package nirmalya.aatithya.restmodule.canteen.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.canteen.dao.AssignDao;
import nirmalya.aatithya.restmodule.canteen.dao.RestMenuDao;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping("canteen/")
public class RestAssignController {

	Logger logger = LoggerFactory.getLogger(RestMenuController.class);

	@Autowired
	AssignDao assignDao;

	@RequestMapping(value = "getAssignCatagory", method = { RequestMethod.GET })
	public List<DropDownModel> getIncentive() {
		logger.info("Method : getIncentive starts");

		logger.info("Method : getIncentive ends");
		return assignDao.getincentive();

	}

	@RequestMapping(value = "getAssignSubCatagiry", method = { RequestMethod.GET })
	public List<DropDownModel> getClubMembers() {
		logger.info("Method : getClubMembers starts");

		logger.info("Method : getClubMembers ends");
		return assignDao.getClubMembers();

	}

	@RequestMapping(value = "getAssignvariants", method = { RequestMethod.GET })
	public List<DropDownModel> getvariants() {
		logger.info("Method : getvariants starts");

		logger.info("Method : getvariants ends");
		return assignDao.getvariants();

	}

	@RequestMapping(value = "getAssigncomboDetails", method = { RequestMethod.GET })
	public List<DropDownModel> getcombo() {
		logger.info("Method : getcombo starts");

		logger.info("Method : getcombo ends");
		return assignDao.getcombo();

	}

	// View
	@RequestMapping(value = "rest-assign-item-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewShoukeenIncentive(String CatId, String SubCatId,
			String variant, String combo) {
		logger.info("Method: restViewCombo View Start");

		logger.info("Method: restViewCombo ends");
		return assignDao.viewAssign(CatId, SubCatId, variant, combo);
	}

	// View
	@RequestMapping(value = "restViewAssignDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewShoukeenIncentive() {
		logger.info("Method: restViewincentivesdetails View Start");

		logger.info("Method: restViewincentivesdetails ends");
		return assignDao.viewShoukeenIncentive();
	}

	// Searching
	@GetMapping(value = "getProductSassign")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> getProductSearchList(@RequestParam String id) {
		logger.info("Method : getProductSearchList starts");

		logger.info("Method :getProductSearchList endss");
		return assignDao.getProductList(id);
	}

	// Searching
	@GetMapping(value = "getComboAssign")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> getComboSearchList(@RequestParam String id) {
		logger.info("Method : getComboSearchList starts");

		logger.info("Method :getComboSearchList endss");
		return assignDao.getComboList(id);
	}
}

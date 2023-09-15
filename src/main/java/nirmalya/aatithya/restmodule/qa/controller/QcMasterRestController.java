package nirmalya.aatithya.restmodule.qa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.QcMasterDao;
import nirmalya.aatithya.restmodule.qa.model.QcMasterRestModel;


@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "production/")
public class QcMasterRestController {
	Logger logger = LoggerFactory.getLogger(QcMasterRestController.class);

	@Autowired
	QcMasterDao qcMasterDao;

	@GetMapping(value = "get-parameter-lists")
	public List<DropDownModel> getparameterLists(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getparameterLists starts");

		logger.info("Method : getparameterLists ends");
		return qcMasterDao.getparameterLists(org, orgDiv);
	}

	@GetMapping(value = "get-itemname-list")
	public List<DropDownModel> getitemnameList(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getitemnameList starts");

		logger.info("Method : getitemnameList ends");
		return qcMasterDao.getitemnameList(org, orgDiv);
	}

	// addQc
	@PostMapping(value = "rest-addQc")
	public ResponseEntity<JsonResponse<List<QcMasterRestModel>>> addQc(

			@RequestBody List<QcMasterRestModel> qcMasterModel) {
		logger.info("Method : restaddQc starts");
		logger.info("Method : restaddQc ends");
		return qcMasterDao.addQc(qcMasterModel);
	}

	// viewQc
	@RequestMapping(value = "rest-viewQc", method = { RequestMethod.GET })
	public JsonResponse<Object> viewQc(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewQc start");

		logger.info("Method :viewQc endss");
		return qcMasterDao.viewQc(orgName, orgDivision);
	}

	// editQc
	@RequestMapping(value = "rest-editQc", method = { RequestMethod.GET })
	public JsonResponse<Object> editQc(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editQc start");

		logger.info("Method :editQc endss");
		return qcMasterDao.editQc(id, orgName, orgDivision);
	}

	// deleteQc
	@RequestMapping(value = "rest-deleteQc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteQc(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteQc starts");

		logger.info("Method : deleteQc ends");
		return qcMasterDao.deleteQc(id, org, div);

	}
	
}

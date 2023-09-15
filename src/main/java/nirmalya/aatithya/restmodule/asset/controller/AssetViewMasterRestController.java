package nirmalya.aatithya.restmodule.asset.controller;

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

import nirmalya.aatithya.restmodule.asset.dao.AssetViewMasterDao;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.employee.dao.TravelRequsitionRestDao;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.qa.dao.QcMasterDao;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetViewMasterRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetViewMasterDao assetViewMasterDao;

 
	@GetMapping(value = "get-parameter-lists")
	public List<DropDownModel> getparameterLists(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getparameterLists starts");

		logger.info("Method : getparameterLists ends");
		return assetViewMasterDao.getparameterLists(org, orgDiv);
	}

	@GetMapping(value = "get-itemname-list")
	public List<DropDownModel> getitemnameList(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getitemnameList starts");

		logger.info("Method : getitemnameList ends");
		return assetViewMasterDao.getitemnameList(org, orgDiv);
	}

	// addQc
	@PostMapping(value = "rest-asset-add")
	public ResponseEntity<JsonResponse<List<AssetViewMasterRestModel>>> addAsset(

			@RequestBody List<AssetViewMasterRestModel> assetMasterModel) {
		logger.info("Method : addAsset starts");
		logger.info("Method : addAsset ends");
		return assetViewMasterDao.addAsset(assetMasterModel);
	}

	// viewQc
	@RequestMapping(value = "rest-view-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAsset(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewAsset start");

		logger.info("Method :viewAsset endss");
		return assetViewMasterDao.viewAsset(orgName, orgDivision);
	}

	// editQc
	@RequestMapping(value = "rest-edit-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> editAsset(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAsset start");

		logger.info("Method :editAsset endss");
		return assetViewMasterDao.editAsset(id, orgName, orgDivision);
	}

	// deleteAsset
	@RequestMapping(value = "rest-delete-asset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAsset(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteAsset starts");

		logger.info("Method : deleteAsset ends");
		return assetViewMasterDao.deleteAsset(id, org, div);

	}
	
	// scrapAsset
	@RequestMapping(value = "rest-asset-code-scrap", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> scarpAsset(@RequestParam String id, String org, String div) {
		logger.info("Method : scarpAsset starts");

		logger.info("Method : scarpAsset ends");
		return assetViewMasterDao.scarpAsset(id, org, div);

	}

	// approveQc
	@RequestMapping(value = "rest-approve-asset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAsset(@RequestParam String id,String QrCode, String org, String orgDiv) {
		logger.info("Method : approveAsset starts");

		logger.info("Method : approveAsset ends");
		return assetViewMasterDao.approveAsset(id,QrCode, org, orgDiv);

	}
	
	//getEmployeeListforAsset
	@RequestMapping(value = "getEmployeeListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeListforAsset(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		logger.info("Method : getEmployeeListforAsset ends");
		return assetViewMasterDao.getEmployeeListforAsset(org,orgDiv,userId);
	}
	
	//getLocationListforAsset
	@RequestMapping(value = "getLocationListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getLocationListforAsset(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getLocationListforAsset starts");

		logger.info("Method : getLocationListforAsset ends");
		return assetViewMasterDao.getLocationListforAsset(org,orgDiv,userId);
	}
	// assignAsset
	@RequestMapping(value = "rest-asset-master-code-assign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> assignAsset(@RequestParam String id,String assetcat,String assetemp,String assigndate, String org, String orgDiv) {
		logger.info("Method : assignAsset starts");

		logger.info("Method : assignAsset ends");
		return assetViewMasterDao.assignAsset(id,assetcat,assetemp,assigndate, org, orgDiv);

	}
	
	// assetHistory
	@RequestMapping(value = "rest-asset-master-history", method = { RequestMethod.GET })
	public JsonResponse<Object> historyAsset(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :historyAsset start");

		logger.info("Method :historyAsset endss");
		return assetViewMasterDao.historyAsset(id, orgName, orgDivision);
	}


}

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

import nirmalya.aatithya.restmodule.asset.dao.AssetPolicyDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetViewMasterDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
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
public class AssetPolicyRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetPolicyDao assetPolicyDao;

	
	
	  //getEmployeeListforAsset
	  
	  @RequestMapping(value = "getCategoryListforAsset", method = {
	  RequestMethod.GET }) public List<DropDownModel>
	  getCategoryListforAsset(@RequestParam String org,String orgDiv,String userId)
	  { logger.info("Method : getCategoryListforAsset starts");
	  
	  logger.info("Method : getCategoryListforAsset ends"); return
	  assetPolicyDao.getCategoryListforAsset(org,orgDiv,userId); }
	  
	  //getEmployeeListforAsset
	  
	  @RequestMapping(value = "getPriorityListforAsset", method = {
	  RequestMethod.GET }) public List<DropDownModel> getPriorityList(@RequestParam
	  String org,String orgDiv,String userId) {
	  logger.info("Method : getPriorityList starts");
	  
	  logger.info("Method : getPriorityList ends"); return
	  assetPolicyDao.getPriorityList(org,orgDiv,userId); }
	 
	// getSubCategory
	@RequestMapping(value = "rest-asset-policy-subcategory", method = { RequestMethod.GET })
	public JsonResponse<Object> getSubCategory(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getSubCategory start");

		logger.info("Method :getSubCategory endss");
		return assetPolicyDao.getSubCategory(id, orgName, orgDivision);
	}
	
	// addAssetPolicy
	@PostMapping(value = "rest-asset-policy-add")
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addAssetPolicy(

			@RequestBody List<AssetPoilcyRestModel> assetPolicyModel) {
		logger.info("Method : addAssetPolicy starts");
		logger.info("Method : addAssetPolicy ends");
		return assetPolicyDao.addAssetPolicy(assetPolicyModel);
	}
	
	// viewAssetPolicy
	@RequestMapping(value = "rest-asset-policy-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetPolicy(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewAssetPolicy start");

		logger.info("Method :viewAssetPolicy endss");
		return assetPolicyDao.viewAssetPolicy(orgName, orgDivision);
	}
	
	// editPolicy
	@RequestMapping(value = "rest-asset-policy-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editAssetPolicy(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAssetPolicy start");

		logger.info("Method :editAssetPolicy endss");
		return assetPolicyDao.editAssetPolicy(id, orgName, orgDivision);
	}
	
	// deleteQc
	@RequestMapping(value = "rest-asset-policy-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssetPolicy(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteAssetPolicy starts");

		logger.info("Method : deleteAssetPolicy ends");
		return assetPolicyDao.deleteAssetPolicy(id, org, div);

	}

	// approveQc
	@RequestMapping(value = "rest-asset-policy-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAssetPolicy(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveAssetPolicy starts");

		logger.info("Method : approveAssetPolicy ends");
		return assetPolicyDao.approveAssetPolicy(id, org, orgDiv);

	}




}

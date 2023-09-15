package nirmalya.aatithya.restmodule.maintenance.controller;

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

import nirmalya.aatithya.restmodule.maintenance.dao.AssetMaintenanceDao;
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
@RequestMapping(value = { "maintenance/" })
public class AssetMaintenanceRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetMaintenanceDao assetMaintenanceDao;

 
	//getLocationListforAsset
	
	  @RequestMapping(value = "getThirdPartyList", method = {
	  RequestMethod.GET }) public List<DropDownModel>
	  getThirdPartyList(@RequestParam String org,String orgDiv,String userId)
	  { logger.info("Method : getThirdPartyList starts");
	  
	  logger.info("Method : getThirdPartyList ends"); return
	  assetMaintenanceDao.getThirdPartyList(org,orgDiv,userId); }
	 
	// viewQc
	@RequestMapping(value = "rest-asset-maintenance-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetMaintenance(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewAssetMaintenance start");

		logger.info("Method :viewAssetMaintenance endss");
		return assetMaintenanceDao.viewAssetMaintenance(orgName, orgDivision);
	}
	// assignAsset
	@RequestMapping(value = "rest-asset-maintenance-allocate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> allocatePolicy(@RequestParam String assetid,String policyid,String assetcat,String assetemp,String assigndate,String frequency, String org, String orgDiv) {
		logger.info("Method : allocatePolicy starts");

		logger.info("Method : allocatePolicy ends");
		return assetMaintenanceDao.allocatePolicy(assetid,policyid,assetcat,assetemp,assigndate,frequency, org, orgDiv);

	}
	//getEmployeeListforAsset
	@RequestMapping(value = "getCategoryListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getCategoryListforAsset(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getCategoryListforAsset starts");

		logger.info("Method : getCategoryListforAsset ends");
		return assetMaintenanceDao.getCategoryListforAsset(org,orgDiv,userId);
	}
	
	//getEmployeeListforAsset
	@RequestMapping(value = "getPriorityListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getPriorityList(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getPriorityList starts");

		logger.info("Method : getPriorityList ends");
		return assetMaintenanceDao.getPriorityList(org,orgDiv,userId);
	}
	
	// editQc
	@RequestMapping(value = "rest-maintenance-emergencylist", method = { RequestMethod.GET })
	public JsonResponse<Object> getEmgList(@RequestParam String type,String cat,String subcat, String orgName, String orgDivision) {
		logger.info("Method :getEmgList start");

		logger.info("Method :getEmgList endss");
		return assetMaintenanceDao.getEmgList(type,cat,subcat,orgName, orgDivision);
	}

	// deleteAsset
	@RequestMapping(value = "rest-asset-maintenance-deallocate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePolicyAlloc(@RequestParam String id, String org, String div) {
		logger.info("Method : deletePolicyAlloc starts");

		logger.info("Method : deletePolicyAlloc ends");
		return assetMaintenanceDao.deletePolicyAlloc(id, org, div);

	}
	



}

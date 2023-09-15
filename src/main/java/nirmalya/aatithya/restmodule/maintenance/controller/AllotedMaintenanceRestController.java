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

import nirmalya.aatithya.restmodule.maintenance.dao.AllotedMaintenanceDao;
import nirmalya.aatithya.restmodule.maintenance.dao.AssetMaintenanceDao;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;
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
@RequestMapping(value = { "maintenance/" })
public class AllotedMaintenanceRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AllotedMaintenanceDao allotedMaintenanceDao;

 
	 

	@RequestMapping(value = "rest-alloted-maintenance-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetMaintenance(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewAssetMaintenance start");

		logger.info("Method :viewAssetMaintenance endss");
		return allotedMaintenanceDao.viewAssetMaintenance(orgName, orgDivision);
	}

	
	
	@PostMapping(value = "rest-asset-maintenance-progress")
	public ResponseEntity<JsonResponse<List<AllotedMaintenanceRestModel>>> addPolicyProgress(

			@RequestBody List<AllotedMaintenanceRestModel> allotedModel) {
		logger.info("Method : addPolicyProgress starts");
		logger.info("Method : addPolicyProgress ends");
		return allotedMaintenanceDao.addPolicyProgress(allotedModel);
	}



	
	  @RequestMapping(value = "rest-asset-maintenance-policylist", method = {
	  RequestMethod.GET }) public JsonResponse<Object> getPolList(@RequestParam
	  String aid,String pid, String orgName, String orgDivision) {
	  logger.info("Method :getPolList start");
	  
	  logger.info("Method :getPolList endss"); return
	  allotedMaintenanceDao.getPolList(aid,pid,orgName,orgDivision); }
	  
	 
}

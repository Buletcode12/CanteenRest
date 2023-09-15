package nirmalya.aatithya.restmodule.employee.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.TravelRequsitionRestDao;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;

@RestController
@RequestMapping(value = { "employee/" })
public class TravelRequisitionRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	TravelRequsitionRestDao travelRequsitionRestDao;
 
	@PostMapping(value = "travel-requisition-employee")
	public JsonResponse<List<TravelRequisitionRestModel>> viewTravelRequisition(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewTravelRequisition starts");

		String userId = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();

		String userRole = "";
		if (roleList.size() > 0) {
			for (String m : roleList) {
				if (empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole + "\"" + m + "\",";
				}
			}
		}

		if (userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}

		logger.info("User Id = " + userId + " *** userRole=====" + userRole);
		logger.info("Method : viewTravelRequisition ends");
		return travelRequsitionRestDao.viewTravelRequisition(userId, userRole,organization,orgDivision);
	}

	// add travel
	@PostMapping(value = "rest-add-travel")
	public ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> restAddTravel(
			@RequestBody List<TravelRequisitionRestModel> travelModel) {
		logger.info("Method : restAddTravel starts");
		logger.info("Method : restAddTravel ends");
		return travelRequsitionRestDao.addTravel(travelModel);
	}

	@GetMapping(value = "get-travel-edit")
	public ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> travelEdit(@RequestParam String id) {
		logger.info("Method : travelEdit starts");
		logger.info("Method : travelEdit endss");
		return travelRequsitionRestDao.getTravelEdit(id);
	}
	

	// delete travel

	@PostMapping(value = "rest-delete-travel")
	public ResponseEntity<JsonResponse<Object>> restDeleteTravel(

			@RequestBody TravelRequisitionRestModel travelModel) {
		logger.info("Method : restDeleteTravel starts");
		logger.info("Method : restDeleteTravel ends");
		return travelRequsitionRestDao.deleteTravel(travelModel);
	}

	// approve Requisition

	@GetMapping(value = "approveRequisition")
	public JsonResponse<TravelRequisitionRestModel> approveRequisition(@RequestParam String id, String name,
			String comment, @RequestParam String roleid) {
		logger.info("Method : approveRequisition starts");

		logger.info("Method : approveRequisition ends");
		return travelRequsitionRestDao.approveRequisition(id, name, comment, roleid);
	}
	//approve Travel details api
	@PostMapping(value="approveRequisition-api")
	public JsonResponse<TravelRequisitionRestModel> approveRequisitionApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : approveRequisitionApi starts");
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		logger.info("User Id = "+id+ " *** userRole====="+userRole);
		logger.info("Method : approveRequisitionApi ends");
		return travelRequsitionRestDao.approveRequisition(id, name, comment, userRole);
	}
	// rejectRequisition

	@GetMapping(value = "rejectRequisition")
	public JsonResponse<TravelRequisitionRestModel> rejectRequisition(@RequestParam String id, String name,
			String comment, @RequestParam String roleid) {
		logger.info("Method : rejectRequisition starts");

		logger.info("Method : rejectRequisition ends");
		return travelRequsitionRestDao.rejectRequisition(id, name, comment, roleid);
	}
	//reject Travel details api
	@PostMapping(value="rejectRequisition-api")
	public JsonResponse<TravelRequisitionRestModel> rejectRequisitionApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : rejectRequisitionApi starts");
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		logger.info("User Id = "+id+ " *** userRole====="+userRole);
		logger.info("Method : rejectRequisitionApi ends");
		return travelRequsitionRestDao.rejectRequisition(id, name, comment, userRole);
	}
	//travel requisition api
	@GetMapping(value = "travel-requisition-employee-api")
	public JsonResponse<List<TravelRequisitionRestModel>> viewTravelRequisitionApi(@RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewTravelRequisitionApi starts");
 
		logger.info("Method : viewTravelRequisitionApi ends");
		return travelRequsitionRestDao.viewTravelRequisitionApi(userId,organization,orgDivision);
	}
}
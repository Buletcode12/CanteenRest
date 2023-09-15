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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.ExtendExitManagementRestDao;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;

@RestController
@RequestMapping("employee/")
public class ExtendExitManagementRestController {

	Logger logger = LoggerFactory.getLogger(ExtendExitManagementRestController.class);

	@Autowired
	ExtendExitManagementRestDao exitManagementDao;

	// Name list

	@RequestMapping(value = "getNamelist", method = { RequestMethod.GET })
	public List<DropDownModel> namelist() {
		logger.info("Method : namelist starts");

		logger.info("Method : namelist ends");
		return exitManagementDao.namelist();
	}

	// Department list(Clearance)

	@RequestMapping(value = "getDeptlist", method = { RequestMethod.GET })
	public List<DropDownModel> departmentList() {
		logger.info("Method : departmentList starts");

		logger.info("Method : departmentList ends");
		return exitManagementDao.deptList();
	}

	// "Clearance By" List

	@RequestMapping(value = "getClrncPersonList", method = { RequestMethod.GET })
	public List<DropDownModel> clrncPersonList() {
		logger.info("Method : clrncPersonList starts");

		logger.info("Method : clrncPersonList ends");
		return exitManagementDao.clrncPersonList();
	}

	// job

	@GetMapping(value = "rest-get-designationList")
	public JsonResponse<List<DropDownModel>> getDesignationList(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");

		logger.info("Method : getDesignationList ends");
		return exitManagementDao.getDesignationList(id);
	}

	/*
	 * View Exit Management
	 * 
	 */
	@GetMapping(value = "viewExitdetails")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewExtendExitManagementDtls(@RequestParam String userId,String userRole,String organization,String orgDivision) {
		logger.info("Method : viewExtendExitManagementDtls starts");

		logger.info("Method : viewExtendExitManagementDtls ends");

		return exitManagementDao.viewExtendExitManagementDtls(userId,userRole,organization,orgDivision);
	}
	
	/*
	 *
	 * Edit Exit details
	 *
	 */
	@RequestMapping(value = "editExitManagement", method = { RequestMethod.GET })
	public JsonResponse<ExtendExitManagementRestModel> editManagementDetails(@RequestParam String id,String organization,String orgDivision) {
		logger.info("Method : editManagementDetails starts");

		logger.info("Method :editManagementDetails ends");
		return exitManagementDao.editManagementDetails(id,organization,orgDivision);
	}
	/*
	 * Add Exit Management
	 * 
	 */

	@PostMapping(value = "addExitdetails")
	public JsonResponse<Object> addExitManagement(@RequestBody ExtendExitManagementRestModel exit) {
		logger.info("Method : addExitManagement starts");

		logger.info("Method : addExitManagement ends");
		return exitManagementDao.addExitManagement(exit);
	}

	/*
	 * Add Initiate & Clearance Details
	 * 
	 */
	@PostMapping(value = "addinitiatedata")

	public JsonResponse<Object> addClearanceDetails(@RequestBody ExtendExitManagementRestModel exit) {
		logger.info("Method : addClearanceDetails starts");

		logger.info("Method : addClearanceDetails ends");
		return exitManagementDao.addClearanceDetailsDao(exit);
	}
 
 
	/*
	 *
	 * Delete Student details
	 *
	 */
	@GetMapping(value = "exitManagementdelete")
	public JsonResponse<ExtendExitManagementRestModel> deleteExitDetails(@RequestParam String id) {
		logger.info("Method : deleteExitDetails starts");

		logger.info("Method :deleteExitDetails ends");
		return exitManagementDao.deleteExitDetails(id);
	}
	/*
	 * Add Finance Details
	 * 
	 */

	@PostMapping(value = "addFinancedetails")
	public JsonResponse<Object> addFinanceDetails(@RequestBody ExtendExitManagementRestModel exit) {
		logger.info("Method : addFinanceDetails starts");

		logger.info("Method : addFinanceDetails ends");
		return exitManagementDao.addFinanceDetails(exit);
	}

	@GetMapping(value = "get-deptClearanceDetails")
	public JsonResponse<List<DropDownModel>> viewdeptClearanceDetails(@RequestParam String userid) {
		logger.info("Method : viewdeptClearanceDetails starts");

		logger.info("Method : viewdeptClearanceDetails ends");
		return exitManagementDao.viewdeptClearanceDetails(userid);
	}
	/*
	 * view Exit Clearance
	 * 
	 */
	@GetMapping(value = "viewExitClearance")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewExitClearance(@RequestParam String userId,String exitid,String organization,String orgDivision) {
		logger.info("Method : viewExitClearance starts");

		logger.info("Method : viewExitClearance ends");

		return exitManagementDao.viewExitClearance(userId,exitid,organization,orgDivision);
	}
	/*
	 *
	 * Edit Exit Clearance
	 *
	 */
	@RequestMapping(value = "editClearance", method = { RequestMethod.GET })
	public JsonResponse<ExtendExitManagementRestModel> editClearance(@RequestParam String id,String organization,String orgDivision) {
		logger.info("Method : editClearance starts");

		logger.info("Method :editClearance ends");
		return exitManagementDao.editClearance(id,organization,orgDivision);
	}
}
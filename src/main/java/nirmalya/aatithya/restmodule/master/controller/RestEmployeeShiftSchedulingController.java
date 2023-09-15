package nirmalya.aatithya.restmodule.master.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestEmployeeShiftSchedulingDao;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeShiftSchedulingModel;

@RestController
@RequestMapping(value = { "master/" })
public class RestEmployeeShiftSchedulingController {

	Logger logger = LoggerFactory.getLogger(RestEmployeeShiftSchedulingController.class);

	@Autowired
	RestEmployeeShiftSchedulingDao restEmployeeWeekOffDao;

	/*
	 * 
	 * Get mapping for department
	 */

	@GetMapping(value = "get-departmentListt")
	public List<DropDownModel> getDepartment(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getDepartment starts");
		logger.info("Method : getDepartment endss");
		return restEmployeeWeekOffDao.getDepartmentList(organization,orgDivision);
	}
 
	@GetMapping(value = "getShiftLists")
	public JsonResponse<List<DropDownModel>> getShiftLists(@RequestParam String userId,String organization,String orgDivision,String deptId,String subDeptId) {
		logger.info("Method : getShiftLists starts");

		logger.info("Method : getShiftLists ends");
		return restEmployeeWeekOffDao.getShiftLists(userId,organization,orgDivision,deptId,subDeptId);
	}
	
	@GetMapping(value = "get-nameandDeptList")
	public JsonResponse<List<DropDownModel>> getdeptidList(@RequestParam String id,String organization,String orgDivision) {
		logger.info("Method : getdeptidList starts");

		logger.info("Method : getngetdeptidListameAndDesignationList ends");
		return restEmployeeWeekOffDao.getdeptidList(id,organization,orgDivision);
	}
	// assign shift details
	
	@PostMapping(value = "rest-assignShiftDetails")
	public JsonResponse<List<RestEmployeeShiftSchedulingModel>> assignShiftDetails(
			@RequestBody List<RestEmployeeShiftSchedulingModel> assignshiftModel) {
		logger.info("Method : assignShiftDetails starts");

		logger.info("Method : assignShiftDetails ends");
		return restEmployeeWeekOffDao.assignShiftDetails(assignshiftModel);
	}
	
	@GetMapping(value = "rest-viewEmployeeShiftDetails")
	public JsonResponse<List<RestEmployeeShiftSchedulingModel>> viewEmployeeShiftDetails(@RequestParam String fromDate,String toDate,String userId,String dept,String subDept,String organization,String orgDivision) {
		logger.info("Method :viewEmployeeShiftDetails starts");
		
		logger.info("Method :viewEmployeeShiftDetails endss");
		return restEmployeeWeekOffDao.viewEmployeeShiftDetails(fromDate,toDate,userId,dept,subDept,organization,orgDivision);
	}
	/*
	 * auto search 
	 */
	@GetMapping(value = "getEmpShiftAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpShiftAutoSearchList(
			@RequestParam String id,String dept,String subDept,String organization,String orgDivision) {
		logger.info("Method : getEmpShiftAutoSearchList starts");

		logger.info("Method :getEmpShiftAutoSearchList endss");
		return restEmployeeWeekOffDao.getEmpShiftAutoSearchList(id,dept,subDept,organization,orgDivision);
	}
	
}

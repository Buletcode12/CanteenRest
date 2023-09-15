package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;
import nirmalya.aatithya.restmodule.master.dao.RestEmployeeReportDao;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeReportsModel;

@RestController
@RequestMapping("master/")
public class RestEmployeeReportController {
	Logger logger = LoggerFactory.getLogger(RestEmployeeReportController.class);

	@Autowired
	RestEmployeeReportDao restEmployeeReportDao;
	
	// view
	@GetMapping(value = "rest-viewEmployeeReport")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeReportDetails(@RequestParam String userId,String organization,String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewEmployeeReportDetails starts");

		logger.info("Method : viewEmployeeReportDetails ends");

		return restEmployeeReportDao.viewEmployeeReportDetails(userId,organization,orgDivision,fromDate,toDate);
	}
	
	// view attendance
	@GetMapping(value = "rest-viewEmployeeAttendanceReports")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeAttendanceReports(@RequestParam String userId,String organization,String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewEmployeeAttendanceReports starts");

		logger.info("Method : viewEmployeeAttendanceReports ends");

		return restEmployeeReportDao.viewEmployeeAttendanceReports(userId,organization,orgDivision,fromDate,toDate);
	}
	
	@GetMapping(value = "rest-viewEmployeeovertime")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeovertime(@RequestParam String userId,String organization,String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewEmployeeovertime starts");

		logger.info("Method : viewEmployeeovertime ends");

		return restEmployeeReportDao.viewEmployeeovertime(userId,organization,orgDivision,fromDate,toDate);
	}
	
	// view attendance
	@GetMapping(value = "rest-viewEmployeeBiometricAttendanceReports")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeBiometricAttendanceReports(@RequestParam String userId,String organization,String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewEmployeeBiometricAttendanceReports starts");
		
		logger.info("Method : viewEmployeeBiometricAttendanceReports ends");
		
		return restEmployeeReportDao.viewEmployeeBiometricAttendanceReports(userId,organization,orgDivision,fromDate,toDate);
	}
	// view Resignation
	@GetMapping(value = "rest-viewEmployeeResignationReports")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeResignationReports(@RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewEmployeeResignationReports starts");
		
		logger.info("Method : viewEmployeeResignationReports ends");
		
		return restEmployeeReportDao.viewEmployeeResignationReports(userId,organization,orgDivision);
	}
	// view attendance dept wise
	@GetMapping(value = "rest-empAttendanceDetailsDepartmentWise")
	public JsonResponse<List<RestEmployeeReportsModel>> empAttendanceDetailsDepartmentWise(@RequestParam String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		logger.info("Method : empAttendanceDetailsDepartmentWise starts");

		logger.info("Method : empAttendanceDetailsDepartmentWise ends");

		return restEmployeeReportDao.empAttendanceDetailsDepartmentWise(dept,subDept,fromDate,toDate,organization,orgDivision);
	}
	// view bioattendance dept wise
	@GetMapping(value = "rest-empBioAttendanceDetailsDepartmentWise")
	public JsonResponse<List<RestEmployeeReportsModel>> empBioAttendanceDetailsDepartmentWise(@RequestParam String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		logger.info("Method : empBioAttendanceDetailsDepartmentWise starts");
		
		logger.info("Method : empBioAttendanceDetailsDepartmentWise ends");
		
		return restEmployeeReportDao.empBioAttendanceDetailsDepartmentWise(dept,subDept,fromDate,toDate,organization,orgDivision);
	}
	// view employee Details department wise
	@GetMapping(value = "rest-empDetailsDepartmentWise")
	public JsonResponse<List<RestEmployeeReportsModel>> empDetailsDepartmentWise(@RequestParam String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		logger.info("Method : empDetailsDepartmentWise starts");
		
		logger.info("Method : empDetailsDepartmentWise ends");
		
		return restEmployeeReportDao.empDetailsDepartmentWise(dept,subDept,fromDate,toDate,organization,orgDivision);
	}
	// view attendance Status
	@GetMapping(value = "rest-empAttendanceDetailsStatusWise")
	public JsonResponse<List<RestEmployeeReportsModel>> empAttendanceDetailsStatusWise(@RequestParam String dept,String subDept,String attndate,String organization,String orgDivision,String status) {
		logger.info("Method : empAttendanceDetailsStatusWise starts");
		
		logger.info("Method : empAttendanceDetailsStatusWise ends");
		
		return restEmployeeReportDao.empAttendanceDetailsStatusWise(dept,subDept,attndate,organization,orgDivision,status);
	}
	// view Bio attendance Status
	@GetMapping(value = "rest-empBioAttendanceDetailsStatusWise")
	public JsonResponse<List<RestEmployeeReportsModel>> empBioAttendanceDetailsStatusWise(@RequestParam String dept,String subDept,String attndate,String organization,String orgDivision,String status) {
		logger.info("Method : empBioAttendanceDetailsStatusWise starts");
		
		logger.info("Method : empBioAttendanceDetailsStatusWise ends");
		
		return restEmployeeReportDao.empBioAttendanceDetailsStatusWise(dept,subDept,attndate,organization,orgDivision,status);
	}
	
	/*
	 * View Exit Management Report
	 * 
	 */
	@GetMapping(value = "viewExitdetails-report")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewExtendExitManagementDtlsReport(@RequestParam String userId,String userRole,String organization,String orgDivision) {
		logger.info("Method : viewExtendExitManagementDtlsReport starts");

		logger.info("Method : viewExtendExitManagementDtlsReport ends");

		return restEmployeeReportDao.viewExtendExitManagementDtlsReport(userId,userRole,organization,orgDivision);
	}
	
	//view overtime details dept wise
	@GetMapping(value = "rest-overtimeattendance")
	public JsonResponse<List<RestEmployeeReportsModel>> overtimeAttendanceReportDeptype(@RequestParam String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		logger.info("Method : overtimeAttendanceReportDeptype starts");

		logger.info("Method : overtimeAttendanceReportDeptype ends");

		return restEmployeeReportDao.overtimeAttendanceReportDeptype(dept,subDept,fromDate,toDate,organization,orgDivision);
	}
	
	@GetMapping(value = "rest-overtimestatuswise")
	public JsonResponse<List<RestEmployeeReportsModel>> overtimeDetailsStatuswise(@RequestParam String dept,String subDept,String attndate,String organization,String orgDivision,String status) {
		logger.info("Method : overtimeDetailsStatuswise starts");
		
		logger.info("Method : overtimeDetailsStatuswise ends");
		
		return restEmployeeReportDao.overtimeDetailsStatuswise(dept,subDept,attndate,organization,orgDivision,status);
	}
}

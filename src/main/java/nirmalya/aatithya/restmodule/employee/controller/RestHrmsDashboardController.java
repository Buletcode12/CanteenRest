package nirmalya.aatithya.restmodule.employee.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.RestHrmsDashboardDao;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsDashboardModel;

@RestController
@RequestMapping("employee/")
public class RestHrmsDashboardController {
	Logger logger = LoggerFactory.getLogger(RestHrmsDashboardController.class);

	@Autowired
	RestHrmsDashboardDao restHrmsDashboardDao;

	// Total Monthly Attendance
	@GetMapping(value = "rest-getTotalMonthlyAttendance")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyAttendance(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getTotalMonthlyAttendance starts");

		logger.info("Method :getTotalMonthlyAttendance ends");
		return restHrmsDashboardDao.getTotalMonthlyAttendance(userId, orgName, orgDiv, currentYear);
	}

	// totalMonthlyAttendance Aggrid
	@GetMapping(value = "rest-getTotalMonthlyAttendanceAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyAttendanceAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear, @RequestParam("month") String month) {

		logger.info("Method : getTotalMonthlyAttendanceAggrid starts");

		logger.info("Method :getTotalMonthlyAttendanceAggrid ends");
		return restHrmsDashboardDao.getTotalMonthlyAttendanceAggrid(userId, value1, orgName, orgDiv, currentYear,
				month);
	}

	// Total Monthly Reimbursement
	@GetMapping(value = "rest-getTotalMonthlyReimbursement")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyReimbursement(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getTotalMonthlyReimbursement starts");

		logger.info("Method :getTotalMonthlyReimbursement ends");
		return restHrmsDashboardDao.getTotalMonthlyReimbursement(userId, orgName, orgDiv, currentYear);
	}

	// Total Monthly Reimbursement Aggrid
	@GetMapping(value = "rest-getTotalMonthlyReimbursementAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyReimbursementAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear, @RequestParam("month") String month) {

		logger.info("Method : getTotalMonthlyReimbursementAggrid starts");

		logger.info("Method :getTotalMonthlyReimbursementAggrid ends");
		return restHrmsDashboardDao.getTotalMonthlyReimbursementAggrid(userId, value1, orgName, orgDiv, currentYear,
				month);
	}

	// Total Leave

	@GetMapping(value = "rest-getTotalLeave")
	public JsonResponse<List<DropDownModel>> getTotalLeave(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getTotalLeave starts");

		logger.info("Method :getTotalLeave ends");
		return restHrmsDashboardDao.getTotalLeave(userId, orgName, orgDiv, currentYear);
	}

	// Leave Aggrid
	@GetMapping(value = "rest-getTotalLeaveAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalLeaveAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear) {

		logger.info("Method : getTotalLeaveAggrid starts");

		logger.info("Method :getTotalLeaveAggrid ends");
		return restHrmsDashboardDao.getTotalLeaveAggrid(userId, value1, orgName, orgDiv, currentYear);
	}
	// Total Monthly Event

	@GetMapping(value = "rest-getTotalMonthlyEvent")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyEvent(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getTotalMonthlyEvent starts");

		logger.info("Method :getTotalMonthlyEvent ends");
		return restHrmsDashboardDao.getTotalMonthlyEvent(userId, orgName, orgDiv, currentYear);
	}

	// Total Monthly Event Aggrid
	@GetMapping(value = "rest-getTotalMonthlyEventAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyEventAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear,
			@RequestParam("month") String month) {

		logger.info("Method : getTotalMonthlyEventAggrid starts");

		logger.info("Method :getTotalMonthlyEventAggrid ends");
		return restHrmsDashboardDao.getTotalMonthlyEventAggrid(userId, value1, orgName, orgDiv, currentYear, month);
	}

	// Total Count Details
	@GetMapping(value = "rest-getCountDetails")
	public JsonResponse<List<RestHrmsDashboardModel>> getCountDetails(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getCountDetails starts");

		logger.info("Method :getCountDetails ends");
		return restHrmsDashboardDao.getCountDetails(userId, orgName, orgDiv, currentYear);
	}

	// Total Manager Count Details
	@GetMapping(value = "rest-getManagerCountDetails")
	public JsonResponse<List<RestHrmsDashboardModel>> getManagerCountDetails(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getManagerCountDetails starts");

		logger.info("Method :getManagerCountDetails ends");
		return restHrmsDashboardDao.getManagerCountDetails(userId, orgName, orgDiv, currentYear);
	}

	/// Leave Approve
	@GetMapping(value = "rest-getLeaveApprove")
	public JsonResponse<List<DropDownModel>> getLeaveApprove(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method : getLeaveApprove starts");

		logger.info("Method :getLeaveApprove ends");
		return restHrmsDashboardDao.getLeaveApprove(userId, orgName, orgDiv, fromdate, todate);
	}

	// Leave Approve Aggrid
	@GetMapping(value = "rest-getLeaveApprovedAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getLeaveApprovedAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam String fromdate, @RequestParam String todate) {

		logger.info("Method : getLeaveApprovedAggrid starts");

		logger.info("Method :getLeaveApprovedAggrid ends");
		return restHrmsDashboardDao.getLeaveApprovedAggrid(userId, value1, orgName, orgDiv, fromdate, todate);
	}

	// Total Reimbursement Approved
	@GetMapping(value = "rest-getReimbursementApproved")
	public JsonResponse<List<DropDownModel>> getReimbursementApproved(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method : getReimbursementApproved starts");

		logger.info("Method :getReimbursementApproved ends");
		return restHrmsDashboardDao.getReimbursementApproved(userId, orgName, orgDiv, fromdate, todate);
	}

	// Total Reimbursement Approved Aggrid
	@GetMapping(value = "rest-getReimbursementApprovedAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getReimbursementApprovedAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("month") String month,@RequestParam String fromdate, @RequestParam String todate) {

		logger.info("Method : getReimbursementApprovedAggrid starts");

		logger.info("Method :getReimbursementApprovedAggrid ends");
		return restHrmsDashboardDao.getReimbursementApprovedAggrid(userId, value1, orgName, orgDiv, month,fromdate, todate);
	}

	// PayRoll Process
	@GetMapping(value = "rest-getPayrollProcess")
	public JsonResponse<List<RestHrmsDashboardModel>> getPayrollProcess(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method : getPayrollProcess starts");

		logger.info("Method :getPayrollProcess ends");
		return restHrmsDashboardDao.getPayrollProcess(userId, orgName, orgDiv, fromdate, todate);
	}

	// PayRoll Process Aggrid

	@GetMapping(value = "rest-getPayrollProcessAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getPayrollProcessAggrid(@RequestParam("userId") String userId,
			@RequestParam("value") String value, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam String fromdate, @RequestParam String todate) {

		logger.info("Method : getPayrollProcessAggrid starts");

		logger.info("Method :getPayrollProcessAggrid ends");
		return restHrmsDashboardDao.getPayrollProcessAggrid(userId, value, orgName, orgDiv, fromdate, todate);
	}
	// RatingWise Appresal

	@GetMapping(value = "rest-getRatingWise")
	public JsonResponse<List<DropDownModel>> getRatingWise(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getRatingWise starts");

		logger.info("Method :getRatingWise ends");
		return restHrmsDashboardDao.getRatingWise(userId, orgName, orgDiv, currentYear);
	}

	// RatingWise Appresal aggrid
	@GetMapping(value = "rest-getRatingWiseAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getRatingWiseAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear) {

		logger.info("Method : getRatingWiseAggrid starts");

		logger.info("Method :getRatingWiseAggrid ends");
		return restHrmsDashboardDao.getRatingWiseAggrid(userId, value1, orgName, orgDiv, currentYear);
	}

	// Total HR Count Details
	@GetMapping(value = "rest-getHrCountDetails")
	public JsonResponse<List<RestHrmsDashboardModel>> getHrCountDetails(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getHrCountDetails starts");

		logger.info("Method :getHrCountDetails ends");
		return restHrmsDashboardDao.getHrCountDetails(userId, orgName, orgDiv, currentYear);
	}

	// Designation By Requisition
	@GetMapping(value = "rest-getDesignationByRequisition")
	public JsonResponse<List<RestHrmsDashboardModel>> getDesignationByRequisition(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getDesignationByRequisition starts");

		logger.info("Method :getDesignationByRequisition ends");
		return restHrmsDashboardDao.getDesignationByRequisition(userId, orgName, orgDiv, currentYear);
	}

	// Designation By Requisition Aggrid
	@GetMapping(value = "rest-getDesignationByRequisitionAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getDesignationByRequisitionAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear, @RequestParam("value") String value) {

		logger.info("Method : getDesignationByRequisitionAggrid starts");

		logger.info("Method :getDesignationByRequisitionAggrid ends");
		return restHrmsDashboardDao.getDesignationByRequisitionAggrid(userId, value1, orgName, orgDiv, currentYear,
				value);
	}

	// Requisition status
	@GetMapping(value = "rest-getRequisitionStatus")
	public JsonResponse<List<RestHrmsDashboardModel>> getRequisitionStatus(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getRequisitionStatus starts");

		logger.info("Method :getRequisitionStatus ends");
		return restHrmsDashboardDao.getRequisitionStatus(userId, orgName, orgDiv, currentYear);
	}

	// Requisition Status Aggrid
	@GetMapping(value = "rest-getRequisitionStatusAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getRequisitionStatusAggrid(@RequestParam("userId") String userId,
			@RequestParam("value") String value, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear) {

		logger.info("Method : getRequisitionStatusAggrid starts");

		logger.info("Method :getRequisitionStatusAggrid ends");
		return restHrmsDashboardDao.getRequisitionStatusAggrid(userId, value, orgName, orgDiv, currentYear);
	}

	//// Gender Wise Candidate/Employee
	@GetMapping(value = "rest-getGendereWiseCandidate")
	public JsonResponse<List<DropDownModel>> getGendereWiseCandidate(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getGendereWiseCandidate starts");

		logger.info("Method :getGendereWiseCandidate ends");
		return restHrmsDashboardDao.getGendereWiseCandidate(userId, orgName, orgDiv, currentYear);
	}

	// Gender Wise Candidate/Employee Aggrid
	@GetMapping(value = "rest-getGendereWiseCandidateAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getGendereWiseCandidateAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {

		logger.info("Method : getGendereWiseCandidateAggrid starts");

		logger.info("Method :getGendereWiseCandidateAggrid ends");
		return restHrmsDashboardDao.getGendereWiseCandidateAggrid(userId, value1, orgName, orgDiv, currentYear);
	}

	// Yearly Event
	@GetMapping(value = "rest-getYearlyEvent")
	public JsonResponse<List<DropDownModel>> getYearlyEvent(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getYearlyEvent starts");

		logger.info("Method :getYearlyEvent ends");
		return restHrmsDashboardDao.getYearlyEvent(userId, orgName, orgDiv, currentYear);
	}

	// Yearly Event Aggrid
	@GetMapping(value = "rest-getYearlyEventAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getYearlyEventAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear,
			@RequestParam("month") String month) {

		logger.info("Method : getYearlyEventAggrid starts");

		logger.info("Method :getYearlyEventAggrid ends");
		return restHrmsDashboardDao.getYearlyEventAggrid(userId, value1, orgName, orgDiv, currentYear, month);
	}

	@RequestMapping(value = "dashboard-yearlyselection", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrmsDashboardModel>>> viewYearSelectionData(
			@RequestParam String currentYear, @RequestParam String orgname, @RequestParam String orgdiv) {
		logger.info("Method : viewYearSelectionData starts" + currentYear);

		logger.info("Method : viewYearSelectionData ends");
		return restHrmsDashboardDao.viewYearSelectionData(currentYear, orgname, orgdiv);
	}

	/// getAttendanceReports
	@GetMapping(value = "rest-getAttendanceReports")
	public JsonResponse<List<DropDownModel>> getAttendanceReports(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method : getAttendanceReports starts" + fromdate);
		logger.info("Method : getAttendanceReports starts" + todate);

		logger.info("Method :getAttendanceReports ends");
		return restHrmsDashboardDao.getAttendanceReports(userId, orgName, orgDiv, fromdate, todate);
	}

	@GetMapping(value = "rest-getTotalemployeeAttendanceAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalEmployeeAttendanceAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate, @RequestParam String shift) {

		logger.info("Method : getTotalEmployeeAttendanceAggrid starts");

		logger.info("Method :getTotalEmployeeAttendanceAggrid ends");
		return restHrmsDashboardDao.getTotalEmployeeAttendanceAggrid(userId, value1, orgName, orgDiv, fromdate, todate,
				shift);
	}
}

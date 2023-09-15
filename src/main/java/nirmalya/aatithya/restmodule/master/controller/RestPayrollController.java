package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestPayrollDao;
import nirmalya.aatithya.restmodule.master.model.RestPayrollApprovalModel;
import nirmalya.aatithya.restmodule.master.model.RestPayrollModel;
import nirmalya.aatithya.restmodule.master.model.RestPayslipModel;

@RestController
@RequestMapping(value = "master")
public class RestPayrollController {
	Logger logger = LoggerFactory.getLogger(RestPayrollController.class);

	@Autowired
	RestPayrollDao restPayrollDao;
	@Autowired
	EntityManager em;

	/**
	 * Rest Controller - Get months For Drop Down
	 *
	 */
	@RequestMapping(value = "getMonthLists", method = { RequestMethod.GET })
	public List<DropDownModel> getMonthList() {
		logger.info("Method : getMonthList starts");

		logger.info("Method : getMonthList ends");
		return restPayrollDao.getMonthListsDao();
	}

	/*
	 * @GetMapping(value = "rest-getBandDropDown") public List<DropDownModel>
	 * getBandDropDown() { logger.info("Method : getBandDropDown starts");
	 * 
	 * logger.info("Method : getBandDropDown ends"); return
	 * restPayrollDao.getBandDropDown(); }
	 */

	/*************************** Process *******************************/
	/*
	 * Process
	 */
	@GetMapping(value = "rest-viewProcess")
	public JsonResponse<List<RestPayrollModel>> viewProcess(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String band, @RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewProcess starts");

		logger.info("Method : viewProcess ends");

		return restPayrollDao.viewProcessDao(fromDate, toDate, band, userId,organization,orgDivision);
	}

	/**
	 * Rest Controller - getComponetList
	 *
	 */
	@GetMapping(value = "rest-getComponetList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getComponetList(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getComponetList starts");

		logger.info("Method : getComponetList ends");
		return restPayrollDao.getComponetList(organization,orgDivision);
	}
	/**
	 * Rest Controller - Get getApproverStatus
	 *
	 */
	@GetMapping(value = "rest-getApproverStatus")
	public ResponseEntity<JsonResponse<DropDownModel>> getApproverStatus(@RequestParam String fromDate,String process,String userId,String organization,String orgDivision) {
		logger.info("Method : getApproverStatus starts");

		logger.info("Method : getApproverStatus ends");
		return restPayrollDao.getApproverStatus(fromDate,process,userId,organization,orgDivision);
	}
	
	@RequestMapping(value = "approveProcessDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> approveProcessDetails(@RequestBody List<RestPayrollApprovalModel> data) {
		logger.info("Method : approveProcessDetails starts");

		logger.info("Method : approveProcessDetails ends");
		return restPayrollDao.approveProcessDetails(data);
	}

	/*************************** Approve *******************************/
	/*
	 * Approve
	 */
	@GetMapping(value = "rest-viewApprove")
	public JsonResponse<List<RestPayrollModel>> viewApprove(@RequestParam String fromDate, String toDate,
			 String band,String userId,String organization,String orgDivision) {
		logger.info("Method : viewApprove starts");

		logger.info("Method : viewApprove ends");

		return restPayrollDao.viewApproveDao(fromDate, toDate, band, userId,organization,orgDivision);
	}

	/*************************** Salary Advice *******************************/
	/*
	 * view Salary Advice
	 */

	@GetMapping(value = "rest-viewSalaryAdvice")
	public JsonResponse<List<RestPayrollModel>> viewSalaryAdvice(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String band, @RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewSalaryAdvice starts");

		logger.info("Method : viewSalaryAdvice ends");

		return restPayrollDao.viewSalaryAdviceDao(fromDate, toDate, band, userId,organization,orgDivision);
	}

	/*************************** EPF *******************************/
	/*
	 * view EPF
	 */

	@GetMapping(value = "rest-viewEpf")
	public JsonResponse<List<RestPayrollModel>> viewEpf(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String band, @RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewEpf starts");

		logger.info("Method : viewEpf ends");

		return restPayrollDao.viewEpfDao(fromDate, toDate, band, userId,organization,orgDivision);
	}

	/*************************** ESI *******************************/
	/*
	 * view ESI
	 */

	@GetMapping(value = "rest-viewEsi")
	public JsonResponse<List<RestPayrollModel>> viewEsi(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String band, @RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewEsi starts");

		logger.info("Method : viewEsi ends");

		return restPayrollDao.viewEsiDao(fromDate, toDate, band, userId,organization,orgDivision);
	}

	/*************************** TAX *******************************/
	/*
	 * view TAX
	 */

	@GetMapping(value = "rest-viewTax")
	public JsonResponse<List<RestPayrollModel>> viewTax(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String band, @RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewTax starts");

		logger.info("Method : viewTax ends");

		return restPayrollDao.viewTaxDao(fromDate, toDate, band, userId,organization,orgDivision);
	}

	////////////////////////////////////////////// PAY SLIP
	////////////////////////////////////////////// ////////////////////////////////////////////////////////
	/*
	 * dropdown for employeelist
	 */
	@GetMapping(value = "getEmployeeListsSlip")
	public List<DropDownModel> getEmppLists(@RequestParam String userId,String isHr,String organization,String orgDivision) {
		logger.info("Method : getEmppLists starts");

		logger.info("Method : getEmppLists ends");
		return restPayrollDao.getEmployeeListsSlip(userId, isHr,organization,orgDivision);
	}
	/*
	 * view paySlip Personal details
	 */

	@GetMapping(value = "rest-viewpaySlipPersonal")
	public ResponseEntity<JsonResponse<RestPayslipModel>> viewpaySlipPersonal(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String empId,@RequestParam String organization,@RequestParam String orgDivision ) {
		logger.info("Method : viewpaySlipPersonal starts");

		logger.info("Method : viewpaySlipPersonal ends"+orgDivision);

		return restPayrollDao.viewpaySlipPersonalDao(fromDate, toDate, empId,organization,orgDivision);
	}
	// view pay slip API

	@GetMapping(value = "view-employe-paySlip-api")
	public JsonResponse<List<RestPayslipModel>> viewPaySlipApi(@RequestParam String userId,String organization, String orgDivision) {
		logger.info("Method : viewPaySlipApi starts");

		logger.info("Method : viewPaySlipApi ends");
		return restPayrollDao.viewPaySlipApi(userId,organization,orgDivision);
	}
	//check payslip eligible
		@GetMapping(value = "/check-payslip-eligible")
		public ResponseEntity<JsonResponse<DropDownModel>> checkPayslipEligible(@RequestParam String userId,@RequestParam String organization,@RequestParam String orgDivision){
			logger.info("Method : checkPayslipEligible starts");

			logger.info("Method : checkPayslipEligible ends");
			return restPayrollDao.checkPayslipEligible(userId,organization,orgDivision);
		}
}

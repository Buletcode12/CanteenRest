package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GeneratePayrollApproveParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestPayrollApprovalModel;
import nirmalya.aatithya.restmodule.master.model.RestPayrollModel;
import nirmalya.aatithya.restmodule.master.model.RestPayslipModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestPayrollDao {
	Logger logger = LoggerFactory.getLogger(RestPayrollDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/**
	 * DAO - Get Month For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getMonthListsDao() {
		logger.info("Method : getMonthListsDao starts");

		List<DropDownModel> month = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "getMonthsList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				month.add(dropDownModel);
			}

		} catch (Exception e) {
			logger.error("getMonthListsDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getMonthListsDao ends");
		return month;
	}

	/**
	 * DAO - Get Band For Drop Down
	 *
	 */

	/*
	 * @SuppressWarnings("unchecked") public List<DropDownModel> getBandDropDown() {
	 * logger.info("Method : getBandDropDown starts");
	 * 
	 * List<DropDownModel> getBandDropDown = new ArrayList<DropDownModel>();
	 * 
	 * try {
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
	 * .setParameter("actionType",
	 * "getBandTypeDropdown").setParameter("actionValue", "").getResultList();
	 * 
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); getBandDropDown.add(dropDownModel); } } catch (Exception e) {
	 * logger.error("getBandDropDown: " + e.getMessage()); e.printStackTrace(); }
	 * 
	 * logger.info("Method : getBandDropDown ends");
	 * 
	 * return getBandDropDown; }
	 */

	/*************************** Process *******************************/
	/*
	 * Process
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPayrollModel>> viewProcessDao(String fromDate, String toDate, String band,
			String userId,String organization,String orgDivision) {

		logger.info("Method in Dao: viewProcessDao starts");

		List<RestPayrollModel> approve = new ArrayList<RestPayrollModel>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Band=\"" + band + "\", @P_userId=\"" + userId
					+ "\", @P_organization=\"" + organization + "\", @P_orgDivision=\"" + orgDivision + "\";";

			logger.info("value process =====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewProcessApproved").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				RestPayrollModel rollModel = new RestPayrollModel(m[0], m[1], m[2].toString(), 
						m[3].toString(),m[4].toString(), m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(),m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), m[13].toString(),m[14].toString(),m[15].toString(), m[16].toString(), m[17].toString(),  
						m[18].toString(),m[19].toString(),m[20].toString(),m[21].toString(),m[22].toString(),m[23].toString(),
						m[24].toString(),m[25].toString(),m[26].toString(),
						m[27].toString(),m[28].toString(),m[29].toString(), m[30].toString(), m[31].toString(),m[32].toString(), m[33].toString(), m[34].toString());
				approve.add(rollModel);
			}

		} catch (Exception e) {
			logger.error("viewProcessDao: " + e.getMessage());
			e.printStackTrace();
		}

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Band=\"" + band + "\", @P_userId=\"" + userId
					+ "\";";

			logger.info("value process =====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewProcessUnApproved").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				RestPayrollModel rollModel = new RestPayrollModel(m[0], m[1], m[2].toString(), 
						m[3].toString(),m[4].toString(), m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(),m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), m[13].toString(),m[14].toString(),m[15].toString(), m[16].toString(), m[17].toString(),  
						m[18].toString(),m[19].toString(),m[20].toString(),m[21].toString(),m[22].toString(),m[23].toString(),
						m[24].toString(),m[25].toString(),m[26].toString(),
						m[27].toString(),m[28].toString(),m[29].toString(), m[30].toString(), m[31].toString(),m[32].toString(), m[33].toString(), m[34].toString());
				approve.add(rollModel);
			}

		} catch (Exception e) {
			logger.error("viewProcessDao: " + e.getMessage());
			e.printStackTrace();
		}
		JsonResponse<List<RestPayrollModel>> resp = new JsonResponse<List<RestPayrollModel>>();
		resp.setBody(approve);
		logger.info("resp process =====" + resp);
		logger.info("Method in Dao: viewProcessDao ends");
		return resp;
	}
	// get getComponetList

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getComponetList(String organization,String orgDivision) {

		logger.info("Method : getComponetList starts");

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> model = new ArrayList<DropDownModel>();
		String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "getComponetList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel item = new DropDownModel(m[0], m[1]);
				model.add(item);
			}
		} catch (Exception e) {
			logger.error("getComponetList: " + e.getMessage());
			e.printStackTrace();
		}
		resp.setBody(model);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getComponetList ends");
		return response;
	}

	// get getApproverStatus
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getApproverStatus(String fromDate, String process,
			String userId,String organization,String orgDivision) {
		logger.info("Method : getApproverStatus starts");

		DropDownModel policydetails = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();

		try {
			String value = "SET @p_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\",@p_process=\"" + process
					+ "\",@p_userId=\"" + userId + "\",@P_organization=\"" + organization + "\",@P_orgDivision=\"" + orgDivision + "\";";
			logger.info("value status =====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "getApproverStatus").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				policydetails = dropDownModel;
			}
			resp.setBody(policydetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getApproverStatus ends");

		return response;
	}

	/* Function for approveEmployeeAttendance */

	public ResponseEntity<JsonResponse<Object>> approveProcessDetails(List<RestPayrollApprovalModel> data) {
		logger.info("Method : approveProcessDetails starts");
		logger.info("data======" + data);
		
		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = GeneratePayrollApproveParam.getPayrollApproveParam(data);
		logger.info("value======" + value);
		try {
			em.createNamedStoredProcedureQuery("payrollRoutines").setParameter("actionType", "approveProcessDetails")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				logger.error("approveProcessDetails: " + e.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
			logger.error("approveProcessDetails: " + e.getMessage());
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("response======" + response);
		logger.info("Method : approveProcessDetails ends");
		return response;
	}

	/*************************** Approve *******************************/
	/*
	 * Approve
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPayrollModel>> viewApproveDao(String fromDate, String toDate, String band,
			String userId,String organization,String orgDivision) {

		logger.info("Method in Dao: viewApproveDao starts");

		List<RestPayrollModel> approve = new ArrayList<RestPayrollModel>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Band=\"" + band + "\", @P_userId=\"" + userId
					+ "\", @P_organization=\"" + organization + "\", @P_orgDivision=\"" + orgDivision + "\";";

			logger.info("value approve======" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewApprove").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				RestPayrollModel rollModel = new RestPayrollModel(m[0], m[1], m[2].toString(), 
						m[3].toString(),m[4].toString(), m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(),m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), m[13].toString(),m[14].toString(),m[15].toString(), m[16].toString(), m[17].toString(),  
						m[18].toString(),m[19].toString(),m[20].toString(),m[21].toString(),m[22].toString(),m[23].toString(),
						m[24].toString(),m[25].toString(),m[26].toString(),
						m[27].toString(),m[28].toString(),m[29].toString(), m[30].toString(), m[31].toString(),m[32].toString(), m[33].toString(), m[34].toString());
				approve.add(rollModel);
			}

		} catch (Exception e) {
			logger.error("viewApproveDao: " + e.getMessage());
			e.printStackTrace();
		}

		JsonResponse<List<RestPayrollModel>> resp = new JsonResponse<List<RestPayrollModel>>();
		resp.setBody(approve);
		logger.info("Method in Dao: viewApproveDao ends");
		return resp;
	}

	/*************************** Salary Advice *******************************/
	/*
	 * view Salary Advice
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPayrollModel>> viewSalaryAdviceDao(String fromDate, String toDate, String band,
			String userId,String organization,String orgDivision) {

		logger.info("Method in Dao: viewSalaryAdviceDao starts");

		List<RestPayrollModel> salayAdviceList = new ArrayList<RestPayrollModel>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Band=\"" + band + "\", @P_userId=\"" + userId
					+ "\",@P_organization=\"" + organization + "\", @P_orgDivision=\"" + orgDivision +"\";";
			logger.info("value======" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewSalaryAdvice").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestPayrollModel rollModel = new RestPayrollModel(m[0], m[1], m[2], m[3].toString(),m[4].toString(),null,m[5],m[6],m[7]);
				salayAdviceList.add(rollModel);
			}

		} catch (Exception e) {
			logger.error("viewSalaryAdviceDao: " + e.getMessage());
			e.printStackTrace();
		}

		JsonResponse<List<RestPayrollModel>> resp = new JsonResponse<List<RestPayrollModel>>();
		resp.setBody(salayAdviceList);
		logger.info("Method in Dao: viewSalaryAdviceDao ends");
		return resp;
	}

	/*************************** EPF *******************************/
	/*
	 * view EPF
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPayrollModel>> viewEpfDao(String fromDate, String toDate, String band, String userId,String organization,String orgDivision) {

		logger.info("Method in Dao: viewEpfDao starts");

		List<RestPayrollModel> epf = new ArrayList<RestPayrollModel>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Band=\"" + band + "\", @P_userId=\"" + userId
					+ "\",@P_organization=\"" + organization +"\", @P_orgDivision=\"" + orgDivision +"\";";
			logger.info("value======" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewEpf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestPayrollModel rollModel = new RestPayrollModel(m[0], m[1], m[2].toString(), m[3].toString(),
						m[4].toString(), m[5].toString(), m[6].toString(),m[7],m[8],m[9]);
				epf.add(rollModel);
			}

		} catch (Exception e) {
			logger.error("viewEpfDao: " + e.getMessage());
			e.printStackTrace();
		}

		JsonResponse<List<RestPayrollModel>> resp = new JsonResponse<List<RestPayrollModel>>();
		resp.setBody(epf);
		logger.info("Method in Dao: viewEpfDao ends");
		return resp;
	}

	/*************************** ESI *******************************/
	/*
	 * view ESI
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPayrollModel>> viewEsiDao(String fromDate, String toDate, String band, String userId,String organization,String orgDivision) {

		logger.info("Method in Dao: viewEsiDao starts");

		List<RestPayrollModel> esi = new ArrayList<RestPayrollModel>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Band=\"" + band + "\", @P_userId=\"" + userId
					+ "\",@P_organization=\"" + organization + "\", @P_orgDivision=\"" + orgDivision + "\";";
			logger.info("value======" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewEsi").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestPayrollModel rollModel = new RestPayrollModel(m[0], m[1], m[2], m[3].toString(), m[4].toString(),
						m[5].toString(), m[6].toString(), null,m[7],m[8],m[9]);
				esi.add(rollModel);
			}

		} catch (Exception e) {
			logger.error("viewEsiDao: " + e.getMessage());
			e.printStackTrace();
		}

		JsonResponse<List<RestPayrollModel>> resp = new JsonResponse<List<RestPayrollModel>>();
		resp.setBody(esi);
		logger.info("resp======" + resp);
		logger.info("Method in Dao: viewEsiDao ends");
		return resp;
	}

	/*************************** TAX *******************************/
	/*
	 * view TAX
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPayrollModel>> viewTaxDao(String fromDate, String toDate, String band, String userId,String organization,String orgDivision) {

		logger.info("Method in Dao: viewTaxDao starts");

		List<RestPayrollModel> tax = new ArrayList<RestPayrollModel>();
		JsonResponse<List<RestPayrollModel>> resp1 = new JsonResponse<List<RestPayrollModel>>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Band=\"" + band + "\", @P_userId=\"" + userId
					+ "\",@P_organization=\"" + organization + "\", @P_orgDivision=\"" + orgDivision + "\";";
			logger.info("value======" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewTax").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestPayrollModel rollModel = new RestPayrollModel(m[0], m[1], m[2], m[3].toString(), m[4].toString(),m[5],m[6],m[7]);
				tax.add(rollModel);
			}
			if (tax.size() > 0) {
				Util.setJsonResponse(resp1, tax, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp1, tax, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

			resp1.setBody(tax);

		} catch (Exception e) {
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp1, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		logger.info("Method in Dao: viewTaxDao ends");
		return resp1;
	}

	/************************** Payslip ******************************/

	// Employee List dropdown //

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeListsSlip(String userId, String isHr,String organization,String orgDivision) {
		logger.info("Method : getEmppLists starts");

		List<DropDownModel> getEmpDropDown = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_empId='" + userId + "',@p_isHr='" + isHr + "',@P_organization=\"" + organization + "\", @P_orgDivision=\"" + orgDivision + "\";";
			logger.info("value====" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("payslipRoutines")
					.setParameter("actionType", "getEmployeeLists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getEmpDropDown.add(dropDownModel);
			}
		} catch (Exception e) {
			logger.error("getEmppLists: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getEmppLists ends");
		return getEmpDropDown;
	}

	/*
	 * view Payslip personal details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestPayslipModel>> viewpaySlipPersonalDao(String fromDate, String toDate,
			String empId ,String organization,  String orgDivision) {

		logger.info("Method in Dao: viewpaySlipPersonalDao starts");

		RestPayslipModel patSlipList = new RestPayslipModel();
		JsonResponse<RestPayslipModel> resp = new JsonResponse<RestPayslipModel>();
		try {
			String value = "SET @p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_empId='" + empId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value======" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payslipRoutines")
					.setParameter("actionType", "viewpayslipPersonal").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object Dob = null;
				if (m[13] != null) {
					Dob  =DateFormatter.returnStringDate(m[13]);
				}
				RestPayslipModel rollModel = new RestPayslipModel(m[0], m[1], m[2].toString(), m[3].toString(),
						m[4].toString(), m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(),
						m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), Dob, m[14].toString(), m[15].toString(), m[16].toString(),
						m[17].toString(), m[18].toString(), m[19].toString(), m[20].toString(), m[21].toString(), m[22].toString(), m[23].toString(), m[24].toString(), m[25].toString(), m[26].toString(),
						m[27].toString(), m[28].toString(),m[29].toString(),m[30].toString(),m[31].toString(),m[32].toString(),m[33],m[34],m[35]);
				patSlipList = rollModel;

			}
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			resp.setBody(patSlipList);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info("err======" + err);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");

			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestPayslipModel>> response = new ResponseEntity<JsonResponse<RestPayslipModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("response======" + response);
		logger.info("Method in Dao: viewpaySlipPersonalDao ends");
		return response;
	}

	// view pay slip API
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPayslipModel>> viewPaySlipApi(String userId,String organization, String orgDivision) {

		logger.info("Method : viewPaySlipApi Dao starts");
		List<RestPayslipModel> payslip = new ArrayList<RestPayslipModel>();
		JsonResponse<List<RestPayslipModel>> resp = new JsonResponse<List<RestPayslipModel>>();
		try {

			String value = "SET @p_empId=\"" + userId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value===="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payslipRoutines")
					.setParameter("actionType", "viewPaySlipApi").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object Dob = null;
				if (m[13] != null) {
					Dob  =DateFormatter.returnStringDate(m[13]);
					
				}
				RestPayslipModel rollModel = new RestPayslipModel(m[0], m[1], m[2].toString(), m[3].toString(),
						m[4].toString(), m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(),
						m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), Dob, m[14].toString(), m[15].toString(), m[16].toString(),
						m[17].toString(), m[18].toString(), m[19].toString(), m[20].toString(), m[21].toString(), m[22].toString(), m[23].toString(), m[24].toString(), m[25].toString(), m[26].toString(),
						m[27].toString(), m[28].toString(),m[29].toString(),m[30].toString(),DateFormatter.returnStringDate(m[31]),DateFormatter.returnStringDate(m[32]),null,null,null);

				payslip.add(rollModel);

			}

			if (payslip.size() > 0) {
				resp.setBody(payslip);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(payslip);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			logger.error("viewPaySlipApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(payslip);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewPaySlipApi Dao ends");
		return resp;
	}
	
	//check payslip eligible
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>>checkPayslipEligible(String userId, String organization,String orgDivision) {
		logger.info("Method : checkPayslipEligible starts");

		DropDownModel pf = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		String value = "SET @p_userName='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "checkPayslipEligible").setParameter("actionValue",value).getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				pf = dropDownModel;
				
				if (dropDownModel.equals("")) {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			 resp.setBody(pf);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("checkPayslipEligible: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(pf);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : checkPayslipEligible ends");
		return response;
	}
}

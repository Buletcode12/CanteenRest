package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.AccountLedgerReportRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAccountReportsDao {
	Logger logger = LoggerFactory.getLogger(RestAccountReportsDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	// restViewBankDetails

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerVoucherReport(String id) {
			logger.info("Method : viewLedgerVoucherReport starts");
			List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();
			
			String value = "SET @p_ledgerId='" + id + "';";
			System.out.println("===>>>"+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
						.setParameter("actionType", "getLedgerList")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {

					if (m[3] == null) {
						m[3] = "";
					}
					AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0],m[1], m[2], m[3], m[4].toString(), m[5].toString(), m[6]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : viewLedgerVoucherReport ends");
			return response;

		}
		
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewDayBookReport(String fromDate,String toDate) {
			logger.info("Method : viewDayBookReport starts");
			List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();
			
			String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='"+toDate+"';";
			System.out.println("===>>>"+value);
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
						.setParameter("actionType", "viewDayBookReport")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					
					if (m[3] == null) {
						m[3] = "";
					}
					AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0],m[1], m[2], m[3], m[4].toString(), m[5].toString(), m[6]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			
			
			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}
			
			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : viewDayBookReport ends");
			return response;
			
		}
		
		//viewCashFlowReport
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewCashFlowReport() {
			logger.info("Method : viewCashFlowReport starts");
			List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();
			
			String value = "";
			System.out.println("===>>>"+value);
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
						.setParameter("actionType", "cashFlowReport")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					
					if (m[1] == null) {
						m[1] = "0";
					}
					if (m[2] == null) {
						m[2] = "0";
					}
					if (m[3] == null) {
						m[3] = "0";
					}
					if (m[4] == null) {
						m[4] = "0";
					}
					AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0],m[1].toString(), m[2].toString(), m[3].toString(), m[4].toString());
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			
			
			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}
			
			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : viewCashFlowReport ends");
			return response;
			
		}
		
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerMonthlySummary(String id) {
			logger.info("Method : viewLedgerMonthlySummary starts");
			List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();
			
			String value = "SET @p_ledgerId='" + id + "';";
			System.out.println("value---------------"+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
						.setParameter("actionType", "viewLedgerMonthlySummary")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {	
					
					if (m[0] == null) {
						m[0] = "";
					}
					
					if (m[1] == null) {
						m[1] = "";
					}
					
					AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0].toString(),
							m[1].toString(), m[2].toString());
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : viewLedgerMonthlySummary ends");
			return response;

		}
		
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewMothlyDetails(String month,String ledgerId) {
			logger.info("Method : viewMothlyDetails starts");
			List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();
			
			String value = "SET @p_month='" + month + "',@p_ledgerId='"+ledgerId+"';";
			System.out.println("===>>>"+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
						.setParameter("actionType", "viewLedgerMonthlyDetails")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					
					
					AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0],m[1], m[2], m[3], m[4].toString(), m[5], m[6]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			
			
			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}
			
			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : viewMothlyDetails ends");
			return response;
			
		}
		
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> trialBalanceReport(String fromDate,String toDate) {
			logger.info("Method : trialBalanceReport starts");
			List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();
			
			String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='"+toDate+"';";
			System.out.println("===>>>"+value);
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
						.setParameter("actionType", "trialBalanceReport")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					
					if (m[3] == null) {
						m[3] = "";
					}
					AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0],m[1], m[2], m[3], m[4].toString(), m[5], m[6]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			
			
			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}
			
			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : trialBalanceReport ends");
			return response;
			
		}
		
		//profitLossReport
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> profitLossReport(String fromDate,String toDate) {
			logger.info("Method : profitLossReport starts");
			List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();
			
			String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='"+toDate+"';";
			System.out.println("===>>>"+value);
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
						.setParameter("actionType", "profitLossReport")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					
				
					AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0].toString(),m[1].toString(), m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),m[7].toString());
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			
			
			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}
			
			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : profitLossReport ends");
			return response;
			
		}
}

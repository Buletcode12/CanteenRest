package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountJournalVoucherParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestPaymentVoucherDao {
	Logger logger = LoggerFactory.getLogger(RestPaymentVoucherDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * public ResponseEntity<JsonResponse<Object>> addPaymentVoucher(
	 * List<AccountJournalVoucherModel> journalVoucherModel) {
	 * logger.info("Method : addPaymentVoucher starts");
	 * 
	 * @SuppressWarnings("unused") List<DropDownModel> dropDownModel = new
	 * ArrayList<DropDownModel>(); boolean validation = true; JsonResponse<Object>
	 * resp = new JsonResponse<Object>(); resp.setMessage(""); resp.setCode("");
	 * 
	 * for (AccountJournalVoucherModel l : journalVoucherModel) { if
	 * (l.getCostCenter() == null || l.getCostCenter() == "") { validation = false;
	 * resp.setCode("Field Validation Error");
	 * resp.setMessage("Please Select Cost Center."); break; } else if
	 * (l.getDescription() == null || l.getDescription() == "") { validation =
	 * false; resp.setCode("Field Validation Error");
	 * resp.setMessage("Please Enter Description."); break; } }
	 * 
	 * if (validation) {
	 * 
	 * if(journalVoucherModel.get(0).getJournalVoucher() ==null ||
	 * journalVoucherModel.get(0).getJournalVoucher() =="") { try { String value =
	 * GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(
	 * journalVoucherModel); System.out.println("Add=====>>>>"+value);
	 * em.createNamedStoredProcedureQuery("account_payment_routines")
	 * .setParameter("actionType", "addPaymentVoucher").setParameter("actionValue",
	 * value).execute(); // } } catch (Exception e) { try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); } }else { try { String value =
	 * GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(
	 * journalVoucherModel); System.out.println("modify=====>>>>"+value);
	 * em.createNamedStoredProcedureQuery("account_payment_routines")
	 * .setParameter("actionType",
	 * "modifyPaymentVoucher").setParameter("actionValue", value).execute(); // } }
	 * catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
	 * e1.printStackTrace(); } e.printStackTrace(); } }
	 * 
	 * } ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * logger.info("Method : addPaymentVoucher ends"); return response; }
	 */

	/**
	 * DAO Function to Add Issue Note in inventory
	 */
	public ResponseEntity<JsonResponse<Object>> addPaymentVoucher(
			List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : addPaymentVoucher starts");
		System.out.println("sdfddsfdf=====>>>>" + journalVoucherModel);
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AccountJournalVoucherModel l : journalVoucherModel) {
			if (l.getCostCenter() == null || l.getCostCenter() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Cost Center.");
				break;
			} else if (l.getDescription() == null || l.getDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			}
		}

		if (validation) {

			if (journalVoucherModel.get(0).getJournalVoucher() == null
					|| journalVoucherModel.get(0).getJournalVoucher() == "") {
				try {
					String value = GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(journalVoucherModel);
					System.out.println("Add=====>>>>" + value);
					em.createNamedStoredProcedureQuery("account_payment_routines")
							.setParameter("actionType", "addPaymentVoucher").setParameter("actionValue", value)
							.execute();
					// }
				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			} else {
				try {
					String value = GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(journalVoucherModel);
					System.out.println("modify=====>>>>" + value);
					em.createNamedStoredProcedureQuery("account_payment_routines")
							.setParameter("actionType", "modifyPaymentVoucher").setParameter("actionValue", value)
							.execute();
					// }
				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			}

		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addPaymentVoucher ends");
		return response;
	}

	// restViewJournalVoucher

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> restViewPaymentDetails() {
		logger.info("Method : restViewPaymentDetails starts");
		List<AccountJournalVoucherModel> respList = new ArrayList<AccountJournalVoucherModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getPaymentDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						m[5].toString(), m[6]);
				respList.add(restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restViewPaymentDetails ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editPaymentInfo(String id) {
		logger.info("Method : editPaymentInfo starts");
		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		List<AccountJournalVoucherModel> rs = new ArrayList<AccountJournalVoucherModel>();
		try {

			String value = "SET @p_journalVoucher='" + id + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "editPaymentInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {

				if(m[11]==null || m[11]=="")
				{
					m[11]="";
				}

				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10],m[11].toString(),m[12].toString());
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editPaymentInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println(response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber() {
		logger.info("Method : voucherNumber starts");
		List<DropDownModel> respList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getvoucherNumber").setParameter("actionValue", "").getResultList();
			Object jobId = x.get(0);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);
			respList.add(dropDownModel);
			resp.setBody(respList);
			resp.setMessage("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Unsuccess");
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : voucherNumber ends");
		return response;

	}
	
	/*
	 * getDebitAccountSearch
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(String id) {
		logger.info("Method : getDebitAccountSearch starts");

		List<RestContraVoucherModel> itemNameList = new ArrayList<RestContraVoucherModel>();
		JsonResponse<List<RestContraVoucherModel>> resp = new JsonResponse<List<RestContraVoucherModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getDebitAccSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				
				if(m[2]==null || m[2]=="") {
					m[2]="0";
				}
				
				RestContraVoucherModel dropDownModel = new RestContraVoucherModel(m[0], m[1],m[2].toString());
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<RestContraVoucherModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getDebitAccountSearch ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getCreditAccountSearch(String id) {
		logger.info("Method : getCreditAccountSearch starts");

		List<RestContraVoucherModel> itemNameList = new ArrayList<RestContraVoucherModel>();
		JsonResponse<List<RestContraVoucherModel>> resp = new JsonResponse<List<RestContraVoucherModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getCreditAccSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				
				if(m[2]==null || m[2]=="") {
					m[2]="0";
				}
				RestContraVoucherModel dropDownModel = new RestContraVoucherModel(m[0], m[1],m[2].toString());
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<RestContraVoucherModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getCreditAccountSearch ends");
		return response;
	}
	
	// deleteContraDetails

		public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(String id) {
			logger.info("Method : deleteJournalDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			
			if (validity)
				try {
					String value = "SET @p_payId='" + id + "';";
					em.createNamedStoredProcedureQuery("account_payment_routines")
							.setParameter("actionType", "deleteJournal")
							.setParameter("actionValue", value).execute();

				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);

			if (resp.getMessage() == null) {
				resp.setMessage("Deleted successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}

			logger.info("Method :  deleteJournalDetails ends");
			System.out.println("DELETE" + response);
			return response;
		}


}

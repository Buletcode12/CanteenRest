
package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountJournalVoucherParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import org.springframework.http.HttpHeaders;

@Repository
public class RestContraVoucherDao {

	Logger logger = LoggerFactory.getLogger(RestContraVoucherDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// getVoucherTypeList

	/**
	 * for voucher list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVoucherTypeList() {

		logger.info("Method : getVoucherTypeList starts");

		List<DropDownModel> voucherList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
					.setParameter("actionType", "getCVType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				voucherList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVoucherTypeList ends" + voucherList);
		System.out.println("voucherList----------------------" + voucherList);

		return voucherList;
	}
	
	//getFiscalYearList
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFiscalYearList() {

		logger.info("Method : getFiscalYearList starts");

		List<DropDownModel> voucherList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
					.setParameter("actionType", "getfiscalYear").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				voucherList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFiscalYearList ends" + voucherList);
		System.out.println("voucherList----------------------" + voucherList);

		return voucherList;
	}

	// getCostCenterList

	/**
	 * for costcenter list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenterList() {

		logger.info("Method : getCostCenterList starts");

		List<DropDownModel> costCenterList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
					.setParameter("actionType", "getCostCenter").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				costCenterList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCostCenterList ends" + costCenterList);
		System.out.println("getCostCenterList----------------------" + costCenterList);

		return costCenterList;
	}

	
	
	

	/**
	 * DAO Function to Add Issue Note in inventory
	 */
	public ResponseEntity<JsonResponse<Object>> addContraVoucher(
			List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : addContraVoucher starts");
		System.out.println("sdfddsfdf=====>>>>"+journalVoucherModel);
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
			
			if(journalVoucherModel.get(0).getJournalVoucher() ==null || journalVoucherModel.get(0).getJournalVoucher() =="") {
				try {
					String value = GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(journalVoucherModel);
					System.out.println("Add=====>>>>"+value);
					em.createNamedStoredProcedureQuery("account_contra_routines")
							.setParameter("actionType", "addContraVoucher")
							.setParameter("actionValue", value).execute();
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
			}else {
				try {
					String value = GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(journalVoucherModel);
					System.out.println("modify=====>>>>"+value);
					em.createNamedStoredProcedureQuery("account_contra_routines")
							.setParameter("actionType", "modifyContraVoucher").setParameter("actionValue", value).execute();
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
		logger.info("Method : addContraVoucher ends");
		return response;
	}
	
	
	// restViewContraVouDetails

	
	// restViewJournalVoucher

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> restViewContraVouDetails() {
			logger.info("Method : restViewJournalVoucher starts");
			List<AccountJournalVoucherModel> respList = new ArrayList<AccountJournalVoucherModel>();
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
						.setParameter("actionType", "getContraDetails").setParameter("actionValue", "").getResultList();

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
			logger.info("Method : restViewJournalVoucher ends");

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}

			System.out.println("VIEWWWWWWWW" + respList);
			return response;

		}

	// deleteContraDetails

	public ResponseEntity<JsonResponse<Object>> deleteContraDetails(String id) {
		logger.info("Method : deleteContraDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET @p_contraId='" + id + "';";
				em.createNamedStoredProcedureQuery("account_contra_routines").setParameter("actionType", "deleteContra")
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

		logger.info("Method :  deleteContraDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	// editAccountInfo

	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editContraInfo(String id) {
		logger.info("Method : editContraInfo starts");

		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		List<AccountJournalVoucherModel> rs = new ArrayList<AccountJournalVoucherModel>();

		try {

			String value = "SET @p_journalVoucher='" + id + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
					.setParameter("actionType", "editContraInfo")
					.setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {

				if(m[11]==null || m[11]=="")
				{
					m[11]="";
				}
				if(m[12]==null || m[12]=="")
				{
					m[12]="";
				}
				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						m[5],m[6],m[7], m[8], m[9],m[10],m[11].toString(),m[12].toString());
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

		logger.info("Method : editContraInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println(response);
		return response;
	}

	// getDebitAccountSearch

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
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
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

//getFromAccountB2BSearch

	/*
	 * getFromAccountB2BSearch
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getFromAccountB2BSearch(String id) {
		logger.info("Method : getFromAccountB2BSearch starts");

		List<RestContraVoucherModel> itemNameList = new ArrayList<RestContraVoucherModel>();
		JsonResponse<List<RestContraVoucherModel>> resp = new JsonResponse<List<RestContraVoucherModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
					.setParameter("actionType", "getAccSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestContraVoucherModel dropDownModel = new RestContraVoucherModel(m[0], m[1], m[2], m[3]);
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
		logger.info("Method : getFromAccountB2BSearch ends");
		return response;
	}

	// getContraVoucherReport

	/**
	 * DAO - CONTRA VOUCHER REPORT
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getContraVoucherReport(DataTableRequest request) {
		logger.info("Method : DAO getContraVoucherReport starts");

		List<RestContraVoucherModel> contraVoucher = new ArrayList<RestContraVoucherModel>();
		JsonResponse<List<RestContraVoucherModel>> resp = new JsonResponse<List<RestContraVoucherModel>>();

		String param1 = request.getParam1();
		String param2 = request.getParam2();
		if (param1 != null && param1 != "") {
			String frmDate = param1;

			request.setParam1(frmDate);
		}
		if (param2 != null && param2 != "") {
			String tDate = param2;

			request.setParam2(tDate);
		}

		String values = GenerateParameter.getSearchParam(request);
		Integer total = 0;
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
					.setParameter("actionType", "contraVoucherReport").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object cvDate = null;
				if (m[4] != null) {
					cvDate = m[4].toString();
				}
				RestContraVoucherModel cv = new RestContraVoucherModel(m[0], m[1], m[2], m[3], cvDate, m[5]);
				contraVoucher.add(cv);
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("contravoucher response----------------------" + contraVoucher);

		resp.setBody(contraVoucher);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<RestContraVoucherModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getContraVoucherReport ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getContravoucherNumber() {
		logger.info("Method : getContravoucherNumber starts");
		List<DropDownModel> respList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
					.setParameter("actionType", "getvoucherNumber").setParameter("actionValue", "").getResultList();
			Object jobId = x.get(0);
			
			DropDownModel dropDownModel = new DropDownModel(jobId,null);
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
		logger.info("Method : getContravoucherNumber ends");
		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

}

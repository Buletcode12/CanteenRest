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

import nirmalya.aatithya.restmodule.account.model.AccountCreditNoteRestModel;
import nirmalya.aatithya.restmodule.account.model.RestPurchaseItemModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.CreditNoteGenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAccountDebitNoteDao {
	Logger logger = LoggerFactory.getLogger(RestAccountDebitNoteDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getorderList(String id) {

		logger.info("Method : getorderList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_salesId='" + id + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("debit_notes_routines")
					.setParameter("actionType", "getpoorderList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getorderList ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProductList(String id) {

		logger.info("Method : getProductList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_orderId='" + id + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("debit_notes_routines")
					.setParameter("actionType", "getProductList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getProductList ends");
		return response;
	}
	
	

	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseItemModel>>> getProductDetails(String id,String pid) {
		logger.info("Method : getProductList starts");

		List<RestPurchaseItemModel> getAllemployee = new ArrayList<RestPurchaseItemModel>();
		JsonResponse<List<RestPurchaseItemModel>> resp = new JsonResponse<List<RestPurchaseItemModel>>();

		String value = "SET @p_orderId='" + id + "',@p_prdcId='"+pid+"';";
		System.out.println("values=====>>"+value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("debit_notes_routines")
					.setParameter("actionType", "getOrderItem").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestPurchaseItemModel viewdemo = new RestPurchaseItemModel(m[0], m[1], m[2].toString(), m[3].toString(), m[4].toString(),
						m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(),m[9].toString(),null,null);

				getAllemployee.add(viewdemo);
			}
			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}

		resp.setBody(getAllemployee);
		ResponseEntity<JsonResponse<List<RestPurchaseItemModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseItemModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductList ends");
		System.out.println("response data is" + response);
		return response;
	}
	
	/*
	 * add
	 */

	@SuppressWarnings({ "unchecked", "unused" })
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> addDebitNote(List<AccountCreditNoteRestModel> addCreditNote) {
		logger.info("Method : addDebitNote starts");
		JsonResponse<List<AccountCreditNoteRestModel>> resp = new JsonResponse<List<AccountCreditNoteRestModel>>();
		List<AccountCreditNoteRestModel> listData = new ArrayList<AccountCreditNoteRestModel>();

		String orderId;
		String address;

		try {
			String values = CreditNoteGenerateParameter.addDebitNote(addCreditNote);
			System.out.println("====>>>" + values);
			if (addCreditNote.get(0).getCreditNoteId() == null || addCreditNote.get(0).getCreditNoteId() == "") {

				 em.createNamedStoredProcedureQuery("debit_notes_routines")
						.setParameter("actionType", "addDebitNote").setParameter("actionValue", values)
						.execute();
								
			}
			resp.setCode("Success");
			resp.setMessage("Order placed successfully");
		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());

		}
		ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addDebitNote dao ends");
		return response;
	}
	
	// restViewJournalVoucher

			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> debitNoteView(String userId) {
				logger.info("Method : debitNoteView starts");
				List<AccountCreditNoteRestModel> respList = new ArrayList<AccountCreditNoteRestModel>();
				
				String value = "SET @p_userId='" + userId + "';";
				try {
					List<Object[]> x = em.createNamedStoredProcedureQuery("debit_notes_routines")
							.setParameter("actionType", "debitNoteView").setParameter("actionValue", value).getResultList();

					for (Object[] m : x) {

						AccountCreditNoteRestModel restPayroll = new AccountCreditNoteRestModel(m[0], m[1], m[2], m[3], m[4],
								m[5].toString(), m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), m[13], m[14], m[15],null,null);
						respList.add(restPayroll);

					}

					System.out.println("VIEW" + respList);

				} catch (Exception e) {

					e.printStackTrace();

				}

				JsonResponse<List<AccountCreditNoteRestModel>> resp = new JsonResponse<List<AccountCreditNoteRestModel>>();
				resp.setBody(respList);
				ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>>(
						resp, HttpStatus.CREATED);
				System.out.println("response" + response);
				

				if (resp.getMessage() == null) {
					resp.setMessage("View successfully");
				}

				if (resp.getCode() == null) {
					resp.setCode("Success");
				}

				System.out.println("VIEWWWWWWWW" + respList);
				logger.info("Method : debitNoteView ends");
				return response;

			}
			
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<DropDownModel>>> getDebitLedgerList(String id) {
				logger.info("Method : getDebitLedgerList starts");

				List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
				JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
				String value = "SET @p_searchValue='" + id + "';";

				try {
					List<Object[]> x = em.createNamedStoredProcedureQuery("debit_notes_routines")
							.setParameter("actionType", "getDebitLedgerList")
							.setParameter("actionValue", value)
							.getResultList();

					System.out.println(value);
					for (Object[] m : x) {
						
						if(m[2]=="" || m[2]==null){
							m[2]="";
						}
						
						DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2].toString());

						itemNameList.add(dropDownModel);
					}
					// System.out.println("getAllcustomer" +itemNameList);
					if (itemNameList.size() > 0) {
						resp.setBody(itemNameList);
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					} else {
						resp.setBody(itemNameList);
						resp.setCode("failed");
						resp.setMessage("Data not found");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("Method : getDebitLedgerList ends" + response);

				return response;
			}
			
			
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<AccountCreditNoteRestModel>> viewDebitNote(String id) {
				logger.info("Method : viewDebitNote starts");

				JsonResponse<AccountCreditNoteRestModel> resp = new JsonResponse<AccountCreditNoteRestModel>();
				List<AccountCreditNoteRestModel> getShoukeenProduct = new ArrayList<AccountCreditNoteRestModel>();
				List<RestPurchaseItemModel> docList = new ArrayList<RestPurchaseItemModel>();

				try {

					String value = "SET @p_voucherId='" + id + "';";
					System.out.println("===>>>" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("debit_notes_routines")
							.setParameter("actionType", "viewDebitNotes").setParameter("actionValue", value).getResultList();

					for (Object[] m : x) {
						
						if(m[5]=="" || m[5]==null) {
							m[5]="";
						}
						
						if(m[16]=="" || m[16]==null) {
							m[16]="";
						}
						
						if(m[17]=="" || m[17]==null) {
							m[17]="";
						}

						AccountCreditNoteRestModel orderdeatils = new AccountCreditNoteRestModel(m[0], m[1], m[2], m[3], m[4],
								m[5].toString(), m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), m[13], m[14], m[15],m[16],m[17].toString());
						getShoukeenProduct.add(orderdeatils);

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				if (getShoukeenProduct.size() > 0) {
					try {
						String subValues = "SET @p_vocherId='" + id + "';";
						System.out.println(subValues);
						List<Object[]> x1 = em.createNamedStoredProcedureQuery("debit_notes_routines")
								.setParameter("actionType", "getProductDetails").setParameter("actionValue", subValues)
								.getResultList();
						for (Object[] m : x1) {

							RestPurchaseItemModel viewdemo = new RestPurchaseItemModel(null,null,m[0], m[1], m[2], m[3].toString(), m[4],
									m[5], m[6].toString(), m[7],m[8],m[9]);
							docList.add(viewdemo);
						}
						getShoukeenProduct.get(0).setDebitItemAttribute(docList);
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
				resp.setBody(getShoukeenProduct.get(0));
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("MyResponseHeader", "MyValue");
				
				if (resp.getBody().getCreditNoteId() != null) {
					resp.setCode("Success");
					resp.setMessage("Data fetched  succesfully");
				} else {
					resp.setCode("Failed");
					resp.setMessage("Data Not Found");
				}

				ResponseEntity<JsonResponse<AccountCreditNoteRestModel>> response = new ResponseEntity<JsonResponse<AccountCreditNoteRestModel>>(
						resp, responseHeaders, HttpStatus.CREATED);

				logger.info("Method : viewDebitNote ends");
				System.out.println("response in edit product-------------" + response);
				return response;

			}
			
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber() {
				logger.info("Method : voucherNumber starts");
				List<DropDownModel> respList = new ArrayList<DropDownModel>();
				JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
				try {
					List<Object[]> x = em.createNamedStoredProcedureQuery("debit_notes_routines")
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
				
			
	
}

package nirmalya.aatithya.restmodule.pipeline.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCallParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;

@Repository
public class RestCrmCallDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	//addTask
	
	/**
	 * DAO Function to add pipeline
	 *
	 */

	public JsonResponse<Object> addCall(RestCrmCallModel call) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateCallParameter.getAddCallParam(call);
				logger.info("Values for add task----------------------"+values);
				if (call.getCallId() == null || call.getCallId() == "") {
					logger.info("add============="+call.getCallId());
					
						
						
						String pageTypeContact="Contact";
						String pageTypeLead="Lead";
						String pageTypeAccount="Account";
						String pageTypeDeal = "Deal";
						String pageTypeCall = "Call";
						
						String pageTypeQuote="Quote";
						String pageTypeSO="SalesOrder";
						String pageTypePO="PurchaseOrder";
						String pageTypeInvoice="Invoice";
						
						String pageType=call.getPageType();
						
						if(pageType.equals(pageTypeCall)) {
							
							
							if(call.getLeadId() == null || call.getLeadId() == "") {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactType")
										.setParameter("actionValue", values).execute();
								}
								else {
									em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadType")
									.setParameter("actionValue", values).execute();
								}
								
						}
						
						
					 if(pageType.equals(pageTypeLead)) {
							if(call.getLeadId() == null || call.getLeadId() == "") {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactTypeL")
										.setParameter("actionValue", values).execute();
								}
								else {
									em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeL")
									.setParameter("actionValue", values).execute();
								}	
						}
						
						if(pageType.equals(pageTypeContact)) {
							if(call.getLeadId() == null || call.getLeadId() == "") {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactTypeC")
										.setParameter("actionValue", values).execute();
								}
								else {
									em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeC")
									.setParameter("actionValue", values).execute();
								}	
						}
						


					if(pageType.equals(pageTypeAccount)) {
						if(call.getLeadId() == null || call.getLeadId() == "") {
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactTypeA")
									.setParameter("actionValue", values).execute();
							}
							else {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeA")
								.setParameter("actionValue", values).execute();
							}
					}
					
					if(pageType.equals(pageTypeDeal)) {
						if(call.getLeadId() == null || call.getLeadId() == "") {
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactTypeD")
									.setParameter("actionValue", values).execute();
							}
							else {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeD")
								.setParameter("actionValue", values).execute();
							}
					}
					
					
					 if(pageType.equals(pageTypeQuote)) {
							if(call.getLeadId() == null || call.getLeadId() == "") {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactTypeQ")
										.setParameter("actionValue", values).execute();
								}
								else {
									em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeQ")
									.setParameter("actionValue", values).execute();
								}	
						}
					 
					 if(pageType.equals(pageTypeSO)) {
							if(call.getLeadId() == null || call.getLeadId() == "") {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactTypeS")
										.setParameter("actionValue", values).execute();
								}
								else {
									em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeS")
									.setParameter("actionValue", values).execute();
								}	
						}
					 
					 if(pageType.equals(pageTypePO)) {
							if(call.getLeadId() == null || call.getLeadId() == "") {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactTypeP")
										.setParameter("actionValue", values).execute();
								}
								else {
									em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeP")
									.setParameter("actionValue", values).execute();
								}	
						}
					 
					 if(pageType.equals(pageTypeInvoice)) {
							if(call.getLeadId() == null || call.getLeadId() == "") {
								em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addCallContactTypeI")
										.setParameter("actionValue", values).execute();
								}
								else {
									em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeI")
									.setParameter("actionValue", values).execute();
								}	
						}
						
						
						
						
				}

				 else {
					logger.info("modify=========================================modifyCallDetails");
					em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "modifyCallDetails")
							.setParameter("actionValue", values).execute();
				}
			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("@@@@@" + resp);

		logger.info("Method : addCall ends");
		return resp;
	}
	
	
	///restViewTaskdetails
	


////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> restViewCallDetails() {
		logger.info("Method : restViewCallDetails starts");
		List<RestCrmCallModel> respList = new ArrayList<RestCrmCallModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "getCallDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
	

				RestCrmCallModel restPayroll = new RestCrmCallModel(m[0].toString(), m[1], m[2],m[3],m[4],m[5],m[6],m[7].toString(),m[8].toString(),m[9],m[10],
						m[11],m[12]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmCallModel>> resp = new JsonResponse<List<RestCrmCallModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmCallModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCallModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewLeadData ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	//getLeadNameList
	
	
	/**
	 * for getLeadNameList list
	 * @return
	 */
/*	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadNameList() {
		
		logger.info("Method : getLeadNameList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_task")
					.setParameter("actionType", "getLeadNameList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeadNameList ends"+employmentList);
		
		return employmentList;
	}*/
	
	//editTaskInfo
	
	

	///editAccountInfo   
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestCrmCallModel>>>editCallInfo(String id) {
			logger.info("Method : editTaskInfo starts");

			JsonResponse<List<RestCrmCallModel>> resp = new JsonResponse<List<RestCrmCallModel>>();
			List<RestCrmCallModel> rs = new ArrayList<RestCrmCallModel>();

			try {

				String value = "SET @p_callId='" + id +"';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
						.setParameter("actionType", "editCallInfo").setParameter("actionValue", value).getResultList();
				logger.info("asdfasdf"+x);
	           
				for (Object[] m : x) {
					RestCrmCallModel restPayroll = new RestCrmCallModel(m[0].toString(), m[1], m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9].toString(),m[10],
							m[11].toString(),m[12].toString(),m[13].toString(),m[14].toString(),m[15].toString(),m[16].toString(),m[17].toString(),m[18],m[19].toString());
					
					rs.add(restPayroll);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	resp.setBody(rs);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<RestCrmCallModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCallModel>>>(resp,responseHeaders,
					HttpStatus.CREATED);

			logger.info("Method : editCallInfo ends");
			return response;
		}

	//deleteTaskDetails
		
		/*
		 * delete
		 */

	public ResponseEntity<JsonResponse<Object>> deleteCallDetails(String id) {
			logger.info("Method : deleteCallDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			logger.info("ID...."+id);
			if (validity)
				try {

					//String value = "SET @p_taskId='" + id + "';";
					String value = "SET  @p_callId='(" + id + ")';";
					logger.info(value);

					em.createNamedStoredProcedureQuery("crm_call")
							.setParameter("actionType", "deleteCallDetails").setParameter("actionValue", value).execute();

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

			logger.info("Method :  deleteCallDetails ends");
			logger.info("DELETE" + response);
			return response;
		}
	
	// AutoSearch

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchList(String id) {
			logger.info("Method : getNameAutoSearchList starts");
			List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			String value = "SET @p_searchValue='" + id + "';";

			try {
				logger.info("VALUE"+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
						.setParameter("actionType", "getNameAutoSearchList").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					itemNameList.add(dropDownModel);
				}
				resp.setBody(itemNameList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);

				if (resp.getMessage() == null) {
					resp.setMessage("View successfully");
				}
				
				if (resp.getCode() == null) {
					resp.setCode("Success");
				}
			
			
			logger.info("Method : getNameAutoSearchList ends");
			logger.info("AUTODATAAA" + response);
			return response;
		}

		// AutoSearch

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchListContact(String id) {
					logger.info("Method : getNameAutoSearchListContact starts");
					List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
					JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
					String value = "SET @p_searchValue='" + id + "';";

					try {
						logger.info("VALUE"+value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
								.setParameter("actionType", "getNameAutoSearchListContact").setParameter("actionValue", value)
								.getResultList();
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
							itemNameList.add(dropDownModel);
						}
						resp.setBody(itemNameList);
					} catch (Exception e) {
						e.printStackTrace();
					}
					ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
							resp, HttpStatus.CREATED);
					
					if (resp.getMessage() == null) {
						resp.setMessage("View successfully");
					}
					
					if (resp.getCode() == null) {
						resp.setCode("Success");
					}
					
					logger.info("Method : getNameAutoSearchListContact ends");
					logger.info("AUTODATAAA" + response);
					return response;
				}
	
				// AutoSearch

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchDetailsRelated(String searchValue,String id) {
					logger.info("Method : getNameAutoSearchDetailsRelated starts");
					List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
					JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
					String value = "SET @p_searchValue=\"" + searchValue + "\", @p_Id=\"" + id + "\";";

					try {
						logger.info("VALUE"+value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
								.setParameter("actionType", "getNameAutoSearchDetailsRelated").setParameter("actionValue", value)
								.getResultList();
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
							itemNameList.add(dropDownModel);
						}
						resp.setBody(itemNameList);
					} catch (Exception e) {
						e.printStackTrace();
					}
					ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("Method : getNameAutoSearchDetailsRelated ends");
					logger.info("AUTODATAAA" + response);
					return response;
				}

}

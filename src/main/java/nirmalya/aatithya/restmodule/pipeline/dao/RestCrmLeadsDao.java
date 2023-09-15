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
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmLeadDetails;
import nirmalya.aatithya.restmodule.common.utils.GenerateemployeemasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmProductModel;

@Repository
public class RestCrmLeadsDao {

	Logger logger = LoggerFactory.getLogger(RestCrmLeadsDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	/**
	 * for department list
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadList() {
		
		logger.info("Method : getLeadList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getLeadList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeadList ends"+employmentList);
		
		return employmentList;
	}
	
	
	
	/**
	 * for department list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getindustrylist() {
		
		logger.info("Method : getindustrylist starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getindustrylist")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getindustrylist ends"+employmentList);
		
		return employmentList;
	}
	
	
	/**
	 * for department list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRatingList() {
		
		logger.info("Method : getRatingList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getRatingList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRatingList ends"+employmentList);
		
		return employmentList;
	}
	
	/**
	 * for department list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDocumentList() {
		
		logger.info("Method : getDocumentList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getDocumentList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDocumentList ends"+employmentList);
		
		return employmentList;
	}
	
////view
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> viewLeadSearchDetails(RestCrmLeadsModel leadDetails) {

		logger.info("Method in Dao: viewLeadSearchDetails starts");
		
		
        JsonResponse<Object> resp = new JsonResponse<Object>();
		  resp.setMessage(""); resp.setCode("");
		 
		//JsonResponse<Object> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();
			try {
				String values = GenerateCrmLeadDetails.CrmLeadParam(leadDetails);
				logger.info(values);
				
				String actionType = null;
				String actionValue = null;
				
				if(values != null && values != "") {
					actionType = "getDetailsBySearch";
					actionValue = values;
				} else {
					actionType = "getDetails";
					actionValue = "";
				}

				logger.info("Action Type===="+actionType);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", actionType).setParameter("actionValue", actionValue)
						.getResultList();
				logger.info("asdfasdf"+x);
	           
				for (Object[] m : x) {
					//logger.info("VIEWWWWWWWWWWWW");
					
//					String fromDate = null;
//					if (m[11] != null) {
//						fromDate = m[11].toString();
//					}
					
					logger.info("reference contact-------------"+m[32]);
					
					RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],
							m[9],m[10], m[11],m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
							m[22], m[23], m[24],m[25],m[26],m[27],m[28],m[29].toString(),m[30],m[31],m[32],null);
					logger.info("VIEW DATA LEADS DETAILS---------------"+assignSkill);
					
					rs.add(assignSkill);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        resp.setBody(rs);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
			logger.info("Method : viewLeadInfo ends");
		
			return response;
	}
	
	
	
	
	/**
	 * for department list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountry() {
		
		logger.info("Method : getCountry starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getCountry")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountry ends"+employmentList);
		
		return employmentList;
	}
	
	//getLeadStatusList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadStatusList() {
		
		logger.info("Method : getLeadStatusList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getLeadStatusList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeadStatusList ends"+employmentList);
		
		return employmentList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getcuststateListNew(String id) {

		logger.info("Method : getcuststateListNew starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
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
	
		logger.info("Method : getcuststateListNew ends");
		return response;
	}
	
	
	
	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> restAddLeadDetails(RestCrmLeadsModel leadDetails) {

		logger.info("Method in Dao: restAddLeadDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
			try {
				String values = GenerateCrmLeadDetails.generateCrmLeadParam(leadDetails);
				logger.info(values);
				if (leadDetails.getLeadId() =="" || leadDetails.getLeadId() ==null) {
			
					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "1addLeadData")
							.setParameter("actionValue", values).execute();
					
				} else {
					logger.info("in modify"+leadDetails.getLeadId());
					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "modifyLeadData")
							.setParameter("actionValue", values).execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: restAddLeadDetails ends");

		return response;
	}
	
	// edit view  email
	
	
			@SuppressWarnings("unchecked")
			public JsonResponse<RestCrmLeadsModel> viewEmailDetails(String id1,String id2,String id3) {
				logger.info("Method : viewEmailDetails dao starts");

				RestCrmLeadsModel req = new RestCrmLeadsModel();
				JsonResponse<RestCrmLeadsModel> resp = new JsonResponse<RestCrmLeadsModel>();
				int ID=Integer.parseInt(id2);
				try {
					String value = "SET @p_leadId=\"" + id1 + "\", @p_Id=\"" + ID + "\",@p_tomail=\"" + id3 + "\";";
					logger.info("VALUESSS"+value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "viewEmailDetails").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {

						RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5], 
								m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11]);
						req = assignSkill;
					}
					resp.setBody(req);
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("Method : viewEmailDetails dao ends");
				return resp;
			}
		
	
	
	
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadData() {
		logger.info("Method : viewLeadData starts");
		List<RestCrmLeadsModel> respList = new ArrayList<RestCrmLeadsModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "getLeadDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestCrmLeadsModel restPayroll = new RestCrmLeadsModel(m[0], m[1], m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10].toString(),m[11],m[12],m[13]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		
		//resp.setMessage(err[1]);
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("response" + response);
		logger.info("Method : viewLeadData ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	
	
////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>editLeadInfo(String id) {
		logger.info("Method : editLeadInfo starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_leadId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "editLeadInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],
						m[11],m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26],m[27],null,null,null,null,m[28],null);
				
				
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : editLeadInfo ends");
	
		return response;
	}
	
	///viewLeadInfo
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>viewLeadInfo(String id) {
		logger.info("Method : viewLeadInfo starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_leadId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadDetailInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],
						m[11],m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26],m[27],null,null,null,null,m[29],null);
				
				
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewLeadInfo ends");
	
		return response;
	}
	
	
	//viewLeadNoteInfo
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>viewLeadNoteInfo(String id) {
		logger.info("Method : viewLeadNoteInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_leadId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadNoteInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],m[9],
						m[10].toString(),m[11],m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20],m[21],m[22],
						m[23],m[24],m[25],m[26],m[27],m[28],m[29],m[30],m[31],m[32]);
				
				
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewLeadNoteInfo ends");
	
		return response;
	}
	
	///viewLeadMailInfo
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>viewLeadMailInfo(String id) {
		logger.info("Method : viewLeadMailInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_leadId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadMailInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
							
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5], 
						m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11]);
				
				
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewLeadMailInfo ends");
	
		return response;
	}
	
	//viewLeadProductInfo
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmProductModel>>>viewLeadProductInfo(String id) {
		logger.info("Method : viewLeadProductInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmProductModel>> resp = new JsonResponse<List<RestCrmProductModel>>();
		List<RestCrmProductModel> rs = new ArrayList<RestCrmProductModel>();

		try {

			String value = "SET @p_id='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadProductInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
						m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
				
				
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmProductModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmProductModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewLeadProductInfo ends");
	
		return response;
	}
	
	//viewLeadCampaignInfo
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>>viewLeadCampaignInfo(String id) {
		logger.info("Method : viewLeadCampaignInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmCampaignModel>> resp = new JsonResponse<List<RestCrmCampaignModel>>();
		List<RestCrmCampaignModel> rs = new ArrayList<RestCrmCampaignModel>();

		try {

			String value = "SET @p_leadId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadCampaignInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
							
				RestCrmCampaignModel assignSkill = new RestCrmCampaignModel(m[0].toString(), m[1], m[2], m[3],
						m[4], m[5].toString(), m[6].toString(), m[7], m[8], m[9], m[10], m[11], m[12], m[13], null);
				 
				
				
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewLeadCampaignInfo ends");
	
		return response;
	}
	
	//viewLeadTaskInfo
	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>>viewLeadTaskInfo(String id) {
		logger.info("Method : viewLeadTaskInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmTaskModel>> resp = new JsonResponse<List<RestCrmTaskModel>>();
		List<RestCrmTaskModel> rs = new ArrayList<RestCrmTaskModel>();

		try {

			String value = "SET @p_leadId='" + id +"';";
			
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadTaskInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
							
				RestCrmTaskModel assignSkill = new RestCrmTaskModel(m[0].toString(), m[1], m[2], m[3],m[4].toString(),m[5],m[6],m[7],m[8],null,null,
						null,null, null, null, null,null,null);
				 
				
				
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmTaskModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewLeadCampaignInfo ends");
	
		return response;
	}
	
	
	//viewLeadCallInfo
	
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestCrmCallModel>>>viewLeadCallInfo(String id) {
			logger.info("Method : viewLeadCallInfo starts----------------------------");
			logger.info("call-----------------------------------------------------------------");
			JsonResponse<List<RestCrmCallModel>> resp = new JsonResponse<List<RestCrmCallModel>>();
			List<RestCrmCallModel> rs = new ArrayList<RestCrmCallModel>();

			try {

				String value = "SET @p_leadId='" + id +"';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "viewLeadCallInfo").setParameter("actionValue", value).getResultList();
				logger.info("asdfasdf"+x);
	           
				for (Object[] m : x) {
								
					
					RestCrmCallModel assignSkill = new RestCrmCallModel(m[0].toString(), m[1], m[2],m[3],m[4],m[5],m[6].toString(),m[7],m[8],m[9]);
					 
					
					
					rs.add(assignSkill);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setBody(rs);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<RestCrmCallModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCallModel>>>(resp,responseHeaders,
					HttpStatus.CREATED);

			logger.info("Method : viewLeadCallInfo ends");
		
			return response;
		}
		
	//viewLeadActivityInfo
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestCrmActivityModel>>>viewLeadActivityInfo(String id) {
			logger.info("Method : viewLeadActivityInfo starts----------------------------");
			logger.info("note-----------------------------------------------------------------");
			JsonResponse<List<RestCrmActivityModel>> resp = new JsonResponse<List<RestCrmActivityModel>>();
			List<RestCrmActivityModel> rs = new ArrayList<RestCrmActivityModel>();

			try {

				String value = "SET @p_id='" + id +"';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "viewLeadActivityInfo").setParameter("actionValue", value).getResultList();
				logger.info("asdfasdf"+x);
	           
				for (Object[] m : x) {
					
					String fromDate = null;
					if (m[11] != null) {
						fromDate = m[11].toString();
					}
							
					String todate = null;
					if (m[13] != null) {
						todate = m[13].toString();
					}
					
					String createdDate = null;
					if (m[17] != null) {
						createdDate = m[17].toString();
					}
								
					
					RestCrmActivityModel assignSkill = new RestCrmActivityModel(m[0].toString(), m[1], m[2],m[3],m[4],m[5],m[6],m[7],
							m[8],m[9],m[10],fromDate,m[12],todate,m[14],m[15],m[16],createdDate);
					
			/*		TLAM_Activity,TLAM_Activity_Lead,TLAM_Activity_Name,TLAM_Activity_Type,TLAM_Activity_Owner,TLAM_Activity_NoteTitle,
					 TLAM_Activity_NoteDesc,TLAM_Activity_TaskSubject,TLAM_Activity_MailSentTo,TLAM_Activity_Participant, 
					 
					 
					 TLAM_Activity_CallScheduleWith,TLAM_Activity_MeetingFromDate,TLAM_Activity_MeetingFromTime,TLAM_Activity_MeetingToDate,
					 TLAM_Activity_MeetingToTime,TLAM_Activity_CreatedTime,TLAM_Activity_CreatedBy,TLAM_Activity_CreatedOn
					 
					 public RestCrmActivityModel(Object activityId, Object leadId, Object activityName,Object activityType, Object leadOwner,
								Object noteTitle, Object noteDesc, Object mailSubject,Object mailSentTo, Object participant, 
								
								Object callScheduledWith, Object meetingFromDate, Object meetingFromTime, Object meetingToDate,Object meetingToTime,
								Object createdTime, Object createdBy,Object createdOn)*/
					 
					
					
					rs.add(assignSkill);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setBody(rs);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<RestCrmActivityModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmActivityModel>>>(resp,responseHeaders,
					HttpStatus.CREATED);

			logger.info("Method : viewLeadActivityInfo ends");
		
			return response;
		}	
		
	//viewLeadMeetingInfo
		
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>>viewLeadMeetingInfo(String id) {
		logger.info("Method : viewLeadMeetingInfo starts----------------------------");
		JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
		List<RestCrmMeetingModel> rs = new ArrayList<RestCrmMeetingModel>();

		try {
			String value = "SET @p_leadId='" + id +"';";
			logger.info("value for meeting id------------"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadMeetingInfo").setParameter("actionValue", value).getResultList();
			
           
			for (Object[] m : x) {
				
				String leadId = null;
				if (m[10] != null) {
					leadId = m[10].toString();
				}
							
				RestCrmMeetingModel assignSkill = new RestCrmMeetingModel(m[0].toString(), m[1], m[2],m[3],m[4],m[5].toString(),m[6],
						m[7].toString(),m[8],m[9],null,m[11]);
				 
				logger.info("data in dao------------"+assignSkill);
				
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewLeadMeetingInfo ends");
	
		return response;
	}
	
	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteDetails(String id) {
		logger.info("Method : deleteDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...."+id);
		if (validity)
			try {

				String value = "SET @p_leadId='" + id + "';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "deleteDetails").setParameter("actionValue", value).execute();

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

		logger.info("Method :  deleteDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}
	
	
	//saveleadtask(leadTask);
	
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadtask(
			List<RestCrmLeadsModel> leadTask) {
		logger.info("Method : addPurchaseOrder dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {
				
			

				String value2 = GenerateCrmLeadDetails.addleadtask(leadTask);
				logger.info("Value----------------"+value2);
				
				
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadTask")
				.setParameter("actionValue", value2).execute();

				
			}
		 catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : addLeadTask dao ends");
		return response;
	}
	//saveleadtags
	
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadtags(
			List<RestCrmLeadsModel> leadTags) {
		logger.info("Method : addPurchaseOrder dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {
				
			

				String value2 = GenerateCrmLeadDetails.addleadtags(leadTags);
				logger.info("Value----------------"+value2);
				
				
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadTags")
				.setParameter("actionValue", value2).execute();

				
			}
		 catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : addLeadTags dao ends");
		return response;
	}
	
	//saveleadMacro
	
	
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadMacro(
			List<RestCrmLeadsModel> leadMacro) {
		logger.info("Method : saveleadMacro dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {
				
			

				String value2 = GenerateCrmLeadDetails.addLeadMacro(leadMacro);
				logger.info("Value----------------"+value2);
				
				
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadMacro")
				.setParameter("actionValue", value2).execute();

				
			}
		 catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveleadMacro dao ends");
		return response;
	}
	
	
	
	////saveleadCampaign
	
	
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadCampaign(
			List<RestCrmLeadsModel> leadCampaign) {
		logger.info("Method : saveleadCampaign dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {
				
			

				String value2 = GenerateCrmLeadDetails.addLeadCampaign(leadCampaign);
				logger.info("Value----------------"+value2);
				
				
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadCampaign")
				.setParameter("actionValue", value2).execute();

				
			}
		 catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveleadCampaign dao ends");
		return response;
	}
	
	
	
	
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadmail(
			List<RestCrmLeadsModel> leadTask) {
		logger.info("Method : saveleadmail dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {
				
			

				String value2 = GenerateCrmLeadDetails.addleadmail(leadTask);
				logger.info("Value----------------"+value2);
				
				
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "saveleadmail")
				.setParameter("actionValue", value2).execute();

				
			}
		 catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveleadmail dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addItemRequisition(
			RestCrmTaskModel restItemRequisitonModel) {
		logger.info("Method : addItemRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = GenerateCrmLeadDetails.addleadmacro(restItemRequisitonModel);
			logger.info("values" + value);
			
				logger.info("in modify");
				em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "addMacroDetails").setParameter("actionValue", value).execute();
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
		logger.info("Method : add item Requisition ends");
		return response;
	}
	
	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> restAddMassUpdate(RestCrmLeadsModel leadDetails) {

		logger.info("Method in Dao: restAddMassUpdate starts"+leadDetails);

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
			try {
				if (leadDetails.getLeadId() =="" || leadDetails.getLeadId() ==null) {
			
					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadData")
							.setParameter("actionValue","" ).execute();
					
				} else {
					logger.info("in modify"+leadDetails.getLeadId());
					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "modifyLeadData")
							.setParameter("actionValue","").execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: restAddMassUpdate ends");

		return response;
	}

	
	///////////////////////////////////////////////////////////////////
	
	public ResponseEntity<JsonResponse<Object>> addNoteDoc(EmployeeDocumentModel employeeDocumentModel) {
		logger.info("Method : addNoteDoc starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = GenerateemployeemasterParameter.getLeadNoteDoc(employeeDocumentModel);
			logger.info("value for generate parameter------------"+value);
	

				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addNoteDoc")
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
		logger.info("Method : add item addNoteDoc ends");
		return response;
	}
	
	//convertToAccContDeal

	public JsonResponse<Object> convertToAccContDeal(RestCrmLeadsModel leadModel) {
		Boolean validity = true;
		logger.info("Method : convertToAccContDeal start");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateCrmLeadDetails.generateCrmLeadConvertParam(leadModel);
				logger.info("Values for lead converted----------------------"+values);
								
				//String dealCheck="";
				if (leadModel.getDealName()== null || leadModel.getDealName() == "") {
					logger.info("DealName if null============="+leadModel.getDealName());

					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "convertLead")
							.setParameter("actionValue", values).execute();

				}else {
					logger.info("Deal Name if not null============="+leadModel.getDealName());

					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "convertLeadWithDeal")
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

		logger.info("Method : convertToAccContDeal ends");
		return resp;
	}


	
	
//	viewProductDetailsView
	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmProductModel>>>viewProductDetailsView(String id,String id2,String pageType, String productCode) {
		logger.info("Method : viewProductDetailsView starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmProductModel>> resp = new JsonResponse<List<RestCrmProductModel>>();
		List<RestCrmProductModel> rs = new ArrayList<RestCrmProductModel>();

		try {
			

			logger.info("id2---------------------------------------------"+id2);
			String Yes="Yes";
			String value = "SET @p_id='" + id +"';";
			String value1 = "SET @p_id=\"" + id +  "\",@p_productId=\"" + productCode + "\";";
			String noProduct="";
			String pageLead="Lead";
			String pageContact="Contact";
			String pageAccount="Account";
			String pageDeal="Deal";
			
			if (id2.equals(Yes)) {
				
				if (productCode.equals(noProduct)) {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "viewPdctNotAsgn").setParameter("actionValue", value).getResultList();
					logger.info("asdfasdf"+x);
					
					for (Object[] m : x) {
						
						RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3],
								m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
								m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
						
						
						rs.add(assignSkill);
						
					}
					
				}else {
					
					if (pageLead.equals(pageType)) {
						logger.info("Leaddddddddddddddddddddddddddddddddddddddddddddddddddd");
						logger.info("value1----------------------------------------"+value1);
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
								.setParameter("actionType", "viewPdctNotAsgnL").setParameter("actionValue", value1).getResultList();
						for (Object[] m : x) {
							
							RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3],
									m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
									m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
							
							
							rs.add(assignSkill);
							
						}
						
					}
					
					if (pageContact.equals(pageType)) {
						logger.info("Contacttttttttttttttttttttttttttt");
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
								.setParameter("actionType", "viewPdctNotAsgnC").setParameter("actionValue", value1).getResultList();
							for (Object[] m : x) {
							
							RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3],
									m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
									m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
							
							
							rs.add(assignSkill);
							
						}
						
					}
					
					if (pageAccount.equals(pageType)) {
						logger.info("Accountttttttttttttttttttttttttt");
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
								.setParameter("actionType", "viewPdctNotAsgnA").setParameter("actionValue", value1).getResultList();
						for (Object[] m : x) {
							
							RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3],
									m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
									m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
							
							
							rs.add(assignSkill);
							
						}
						
					}
					
					if (pageDeal.equals(pageType)) {
						logger.info("Dealllllllllllllllllllllllllllllllllllllll");
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
								.setParameter("actionType", "viewPdctNotAsgnD").setParameter("actionValue", value1).getResultList();
					for (Object[] m : x) {
							
							RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3],
									m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
									m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
							
							
							rs.add(assignSkill);
							
						}
						
					}
					
					
					
					
				}
								
			}
			else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "viewProductDetails").setParameter("actionValue", value).getResultList();
				logger.info("asdfasdf"+x);
				
				for (Object[] m : x) {
					
					RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
							m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
					
					
					rs.add(assignSkill);
					
				}
				
			}
			
			//viewPdctNotAsgn
           
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmProductModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmProductModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewProductDetailsView ends");
	
		return response;
	}
	

	
	//saveCRMProductAdd
	

public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveCRMProductAdd(String id,
			List<RestCrmLeadsModel> leadTags) {
		logger.info("Method : saveCRMProductAdd dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {
				

				String value2 = GenerateCrmLeadDetails.addProductAssigned(leadTags);
				logger.info("Value----------------"+value2);
				
				
				
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "saveCRMProductAdd")
				.setParameter("actionValue", value2).execute();
				
				//String Lead="Lead";
			//	String Contact="Contact";
				//String Account="Account";
				//String Deal="Deal";
			/*	
			    String value = "SET  @p_productIds='(" + id + ")';";
				logger.info("PageType------------"+leadTags.get(0).getPageType());
				
				if (leadTags.get(0).getPageType().equals(Lead)) {
					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "productAssLead").setParameter("actionValue", value).execute();
					
				}
				
				if (leadTags.get(0).getPageType().equals(Contact)) {
					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "productAssContact").setParameter("actionValue", value).execute();
					
				}
				
				if (leadTags.get(0).getPageType().equals(Account)) {
					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "productAssAccount").setParameter("actionValue", value).execute();
					
				}
				
				if (leadTags.get(0).getPageType().equals(Deal)) {
					em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "productAssDeal").setParameter("actionValue", value).execute();
					
				}*/
			}
		 catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveCRMProductAdd dao ends");
		return response;
	}

   /* //getNameAutoSearchProduct
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchProduct(String id,String leadId,String assigRow) {
		logger.info("Method : getNameAutoSearchProduct starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		
		logger.info("search val--------------------------"+id);
		logger.info("search leadId--------------------------"+leadId);
		logger.info("search assigRow--------------------------"+assigRow);
	
		try {
			logger.info("VALUE"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getSearchProduct").setParameter("actionValue", value)
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
		logger.info("Method : getNameAutoSearchProduct ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}
*/

//viewProductSearchView(searchVal,leadId,assigRow);

@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<List<DropDownModel>>>viewProductSearchView(String searchVal,String id,String assigRow, String pageType) {
	logger.info("Method : viewProductSearchView starts----------------------------");
	logger.info("note-----------------------------------------------------------------");
	JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
	List<DropDownModel> rs = new ArrayList<DropDownModel>();

	try {
		
		logger.info("searchVal---------------------------------------------"+searchVal);
		logger.info("id---------------------------------------------"+id);
		logger.info("assigRow---------------------------------------------"+assigRow);
	//	String value = "SET  @p_searchValue='" + searchVal + "';";
		String value = "SET @p_id=\"" + id +  "\",@p_searchValue=\"" + searchVal + "\";";
		
		String Yes="Yes";
		String pageLeadType="Lead";
		String pageContactType="Contact";
		String pageAccountType="Account";
		String pageDealType="Deal";
		
		if (assigRow.equals(Yes)) {			
			if (pageLeadType.equals(pageType)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "getSrchPdctAssignL").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					rs.add(dropDownModel);
				}
				resp.setBody(rs);
			}
			
			if (pageContactType.equals(pageType)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "getSrchPdctAssignC").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					rs.add(dropDownModel);
				}
				resp.setBody(rs);
			}
			
			if (pageAccountType.equals(pageType)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "getSrchPdctAssignA").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					rs.add(dropDownModel);
				}
				resp.setBody(rs);
			}
			
			if (pageDealType.equals(pageType)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "getSrchPdctAssignD").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					rs.add(dropDownModel);
				}
				resp.setBody(rs);
			}
		}else {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getSearchProduct").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				rs.add(dropDownModel);
			}
			resp.setBody(rs);
			
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	resp.setBody(rs);
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.set("MyResponseHeader", "MyValue");

	ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(resp,responseHeaders,
			HttpStatus.CREATED);

	logger.info("Method : viewProductSearchView ends");
	return response;
}
		



}

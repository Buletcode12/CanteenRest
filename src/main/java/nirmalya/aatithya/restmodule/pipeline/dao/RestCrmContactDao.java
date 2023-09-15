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
import nirmalya.aatithya.restmodule.common.utils.GenerateContactParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateemployeemasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestCrmContactDao {
	Logger logger = LoggerFactory.getLogger(RestCrmContactDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to add pipeline
	 *
	 */

	public JsonResponse<Object> addContact(RestContactModel contact) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateContactParameter.getAddContactParam(contact);
				logger.info("Values----------------------" + values);
				if (contact.getPipelineId() == null || contact.getPipelineId() == "") {
					logger.info("add=============");

					em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "addContact")
							.setParameter("actionValue", values).execute();

				} else {
					logger.info("update=============");
					em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "modifyContact")
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

		logger.info("Method : addContact ends");
		return resp;
	}
	
	
////view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> viewContactSearchDetails(RestContactModel contactDetails) {

		logger.info("Method in Dao: viewLeadSearchDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		// JsonResponse<Object> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestContactModel> rs = new ArrayList<RestContactModel>();
		try {
			String values = GenerateContactParameter.getContactParam(contactDetails);
			logger.info(values);

			String actionType = null;
			String actionValue = null;


			if(values != null && values != "") {
				actionType = "getContactDetailsBySearch";
				actionValue = values;
			} else {
				actionType = "getContactDetails";
				actionValue = "";
			}

			logger.info("Action Type====" + actionType);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", actionType).setParameter("actionValue", actionValue).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {
				
				Object birthDate = null;
				if (m[13] != null) {
					birthDate = m[13].toString();
				}
				logger.info("VIEWWWWWWWWWWWW");
				RestContactModel reqEdit = new RestContactModel(null,m[0], m[1], m[2], m[3],null, m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], birthDate,m[14],m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],m[32].toString(),
						m[33],m[34],null,null);
				logger.info("VIEWWDATA" + reqEdit);

				rs.add(reqEdit);

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

	

	/*
	 * View Pipeline
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestContactModel>> viewAllContact() {

		logger.info("Method in Dao: viewAllContactDao starts");

		List<RestContactModel> pipeline = new ArrayList<RestContactModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewAllContact").setParameter("actionValue", "").getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object createdDate = null;
//					if (m[32] != null) {
//						createdDate = DateFormatter.returnStringDate(m[32]);
//					}

					RestContactModel crmContactModel = new RestContactModel(m[0], m[1], null, m[2], null, null, m[3],
							null, m[4], null, m[5], null, null, null, null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, m[6].toString(),m[7],
							m[8],null,null);

					pipeline.add(crmContactModel);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestContactModel>> resp = new JsonResponse<List<RestContactModel>>();
		resp.setBody(pipeline);

		logger.info("Method in Dao: viewAllPipelinesDao ends");
		// logger.info("fgfghjhfh "+resp);
		return resp;
	}

	// RestContactModel

	/*
	 * Edit Pipeline
	 *
	 *
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<RestContactModel> editContact(String id) {
		logger.info("Method : editContact starts");

		RestContactModel req = new RestContactModel();
		JsonResponse<RestContactModel> resp = new JsonResponse<RestContactModel>();

		try {

			String value = "SET @p_contactId='" + id + "';";
			logger.info("value------------" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewEditContact").setParameter("actionValue", value).getResultList();
			logger.info(id);

			for (Object[] m : x) {
				Object createdDate = null;
				if (m[34] != null) {
					createdDate = m[34].toString();
				}

				Object birthDate = null;
				if (m[15] != null) {
					birthDate = m[15].toString();
				}
				RestContactModel reqEdit = new RestContactModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], birthDate, m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33],
						createdDate,null,null,m[35],null);

				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editContact ends");
		logger.info("EDITTTTT=======" + resp);
		return resp;
	}

	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<RestContactModel> viewContact(String id) {
		logger.info("Method : viewContact starts");

		RestContactModel req = new RestContactModel();
		JsonResponse<RestContactModel> resp = new JsonResponse<RestContactModel>();

		try {

			String value = "SET @p_contactId='" + id + "';";
			logger.info("value------------" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactDetails").setParameter("actionValue", value)
					.getResultList();
			logger.info(id);

			for (Object[] m : x) {
				Object createdDate = null;
				if (m[34] != null) {
					createdDate = m[34].toString();
				}

				Object birthDate = null;
				if (m[15] != null) {
					birthDate = m[15].toString();
				}
				RestContactModel reqEdit = new RestContactModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], birthDate, m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33], createdDate,
						null,null,null,m[35],null);

				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method :  ends");
		logger.info("VIEWWWWW=======" + resp);
		return resp;
	}

	// getOwnerList

	/**
	 * for getOwnerList
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOwnerList() {

		logger.info("Method : getOwnerList starts");

		List<DropDownModel> ownerList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "getOwnerList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ownerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOwnerList ends" + ownerList);

		return ownerList;
	}

	// getLeadSourceList

	/**
	 * for getOwnerList
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadSourceList() {

		logger.info("Method : getOwnerList starts");

		List<DropDownModel> leadSourceList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "getLeadSourceList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				leadSourceList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOwnerList ends" + leadSourceList);

		return leadSourceList;
	}

	// deleteContactDetails

	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteContactDetails(String id) {
		logger.info("Method : deleteContactDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...." + id);
		if (validity)
			try {

				// String value = "SET @p_taskId='" + id + "';";
				// String value = "SET @p_contactId='(" + id + ")';";
				String value = "SET @p_contactId='" + id + "';";
				logger.info(value);
				em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "deleteContactDetails")
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

		logger.info("Method :  deleteContactDetails ends");
		logger.info("DELETE" + response);
		return response;
	}

	/*
	 * cust getAccountNameAutoSearchNewList
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getAccountNameAutoSearchNewList(String id) {
		logger.info("Method : getAccountNameAutoSearchNewList starts");

		List<RestSaleOrderNewModel> itemNameList = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		logger.info("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "getAccountSearchList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getAccountNameAutoSearchNewList ends");
		return response;
	}

	// viewLeadTaskInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> viewContactTaskInfo(String id) {
		logger.info("Method : viewContactTaskInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmTaskModel>> resp = new JsonResponse<List<RestCrmTaskModel>>();
		List<RestCrmTaskModel> rs = new ArrayList<RestCrmTaskModel>();

		try {

			String value = "SET @p_contactId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactTaskInfo").setParameter("actionValue", value)
					.getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmTaskModel assignSkill = new RestCrmTaskModel(m[0].toString(), m[1], m[2], m[3], m[4].toString(),
						m[5], m[6], m[7], m[8], null, null, null, null, null, null, null, null, null);


				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmTaskModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewContactTaskInfo ends");
		return response;
	}

	// viewLeadCallInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> viewContactCallInfo(String id) {
		logger.info("Method : viewContactCallInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmCallModel>> resp = new JsonResponse<List<RestCrmCallModel>>();
		List<RestCrmCallModel> rs = new ArrayList<RestCrmCallModel>();

		try {

			String value = "SET @p_contactId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactCallInfo").setParameter("actionValue", value)
					.getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmCallModel assignSkill = new RestCrmCallModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5],
						m[6].toString(), m[7], m[8], m[9]);


				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmCallModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCallModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewContactCallInfo ends");
		return response;
	}

	// viewLeadMeetingInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> viewContactMeetingInfo(String id) {
		logger.info("Method : viewLeadMeetingInfo starts----------------------------");
		JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
		List<RestCrmMeetingModel> rs = new ArrayList<RestCrmMeetingModel>();

		try {

			String value = "SET @p_contactId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactMeetingInfo").setParameter("actionValue", value)
					.getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmMeetingModel assignSkill = new RestCrmMeetingModel(m[0].toString(), m[1], m[2], m[3], m[4],
						m[5].toString(), m[6], m[7].toString(), m[8], m[9], m[10], m[11]);


				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewContactMeetingInfo ends");
		return response;
	}

	// viewLeadCampaignInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> viewContactCampaignInfo(String id) {
		logger.info("Method : viewContactCampaignInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmCampaignModel>> resp = new JsonResponse<List<RestCrmCampaignModel>>();
		List<RestCrmCampaignModel> rs = new ArrayList<RestCrmCampaignModel>();

		try {

			String value = "SET @p_contactId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactCampaignInfo").setParameter("actionValue", value)
					.getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmCampaignModel assignSkill = new RestCrmCampaignModel(m[0].toString(), m[1], m[2], m[3], m[4],
						m[5].toString(), m[6].toString(), m[7], m[8], m[9], m[10], m[11], m[12], m[13], null);


				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewContactCampaignInfo ends");
		return response;
	}

///////////////////////////////////////////////////////////////////

	public ResponseEntity<JsonResponse<Object>> addContactEmailDoc(EmployeeDocumentModel employeeDocumentModel) {
		logger.info("Method : addNoteDoc starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = GenerateemployeemasterParameter.addContactMailDtls(employeeDocumentModel);
			logger.info("value for generate parameter------------" + value);

				em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "addContactEmailDoc")
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
		logger.info("Method : add item addContactEmailDoc ends");
		return response;
	}

}

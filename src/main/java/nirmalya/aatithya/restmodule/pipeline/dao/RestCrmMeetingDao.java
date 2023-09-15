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
import nirmalya.aatithya.restmodule.common.utils.GenerateMeetingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;

@Repository
public class RestCrmMeetingDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
		
	//addTask
	
	/**
	 * DAO Function to addMeeting
	 *
	 */

	public JsonResponse<Object> addMeeting(RestCrmMeetingModel task) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateMeetingParameter.getMeetingParam(task);
				logger.info("Values for add Meeting----------------------"+values);
				if (task.getMeetingId() == null || task.getMeetingId() == "") {
					logger.info("add============="+task.getMeetingId());
					String meetingTypeContact="Contact";
					String meetingTypeLead="Lead";
					String pageTypeAccount="Account";
					String pageTypeMeeting="Meeting";
					String pageTypeDeal="Deal";
					
					String pageTypeQuote="Quote";
					String pageTypeSO="SalesOrder";
					String pageTypePO="PurchaseOrder";
					String pageTypeInvoice="Invoice";
					
					String meetingType=task.getMeetingType();
					
					if(meetingType.equals(pageTypeQuote)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeetingQuote")
						.setParameter("actionValue", values).execute();
					}
					
					if(meetingType.equals(pageTypeSO)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeetingSO")
						.setParameter("actionValue", values).execute();
					}
					
					if(meetingType.equals(pageTypePO)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeetingPO")
						.setParameter("actionValue", values).execute();
					}
					
					if(meetingType.equals(pageTypeInvoice)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeetingInvoice")
						.setParameter("actionValue", values).execute();
					}
					
					if(meetingType.equals(meetingTypeLead)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeetingLeadPage")
						.setParameter("actionValue", values).execute();
					}
					
					if(meetingType.equals(meetingTypeContact)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeetingContactPage")
						.setParameter("actionValue", values).execute();
					}
					
					if(meetingType.equals(pageTypeAccount)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeetingAccountPage")
						.setParameter("actionValue", values).execute();
					}
					
					if(meetingType.equals(pageTypeDeal)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeetingDealPage")
						.setParameter("actionValue", values).execute();
					}
					
					if(meetingType.equals(pageTypeMeeting)) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "addMeeting")
						.setParameter("actionValue", values).execute();
					}
					
					

				} else {
					logger.info("update============="+task.getMeetingId());
					em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "modifyMeeting")
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

		logger.info("Method : addMeeting ends");
		return resp;
	}
	
	
	///restViewTaskdetails
	


////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> restViewMeetingDetails() {
		logger.info("Method : restViewMeetingDetails starts");
		List<RestCrmMeetingModel> respList = new ArrayList<RestCrmMeetingModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "getMeetingDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
	

				RestCrmMeetingModel restPayroll = new RestCrmMeetingModel(m[0].toString(), m[1], m[2],m[3],m[4],m[5].toString(),m[6].toString(),
						m[7].toString(),m[8],m[9],m[10],m[11],m[12].toString(),m[13],m[14],m[15].toString(),
						m[16],m[17].toString(),m[18],m[19].toString(),null,null,null,m[20],null,m[21],null);
				respList.add(restPayroll);

			}

			logger.info("VIEW response-----------------------" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>>(
				resp, HttpStatus.CREATED);
		//logger.info("response meeting--------" + response);
		logger.info("Method : restViewMeetingDetails ends");

		//logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	//getLeadNameList

	///editAccountInfo   
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>>editMeetingInfo(String id) {
			logger.info("Method : editMeetingInfo starts");

			JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
			List<RestCrmMeetingModel> rs = new ArrayList<RestCrmMeetingModel>();

			try {

				String value = "SET @p_meetingId='" + id +"';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_meeting")
						.setParameter("actionType", "editMeetingInfo").setParameter("actionValue", value).getResultList();
				logger.info("asdfasdf"+x);
	           
				for (Object[] m : x) {
					RestCrmMeetingModel assignSkill = new RestCrmMeetingModel(m[0].toString(), m[1], m[2],m[3],m[4],m[5].toString(),m[6],
							m[7].toString(),m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15].toString(),
							m[16],m[17].toString(),m[18],m[19].toString(),m[20],m[21],m[22],m[23],m[24],m[25],m[26]);
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

			logger.info("Method : editMeetingInfo ends");
			return response;
		}

	//deleteTaskDetails
		
		/*
		 * delete
		 */

		public ResponseEntity<JsonResponse<Object>> deleteMeetingDetails(String id) {
			logger.info("Method : deleteMeetingDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			logger.info("ID...."+id);
			if (validity)
				try {

					//String value = "SET @p_taskId='" + id + "';";
					String value = "SET  @p_meetingId='(" + id + ")';";
					logger.info(value);

					em.createNamedStoredProcedureQuery("crm_meeting")
							.setParameter("actionType", "deleteMeetingDetails").setParameter("actionValue", value).execute();

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

			logger.info("Method :  deleteMeetingDetails ends");
			logger.info("DELETE" + response);
			return response;
		}
		

}

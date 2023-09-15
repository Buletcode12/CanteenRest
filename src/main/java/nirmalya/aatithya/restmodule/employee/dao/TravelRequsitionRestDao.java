package nirmalya.aatithya.restmodule.employee.dao;

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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateTravelManagementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class TravelRequsitionRestDao {

	Logger logger = LoggerFactory.getLogger(TravelRequsitionRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	PushNotification pushNotification = new PushNotification();
	 
	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelRequisitionRestModel>> viewTravelRequisition(String userId, String userRole,String organization,String orgDivision) {
		logger.info("Method : viewTravelRequisition dao starts");
		JsonResponse<List<TravelRequisitionRestModel>> resp = new JsonResponse<List<TravelRequisitionRestModel>>();
		List<TravelRequisitionRestModel> viewTravelRequisition = new ArrayList<TravelRequisitionRestModel>();
		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")',@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
					.setParameter("actionType", "viewTravel").setParameter("actionValue", value).getResultList();
			if(x.size()>0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success,ApiResponseMessage.DATA_FETCH_SUCCESS);
			}else {
				Util.setJsonResponse(resp, x, ResponseStatus.success,ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				Object Date = null;
				if (m[8] != null) {
					Date  = DateFormatter.returnStringDate(m[8]);
				}
				Object cDate = null;
				if (m[12] != null) {
					cDate  = DateFormatter.returnStringDate(m[12]);
				}
				TravelRequisitionRestModel travelModel = new TravelRequisitionRestModel(m[0], m[1], m[2], m[3], m[4].toString(),m[5],
						m[6].toString(), sDate, Date, m[9],m[10], m[11],cDate,m[13]);
				viewTravelRequisition.add(travelModel);
			}

			if (viewTravelRequisition.size() > 0) {
				resp.setBody(viewTravelRequisition);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(viewTravelRequisition);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed,ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewReimbursement: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewTravelRequisition);
			resp.setCode("success");
			resp.setMessage(e.getMessage());
		}
		
		resp.setBody(viewTravelRequisition);
		logger.info("Method : viewTravelRequisition Dao ends");
		logger.info("VIEW"+resp);
		return resp;
	}

	
	//add travel
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> addTravel(
			List<TravelRequisitionRestModel> travelModel) {
		logger.info("Method : addTravel dao starts");
		JsonResponse<List<TravelRequisitionRestModel>> resp = new JsonResponse<List<TravelRequisitionRestModel>>();
	
		String value = GenerateTravelManagementParam.getTravelRequisitionParam(travelModel);
logger.info("value==="+value);
		try {
			if (travelModel.get(0).getTravelingReqId() != null && travelModel.get(0).getTravelingReqId() != "") {
				List<Object[]> x=entityManager.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "modifyTravel").setParameter("actionValue", value).getResultList();
 
				 if(x.get(0)[0].toString()==null || x.get(0)[0].toString()=="" 
						 || x.get(0)[0].toString().equals(null) || x.get(0)[0].toString().equals("") ) {
							resp.setCode("success");
							resp.setMessage("Data Modified successfully");
						}else {
							resp.setCode("failed");
							resp.setMessage("You have already applied travel for this date. Please choose a different date.");
						}
				
			} else {

				List<Object[]> x=entityManager.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "addTravel").setParameter("actionValue", value).getResultList();
				 if(x.get(0)[0].toString()==null || x.get(0)[0].toString()=="" 
						 || x.get(0)[0].toString().equals(null) || x.get(0)[0].toString().equals("") ) {
							resp.setCode("success");
							resp.setMessage("Data saved successfully");
							
							List<DropDownModel> managerByUesr = checkDuplicateDao.getManagerByUser(travelModel.get(0).getCreatedBy());
							 
							for(DropDownModel m : managerByUesr) {
								String msg=m.getName()+" apply for Travel";
								try {
									String msgId = pushNotification.pushFCMNotification(m.getKey(),msg);
									
								} catch (Exception e) {
									e.printStackTrace(); 
								}
							}
						}else {
							resp.setCode("failed");
							resp.setMessage("You have already applied travel for this date. Please choose a different date.");
						}

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed,err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		
		ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> response = new ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response==="+response);
		logger.info("Method : addTravel dao ends");
		return response;
		
	}
	
	
	//edit travel
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> getTravelEdit(String id) {
		logger.info("Method : getTravelEdit starts");
		List<TravelRequisitionRestModel> getScheduleTypeList = new ArrayList<TravelRequisitionRestModel>();
		JsonResponse<List<TravelRequisitionRestModel>> resp = new JsonResponse<List<TravelRequisitionRestModel>>();
		try {
			String values = "SET @P_ser='" + id + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("travelRequisitionRoutines")
					.setParameter("actionType", "getTravelEdit").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object fromDate = null;
				if (m[5] != null) {
					fromDate = DateFormatter.returnStringDate(m[5]);
				}
				Object toDate = null;
				if (m[6] != null) {
					toDate = DateFormatter.returnStringDate(m[6]);
				}
				Object sDate = null;
				if (m[9] != null) {
					sDate = DateFormatter.returnStringDate(m[9]);
				}

				String as = null;
				if (m[7] != null) {
					as = m[7].toString();
				}

				if (as.equals("0")) {
					TravelRequisitionRestModel dropDownModel = new TravelRequisitionRestModel(m[0], null, m[1], m[2], m[3].toString(),
							m[4], null, fromDate, toDate, null, null, null, null, null, null, null, null, null);
					getScheduleTypeList.add(dropDownModel);

				} else {
					TravelRequisitionRestModel dropDownModel = new TravelRequisitionRestModel(m[0], null, m[1], m[2], m[3].toString(),
							m[4], null, fromDate, toDate, m[7], m[8], sDate, m[10], m[11], null, null, null, null);
					getScheduleTypeList.add(dropDownModel);

				}
			if (getScheduleTypeList.size()>0) {
				Util.setJsonResponse(resp, getScheduleTypeList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			}else {
				Util.setJsonResponse(resp, getScheduleTypeList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
			}
			
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> response = new ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("getTravelEdit==="+response);
		logger.info("Method : getTravelEdit ends");

		return response;
	}
	
	
	//delete travel
 
	
	public ResponseEntity<JsonResponse<Object>> deleteTravel(TravelRequisitionRestModel travelModel) {
		logger.info("Method : deleteTravel dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateTravelManagementParam.getDeleteParam(travelModel);

			entityManager.createNamedStoredProcedureQuery("travelRequisitionRoutines")
					.setParameter("actionType", "deleteTravel").setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success,ApiResponseMessage.DELETE_DATA);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed,ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteTravel dao ends" + response);

		return response;
	}
	
	
	//approve Travel Requisition
	
	public JsonResponse<TravelRequisitionRestModel> approveRequisition(String id,String name,String comment,String roleid) {
		logger.info("Method : approveRequisition starts");

		TravelRequisitionRestModel req = new TravelRequisitionRestModel();
		JsonResponse<TravelRequisitionRestModel> resp = new JsonResponse<TravelRequisitionRestModel>();

		try {

			String value = "SET @p_requisitionId='" + id + "',@p_approveBy='"+name+"',@p_comment='"+comment+"',@p_userRole='(" + roleid + ")';";
			
			logger.info("value==="+value);
			em.createNamedStoredProcedureQuery("travelRequisitionRoutines").setParameter("actionType", "approveRequisition")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Travel approved successfully");
			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id,name);
			for(DropDownModel m : managerByUesr) {
				String msg=m.getName()+" approved your Travel";
				try {
					String msgId = pushNotification.pushFCMNotification(m.getKey(),msg);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if(err[1].equals("Duplicate entry 'x' for  'tbl_approval_history.PRIMARY'")) {
					resp.setCode("failed");
					resp.setMessage("You are already travel approved");
				}else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				}
				// resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			logger.error("approveRequisition: "+e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : approveRequisition ends");
		return resp;
	}
	
	//reject Requisition
	
		public JsonResponse<TravelRequisitionRestModel> rejectRequisition(String id,String name,String comment,String roleid) {
			logger.info("Method : rejectRequisition starts");

			TravelRequisitionRestModel req = new TravelRequisitionRestModel();
			JsonResponse<TravelRequisitionRestModel> resp = new JsonResponse<TravelRequisitionRestModel>();

			try {

				String value = "SET @p_requisitionId='" + id + "',@p_rejectBy='"+name+"',@p_comment='"+comment+"',@p_userRole='(" + roleid + ")';";
				
				em.createNamedStoredProcedureQuery("travelRequisitionRoutines").setParameter("actionType", "rejectRequisition")
						.setParameter("actionValue", value).execute();
				resp.setBody(req);
				resp.setCode("success");
				resp.setMessage("Travel rejected successfully");
				List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id,name);
				for(DropDownModel m : managerByUesr) {
					String msg=m.getName()+" rejected your Travel";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(),msg);
					} catch (Exception e) {
						e.printStackTrace(); 
					}
				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					if(err[1].equals("Duplicate entry 'x' for  'tbl_approval_history.PRIMARY'")) {
						resp.setCode("failed");
						resp.setMessage("You are already travel rejected");
					}else {
						resp.setCode("failed");
						resp.setMessage("Something went wrong");
					}
					// resp.setMessage(err[1]);
				} catch (Exception e1) {
					resp.setCode("failed");
					e1.printStackTrace();
					resp.setMessage("Something went wrong");
				}
				logger.error("rejectRequisition: "+e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : rejectRequisition ends");
			return resp;
		}
		//view travel api
		@SuppressWarnings("unchecked")
		public JsonResponse<List<TravelRequisitionRestModel>> viewTravelRequisitionApi(String userId,String organization,String orgDivision) {
			logger.info("Method : viewTravelRequisition dao starts");
			JsonResponse<List<TravelRequisitionRestModel>> resp = new JsonResponse<List<TravelRequisitionRestModel>>();
			List<TravelRequisitionRestModel> viewTravelRequisition = new ArrayList<TravelRequisitionRestModel>();
			try {
				String value = "SET @p_empId=\"" + userId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\";";
				logger.info("value==="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "viewTravelApi").setParameter("actionValue", value).getResultList();
				if(x.size()>0) {
					Util.setJsonResponse(resp, x, ResponseStatus.success,ApiResponseMessage.DATA_FETCH_SUCCESS);
				}else {
					Util.setJsonResponse(resp, x, ResponseStatus.success,ApiResponseMessage.NO_DATA_FOUND);
				}
				for (Object[] m : x) {
					Object sDate = null;
					if (m[7] != null) {
						sDate = DateFormatter.returnStringDate(m[7]);
					}
					Object Date = null;
					if (m[8] != null) {
						Date  = DateFormatter.returnStringDate(m[8]);
					}
					Object cDate = null;
					if (m[12] != null) {
						cDate  = DateFormatter.returnStringDate(m[12]);
					}
					TravelRequisitionRestModel travelModel = new TravelRequisitionRestModel(m[0], m[1], m[2], m[3], m[4].toString(),m[5],
							m[6].toString(), sDate, Date, m[9],m[10], m[11],cDate,m[13]);
					viewTravelRequisition.add(travelModel);
				}

				if (viewTravelRequisition.size() > 0) {
					resp.setBody(viewTravelRequisition);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setBody(viewTravelRequisition);
					resp.setCode("success");
					resp.setMessage("Data not found");
				}
			} catch (Exception e) {
				Util.setJsonResponse(resp, null, ResponseStatus.failed,ApiResponseMessage.UNKNOWN_EXCEPTION);
				logger.error("viewReimbursement: " + e.getMessage());
				e.printStackTrace();
				resp.setBody(viewTravelRequisition);
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
			
			resp.setBody(viewTravelRequisition);
			logger.info("Method : viewTravelRequisitionApi Dao ends");
			logger.info("VIEW"+resp);
			return resp;
		}
}

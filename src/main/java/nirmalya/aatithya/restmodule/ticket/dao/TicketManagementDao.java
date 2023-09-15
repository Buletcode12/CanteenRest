package nirmalya.aatithya.restmodule.ticket.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketAddManagementParm;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;


@Repository
public class TicketManagementDao {
	Logger logger = LoggerFactory.getLogger(TicketManagementDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	// Ticket Type List.

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTicketTypeList(String org, String orgDiv) {
		logger.info("Method : getTicketTypeList starts");

		List<DropDownModel> getTicketTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getTicketTypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTicketTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTicketTypeList ends");
		return getTicketTypeList;
	}

	// Ticket Priority List.

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPriorityList(String org, String orgDiv) {
		logger.info("Method : getPriorityList starts");

		List<DropDownModel> getPriorityList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPriorityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPriorityList ends");
		return getPriorityList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getEmpListDao(String organization, String orgDivision, String userId) {
		logger.info("Method : getEmpListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
		logger.info(value + "valuessssssssssss");

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "viewEmpList").setParameter("actionValue", value).getResultList();

			resp.setBody(x);

			logger.error("respppp: " + resp.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getEmpListDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getEmpListDao ends");
		return resp;
	}

	// Add Ticket.

	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveTicketDtls(
			List<TicketManagementRestModel> category) {
		logger.info("Method : saveTicketDtls starts");

		Boolean validity = true;
		JsonResponse<TicketManagementRestModel> resp = new JsonResponse<TicketManagementRestModel>();
		resp.setMessage("");
		resp.setCode("");
		
		String values = GenerateTicketAddManagementParm.saveTicketDetails(category);
		System.out.println("values>>>>-------" + values);

		if (validity)
			try {
				
				if(category.get(0).getTicketId() != null && category.get(0).getTicketId() != "") {
					System.out.println("Ok Edit>>>>-------" + category.get(0).getTicketId());
					em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "modifyTicketDtls").setParameter("actionValue", values).execute();
					
				}else {
					
					em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "addTicketDtls").setParameter("actionValue", values).execute();
					
				}

				

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
		ResponseEntity<JsonResponse<TicketManagementRestModel>> response = new ResponseEntity<JsonResponse<TicketManagementRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveTicketDtls ends");
		return response;
	}
	
	// View Ticket.
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTicketData(String orgName, String orgDivision) {
		logger.info("Method : viewTicketData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "viewTicketData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewTicketData Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	// Edit Ticket.
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editTicket(String id, String orgName, String orgDivision) {
		logger.info("Method : editTicket Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_ticketId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "editTicket").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editTicket Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}
	
	// delete Ticket.
	
	public ResponseEntity<JsonResponse<Object>> deleteTicket(String id, String userId, String orgName,
			String orgDivision) {
		logger.info("Method : deleteTicket dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_ticketId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("value==" + value);
			em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "deleteTicket").setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("Deleted");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteTicket dao ends");
		return response;
	}

}

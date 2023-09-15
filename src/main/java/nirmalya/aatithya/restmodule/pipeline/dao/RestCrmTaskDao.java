package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateTaskParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;


import org.springframework.http.HttpHeaders;

@Repository
public class RestCrmTaskDao {
	
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

	public JsonResponse<Object> addTask(RestCrmTaskModel task) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateTaskParameter.getAddTasklParam(task);
				logger.info("Values for add task----------------------"+values);
				if (task.getTaskId() == null || task.getTaskId() == "") {
					logger.info("add============="+task.getTaskId());				
					String pageTypeContact="Contact";
					String pageTypeLead="Lead";
					String pageTypeAccount="Account";
					String pageTypeDeal="Deal";
					String pageTypeTask="Task";
					
					String pageTypeQuote="Quote";
					String pageTypeSO="SalesOrder";
					String pageTypePO="PurchaseOrder";
					String pageTypeInvoice="Invoice";
					
					String pageType=task.getPageType();
					
					if(pageType.equals(pageTypeInvoice)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTaskInvoice")
						.setParameter("actionValue", values).execute();
					}
					
					if(pageType.equals(pageTypePO)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTaskPO")
						.setParameter("actionValue", values).execute();
					}
					
					
					if(pageType.equals(pageTypeSO)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTaskSO")
						.setParameter("actionValue", values).execute();
					}
					
					if(pageType.equals(pageTypeQuote)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTaskQuote")
						.setParameter("actionValue", values).execute();
					}
					
					if(pageType.equals(pageTypeLead)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTaskLead")
						.setParameter("actionValue", values).execute();
					}
					
					if(pageType.equals(pageTypeContact)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTaskContact")
						.setParameter("actionValue", values).execute();
					}
					
					if(pageType.equals(pageTypeAccount)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTaskAccount")
						.setParameter("actionValue", values).execute();
					}
					
					if(pageType.equals(pageTypeDeal)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTaskDeal")
						.setParameter("actionValue", values).execute();
					}
					
					if(pageType.equals(pageTypeTask)) {
						em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "addTask")
						.setParameter("actionValue", values).execute();
					}

				} else {
					logger.info("update============="+task.getTaskId());
					em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "modifyTask")
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
		
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method : addTask ends");
		return resp;
	}
	
	
	///restViewTaskdetails
	


////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> restViewTaskdetails() {
		logger.info("Method : viewLeadData starts");
		List<RestCrmTaskModel> respList = new ArrayList<RestCrmTaskModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_task").setParameter("actionType", "getTaskDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
	

				RestCrmTaskModel restPayroll = new RestCrmTaskModel(m[0].toString(), m[1], m[2],m[3],m[4].toString(),null,null,m[7],m[8],null,null,
						null,null,null,null,null,m[5],null);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmTaskModel>> resp = new JsonResponse<List<RestCrmTaskModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmTaskModel>>>(
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
	@SuppressWarnings("unchecked")
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
	}
	
	//editTaskInfo
	
	///editAccountInfo   
	
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>>editTaskInfo(String id) {
				logger.info("Method : editTaskInfo starts");

				JsonResponse<List<RestCrmTaskModel>> resp = new JsonResponse<List<RestCrmTaskModel>>();
				List<RestCrmTaskModel> rs = new ArrayList<RestCrmTaskModel>();

				try {

					String value = "SET @p_taskId='" + id +"';";
					logger.info(value);

					List<Object[]> x = em.createNamedStoredProcedureQuery("crm_task")
							.setParameter("actionType", "editTaskInfo").setParameter("actionValue", value).getResultList();
					logger.info("asdfasdf"+x);
		           
					for (Object[] m : x) {
						RestCrmTaskModel assignSkill = new RestCrmTaskModel(m[0].toString(), m[1], m[2], m[3],m[4].toString(),m[5],m[6],m[7],m[8],m[9],m[10].toString(),
								m[11].toString(),m[12], m[13], m[14], m[15].toString(),m[16],m[17]);
						
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

				logger.info("Method : editTaskInfo ends");
				return response;
			}

	//deleteTaskDetails
		
		/*
		 * delete
		 */

		public ResponseEntity<JsonResponse<Object>> deleteTaskDetails(String id) {
			logger.info("Method : deleteTaskDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			logger.info("ID...."+id);
			if (validity)
				try {

					//String value = "SET @p_taskId='" + id + "';";
					String value = "SET  @p_taskId='(" + id + ")';";
					logger.info(value);

					em.createNamedStoredProcedureQuery("crm_task")
							.setParameter("actionType", "deleteTaskDetails").setParameter("actionValue", value).execute();

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

			logger.info("Method :  deleteTaskDetails ends");
			logger.info("DELETE" + response);
			return response;
		}
		

}

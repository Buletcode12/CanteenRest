package nirmalya.aatithya.restmodule.EDMS.dao;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;

import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.EDMS.model.RestWorkSpaceModel;
import nirmalya.aatithya.restmodule.common.ServerDao;

@Repository
public class RestWorkspaceDao {
	Logger logger = LoggerFactory.getLogger(RestWorkspaceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> fileAccessType() {
		logger.info("Method : fileAccessType Dao starts");

		List<DropDownModel> CatogaryList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "fileAccessType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				logger.info(dropDownModel.toString());
				CatogaryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : fileAccessType Dao ends" + CatogaryList);
		return CatogaryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> fileOperationType() {
		logger.info("Method : fileOperationType Dao starts");

		List<DropDownModel> CatogaryList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "fileOperationType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				logger.info(dropDownModel.toString());
				CatogaryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : fileOperationType Dao ends" + CatogaryList);
		return CatogaryList;
	}

	public ResponseEntity<JsonResponse<Object>> saveWorkspaceModel(RestWorkSpaceModel empDetaails) {
		logger.info("Method : saveWorkspaceModel dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		List<RestWorkSpaceModel> listData = new ArrayList<RestWorkSpaceModel>();

		System.out.println("emloyee details===>>" + empDetaails);
		try {
			/*
			 * String values = GenerateWorkSpaceParam.getWorkspaceParam(empDetaails);
			 * System.out.println("event details===>>" + values); if
			 * (empDetaails.getWorkspaceId() == null || empDetaails.getWorkspaceId() == "")
			 * {
			 * 
			 * System.out.println("values IN ADD" + values);
			 * em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter(
			 * "actionType", "addWorkSpace") .setParameter("actionValue", values).execute();
			 * 
			 * } else {
			 * 
			 * System.out.println("values in modify");
			 * em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter(
			 * "actionType", "modifyDetails") .setParameter("actionValue",
			 * values).execute();
			 * 
			 * }
			 */
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveWorkspaceModel dao ends");
		System.out.println("response====" + resp);
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWorkSpace(String userId, String orgName, String orgDiv) {
		logger.info("Method : viewWorkSpace Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "viewWorkspace").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewWorkSpace Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editWorkSpace(String workSpaceId,String userId, String orgName, String orgDiv) {
		logger.info("Method : editWorkSpace Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_workId='"+workSpaceId+"' ,@p_userId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "editWorkSpace").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editWorkSpace Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> deleteWorksapce(String workSpaceId) {
		logger.info("Method : deleteWorksapce Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String value = "SET @p_workSpaceId='"+workSpaceId+"';";
		System.out.println(value);
		try {

			 em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "deleteworkspace").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		System.out.println("=====>>>resp" + response);
		logger.info("Method : deleteWorksapce Dao ends");
		return response;

	}
	
	// Add New Work Space

		public ResponseEntity<JsonResponse<Object>> addNewWorkSpace(String workSpace, String workSpaceId) {
			logger.info("Method : addNewWorkSpace dao starts" + workSpace);
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				if (!StringUtil.isNull(workSpaceId)) {
					String value = "SET @id='" + workSpaceId + "',@assert='" + workSpace + "';";
					System.out.println("Updated Seert ID: " + workSpaceId);
					em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "modifyAsset")
							.setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Data Updated successfully");

				} else {
					String value = "SET @assert='" + workSpace + "';";
					em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "addAsset")
							.setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Data Added successfully");
				}

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				}
				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);
			logger.info("Method : addNewWorkSpace dao ends");
			return response;

		}
}

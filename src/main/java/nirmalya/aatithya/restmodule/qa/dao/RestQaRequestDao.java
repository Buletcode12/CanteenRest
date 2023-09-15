package nirmalya.aatithya.restmodule.qa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestQaRequestDao {
	
	
	Logger logger = LoggerFactory.getLogger(RestQaRequestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewQaRequestData(String orgName, String orgDivision) {
		logger.info("Method : viewQaRequestData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "viewQaRequestData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewQaRequestData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestDtls(String id, String orgName, String orgDivision) {
		logger.info("Method : qaRequestDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaRequestDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			 resp.setCode("Success");
			resp.setMessage("Child Data");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaRequestDtls Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestChangeStatus(String id, String orgName, String orgDivision) {
		logger.info("Method : qaRequestChangeStatus Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			 em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaRequestChangeStatus").setParameter("actionValue", value).execute();
			 
			 resp.setCode("success");
			resp.setMessage("Sample Requested");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaRequestChangeStatus Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
}

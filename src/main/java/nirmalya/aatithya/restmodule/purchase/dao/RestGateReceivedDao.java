package nirmalya.aatithya.restmodule.purchase.dao;

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
public class RestGateReceivedDao {
	
	Logger logger = LoggerFactory.getLogger(RestGateReceivedDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gateReceivedDataView(String orgName, String orgDivision) {
		logger.info("Method : awaitingQaRequestData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_received_routines")
					.setParameter("actionType", "viewGateReceivedData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : gateReceivedDataView Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gateReceivedDtls(String id,String po , String orgName, String orgDivision) {
		logger.info("Method : gateReceivedDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET  @p_gatePId='" + id + "',@p_poNo='" + po + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_received_routines")
					.setParameter("actionType", "gateReceiveChildDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data Ok");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : gateReceivedDtls Dao ends");
		logger.info("resp**************chiiiild**************" + resp);
		return resp;

	}
	
}

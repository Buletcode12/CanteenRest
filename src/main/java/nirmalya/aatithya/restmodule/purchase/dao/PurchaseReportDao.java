package nirmalya.aatithya.restmodule.purchase.dao;

import javax.persistence.EntityManager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class PurchaseReportDao {

	Logger logger = LoggerFactory.getLogger(PurchaseReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPurchaseMtrlArrvReportData(String orgName, String orgDivision) {
		logger.info("Method : viewPurchaseMtrlArrvReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_report_routines")
					.setParameter("actionType", "viewReportData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPurchaseMtrlArrvReportData Dao ends");
		logger.info("resp**********" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewPurchaseReportFilterData(String orgName, String orgDivision, String fdate,
			String tdate) {

		logger.info("Method : viewPurchaseReportFilterData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fdate='"
					+ DateFormatter.getStringDate(fdate) + "',@p_tdate='" + DateFormatter.getStringDate(tdate) + "';";

			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_report_routines")
					.setParameter("actionType", "viewReportFilterData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPurchaseReportFilterData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPurchaseRMPMMtrlArrvReportData(String orgName, String orgDivision) {
		logger.info("Method : viewPurchaseRMPMMtrlArrvReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_report_routines")
					.setParameter("actionType", "viewRMPMReportData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPurchaseRMPMMtrlArrvReportData Dao ends");
		logger.info("resp**********" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPurchaseFGMtrlArrvReportData(String orgName, String orgDivision) {
		logger.info("Method : viewPurchaseFGMtrlArrvReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_report_routines")
					.setParameter("actionType", "viewFGReportData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPurchaseFGMtrlArrvReportData Dao ends");
		logger.info("resp**********" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPurchaseSFGMtrlArrvReportData(String orgName, String orgDivision) {
		logger.info("Method : viewPurchaseSFGMtrlArrvReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_report_routines")
					.setParameter("actionType", "viewSFGReportData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPurchaseSFGMtrlArrvReportData Dao ends");
		logger.info("resp**********" + resp);
		return resp;

	}
}

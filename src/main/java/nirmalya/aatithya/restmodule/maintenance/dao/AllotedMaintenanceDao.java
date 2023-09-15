package nirmalya.aatithya.restmodule.maintenance.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAllotedPolicyProgress;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetPolicyParams;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.common.utils.GenerateQcMasterParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AllotedMaintenanceDao {
	Logger logger = LoggerFactory.getLogger(AllotedMaintenanceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetMaintenance(String orgName, String orgDivision) {
		logger.info("Method : viewAssetMaintenance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "viewAlloted").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetMaintenance Dao ends");

		return resp;

	}


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPolList(String aid, String pid, String orgName, String orgDivision) {
		logger.info("Method : getPolList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_allotId='" + aid + "',@p_policyId='" + pid 
					+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getPolList").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getPolList Dao ends");
		return resp;
	}
	
	
	

	public ResponseEntity<JsonResponse<List<AllotedMaintenanceRestModel>>> addPolicyProgress(List<AllotedMaintenanceRestModel> av) {
		logger.info("Method : addPolicyProgress dao starts");
		System.out.println(av);
		JsonResponse<List<AllotedMaintenanceRestModel>> resp = new JsonResponse<List<AllotedMaintenanceRestModel>>();

		String value = GenerateAllotedPolicyProgress.getPolicyProgressList(av);
		System.out.println("value===sss" + value);
		try {

			if (av.get(0).getAllocid() != null && av.get(0).getAllocid() != "") {

				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "modifyPolicyProgress").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

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

		ResponseEntity<JsonResponse<List<AllotedMaintenanceRestModel>>> response = new ResponseEntity<JsonResponse<List<AllotedMaintenanceRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addPolicyProgress dao ends");
		return response;

	}


}

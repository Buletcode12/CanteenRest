package nirmalya.aatithya.restmodule.asset.dao;

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
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.common.utils.GenerateQcMasterParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetAssignDao {
	Logger logger = LoggerFactory.getLogger(AssetAssignDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetAssign(String orgName, String orgDivision) {
		logger.info("Method : viewAssetAssign Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_assign_routines")
					.setParameter("actionType", "viewAssetAssign").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetAssign Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
	// edit Asset Assign
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAssetAssign(String id, String orgName, String orgDivision) {
		logger.info("Method : editAssetAssign Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assignId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_assign_routines")
					.setParameter("actionType", "editAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAssetAssign Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	
	// assignAssetUpdate
	public ResponseEntity<JsonResponse<Object>> assignAssetUpdate(String id,String assetcat,String assetemp,String assigndate, String orgName, String orgDivision) {
		logger.info("Method : assignAssetUpdate starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assignId='" + id + "',@p_assetcat='" + assetcat+ "',@p_assetemp='" + assetemp+ "',@p_assigndate='" + assigndate+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("asset_assign_routines")
						.setParameter("actionType", "assignAssetUpdate").setParameter("actionValue", value).execute();

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

		logger.info("Method : assignAssetUpdate ends");

		return response;
	}
	
	// approveAssign
	public ResponseEntity<JsonResponse<Object>> approveAssign(String id, String orgName, String orgDivision) {
		logger.info("Method : approveAssign starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assignId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("asset_assign_routines")
						.setParameter("actionType", "approveAssign").setParameter("actionValue", value).execute();
				resp.setMessage("Success");
				resp.setCode("success");
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

		logger.info("Method : approveAssign ends");
		System.out.println("DELETEE" + response);
		return response;
	}
	

	// dissociateAsset
	public ResponseEntity<JsonResponse<Object>> dissociateAsset(String assignid,String assetid, String orgName, String orgDivision, String dreason) {
		logger.info("Method : dissociateAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assignId='" + assignid + "',@p_assetId='" + assetid + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_dreason='" + dreason + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("asset_assign_routines")
						.setParameter("actionType", "dissociateAsset").setParameter("actionValue", value).execute();

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

		logger.info("Method : dissociateAsset ends");
		System.out.println("DELETEE" + response);
		return response;
	}


}
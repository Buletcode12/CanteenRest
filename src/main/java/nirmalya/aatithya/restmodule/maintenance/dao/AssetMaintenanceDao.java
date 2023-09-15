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
public class AssetMaintenanceDao {
	Logger logger = LoggerFactory.getLogger(AssetMaintenanceDao.class);

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
					.setParameter("actionType", "viewAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetMaintenance Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
	

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getThirdPartyList(String org,String orgDiv,String userId) {
		logger.info("Method : getThirdPartyList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getThirdPartyList ends");
		return getCollectionList;
	}
	
	

	public ResponseEntity<JsonResponse<Object>> allocatePolicy(String assetid,String policyid,String assetcat,String assetemp,String assigndate,String frequency, String orgName, String orgDivision) {
		logger.info("Method : allocatePolicy starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + assetid+ "',@p_policyid='" + policyid + "',@p_assetcat='" + assetcat+ "',@p_assetemp='" + assetemp+ "',@p_assigndate='" + assigndate+ "',@p_frequency='" + frequency+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "allocatePolicy").setParameter("actionValue", value).execute();

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

		logger.info("Method : allocatePolicy ends");

		return response;
	}


	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryListforAsset(String org,String orgDiv,String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getCatList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeListforAsset ends");
		return getCollectionList;
	}


	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPriorityList(String org,String orgDiv,String userId) {
		logger.info("Method : getPriorityList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPriorityList ends");
		return getCollectionList;
	}


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEmgList(String type,String cat,String subcat, String orgName, String orgDivision) {
		logger.info("Method : getEmgList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetType='" + type + "',@p_assetCat='" + cat + "',@p_assetSubcat='" + subcat + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("hhhhhhhhhhhhiiiiiiiiiiiiii"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getEmgList").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmgList Dao ends");
		return resp;
	}



	public ResponseEntity<JsonResponse<Object>> deletePolicyAlloc(String id, String orgName, String orgDivision) {
		logger.info("Method : deletePolicyAlloc starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_allocId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "deletePolicyAlloc").setParameter("actionValue", value).execute();

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

		logger.info("Method : deletePolicyAlloc ends");
		return response;
	}




}

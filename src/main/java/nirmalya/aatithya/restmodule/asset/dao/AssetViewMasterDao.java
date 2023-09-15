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
public class AssetViewMasterDao {
	Logger logger = LoggerFactory.getLogger(AssetViewMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// getparameterLists
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getparameterLists(String org, String orgDiv) {
		logger.info("Method : getparameterLists Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getparameterlists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getparameterLists Dao ends");
		return itemList;
	}

//getitemnameList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getitemnameList(String org, String orgDiv) {
		logger.info("Method : getitemnameList Dao starts");
		List<DropDownModel> itemnamelist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getitemnamelist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemnamelist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getitemnamelist Dao ends");
		return itemnamelist;
	}

	// addAsset
	public ResponseEntity<JsonResponse<List<AssetViewMasterRestModel>>> addAsset(List<AssetViewMasterRestModel> av) {
		logger.info("Method : addAsset dao starts");
		JsonResponse<List<AssetViewMasterRestModel>> resp = new JsonResponse<List<AssetViewMasterRestModel>>();

		String value = GenerateAssetViewMaster.getAddasset(av);
		try {

			if (av.get(0).getAssetId() != null && av.get(0).getAssetId() != "") {

				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "modifyAsset").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "addAsset").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<AssetViewMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetViewMasterRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addAsset dao ends");
		return response;

	}

	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAsset(String orgName, String orgDivision) {
		logger.info("Method : viewAsset Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "viewAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAsset Dao ends");
		return resp;

	}

	// editQc
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAsset(String id, String orgName, String orgDivision) {
		logger.info("Method : editQc Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "editAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAsset Dao ends");
		return resp;
	}

	// deleteAsset
	public ResponseEntity<JsonResponse<Object>> deleteAsset(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteQc starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "deleteAsset").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteAsset ends");
		return response;
	}

	
	// scarpAsset
	public ResponseEntity<JsonResponse<Object>> scarpAsset(String id, String orgName, String orgDivision) {
		logger.info("Method : scarpAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "scarpAsset").setParameter("actionValue", value).execute();

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

		logger.info("Method : scarpAsset ends");
		return response;
	}

	
	// approveAsset
	public ResponseEntity<JsonResponse<Object>> approveAsset(String id,String QrCode, String orgName, String orgDivision) {
		logger.info("Method : approveAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_QrCode='" + QrCode+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "approveAsset").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
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

		logger.info("Method : approveAsset ends");
		return response;
	}
	
	
	
	//getShiftListsAllocation	
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getEmployeeListforAsset(String org,String orgDiv,String userId) {
			logger.info("Method : getEmployeeListforAsset starts");

			List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "getEmpList").setParameter("actionValue",value).getResultList();

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
		
		
		//getLocationListforAsset	
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getLocationListforAsset(String org,String orgDiv,String userId) {
			logger.info("Method : getLocationListforAsset starts");

			List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "getLocList").setParameter("actionValue",value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getCollectionList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getLocationListforAsset ends");
			return getCollectionList;
		}
		
		
		// assignAsset
		public ResponseEntity<JsonResponse<Object>> assignAsset(String id,String assetcat,String assetemp,String assigndate, String orgName, String orgDivision) {
			logger.info("Method : assignAsset starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_assetId='" + id + "',@p_assetcat='" + assetcat+ "',@p_assetemp='" + assetemp+ "',@p_assigndate='" + assigndate+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					em.createNamedStoredProcedureQuery("asset_view_master_routines")
							.setParameter("actionType", "assignAsset").setParameter("actionValue", value).execute();

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

			logger.info("Method : assignAsset ends");

			return response;
		}


		// historyAsset
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> historyAsset(String id, String orgName, String orgDivision) {
			logger.info("Method : historyAsset Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "historyAsset").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : historyAsset Dao ends");
			return resp;
		}


}

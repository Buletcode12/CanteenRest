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
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetPolicyParams;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.common.utils.GenerateQcMasterParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetPolicyDao {
	Logger logger = LoggerFactory.getLogger(AssetPolicyDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	
	//getShiftListsAllocation	
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

		//getShiftListsAllocation	
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
		

		
		//getLocationListforAsset	
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getSubCategoryforAsset(String org,String orgDiv,String userId) {
			logger.info("Method : getLocationListforAsset starts");

			List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "getSCatList").setParameter("actionValue",value).getResultList();

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
		
		
		// getSubCategory
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getSubCategory(String id, String orgName, String orgDivision) {
			logger.info("Method : getSubCategory Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_catId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "getSubCategory").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getSubCategory Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;
		}
		
		// addAssetPolicy
		public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addAssetPolicy(List<AssetPoilcyRestModel> av) {
			logger.info("Method : addAssetPolicy dao starts");
			System.out.println(av);
			JsonResponse<List<AssetPoilcyRestModel>> resp = new JsonResponse<List<AssetPoilcyRestModel>>();

			String value = GenerateAssetPolicyParams.getAddAssetPolicy(av);
			System.out.println("value===sss" + value);
			try {

				if (av.get(0).getPolicyid() != null && av.get(0).getPolicyid() != "") {

					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
							.setParameter("actionType", "modifyPolicy").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data Modified successfully");

				} else {
					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
							.setParameter("actionType", "addPolicy").setParameter("actionValue", value).execute();

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

			ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response===" + response);
			logger.info("Method : addAssetPolicy dao ends");
			return response;

		}


		// viewAssetPolicy
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewAssetPolicy(String orgName, String orgDivision) {
			logger.info("Method : viewAssetPolicy Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "viewAssetPolicy").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewAssetPolicy Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		// editPolicy
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editAssetPolicy(String id, String orgName, String orgDivision) {
			logger.info("Method : editAssetPolicy Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_policyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "editAssetPolicy").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editAssetPolicy Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;
		}
		
		// deleteAssetPolicy
		public ResponseEntity<JsonResponse<Object>> deleteAssetPolicy(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteAssetPolicy starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_policyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
							.setParameter("actionType", "deleteAssetPolicy").setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteAssetPolicy ends");
			System.out.println("DELETEE" + response);
			return response;
		}

		
		// approveAssetPolicy
		public ResponseEntity<JsonResponse<Object>> approveAssetPolicy(String id, String orgName, String orgDivision) {
			logger.info("Method : approveAssetPolicy starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_policyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
							.setParameter("actionType", "approveAssetPolicy").setParameter("actionValue", value).execute();
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

			logger.info("Method : approveAssetPolicy ends");
			System.out.println("DELETEE" + response);
			return response;
		}

		

}

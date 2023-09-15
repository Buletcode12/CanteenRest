package nirmalya.aatithya.restmodule.gatepass.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.gatePass.GenerateGatePassEntryPAram;
import nirmalya.aatithya.restmodule.common.utils.gatePass.GenerateGatePassExitParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository

public class GatePassDao {
	Logger logger = LoggerFactory.getLogger(GatePassDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getpurchseOrderIdList(String org, String orgDiv) {
		logger.info("Method : getpurchseOrderIdList starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getpurchseOrderIdList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getpurchseOrderIdList ends");
		return categoryList;
	}
	// purchseOrderIdForExit

	@SuppressWarnings("unchecked")
	public List<DropDownModel> purchseOrderIdForExit() {
		logger.info("Method : purchseOrderIdForExit starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "purchseOrderIdForExit").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : purchseOrderIdForExit ends");
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getnoOfwheelerList() {
		logger.info("Method : getnoOfwheelerList starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getnoOfwheelerList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getnoOfwheelerList ends");
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryList(String id) {
		logger.info("Method : getSubCategoryList starts");

		List<DropDownModel> subcategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_Category='" + id + "';";
		logger.info("Method : getSubCategoryList starts" + value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getSubcategoryList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				subcategoryList.add(dropDownModel);
			}
			if (subcategoryList.size() > 0) {
				Util.setJsonResponse(resp, subcategoryList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, subcategoryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSubCategoryList ends" + response);
		return response;
	}

	// add gatepass entry/in

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> addGatepassEntry(
			List<RestGatePassDetailsModel> restGatePassDetailsModel) {

		logger.info("Method : addGatepassEntry starts");

		JsonResponse<List<RestGatePassDetailsModel>> resp = new JsonResponse<List<RestGatePassDetailsModel>>();
		List<RestGatePassDetailsModel> listData = new ArrayList<RestGatePassDetailsModel>();

		try {

			String values = GenerateGatePassEntryPAram.getGatepassEntryParamforBothh(restGatePassDetailsModel);
			if (restGatePassDetailsModel.get(0).getGetPassEntryId() == ""
					|| restGatePassDetailsModel.get(0).getGetPassEntryId() == null) {

				entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
						.setParameter("actionType", "addGatePasses").setParameter("actionValue", values).execute();
			}

			else {

				entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
						.setParameter("actionType", "modifygatepassEntry").setParameter("actionValue", values)
						.execute();

			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addGatepassEntry ends");
		return response;
	}

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> viewGatePassEntry(String userId,
			String organization, String orgDivision) {
		logger.info("Method : viewGatePassEntry starts");
		List<RestGatePassDetailsModel> respList = new ArrayList<RestGatePassDetailsModel>();

		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\";";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "viewGatePassEntry").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[11] != null) {
					createdOn = m[11].toString();
				}
				RestGatePassDetailsModel viewdemo = new RestGatePassDetailsModel(m[0], m[1], m[2], m[3].toString(),
						m[4].toString(), m[5], m[6], m[7], m[8], m[9], m[10], createdOn, m[12], m[13], m[14], m[15],
						m[16], m[17], m[18], m[19], m[20], m[21], m[22]);
				respList.add(viewdemo);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestGatePassDetailsModel>> resp = new JsonResponse<List<RestGatePassDetailsModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewGatePassEntry ends");
		return response;

	}
// edit for gate pass entry 

	@SuppressWarnings("unchecked")
	public List<RestGatePassDetailsModel> editGatePassEntryData(String id, String organization, String orgDivision) {
		logger.info("Method : editGatePassEntryData starts");
		List<RestGatePassDetailsModel> getRequisitionTypeList = new ArrayList<RestGatePassDetailsModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String value = "SET @p_Entryid=\"" + id + "\", @p_org=\"" + organization + "\", @p_orgDiv=\"" + orgDivision
					+ "\";";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "editGatePassEntry").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				Object date = null;
				if (m[15] != null) {
					date = DateFormatter.returnStringDate(m[15]);
				}
				Object date1 = null;
				if (m[16] != null) {
					date1 = DateFormatter.returnStringDate(m[16]);
				}
				Object date2 = null;
				if (m[17] != null) {
					date2 = DateFormatter.returnStringDate(m[17]);
				}
				Object date3 = null;
				if (m[18] != null) {
					date3 = DateFormatter.returnStringDate(m[18]);
				}

				Object date4 = null;
				if (m[36] != null) {
					date4 = DateFormatter.returnStringDate(m[36]);
				}

				Object createdOn = null;
				if (m[20] != null) {
					createdOn = DateFormatter.returnStringDate(m[20]);
				}
				RestGatePassDetailsModel dropDownModel = new RestGatePassDetailsModel(m[0], m[1], m[2], m[3].toString(),
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], date, date1, date2,
						date3, m[19], createdOn, m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30],
						m[31], m[32], m[33], m[34], m[35], date4, m[37], m[38], m[39], m[40], m[41], m[42], m[43],
						m[44], m[45], m[46], m[47]);

				getRequisitionTypeList.add(dropDownModel);

			}

			try {
				String subValues = "SET @p_Entryid='" + getRequisitionTypeList.get(0).getGetPassEntryId() + "';";
				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
						.setParameter("actionType", "getVisitingDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : editGatePassEntryData ends");
		return getRequisitionTypeList;
	}

	// gate out data add

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> addGatepassExit(
			List<RestGatePassDetailsModel> restGatePassDetailsModel) {

		logger.info("Method : addGatepassExit starts");

		JsonResponse<List<RestGatePassDetailsModel>> resp = new JsonResponse<List<RestGatePassDetailsModel>>();
		List<RestGatePassDetailsModel> listData = new ArrayList<RestGatePassDetailsModel>();

		try {
			String values = GenerateGatePassExitParam.getGatepassExitParam(restGatePassDetailsModel);
			if (restGatePassDetailsModel.get(0).getGetPassExitId() == null
					|| restGatePassDetailsModel.get(0).getGetPassExitId() == "") {
				entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
						.setParameter("actionType", "addGatePassExit").setParameter("actionValue", values).execute();

			} else {
				entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
						.setParameter("actionType", "modifygatepassExit").setParameter("actionValue", values).execute();

			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addGatepassExit ends");
		return response;
	}

	// view gate out

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> viewGatePassExit(String userId,
			String organization, String orgDivision) {
		logger.info("Method : viewGatePassExit starts");
		List<RestGatePassDetailsModel> respList = new ArrayList<RestGatePassDetailsModel>();

		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\";";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "viewGatePassExit").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[12] != null) {
					createdOn = m[12].toString();
				}
				RestGatePassDetailsModel viewdemo = new RestGatePassDetailsModel(m[0], m[1], m[2], m[3].toString(),
						m[4].toString(), m[5], m[6], m[7], m[8], m[9], m[10], m[11], createdOn, m[13], m[14], m[15],
						m[16], m[17]);

				respList.add(viewdemo);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestGatePassDetailsModel>> resp = new JsonResponse<List<RestGatePassDetailsModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewGatePassExit ends");
		return response;

	}

	// edit for gate out

	@SuppressWarnings("unchecked")
	public List<RestGatePassDetailsModel> editGatePassExit(String id, String organization, String orgDivision) {
		logger.info("Method : editGatePassExit starts");
		List<RestGatePassDetailsModel> getRequisitionTypeList = new ArrayList<RestGatePassDetailsModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String value = "SET @p_Exitid=\"" + id + "\", @p_org=\"" + organization + "\", @p_orgDiv=\"" + orgDivision
					+ "\";";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "editGatePassExit").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				Object date = null;
				if (m[15] != null) {
					date = DateFormatter.returnStringDate(m[15]);
				}
				Object date1 = null;

				if (m[16] != null) {
					date1 = DateFormatter.returnStringDate(m[16]);
				}
				Object date2 = null;
				if (m[17] != null) {
					date2 = DateFormatter.returnStringDate(m[17]);
				}
				Object date3 = null;
				if (m[18] != null) {
					date3 = DateFormatter.returnStringDate(m[18]);
				}
				Object createdOn = null;
				if (m[20] != null) {
					createdOn = DateFormatter.returnStringDate(m[20]);
				}
				Object createdOn1 = null;
				if (m[34] != null) {
					createdOn1 = DateFormatter.returnStringDate(m[34]);
				}

				RestGatePassDetailsModel reqEdit = new RestGatePassDetailsModel(m[0], m[1], m[2], m[3].toString(), m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], date, date1, date2, date3,
						m[19], createdOn, m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],
						m[32], m[33], createdOn1, m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44], m[45], m[46]);
				getRequisitionTypeList.add(reqEdit);

			}

			try {
				String subValues = "SET @p_Entryid='" + getRequisitionTypeList.get(0).getGetPassExitId() + "';";
				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
						.setParameter("actionType", "getVisitingDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editGatePassExit ends");
		return getRequisitionTypeList;
	}

	// item against po id

	@SuppressWarnings("unchecked")
	public List<RestGatePassDetailsModel> getVendorandItemDetails(String id, String org, String orgDivision) {
		logger.info("Method : getVendorandItemDetails starts");
		List<RestGatePassDetailsModel> getRequisitionTypeList = new ArrayList<RestGatePassDetailsModel>();
		try {

			String values = "SET @p_poId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getVendorandItemDetails").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object DATE = null;
					if (m[9] != null) {
						DATE = DateFormatter.returnStringDate(m[9]);
					}

					RestGatePassDetailsModel dropDownModel = new RestGatePassDetailsModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], DATE, m[10], m[11].toString(), m[12].toString(), m[13], m[14],
							m[15]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : getVendorandItemDetails ends");
		return getRequisitionTypeList;
	}

// getItemDetailsForExit

	@SuppressWarnings("unchecked")
	public List<RestGatePassDetailsModel> getItemDetailsForExit(String id, String org, String orgDivision) {
		logger.info("Method : getItemDetailsForExit starts");
		List<RestGatePassDetailsModel> getRequisitionTypeList = new ArrayList<RestGatePassDetailsModel>();
		try {

			String values = "SET @p_poId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDivision + "';";
			System.err.println("DATA" + values);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getItemDetailsForExit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					/*
					 * Object DATE = null; if (m[11] != null) { DATE =
					 * DateFormatter.returnStringDate(m[11]); }
					 */

					/*
					 * double rcvng=0; if (m[12] != null) {
					 * rcvng=Double.parseDouble(m[12].toString()); } double rcvd=0; if (m[13] !=
					 * null) { rcvd=Double.parseDouble(m[13].toString()); } double pndng=0; if
					 * (m[14] != null) { pndng=Double.parseDouble(m[14].toString()); }
					 */
					RestGatePassDetailsModel dropDownModel = new RestGatePassDetailsModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9].toString(), m[10], m[11], null, null, null);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : getItemDetailsForExit ends");
		return getRequisitionTypeList;
	}
	// approveGatepassEntry

	public JsonResponse<DropDownModel> approveGatepassEntry(String approveStatus, String getPassEntryId,
			String organization, String orgDivision) {
		logger.info("Method : approveGatepassEntry starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			// String value = "SET @p_approveStatus='" + approveStatus + "',@p_Entryid='" +
			// getPassEntryId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\"" +
			// orgDivision+ "';";
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_Entryid='" + getPassEntryId + "', @p_org='"
					+ organization + "',@p_orgDiv='" + orgDivision + "';";
			entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "approveGatepassEntry").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveGatepassEntry ends");
		return resp;
	}
	// approveGatepassExit

	public JsonResponse<DropDownModel> approveGatepassExit(String approveStatus, String getPassExitId,
			String organization, String orgDivision) {
		logger.info("Method : approveGatepassExit starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_Exitid='" + getPassExitId + "', @p_org='"
					+ organization + "',@p_orgDiv='" + orgDivision + "';";
			entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "approveGatepassExit").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveGatepassExit ends");
		return resp;
	}

	// deleteGatepassEntry

	public ResponseEntity<JsonResponse<Object>> deleteGatepassEntry(String id, String organization,
			String orgDivision) {
		logger.info("Method : deleteGatepassEntry starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				// String value = "SET @p_Entryid=\"" + id + "\", @p_org=\"" + organization +
				// "\", @p_orgDiv=\"" + orgDivision+ "';";
				String value = "SET @p_Entryid='" + id + "', @p_org='" + organization + "',@p_orgDiv='" + orgDivision
						+ "';";
				entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
						.setParameter("actionType", "deleteGatepassEntry").setParameter("actionValue", value).execute();
			
				resp.setMessage("Success");
				resp.setCode("Ok");

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

		logger.info("Method : deleteGatepassEntry ends");
		return response;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteGatepassExit(String id, String organization, String orgDivision) {
		logger.info("Method : deleteGatepassExit starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_Exitid='" + id + "', @p_org='" + organization + "',@p_orgDiv='" + orgDivision
						+ "';";

				entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
						.setParameter("actionType", "deleteGatepassExit").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteGatepassExit ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemAutoSearchListforgate(String id,
			String org, String orgDiv) {
		logger.info("Method : getItemAutoSearchListforgate starts");
		List<InventorySkuProductModel> itemNameList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getItemForGateEntry").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				double gst = 0;
				if (m[9] != null) {
					gst = Double.parseDouble(m[9].toString());
				}
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], gst,null,null,null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemAutoSearchListforgate ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemAutoSearchNewListForFg(String id,
			String org, String orgDiv) {
		logger.info("Method : getItemAutoSearchNewListForFg starts");
		List<InventorySkuProductModel> itemNameList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getItemForFg").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				double gst = 0;
				if (m[9] != null) {
					gst = Double.parseDouble(m[9].toString());
				}
				
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], gst,null,null,null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemAutoSearchNewListForFg ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gettransportAutoSearchList(String id,String org, String  orgDiv) {
		logger.info("Method : getManPowerAutoSearchListForItem Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "gettransportAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : gettransportAutoSearchList Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getdriverAutoSearchList(String id,String org, String  orgDiv) {
		logger.info("Method : getdriverAutoSearchList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getdriverAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getdriverAutoSearchList Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getvehicleAutoSearchList(String id,String org, String orgDiv) {
		logger.info("Method : getvehicleAutoSearchList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getvehicleAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getvehicleAutoSearchList Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getdepoAutoSearchList(String id,String org, String orgDiv) {
		logger.info("Method : getdepoAutoSearchList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getdepoAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getdepoAutoSearchList Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getvisitList(String id,String org, String orgDiv) {
		logger.info("Method : getvisitList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			//String value = "SET @p_searchValue='" + id + "';";
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
					.setParameter("actionType", "getvisitList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getvisitList Dao ends");
		return resp;
	}
}

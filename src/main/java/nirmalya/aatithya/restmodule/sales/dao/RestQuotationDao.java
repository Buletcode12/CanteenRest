package nirmalya.aatithya.restmodule.sales.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GeneratePoNoNewParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateRequisitionParam;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateQuotationNewParameter;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;
import nirmalya.aatithya.restmodule.sales.model.ScopeMatrixRestModel;

@Repository
public class RestQuotationDao {

	Logger logger = LoggerFactory.getLogger(RestQuotationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@Autowired
	EnvironmentVaribles env;
	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<List<DropDownModel>>
	 * getSalespersonList() {
	 * 
	 * logger.info("Method : getSalespersonList starts"); List<DropDownModel>
	 * salespersonList = new ArrayList<DropDownModel>();
	 * JsonResponse<List<DropDownModel>> resp = new
	 * JsonResponse<List<DropDownModel>>();
	 * 
	 * 
	 * try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("quotationmasterRotines")
	 * .setParameter("actionType", "getSalespersonList").setParameter("actionValue",
	 * "").getResultList(); for (Object[] m : x) {
	 * 
	 * DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
	 * salespersonList.add(dropDownModel); } resp.setBody(salespersonList); if
	 * (salespersonList.size() > 0) { Util.setJsonResponse(resp, salespersonList,
	 * ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS); } else {
	 * Util.setJsonResponse(resp, salespersonList, ResponseStatus.success,
	 * ApiResponseMessage.NO_DATA_FOUND); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); logger.error("Error " +
	 * e.getMessage()); Util.setJsonResponse(resp, null, ResponseStatus.failed,
	 * ApiResponseMessage.UNKNOWN_EXCEPTION); }
	 * 
	 * logger.info("Method : getSalespersonList ends");
	 * 
	 * logger.info("LISTTTT" + resp); return resp; }
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> getSalesPersonListByAutoSearch(String id,String orgName, String orgDiv) {
		logger.info("Method :getSalesPersonListByAutoSearch starts");

		List<RestQuotationNewModel> itemNameList = new ArrayList<RestQuotationNewModel>();
		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getSalespersonList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], m[1], null, null, null, null,
						null, null, null);
				logger.info("getAllcustomerrrrr" + dropDownModel);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalesPersonListByAutoSearch ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestQuotationNewModel>> getAllquotation(String userId, String organization,
			String orgDivision) {
		logger.info("Method : All quotation Dao starts");

		List<RestQuotationNewModel> getAllemployee = new ArrayList<RestQuotationNewModel>();
		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();

		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\";";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "viewquotation").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				logger.info("DATAA" + Arrays.toString(m));

				Object DATE = null;
				if (m[2] != null) {
					DATE = m[2].toString();
				}
				Object validDate = null;
				if (m[4] != null) {
					validDate = m[4].toString();
				}
				Object update = null;
				if (m[8] != null) {
					update = m[8].toString();

				}
				Object podate = null;
				if (m[13] != null) {
					podate = m[13].toString();
					
				}
				// DateFormatter.returnStringDate(
				logger.info("getAllemployee" + getAllemployee);
				RestQuotationNewModel viewdemo = new RestQuotationNewModel(m[0], m[1], DATE, m[3], validDate, m[5],
						m[6], m[7], update, null, null,m[9],m[10],m[11],m[12],podate,m[14],m[15]);
				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		logger.info("Method : Allquotation Dao ends");
		logger.info("ssssssssssss" + resp);
		return resp;

	}
//View Draft
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestQuotationNewModel>> viewquotationDraft(String userId, String organization,
			String orgDivision) {
		logger.info("Method : All viewquotationDraft Dao starts");

		List<RestQuotationNewModel> getAllemployee = new ArrayList<RestQuotationNewModel>();
		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();

		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\";";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "viewquotationDraft").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				logger.info("DATAA" + Arrays.toString(m));

				
				Object validDate = null;
				if (m[2] != null) {
					validDate = m[2].toString();
				}
				
				// DateFormatter.returnStringDate(
				logger.info("getAllemployee" + getAllemployee);
				RestQuotationNewModel viewdemo = new RestQuotationNewModel(m[0], m[1],validDate,m[3],m[4],null,null);
				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		logger.info("Method : viewquotationDraft Dao ends");
		logger.info("ssssssssssss" + resp);
		return resp;

	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestQuotationNewModel>> getAllquotationItem() {
		logger.info("Method : getAllquotationItem starts");

		List<RestQuotationNewModel> getAllemployee = new ArrayList<RestQuotationNewModel>();
		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "viewquotationItem").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				// logger.info("getAllemployee@@" +getAllemployee);
				RestQuotationNewModel viewdemo = new RestQuotationNewModel(null, null, null, null, null, null, null,
						null, null, null, null, m[0], m[1], m[2], m[3], m[4], m[5], null, m[6], m[7], m[8], null, null,
						null, null, m[9], null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null);
				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		logger.info("Method : getAllquotationItem ends");
		// logger.info("response data is" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> getCustomerListByAutoSearch(String id,String orgName, String orgDiv) {
		logger.info("Method : getCustomerListByAutoSearch starts");

		List<RestQuotationNewModel> itemNameList = new ArrayList<RestQuotationNewModel>();
		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
         logger.info("value==="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getcustomerList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Boolean boolean1 = false;
				if (m[3].toString() != null) {
					String data = m[3].toString();
					if (data.contentEquals("Same State")) {
						boolean1 = true;
					} else {
						boolean1 = false;
					}
				}
				RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], m[1], m[2], boolean1, null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCustomerListByAutoSearch ends");
		return response;
	}

	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemQuotationAutoSearchListForItem(String id) {
		logger.info("Method : getItemQuotationAutoSearchListForItem starts");
		List<InventorySkuProductModel> itemNameList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		logger.info("SRCHVALUE"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getitemquotationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				double gst=0;
				if (m[9] != null) {
					gst=Double.parseDouble(m[9].toString());
				}
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6],m[7],m[8],gst,m[10],null,null);
				itemNameList.add(dropDownModel);
			}
			logger.info("getAllItemList######################S" + itemNameList);
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemQuotationAutoSearchListForItem ends");
		return response;
	}
//Quotation Save
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> addquotationnew(
			List<RestQuotationNewModel> restQuotationNewModel) {

		logger.info("Method : addquotationnew starts");

		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();
		List<RestQuotationNewModel> listData = new ArrayList<RestQuotationNewModel>();
		String values = GenerateQuotationNewParameter.getAddempParam(restQuotationNewModel);
		logger.info("VALUEee" + values);
		try {
			
			  if (restQuotationNewModel.get(0). getQuotationNo() == null ||
			  restQuotationNewModel.get(0). getQuotationNo() == "") {
			
				List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "addquotationnew").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], m[1], null,null,null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("@addd" + listData);
		} else {
				logger.info("@IDDDDMODIFY" + restQuotationNewModel.get(0).getQuotationId());
				logger.info("@modify" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "modifyquotationnew").setParameter("actionValue", values)
						.getResultList();

				try {
					for (Object[] m : x) {

						RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], m[1], null,null,null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("print in modify block" + listData);
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
		ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addquotationnew ends");
		return response;
	}
	
	//Quotation Draft Save
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> addquotationdraft(
			List<RestQuotationNewModel> restQuotationNewModel) {

		logger.info("Method : addquotationdraft starts");

		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();
		List<RestQuotationNewModel> listData = new ArrayList<RestQuotationNewModel>();
		
		
		 
		try {
			String values = GenerateQuotationNewParameter.getAddQuotationDraftParam(restQuotationNewModel);
			if (restQuotationNewModel.get(0).getDraftId() == null ||restQuotationNewModel.get(0).getDraftId() == "") {
				List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "addquotationdraft").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], null, null,null,null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("@addd" + listData);
		} else {
			logger.info("@IDDDDMODIFY" + restQuotationNewModel.get(0).getQuotationId());
			logger.info("@modify" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "modifyquotationdraftnew").setParameter("actionValue", values)
					.getResultList();

			try {
				for (Object[] m : x) {

					RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], null, null,null,null,null);
					listData.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("print in modify block" + listData);
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
		ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addquotationdraft ends");
		return response;
	}

	// get Product Category List Modal
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryDataListModal starts");

		JsonResponse<List<ProductCategoryModel>> resp = new JsonResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> yearList = new ArrayList<ProductCategoryModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getProductCategoryList").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {

				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				yearList.add(item);

				// logger.info("getAllItemList" +yearList);
			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductCategoryModel>>> response = new ResponseEntity<JsonResponse<List<ProductCategoryModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getProductCategoryDataListModal ends");
		// logger.info(response);
		return response;
	}

	// get product by cat

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getProductsByCat(String catId) {
		// logger.info("catId" + catId);
		logger.info("Method : getProductsByCat starts");

		List<InventorySkuProductModel> productList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		try {

			String value = GenerateRequisitionParam.getProduct(catId);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getProductByCat").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], null, null,null,null,null);
				productList.add(dropDownModel);
			}

			resp.setBody(productList);
			// logger.info(resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductsByCat ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<RestQuotationNewModel> viewQuotationEdit(String id) {
		logger.info("Method : viewQuotationEdit starts");
		List<RestQuotationNewModel> getRequisitionTypeList = new ArrayList<RestQuotationNewModel>();

		List<ScopeMatrixRestModel> matrixList = new ArrayList<ScopeMatrixRestModel>();

		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_quotationId='" + id + "';";
		
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getQuotationEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					logger.info("DATAAAA"+Arrays.toString(m));
					Object DATE = null;
					if (m[2] != null) {
						DATE = m[2].toString();
					}
					Object validDate = null;
					if (m[4] != null) {
						validDate = m[4].toString();
					}
					Object update = null;
					if (m[8] != null) {
						update = m[8].toString();

					}
					RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], m[1], DATE, m[3], validDate,
							m[5], m[6], m[7], update, null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],m[17].toString(),null,
							m[18],m[19],m[20],m[21],m[22],m[23],
							m[24],m[25],m[26],m[27],m[28],m[29],m[30],m[31],m[32],m[33],m[34],null,null,m[35],m[36]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				System.err.println("DropDownModel");
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getQuotationId() + "';";
				System.err.println("DropDownModel1");
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "getScopeMatrixEditDtls").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {
					logger.info("DropDownModel2" + Arrays.toString(m));
					logger.info("DropDownModel2" + m[0]);

					ScopeMatrixRestModel dropDownModel = new ScopeMatrixRestModel(m[0], m[1], m[2], m[3],m[4]);

					logger.info("DropDownModel" + dropDownModel);
					matrixList.add(dropDownModel);

					logger.info("matrixList" + matrixList);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getQuotationId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
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
		getRequisitionTypeList.get(0).setScopematrix(matrixList);
		getRequisitionTypeList.get(0).setDocumentList(docList);

		logger.info("Method : viewQuotationEdit ends");
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		return getRequisitionTypeList;
	}
	
	//Edit Draft
	@SuppressWarnings("unchecked")
	public List<RestQuotationNewModel> viewQuotationDraftEdit(String draftId) {
		logger.info("Method : viewQuotationDraftEdit starts");
		List<RestQuotationNewModel> getRequisitionTypeList = new ArrayList<RestQuotationNewModel>();

		List<ScopeMatrixRestModel> matrixList = new ArrayList<ScopeMatrixRestModel>();

		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_draftId='" + draftId + "';";
		
			logger.info("values222222222222222222"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "viewQuotationDraftEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					logger.info("DATAAAA"+Arrays.toString(m));
					Object DATE = null;
					if (m[0] != null) {
						DATE = m[0].toString();
					}
					Object validDate = null;
					if (m[2] != null) {
						validDate = m[2].toString();
					}
					Object update = null;
					if (m[6] != null) {
						update = m[6].toString();

					}
					RestQuotationNewModel dropDownModel = new RestQuotationNewModel(null, null, DATE, m[1], validDate,
							m[3], m[4], m[5], update, null, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14],m[15].toString(),m[16],
							m[17],m[18],m[19],m[20],m[21],m[22],
							m[23],m[24],m[25],m[26],m[27],m[28],m[29],m[30],m[31],m[32],m[33],null,m[34],m[35],m[36]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				System.err.println("DropDownModel");
				String subValues = "SET @p_draftId='" + getRequisitionTypeList.get(0).getDraftId() + "';";
				System.err.println("DropDownModel1");
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "getScopeMatrixEditDraftDtls").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {
					logger.info("DropDownModel2" + Arrays.toString(m));
					logger.info("DropDownModel2" + m[0]);

					ScopeMatrixRestModel dropDownModel = new ScopeMatrixRestModel(m[0], m[1], m[2], m[3],m[4]);

					logger.info("DropDownModel" + dropDownModel);
					matrixList.add(dropDownModel);

					logger.info("matrixList" + matrixList);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_draftId='" + getRequisitionTypeList.get(0).getDraftId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "getVendorDraftDocs").setParameter("actionValue", subValues)
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
		getRequisitionTypeList.get(0).setScopematrix(matrixList);
		getRequisitionTypeList.get(0).setDocumentList(docList);

		logger.info("Method : viewQuotationDraftEdit ends");
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		return getRequisitionTypeList;
	}
	
//viewQuotationGetOrder
	@SuppressWarnings("unchecked")
	public List<RestQuotationNewModel> viewQuotationGetOrder(String id) {
		logger.info("Method : viewQuotationGetOrder starts");
		List<RestQuotationNewModel> getRequisitionTypeList = new ArrayList<RestQuotationNewModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_quotationId='" + id + "';";
			
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "viewQuotationGetOrder").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					logger.info("DATAAAA"+Arrays.toString(m));
					Object DATE = null;
					if (m[2] != null) {
						DATE = m[2].toString();
					}
					Object validDate = null;
					if (m[4] != null) {
						validDate = m[4].toString();
					}
					Object update = null;
					if (m[8] != null) {
						update = m[8].toString();
						
					}
					RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], m[1], DATE, m[3], validDate,
							m[5], m[6], m[7], update,null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],m[17].toString(),m[18],
							m[19],m[20],m[21],m[22],m[23],m[24],
							m[25],m[26],m[27],m[28],m[29],m[30],m[31],m[32],m[33],m[34],m[35],m[36],null,null,m[37]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getQuotationId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {
					
					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
				}
				getRequisitionTypeList.get(0).setDocumentList(docList);
			} catch (Exception e) {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewQuotationGetOrder ends");
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		return getRequisitionTypeList;
	}

	/*
	 * 
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteItemQuotation(RestQuotationNewModel deleteItemQuotation) {
		logger.info("Method : restDeleteRequisition starts");
		logger.info("restQuotationNewModel" + deleteItemQuotation);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateQuotationNewParameter.getDeleteParam(deleteItemQuotation);
			logger.info(value);
			em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "deleteQuotationItem").setParameter("actionValue", value).execute();
			logger.info("print block" + deleteItemQuotation);
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
		logger.info("@@@@@@@@@@@@@@@@" + deleteItemQuotation);
		logger.info("Method : deleteItemQuotation ends");
		return response;
	}

	/*
	 * delete Draft
	 */

	public ResponseEntity<JsonResponse<Object>> deleteDraft(RestQuotationNewModel deleteItemQuotation) {
		logger.info("Method : deleteDraft starts");
		logger.info("restQuotationNewModel" + deleteItemQuotation);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_draftId='" + deleteItemQuotation.getDraftId() + "';";
			logger.info(value);
			em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "deleteDraft").setParameter("actionValue", value).execute();
			logger.info("print block" + deleteItemQuotation);
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
		logger.info("@@@@@@@@@@@@@@@@" + deleteItemQuotation);
		logger.info("Method : deleteDraft ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addpoNo(RestQuotationNewModel quotationNewModel) {

		logger.info("Method : addpoNo starts");
		logger.info("quotationNewModel" + quotationNewModel);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GeneratePoNoNewParameter.getAddempParam(quotationNewModel);
			logger.info(values);

			if (quotationNewModel.getQuotationId() == null || quotationNewModel.getQuotationId() == "") {
				logger.info("Hii New" + quotationNewModel);
				em.createNamedStoredProcedureQuery("quotationmasterRotines").setParameter("actionType", "addpoNo")
						.setParameter("actionValue", values).execute();
				logger.info("print in addEmp block");

			} else {
				logger.info("print in modify block");
				em.createNamedStoredProcedureQuery("quotationmasterRotines").setParameter("actionType", "modifypoNo")
						.setParameter("actionValue", values).execute();

			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addpoNo ends");
		return response;
	}

	public JsonResponse<Object> addSalesPerson(RestQuotationNewModel restQuotationNewModel) {

		logger.info("Method : addSalesPerson starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateQuotationNewParameter.getSalesPersonadd(restQuotationNewModel);
			logger.info("ADDDVALUE" + values);
			logger.info("ID======" + restQuotationNewModel.getSalespersonId());
			if (restQuotationNewModel.getSalespersonId() == null || restQuotationNewModel.getSalespersonId() == "") {
				logger.info("ADD" + values);
				em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "addSalesPerson").setParameter("actionValue", values).execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		logger.info("ADDDDDDD" + resp);
		logger.info("Method : addSalesPerson ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<RestCustoomerNewModel> getCustomerAddressById(String id,String shipId,String orgName, String orgDivision) {
		logger.info("Method : getCustomerAddressById dao starts");

		RestCustoomerNewModel req = new RestCustoomerNewModel();
		JsonResponse<RestCustoomerNewModel> resp = new JsonResponse<RestCustoomerNewModel>();

		try {

			String value = "SET @P_customerId='" + id + "',@p_shipId='" + shipId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("valueeeeeee" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getCustomerAddress").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + Arrays.toString(m));
				RestCustoomerNewModel reqEdit = new RestCustoomerNewModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],m[17],m[18]);
				req = reqEdit;

			}
			logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@" +req);
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCustomerAddressById dao ends");
		logger.info("EDIT@@@@" + resp);
		return resp;
	}

	public JsonResponse<Object> addbillingaddress(RestCustoomerNewModel restCustoomerNewModel) {

		logger.info("Method : addbillingaddress starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateQuotationNewParameter.getBillingaddressadd(restCustoomerNewModel);
			// logger.info("ADDDVALUE"+values);
			logger.info("ID======" + restCustoomerNewModel.getCustomerId());
			logger.info("ADDddddddd" + values);
			if (restCustoomerNewModel.getCustomerId() == null || restCustoomerNewModel.getCustomerId() == "") {
				logger.info("ADDddddddd" + values);
				em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "addbillingAddress").setParameter("actionValue", values).execute();

			}

			else {
				logger.info("ADDddddddd" + values);
				em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "modifybillingaddress").setParameter("actionValue", values)
						.execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		logger.info("ADDDDDDD" + resp);
		logger.info("Method : addbillingaddress ends");
		return resp;
	}

	public JsonResponse<Object> addshippingaddress(RestCustoomerNewModel restCustoomerNewModel) {

		logger.info("Method : addshippingaddress starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateQuotationNewParameter.getShippingaddressadd(restCustoomerNewModel);
			// logger.info("ADDDVALUE"+values);
			// logger.info("ID======"+restCustoomerNewModel.getSalespersonId());
			if (restCustoomerNewModel.getCustomerId() == null || restCustoomerNewModel.getCustomerId() == "") {
				logger.info("ADD" + values);
				em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "addshippingAddress").setParameter("actionValue", values).execute();

			} else {
				logger.info("ADDddddddd" + values);
				em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "modifyshippingaddress").setParameter("actionValue", values)
						.execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		logger.info("ADDDDDDD" + resp);
		logger.info("Method : addshippingAddress ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> getTCSAutoSearchList(String id,String orgName, String orgDiv) {
		logger.info("Method :getTCSAutoSearchList starts");

		List<RestQuotationNewModel> itemNameList = new ArrayList<RestQuotationNewModel>();
		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getTcsList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestQuotationNewModel dropDownModel = new RestQuotationNewModel(null, null, null, null, m[0], null,
						null, m[2], m[1], null);

				logger.info("getAllcustomerrrrr" + dropDownModel);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestQuotationNewModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getTCSAutoSearchList ends");
		return response;
	}

	// Add TCS
	public JsonResponse<Object> addTcs(RestQuotationNewModel restQuotationNewModel) {

		logger.info("Method : addTcs starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateQuotationNewParameter.getTcsadd(restQuotationNewModel);
			logger.info("ADDDVALUE" + values);
			logger.info("ID======" + restQuotationNewModel.getTcsId());
			if (restQuotationNewModel.getTcsId() == null || restQuotationNewModel.getTcsId() == "") {
				logger.info("ADD" + values);
				em.createNamedStoredProcedureQuery("quotationmasterRotines").setParameter("actionType", "addTcs")
						.setParameter("actionValue", values).execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		logger.info("ADDDDDDD" + resp);
		logger.info("Method : addTcs ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCollectionList() {
		logger.info("Method : getCollectionList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getCollectionList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCollectionList ends");
		return getCollectionList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getQuotationTypeList() {
		logger.info("Method : getQuotationTypeList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getQuotationTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getQuotationTypeList ends");
		return getCollectionList;
	}

	// approve 

	public ResponseEntity<JsonResponse<List<DropDownModel>>> approveItemQuatation(String approveStatus, String quotationId,String reference) {
		logger.info("Method : approveLeaveApply starts");
		
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> rs = new ArrayList<DropDownModel>();
		
		try {

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_quotationId='" + quotationId + "',@p_reference='" + reference + "';";
			logger.info("value===========" + value);
			@SuppressWarnings("unchecked")
			List<Object[]> x=em.createNamedStoredProcedureQuery("quotationmasterRotines").setParameter("actionType", "approvequatation")
					.setParameter("actionValue", value).getResultList();
			
			try {
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], null);
					rs.add(dropDownModel);
					
					

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setBody(rs);
			resp.setCode("success");
			resp.setMessage("approveItemQuatation successfully");

			// List<DropDownModel> managerByUesr =
			// checkDuplicateDao.getUserByRequisitionId(id,name);
			/*
			 * for(DropDownModel m : managerByUesr) { String
			 * msg=m.getName()+" approved your Leave"; try { String msgId =
			 * pushNotification.pushFCMNotification(m.getKey(),msg); } catch (Exception e) {
			 * e.printStackTrace(); } }
			 */

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp,HttpStatus.CREATED);
				
		logger.info("resp===" + resp);
		logger.info("Method : approveItemQuatation ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuotationInsertedId() {
		logger.info("Method : getQuotationInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getQuotationInsertedId").setParameter("actionValue", "")
					.getResultList();

			Object jobId = x.get(0);
			logger.info("job id--------" + jobId);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response for getting job card id -------" + response);
		logger.info("Method : getQuotationInsertedId ends");
		return response;
	}


// getNoAndaggridDetails

	@SuppressWarnings("unchecked")
	public List<RestQuotationNewModel> getNoAndaggridDetails() {
		logger.info("Method : getNoAndaggridDetails starts");
		logger.info("restQuotationNewModel");
		List<RestQuotationNewModel> getRequisitionTypeList = new ArrayList<RestQuotationNewModel>();

		// List<InventoryVendorDocumentModel> docList = new
		// ArrayList<InventoryVendorDocumentModel>();
		try {
			// String values = "SET @p_quotationId='" + id + "';";
			// logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getNoAndaggridDetails").setParameter("actionValue", "")
					.getResultList();

			try {
				for (Object[] m : x) {

					RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0].toString(),m[1],m[2],m[3]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// getRequisitionTypeList.get(0).setDocumentList(docList);

		logger.info("Method : getNoAndaggridDetails ends");
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuotationNo() {
		logger.info("Method : getQuotationNo starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getQuotationNo").setParameter("actionValue", "").getResultList();

			Object jobId = x.get(0);
			logger.info("job id--------" + jobId);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response for getting job card id -------" + response);
		logger.info("Method : getQuotationNo ends");
		return response;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deletequotation(String id) {
		logger.info("Method : deletequotation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_quotId='" + id + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "deletequotation").setParameter("actionValue", value).execute();

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

		logger.info("Method : deletequotation ends");
		logger.info("DELETEE" + response);
		return response;
	}

//pdf 
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestQuotationNewModel>> getQuotationPdfDetails(String id, String organization,
			String orgDivision,String userId) {
		logger.info("Method : getQuotationPdfDetails starts");
		List<RestQuotationNewModel> quodetails = new ArrayList<RestQuotationNewModel>();

		JsonResponse<List<RestQuotationNewModel>> resp = new JsonResponse<List<RestQuotationNewModel>>();
		try {

			String value = "SET @p_quoId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getQuotationPdfDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[2] != null) {
					DATE = m[2].toString();
				}
				Object validDate = null;
				if (m[4] != null) {
					validDate = m[4].toString();
				}
				/*
				 * Object update = null; if (m[8] != null) { update = m[8].toString();
				 * 
				 * }
				 */
				
				Object update = null;
				if (m[8] != null) {
					update = DateFormatter.returnStringDate(m[8]);
				}
				String orgImg = null;
				if (m[34] != null && m[34] != "" && m[34] != " " && !m[34].toString().equals(" ")
						&& !m[34].toString().equals(null) && !m[34].toString().equals("")) {
					orgImg = env.getMobileView() + "document/document/" + m[34].toString();
				} else {
					orgImg = "";
				}
				// DateFormatter.returnStringDate(
				RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], m[1], DATE, m[3], validDate,
						m[5], m[6], m[7], update, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],m[18].toString(),
						m[19],m[20],null,m[21],null,m[22],m[23],m[24],m[25],m[26],m[27],m[28],m[29],m[30],
						m[31],m[32],m[33],orgImg,m[35],m[36],m[37],m[38],null);
				logger.info("reqEdit" + dropDownModel);
				quodetails.add(dropDownModel);
			}
			logger.info("lllllllllll" + quodetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (quodetails.isEmpty() == false) {
			List<ScopeMatrixRestModel> scopematrix = new ArrayList<ScopeMatrixRestModel>();
			String iD = quodetails.get(0).getQuotationId();
			String idD = quodetails.get(0).getUserId();
			logger.info("IDDDD" +iD);
			logger.info("IDDDD" + userId);
			try {

				List<Object[]> x1 = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "getQuotationItemPdfDetails")
						.setParameter("actionValue", "SET @p_quoId='" + quodetails.get(0).getQuotationId() + "',@p_userId='" + userId + "';")
						.getResultList();
				for (Object[] m : x1) {

					/*
					 * Object createdDate = null; if (m[10] != null) { createdDate =
					 * m[10].toString(); }
					 */
					ScopeMatrixRestModel productModel = new ScopeMatrixRestModel(m[0], m[1], m[2], m[3],m[4]);
					scopematrix.add(productModel);
				}
				logger.info("ScopeMatrixRestModelllllllllll" + scopematrix);
			} catch (Exception e) {
				e.printStackTrace();
			}

			quodetails.get(0).setScopematrix(scopematrix);
		}
		resp.setBody(quodetails);
		logger.info("DaOOOOO================" + resp);
		logger.info("Method : getQuotationPdfDetails ends");

		return resp;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSacCode() {
		logger.info("Method : getSacCode starts");
		
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getSacCode").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {
			DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
			itemList.add(dropDownModel);
			}
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSacCode ends");
		return response;
	}
	

	@SuppressWarnings("unchecked")
	public List<RestQuotationNewModel> viewQuotationRevision(String id) {
		logger.info("Method : viewQuotationRevision starts");
		List<RestQuotationNewModel> getRequisitionTypeList = new ArrayList<RestQuotationNewModel>();

		List<ScopeMatrixRestModel> matrixList = new ArrayList<ScopeMatrixRestModel>();

		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_quotationId='" + id + "';";
		
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "viewQuotationRevision").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					logger.info("DATAAAA"+Arrays.toString(m));
					Object DATE = null;
					if (m[2] != null) {
						DATE = m[2].toString();
					}
					Object validDate = null;
					if (m[4] != null) {
						validDate = m[4].toString();
					}
					Object update = null;
					if (m[8] != null) {
						update = m[8].toString();

					}
					RestQuotationNewModel dropDownModel = new RestQuotationNewModel(m[0], m[1], DATE, m[3], validDate,
							m[5], m[6], m[7], update, null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],m[17].toString(),m[18],
							m[19],m[20],m[21],m[22],m[23],m[24],
							m[25],m[26],m[27],m[28],m[29],m[30],m[31],m[32],m[33],m[34],m[35],null,null,m[36],m[37]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				System.err.println("DropDownModel");
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getQuotationId() + "';";
				System.err.println("DropDownModel1");
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "getScopeMatrixEditDtls").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {
					logger.info("DropDownModel2" + Arrays.toString(m));
					logger.info("DropDownModel2" + m[0]);

					ScopeMatrixRestModel dropDownModel = new ScopeMatrixRestModel(m[0], m[1], m[2], m[3],m[4]);

					logger.info("DropDownModel" + dropDownModel);
					matrixList.add(dropDownModel);

					logger.info("matrixList" + matrixList);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getQuotationId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("quotationmasterRotines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
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
		getRequisitionTypeList.get(0).setScopematrix(matrixList);
		getRequisitionTypeList.get(0).setDocumentList(docList);

		logger.info("Method : viewQuotationRevision ends");
		logger.info("@@@@@@@@revision" + getRequisitionTypeList);
		return getRequisitionTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ScopeMatrixRestModel>>> getScopeMatrixDetails(String quotType,
			String orgName, String orgDiv) {
		logger.info("Method : getScopeMatrixDetails Dao startssssssssssssssssssssss");

		List<ScopeMatrixRestModel> getScopedata = new ArrayList<ScopeMatrixRestModel>();
		JsonResponse<List<ScopeMatrixRestModel>> resp = new JsonResponse<List<ScopeMatrixRestModel>>();

		try {
			String values = "SET @p_quotType='" + quotType + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("################### -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getScopeMatrixDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				ScopeMatrixRestModel viewdemo = new ScopeMatrixRestModel(m[0].toString(), m[1], m[2], m[3], null);
				getScopedata.add(viewdemo);
			}
			resp.setBody(getScopedata);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ScopeMatrixRestModel>>> response = new ResponseEntity<JsonResponse<List<ScopeMatrixRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getScopeMatrixDetails Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}
	 
	
	
	/*
	 * @SuppressWarnings("unchecked") public List<RestQuotationNewModel>
	 * getScopeMatrixDetails(String quotType,String orgName,String orgDiv) {
	 * logger.info("Method : getScopeMatrixDetails starts");
	 * List<RestQuotationNewModel> getRequisitionTypeList = new
	 * ArrayList<RestQuotationNewModel>();
	 * 
	 * List<ScopeMatrixRestModel> matrixList = new
	 * ArrayList<ScopeMatrixRestModel>();
	 * 
	 * 
	 * try { System.err.println("DropDownModel"); String values =
	 * "SET @p_quotType='" + quotType + "',@p_org='" + orgName + "',@p_orgDiv='" +
	 * orgDiv + "';"; logger.info("################### -----------"+values);
	 * List<Object[]> x1 =
	 * em.createNamedStoredProcedureQuery("quotationmasterRotines")
	 * .setParameter("actionType",
	 * "getScopeMatrixDetails").setParameter("actionValue", values)
	 * .getResultList();
	 * 
	 * try {
	 * 
	 * for (Object[] m : x1) { logger.info("DropDownModel2" +
	 * Arrays.toString(m)); logger.info("DropDownModel2" + m[0]);
	 * 
	 * ScopeMatrixRestModel dropDownModel = new
	 * ScopeMatrixRestModel(m[0].toString(), m[1], m[2], m[3],null);
	 * 
	 * logger.info("DropDownModel" + dropDownModel);
	 * matrixList.add(dropDownModel);
	 * 
	 * logger.info("matrixList" + matrixList); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * getRequisitionTypeList.get(0).setScopematrix(matrixList);
	 * 
	 * 
	 * logger.info("Method : getScopeMatrixDetails ends");
	 * logger.info("@@@@@@@@edit" + getRequisitionTypeList); return
	 * getRequisitionTypeList; }
	 */
	
	@SuppressWarnings("unchecked")
	public JsonResponse viewShippingAddressData(String customerId,String orgName, String orgDiv) {
		logger.info("Method : viewShippingAddressData Dao startssssssssssssssssssssss");

		JsonResponse resp = new JsonResponse();

		try {
			String value = "SET @p_customerId='" + customerId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "viewShippingAddressData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : viewShippingAddressData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse editShippingAddressData(String addressId, String orgName, String orgDiv) {
		logger.info("Method : viewShippingAddressData Dao starts");

		JsonResponse resp = new JsonResponse();

		try {
			String value = "SET @p_addressId='" + addressId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "editShippingAddressData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : editShippingAddressData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	 
}

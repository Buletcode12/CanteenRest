package nirmalya.aatithya.restmodule.sales.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateRequisitionParam;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSaleOrderNewParameter;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

@Repository
public class RestSaleOrderNewDao {

	Logger logger = LoggerFactory.getLogger(RestSaleOrderNewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> GetStoreList() {
		logger.info("Method : demo Dao starts");

		List<DropDownModel> GetStoreList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "GetStoreList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				GetStoreList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : demo Dao ends");

		return GetStoreList;
	}

	/*
	 * cust Autosearch
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getCustomerAutoSearchNewList(String id) {
		logger.info("Method : getCustomerAutoSearchNewList starts");

		List<RestSaleOrderNewModel> itemNameList = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getcustomerList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel( m[0], m[1], m[2]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCustomerAutoSearchNewList ends");
		return response;
	}

	/*
	 * item autosearch
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getItemQuotationAutoSearchNewList(String id) {
		logger.info("Method : getItemQuotationAutoSearchNewList starts");
		List<RestSaleOrderNewModel> itemNameList = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";
logger.info("value==="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getitemquotationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1], m[2], m[3]);
				itemNameList.add(dropDownModel);
			}
			// logger.info("getAllItemList" +itemNameList);
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemQuotationAutoSearchNewList ends");
		return response;
	}

	// get Product Category List Modal
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryDataListModal starts");

		JsonResponse<List<ProductCategoryModel>> resp = new JsonResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> yearList = new ArrayList<ProductCategoryModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getProductCategoryList").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {

				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				yearList.add(item);

				// logger.info("yearList===="+yearList);
			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductCategoryModel>>> response = new ResponseEntity<JsonResponse<List<ProductCategoryModel>>>(
				resp, HttpStatus.CREATED);
		logger.info(response.toString());
		logger.info("Method : getProductCategoryDataListModal ends");
		return response;
	}

	// get product by cat

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getProductsNByCat(String catId) {
		// logger.info("catId" + catId);
		logger.info("Method : getProductsNByCat starts");

		List<InventorySkuProductModel> productList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		try {
			String value = GenerateRequisitionParam.getProduct(catId);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getProductByCat").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				double gst=0;
				if (m[9] != null) {
					gst=Double.parseDouble(m[9].toString());
				}
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6],m[7],m[8],gst,m[10],null,null);
				productList.add(dropDownModel);
			}
			resp.setBody(productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductsNByCat ends");
		return response;
	}

	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> addsalenew(
			List<RestSaleOrderNewModel> restSaleOrderNewModel) {

		logger.info("Method : addsalenew starts");

		logger.info("RestSaleOrderNewModel" + restSaleOrderNewModel);
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		List<RestSaleOrderNewModel> listData = new ArrayList<RestSaleOrderNewModel>();

		try {
			String values = GenerateSaleOrderNewParameter.getAddempParam(restSaleOrderNewModel);
			logger.info("value#" + values);
			logger.info("IDDDD#" + restSaleOrderNewModel.get(0).getSalesOrder());
			if (restSaleOrderNewModel.get(0).getSalesOrder() == null
					|| restSaleOrderNewModel.get(0).getSalesOrder() == "") {
				logger.info("ADD#" + values);
			
				em.createNamedStoredProcedureQuery("salesOrderNew")
						.setParameter("actionType", "addsalenew").setParameter("actionValue", values).execute();
			} else {
				logger.info("@modify" + values);
				 em.createNamedStoredProcedureQuery("salesOrderNew")
						.setParameter("actionType", "modifysalesnew").setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addsalenew ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestSaleOrderNewModel>> getAllsalesOrder(String userId,String organization, String orgDivision ) {
		logger.info("Method : getAllsalesOrder Dao starts");

		List<RestSaleOrderNewModel> getAllemployee = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();

		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value===="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "viewsalesorder").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				Object expDate = null;
				if (m[3] != null) {
					expDate = m[3].toString();
				}
 
				Object ordate = null;
				if (m[9] != null) {
					ordate = m[9].toString();
				}
				RestSaleOrderNewModel viewdemo = new RestSaleOrderNewModel(m[0],m[1], m[2],expDate,
						m[4], m[5], m[6],m[7],m[8],ordate,m[10].toString(),m[11].toString(),m[12]);
				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		logger.info("Method : getAllsalesOrder Dao ends");
		return resp;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestSaleOrderNewModel> viewsalesOrdeerEdit(String id) {
		logger.info("Method : viewsalesOrdeerEdit starts");
		logger.info("RestSaleOrderNewModel" + id);
		List<RestSaleOrderNewModel> getRequisitionTypeList = new ArrayList<RestSaleOrderNewModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_salesId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getSalesOrderEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					Object DATER = null;
					if (m[41] != null) {
						DATER = m[41].toString();
					}
					
					Object EDATE = null;
					if (m[42] != null) {
						EDATE = m[42].toString();
					}
					RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1],m[2],
							m[3], m[4],
                            m[5], m[6], m[7], m[8], m[9], 
                             m[10], m[11], m[12], m[13], m[14],m[15],
				                m[16], m[17], m[18], m[19], m[20],
                               m[21], m[22],m[23],
				              m[24],m[25],
                          m[26],m[27],m[28],
                           m[29],m[30],m[31],m[32],
                       m[33],m[34],m[35],m[36],m[37],m[38],m[39],m[40],DATER,EDATE,m[43],m[44],m[45],m[46]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getQuotationId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesOrderNew")
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
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : viewsalesOrdeerEdit ends");
		return getRequisitionTypeList;
	}
	/*
	 * viewsalesOrderForPacking
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestSaleOrderNewModel> viewsalesOrderForPacking(String id,String poidd,String noOfSO) {
		logger.info("Method : viewsalesOrderForPacking starts");
		List<RestSaleOrderNewModel> getRequisitionTypeList = new ArrayList<RestSaleOrderNewModel>();
		try {
			String values = "SET @p_salesId='(" + id + ")',@p_poidd='" + poidd + "',@p_noOfSO='" + noOfSO + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "viewsalesOrderForPacking").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					
					Object DATER = null;
					if (m[21] != null) {
						DATER = m[21].toString();
					}
					Object DATET = null;
					if (m[22] != null) {
						DATET = m[22].toString();
					}
					Object EDATE = null;
					if (m[26] != null) {
						EDATE = m[26].toString();
					}
					RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], null, m[1], m[2], null, null,
							m[3], m[4], m[5], null, m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
							m[16], m[17], null, m[18], null, m[19], m[20], null, DATER, DATET, null, m[23], m[24],
							m[25],EDATE,m[27],m[28],m[29],null,null,m[30],m[31],m[32],m[33],m[34],m[35],m[36],
							null,null,null,m[37],m[38],m[39],m[40],m[41],m[42].toString(),m[43].toString(),m[44],m[45],m[46]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewsalesOrderForPacking ends");
		return getRequisitionTypeList;
	}

	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deletesalesOrder(RestSaleOrderNewModel deletesalesOrder) {
		logger.info("Method : deletesalesOrder starts");
		logger.info("restSaleOrderNewModel" + deletesalesOrder);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateSaleOrderNewParameter.getDeleteParam(deletesalesOrder);
			logger.info(value);
			em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "deletesalesOrder")
					.setParameter("actionValue", value).execute();
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
		logger.info("Method : deletesalesOrder ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSOInsertedId() {
		logger.info("Method : getSOInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getSOInsertedId").setParameter("actionValue", "")
					.getResultList();

			Object jobId = x.get(0);
			DropDownModel dropDownModel = new DropDownModel(jobId,null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSOInsertedId ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesPoListt(String id) {

		logger.info("Method : getSalesPoListt starts");
		List<DropDownModel> salesPOList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getSalesPoListt").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesPOList.add(dropDownModel);
			}
			resp.setBody(salesPOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalesPoListt ends");
		return response;
	}	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> viewsalesOrderPoWise(String orgName, String orgDiv,String id) {
		logger.info("Method : viewsalesOrderPoWise Dao starts");

		List<RestSaleOrderNewModel> solist = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_poId='" + id + "';";
			logger.info("values****************************" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "viewsalesOrderPoWise").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object expDate = null;
				if (m[3] != null) {
					expDate =DateFormatter.returnStringDate(m[3]);
				}
 
				Object ordate = null;
				if (m[9] != null) {
					ordate =DateFormatter.returnStringDate(m[9]);
				}
				RestSaleOrderNewModel viewdemo = new RestSaleOrderNewModel(m[0],m[1], m[2],expDate,
						m[4], m[5], m[6],m[7],m[8],ordate,m[10].toString(),m[11].toString(),m[12]);
				solist.add(viewdemo);
			}
			resp.setBody(solist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesOrderPoWise Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}
	
	//Block Order
	
		public JsonResponse<RestSaleOrderNewModel> blockSaleOrderItem(String blockeOrder, String salesOrder,String sku) {
				logger.info("Method : blockSaleOrderItem starts");

				RestSaleOrderNewModel req = new RestSaleOrderNewModel();
				JsonResponse<RestSaleOrderNewModel> resp = new JsonResponse<RestSaleOrderNewModel>();
				try {
					
					String value = "SET @p_blockeOrder='" + blockeOrder + "',@p_salesOrder='" + salesOrder + "',@p_sku='" + sku + "';";
					logger.info("value==="+value);
					em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "blockSaleOrderItem")
							.setParameter("actionValue", value).execute();
					resp.setBody(req);
					resp.setCode("success");
					resp.setMessage("Blocked successfully");
					
				//	List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id,name);
				/*
				 * for(DropDownModel m : managerByUesr) { String
				 * msg=m.getName()+" approved your Leave"; try { String msgId =
				 * pushNotification.pushFCMNotification(m.getKey(),msg); } catch (Exception e) {
				 * e.printStackTrace(); } }
				 */
					
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				logger.info("resp==="+resp);
				logger.info("Method : blockSaleOrderItem ends");
				return resp;
			}
		
		// approve 


		public JsonResponse<RestSaleOrderNewModel> approveSaleOrder(String approveStatus, String salesOrder,String pendingQut) {
				logger.info("Method : approveSaleOrder starts");

				RestSaleOrderNewModel req = new RestSaleOrderNewModel();
				JsonResponse<RestSaleOrderNewModel> resp = new JsonResponse<RestSaleOrderNewModel>();
				try {
					
					String value = "SET @p_approveStatus='" + approveStatus + "',@p_salesOrder='" + salesOrder + "',@p_pendingQut='" + pendingQut + "';";
					logger.info("value==="+value);
					em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "approveSaleOrder")
							.setParameter("actionValue", value).execute();
					resp.setBody(req);
					resp.setCode("success");
					resp.setMessage("Approved successfully");
					
				//	List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id,name);
				/*
				 * for(DropDownModel m : managerByUesr) { String
				 * msg=m.getName()+" approved your Leave"; try { String msgId =
				 * pushNotification.pushFCMNotification(m.getKey(),msg); } catch (Exception e) {
				 * e.printStackTrace(); } }
				 */
					
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				logger.info("resp==="+resp);
				logger.info("Method : approveSaleOrder ends");
				return resp;
			}
			
}

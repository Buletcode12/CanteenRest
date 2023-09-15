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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GeneratePoOrWoParamater;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestPoOrWoModel;


@Repository
public class RestPoOrWoDao {
	Logger logger = LoggerFactory.getLogger(RestPoOrWoDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> addSalesPo(
			List<RestPoOrWoModel> restPoOrWoModel) {

		logger.info("Method : addSalesPo starts");

		logger.info("RestPoOrWoModel" + restPoOrWoModel);
		JsonResponse<List<RestPoOrWoModel>> resp = new JsonResponse<List<RestPoOrWoModel>>();
		List<RestPoOrWoModel> listData = new ArrayList<RestPoOrWoModel>();

		try {
			String values = GeneratePoOrWoParamater.getAddPoParam(restPoOrWoModel);
			//logger.info("restPoOrWoModel#" + restPoOrWoModel);

			if (restPoOrWoModel.get(0).getReferenceId() == null
					|| restPoOrWoModel.get(0).getReferenceId() == "") {
				logger.info("ADD#" + values);
				em.createNamedStoredProcedureQuery("salesPurchaseOrder")
						.setParameter("actionType", "addSalesPo").setParameter("actionValue", values).execute();
			} else {
				logger.info("@restPoOrWoModel" + restPoOrWoModel);
				 em.createNamedStoredProcedureQuery("salesPurchaseOrder")
						.setParameter("actionType", "modifySalesPo").setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> response = new ResponseEntity<JsonResponse<List<RestPoOrWoModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addSalesPo ends");
		return response;
	}
	
	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> viewsalesPo(String orgName, String orgDiv) {
		logger.info("Method : viewsalesPo Dao startssssssssssssssssssssss");

		List<RestPoOrWoModel> getAllemployee = new ArrayList<RestPoOrWoModel>();
		JsonResponse<List<RestPoOrWoModel>> resp = new JsonResponse<List<RestPoOrWoModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "viewsalesPo").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object expDate = null;
				if (m[8] != null) {
					expDate = m[8].toString();
				}
 
				Object ordate = null;
				if (m[3] != null) {
					ordate = m[3].toString();
				}
				Object orderdate = null;
				if (m[12] != null) {
					orderdate = m[12].toString();
				}

				RestPoOrWoModel viewdemo = new RestPoOrWoModel(m[0],m[1], m[2],
						ordate,m[4], m[5], m[6],m[7],expDate,m[9],m[10],m[11],orderdate);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> response = new ResponseEntity<JsonResponse<List<RestPoOrWoModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesPo Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPoOrWoModel> viewsalesPoEdit(String id,String orgName, String orgDiv) {
		logger.info("Method : viewsalesPoEdit starts");
		logger.info("RestPoOrWoModel" + id);
		List<RestPoOrWoModel> getRequisitionTypeList = new ArrayList<RestPoOrWoModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_poId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "viewsalesPoEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					Object podate = null;
					if (m[3] != null) {
						podate = m[3].toString();
					}
					Object sDate = null;
					if (m[29] != null) {
						sDate = m[29].toString();
					}
					Object soDate = null;
					if (m[46] != null) {
						soDate = m[46].toString();
					}
					
					RestPoOrWoModel dropDownModel = new RestPoOrWoModel(m[0],m[1],m[2],podate,m[4],
							m[5],null,m[6],m[7],null,
							m[8],null,m[9],m[10],m[11],m[12],m[13],
							m[14],m[15],m[16],m[17],m[18],m[19],
							m[20],m[21],m[22],m[23],m[24],null,m[25],
							null,m[26],m[27],m[28],null,
							null,sDate,m[30],m[31],
							m[32],m[33],null,m[34],m[35],m[36],
							m[37],m[38],m[39],m[40],m[41],m[42],m[43],null,m[44],m[45],soDate,null,m[47],null,m[48],m[49]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getReferenceId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
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
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : viewsalesPoEdit ends");
		return getRequisitionTypeList;
	}
	
	/*delete
	 * 	
	 */
		public ResponseEntity<JsonResponse<Object>> deleteSalesPo(RestPoOrWoModel deletePo) {
			logger.info("Method : deleteSalesPo starts");
			
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			try {
				String value = GeneratePoOrWoParamater.getDeleteSalesPo(deletePo);
				//logger.info(value);
				em.createNamedStoredProcedureQuery("salesPurchaseOrder")
						.setParameter("actionType", "deleteSalesPo").setParameter("actionValue", value).execute();
				//logger.info("print block" + deletesalesInvoice);
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
			//logger.info("@@@@@@@@@@@@@@@@" + deletesalesInvoice);
			logger.info("Method : deleteSalesPo ends");
			return response;
		}
		
		
		@SuppressWarnings("unchecked")
		public List<RestPoOrWoModel> getSoData(String id,String skuid,String orgName, String orgDiv) {
			logger.info("Method : getSoData starts");
			logger.info("RestPoOrWoModel" + id);
			List<RestPoOrWoModel> getRequisitionTypeList = new ArrayList<RestPoOrWoModel>();
			List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
			try {
				String values = "SET @p_poId='" + id + "',@p_skuid='(" + skuid+")',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info(values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
						.setParameter("actionType", "getSoData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						Object podate = null;
						if (m[3] != null) {
							podate = m[3].toString();
						}
						Object sDate = null;
						if (m[29] != null) {
							sDate = m[29].toString();
						}
						
						RestPoOrWoModel dropDownModel = new RestPoOrWoModel(m[0],m[1],m[2],podate,m[4],
								m[5],null,m[6],m[7],null,
								m[8],null,m[9],m[10],m[11],m[12],m[13],
								m[14],m[15],m[16],m[17],m[18],m[19],
								m[20],m[21],m[22],m[23],m[24],null,m[25],
								null,m[26],m[27],m[28],null,
								null,sDate,m[30],m[31],
								m[32],m[33],null,m[34],m[35],m[36],
								m[37],m[38],m[39],m[40],m[41],m[42],m[43],null,null,null,null,null,null,null,m[44],null);
						getRequisitionTypeList.add(dropDownModel);
						logger.info("print edit" + getRequisitionTypeList);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getReferenceId() + "';";
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
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
			logger.info("@@@@@@@@edit" + getRequisitionTypeList);
			logger.info("Method : getSoData ends");
			return getRequisitionTypeList;
		}

//Block Order
		
		/*
		 * public JsonResponse<RestPoOrWoModel> blockSaleOrder(String blockeOrder,
		 * String referenceId,String sku) {
		 * logger.info("Method : blockSaleOrder starts");
		 * 
		 * RestPoOrWoModel req = new RestPoOrWoModel(); JsonResponse<RestPoOrWoModel>
		 * resp = new JsonResponse<RestPoOrWoModel>(); try {
		 * 
		 * String value = "SET @p_blockeOrder='" + blockeOrder + "',@p_referenceId='" +
		 * referenceId + "',@p_sku='" + sku + "';";
		 * logger.info("value==="+value);
		 * em.createNamedStoredProcedureQuery("salesPurchaseOrder").setParameter(
		 * "actionType", "blockSaleOrder") .setParameter("actionValue",
		 * value).execute(); resp.setBody(req); resp.setCode("success");
		 * resp.setMessage("approveItemQuatation successfully");
		 * 
		 * 
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); } logger.info("resp==="+resp);
		 * logger.info("Method : blockSaleOrder ends"); return resp; }
		 */
		@SuppressWarnings("unchecked")
		public List<RestPoOrWoModel> viewsalesCreateversionEdit(String id,String orgName, String orgDiv) {
			logger.info("Method : viewsalesCreateversionEdit starts");
			logger.info("RestPoOrWoModel" + id);
			List<RestPoOrWoModel> getRequisitionTypeList = new ArrayList<RestPoOrWoModel>();
			List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
			try {
				String values = "SET @p_poId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info(values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
						.setParameter("actionType", "viewsalesCreateversionEdit").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						Object podate = null;
						if (m[3] != null) {
							podate = m[3].toString();
						}
						Object sDate = null;
						if (m[29] != null) {
							sDate = m[29].toString();
						}
						Object soDate = null;
						if (m[46] != null) {
							soDate = m[46].toString();
						}
						
						RestPoOrWoModel dropDownModel = new RestPoOrWoModel(m[0],m[1],m[2],podate,m[4],
								m[5],null,m[6],m[7],null,
								m[8],null,m[9],m[10],m[11],m[12],m[13],
								m[14],m[15],m[16],m[17],m[18],m[19],
								m[20],m[21],m[22],m[23],m[24],null,m[25],
								null,m[26],m[27],m[28],null,
								null,sDate,m[30],m[31],
								m[32],m[33],null,m[34],m[35],m[36],
								m[37],m[38],m[39],m[40],m[41],m[42],m[43],null,m[44],m[45],soDate,null,m[47].toString(),m[48],m[49],null);
						getRequisitionTypeList.add(dropDownModel);
						logger.info("print edit" + getRequisitionTypeList);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getReferenceId() + "';";
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
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
			logger.info("@@@@@@@@edit" + getRequisitionTypeList);
			logger.info("Method : viewsalesCreateversionEdit ends");
			return getRequisitionTypeList;
		}
}

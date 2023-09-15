package nirmalya.aatithya.restmodule.purchase.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateManageInvoiceParameter;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateQaRequestParam;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestQaRequestModel;

@Repository
public class RestManageInvoiceDao {
	Logger logger = LoggerFactory.getLogger(RestManageInvoiceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceInsertedId() {
		logger.info("Method : getInvoiceInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getInvoiceInsertedId").setParameter("actionValue", "").getResultList();

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
		logger.info("Method : getInvoiceInsertedId ends");
		return response;
	}

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> addInvoice(
			List<RestManageInvoiceModel> restManageInvoiceModel) {

		logger.info("Method : addInvoice starts");

		// logger.info("RestManageInvoiceModel" + restManageInvoiceModel);
		JsonResponse<List<RestManageInvoiceModel>> resp = new JsonResponse<List<RestManageInvoiceModel>>();
		List<RestManageInvoiceModel> listData = new ArrayList<RestManageInvoiceModel>();

		try {
			String values = GenerateManageInvoiceParameter.getAddInvoice(restManageInvoiceModel);

			logger.info("ADDDDD" + values);

			if (restManageInvoiceModel.get(0).getInvoiceId() == null
					|| restManageInvoiceModel.get(0).getInvoiceId() == "") {

				em.createNamedStoredProcedureQuery("action_invoice_Routines").setParameter("actionType", "addInvoice")
						.setParameter("actionValue", values).execute();

			} else {
				logger.info("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("action_invoice_Routines")
						.setParameter("actionType", "modifyInvoice").setParameter("actionValue", values).execute();

				// logger.info("modify printttttttttttttttttt" + listData);

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
		ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data issssssssssssssssssssss" + response);
		logger.info("Method : addInvoice ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> viewInvoice(String orgName, String orgDiv) {
		logger.info("Method : viewInvoice Dao startssssssssssssssssssssss");

		List<RestManageInvoiceModel> getAllemployee = new ArrayList<RestManageInvoiceModel>();
		JsonResponse<List<RestManageInvoiceModel>> resp = new JsonResponse<List<RestManageInvoiceModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "viewInvoice").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}
				Object dueDate = null;
				if (m[7] != null) {
					dueDate = m[7].toString();
				}

				RestManageInvoiceModel viewdemo = new RestManageInvoiceModel(m[0], m[1], m[2], m[3], createdOn, m[5],
						m[6], dueDate, m[8], m[9], m[10], m[11], m[12],m[13]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewInvoice Dao ends");
		logger.info("aaaaaaaaaaaaaaaaaaaaaa" + response);
		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestManageInvoiceModel> viewInvoiteEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewInvoiteEdit starts");
		logger.info("RestManageInvoiceModel" + id);
		List<RestManageInvoiceModel> getRequisitionTypeList = new ArrayList<RestManageInvoiceModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_invoiceId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "viewInvoiteEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					logger.info("DATAAAAAAAA"+Arrays.toString(m));
					Object createdOn1 = null;
					if (m[4] != null) {
						createdOn1 = m[4].toString();
					}
					Object createdOn2 = null;
					if (m[14] != null) {
						createdOn2 = m[14].toString();
					}
					/*
					 * Object createdOn3 = null; if (m[15] != null) { createdOn3 = m[15].toString();
					 * }
					 */

					Object createdOn4 = null;
					if (m[40] != null) {
						createdOn4 = m[40].toString();
					}
					double rcv = 0;
					if (m[48] != null) {
						rcv = Double.parseDouble(m[48].toString());
					}
					Object cdate = null;
					if (m[60] != null) {
						cdate = m[60].toString();
					}
					//m[35]
					 //m[25]
					RestManageInvoiceModel dropDownModel = new RestManageInvoiceModel(m[0], m[1], m[2], m[3],
							createdOn1, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], createdOn2, m[15],
							m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28],
							m[29], m[30], m[31], m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], createdOn4,
							m[41], m[42], m[43], m[44], m[45], m[46], m[47], rcv, m[49], m[50], m[51], m[52], m[53],
							m[54], m[55], m[56], m[57], m[58], m[59], cdate,m[61],m[62]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_invoiceId='" + getRequisitionTypeList.get(0).getInvoiceId() + "';";
				logger.info("DOCUMRNt" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("action_invoice_Routines")
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
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewInvoiteEdit ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPoList(String id, String type, String orgName,
			String orgDiv) {

		logger.info("Method : getPoList starts");
		List<DropDownModel> salesInvoiceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_vendorId='" + id + "',@p_type='" + type + "',@p_org='" + orgName + "',@p_orgDiv='"
				+ orgDiv + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getPoList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesInvoiceList.add(dropDownModel);
				// logger.info("stateeeeeeeeeee"+dropDownModel);
			}

			resp.setBody(salesInvoiceList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("stateeeeeeeeeee======" + response);
		logger.info("Method : getPoList ends");
		return response;
	}

	/*
	 * delete
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> deleteInvoice(RestManageInvoiceModel deleteInvoice) {
		logger.info("Method : deleteInvoice starts");
		// logger.info("restDeliveryChallanModel" + deletesalesDeliveryChallan);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateManageInvoiceParameter.getDeleteInvoice(deleteInvoice);
			// logger.info(value);
			em.createNamedStoredProcedureQuery("action_invoice_Routines").setParameter("actionType", "deleteInvoice")
					.setParameter("actionValue", value).execute();
			// logger.info("print block" + deletesalesInvoice);
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
		// logger.info("@@@@@@@@@@@@@@@@" + deletesalesInvoice);
		logger.info("Method : deleteInvoice ends");
		return response;
	}

	/************************ Invoice PDF View **********************/

	@SuppressWarnings("unchecked")
	public List<RestManageInvoiceModel> viewInvoiceViewPdf(String id, String orgName, String orgDiv) {
		logger.info("Method : viewsalesInvoiceViewPdf starts");
		List<RestManageInvoiceModel> getRequisitionTypeList = new ArrayList<RestManageInvoiceModel>();
		try {
			String values = "SET @p_invoiceId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "viewInvoiceViewPdf").setParameter("actionValue", values)
					.getResultList();

			try {
				for (Object[] m : x) {
					logger.info(Arrays.toString(m));
					Object createdOnp = null;
					if (m[4] != null) {
						createdOnp = m[4].toString();
					}
					Object pcreatedOn = null;
					if (m[20] != null) {
						pcreatedOn = m[20].toString();
					}
					Object createdOnp3 = null;
					if (m[15] != null) {
						createdOnp3 = m[15].toString();
					}
					Object createdOnp4 = null;
					if (m[44] != null) {
						createdOnp4 = m[44].toString();
					}

					RestManageInvoiceModel dropDownModel = new RestManageInvoiceModel(m[0], m[1], m[2], m[3],
							createdOnp, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], createdOnp3,
							m[16], m[17], m[18], m[19], pcreatedOn, m[21], m[22], m[23], m[24], m[25], m[26], m[27],
							m[28], m[29], m[30], m[31], m[32], m[33], m[34], m[35], m[36], null, m[37], m[38], m[39],
							m[40], m[41], m[42], m[43], createdOnp4, m[45], m[46], m[47], m[48], m[49], m[50], m[51],
							null, null, null, null, null, null, null, null,null,null);
					logger.info("========================" + dropDownModel);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// logger.info("========================"+getRequisitionTypeList);
		logger.info("Method : viewsalesOrdeerEdit ends");
		return getRequisitionTypeList;
	}

	public ResponseEntity<JsonResponse<Object>> grnReturn(RestManageInvoiceModel returnInvoice) {
		logger.info("Method : returnInvoice starts");
		// logger.info("restDeliveryChallanModel" + deletesalesDeliveryChallan);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		logger.info("@@@@" + returnInvoice);

		try {
			String value = GenerateManageInvoiceParameter.getReturnInvoice(returnInvoice);
			logger.info("4242424242424" + value);
			em.createNamedStoredProcedureQuery("action_invoice_Routines").setParameter("actionType", "returnInvoice")
					.setParameter("actionValue", value).execute();
			// logger.info("print block" + deletesalesInvoice);
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
		// logger.info("@@@@@@@@@@@@@@@@" + deletesalesInvoice);
		logger.info("Method : returnInvoice ends");
		return response;

	}

	/*
	 * edit for grn return
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestManageInvoiceModel> viewInvoiceEditForReturn(String id, String hsnCode, String orgName,
			String orgDiv) {
		logger.info("Method : viewInvoiceEditForReturn starts");
		logger.info("RestManageInvoiceModel" + id);
		List<RestManageInvoiceModel> getRequisitionTypeList = new ArrayList<RestManageInvoiceModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_invoiceId='" + id + "',@p_sku='(" + hsnCode + ")',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";

			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "viewInvoiceEditForReturn").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					logger.info(Arrays.toString(m));
//					Object createdOn1 = null;
//					if (m[4] != null) {
//						createdOn1 = m[4].toString();
//					}
					Object createdOn2 = null;
					if (m[30] != null) {
						createdOn2 = m[30].toString();
					}

					double rtrn = 0;
					if (m[37] != null) {
						rtrn = Double.parseDouble(m[37].toString());
					}

					RestManageInvoiceModel dropDownModel = new RestManageInvoiceModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], createdOn2,
							m[31], m[32], m[33], m[34], m[35], m[36], rtrn,m[38]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_invoiceId='" + getRequisitionTypeList.get(0).getInvoiceId() + "';";
				logger.info("DOCUMRNt" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("action_invoice_Routines")
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
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewInvoiceEditForReturn ends");
		return getRequisitionTypeList;
	}

	// approve

	public JsonResponse<DropDownModel> approveinvoice(String approveStatus, String invoiceId, String orgName,
			String orgDivision) {
		logger.info("Method : approveinvoice starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_invoiceId='" + invoiceId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("action_invoice_Routines").setParameter("actionType", "approveinvoice")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : approveinvoice ends");
		return resp;
	}

	// QA- Request Add

	public ResponseEntity<JsonResponse<List<RestQaRequestModel>>> saveQaRequest(List<RestQaRequestModel> data) {
		logger.info("Method : saveQaRequest dao starts");
		JsonResponse<List<RestQaRequestModel>> resp = new JsonResponse<List<RestQaRequestModel>>();
		List<RestQaRequestModel> listData = new ArrayList<RestQaRequestModel>();

		logger.info("=====>>>>>" + data);
		logger.info("listData=====>>>>>" + listData);

		try {
			String values = GenerateQaRequestParam.addQaRequestParam(data);
			em.createNamedStoredProcedureQuery("awaiting_quality_assurance_routines")
					.setParameter("actionType", "saveQaRequest").setParameter("actionValue", values).execute();
			resp.setCode("success");
			resp.setMessage("Data Saved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		logger.info("list Data IS======== " + listData);
		ResponseEntity<JsonResponse<List<RestQaRequestModel>>> response = new ResponseEntity<JsonResponse<List<RestQaRequestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : saveQaRequest dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorList(String id, String orgName, String orgDiv) {

		logger.info("Method : getVendorList starts");
		List<DropDownModel> referenceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				referenceList.add(dropDownModel);
			}
			resp.setBody(referenceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getVendorList ends" + response);
		return response;
	}
}

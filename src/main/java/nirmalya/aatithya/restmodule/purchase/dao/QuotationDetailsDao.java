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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseQuotationDetails;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestQuotationDetailsModel;

@Repository
public class QuotationDetailsDao {

	Logger logger = LoggerFactory.getLogger(QuotationDetailsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReferenceInquiry() {
		logger.info("Method : getReferenceInquiry starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "getReferenceInquiry").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getReferenceInquiry ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuotationInsertedId() {
		logger.info("Method : getQuotationInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "getQuotationInsertedId").setParameter("actionValue", "")
					.getResultList();

			Object jobId = x.get(0);
			// logger.info("job id--------" + jobId);

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

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> addquotationDetails(
			List<RestQuotationDetailsModel> restQuotationDetailsModel) {

		logger.info("Method : addquotationDetails starts");

		// logger.info("RestQuotationDetailsModel" + RestQuotationDetailsModel);
		JsonResponse<List<RestQuotationDetailsModel>> resp = new JsonResponse<List<RestQuotationDetailsModel>>();
		List<RestQuotationDetailsModel> listData = new ArrayList<RestQuotationDetailsModel>();

		try {

			String values = GeneratePurchaseQuotationDetails.getAddPurchaseQuotation(restQuotationDetailsModel);

			logger.info("IDd" + restQuotationDetailsModel.get(0).getQuotationId());
			if (restQuotationDetailsModel.get(0).getQuotationId() == null
					|| restQuotationDetailsModel.get(0).getQuotationId() == "") {
				logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);

				em.createNamedStoredProcedureQuery("QuotationDetails").setParameter("actionType", "addquotationDetails")
						.setParameter("actionValue", values).execute();

			} else {

				// logger.info("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("QuotationDetails")
						.setParameter("actionType", "modifyquotationDetails").setParameter("actionValue", values)
						.execute();

				logger.info("modify printttttttttttttttttt" + listData);

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
		ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data issssssssssssssssssssss" + response);
		logger.info("Method : addquotationDetails ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> viewquotationdetails(String orgName,
			String orgDiv) {
		logger.info("Method : viewPurchaseOrder Dao startssssssssssssssssssssss");

		List<RestQuotationDetailsModel> getAllemployee = new ArrayList<RestQuotationDetailsModel>();
		JsonResponse<List<RestQuotationDetailsModel>> resp = new JsonResponse<List<RestQuotationDetailsModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "viewquotationdetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[6] != null) {
					createdOn = m[6].toString();
				}

				RestQuotationDetailsModel viewdemo = new RestQuotationDetailsModel(m[0], m[1], m[2], m[3].toString(),
						m[4], m[5], null, createdOn, null, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
						m[16], m[17], m[18]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewquotationdetails Dao ends");

		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestQuotationDetailsModel> viewPurchaseQutEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewPurchaseQutEdit starts");
		// logger.info("RestDeliveryChallanModel" + id);
		List<RestQuotationDetailsModel> getRequisitionTypeList = new ArrayList<RestQuotationDetailsModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_quoId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "viewPurchaseQutEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object createdOn = null;
					if (m[31] != null) {
						createdOn = m[31].toString();
					}
					Object createdOn1 = null;
					if (m[3] != null) {
						createdOn1 = m[3].toString();
					}
					Boolean boolean1 = false;
					if (m[20].toString() != null) {
						String data = m[20].toString();
						if (data.contentEquals("Same State")) {
							boolean1 = true;
						} else {
							boolean1 = false;
						}
					}

					RestQuotationDetailsModel dropDownModel = new RestQuotationDetailsModel(m[0], m[1], m[2],
							createdOn1, m[4], m[5], m[6], m[7], m[8], null, m[9], m[10], m[11], m[12], m[13], m[14],
							m[15], m[16], m[17], m[18], m[19], boolean1, m[21], m[22], m[23], m[24], null, m[25], m[26],
							m[27], m[28], m[29], null, m[30], createdOn, null, null, m[32], m[33], m[34], m[35], m[36],
							m[37], null, m[38], null, m[39], m[40], null, null, m[41], m[42], m[43], m[44], m[45],
							m[46]);
					getRequisitionTypeList.add(dropDownModel);
					// logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quoId='" + getRequisitionTypeList.get(0).getQuotationId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("QuotationDetails")
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
		logger.info("Method : viewPurchaseQutEdit ends");
		return getRequisitionTypeList;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deletequotationDetails(String id) {
		logger.info("Method : deletequotationDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_quotId='" + id + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("QuotationDetails")
						.setParameter("actionType", "deletequotationDetails").setParameter("actionValue", value)
						.execute();

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

		logger.info("Method : deletequotationDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPaymentModeList() {
		logger.info("Method : getPaymentModeList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "getPaymentModeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPaymentModeList ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getReferenceList(String id, String orgName,
			String orgDiv) {

		logger.info("Method : getReferenceList starts");
		List<DropDownModel> referenceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		// String value = "SET @p_vendorId='" + id + "';";
		String value = "SET @p_vendorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "getReferenceList").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getReferenceList ends");
		return response;
	}

	// approve

	public JsonResponse<DropDownModel> approveQuotation(String approveStatus, String quotationId, String orgName,
			String orgDivision) {
		logger.info("Method : approvePorder starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			// String value = "SET @p_approveStatus='" + approveStatus +
			// "',@p_quotationId='" + quotationId + "', @p_org='" + orgName +
			// "',@p_orgDiv='" + orgDivision + "';";

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_quotationId='" + quotationId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("QuotationDetails").setParameter("actionType", "approveQuotation")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : approveQuotation ends");
		return resp;
	}
	// item against po id

	@SuppressWarnings("unchecked")
	public List<RestQuotationDetailsModel> getReferenceItemDetails(String id, String taxType1, String org, String div) {
		logger.info("Method : getReferenceItemDetails starts");
		List<RestQuotationDetailsModel> getRequisitionTypeList = new ArrayList<RestQuotationDetailsModel>();
		try {

			String values = "SET @p_refId='" + id + "', @p_taxType='" + taxType1 + "' ,@p_org='" + org
					+ "' ,@p_orgDiv='" + div + "';";
			logger.info("DATA" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "getReferenceItemDetails").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object DATE = null;
					if (m[10] != null) {
						DATE = DateFormatter.returnStringDate(m[10]);
					}
					double igst = 0;
					if (m[11] != null) {
						igst = Double.parseDouble(m[11].toString());
					}
					double cgst = 0;
					if (m[12] != null) {
						cgst = Double.parseDouble(m[12].toString());
					}
					double sgst = 0;
					if (m[13] != null) {
						sgst = Double.parseDouble(m[13].toString());
					}
					double txblAmt = 0;
					if (m[14] != null) {
						txblAmt = Double.parseDouble(m[14].toString());
					}
					double gstRate = 0;
					if (m[15] != null) {
						gstRate = Double.parseDouble(m[15].toString());
					}

					RestQuotationDetailsModel dropDownModel = new RestQuotationDetailsModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7], m[8], m[9], DATE, igst, cgst, sgst, txblAmt, gstRate, m[16], null,
							null);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : getReferenceItemDetails ends");
		logger.info("DATAtertrh" + getRequisitionTypeList);
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRfqListByAutoSearch(String id) {
		logger.info("Method : getRfqListByAutoSearch starts");

		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "getRFQName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();

		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getRfqListByAutoSearch ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> rfqQuotationCompare(String id, String orgName,
			String orgDiv) {
		logger.info("Method : rfqQuotationCompare Dao starts");

		List<RestQuotationDetailsModel> getAllemployee = new ArrayList<RestQuotationDetailsModel>();
		JsonResponse<List<RestQuotationDetailsModel>> resp = new JsonResponse<List<RestQuotationDetailsModel>>();

		try {
			String value = "SET @p_rfqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "getQtnDtls").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[6] != null) {
					createdOn = m[6].toString();
				}

				RestQuotationDetailsModel viewdemo = new RestQuotationDetailsModel(m[0], m[1], m[2], m[3].toString(),
						m[4], m[5], null, createdOn, null, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
						m[16], m[17], m[18]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : rfqQuotationCompare Dao ends");

		return response;

	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRfqListForQuotation() {
		logger.info("Method : getRfqListForQuotation starts");
		
		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("QuotationDetails")
					.setParameter("actionType", "getRFQName").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getRfqListForQuotation ends");
		return modeList;
	}



}

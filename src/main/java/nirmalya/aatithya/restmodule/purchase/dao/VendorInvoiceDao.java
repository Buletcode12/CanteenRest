package nirmalya.aatithya.restmodule.purchase.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateVendorInvoiceParam;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.VendorInvoiceRestModel;

@Repository
public class VendorInvoiceDao {
	Logger logger = LoggerFactory.getLogger(VendorInvoiceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<VendorInvoiceRestModel>>> addVendorInvoicenew(
			List<VendorInvoiceRestModel> VendorInvoiceRestModel) {
		logger.info("Method : addVendorInvoicenew starts");

		JsonResponse<List<VendorInvoiceRestModel>> resp = new JsonResponse<List<VendorInvoiceRestModel>>();
		List<VendorInvoiceRestModel> listData = new ArrayList<VendorInvoiceRestModel>();

		try {
			String values = GenerateVendorInvoiceParam.getAddInvoiceParam(VendorInvoiceRestModel);
			if (VendorInvoiceRestModel.get(0).getVendorInvoice() == null
					|| VendorInvoiceRestModel.get(0).getVendorInvoice() == "") {
				System.out.println("ADDDDDDDDDDDDDDDDDDS#" + values);
				em.createNamedStoredProcedureQuery("vendor_Invoice_routines")
						.setParameter("actionType", "addVendorInvoicenew").setParameter("actionValue", values)
						.execute();
			} else {
				System.out.println("MODIFY====#" + values);
				em.createNamedStoredProcedureQuery("vendor_Invoice_routines")
						.setParameter("actionType", "modifyVendorInvoicenew").setParameter("actionValue", values)
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
		ResponseEntity<JsonResponse<List<VendorInvoiceRestModel>>> response = new ResponseEntity<JsonResponse<List<VendorInvoiceRestModel>>>(
				resp, HttpStatus.CREATED);
		// System.out.println("response data is" + response);
		logger.info("Method : addVendorInvoicenew ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<VendorInvoiceRestModel>> viewVendorInvoice(String userId, String organization,
			String orgDivision) {
		logger.info("Method : viewVendorInvoice Dao starts");

		List<VendorInvoiceRestModel> invoiceList = new ArrayList<VendorInvoiceRestModel>();
		JsonResponse<List<VendorInvoiceRestModel>> resp = new JsonResponse<List<VendorInvoiceRestModel>>();

		try {
			String value = "SET @p_userId='" + userId + "', @p_org='" + organization + "', @p_orgDiv='"
					+ orgDivision + "';";
			 System.out.println("value===="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_Invoice_routines")
					.setParameter("actionType", "viewVendorInvoice").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object invoiceDate = null;
				if (m[3] != null) {
					invoiceDate = DateFormatter.returnStringDate(m[3]);
				}
				Object dueDate = null;
				if (m[8] != null) {
					dueDate = DateFormatter.returnStringDate(m[8]);
				}
				
				VendorInvoiceRestModel viewdemo = new VendorInvoiceRestModel(m[0], m[1], m[2], invoiceDate, m[4], m[5],
						m[6], m[7], dueDate, null);

				 invoiceList.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(invoiceList);
		System.out.println("resp=====" + resp);
		logger.info("Method : viewVendorInvoice Dao ends");

		return resp;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<VendorInvoiceRestModel> viewVendorIvoiceEdit(String id, String organization, String orgDivision) {
		logger.info("Method : viewVendorIvoiceEdit starts");
		// System.out.println("VendorInvoiceRestModel" + id);
		List<VendorInvoiceRestModel> getRequisitionTypeList = new ArrayList<VendorInvoiceRestModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_vendorInvoice='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			// System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_Invoice_routines")
					.setParameter("actionType", "viewVendorIvoiceEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object InvDATE = null;
					if (m[4] != null) {
						InvDATE = DateFormatter.returnStringDate(m[4]);
					}
					Object DueDate = null;
					if (m[6] != null) {
						DueDate = DateFormatter.returnStringDate(m[6]);
					}
					
					VendorInvoiceRestModel dropDownModel = new VendorInvoiceRestModel(m[0], m[1], m[2], m[3], InvDATE,
							m[5], DueDate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30],
							m[31], m[32], m[33], m[34], m[35], m[36], m[37],m[38]);
					getRequisitionTypeList.add(dropDownModel);
					 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * try { String subValues = "SET @p_quotationId='" +
			 * getRequisitionTypeList.get(0).getVendorInvoice() + "';"; List<Object[]> x1 =
			 * em.createNamedStoredProcedureQuery("vendor_Invoice_routines")
			 * .setParameter("actionType", "getVendorDocs").setParameter("actionValue",
			 * subValues) .getResultList(); for (Object[] m : x1) {
			 * 
			 * InventoryVendorDocumentModel dropDownModel = new
			 * InventoryVendorDocumentModel(m[0], m[1], m[2]); docList.add(dropDownModel); }
			 * } catch (Exception e) {
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		//getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : viewVendorIvoiceEdit ends");
		return getRequisitionTypeList;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteVendorInvoice(String id, String organization,
			String orgDivision) {
		logger.info("Method : deleteVendorInvoice starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_dId='" + id + "',@p_org='" + organization + "' ,@p_orgDiv='" + orgDivision
						+ "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("vendor_Invoice_routines")
						.setParameter("actionType", "deleteVendorInvoice").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteVendorInvoice ends");
		return response;
	}
}

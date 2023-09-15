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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateVendorDeliveryChallanParam;
import nirmalya.aatithya.restmodule.purchase.model.VendorDeliveryChallanModel;

@Repository
public class VendorDeliveryChallanDao {
	Logger logger = LoggerFactory.getLogger(VendorDeliveryChallanDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> addvendorDeliveryChallan(
			List<VendorDeliveryChallanModel> VendorDeliveryChallanModel) {

		logger.info("Method : addvendorDeliveryChallan starts");

		System.out.println("addvendorDeliveryChallan" + VendorDeliveryChallanModel);
		JsonResponse<List<VendorDeliveryChallanModel>> resp = new JsonResponse<List<VendorDeliveryChallanModel>>();
		List<VendorDeliveryChallanModel> listData = new ArrayList<VendorDeliveryChallanModel>();

		try {
			String values = GenerateVendorDeliveryChallanParam.getAddChallanParam(VendorDeliveryChallanModel);

			if (VendorDeliveryChallanModel.get(0).getVendorDeliveryChallan() == null
					|| VendorDeliveryChallanModel.get(0).getVendorDeliveryChallan() == "") {
				System.out.println("ADDDDDDDDDDDDDDDDDDS#" + values);

				em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
						.setParameter("actionType", "addvendorDeliveryChallan").setParameter("actionValue", values)
						.execute();

			} else {
				System.out.println("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
						.setParameter("actionType", "modifyDeliveryChallan").setParameter("actionValue", values)
						.execute();

				System.out.println("modify print" + listData);

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
		ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addvendorDeliveryChallan ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> viewvendordeliveryChallan(String orgName,
			String orgDiv,String userId) {
		logger.info("Method : viewvendordeliveryChallan Dao starts");

		List<VendorDeliveryChallanModel> getAllemployee = new ArrayList<VendorDeliveryChallanModel>();
		JsonResponse<List<VendorDeliveryChallanModel>> resp = new JsonResponse<List<VendorDeliveryChallanModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			System.out.println("values" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
					.setParameter("actionType", "viewvendordeliveryChallanDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}
				VendorDeliveryChallanModel viewdemo = new VendorDeliveryChallanModel(m[0], m[1], m[2], m[3], createdOn,
						m[5], m[6], m[7], null, null, m[8], m[9], null,m[10]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewvendordeliveryChallan Dao ends");

		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<VendorDeliveryChallanModel> viewDeliveryChallanEdit(String id, String orgName, String orgDivision) {
		logger.info("Method : viewDeliveryChallanEdit starts");
		// System.out.println("VendorDeliveryChallanModel" + id);
		List<VendorDeliveryChallanModel> getRequisitionTypeList = new ArrayList<VendorDeliveryChallanModel>();
		try {
			String values = "SET @p_vendorDeliveryChallan='" + id + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
					.setParameter("actionType", "viewDeliveryChallanEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object createdOn = null;
					if (m[25] != null) {
						createdOn = m[25].toString();
					}
					Object ebillDate = null;
					if (m[31] != null) {
						ebillDate = m[31].toString();
					}

					VendorDeliveryChallanModel dropDownModel = new VendorDeliveryChallanModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							m[18], m[19], m[20], m[21], m[22], m[23], m[24], createdOn, m[26], m[27], m[28], m[29],
							m[30], ebillDate, m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], m[40],m[41],m[42]);
					getRequisitionTypeList.add(dropDownModel);
					// System.out.println("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// getRequisitionTypeList.get(0).setDocumentList(docList);
		System.out.println("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewDeliveryChallanEdit ends");
		return getRequisitionTypeList;
	}

	/*
	 * delete
	 * 
	 */
	// delete

	public ResponseEntity<JsonResponse<Object>> deleteDeliveryChallan(String id) {
		logger.info("Method : deleteDeliveryChallan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_dId='" + id + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
						.setParameter("actionType", "deleteDeliveryChallan").setParameter("actionValue", value)
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

		logger.info("Method : deleteDeliveryChallan ends");
		System.out.println("DELETEE" + response);
		return response;
	}
}

package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseOrderRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseProductRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestSalesVoucherDao {

	Logger logger = LoggerFactory.getLogger(RestAccountDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> viewSalesVoucher(String orgName, String orgDiv) {
		logger.info("Method : viewSalesVoucher Dao startssssssssssssssssssssss");
		List<AccountPurchaseOrderRestModel> getAllemployee = new ArrayList<AccountPurchaseOrderRestModel>();
		JsonResponse<List<AccountPurchaseOrderRestModel>> resp = new JsonResponse<List<AccountPurchaseOrderRestModel>>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("restViewVendorDtls -----------"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "getSalesList").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				
				if (m[7] == null) {
					m[7] = "N/A";
				}
				
				AccountPurchaseOrderRestModel viewdemo = new AccountPurchaseOrderRestModel(m[0],m[1].toString(), m[2].toString(), m[3], m[4],
						m[5], m[6],m[7]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewSalesVoucher Dao ends"+response);
	
		return response;

	}
	
	// editAccountInfo
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> viewEditSalesVoucher(String id) {
			logger.info("Method : viewEditSalesVoucher starts");
			JsonResponse<List<AccountPurchaseOrderRestModel>> resp = new JsonResponse<List<AccountPurchaseOrderRestModel>>();
			List<AccountPurchaseOrderRestModel> rs = new ArrayList<AccountPurchaseOrderRestModel>();
			List<AccountPurchaseProductRestModel> prdoct = new ArrayList<AccountPurchaseProductRestModel>();
			
			System.out.println("rs.size()-------------"+rs.size());
			
			try {
				String value = "SET @p_salesId='" + id + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
						.setParameter("actionType", "editSalesView")
						.setParameter("actionValue", value).getResultList();
				System.out.println("asdfasdf" + x);

				for (Object[] m : x) {
					
					if (m[7] == null) {
						m[7] = "N/A";
					}
					
					AccountPurchaseOrderRestModel restPayroll = new AccountPurchaseOrderRestModel(m[0], m[1].toString(), m[2].toString(), m[3], m[4],
							m[5],m[6],m[7].toString(),m[8].toString(),m[9].toString(),m[10].toString(),m[11].toString(),m[12]);
					rs.add(restPayroll);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("rs.size()-------------"+rs.size());
			if (rs.size() > 0) {
				try {
					String subValues = "SET @p_salesId='" + id + "';";
					System.out.println(subValues);
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesAccountRoutines")
							.setParameter("actionType", "getProductDetails").setParameter("actionValue", subValues)
							.getResultList();
					for (Object[] m : x1) {
						
						System.out.println("discount value-----------------------------"+m[6]);
						
						if (m[6].equals("null")) {
							m[6] = "No Discount";
						}
						
						if (m[11] == null) {
							m[11] = 0.0;
						}

						AccountPurchaseProductRestModel dropDownModel = new AccountPurchaseProductRestModel(m[0], m[1], m[2], m[3].toString(),
								m[4], m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), m[13]);
						prdoct.add(dropDownModel);
					}
					rs.get(0).setProductList(prdoct);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			resp.setBody(rs);
			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}
			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : viewEditSalesVoucher ends");
			System.out.println(response);
			return response;
		}

}

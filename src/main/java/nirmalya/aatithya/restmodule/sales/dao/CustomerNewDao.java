package nirmalya.aatithya.restmodule.sales.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateProductMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateCustomerNewParameter;
import nirmalya.aatithya.restmodule.master.model.ProductDetailsModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;

@Repository
public class CustomerNewDao {

	Logger logger = LoggerFactory.getLogger(CustomerNewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * for add new assignSkill
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestCustoomerNewModel>> addAccountCustomer(
			RestCustoomerNewModel restCustoomerNewModel) {

		logger.info("Method in Dao: addAccountCustomer starts");

		JsonResponse<RestCustoomerNewModel> resp = new JsonResponse<RestCustoomerNewModel>();

		List<RestCustoomerNewModel> newProduct = new ArrayList<RestCustoomerNewModel>();

		try {
			String values = GenerateCustomerNewParameter.getAddCustParam(restCustoomerNewModel);
			if (restCustoomerNewModel.getCustomerId() == "" || restCustoomerNewModel.getCustomerId() == null) {

				List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
						.setParameter("actionType", "addCustomer").setParameter("actionValue", values).getResultList();
				logger.info("ddddddddddddd"+x.toString());
				for (Object[] m : x) {
					logger.info("ddddddddddddd"+Arrays.toString(m));
					RestCustoomerNewModel item = new RestCustoomerNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27]);
					
					newProduct.add(item);
					logger.info("@@@@@@@@@@@@"+newProduct);
				}
			} else {
				

				List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
						.setParameter("actionType", "modifyCustomer").setParameter("actionValue", values)
						.getResultList();

				for (Object[] m : x) {
					

					RestCustoomerNewModel item = new RestCustoomerNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27]);
					newProduct.add(item);
					
				}
			}

			resp.setBody(newProduct.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<RestCustoomerNewModel>> response = new ResponseEntity<JsonResponse<RestCustoomerNewModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: addAccountCustomer ends");

		return response;
	}

	// restViewCustDtls

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>> restViewCustDtls() {
		logger.info("Method : restViewCustDtls starts");
		List<RestCustoomerNewModel> respList = new ArrayList<RestCustoomerNewModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
					.setParameter("actionType", "getCustDetails").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				RestCustoomerNewModel cusData = new RestCustoomerNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7].toString(), m[8]);
				respList.add(cusData);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCustoomerNewModel>> resp = new JsonResponse<List<RestCustoomerNewModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>> response = new ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : restViewCustDtls ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		return response;

	}

	// deleteBankDetails

	public ResponseEntity<JsonResponse<Object>> deleteCusAccDetails(String id) {
		logger.info("Method : deleteCusAccDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String value = "SET  @p_customerId='(" + id + ")';";


				em.createNamedStoredProcedureQuery("customermaster").setParameter("actionType", "deleteCustomer")
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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  deleteCusAccDetails ends");
		return response;
	}

	// editAccCusInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>> editAccCusInfo(String id) {
		logger.info("Method : editAccCusInfo starts");

		JsonResponse<List<RestCustoomerNewModel>> resp = new JsonResponse<List<RestCustoomerNewModel>>();
		List<RestCustoomerNewModel> rs = new ArrayList<RestCustoomerNewModel>();

		try {

			String value = "SET @p_customerId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
					.setParameter("actionType", "editCustomerInfo").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestCustoomerNewModel restPayroll = new RestCustoomerNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20],
						m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33],
						m[34], m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44],null);
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>> response = new ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editAccCusInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		return response;
	}

	// getStateLists1

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateLists1(String id) {

		logger.info("Method : getStateLists1 starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStateLists1 ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestCustoomerNewModel>> saveAddressDetails(RestCustoomerNewModel product) {
		logger.info("Method : saveAddressDetails starts");
		JsonResponse<RestCustoomerNewModel> resp = new JsonResponse<RestCustoomerNewModel>();
		
		List<RestCustoomerNewModel> newProduct = new ArrayList<RestCustoomerNewModel>();
		try {
				String values = GenerateCustomerNewParameter.saveAddressDetails(product);
				System.out.println("value==="+values);
				if (product.getShippingId() != null && product.getShippingId() != "") {
					System.out.println("valuemodifyy");
					List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
							.setParameter("actionType", "modifyAddressDetails").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						RestCustoomerNewModel item = new RestCustoomerNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],m[11],m[12]);
						newProduct.add(item);
					}
				} else {
					System.out.println("valueaddd");
					List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
							.setParameter("actionType", "saveAddressDetails").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						RestCustoomerNewModel item = new RestCustoomerNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],m[11],m[12]);
						newProduct.add(item);
					}
					
				}
				
				resp.setBody(newProduct.get(0));
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
		
		ResponseEntity<JsonResponse<RestCustoomerNewModel>> response = new ResponseEntity<JsonResponse<RestCustoomerNewModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveAddressDetails ends"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewShippingDetails(String customerIdd,String orgName, String orgDivision) {
		logger.info("Method : viewShippingDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_customerId='" + customerIdd + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
					.setParameter("actionType", "viewShippingDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewShippingDetails Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editShippingDetails(String addressId,String orgName, String orgDivision) {
		logger.info("Method : editShippingDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_addressId='" + addressId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("customermaster")
					.setParameter("actionType", "editShippingDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : editShippingDetails Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteaddressdata(String deleteId,String orgName, String orgDiv) {
		logger.info("Method : deleteaddressdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_deleteId='" + deleteId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			 em.createNamedStoredProcedureQuery("customermaster")
					.setParameter("actionType", "deleteaddressdata").setParameter("actionValue", value)
					.execute();
			 resp.setCode("success");
			 resp.setMessage("Deleted Successfully");
			//resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteaddressdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

}

package nirmalya.aatithya.restmodule.gatepass.dao;

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
import nirmalya.aatithya.restmodule.common.utils.gatePass.GenerateGatePassReportParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassReportModel;

@Repository
public class GatePassReportDao {
	
	Logger logger = LoggerFactory.getLogger(GatePassReportDao.class);
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getShift(String orgName, String orgDivision , String userId) {
		logger.info("Method : getShift Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "getShift").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShift Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCategoryList(String orgName, String orgDivision , String shift) {
		logger.info("Method : getCategoryList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_shift='" + shift + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "getCategoryList").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCategoryList Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	

		public ResponseEntity<JsonResponse<List<RestGatePassReportModel>>> saveGateReportData(
				List<RestGatePassReportModel> restGatePassReportModel) {
			logger.info("Method : saveGateReportData starts");
			JsonResponse<List<RestGatePassReportModel>> resp = new JsonResponse<List<RestGatePassReportModel>>();
			List<RestGatePassReportModel> listData = new ArrayList<RestGatePassReportModel>();

			System.out.println("=====>>>>>" + restGatePassReportModel);

			try {
				String values = GenerateGatePassReportParameter.saveGateReportDataParam(restGatePassReportModel);
				if (restGatePassReportModel.get(0).getRegisterId() == null
						|| restGatePassReportModel.get(0).getRegisterId() == "") {
					System.out.println("ADDDDDDDDDDDDDDDDDDS#" + values);

					em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "saveGateReportData").setParameter("actionValue", values)
					.execute();
				

				} else {
					System.out.println("@modifyyyyyyyyyyyyyy" + values);

					em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "modifyGateReportData").setParameter("actionValue", values)
					.execute();

					
					System.out.println("modify printttttttttttttttttt" + listData);

				}
				
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
			ResponseEntity<JsonResponse<List<RestGatePassReportModel>>> response = new ResponseEntity<JsonResponse<List<RestGatePassReportModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response data is" + response);
			logger.info("Method : saveGateReportData ends");
			return response;
		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewReportData(String orgName, String orgDivision) {
			logger.info("Method : viewReportData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "viewReportData").setParameter("actionValue", value)
						.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewReportData Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editReportData(String id, String orgName, String orgDivision) {
			logger.info("Method : editReportData Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_registerId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "editReportData").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editReportData Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
	

		
		public JsonResponse<Object> deleteReport(String registerId,String orgName, String orgDiv) {
			logger.info("Method : deleteAllocationdata Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_registerId='" + registerId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("values****************************" + value);
				 em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "deleteReport").setParameter("actionValue", value)
						.execute();
				 resp.setCode("success");
				 resp.setMessage("Deleted Successfully");
				//resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : deleteReport Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> approveReportdata(String registerId,String orgName, String orgDiv) {
			logger.info("Method : approveReportdata Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_registerId='" + registerId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("values****************************" + value);
				 em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "approveReportdata").setParameter("actionValue", value)
						.execute();
				 resp.setCode("success");
				 resp.setMessage("Approved Successfully");
				//resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : approveReportdata Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getReportPdfDetails(String registerId, String orgName, String orgDivision) {
			logger.info("Method : getReportPdfDetails Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_registerId='" + registerId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "getReportPdfDetails").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getReportPdfDetails Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getCategoryAutoSearchListForItem(String id) {
			logger.info("Method : getReportPdfDetails Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_searchValue='" + id + "';";
				
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "getCategoryAutoSearchListForItem").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getCategoryAutoSearchListForItem Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getManPowerAutoSearchListForItem(String id) {
			logger.info("Method : getManPowerAutoSearchListForItem Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_searchValue='" + id + "';";
				
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "getManPowerAutoSearchListForItem").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getManPowerAutoSearchListForItem Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
		

}

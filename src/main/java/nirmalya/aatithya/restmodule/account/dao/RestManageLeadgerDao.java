package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateManageLeadgerParam;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;




@RestController
@RequestMapping(value = { "account" })
public class RestManageLeadgerDao {
	
	Logger logger = LoggerFactory.getLogger(RestManageLeadgerDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {

		logger.info("Method :getCountryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryList ends" + countryList);

		return countryList;
	}

	
	

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateLists() {

		logger.info("Method :getStateLists starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "getStateLists").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStateLists ends" + stateList);

		return stateList;
	}

	
	
	
	// Add
	public ResponseEntity<JsonResponse<Object>> addLedgerDetails(RestManageLeadgerModel manageleadger) {

		logger.info("Method in Dao: addLedgerDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateManageLeadgerParam.addManageLeadgerParam(manageleadger);
			System.out.println(values);
			if (manageleadger.getLeadgerId() == "" || manageleadger.getLeadgerId() == null) {

				em.createNamedStoredProcedureQuery("account_manageledger").setParameter("actionType", "addLedger")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("account_manageledger").setParameter("actionType", "modifyLedger")
						.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		System.out.println("hello BUlet");
		logger.info("Method in Dao: addLedgerDetails ends" + response);

		return response;
	}
	
	
	
	
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> viewLeadger() {
		logger.info("Method : viewLeadgerDao starts");
		List<RestManageLeadgerModel> respList = new ArrayList<RestManageLeadgerModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "viewleadger").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestManageLeadgerModel restPayroll = new RestManageLeadgerModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7],m[8],m[9],null);
				respList.add(restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestManageLeadgerModel>> resp = new JsonResponse<List<RestManageLeadgerModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> response = new ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : viewLeadgerDao ends");

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	//Edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>>editLeadger(String id) {
		logger.info("Method : editmanageLeadgerInfo starts");

		JsonResponse<List<RestManageLeadgerModel>> resp = new JsonResponse<List<RestManageLeadgerModel>>();
		List<RestManageLeadgerModel> rs = new ArrayList<RestManageLeadgerModel>();

		try {

			String value = "SET @p_leaderId='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "editledger").setParameter("actionValue", value).getResultList();
			
	     
			for (Object[] m : x) {
				RestManageLeadgerModel restPayroll = new RestManageLeadgerModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7],m[8],m[9],m[10]);
			
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	  resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> response = new ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : editmanageLeadgerInfo ends");
		System.out.println("hello"+response);
		return response;
	}
	
	//delete
		public ResponseEntity<JsonResponse<Object>> deletemanageleadgerDetails(String id) {
			logger.info("Method : deletemanageleadgerDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			System.out.println("ID...."+id);
			if (validity)
				try {

					
					//String value = "SET  @p_leaderId='(" + id + ")';";
					String value = "SET @p_leaderId=" + id + ";";
					
					System.out.println("value------------------"+value);
					

					em.createNamedStoredProcedureQuery("account_manageledger")
							.setParameter("actionType", "deleteleadger").setParameter("actionValue", value).execute();
					

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

			logger.info("Method :  deletemanageleadgerDetails ends");
			System.out.println("DELETE" + response);
			return response;
		}
		
		//search
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> getGroupList(String id) {
			logger.info("Method : getGroupList starts");

			List<RestManageLeadgerModel> itemNameList = new ArrayList<RestManageLeadgerModel>();
			JsonResponse<List<RestManageLeadgerModel>> resp = new JsonResponse<List<RestManageLeadgerModel>>();
			String value = "SET @p_searchValue='" + id + "';";

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
						.setParameter("actionType", "getgroupli").setParameter("actionValue", value)
						.getResultList();

				System.out.println(value);
				for (Object[] m : x) {
					RestManageLeadgerModel dropDownModel = new RestManageLeadgerModel(m[0], m[1]);

					itemNameList.add(dropDownModel);
				}
				// System.out.println("getAllcustomer" +itemNameList);
				if (itemNameList.size() > 0) {
					resp.setBody(itemNameList);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setBody(itemNameList);
					resp.setCode("failed");
					resp.setMessage("Data not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> response = new ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getGroupList ends" + response);

			return response;
		}

	}
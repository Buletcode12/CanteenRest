
package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountBankParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountBranchParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmCustomerDetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;

import org.springframework.http.HttpHeaders;

@Repository
public class RestAccountBranchDao {

	Logger logger = LoggerFactory.getLogger(RestAccountBranchDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addBranch(RestAccountBranchModel restAccountBranchModel) {

		logger.info("Method in Dao: addBranch starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateAccountBranchParameter.getAddBranchParam(restAccountBranchModel);
			System.out.println(values);
			if (restAccountBranchModel.getBranchId() == "" || restAccountBranchModel.getBranchId() == null) {

				em.createNamedStoredProcedureQuery("account_bankBranchRoutines").setParameter("actionType", "addBranch")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("account_bankBranchRoutines")
						.setParameter("actionType", "modifyBranch").setParameter("actionValue", values).execute();
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
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: addBranch ends");

		return response;
	}

	// restViewBankDetails

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> restViewBranchDetails() {
		logger.info("Method : restViewBranchDetails starts");

		System.out.println("rest bank DAO-------------------------------------------------------------2222222222");
		List<RestAccountBranchModel> respList = new ArrayList<RestAccountBranchModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankBranchRoutines")
					.setParameter("actionType", "getBranchDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				

				if (m[6] == null) {
					m[6] = "";
				}

				RestAccountBranchModel restPayroll = new RestAccountBranchModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6].toString(), m[7], m[8], m[9], m[10], m[11], m[12], m[13].toString(), m[14].toString());
				respList.add(restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAccountBranchModel>> resp = new JsonResponse<List<RestAccountBranchModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountBranchModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restViewBranchDetails ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

	// deleteBankDetails

	public ResponseEntity<JsonResponse<Object>> deleteBranchDetails(String id) {
		logger.info("Method : deleteBranchDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET  @p_branchId='(" + id + ")';";

				System.out.println("value------------------" + value);

				em.createNamedStoredProcedureQuery("account_bankBranchRoutines")
						.setParameter("actionType", "deleteBranch").setParameter("actionValue", value).execute();

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

		logger.info("Method :  deleteBranchDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	// editBankInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> editBranchInfo(String id) {
		logger.info("Method : editBranchInfo starts");

		JsonResponse<List<RestAccountBranchModel>> resp = new JsonResponse<List<RestAccountBranchModel>>();
		List<RestAccountBranchModel> rs = new ArrayList<RestAccountBranchModel>();

		try {

			String value = "SET @p_branchId='" + id + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankBranchRoutines")
					.setParameter("actionType", "editBranchInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {
				

				if (m[6] == null) {
					m[6] = "";
				}

				RestAccountBranchModel restPayroll = new RestAccountBranchModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6].toString(), m[7], m[8], m[9], m[10], m[11], m[12], m[13].toString(), m[14].toString());
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountBranchModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editBranchInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println(response);
		return response;
	}

	// getBankList

	/**
	 * for getBankList list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankList() {

		logger.info("Method : getBankList starts");

		List<DropDownModel> bankList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankBranchRoutines")
					.setParameter("actionType", "bankList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bankList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBankList ends" + bankList);
		System.out.println("Bank list----------------------" + bankList);

		return bankList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> headTypeList() {

		logger.info("Method : headTypeList starts");

		List<DropDownModel> bankList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankBranchRoutines")
					.setParameter("actionType", "headTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bankList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : headTypeList ends" + bankList);
		System.out.println("Bank list----------------------" + bankList);

		return bankList;
	}

}

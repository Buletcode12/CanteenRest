
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

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateManageAccountParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import org.springframework.http.HttpHeaders;

@Repository
public class RestAccountDao {

	Logger logger = LoggerFactory.getLogger(RestAccountDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addAccount(RestAccountModel restAccountModel) {

		logger.info("Method in Dao: addAccount starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateManageAccountParameter.getAddAccountParam(restAccountModel);
			System.out.println(values);
			if (restAccountModel.getAccountId() == "" || restAccountModel.getAccountId() == null) {

				em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
						.setParameter("actionType", "addAccount").setParameter("actionValue", values).execute();

			} else {

				System.out.println(values + "modify");
				em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
						.setParameter("actionType", "modifyAccount").setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addAccount ends");

		return response;
	}

	// restViewBankDetails

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountModel>>> restViewAccountDetails() {
		logger.info("Method : restViewAccountDetails starts");

		System.out.println("rest bank Account-------------2222222222");
		List<RestAccountModel> respList = new ArrayList<RestAccountModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
					.setParameter("actionType", "getAccountDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				if (m[2] == null) {
					m[2] = "";
				}

				if (m[6] == null) {
					m[6] = "";
				}

				RestAccountModel restPayroll = new RestAccountModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6].toString(),
						m[7].toString(), m[8].toString());
				respList.add(restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAccountModel>> resp = new JsonResponse<List<RestAccountModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAccountModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountModel>>>(
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

	// deleteAccountDetails

	public ResponseEntity<JsonResponse<Object>> deleteAccountDetails(String id) {
		logger.info("Method : deleteAccountDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET  @p_accountId='(" + id + ")';";

				System.out.println("value------------------" + value);

				em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
						.setParameter("actionType", "deleteAccount").setParameter("actionValue", value).execute();

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

		logger.info("Method :  deleteAccountDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	// editAccountInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editAccountInfo(String id) {
		logger.info("Method : editAccountInfo starts");

		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		List<AccountJournalVoucherModel> rs = new ArrayList<AccountJournalVoucherModel>();

		try {

			String value = "SET @p_accountId='" + id + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
					.setParameter("actionType", "editAccountInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {

				if (m[6] == null) {
					m[6] = "";
				}

				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6].toString(), null, null, null, null, null, null, null, null, null, null, null, null);
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
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

}

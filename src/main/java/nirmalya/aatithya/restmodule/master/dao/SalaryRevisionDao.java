package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateSalaryRevisionPromotionParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;

@Repository
public class SalaryRevisionDao {
	Logger logger = LoggerFactory.getLogger(SalaryRevisionDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFinancialYrForSalaryRevision(String organization, String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getFinancialYrForSalaryRevision starts");
		List<DropDownModel> financialYr = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			logger.info("value fan==" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getFinancialYrType").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logger.info("dropDownModel@@@@@@@@@@@@@@@@" + dropDownModel);
				financialYr.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFinancialYrForSalaryRevision end");
		return financialYr;

	}

	// employeeID list
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getEmployeeList(String orgName, String orgDivision) {

		logger.info("Method : getEmployeeList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_organization='" + orgName + "',@P_orgDivision='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeList ends");

		logger.info("LISTTTT" + resp);
		return resp;
	}

	/*
	 * date list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDateList(String id) {

		logger.info("Method : getDateList starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_fy='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getDateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}

			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDateList ends");
		logger.info("LISTTTT" + resp);
		return resp;
	}

	// designation list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDesignationDropDown(String organization, String orgDivision) {
		logger.info("Method : getDesignationDropDown starts");

		List<DropDownModel> getDesgList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getDesignationDropDownList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDown = new DropDownModel(m[0], m[1]);
				getDesgList.add(dropDown);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDesignationDropDown ends");

		return getDesgList;
	}

	/**
	 * DAO Function to Add
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addsalaryrevision(RestSalaryRevisionModel salaryModel) {
		logger.info("Method : Rest addsalaryrevision  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateSalaryRevisionPromotionParameter.addSalaryRevisionParam(salaryModel);

				if (salaryModel.getEditId() == null || salaryModel.getEditId() == "") {
					em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
							.setParameter("actionType", "addsalaryrevision").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
							.setParameter("actionType", "modifysalaryrevision").setParameter("actionValue", values)
							.execute();
				}
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

		logger.info("Method : Rest addsalaryrevision  Dao ends");
		return response;
	}

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> viewSalaryMaster(String userid,
			String organization, String orgDivision) {
		logger.info("Method : viewSalaryMaster starts");
		List<RestSalaryRevisionModel> respList = new ArrayList<RestSalaryRevisionModel>();

		try {
			String value = "SET @P_userId='" + userid + "',@P_organization='" + organization + "',@P_orgDivision='"
					+ orgDivision + "';";
			logger.info("value==" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "viewSalaryMaster").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[4] != null) {
					date = m[4].toString();
				}
				RestSalaryRevisionModel restPayroll = new RestSalaryRevisionModel(m[0], m[1], m[2], m[3], date, m[5],
						m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(),
						m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(), m[15].toString(), m[16],
						m[17], m[18].toString(),m[19].toString(),m[20].toString(),m[21]);
				respList.add(restPayroll);

			}

			logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestSalaryRevisionModel>> resp = new JsonResponse<List<RestSalaryRevisionModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> response = new ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewSalaryMaster ends");
		return response;

	}

	// edit apply

	@SuppressWarnings("unchecked")
	public JsonResponse<RestSalaryRevisionModel> editSalaryRevision(String id) {
		logger.info("Method : editSalaryRevision dao starts");
		logger.info("Edit" + id);
		RestSalaryRevisionModel req = new RestSalaryRevisionModel();
		JsonResponse<RestSalaryRevisionModel> resp = new JsonResponse<RestSalaryRevisionModel>();
		try {
			String value = "SET @p_editId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "editSalaryRevision").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[4] != null) {
					date = DateFormatter.returnStringDate(m[4]);
					date = date.toString();
					logger.info("DATEEE" + date);
				}

				RestSalaryRevisionModel restPayroll = new RestSalaryRevisionModel(m[0], m[1], m[2], m[3], date, m[5],
						m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(),
						m[11].toString(), m[12].toString(), m[13].toString(),m[14].toString(), m[15].toString(), null, null, 
						m[16].toString(),m[17].toString(),m[18].toString(),null);
				req = restPayroll;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("RestSalaryRevisionModel" + resp);
		logger.info("Method : editSalaryRevision dao ends");
		return resp;
	}

	/*
	 * name And DesignationList list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getnameAndDesignationList(String id, String organization,
			String orgDivision) {

		logger.info("Method : getnameAndDesignationList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId='" + id + "',@P_organization='" + organization + "',@P_orgDivision='" + orgDivision
				+ "';";
		logger.info("value==" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getnameAndDesignationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getnameAndDesignationList ends");

		logger.info("LISTTTT" + resp);
		return resp;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteSalaryRevision(String id, String organization,
			String orgDivision) {
		logger.info("Method : deleteSalaryRevision starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_editId='" + id + "',@P_organization='" + organization + "',@P_orgDivision='"
						+ orgDivision + "';";
				logger.info("value====" + value);
				em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
						.setParameter("actionType", "deleteSalaryRevision").setParameter("actionValue", value)
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

		logger.info("Method : deleteSalaryRevision ends");
		logger.info("DELETEE" + response);
		return response;
	}

}

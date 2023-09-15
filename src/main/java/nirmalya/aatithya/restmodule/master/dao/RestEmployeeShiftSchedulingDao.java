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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmpShiftdetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeShiftSchedulingModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestEmployeeShiftSchedulingDao {

	Logger logger = LoggerFactory.getLogger(RestEmployeeShiftSchedulingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;

	/**
	 * DAO DROPDOWN department
	 *
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList(String organization,String orgDivision) {
		logger.info("Method : getDepartment starts");
		List<DropDownModel> getDepartmentList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org=\""+organization+"\",@p_orgDiv=\""+orgDivision+"\";";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDepartmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDepartment ends");
		return getDepartmentList;
	}
 
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getShiftLists(String userId,String organization,String orgDivision,String deptId,String subDeptId) {
		logger.info("Method : getShiftLists  Dao starts");

		List<DropDownModel> shiftList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @P_userId=\"" + userId + "\",@P_organization=\"" + organization + "\",@P_orgDivision=\"" + orgDivision + "\",@P_dept=\""+deptId+"\",@P_subDept=\""+subDeptId+"\";";
		logger.info("VALUEEEE =====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "viewshiftdetails").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {

				DropDownModel shift = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());

				shiftList.add(shift);
			}

			if (shiftList.size() > 0) {
				resp.setBody(shiftList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(shiftList);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();

			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewLeaveApply: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(shiftList);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		resp.setBody(shiftList);
		logger.info("REEESSSPPP===" + resp);
		logger.info("Method : getShiftLists  Dao ends");
		return resp;
	}
 

	/*
	 * DesignationList list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getdeptidList(String id,String organization,String orgDivision) {

		logger.info("Method : getdeptidList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId=\"" + id + "\",@p_org=\""+organization+"\",@p_orgDiv=\""+orgDivision+"\";";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "deptid").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getdeptidList ends");

		logger.info("LISTTTT" + resp);
		return resp;
	}
 

	/* Function for assignShiftDetails */

		public JsonResponse<List<RestEmployeeShiftSchedulingModel>> assignShiftDetails(List<RestEmployeeShiftSchedulingModel> assignAttend) {
			logger.info("Method : assignShiftDetailsDao starts");

			JsonResponse<List<RestEmployeeShiftSchedulingModel>> resp = new JsonResponse<List<RestEmployeeShiftSchedulingModel>>();
			List<RestEmployeeShiftSchedulingModel> listData = new ArrayList<RestEmployeeShiftSchedulingModel>();

			try {

				String value = GenerateEmpShiftdetails.getEmpShiftParam(assignAttend);
				logger.info("assign shift======" + value);
				em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
				.setParameter("actionType", "approveEmpShiftAttendance").setParameter("actionValue", value)
				.execute();

			} catch (Exception e) {
				resp.setCode("Failed");
				resp.setMessage(e.getLocalizedMessage());
				e.printStackTrace();
			}
			resp.setBody(listData);
logger.info("resp==="+resp);
			logger.info("Method : assignShiftDetailsDao ends");
			return resp;
		}
	
//Function for viewEmployeeShiftDetails	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeShiftSchedulingModel>> viewEmployeeShiftDetails(String fromDate,
			String toDate, String userId, String dept,String subDept,String organization,String orgDivision) {
		logger.info("Method : viewEmployeeShiftDetails starts");

		List<RestEmployeeShiftSchedulingModel> shiftList = new ArrayList<RestEmployeeShiftSchedulingModel>();
		JsonResponse<List<RestEmployeeShiftSchedulingModel>> resp = new JsonResponse<List<RestEmployeeShiftSchedulingModel>>();

		String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
				+ DateFormatter.getStringDate(toDate) + "\", @P_userId=\"" + userId + "\",@P_dept=\""+dept+"\",@P_subDept=\""+subDept+"\","
						+ "@p_org=\""+organization+"\",@p_orgDiv=\""+orgDivision+"\";";
		logger.info("VALUE getShiftListUnassigned  =====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "getShiftListUnassigned").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				logger.info("unassigned==="+Arrays.toString(m));
				Object status = null;
				if (m[33] != null) {
					if(m[33].equals("0")) {
					status = "UNASSIGNED";
					}else {
					status ="";
					}
				}else {
					status ="";
				}

				RestEmployeeShiftSchedulingModel dropDownModel = new RestEmployeeShiftSchedulingModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
						m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],
						m[32],status.toString());
				shiftList.add(dropDownModel);
			}

			resp.setBody(shiftList);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.error("getEmpShiftWeekoffList: " + e.getMessage());
			e.printStackTrace();
		}

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "getShiftListAssigned").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object status = null;
				if (m[33] != null) {
					if(m[33].equals("1")) {
					status = "ASSIGNED";
					}else {
					status ="";
					}
				}else {
					status ="";
				}
				RestEmployeeShiftSchedulingModel dropDownModel = new RestEmployeeShiftSchedulingModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
						m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],
						m[32],status.toString());
				shiftList.add(dropDownModel);
			}

			resp.setBody(shiftList);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.error("getEmpShiftWeekoffList: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("viewEmployeeShiftDetails" + resp);
		logger.info("Method : viewEmployeeShiftDetails ends");
		return resp;
	}
	
	
	// AutoSearch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpShiftAutoSearchList(String id,String dept,String subDept,String organization,String orgDivision) {
		logger.info("Method : getEmpShiftAutoSearchList starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_dept='"+dept+"',@p_subDept='"+subDept+"',@p_org='"+organization+"',@p_orgDiv='"+orgDivision+"';";
		logger.info("value==="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "getEmpShiftList").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getEmpShiftAutoSearchList ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}

}
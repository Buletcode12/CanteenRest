package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsDashboardModel;

@Repository
public class RestHrmsDashboardDao {
	Logger logger = LoggerFactory.getLogger(RestHrmsDashboardDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	// Total Monthly Attendance
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyAttendance(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getTotalMonthlyAttendance starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";
			logger.info("Method : getTotalMonthlyAttendance startsssssssssssssssssssssssss" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyattendance").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTotalMonthlyAttendance ends" + resp);
		return resp;
	}

	// totalMonthlyAttendance aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyAttendanceAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear, String month) {

		logger.info("Method : getTotalMonthlyAttendanceAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_month='" + month + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyAttendanceAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, m[0], m[1], m[2].toString(),
						m[3], null, null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalMonthlyAttendanceAggrid ends");

		return resp;
	}

	// Total Monthly Reimbursement
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyReimbursement(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getTotalMonthlyReimbursement starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyreimbursement").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTotalMonthlyReimbursement ends" + resp);

		return resp;
	}

	// TotalMonthlyReimbursement Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyReimbursementAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear, String month) {
		logger.info("Method : getTotalMonthlyReimbursementAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_month='" + month + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyReimbursementAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, m[0],
						m[1], m[2], m[3].toString(), m[4].toString(), m[5], null, null, null, null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalMonthlyReimbursementAggrid ends");

		return resp;
	}

	// Total Leave
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTotalLeave(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getTotalLeave starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "totalLeave").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTotalLeave ends" + resp);
		return resp;
	}

	// leave aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalLeaveAggrid(String userId, String value1, String orgName,
			String orgDiv, String currentYear) {
		logger.info("Method : getTotalLeaveAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "';";
logger.info("values===="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "leaveAggrid").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object DATE = null;
				if (m[4] != null) {
					DATE = DateFormatter.returnStringDate(m[4]);
				}
				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), DATE);
				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalLeaveAggrid ends");

		return resp;
	}

	// Total Monthly event
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyEvent(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getTotalMonthlyEvent starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyEvent").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTotalMonthlyEvent ends" + resp);

		return resp;
	}

	// Total Monthly event Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyEventAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear, String month) {
		logger.info("Method : getTotalMonthlyEventAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_month='" + month + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyEventAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, m[0].toString(), m[1].toString(), m[2].toString(),
						m[3].toString(), m[4].toString());

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalMonthlyEventAggrid ends");

		return resp;
	}

	// Count Details
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getCountDetails(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getCountDetails starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";
logger.info("count values==="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "totalCountDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), null, null, null, null,
						null, null, null, null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountDetails ends" + resp);

		return resp;
	}

	// Manager Count Deatails
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getManagerCountDetails(String userId, String orgName,
			String orgDiv, String currentYear) {
		logger.info("Method : getManagerCountDetails starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "totalManagerCountDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, m[0].toString(), m[1].toString(), m[2].toString(), m[3].toString());

				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getManagerCountDetails ends" + resp);

		return resp;
	}

	// Leave Approve
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getLeaveApprove(String userId, String orgName, String orgDiv,
			String fromdate, String todate) {
		logger.info("Method : getLeaveApprove starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_fromdate='" + DateFormatter.getStringDate(fromdate) + "', @p_todate='" + DateFormatter.getStringDate(todate) + "';";
			logger.info("Method : getLeaveApprove startssssssssssssssssssss" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "leaveApprove").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeaveApprove ends" + resp);
		return resp;
	}

	// leave approve aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getLeaveApprovedAggrid(String userId, String value1,
			String orgName, String orgDiv, String fromdate, String todate) {
		logger.info("Method : getLeaveApprovedAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_fromdate='" + DateFormatter.getStringDate(fromdate)  + "',@p_todate='"+DateFormatter.getStringDate(todate) +"';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "leaveApproveAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object applyDATE = null;
				if (m[2] != null) {
					applyDATE = DateFormatter.returnStringDate(m[2]);
				}
				Object approveDATE = null;
				if (m[4] != null) {
					approveDATE = DateFormatter.returnStringDate(m[4]);
				}
				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0], m[1], applyDATE, m[3], approveDATE);
				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLeaveApprovedAggrid ends");

		return resp;
	}

	// Total Reimbursement Approved
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getReimbursementApproved(String userId, String orgName, String orgDiv,
			String fromdate,String todate) {
		logger.info("Method : getReimbursementApproved starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_fromdate='" + DateFormatter.getStringDate(fromdate)  + "',@p_todate='"+DateFormatter.getStringDate(todate) +"';";
			logger.info("values_____________"+values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "reimbursementApproved").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);
			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getReimbursementApproved ends" + resp);

		return resp;
	}

	// Total ReimbursementApproved Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getReimbursementApprovedAggrid(String userId, String value1,
			String orgName, String orgDiv, String month,String fromdate,String todate) {
		logger.info("Method : getReimbursementApprovedAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_month='" + month + "',@p_fromdate='" + DateFormatter.getStringDate(fromdate)  + "',@p_todate='"+DateFormatter.getStringDate(todate) +"';";
logger.info("values==="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "reimbursementApprovedAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, m[0],
						m[1], m[2], m[3].toString(), m[4].toString(), m[5], null, null, null, null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReimbursementApprovedAggrid ends");

		return resp;
	}

	// PayRoll Process
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getPayrollProcess(String userId, String orgName, String orgDiv,
			String fromdate, String todate) {
		logger.info("Method : getPayrollProcess starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_fromdate='" + DateFormatter.getStringDate(fromdate) + "', @p_todate='"+DateFormatter.getStringDate(todate)+"';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "payrollProcess").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, m[0].toString(),
						null, m[1].toString(), null, null, m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPayrollProcess ends" + resp);

		return resp;
	}

	// Payroll Process Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getPayrollProcessAggrid(String userId, String value,
			String orgName, String orgDiv, String fromdate, String todate) {
		logger.info("Method : getPayrollProcessAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value='" + value + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_fromdate='" + DateFormatter.getStringDate(fromdate) + "',@p_todate='"+DateFormatter.getStringDate(todate)+"';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "payrollProcessAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, m[0], m[1],
						m[2], m[3], null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPayrollProcessAggrid ends");

		return resp;
	}

	// RatingwiseAppresal
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getRatingWise(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getRatingWise starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "ratingwiseAppresal").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRatingWise ends" + resp);

		return resp;
	}

	// Ratingwise Appresal Aggrid

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getRatingWiseAggrid(String userId, String value1, String orgName,
			String orgDiv, String currentYear) {
		logger.info("Method : getRatingWiseAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "ratingwiseAppresalAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, m[0].toString(), m[1].toString(),
						null, null, null, m[2].toString(), m[3].toString());
				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRatingWiseAggrid ends");

		return resp;
	}

	// HR Count Deatails
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getHrCountDetails(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getHrCountDetails starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "totalHrCountDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHrCountDetails ends" + resp);

		return resp;
	}

	// Designation By Requisition
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getDesignationByRequisition(String userId, String orgName,
			String orgDiv, String currentYear) {
		logger.info("Method : getDesignationByRequisition starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "designationByRequisition").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, m[0].toString(), m[1].toString(), m[2].toString(),
						m[3].toString(), null, null, null, null, null, null, null, null, null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDesignationByRequisition ends" + resp);

		return resp;
	}
	// Designation By Requisition Aggrid

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getDesignationByRequisitionAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear, String value) {
		logger.info("Method : getDesignationByRequisitionAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_value='" + value + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "designationByRequisitionAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], m[3], m[4],
						null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDesignationByRequisitionAggrid ends");

		return resp;
	}

	// Requisition Status
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getRequisitionStatus(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getRequisitionStatus starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "requisitionStatus").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, m[0].toString(), m[1].toString(), null,
						null, null, null, null, null, null);

				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRequisitionStatus ends" + resp);

		return resp;
	}

	// Requisition Status Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getRequisitionStatusAggrid(String userId, String value,
			String orgName, String orgDiv, String currentYear) {
		logger.info("Method : getRequisitionStatusAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value='" + value + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "requisitionStatusAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, m[0], m[1].toString(), m[2],
						m[3].toString(), null, null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionStatusAggrid ends");

		return resp;
	}

	//// Gender Wise Candidate
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getGendereWiseCandidate(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getGendereWiseCandidate starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "gendereWiseCandidate").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString());

				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGendereWiseCandidate ends" + resp);

		return resp;
	}

	// Gender Wise Candidate Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getGendereWiseCandidateAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear) {
		logger.info("Method : getGendereWiseCandidateAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "gendereWiseCandidateAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0].toString(),
						m[1].toString(), null, null, m[2].toString(), m[3].toString());

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getGendereWiseCandidateAggrid ends");

		return resp;
	}
	// Yearly Event

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getYearlyEvent(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getYearlyEvent starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "yearlyEvent").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getYearlyEvent ends" + resp);

		return resp;
	}

	// Yearly Selection Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getYearlyEventAggrid(String userId, String value1, String orgName,
			String orgDiv, String currentYear, String month) {
		logger.info("Method : getYearlyEventAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_month='" + month + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "yearlyEventAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, m[0], m[1].toString(), m[2].toString(), m[3], m[4]);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getYearlyEventAggrid ends");

		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrmsDashboardModel>>> viewYearSelectionData(String currentYear,
			String orgname, String orgdiv) {
		logger.info("Method : viewYearSelectionData starts");

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();
		List<RestHrmsDashboardModel> rs = new ArrayList<RestHrmsDashboardModel>();

		try {

			String value = "SET @p_currentYear='" + currentYear + "', @p_orgname='" + orgname + "', @p_orgdiv='"
					+ orgdiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "viewyearselection").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0], m[1].toString(), null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null);
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestHrmsDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestHrmsDashboardModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewYearSelectionData ends");
		logger.info("sssssssssssssssssssssssss" + response);
		return response;
	}

	// getAttendanceReports
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getAttendanceReports(String userId, String orgName, String orgDiv,
			String fromdate, String todate) {
		logger.info("Method : getAttendanceReports starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_fromdate='" + DateFormatter.getStringDate(fromdate) + "', @p_todate='"
					+ DateFormatter.getStringDate(todate) + "';";
			logger.info("===============" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "attendanceReports").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2]);
				req.add(reqemp);
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAttendanceReports ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalEmployeeAttendanceAggrid(String userId, String value1,
			String orgName, String orgDiv, String fromdate, String todate, String shift) {

		logger.info("Method : getTotalEmployeeAttendanceAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_fromdate='" + DateFormatter.getStringDate(fromdate)
					+ "',@p_todate='" + DateFormatter.getStringDate(todate) + "',@p_shift='" + shift + "';";
			logger.info("value----------------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "employeeAttendanceAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, m[0], m[1], m[2].toString(),
						m[3], null, null, m[4]);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalEmployeeAttendanceAggrid ends");

		return resp;
	}
}

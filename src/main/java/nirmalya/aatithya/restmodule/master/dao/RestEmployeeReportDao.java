package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeReportsModel;
@Repository
public class RestEmployeeReportDao {
	Logger logger = LoggerFactory.getLogger(RestEmployeeReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeReportDetails(String userId,String organization,String orgDivision,String fromDate,String toDate) {

		logger.info("Method in Dao: viewEmployeeReportDetails dao starts");

		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @P_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"';";
		logger.info("value===="+value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewEmployeeDetails").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				Object dob = null;
				if (m[3] != null) {
					dob = DateFormatter.returnStringDate(m[3]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],m[2],dob,m[4],m[5],m[6],
						m[7],m[8],m[9],m[10],m[11],null,null,m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19]);
				reportDetails.add(report);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: viewEmployeeReportDetails dao ends");

		return resp;
	}
	// view Employee Attendance Reports

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeAttendanceReports(String userId,String organization,String orgDivision,String fromDate,String toDate) {

		logger.info("Method in Dao: viewEmployeeAttendanceReports dao starts");

		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @P_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"';";
		logger.info("value===="+value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewEmployeeAttendanceReports").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				Object attenDate = null;
				if (m[2] != null) {
					attenDate = DateFormatter.returnStringDate(m[2]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],attenDate,m[3],m[4],m[5],m[6],m[7].toString());
				reportDetails.add(report);

			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: viewEmployeeAttendanceReports dao ends");

		return resp;
	}
	// view Employee Biometric Attendance Reports
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeBiometricAttendanceReports(String userId,String organization,String orgDivision,String fromDate,String toDate) {
		
		logger.info("Method in Dao: viewEmployeeBiometricAttendanceReports dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @P_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"';";
		logger.info("value===="+value);
		
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewEmployeeBiometricAttendanceReports").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object attenDate = null;
				if (m[2] != null) {
					attenDate = DateFormatter.returnStringDate(m[2]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],attenDate,m[3],m[4],m[5],m[6],m[7].toString());
				reportDetails.add(report);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: viewEmployeeBiometricAttendanceReports dao ends");
		
		return resp;
	}
	// view Employee Attendance Reports
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeResignationReports(String userId,String organization,String orgDivision) {
		
		logger.info("Method in Dao: viewEmployeeResignationReports dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @P_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewEmployeeResignationReports").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object resgDate = null;
				if (m[4] != null) {
					resgDate = DateFormatter.returnStringDate(m[4]);
				}
				RestEmployeeReportsModel regReport = new RestEmployeeReportsModel(m[0],m[1],m[2],m[3],resgDate.toString(),m[5].toString(),m[6].toString(),
						m[7].toString(),m[8].toString(),m[9],m[10],m[11],m[12],m[13],m[14]);
				reportDetails.add(regReport);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: viewEmployeeResignationReports dao ends");
		
		return resp;
	}
	// view Employee Attendance Reports dept wise
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> empAttendanceDetailsDepartmentWise(String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		
		logger.info("Method in Dao: empAttendanceDetailsDepartmentWise dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "empAttendanceDetailsDepartmentWise").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object attenDate = null;
				if (m[2] != null) {
					attenDate = DateFormatter.returnStringDate(m[2]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],attenDate,m[3],m[4],m[5],m[6],m[7].toString());
				reportDetails.add(report);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: empAttendanceDetailsDepartmentWise dao ends");
		return resp;
	}
	// view Employee BioAttendance Reports dept wise
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> empBioAttendanceDetailsDepartmentWise(String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		
		logger.info("Method in Dao: empBioAttendanceDetailsDepartmentWise dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "empBioAttendanceDetailsDepartmentWise").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object attenDate = null;
				if (m[2] != null) {
					attenDate = DateFormatter.returnStringDate(m[2]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],attenDate,m[3],m[4],m[5],m[6],m[7].toString());
				reportDetails.add(report);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: empBioAttendanceDetailsDepartmentWise dao ends");
		return resp;
	}
	// view Employee Reports Department wise
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> empDetailsDepartmentWise(String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		
		logger.info("Method in Dao: empDetailsDepartmentWise dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "empDetailsDepartmentWise").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) { 
				Object dob = null;
				if (m[3] != null) {
					dob = DateFormatter.returnStringDate(m[3]);
				}
				RestEmployeeReportsModel report =new RestEmployeeReportsModel(m[0],m[1],m[2],dob,m[4],m[5],m[6],
						m[7],m[8],m[9],m[10],m[11],null,null,m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19]);
				reportDetails.add(report);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: empDetailsDepartmentWise dao ends");
		
		return resp;
	}
	// view Employee Attendance Reports by status
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> empAttendanceDetailsStatusWise(String dept,String subDept,String attndate,String organization,String orgDivision,String status) {
		
		logger.info("Method in Dao: empAttendanceDetailsStatusWise dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_attndate='"+DateFormatter.getStringDate(attndate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_status='"+status+"';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "empAttendanceDetailsStatusWise").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object attenDate = null;
				if (m[2] != null) {
					attenDate = DateFormatter.returnStringDate(m[2]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],attenDate,m[3],m[4],m[5],m[6],m[7].toString());
				reportDetails.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: empAttendanceDetailsStatusWise dao ends");
		
		return resp;
	}
	// view Employee BioAttendance Reports by status
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> empBioAttendanceDetailsStatusWise(String dept,String subDept,String attndate,String organization,String orgDivision,String status) {
		
		logger.info("Method in Dao: empBioAttendanceDetailsStatusWise dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_attndate='"+DateFormatter.getStringDate(attndate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_status='"+status+"';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "empBioAttendanceDetailsStatusWise").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object attenDate = null;
				if (m[2] != null) {
					attenDate = DateFormatter.returnStringDate(m[2]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],attenDate,m[3],m[4],m[5],m[6],m[7].toString());
				reportDetails.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: empBioAttendanceDetailsStatusWise dao ends");
		
		return resp;
	}
	/*
	 *  View Exit Management report
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewExtendExitManagementDtlsReport(String userId,String userRole,String organization,String orgDivision) {

		logger.info("Method in Dao: viewExtendExitManagementDtlsReport starts");

		List<ExtendExitManagementRestModel> exitDtlsList = new ArrayList<ExtendExitManagementRestModel>();
		String value = "SET @P_userId='" + userId + "',@P_userRole='" + userRole + "',@P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewExitManagementReport").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				Object DATE = null;
				if (m[7] != null) {
					DATE = DateFormatter.returnStringDate(m[7]);
				}
				Object DATER = null;
				if (m[8] != null) {
					DATER = DateFormatter.returnStringDate(m[8]);
				}

				ExtendExitManagementRestModel exitManagementModel = new ExtendExitManagementRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], DATE, DATER, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
						m[17].toString(),m[18],m[19],m[20],m[21],m[22],m[23],m[24]);
				exitDtlsList.add(exitManagementModel);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ExtendExitManagementRestModel>> resp = new JsonResponse<List<ExtendExitManagementRestModel>>();
		resp.setBody(exitDtlsList);

		logger.info("Method in Dao: viewExtendExitManagementDtlsReport ends");

		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeovertime(String userId,String organization,String orgDivision,String fromDate,String toDate) {

		logger.info("Method in Dao: viewEmployeeovertime dao starts");

		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @P_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"';";
		logger.info("value===="+value);
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewOvertimeAttendanceReports").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				Object otStart = null;
				if (m[2] != null) {
					otStart = DateFormatter.returnStringTostringDateTime(m[2].toString());
				}
				Object ndtime = null;
				if (m[3] != null) {
					ndtime = DateFormatter.returnStringTostringDateTime(m[3].toString());
				}
				Object attenDate = null;
				if (m[6] != null) {
					attenDate = DateFormatter.returnStringDate(m[6]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],otStart,ndtime,m[4],m[5],attenDate,m[7].toString(),m[8],m[9],m[10],m[11].toString());
				reportDetails.add(report);

			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: viewEmployeeovertime dao ends");

		return resp;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> overtimeAttendanceReportDeptype(String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		
		logger.info("Method in Dao: overtimeAttendanceReportDeptype dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "overtimeattendancedeptwise").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object otStart = null;
				if (m[2] != null) {
					otStart = DateFormatter.returnStringTostringDateTime(m[2].toString());
				}
				Object ndtime = null;
				if (m[3] != null) {
					ndtime = DateFormatter.returnStringTostringDateTime(m[3].toString());
				}
				Object attenDate = null;
				if (m[6] != null) {
					attenDate = DateFormatter.returnStringDate(m[6]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],otStart,ndtime,m[4],m[5],attenDate,m[7].toString(),m[8],m[9],m[10],m[11].toString());
				reportDetails.add(report);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: overtimeAttendanceReportDeptype dao ends");
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> overtimeDetailsStatuswise(String dept,String subDept,String attndate,String organization,String orgDivision,String status) {
		
		logger.info("Method in Dao: overtimeDetailsStatuswise dao starts");
		
		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_attndate='"+DateFormatter.getStringDate(attndate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_status='"+status+"';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "overtimeDetailsStatusWise").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object otStart = null;
				if (m[2] != null) {
					otStart = DateFormatter.returnStringTostringDateTime(m[2].toString());
				}
				Object ndtime = null;
				if (m[3] != null) {
					ndtime = DateFormatter.returnStringTostringDateTime(m[3].toString());
				}
				Object attenDate = null;
				if (m[6] != null) {
					attenDate = DateFormatter.returnStringDate(m[6]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],otStart,ndtime,m[4],m[5],attenDate,m[7].toString(),m[8],m[9],m[10],m[11].toString());
				reportDetails.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: overtimeDetailsStatuswise dao ends");
		
		return resp;
	}
}

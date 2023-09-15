package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;
import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;

public class GenerateLeaveParameter {
	
	public static String addLeaveApply(List<LeaveApplyRestModel> leave) {
		String s = "";
		String sitem = "";
		
		//parent table
		
		if (leave.get(0).getLeaveId() != null && leave.get(0).getLeaveId()!= "" ) {
			s = s + "@p_leaveId='" + leave.get(0).getLeaveId() + "',";
		}
		if (leave.get(0).getEmpID() != null && leave.get(0).getEmpID()!= "" ) {
			s = s + "@p_empId='" + leave.get(0).getEmpID() + "',";
		}
		if (leave.get(0).getEmpName() != null && leave.get(0).getEmpName()!= "" ) {
			s = s + "@p_empName='" + leave.get(0).getEmpName() + "',";
		}
		if (leave.get(0).getLeaveApplyDate() != null && leave.get(0).getLeaveApplyDate()!= "" ) {
			s = s + "@p_leaveApplyDate='" + leave.get(0).getLeaveApplyDate() + "',";
		}
		if (leave.get(0).getCreatedBy() != null && leave.get(0).getCreatedBy()!= "" ) {
			s = s + "@p_createdBy='" + leave.get(0).getCreatedBy() + "',";
		}
		if(leave.get(0).getOrganization() != null || leave.get(0).getOrganization() != "") {
			s = s + "@p_org='" + leave.get(0).getOrganization() + "',";
		}
		if(leave.get(0).getOrgDivision() != null || leave.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + leave.get(0).getOrgDivision() + "',";
		}
		if(leave.get(0).getFromDate() != null || leave.get(0).getFromDate() != "") {
			s = s + "@p_fdate='" + leave.get(0).getFromDate() + "',";
		}
		if(leave.get(0).getToDate() != null || leave.get(0).getToDate() != "") {
			s = s + "@p_tdate='" + leave.get(0).getToDate() + "',";
		}

	//child table
		for (LeaveApplyRestModel m : leave) {

			sitem = sitem + "(@p_leaveId,\""  + m.getLeaveTypeId() +
					"\",\"" + m.getFromDate() +"\",\"" + m.getToDate() + "\",\"" + m.getTotalLeave() + "\",\"" +
			m.getReason() + "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}

}

package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestEmployeeShiftSchedulingModel;

public class GenerateEmpShiftdetails {

	public static String getEmpShiftParam(List<RestEmployeeShiftSchedulingModel> data) {

		String s = "";
		String emplist = "";
		String datalist = ""; 
		String status="1";
		if (data.get(0).getFromDate() != null || data.get(0).getFromDate()!= "") {
			s = s + "@p_fromdate='" + DateFormatter.getStringDate(data.get(0).getFromDate()) + "',";
		}
		if (data.get(0).getRoleId() != null || data.get(0).getRoleId()!= "") {
			s = s + "@p_roleid='(" + data.get(0).getRoleId()+ ")',";
		}
		if (data.get(0).getAssignBy() != null || data.get(0).getAssignBy()!= "") {
			s = s + "@p_assignBy='" + data.get(0).getAssignBy() + "',";
		}

		if (data.size() > 0) {
			for (RestEmployeeShiftSchedulingModel m : data) {
				emplist=emplist+"\"" + m.getEmpId() + "\""+",";
				datalist = datalist + "(\"" + m.getEmpId() + "\",\"" + m.getDept() + "\",\"" + m.getSubDept() + "\",\"" + m.getId21() + "\",\"" + m.getId22()
						+ "\",\"" + m.getId23() + "\",\"" + m.getId24() + "\"," + "\"" + m.getId25() + "\", \""
						+ m.getId26() + "\",\"" + m.getId27() + "\",\"" + m.getId28() + "\",\"" + m.getId29() + "\",\""
						+ m.getId30() + "\"," + "\"" + m.getId31() + "\",\"" + m.getId1() + "\",\"" + m.getId2()
						+ "\",\"" + m.getId3() + "\",\"" + m.getId4() + "\",\"" + m.getId5() + "\"," + "\"" + m.getId6()
						+ "\",\"" + m.getId7() + "\",\"" + m.getId8() + "\",\"" + m.getId9() + "\",\"" + m.getId10()
						+ "\",\"" + m.getId11() + "\"," + "\"" + m.getId12() + "\",\"" + m.getId13() + "\",\""
						+ m.getId14() + "\",\"" + m.getId15() + "\",\"" + m.getId16() + "\",\"" + m.getId17() + "\","
						+ "\"" + m.getId18() + "\",\"" + m.getId19() + "\",\"" + m.getId20() + "\",\""
						+ DateFormatter.getStringDate(m.getFromDate()) + "\"," + "\""
						+ DateFormatter.getStringDate(m.getToDate()) + "\",\"" + m.getAssignBy() + "\",\""+m.getOrganization()+"\",\""+m.getOrgDivision()+"\",\""+status+"\"),";
			}
			
		}
		if(!emplist.isEmpty()) {
			emplist = emplist.substring(0, emplist.length() - 1);
			s = s + "@p_emplist='(" + emplist + ")',";
		}
		if(!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_EmpSubQuery='" + datalist + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	
}


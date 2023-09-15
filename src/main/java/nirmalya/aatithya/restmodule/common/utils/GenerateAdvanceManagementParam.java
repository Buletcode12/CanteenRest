package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;

public class GenerateAdvanceManagementParam {
	public static String getAdvManageParam( RestAdvanceManagementModel  advance) {

		String s = "";
 
		String advanceId = advance.getAdvanceId();
		String	reqPolicyId = advance.getReqPolicyId();
		String	empID = advance.getEmpID();
		Double loanamt = advance.getLoanamt(); 
		String	reason = advance.getReason();
		String	createdBy = advance.getCreatedBy();
		String organization=advance.getOrganization(); 
		String orgDivision=advance.getOrgDivision();
	 
		s = s + "@p_advanceId='" + advanceId + "',";
		s = s + "@p_reqPolicyId='" + reqPolicyId + "',";
		s = s + "@p_empId='" + empID + "',";
		s = s + "@p_loanamt='" + loanamt + "',";
		s = s + "@p_reason='" + reason + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		
 
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}
	
	
	public static String getProcessApproveParam( RestAdvanceManagementModel  advance) {

		String s = "";
		String pdata = "";
		
		String advanceId = advance.getAdvanceId();
		s = s + "@p_advanceId='" + advanceId + "',";
		
		
		int ten=Integer.parseInt(advance.getTernure());		
		
		for (int i = 1; i <= ten ; i++) {
			LocalDate futureDate = LocalDate.now().plusMonths(i);
			int m=futureDate.getMonthValue();
			int y=futureDate.getYear();
			String duedate=y+"-"+m+"-"+"01";
		 
			pdata = pdata + "(\"" +advance.getAdvanceId()+"\",\""+advance.getEmpID()+"\",\""+duedate+"\",\""+advance.getLoanamt()+"\",\""+advance.getTernure()+"\",\""+advance.getIntrestRate()+"\",\""+advance.getEmi()+"\",\""+advance.getTotalInterest()+"\",\""+ advance.getCreatedBy() +"\"),";
		}
		if (pdata != "") {
			pdata = pdata.substring(0, pdata.length() - 1);
			pdata = pdata+"";
		}
		s =s+"@P_subQuery='"+pdata+"'," ;
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}	
	
}
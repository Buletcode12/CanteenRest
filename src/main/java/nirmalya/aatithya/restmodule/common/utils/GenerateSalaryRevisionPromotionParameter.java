package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;

public class GenerateSalaryRevisionPromotionParameter {
	
	public static String addSalaryRevisionParam(RestSalaryRevisionModel restPayroll) {
		// TODO Auto-generated method stub
		String S = "";
		String oth = "0.00";
		System.out.println("restPayroll==="+restPayroll);
		if(restPayroll.getEmpId() != null || restPayroll.getEmpId() != "") {
			S = S + "@p_empId='" + restPayroll.getEmpId() + "',";
		}
		if(restPayroll.getName() != null || restPayroll.getName() != "") {
			S = S + "@p_name='" + restPayroll.getName() + "',";
		}
		if(restPayroll.getPdesg() != null || restPayroll.getPdesg() != "") {
			S = S + "@p_pdesg='" + restPayroll.getPdesg() + "',";
		}
		if(restPayroll.getNdesg() != null || restPayroll.getNdesg() != "") {
			S = S + "@p_ndesg='" + restPayroll.getNdesg() + "',";
		}
		if(restPayroll.getEffectiveDate() != null || restPayroll.getEffectiveDate() != "") {
			S = S + "@p_effectiveDate='" + restPayroll.getEffectiveDate() + "',";
		}
		if(restPayroll.getBand() != null || restPayroll.getBand() != "") {
			S = S + "@p_band='" + restPayroll.getBand() + "',";
		}
		if(restPayroll.getBasic() != null && restPayroll.getBasic() != "") {
			S = S + "@p_basic='" + restPayroll.getBasic() + "',";
		}else {
			S = S + "@p_basic='" + oth+ "',";
		}
		if(restPayroll.getHra() != null && restPayroll.getHra() != "") {
			S = S + "@p_hra='" + restPayroll.getHra() + "',";
		}else {
			S = S + "@p_hra='" + oth+ "',";
		}
		if(restPayroll.getAddAllow() != null && restPayroll.getAddAllow() != "") {
			S = S + "@p_addAllow='" + restPayroll.getAddAllow() + "',";
		}else {
			S = S + "@p_addAllow='" + oth+ "',";
		}
		if(restPayroll.getConve() != null && restPayroll.getConve() != "") {
			S = S + "@p_conve='" + restPayroll.getConve() + "',";
		}else {
			S = S + "@p_conve='" + oth+ "',";
		}
		if(restPayroll.getLta() != null && restPayroll.getLta() != "") {
			S = S + "@p_lta='" + restPayroll.getLta() + "',";
		}else {
			S = S + "@p_lta='" + oth+ "',";
		}
		if(restPayroll.getMedical() != null && restPayroll.getMedical() != "") {
			S = S + "@p_medical='" + restPayroll.getMedical() + "',";
		}else {
			S = S + "@p_medical='" + oth+ "',";
		}
		if(restPayroll.getWashAllow() != null && restPayroll.getWashAllow() != "") {
			S = S + "@p_washAllow='" + restPayroll.getWashAllow() + "',";
		}else {
			S = S + "@p_washAllow='" + oth+ "',";
		}
		if(restPayroll.getSkillDev() != null && restPayroll.getSkillDev() != "") {
			S = S + "@p_skillDev='" + restPayroll.getSkillDev() + "',";
		}else {
			S = S + "@p_skillDev='" + oth+ "',";
		}
		if(restPayroll.getOther() != null && restPayroll.getOther() != "") {
			S = S + "@p_other='" + restPayroll.getOther() + "',";
		}else {
			S = S + "@p_other='" + oth+ "',";
		}
		if(restPayroll.getCreatedBy() != null && restPayroll.getCreatedBy() != "") {
			S = S + "@p_createdBy='" + restPayroll.getCreatedBy() + "',";
		}
		if(restPayroll.getEditId() != null || restPayroll.getEditId() != "") {
			S = S + "@p_editId='" + restPayroll.getEditId() + "',";
		}
		if(restPayroll.getOrganization() != null || restPayroll.getOrganization() != "") {
			S = S + "@p_org='" + restPayroll.getOrganization() + "',";
		}
		if(restPayroll.getOrgDivision() != null || restPayroll.getOrgDivision() != "") {
			S = S + "@p_orgDiv='" + restPayroll.getOrgDivision() + "',";
		}
		if(restPayroll.getDept() != null || restPayroll.getDept() != "") {
			S = S + "@p_dept='" + restPayroll.getDept() + "',";
		}
		if(restPayroll.getSubdept() != null || restPayroll.getSubdept() != "") {
			S = S + "@p_subdept='" + restPayroll.getSubdept() + "',";
		}
		if(restPayroll.getCtc() != null && restPayroll.getCtc() != "") {
			S = S + "@p_ctc='" + restPayroll.getCtc() + "',";
		}else {
			S = S + "@p_ctc='" + oth+ "',";
		}
		if (S != "") {
			S = S.substring(0, S.length() - 1);

			S = "SET " + S + ";";
		}
		System.out.println(S);
		return S;
	}
	
	
	

}

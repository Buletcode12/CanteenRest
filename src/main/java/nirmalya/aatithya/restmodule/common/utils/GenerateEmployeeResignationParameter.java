package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.RestEmployeeResignationModel;


public class GenerateEmployeeResignationParameter {
	
	public static String getEmployeeResignationParam(List<RestEmployeeResignationModel> restEmployeeResignationModel) {
		String s = "";
		String resignationDraftId = "";
		String resignationId = "";
		String regTo = "";
		String regCC = "";
		String subject = "";
		String reason = "";
		String resignDate = "";
		String releaseDate = "";
		String createdBy = "";
		String organization=""; 
		String orgDivision="";

		for (RestEmployeeResignationModel m : restEmployeeResignationModel) {
			resignationDraftId = m.getResignationDraftId();
			resignationId = m.getResignationId();
			regTo =m.getRegTo();
			regCC = m.getRegCC();
			subject = m.getSubject();
			reason = m.getReason();
			resignDate = m.getResignDate();
			releaseDate = m.getReleaseDate();
			createdBy=m.getCreatedBy();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
			
		}
		s = s + "@p_resignationDraftId='" + resignationDraftId + "',";
		s = s + "@p_resignationId='" + resignationId + "',";
		s = s + "@p_regTo='" + regTo + "',";
		s = s + "@p_regCC='" + regCC + "',";
		s = s + "@p_subject='" + subject + "',";
		s = s + "@p_reason='" + reason + "',";
		s = s + "@p_resignDate='" + resignDate + "',";
		s = s + "@p_releaseDate='" + releaseDate + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
 
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
System.out.println("Generate reg Params"+s);
		return s;
	}
}

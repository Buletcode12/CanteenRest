package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;


public class GenerateAllotedPolicyProgress {
	public static String getPolicyProgressList(List<AllotedMaintenanceRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getAllocid() != null || av.get(0).getAllocid() != "") {
			s = s + "@p_allocid='" + av.get(0).getAllocid() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}

		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}

		for (AllotedMaintenanceRestModel m : av) {

			sitem = sitem + "(@p_allocid,\"" + m.getPolicyid() + "\",\"" + m.getPolicyName() + "\",\"" + m.getPriority() + "\",\"" + m.getStatus() + "\",\"" + m.getDescription()+ "\",\"" + m.getCreatedBy()  + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}

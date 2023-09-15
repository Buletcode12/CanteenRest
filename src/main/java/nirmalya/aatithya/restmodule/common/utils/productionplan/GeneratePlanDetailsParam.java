package nirmalya.aatithya.restmodule.common.utils.productionplan;

import java.util.List;

import nirmalya.aatithya.restmodule.productionplan.model.UploadedPlanRestModel;
import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;

public class GeneratePlanDetailsParam {
	public static String getAddPlan(List<UploadedPlanRestModel> plan) {
		String s = "";
		String sitem = "";

		if (plan.get(0).getPlanId() != null || plan.get(0).getPlanId() != "") {
			s = s + "@p_planId='" + plan.get(0).getPlanId() + "',";
		}
		if (plan.get(0).getWeek() != null || plan.get(0).getWeek() != "") {
			s = s + "@p_week='" + plan.get(0).getWeek() + "',";
		}
 
		if (plan.get(0).getDescription() != null || plan.get(0).getDescription() != "") {
			s = s + "@p_description='" + plan.get(0).getDescription() + "',";
		}

		if (plan.get(0).getCreatedBy() != null || plan.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + plan.get(0).getCreatedBy() + "',";
		}

		if (plan.get(0).getOrganization() != null || plan.get(0).getOrganization() != "") {
			s = s + "@p_org='" + plan.get(0).getOrganization() + "',";
		}
		if (plan.get(0).getOrgDivision() != null || plan.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + plan.get(0).getOrgDivision() + "',";
		}

		for (UploadedPlanRestModel m : plan) {

			sitem = sitem + "(@p_planId,\"" + m.getItemId() + "\",\"" + m.getQuantity()+ "\",\""
					+ m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\",\"" + m.getUnit() + "\"),";
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
	
	public static String saveAllBomData(UploadedPlanRestModel plan) {
		String s = "";
		String bitem = "";
		
		if (plan.getPlanId() != null || plan.getPlanId() != "") {
			s = s + "@p_planId='" + plan.getPlanId() + "',";
		}
		if(plan.getBomList().size() > 0) {
			for(String m : plan.getBomList()) {
				bitem = bitem + "(\"" + plan.getPlanId() + "\",\"" + plan.getItemId() + "\",\"" + m + "\",\""+plan.getOrganization()+"\",\""+plan.getOrgDivision()+"\",\""+plan.getCreatedBy()+"\"),";
			}
			
			bitem = bitem.substring(0, bitem.length() - 1);
		}
		s = s + "@p_bomSubQuery='" + bitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}

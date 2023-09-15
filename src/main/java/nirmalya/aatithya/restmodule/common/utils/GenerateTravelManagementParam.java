package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;

public class GenerateTravelManagementParam {

	public static String getTravelRequisitionParam(List<TravelRequisitionRestModel> travelModel) {

		String s = "";
		String sitem = "";

		if (travelModel.get(0).getTravelingReqId() != null || travelModel.get(0).getTravelingReqId() != "") {
			s = s + "@p_travelId='" + travelModel.get(0).getTravelingReqId() + "',";
		}
		
		
		if (travelModel.get(0).getPlaceName() != null || travelModel.get(0).getPlaceName() != "") {
			s = s + "@p_placeName='" + travelModel.get(0).getPlaceName() + "',";
		}
		
		if (travelModel.get(0).getPurpose() != null || travelModel.get(0).getPurpose() != "") {
			s = s + "@p_purposeName='" + travelModel.get(0).getPurpose() + "',";
		}
		
		if (travelModel.get(0).getAdvanceReq() != null || travelModel.get(0).getAdvanceReq() != "") {
			s = s + "@p_advanceRequi='" + travelModel.get(0).getAdvanceReq() + "',";
		}
		
		if (travelModel.get(0).getAdvanceAmount() != null) {
			s = s + "@p_advanceAmount='" + travelModel.get(0).getAdvanceAmount() + "',";
		}

		if (travelModel.get(0).getFromDate() != null || travelModel.get(0).getFromDate() != "") {
			s = s + "@p_fromdate='" + DateFormatter.getStringDate(travelModel.get(0).getFromDate()) + "',";
		}
		
		if (travelModel.get(0).getToDate() != null || travelModel.get(0).getToDate() != "") {
			s = s + "@p_todate='" + DateFormatter.getStringDate(travelModel.get(0).getToDate() )+ "',";
		}

		
		if (travelModel.get(0).getCreatedBy() != null || travelModel.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + travelModel.get(0).getCreatedBy() + "',";
		}

		if(travelModel.get(0).getOrganization() != null || travelModel.get(0).getOrganization() != "") {
			s = s + "@p_org='" + travelModel.get(0).getOrganization() + "',";
		}
		if(travelModel.get(0).getOrgDivision() != null || travelModel.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + travelModel.get(0).getOrgDivision() + "',";
		}

		for (TravelRequisitionRestModel m : travelModel) {

			sitem = sitem + "(@p_travelId,\"" + m.getServiceName() + "\",\"" +DateFormatter.getStringDate(m.getDate()) + "\",\"" + m.getTime() + "\",\"" + m.getDescription() +  "\"),";
		
			
			
		}
		
		//s = s + "@p_serviceId='" + travelModel.get(0).getServiceId() +"',";
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
	
	// delete schedule param
	
	public static String getDeleteParam(TravelRequisitionRestModel resttravelModel) {
		String[] travelIds = resttravelModel.getTravelingReqId().split(",");
		String s = "";
		String sitem = "";
		/* String act = ""; */ 
		for (String a : travelIds) {
			sitem = sitem + "\"" + a + "\",";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		sitem = "(" + sitem + ")";
		s = s + "@p_reqIds='" + sitem + "',";

		
		  /*for (String a : userIds) {
		  
		  act = act + "(\"" + resttravelModel.getModuleId() + "\",\"" +
		  resttravelModel.getComponentId() + "\",\"" +
		  resttravelModel.getSubComponentId() + "\",\"" + a + "\",\"" +
		  "Delete Requisition" + "\",\"" + resttravelModel.getCreatedBy() + "\"),";
		  
		  }*/
		 
		/*
		 * act = act.substring(0, act.length() - 1);
		 * 
		 * s = s + "@p_actSubQuery='" + act + "',";
		 */
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		System.out.println("generated"+sitem);

		return s;
	}

}

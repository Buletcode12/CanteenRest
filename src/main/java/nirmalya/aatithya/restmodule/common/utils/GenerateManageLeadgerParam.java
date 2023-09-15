package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;


public class GenerateManageLeadgerParam {

	public static String addManageLeadgerParam(RestManageLeadgerModel manageleadger) {

		String s = "";
		if (manageleadger.getLeadgerId() != null || manageleadger.getLeadgerId() != "") {
			s = s + "@p_leaderId='" + manageleadger.getLeadgerId() + "',";
		}
		if (manageleadger.getLedgername() != null || manageleadger.getLedgername() != "") {
			s = s + "@p_leaderName='" + manageleadger.getLedgername() + "',";
		}
		if (manageleadger.getGroupId() != null || manageleadger.getGroupId() != "") {
			s = s + "@p_groupId='" + manageleadger.getGroupId() + "',";
		}
		if (manageleadger.getLname() != null || manageleadger.getLname() != "") {
			s = s + "@p_mailingName='" + manageleadger.getLname() + "',";
		}
		if (manageleadger.getAddress() != null || manageleadger.getAddress() != "") {
			s = s + "@p_leaderAddress='" + manageleadger.getAddress() + "',";
		}
		if (manageleadger.getLeadgercountry() != null || manageleadger.getLeadgercountry() != "") {
			s = s + "@p_leaderCountry='" + manageleadger.getLeadgercountry() + "',";
		}
		if (manageleadger.getLeadgerstate() != null || manageleadger.getLeadgerstate() != "") {
			s = s + "@p_leaderState='" + manageleadger.getLeadgerstate() + "',";
		}
		if (manageleadger.getPincode() != null || manageleadger.getPincode() != "") {
			s = s + "@p_leaderPincode='" + manageleadger.getPincode() + "',";
		}
		if (manageleadger.getPanitn() != null || manageleadger.getPanitn() != "") {
			s = s + "@p_leaderPaitn='" + manageleadger.getPanitn() + "',";
		}
		if (manageleadger.getOpeninbalanceDate() != null || manageleadger.getOpeninbalanceDate() != "") {
			s = s + "@p_leaderopebal='" + manageleadger.getOpeninbalanceDate() + "',";
		}


		if (s != "") { 
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}

}

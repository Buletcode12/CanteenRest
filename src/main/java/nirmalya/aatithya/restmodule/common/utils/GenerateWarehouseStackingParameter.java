package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

public class GenerateWarehouseStackingParameter {
	
	public static String saveStackdataParam(List<WirehouseRomeModel> wirehouseRomeModel) {
		String s = "";
		String zoneId="";
		String rackId="";
		String allocationId="";
		String oldBinId="";
		String newBinId="";
	    String organization="";
		String orgDivision="";
		
		for (WirehouseRomeModel m : wirehouseRomeModel) {
			zoneId=m.getZoneId();
			rackId=m.getRackId();
			allocationId=m.getAllocationId();
			oldBinId=m.getOldBinId();
			newBinId=m.getNewBinId();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
			
			
					
		}
		
		s = s + "@p_zoneId='" + zoneId + "',";
		s = s + "@p_rackId='" + rackId + "',";
		s = s + "@p_allocationId='" + allocationId + "',";
		s = s + "@p_oldBinId='" + oldBinId + "',";
		s = s + "@p_newBinId='" + newBinId + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
	
	
		System.out.println(wirehouseRomeModel);
		if(!wirehouseRomeModel.isEmpty()) {
			if(!wirehouseRomeModel.get(0).getAllocationId().contentEquals("1")) {
				if (s != "") {
				s = s.substring(0, s.length() - 1);
				s = "SET " + s + ";";
				}
				}
		}else {
			System.out.println("customer object is empty.");
		}
		
		
		return s;
	}
	
	
	

}

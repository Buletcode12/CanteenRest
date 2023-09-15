package nirmalya.aatithya.restmodule.common.utils.gatePass;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;

public class GenerateGatePassEntryPAram {
	
	public static String getGatepassEntryParamforLoading(List<RestGatePassDetailsModel> gatepass) {
		String s = "";
		String listdata = "";
		System.out.println("gatepass====" + gatepass);
		if (gatepass.get(0).getGetPassEntryId() != null && gatepass.get(0).getGetPassEntryId() != "") {
			s = s + "@p_Entryid='" + gatepass.get(0).getGetPassEntryId() + "',";
		}
		if (gatepass.get(0).getType() != null && gatepass.get(0).getType() != "") {
			s = s + "@p_type='" + gatepass.get(0).getType() + "',";
		}
		if (gatepass.get(0).getEntrydate() != null && gatepass.get(0).getEntrydate() != "") {
			s = s + "@p_entrydate='" + DateFormatter.getStringDate(gatepass.get(0).getEntrydate()) + "',";
		}
		if (gatepass.get(0).getEntryTime() != null && gatepass.get(0).getEntryTime() != "") {
			s = s + "@p_entrytime='" + gatepass.get(0).getEntryTime() + "',";
		}
		if (gatepass.get(0).getTransportName() != null && gatepass.get(0).getTransportName() != "") {
			s = s + "@p_transportName='" + gatepass.get(0).getTransportName() + "',";
		}
		if (gatepass.get(0).getLrNo() != null && gatepass.get(0).getLrNo() != "") {
			s = s + "@p_lrNo='" + gatepass.get(0).getLrNo() + "',";
		}
		if (gatepass.get(0).getVechileNo() != null && gatepass.get(0).getVechileNo() != "") {
			s = s + "@p_vechileno='" + gatepass.get(0).getVechileNo() + "',";
		}
		
		if (gatepass.get(0).getDriverName() != null && gatepass.get(0).getDriverName() != "") {
			s = s + "@p_drivername='" + gatepass.get(0).getDriverName() + "',";
		}
		if (gatepass.get(0).getDriverMobile() != null && gatepass.get(0).getDriverMobile() != "") {
			s = s + "@p_drivermob='" + gatepass.get(0).getDriverMobile() + "',";
		}
	
		if (gatepass.get(0).getNoOfWheel() != null && gatepass.get(0).getNoOfWheel() != "") {
			s = s + "@p_noOfWheel='" + gatepass.get(0).getNoOfWheel() + "',";
		}
		if (gatepass.get(0).getDlNo() != null && gatepass.get(0).getDlNo() != "") {
			s = s + "@p_dlNo='" + gatepass.get(0).getDlNo() + "',";
		}
		if (gatepass.get(0).getDepoName() != null && gatepass.get(0).getDepoName() != "") {
			s = s + "@p_depoName='" + gatepass.get(0).getDepoName() + "',";
		}
		
		if (gatepass.get(0).getTruckSeal() != null && gatepass.get(0).getTruckSeal() != "") {
			s = s + "@p_truckSeal='" + gatepass.get(0).getTruckSeal() + "',";
		}
		if (gatepass.get(0).getRoadTax() != null && gatepass.get(0).getRoadTax() != "") {
			s = s + "@p_roadTax='" + gatepass.get(0).getRoadTax() + "',";
		}
		if (gatepass.get(0).getInsuranceDate() != null && gatepass.get(0).getInsuranceDate() != "") {
			s = s + "@p_insuranceDate='" + DateFormatter.getStringDate(gatepass.get(0).getInsuranceDate()) + "',";
		}
		
		if (gatepass.get(0).getPolutionDate() != null && gatepass.get(0).getPolutionDate() != "") {
			s = s + "@p_polutionDate='" + DateFormatter.getStringDate(gatepass.get(0).getPolutionDate()) + "',";
		}
		if (gatepass.get(0).getPolutionNo() != null && gatepass.get(0).getPolutionNo() != "") {
			s = s + "@p_polutionNo='" + gatepass.get(0).getPolutionNo() + "',";
		}
		if (gatepass.get(0).getFitnessDate() != null && gatepass.get(0).getFitnessDate() != "") {
			s = s + "@p_fitnessDate='" + DateFormatter.getStringDate(gatepass.get(0).getFitnessDate()) + "',";
		}
		if (gatepass.get(0).getDlDate() != null && gatepass.get(0).getDlDate() != "") {
			s = s + "@p_dlDate='" + DateFormatter.getStringDate(gatepass.get(0).getDlDate()) + "',";
		}
		if (gatepass.get(0).getCreatedBy() != null && gatepass.get(0).getCreatedBy() != "") {
			s = s + "@p_createdby='" + gatepass.get(0).getCreatedBy() + "',";
		}
		if (gatepass.get(0).getOrganizationName() != null && gatepass.get(0).getOrganizationName() != "") {
			s = s + "@p_orgName='" + gatepass.get(0).getOrganizationName() + "',";
		}
		if (gatepass.get(0).getOrganizationDivision() != null && gatepass.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + gatepass.get(0).getOrganizationDivision() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details" + s);
		return s;
	}
	
	public static String getGatepassEntryParamforUnLoading(List<RestGatePassDetailsModel> gatepass) {
		String s = "";
		String listdata = "";
		System.out.println("gatepass====" + gatepass);
		if (gatepass.get(0).getGetPassEntryId() != null && gatepass.get(0).getGetPassEntryId() != "") {
			s = s + "@p_Entryid='" + gatepass.get(0).getGetPassEntryId() + "',";
		}
		if (gatepass.get(0).getType() != null && gatepass.get(0).getType() != "") {
			s = s + "@p_type='" + gatepass.get(0).getType() + "',";
		}
		if (gatepass.get(0).getPoNumber() != null && gatepass.get(0).getPoNumber() != "") {
			s = s + "@p_poId='" + gatepass.get(0).getPoNumber() + "',";
		}
		if (gatepass.get(0).getEntrydate() != null && gatepass.get(0).getEntrydate() != "") {
			s = s + "@p_entrydate='" + DateFormatter.getStringDate(gatepass.get(0).getEntrydate()) + "',";
		}
		if (gatepass.get(0).getEntryTime() != null && gatepass.get(0).getEntryTime() != "") {
			s = s + "@p_entrytime='" + gatepass.get(0).getEntryTime() + "',";
		}
		if (gatepass.get(0).getTransportName() != null && gatepass.get(0).getTransportName() != "") {
			s = s + "@p_transportName='" + gatepass.get(0).getTransportName() + "',";
		}
		if (gatepass.get(0).getLrNo() != null && gatepass.get(0).getLrNo() != "") {
			s = s + "@p_lrNo='" + gatepass.get(0).getLrNo() + "',";
		}
		if (gatepass.get(0).getVechileNo() != null && gatepass.get(0).getVechileNo() != "") {
			s = s + "@p_vechileno='" + gatepass.get(0).getVechileNo() + "',";
		}
		
		if (gatepass.get(0).getDriverName() != null && gatepass.get(0).getDriverName() != "") {
			s = s + "@p_drivername='" + gatepass.get(0).getDriverName() + "',";
		}
		if (gatepass.get(0).getDriverMobile() != null && gatepass.get(0).getDriverMobile() != "") {
			s = s + "@p_drivermob='" + gatepass.get(0).getDriverMobile() + "',";
		}
	
		if (gatepass.get(0).getNoOfWheel() != null && gatepass.get(0).getNoOfWheel() != "") {
			s = s + "@p_noOfWheel='" + gatepass.get(0).getNoOfWheel() + "',";
		}
		if (gatepass.get(0).getDlNo() != null && gatepass.get(0).getDlNo() != "") {
			s = s + "@p_dlNo='" + gatepass.get(0).getDlNo() + "',";
		}
		if (gatepass.get(0).getCreatedBy() != null && gatepass.get(0).getCreatedBy() != "") {
			s = s + "@p_createdby='" + gatepass.get(0).getCreatedBy() + "',";
		}
		if (gatepass.get(0).getOrganizationName() != null && gatepass.get(0).getOrganizationName() != "") {
			s = s + "@p_orgName='" + gatepass.get(0).getOrganizationName() + "',";
		}
		if (gatepass.get(0).getOrganizationDivision() != null && gatepass.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + gatepass.get(0).getOrganizationDivision() + "',";
		}
		if (gatepass.get(0).getVendorName() != null && gatepass.get(0).getVendorName() != "") {
			s = s + "@p_vendorName='" + gatepass.get(0).getVendorName() + "',";
		}else {
			s = s + "@p_vendorName='',";
		}
		if (gatepass.get(0).getVendorId() != null && gatepass.get(0).getVendorId() != "") {
			s = s + "@p_vendorId='" + gatepass.get(0).getVendorId() + "',";
		}else {
			s = s + "@p_vendorId='',";
		}
		
		if (gatepass.get(0).getItemId() != null && gatepass.get(0).getItemId() != "") {
			for (RestGatePassDetailsModel m : gatepass) {
				Double pending = 0.00;
				if (m.getPendingQuantity() != null) {
					pending = m.getPendingQuantity();
				}
				System.out.println("pending " + pending);
				Double receiving = 0.00;
				if (m.getReceivingQuantity() != null) {

					receiving = m.getReceivingQuantity();

				}
				Double received = 0.00;
				if (m.getReceivedQuantity() != null) {
					received = m.getReceivedQuantity();
				}
				String cDate = "";
				if (m.getChallanDate() != null) {
					cDate = DateFormatter.getStringDate(m.getChallanDate());
				}
				System.out.println("cDate " + cDate);
				
				
				  listdata = listdata + "(@p_Entryid,@p_poId,\"" + m.getItemId() + "\",\"" +
				  m.getItemName() + "\",\"" + m.getHsnCode() + "\"," + m.getQuantity() + "," +
				  m.getLineTotal() + ",\"" + m.getSku() + "\",\"" + m.getUnit() + "\"," +
				  pending + "," + receiving + "," +received+ "," +cDate +",\"" + m.getChallanDate() +"\",\"" + m.getDescItem() +
				  "\"),";
		
				 
			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_litemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_litemSubQuery='',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details" + s);
		return s;
	}

	public static String getGatepassEntryParamforBothh(List<RestGatePassDetailsModel> gatepass) {
		String s = "";
		String listdata = "";
		System.out.println("gatepass====" + gatepass);
	    if (gatepass.get(0).getGetPassEntryId() != null && gatepass.get(0).getGetPassEntryId() != "") {
			s = s + "@p_Entryid='" + gatepass.get(0).getGetPassEntryId() + "',";
		}
		if (gatepass.get(0).getType() != null && gatepass.get(0).getType() != "") {
			s = s + "@p_type='" + gatepass.get(0).getType() + "',";
		}
		if (gatepass.get(0).getPoNumber() != null && gatepass.get(0).getPoNumber() != "") {
			s = s + "@p_poId='" + gatepass.get(0).getPoNumber() + "',";
		}else {
			s = s + "@p_poId='',";
		}
		if (gatepass.get(0).getEntrydate() != null && gatepass.get(0).getEntrydate() != "") {
			s = s + "@p_entrydate='" + DateFormatter.getStringDate(gatepass.get(0).getEntrydate()) + "',";
		}
		if (gatepass.get(0).getEntryTime() != null && gatepass.get(0).getEntryTime() != "") {
			s = s + "@p_entrytime='" + gatepass.get(0).getEntryTime() + "',";
		}
		if (gatepass.get(0).getTransportName() != null && gatepass.get(0).getTransportName() != "") {
			s = s + "@p_transportName='" + gatepass.get(0).getTransportName() + "',";
		}else {
			s = s + "@p_transportName='',";
		}
		
		if (gatepass.get(0).getLrNo() != null && gatepass.get(0).getLrNo() != "") {
			s = s + "@p_lrNo='" + gatepass.get(0).getLrNo() + "',";
		}else {
			s = s + "@p_lrNo='',";
		}
		if (gatepass.get(0).getVechileNo() != null && gatepass.get(0).getVechileNo() != "") {
			s = s + "@p_vechileno='" + gatepass.get(0).getVechileNo() + "',";
		}else {
			s = s + "@p_vechileno='',";
		}		
		if (gatepass.get(0).getDriverName() != null && gatepass.get(0).getDriverName() != "") {
			s = s + "@p_drivername='" + gatepass.get(0).getDriverName() + "',";
		}else {
			s = s + "@p_drivername='',";
		}
		if (gatepass.get(0).getDriverMobile() != null && gatepass.get(0).getDriverMobile() != "") {
			s = s + "@p_drivermob='" + gatepass.get(0).getDriverMobile() + "',";
		}else {
			s = s + "@p_drivermob='',";
		}	
		if (gatepass.get(0).getNoOfWheel() != null && gatepass.get(0).getNoOfWheel() != "") {
			s = s + "@p_noOfWheel='" + gatepass.get(0).getNoOfWheel() + "',";
		}else {
			s = s + "@p_noOfWheel='',";
		}
		if (gatepass.get(0).getDlNo() != null && gatepass.get(0).getDlNo() != "") {
			s = s + "@p_dlNo='" + gatepass.get(0).getDlNo() + "',";
		}else {
			s = s + "@p_dlNo='',";
		}
		if (gatepass.get(0).getDepoName() != null && gatepass.get(0).getDepoName() != "") {
			s = s + "@p_depoName='" + gatepass.get(0).getDepoName() + "',";
		}else {
			s = s + "@p_depoName='',";
		}		
		if (gatepass.get(0).getTruckSeal() != null && gatepass.get(0).getTruckSeal() != "") {
			s = s + "@p_truckSeal='" + gatepass.get(0).getTruckSeal() + "',";
		}else {
			s = s + "@p_truckSeal='',";
		}
		if (gatepass.get(0).getRoadTax() != null && gatepass.get(0).getRoadTax() != "") {
			s = s + "@p_roadTax='" + gatepass.get(0).getRoadTax() + "',";
		}else {
			s = s + "@p_roadTax='',";
		}
		if (gatepass.get(0).getInsuranceDate() != null && gatepass.get(0).getInsuranceDate() != "") {
			s = s + "@p_insuranceDate='" + DateFormatter.getStringDate(gatepass.get(0).getInsuranceDate()) + "',";
		} /*
			 * else { s = s + "@p_insuranceDate='',"; }
			 */
		if (gatepass.get(0).getPolutionDate() != null && gatepass.get(0).getPolutionDate() != "") {
			s = s + "@p_polutionDate='" + DateFormatter.getStringDate(gatepass.get(0).getPolutionDate()) + "',";
		} /*
			 * else { s = s + "@p_polutionDate='',"; }
			 */
		if (gatepass.get(0).getPolutionNo() != null && gatepass.get(0).getPolutionNo() != "") {
			s = s + "@p_polutionNo='" + gatepass.get(0).getPolutionNo() + "',";
		}else {
			s = s + "@p_polutionNo='',";
		}
		if (gatepass.get(0).getFitnessDate() != null && gatepass.get(0).getFitnessDate() != "") {
			s = s + "@p_fitnessDate='" + DateFormatter.getStringDate(gatepass.get(0).getFitnessDate()) + "',";
		} /*
			 * else { s = s + "@p_fitnessDate='',"; }
			 */
		if (gatepass.get(0).getDlDate() != null && gatepass.get(0).getDlDate() != "") {
			s = s + "@p_dlDate='" + DateFormatter.getStringDate(gatepass.get(0).getDlDate()) + "',";
		} /*
			 * else { s = s + "@p_dlDate='',"; }
			 */
		if (gatepass.get(0).getCreatedBy() != null && gatepass.get(0).getCreatedBy() != "") {
			s = s + "@p_createdby='" + gatepass.get(0).getCreatedBy() + "',";
		}
		if (gatepass.get(0).getOrganizationName() != null && gatepass.get(0).getOrganizationName() != "") {
			s = s + "@p_orgName='" + gatepass.get(0).getOrganizationName() + "',";
		}
		if (gatepass.get(0).getOrganizationDivision() != null && gatepass.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + gatepass.get(0).getOrganizationDivision() + "',";
		}
		if (gatepass.get(0).getItemId() != null && gatepass.get(0).getItemId() != "") {
			s = s + "@p_itemId='" + gatepass.get(0).getItemId() + "',";
		}
		if (gatepass.get(0).getVisitingName() != null && gatepass.get(0).getVisitingName() != "") {
			s = s + "@p_visitingName='" + gatepass.get(0).getVisitingName() + "',";
		}else {
			s = s + "@p_visitingName='',";
		}
		if (gatepass.get(0).getVisitingAddress() != null && gatepass.get(0).getVisitingAddress() != "") {
			s = s + "@p_visitingAddress='" + gatepass.get(0).getVisitingAddress() + "',";
		}else {
			s = s + "@p_visitingAddress='',";
		}
		if (gatepass.get(0).getVisitingPurpose() != null && gatepass.get(0).getVisitingPurpose() != "") {
			s = s + "@p_visitingPurpose='" + gatepass.get(0).getVisitingPurpose() + "',";
		}else {
			s = s + "@p_visitingPurpose='',";
		}
		if (gatepass.get(0).getVisitingTomeet() != null && gatepass.get(0).getVisitingTomeet() != "") {
			s = s + "@p_visitingTomeet='" + gatepass.get(0).getVisitingTomeet() + "',";
		}else {
			s = s + "@p_visitingTomeet='',";
		}
		if (gatepass.get(0).getVisitingPassno() != null && gatepass.get(0).getVisitingPassno() != "") {
			s = s + "@p_visitingPassno='" + gatepass.get(0).getVisitingPassno() + "',";
		}else {
			s = s + "@p_visitingPassno='',";
		}
		if (gatepass.get(0).getVisitingMobile() != null && gatepass.get(0).getVisitingMobile() != "") {
			s = s + "@p_visitorMobile='" + gatepass.get(0).getVisitingMobile() + "',";
		}else {
			s = s + "@p_visitorMobile='',";
		}
		if (gatepass.get(0).getImage() != null && gatepass.get(0).getImage() != "") {
			s = s + "@p_image='" + gatepass.get(0).getImage() + "',";
		}else {
			s = s + "@p_image='',";
		}
		if (gatepass.get(0).getPoType() != null && gatepass.get(0).getPoType() != "") {
			s = s + "@p_poType='" + gatepass.get(0).getPoType() + "',";
		}else {
			s = s + "@p_poType='',";
		}
		if (gatepass.get(0).getVendorName() != null && gatepass.get(0).getVendorName() != "") {
			s = s + "@p_vendorName='" + gatepass.get(0).getVendorName() + "',";
		}else {
			s = s + "@p_vendorName='',";
		}
		if (gatepass.get(0).getVendorId() != null && gatepass.get(0).getVendorId() != "") {
			s = s + "@p_vendorId='" + gatepass.get(0).getVendorId() + "',";
		}else {
			s = s + "@p_vendorId='',";
		}
		
		if (gatepass.get(0).getItemId() != null && gatepass.get(0).getItemId() != "") {
			for (RestGatePassDetailsModel m : gatepass) {
				Double pending = 0.00;
				if (m.getPendingQuantity() != null) {
					pending = m.getPendingQuantity();
				}
				Double receiving = 0.00;
				if (m.getReceivingQuantity() != null) {

					receiving = m.getReceivingQuantity();

				}
				Double received = 0.00;
				if (m.getReceivedQuantity() != null) {
					received = m.getReceivedQuantity();
				}
				String cDate = "";
				if (m.getChallanDate() != null && m.getChallanDate() != "") {
					cDate = DateFormatter.getStringDate(m.getChallanDate());
				}
				
				  listdata = listdata + "(@p_Entryid,@p_poId,\"" + m.getItemId() + "\",\"" +
				  m.getItemName() + "\",\"" + m.getHsnCode() + "\"," + m.getQuantity() + "," +
				  m.getLineTotal() + ",\"" + m.getSku() + "\",\"" + m.getUnit() + "\"," +
				  pending + "," + receiving + "," +received+ ",\"" +cDate +"\",\"" + m.getChallanNo() +"\",\"" + m.getDescItem() +"\",\"" + m.getOrganizationName() + "\",\"" + m.getOrganizationDivision() + "\"),";
		
				 
			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_litemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_litemSubQuery='',";
		}
	
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}

	public static String getGatepassEntryParamForBoth(List<RestGatePassDetailsModel> gatepass) {
		String s = "";
		String listdata = "";
		System.out.println("gatepass====" + gatepass);
		
		
		if (gatepass.get(0).getGetPassEntryId() != null && gatepass.get(0).getGetPassEntryId() != "") {
			s = s + "@p_Entryid='" + gatepass.get(0).getGetPassEntryId() + "',";
		}
		if (gatepass.get(0).getPoNumber() != null && gatepass.get(0).getPoNumber() != "") {
			s = s + "@p_poId='" + gatepass.get(0).getPoNumber() + "',";
		}
		if (gatepass.get(0).getType() != null && gatepass.get(0).getType() != "") {
			s = s + "@p_type='" + gatepass.get(0).getType() + "',";
		}
		if (gatepass.get(0).getEntrydate() != null && gatepass.get(0).getEntrydate() != "") {
			s = s + "@p_entrydate='" + DateFormatter.getStringDate(gatepass.get(0).getEntrydate()) + "',";
		}
		if (gatepass.get(0).getEntryTime() != null && gatepass.get(0).getEntryTime() != "") {
			s = s + "@p_entrytime='" + gatepass.get(0).getEntryTime() + "',";
		}
		if (gatepass.get(0).getTransportName() != null && gatepass.get(0).getTransportName() != "") {
			s = s + "@p_transportName='" + gatepass.get(0).getTransportName() + "',";
		}
		if (gatepass.get(0).getLrNo() != null && gatepass.get(0).getLrNo() != "") {
			s = s + "@p_lrNo='" + gatepass.get(0).getLrNo() + "',";
		}
		if (gatepass.get(0).getVechileNo() != null && gatepass.get(0).getVechileNo() != "") {
			s = s + "@p_vechileno='" + gatepass.get(0).getVechileNo() + "',";
		}
		
		if (gatepass.get(0).getDriverName() != null && gatepass.get(0).getDriverName() != "") {
			s = s + "@p_drivername='" + gatepass.get(0).getDriverName() + "',";
		}
		if (gatepass.get(0).getDriverMobile() != null && gatepass.get(0).getDriverMobile() != "") {
			s = s + "@p_drivermob='" + gatepass.get(0).getDriverMobile() + "',";
		}
	
		if (gatepass.get(0).getNoOfWheel() != null && gatepass.get(0).getNoOfWheel() != "") {
			s = s + "@p_noOfWheel='" + gatepass.get(0).getNoOfWheel() + "',";
		}
		if (gatepass.get(0).getDlNo() != null && gatepass.get(0).getDlNo() != "") {
			s = s + "@p_dlNo='" + gatepass.get(0).getDlNo() + "',";
		}
		if (gatepass.get(0).getDepoName() != null && gatepass.get(0).getDepoName() != "") {
			s = s + "@p_depoName='" + gatepass.get(0).getDepoName() + "',";
		}
		
		if (gatepass.get(0).getTruckSeal() != null && gatepass.get(0).getTruckSeal() != "") {
			s = s + "@p_truckSeal='" + gatepass.get(0).getTruckSeal() + "',";
		}
		if (gatepass.get(0).getRoadTax() != null && gatepass.get(0).getRoadTax() != "") {
			s = s + "@p_roadTax='" + gatepass.get(0).getRoadTax() + "',";
		}
		if (gatepass.get(0).getInsuranceDate() != null && gatepass.get(0).getInsuranceDate() != "") {
			s = s + "@p_insuranceDate='" + DateFormatter.getStringDate(gatepass.get(0).getInsuranceDate()) + "',";
		}
		
		if (gatepass.get(0).getPolutionDate() != null && gatepass.get(0).getPolutionDate() != "") {
			s = s + "@p_polutionDate='" + DateFormatter.getStringDate(gatepass.get(0).getPolutionDate()) + "',";
		}
		if (gatepass.get(0).getPolutionNo() != null && gatepass.get(0).getPolutionNo() != "") {
			s = s + "@p_polutionNo='" + gatepass.get(0).getPolutionNo() + "',";
		}
		if (gatepass.get(0).getFitnessDate() != null && gatepass.get(0).getFitnessDate() != "") {
			s = s + "@p_fitnessDate='" + DateFormatter.getStringDate(gatepass.get(0).getFitnessDate()) + "',";
		}
		if (gatepass.get(0).getDlDate() != null && gatepass.get(0).getDlDate() != "") {
			s = s + "@p_dlDate='" + DateFormatter.getStringDate(gatepass.get(0).getDlDate()) + "',";
		}
		if (gatepass.get(0).getCreatedBy() != null && gatepass.get(0).getCreatedBy() != "") {
			s = s + "@p_createdby='" + gatepass.get(0).getCreatedBy() + "',";
		}
		if (gatepass.get(0).getOrganizationName() != null && gatepass.get(0).getOrganizationName() != "") {
			s = s + "@p_orgName='" + gatepass.get(0).getOrganizationName() + "',";
		}
		if (gatepass.get(0).getOrganizationDivision() != null && gatepass.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + gatepass.get(0).getOrganizationDivision() + "',";
		}
		if (gatepass.get(0).getVendorName() != null && gatepass.get(0).getVendorName() != "") {
			s = s + "@p_vendorName='" + gatepass.get(0).getVendorName() + "',";
		}else {
			s = s + "@p_vendorName='',";
		}
		if (gatepass.get(0).getVendorId() != null && gatepass.get(0).getVendorId() != "") {
			s = s + "@p_vendorId='" + gatepass.get(0).getVendorId() + "',";
		}else {
			s = s + "@p_vendorId='',";
		}
		

		if (gatepass.get(0).getItemId() != null && gatepass.get(0).getItemId() != "") {
			for (RestGatePassDetailsModel m : gatepass) {
				Double pending = 0.00;
				if (m.getPendingQuantity() != null) {
					pending = m.getPendingQuantity();
				}
				System.out.println("pending " + pending);
				Double receiving = 0.00;
				if (m.getReceivingQuantity() != null) {

					receiving = m.getReceivingQuantity();

				}
				Double received = 0.00;
				if (m.getReceivedQuantity() != null) {
					received = m.getReceivedQuantity();
				}
				String cDate = "";
				if (m.getChallanDate() != null) {
					cDate = DateFormatter.getStringDate(m.getChallanDate());
				}
				System.out.println("cDate " + cDate);
				
				
				  listdata = listdata + "(@p_Entryid,@p_poId,\"" + m.getItemId() + "\",\"" +
				  m.getItemName() + "\",\"" + m.getHsnCode() + "\"," + m.getQuantity() + "," +
				  m.getLineTotal() + ",\"" + m.getSku() + "\",\"" + m.getUnit() + "\"," +
				  pending + "," + receiving + "," +received+ "," +cDate +",\"" + m.getChallanDate() +"\",\"" + m.getDescItem() +
				  "\"),";
		
				 
			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_litemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_litemSubQuery='',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details--------------" + s);
		return s;
	}
}

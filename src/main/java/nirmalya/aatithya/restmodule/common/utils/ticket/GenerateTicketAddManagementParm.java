package nirmalya.aatithya.restmodule.common.utils.ticket;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.ticket.model.TicketRestDocumentManagementModel;

public class GenerateTicketAddManagementParm {

	public static String saveTicketDetails(List<TicketManagementRestModel> category) {

		String s = "";

		if (category.get(0).getTicketId() != null && category.get(0).getTicketId() != "") {
			s = s + "@p_ticketId='" + category.get(0).getTicketId() + "',";
		}else {
			s = s + "@p_ticketId='" + "" + "',";
		}
		if (category.get(0).getEmpId() != null && category.get(0).getEmpId() != "") {
			s = s + "@p_empId='" + category.get(0).getEmpId() + "',";
		}
		else {
			s = s + "@p_empId='" + "" + "',";
		}
		if (category.get(0).getDate() != null && category.get(0).getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(category.get(0).getDate()) + "',";
		}
		else {
			s = s + "@p_date='" + "" + "',";
		}
		if (category.get(0).getEmpName() != null && category.get(0).getEmpName() != "") {
			s = s + "@p_empName='" + category.get(0).getEmpName() + "',";
		}else {
			s = s + "@p_empName='" + "" + "',";
		}
		if (category.get(0).getDept() != null && category.get(0).getDept() != "") {
			s = s + "@p_dept='" + category.get(0).getDept() + "',";
		}else {
			s = s + "@p_dept='" + "" + "',";
		}
		if (category.get(0).getTicketType() != null && category.get(0).getTicketType() != "") {
			s = s + "@p_tktType='" + category.get(0).getTicketType() + "',";
		}else {
			s = s + "@p_tktType='" + "" + "',";
		}
		if (category.get(0).getTicketCategory() != null && category.get(0).getTicketCategory() != "") {
			s = s + "@p_tktCatagory='" + category.get(0).getTicketCategory() + "',";
		}else {
			s = s + "@p_tktCatagory='" + "" + "',";
		}
		if (category.get(0).getTicketSubCategory() != null && category.get(0).getTicketSubCategory() != "") {
			s = s + "@p_tktSubCatagory='" + category.get(0).getTicketSubCategory() + "',";
		}else {
			s = s + "@p_tktSubCatagory='" + "" + "',";
		}
		if (category.get(0).getTicketPriority() != null && category.get(0).getTicketPriority() != "") {
			s = s + "@p_tktPriority='" + category.get(0).getTicketPriority() + "',";
		}else {
			s = s + "@p_tktPriority='" + "" + "',";
		}
		if (category.get(0).getDescription() != null && category.get(0).getDescription() != "") {
			s = s + "@p_tktDesc='" + category.get(0).getDescription() + "',";
		}else {
			s = s + "@p_tktDesc='" + "" + "',";
		}
		if (category.get(0).getLocType() != null && category.get(0).getLocType() != "") {
			s = s + "@p_locType='" + category.get(0).getLocType() + "',";
		}else {
			s = s + "@p_locType='" + "" + "',";
		}
		if (category.get(0).getLatitude() != null && category.get(0).getLatitude() != "") {
			s = s + "@p_latitude='" + category.get(0).getLatitude() + "',";
		}else {
			s = s + "@p_latitude='" + "" + "',";
		}
		if (category.get(0).getLongitude() != null && category.get(0).getLongitude() != "") {
			s = s + "@p_longitude='" + category.get(0).getLongitude() + "',";
		}else {
			s = s + "@p_longitude='" + "" + "',";
		}
		if (category.get(0).getAddress() != null && category.get(0).getAddress() != "") {
			s = s + "@p_address='" + category.get(0).getAddress() + "',";
		}else {
			s = s + "@p_address='" + "" + "',";
		}
		if (category.get(0).getEmpAddress() != null && category.get(0).getEmpAddress() != "") {
			s = s + "@p_empAddress='" + category.get(0).getEmpAddress() + "',";
		}else {
			s = s + "@p_empAddress='" + "" + "',";
		}
		if (category.get(0).getCreatedBy() != null && category.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.get(0).getCreatedBy() + "',";
		}else {
			s = s + "@p_createdBy='" + "" + "',";
		}
		if (category.get(0).getOrganization() != null && category.get(0).getOrganization() != "") {
			s = s + "@p_organization='" + category.get(0).getOrganization() + "',";
		}else {
			s = s + "@p_organization='" + "" + "',";
		}
		if (category.get(0).getOrgDivision() != null && category.get(0).getOrgDivision() != "") {
			s = s + "@p_orgdivision='" + category.get(0).getOrgDivision() + "',";
		}else {
			s = s + "@p_orgdivision='" + "" + "',";
		}

		/*
		 * if (category.get(0).getMaterialStatus() != null &&
		 * category.get(0).getMaterialStatus() != "") { s = s + "@p_isActive=" +
		 * category.get(0).getMaterialStatus() + ","; } else { s = s + "@p_isActive=" +
		 * 0 + ","; }
		 */

		String document = "";
		for (TicketRestDocumentManagementModel a : category.get(0).getDocumentList()) {
			document = document + "(@p_ticketId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",\""
					+ a.getDocumentURL() + "\",@p_createdBy,@p_organization,@p_orgdivision),";
		}
		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_tktDocuments='" + document + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}

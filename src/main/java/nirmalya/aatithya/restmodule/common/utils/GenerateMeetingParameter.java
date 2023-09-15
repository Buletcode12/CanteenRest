package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;

public class GenerateMeetingParameter {

	public static String getMeetingParam(RestCrmMeetingModel form) {
		// TODO Auto-generated method stub
		String s = "";		
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";
		
		if (form.getMeetingId() != null && form.getMeetingId() != "") {
			s = s + "@p_meetingId='" + form.getMeetingId() + "',";
		}
		
		if (form.getMeetingLead() != null && form.getMeetingLead() != "") {
			s = s + "@p_meetingLead='" + form.getMeetingLead() + "',";
		}
		
		
		if (form.getOwnerName() != null && form.getOwnerName() != "") {
			s = s + "@p_ownerName='" + form.getOwnerName() + "',";
		}

		if (form.getMeetingTitle() != null && form.getMeetingTitle() != "") {
			s = s + "@p_meetingTitle='" + form.getMeetingTitle() + "',";
		}
		
		if (form.getMeetingLocation() != null && form.getMeetingLocation() != "") {
			s = s + "@p_meetingLocation='" + form.getMeetingLocation() + "',";
		}
		
		if (form.getIsThisOnlineMeeting() != null && form.getIsThisOnlineMeeting() != "") {
			s = s + "@p_isThisOnlineMeeting ='" + form.getIsThisOnlineMeeting() + "',";
		}
		
		if (form.getIsAllDay() != null && form.getIsAllDay() != "") {
			s = s + "@p_isAllDay='" + form.getIsAllDay() + "',";
		}
		
		if (form.getMeetingFromDate() != null && form.getMeetingFromDate() != "") {
			//s = s + "@p_meetingFromDate='" + DateFormatter.getStringDate(form.getMeetingFromDate()) + "',";
			s = s + "@p_meetingFromDate='" + form.getMeetingFromDate() + "',";
		}
		
		if (form.getMeetingFromTime() != null && form.getMeetingFromTime() != "") {
			s = s + "@p_meetingFromTime='" + form.getMeetingFromTime() + "',";
			
		}
		
		if (form.getMeetingToDate() != null && form.getMeetingToDate() != "") {
			//s = s + "@p_meetingToDate='" + DateFormatter.getStringDate(form.getMeetingToDate()) + "',";
			s = s + "@p_meetingToDate='" + form.getMeetingToDate() + "',";
		}
		
		if (form.getMeetingToTime() != null && form.getMeetingToTime() != "") {
			s = s + "@p_meetingToTime='" + form.getMeetingToTime() + "',";
		}
		if (form.getLeadName()!= null && form.getLeadName() != "") {
			s = s + "@p_leadName='" + form.getLeadName() + "',";
		}
		if (form.getLeadId()!= null && form.getLeadId() != "") {
			s = s + "@p_leadId='" + form.getLeadId() + "',";
		}
		if (form.getContactName()!= null && form.getContactName() != "") {
			s = s + "@p_contactName='" + form.getContactName() + "',";
		}
		if (form.getContactId()!= null && form.getContactId() != "") {
			s = s + "@p_contactId='" + form.getContactId() + "',";
		}
		
		if (form.getMeetingHost() != null && form.getMeetingHost() != "") {
			s = s + "@p_meetingHost='" + form.getMeetingHost() + "',";
		}
		
		if (form.getMeetingParticipants() != null && form.getMeetingParticipants() != "") {
			s = s + "@p_meetingParticipants='" + form.getMeetingParticipants() + "',";
		}
		if (form.getParticipantId() != null && form.getParticipantId() != "") {
			s = s + "@p_meetingParticipantId='" + form.getParticipantId() + "',";
		}
		
			
		if (form.getRelatedMeetingTo() != null && form.getRelatedMeetingTo() != "") {
			s = s + "@p_relatedMeetingTo ='" + form.getRelatedMeetingTo() + "',";
		}
		
		if (form.getIsRepeat() != null && form.getIsRepeat() != "") {
			s = s + "@p_isRepeat='" + form.getIsRepeat() + "',";
		}
		
		if (form.getMeetingStatus() != null && form.getMeetingStatus() != "") {
			s = s + "@p_meetingStatus='" + form.getMeetingStatus() + "',";
		}
		
		if (form.getIsAllDay() != null && form.getIsAllDay() != "") {
			s = s + "@p_isAllDay='" + form.getIsAllDay() + "',";
		}
		
		
		if (form.getMeetingRepeatFromDate() != null && form.getMeetingRepeatFromDate() != "") {
			//s = s + "@p_meetingRepeatFromDate='" + DateFormatter.getStringDate(form.getMeetingRepeatFromDate()) + "',";
			
			s = s + "@p_meetingRepeatFromDate='" + form.getMeetingRepeatFromDate() + "',";
		}
		
		if (form.getMeetingRepeatFromTime() != null && form.getMeetingRepeatFromTime() != "") {
			s = s + "@p_meetingRepeatFromTime='" + form.getMeetingRepeatFromTime() + "',";
		}
		
		if (form.getMeetingRepeatToDate() != null && form.getMeetingRepeatToDate() != "") {
			//s = s + "@p_meetingRepeatToDate='" + DateFormatter.getStringDate(form.getMeetingRepeatToDate()) + "',";
			
			s = s + "@p_meetingRepeatToDate='" + form.getMeetingRepeatToDate() + "',";
		}
		
		System.out.println("@p_meetingRepeatToTime--------------------"+form.getMeetingCalendarRepeatToTime());
		
		if (form.getMeetingCalendarRepeatToTime() != null && form.getMeetingCalendarRepeatToTime() != "") {
			s = s + "@p_meetingRepeatToTime='" + form.getMeetingCalendarRepeatToTime() + "',";
		}
		
		
		if (form.getRepeatType() != null && form.getRepeatType() != "") {
			s = s + "@p_repeatType='" + form.getRepeatType() + "',";
		}
				
		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription() + "',";
		}
				
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}
		if (form.getMeetingLeadId() != null && form.getMeetingLeadId() != "") {
			s = s + "@p_meetingleadId='" + form.getMeetingLeadId() + "',";
		}
		
		if (form.getMeetingDealId() != null && form.getMeetingDealId() != "") {
			s = s + "@p_meetingDealId='" + form.getMeetingDealId() + "',";
		}
		if (form.getMeetingContactId() != null && form.getMeetingContactId() != "") {
			s = s + "@p_meetingcontactId='" + form.getMeetingContactId() + "',";
		}
		
		
		if (form.getMeetingAccountId() != null && form.getMeetingAccountId() != "") {
			s = s + "@p_meetingAccountId='" + form.getMeetingAccountId() + "',";
		}
		
		if (form.getQuoteId() != null && form.getQuoteId() != "") {
			s = s + "@p_quoteId='" + form.getQuoteId() + "',";
		}
		
		if (form.getSoId() != null && form.getSoId() != "") {
			s = s + "@p_soId='" + form.getSoId() + "',";
		}
		
		if (form.getPoId() != null && form.getPoId() != "") {
			s = s + "@p_poId='" + form.getPoId() + "',";
		}
		
		if (form.getInvoiceId() != null && form.getInvoiceId() != "") {
			s = s + "@p_invoiceId='" + form.getInvoiceId() + "',";
		}
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------"+s);
		return s;

	}
	
}

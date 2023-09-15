package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
public class RestEventManagementModel {
	private String eventId;
	private String eventName;
	private String fromDate;
	private String toDate;
	private String eventOrganiser;
	private String eventType;
	private String eventResponsible;
	private String evantMaxRegd;
	private String eventVanue;
	private String regdStartDate;
	private String regdEndDate;
	private String eventCreatedBy;
	private String organization;
	private String orgDivision;
	private String approvedDate;
	private String approvedBy;
	private String rejectDate;
	private String rejectedBy;
	private String status;
	private String approveComment;
	private String empName;
	private String createdBy;
	private String createdOn;
	private String applyStatus;
	
	private String eventSlNo;
	private String eventActivityDate;
	private String eventAvtivityStartTime;
	private String eventActivityEndTime;
	private String eventActivity;
	private String eventActivityRemark;
	
	private String notiSend;
	private String notiAction;
	private String notiInterval;
	private String nitoUnit;
	private String notiRule;
	private String notiSent;
	
	
	private List<RestEventActivityModel> activity;
	private List<RestEventNotificationModel> notification;
	
	
	public RestEventManagementModel(Object eventId, Object eventName, Object fromDate, Object toDate, Object eventOrganiser,
			Object eventType, Object regdStartDate, Object regdEndDate,Object applyStatus) {
		// TODO Auto-generated constructor stub
		
		this.eventId = (String)eventId;
		this.eventName = (String)eventName;
		this.fromDate = (String)fromDate;
		this.toDate = (String)toDate;
		this.eventOrganiser = (String)eventOrganiser;
		this.eventType = (String)eventType;
		this.regdStartDate = (String)regdStartDate;
		this.regdEndDate = (String)regdEndDate;
		this.applyStatus = (String)applyStatus;
		
		
	}
	
	
	public RestEventManagementModel(Object eventId, Object eventName, Object fromDate, Object toDate, Object eventOrganiser,
			Object eventType, Object regdStartDate, Object regdEndDate,Object status, Object approvedBy, Object rejectedBy,Object approveComment
			,Object empName, Object createdBy,Object createdOn) {
		// TODO Auto-generated constructor stub
		
		this.eventId = (String)eventId;
		this.eventName = (String)eventName;
		this.fromDate = (String)fromDate;
		this.toDate = (String)toDate;
		this.eventOrganiser = (String)eventOrganiser;
		this.eventType = (String)eventType;
		this.regdStartDate = (String)regdStartDate;
		this.regdEndDate = (String)regdEndDate;
		
		this.status = (String)status;
		this.approvedBy = (String)approvedBy;
		this.rejectedBy = (String)rejectedBy;
		this.approveComment = (String)approveComment;
		this.empName = (String)empName;
		this.createdBy = (String)createdBy;
		this.createdOn = (String)createdOn;
		
	}
	
	public RestEventManagementModel(Object eventId, Object eventName, Object fromDate, Object toDate, Object eventOrganiser,
			Object eventResponsible, Object evantMaxRegd, Object eventVanue,Object regdStartDate, Object regdEndDate, Object eventType,Object createdBy, Object eventSlNo
			,Object eventActivityDate, Object eventAvtivityStartTime, Object eventActivityEndTime,Object eventActivity, Object eventActivityRemark, Object notiSend,Object notiAction
			,Object notiInterval,Object nitoUnit,Object notiRule,Object notiSent) {
		// TODO Auto-generated constructor stub
	
		this.eventId = (String)eventId;
		this.eventName = (String)eventName;
		this.fromDate = (String)fromDate;
		this.toDate = (String)toDate;
		this.eventOrganiser = (String)eventOrganiser;
		this.eventResponsible = (String)eventResponsible;
		this.evantMaxRegd = (String)evantMaxRegd;
		this.eventVanue = (String)eventVanue;
		this.regdStartDate = (String)regdStartDate;
		this.regdEndDate = (String)regdEndDate;
		this.eventType = (String)eventType;
		this.createdBy = (String)createdBy;
		
		this.eventSlNo = (String)eventSlNo;
		this.eventActivityDate = (String)eventActivityDate;
		this.eventAvtivityStartTime = (String)eventAvtivityStartTime;
		this.eventActivityEndTime = (String)eventActivityEndTime;
		this.eventActivity = (String)eventActivity;
		this.eventActivityRemark = (String)eventActivityRemark;
		
		this.notiSend = (String)notiSend;
		this.notiAction = (String)notiAction;
		this.notiInterval = (String)notiInterval;
		this.nitoUnit = (String)nitoUnit;
		this.notiRule = (String)notiRule;
		this.notiSent = (String)notiSent;
	}
	
	
	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public RestEventManagementModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getEventOrganiser() {
		return eventOrganiser;
	}

	public void setEventOrganiser(String eventOrganiser) {
		this.eventOrganiser = eventOrganiser;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventResponsible() {
		return eventResponsible;
	}

	public void setEventResponsible(String eventResponsible) {
		this.eventResponsible = eventResponsible;
	}

	public String getEvantMaxRegd() {
		return evantMaxRegd;
	}

	public void setEvantMaxRegd(String evantMaxRegd) {
		this.evantMaxRegd = evantMaxRegd;
	}

	public String getEventVanue() {
		return eventVanue;
	}

	public void setEventVanue(String eventVanue) {
		this.eventVanue = eventVanue;
	}

	public String getRegdStartDate() {
		return regdStartDate;
	}

	public void setRegdStartDate(String regdStartDate) {
		this.regdStartDate = regdStartDate;
	}

	public String getRegdEndDate() {
		return regdEndDate;
	}

	public void setRegdEndDate(String regdEndDate) {
		this.regdEndDate = regdEndDate;
	}

	public List<RestEventActivityModel> getActivity() {
		return activity;
	}

	public void setActivity(List<RestEventActivityModel> activity) {
		this.activity = activity;
	}

	public List<RestEventNotificationModel> getNotification() {
		return notification;
	}

	public void setNotification(List<RestEventNotificationModel> notification) {
		this.notification = notification;
	}
	public String getEventCreatedBy() {
		return eventCreatedBy;
	}
	public void setEventCreatedBy(String eventCreatedBy) {
		this.eventCreatedBy = eventCreatedBy;
	}
	
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrgDivision() {
		return orgDivision;
	}

	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(String rejectDate) {
		this.rejectDate = rejectDate;
	}

	public String getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public String getApproveComment() {
		return approveComment;
	}

	public void setApproveComment(String approveComment) {
		this.approveComment = approveComment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getEventSlNo() {
		return eventSlNo;
	}



	public void setEventSlNo(String eventSlNo) {
		this.eventSlNo = eventSlNo;
	}



	public String getEventActivityDate() {
		return eventActivityDate;
	}



	public void setEventActivityDate(String eventActivityDate) {
		this.eventActivityDate = eventActivityDate;
	}



	public String getEventAvtivityStartTime() {
		return eventAvtivityStartTime;
	}



	public void setEventAvtivityStartTime(String eventAvtivityStartTime) {
		this.eventAvtivityStartTime = eventAvtivityStartTime;
	}



	public String getEventActivityEndTime() {
		return eventActivityEndTime;
	}



	public void setEventActivityEndTime(String eventActivityEndTime) {
		this.eventActivityEndTime = eventActivityEndTime;
	}



	public String getEventActivity() {
		return eventActivity;
	}



	public void setEventActivity(String eventActivity) {
		this.eventActivity = eventActivity;
	}



	public String getEventActivityRemark() {
		return eventActivityRemark;
	}



	public void setEventActivityRemark(String eventActivityRemark) {
		this.eventActivityRemark = eventActivityRemark;
	}
	



	public String getNotiSend() {
		return notiSend;
	}



	public void setNotiSend(String notiSend) {
		this.notiSend = notiSend;
	}



	public String getNotiAction() {
		return notiAction;
	}



	public void setNotiAction(String notiAction) {
		this.notiAction = notiAction;
	}



	public String getNotiInterval() {
		return notiInterval;
	}



	public void setNotiInterval(String notiInterval) {
		this.notiInterval = notiInterval;
	}



	public String getNitoUnit() {
		return nitoUnit;
	}



	public void setNitoUnit(String nitoUnit) {
		this.nitoUnit = nitoUnit;
	}



	public String getNotiRule() {
		return notiRule;
	}



	public void setNotiRule(String notiRule) {
		this.notiRule = notiRule;
	}



	public String getNotiSent() {
		return notiSent;
	}



	public void setNotiSent(String notiSent) {
		this.notiSent = notiSent;
	}



	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;

	}
}

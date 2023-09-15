package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmActivityModel {
	
	private String activityId;
	private String leadId;
	private String activityName;
	private String activityType;
	private String leadOwner;

	private String noteTitle; 
	private String noteDesc; 
	private String noteDocName;
	private String mailSubject;
	private String mailSentTo;
	private String participant;
	private String taskSubject;
	private String callScheduledWith;
	
	private String meetingFromDate;
	private String meetingFromTime;
	private String meetingToDate;
	private String meetingToTime;
	private String callStartDate;
	private String callStartTime;
	private String createdTime;
	private String createdBy;
	private String createdOn;

	
	public RestCrmActivityModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestCrmActivityModel(Object activityId, Object leadId, Object activityName,Object activityType, Object leadOwner,
			Object noteTitle, Object noteDesc, Object mailSubject,Object mailSentTo, Object participant, 
			Object callScheduledWith, Object meetingFromDate, Object meetingFromTime, Object meetingToDate,Object meetingToTime,
			Object createdTime, Object createdBy,Object createdOn) {
		
		
		super();
		try {
			this.activityId = (String) activityId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.leadId = (String) leadId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.activityName = (String) activityName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.activityType = (String) activityType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.leadOwner = (String) leadOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.noteTitle = (String) noteTitle;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.noteDesc = (String) noteDesc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.mailSubject = (String) mailSubject;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.mailSentTo = (String) mailSentTo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.participant = (String) participant;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			this.callScheduledWith = (String) callScheduledWith;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.meetingFromDate = (String) meetingFromDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.meetingFromTime = (String) meetingFromTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.meetingToDate = (String) meetingToDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.meetingToTime = (String) meetingToTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.createdTime = (String) createdTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.createdOn = (String) createdOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public String getActivityId() {
			return activityId;
		}
		public void setActivityId(String activityId) {
			this.activityId = activityId;
		}
		public String getLeadId() {
			return leadId;
		}
		public void setLeadId(String leadId) {
			this.leadId = leadId;
		}
		public String getActivityName() {
			return activityName;
		}
		public void setActivityName(String activityName) {
			this.activityName = activityName;
		}
		public String getActivityType() {
			return activityType;
		}
		public void setActivityType(String activityType) {
			this.activityType = activityType;
		}
		public String getLeadOwner() {
			return leadOwner;
		}
		public void setLeadOwner(String leadOwner) {
			this.leadOwner = leadOwner;
		}
		public String getCreatedTime() {
			return createdTime;
		}
		public void setCreatedTime(String createdTime) {
			this.createdTime = createdTime;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getCreatedOn() {
			return createdOn;
		}
		public void setCreatedOn(String createdOn) {
			this.createdOn = createdOn;
		}
		public String getTaskSubject() {
			return taskSubject;
		}
		public void setTaskSubject(String taskSubject) {
			this.taskSubject = taskSubject;
		}
		public String getCallScheduledWith() {
			return callScheduledWith;
		}
		public void setCallScheduledWith(String callScheduledWith) {
			this.callScheduledWith = callScheduledWith;
		}
		public String getMeetingFromDate() {
			return meetingFromDate;
		}
		public void setMeetingFromDate(String meetingFromDate) {
			this.meetingFromDate = meetingFromDate;
		}
		public String getMeetingFromTime() {
			return meetingFromTime;
		}
		public void setMeetingFromTime(String meetingFromTime) {
			this.meetingFromTime = meetingFromTime;
		}
		public String getMeetingToDate() {
			return meetingToDate;
		}
		public void setMeetingToDate(String meetingToDate) {
			this.meetingToDate = meetingToDate;
		}
		public String getMeetingToTime() {
			return meetingToTime;
		}
		public void setMeetingToTime(String meetingToTime) {
			this.meetingToTime = meetingToTime;
		}
		public String getNoteTitle() {
			return noteTitle;
		}
		public void setNoteTitle(String noteTitle) {
			this.noteTitle = noteTitle;
		}
		public String getNoteDesc() {
			return noteDesc;
		}
		public void setNoteDesc(String noteDesc) {
			this.noteDesc = noteDesc;
		}
		public String getNoteDocName() {
			return noteDocName;
		}
		public void setNoteDocName(String noteDocName) {
			this.noteDocName = noteDocName;
		}
		public String getMailSubject() {
			return mailSubject;
		}
		public void setMailSubject(String mailSubject) {
			this.mailSubject = mailSubject;
		}
		public String getMailSentTo() {
			return mailSentTo;
		}
		public void setMailSentTo(String mailSentTo) {
			this.mailSentTo = mailSentTo;
		}
		public String getParticipant() {
			return participant;
		}
		public void setParticipant(String participant) {
			this.participant = participant;
		}
		public String getCallStartDate() {
			return callStartDate;
		}
		public void setCallStartDate(String callStartDate) {
			this.callStartDate = callStartDate;
		}
		public String getCallStartTime() {
			return callStartTime;
		}
		public void setCallStartTime(String callStartTime) {
			this.callStartTime = callStartTime;
		}
	@Override
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

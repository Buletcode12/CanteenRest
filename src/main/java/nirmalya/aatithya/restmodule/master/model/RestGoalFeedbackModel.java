package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestGoalFeedbackModel {
	private String name;
	private String designation;
	private String empid;
	private String empName;
	private String empdesignation;
	private String comments;
	private String ratings;
	private String createdBy;
	private  List<RestGoalFeedbackModel> feedback;
	
	private String employeeId;
	private String firstName;
	private String gender;
	private String dob;
	private String mobileNo;
	private String personalMail;
	private String workMail;
	private String designationId;
	private String feedbackId;
	private String jobTitle;
	public RestGoalFeedbackModel() {
		super();
	}
	
	public RestGoalFeedbackModel(Object feedbackId,Object empName,Object empdesignation,Object comments,Object ratings) {
		super();
		this.feedbackId = (String) feedbackId;
		this.empName = (String) empName;
		this.empdesignation = (String) empdesignation;
		this.comments = (String) comments;
		this.ratings = (String) ratings;
	}
	public RestGoalFeedbackModel(Object employeeId,Object firstName,Object gender,Object dob,Object mobileNo,Object personalMail,Object workMail) {
		super();
		
		this.employeeId = (String) employeeId;
		this.firstName = (String) firstName;
		this.gender = (String) gender;
		this.dob = (String) dob;
		this.mobileNo = (String) mobileNo;
		this.personalMail = (String) personalMail;
		this.workMail = (String) workMail;
	}
	public RestGoalFeedbackModel(Object empid,Object name,Object designationId,Object designation,Object jobTitle,Object createdBy) {
		super();
		this.empid = (String) empid;
		this.name = (String) name;
		this.designationId = (String) designationId;
		this.designation = (String) designation;
		this.jobTitle = (String) jobTitle;
		this.createdBy = (String) createdBy;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpdesignation() {
		return empdesignation;
	}

	public void setEmpdesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<RestGoalFeedbackModel> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<RestGoalFeedbackModel> feedback) {
		this.feedback = feedback;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPersonalMail() {
		return personalMail;
	}

	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	public String getWorkMail() {
		return workMail;
	}

	public void setWorkMail(String workMail) {
		this.workMail = workMail;
	}

	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	
	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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

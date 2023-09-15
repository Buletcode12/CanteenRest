package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AddRecruitentModel {

	private String requisitionId;
	private List<String> benefits;
	private String jobTitle;
	private String jobType;
	private String jobLocation;
	private String minEducation;
	private Double minSalary;
	private Double maxSalary;
	private String department;
	private String hiringManager;
	private Integer noPosition;
	private String workHour;
	private String band;
	private String bandid;
	private String joinDate;
	private String applyStartDate;
	private String applyEndDate;
	private String positionSummary;
	private String positionResponsibility;
	private String requiredSkillExperience;
	private String approver;
	private String about;
	private String createdBy;
	private String createdOn;
	private String activityStatus;
	private String reqBenefits;
	private String applicants;
	private String shortlisted;
	private String interviewed;
	private String offered;
	private String designation;
	private String organization;
	private String orgDivision;
	private String ApproveStatus;
	private String approvedBy;
	private String rejeactedBy;
	private String comments;
	private String approvedDate;
	private String rejeactedDate;
	
	@SuppressWarnings("unchecked")
	public AddRecruitentModel(Object requisitionId, Object benefits, Object jobTitle, Object jobType,
			Object jobLocation, Object minEducation, Object minSalary, Object maxSalary,
			Object department, Object hiringManager, Object noPosition, Object workHour, 
			Object band,Object bandid, Object joinDate, Object positionSummary, 
			Object positionResponsibility,  Object requiredSkillExperience, Object approver, Object about,
			Object createdBy, Object createdOn, Object activityStatus, Object reqBenefits, 
			Object applicants,  Object shortlisted, Object interviewed,Object designation,Object ApproveStatus, 
			Object approvedBy, Object rejeactedBy,Object comments, Object applyStartDate,Object applyEndDate) {
		super();
		this.requisitionId = (String) requisitionId;
		this.benefits = (List<String>) benefits;
		this.jobTitle = (String) jobTitle;
		this.jobType = (String) jobType;
		this.jobLocation = (String) jobLocation;
		this.minEducation = (String) minEducation;
		this.minSalary = (Double) minSalary;
		this.maxSalary = (Double) maxSalary;
		this.department = (String) department;
		this.hiringManager = (String) hiringManager;
		this.noPosition = (Integer) noPosition;
		this.workHour = (String) workHour;
		this.band = (String) band;
		this.bandid = (String) bandid;
		this.joinDate = (String) joinDate;
		this.positionSummary = (String) positionSummary;
		this.positionResponsibility = (String) positionResponsibility;
		this.requiredSkillExperience = (String) requiredSkillExperience;
		this.approver = (String) approver;
		this.about = (String) about;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.activityStatus = (String) activityStatus;
		this.reqBenefits = (String) reqBenefits;
		this.applicants = (String) applicants;
		this.shortlisted =(String) shortlisted;
		this.interviewed = (String) interviewed;
		this.designation = (String) designation;
		this.ApproveStatus = (String) ApproveStatus;
		this.approvedBy =(String) approvedBy;
		this.rejeactedBy = (String) rejeactedBy;
		this.comments = (String) comments;
		this.applyStartDate = (String) applyStartDate;
		this.applyEndDate = (String) applyEndDate;
	}
	
	
	public String getApplyStartDate() {
		return applyStartDate;
	}


	public void setApplyStartDate(String applyStartDate) {
		this.applyStartDate = applyStartDate;
	}


	public String getApplyEndDate() {
		return applyEndDate;
	}


	public void setApplyEndDate(String applyEndDate) {
		this.applyEndDate = applyEndDate;
	}


	public String getApproveStatus() {
		return ApproveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		ApproveStatus = approveStatus;
	}

	public AddRecruitentModel() {
		super();
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getRejeactedBy() {
		return rejeactedBy;
	}

	public void setRejeactedBy(String rejeactedBy) {
		this.rejeactedBy = rejeactedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getRejeactedDate() {
		return rejeactedDate;
	}

	public void setRejeactedDate(String rejeactedDate) {
		this.rejeactedDate = rejeactedDate;
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

	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public List<String> getBenefits() {
		return benefits;
	}
	public void setBenefits(List<String> benefits) {
		this.benefits = benefits;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getMinEducation() {
		return minEducation;
	}
	public void setMinEducation(String minEducation) {
		this.minEducation = minEducation;
	}
	public Double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}
	public Double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}
	public Integer getNoPosition() {
		return noPosition;
	}
	public void setNoPosition(Integer noPosition) {
		this.noPosition = noPosition;
	}
	public String getWorkHour() {
		return workHour;
	}
	public void setWorkHour(String workHour) {
		this.workHour = workHour;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	
	public String getBandid() {
		return bandid;
	}
	public void setBandid(String bandid) {
		this.bandid = bandid;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getPositionSummary() {
		return positionSummary;
	}
	public void setPositionSummary(String positionSummary) {
		this.positionSummary = positionSummary;
	}
	public String getPositionResponsibility() {
		return positionResponsibility;
	}
	public void setPositionResponsibility(String positionResponsibility) {
		this.positionResponsibility = positionResponsibility;
	}
	public String getRequiredSkillExperience() {
		return requiredSkillExperience;
	}
	public void setRequiredSkillExperience(String requiredSkillExperience) {
		this.requiredSkillExperience = requiredSkillExperience;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
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
	
	public String getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	public String getReqBenefits() {
		return reqBenefits;
	}
	public void setReqBenefits(String reqBenefits) {
		this.reqBenefits = reqBenefits;
	} 
	public String getApplicants() {
		return applicants;
	}
	public void setApplicants(String applicants) {
		this.applicants = applicants;
	}
	public String getShortlisted() {
		return shortlisted;
	}
	public void setShortlisted(String shortlisted) {
		this.shortlisted = shortlisted;
	}
	public String getInterviewed() {
		return interviewed;
	}
	public void setInterviewed(String interviewed) {
		this.interviewed = interviewed;
	}
	public String getOffered() {
		return offered;
	}
	public void setOffered(String offered) {
		this.offered = offered;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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

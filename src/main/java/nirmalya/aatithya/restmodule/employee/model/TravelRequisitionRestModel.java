package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TravelRequisitionRestModel {

	private String travelingReqId;
	private String employeeId;
	private String employeeName;
	private String placeName;
	private String purpose;
	private String advanceReq;
	private Double advanceAmount;
	private String amountPaid;
	private String status;
	private String fromDate;
	private String toDate;
	private String approvedDate;
	private String approvedBy;
	private String rejectDate;
	private String rejectedBy;
	private String approveComment;
	private String organization;
	private String orgDivision;

	private String serviceId;
	private String serviceName;
	private String date;
	private String time;
	private String fromPlace;
	private String toPlace;
	private String description;
	private String createdBy;
	private String createdOn;
	private String updatedon;
	private String updatedBy;
	public TravelRequisitionRestModel(Object travelingReqId, Object employeeId, Object placeName, Object purpose,
			Object advanceReq, Object advanceAmount, Object status, Object fromDate, Object toDate,
			Object approvedBy, Object rejectedBy, Object approveComment,Object createdOn,Object employeeName) {

		super();

		this.travelingReqId = (String) travelingReqId;
		this.employeeId = (String) employeeId;
		this.placeName = (String) placeName;
		this.purpose = (String) purpose;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (Double) advanceAmount;
		this.status = (String) status;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;

		this.approvedBy = (String) approvedBy;
		this.rejectedBy = (String) rejectedBy;
		this.approveComment = (String) approveComment;
		this.createdOn = (String) createdOn;
		this.employeeName = (String) employeeName;
		
		
	}
	
	public TravelRequisitionRestModel(Object travelingReqId, Object employeeId, Object placeName, Object purpose,
			Object advanceReq, Object advanceAmount, Object status, Object fromDate, Object toDate,
			Object serviceId, Object serviceName, Object date,Object time, Object description, Object createdBy,
			Object createdOn, Object updatedon, Object updatedBy) {

		super();

		this.travelingReqId = (String) travelingReqId;
		this.employeeId = (String) employeeId;
		this.placeName = (String) placeName;
		this.purpose = (String) purpose;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (Double) advanceAmount;
		this.status = (String) status;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;

		this.serviceId = (String) serviceId;
		this.serviceName = (String) serviceName;
		this.date = (String) date;
		this.time = (String) time;
		this.description = (String) description;
		//this.toPlace = (String) toPlace;

		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.updatedon = (String) updatedon;
		this.updatedBy = (String) updatedBy;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TravelRequisitionRestModel() {
		// TODO Auto-generated constructor stub
	}

	public String getTravelingReqId() {
		return travelingReqId;
	}

	public void setTravelingReqId(String travelingReqId) {
		this.travelingReqId = travelingReqId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getAdvanceReq() {
		return advanceReq;
	}

	public void setAdvanceReq(String advanceReq) {
		this.advanceReq = advanceReq;
	}

	public Double getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(Double advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
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

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

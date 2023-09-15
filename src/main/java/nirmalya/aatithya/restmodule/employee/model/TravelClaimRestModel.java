package nirmalya.aatithya.restmodule.employee.model;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TravelClaimRestModel {
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

	private String itemId;
	private String item;
	private String destination;
	private String date;
	private String amount;
	private String bill;
	private String docName;
	private String claimStatus;
	private MultipartFile mulFile;
    private String docType;
    private String extension;
    private String userid;
    private String filetype;
	
	
	private String createdBy;
	private String createdOn;
	private String updatedon;
	private String updatedBy;
	
	public TravelClaimRestModel() {
		super();
	}
	public TravelClaimRestModel(Object travelingReqId, Object employeeId, Object placeName, Object purpose,
			Object advanceReq, Object advanceAmount, Object status, Object fromDate, Object toDate,
			Object approvedBy, Object rejectedBy, Object approveComment,Object employeeName ) {

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
		this.employeeName = (String) employeeName;
	}
	public TravelClaimRestModel(Object travelingReqId,Object placeName, Object purpose,
			Object advanceReq, Object advanceAmount, Object fromDate, Object toDate,
			Object createdBy) {

		super();

		this.travelingReqId = (String) travelingReqId;
		this.placeName = (String) placeName;
		this.purpose = (String) purpose;
		this.advanceReq = (String) advanceReq;
		this.advanceAmount = (Double) advanceAmount;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.createdBy = (String) createdBy;
	}
	public TravelClaimRestModel(Object itemId,Object item, Object destination,
			Object date, Object amount, Object bill,Object docName) {

		super();

		this.itemId = (String) itemId;
		this.item = (String) item;
		this.destination = (String) destination;
		this.date = (String) date;
		this.amount = (String) amount;
		this.bill = (String) bill;
		this.docName = (String) docName;
	}
	public String getTravelingReqId() {
		return travelingReqId;
	}
	public void setTravelingReqId(String travelingReqId) {
		this.travelingReqId = travelingReqId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBill() {
		return bill;
	}
	public void setBill(String bill) {
		this.bill = bill;
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	
	
	public MultipartFile getMulFile() {
		return mulFile;
	}
	public void setMulFile(MultipartFile mulFile) {
		this.mulFile = mulFile;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
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

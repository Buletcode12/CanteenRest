package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CrmVisitHistoryReportRestModel {
	private String planId;
	private String planType;
	private String customerId;
	private String customerName;
	private String customerAddress;
	private String dMakerId;
	private String dMakerName;
	private String dmEmail;
	private String dmPhone;
	private String planDate; 
	private String planTime;
	private String subject;
	private String desc; 
	private String status;
	private String checkDate;
	private String checkTime;
	private String ckeckAddress;
	private String checkImg;
	private String ckeckDesc;
	private String createdBy;
	private String createdByName;
	private String orgName;
	private String orgDiv;
	public CrmVisitHistoryReportRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CrmVisitHistoryReportRestModel(Object planId,Object planType ,Object customerId,
			Object customerName,Object dMakerId,
			Object dMakerName, Object planDate, Object planTime,Object subject,Object desc,Object status,
			Object checkDate,Object checkTime,
			Object ckeckAddress,Object ckeckDesc,Object createdBy,Object createdByName,Object customerAddress,Object dmEmail,Object dmPhone,Object checkImg) {
		super();
		this.planId = (String)planId;
		this.planType= (String)planType; 
		this.customerId = (String)customerId;
		this.customerName = (String)customerName;
		this.dMakerId = (String)dMakerId;
		this.dMakerName = (String)dMakerName;
		this.planDate = (String)planDate;
		this.planTime = (String)planTime;
		this.subject = (String)subject;
		this.desc = (String)desc;
		this.status = (String)status;
		this.checkDate = (String)checkDate;
		this.checkTime = (String)checkTime;
		this.ckeckAddress = (String)ckeckAddress;
		this.ckeckDesc = (String)ckeckDesc;
		this.createdBy = (String)createdBy;
		this.createdByName = (String)createdByName;
		this.customerAddress = (String)customerAddress;
		this.dmEmail = (String)dmEmail;
		this.dmPhone = (String)dmPhone;
		this.checkImg = (String)checkImg;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getdMakerId() {
		return dMakerId;
	}
	public void setdMakerId(String dMakerId) {
		this.dMakerId = dMakerId;
	}
	public String getdMakerName() {
		return dMakerName;
	}
	public void setdMakerName(String dMakerName) {
		this.dMakerName = dMakerName;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getCkeckAddress() {
		return ckeckAddress;
	}
	public void setCkeckAddress(String ckeckAddress) {
		this.ckeckAddress = ckeckAddress;
	}
	public String getCkeckDesc() {
		return ckeckDesc;
	}
	public void setCkeckDesc(String ckeckDesc) {
		this.ckeckDesc = ckeckDesc;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgDiv() {
		return orgDiv;
	}
	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
	}
	
	public String getDmEmail() {
		return dmEmail;
	}
	public void setDmEmail(String dmEmail) {
		this.dmEmail = dmEmail;
	}
	public String getDmPhone() {
		return dmPhone;
	}
	public void setDmPhone(String dmPhone) {
		this.dmPhone = dmPhone;
	}
	public String getCheckImg() {
		return checkImg;
	}
	public void setCheckImg(String checkImg) {
		this.checkImg = checkImg;
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

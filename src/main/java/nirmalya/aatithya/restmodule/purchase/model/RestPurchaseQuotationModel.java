package nirmalya.aatithya.restmodule.purchase.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.inventory.model.InventoryRfqVendorModel;



public class RestPurchaseQuotationModel {

	private String vendorId;
	private String vendorName;
	private String rfqId;
	private String desc;
	private String reqType; 
	private String reqPrior;
	private String receiveDate;
	
	
	private String itemId;
	private Integer slNo;
	private String itemName;
	private String hsnCode;
	private Double quantity;
	private Double unitPrice;
    private Double lineTotal;
	private String sku;
    private String createdBy;
	private String updatedOn;
    private String unit;
	private String unitName;
    private String organization; 
	private String orgDivision;
	private String indentId;
	private String project;
	private String projectName;
	private List<InventoryRfqVendorModel> vendorList;
	
	
	public RestPurchaseQuotationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public RestPurchaseQuotationModel(Object rfqId, Object desc, Object reqType,
			Object reqPrior, Object receiveDate, Object itemId, Object itemName,
			Object hsnCode, Object quantity, Object unitPrice, Object lineTotal, Object sku, Object createdBy,
			Object updatedOn, Object unit, Object unitName,Object vendorId,Object vendorName,Object project,Object projectName) {
		super();

		this.rfqId = (String)rfqId;
		this.desc = (String)desc;
		this.reqType = (String)reqType;
		this.reqPrior = (String)reqPrior;
		this.receiveDate = (String)receiveDate;
		
		this.itemId = (String)itemId;
		this.itemName = (String)itemName;
		this.hsnCode = (String)hsnCode;
		this.quantity = (Double)quantity;
		this.unitPrice = (Double)unitPrice;
		this.lineTotal = (Double)lineTotal;
		this.sku = (String)sku;
		this.createdBy = (String)createdBy;
		this.updatedOn = (String)updatedOn;
		this.unit = (String)unit;
		this.unitName = (String)unitName;
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.project = (String) project;
		this.projectName = (String) projectName;
	}




	public RestPurchaseQuotationModel(Object rfqId, Object desc, Object reqType, Object reqPrior, Object receiveDate,
			Object createdBy, Object updatedOn,Object project) {
		super();
		this.rfqId = (String)rfqId;
		this.desc = (String)desc;
		this.reqType = (String)reqType;
		this.reqPrior = (String)reqPrior;
		this.receiveDate = (String)receiveDate;
		this.createdBy = (String)createdBy;
		this.updatedOn = (String)updatedOn;
		this.project = (String)project;
		
	}




	public String getVendorId() {
		return vendorId;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public String getRfqId() {
		return rfqId;
	}


	public void setRfqId(String rfqId) {
		this.rfqId = rfqId;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getReqType() {
		return reqType;
	}


	public void setReqType(String reqType) {
		this.reqType = reqType;
	}


	public String getReqPrior() {
		return reqPrior;
	}


	public void setReqPrior(String reqPrior) {
		this.reqPrior = reqPrior;
	}


	public String getReceiveDate() {
		return receiveDate;
	}


	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}


	


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public Integer getSlNo() {
		return slNo;
	}


	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getHsnCode() {
		return hsnCode;
	}


	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}


	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public Double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public Double getLineTotal() {
		return lineTotal;
	}


	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getUnitName() {
		return unitName;
	}


	public void setUnitName(String unitName) {
		this.unitName = unitName;
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


	public List<InventoryRfqVendorModel> getVendorList() {
		return vendorList;
	}




	public void setVendorList(List<InventoryRfqVendorModel> vendorList) {
		this.vendorList = vendorList;
	}




	public String getIndentId() {
		return indentId;
	}




	public void setIndentId(String indentId) {
		this.indentId = indentId;
	}




	public String getProject() {
		return project;
	}




	public void setProject(String project) {
		this.project = project;
	}




	public String getProjectName() {
		return projectName;
	}




	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

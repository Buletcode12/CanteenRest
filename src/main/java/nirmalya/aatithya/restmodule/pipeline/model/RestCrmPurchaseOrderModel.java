package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmPurchaseOrderModel {
	private String poId;
	private String custGSTNo;
	private String qutValidDate; 
	private String qutDescription;
	private String qutActive; 
	private String qutCreatedBy;
	private String createdOn;
	private String qutUpdatedOn;
	private String itemId;
	private Integer slNo;
	private String itemName;
	private Double quantity;
	private Double unitPrice;
	private Double discount;
	private Double gstRate;
	private Double lineTotal;
	private Double subTotal;
	private Double qIGST;
	private Double qCGST;
	private Double qSGST;
	private Double grandTotal;
	private String active;
	private Boolean taxType;
	private String qItmCode;
	private String sku;
	private Double itemIgst;
	private Double itemCgst;
	private Double itemSgst;
	private String poNo;
	private String filePoSale;
	private String salesOrder;
	private String sOrderDate;
	
	private String purchaseOrderOwner;
	private String poNumber;
	private String poSubject;
	private String vendorId;
	private String vendorName;
	private String requisitionNo;
	private String trackingNo;
	private String contactId;
	private String contactName;
	
	private String poDate;
	private String dueDate;
	private String quoteCarrier;
	private String exciseDuty;
	private String salesCommission;
	private String purchaseOrderStatus;
	
	private String billingStreet;
	private String shippingStreet;
	private String billingCity;
	private String shippingCity;
	private String billingCode;
	
	private String shippingCode;
	private String billingState;
	private String shippingState;
	private String billingCountry;
	private String shippingCountry;
	
	private String description;
	private String termCondition;
	
public RestCrmPurchaseOrderModel(Object poId, Object purchaseOrderOwner, Object poNumber, Object poSubject,
		Object vendorId, Object vendorName, Object requisitionNo, Object trackingNo, Object contactId, Object contactName,
		Object poDate, Object dueDate,  Object quoteCarrier, Object exciseDuty,
		Object salesCommission, Object purchaseOrderStatus, Object billingStreet, Object shippingStreet,
		Object billingCity, Object shippingCity,Object billingState, Object shippingState, Object billingCode, 
		Object shippingCode, Object billingCountry, Object shippingCountry, Object termCondition, Object description,
		Object subTotal, Object qCGST, Object qSGST, Object qIGST, Object grandTotal, Object taxType,
		Object itemId, Object itemName, Object quantity, Object unitPrice,Object discount, Object gstRate,
		Object lineTotal, Object qItmCode, Object sku, Object itemIgst, Object itemCgst, Object itemSgst) {
		
	
		super();
		this.poId = (String) poId;
		this.purchaseOrderOwner = (String) purchaseOrderOwner;
		this.poNumber = (String) poNumber;
		this.poSubject = (String) poSubject;
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		
		this.requisitionNo = (String) requisitionNo;
		this.trackingNo = (String) trackingNo;
		
		this.contactId = (String) contactId;
		this.contactName = (String) contactName;
		this.poDate = (String) poDate;
		this.dueDate = (String) dueDate;
		this.quoteCarrier = (String) quoteCarrier;
		this.exciseDuty = (String) exciseDuty;
		this.salesCommission = (String) salesCommission;
		this.purchaseOrderStatus = (String) purchaseOrderStatus;
		
		this.billingStreet = (String) billingStreet;
		this.shippingStreet = (String) shippingStreet;
		this.billingCity = (String) billingCity;
		this.shippingCity = (String) shippingCity;
		this.billingState = (String) billingState;
		this.shippingState = (String) shippingState;
		this.billingCode = (String) billingCode;
		this.shippingCode = (String) shippingCode;	
		this.billingCountry = (String) billingCountry;
		this.shippingCountry = (String) shippingCountry;
		this.termCondition = (String) termCondition;
		this.description = (String) description;
			
		this.subTotal = (Double) subTotal;
		this.qCGST = (Double) qCGST;
		this.qSGST = (Double) qSGST;
		this.qIGST = (Double) qIGST;
		this.grandTotal = (Double) grandTotal;
		this.taxType = (Boolean) taxType;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.quantity = (Double) quantity;
		this.unitPrice = (Double) unitPrice;
		this.discount = (Double) discount;
		this.gstRate = (Double) gstRate;
		this.lineTotal = (Double) lineTotal;
		this.qItmCode = (String) qItmCode;
		this.sku = (String) sku;
		this.itemIgst = (Double) itemIgst;
		this.itemCgst = (Double) itemCgst;
		this.itemSgst = (Double) itemSgst;

	}
	
	
	public RestCrmPurchaseOrderModel(Object poId,  Object poSubject, Object purchaseOrderStatus, Object grandTotal,
			Object vendorName, Object contactName, Object purchaseOrderOwner,  Object createdOn) {
		
		super();
		this.poId = (String) poId;
		this.poSubject = (String) poSubject;
		this.purchaseOrderStatus = (String) purchaseOrderStatus;
		this.grandTotal = (Double) grandTotal;
		this.vendorName = (String) vendorName;
		this.contactName = (String) contactName;
		this.purchaseOrderOwner = (String) purchaseOrderOwner;
		this.createdOn = (String) createdOn;

	}
	

	/*public RestCrmSalesOrderModel(Object itemId,  Object itemName, Object gstRate, Object sku) {
		
		super();
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.gstRate = (Double) gstRate;
		this.sku = (String) sku;

	}*/

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	public String getsOrderDate() {
		return sOrderDate;
	}

	public void setsOrderDate(String sOrderDate) {
		this.sOrderDate = sOrderDate;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public String getFilePoSale() {
		return filePoSale;
	}

	public void setFilePoSale(String filePoSale) {
		this.filePoSale = filePoSale;
	}

	public Double getItemIgst() {
		return itemIgst;
	}

	public void setItemIgst(Double itemIgst) {
		this.itemIgst = itemIgst;
	}

	public Double getItemCgst() {
		return itemCgst;
	}

	public void setItemCgst(Double itemCgst) {
		this.itemCgst = itemCgst;
	}

	public Double getItemSgst() {
		return itemSgst;
	}

	public void setItemSgst(Double itemSgst) {
		this.itemSgst = itemSgst;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getqItmCode() {
		return qItmCode;
	}

	public void setqItmCode(String qItmCode) {
		this.qItmCode = qItmCode;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public String getCustGSTNo() {
		return custGSTNo;
	}

	public void setCustGSTNo(String custGSTNo) {
		this.custGSTNo = custGSTNo;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public RestCrmPurchaseOrderModel() {
		super();

	}


	public String getQutValidDate() {
		return qutValidDate;
	}

	public void setQutValidDate(String qutValidDate) {
		this.qutValidDate = qutValidDate;
	}

	
	public String getQutDescription() {
		return qutDescription;
	}

	public void setQutDescription(String qutDescription) {
		this.qutDescription = qutDescription;
	}

	public String getQutActive() {
		return qutActive;
	}

	public void setQutActive(String qutActive) {
		this.qutActive = qutActive;
	}

	public String getQutCreatedBy() {
		return qutCreatedBy;
	}

	public void setQutCreatedBy(String qutCreatedBy) {
		this.qutCreatedBy = qutCreatedBy;
	}

	public String getQutUpdatedOn() {
		return qutUpdatedOn;
	}

	public void setQutUpdatedOn(String qutUpdatedOn) {
		this.qutUpdatedOn = qutUpdatedOn;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getqIGST() {
		return qIGST;
	}

	public void setqIGST(Double qIGST) {
		this.qIGST = qIGST;
	}

	public Double getqCGST() {
		return qCGST;
	}

	public void setqCGST(Double qCGST) {
		this.qCGST = qCGST;
	}

	public Double getqSGST() {
		return qSGST;
	}

	public void setqSGST(Double qSGST) {
		this.qSGST = qSGST;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getShippingStreet() {
		return shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTermCondition() {
		return termCondition;
	}

	public void setTermCondition(String termCondition) {
		this.termCondition = termCondition;
	}
	

	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	
	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	
	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getExciseDuty() {
		return exciseDuty;
	}

	public void setExciseDuty(String exciseDuty) {
		this.exciseDuty = exciseDuty;
	}

	public String getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(String salesCommission) {
		this.salesCommission = salesCommission;
	}
	
	

	

	public String getPoId() {
		return poId;
	}


	public void setPoId(String poId) {
		this.poId = poId;
	}


	public String getPurchaseOrderOwner() {
		return purchaseOrderOwner;
	}

	public void setPurchaseOrderOwner(String purchaseOrderOwner) {
		this.purchaseOrderOwner = purchaseOrderOwner;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getPoSubject() {
		return poSubject;
	}

	public void setPoSubject(String poSubject) {
		this.poSubject = poSubject;
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

	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public String getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}

	public String getQuoteCarrier() {
		return quoteCarrier;
	}

	public void setQuoteCarrier(String quoteCarrier) {
		this.quoteCarrier = quoteCarrier;
	}

	public String getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}

	public void setPurchaseOrderStatus(String purchaseOrderStatus) {
		this.purchaseOrderStatus = purchaseOrderStatus;
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

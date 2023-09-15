package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class RestPoOrWoModel {
	private String referenceId; 
	private String quotationId;
	private String poNo; 
	private String poDate;
	
	private String custId;
	private String custName;
	private String custGSTNo;
	private String qutDescription;
    private String qutCreatedBy;
	private String qutUpdatedOn;
	private String itemId;
	private Integer slNo;
	private String itemName;
	private String hsnCode;
	private Double quantity;
	private String unit;
	private String unitName;
	private Double taxableAmt;
	private Double unitPrice;
	private Double discount;
	private Double gstRate;
	private Double lineTotal;
	private Double subTotal;
	private Double qIGST;
	private Double qCGST;
	private Double qSGST;
	private Double grandTotal;
	private Boolean taxType;
	private String qItmCode;
	private String sku;
	private String salesOrder;
	private Double itemIgst;
	private Double itemCgst;
	private Double itemSgst;
	private String organization;
	private String orgDivision;
	private String expectedShipmentDate;
	private String paymentTermId;
	private String deliveryMethodId;
	private String salesPersonId;
	private String salesPerson;
	private String spName;
	private String reference;
	private Double tcsAmount;
	private String tcs;
    private String terms;
	private String tcsId;
	private String tcsRate;
     private String sizeInMM;
    private String thicknessInMM;
	private String itemDesc;
	private String orderType;
	private String desc;
	private String salesOrderId;
	private String salesOrderStatus;
	private String salesOrderDate;
	private String blockeOrder;
	private String version;
	private String lastVersion;
	private String shippingHiddenId;
	private String advance;
	List<InventoryVendorDocumentModel> documentList;

	public RestPoOrWoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestPoOrWoModel(Object referenceId, Object quotationId, Object poNo, Object poDate, Object custId,
			Object custName, Object custGSTNo, Object qutDescription, Object qutCreatedBy, Object qutUpdatedOn,
			Object itemId, Object slNo, Object itemName, Object hsnCode, Object quantity, Object unit, Object unitName,
			Object taxableAmt, Object unitPrice, Object discount, Object gstRate, Object lineTotal, Object subTotal,
			Object qIGST, Object qCGST, Object qSGST, Object grandTotal, Object taxType, Object qItmCode, Object sku,
			Object salesOrder, Object itemIgst, Object itemCgst, Object itemSgst, Object organization,
			Object orgDivision, Object expectedShipmentDate, Object paymentTermId, Object deliveryMethodId,
			Object salesPersonId, Object salesPerson, Object spName, Object reference, Object tcsAmount, Object tcs,
			Object terms, Object tcsId, Object tcsRate, Object sizeInMM, Object thicknessInMM, Object itemDesc,
			Object orderType, Object desc,Object salesOrderStatus,Object salesOrderId,Object salesOrderDate,Object blockeOrder,Object version,
			Object lastVersion,Object shippingHiddenId,Object advance) {
		super();
		this.referenceId = (String)referenceId;
		this.quotationId = (String)quotationId;
		this.poNo = (String)poNo;
		this.poDate = (String)poDate;
		this.custId = (String)custId;
		this.custName = (String)custName;
		this.custGSTNo = (String)custGSTNo;
		this.qutDescription = (String)qutDescription;
		this.qutCreatedBy = (String)qutCreatedBy;
		this.qutUpdatedOn =(String)qutUpdatedOn;
		this.itemId = (String)itemId;
		this.slNo = (Integer)slNo;
		this.itemName = (String)itemName;
		this.hsnCode = (String)hsnCode;
		this.quantity = (Double)quantity;
		this.unit = (String)unit;
		this.unitName = (String)unitName;
		this.taxableAmt = (Double)taxableAmt;
		this.unitPrice = (Double)unitPrice;
		this.discount = (Double)discount;
		this.gstRate = (Double)gstRate;
		this.lineTotal = (Double)lineTotal;
		this.subTotal = (Double)subTotal;
		this.qIGST = (Double)qIGST;
		this.qCGST = (Double)qCGST;
		this.qSGST = (Double)qSGST;
		this.grandTotal = (Double)grandTotal;
		this.taxType = (Boolean)taxType;
		this.qItmCode = (String)qItmCode;
		this.sku = (String)sku;
		this.salesOrder = (String)salesOrder;
		this.itemIgst = (Double)itemIgst;
		this.itemCgst = (Double)itemCgst;
		this.itemSgst = (Double)itemSgst;
		this.organization = (String)organization;
		this.orgDivision = (String)orgDivision;
		this.expectedShipmentDate = (String)expectedShipmentDate;
		this.paymentTermId = (String)paymentTermId;
		this.deliveryMethodId = (String)deliveryMethodId;
		this.salesPersonId = (String)salesPersonId;
		this.salesPerson = (String)salesPerson;
		this.spName = (String)spName;
		this.reference = (String)reference;
		this.tcsAmount = (Double)tcsAmount;
		this.tcs = (String)tcs;
		this.terms = (String)terms;
		this.tcsId = (String)tcsId;
		this.tcsRate = (String)tcsRate;
		this.sizeInMM = (String)sizeInMM;
		this.thicknessInMM = (String)thicknessInMM;
		this.itemDesc = (String)itemDesc;
		this.orderType = (String)orderType;
		this.desc = (String)desc;
		this.salesOrderStatus = (String)salesOrderStatus;
		this.salesOrderId = (String)salesOrderId;
		this.salesOrderDate = (String)salesOrderDate;
		this.blockeOrder = (String)blockeOrder;
		this.version = (String)version;
		this.lastVersion = (String)lastVersion;
		this.shippingHiddenId = (String)shippingHiddenId;
		this.advance = (String)advance;
	}





	public RestPoOrWoModel(Object referenceId, Object quotationId, Object poNo, Object poDate, Object custId,
			Object custName, Object qutCreatedBy, Object grandTotal, Object expectedShipmentDate, Object reference,
			Object salesOrderId,Object salesOrderStatus,Object salesOrderDate) {
		super();
		this.referenceId = (String)referenceId;
		this.quotationId = (String)quotationId;
		this.poNo = (String)poNo;
		this.poDate = (String)poDate;
		this.custId = (String)custId;
		this.custName = (String)custName;
		this.qutCreatedBy = (String)qutCreatedBy;
		this.grandTotal =(Double)grandTotal;
		this.expectedShipmentDate = (String)expectedShipmentDate;
		this.reference = (String)reference;
		this.salesOrderId = (String)salesOrderId;
		this.salesOrderStatus = (String)salesOrderStatus;
		this.salesOrderDate = (String)salesOrderDate;
	}





	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustGSTNo() {
		return custGSTNo;
	}

	public void setCustGSTNo(String custGSTNo) {
		this.custGSTNo = custGSTNo;
	}

	public String getQutDescription() {
		return qutDescription;
	}

	public void setQutDescription(String qutDescription) {
		this.qutDescription = qutDescription;
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

	public Double getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(Double taxableAmt) {
		this.taxableAmt = taxableAmt;
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

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public String getqItmCode() {
		return qItmCode;
	}

	public void setqItmCode(String qItmCode) {
		this.qItmCode = qItmCode;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
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

	public String getExpectedShipmentDate() {
		return expectedShipmentDate;
	}

	public void setExpectedShipmentDate(String expectedShipmentDate) {
		this.expectedShipmentDate = expectedShipmentDate;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getDeliveryMethodId() {
		return deliveryMethodId;
	}

	public void setDeliveryMethodId(String deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}

	public String getSalesPersonId() {
		return salesPersonId;
	}

	public void setSalesPersonId(String salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getTcsAmount() {
		return tcsAmount;
	}

	public void setTcsAmount(Double tcsAmount) {
		this.tcsAmount = tcsAmount;
	}

	public String getTcs() {
		return tcs;
	}

	public void setTcs(String tcs) {
		this.tcs = tcs;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getTcsId() {
		return tcsId;
	}

	public void setTcsId(String tcsId) {
		this.tcsId = tcsId;
	}

	public String getTcsRate() {
		return tcsRate;
	}

	public void setTcsRate(String tcsRate) {
		this.tcsRate = tcsRate;
	}

	public String getSizeInMM() {
		return sizeInMM;
	}

	public void setSizeInMM(String sizeInMM) {
		this.sizeInMM = sizeInMM;
	}

	public String getThicknessInMM() {
		return thicknessInMM;
	}

	public void setThicknessInMM(String thicknessInMM) {
		this.thicknessInMM = thicknessInMM;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}
	

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}
	

	public String getSalesOrderId() {
		return salesOrderId;
	}





	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}





	public String getSalesOrderStatus() {
		return salesOrderStatus;
	}





	public void setSalesOrderStatus(String salesOrderStatus) {
		this.salesOrderStatus = salesOrderStatus;
	}





	public String getSalesOrderDate() {
		return salesOrderDate;
	}





	public void setSalesOrderDate(String salesOrderDate) {
		this.salesOrderDate = salesOrderDate;
	}





	public String getBlockeOrder() {
		return blockeOrder;
	}
	public void setBlockeOrder(String blockeOrder) {
		this.blockeOrder = blockeOrder;
	}
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	public String getLastVersion() {
		return lastVersion;
	}
	public void setLastVersion(String lastVersion) {
		this.lastVersion = lastVersion;
	}
	
	
	public String getShippingHiddenId() {
		return shippingHiddenId;
	}
	public void setShippingHiddenId(String shippingHiddenId) {
		this.shippingHiddenId = shippingHiddenId;
	}
	
	
	public String getAdvance() {
		return advance;
	}
	public void setAdvance(String advance) {
		this.advance = advance;
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

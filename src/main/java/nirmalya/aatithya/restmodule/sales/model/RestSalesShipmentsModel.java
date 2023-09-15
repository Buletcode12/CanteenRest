package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestSalesShipmentsModel {

	private String salesShipmentId;
	private String saleDeliveryChallan;
	private String custId;
	private String custName;
	private String poId;
	private String salesOrder;
	private String salesOrderId;
	private String salePackageId;
	private String shipmentOrder;
	private String carrierId;
	private String shipmentDate;
	private String trackingId;
	private String trackingUrlId;
	private String contactNo;
	private Double shippingCharge;
	private String internalNotes;
	private String shipmentDeliverdId;
	private String sendStatusNotification;
	private String qutCreatedBy;
	private String qutUpdatedOn;
	private String ShipmentStatus;
	private String orgName;
	private String orgDiv;
	private String shippingHiddenId;


	public RestSalesShipmentsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestSalesShipmentsModel(Object salesShipmentId, Object custId, Object custName, Object salesOrder,
			Object poId, Object saleDeliveryChallan, Object shipmentOrder, Object carrierId, Object shipmentDate,
			Object trackingId, Object trackingUrlId, Object shippingCharge, Object internalNotes,
			Object shipmentDeliverdId, Object sendStatusNotification, Object qutCreatedBy, Object qutUpdatedOn,
			Object shipmentStatus, Object orgName, Object orgDiv,Object contactNo,Object shippingHiddenId) {
		super();
		this.salesShipmentId = (String) salesShipmentId;
		this.custId = (String) custId;
		this.custName = (String) custName;
		this.salesOrder = (String) salesOrder;
		this.poId = (String) poId;
		this.saleDeliveryChallan = (String) saleDeliveryChallan;
		this.shipmentOrder = (String) shipmentOrder;
		this.carrierId = (String) carrierId;
		this.shipmentDate = (String) shipmentDate;
		this.trackingId = (String) trackingId;
		this.trackingUrlId = (String) trackingUrlId;
		this.shippingCharge = (Double) shippingCharge;
		this.internalNotes = (String) internalNotes;
		this.shipmentDeliverdId = (String) shipmentDeliverdId;
		this.sendStatusNotification = (String) sendStatusNotification;
		this.qutCreatedBy = (String) qutCreatedBy;
		this.qutUpdatedOn = (String) qutUpdatedOn;
		this.ShipmentStatus = (String) shipmentStatus;
		this.orgName = (String) orgName;
		this.orgDiv = (String) orgDiv;
		this.contactNo = (String) contactNo;
		this.shippingHiddenId = (String) shippingHiddenId;
	}

	public String getSalesShipmentId() {
		return salesShipmentId;
	}

	public void setSalesShipmentId(String salesShipmentId) {
		this.salesShipmentId = salesShipmentId;
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

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getSalePackageId() {
		return salePackageId;
	}

	public void setSalePackageId(String salePackageId) {
		this.salePackageId = salePackageId;
	}

	public String getShipmentOrder() {
		return shipmentOrder;
	}

	public void setShipmentOrder(String shipmentOrder) {
		this.shipmentOrder = shipmentOrder;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getTrackingUrlId() {
		return trackingUrlId;
	}

	public void setTrackingUrlId(String trackingUrlId) {
		this.trackingUrlId = trackingUrlId;
	}

	public Double getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(Double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public String getInternalNotes() {
		return internalNotes;
	}

	public void setInternalNotes(String internalNotes) {
		this.internalNotes = internalNotes;
	}

	public String getShipmentDeliverdId() {
		return shipmentDeliverdId;
	}

	public void setShipmentDeliverdId(String shipmentDeliverdId) {
		this.shipmentDeliverdId = shipmentDeliverdId;
	}

	public String getSendStatusNotification() {
		return sendStatusNotification;
	}

	public void setSendStatusNotification(String sendStatusNotification) {
		this.sendStatusNotification = sendStatusNotification;
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

	public String getShipmentStatus() {
		return ShipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		ShipmentStatus = shipmentStatus;
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

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	

	public String getSaleDeliveryChallan() {
		return saleDeliveryChallan;
	}

	public void setSaleDeliveryChallan(String saleDeliveryChallan) {
		this.saleDeliveryChallan = saleDeliveryChallan;
	}
	

	public String getShippingHiddenId() {
		return shippingHiddenId;
	}

	public void setShippingHiddenId(String shippingHiddenId) {
		this.shippingHiddenId = shippingHiddenId;
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

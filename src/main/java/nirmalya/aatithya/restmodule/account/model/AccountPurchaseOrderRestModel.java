package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountPurchaseOrderRestModel {
	private String purchaseId;
	private String totalAmount;
	private String purchaseDate;
	private String buyerName;
	private String buyerNameId;
	private String sellerName;
	private String sellerNameId;
	private String customerType;
	
	private String subTotal;
	private String sgst;
	private String cgst;
	private String igst;
	private String grandTotal;
	
	
	List<AccountPurchaseProductRestModel> productList;
	
	public AccountPurchaseOrderRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountPurchaseOrderRestModel(Object purchaseId, Object totalAmount, Object purchaseDate, Object buyerName,
			Object buyerNameId, Object sellerName, Object sellerNameId, Object customerType) {
		super();
		this.purchaseId = (String) purchaseId;
		this.totalAmount = (String) totalAmount;
		this.purchaseDate = (String) purchaseDate;
		this.buyerName = (String) buyerName;
		this.buyerNameId = (String) buyerNameId;
		this.sellerName = (String) sellerName;
		this.sellerNameId = (String) sellerNameId;
		this.customerType = (String) customerType;
	}
	
	
	
	
	
	public AccountPurchaseOrderRestModel(Object purchaseId, Object totalAmount, Object purchaseDate, Object buyerName,
			Object buyerNameId, Object sellerName, Object sellerNameId, Object subTotal,
			Object sgst, Object cgst, Object igst, Object grandTotal, Object customerType
			) {
		super();
		this.purchaseId = (String) purchaseId;
		this.totalAmount = (String) totalAmount;
		this.purchaseDate = (String) purchaseDate;
		this.buyerName = (String) buyerName;
		this.buyerNameId = (String) buyerNameId;
		this.sellerName = (String) sellerName;
		this.sellerNameId = (String) sellerNameId;
		this.subTotal = (String) subTotal;
		this.sgst = (String) sgst;
		this.cgst = (String) cgst;
		this.igst = (String) igst;
		this.grandTotal = (String) grandTotal;
		this.customerType = (String) customerType;
		
	}
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	
	
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerNameId() {
		return buyerNameId;
	}
	public void setBuyerNameId(String buyerNameId) {
		this.buyerNameId = buyerNameId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerNameId() {
		return sellerNameId;
	}
	public void setSellerNameId(String sellerNameId) {
		this.sellerNameId = sellerNameId;
	}
	
	public List<AccountPurchaseProductRestModel> getProductList() {
		return productList;
	}
	public void setProductList(List<AccountPurchaseProductRestModel> productList) {
		this.productList = productList;
	}
	
	public String getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	public String getSgst() {
		return sgst;
	}
	public void setSgst(String sgst) {
		this.sgst = sgst;
	}
	public String getCgst() {
		return cgst;
	}
	public void setCgst(String cgst) {
		this.cgst = cgst;
	}
	public String getIgst() {
		return igst;
	}
	public void setIgst(String igst) {
		this.igst = igst;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
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

package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountCreditNoteRestModel {
	private String creditNoteId;
	private String partyLedgerId;
	private String partyLedger;
	private String salesLedgerId;
	private String salesLedger;
	private String prtyLedgerCurBal;
	private String salesLedgerCurBal;
	private String creditNoteDate;
	private String orderNumber;
	private String qSGST;
	private String qCGST;
	private String qIGST;
	private String grandTotal;
	private String subTotal;
	private String totalItem;
	private String createdBy;
	private String createdOn;
	private String costCenter;
	private String description;
	private String currentBalance;
	
	
	List<ItemShoukeenModel> itemattribute;
	List<RestPurchaseItemModel> debitItemAttribute;

	public AccountCreditNoteRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountCreditNoteRestModel(Object creditNoteId, Object partyLedgerId, Object partyLedger,
			Object salesLedgerId, Object salesLedger,
			Object creditNoteDate, Object orderNumber, Object qSGST, Object qCGST, Object qIGST, Object grandTotal,
			Object subTotal, Object totalItem, Object createdBy, Object createdOn,Object costCenter,Object description,Object currentBalance) {
		super();
		this.creditNoteId = (String) creditNoteId;
		this.partyLedgerId = (String) partyLedgerId;
		this.partyLedger = (String) partyLedger;
		this.salesLedgerId = (String) salesLedgerId;
		this.salesLedger = (String) salesLedger;
		this.creditNoteDate = (String) creditNoteDate;
		this.orderNumber = (String) orderNumber;
		this.qSGST = (String) qSGST;
		this.qCGST = (String) qCGST;
		this.qIGST = (String) qIGST;
		this.grandTotal = (String) grandTotal;
		this.subTotal = (String) subTotal;
		this.totalItem = (String) totalItem;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.costCenter = (String) costCenter;
		this.description = (String) description;
		this.currentBalance = (String) currentBalance;
	}

	public String getCreditNoteId() {
		return creditNoteId;
	}

	public void setCreditNoteId(String creditNoteId) {
		this.creditNoteId = creditNoteId;
	}

	public String getPartyLedgerId() {
		return partyLedgerId;
	}

	public void setPartyLedgerId(String partyLedgerId) {
		this.partyLedgerId = partyLedgerId;
	}

	public String getPartyLedger() {
		return partyLedger;
	}

	public void setPartyLedger(String partyLedger) {
		this.partyLedger = partyLedger;
	}

	public String getSalesLedgerId() {
		return salesLedgerId;
	}

	public void setSalesLedgerId(String salesLedgerId) {
		this.salesLedgerId = salesLedgerId;
	}

	public String getSalesLedger() {
		return salesLedger;
	}

	public void setSalesLedger(String salesLedger) {
		this.salesLedger = salesLedger;
	}

	public String getPrtyLedgerCurBal() {
		return prtyLedgerCurBal;
	}

	public void setPrtyLedgerCurBal(String prtyLedgerCurBal) {
		this.prtyLedgerCurBal = prtyLedgerCurBal;
	}

	public String getSalesLedgerCurBal() {
		return salesLedgerCurBal;
	}

	public void setSalesLedgerCurBal(String salesLedgerCurBal) {
		this.salesLedgerCurBal = salesLedgerCurBal;
	}

	public String getCreditNoteDate() {
		return creditNoteDate;
	}

	public void setCreditNoteDate(String creditNoteDate) {
		this.creditNoteDate = creditNoteDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getqSGST() {
		return qSGST;
	}

	public void setqSGST(String qSGST) {
		this.qSGST = qSGST;
	}

	public String getqCGST() {
		return qCGST;
	}

	public void setqCGST(String qCGST) {
		this.qCGST = qCGST;
	}

	public String getqIGST() {
		return qIGST;
	}

	public void setqIGST(String qIGST) {
		this.qIGST = qIGST;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public String getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(String totalItem) {
		this.totalItem = totalItem;
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

	public List<ItemShoukeenModel> getItemattribute() {
		return itemattribute;
	}

	public void setItemattribute(List<ItemShoukeenModel> itemattribute) {
		this.itemattribute = itemattribute;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	
	public List<RestPurchaseItemModel> getDebitItemAttribute() {
		return debitItemAttribute;
	}

	public void setDebitItemAttribute(List<RestPurchaseItemModel> debitItemAttribute) {
		this.debitItemAttribute = debitItemAttribute;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
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

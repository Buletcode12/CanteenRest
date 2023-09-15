package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.account.model.AccountCreditNoteRestModel;
import nirmalya.aatithya.restmodule.account.model.ItemShoukeenModel;
import nirmalya.aatithya.restmodule.account.model.RestPurchaseItemModel;

public class CreditNoteGenerateParameter {

	public static String addCreditNote(List<AccountCreditNoteRestModel> creditNote) {

		String s = "";
		String listdata = "";
		if (creditNote.get(0).getCreditNoteId() != null && creditNote.get(0).getCreditNoteId() != "") {
			s = s + "@p_creditNoteId='" + creditNote.get(0).getCreditNoteId() + "',";
		}
		if (creditNote.get(0).getSalesLedgerId() != null && creditNote.get(0).getSalesLedgerId() != "") {
			s = s + "@p_salesLedgerId='" + creditNote.get(0).getSalesLedgerId() + "',";
		}
		if (creditNote.get(0).getPartyLedgerId() != null && creditNote.get(0).getPartyLedgerId() != "") {
			s = s + "@p_partyLedgerId='" + creditNote.get(0).getPartyLedgerId() + "',";
		}
		if (creditNote.get(0).getPrtyLedgerCurBal() != null && creditNote.get(0).getPrtyLedgerCurBal() != "") {
			s = s + "@p_partyCurrBal='" + creditNote.get(0).getPrtyLedgerCurBal() + "',";
		}
		if (creditNote.get(0).getSalesLedgerCurBal() != null && creditNote.get(0).getSalesLedgerCurBal() != "") {
			s = s + "@p_salesCurrBal='" + creditNote.get(0).getSalesLedgerCurBal() + "',";
		}
		if (creditNote.get(0).getCreditNoteDate() != null && creditNote.get(0).getCreditNoteDate() != "") {
			s = s + "@p_salesCreditDate='" + creditNote.get(0).getCreditNoteDate() + "',";
		}
		if (creditNote.get(0).getOrderNumber() != null && creditNote.get(0).getOrderNumber() != "") {
			s = s + "@p_orderNumber='" + creditNote.get(0).getOrderNumber() + "',";
		}
		if (creditNote.get(0).getSubTotal() != null) {
			s = s + "@p_subTotal=" + creditNote.get(0).getSubTotal() + ",";
		}
		if (creditNote.get(0).getqSGST() != null) {
			s = s + "@p_qSGST=" + creditNote.get(0).getqSGST() + ",";
		}
		if (creditNote.get(0).getqCGST() != null) {
			s = s + "@p_qCGST=" + creditNote.get(0).getqCGST() + ",";
		}
		if (creditNote.get(0).getqIGST() != null) {
			s = s + "@p_qIGST=" + creditNote.get(0).getqIGST() + ",";
		}
		if (creditNote.get(0).getGrandTotal() != null) {
			s = s + "@p_grandTotal=" + creditNote.get(0).getGrandTotal() + ",";
		}
		if (creditNote.get(0).getTotalItem() != null && creditNote.get(0).getTotalItem() != "") {
			s = s + "@p_totalItem='" + creditNote.get(0).getTotalItem() + "',";
		}
		if (creditNote.get(0).getCreatedBy() != null && creditNote.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + creditNote.get(0).getCreatedBy() + "',";
		}
		if (creditNote.get(0).getCostCenter() != null && creditNote.get(0).getCostCenter() != "") {
			s = s + "@p_costCenter='" + creditNote.get(0).getCostCenter() + "',";
		}
		if (creditNote.get(0).getDescription() != null && creditNote.get(0).getDescription() != "") {
			s = s + "@p_description='" + creditNote.get(0).getDescription() + "',";
		}
		
		for (ItemShoukeenModel m : creditNote.get(0).getItemattribute()) {
			listdata = listdata + "(@p_creditNoteId,@p_orderNumber,\"" + m.getCategoryId() + "\",\"" + m.getQuantity() + "\",\"" + m.getProductDimension() + "\"," + "\""
					+ m.getItemUnitPrice() + "\",\"" + m.getDiscount() + "\",\"" + m.getGstRate() + "\",\""
					+ m.getItemCgst() + "\",\"" + m.getItemSgst() + "\",\"" + m.getToggleRegularCustom() + "\",\""
					+ m.getLineTotal() + "\"," + "\"" + m.getDealerCode() + "\","+"\"" + m.getExtraDiscount() +"\"),";

		}
		listdata = listdata.substring(0, listdata.length() - 1);
		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		System.out.println("Item Details" + s);
		return s;
	}
	
	
	
	public static String addDebitNote(List<AccountCreditNoteRestModel> debitNote) {

		String s = "";
		String listdata = "";
		if (debitNote.get(0).getCreditNoteId() != null && debitNote.get(0).getCreditNoteId() != "") {
			s = s + "@p_debitNoteId='" + debitNote.get(0).getCreditNoteId() + "',";
		}
		if (debitNote.get(0).getSalesLedgerId() != null && debitNote.get(0).getSalesLedgerId() != "") {
			s = s + "@p_salesLedgerId='" + debitNote.get(0).getSalesLedgerId() + "',";
		}
		if (debitNote.get(0).getPartyLedgerId() != null && debitNote.get(0).getPartyLedgerId() != "") {
			s = s + "@p_partyLedgerId='" + debitNote.get(0).getPartyLedgerId() + "',";
		}
		if (debitNote.get(0).getPrtyLedgerCurBal() != null && debitNote.get(0).getPrtyLedgerCurBal() != "") {
			s = s + "@p_partyCurrBal='" + debitNote.get(0).getPrtyLedgerCurBal() + "',";
		}
		if (debitNote.get(0).getSalesLedgerCurBal() != null && debitNote.get(0).getSalesLedgerCurBal() != "") {
			s = s + "@p_salesCurrBal='" + debitNote.get(0).getSalesLedgerCurBal() + "',";
		}
		if (debitNote.get(0).getCreditNoteDate() != null && debitNote.get(0).getCreditNoteDate() != "") {
			s = s + "@p_salesCreditDate='" + debitNote.get(0).getCreditNoteDate() + "',";
		}
		if (debitNote.get(0).getOrderNumber() != null && debitNote.get(0).getOrderNumber() != "") {
			s = s + "@p_orderNumber='" + debitNote.get(0).getOrderNumber() + "',";
		}
		if (debitNote.get(0).getSubTotal() != null) {
			s = s + "@p_subTotal=" + debitNote.get(0).getSubTotal() + ",";
		}
		if (debitNote.get(0).getqSGST() != null) {
			s = s + "@p_qSGST=" + debitNote.get(0).getqSGST() + ",";
		}
		if (debitNote.get(0).getqCGST() != null) {
			s = s + "@p_qCGST=" + debitNote.get(0).getqCGST() + ",";
		}
		if (debitNote.get(0).getqIGST() != null) {
			s = s + "@p_qIGST=" + debitNote.get(0).getqIGST() + ",";
		}
		if (debitNote.get(0).getGrandTotal() != null) {
			s = s + "@p_grandTotal=" + debitNote.get(0).getGrandTotal() + ",";
		}
		if (debitNote.get(0).getTotalItem() != null && debitNote.get(0).getTotalItem() != "") {
			s = s + "@p_totalItem='" + debitNote.get(0).getTotalItem() + "',";
		}
		if (debitNote.get(0).getCreatedBy() != null && debitNote.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + debitNote.get(0).getCreatedBy() + "',";
		}
		if (debitNote.get(0).getCostCenter() != null && debitNote.get(0).getCostCenter() != "") {
			s = s + "@p_costCenter='" + debitNote.get(0).getCostCenter() + "',";
		}
		if (debitNote.get(0).getDescription() != null && debitNote.get(0).getDescription() != "") {
			s = s + "@p_description='" + debitNote.get(0).getDescription() + "',";
		}
		
		for (RestPurchaseItemModel m : debitNote.get(0).getDebitItemAttribute()) {
			listdata = listdata + "(@p_debitNoteId,@p_orderNumber,\"" + m.getProductId() + "\",\"" + m.getQuantity() + "\",\"" + m.getHsnCode() + "\"," + "\""
					+ m.getUnitPrice() + "\",\"" + m.getDiscount() + "\",\"" + m.getGstRate() + "\",\""
					+ m.getCgst() + "\",\"" + m.getSgst() + "\",\""
					+ m.getLineTotal() + "\"),";

		}
		listdata = listdata.substring(0, listdata.length() - 1);
		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		System.out.println("Item Details" + s);
		return s;
	}

}

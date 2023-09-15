package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountLedgerReportRestModel {
	private String ledgerId;
	private String ledgerName;
	private String voucherType;
	private String voucherId;
	private String debitAmount;
	private String creditAmount;
	private String voucherDate;
	private String monthName;
	private String grandDebitAmnt;
	private String grandCreditAmnt;
	
	private String receiptAmnt;
	private String paymentAmount;
	private String contraJournalAmount;
	private String saleReturnAmount;
	private String purchaseReturnAmount;
	private String totalEarningAmonut; 
	private String totalExpenditure;
	private String profitLossAmnt;
	
	
	
	
	
	public AccountLedgerReportRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountLedgerReportRestModel(Object ledgerId, Object ledgerName, Object voucherType, Object voucherId,
			Object debitAmount, Object creditAmount, Object voucherDate) {
		super();
		this.ledgerId = (String) ledgerId;
		this.ledgerName = (String) ledgerName;
		this.voucherType = (String) voucherType;
		this.voucherId = (String) voucherId;
		this.debitAmount = (String) debitAmount;
		this.creditAmount = (String) creditAmount;
		this.voucherDate = (String) voucherDate;
	}
	
	//  ReceiptAmnt, PaymentAmount, ContraJournalAmount, saleReturnAmount, 
    // purchaseReturnAmount, totalEarningAmonut, totalExpenditure, profitLossAmnt
	
	public AccountLedgerReportRestModel(Object receiptAmnt, Object paymentAmount, Object contraJournalAmount,
			Object saleReturnAmount, Object purchaseReturnAmount, Object totalEarningAmonut, 
			Object totalExpenditure, Object profitLossAmnt) {
		super();
		this.receiptAmnt = (String) receiptAmnt;
		this.paymentAmount = (String) paymentAmount;
		this.contraJournalAmount = (String) contraJournalAmount;
		this.saleReturnAmount = (String) saleReturnAmount;
		this.purchaseReturnAmount = (String) purchaseReturnAmount;
		this.totalEarningAmonut = (String) totalEarningAmonut;
		this.totalExpenditure = (String) totalExpenditure;
		this.profitLossAmnt = (String) profitLossAmnt;
	}
	
	
	public AccountLedgerReportRestModel(Object monthName, Object debitAmount, Object creditAmount,
Object grandDebitAmnt, Object grandCreditAmnt) {
		super();
		this.monthName = (String) monthName;
		this.debitAmount = (String) debitAmount;
		this.creditAmount = (String) creditAmount;
		this.grandDebitAmnt = (String) grandDebitAmnt;
		this.grandCreditAmnt = (String) grandCreditAmnt;
		this.creditAmount = (String) creditAmount;
		this.voucherDate = (String) voucherDate;
	}
	
	public AccountLedgerReportRestModel(
			Object debitAmount, Object creditAmount, Object voucherDate) {
		super();
		this.debitAmount = (String) debitAmount;
		this.creditAmount = (String) creditAmount;
		this.voucherDate = (String) voucherDate;
	}
	
	
	
	
	public String getReceiptAmnt() {
		return receiptAmnt;
	}
	public void setReceiptAmnt(String receiptAmnt) {
		this.receiptAmnt = receiptAmnt;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getContraJournalAmount() {
		return contraJournalAmount;
	}
	public void setContraJournalAmount(String contraJournalAmount) {
		this.contraJournalAmount = contraJournalAmount;
	}
	public String getSaleReturnAmount() {
		return saleReturnAmount;
	}
	public void setSaleReturnAmount(String saleReturnAmount) {
		this.saleReturnAmount = saleReturnAmount;
	}
	public String getPurchaseReturnAmount() {
		return purchaseReturnAmount;
	}
	public void setPurchaseReturnAmount(String purchaseReturnAmount) {
		this.purchaseReturnAmount = purchaseReturnAmount;
	}
	public String getTotalEarningAmonut() {
		return totalEarningAmonut;
	}
	public void setTotalEarningAmonut(String totalEarningAmonut) {
		this.totalEarningAmonut = totalEarningAmonut;
	}
	public String getTotalExpenditure() {
		return totalExpenditure;
	}
	public void setTotalExpenditure(String totalExpenditure) {
		this.totalExpenditure = totalExpenditure;
	}
	public String getProfitLossAmnt() {
		return profitLossAmnt;
	}
	public void setProfitLossAmnt(String profitLossAmnt) {
		this.profitLossAmnt = profitLossAmnt;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public String getGrandDebitAmnt() {
		return grandDebitAmnt;
	}
	public void setGrandDebitAmnt(String grandDebitAmnt) {
		this.grandDebitAmnt = grandDebitAmnt;
	}
	public String getGrandCreditAmnt() {
		return grandCreditAmnt;
	}
	public void setGrandCreditAmnt(String grandCreditAmnt) {
		this.grandCreditAmnt = grandCreditAmnt;
	}
	
	public String getLedgerId() {
		return ledgerId;
	}
	public void setLedgerId(String ledgerId) {
		this.ledgerId = ledgerId;
	}
	public String getLedgerName() {
		return ledgerName;
	}
	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}
	public String getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}
	public String getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}
	public String getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(String debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	public String getVoucherDate() {
		return voucherDate;
	}
	public void setVoucherDate(String voucherDate) {
		this.voucherDate = voucherDate;
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

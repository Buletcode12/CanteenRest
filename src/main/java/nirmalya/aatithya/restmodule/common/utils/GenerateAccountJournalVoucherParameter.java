package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;

public class GenerateAccountJournalVoucherParameter {

	public static String saveJournalVoucherParam(List<AccountJournalVoucherModel> journalVoucherModel) {
		String s = "";
		String litem = "";
		String journalVoucher = "";
		String costCenter = "";
		String Description = "";
		Double totalAmount = 0.0;
		String createdBy = "";
		String voucherType = "";
		String voucherDate = "";
		
		for (AccountJournalVoucherModel m : journalVoucherModel) {
			journalVoucher = m.getJournalVoucher();
			costCenter = m.getCostCenter();
			Description = m.getDescription();
			createdBy = m.getCreatedBy();
			totalAmount = m.getTotalAmount();
			voucherType = m.getVoucherType();
			voucherDate = m.getVoucherDate();

		}

		s = s + "@p_journalVoucher='" + journalVoucher + "',";
		s = s + "@p_costCenter='" + costCenter + "',";
		s = s + "@p_description='" + Description + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_voucherType='" + voucherType + "',";
		s = s + "@p_totalAmount=" + totalAmount + ",";
		s = s + "@p_voucherDate='" + voucherDate + "',";

		for (AccountJournalVoucherModel m : journalVoucherModel) {
			m.setTransactionType("Debit");
			m.setDebitTrans("YES");
			m.setCreditTrans("");
			if (m.getFromAmount() != null && m.getFromAccountSubGroup() != null) {
				litem = litem + "(@p_journalVoucher,\""+m.getDebitTrans()+"\",\""+m.getCreditTrans()+"\","
						+ "\"" + m.getFromAccountSubGroup() + "\",\"" + m.getTransactionType()+ "\","
								+ "\"" + m.getFromName() + "\"," + m.getFromAmount() + "),";
			}
		}
		for (AccountJournalVoucherModel m : journalVoucherModel) {
			m.setTransactionType("Credit");
			m.setDebitTrans("");
			m.setCreditTrans("YES");
			if (m.getToAmount() != null && m.getToAccountSubGroup() != null) {
				litem = litem + "(@p_journalVoucher,\""+m.getDebitTrans()+"\",\""+m.getCreditTrans()+"\",\"" + m.getToAccountSubGroup() + "\",\"" + m.getTransactionType()
						+ "\",\"" + m.getToName() + "\"," + m.getToAmount() + "),";

			}
		}
		litem = litem.substring(0, litem.length()-1);

		s = s + "@p_jVSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("==>>>>>>>>>>>>>>>>>>"+s);
		return s;
	}

}

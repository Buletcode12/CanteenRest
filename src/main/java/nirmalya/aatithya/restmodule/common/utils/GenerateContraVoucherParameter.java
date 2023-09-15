/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateContraVoucherParameter {

	public static String getAddContraParam(RestContraVoucherModel form) {

		String s = "";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateString);
		s = s + "@p_createdTime='" + dateString + "',";

		if (form.getContraVoucherId() != null) {
			s = s + "@p_contraVouId='" + form.getContraVoucherId() + "',";
		}

		if (form.getContraVoucherType() != null && form.getContraVoucherType() != "") {
			s = s + "@p_contraVouType='" + form.getContraVoucherType() + "',";
		}

		if (form.getCostCenterType() != null && form.getCostCenterType() != "") {
			s = s + "@p_cctype='" + form.getCostCenterType() + "',";
		}

		if (form.getContraVoucherDate() != null && form.getContraVoucherDate() != "") {
			s = s + "@p_contraVouDate='" + form.getContraVoucherDate() + "',";
		}

		if (form.getAmount() != null && form.getAmount() != "") {
			s = s + "@p_amount='" + form.getAmount() + "',";
		}

		if (form.getDebitedAccGroup() != null && form.getDebitedAccGroup() != "") {
			s = s + "@p_debitAccGrp='" + form.getDebitedAccGroup() + "',";
		}

		if (form.getDebAccGroupId() != null && form.getDebAccGroupId() != "") {
			s = s + "@p_debitAccGrpId='" + form.getDebAccGroupId() + "',";
		}

		if (form.getCreAccGroupId() != null && form.getCreAccGroupId() != "") {
			s = s + "@p_creditAccGrpId='" + form.getCreAccGroupId() + "',";
		}

		if (form.getCreditedAccGroup() != null && form.getCreditedAccGroup() != "") {
			s = s + "@p_creditAccGrp='" + form.getCreditedAccGroup() + "',";
		}

		if (form.getFromAccountB2BId() != null && form.getFromAccountB2BId() != "") {
			s = s + "@p_fromAccountB2BId='" + form.getFromAccountB2BId() + "',";
		}

		if (form.getFromAccountB2B() != null && form.getFromAccountB2B() != "") {
			s = s + "@p_fromAccountB2B='" + form.getFromAccountB2B() + "',";
		}

		if (form.getToAccountB2BId() != null && form.getToAccountB2BId() != "") {
			s = s + "@p_toAccountB2BId='" + form.getToAccountB2BId() + "',";
		}

		if (form.getToAccountB2B() != null && form.getToAccountB2B() != "") {
			s = s + "@p_toAccountB2B='" + form.getToAccountB2B() + "',";
		}

		if (form.getFromBankB2CId() != null && form.getFromBankB2CId() != "") {
			s = s + "@p_fromBankB2CId='" + form.getFromBankB2CId() + "',";
		}

		if (form.getFromBankB2C() != null && form.getFromBankB2C() != "") {
			s = s + "@p_fromBankB2C='" + form.getFromBankB2C() + "',";
		}

		if (form.getToCashB2C() != null && form.getToCashB2C() != "") {
			s = s + "@p_toCashB2C='" + form.getToCashB2C() + "',";
		}

		if (form.getFromCashC2B() != null && form.getFromCashC2B() != "") {
			s = s + "@p_fromCashC2B='" + form.getFromCashC2B() + "',";
		}

		if (form.getToBankC2BId() != null && form.getToBankC2BId() != "") {
			s = s + "@p_toBankC2BId='" + form.getToBankC2BId() + "',";
		}

		if (form.getToBankC2B() != null && form.getToBankC2B() != "") {
			s = s + "@p_toBankC2B='" + form.getToBankC2B() + "',";
		}

		if (form.getFromCashC2C() != null && form.getFromCashC2C() != "") {
			s = s + "@p_fromCashC2C='" + form.getFromCashC2C() + "',";
		}

		if (form.getToCashC2C() != null && form.getToCashC2C() != "") {
			s = s + "@p_toCashC2C='" + form.getToCashC2C() + "',";
		}

		if (form.getDescription() != null && form.getDescription() != "") {
			s = s + "@p_description='" + form.getDescription() + "',";
		}

		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (form.getFromBranch() != null && form.getFromBranch() != "") {
			s = s + "@p_fromBranch='" + form.getFromBranch() + "',";
		}

		if (form.getFromAccount() != null && form.getFromAccount() != "") {
			s = s + "@p_fromAccount='" + form.getFromAccount() + "',";
		}

		if (form.getFromCash() != null && form.getFromCash() != "") {
			s = s + "@p_fromCash='" + form.getFromCash() + "',";
		}

		if (form.getToBranch() != null && form.getToBranch() != "") {
			s = s + "@p_toBranch='" + form.getToBranch() + "',";
		}

		if (form.getToAccount() != null && form.getToAccount() != "") {
			s = s + "@p_toAccount='" + form.getToAccount() + "',";
		}

		if (form.getToCash() != null && form.getToCash() != "") {
			s = s + "@p_toCash='" + form.getToCash() + "',";
		}
		
		if (form.getDebitAccountGroup() != null && form.getDebitAccountGroup() != "") {
			s = s + "@p_debitAccountGroup='" + form.getDebitAccountGroup() + "',";
		}
		if (form.getCreditAccountGroup() != null && form.getCreditAccountGroup() != "") {
			s = s + "@p_creditAccountGroup='" + form.getCreditAccountGroup() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

}

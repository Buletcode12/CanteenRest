/**
 * 
 */
package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class RestAccountModel {
	private String accountId;
	private String accountHolder;
	private String bankName;
	private String branchName;
	private String accountType;
	private String accountNumber;
	private String status;
	private String createdDate;	
	private String createdTime;
	private String createdBy;
	
	public RestAccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RestAccountModel(Object accountId, Object bankName, Object branchName,Object accountHolder,
			Object accountType,Object accountNumber,Object status,Object createdDate, Object createdTime) {
		super();
		this.accountId = (String) accountId;
		this.bankName = (String) bankName;
		this.branchName = (String) branchName;
		
		this.accountHolder = (String) accountHolder;
		this.accountType = (String) accountType;
		this.accountNumber = (String) accountNumber;
		this.status = (String) status;
		this.createdDate = (String) createdDate;
		this.createdTime=(String) createdTime;
		
	}
	

	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

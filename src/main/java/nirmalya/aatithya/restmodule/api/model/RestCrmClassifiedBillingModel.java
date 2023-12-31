package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmClassifiedBillingModel {
	private String billId;
	private String bill; 
	private String billDate; 
	private String displayBill;
	private String status;
	private String createdBy;
	private String createdByName;
	private String orgName;
	private String orgDiv;

	public RestCrmClassifiedBillingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public RestCrmClassifiedBillingModel(Object billId, Object bill, Object billDate,Object displayBill,
			Object createdBy,Object createdByName,Object status) {
		super();
		this.billId = (String)billId;
		this.bill = (String)bill;
		this.billDate = (String)billDate;
		this.displayBill= (String)displayBill; 
		this.createdBy = (String)createdBy;
		this.createdByName = (String)createdByName;
		this.status = (String)status;
	}
 
	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getDisplayBill() {
		return displayBill;
	}

	public void setDisplayBill(String displayBill) {
		this.displayBill = displayBill;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
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

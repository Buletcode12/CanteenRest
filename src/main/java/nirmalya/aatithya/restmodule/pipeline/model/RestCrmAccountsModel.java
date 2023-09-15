package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmAccountsModel {

	private String accountId;
	private String accountOwner;
	private String rating;
	private String accountName;
	private String phone;
	private String accountSite;
	private String parentAccountId;
	private String parentAccount;
	private String fax;
	private String website;
	private String accountNo;
	private String ticketSymbol;
	private String accountType;
	private String ownership;
	private String industry;
	private String employee;
	private String accountRevenue;
	private String sicCode;
	private String billingStreet;
	private String shippingStreet;
	private String billingCity;
	private String shippingCity;
	private String billingState;
	private String shippingState;
	private String billingCode;
	private String shippingCode;
	private String billingCountry;
	private String shippingCountry;
	private String description;
	private String createdBy;
	private String imageName;
	
	private String createdDate;
	private String createdTime;
	private String ownerImage;
	private String referenceContact;
	
	
	
	
	public String getReferenceContact() {
		return referenceContact;
	}




	public void setReferenceContact(String referenceContact) {
		this.referenceContact = referenceContact;
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




	public String getOwnerImage() {
		return ownerImage;
	}




	public void setOwnerImage(String ownerImage) {
		this.ownerImage = ownerImage;
	}




	public RestCrmAccountsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getParentAccountId() {
		return parentAccountId;
	}




	public void setParentAccountId(String parentAccountId) {
		this.parentAccountId = parentAccountId;
	}




	public String getImageName() {
		return imageName;
	}




	public void setImageName(String imageName) {
		this.imageName = imageName;
	}




	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String getAccountOwner() {
		return accountOwner;
	}



	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public String getAccountName() {
		return accountName;
	}



	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAccountSite() {
		return accountSite;
	}



	public void setAccountSite(String accountSite) {
		this.accountSite = accountSite;
	}



	public String getParentAccount() {
		return parentAccount;
	}



	public void setParentAccount(String parentAccount) {
		this.parentAccount = parentAccount;
	}



	public String getFax() {
		return fax;
	}



	public void setFax(String fax) {
		this.fax = fax;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}



	public String getTicketSymbol() {
		return ticketSymbol;
	}



	public void setTicketSymbol(String ticketSymbol) {
		this.ticketSymbol = ticketSymbol;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public String getOwnership() {
		return ownership;
	}



	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}



	public String getIndustry() {
		return industry;
	}



	public void setIndustry(String industry) {
		this.industry = industry;
	}



	public String getEmployee() {
		return employee;
	}



	public void setEmployee(String employee) {
		this.employee = employee;
	}



	public String getAccountRevenue() {
		return accountRevenue;
	}



	public void setAccountRevenue(String accountRevenue) {
		this.accountRevenue = accountRevenue;
	}



	public String getSicCode() {
		return sicCode;
	}



	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}



	public String getBillingStreet() {
		return billingStreet;
	}



	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}



	public String getShippingStreet() {
		return shippingStreet;
	}



	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}



	public String getBillingCity() {
		return billingCity;
	}



	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}



	public String getShippingCity() {
		return shippingCity;
	}



	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}



	public String getBillingState() {
		return billingState;
	}



	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}



	public String getShippingState() {
		return shippingState;
	}



	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}



	public String getBillingCode() {
		return billingCode;
	}



	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}



	public String getShippingCode() {
		return shippingCode;
	}



	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}



	public String getBillingCountry() {
		return billingCountry;
	}



	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}



	public String getShippingCountry() {
		return shippingCountry;
	}



	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public RestCrmAccountsModel(Object accountId, Object accountOwner, Object rating, Object accountName, Object phone,
			Object accountSite, Object parentAccountId,Object parentAccount, Object fax, Object website, Object accountNo, Object ticketSymbol,
			Object accountType, Object ownership, Object industry, Object employee, Object accountRevenue,
			Object sicCode, Object billingStreet, Object shippingStreet, Object billingCity, Object shippingCity,
			Object billingState, Object shippingState, Object billingCode, Object shippingCode, Object billingCountry,
			Object shippingCountry, Object description, Object imageName, Object createdDate, Object createdTime, 
			Object ownerImage,Object referenceContact) {
		super();
		try {
			this.accountId = (String) accountId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.accountOwner = (String) accountOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.rating = (String) rating;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.accountName = (String) accountName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.phone = (String) phone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.accountSite = (String) accountSite;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.parentAccountId = (String) parentAccountId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.parentAccount = (String) parentAccount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.fax = (String) fax;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.website = (String) website;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.accountNo = (String) accountNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.ticketSymbol = (String) ticketSymbol;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.accountType = (String) accountType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.ownership = (String) ownership;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.industry = (String) industry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.employee = (String) employee;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			this.accountRevenue = (String) accountRevenue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.sicCode = (String) sicCode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.billingStreet = (String) billingStreet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.shippingStreet = (String) shippingStreet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.billingCity = (String) billingCity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.shippingCity = (String) shippingCity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			this.billingState = (String) billingState;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.shippingState = (String) shippingState;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.billingCode = (String) billingCode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.shippingCode = (String) shippingCode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.billingCountry = (String) billingCountry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.shippingCountry = (String) shippingCountry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.description = (String) description;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.imageName = (String) imageName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.createdDate = (String) createdDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.createdTime = (String) createdTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.ownerImage = (String) ownerImage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.referenceContact = (String) referenceContact;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

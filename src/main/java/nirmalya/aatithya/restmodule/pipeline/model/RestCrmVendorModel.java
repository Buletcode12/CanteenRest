package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmVendorModel {
	private String vendorId;
	private String vendorOwner;
	private String vendorName;
	private String vendorPhone;
	private String vendorEmail;
	private String vendorWebsite;
	private String glaAccount;
	private String vendorCategory;
	private String vendorStreet;
	private String vendorCity;
	private String vendorState;
	private String vendorZipCode;
	private String vendorCountry;
	private String description;
	private String createdBy;
	private String imageName;
	private String vendorImageLink;
	private String createdDate;
	private String updatedDate;
	
public RestCrmVendorModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestCrmVendorModel(Object vendorId, Object vendorOwner, Object vendorName, Object vendorPhone,
			Object vendorEmail, Object vendorWebsite, Object glaAccount,Object vendorCategory,
			Object vendorStreet,Object vendorCity,
			Object vendorState, Object vendorZipCode,
			Object vendorCountry,Object description,Object imageName, Object createdBy,
			Object createdDate) {
		
		
		super();
		try {
			this.vendorId = (String) vendorId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.vendorOwner = (String) vendorOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.vendorName = (String) vendorName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.vendorPhone = (String) vendorPhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.vendorEmail = (String) vendorEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.vendorWebsite = (String) vendorWebsite;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.glaAccount = (String) glaAccount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.vendorCategory = (String) vendorCategory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.vendorStreet = (String) vendorStreet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.vendorCity = (String) vendorCity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.vendorState = (String) vendorState;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.vendorZipCode = (String) vendorZipCode;
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
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.vendorCountry = (String) vendorCountry;
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
			this.createdBy = (String) createdBy;
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
		
		
	}
	
	
	
	public String getVendorId() {
		return vendorId;
	}



	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}



	public String getVendorOwner() {
		return vendorOwner;
	}



	public void setVendorOwner(String vendorOwner) {
		this.vendorOwner = vendorOwner;
	}



	public String getVendorName() {
		return vendorName;
	}



	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}



	public String getVendorPhone() {
		return vendorPhone;
	}



	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}



	public String getVendorEmail() {
		return vendorEmail;
	}



	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}



	public String getVendorWebsite() {
		return vendorWebsite;
	}



	public void setVendorWebsite(String vendorWebsite) {
		this.vendorWebsite = vendorWebsite;
	}



	public String getGlaAccount() {
		return glaAccount;
	}



	public void setGlaAccount(String glaAccount) {
		this.glaAccount = glaAccount;
	}



	public String getVendorCategory() {
		return vendorCategory;
	}



	public void setVendorCategory(String vendorCategory) {
		this.vendorCategory = vendorCategory;
	}



	public String getVendorStreet() {
		return vendorStreet;
	}



	public void setVendorStreet(String vendorStreet) {
		this.vendorStreet = vendorStreet;
	}



	public String getVendorCity() {
		return vendorCity;
	}



	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}



	public String getVendorState() {
		return vendorState;
	}



	public void setVendorState(String vendorState) {
		this.vendorState = vendorState;
	}



	public String getVendorZipCode() {
		return vendorZipCode;
	}



	public void setVendorZipCode(String vendorZipCode) {
		this.vendorZipCode = vendorZipCode;
	}



	public String getVendorCountry() {
		return vendorCountry;
	}



	public void setVendorCountry(String vendorCountry) {
		this.vendorCountry = vendorCountry;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getImageName() {
		return imageName;
	}



	public void setImageName(String imageName) {
		this.imageName = imageName;
	}



	public String getVendorImageLink() {
		return vendorImageLink;
	}



	public void setVendorImageLink(String vendorImageLink) {
		this.vendorImageLink = vendorImageLink;
	}



	public String getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}



	public String getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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

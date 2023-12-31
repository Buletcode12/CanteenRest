package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmOwnerModel {

			private String ownerId;
			private String firstName;
			private String lastName;
			private String email;
			private String phone;
			private String fax;
			private String mobile;
			private String website;
			private String industry;
			private String skypeId;
			private String twitter;
			private String organisationName;
			private String status;
			private String secondaryMail;
			private String ownerDob;
			private String whatsappNumber;
			
			private String country;
			private String states;
			private String city;
			private String addressStreet;
			private String zip;
			
			private String description;
			private String createdBy;
			private String imageName;
			
			
		
			
			public RestCrmOwnerModel(Object ownerId, Object firstName, Object lastName, Object email, Object phone,
					Object fax, Object mobile, Object website, Object industry, Object skypeId, Object twitter,
					Object organisationName, Object status, Object secondaryMail, Object ownerDob,
					Object whatsappNumber, Object country, Object states, Object city, Object addressStreet, Object zip,
					Object description, Object imageName) {
				super();
				this.ownerId = (String) ownerId;
				this.firstName = (String)  firstName;
				this.lastName =  (String) lastName;
				this.email =  (String) email;
				this.phone =  (String) phone;
				this.fax =  (String) fax;
				this.mobile =  (String) mobile;
				this.website =  (String) website;
				this.industry = (String)  industry;
				this.skypeId =  (String) skypeId;
				this.twitter =  (String) twitter;
				this.organisationName =  (String) organisationName;
				this.status =  (String) status;
				this.secondaryMail = (String)  secondaryMail;
				this.ownerDob =  (String) ownerDob;
				this.whatsappNumber =  (String)  whatsappNumber;
				this.country =  (String) country;
				this.states =  (String) states;
				this.city =  (String) city;
				this.addressStreet = (String)  addressStreet;
				this.zip =  (String) zip;
				this.description = (String)  description;
				this.imageName = (String)  imageName;
			}

			public RestCrmOwnerModel(Object ownerId, Object firstName, Object organisationName,Object mobile, Object email,
					Object imageName) {
				super();
				this.ownerId = (String) ownerId;
				this.firstName = (String) firstName;
				this.email = (String) email;
				this.mobile = (String) mobile;
				this.organisationName = (String) organisationName;
				this.imageName = (String) imageName;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

			public String getSecondaryMail() {
				return secondaryMail;
			}

			public void setSecondaryMail(String secondaryMail) {
				this.secondaryMail = secondaryMail;
			}

			public String getOwnerDob() {
				return ownerDob;
			}

			public void setOwnerDob(String ownerDob) {
				this.ownerDob = ownerDob;
			}

			public String getWhatsappNumber() {
				return whatsappNumber;
			}

			public void setWhatsappNumber(String whatsappNumber) {
				this.whatsappNumber = whatsappNumber;
			}

			public String getOrganisationName() {
				return organisationName;
			}

			public void setOrganisationName(String organisationName) {
				this.organisationName = organisationName;
			}

			public String getImageName() {
				return imageName;
			}

			public void setImageName(String imageName) {
				this.imageName = imageName;
			}

			public RestCrmOwnerModel() {
				super();
				// TODO Auto-generated constructor stub
			}
			
			
			public String getOwnerId() {
				return ownerId;
			}

			public void setOwnerId(String ownerId) {
				this.ownerId = ownerId;
			}

			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			public String getLastName() {
				return lastName;
			}
			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
			
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPhone() {
				return phone;
			}
			public void setPhone(String phone) {
				this.phone = phone;
			}
			public String getFax() {
				return fax;
			}
			public void setFax(String fax) {
				this.fax = fax;
			}
			public String getMobile() {
				return mobile;
			}
			public void setMobile(String mobile) {
				this.mobile = mobile;
			}
			public String getWebsite() {
				return website;
			}
			public void setWebsite(String website) {
				this.website = website;
			}
			
			public String getIndustry() {
				return industry;
			}
			public void setIndustry(String industry) {
				this.industry = industry;
			}
			
			public String getSkypeId() {
				return skypeId;
			}
			public void setSkypeId(String skypeId) {
				this.skypeId = skypeId;
			}
			public String getTwitter() {
				return twitter;
			}
			public void setTwitter(String twitter) {
				this.twitter = twitter;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public String getStates() {
				return states;
			}
			public void setStates(String states) {
				this.states = states;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getAddressStreet() {
				return addressStreet;
			}
			public void setAddressStreet(String addressStreet) {
				this.addressStreet = addressStreet;
			}
			public String getZip() {
				return zip;
			}
			public void setZip(String zip) {
				this.zip = zip;
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

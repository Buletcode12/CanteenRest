package nirmalya.aatithya.restmodule.property.stakeholder.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestManagePropertyPerformanceModel {
	private String performanceId;
	private String propNo;
	private String alliesname;
	private String actualRent;
	private String annualRent;
	private String type;
	private String experience;
	private String area;
	private String netIncome;
	private String propPrice;
	private String returnRate;
	private String createdby;
	private String createdon;
	

	public RestManagePropertyPerformanceModel() {
		super();
	}

	public RestManagePropertyPerformanceModel(Object performanceId, Object propNo, Object alliesname, Object type, Object area,
			 Object propPrice, Object annualRent,Object actualRent, Object experience, Object netIncome,
			Object returnRate, Object createdby) {
		super();
		this.performanceId = (String) performanceId;
		this.propNo = (String) propNo;
		this.alliesname = (String) alliesname;
		this.actualRent = (String) actualRent;
		this.annualRent = (String) annualRent;
		this.type = (String) type;
		this.experience = (String) experience;
		this.area = (String) area;
		this.netIncome = (String) netIncome;
		this.propPrice = (String) propPrice;
		this.returnRate = (String) returnRate;
		this.createdby = (String) createdby;
	}

	public String getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(String performanceId) {
		this.performanceId = performanceId;
	}

	public String getPropNo() {
		return propNo;
	}




	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}




	public String getAlliesname() {
		return alliesname;
	}




	public void setAlliesname(String alliesname) {
		this.alliesname = alliesname;
	}




	public String getActualRent() {
		return actualRent;
	}




	public void setActualRent(String actualRent) {
		this.actualRent = actualRent;
	}




	public String getAnnualRent() {
		return annualRent;
	}




	public void setAnnualRent(String annualRent) {
		this.annualRent = annualRent;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getExperience() {
		return experience;
	}




	public void setExperience(String experience) {
		this.experience = experience;
	}




	public String getArea() {
		return area;
	}




	public void setArea(String area) {
		this.area = area;
	}




	public String getNetIncome() {
		return netIncome;
	}




	public void setNetIncome(String netIncome) {
		this.netIncome = netIncome;
	}




	public String getPropPrice() {
		return propPrice;
	}




	public void setPropPrice(String propPrice) {
		this.propPrice = propPrice;
	}




	public String getReturnRate() {
		return returnRate;
	}




	public void setReturnRate(String returnRate) {
		this.returnRate = returnRate;
	}




	public String getCreatedby() {
		return createdby;
	}




	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
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

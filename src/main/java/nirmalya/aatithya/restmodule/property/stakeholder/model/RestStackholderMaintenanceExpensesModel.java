package nirmalya.aatithya.restmodule.property.stakeholder.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestStackholderMaintenanceExpensesModel {

	private String mainid;
	private String propno;
	private String month;
	private String maintainence;
	private String recptno;
	private String amount;
	private String createdby;
	private String createdOn;
	
	

	public String getMainid() {
		return mainid;
	}


	public void setMainid(String mainid) {
		this.mainid = mainid;
	}


	public String getRecptno() {
		return recptno;
	}


	public void setRecptno(String recptno) {
		this.recptno = recptno;
	}


	public	RestStackholderMaintenanceExpensesModel() {
		super();
	}

	
	public	RestStackholderMaintenanceExpensesModel(Object mainid,  Object propno, Object month,Object maintainence,Object recptno,Object amount,Object createdby,Object createdOn) {
		super();
		
		this.mainid = (String)mainid;
		this.propno = (String)propno;
		this.month = (String)month;
		this.maintainence = (String) maintainence;
		this.recptno = (String)recptno;
		this.amount = (String) amount;
		this.createdby=(String)createdby;
		this.createdOn=(String)createdOn;
		
	}
	
	
	public String getPropno() {
		return propno;
	}
	public void setPropno(String propno) {
		this.propno = propno;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMaintainence() {
		return maintainence;
	}
	public void setMaintainence(String maintainence) {
		this.maintainence = maintainence;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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

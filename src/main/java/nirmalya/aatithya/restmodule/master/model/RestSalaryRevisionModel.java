package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestSalaryRevisionModel {
	
	private String empId;
	private String name;
	private String fatherName;
	private String pdesg;
	private String ndesg;
	private String effectiveDate;
	private String band;
	private String basic;
	private String hra;
	private String addAllow;
	private String lta;
	private String medical;
	private String other;
	private String conve;
	private String washAllow;
	private String skillDev;
	private String createdBy;
	private String editId;
	private String organization;
	private String orgDivision;
	private String dept;
	private String subdept;
	private String ctc;
	public RestSalaryRevisionModel() {
		super();
	}
	
	public RestSalaryRevisionModel( Object empId, Object name,Object pdesg, Object ndesg, Object effectiveDate, Object band,
			Object basic,Object hra,Object addAllow, Object lta,Object medical,Object conve,Object washAllow,Object skillDev,Object other,
			Object editId,Object organization,Object orgDivision,Object dept,Object subdept,Object ctc,Object fatherName) {
		super();
		this.empId = (String) empId;
		this.name = (String) name;
		this.pdesg = (String) pdesg;
		this.ndesg = (String) ndesg;
		this.effectiveDate = (String) effectiveDate;
		this.band = (String) band;
		
		this.basic = (String) basic;
		this.hra = (String) hra;
		this.addAllow = (String) addAllow;
		this.lta = (String) lta;
		this.medical = (String) medical;
		this.conve = (String) conve;
		this.washAllow = (String) washAllow;
		this.skillDev = (String) skillDev;
		this.other = (String) other;
		
		this.editId = (String) editId;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
		this.dept = (String) dept;
		this.subdept = (String) subdept;
		this.ctc = (String) ctc;
		this.fatherName = (String) fatherName;
	}
	
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPdesg() {
		return pdesg;
	}
	public void setPdesg(String pdesg) {
		this.pdesg = pdesg;
	}
	public String getNdesg() {
		return ndesg;
	}
	public void setNdesg(String ndesg) {
		this.ndesg = ndesg;
	}
	
	
	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getHra() {
		return hra;
	}
	public void setHra(String hra) {
		this.hra = hra;
	}
	public String getAddAllow() {
		return addAllow;
	}
	public void setAddAllow(String addAllow) {
		this.addAllow = addAllow;
	}
	public String getLta() {
		return lta;
	}
	public void setLta(String lta) {
		this.lta = lta;
	}
	public String getMedical() {
		return medical;
	}
	public void setMedical(String medical) {
		this.medical = medical;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
    
	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getConve() {
		return conve;
	}

	public void setConve(String conve) {
		this.conve = conve;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrgDivision() {
		return orgDivision;
	}

	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSubdept() {
		return subdept;
	}

	public void setSubdept(String subdept) {
		this.subdept = subdept;
	}
	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	public String getWashAllow() {
		return washAllow;
	}

	public void setWashAllow(String washAllow) {
		this.washAllow = washAllow;
	}

	public String getSkillDev() {
		return skillDev;
	}

	public void setSkillDev(String skillDev) {
		this.skillDev = skillDev;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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

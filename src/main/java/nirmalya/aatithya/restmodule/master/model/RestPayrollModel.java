package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPayrollModel {
	private String empId;
	private String bandId;
	private String empName;
	private String bankAccountName;
	private String bankAccount;
	private String salary;

	private String uanNo;
	private String workDay;
	private String workingDay;
	private String fatherName;
	private String empEPF;
	private String compEPF;
	private String empESI;
	private String compESI;

	private String panNo;
	private String incTax;

	private String basic;
	private String hra;
	private String addAll;
	private String lta;
	private String medical;
	private String other;
	private String conve;
	private String washAllow;
	private String skillDev;
	private String bonus;
	private String reward;
	private String foodReim;
	private String arear;
	private String overTime;
	private String totalEarning;

	private String advance;
	private String netPay;
	private String annualSalary;
	private String profTax;
	private String totalDeduction;
	private String approveStatus;
	private String remarks;
	private String approvedBy;
	private String fromDate;
	private String toDate;
	private String financialYr;
	private String deptId;
	private String subDeptId;
	private String dept;
	private String subDept;
	private String paymentStatus;

	public RestPayrollModel(Object empId, Object empName, Object bandId, 
			Object basic,Object hra,Object lta,Object addAll,Object conve,Object medical,Object washAllow,Object skillDev,Object other,Object bonus,Object reward,Object foodReim,Object arear,Object overTime,Object totalEarning, 
			Object empEPF, Object empESI, Object advance,Object profTax,Object incTax,Object totalDeduction,
			Object netPay,Object compEPF, Object compESI,
			Object approveStatus,Object deptId,Object subDeptId,Object dept,Object subDept,Object workDay,Object workingDay,Object fatherName) {
		super();
		this.empId = (String) empId;
		this.empName = (String) empName;
		this.bandId = (String) bandId;
		
		this.basic = (String) basic;
		this.hra = (String) hra;
		this.lta = (String) lta;
		this.addAll = (String) addAll;
		this.conve = (String) conve;
		this.medical = (String) medical;
		this.washAllow = (String) washAllow;
		this.skillDev = (String) skillDev;
		this.other = (String) other;
		this.bonus = (String) bonus;
		this.reward = (String) reward;
		this.foodReim = (String) foodReim;
		this.arear = (String) arear;
		this.overTime = (String) overTime;
		this.totalEarning = (String) totalEarning;
  
		this.empEPF = (String) empEPF;
		this.empESI = (String) empESI;
		this.advance = (String) advance;
		this.profTax = (String) profTax;
		this.incTax = (String) incTax;
		this.totalDeduction = (String) totalDeduction;
		
		this.netPay = (String) netPay;
		this.compEPF = (String) compEPF;
		this.compESI = (String) compESI;
		
		this.approveStatus = (String) approveStatus;
		this.deptId = (String) deptId;
		this.subDeptId = (String) subDeptId;
		this.dept = (String) dept;
		this.subDept = (String) subDept;
		this.workDay = (String) workDay;
		this.workingDay = (String) workingDay;
		this.fatherName = (String) fatherName;
	}

	public RestPayrollModel() {
		super();
	}

	public RestPayrollModel(Object empId, Object empName,Object bankAccountName, Object bankAccount, Object salary,Object approveStatus,Object dept,Object subDept,Object paymentStatus) {
		super();
		this.empId = (String) empId;
		this.empName = (String) empName;
		this.bankAccountName = (String) bankAccountName;
		this.bankAccount = (String) bankAccount;
		this.salary = (String) salary;
		this.approveStatus = (String) approveStatus;
		this.dept = (String) dept;
		this.subDept = (String) subDept;
		this.paymentStatus = (String) paymentStatus;
		
	}

	public RestPayrollModel(Object empId, Object empName, Object uanNo, Object workingDay, Object salary, Object empEPF,
			Object compEPF,Object dept,Object subDept,Object paymentStatus) {
		super();
		this.empId = (String) empId;
		this.empName = (String) empName;
		this.uanNo = (String) uanNo;
		this.workingDay = (String) workingDay;
		this.salary = (String) salary;
		this.empEPF = (String) empEPF;
		this.compEPF = (String) compEPF;
		this.dept = (String) dept;
		this.subDept = (String) subDept;
		this.paymentStatus = (String) paymentStatus;
	}

	public RestPayrollModel(Object empId, Object empName, Object uanNo, Object workingDay, Object salary, Object empESI,
			Object compESI, Object workday,Object dept,Object subDept,Object paymentStatus) {
		super();
		this.empId = (String) empId;
		this.empName = (String) empName;
		this.uanNo = (String) uanNo;
		this.workingDay = (String) workingDay;
		this.salary = (String) salary;
		this.empESI = (String) empESI;
		this.compESI = (String) compESI;
		this.dept = (String) dept;
		this.subDept = (String) subDept;
		this.paymentStatus = (String) paymentStatus;
	}

	public RestPayrollModel(Object empId, Object empName, Object panNo, Object salary, Object incTax,Object dept,Object subDept,Object paymentStatus) {
		super();
		this.empId = (String) empId;
		this.empName = (String) empName;
		this.panNo = (String) panNo;
		this.salary = (String) salary;
		this.incTax = (String) incTax;
		this.dept = (String) dept;
		this.subDept = (String) subDept;
		this.paymentStatus = (String) paymentStatus;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getBandId() {
		return bandId;
	}

	public void setBandId(String bandId) {
		this.bandId = bandId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getUanNo() {
		return uanNo;
	}

	public void setUanNo(String uanNo) {
		this.uanNo = uanNo;
	}

	public String getWorkDay() {
		return workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public String getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmpEPF() {
		return empEPF;
	}

	public void setEmpEPF(String empEPF) {
		this.empEPF = empEPF;
	}

	public String getCompEPF() {
		return compEPF;
	}

	public void setCompEPF(String compEPF) {
		this.compEPF = compEPF;
	}

	public String getEmpESI() {
		return empESI;
	}

	public void setEmpESI(String empESI) {
		this.empESI = empESI;
	}

	public String getCompESI() {
		return compESI;
	}

	public void setCompESI(String compESI) {
		this.compESI = compESI;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getIncTax() {
		return incTax;
	}

	public void setIncTax(String incTax) {
		this.incTax = incTax;
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

	public String getAddAll() {
		return addAll;
	}

	public void setAddAll(String addAll) {
		this.addAll = addAll;
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

	public String getConve() {
		return conve;
	}

	public void setConve(String conve) {
		this.conve = conve;
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

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getFoodReim() {
		return foodReim;
	}

	public void setFoodReim(String foodReim) {
		this.foodReim = foodReim;
	}

	public String getArear() {
		return arear;
	}

	public void setArear(String arear) {
		this.arear = arear;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public String getTotalEarning() {
		return totalEarning;
	}

	public void setTotalEarning(String totalEarning) {
		this.totalEarning = totalEarning;
	}

	public String getAdvance() {
		return advance;
	}

	public void setAdvance(String advance) {
		this.advance = advance;
	}

	public String getNetPay() {
		return netPay;
	}

	public void setNetPay(String netPay) {
		this.netPay = netPay;
	}

	public String getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getProfTax() {
		return profTax;
	}

	public void setProfTax(String profTax) {
		this.profTax = profTax;
	}

	public String getTotalDeduction() {
		return totalDeduction;
	}

	public void setTotalDeduction(String totalDeduction) {
		this.totalDeduction = totalDeduction;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFinancialYr() {
		return financialYr;
	}

	public void setFinancialYr(String financialYr) {
		this.financialYr = financialYr;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(String subDeptId) {
		this.subDeptId = subDeptId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSubDept() {
		return subDept;
	}

	public void setSubDept(String subDept) {
		this.subDept = subDept;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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

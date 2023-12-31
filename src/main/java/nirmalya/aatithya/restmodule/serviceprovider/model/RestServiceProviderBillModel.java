package nirmalya.aatithya.restmodule.serviceprovider.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestServiceProviderBillModel {
	
	private String instrno;
	private String propertyno;
	private String paymentdate;
	private String totalos;
	private String duedate;
	private String paydate;
	private String paystatus;
	
	
	public RestServiceProviderBillModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestServiceProviderBillModel(Object instrno, Object propertyno, Object paymentdate,
			Object totalos, Object duedate, Object paydate, Object paystatus) {
		super();
		this.instrno = (String) instrno;
		this.propertyno = (String) propertyno;
		this.paymentdate = (String) paymentdate;
		this.totalos = (String) totalos;
		this.duedate = (String) duedate;
		this.paydate = (String) paydate;
		this.paystatus = (String) paystatus;

	}
	

	
	public String getInstrno() {
		return instrno;
	}

	public void setInstrno(String instrno) {
		this.instrno = instrno;
	}

	public String getPropertyno() {
		return propertyno;
	}

	public void setPropertyno(String propertyno) {
		this.propertyno = propertyno;
	}

	public String getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getTotalos() {
		return totalos;
	}

	public void setTotalos(String totalos) {
		this.totalos = totalos;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public String getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
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

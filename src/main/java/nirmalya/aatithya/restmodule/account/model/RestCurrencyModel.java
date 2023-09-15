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
public class RestCurrencyModel {
	private String currencyId;
	private String currency;
	private String dateAdjust;
	private String exchangeRateInr;
	private String status;
	private String notes;
	private String createdDate;	
	private String createdTime;
	private String createdBy;
	
	public RestCurrencyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RestCurrencyModel(Object currencyId, Object currency, Object dateAdjust,Object exchangeRateInr,
			Object status,Object notes, Object createdTime, Object createdDate) {
		super();
		this.currencyId = (String) currencyId;
		this.currency = (String) currency;
		this.dateAdjust = (String) dateAdjust;
		this.exchangeRateInr = (String) exchangeRateInr;
		this.status = (String) status;
		this.notes = (String) notes;
		this.createdTime=(String) createdTime;
		this.createdDate = (String) createdDate;
			
	}
	
	public String getCurrencyId() {
		return currencyId;
	}


	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getDateAdjust() {
		return dateAdjust;
	}


	public void setDateAdjust(String dateAdjust) {
		this.dateAdjust = dateAdjust;
	}


	public String getExchangeRateInr() {
		return exchangeRateInr;
	}


	public void setExchangeRateInr(String exchangeRateInr) {
		this.exchangeRateInr = exchangeRateInr;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
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

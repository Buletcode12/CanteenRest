package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmCallModel {
	
	private String callId;
	private String relatedId;
	private String callToWhom;
	private String leadName;
	private String leadId;
	private String pageType;
	private String contactName;
	private String contactId;
	private String relatedType;
	private String relatedName;
	private String callType;
	private String callStatus;
	private String callStartDate;
	private String callStartTime;
	private String callOwner;
	private String callSubject;	
	private String callReminder;
	private String callPurpose;
	private String callAgenda;
	private String createdBy;
	private String createdOn;
	
	private String callLeadId;
	private String callDealId;
	private String callContactId;
	private String callAccountId;
	
	private String quoteId;
	private String soId;
	private String poId;
	private String invoiceId;
	
	
	private String ownerName;
	
	
	
	
	public String getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}
	public String getSoId() {
		return soId;
	}
	public void setSoId(String soId) {
		this.soId = soId;
	}
	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getCallAccountId() {
		return callAccountId;
	}
	public void setCallAccountId(String callAccountId) {
		this.callAccountId = callAccountId;
	}
	public String getCallContactId() {
		return callContactId;
	}
	public void setCallContactId(String callContactId) {
		this.callContactId = callContactId;
	}
	public String getCallDealId() {
		return callDealId;
	}
	public void setCallDealId(String callDealId) {
		this.callDealId = callDealId;
	}
	public RestCrmCallModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestCrmCallModel(Object callId, Object callToWhom, Object leadName,Object leadId, Object contactName,Object contactId, Object relatedType,Object relatedId,
			Object relatedName, Object callType, Object callStatus, Object callStartDate,Object callStartTime,
			Object callOwner, Object callSubject,
			Object callReminder, Object callPurpose, Object callAgenda, Object createdBy,
			Object createdOn) {
		
		
		super();
		try {
			this.callId = (String) callId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.callToWhom = (String) callToWhom;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.leadName = (String) leadName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.leadId = (String) leadId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.contactName = (String) contactName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.contactId = (String) contactId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.relatedType = (String) relatedType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.relatedId = (String) relatedId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.relatedName = (String) relatedName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.callType = (String) callType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.callStatus = (String) callStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.callStartDate = (String) callStartDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.callStartTime = (String) callStartTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.callOwner = (String) callOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.callSubject = (String) callSubject;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.callReminder = (String) callReminder;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.callPurpose = (String) callPurpose;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.callAgenda = (String) callAgenda;
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
			this.createdOn = (String) createdOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public RestCrmCallModel(Object callId, Object callToWhom, Object leadName,Object contactName, Object relatedType,
			Object relatedName, Object callType, Object callStatus, Object callStartDate,Object callStartTime,
			Object callOwner, Object callSubject, Object callLeadId) {
		
		super();
		try {
			this.callId = (String) callId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.callToWhom = (String) callToWhom;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.leadName = (String) leadName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.contactName = (String) contactName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.relatedType = (String) relatedType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.relatedName = (String) relatedName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.callType = (String) callType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.callStatus = (String) callStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.callStartDate = (String) callStartDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.callStartTime = (String) callStartTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.callOwner = (String) callOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.callSubject = (String) callSubject;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public RestCrmCallModel(Object callId, Object callToWhom, Object relatedType,
				Object relatedName, Object callType, Object callStatus, Object callStartDate,Object callStartTime,
				Object callOwner, Object callSubject) {
			
			super();
		
			
			try {
				this.callId = (String) callId;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				this.callToWhom = (String) callToWhom;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.relatedType = (String) relatedType;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.relatedName = (String) relatedName;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				this.callType = (String) callType;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.callStatus = (String) callStatus;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.callStartDate = (String) callStartDate;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				this.callStartTime = (String) callStartTime;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				this.callOwner = (String) callOwner;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.callSubject = (String) callSubject;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
	


	public String getCallId() {
		return callId;
	}



	public void setCallId(String callId) {
		this.callId = callId;
	}



	
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}

	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	
	public String getRelatedId() {
		return relatedId;
	}
	public void setRelatedId(String relatedId) {
		this.relatedId = relatedId;
	}
	public String getCallToWhom() {
		return callToWhom;
	}



	public void setCallToWhom(String callToWhom) {
		this.callToWhom = callToWhom;
	}



	



	public String getRelatedType() {
		return relatedType;
	}



	public void setRelatedType(String relatedType) {
		this.relatedType = relatedType;
	}



	public String getRelatedName() {
		return relatedName;
	}



	public void setRelatedName(String relatedName) {
		this.relatedName = relatedName;
	}



	public String getCallType() {
		return callType;
	}



	public void setCallType(String callType) {
		this.callType = callType;
	}



	public String getCallStatus() {
		return callStatus;
	}



	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}



	public String getCallStartDate() {
		return callStartDate;
	}



	public void setCallStartDate(String callStartDate) {
		this.callStartDate = callStartDate;
	}



	public String getCallStartTime() {
		return callStartTime;
	}



	public void setCallStartTime(String callStartTime) {
		this.callStartTime = callStartTime;
	}



	public String getCallOwner() {
		return callOwner;
	}



	public void setCallOwner(String callOwner) {
		this.callOwner = callOwner;
	}



	public String getCallSubject() {
		return callSubject;
	}



	public void setCallSubject(String callSubject) {
		this.callSubject = callSubject;
	}



	public String getCallReminder() {
		return callReminder;
	}



	public void setCallReminder(String callReminder) {
		this.callReminder = callReminder;
	}



	public String getCallPurpose() {
		return callPurpose;
	}



	public void setCallPurpose(String callPurpose) {
		this.callPurpose = callPurpose;
	}



	public String getCallAgenda() {
		return callAgenda;
	}



	public void setCallAgenda(String callAgenda) {
		this.callAgenda = callAgenda;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	
	public String getCallLeadId() {
		return callLeadId;
	}
	public void setCallLeadId(String callLeadId) {
		this.callLeadId = callLeadId;
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

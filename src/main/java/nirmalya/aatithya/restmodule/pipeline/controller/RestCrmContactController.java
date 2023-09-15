package nirmalya.aatithya.restmodule.pipeline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmContactDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmContactController {
	Logger logger = LoggerFactory.getLogger(RestCrmContactController.class);
	@Autowired
	RestCrmContactDao contactDao;

	
	
	/**
	 * Post Mapping to Add new Contact
	 *
	 */
	// add

	@PostMapping(value = "/addContact")
	public JsonResponse<Object> addContact(@RequestBody RestContactModel contact) {
		logger.info("Method : addContact starts");

		logger.info("Method : addContact ends");
		return contactDao.addContact(contact);
	}
	
	@RequestMapping(value = "viewContactSearchDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> viewLeadSearchDetails(

			@RequestBody RestContactModel searchContactModel) {
		logger.info("Method : viewContactSearchDetails starts");
		logger.info("VIEWWW" + searchContactModel);
		logger.info("Method : viewContactSearchDetails ends");

		return contactDao.viewContactSearchDetails(searchContactModel);
	}
	
	/*
	 * View pipeline Details
	 *
	 */

	@GetMapping(value = "getAllContact")
	public JsonResponse<List<RestContactModel>> viewAllContact() {
		logger.info("Method : viewAllContactDao starts");

		logger.info("Method : viewAllContactDao ends");

		return contactDao.viewAllContact();
	}
	
	//editContact
	

/**
	 * returns edit editContact
	 *
	 */
	@RequestMapping(value = "/editContact", method = { RequestMethod.GET })
	public JsonResponse<RestContactModel> editContact(@RequestParam String id) {
		logger.info("Method : editContact starts");

		logger.info("Method :editContact ends");
		return contactDao.editContact(id);
	}
	
	@RequestMapping(value = "/viewContact", method = { RequestMethod.GET })
	public JsonResponse<RestContactModel> viewContact(@RequestParam String id) {
		logger.info("Method : viewContact starts");

		logger.info("Method :viewContact ends");
		return contactDao.viewContact(id);
	}
	
	
	//getOwnerList
	
	@RequestMapping(value = "getOwnerList", method = { RequestMethod.GET })
	public List<DropDownModel> getOwnerList() {
		
		logger.info("Method : getOwnerList starts");
		logger.info("Method : getOwnerList ends");
		
		
		return contactDao.getOwnerList();
	}
	
	//getLeadSourceList
	
	@RequestMapping(value = "getLeadSourceList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadSourceList() {
		
		logger.info("Method : getLeadSourceList starts");
		logger.info("Method : getLeadSourceList ends");
		
		return contactDao.getLeadSourceList();
	}
	
	//delete-contact-Details
	
	@RequestMapping(value = "delete-contact-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteContactDetails(@RequestParam String id) {
		logger.info("Method :  deleteContactDetails starts"+id);

		logger.info("Method :  deleteContactDetails ends");
		return contactDao.deleteContactDetails(id);
	}
	
	/*
	 * getAccountNameAutoSearchNewList auto search
	 */
	@GetMapping(value = "getAccountNameAutoSearchNewList")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getAccountNameAutoSearchNewList(
			@RequestParam String id) {
		logger.info("Method : getAccountNameAutoSearchNewList starts");

		logger.info("Method :getAccountNameAutoSearchNewList endss");
		return contactDao.getAccountNameAutoSearchNewList(id);
	}
	//view-rest-LeadTaskInfo
	
			@GetMapping(value = "view-rest-ContactTaskInfo")
			public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> viewContactTaskInfo(@RequestParam String id) {
				logger.info("Method :viewContactTaskInfo starts");

				logger.info("Method :viewContactTaskInfo ends"+id);
				return contactDao.viewContactTaskInfo(id);
			}
	
	//view-rest-LeadCallInfo
	
			@GetMapping(value = "view-rest-ContactCallInfo")
			public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> viewContactCallInfo(@RequestParam String id) {
				logger.info("Method :viewContactCallInfo starts");

				logger.info("Method :viewContactCallInfo ends"+id);
				return contactDao.viewContactCallInfo(id);
			}
			
			//view-rest-LeadMeetingInfo
			@GetMapping(value = "view-rest-ContactMeetingInfo")
			
			public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> viewContactMeetingInfo(@RequestParam String id) {
				logger.info("Method :viewContactMeetingInfo starts");

				logger.info("Method :viewContactMeetingInfo ends"+id);
				return contactDao.viewContactMeetingInfo(id);
			}
			
			//view-rest-LeadCampaignInfo
			
			@GetMapping(value = "view-rest-viewContactCampaignInfo")
			public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> viewContactCampaignInfo(@RequestParam String id) {
				logger.info("Method :viewContactCampaignInfo starts");

				logger.info("Method :viewContactCampaignInfo ends"+id);
				return contactDao.viewContactCampaignInfo(id);

			}
			
			//addNoteDoc
			
			@PostMapping(value = "addContactEmailDoc")
			public ResponseEntity<JsonResponse<Object>> addContactEmailDoc(@RequestBody EmployeeDocumentModel employeeDocumentModel) {
				logger.info("Method : addContactEmailDoc starts");
				logger.info("Method : addContactEmailDoc ends");
				return contactDao.addContactEmailDoc(employeeDocumentModel);
			}
			

}

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
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmLeadsDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmProductModel;

@RestController
@RequestMapping(value = "pipeline")
public class RestCrmLeadsController {

	Logger logger = LoggerFactory.getLogger(RestCrmLeadsController.class);
	@Autowired
	RestCrmLeadsDao restCrmLeadsDao;
	
	/**
	 * 
	 * @return department list
	 */
	
	@RequestMapping(value = "getLeadList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadList() {
		
		logger.info("Method : getLeadList starts");
		logger.info("Method : getLeadList ends");
		
		return restCrmLeadsDao.getLeadList();
	}
	
	@RequestMapping(value = "getindustrylist", method = { RequestMethod.GET })
	public List<DropDownModel> getindustrylist() {
		
		logger.info("Method : getindustrylist starts");
		logger.info("Method : getindustrylist ends");
		
		return restCrmLeadsDao.getindustrylist();
	}
	
	
	@RequestMapping(value = "getRatingList", method = { RequestMethod.GET })
	public List<DropDownModel> getRatingList() {
		
		logger.info("Method : getRatingList starts");
		logger.info("Method : getRatingList ends");
		
		return restCrmLeadsDao.getRatingList();
	}
	
	
	
	@RequestMapping(value = "getDocumentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDocumentList() {
		
		logger.info("Method : getDocumentList starts");
		logger.info("Method : getDocumentList ends");
		
		return restCrmLeadsDao.getDocumentList();
	}
	

	@RequestMapping(value = "viewLeadSearchDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> viewLeadSearchDetails(
			@RequestBody RestCrmLeadsModel searchLeadModel) {
		logger.info("Method : viewLeadSearchDetails starts");
        logger.info("VIEWWW"+searchLeadModel);
		logger.info("Method : viewLeadSearchDetails ends");

		return restCrmLeadsDao.viewLeadSearchDetails(searchLeadModel);
	}

	
	@RequestMapping(value = "getCountry", method = { RequestMethod.GET })
	public List<DropDownModel> getCountry() {
		
		logger.info("Method : getCountry starts");
		logger.info("Method : getCountry ends");
		
		return restCrmLeadsDao.getCountry();
	}
	
	
	@RequestMapping(value = "viewEmailDetailsView", method = { RequestMethod.GET })
	public JsonResponse<RestCrmLeadsModel> viewEmailDetails(@RequestParam String id1,@RequestParam String id2,@RequestParam String id3) {
		logger.info("Method : viewEmailDetails rest starts");

		logger.info("Method :viewEmailDetails rest ends");
		return restCrmLeadsDao.viewEmailDetails(id1,id2,id3);
	}
	
	
	@RequestMapping(value = "getLeadStatusList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadStatusList() {
		
		logger.info("Method : getLeadStatusList starts");
		logger.info("Method : getLeadStatusList ends");
		
		return restCrmLeadsDao.getLeadStatusList();
	}
	
	
	//addNoteDoc
	
	@PostMapping(value = "addNoteDoc")
	public ResponseEntity<JsonResponse<Object>> addNoteDoc(@RequestBody EmployeeDocumentModel employeeDocumentModel) {
		logger.info("Method : addNoteDoc starts");
		logger.info("Method : addNoteDoc ends");
		return restCrmLeadsDao.addNoteDoc(employeeDocumentModel);
	}
	
	
	
	@RequestMapping(value = "getStateLists",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getstateListNew(@RequestParam String id) {
		logger.info("Method : getstateList starts");
		logger.info("Method : getstateList ends");
		return restCrmLeadsDao.getcuststateListNew(id);
	}
	
	
	/*
	 * for All  Add leadDetails
	 */
	@RequestMapping(value="rest-add-lead-details" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddLeadDetails(@RequestBody RestCrmLeadsModel restCrmLeadsModel) 
	{
		logger.info("Method : restAddLeadDetails starts");
		
		logger.info("restAddLeadDetails api value-----------------------------"+restCrmLeadsModel);
		
		logger.info("Method : restAddLeadDetails ends");
		
		return restCrmLeadsDao.restAddLeadDetails(restCrmLeadsModel);
	}
	/*
	 * for view
	 */
	@RequestMapping(value="viewLeadData" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> restViewData(){
		logger.info("Method: restViewData View Start");
		
		logger.info("Method: restViewData ends");
		return restCrmLeadsDao.viewLeadData();
	}
	
	
	
	///edit
		@GetMapping(value = "edit-rest-LeadInfo")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> editLeadInfo(@RequestParam String id) {
			logger.info("Method :editLeadInfo starts");

			logger.info("Method :editLeadInfo ends"+id);
			return restCrmLeadsDao.editLeadInfo(id);

		}
		
		//view-rest-LeadInfo
		
		@GetMapping(value = "view-rest-LeadInfo")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadInfo(@RequestParam String id) {
			logger.info("Method :viewLeadInfo starts");

			logger.info("Method :viewLeadInfo ends"+id);
			return restCrmLeadsDao.viewLeadInfo(id);

		}
		
		//convertToAccContDeal
		

	@PostMapping(value = "/convertToAccContDeal")
		public JsonResponse<Object> convertToAccContDeal(@RequestBody RestCrmLeadsModel leadModel) {
		logger.info("Method : convertToAccContDeal starts");

		logger.info("Method : convertToAccContDeal ends");
		return restCrmLeadsDao.convertToAccContDeal(leadModel);
	}
		
		//view-rest-LeadNoteInfo
		
		@GetMapping(value = "view-rest-LeadNoteInfo")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadNoteInfo(@RequestParam String id) {
			logger.info("Method :viewLeadNoteInfo starts");

			logger.info("Method :viewLeadNoteInfo ends"+id);
			return restCrmLeadsDao.viewLeadNoteInfo(id);

		}
		
		//view-rest-LeadMailInfo
		
		
		@GetMapping(value = "view-rest-LeadMailInfo")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadMailInfo(@RequestParam String id) {
			logger.info("Method :viewLeadMailInfo starts");

			logger.info("Method :viewLeadMailInfo ends"+id);
			return restCrmLeadsDao.viewLeadMailInfo(id);

		}
		
		//view-rest-LeadProductInfo
		
		@GetMapping(value = "view-rest-LeadProductInfo")
		public ResponseEntity<JsonResponse<List<RestCrmProductModel>>> viewLeadProductInfo(@RequestParam String id) {
			logger.info("Method :viewLeadProductInfo starts");

			logger.info("Method :viewLeadProductInfo ends"+id);
			return restCrmLeadsDao.viewLeadProductInfo(id);

		}
		
		//view-rest-LeadCampaignInfo
		
		@GetMapping(value = "view-rest-LeadCampaignInfo")
		public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> viewLeadCampaignInfo(@RequestParam String id) {
			logger.info("Method :viewLeadCampaignInfo starts");

			logger.info("Method :viewLeadCampaignInfo ends"+id);
			return restCrmLeadsDao.viewLeadCampaignInfo(id);

		}
		
		//view-rest-LeadTaskInfo
		
		@GetMapping(value = "view-rest-LeadTaskInfo")
		public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> viewLeadTaskInfo(@RequestParam String id) {
			logger.info("Method :viewLeadTaskInfo starts");

			logger.info("Method :viewLeadTaskInfo ends"+id);
			return restCrmLeadsDao.viewLeadTaskInfo(id);
		}
		
		//view-rest-LeadCallInfo
		
		@GetMapping(value = "view-rest-LeadCallInfo")
		public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> viewLeadCallInfo(@RequestParam String id) {
			logger.info("Method :viewLeadCallInfo starts");

			logger.info("Method :viewLeadCallInfo ends"+id);
			return restCrmLeadsDao.viewLeadCallInfo(id);
		}
		
		//view-rest-LeadActivityInfo
		
		@GetMapping(value = "view-rest-LeadActivityInfo")
		public ResponseEntity<JsonResponse<List<RestCrmActivityModel>>> viewLeadActivityInfo(@RequestParam String id) {
			logger.info("Method :viewLeadActivityInfo starts");

			logger.info("Method :viewLeadActivityInfo ends"+id);
			return restCrmLeadsDao.viewLeadActivityInfo(id);
		}
		
		//view-rest-LeadMeetingInfo
		
		@GetMapping(value = "view-rest-LeadMeetingInfo")
		public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> viewLeadMeetingInfo(@RequestParam String id) {
			logger.info("Method :viewLeadMeetingInfo starts");

			logger.info("Method :viewLeadMeetingInfo ends"+id);
			return restCrmLeadsDao.viewLeadMeetingInfo(id);
		}
		
	////delete
		@RequestMapping(value = "delete-Details", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteDetails(@RequestParam String id) {
			logger.info("Method :  deleteDetails starts"+id);

			logger.info("Method :  deleteDetails ends");
			return restCrmLeadsDao. deleteDetails(id);
		}
		
		//taskadd
		
		
		
		@PostMapping(value = "saveleadtask")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadtask(
				@RequestBody List<RestCrmLeadsModel> leadTask) {
			logger.info("Method : saveleadtask starts");
			
			logger.info("Method : saveleadtask ends");
			return restCrmLeadsDao.saveleadtask(leadTask);
		}
		
		
		//saveleadtags
		
		@PostMapping(value = "saveleadtags")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadtags(
				@RequestBody List<RestCrmLeadsModel> leadTags) {
			logger.info("Method : saveleadtags starts");
			
			logger.info("Method : saveleadtags ends");
			return restCrmLeadsDao.saveleadtags(leadTags);
		}
		
		
		//saveleadMacro
		
		@PostMapping(value = "saveleadMacro")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadMacro(
				@RequestBody List<RestCrmLeadsModel> leadMacro) {
			logger.info("Method : saveleadMacro starts");
			
			logger.info("Method : saveleadMacro ends");
			return restCrmLeadsDao.saveleadMacro(leadMacro);
		}
		
		//saveleadCampaign
		@PostMapping(value = "saveleadCampaign")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadCampaign(
				@RequestBody List<RestCrmLeadsModel> leadCampaign) {
			logger.info("Method : saveleadCampaign starts");
			
			logger.info("Method : saveleadCampaign ends");
			return restCrmLeadsDao.saveleadCampaign(leadCampaign);
		}
		
		
		
		@PostMapping(value = "saveleadmails")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadmail(
				@RequestBody List<RestCrmLeadsModel> leadTask) {
			logger.info("Method : saveleadmail starts");
			
			logger.info("Method : saveleadmail ends");
			return restCrmLeadsDao.saveleadmail(leadTask);
		}
		
		@RequestMapping(value = "rest-addTask-Leads", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> userLaundryItemService(
				@RequestBody RestCrmTaskModel restItemRequisitonModel) {
			logger.info("Method : RestCRMLeadTaskModel starts");
			logger.info("Method : RestCRMLeadTaskModel ends");
			return restCrmLeadsDao.addItemRequisition(restItemRequisitonModel);
		}
		
		/*
		 * for All  Add leadDetails
		 */
		@RequestMapping(value="rest-add-massUpdate" , method={RequestMethod.POST})
		public ResponseEntity<JsonResponse<Object>> restAddMassUpdate(@RequestBody RestCrmLeadsModel assignSkill) 
		{
			logger.info("Method : restAddMassUpdate starts");
			
			logger.info("Method : restAddMassUpdate ends");
			
			return restCrmLeadsDao.restAddMassUpdate(assignSkill);
		}
		
		///viewProductDetailsView  (view of products)
		
		
		@GetMapping(value = "viewProductDetailsView")
		public ResponseEntity<JsonResponse<List<RestCrmProductModel>>> viewProductDetailsView(@RequestParam String id, @RequestParam String id2,@RequestParam String pageType,@RequestParam String productCode) {
			logger.info("Method :viewProductDetailsView starts");

			logger.info("Method :viewProductDetailsView ends"+id);
			return restCrmLeadsDao.viewProductDetailsView(id,id2,pageType,productCode);
		}
		
		
		//saveCRMProductAdd
		@PostMapping(value = "saveCRMProductAdd")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveCRMProductAdd(@RequestParam String id,
				@RequestBody List<RestCrmLeadsModel> leadTags) {
			logger.info("Method : saveCRMProductAdd starts");
			
			logger.info("Method : saveCRMProductAdd ends");
			return restCrmLeadsDao.saveCRMProductAdd(id,leadTags);
		}
		
		/*//getNameAutoSearchProduct
		
		@GetMapping(value = "getNameAutoSearchProduct")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchProduct(
				@RequestParam String id,@RequestParam String leadId,@RequestParam String assigRow) {
			logger.info("Method : getNameAutoSearchProduct starts");

			logger.info("Method :getNameAutoSearchProduct endss");
			return restCrmLeadsDao.getNameAutoSearchProduct(id,leadId,assigRow);
		}*/
		
		//viewProductSearchView
		
		@GetMapping(value = "viewProductSearchView")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> viewProductSearchView(@RequestParam String searchVal, @RequestParam String id, @RequestParam String assigRow,@RequestParam String  pageType) {
			logger.info("Method :viewProductSearchView starts");

			logger.info("Method :searchVal ends"+searchVal);
			return restCrmLeadsDao.viewProductSearchView(searchVal,id,assigRow,pageType);
		}
		
		
		
}

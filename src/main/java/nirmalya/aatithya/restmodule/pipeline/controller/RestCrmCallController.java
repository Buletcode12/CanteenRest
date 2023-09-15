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


import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmContactDao;
import nirmalya.aatithya.restmodule.pipeline.dao.PipelineDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCallDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineLogModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineSmsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestStagesDetailModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmCallController {
	Logger logger = LoggerFactory.getLogger(RestCrmCallController.class);
	@Autowired
	RestCrmCallDao restCrmCallDao;

	
	/**
	 * Post Mapping to Add new addDeal
	 *
	 */
	// add

	@PostMapping(value = "/addCall")
	public JsonResponse<Object> addCall(@RequestBody RestCrmCallModel call) {
		logger.info("Method : addCall starts");

		logger.info("Method : addCall ends");
		return restCrmCallDao.addCall(call);
	}
	
	
	//getLeadNameList
	
	/*@RequestMapping(value = "getLeadNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadNameList() {
		
		logger.info("Method : getLeadNameList starts");
		logger.info("Method : getLeadNameList ends");
		
		return restCrmTaskDao.getLeadNameList();
	}*/
	
	
	//restViewTaskdetails

	
	//editTaskInfo
			
	@GetMapping(value = "editCallInfo")
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> editCallInfo(@RequestParam String id) {
		logger.info("Method :editCallInfo starts");

		logger.info("Method :editCallInfo ends"+id);
		return restCrmCallDao.editCallInfo(id);

	}
	
	//delete-task-Details
	
	@RequestMapping(value = "delete-call-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCallDetails(@RequestParam String id) {
		logger.info("Method :  deleteCallDetails starts"+id);

		logger.info("Method :  deleteCallDetails ends");
		return restCrmCallDao.deleteCallDetails(id);
	}
	
	
	
	

	/*
	 * for view
	 */
	@RequestMapping(value="restViewCallDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> restViewCallDetails(){
		logger.info("Method: restViewCallDetails View Start");
		
		logger.info("Method: restViewCallDetails ends");
		return restCrmCallDao.restViewCallDetails();
	}
	
	/*
	 * auto search 
	 */

	@GetMapping(value = "getNameAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchList(
			@RequestParam String id) {
		logger.info("Method : getNameAutoSearchList starts");

		logger.info("Method :getNameAutoSearchList endss");
		return restCrmCallDao.getNameAutoSearchList(id);
	}
	
	@GetMapping(value = "getNameAutoSearchListContact")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchListContact(
			@RequestParam String id) {
		logger.info("Method : getNameAutoSearchListContact starts");

		logger.info("Method :getNameAutoSearchListContact endss");
		return restCrmCallDao.getNameAutoSearchListContact(id);
	}
	
	@GetMapping(value = "getNameAutoSearchDetailsRelateds")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchDetailsRelated(@RequestParam String relatedType,
			@RequestParam String searchVal) {
		logger.info("Method : getNameAutoSearchDetailsRelated starts");

		logger.info("Method :getNameAutoSearchDetailsRelated endss");
		return restCrmCallDao.getNameAutoSearchDetailsRelated(relatedType,searchVal);
	}

}

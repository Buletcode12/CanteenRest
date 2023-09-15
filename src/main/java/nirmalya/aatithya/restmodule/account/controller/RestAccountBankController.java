package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.RestAccountBankDao;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmContactDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCustomerDao;
import nirmalya.aatithya.restmodule.pipeline.dao.PipelineDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCallDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCampaignDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmVendorDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;
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
@RequestMapping(value = "account")
public class RestAccountBankController {
	Logger logger = LoggerFactory.getLogger(RestAccountBankController.class);
	@Autowired
	RestAccountBankDao restAccountBankDao;

	/*
	 * for Add Bank 
	 */
	@RequestMapping(value="addBank" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addBank(@RequestBody RestAccountBankModel bankModel) 
	{
		logger.info("Method : addBank starts");
		
		System.out.println("bankModel---------------------"+bankModel);
		
		logger.info("Method : addBank ends");
		
		return restAccountBankDao.addBank(bankModel);
	}
	

	
	
	
	
	//restViewVendorDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewBankDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAccountBankModel>>> restViewBankDetails(){
		logger.info("Method: restViewBankDetails View Start");
		System.out.println("rest bank controller-------------------------------------------------------------1111111111");
		logger.info("Method: restViewBankDetails ends");
		return restAccountBankDao.restViewBankDetails();
	}
	
	
	//editBankInfo

	
	@GetMapping(value = "editBankInfo")
	public ResponseEntity<JsonResponse<List<RestAccountBankModel>>> editBankInfo(@RequestParam String id) {
		logger.info("Method :editBankInfo starts");

		logger.info("Method :editBankInfo ends"+id);
		return restAccountBankDao.editBankInfo(id);

	}
	
	
	//delete-vendor-Details
	
	@RequestMapping(value = "deleteBankDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBankDetails(@RequestParam String id) {
		logger.info("Method :  deleteBankDetails starts"+id);

		logger.info("Method :  deleteBankDetails ends");
		return restAccountBankDao.deleteBankDetails(id);
	}
	
	
	//getVendorNameAutoSearch
	/*@GetMapping(value = "getVendorNameAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorNameAutoSearch(
			@RequestParam String id) {
		logger.info("Method : getVendorNameAutoSearch starts");

		logger.info("Method :getVendorNameAutoSearch endss");
		return restCrmVendorDao.getVendorNameAutoSearch(id);
	}*/
}


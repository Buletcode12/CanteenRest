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
import nirmalya.aatithya.restmodule.account.dao.RestAccountBranchDao;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
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
public class RestAccountBranchController {
	Logger logger = LoggerFactory.getLogger(RestAccountBranchController.class);
	@Autowired
	RestAccountBranchDao restAccountBranchDao;

	/*
	 * for Add Bank
	 */
	@RequestMapping(value="addBranch" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addBranch(@RequestBody RestAccountBranchModel branchModel) 
	{
		logger.info("Method : branchModel starts");
		
		System.out.println("branchModel---------------------"+branchModel);
		
		logger.info("Method : addBranch ends");
		
		return restAccountBranchDao.addBranch(branchModel);
	}
	

	
	
	
	
	//restViewVendorDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewBranchDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> restViewBranchDetails(){
		logger.info("Method: restViewBranchDetails View Start");
		System.out.println("rest bank controller-------------------------------------------------------------1111111111");
		logger.info("Method: restViewBranchDetails ends");
		return restAccountBranchDao.restViewBranchDetails();
	}
	
	
	//editBankInfo

	
	@GetMapping(value = "editBranchInfo")
	public ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> editBranchInfo(@RequestParam String id) {
		logger.info("Method :editBranchInfo starts");

		logger.info("Method :editBranchInfo ends"+id);
		return restAccountBranchDao.editBranchInfo(id);

	}
	
	
	//delete-vendor-Details
	
	@RequestMapping(value = "deleteBranchDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBranchDetails(@RequestParam String id) {
		logger.info("Method :  deleteBranchDetails starts"+id);

		logger.info("Method :  deleteBranchDetails ends");
		return restAccountBranchDao.deleteBranchDetails(id);
	}
	
	@RequestMapping(value = "getBankList", method = { RequestMethod.GET })
	public List<DropDownModel> getBankList() {
		
		logger.info("Method : getBankList starts");
		logger.info("Method : getBankListends");
		
		return restAccountBranchDao.getBankList();
	}
	
	@RequestMapping(value = "headTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> headTypeList() {
		
		logger.info("Method : headTypeList starts");
		logger.info("Method : headTypeList");
		
		return restAccountBranchDao.headTypeList();
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


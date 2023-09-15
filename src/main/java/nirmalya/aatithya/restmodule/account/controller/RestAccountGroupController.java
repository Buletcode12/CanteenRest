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
import nirmalya.aatithya.restmodule.account.dao.RestAccountGroupDao;
import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestOrganizationMasterModel;
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
public class RestAccountGroupController {
	Logger logger = LoggerFactory.getLogger(RestAccountGroupController.class);
	@Autowired
	RestAccountGroupDao restAccountGroupDao;
	

	//getAccountTreeDetails
	/*
	 * 
	 * getAccountTree
	 * 
	 */
	@RequestMapping(value = "getAccountTreeDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getActivityDetails(String getAccountTreeDetails) {
		logger.info("Method : getAccountTreeDetails starts");
		logger.info("Method : getAccountTreeDetails ends");
		return restAccountGroupDao.getAccountTreeDetails("getAccountTreeDetails");
	}

	//restAddParent
	
	/*
	 * Post Mapping to Add Parent
	 *
	 */
	 
	@RequestMapping(value = "restAddParent", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddParent(@RequestBody DataSetAccountTree table) {
		logger.info("Method : restAddParent starts");
		System.out.println("restAddParent data :-----------------------------11111111111 "+table);
		logger.info("Method : restAddParent ends");
		// System.out.println("restAddLeavePeriod data : "+table);
		return restAccountGroupDao.restAddParent(table);
	}
	
	//restAddChild
	
	/*
	 * Post Mapping to Add Child
	 *
	 */
	 
	@RequestMapping(value = "restAddChild", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddChild(@RequestBody DataSetAccountTree table) {
		logger.info("Method : restAddChild starts");
		System.out.println("restAddChild data :-----------------------------11111111111 "+table);
		logger.info("Method : restAddChild ends");
		// System.out.println("restAddLeavePeriod data : "+table);
		return restAccountGroupDao.restAddChild(table);
	}
}


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
import nirmalya.aatithya.restmodule.account.dao.RestAccountDao;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
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
public class RestAccountController {
	Logger logger = LoggerFactory.getLogger(RestAccountController.class);
	@Autowired
	RestAccountDao restAccountDao;

	/*
	 * for Add Bank
	 */
	@RequestMapping(value = "addAccount", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAccount(@RequestBody RestAccountModel accountModel) {
		logger.info("Method : addAccount starts");

		System.out.println("addAccount---------------------" + accountModel);

		logger.info("Method : addAccount ends");

		return restAccountDao.addAccount(accountModel);
	}

	// restViewAccountDetails

	/*
	 * for view
	 */
	@RequestMapping(value = "restViewAccountDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestAccountModel>>> restViewAccountDetails() {
		logger.info("Method: restViewAccountDetails View Start");
		System.out.println("rest Account controller");
		logger.info("Method: restViewAccountDetails ends");
		return restAccountDao.restViewAccountDetails();
	}

	// editBankInfo

	@GetMapping(value = "editAccountInfo")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editAccountInfo(@RequestParam String id) {
		logger.info("Method :editAccountInfo starts");

		logger.info("Method :editAccountInfo ends" + id);
		return restAccountDao.editAccountInfo(id);

	}

	/*
	 * @GetMapping(value = "editAccountInfo") public
	 * ResponseEntity<JsonResponse<AccountJournalVoucherModel>>
	 * editAccountInfo(@RequestParam String id) {
	 * logger.info("Method :editAccountInfo starts");
	 * 
	 * logger.info("Method :editAccountInfo ends" + id); return
	 * restAccountDao.editAccountInfo(id);
	 * 
	 * }
	 */

	// delete-account-Details

	@RequestMapping(value = "deleteAccountDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAccountDetails(@RequestParam String id) {
		logger.info("Method :  deleteAccountDetails starts" + id);

		logger.info("Method :  deleteAccountDetails ends");
		return restAccountDao.deleteAccountDetails(id);
	}

}

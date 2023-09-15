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
import nirmalya.aatithya.restmodule.account.dao.RestContraVoucherDao;
import nirmalya.aatithya.restmodule.account.dao.RestJournalVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
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
public class RestJournalVoucherController {
	Logger logger = LoggerFactory.getLogger(RestJournalVoucherController.class);
	@Autowired
	RestJournalVoucherDao restJournalVoucherDao;

	@RequestMapping(value = "addJournalVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveJournalVoucher(
			@RequestBody List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : saveJournalVoucher starts");
		System.out.println("===>>>"+journalVoucherModel);
		logger.info("Method : saveJournalVoucher ends");
		return restJournalVoucherDao.addJournalVoucher(journalVoucherModel);
	}

//restViewJournalVoucher

	@RequestMapping(value = "restViewJournalVoucher", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> restViewJournalVoucher() {
		logger.info("Method: restViewJournalVoucher View Start");

		logger.info("Method: restViewJournalVoucher ends");
		return restJournalVoucherDao.restViewJournalVoucher();
	}

	// deleteJournalDetails

	@RequestMapping(value = "deleteJournalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(@RequestParam String id) {
		logger.info("Method :  deleteJournalDetails starts" + id);

		logger.info("Method :  deleteJournalDetails ends");
		return restJournalVoucherDao.deleteJournalDetails(id);
	}

	// approveJournalDetails
	@RequestMapping(value = "approveJournalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveJournalDetails(@RequestParam String id,String userId) {
		logger.info("Method :  approveJournalDetails starts" + id);

		logger.info("Method :  approveJournalDetails ends");
		return restJournalVoucherDao.approveJournalDetails(id,userId);
	}
	// rejectJournalDetails

	@RequestMapping(value = "rejectJournalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> rejectJournalDetails(@RequestParam String id,String userId) {
		logger.info("Method :  rejectJournalDetails starts" + id);

		logger.info("Method :  rejectJournalDetails ends");
		return restJournalVoucherDao.rejectJournalDetails(id,userId);
	}

	// returnJournalDetails
	@RequestMapping(value = "returnJournalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> returnJournalDetails(@RequestParam String id) {
		logger.info("Method :  returnJournalDetails starts" + id);

		logger.info("Method :  returnJournalDetails ends");
		return restJournalVoucherDao.returnJournalDetails(id);
	}

	// editAccountInfo

	@GetMapping(value = "editJournalInfo")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editJournalInfo(@RequestParam String id) {
		logger.info("Method :editJournalInfo starts");

		logger.info("Method :editJournalInfo ends" + id);
		return restJournalVoucherDao.editJournalInfo(id);

	}

	
	@RequestMapping(value = "getJournalvouchernumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getvouchernumber() {
		logger.info("Method: getvouchernumber View Start");

		logger.info("Method: getvouchernumber ends");
		return restJournalVoucherDao.getvouchernumber();
	}
	
	
	/*
	 * getDebitAccountSearch auto search
	 */
	@GetMapping(value = "getDebitJournalAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(
			@RequestParam String id) {
		logger.info("Method : getDebitAccountSearch starts");

		logger.info("Method :getDebitAccountSearch endss");
		return restJournalVoucherDao.getDebitAccountSearch(id);
	}
	
	/*
	 * getCreditAccountSearch auto search
	 */
	@GetMapping(value = "getCreditJournalAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getCreditAccountSearch(
			@RequestParam String id) {
		logger.info("Method : getCreditAccountSearch starts");

		logger.info("Method :getCreditAccountSearch endss");
		return restJournalVoucherDao.getCreditAccountSearch(id);
	}
}

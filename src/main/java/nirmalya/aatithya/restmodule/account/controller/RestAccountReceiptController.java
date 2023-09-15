package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountReceiptDao;
import nirmalya.aatithya.restmodule.account.dao.RestJournalVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountReceiptController {
	Logger logger = LoggerFactory.getLogger(RestAccountReceiptController.class);
	@Autowired
	RestAccountReceiptDao restReceiptDao;

	@RequestMapping(value = "addReceiptJournalVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveJournalVoucher(
			@RequestBody List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : addReceiptJournalVoucher starts");
		logger.info("Method : addReceiptJournalVoucher ends");
		return restReceiptDao.addReceiptVoucher(journalVoucherModel);
	}

//restViewJournalVoucher

	@RequestMapping(value = "viewReceiptVoucher", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> restViewJournalVoucher() {
		logger.info("Method: viewReceiptVoucher View Start");

		logger.info("Method: viewReceiptVoucher ends");
		return restReceiptDao.viewReceiptVoucher();
	}

	// editAccountInfo

	@GetMapping(value = "editReceiptInfo")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editJournalInfo(@RequestParam String id) {
		logger.info("Method :editJournalInfo starts");

		logger.info("Method :editJournalInfo ends" + id);
		return restReceiptDao.editReceiptInfo(id);

	}

	@RequestMapping(value = "getReceiptvoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber() {
		logger.info("Method: voucherNumber View Start");

		logger.info("Method: voucherNumber ends");
		return restReceiptDao.voucherNumber();
	}

	/*
	 * getDebitAccountSearch auto search
	 */
	@GetMapping(value = "getDebitReceiptAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(@RequestParam String id) {
		logger.info("Method : getDebitAccountSearch starts");

		logger.info("Method :getDebitAccountSearch endss");
		return restReceiptDao.getDebitAccountSearch(id);
	}

	/*
	 * getCreditAccountSearch auto search
	 */
	@GetMapping(value = "getCreditReceiptAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getCreditAccountSearch(@RequestParam String id) {
		logger.info("Method : getCreditAccountSearch starts");

		logger.info("Method :getCreditAccountSearch endss");
		return restReceiptDao.getCreditAccountSearch(id);
	}

	// deleteJournalDetails

	@RequestMapping(value = "deleteReceiptDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(@RequestParam String id) {
		logger.info("Method :  deleteJournalDetails starts" + id);

		logger.info("Method :  deleteJournalDetails ends");
		return restReceiptDao.deleteJournalDetails(id);
	}
}

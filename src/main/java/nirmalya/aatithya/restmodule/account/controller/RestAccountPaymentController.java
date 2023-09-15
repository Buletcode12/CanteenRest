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

import nirmalya.aatithya.restmodule.account.dao.RestPaymentVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountPaymentController {
	Logger logger = LoggerFactory.getLogger(RestAccountPaymentController.class);
	@Autowired
	RestPaymentVoucherDao restPaymentVoucherDao;
	
	
	
	@RequestMapping(value = "addPaymentVoucher", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPaymentVoucher(
			@RequestBody List<AccountJournalVoucherModel> addPaymentVoucher) {
		logger.info("Method : addPaymentVoucher starts");
		System.out.println("===>>>"+addPaymentVoucher);
		logger.info("Method : addPaymentVoucher ends");
		return restPaymentVoucherDao.addPaymentVoucher(addPaymentVoucher);
	}
		
	//restViewContraVouDetails
	
	

		@RequestMapping(value = "restViewPaymentDetails", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> restViewJournalVoucher() {
			logger.info("Method: restViewJournalVoucher View Start");

			logger.info("Method: restViewJournalVoucher ends");
			return restPaymentVoucherDao.restViewPaymentDetails();
		}
	
	
	//editContraInfo

	
	@GetMapping(value = "editPaymentInfo")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editPaymentInfo(@RequestParam String id) {
		logger.info("Method :editPaymentInfo starts");

		logger.info("Method :editPaymentInfo ends" + id);
		return restPaymentVoucherDao.editPaymentInfo(id);

	}
	
	@RequestMapping(value = "getPaymentvoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber() {
		logger.info("Method: voucherNumber View Start");

		logger.info("Method: voucherNumber ends");
		return restPaymentVoucherDao.voucherNumber();
	}
	
	/*
	 * getDebitAccountSearch auto search
	 */
	@GetMapping(value = "getDebitPaymentAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(
			@RequestParam String id) {
		logger.info("Method : getDebitAccountSearch starts");

		logger.info("Method :getDebitAccountSearch endss");
		return restPaymentVoucherDao.getDebitAccountSearch(id);
	}
	
	/*
	 * getCreditAccountSearch auto search
	 */
	@GetMapping(value = "getCreditPaymentAccountSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getCreditAccountSearch(
			@RequestParam String id) {
		logger.info("Method : getCreditAccountSearch starts");

		logger.info("Method :getCreditAccountSearch endss");
		return restPaymentVoucherDao.getCreditAccountSearch(id);
	}
	
	// deleteJournalDetails

		@RequestMapping(value = "deletePaymentDetails", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(@RequestParam String id) {
			logger.info("Method :  deleteJournalDetails starts" + id);

			logger.info("Method :  deleteJournalDetails ends");
			return restPaymentVoucherDao.deleteJournalDetails(id);
		}
}

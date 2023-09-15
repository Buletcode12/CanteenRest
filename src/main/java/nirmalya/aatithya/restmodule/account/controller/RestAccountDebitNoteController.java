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

import nirmalya.aatithya.restmodule.account.dao.RestAccountDebitNoteDao;
import nirmalya.aatithya.restmodule.account.model.AccountCreditNoteRestModel;
import nirmalya.aatithya.restmodule.account.model.RestPurchaseItemModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountDebitNoteController {
	Logger logger = LoggerFactory.getLogger(RestAccountDebitNoteController.class);
	@Autowired
	RestAccountDebitNoteDao debitNoteDao;
	
	
	@RequestMapping(value = "getPurchaseorderList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getorderList(@RequestParam String id) {
		logger.info("Method : getorderList starts");
		logger.info("Method : getorderList ends");
		return debitNoteDao.getorderList(id);
	}

	@RequestMapping(value = "getPurchaseProductList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProductList(@RequestParam String id) {
		logger.info("Method : getProductList starts");
		logger.info("Method : getProductList ends");
		return debitNoteDao.getProductList(id);
	}
	
	@GetMapping(value = "getDebitLedgerList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDebitLedgerList(@RequestParam String id) {
		logger.info("Method : getDebitLedgerList starts");

		logger.info("Method :getDebitLedgerList endss");
		return debitNoteDao.getDebitLedgerList(id);
	}

	@RequestMapping(value = "getPurchaseProductDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPurchaseItemModel>>> getProductDetails(@RequestParam String id,
			@RequestParam String pid) {
		logger.info("Method : getProductDetails starts");
		logger.info("Method : getProductDetails ends");
		return debitNoteDao.getProductDetails(id, pid);
	}

	@PostMapping(value = "addDebitNote")
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> addDebitNote(
			@RequestBody List<AccountCreditNoteRestModel> addCreditNote) {
		logger.info("Method :addDebitNote starts");
		System.out.println("adddddddd" + addCreditNote);
		logger.info("Method :addDebitNote endss");
		return debitNoteDao.addDebitNote(addCreditNote);
	}

	// creditNoteView

	@RequestMapping(value = "debitNoteView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> debitNoteView(@RequestParam String userId) {
		logger.info("Method: debitNoteView Start");

		logger.info("Method: debitNoteView ends");
		return debitNoteDao.debitNoteView(userId);
	}
	
	@GetMapping(value = "viewDebitNote")
	public ResponseEntity<JsonResponse<AccountCreditNoteRestModel>> viewDebitNote(@RequestParam String id) {
		logger.info("Method :viewDebitNote starts");

		logger.info("Method :viewDebitNote ends"+id);
		return debitNoteDao.viewDebitNote(id);

	}
	
	

	@RequestMapping(value = "getDebitNotevoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber() {
		logger.info("Method: voucherNumber View Start");

		logger.info("Method: voucherNumber ends");
		return debitNoteDao.voucherNumber();
	}
}

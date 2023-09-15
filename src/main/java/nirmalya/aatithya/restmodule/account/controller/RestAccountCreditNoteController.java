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

import nirmalya.aatithya.restmodule.account.dao.RestAccountCreditNoteDao;
import nirmalya.aatithya.restmodule.account.model.AccountCreditNoteRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.ItemShoukeenModel;
import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountCreditNoteController {
	Logger logger = LoggerFactory.getLogger(RestAccountCreditNoteController.class);
	@Autowired
	RestAccountCreditNoteDao creditNoteDao;

	@RequestMapping(value = "getorderList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getorderList(@RequestParam String id) {
		logger.info("Method : getorderList starts");
		logger.info("Method : getorderList ends");
		return creditNoteDao.getorderList(id);
	}
	
	@GetMapping(value = "getCreditLedgerList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCreditLedgerList(@RequestParam String id) {
		logger.info("Method : getCreditLedgerList starts");

		logger.info("Method :getCreditLedgerList endss");
		return creditNoteDao.getCreditLedgerList(id);
	}

	@RequestMapping(value = "getProductList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProductList(@RequestParam String id) {
		logger.info("Method : getProductList starts");
		logger.info("Method : getProductList ends");
		return creditNoteDao.getProductList(id);
	}

	@RequestMapping(value = "getProductDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ItemShoukeenModel>>> getProductDetails(@RequestParam String id,
			@RequestParam String pid) {
		logger.info("Method : getProductDetails starts");
		logger.info("Method : getProductDetails ends");
		return creditNoteDao.getProductDetails(id, pid);
	}

	@PostMapping(value = "addCreditNote")
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> addDealerOrderNew(
			@RequestBody List<AccountCreditNoteRestModel> addCreditNote) {
		logger.info("Method :addDealerOrderNew starts");
		System.out.println("adddddddd" + addCreditNote);
		logger.info("Method :addDealerOrderNew endss");
		return creditNoteDao.addCreditNote(addCreditNote);
	}

	// creditNoteView

	@RequestMapping(value = "creditNoteView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> creditNoteView(@RequestParam String userId) {
		logger.info("Method: creditNoteView Start");

		logger.info("Method: creditNoteView ends");
		return creditNoteDao.creditNoteView(userId);
	}
	
	
	@GetMapping(value = "viewCreditNote")
	public ResponseEntity<JsonResponse<AccountCreditNoteRestModel>> viewCreditNote(@RequestParam String id) {
		logger.info("Method :viewCreditNote starts");

		logger.info("Method :viewCreditNote ends"+id);
		return creditNoteDao.viewCreditNote(id);

	}
	
	
	@RequestMapping(value = "getCreditNotevoucherNumber", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber() {
		logger.info("Method: voucherNumber View Start");

		logger.info("Method: voucherNumber ends");
		return creditNoteDao.voucherNumber();
	}

}

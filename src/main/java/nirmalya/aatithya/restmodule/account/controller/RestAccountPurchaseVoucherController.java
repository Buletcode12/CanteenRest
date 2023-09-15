package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestPurchaseVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseOrderRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountPurchaseVoucherController {
	Logger logger = LoggerFactory.getLogger(RestAccountPurchaseVoucherController.class);
	@Autowired
	RestPurchaseVoucherDao restPurchaseVoucherDao;
	
	
	@RequestMapping(value = "rest-viewPurchaseVoucher", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> viewPurchaseOrder(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :viewPurchaseOrder startssssssssssssssssss");

		logger.info("Method :viewPurchaseOrder endss");
		return restPurchaseVoucherDao.viewPurchaseVoucher(org,orgDiv);

	}
	
	@GetMapping(value = "viewPurchaseVoucher")
	public ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> viewPurchaseVoucher(@RequestParam String id) {
		logger.info("Method :viewPurchaseVoucher starts");

		logger.info("Method :viewPurchaseVoucher ends" + id);
		return restPurchaseVoucherDao.viewPurchaseVoucher(id);

	}
}

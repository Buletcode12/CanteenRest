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

import nirmalya.aatithya.restmodule.account.dao.RestSalesVoucherDao;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseOrderRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountSalesVoucherController {
	Logger logger = LoggerFactory.getLogger(RestAccountSalesVoucherController.class);
	@Autowired
	RestSalesVoucherDao restSalesVoucherDao;
	
	
	@RequestMapping(value = "rest-viewSalesVoucher", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> viewPurchaseOrder(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method :viewPurchaseOrder startssssssssssssssssss");

		logger.info("Method :viewPurchaseOrder endss");
		return restSalesVoucherDao.viewSalesVoucher(org,orgDiv);

	}
	
	@GetMapping(value = "viewEditSalesVoucher")
	public ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> viewEditSalesVoucher(@RequestParam String id) {
		logger.info("Method :viewEditSalesVoucher starts");

		logger.info("Method :viewEditSalesVoucher ends" + id);
		return restSalesVoucherDao.viewEditSalesVoucher(id);

	}
}

package nirmalya.aatithya.restmodule.purchase.cotroller;


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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestCreditNoteDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestManageInvoiceDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestManageInvoiceReturnDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestRequestedRawMaterialDao;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceReturnModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

@RestController
@RequestMapping("purchase/")
public class RestCreditNoteController {
	Logger logger = LoggerFactory.getLogger(RestCreditNoteController.class);

	@Autowired

	RestCreditNoteDao restCreditNoteDao;

// view ProductItem Data

	@RequestMapping(value = "viewcreditNoteData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewcreditNoteData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewcreditNoteData start");

		logger.info("Method :viewcreditNoteData endss");
		return restCreditNoteDao.viewcreditNoteData(orgName, orgDivision);

	}

}

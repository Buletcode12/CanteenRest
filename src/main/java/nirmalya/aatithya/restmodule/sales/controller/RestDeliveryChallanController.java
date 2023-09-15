package nirmalya.aatithya.restmodule.sales.controller;

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
import nirmalya.aatithya.restmodule.sales.dao.RestDeliveryChallanDao;
import nirmalya.aatithya.restmodule.sales.model.RestDeliveryChallanModel;

@RestController
@RequestMapping("sales/")
public class RestDeliveryChallanController {
	Logger logger = LoggerFactory.getLogger(RestDeliveryChallanController.class);

	@Autowired

	RestDeliveryChallanDao restDeliveryChallanDao;

	
	@RequestMapping(value = "getTransportationModeList", method = { RequestMethod.GET })
	public List<DropDownModel> getTransportationModeLists() {
		logger.info("Method : getTransportationModeLists starts");
		
		logger.info("Method : getTransportationModeLists ends");
		return restDeliveryChallanDao.getTransportationModeLists();
	}
	
	@RequestMapping(value = "getSalesInvoiceList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceList(@RequestParam String id, String type) {
		logger.info("Method : getSalesInvoiceList starts");
		logger.info("Method : getSalesInvoiceList ends");
		return restDeliveryChallanDao.getSalesInvoiceList(id, type);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addsaleDeliveryChallan")
	public ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> addsaleDeliveryChallan(
			@RequestBody List<RestDeliveryChallanModel> restDeliveryChallanModel) {
		logger.info("Method :addsaleDeliveryChallan starts");

		logger.info("Method :addsaleDeliveryChallan endss");
		return restDeliveryChallanDao.addsaleDeliveryChallan(restDeliveryChallanModel);
	}

	@RequestMapping(value = "rest-viewsalesdeliveryChallan", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> viewsalesdeliveryChallan(
			@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method :viewsalesdeliveryChallan endss");
		return restDeliveryChallanDao.viewsalesdeliveryChallan(org, orgDiv);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewsalesChallanEdit")
	public List<RestDeliveryChallanModel> viewsalesChallanEdit(@RequestParam String id) {
		logger.info("Method : viewsalesChallanEdit starts");

		logger.info("Method : viewsalesChallanEdit endss");
		return restDeliveryChallanDao.viewsalesChallanEdit(id);
	}

	@GetMapping(value = "viewsalesChallanGetInvoice")
	public List<RestDeliveryChallanModel> viewsalesChallanGetInvoice(@RequestParam String id, String poid,
			String noOfChallan) {
		logger.info("Method : viewsalesChallanGetInvoice starts");

		logger.info("Method : viewsalesChallanEdit endss");
		return restDeliveryChallanDao.viewsalesChallanGetInvoice(id, poid, noOfChallan);
	}

	/*
	 * delete
	 * 
	 */
	@PostMapping(value = "deletesalesDeliveryChallan")
	public ResponseEntity<JsonResponse<Object>> deletesalesDeliveryChallan(
			@RequestBody RestDeliveryChallanModel restDeliveryChallanModel) {
		logger.info("Method : deletesalesDeliveryChallan starts");
		// logger.info(restSalesInvoiceNewModel);
		logger.info("Method : deletesalesDeliveryChallan ends");
		return restDeliveryChallanDao.deletesalesDeliveryChallan(restDeliveryChallanModel);
	}

	@GetMapping(value = "getDeliveryChallanInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeliveryChallanInsertedId() {
		logger.info("Method : getDeliveryChallanInsertedId starts");

		logger.info("Method : getDeliveryChallanInsertedId endss");
		return restDeliveryChallanDao.getDeliveryChallanInsertedId();
	}

	@RequestMapping(value = "getSalesOrderListDc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListDc(@RequestParam String id, String type) {
		logger.info("Method : getSalesOrderListDc starts");
		
		logger.info("Method : getSalesOrderListDc ends");
		return restDeliveryChallanDao.getSalesOrderListDc(id, type);
	}

	@RequestMapping(value = "getPackageIdDc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPackageIdDc(@RequestParam String id) {
		logger.info("Method : getPackageIdDc starts");
		logger.info("Method : getPackageIdDc ends");
		return restDeliveryChallanDao.getPackageIdDc(id);
	}
 
	/*
	 * pdf
	 */ @GetMapping(value = "view-dc-viewPdf")
	public List<RestDeliveryChallanModel> viewDcViewPdf(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewDcViewPdf starts");
		logger.info("Method : viewDcViewPdf endss");
		return restDeliveryChallanDao.viewDcViewPdf(id, org, orgDiv);
	}

	@RequestMapping(value = "rest-viewsalesPOWiseDeliveryChallan", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> viewsalesPOWiseDeliveryChallan(
			@RequestParam String org, @RequestParam String orgDiv, @RequestParam String id) {

		logger.info("Method :viewsalesPOWiseDeliveryChallan starts");

		logger.info("Method :viewsalesPOWiseDeliveryChallan endss");
		return restDeliveryChallanDao.viewsalesPOWiseDeliveryChallan(org, orgDiv, id);

	}
	
	@RequestMapping(value = "getSalesPoListForDc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesPoListForDc(@RequestParam String id) {
		logger.info("Method : getSalesPoListForDc starts");
		
		logger.info("Method : getSalesPoListForDc ends");
		return restDeliveryChallanDao.getSalesPoListForDc(id);
	}

}

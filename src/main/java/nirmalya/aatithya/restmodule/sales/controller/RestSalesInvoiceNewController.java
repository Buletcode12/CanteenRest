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
import nirmalya.aatithya.restmodule.sales.dao.SalesInvoiceNewDao;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;

@RestController
@RequestMapping("sales/")
public class RestSalesInvoiceNewController {

	Logger logger = LoggerFactory.getLogger(RestSalesInvoiceNewController.class);

	@Autowired

	SalesInvoiceNewDao SalesInvoiceNewDao;
	
	/*
	 * store name drp down
	 */
	/*
	 * @GetMapping(value = "GetStoreNameList") public List<DropDownModel>
	 * GetStoreNameList() { logger.info("Method : GetStoreNameList starts");
	 * 
	 * logger.info("Method : GetStoreNameList ends"); return
	 * SalesInvoiceNewDao.GetStoreNameList(); }
	 */

	@GetMapping(value = "getSalesOrderAutoSearchNewList")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> getSalesOrderAutoSearchNewList(
			@RequestParam String id) {
		logger.info("Method : getSalesOrderAutoSearchNewList starts");
		//logger.info("RestSalesInvoiceNewModel" + id);
		logger.info("Method :getSalesOrderAutoSearchNewList endss");
		return SalesInvoiceNewDao.getSalesOrderAutoSearchNewList(id);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addsaleInvoicenew")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> addsaleInvoicenew(
			@RequestBody List<RestSalesInvoiceNewModel> restSalesInvoiceNewModel) {
		logger.info("Method :addsaleInvoicenew starts");
		
		logger.info("Method :addsaleInvoicenew endss");
		return SalesInvoiceNewDao.addsaleInvoicenew(restSalesInvoiceNewModel);
	}

	/*
	 * view
	 * 
	 */
	@PostMapping(value = "getAllsalesInvoice")
	public JsonResponse<List<RestSalesInvoiceNewModel>> getAllsalesInvoice(@RequestBody EmpRoleModel empModel) {
		String userId = empModel.getUserId();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		logger.info("Method :getAllsalesInvoice starts");

		logger.info("Method :getAllsalesInvoice endss");
		return SalesInvoiceNewDao.getAllsalesInvoice(userId,organization,orgDivision);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewsalesIvoiceEdit")
	public List<RestSalesInvoiceNewModel> viewsalesIvoiceEdit(@RequestParam String id) {
		logger.info("Method : viewsalesIvoiceEdit starts");
		//logger.info(id);
		logger.info("Method : viewsalesIvoiceEdit endss");
		return SalesInvoiceNewDao.viewsalesIvoiceEdit(id);
	}
/*delete
 * 	 
 */
	 @PostMapping(value = "deletesalesInvoice")
		public ResponseEntity<JsonResponse<Object>> deletesalesInvoice(
				@RequestBody RestSalesInvoiceNewModel restSalesInvoiceNewModel) {
			logger.info("Method : deletesalesInvoice starts");
			//logger.info(restSalesInvoiceNewModel);
			logger.info("Method : deletesalesInvoice ends");
			return SalesInvoiceNewDao.deletesalesInvoice(restSalesInvoiceNewModel);
}
	 
	 /*
	  * payment mode drpdown
	  */
	 
	 @GetMapping(value = "GetpaymentModeList")
		public List<DropDownModel> GetpaymentModeList() {
			logger.info("Method : paymentModeListrest starts");

			logger.info("Method : paymentModeListrest ends");
			return SalesInvoiceNewDao.GetpaymentModeList();
		}
	 
	 /*
		 *  payment add
		 */
		@PostMapping(value = "addinvPaymentnew")
		public ResponseEntity<JsonResponse<Object>> addinvPaymentnew(@RequestBody RestSalesInvoiceNewModel salesInvoiceNewModel) {
			logger.info("Method :addinvPaymentnewrest starts");
			logger.info(salesInvoiceNewModel.toString());
			logger.info("Method :addinvPaymentnewrest endss");
			return SalesInvoiceNewDao.addinvPaymentnew(salesInvoiceNewModel);
		}
		
		@RequestMapping(value = "getSalesorderList",method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderList(@RequestParam String id,String type) {
			logger.info("Method : getSalesorderList starts");
			logger.info("Method : getSalesorderList ends");
			return SalesInvoiceNewDao.getSalesorderList(id,type);
		}
		@GetMapping(value = "getInvoiceInsertedId")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceInsertedId() {
			logger.info("Method : getInvoiceInsertedId starts");

			logger.info("Method : getInvoiceInsertedId endss");
			return SalesInvoiceNewDao.getInvoiceInsertedId();
	}
		
		@GetMapping(value = "getInvoicepodata")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoicepodata() {
			logger.info("Method : getInvoicepodata starts");

			logger.info("Method : getInvoicepodata endss");
			return SalesInvoiceNewDao.getInvoicepodata();
	}
		/*
		 * pdf
		 */ @GetMapping(value = "viewsales-invoice-viewPdf")
		public List<RestSalesInvoiceNewModel> viewsalesInvoiceViewPdf(@RequestParam String id) {
			logger.info("Method : viewsalesInvoiceViewPdf starts");
			logger.info("Method : viewsalesInvoiceViewPdf endss");
			return SalesInvoiceNewDao.viewsalesInvoiceViewPdf(id);
		}
		 
		 
	/*Project Sutosearch*/
		 
	@GetMapping(value = "geProjectListByAutoSearch")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> getCustomerListByAutoSearch(
			@RequestParam String id) {
		logger.info("Method : geProjectListByAutoSearch starts");

		logger.info("Method :geProjectListByAutoSearch endss");
		return SalesInvoiceNewDao.geProjectListByAutoSearch(id);
	}
	
	
	/*
	 * view Item
	 * 
	 */
	@GetMapping(value = "getAllsalesInvoiceitem")
	public JsonResponse<List<RestSalesInvoiceNewModel>> getAllsalesInvoiceitem(@RequestParam String prId, @RequestParam String crId) {
		logger.info("Method :getAllsalesInvoiceitem starts");

		logger.info("Method :getAllsalesInvoiceitem endss");
		return SalesInvoiceNewDao.getAllsalesInvoiceitem(prId,crId);

	}
	
//	@RequestMapping(value = "viewsalesIvoiceEdit-new", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<RestSalesInvoiceNewModel>> viewsalesIvoiceEdits(@RequestParam String id) {
//		logger.info("Method : viewsalesIvoiceEdits rest starts");
//
//		logger.info("Method :viewsalesIvoiceEdits rest ends");
//		return SalesInvoiceNewDao.viewsalesIvoiceEdits(id);
//	}
	@GetMapping(value = "viewSalesPdfNew")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> viewSalesPdfNew(@RequestParam String id) {
		logger.info("Method :viewSalesPdfNew starts");

		logger.info("Method :viewSalesPdfNew ends" + id);
		return SalesInvoiceNewDao.viewSalesPdfNew(id);
	}
	
	@RequestMapping(value = "rest-rejectInvoice", method = { RequestMethod.GET })
	public JsonResponse<Object> rejectInvoice(@RequestParam String invId,String comment, String org,String orgDiv) {
		logger.info("Method :rejectInvoice start");

		logger.info("Method :rejectInvoice endss");
		return SalesInvoiceNewDao.rejectInvoice(invId,comment,org, orgDiv);
	}
}

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
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.sales.dao.RestSaleOrderNewDao;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

@RestController
@RequestMapping("sales/")
public class RestSaleOrderNewController {
	Logger logger = LoggerFactory.getLogger(RestSaleOrderNewController.class);

	@Autowired

	RestSaleOrderNewDao RestSaleOrderNewDao;

	/*
	 * store name drp down
	 */
	@GetMapping(value = "GetStoreList")
	public List<DropDownModel> GetStoreList() {
		logger.info("Method : GetStoreList starts");

		logger.info("Method : GetStoreList ends");
		return RestSaleOrderNewDao.GetStoreList();
	}

	/*
	 * customer auto search
	 */
	@GetMapping(value = "getCustomerAutoSearchNewList")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getCustomerAutoSearchNewList(
			@RequestParam String id) {
		logger.info("Method : getCustomerAutoSearchNewList starts");

		logger.info("Method :getCustomerAutoSearchNewList endss");
		return RestSaleOrderNewDao.getCustomerAutoSearchNewList(id);
	}

	/*
	 * item autosearch
	 * 
	 */
	@GetMapping(value = "getItemQuotationAutoSearchNewList")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getItemQuotationAutoSearchNewList(
			@RequestParam String id) {
		logger.info("Method : getItemQuotationAutoSearchNewList starts");

		logger.info("Method :getItemQuotationAutoSearchNewList endss");
		return RestSaleOrderNewDao.getItemQuotationAutoSearchNewList(id);
	}

	// get product category list

	@RequestMapping(value = "getProductCategoryDataListModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryDataListModal starts");

		logger.info("Method : getProductCategoryDataListModal ends");
		return RestSaleOrderNewDao.getProductCategoryDataListModal();
	}

	/*
	 * get product by cat
	 * 
	 */
	@GetMapping(value = "getProductsNByCat")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getProductsNByCat(@RequestParam String id) {
		logger.info("Method in rest: getProductsByCat starts");
		// logger.info(id);
		logger.info("Method in rest: getProductsByCat ends");
		return RestSaleOrderNewDao.getProductsNByCat(id);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addsalenew")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> addsalenew(
			@RequestBody List<RestSaleOrderNewModel> restSaleOrderNewModel) {
		logger.info("Method :addsalenew starts");
		 
		logger.info("Method :addsalenew endss");
		return RestSaleOrderNewDao.addsalenew(restSaleOrderNewModel);
	}

	/*
	 * view
	 * 
	 */
	@PostMapping(value = "getAllsalesOrder")
	public JsonResponse<List<RestSaleOrderNewModel>> getAllsalesOrder(@RequestBody EmpRoleModel empModel) {
		String userId = empModel.getUserId();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		logger.info("Method :getAllsalesOrder starts");
		

		logger.info("Method :getAllsalesOrder endss");
		return RestSaleOrderNewDao.getAllsalesOrder(userId,organization,orgDivision);
	}

	/*
	 * edit
	 */
	@GetMapping(value = "viewsalesOrdeerEdit")
	public List<RestSaleOrderNewModel> viewsalesOrdeerEdit(@RequestParam String id) {
		logger.info("Method : viewsalesOrdeerEdit starts");
		logger.info("Method : viewsalesOrdeerEdit endss");
		return RestSaleOrderNewDao.viewsalesOrdeerEdit(id);
	}
	/*
	 * viewsalesOrderForPacking
	 */
	@GetMapping(value = "viewsalesOrderForPacking")
	public List<RestSaleOrderNewModel> viewsalesOrderForPacking(@RequestParam String id,String poidd,String noOfSO) {
		logger.info("Method : viewsalesOrderForPacking starts");
		
		logger.info("Method : viewsalesOrderForPacking endss");
		return RestSaleOrderNewDao.viewsalesOrderForPacking(id,poidd,noOfSO);
	}

	/*
	 * delete
	 * 
	 */
	@PostMapping(value = "deletesalesOrder")
	public ResponseEntity<JsonResponse<Object>> deletesalesOrder(
			@RequestBody RestSaleOrderNewModel restSaleOrderNewModel) {
		logger.info("Method : deletesalesOrder starts");
		logger.info(restSaleOrderNewModel.toString());
		logger.info("Method : deletesalesOrder ends");
		return RestSaleOrderNewDao.deletesalesOrder(restSaleOrderNewModel);
	}
	
	@GetMapping(value = "getSOInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSOInsertedId() {
		logger.info("Method : getSOInsertedId starts");

		logger.info("Method : getSOInsertedId endss");
		return RestSaleOrderNewDao.getSOInsertedId();
	}
	@RequestMapping(value = "getSalesPoListt", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesPoListt(@RequestParam String id) {
		logger.info("Method : getSalesPoListt starts");
		
		logger.info("Method : getSalesPoListt ends");
		return RestSaleOrderNewDao.getSalesPoListt(id);
	}
	@RequestMapping(value = "rest-viewsalesOrderPoWise", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> viewsalesOrderPoWise(
			@RequestParam String org, @RequestParam String orgDiv, @RequestParam String id) {
		logger.info("Method :viewsalesOrderPoWise starts");

		logger.info("Method :viewsalesOrderPoWise endss");
		return RestSaleOrderNewDao.viewsalesOrderPoWise(org, orgDiv, id);

	}
	
	 // Block Order
    @GetMapping(value="blockSaleOrderItem")
	public JsonResponse<RestSaleOrderNewModel> blockSaleOrderItem(@RequestParam String blockeOrder, String salesOrder,String sku){
		logger.info("Method : blockSaleOrderItem starts");
		
		logger.info("Method : blockSaleOrderItem ends");
		return RestSaleOrderNewDao.blockSaleOrderItem(blockeOrder, salesOrder,sku);
	}
    
 // approve


 	
    @GetMapping(value="approveSaleOrder")
 	public JsonResponse<RestSaleOrderNewModel> approveSaleOrder(@RequestParam String approveStatus,
 			String salesOrder,String pendingQut){
 		logger.info("Method : approveSaleOrder starts");
 		
 		logger.info("Method : approveSaleOrder ends");
 		return RestSaleOrderNewDao.approveSaleOrder(approveStatus, salesOrder,pendingQut);
 	}
	
}

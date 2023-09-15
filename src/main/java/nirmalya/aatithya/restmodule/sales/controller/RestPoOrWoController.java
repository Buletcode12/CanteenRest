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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.RestPoOrWoDao;
import nirmalya.aatithya.restmodule.sales.model.RestPoOrWoModel;



@RestController
@RequestMapping("sales/")
public class RestPoOrWoController {
	Logger logger = LoggerFactory.getLogger(RestPoOrWoController.class);

	@Autowired

	RestPoOrWoDao RestPoOrWoDao;
	
	
	
	/*
	 * add
	 */
	@PostMapping(value = "addSalesPo")
	public ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> addSalesPo(
			@RequestBody List<RestPoOrWoModel> restPoOrWoModel) {
		logger.info("Method :addSalesPo starts");
		logger.info(restPoOrWoModel.toString());
		logger.info("Method :addSalesPo endss");
		return RestPoOrWoDao.addSalesPo(restPoOrWoModel);
	}
	
	/*
	 * view
	 * 
	 */
	@RequestMapping(value = "rest-viewsalesPo", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> viewsalesPo(
			@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method :viewsalesPo endss");
		return RestPoOrWoDao.viewsalesPo(org, orgDiv);

	}
	
	
	/*
	 * edit
	 */
	@GetMapping(value = "viewsalesPoEdit")
	public List<RestPoOrWoModel> viewsalesPoEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewsalesPoEdit starts");
		
		logger.info("Method : viewsalesPoEdit endss");
		return RestPoOrWoDao.viewsalesPoEdit(id,org,orgDiv);
	}
	
	 /*delete
	  * 	 
	  */
	 	 @PostMapping(value = "deleteSalesPo")
	 		public ResponseEntity<JsonResponse<Object>> deleteSalesPo(
	 				@RequestBody RestPoOrWoModel restPoOrWoModel) {
	 			logger.info("Method : deletePo starts");
	 			//logger.info(restSalesInvoiceNewModel);
	 			logger.info("Method : deletePo ends");
	 			return RestPoOrWoDao.deleteSalesPo(restPoOrWoModel);
	 }
	 	 
	 	@GetMapping(value = "getSoData")
		public List<RestPoOrWoModel> getSoData(@RequestParam String id,String skuid, String org,String orgDiv) {
			logger.info("Method : getSoData starts");
			logger.info("Method : getSoData endss");
			return RestPoOrWoDao.getSoData(id,skuid,org,orgDiv);
		}
	 	
	 // Block Order
		/*
		 * @GetMapping(value="blockSaleOrder") public JsonResponse<RestPoOrWoModel>
		 * blockSaleOrder(@RequestParam String blockeOrder, String referenceId,String
		 * sku){ logger.info("Method : blockSaleOrder starts");
		 * 
		 * logger.info("Method : blockSaleOrder ends"); return
		 * RestPoOrWoDao.blockSaleOrder(blockeOrder, referenceId,sku); }
		 */
	 	@GetMapping(value = "viewsalesCreateversionEdit")
		public List<RestPoOrWoModel> viewsalesCreateversionEdit(@RequestParam String id,@RequestParam String org,
				@RequestParam String orgDiv) {
			logger.info("Method : viewsalesCreateversionEdit starts");
			
			logger.info("Method : viewsalesCreateversionEdit endss");
			return RestPoOrWoDao.viewsalesCreateversionEdit(id,org,orgDiv);
		}
		

}

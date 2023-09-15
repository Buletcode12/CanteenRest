package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.sales.dao.RestSalesProductDao;

@RestController
@RequestMapping("sales/")
public class RestSalesProductController {
	Logger logger = LoggerFactory.getLogger(RestSalesProductController.class);

	@Autowired

	RestSalesProductDao restSalesProductDao;
	
	@RequestMapping(value = "getBrandListForSalesProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getBrandListForSalesProduct(@RequestParam String org,String orgDiv) {
		logger.info("Method : getBrandListForSalesProduct starts");
		
		logger.info("Method : getBrandListForSalesProduct ends");
		return restSalesProductDao.getBrandListForSalesProduct(org, orgDiv);
	}
	
	@RequestMapping(value = "getModeListForSalesProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getModeListForSalesProduct() {
		logger.info("Method : getModeListForSalesProduct starts");
		
		logger.info("Method : getModeListForSalesProduct ends");
		return restSalesProductDao.getModeListForSalesProduct();
	}
	
	@RequestMapping(value = "getSalesProductCategoryDataListModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getSalesProductCategoryDataListModal starts");
		
		logger.info("Method : getSalesProductCategoryDataListModal ends");
		return restSalesProductDao.getSalesProductCategoryDataListModal();
	}
}

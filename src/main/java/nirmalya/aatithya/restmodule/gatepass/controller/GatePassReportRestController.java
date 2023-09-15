package nirmalya.aatithya.restmodule.gatepass.controller;

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
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassReportDao;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassReportModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping("gatepass/")
public class GatePassReportRestController {
	
	Logger logger = LoggerFactory.getLogger(GatePassReportRestController.class);

	@Autowired
	GatePassReportDao gatePassReportDao;
	

	
	// category list
	@RequestMapping(value = "rest-gatePass-report_category_list", method = { RequestMethod.GET })
	public JsonResponse<Object> getCategoryList(@RequestParam String orgName, String orgDivision , String shift) {
		logger.info("Method :getCategoryList start");

		logger.info("Method :getCategoryList endss");
		return gatePassReportDao.getCategoryList(orgName, orgDivision , shift);
	}

	
	//saveAllocation
	@PostMapping(value = "saveGateReportData")
	public ResponseEntity<JsonResponse<List<RestGatePassReportModel>>> saveAllocation(
			@RequestBody List<RestGatePassReportModel> restGatePassReportModel) {
		logger.info("Method :saveGateReportData starts");
		
		logger.info("Method :saveGateReportData endss");
		return gatePassReportDao.saveGateReportData(restGatePassReportModel);
	}
	
	@RequestMapping(value = "viewReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewReportData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewReportData start");

		logger.info("Method :viewReportData endss");
		return gatePassReportDao.viewReportData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "editReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> editReportData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editReportData start");

		logger.info("Method :editReportData endss");
		return gatePassReportDao.editReportData(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteReport", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteReport(@RequestParam String registerId, String org,String orgDiv) {
		logger.info("Method :deleteReport start");

		logger.info("Method :deleteReport endss");
		return gatePassReportDao.deleteReport(registerId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-approveReportdata", method = { RequestMethod.GET })
	public JsonResponse<Object> approveReportdata(@RequestParam String registerId, String org,String orgDiv) {
		logger.info("Method :approveReportdata start");

		logger.info("Method :approveReportdata endss");
		return gatePassReportDao.approveReportdata(registerId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-report-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> getReportPdfDetails(@RequestParam String registerId, String orgName, String orgDivision) {
		logger.info("Method :getReportPdfDetails start");

		logger.info("Method :getReportPdfDetails endss");
		return gatePassReportDao.getReportPdfDetails(registerId, orgName, orgDivision);
	}
	
	
	@RequestMapping(value = "getCategoryAutoSearchListForItem", method = { RequestMethod.GET })
	public JsonResponse<Object> getCategoryAutoSearchListForItem(@RequestParam String id) {
		logger.info("Method :getCategoryAutoSearchListForItem start");

		logger.info("Method :getCategoryAutoSearchListForItem endss");
		return gatePassReportDao.getCategoryAutoSearchListForItem(id);
	}
	@RequestMapping(value = "getManPowerAutoSearchListForItem", method = { RequestMethod.GET })
	public JsonResponse<Object> getManPowerAutoSearchListForItem(@RequestParam String id) {
		logger.info("Method :getManPowerAutoSearchListForItem start");

		logger.info("Method :getManPowerAutoSearchListForItem endss");
		return gatePassReportDao.getManPowerAutoSearchListForItem(id);
	}
	
	
}

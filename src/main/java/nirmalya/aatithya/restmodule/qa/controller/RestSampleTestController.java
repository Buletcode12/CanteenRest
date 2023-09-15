package nirmalya.aatithya.restmodule.qa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.RestSampleTestDao;

@RestController
@RequestMapping(value = "production/")
public class RestSampleTestController {
	
	
	Logger logger = LoggerFactory.getLogger(RestSampleTestController.class);

	@Autowired
	RestSampleTestDao restSampleTestDao;
	
	@RequestMapping(value = "rest-qaTestDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestDtls(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :qaTestDtls start");

		logger.info("Method :qaTestDtls endss");
		return restSampleTestDao.qaTestDtls(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-qaChildDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> qaChildDtls(@RequestParam String rid,@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :qaChildDtls start");

		logger.info("Method :qaChildDtls endss");
		return restSampleTestDao.qaRequestDtls(rid,id, orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-testResultSubmit", method = { RequestMethod.GET })
	public JsonResponse<Object> testResultSubmit(@RequestParam String id, String testres, String param, String task, String sku, String status, String orgName, String orgDivision) {
		logger.info("Method :testResultSubmittttt start",id);
		System.out.println(id);
		logger.info("Method :testResultSubmit endss");
		return restSampleTestDao.testResultSubmit(id, testres, param,task,sku,status, orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-testApprove", method = { RequestMethod.GET })
	public JsonResponse<Object> testApproveSet(@RequestParam String id, String sku) {
		logger.info("Method :testResultSubmittttt start",id);
		System.out.println(id);
		logger.info("Method :testResultSubmit endss");
		return restSampleTestDao.testApproveSet(id , sku);

	}
	
	

}

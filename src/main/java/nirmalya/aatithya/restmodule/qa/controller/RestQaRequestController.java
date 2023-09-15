package nirmalya.aatithya.restmodule.qa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.RestQaRequestDao;

@RestController
@RequestMapping(value = "production/")
public class RestQaRequestController {
	
	
	Logger logger = LoggerFactory.getLogger(RestQaRequestController.class);

	@Autowired
	RestQaRequestDao restQaRequestDao;

	@RequestMapping(value = "rest-viewQaRequstedData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewQaRequestData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewQaRequestData start");

		logger.info("Method :viewQaRequestData endss");
		return restQaRequestDao.viewQaRequestData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-qaRequestDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestDtls(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :qaRequestDtls start");

		logger.info("Method :qaRequestDtls endss");
		return restQaRequestDao.qaRequestDtls(id, orgName, orgDivision);

	}
	
	
	@RequestMapping(value = "rest-qaRequestChangeStatus", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestChangeStatus(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :qaRequestChangeStatus start");

		logger.info("Method :qaRequestChangeStatus endss");
		return restQaRequestDao.qaRequestChangeStatus(id, orgName, orgDivision);

	}

}

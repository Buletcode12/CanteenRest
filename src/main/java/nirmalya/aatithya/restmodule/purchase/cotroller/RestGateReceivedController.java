package nirmalya.aatithya.restmodule.purchase.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestGateReceivedDao;

@RestController
@RequestMapping(value = "purchase/")
public class RestGateReceivedController {
	
	Logger logger = LoggerFactory.getLogger(RestGateReceivedController.class);

	@Autowired
	RestGateReceivedDao restGateReceivedDao;

	@RequestMapping(value = "rest-gateReceivedDataView", method = { RequestMethod.GET })
	public JsonResponse<Object> gateReceivedDataView(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :gateReceivedDataView start");

		logger.info("Method :gateReceivedDataView endss");
		return restGateReceivedDao.gateReceivedDataView(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-gateReceivedDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> gateReceivedDtls(@RequestParam String id,@RequestParam String po, String orgName, String orgDivision) {
		logger.info("Method :gateReceivedDtls start");

		logger.info("Method :gateReceivedDtls endss");
		return restGateReceivedDao.gateReceivedDtls(id, po, orgName, orgDivision);

	}
	
	
	

}

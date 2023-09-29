package nirmalya.aatithya.restmodule.canteen.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.canteen.dao.RestMenuDao;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping("canteen/")
public class RestAssignController {
	
	Logger logger = LoggerFactory.getLogger(RestMenuController.class);

	@Autowired
	RestMenuDao restMenuDao;

	

	//View
		@RequestMapping(value="restViewAssignDetails" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewShoukeenIncentive(){
			logger.info("Method: restViewincentivesdetails View Start");
			
			logger.info("Method: restViewincentivesdetails ends");
			return restMenuDao.viewShoukeenIncentive();
		}

}

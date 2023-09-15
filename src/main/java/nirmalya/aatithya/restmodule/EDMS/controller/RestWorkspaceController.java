package nirmalya.aatithya.restmodule.EDMS.controller;

import nirmalya.aatithya.restmodule.EDMS.dao.RestWorkspaceDao;
import nirmalya.aatithya.restmodule.EDMS.model.RestWorkSpaceModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

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

@RestController
@RequestMapping(value = "edms/")
public class RestWorkspaceController {
	Logger logger = LoggerFactory.getLogger(RestWorkspaceController.class);

	RestWorkspaceDao RestWorkspaceDao;
	
	@Autowired
	public RestWorkspaceController(RestWorkspaceDao RestWorkspaceDao) {
		this.RestWorkspaceDao = RestWorkspaceDao;
	}

	@RequestMapping(value = "rest-fileaccess-type", method = { RequestMethod.GET })
	public List<DropDownModel> fileAccessType() {
		logger.info("Method : fileAccessType starts");

		logger.info("Method : fileAccessType ends");
		return RestWorkspaceDao.fileAccessType();
	}

	@RequestMapping(value = "rest-fileoperation-type", method = { RequestMethod.GET })
	public List<DropDownModel> fileOperationType() {
		logger.info("Method : fileOperationType starts");

		logger.info("Method : fileOperationType ends");
		return RestWorkspaceDao.fileOperationType();
	}

	@PostMapping(value = "save-workspacemodel")
	public ResponseEntity<JsonResponse<Object>> saveEventsRest(@RequestBody RestWorkSpaceModel eventModel) {
		logger.info("Method : saveEventsRest starts");
		System.out.println("======>>" + eventModel);
		logger.info("Method : saveEventsRest ends");
		return RestWorkspaceDao.saveWorkspaceModel(eventModel);
	}

	@RequestMapping(value = "rest-workSpace", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWorkSpace(@RequestParam String userId, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :viewWorkSpace start");

		logger.info("Method :viewWorkSpace endss ");
		return RestWorkspaceDao.viewWorkSpace(userId, orgName, orgDivision);

	}

	@RequestMapping(value = "rest-workSpace-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editWorkSpace(@RequestParam String workSpaceId, @RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :editWorkSpace start");

		logger.info("Method :editWorkSpace endss ");
		return RestWorkspaceDao.editWorkSpace(workSpaceId, userId, orgName, orgDivision);
	}

	@GetMapping(value = "rest-deleteworksapce")
	public ResponseEntity<JsonResponse<Object>> deleteWorksapce(@RequestParam String id) {
		logger.info("Method : deleteWorksapce starts");

		logger.info("Method : deleteWorksapce ends");
		return RestWorkspaceDao.deleteWorksapce(id);
	}
	
	// Add Asset
		@PostMapping(value = "rest-getNew-workspace-add")
		public ResponseEntity<JsonResponse<Object>> addNewWorkSpace(@RequestBody String workSpace, @RequestParam String workSpaceId) {
			logger.info("Method : addNewWorkSpace starts");
			logger.info("Method : addNewWorkSpace ends");
			return RestWorkspaceDao.addNewWorkSpace(workSpace, workSpaceId);
		}
}

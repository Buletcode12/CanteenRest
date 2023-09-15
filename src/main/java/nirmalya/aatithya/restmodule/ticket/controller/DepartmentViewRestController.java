package nirmalya.aatithya.restmodule.ticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.ticket.dao.DepartmentViewDao;

@RestController
@RequestMapping("ticket/")
public class DepartmentViewRestController {
	
	Logger logger = LoggerFactory.getLogger(DepartmentViewRestController.class);

	@Autowired
	DepartmentViewDao departmentViewDao;
	
	// priority List
	
	@RequestMapping(value = "rest-deptViewPriorityList", method = { RequestMethod.GET })
	public JsonResponse<Object> deptViewPriorityList(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :deptViewPriorityList start");

		logger.info("Method :deptViewPriorityList endss");
		return departmentViewDao.deptViewPriorityList(orgName, orgDivision);

	}

}

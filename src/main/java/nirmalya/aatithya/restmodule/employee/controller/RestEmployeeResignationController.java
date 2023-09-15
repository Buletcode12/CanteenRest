package nirmalya.aatithya.restmodule.employee.controller;

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
import nirmalya.aatithya.restmodule.employee.dao.RestEmployeeResignationDao;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeResignationModel;


@RestController
@RequestMapping(value = { "employee/" })
public class RestEmployeeResignationController {
	Logger logger = LoggerFactory.getLogger(RestEmployeeResignationController.class);
	
	@Autowired
	RestEmployeeResignationDao restEmployeeResignationDao;
	
	@RequestMapping(value = "getEmployeeLists", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeLists(@RequestParam String orgName, String orgDivision) {
		logger.info("Method : getEmployeeLists starts");

		logger.info("Method : getEmployeeLists ends");
		return restEmployeeResignationDao.getEmployeeLists(orgName,orgDivision);
	}
	@RequestMapping(value = "getEmployeeListsCC", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeListsCC(@RequestParam String orgName, String orgDivision,String managerId,String userId) {
		logger.info("Method : getEmployeeListsCC starts");
		
		logger.info("Method : getEmployeeListsCC ends");
		return restEmployeeResignationDao.getEmployeeListsCC(orgName,orgDivision,managerId,userId);
	}
	
	/*
	 * Add Resignation details Draft
	 */
	
	@PostMapping(value = "rest-resignation-apply-draft")
	public ResponseEntity<JsonResponse<List<RestEmployeeResignationModel>>>resignationApplyDraft(
			@RequestBody List<RestEmployeeResignationModel> restEmployeeResignationModel) {
		logger.info("Method : resignationApplyDraft starts");
		logger.info("Method : resignationApplyDraft ends");
		return restEmployeeResignationDao.resignationApplyDraftDao(restEmployeeResignationModel);
	}
	//view resignation apply Draft
	
	@GetMapping(value="rest-viewResignationDraft")
	public JsonResponse<List<RestEmployeeResignationModel>> viewResignationDraft(@RequestParam String userId ,@RequestParam String userRole,@RequestParam String organization,@RequestParam String orgDivision){
		logger.info("Method : viewResignationDraft starts");
		
		logger.info("Method : viewResignationDraft ends"+orgDivision);
		return restEmployeeResignationDao.viewResignationDraft(userId ,userRole,organization,orgDivision);
	}
	//edit resignation apply draft
	
	@GetMapping(value="rest-editResignationApplyDraft")
	public JsonResponse<List<RestEmployeeResignationModel>> editResignationApplyDraft(@RequestParam String id){
		logger.info("Method : editResignationApplyDraft starts");
		
		logger.info("Method : editResignationApplyDraft ends");
		return restEmployeeResignationDao.editResignationApplyDraft(id);
	}
	
	//delete resignation details
	
	@GetMapping(value="rest-deleteResignation")
	public JsonResponse<RestEmployeeResignationModel> deleteResignationApply(@RequestParam String id){
		logger.info("Method : deleteResignationApply starts");
		
		logger.info("Method : deleteResignationApply ends");
		return restEmployeeResignationDao.deleteResignationApply(id);
	}
	
	
	/*
	 * Add Resignation details
	 */
	
	@PostMapping(value = "rest-resignation-apply")
	public ResponseEntity<JsonResponse<List<RestEmployeeResignationModel>>>resignationApply(
			@RequestBody List<RestEmployeeResignationModel> restEmployeeResignationModel) {
		logger.info("Method : resignationApply starts");
		logger.info("Method : resignationApply ends");
		return restEmployeeResignationDao.resignationApplyDao(restEmployeeResignationModel);
	}
	/*
	 * get mail  Details
	 */

	@RequestMapping(value = "get_maildetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getMailDetails(@RequestParam String mylist) {
		logger.info("Method : getMailDetails starts");

		logger.info("Method : getMailDetails ends");
		return restEmployeeResignationDao.getMailDetails(mylist);
	}
	//view resignation apply
	
	@GetMapping(value="rest-viewResignation")
	public JsonResponse<List<RestEmployeeResignationModel>> viewResignation(@RequestParam String userId ,@RequestParam String userRole){
		logger.info("Method : viewResignation starts");
		
		logger.info("Method : viewResignation ends");
		return restEmployeeResignationDao.viewResignation(userId ,userRole);
	}
	/*
	 * Get Employee Name for choosen Js(Edit)
	 */
	@RequestMapping(value = "rest-draft-getempname", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DropDownModel>> getEmpName(
			@RequestParam("id") String id) {
		logger.info("Method : getEmpName starts");

		logger.info("Method : getEmpName ends");
		return restEmployeeResignationDao.getEmpName(id);
	}
}

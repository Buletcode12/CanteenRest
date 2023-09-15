package nirmalya.aatithya.restmodule.ticket.controller;

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
import nirmalya.aatithya.restmodule.ticket.dao.TicketManagementDao;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;


@RestController
@RequestMapping(value = "ticket/")
public class TicketManagementRestController {
	Logger logger = LoggerFactory.getLogger(TicketManagementRestController.class);

	@Autowired
	TicketManagementDao ticketManagementDao;
	
	// Ticket Type List.
	
	@RequestMapping(value = "getTicketTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getTicketTypeList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getTicketTypeList starts");

		logger.info("Method : getTicketTypeList ends");
		return ticketManagementDao.getTicketTypeList(org,orgDiv);
	}
	
	// Ticket Priority List.
	
	@RequestMapping(value = "getPriorityList", method = { RequestMethod.GET })
	public List<DropDownModel> getPriorityList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getPriorityList starts");

		logger.info("Method : getPriorityList ends");
		return ticketManagementDao.getPriorityList(org,orgDiv);
	}
	
	/*
	 * get all employee list
	 * 	
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "get-employee-list")
	public JsonResponse getEmployeeList(
			@RequestParam String organization, @RequestParam String orgDivision,@RequestParam String userId) {
		logger.info("Method : view-assigned-employee-list starts");

		logger.info("Method : view-assigned-employee-list ends");
		return ticketManagementDao.getEmpListDao(organization, orgDivision,userId);
	}
	
	// Add Ticket.
	
	@PostMapping(value = "rest-add-ticket-dtls")
	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveTicketDtls(@RequestBody List<TicketManagementRestModel> category) {
		logger.info("Method : saveTicketDtls starts");

		logger.info("Method : saveTicketDtls ends");
		return ticketManagementDao.saveTicketDtls(category);
	}
	
	// View Ticket.
	
	
	@RequestMapping(value = "rest-view-ticket-data", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTicketData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewTicketData start");

		logger.info("Method :viewTicketData endss");
		return ticketManagementDao.viewTicketData(orgName, orgDivision);
	}
	
	// Edit Ticket.
	
	@RequestMapping(value = "rest-ticket-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editTicket(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editTicket start");

		logger.info("Method :editTicket endss");
		return ticketManagementDao.editTicket(id, orgName, orgDivision);
	}
	
	// Delete Ticket.
	
	@GetMapping(value = "rest-ticket-delete")
	public ResponseEntity<JsonResponse<Object>> deleteTicket(@RequestParam String id, String userId , String org, String orgDiv) {
		logger.info("Method : deleteTicket starts");

		logger.info("Method : deleteTicket ends");
		return ticketManagementDao.deleteTicket(id, userId, org, orgDiv);

	}
	
}

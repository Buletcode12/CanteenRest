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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassDao;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;

@RestController
@RequestMapping("gatepass/")
public class GatePassRestController {
	Logger logger = LoggerFactory.getLogger(GatePassRestController.class);

	@Autowired
	GatePassDao gatePassDao;

	@GetMapping(value = "get-purchseOrderId-list")
	public List<DropDownModel> getpurchseOrderIdList(@RequestParam String org, String orgDiv) {
		logger.info("Method : getpurchseOrderIdList starts");
		logger.info("Method : getpurchseOrderIdList endss");
		return gatePassDao.getpurchseOrderIdList(org, orgDiv);
	}

	@GetMapping(value = "get-purchseOrderIdForExit-list")
	public List<DropDownModel> purchseOrderIdForExit() {
		logger.info("Method : purchseOrderIdForExit starts");
		logger.info("Method : purchseOrderIdForExit endss");
		return gatePassDao.purchseOrderIdForExit();
	}

	@GetMapping(value = "get-noOfwheeler-list")
	public List<DropDownModel> getnoOfwheelerList() {
		logger.info("Method : getnoOfwheelerList starts");
		logger.info("Method : getnoOfwheelerList endss");
		return gatePassDao.getnoOfwheelerList();
	}

	@RequestMapping(value = "getSubCategoryList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryList(@RequestParam String id) {
		logger.info("Method : getSubCategoryList starts");

		logger.info("Method : getSubCategoryList ends");
		return gatePassDao.getSubCategoryList(id);
	}
	// add gatepass in

	@PostMapping(value = "rest-add-gatepass-entry")
	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> addGatepassEntry(
			@RequestBody List<RestGatePassDetailsModel> restGatePassDetailsModel) {
		logger.info("Method :addGatepassEntry starts");
		// System.out.println(restSalesInvoiceNewModel);
		logger.info("Method :addGatepassEntry endss");
		return gatePassDao.addGatepassEntry(restGatePassDetailsModel);
	}

	/*
	 * @GetMapping(value = "viewgatepassEntry") public
	 * JsonResponse<List<InventoryGatePassModel>> getAllgatepassEntry() {
	 * logger.info("Method :viewgatepassEntry starts");
	 * 
	 * logger.info("Method :viewgatepassEntry endss"); return
	 * gatePassDao.viewgatepassEntry();
	 * 
	 * }
	 */
	@PostMapping(value = "viewGatePassEntry")
	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> viewGatePassEntry(
			@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewGatePassEntry starts");

		String userId = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();

		logger.info("Method : viewGatePassEntry ends");
		return gatePassDao.viewGatePassEntry(userId, organization, orgDivision);
	}

	/*
	 * edit
	 */ @GetMapping(value = "editGatePassEntryData")
	public List<RestGatePassDetailsModel> editGatePassEntryData(@RequestParam String id,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : editGatePassEntryData starts");
		// System.out.println(id);
		logger.info("Method : editGatePassEntryData endss");
		return gatePassDao.editGatePassEntryData(id, organization, orgDivision);
	}

	// gate out add

	@PostMapping(value = "rest-add-gatepass-exit")
	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> addGatepassExit(
			@RequestBody List<RestGatePassDetailsModel> restGatePassDetailsModel) {
		logger.info("Method :addGatepassExit starts");
		logger.info("Method :addGatepassExit endss");
		return gatePassDao.addGatepassExit(restGatePassDetailsModel);
	}
	// gate out view

	@PostMapping(value = "viewGatePassExit")
	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> viewGatePassExit(
			@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewGatePassExit starts");

		String userId = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();

		logger.info("Method : viewGatePassExit ends");
		return gatePassDao.viewGatePassExit(userId, organization, orgDivision);
	}

	/*
	 * edit
	 */ @GetMapping(value = "editGatePassExit")
	public List<RestGatePassDetailsModel> editGatePassExit(@RequestParam String id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : editGatePassExit starts");
		// System.out.println(id);
		logger.info("Method : editGatePassExit endss");
		return gatePassDao.editGatePassExit(id, organization, orgDivision);
	}
// item against po id 

	@GetMapping(value = "getVendorandItemDetails")
	public List<RestGatePassDetailsModel> getVendorandItemDetails(@RequestParam String id, String org,
			String orgDivision) {
		logger.info("Method : getVendorandItemDetails starts");

		logger.info("Method : getVendorandItemDetails endss");
		return gatePassDao.getVendorandItemDetails(id, org, orgDivision);
	}
	// getItemDetailsForExit

	@GetMapping(value = "getItemDetailsForExit")
	public List<RestGatePassDetailsModel> getItemDetailsForExit(@RequestParam String id, String org,
			String orgDivision) {
		logger.info("Method : getItemDetailsForExit starts");

		logger.info("Method : getItemDetailsForExit endss");
		return gatePassDao.getItemDetailsForExit(id, org, orgDivision);
	}

	// approve for

	@GetMapping(value = "approveGatepassEntry")
	public JsonResponse<DropDownModel> approveGatepassEntry(@RequestParam String approveStatus, String getPassEntryId,
			String org, String orgDivision) {
		logger.info("Method : approveGatepassEntry starts");

		logger.info("Method : approveGatepassEntry ends");
		return gatePassDao.approveGatepassEntry(approveStatus, getPassEntryId, org, orgDivision);
	}

	// approve for gate-out

	@GetMapping(value = "approveGatepassExit")
	public JsonResponse<DropDownModel> approveGatepassExit(@RequestParam String approveStatus, String getPassExitId,
			String org, String orgDivision) {
		logger.info("Method : approveGatepassExit starts");

		logger.info("Method : approveGatepassExit ends");
		return gatePassDao.approveGatepassExit(approveStatus, getPassExitId, org, orgDivision);
	}

	// delete for gate-in

	@RequestMapping(value = "deleteGatepassEntry", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGatepassEntry(@RequestParam String id, String org,
			String orgDivision) {
		logger.info("Method : deleteGatepassEntry starts");

		logger.info("Method : deleteGatepassEntry ends");
		return gatePassDao.deleteGatepassEntry(id, org, orgDivision);
	}

	// delete for gate-out

	@RequestMapping(value = "deleteGatepassExit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGatepassExit(@RequestParam String id, String org,String orgDivision) {
		logger.info("Method : deleteGatepassExit starts");

		logger.info("Method : deleteGatepassExit ends");
		return gatePassDao.deleteGatepassExit(id, org, orgDivision);
	}

	@GetMapping(value = "getItemAutoSearchListforgate")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemAutoSearchListforgate(
			@RequestParam String id,String org,String orgDiv) {
		logger.info("Method : getItemAutoSearchListforgate starts");

		logger.info("Method :getItemAutoSearchListforgate endss");
		return gatePassDao.getItemAutoSearchListforgate(id,org,orgDiv);
	}
	@GetMapping(value = "getItemAutoSearchNewListForFg")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemAutoSearchNewListForFg(
			@RequestParam String id,String org,String orgDiv) {
		logger.info("Method : getItemAutoSearchNewListForFg starts");
		
		logger.info("Method :getItemAutoSearchNewListForFg endss");
		return gatePassDao.getItemAutoSearchNewListForFg(id,org,orgDiv);
	}
	

	@RequestMapping(value = "gettransportAutoSearchList", method = { RequestMethod.GET })
	public JsonResponse<Object> gettransportAutoSearchList(@RequestParam String id, String org, String  orgDiv) {
		logger.info("Method :gettransportAutoSearchList start");

		logger.info("Method :gettransportAutoSearchList endss");
		return gatePassDao.gettransportAutoSearchList(id,org,orgDiv);
	}
	
	@RequestMapping(value = "getdriverAutoSearchList", method = { RequestMethod.GET })
	public JsonResponse<Object> getdriverAutoSearchList(@RequestParam String id, String org, String  orgDiv) {
		logger.info("Method :getdriverAutoSearchList start");

		logger.info("Method :getdriverAutoSearchList endss");
		return gatePassDao.getdriverAutoSearchList(id,org,orgDiv);
	}

	@RequestMapping(value = "getvehicleAutoSearchList", method = { RequestMethod.GET })
	public JsonResponse<Object> getvehicleAutoSearchList(@RequestParam String id, String org, String  orgDiv) {
		logger.info("Method :getvehicleAutoSearchList start");

		logger.info("Method :getvehicleAutoSearchList endss");
		return gatePassDao.getvehicleAutoSearchList(id,org,orgDiv);
	}

	@RequestMapping(value = "getdepoAutoSearchList", method = { RequestMethod.GET })
	public JsonResponse<Object> getdepoAutoSearchList(@RequestParam String id, String org, String  orgDiv) {
		logger.info("Method :getdepoAutoSearchList start");

		logger.info("Method :getdepoAutoSearchList endss");
		return gatePassDao.getdepoAutoSearchList(id,org,orgDiv);
	}

	@RequestMapping(value = "getvisitList", method = { RequestMethod.GET })
	public JsonResponse<Object> getvisitList(@RequestParam String id, String org,String orgDiv) {
		logger.info("Method :getvisitList start");

		logger.info("Method :getvisitList endss");
		return gatePassDao.getvisitList(id,org,orgDiv);
	}
}

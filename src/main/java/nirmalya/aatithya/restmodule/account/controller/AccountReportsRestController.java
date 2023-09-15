package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountReportsDao;
import nirmalya.aatithya.restmodule.account.model.AccountLedgerReportRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account")
public class AccountReportsRestController {
	Logger logger = LoggerFactory.getLogger(AccountReportsRestController.class);
	@Autowired
	RestAccountReportsDao restReportDao;
	
	/*
	 * for ledger voucher report view
	 */
	@RequestMapping(value="viewLedgerVoucherReport" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerVoucherReport(@RequestParam String id){
		logger.info("Method: viewLedgerVoucherReport View Start");
		logger.info("Method: viewLedgerVoucherReport ends");
		return restReportDao.viewLedgerVoucherReport(id);
	}
	
	/*
	 * for day book voucher report view
	 */
	
	@RequestMapping(value="viewDayBookReport" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewDayBookReport(@RequestParam String fromDate,@RequestParam String toDate){
		logger.info("Method: viewDayBookReport Start");
		logger.info("Method: viewDayBookReport ends");
		return restReportDao.viewDayBookReport(fromDate,toDate);
	}
	
	/*
	 * for cash flow voucher report view
	 */
	
	@RequestMapping(value="viewCashFlowReport" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewCashFlowReport(){
		logger.info("Method: viewCashFlowReport Start");
		logger.info("Method: viewCashFlowReport ends");
		return restReportDao.viewCashFlowReport();
	}
	
	/*
	 * for account statement  monthly ledger summary
	 */
	
	
	@RequestMapping(value="viewLedgerMonthlySummary" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerMonthlySummary(@RequestParam String id){
		logger.info("Method: viewLedgerMonthlySummary Start");
		logger.info("Method: viewLedgerMonthlySummary ends");
		return restReportDao.viewLedgerMonthlySummary(id);
	}
	
	/*
	 * for account statement  monthly details 
	 */
	
	
	@RequestMapping(value="viewMothlyDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewMothlyDetails(@RequestParam String month,@RequestParam String ledgerId){
		logger.info("Method: viewMothlyDetails Start");
		logger.info("Method: viewMothlyDetails ends");
		return restReportDao.viewMothlyDetails(month,ledgerId);
	}
	
	
	/*
	 * for account statement  trialBalanceReport details 
	 */
	
	
	@RequestMapping(value="trialBalanceReport" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> trialBalanceReport(@RequestParam String fromDate,@RequestParam String toDate){
		logger.info("Method: trialBalanceReport Start");
		logger.info("Method: trialBalanceReport ends");
		return restReportDao.trialBalanceReport(fromDate,toDate);
	}
	
	//profitLossReport
	@RequestMapping(value="profitLossReport" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> profitLossReport(@RequestParam String fromDate,@RequestParam String toDate){
		logger.info("Method: profitLossReport Start");
		logger.info("Method: profitLossReport ends");
		return restReportDao.profitLossReport(fromDate,toDate);
	}

}

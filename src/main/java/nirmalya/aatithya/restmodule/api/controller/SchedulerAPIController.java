package nirmalya.aatithya.restmodule.api.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.api.dao.RestCrmDealFinalApiDao;
import nirmalya.aatithya.restmodule.api.dao.SignUpLogInDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
 

@EnableScheduling
@RestController
@RequestMapping(value = "api")
public class SchedulerAPIController {

	@Autowired
	EnvironmentVaribles env;
	
	@Autowired
	SignUpLogInDao sigUpLogInDao;
	@Autowired
	RestCrmDealFinalApiDao restCrmDealFinalApiDao;

	Logger logger = LoggerFactory.getLogger(SchedulerAPIController.class);
	
	/*
	 * @Scheduled(cron = "0 30 12 ? * *") public void scheduleFixedRateTask() throws
	 * Exception { logger.info("Scheduler"); for (int i = 1; i <6; i++) { //
	 * logger.info(i); Date dt = new Date(); Calendar c =
	 * Calendar.getInstance(); c.setTime(dt); c.add(Calendar.DATE, -i); dt =
	 * c.getTime(); SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	 * String attendanceDate = formatter.format(dt); String
	 * organization="Summa Reak Media Private Limited"; String orgDivision="News7";
	 * sigUpLogInDao.getBiometricAttendanceApi(attendanceDate, organization,
	 * orgDivision); } logger.info("After Database"); }
	 * 
	 * @Scheduled(cron = "0 30 15 ? * *") public void scheduleFixedRateTasks()
	 * throws Exception { logger.info("Scheduler");
	 * 
	 * for (int i = 1; i <6; i++) { //logger.info(i); Date dt = new Date();
	 * Calendar c = Calendar.getInstance(); c.setTime(dt); c.add(Calendar.DATE, -i);
	 * dt = c.getTime(); SimpleDateFormat formatter = new
	 * SimpleDateFormat("dd-MM-yyyy"); String attendanceDate = formatter.format(dt);
	 * String organization="Summa Reak Media Private Limited"; String
	 * orgDivision="News7"; sigUpLogInDao.getBiometricAttendanceApi(attendanceDate,
	 * organization, orgDivision); } logger.info("After Database"); }
	 */
	@Scheduled(cron = "0 30 09 ? * *")
	public void scheduleFixedForChequeDate() throws Exception {
		logger.info("Scheduler");
 
			Date dt = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String date = formatter.format(dt);
			logger.info("date");
			restCrmDealFinalApiDao.chequeDateReminder(date);
			
		logger.info("After Database");
	}
 
}

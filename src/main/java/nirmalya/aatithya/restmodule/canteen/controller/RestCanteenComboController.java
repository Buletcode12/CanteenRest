package nirmalya.aatithya.restmodule.canteen.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.canteen.dao.RestCanteenComboDao;

import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping("canteen/")
public class RestCanteenComboController {

	Logger logger = LoggerFactory.getLogger(RestCanteenComboController.class);

	@Autowired
	RestCanteenComboDao restCanteenComboDao;

	

	
	  @RequestMapping(value = "getComboCatagory", method = { RequestMethod.GET })
	  public List<DropDownModel> getIncentive() {
	  logger.info("Method : getIncentive starts");
	  
	  logger.info("Method : getIncentive ends"); return restCanteenComboDao.getincentive();
	  
	  }
	  
	  @RequestMapping(value = "getComboSubCatagiry", method = { RequestMethod.GET })
	  public List<DropDownModel> getClubMembers() {
	  logger.info("Method : getClubMembers starts");
	  
	  logger.info("Method : getClubMembers ends"); return
	  restCanteenComboDao.getClubMembers();
	  
	  }
	  
	  @RequestMapping(value = "getCombovariants", method = { RequestMethod.GET }) public
	  List<DropDownModel> getvariants() {
	  logger.info("Method : getvariants starts");
	  
	  logger.info("Method : getvariants ends"); return restCanteenComboDao.getvariants();
	  
	  }
	 
	
	//Add
	@RequestMapping(value="restcomboadd" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addIncentive(@RequestBody List <RestMenuModel> incentiveDetails) 
	{
		logger.info("Method : addrestcomboadddetails starts");
		
		logger.info("Method : addrestcomboadddetails ends");
		
		return restCanteenComboDao.addIncentiveDetails(incentiveDetails);
	}
	

	//View
		@RequestMapping(value="restViewCombo" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewShoukeenIncentive( String CatId ,String SubCatId ,String variant ){
			logger.info("Method: restViewCombo View Start");
			
			logger.info("Method: restViewCombo ends");
			return restCanteenComboDao.viewCombo(CatId, SubCatId, variant);
		}
		
	

}

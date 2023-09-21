package nirmalya.aatithya.restmodule.canteen.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCanteenComboParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateCanteenMenuParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@Repository
public class RestCanteenComboDao {

	
	Logger logger = LoggerFactory.getLogger(RestMenuDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getincentive() {
		logger.info("Method : getincentive starts");

		List<DropDownModel> getincentive = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "incentivestats").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getincentive.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPaymentModeList ends");

		System.out.println("getincentive=======>" + getincentive);
		return getincentive;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getClubMembers() {
		logger.info("Method : getClubMembers starts");

		List<DropDownModel> getClubList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "clubMemberList")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getClubList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getClubMembers ends");

		System.out.println("getClubMembers=======>" + getClubList);
		return getClubList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getvariants() {
		logger.info("Method : getvariants starts");

		List<DropDownModel> getClubList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "variants")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getClubList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getvariants ends");

		System.out.println("getvariants=======>" + getClubList);
		return getClubList;
	}
	
	// Add
	public ResponseEntity<JsonResponse<Object>> addIncentiveDetails(List <RestMenuModel> incentiveDetails) {

		logger.info("Method in Dao: addIncentiveDetailsdao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateCanteenComboParameter.addcanteenComboParam(incentiveDetails);
			System.out.println(values);
			if (incentiveDetails.get(0).getItemId() != "" || incentiveDetails.get(0).getItemId() != null) {
       System.out.println("addd part");
				em.createNamedStoredProcedureQuery("canteen-combo")
						.setParameter("actionType", "addCombo")
						.setParameter("actionValue", values).execute();

			} else {
				System.out.println("modify part");
				em.createNamedStoredProcedureQuery("canteen-combo")
						.setParameter("actionType", "modifymenu")
						.setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao:addIncentiveDetailsdao ends" + response);

		return response;
	}
	
	

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> viewCombo( String CatId ,String SubCatId ,String Variant) {
		logger.info("Method : viewCombo starts");
		List<RestMenuModel> respList = new ArrayList<RestMenuModel>();
		
		String value = "SET @p_catId='" + CatId + "',@p_subcatid='" + SubCatId + "',@p_varId='" + Variant + "';";
		System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "viewCombo")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2]);
				respList.add(restPayroll);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new ResponseEntity<JsonResponse<List<RestMenuModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : viewCombo ends");
		return response;

	}
	
	
	
	   
}

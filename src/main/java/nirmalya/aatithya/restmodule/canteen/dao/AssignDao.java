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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
@Repository
public class AssignDao {
	
	Logger logger = LoggerFactory.getLogger(AssignDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> viewShoukeenIncentive() {
		logger.info("Method : viewincentivedao starts");
		List<RestMenuModel> respList = new ArrayList<RestMenuModel>();
		
		System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+respList);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
					.setParameter("actionType", "viewmenuCombo").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2]
						);
				
				respList.add(restPayroll);
				
				System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,"+restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new ResponseEntity<JsonResponse<List<RestMenuModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : viewincentivedao ends");

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	

}

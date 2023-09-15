/**
 * Repository for user handling related call
**/
package nirmalya.aatithya.restmodule.user.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.model.User;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class UserLoginDao {

	Logger logger = LoggerFactory.getLogger(UserLoginDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EnvironmentVaribles env;

	/**
	 * function to return user by name
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<User>> getUserByUsername(String username) {
		logger.info("Method : getUserByUsername starts");

		JsonResponse<User> jsonResponse = new JsonResponse<User>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");

		List<User> userArray = new ArrayList<User>();
		List<String> userRole = new ArrayList<String>();

		try {

			String value = "SET @p_userName='" + username + "';";
			logger.info("value web==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
					.setParameter("actionType", "getByName").setParameter("actionValue", value).getResultList();
             logger.info("cc"+x);
			for (Object[] m : x) {
				String role = (String) m[6];

				if (role != null && role.length() > 0) {
					String[] roles = role.split(",");
					userRole = Arrays.asList(roles);
				}
				String orglogo = null;
				if (m[16] != null && m[16] != "" && m[16] != " " && !m[16].toString().equals(" ")
						&& !m[16].toString().equals(null) && !m[16].toString().equals("")) {
					orglogo = env.getMobileView()+"document/document/"+m[16].toString();
				} else {
					orglogo = "";
				}
	
				User user = new User(m[0], m[1], m[2], m[3], m[4], null, null, null, null, null, null, m[5], null, null,
						userRole, m[7], m[8], m[9], m[10], m[11], m[12],m[13],m[14],m[15],orglogo,m[17],null);
				userArray.add(user);
			}

			if (userArray.size() > 0) {
				jsonResponse.setBody(userArray.get(0));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<User>> response = new ResponseEntity<JsonResponse<User>>(jsonResponse,
				HttpStatus.OK);
		logger.info("Method : getUserByUsername ends");
logger.info("response web ==="+response);
		return response;

	}

	/**
	 * function to register user
	 *
	 */
	public ResponseEntity<JsonResponse<String>> registerUser(User user) {
		logger.info("Method : registerUser starts");

		JsonResponse<String> jsonResponse = new JsonResponse<String>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");

		try {
			String value = GenerateUserParameter.getUserParam(user);
logger.info("value==="+value);
			em.createNamedStoredProcedureQuery("userRoutines").setParameter("actionType", "getByName")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				String[] err = serverDao.errorProcedureCall(e);

				jsonResponse.setCode(err[0]);
				jsonResponse.setMessage(err[1]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<String>> response = new ResponseEntity<JsonResponse<String>>(jsonResponse,
				HttpStatus.OK);
		logger.info("Method : registerUser ends");

		return response;

	}
	@SuppressWarnings("unchecked")
	public User loadUserByName(String username) {
		logger.info("Method : getUserByUsername starts");

		List<User> userArray = new ArrayList<User>();
		List<String> userRole = new ArrayList<String>();
		
		String value = "SET @p_userName='" + username + "';";
logger.info("value mob======"+value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
					.setParameter("actionType", "getByName-mob").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				logger.info("x==="+Arrays.toString(m));
				String role = (String) m[6];

				if (role != null && role.length() > 0) {
					String[] roles = role.split(",");
					userRole = Arrays.asList(roles);
				}
				
				Boolean boolean1 = false;
				if(m[5].toString() != null) { 
					String data = m[5].toString();
					logger.info(data);
					if(data.contentEquals("1")) {
						boolean1 = true;
					} else {
						boolean1 = false;
					}
				}
				String orglogo = null;
				if (m[16] != null && m[16] != "" && m[16] != " " && !m[16].toString().equals(" ")
						&& !m[16].toString().equals(null) && !m[16].toString().equals("")) {
					orglogo = env.getMobileView()+"document/document/"+m[16].toString();
				} else {
					orglogo = "";
				}
				String profileImg = null;
				if (m[17] != null && m[17] != "" && m[17] != " " && !m[17].toString().equals(" ")
						&& !m[17].toString().equals(null) && !m[17].toString().equals("")) {
					profileImg = env.getMobileView()+"document/employee/"+m[17].toString();
				} else {
					profileImg = "";
				}
	

				User user = new User(m[0].toString(), m[1], m[2], m[3], m[4], null, null, null, null, null, null, boolean1, null, null,
						userRole, m[7], m[8], m[9], m[10], m[11], null,m[13],m[14],m[15],orglogo,profileImg,null);
				
				userArray.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		logger.info("Method : getUserByUsername ends");
		logger.info("response mobile ==="+userArray.get(0));
		return userArray.get(0);

	}

}

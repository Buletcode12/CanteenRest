package nirmalya.aatithya.restmodule.ticket.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@Repository
public class DepartmentViewDao {
	
	Logger logger = LoggerFactory.getLogger(DepartmentViewDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	// Priority List.
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deptViewPriorityList(String orgName, String orgDivision ) {
		logger.info("Method : deptViewPriorityList Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision +  "';";
			System.out.println("values****************************" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_department_view_Routines")
					.setParameter("actionType", "deptViewPriorityList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : deptViewPriorityList Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

}

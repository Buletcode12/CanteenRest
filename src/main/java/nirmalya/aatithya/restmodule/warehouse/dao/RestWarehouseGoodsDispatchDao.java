package nirmalya.aatithya.restmodule.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseGoodsBlockingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class RestWarehouseGoodsDispatchDao {
	Logger logger = LoggerFactory.getLogger(RestWarehouseGoodsDispatchDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	//viewRequestedDispatchGoods
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRequestedDispatchGoods(String orgName, String orgDivision) {
		logger.info("Method : viewBlockData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseGoodsDispatchRoutine")
					.setParameter("actionType", "viewRequestedDispatchGoods").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewBlockData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

	//getBlockingDataforDispatch
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getBlockingDataforDispatch(String warehouse,String block,String orgName, String orgDiv) {
		logger.info("Method : getBlockingDataforDispatch Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_warehouseId='" + warehouse + "',@p_blockId='" + block + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseGoodsDispatchRoutine")
					.setParameter("actionType", "getBlockingDataforDispatch").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : getBlockingDataforDispatch Dao ends");
		return resp;

	}
	
	//Save
	public JsonResponse<WirehouseRomeModel> modifyDispatchData(String warehouseId, String blockId,String bdata, String orgName,String orgDivision) {
		logger.info("Method : modifyDispatchData starts");

		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
		try {
			
			String value = "SET @p_warehouseId='" + warehouseId + "',@p_blockId='" + blockId + "',@p_bdata='(" + bdata + ")',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"';";
			System.out.println("value==="+value);
			em.createNamedStoredProcedureQuery("warehouseGoodsDispatchRoutine").setParameter("actionType", "modifyDispatchData")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Goods Dispatched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		System.out.println("resp==="+resp);
		logger.info("Method : modifyDispatchData ends");
		return resp;
	}
}


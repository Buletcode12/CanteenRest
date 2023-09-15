package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateExtendExitManagementParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;

@Repository
public class ExtendExitManagementRestDao {
	Logger logger = LoggerFactory.getLogger(ExtendExitManagementRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * add name list
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> namelist() {
		logger.info("Method : namelist Dao starts");

		List<DropDownModel> namelist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getEmpNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				namelist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : namelist Dao ends");

		return namelist;
	}

	/*
	 * Department list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> deptList() {
		logger.info("Method : deptList Dao starts");

		List<DropDownModel> departmentList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getDeptList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : deptList Dao ends");

		return departmentList;
	}

	/*
	 * Clearance Person list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> clrncPersonList() {
		logger.info("Method : clrncPersonList Dao starts");

		List<DropDownModel> clrncPtList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getclrncPtList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				clrncPtList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : clrncPersonList Dao ends");

		return clrncPtList;
	}

	/*
	 *  job list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDesignationList(String id) {

		logger.info("Method : getDesignationList starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tGuestName='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getEmpDeginationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}

			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDesignationList ends");
		return resp;
	}

	/*
	 *  View Exit Management
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewExtendExitManagementDtls(String userId,String userRole,String organization,String orgDivision) {

		logger.info("Method in Dao: viewExtendExitManagementDtls starts");

		List<ExtendExitManagementRestModel> exitDtlsList = new ArrayList<ExtendExitManagementRestModel>();
		String value = "SET @P_userId='" + userId + "',@P_userRole='" + userRole + "',@P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewExitManagement").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
logger.info(Arrays.toString(m));
				Object DATE = null;
				if (m[7] != null) {
					DATE = DateFormatter.returnStringDate(m[7]);
				}
				Object DATER = null;
				if (m[8] != null) {
					DATER = DateFormatter.returnStringDate(m[8]);
				}

				ExtendExitManagementRestModel exitManagementModel = new ExtendExitManagementRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], DATE, DATER, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
						m[17].toString(),m[18],m[19],m[20],m[21],m[22],m[23],m[24]);
				exitDtlsList.add(exitManagementModel);

			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ExtendExitManagementRestModel>> resp = new JsonResponse<List<ExtendExitManagementRestModel>>();
		resp.setBody(exitDtlsList);

		logger.info("Method in Dao: viewExtendExitManagementDtls ends");

		return resp;
	}

	/*
	 * View Clearance
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewClrncDtls() {

		logger.info("Method in Dao: viewClrncDtls starts");

		List<ExtendExitManagementRestModel> clrncDtlsList = new ArrayList<ExtendExitManagementRestModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewClrncDtls").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				ExtendExitManagementRestModel exitManagementModel = new ExtendExitManagementRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9],m[10],null,null,null,null,null,null,null,null,null,null,null,null,null,null);
				clrncDtlsList.add(exitManagementModel);
			}
		}

		/*
		 * if (x.get(0).length > 14) { BigInteger t = (BigInteger) x.get(0)[14];
		 *
		 * total = Integer.parseInt((t.toString())); }
		 */

		catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ExtendExitManagementRestModel>> resp = new JsonResponse<List<ExtendExitManagementRestModel>>();
		resp.setBody(clrncDtlsList);

		logger.info("Method in Dao: viewClrncDtls ends");

		return resp;
	}

	/*
	 * Add Exit Management
	 * 
	 */

	public JsonResponse<Object> addExitManagement(ExtendExitManagementRestModel exit) {

		logger.info("Method : addExitManagement starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateExtendExitManagementParameter.getAddExitManagementParam(exit);

			if (exit.getEmployeeExit() == null || exit.getEmployeeExit() == "") {
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "addExitManagement")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "modifyExitManagement")
						.setParameter("actionValue", values).execute();
			}
		} catch(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("Method : addExitManagement ends");
		return resp;
	}

	/*
	 * Add Clearance
	 * 
	 */
	public JsonResponse<Object> addClearanceDetailsDao(ExtendExitManagementRestModel exit) {
		logger.info("Method : addClearanceDetailsDao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateExtendExitManagementParameter.getAddClearanceParam(exit);
			if (exit.getClearanceId() == null || exit.getClearanceId() == "") {
				 em.createNamedStoredProcedureQuery("exitmanagement")
						.setParameter("actionType", "addClrncDtls").setParameter("actionValue", values)
						.execute();
					resp.setCode("success");
					resp.setMessage("Data saved successfully");
			} else {
					em.createNamedStoredProcedureQuery("exitmanagement")
						.setParameter("actionType", "modifyClrncDtls").setParameter("actionValue", values)
						.execute();
					resp.setCode("success");
					resp.setMessage("Data modified successfully");
			}
		}catch(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if(err[1].equals("Duplicate entry 'x' for  'tbl_employee_exit_clearance.PRIMARY'")) {
					resp.setCode("failed");
					resp.setMessage("You are already done");
				}else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				}
			} catch (Exception e1) {
				resp.setCode("failed");
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
		}
 
		logger.info("Method : addClearanceDetailsDao ends");
		return resp;
	}

	/*
	 * Edit Exit Management
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<ExtendExitManagementRestModel> editManagementDetails(String id,String organization,String orgDivision) {
		logger.info("Method : editManagementDetails starts");

		ExtendExitManagementRestModel req = new ExtendExitManagementRestModel();
		JsonResponse<ExtendExitManagementRestModel> resp = new JsonResponse<ExtendExitManagementRestModel>();

		try {

			String value = "SET @p_exitMangementId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "editExitManagement").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[7] != null) {
					DATE = DateFormatter.returnStringDate(m[7]);
				}
				Object DATER = null;
				if (m[8] != null) {
					DATER = DateFormatter.returnStringDate(m[8]);
				}

				ExtendExitManagementRestModel reqEdit = new ExtendExitManagementRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], DATE, DATER, m[9], m[10], m[11], m[12], null, null, null, null, null,null,null,null,null,null,null,null);
				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editManagementDetails ends");

		return resp;
	}

	/*
	 * Delete Exit Management Details
	 * 
	 */

	public JsonResponse<ExtendExitManagementRestModel> deleteExitDetails(String deleteId) {
		logger.info("Method : deleteExitDetails starts");

		ExtendExitManagementRestModel req = new ExtendExitManagementRestModel();
		JsonResponse<ExtendExitManagementRestModel> resp = new JsonResponse<ExtendExitManagementRestModel>();

		try {

			String value = "SET @p_exitMangementId='(" + deleteId + ")';";
			logger.info("value===="+value);

			em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "deleteExitDetails")
					.setParameter("actionValue", value).execute();

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}


		logger.info("Method : deleteExitDetails ends");

		return resp;
	}
	
	
	/*
	 * Add Finance Details
	 * 
	 */

	public JsonResponse<Object> addFinanceDetails(ExtendExitManagementRestModel exit) {

		logger.info("Method : addFinanceDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateExtendExitManagementParameter.getAddFinanceDetailsParam(exit);

			if (exit.getFinanceId() == null || exit.getFinanceId() == "") {

				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "addFinanceDetails")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "modifyFinanceDetails")
						.setParameter("actionValue", values).execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("Method : addFinanceDetails ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> viewdeptClearanceDetails(String userid) {

		logger.info("Method : viewdeptClearanceDetails starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId='" + userid + "';";
		logger.info("value=="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewDeptClearanceDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
			
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewdeptClearanceDetails ends");
		
		logger.info("LISTTTT" + resp);
		return resp;
	}
 
	/*
	 *  View Exit Clearance
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewExitClearance(String userId,String exitid,String organization,String orgDivision) {

		logger.info("Method in Dao: viewExitClearance starts");

		List<ExtendExitManagementRestModel> exitDtlsList = new ArrayList<ExtendExitManagementRestModel>();
		String value = "SET @P_userId='" + userId + "',@P_exitid='" + exitid + "',@P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		logger.info("value===="+value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewExitClearance").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				ExtendExitManagementRestModel reqEdit = new ExtendExitManagementRestModel(m[0],m[1],m[2], 
						m[3], m[4], m[5],m[6], m[7],m[8]);
				exitDtlsList.add(reqEdit);

			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ExtendExitManagementRestModel>> resp = new JsonResponse<List<ExtendExitManagementRestModel>>();
		resp.setBody(exitDtlsList);

		logger.info("Method in Dao: viewExitClearance ends");

		return resp;
	}
	/*
	 * Edit Exit Management
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<ExtendExitManagementRestModel> editClearance(String id,String organization,String orgDivision) {
		logger.info("Method : editClearance starts");

		ExtendExitManagementRestModel req = new ExtendExitManagementRestModel();
		JsonResponse<ExtendExitManagementRestModel> resp = new JsonResponse<ExtendExitManagementRestModel>();
		try {
			String value = "SET @p_clearanceId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "editClearance").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ExtendExitManagementRestModel reqEdit = new ExtendExitManagementRestModel(m[0],m[1],m[2], 
						m[3], m[4], m[5],m[6], m[7],m[8]);
				req = reqEdit;
			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editClearance ends");
		return resp;
	}
}
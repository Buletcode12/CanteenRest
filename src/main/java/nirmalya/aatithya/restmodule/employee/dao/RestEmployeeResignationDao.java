package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeResignationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeResignationModel;

@Repository
public class RestEmployeeResignationDao {
	
	Logger logger = LoggerFactory.getLogger(RestEmployeeResignationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	// employee list
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeLists(String orgName, String orgDivision) {
		logger.info("Method : getEmployeeLists starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "getEmployeeLists").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeLists ends");
		return emplist;
	}
	// employee list cc
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeListsCC(String orgName, String orgDivision,String managerId,String userId) {
		logger.info("Method : getEmployeeListsCC starts");
		
		List<DropDownModel> emplist = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\",@p_managerId=\"" + managerId + "\",@p_userId=\"" + userId + "\";";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "getEmployeeListsCC").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				emplist.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getEmployeeListsCC ends");
		return emplist;
	}
	//Resign Add Draft
		@SuppressWarnings({ "unused" })
		public ResponseEntity<JsonResponse<List<RestEmployeeResignationModel>>> resignationApplyDraftDao(
				List<RestEmployeeResignationModel> restEmployeeResignationModel) {

			logger.info("Method : resignationApplyDraftDao starts");
			boolean validation = true;
			List<RestEmployeeResignationModel> listData = new ArrayList<RestEmployeeResignationModel>();
			JsonResponse<List<RestEmployeeResignationModel>> resp = new JsonResponse<List<RestEmployeeResignationModel>>();

			
			resp.setMessage("");
			resp.setCode("");
			String errorCode = "Field Validation Error";
			
				try {
					String value = GenerateEmployeeResignationParameter.getEmployeeResignationParam(restEmployeeResignationModel);
					if (restEmployeeResignationModel.get(0).getResignationDraftId().equals("")|| restEmployeeResignationModel.get(0).getResignationDraftId().equals(null) ) {
					logger.info("if");
						em.createNamedStoredProcedureQuery("resignationRoutines")
								.setParameter("actionType", "resignationApplyDraft").setParameter("actionValue", value)
								.execute();

						
					}else {
						logger.info("else");
						em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "modifyResignationApplyDraft").setParameter("actionValue", value)
						.execute();

					}
				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			resp.setBody(listData);
			ResponseEntity<JsonResponse<List<RestEmployeeResignationModel>>> response = new ResponseEntity<JsonResponse<List<RestEmployeeResignationModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("response==="+response);
			logger.info("Method : resignationApplyDraftDao ends");
			return response;

		}
		// view Resignation Draft
		@SuppressWarnings("unchecked")
		public JsonResponse<List<RestEmployeeResignationModel>> viewResignationDraft(String userId ,String userRole,String organization,String orgDivision) {

			logger.info("Method : viewResignationDraft Dao starts");
			List<RestEmployeeResignationModel> viewregapply = new ArrayList<RestEmployeeResignationModel>();
			JsonResponse<List<RestEmployeeResignationModel>> resp = new JsonResponse<List<RestEmployeeResignationModel>>();
			try {

				String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")',@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\";";
				logger.info("value==="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "viewResignationDraft").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {

					Object ResignDATE = null;
					if (m[7] != null) {
						ResignDATE = m[7].toString();
					}
					Object ReleaseDATE = null;
					if (m[8] != null) {
						ReleaseDATE = m[8].toString();
					}
					
					RestEmployeeResignationModel reg = new RestEmployeeResignationModel( m[0],null,m[1],m[2],m[3],m[4],m[5],m[6],ResignDATE,ReleaseDATE,m[9],m[10]);
					
					viewregapply.add(reg);
					resp.setBody(viewregapply);

					}
				} catch (Exception e) {
					logger.error("viewResignationDraft: "+e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp==="+resp);
			logger.info("Method : viewResignationDraft Dao ends");
			return resp;

		}		
		
		
		//edit Resignation apply Draft
		
		@SuppressWarnings("unchecked")
		public JsonResponse<List<RestEmployeeResignationModel>> editResignationApplyDraft(String id) {

			logger.info("Method : editResignationApplyDraft Dao starts");

			List<RestEmployeeResignationModel> regapply = new ArrayList<RestEmployeeResignationModel>();
			JsonResponse<List<RestEmployeeResignationModel>> resp = new JsonResponse<List<RestEmployeeResignationModel>>();

			try {

				String value = "SET @p_resignationDraftId='" + id + "';";
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "editResignationApplyDraft").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					Object ResignDATE = null;
					if (m[7] != null) {
						ResignDATE = m[7].toString();
					}
					Object ReleaseDATE = null;
					if (m[8] != null) {
						ReleaseDATE = m[8].toString();
					}
					RestEmployeeResignationModel reg = new RestEmployeeResignationModel( m[0],null,m[1],m[2],m[3],m[4],m[5],m[6],ResignDATE,ReleaseDATE,m[9],m[10]);
					
					regapply.add(reg);
				}
				
			} catch (Exception e) {
				logger.error("editResignationApplyDraft: "+e.getMessage());
				e.printStackTrace();
			}
			resp.setBody(regapply);
			logger.info("Method : editResignationApplyDraft Dao ends");
			return resp;

		}
		
		//delete Resignation apply details
		
		public JsonResponse<RestEmployeeResignationModel> deleteResignationApply(String id) {
			logger.info("Method : deleteResignationApply starts");

			RestEmployeeResignationModel req = new RestEmployeeResignationModel();
			JsonResponse<RestEmployeeResignationModel> resp = new JsonResponse<RestEmployeeResignationModel>();

			try {

				String value = "SET @p_resignationId='" + id + "';";
				logger.info("value==="+value);
				em.createNamedStoredProcedureQuery("resignationRoutines").setParameter("actionType", "deleteResignationApply")
						.setParameter("actionValue", value).execute();

				resp.setBody(req);
			} catch (Exception e) {
				logger.error("deleteResignationApply: "+e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : deleteResignationApply ends");
			return resp;
		}
		
		
		
		
		
		
//Resign Add
	@SuppressWarnings({ "unused" })
	public ResponseEntity<JsonResponse<List<RestEmployeeResignationModel>>> resignationApplyDao(
			List<RestEmployeeResignationModel> restEmployeeResignationModel) {

		logger.info("Method : resignationApplyDao starts");
		boolean validation = true;
		List<RestEmployeeResignationModel> listData = new ArrayList<RestEmployeeResignationModel>();
		JsonResponse<List<RestEmployeeResignationModel>> resp = new JsonResponse<List<RestEmployeeResignationModel>>();
		
		resp.setMessage("");
		resp.setCode("");
		String errorCode = "Field Validation Error";
		
			try {
				String value = GenerateEmployeeResignationParameter.getEmployeeResignationParam(restEmployeeResignationModel);
				if (restEmployeeResignationModel.get(0).getResignationId() == "" || restEmployeeResignationModel.get(0).getResignationId() == null) {
				logger.info("if");
					em.createNamedStoredProcedureQuery("resignationRoutines")
							.setParameter("actionType", "resignationApply").setParameter("actionValue", value)
							.execute();

					
				}else {
					logger.info("else");
					em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "modifyResignationApply").setParameter("actionValue", value)
					.execute();

				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestEmployeeResignationModel>>> response = new ResponseEntity<JsonResponse<List<RestEmployeeResignationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : resignationApplyDao ends");
		return response;

	}
	//Method for mail API
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getMailDetails(String mylist) {
		logger.info("Method : getMailDetails starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_id='" + mylist + "';";
				logger.info(value);
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "getEmailLists").setParameter("actionValue", value).getResultList();
				//System.err.println(x);
				for (Object[] m : x) {
					//DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					logger.info("hi"+m[1]);
					resp.setBody(m[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getMailDetails ends");
		return response;
	}
	// view Resignation
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeResignationModel>> viewResignation(String userId ,String userRole) {

		logger.info("Method : viewResignation Dao starts");
		List<RestEmployeeResignationModel> viewregapply = new ArrayList<RestEmployeeResignationModel>();
		JsonResponse<List<RestEmployeeResignationModel>> resp = new JsonResponse<List<RestEmployeeResignationModel>>();
		try {

			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "viewResignation").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object ResignDATE = null;
				if (m[7] != null) {
					ResignDATE = m[7].toString();
				}
				Object ReleaseDATE = null;
				if (m[8] != null) {
					ReleaseDATE = m[8].toString();
				}
				
				RestEmployeeResignationModel reg = new RestEmployeeResignationModel( null,m[0],m[1],m[2],m[3],m[4],m[5],m[6],ResignDATE,ReleaseDATE,m[9],m[10]);
				
				viewregapply.add(reg);
				resp.setBody(viewregapply);

				}
			} catch (Exception e) {
				logger.error("viewResignation: "+e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp==="+resp);
		logger.info("Method : viewResignation Dao ends");
		return resp;

	}
	/*
	 * Get Employee Name for choosen Js(Edit)
	 */
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getEmpName(String id) {
		logger.info("Method : getEmpName starts");
		List<DropDownModel> form = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_id='" + id + "';";
			logger.info("draft Param: " + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "getEmpName").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel sectionMaster = new DropDownModel(m[0], m[1]);
					form.add(sectionMaster);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<DropDownModel> servicemaster = new JsonResponse<DropDownModel>();
		servicemaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(
				servicemaster, HttpStatus.CREATED);
		logger.info("Method : getEmpName ends");
		return response;
	}
}

package nirmalya.aatithya.restmodule.recruitment.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.RestGenerateOfferLetterModel;

@Repository
public class GenerateOfferLetterDao {

	Logger logger = LoggerFactory.getLogger(GenerateOfferLetterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestGenerateOfferLetterModel>> createOfferLetter(String candId,String bandid,String offerLetterId,String org,String orgDiv) {
		// TODO Auto-generated method stub
		JsonResponse<RestGenerateOfferLetterModel> resp = new JsonResponse<RestGenerateOfferLetterModel>();
		RestGenerateOfferLetterModel modellist = new RestGenerateOfferLetterModel();
		String value = "Set @p_candId=\""+candId+"\",@p_bandid=\""+bandid+"\",@p_offerLetterId=\""+offerLetterId+"\",@p_org=\""+org+"\",@p_orgDiv=\""+orgDiv+"\";";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "viewOfferLeterPdf").setParameter("actionValue",value)
					.getResultList();
			for (Object[] m : x) {
				RestGenerateOfferLetterModel dropDownModel = new RestGenerateOfferLetterModel(m[0].toString(), m[1].toString(), null,m[2].toString(), m[3].toString(), m[4].toString(), 
						m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(),m[9].toString(), m[10].toString(), m[11].toString(),
						m[12].toString(),m[13].toString(), m[14].toString(), m[15].toString(), m[16].toString(), m[17].toString(),m[18].toString(),
						m[19].toString(),m[20].toString(),m[21].toString(),m[22].toString(),m[23].toString(),m[24].toString(),m[25].toString(),
						m[26].toString(),m[27].toString(),m[28].toString(),m[29].toString(),m[30].toString(),m[31].toString(),m[32].toString(),
						m[33].toString(),m[34].toString(),m[35].toString(),m[36],m[37],m[38],m[39],m[40]);
				
				modellist=dropDownModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(modellist);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestGenerateOfferLetterModel>> response = new ResponseEntity<JsonResponse<RestGenerateOfferLetterModel>>(
		resp, responseHeaders, HttpStatus.CREATED);
		logger.info("resp==="+resp);
		return response;
	}
	
	

}

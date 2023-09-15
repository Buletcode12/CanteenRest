package nirmalya.aatithya.restmodule.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;

public class DocumentUpload {

	@Autowired
	EnvironmentVaribles env;
	
	Logger logger = LoggerFactory.getLogger(DocumentUpload.class);
	
	public String saveAllTypeDocument(byte[] bytes, String ext, String id, String docfor) {
		logger.info("Method : saveAllTypeDocument starts");

		String documentName = null;

		try {

			if (!Util.isNull(bytes)) {
				long nowTime = new Date().getTime();
				if (ext.contentEquals("jpeg")) {
					documentName = id + "_" + nowTime + ".jpg";
				} else {
					documentName = id + "_" + nowTime + "." + ext;
				}

			}
			Path path = null;
			if(docfor.toUpperCase().equals("PROFILE")) {
				path = Paths.get(env.getFileUploadProfile() + documentName);
			}
			if(docfor.toUpperCase().equals("CRM_PROFILE")) {
				path = Paths.get(env.getFileUploadCRM() + documentName);
				logger.info("path===="+documentName);
			}
			if(docfor.toUpperCase().equals("TRAVELCLAIM")) {
				path = Paths.get(env.getFileUploadDocumenttUrl() + documentName);
			}
			
			if(docfor.toUpperCase().equals("UPLOADDOCUMENT")) {
				path = Paths.get(env.getFileUploadDocumenttUrl() + documentName);
			}
			if (!Util.isNull(bytes)) {

				if (!StringUtil.isNull(id)) {
					Files.write(path, bytes);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		logger.info("Method : saveAllTypeDocument ends");
		return documentName;
	}
	
	public String saveAllMedicalDocuments(byte[] bytes, String ext, String id, String filetype) {
		logger.info("Method : saveAllMedicalDocuments starts");

		String documentName = null;

		try {

			if (!Util.isNull(bytes)) {
				long nowTime = new Date().getTime();
				
				if(filetype.equals("vdo")) {
					ext = "mp4";
				}
				
				if (ext.contentEquals("jpeg")) {
					documentName = id + "_" + nowTime + ".jpg";
				} else {
					documentName = id + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getFileUploadProfile() + documentName);
			if (!Util.isNull(bytes)) {
				if (!StringUtil.isNull(id)) {
					Files.write(path, bytes);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : saveAllMedicalDocuments ends");
		return documentName;
	}
	
	/*public void saveEcgFile(byte[] bytes, String ext, String id, String docfor) {
		logger.info("Method : saveEcgFile starts");

		String documentName = null;
		
		String filePath = env.getLogfiles()+"ecg_log.txt";
		String[] patientId = id.split("_");

		try {

			if (!Util.isNull(bytes)) {
				if (ext.contentEquals("jpeg")) {
					documentName = id + ".jpg";
				} else {
					documentName = id + "." + ext;
				}

			}
			Path path = null;
			if(docfor.toUpperCase().equals("ECG")) {
				path = Paths.get(env.getEcgUrl() + documentName);
			}
			
			if (!Util.isNull(bytes)) {
				if (!StringUtil.isNull(id)) {
					Files.write(path, bytes);
				}
			}
			

			FileWrite.ecgLogWrite(filePath, patientId[0], ApiResponseMessage.ECG_SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			e.printStackTrace();
			FileWrite.ecgLogWrite(filePath, patientId[0], e.getMessage());
			logger.error(e.getMessage());
		}
*/
	
	 
	
}

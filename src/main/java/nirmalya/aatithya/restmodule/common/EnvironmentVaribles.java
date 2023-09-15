package nirmalya.aatithya.restmodule.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Nirmalya Labs
 *
 */
public class EnvironmentVaribles {

	@Value("${service.url.baseURL}")
	private String baseURL;

	@Value("${service.url.mobileView}")
	private String mobileView;

	@Value("${service.url.uploadEmployee}")
	private String fileUploadEmployee;

	@Value("${service.url.uploadReimbursement}")
	private String fileUploadReimbursement;
	
	@Value("${service.url.uploadImageCrm}")
	private String fileUploadCRM;

	@Value("${service.url.uploadProfile}")
	private String fileUploadProfile;

	@Value("${service.url.mobileDocView}")
	private String mobileDocView;

	@Value("${service.url.fileUpload-document}")
	private String fileUploadDocumenttUrl;

	@Value("${service.url.fileUpload-taskdocument}")
	private String fileUploadtaskdocumentUrl;

	public String getFileUploadtaskdocumentUrl() {
		return fileUploadtaskdocumentUrl;
	}
	public EnvironmentVaribles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMobileView() {
		return mobileView;
	}

	public String getFileUploadEmployee() {
		return fileUploadEmployee;
	}

	public String getFileUploadReimbursement() {
		return fileUploadReimbursement;
	}

	public String getFileUploadProfile() {
		return fileUploadProfile;
	}

	public String getFileUploadDocumenttUrl() {
		return fileUploadDocumenttUrl;
	}

	
	public String getBaseUrl() {
		return baseURL;
	}

	public String getMobileDocView() {
		return mobileDocView;
	}

	public String getFileUploadCRM() {
		return fileUploadCRM;
	}

}

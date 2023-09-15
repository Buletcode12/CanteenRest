package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestDocumentModel;


public class GenerateAssetViewMaster {
	public static String getAddasset(List<AssetViewMasterRestModel> av) {
		String s = "";
		String sitem = "";
		String sitem1 = "";
		String document = "";

		if (av.get(0).getAssetId() != null || av.get(0).getAssetId() != "") {
			s = s + "@p_assetId='" + av.get(0).getAssetId() + "',";
		}

		if (av.get(0).getPdate() != null || av.get(0).getPdate() != "") {
			s = s + "@p_pdate='" + av.get(0).getPdate() + "',";
		}

		if (av.get(0).getAssetcat() != null || av.get(0).getAssetcat() != "") {
			s = s + "@p_assetcat='" + av.get(0).getAssetcat() + "',";
		}
		if (av.get(0).getAssetname() != null || av.get(0).getAssetname() != "") {
			s = s + "@p_assetname='" + av.get(0).getAssetname() + "',";
		}
		if (av.get(0).getAssetsubcat() != null || av.get(0).getAssetsubcat() != "") {
			s = s + "@p_assetsubcat='" + av.get(0).getAssetsubcat() + "',";
		}
		if (av.get(0).getAssettype() != null || av.get(0).getAssettype() != "") {
			s = s + "@p_assettype='" + av.get(0).getAssettype() + "',";
		}
		if (av.get(0).getLifespan() != null || av.get(0).getLifespan() != "") {
			s = s + "@p_lifespan='" + av.get(0).getLifespan() + "',";
		}
		if (av.get(0).getPurchaseno() != null || av.get(0).getPurchaseno() != "") {
			s = s + "@p_purchaseno='" + av.get(0).getPurchaseno() + "',";
		}
		if (av.get(0).getWstatus() != null || av.get(0).getWstatus() != "") {
			s = s + "@p_wstatus='" + av.get(0).getWstatus() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}

		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}

		for (AssetViewMasterRestModel m : av) {

			if(m.getCategory()!="" || m.getCategory()!=null) {
			if(m.getCategory().equals("warranty")) {
				sitem = sitem + "(@p_assetId,\"" + m.getWarrantyid() + "\",\"" + m.getSdate() + "\",\"" + m.getEdate()
				+ "\",\"" + m.getServiceprovider() + "\",\"" + m.getRemark() + "\",\"" + m.getDocumentURL()+ "\",\"" + m.getFileName() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
						+ "\"),";
			}else if(m.getCategory().equals("insurance")){
				sitem1 = sitem1 + "(@p_assetId,\"" + m.getInsuranceno() + "\",\"" + m.getInsurancename() + "\",\"" + m.getIsdate() + "\",\"" + m.getIedate()
				+ "\",\"" + m.getDocumentURL()+ "\",\"" + m.getFileName()+ "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
						+ "\"),";
			}
			
		}
		}
		for (ManageTrainingRestDocumentModel a : av.get(0).getDocumentList()) {
			document = document + "(@p_assetId,\"" + a.getDocumnentName() + "\",\""
					+ a.getFileName() + "\",\"" + a.getDocumentURL() + "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
		if(sitem.length()!=0) {
			sitem = sitem.substring(0, sitem.length() - 1);
		}
		if(sitem1.length()!=0) {
			sitem1 = sitem1.substring(0, sitem1.length() - 1);
		}
		if(document.length()!=0) {
			document = document.substring(0, document.length() - 1);
		}

		s = s + "@p_itemSubQuery='" + sitem + "',"+ "@p_itemSubQuery1='" + sitem1 + "',"+ "@p_itemSubQuery2='" + document + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}


		return s;
	}

}

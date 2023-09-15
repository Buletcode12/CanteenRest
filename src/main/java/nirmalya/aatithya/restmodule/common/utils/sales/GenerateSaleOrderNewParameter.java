package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

public class GenerateSaleOrderNewParameter {
	public static String getAddempParam(List<RestSaleOrderNewModel> customer) {
		String s = "";

		String listdata = "";
		String poId = "";
		String custId = "";
		String qutDescription = "";
		
		String qutCreatedBy = "";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;
		String salesOrder = "";
		String orderReceiveDate = "";
		
		String organization = "";
		String orgDivision = "";

		String expectedShipmentDate = "";
		String paymentTermId = "";
		String deliveryMethodId = "";
		String salesPerson = "";
		String tcs = "";
		String terms = "";
		String multidocument = "";
		String reference = "";
		String orderType = "";
		
		Double tcsAmount = 0.00;
		String shippingHiddenId = "";
		for (RestSaleOrderNewModel m : customer) {
			poId = m.getPoId();
			custId = m.getCustId();
			qutDescription = m.getQutDescription();
			
			qutCreatedBy = m.getQutCreatedBy();
			if (m.getSubTotal() != null) {
				subTotal = m.getSubTotal();
			}
			if (m.getqIGST() != null) {
				qIGST = m.getqIGST();
			}
			if (m.getqCGST() != null) {
				qCGST = m.getqCGST();
			}
			if (m.getqSGST() != null) {
				qSGST = m.getqSGST();
			}
			if (m.getGrandTotal() != null) {
				grandTotal = m.getGrandTotal();
			}
			grandTotal = m.getGrandTotal();
			taxType = m.getTaxType();
			salesOrder = m.getSalesOrder();
			orderReceiveDate= m.getOrderReceiveDate();
			expectedShipmentDate = m.getExpectedShipmentDate();
			paymentTermId = m.getPaymentTermId();
			deliveryMethodId = m.getDeliveryMethodId();
			salesPerson = m.getSalesPerson();
			terms = m.getTerms();
			reference = m.getReference();
			
			tcs = m.getTcs();
			if (m.getTcsAmount() != null) {
				tcsAmount = m.getTcsAmount();
			}
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			orderType = m.getOrderType();
			shippingHiddenId = m.getShippingHiddenId();
		}

		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		/*
		 * s = s + "@p_qutSubTotal=" + subTotal + ","; s = s + "@p_qutIGST=" + qIGST +
		 * ","; s = s + "@p_qutCGST=" + qCGST + ","; s = s + "@p_qutSGST=" + qSGST +
		 * ","; s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		 */
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_salesId='" + salesOrder + "',";
		s = s + "@p_orderReceiveDate='" + orderReceiveDate + "',";
		

		s = s + "@p_orgName='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";

		s = s + "@p_expectedDate='" + expectedShipmentDate + "',";
		s = s + "@p_paymentterm='" + paymentTermId + "',";
		s = s + "@p_deliveryMethod='" + deliveryMethodId + "',";
		s = s + "@p_salesperson='" + salesPerson + "',";
		s = s + "@p_tcsAmount='" + tcsAmount + "',";
		s = s + "@p_tcs='" + tcs + "',";
		s = s + "@p_terms='" + terms + "',";
		
		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_orderType='" + orderType + "',";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',";
		
		

		if (!customer.get(0).getSalesOrder().contentEquals("1")) {
			for (RestSaleOrderNewModel m : customer) {
            String itemRemarks="";
           
            		if (m.getItemRemarks() != null) {
            			itemRemarks = m.getItemRemarks();
        			}
					
					  Double unitPrice = 0.00;
					  if (m.getUnitPrice() != null) {
						  unitPrice = m.getUnitPrice(); 
					  }
					
				listdata = listdata + "(@p_salesId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
						+ m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + unitPrice + "\",\""
						+ m.getDiscount() + "\",\"" + m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\""
						+ m.getHsnCode() + "\",\"" + m.getSizeInMM() +"\",\""
						+ m.getThicknessInMM() + "\",\""+ m.getItemDesc() + "\",\"" 
						+ m.getSku() + "\"," + m.getItemIgst() + "," + m.getItemCgst() + ","
						+ m.getItemSgst() + "," + m.getTaxableAmt() + ",@p_orgName,@p_orgDiv,\""+ itemRemarks + "\"," + m.getNoOfItem() + "),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_litemSubQuery='" + listdata + "',";

			/*
			 * for (InventoryVendorDocumentModel a : customer.get(0).getDocumentList()) {
			 * if(!a.getDocumnentName().contentEquals("") &&
			 * a.getDocumnentName().contentEquals("null") &&
			 * a.getDocumnentName().contentEquals(null)) { multidocument = multidocument +
			 * "(@p_salesId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()+
			 * "\",@p_qutCreatedBy,@p_orgName,@p_orgDiv),"; } } if
			 * (!multidocument.isEmpty()) { multidocument = multidocument.substring(0,
			 * multidocument.length() - 1); s = s + "@p_vendorDocuments='" + multidocument +
			 * "',"; }
			 */
			
			for (InventoryVendorDocumentModel a : customer.get(0).getDocumentList()) {
				multidocument = multidocument + "(@p_salesId,\"" + a.getDocumnentName() + "\",\""
						+ a.getFileName() + "\",@p_qutCreatedBy,@p_orgName,@p_orgDiv),";
			}
			if (!multidocument.isEmpty()) {
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			}
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		System.out.println("Item Details-----------------------------" + s);
		return s;
	}

	public static String getDeleteParam(RestSaleOrderNewModel customer) {
		String[] userIds = customer.getSalesOrder().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_salesId='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}

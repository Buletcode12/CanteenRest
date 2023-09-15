package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;

public class GenerateSalesInvoiceNewParameter {
	public static String getAddSalesInvoiceParam(List<RestSalesInvoiceNewModel> customer) {
		String s = "";
		String listdata ="";
		String saleInvoice="";
		String poId="";
		String qutCreatedBy="";
		Double subTotal=0.00;
		Double qIGST=0.00;
		Double qCGST=0.00;
		Double qSGST=0.00;
		Double grandTotal=0.00;
		Boolean taxType=null;
        String custId="";
        String organization="";
        String orgDivision="";
        Double adjustment=0.00;
    	Double tcsAmount=0.00;
		String tcs="";
		String paymentTermId="";
		String dueDate="";
		String challan=""; 
		String challanDate="";
		String ebillNo=""; 
		String ebillDate="";
		Double totalFreightCharges=0.00;
		Double total=0.00;
		String shippingHiddenId="";
		String invoiceDate="";
		String shippingDetails = "";
		String orgDetails = "";
		String custDetails = "";
		String vehicleNo = "";
		String tMode = "";
		String transporterId = "";
		String transporterName = "";
		String lrNumber = "";
		String typeId = "";
		/*
		 * String challanIdNew = ""; String challanDateNew = ""; String ebillNoNew = "";
		 * String ebillDateNew = "";
		 */
		
		
		for (RestSalesInvoiceNewModel m : customer) {
			saleInvoice=m.getSaleInvoice();
			poId=m.getPoId();
			qutCreatedBy=m.getQutCreatedBy();
			if(m.getSubTotal()!=null) {
				subTotal=m.getSubTotal();
			}
			if(m.getqIGST()!=null) {
				qIGST=m.getqIGST();
			}
			if(m.getqCGST()!=null) {
				qCGST=m.getqCGST();
			}
			if(m.getqSGST()!=null) {
				qSGST=m.getqSGST();
			}
			if(m.getGrandTotal()!=null) {
				grandTotal=m.getGrandTotal();
			}
			taxType=m.getTaxType();
			custId=m.getCustId();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
		    if(m.getAdjustment()!=null) {
		    	adjustment=m.getAdjustment();
		    }
			if(m.getTcsAmount()!=null) {
				tcsAmount=m.getTcsAmount();
			}
			tcs=m.getTcs();
			paymentTermId=m.getPaymentTermId();
		   // dueDate=m.getDueDate();
			
			if(m.getDueDate()!=null && m.getDueDate()!="" && m.getDueDate()!="null") {
				dueDate = DateFormatter.getStringDate(m.getDueDate());
			}
			
			//dueDate = DateFormatter.getStringDate(m.getDueDate());
			challan=m.getChallanId();
			challanDate=m.getChallanDate();
			ebillNo=m.getEbillNo();
			ebillDate=m.getEbillDate();
			if(m.getTotalFreightCharges()!=null) {
				totalFreightCharges=m.getTotalFreightCharges();
		    }
			if(m.getTotal()!=null) {
				total=m.getTotal();
		    }
			shippingHiddenId=m.getShippingHiddenId();
			invoiceDate=m.getInvoiceDate();
			shippingDetails = m.getShippingDetails();
			orgDetails = m.getOrgDetails();
			custDetails = m.getCustDetails();
			vehicleNo = m.getVehicleNo();
			tMode = m.gettMode();
			transporterId = m.getTransporterId();
			transporterName = m.getTransporterName();
			lrNumber = m.getLrNumber();
			typeId = m.getTypeId();
		
		}
		
		s = s + "@p_salesInvoice='" + saleInvoice + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_div='" + orgDivision + "',";
		s = s + "@p_adjustment='" +  adjustment + "',";
		s = s + "@p_tcsAmount='" +  tcsAmount + "',";
		s = s + "@p_tcs='" +  tcs + "',";
		s = s + "@p_paymentterm='" + paymentTermId + "',";
		if(dueDate!=null && dueDate!="" && dueDate!="null") {
			s = s + "@p_dueDate='" +  dueDate + "',";
		}
		/*
		 * else { s = s + "@p_dueDate='" + dueDate + "',"; }
		 */
		s = s + "@p_challan='" + challan + "',"; 
		s = s + "@p_challanDate='" + challanDate+ "',";
		s = s + "@p_ebillNo='" + ebillNo + "',"; 
		s = s + "@p_ebillDate='" + ebillDate+ "',";
		s = s + "@p_totalFreightCharges='" +  totalFreightCharges + "',";
		s = s + "@p_total='" +  total + "',";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',"; 
		s = s + "@p_invoiceDate='" + invoiceDate + "',"; 
		s = s + "@p_shippingDetails='" + shippingDetails + "',";
		s = s + "@p_orgDetails='" + orgDetails + "',";
		s = s + "@p_custDetails='" + custDetails + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_tMode='" + tMode + "',";
		s = s + "@p_transporterId='" + transporterId + "',";
		s = s + "@p_transporterName='" + transporterName + "',";
		s = s + "@p_lrNumber='" + lrNumber + "',";
		s = s + "@p_typeId='" + typeId + "',";
		
		
		System.out.println("sssssssssssssssss"+customer);
		for (RestSalesInvoiceNewModel m : customer) {
			listdata = listdata + "(@p_salesInvoice,@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + m.getUnitPrice() +"\",\"" + m.getDiscount() + "\",\""
					+ m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\"" + m.getHsnCode() + "\",\"" + m.getSku()
					+ "\"," + m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + "," + m.getTaxableAmt() + "),";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		System.out.println("Item Details"+s);
		return s;
	}
	
	public static String getDeleteParamnew(RestSalesInvoiceNewModel customer) {
		String[] userIds = customer.getSaleInvoice().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_salesInvoice='" + litem + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE"+s);

		return s;
	}

}

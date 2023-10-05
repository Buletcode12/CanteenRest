package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.account.model.RestManualJournalModel;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;


public class GenerateCanteenComboParameter {
    
    public static String addcanteenComboParam(RestMenuModel canteenmenu) {
        String s = "";
        String litem = "";
        
        System.out.println("Hello" + s);
        System.out.println("Hello" + litem);
        
        if (canteenmenu.getComboId() != null && !canteenmenu.getComboId().isEmpty()) {
            s = s + "@combo_id='" + canteenmenu.getComboId() + "',";
        }
        
        if (canteenmenu.getComboName() != null && !canteenmenu.getComboName().isEmpty()) {
            s = s + "@p_comboName='" + canteenmenu.getComboName() + "',";
        }
        	
        if (canteenmenu.getAllPrice() != null && !canteenmenu.getAllPrice().isEmpty()) {
            s = s + "@p_allprice='" + canteenmenu.getAllPrice() + "',";
        }
        
        if (canteenmenu.getItemList() != null && !canteenmenu.getItemList().isEmpty()) {
            // Iterate through itemList and add its contents to litem
            for (RestMenuModel item : canteenmenu.getItemList()) {
                if (item.getItemId() != null && item.getItemName() != null && item.getPrice() != null) {
                    litem = litem + "(@combo_id,\"" + item.getItemId() + "\",\"" + item.getItemName() + "\",\"" + item.getPrice() + "\"),";
                }
            }
        }
        
		/*
		 * if (canteenmenu.getItemId() != null && canteenmenu.getItemName() != null &&
		 * canteenmenu.getPrice() != null) { litem = litem + "(\"" +
		 * canteenmenu.getItemId() + "\",\"" + canteenmenu.getItemName() + "\",\"" +
		 * canteenmenu.getPrice() + "\"),"; }
		 */
        
		/*
		 * if (canteenmenu.getItemId() != null && canteenmenu.getItemName() != null &&
		 * canteenmenu.getPrice() != null) { litem = litem + "(\"" +
		 * canteenmenu.getItemId() + "\",\"" + canteenmenu.getItemName() + "\",\"" +
		 * canteenmenu.getPrice() + "\"),"; }
		 */
        System.out.print("<<<<<<<<"+s);
        
        System.out.print("<<<<<<<<"+litem);
        
        
        litem = litem.substring(0, litem.length()-1);
        
        s = s + "@p_itemId='" + litem + "',";
        
        if (s != "") {
            s = s.substring(0, s.length() - 1);
            
            s = "SET " + s + ";";
        }
        
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + s);
        return s;
    }
}

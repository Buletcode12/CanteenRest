package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.account.model.RestManualJournalModel;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;



public class GenerateCanteenComboParameter {
	
    public static String addcanteenComboParam(List<RestMenuModel> canteenmenu) {

      String s = "";
      String litem = "";
      
      System.out.println("Hello"+s);
      System.out.println("Hello"+litem);
      
		/*
		 * if (canteenmenu.get(0).getItemId() != null || canteenmenu.get(0).getItemId()
		 * != "") { s = s + "@p_itemid='" + canteenmenu.get(0).getItemId() + "',"; } if
		 * (canteenmenu.get(0).getItemName() != null || canteenmenu.get(0).getItemName()
		 * != "") { s = s + "@p_itemname='" + canteenmenu.get(0).getItemName() + "',"; }
		 * if (canteenmenu.get(0).getPrice() != null || canteenmenu.get(0).getPrice() !=
		 * "") { s = s + "@p_price='" + canteenmenu.get(0).getPrice() + "',"; }
		 */
  
  
  for (RestMenuModel m : canteenmenu) {
	  
		if (m.getItemId() != null && m.getItemName() != null && m.getPrice() != null) {
			litem = litem + "(\"" + m.getItemId()+ "\",\"" + m.getItemName() + "\",\"" + m.getPrice() + "\"),";

		}
	}

  litem = litem.substring(0, litem.length()-1);

	s = s + "@p_itemId='" + litem + "',";

	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}
	
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+s);
	return s;
}

}

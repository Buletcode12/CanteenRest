package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.canteen.model.RestAssignComboModel;
import nirmalya.aatithya.restmodule.canteen.model.RestAssignItemdata;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;

public class GenerateCanteenAssignParameter {
	
				    
			public static String addCanteenAssignParameter(RestAssignComboModel restAssignComboModel) 		
					{
					 String s = "";
				    String litem = "";
				    
				    System.out.println("Hello" + s);
				    System.out.println("Hello" + litem);
				    
				    if (restAssignComboModel.getWeakendId() != null && !restAssignComboModel.getWeakendId().isEmpty()) {
				        s = s + "@weakendId='" + restAssignComboModel.getWeakendId() + "',";
				    }
				    
				    if (restAssignComboModel.getWeakendName() != null && !restAssignComboModel.getWeakendName().isEmpty()) {
				        s = s + "@weakendName='" + restAssignComboModel.getWeakendName() + "',";
				    }
				    					    
				    if (restAssignComboModel.getData() != null && !restAssignComboModel.getData().isEmpty()) {
				        // Iterate through itemList and add its contents to litem
				        for (RestAssignItemdata item : restAssignComboModel.getData()) {
				            if (item.getId() != null && item.getName() != null && item.getPrice() != null) {
				                litem = litem + "(\"" + item.getId() + "\",\"" + item.getName() + "\",\"" + item.getPrice() + "\"),";
				            }
				        }
				    }
				    
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

	
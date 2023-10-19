package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.canteen.model.RestAssignComboModel;
import nirmalya.aatithya.restmodule.canteen.model.RestAssignItemdata;

public class GenerateCanteenAssignParameter {
    public static String addCanteenAssignParameter(RestAssignComboModel restAssignComboModel) {
        String s = "";

        if (restAssignComboModel.getWeakendId() != null && !restAssignComboModel.getWeakendId().isEmpty()) {
            s += "@weakendId='" + restAssignComboModel.getWeakendId() + "',";
        }
        if (restAssignComboModel.getWeakendName() != null && !restAssignComboModel.getWeakendName().isEmpty()) {
            s += "@weakendName='" + restAssignComboModel.getWeakendName() + "',";
        }
        
        

        if (restAssignComboModel.getData() != null && !restAssignComboModel.getData().isEmpty()) {
            StringBuilder litem = new StringBuilder();
            for (RestAssignItemdata item : restAssignComboModel.getData()) {
                if (item.getId() != null && item.getName() != null && item.getPrice() != null) {
                    litem.append("('").append(item.getId()).append("', '").append(item.getName()).append("', '")
                            .append(item.getPrice()).append("'),");
                }
            }
            if (litem.length() > 0) {
                litem.deleteCharAt(litem.length() - 1); // Remove the trailing comma
                s += "@items=" + litem + ",";
            }
        }

        if (!s.isEmpty()) {
            s = s.substring(0, s.length() - 1);
            s = "SET " + s + ";";
        }

        return s;
    }
}

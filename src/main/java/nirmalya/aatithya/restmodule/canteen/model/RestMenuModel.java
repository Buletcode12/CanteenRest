package nirmalya.aatithya.restmodule.canteen.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestMenuModel {
    
	private String itemId;
	private String itemName;
	private String price;
	private String categry;
	private String subcategry;
	private String variant;
	private String status;
	
	
	
	
	public RestMenuModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RestMenuModel(Object categry, Object subcategry, Object variant,
			Object itemId, Object itemName,Object price,Object status) {
		super();

		this.categry = (String) categry;
		this.subcategry = (String) subcategry;
		this.variant = (String) variant;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.price = (String) price;
		this.status = (String) status;
	}
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategry() {
		return categry;
	}
	public void setCategry(String categry) {
		this.categry = categry;
	}
	public String getSubcategry() {
		return subcategry;
	}
	public void setSubcategry(String subcategry) {
		this.subcategry = subcategry;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;

	}
	
	
}

/**
 * Defines menu dropdown class
 *
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class DropDownModel {
	private String key;

	private String name;
	
	private String code;

	public DropDownModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DropDownModel(Object key, Object name) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DropDownModel(Object key, Object name,Object code) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.code = (String) code;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DropDownModel(Object key, Object name,Object code,Object data) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.code = (String) code;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

package lib.duolingoproject.hibernate.util;

import javax.persistence.AttributeConverter;

import org.json.JSONObject;

public class JSONObjectConverter implements AttributeConverter<JSONObject, String> {

	@Override
	public String convertToDatabaseColumn(JSONObject json) {
		
		String jsonString;
		
		try {
			
			jsonString = json.toString();
			
		} catch (Exception e) {
			
			jsonString = "";
			
		}
		
		return jsonString;
	}

	@Override
	public JSONObject convertToEntityAttribute(String jsonString) {
		
		JSONObject jsonData;
		
		try {
			
			jsonData = new JSONObject(jsonString);
			
		} catch (Exception e) {
			
			jsonData = null;
			
		}
		
		return jsonData;
	}
	
	

}

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
		
		JSONObject json;
		
		try {
			
			json = new JSONObject(jsonString);
			
		} catch (Exception e) {
			
			json = null;
			
		}
		
		return json;
	}
	
	public JSONObject createExerciseTestJSON(String original, String translated, String mistake1, String mistake2) {
		
		JSONObject content = new JSONObject();
		
		content.put("phraseOriginal", original);
		content.put("phraseTranslated", translated);
		content.put("phraseMistake1", mistake1);
		content.put("phraseMistake2", mistake2);
		
		return content;
		
	}

}

import org.json.*;

public class ParseNut {
	
	private JsonHttpApi request;
	private JSONObject object;
	
	public ParseNut(String fdcID) {
		
		request = new JsonHttpApi(fdcID);
		object = new JSONObject(request.getString());
	}
	
	public String getNut(String obj) {
		
		object.getJSONObject("foodNutrients").getString(obj);
		return null;
		
	}
	
	public String getText() {
		return object.toString();
	}
	
	public void printJsonArray() {
		JSONArray arr = object.getJSONArray("foodNutrients");
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr.get(i));
		}
	}

}

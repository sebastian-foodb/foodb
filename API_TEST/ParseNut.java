import org.json.*;

public class ParseNut {

	private JsonHttpApi request;
	private JSONObject object;
	private JSONArray arr;

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
		arr = object.getJSONArray("foodNutrients");
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr.get(i));
		}
	}

	public String[] parseJsonArray() {
		arr = object.getJSONArray("foodNutrients");
		String[] ret;
		for (int i = 0; i < arr.length(); i++) {
			
			// obj is the working JSON Array index since the foodNutrients JSONArray
			// is an array of json objects.
			JSONObject obj = arr.getJSONObject(i);
			
			// nutrient is the nutrient object information for the particular json index.
			JSONObject nutrient = obj.getJSONObject("nutrient");
			
			// self-explanatory: extracts name, amount, and the units from the nutrient JSON object.
			String amount = String.valueOf(nutrient.getFloat("number"));
			String name = nutrient.getString("name");
			String unitName = nutrient.getString("unitName");
			
		}
		
		// TODO: replace and finish class.
		return null;
	}

	public JSONArray getJsonArray() {
		arr = object.getJSONArray("foodNutrients");
		return arr;
	}

}

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

	public String[][] parseJsonArray() {
		arr = object.getJSONArray("foodNutrients");
		String[][] ret = new String[arr.length()][3];
		for (int i = 0; i < arr.length(); i++) {
			
			// obj is the working JSON Array index since the foodNutrients JSONArray
			// is an array of json objects.
			JSONObject obj = arr.getJSONObject(i);
			
			// nutrient is the nutrient object information for the particular json index.
			JSONObject nutrient = obj.getJSONObject("nutrient");
			
			// self-explanatory: extracts name, amount, and the units from the nutrient JSON object.
			String amount = String.valueOf(obj.get("amount"));
			String name = nutrient.getString("name");
			String unitName = nutrient.getString("unitName");
			
			if (testValid(name)) {
				ret[i][0] = name;
				ret[i][1] = amount;
				ret[i][2] = unitName;
			}
			else {
				for(int j = 0; j < 3; j++) {
					ret[i][j] = "-1";
				}
			}
			
		}
		
		System.out.println(ret);
		return ret;
	}
	private boolean testValid(String name) {
		//TODO: test for different nutrients we want.
		boolean ret = false;
		
		switch (name) {
			
		case "Sodium, Na":
			ret = true;
			break;
		
		case "Sugar":
			ret = true;
			break;
			
		case "Fiber":
			ret = true;
			break;
			
		case "Vitamin B-6":
			ret = true;
			break;
			
		case "Vitamin B-12":
			ret = true;
			break;
			
		case "Carbohydrate":
			ret = true;
			break;
			
		case "Protein":
			ret = true;
			break;
			
		case "Total lipid (fat)":
			ret = true;
			break;
			
		case "fat":
			ret = true;
			break;
			
		case "Iron, Fe":
			ret = true;
			break;
			
		case "Calcium, Ca":
			ret = true;
			break;
			
		case "Vitamin A, RAE":
			ret = true;
			break;
			
		case "Cholesterol":
			ret = true;
			break;
			
		case "Energy":
			ret = true;
			break;
			
		case "Vitamin D (D2 + D3)":
			ret = true;
			break;
			
		}
		
		return ret;
	}

	public JSONArray getJsonArray() {
		arr = object.getJSONArray("foodNutrients");
		return arr;
	}

}

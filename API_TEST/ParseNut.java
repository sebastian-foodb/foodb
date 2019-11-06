import org.json.*;

public class ParseNut {

	private JsonHttpApi request;
	private JSONObject object;
	private JSONArray arr;
	private String[][] nutrients;
	// FDCID    Calories Fat Cholesterol Sodium Carb Fiber Sugar Protein K Iron Calcium Vitamin_A B6 B12 C D E
	// 0		1		2			3		4	5		6	7		8	9	10		11		12 	  13 14 15 16 17

	public ParseNut(String fdcID) {

		request = new JsonHttpApi(fdcID);
		object = new JSONObject(request.getString());
		nutrients = new String[18][2];
		for (int i = 1; i < 18; i++) {
			nutrients[i][0] = "-1";
			nutrients[i][1] = "-1";
		}
		nutrients[0][0] = fdcID;
		nutrients[0][1] = fdcID;
		parseJsonArray();
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

	public void parseJsonArray() {
		arr = object.getJSONArray("foodNutrients");
		String[][] ret = new String[arr.length()][3];
		for (int i = 0; i < arr.length(); i++) {

			// obj is the working JSON Array index since the foodNutrients JSONArray
			// is an array of json objects.
			JSONObject obj = arr.getJSONObject(i);

			// nutrient is the nutrient object information for the particular json index.
			JSONObject nutrient = obj.getJSONObject("nutrient");

			// self-explanatory: extracts name, amount, and the units from the nutrient JSON object.
			String amount;
			try {
				amount = String.valueOf(obj.get("amount"));
			}
			catch(Exception e) {
				amount = nutrient.getString("number");
			}
			String name = nutrient.getString("name");
			String unitName = nutrient.getString("unitName");

			try {
				testValid(name, amount, unitName);
			}
			catch (Exception e) {

				for(int j = 0; j < 17; j++) {

					// error -2: something went wrong with the testValid method.
					nutrients [j][0] = "-2";
					nutrients [j][1] = "-2";
				}
			}

		}
	}
	private boolean testValid(String name, String amount, String unit) {
		//TODO: test for different nutrients we want.
		boolean ret = false;

		switch (name) {

		case "Sodium, Na":
			ret = true;
			nutrients[3][0] = amount;
			nutrients[3][1] = unit;
			break;

		case "Sugar":
			ret = true;
			nutrients[6][0] = amount;
			nutrients[6][1] = unit;
			break;

		case "Fiber":
			ret = true;
			nutrients[5][0] = amount;
			nutrients[5][1] = unit;
			break;

		case "Vitamin B-6":
			ret = true;
			nutrients[12][0] = amount;
			nutrients[12][1] = unit;
			break;

		case "Vitamin B-12":
			ret = true;
			nutrients[13][0] = amount;
			nutrients[13][1] = unit;
			break;

		case "Carbohydrate":
			ret = true;
			nutrients[4][0] = amount;
			nutrients[4][1] = unit;
			break;

		case "Protein":
			ret = true;
			nutrients[7][0] = amount;
			nutrients[7][1] = unit;
			break;

		case "Total lipid (fat)":
			ret = true;
			nutrients[1][0] = amount;
			nutrients[1][1] = unit;
			break;

		case "fat":
			ret = true;
			nutrients[1][0] = amount;
			nutrients[1][1] = unit;
			break;

		case "Iron, Fe":
			ret = true;
			nutrients[9][0] = amount;
			nutrients[9][1] = unit;
			break;

		case "Calcium, Ca":
			ret = true;
			nutrients[10][0] = amount;
			nutrients[10][1] = unit;
			break;

		case "Vitamin A, RAE":
			ret = true;
			nutrients[11][0] = amount;
			nutrients[11][1] = unit;
			break;

		case "Cholesterol":
			ret = true;
			nutrients[2][0] = amount;
			nutrients[2][1] = unit;
			break;

		case "Energy": //calories
			ret = true;
			nutrients[0][0] = amount;
			nutrients[0][1] = unit;
			break;

		case "Vitamin D (D2 + D3)":
			ret = true;
			nutrients[15][0] = amount;
			nutrients[15][1] = unit;
			break;

		case "Potassium, K":
			ret = true;
			nutrients[8][0] = amount;
			nutrients[8][1] = unit;
			break;

		case "Vitamin E":
			ret = true;
			nutrients[16][0] = amount;
			nutrients[16][1] = unit;
			break;

		}

		return ret;
	}

	public JSONArray getJsonArray() {
		arr = object.getJSONArray("foodNutrients");
		return arr;
	}

	public String[][] getNut() {
		return nutrients;
	}

}

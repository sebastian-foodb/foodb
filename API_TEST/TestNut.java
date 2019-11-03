

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * This is a test class demonstrating how the food.csv will be parsed.
 */

public class TestNut {

	public static void main(String[] args) {
		
		ParseNut nut;
		
		//The test string is created, filled with some random FDC IDs.
		//String[] test = {"341471", "172664", "167698"};
		String [] test = {"341471"};
		
		JSONArray array;
		
		// as parsenut object is initialized with each fdc id. This does an API request and
		// converts the json data to java objects
		for(int i = 0; i < test.length; i++) {
			
			nut = new ParseNut(test[i]);
			//nut.printJsonArray();
			array = nut.getJsonArray();
			System.out.println(array.get(0));
			JSONObject obj = array.getJSONObject(0);
			JSONObject nutrient = obj.getJSONObject("nutrient");
			//System.out.println(obj.get("nutrient"));
			String amount = String.valueOf(obj.getFloat("amount"));
			
			
		}
	}
}

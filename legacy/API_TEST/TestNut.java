

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
		String [] test = {"173173"};
		
		
		nut = new ParseNut(test[0]);
		System.out.println(nut.getText());
		//nut.printJsonArray();
		
		//nut.parseJsonArray();

	}
}
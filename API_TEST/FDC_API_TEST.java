import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

import java.util.regex.*;

/* Depends on Json-Simple.jar */

public class FDC_API_TEST {

	public static void main(String args []) throws IOException, ParseException {

		String num = "325054";
		String apiKey = "W6yzeMeK7FKd9jtH4bjUemFSXaFvxaipmfvSnIeI";

		URL url = new URL("https://api.nal.usda.gov/fdc/v1/" + num + "?api_key=" + apiKey);

		HttpURLConnection conn = (HttpURLConnection)url.openConnection();

		conn.setRequestProperty("Content-Type", "application/json");

		InputStream input = conn.getInputStream();
		JSONParser jsonParser = new JSONParser();
		//org.json.simple.JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(input, "UTF-8"));



		System.out.println(jsonObject.get("foodNutrients"));
		String test = jsonObject.get("foodNutrients").toString();
		JSONArray arr = jsonObject.getJSONArray("foodNutrients");

		for (int i = 0; i < arr.length(); i++)
		{
			String post_id = arr.getJSONObject(i).getString("");

		}

		Matcher m = Pattern.compile("\\{([^}]+)\\)").matcher(test);
		while(m.find()) {
			System.out.println(m.group(1));
		}
	}



}

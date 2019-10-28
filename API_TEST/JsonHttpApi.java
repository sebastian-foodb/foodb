
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/* Depends on Json-Simple.jar */

public class JsonHttpApi {
	
	private String apiKey = "W6yzeMeK7FKd9jtH4bjUemFSXaFvxaipmfvSnIeI";
	private String num;
	JSONObject jo;
	
	public JsonHttpApi(String num) {
		this.num = num;
		boolean succ;
		
		try {
			succ = true;
			get();
		} catch (Exception e) {
			succ = false;
		}
	}
	public JsonHttpApi(String num, String apiKey) {
		
		this.apiKey = apiKey;
		this.num = num;
		boolean succ;
		
		try {
			succ = true;
			get();
		} catch (Exception e) {
			succ = false;
		}
		
	}
	
	private void get() throws Exception {
		URL url = new URL("https://api.nal.usda.gov/fdc/v1/" + num + "?api_key=" + apiKey);
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestProperty("Content-Type", "application/json");
		
		InputStream input = conn.getInputStream();
		
		JSONParser jsonParser = new JSONParser();
		jo = (JSONObject) jsonParser.parse(new InputStreamReader(input, "UTF-8"));
	}

	public JSONObject getJson() {
		return jo;
	}
	public String getString() {
		return jo.toJSONString();
	}

}

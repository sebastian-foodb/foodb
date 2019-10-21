import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//import org.json.simple.*;

public class FDC_API_TEST {
	
	public static void main(String args []) throws IOException {
		
		String num = "325054";
		String apiKey = "W6yzeMeK7FKd9jtH4bjUemFSXaFvxaipmfvSnIeI";
		
			URL url = new URL("https://api.nal.usda.gov/fdc/v1/" + num + "?api_key=" + apiKey);
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestProperty("Content-Type", "application/json");
			
			InputStream input = conn.getInputStream();
			
			System.out.println(input);
	}
	


}

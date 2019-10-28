import org.json.*;

public class ParseNut {
	
	JsonHttpApi request;
	
	public ParseNut(String fdcID) {
		
		request = new JsonHttpApi(fdcID);
		
	}

}

import org.json.JSONException;
import org.json.JSONObject;

public class TestingClass {

	public static void main(String[] args) throws JSONException {
		JSONObject lObj = new JSONObject();
		
		lObj.put("name","ashish");
		lObj.put("Sirname", "Gaikwad");
		
		System.out.println(lObj.toString());
	}

}

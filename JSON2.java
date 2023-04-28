package advancedJAVA;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("C:\\Users\\kopo14\\Desktop\\test.json"));
		
		JSONArray array = (JSONArray) obj;
		
		System.out.println("****************************");
		
		for (int i = 0; i < array.size(); i++) {
			JSONObject result = (JSONObject) array.get(i);
			System.out.println("NAME : " + result.get("name"));
			System.out.println("ID : " + result.get("studentid"));
			
			JSONArray score = (JSONArray) result.get("score");
			long kor = (long)score.get(0);
			long eng = (long)score.get(1);
			long mat = (long)score.get(2);
			
			System.out.println("KOREAN : " + kor);
			System.out.println("ENGLISH : " + eng);
			System.out.println("MATH : " + mat);
			System.out.println("TOTAL : " + (kor + eng + mat));
			System.out.println("AVG : " + ((kor + eng + mat) / 3.0));
			System.out.println("****************************");

		}
	}

}
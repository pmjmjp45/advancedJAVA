package advancedJAVA;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON1 {
/*
 * need download "json-simple.1.1.1.jar" 
 * properties -> java build path -> Libraries -> Classpath -> Add External JARs
 */
	public static JSONObject oneRec (String name, int studentid, int kor, int eng, int mat) { //method to make JSONObject
		JSONObject dataObject = new JSONObject();
		
		dataObject.put("name", name);
		dataObject.put("studentid", studentid);
		
		JSONArray score = new JSONArray(); //JSONArray can save 
		score.add(kor);score.add(eng);score.add(mat);
		dataObject.put("score", score);
		
		return dataObject;
	}
	
	public static void main(String[] args) {

		JSONArray datasArray = new JSONArray(); // make JSONArray to save datas

		datasArray.add(oneRec("Amy", 209901, 90, 95, 100));
		datasArray.add(oneRec("Barnard", 209902, 100, 85, 75));
		datasArray.add(oneRec("Carl", 209903, 90, 75, 100));
		datasArray.add(oneRec("Dora", 209904, 33, 85, 36));
		datasArray.add(oneRec("Eliyah", 209905, 60, 60, 80));
		datasArray.add(oneRec("Fiona", 209906, 95, 85, 55));
		datasArray.add(oneRec("Ginny", 209907, 65, 100, 75));
		datasArray.add(oneRec("Howard", 209908, 40, 55, 45));
		datasArray.add(oneRec("Iris", 209909, 100, 85, 90));
		
		try {
			FileWriter file = new FileWriter("C:\\Users\\kopo14\\Desktop\\test.json");
			file.write(datasArray.toJSONString());
			file.flush();
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("JSON file : " + datasArray);

	}

}

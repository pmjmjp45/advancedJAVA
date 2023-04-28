package advancedJAVA;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class File3 {

	public static void main(String[] args) throws IOException { 
		// TODO Auto-generated method stub

		File f = new File("C:\\Users\\kopo14\\Desktop\\PublicWifi.csv"); // connect to csv file
		BufferedReader br = new BufferedReader(new FileReader(f)); // 
		
		String readtxt;
		
		if ((readtxt = br.readLine()) == null) {
			System.out.println("N/A\n");
		}
		
		String[] field_name = readtxt.split(","); // field name is the first line
		
		int LineCnt = 0;
		
		while((readtxt = br.readLine()) != null) {
			String[] field = readtxt.split(","); // save field data of the line
			
			System.out.printf("**[no.%d]**************\n", LineCnt);
			
			for (int i = 0; i < field_name.length; i++) {
				System.out.printf(" %s : %s\n", field_name[i], field[i]);
			}
			System.out.printf("*****************************\n");
			
			if (LineCnt == 100) break;
			
			LineCnt++;
		}
		
		br.close();
	}

}
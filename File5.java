package advancedJAVA;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\kopo14\\Desktop\\day_data\\THTSKS010H00.dat"); // file to read
		BufferedReader br = new BufferedReader(new FileReader(f)); 
		
		File f1 = new File("C:\\Users\\kopo14\\Desktop\\day_data\\StockDailyPrice.csv"); // file to write
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1)); 
		
		String readtxt;
		
		int totalcnt = 0, filtercnt = 0;
		
		while ((readtxt = br.readLine()) != null) {
			StringBuffer s = new StringBuffer(); // Class to edit
			
			String[] field = readtxt.split("%_%"); // separator : %_%
			
			//Data filtering
			if (field.length > 2 && field[2].replace("^","").trim().substring(0, 1).equals("A")) {
				s.append(field[0].replace("^", "").trim());
				
				for (int i = 1; i < field.length; i++) {
					s.append("," + field[i].replace("^", "").trim());
				}
				bw1.write(s.toString()); // edit with StringBuffer, write withStringBuffer
				bw1.newLine();
				filtercnt++;
			}
			totalcnt++;
		}
		br.close();
		bw1.close();
		System.out.printf("Program End[%d][%d]records\n", totalcnt, filtercnt);
	}

}

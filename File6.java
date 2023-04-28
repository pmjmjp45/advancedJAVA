package advancedJAVA;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File6 {

	public static void main(String[] args) throws IOException { 
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\kopo14\\Desktop\\day_data\\StockDailyPrice.csv"); // file to read
		BufferedReader br = new BufferedReader(new FileReader(f)); // BufferedReader to read
		
		File f1 = new File("C:\\Users\\kopo14\\Desktop\\day_data\\A005930.csv"); // file to write
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1)); // BufferedWriter to write
		String readtxt;
		int cnt = 0;
		
		while ((readtxt = br.readLine()) != null) {
			StringBuffer s = new StringBuffer(); // StringBuffer to edit
			String[]field = readtxt.split(",");
			
			if (field[2].equals("A005930")) {
				s.append(readtxt + "\n");
				cnt++;
			}
			bw1.write(s.toString());
		}
		br.close();
		bw1.close();
		System.out.printf("Program End [%d] records",cnt);
	}

}


package advancedJAVA;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\kopo14\\Desktop\\day_data\\THTSKS010H00.dat"); 
		BufferedReader br = new BufferedReader(new FileReader(f)); 
	
		int n = -1; // end of file = -1
		
		StringBuffer s = new StringBuffer(); // StringBuffer is method to edit text

		while(true) { 
			char[] ch = new char[1000]; // make array to save char data
			
			n = br.read(ch); // the bite of the size of k14_ch
			
			if (n == -1) break; // no more character -> break
			
			for (char c : ch) { 
				if (c == '\n') { // criteria is line separator
					System.out.printf("[%s]***\n", s.toString()); // print and new line
					s.delete(0, s.length()); // delete written line from the s
				} else {
					s.append(c); // write 'c'
				}
			}
		}
		System.out.printf("[%s]***\n", s.toString()); // the last string
		br.close(); 
	}

}
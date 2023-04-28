package advancedJAVA;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class File1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File f = new File("C:\\Users\\kopo14\\Desktop\\test.txt"); //make file on local computer
			FileWriter fw = new FileWriter(f); // write file
			
			fw.write("New File\n");
			fw.write("hello!!\n");
			
			fw.close(); 
			
			FileReader fr = new FileReader(f); // read file
			
			int n = -1; // End of file = -1
			char[] ch; 
			
			while(true) { 
				ch = new char[100]; // char array to save characters 
				n = fr.read(ch); // the bite of the size of char[]k14_ch
				
				if (n == -1) break; // -1 -> no more character -> break
				
				for (int i = 0; i < n; i++) { 
					System.out.printf("%c", ch[i]); // read character byte by byte
				}
			}
			
			fr.close(); 
			
			System.out.printf("\nFILE READ END "); 
		} catch(Exception k14_e) { // general exception
			System.out.printf("error[%s]\n", k14_e); 
		}

	}

}


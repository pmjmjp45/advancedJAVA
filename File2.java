package advancedJAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File2 {
	// For bigger files, Buffered~~ methods are more useful than File~~methods 
	public static void main(String[] args) throws IOException {
		FileWrite();
		FileRead();
	}

	public static void FileWrite() throws IOException { // Input/Output exception

		File f = new File("C:\\Users\\kopo14\\Desktop\\test.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("Hello File");
		bw.newLine(); // line separator
		bw.write("hello!");
		bw.newLine(); // line separator
		
		bw.close();
	}
	
	public static void FileRead() throws IOException {
		File f = new File("C:\\Users\\kopo14\\Desktop\\test.txt");
		BufferedReader br = new BufferedReader (new FileReader(f));
		
		String readtxt;
		
		while ((readtxt = br.readLine()) != null) { // .readLine(): read line by line
			System.out.printf("%s\n", readtxt);
		}
		
		br.close();
		
	}

}

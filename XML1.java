package advancedJAVA;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML1 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		/*
		 * ParserConfigurationException : Exception in organizing parser
		 * SAXException: Exception in SAX parser
		 * IOException: Input/output exception
		 */

		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); // DocumentBuilder: make document
		
		Document doc = docBuilder.parse(new File("C:\\Users\\kopo14\\Desktop\\score.txt"));// DocumentBuilder: make document
		
		Element root = doc.getDocumentElement(); // make root element
		
		NodeList tag_name = doc.getElementsByTagName("name"); // get tag name from 'doc'
		NodeList tag_studentid = doc.getElementsByTagName("studentid");
		NodeList tag_kor = doc.getElementsByTagName("kor");
		NodeList tag_eng = doc.getElementsByTagName("eng");
		NodeList tag_mat = doc.getElementsByTagName("mat");

		System.out.println("****************");
		
		for (int i = 0; i < tag_name.getLength(); i++) { 
			/*
			 * .item(i): the 'i-th'
			 * .getFirstChild(): the first node = data 
			 * .getNodeValue(): get the value 
			 */
			System.out.printf("NAME : %s\n", tag_name.item(i).getFirstChild().getNodeValue()); // print
			System.out.printf("ID : %s\n", tag_studentid.item(i).getFirstChild().getNodeValue());
			System.out.printf("KOREAN : %s\n", tag_kor.item(i).getFirstChild().getNodeValue());
			System.out.printf("ENGLISH : %s\n", tag_eng.item(i).getFirstChild().getNodeValue());
			System.out.printf("MATH : %s\n", tag_mat.item(i).getFirstChild().getNodeValue());
			System.out.println("****************");
		}
	}

}
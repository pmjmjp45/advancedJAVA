package advancedJAVA;

import java.util.Scanner;

public class ReadNumbers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();  
		String inputString = String.valueOf(input);
		String numberInKorean = ""; 
		System.out.printf("==> %s [%d�ڸ�]\n", input, inputString.length()); 

		String[] numberArray = {"��","��","��","��","��","��","��","ĥ","��","��"}; 
		String[] unitArray = {"","��","��","õ","��","��","��","õ","��","��"}; 

		int index = 0;
		int unit = inputString.length() - 1; // starts from smaller number(left -> right)

		while (true) {
			if (index >= inputString.length()) break; 
			
			///////////////read each number in Korean
			System.out.printf("%s[%s]", 
				inputString.substring(index, index + 1), 
				numberArray[Integer.parseInt(inputString.substring(index, index + 1))]); 

			//////////////////////////// read entire number in Korean
			if (inputString.substring(index, index + 1).equals("0")) {  

				/////////////only "��" & "��" is printed even if the value is zero
				if (unitArray[unit].equals("��") || unitArray[unit].equals("��") || unitArray[unit].equals("��")) { 
					numberInKorean =  numberInKorean + "" + unitArray[unit]; 				
				
				}
			} else {
				numberInKorean = numberInKorean 
						+ numberArray[Integer.parseInt(inputString.substring(index, index + 1))]
								+ unitArray[unit]; 
			}
			index++; 
			unit--;
		}////////////////////////�Ͻʾ︸ �����ϱ�
		if (numberInKorean.contains("�︸")) { 
			numberInKorean = numberInKorean.replace("�︸", "��"); 
		}
		////////////////////////////////////'0' �����ϱ�
		if (numberInKorean.equals("")) {
			numberInKorean = "��";
		}
		System.out.printf("\n%s[%s]\n", inputString, numberInKorean); 
	}

}




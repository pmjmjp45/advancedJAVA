package advancedJAVA;

import java.util.Scanner;

public class ReadNumbers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();  
		String inputString = String.valueOf(input);
		String numberInKorean = ""; 
		System.out.printf("==> %s [%d자리]\n", input, inputString.length()); 

		String[] numberArray = {"영","일","이","삼","사","오","육","칠","팔","구"}; 
		String[] unitArray = {"","십","백","천","만","십","백","천","억","십"}; 

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

				/////////////only "만" & "억" is printed even if the value is zero
				if (unitArray[unit].equals("만") || unitArray[unit].equals("억") || unitArray[unit].equals("영")) { 
					numberInKorean =  numberInKorean + "" + unitArray[unit]; 				
				
				}
			} else {
				numberInKorean = numberInKorean 
						+ numberArray[Integer.parseInt(inputString.substring(index, index + 1))]
								+ unitArray[unit]; 
			}
			index++; 
			unit--;
		}////////////////////////일십억만 보정하기
		if (numberInKorean.contains("억만")) { 
			numberInKorean = numberInKorean.replace("억만", "억"); 
		}
		////////////////////////////////////'0' 보정하기
		if (numberInKorean.equals("")) {
			numberInKorean = "영";
		}
		System.out.printf("\n%s[%s]\n", inputString, numberInKorean); 
	}

}




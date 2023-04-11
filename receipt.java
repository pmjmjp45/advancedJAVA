package advancedJAVA;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class receipt {
	public static void main(String[] args) {

		String[] itemname = {"노브랜드 세탁세제 4L","코디 순한 3겹 데코","냉동 삼겹살 바로구이","파머스픽 1등급 특란 25개입","군밤 100g 4입"
				,"굿모닝 굿밀크 1L","팔도비빔면 4입","대추방울토마토","국산콩 콩나물 300g","다우니 엑스퍼트 실내건조 프레쉬클린"
				,"부대찌개 밀키트","노브랜드 도톰한 물티슈","꿈꾸는콩 촌두부","CJ 꼬마돈까스","숯불 데리야끼 닭꼬치"
				,"피코크 새우볶음밥","삼다수 2L","이롬 황성주 국산콩 검은콩 두유","동원 참치살코기 8입","모카골드 마일드 커피믹스"
				,"크라운쵸코하임 18개입","농심 안성탕면 5입","농심신라면 5입","찰현미 4키로","별미 포기김치 3키로"
				,"목우촌 주부9단 비엔나소시지","피코크 초콜릿 샌드위치 비스킷","CJ 비비고 육개장","CJ 비비고 사골곰탕","코카콜라제로 2L"};
		int[] price = {4900,31800,12900,8100,7000
				,1800,3000,10000,1200,18500
				,14800,1000,2000,5000,15000
				,12000,1000,9800,18500,32000
				,4800,3300,4100,11800,15900
				,10000,3000,5500,2000,4600};
		int[] amount = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		boolean[] taxfree = {false,false,true,true,false
				,true,false,true,true,false
				,false,false,true,false,false
				,false,false,false,false,false
				,false,false,false,true,false
				,false,false,false,false,false};

		DecimalFormat df = new DecimalFormat("###,###,###,###,###"); 

		////////////////////////////////////Header
		System.out.printf("emart");
		System.out.printf("%31s", "이마트 죽전점 (031)838-1234\n"); 
		System.out.printf("%31s", "206-86-50913 강희석\n"); 
		System.out.printf("%31s", "용인 수지구 포은대로 552 \n"); 
		System.out.println();
		System.out.printf("영수증 미지참시 교환/환불 불가\n"); 
		System.out.printf("정상상품에 한함, 30일 이내(신선 7일)\n");
		System.out.printf("※일부 브랜드매장 제외(매장 고지물참조)\n");
		System.out.println("교환/환불 구매점에서 가능(결제카드 지참)\n");
		
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm"); 
		System.out.printf("[구 매]%s",sdt.format(cal.getTime())); 
		System.out.printf("%18s\n","POS:0011-9861");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%7s%12s%5s%8s\n","상 품 명","단 가","수량","금 액"); 

		/////////////////////////////////////////////purchase list
		try { // try - catch for numbers not divided into 5
			for (int i = 0; i < itemname.length; i += 5) { // line after 5 products
				System.out.printf("-----------------------------------------\n");
				for (int j = 0; j < 5; j++) { 
					if (taxfree[(i) + (j)] == true) { // * for tax-free products
						System.out.printf("%s","* "); 
					} else { 
						System.out.printf("%s","  "); 
					}
					cut(itemname[(i) + (j)]); 
					System.out.printf("%11s%3s%11s\n",df.format(price[(i) + (j)]) 
							, df.format(amount[(i) + (j)])
							, df.format((price[(i) + (j)]) * amount[(i) + (j)]));
				}

			}
		} catch (Exception e) {

		}
		System.out.println();
		
//////////////////////////////////////////// Money and tax
		int freeTotal = 0; 
		int totalPrice = 0; 
		int taxTotal = 0; 
		double taxRate = 0.1;
		
		for (int i = 0; i < itemname.length; i++) {
			if (taxfree[i] == true) { 
				freeTotal += (price[i] * amount[i]); 
			} else {
				taxTotal += (price[i] * amount[i]); 
			}	
		}
		totalPrice = freeTotal + taxTotal; 

		int netTaxTotal = (int)(taxTotal/ (1 + taxRate)); // 세전과세합계 = (세후과세합계 / 1 + 부가세율)을 정수화한것(부가세 올림 효과)
		int tax = taxTotal - netTaxTotal; 		

		System.out.printf("%22s%14d\n", "총 품목 수량", itemname.length); 
		System.out.printf("%23s%14s\n", "(*)면 세  물 품", df.format(freeTotal));
		System.out.printf("%23s%14s\n", "과 세  물 품", df.format(netTaxTotal));
		System.out.printf("%24s%14s\n", "부   가   세", df.format(tax));
		System.out.printf("%25s%14s\n", "합        계", df.format(totalPrice));
		System.out.printf("%s%24s\n", "결 제 대 상 금 액", df.format(totalPrice));
		System.out.printf("-----------------------------------------\n");

//////////////////////////////////Footer
		System.out.printf("0012 KEB 하나");
		System.out.printf("%28s\n","541707**0484/35860658");
		System.out.printf("%s%16s%10s\n", "카드결제(IC)", "일시불 / ", df.format(totalPrice)); 
		System.out.printf("-----------------------------------------\n");
		System.out.printf("           [신세계포인트 적립]\n");
		System.out.printf("홍*두 고객님의 포인트 현황입니다.\n");
		System.out.printf("%s%17s%10s\n", "금회발생포인트","9350**9995",df.format(totalPrice / 1000)); // new point is related to the totalPrice
		System.out.printf("%s%14s(%9s)\n", "누계(기용)포인트", df.format(5473 + totalPrice / 1000),df.format(5473)); 
		System.out.printf("*신세계포인트 유효기간은 2년입니다.\n");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("    구매금액기준 무료주차시간 자동부여\n");
		System.out.printf("%s%30s\n", "차량번호 :", "34저****");
		System.out.printf("%s%31s\n", "입차시간 :", parkTime(cal)); 
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%s%25s\n","캐셔:084599 양00","1150");

		System.out.printf("      %s%s%08d%s\n",barcode(cal), "/00119861/",totalPrice,"/31"); 
	}
	
	public static void cut(String cut) { // cut itemname (한글 자르기!!!!)
		byte[] bytes = cut.getBytes(); // 상품명 바이트화하여 배열에 저장
		int blank = 0; // 변수(공백 개수) 
		int count = 0; // 변수(한글 개수)
		
		if (bytes.length <= 14) { // 바이트길이 14이하라면
			blank = 14 - bytes.length; // 필요한 공백 개수를 세고
			System.out.print(cut); // 상품명 뒤에
			for (int i = 0; i < blank; i++) { // 공백 붙인다
				System.out.print(" ");
			}
		} else { // 바이트길이 14 초과라면
			for (int i = 0; i <14; i++) { // 14까지만 계산한다
				if ((bytes[i] & 0x80) == 0x80) // 만약에 어떤 글자가 한글이라면 
					count++; //카운트 올린다
			}
			
			if ((bytes[13] & 0x80) == 0x80 && (count%2) == 1) { // 만약에 13번째 글자가 한글이라면
				String ret = new String(bytes,0,13); // 문자열로 전환할 때 12번째 바이트까지 쓰고
				System.out.print(ret + " "); // 공백을 하나 붙인다
				
			} else { // 그렇지 않다면
				String ret = new String(bytes,0,14); // 13번째 바이트까지 쓴다
				System.out.print(ret);
			}
		}	
	}

	public static String parkTime(Calendar cal) { // time for parking
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		cal.add(Calendar.MINUTE,-30); 
		return sdt.format(cal.getTime()); 
		}
	public static String barcode(Calendar cal) { // time for barcode
		SimpleDateFormat sdt2 = new SimpleDateFormat("YYYYMMdd"); 
		return sdt2.format(cal.getTime());
	}
}

package advancedJAVA;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class receipt {
	public static void main(String[] args) {

		String[] itemname = {"��귣�� ��Ź���� 4L","�ڵ� ���� 3�� ����","�õ� ���� �ٷα���","�ĸӽ��� 1��� Ư�� 25����","���� 100g 4��"
				,"�¸�� �¹�ũ 1L","�ȵ������ 4��","���߹���丶��","������ �ᳪ�� 300g","�ٿ�� ������Ʈ �ǳ����� ������Ŭ��"
				,"�δ�� ��ŰƮ","��귣�� ������ ��Ƽ��","�޲ٴ��� �̵κ�","CJ �������","���� �����߳� �߲�ġ"
				,"����ũ ���캺����","��ټ� 2L","�̷� Ȳ���� ������ ������ ����","���� ��ġ���ڱ� 8��","��ī��� ���ϵ� Ŀ�ǹͽ�"
				,"ũ����������� 18����","��� �ȼ����� 5��","��ɽŶ�� 5��","������ 4Ű��","���� �����ġ 3Ű��"
				,"����� �ֺ�9�� �񿣳��ҽ���","����ũ ���ݸ� ������ġ ��Ŷ","CJ ���� ������","CJ ���� ������","��ī�ݶ����� 2L"};
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
		System.out.printf("%31s", "�̸�Ʈ ������ (031)838-1234\n"); 
		System.out.printf("%31s", "206-86-50913 ����\n"); 
		System.out.printf("%31s", "���� ������ ������� 552 \n"); 
		System.out.println();
		System.out.printf("������ �������� ��ȯ/ȯ�� �Ұ�\n"); 
		System.out.printf("�����ǰ�� ����, 30�� �̳�(�ż� 7��)\n");
		System.out.printf("���Ϻ� �귣����� ����(���� ����������)\n");
		System.out.println("��ȯ/ȯ�� ���������� ����(����ī�� ����)\n");
		
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm"); 
		System.out.printf("[�� ��]%s",sdt.format(cal.getTime())); 
		System.out.printf("%18s\n","POS:0011-9861");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%7s%12s%5s%8s\n","�� ǰ ��","�� ��","����","�� ��"); 

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

		int netTaxTotal = (int)(taxTotal/ (1 + taxRate)); // ���������հ� = (���İ����հ� / 1 + �ΰ�����)�� ����ȭ�Ѱ�(�ΰ��� �ø� ȿ��)
		int tax = taxTotal - netTaxTotal; 		

		System.out.printf("%22s%14d\n", "�� ǰ�� ����", itemname.length); 
		System.out.printf("%23s%14s\n", "(*)�� ��  �� ǰ", df.format(freeTotal));
		System.out.printf("%23s%14s\n", "�� ��  �� ǰ", df.format(netTaxTotal));
		System.out.printf("%24s%14s\n", "��   ��   ��", df.format(tax));
		System.out.printf("%25s%14s\n", "��        ��", df.format(totalPrice));
		System.out.printf("%s%24s\n", "�� �� �� �� �� ��", df.format(totalPrice));
		System.out.printf("-----------------------------------------\n");

//////////////////////////////////Footer
		System.out.printf("0012 KEB �ϳ�");
		System.out.printf("%28s\n","541707**0484/35860658");
		System.out.printf("%s%16s%10s\n", "ī�����(IC)", "�Ͻú� / ", df.format(totalPrice)); 
		System.out.printf("-----------------------------------------\n");
		System.out.printf("           [�ż�������Ʈ ����]\n");
		System.out.printf("ȫ*�� ������ ����Ʈ ��Ȳ�Դϴ�.\n");
		System.out.printf("%s%17s%10s\n", "��ȸ�߻�����Ʈ","9350**9995",df.format(totalPrice / 1000)); // new point is related to the totalPrice
		System.out.printf("%s%14s(%9s)\n", "����(���)����Ʈ", df.format(5473 + totalPrice / 1000),df.format(5473)); 
		System.out.printf("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.\n");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("    ���űݾױ��� ���������ð� �ڵ��ο�\n");
		System.out.printf("%s%30s\n", "������ȣ :", "34��****");
		System.out.printf("%s%31s\n", "�����ð� :", parkTime(cal)); 
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%s%25s\n","ĳ��:084599 ��00","1150");

		System.out.printf("      %s%s%08d%s\n",barcode(cal), "/00119861/",totalPrice,"/31"); 
	}
	
	public static void cut(String cut) { // cut itemname (�ѱ� �ڸ���!!!!)
		byte[] bytes = cut.getBytes(); // ��ǰ�� ����Ʈȭ�Ͽ� �迭�� ����
		int blank = 0; // ����(���� ����) 
		int count = 0; // ����(�ѱ� ����)
		
		if (bytes.length <= 14) { // ����Ʈ���� 14���϶��
			blank = 14 - bytes.length; // �ʿ��� ���� ������ ����
			System.out.print(cut); // ��ǰ�� �ڿ�
			for (int i = 0; i < blank; i++) { // ���� ���δ�
				System.out.print(" ");
			}
		} else { // ����Ʈ���� 14 �ʰ����
			for (int i = 0; i <14; i++) { // 14������ ����Ѵ�
				if ((bytes[i] & 0x80) == 0x80) // ���࿡ � ���ڰ� �ѱ��̶�� 
					count++; //ī��Ʈ �ø���
			}
			
			if ((bytes[13] & 0x80) == 0x80 && (count%2) == 1) { // ���࿡ 13��° ���ڰ� �ѱ��̶��
				String ret = new String(bytes,0,13); // ���ڿ��� ��ȯ�� �� 12��° ����Ʈ���� ����
				System.out.print(ret + " "); // ������ �ϳ� ���δ�
				
			} else { // �׷��� �ʴٸ�
				String ret = new String(bytes,0,14); // 13��° ����Ʈ���� ����
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

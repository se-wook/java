package chapter03;

import java.util.Scanner;

public class SwichTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �Է��� �ּ���");
		int score = scan.nextInt();
		
		if(score<0 || score>100) {
			System.out.println("�߸� �Է��߽��ϴ�. 0~100�� ���̷� �Է��ϼ���");
		}else {
			System.out.printf(score+"���� ");
			switch (score/10) {
			case 10:
			case 9:
				System.out.println("A�����Դϴ�.");
				break;
			case 8:
				System.out.println("B�����Դϴ�.");
				break;
			case 7:
				System.out.println("C�����Դϴ�.");
				break;
			case 6:
				System.out.println("D�����Դϴ�.");
				break;
			default:
				System.out.println("F�����Դϴ�.");
				break;
			}
		}
	}
}






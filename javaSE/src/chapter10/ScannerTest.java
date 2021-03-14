package chapter10;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		next(): ���� �Ǵ� ���͸� �������� ����Ÿ�� �����ϰ� �Ѱ��� ����Ÿ�� �Է� �޾� ���ڿ��� ����
//		nextInt(): ���� �Ǵ� ���͸� �������� ����Ÿ�� �����ϰ� �Ѱ��� ����Ÿ�� �Է� �޾�  int ����
//		...
//		nextLine():���͸� �������� ����Ÿ�� �����ؼ� ������ ����Ÿ�� �Է� �޾� ���ڿ��� ���� 
		
		System.out.println(scan.next());
		System.out.println(scan.nextInt());
		System.out.println(scan.nextDouble());
	}

}

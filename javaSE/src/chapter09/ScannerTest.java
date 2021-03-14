package chapter09;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Ű����κ��� �����͸� ���� �� �ִ� ��ü ���� 
		Scanner sc = new Scanner(System.in);

//		next() : ���� �Ǵ� ���͸� �������� �����͸� �����ϰ� �Ѱ��� �����͸� �Է¹޾� ���ڿ��� ��������.		
//		nextInt() : ���� �Ǵ� ���͸� �������� �����͸� �����ϰ� �Ѱ��� �����͸� �Է¹޾� ������ ��������.
//		...
//		nextLine() : ���͸� �������� �����͸� �����ؼ� ������ �����͸� �Է¹޾� ���ڿ��� ����.
		
//		int num = sc.nextInt();
		System.out.println(sc.next());
		System.out.println(sc.nextInt());
		System.out.println(sc.nextDouble());
	}

}

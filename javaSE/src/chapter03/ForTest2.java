package chapter03;

import java.util.Scanner;

public class ForTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num < 1) {
			System.out.println("1�̻��� ������ �Է����ּ���.");
		}else {
			for(int i=1;i<=num;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i=num;i>=1;i--) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}

package chapter03;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력해주세요.");
		int score = sc.nextInt();
		
		if(score >100 || score < 0) {
			System.out.println("다시 입력해주세요");
		}else {
			System.out.print(score + "점은 ");
			switch (score/10) {
				case 10:
				case 9:
					System.out.println("A");
					break;
				case 8:
					System.out.println("B");
					break;
				case 7:
					System.out.println("C");
					break;
				case 6:
					System.out.println("D");
					break;
				default:
					System.out.println("F");
			}
		}
	}

}

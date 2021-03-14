package chapter03;

import java.util.Scanner;

public class IFTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력해주세요.");
		int score = sc.nextInt();

		if (score < 0 || score > 100) {
			System.out.println("잘못 입력했습니다 0~100~");
		} else {
			System.out.print(score + " 점은 ");
			if (score >= 90) {
				System.out.println("A");
			} else if (score >= 80) {
				System.out.println("B");
			} else if (score >= 70) {
				System.out.println("C");
			} else if (score >= 60) {
				System.out.println("D");
			} else {
				System.out.println("F");
			}
		}

	}

}

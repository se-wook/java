package chapter03;

import java.util.Scanner;

public class Main_539 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum=0;
		double count=0;
		while(true) {
			int num = scan.nextInt();
			sum += num;
			count++;
			if(num>=100) {
				break;
			}
		}
		System.out.println(sum);
		System.out.printf("%.1f",sum/count);
	}
}





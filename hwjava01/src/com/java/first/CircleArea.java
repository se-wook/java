package com.java.first;

import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cir = sc.nextInt();
		double area = 3.14 * cir * cir;
		
		System.out.printf("반지름이 %d Cm인 원의 넓이는 %.1f Cm2 입니다.", cir, area);
	}

}

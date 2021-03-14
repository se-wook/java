package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int rate = w+100-h;
		
		System.out.println("비만수치는 " + rate + "입니다.");
		if(rate >= 0) {
			System.out.println("당신은 비만이군요.");
		}
	}

}

package com.java.first;

import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cir = sc.nextInt();
		double area = 3.14 * cir * cir;
		
		System.out.printf("�������� %d Cm�� ���� ���̴� %.1f Cm2 �Դϴ�.", cir, area);
	}

}

package com.ssafy.java;

import java.util.Scanner;

public class AlpaTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		char alpa = 'A';
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=i;j++) {
				if(alpa == 'Z'+1) alpa = 'A';
				System.out.print(alpa + " ");
				alpa++;
			}
			System.out.println();
		}
	}

}

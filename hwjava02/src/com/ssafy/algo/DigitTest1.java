package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] digit = new int[10];
		while(true){
			int num = sc.nextInt();
			if(num == 0) {
				for(int i=0;i<10;i++){
					if(digit[i] > 0){
						System.out.println(i + " : " + digit[i] + "°³");
					}
				}
				break;
			}else{
				digit[num/10]++;
			}
		}
	}

}

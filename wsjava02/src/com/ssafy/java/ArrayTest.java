package com.ssafy.java;

import java.util.Scanner;

public class ArrayTest {
	static int list[] = new int[10];

	static void print(){
		for(int i=0;i<10;i++){
			System.out.print(list[i]);
		}
	}
	static void total(){
		int sum = 0;
		for(int i=0;i<10;i++){
			sum += list[i];
		}
		System.out.println(sum);
	}
	static void average(){
		int sum = 0;
		for(int i=0;i<10;i++){
			sum += list[i];
		}
		System.out.println(sum/10);
	}
	static void minimum(){
		int min = 11000;
		for(int i=0;i<10;i++){
			if(min > list[i]){
				min = list[i];
			}
		}
		System.out.println(min);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<10;i++){
			int num = sc.nextInt();
			list[i] = num;
		}
		System.out.print("배열의 합 : ");
		total();
		System.out.print("배열의 평균 : ");
		average();
		System.out.print("배열의 최솟 : ");
		minimum();
	}
}

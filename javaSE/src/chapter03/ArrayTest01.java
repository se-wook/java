package chapter03;

import java.util.Arrays;

public class ArrayTest01 {

	public static void main(String[] args) {
		int[] a1;
//		배열 객체를 생성하면 기본값으로 초기화 된다.
//		정수: 0  실수:0.0  논리:false  문자:\u0000  참조:null
		a1 = new int[3];	
		for (int i = 0; i < a1.length; i++) {
			System.out.printf("a1[%d]:%d\n", i, a1[i]);
		}
		
//		값 할당   변수명[index] = 값
//		a1[0] = 10;
//		a1[1] = 20;
//		a1[3] = 30; 
		System.out.println(Arrays.toString(a1));
		
//		선언과 생성을 동시에 
		int[] a2 = new int[2];
		
//		선언과 생성과 할당을 동시에
		int[] a3 = { 0, 1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(a3));
	}
}
















package chapter03;

import java.util.Arrays;

/**
 * 다차원 
 * 선언과 생성시 []가 차원을 의미  
 * 할당시에는 { }가 차원을 의미
 */
public class ArrayTest03 {
	public static void main(String[] args) {
		int[][] a1 = new int[2][3];
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[i].length; j++) {
				System.out.printf("a1[%d][%d]:%d ",i, j, a1[i][j]);
			}
			System.out.println();
		}
		
//		행마다 다른 열의 크기로 배열 생성 
		int[][] a2 = new int[3][];
		a2[0] = new int[5];
		a2[1] = new int[1];
		a2[2] = new int[10];
		for (int i = 0; i < a2.length; i++) {
			for (int j = 0; j < a2[i].length; j++) {
				System.out.printf("a2[%d][%d]:%d ",i, j, a2[i][j]);
			}
			System.out.println();
		}
//				열	   0번 1번  2번
		int[][] a3 = {{0 , 1 , 2}			//0번행
					 ,{3 , 4 , 5}			//1번행
					 ,{6 , 7 , 8}};			//2번행
		for (int i = 0; i < a3.length; i++) {
			System.out.println(Arrays.toString(a3[i]));
		}
		int[][][] a4 = {{{0},{1,2}}
					   ,{{3,4,5}}
				       };
		
		
	}
}















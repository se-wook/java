package chapter03;

import java.util.Arrays;

/**
 * ������ 
 * ����� ������ []�� ������ �ǹ�  
 * �Ҵ�ÿ��� { }�� ������ �ǹ�
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
		
//		�ึ�� �ٸ� ���� ũ��� �迭 ���� 
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
//				��	   0�� 1��  2��
		int[][] a3 = {{0 , 1 , 2}			//0����
					 ,{3 , 4 , 5}			//1����
					 ,{6 , 7 , 8}};			//2����
		for (int i = 0; i < a3.length; i++) {
			System.out.println(Arrays.toString(a3[i]));
		}
		int[][][] a4 = {{{0},{1,2}}
					   ,{{3,4,5}}
				       };
		
		
	}
}















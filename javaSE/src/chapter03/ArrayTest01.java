package chapter03;

import java.util.Arrays;

public class ArrayTest01 {

	public static void main(String[] args) {
		int[] a1;
//		�迭 ��ü�� �����ϸ� �⺻������ �ʱ�ȭ �ȴ�.
//		����: 0  �Ǽ�:0.0  ��:false  ����:\u0000  ����:null
		a1 = new int[3];	
		for (int i = 0; i < a1.length; i++) {
			System.out.printf("a1[%d]:%d\n", i, a1[i]);
		}
		
//		�� �Ҵ�   ������[index] = ��
//		a1[0] = 10;
//		a1[1] = 20;
//		a1[3] = 30; 
		System.out.println(Arrays.toString(a1));
		
//		����� ������ ���ÿ� 
		int[] a2 = new int[2];
		
//		����� ������ �Ҵ��� ���ÿ�
		int[] a3 = { 0, 1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(a3));
	}
}
















package chapter03;

import java.util.Scanner;

/**
 * 
 *	label :
 *		- �ݺ����� �̸� �ο�
 *		- Ư�� �ݺ����� break or continue �� �� �ִ�.
 *		- ����
 *			label �̸�:
 *			�ݺ���
 */
public class LabelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		first:
		for(int i=1;i<=100;i++) {
			second:
			for(int j=1;j<=100;j++) {
				System.out.printf("%d * %d = %d  ", i,j,i*j);
				if(i*j > 50) {
					break first;
				}else if(i*j >= 30){
					break second;
				}
			}
			System.out.println();
		}
	}
}

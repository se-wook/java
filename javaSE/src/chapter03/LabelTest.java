package chapter03;

import java.util.Scanner;

/**
 * 
 *	label :
 *		- 반복문에 이름 부여
 *		- 특정 반복문을 break or continue 할 수 있다.
 *		- 형식
 *			label 이름:
 *			반복문
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

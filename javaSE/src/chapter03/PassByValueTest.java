package chapter03;

import java.util.Arrays;

/**
 * - �ڹٴ� ������ ���� �����Ҷ� �޼����� ���ڸ� ������ ��, �޼����� ���� ������ �� 
 *   Pass By Value ��� �ϳ��� ��� 
 *   
 *   Pass By Value  : ������ �� ������ ����� ���� ���� 
 *   �ڹ� Ÿ��
 *     - Primitive : ������ ���� ���� ���� ��
 *       => ������ �� ���� ����(Pass By Value)
 *     - Reference : ������ ���� ��(hash code)�� ����
 *       => ������ �� ���� ��(hash code)�� ���� (Pass By Reference)   
 *        
 *
 */
public class PassByValueTest {
	public static int passValue(int a) {
		System.out.println(a);
		return a+10;
	}
	
	public static void passReference(int[] data) {
		System.out.println(Arrays.toString(data));
		data[0] = 100;
	}
	public static int[] passReference2(int[] data, int offset, int len) {
		if( offset+len <data.length) {
			int[] newArray = new int[len];
			for (int i = 0; i < len; i++) {
				newArray[i] = data[i+offset];
			}
			return newArray;
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(passValue(5));
		
		int[] array = {0,1,2,3,4,5};
		passReference(array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(passReference2(array, 2, 3)));
		
	}
}






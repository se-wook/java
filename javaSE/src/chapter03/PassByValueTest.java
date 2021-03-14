package chapter03;

import java.util.Arrays;

/**
 * - 자바는 변수에 값을 대입할때 메서드의 인자를 전달할 때, 메서드의 값을 리턴할 때 
 *   Pass By Value 방식 하나만 사용 
 *   
 *   Pass By Value  : 전달할 때 변수에 저장된 값을 전달 
 *   자바 타입
 *     - Primitive : 변수에 실제 값이 저장 됨
 *       => 전달할 때 값이 전달(Pass By Value)
 *     - Reference : 변수에 참조 값(hash code)가 저장
 *       => 전달할 때 참조 값(hash code)이 전달 (Pass By Reference)   
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






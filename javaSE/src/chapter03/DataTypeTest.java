package chapter03;

public class DataTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 정수의 기본형은 int
		 * byte, short는 연산시 자동으로 int로 형변환된다.
		 */
		byte b1 = 3, b2 = 5;
//		byte b3 = b1 + b2;
		
//		long l1 = 2222222222; //int 범위 이상의 숫자를 long에 저장하고싶다면, 저장시 long타입(l, L)이라고 표시해야한다.
		long l2 = 2222222222l;
		
		float f1 = 3.14f, f2 = 3.14F; // float임을 표시해야한다.
		float f3 = 65536.256f;
		System.out.println("f3: "+f3);
	
		double d1 = 3.14, d2 = 3.14d, d3 = 3.14D;
		double d4 = 1.2345678901234567890;
		System.out.println(d4);
		
		char c1 = 'a';
		
		boolean bl1 = true; // 0,1 로 표현 불가.
		
	}
}

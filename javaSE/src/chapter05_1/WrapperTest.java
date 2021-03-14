package chapter05_1;

public class WrapperTest {
	public static void main(String[] args) {
		/**
		 * Wrapper : primitive 타입을 객체화
		 * 
		 * primitive => 객체
		 * 	new 생성자(값);
		 * 
		 * 객체 => primitive
		 * 	객체.XXXValue();
		 */
		
		Integer inum = new Integer(5000); // wrapper
		int num = inum.intValue();
		
		/** java 5 부터는 자동 변환
		 * 다형성에 활용.?*/
		Integer iPrice = 10000; // (자동) auto-boxing
		int price = iPrice; // (자동) auto-unboxing
		
		/*
		 * 문자열 데이터를 해당 포맷의 primitive로 변환시킬 수 있음.
		 * 래퍼클래스.parseXXX(String data)
		 */
		
		int data = Integer.parseInt("256");
		
		/*
		 * int data2 = Integer.parseInt("256.1");
		 * 
		 * - NumberFormatException 발생.
		 *   사용자 실수로 입력이 들어올수 있으므로 주의.
		 * 
		 */

		double PI = Double.parseDouble("3.14");
		boolean isEmpty = Boolean.parseBoolean("true");
		System.out.println(data);
		System.out.println(PI);
		System.out.println(isEmpty);
	}
}

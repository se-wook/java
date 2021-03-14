package chapter05;

public class WrapperTest {

	public static void main(String[] args) {
		/* Wrapper  : primitive 타입을 객체화 
		 * 
		 *  primitive => 객체로 
		 *     new 생성자(값);
		 *     
		 *  객체로 => primitive
		 *     객체.XXXValue();     
		 * */
		
		Integer inum = new Integer(5000);
		int num = inum.intValue();
		
//		java5부터 자동 변환 
		Integer iPrice = 10000;			//auto boxing
		int price = iPrice;				//auto unboxing
		
		/*
		 * 문자열데이타를 해당 포맷의 primitive로 변환
		 * 래퍼클래스.parseXXX(String data) 
		 * 
		 * 잘못된 포맷의 데이타로 변환시 NumberFormatException발생한다. 
		 */
		
//		int data = Integer.parseInt("256.1");  // NumberFormatException발생한다.
		int data = Integer.parseInt("256");
		double PI= Double.parseDouble("3.14");
		boolean isEmpty = Boolean.parseBoolean("true");
		System.out.println(data);
		System.out.println(PI);
		System.out.println(isEmpty);
		
		
		
		
	}
}







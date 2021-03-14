package chapter06;


//final class 인 String은 상속 받을 수 없다. ex) String, System(= jvm 클래스)
//class StringSub extends String {}

class FinalSuper {
	public final void test() {
		
	}
}

class FinalSub extends FinalSuper{
//	final method 인 test는 override 할 수 없다.
//	public final void test() {}
}

/**
 * Blank Final Variable
 * - final로 선언된 속성의 값을 선언시 할당하지 않고 객체 생성시 할당
 * - 장점 : 객체마다 다른 고정 값을 사용할 수 있다.
 * - 규칙
 * 	 > 모든 생성자에서 반드시 값을 할당해야 한다.
 * 
 *
 */
class Blank {
	private final int serialNo;
	private static int count = 1;
	public Blank() {
		serialNo = ++count;
	}
	public Blank(int sno) {
		serialNo = sno;
	}
	
}

public class FinalTest {
	public static void main(String[] args) {
		final double PI = 3.14;
//		PI = 3.141; //변경 불가 -> compile error.
		
	}
}

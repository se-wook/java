package chapter06;

import chapter06.sub.Trans;

/**
 * 
 * interface
 * - 상수와 추상 메서드로만 구성되어있다.
 * 	 => 딱히 선언하지 않아도 속성은 public static final,
 * 		메서드는 public abstract으로 선언됨.
 * 
 * - 다중 상속이 됨. => 다형성을 위해 다중 상속이 됨.
 * - 형식]
 * 		[public] interface 인터페이스명 [extends Super인터페이스명1, ....]{ }
 * - 구현]
 * 		[modifiers] class 클래스명 [extends Super클래스명]
 * 			[implements Super인터페이스명1, ...] { }
 * 
 *  
 */


interface Flyer extends Trans, Cloneable {
	void fly();
}

class Human {
	String name;
	public void start() {
		System.out.println("걸어 봅시다.");
	}
}

class SuperMan extends Human implements Flyer {
	public SuperMan(String name) {
		this.name = name;
	}
	public void fly() {
		System.out.println("하늘을 날아서 지구를 구해야지");
	}
	public void stop() {
		System.out.println("그만 움직이고 쉬어야지");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
//		System.out.println(Trans.INIT); // 객체 생성하기도전에 접근 가능 : static이구나
//		Trans.INIT = 20; // 값 변경 불가 : final이구나
		
		SuperMan sm = new SuperMan("클라크");
		sm.start();
	
		Trans t = sm;
		Flyer f = sm;
		Cloneable c = sm;
		Human h = sm;
	}
}

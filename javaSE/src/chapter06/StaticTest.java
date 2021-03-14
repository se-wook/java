package chapter06;


/**
 * 
 * instance : 특정 클래스로부터 실제 생성된 객체
 * Object : 모든 객체들은 Object다.
 * 
 * 
 * static : 동적인 자바에게 정적인 특성을 부여
 * 			클래스가 로딩될때 딱 한번 수행됨.
 * 			객체 생성 없이 클래스 명으로 접근 가능.
 *  			- Class명.속성명 | Class명.메서드명
 * 사용 할 수 있는곳
 * -속성     + 클래스가 로딩될 때 Method Area에 속성을 위한 메모리가 한번 할당된다.
 * 		 + access modifier 범위에 따른 공유변수가됨
 * -메서드  : + 클래스가 로딩될 때 binding이 됨.(정적바인딩 = static 바인딩)
 * 		   + 속성이나 메서드 접근 없이 전달된 인자로만 처리하고 결과를 리턴하는 유틸리시성 메서드를 작성할 때 ex) Arrays.copyof
 * 		   + 주의점
 * 				non-static(=인스턴스) 속성이나,메서드에는 접근 불가.
 * -static block : + 클래스가 로딩될 때 한번 수행되는 block
 * 				   + static 속성을 초기화 하거나 또는 단 한번 수행되는 코드를 작성하면됨.
 * 				   + 형식]
 * 						static { ... }
 * 				   cf) instance block
 * 						- 객체 생성할 때마다 생성자보다 먼저 수행된다.
 * 						- 어떤 생성자로 객체를 생성하던 항상 수행되어야하는 공통 기능을 작성.
 * 						- 형식 { ... }
 * -nested class
 * 
 */

class Counter { // outer class = enclosing class
	
	static class Nested { // nested class , 특) 모든 modifier를 다 적용 가능하다.
		
	}
	
	
	static int scount;
	int icount;
	
	static {
		System.out.println("static block 수행됨.");
	}
	
	{
		System.out.println("instance block 수행됨.");
	}
	
	public Counter() {
		System.out.println("생성자 호출됨.");
		scount++;
		icount++;
	}
	public void print() {
		System.out.println("scount : " + scount);
		System.out.println("icount : " + icount);
	}
	public static void sprint() {
		System.out.println("scount : " + scount);
//		System.out.println("icount : " + icount); // non-static 속성이라 접근 불가다.
	}
}
/**
 * 
 * 클래스 로딩 (JVM이 동적으로 클래스를 로딩해준다.)
 *  1. 클래스의 객체를 처음 생성할 때 로딩이 된다. 또는 2번
 *  2. 클래스의 static한 속성이나 메서드에 처음 접근할때 로딩이 된다.
 *
 * 사용자가 원하는 시점에 클래스 로딩
 *  1. Class.forName("패키지를 포함한 클래스명을 문자열로");
 *  2. ClassLoader를 이용해서 클래스를 직접 로딩.
 *
 */
public class StaticTest {
	
	public static void main(String[] args) {
		//객체 생성 없이 접근이 가능.
		System.out.println(Counter.scount);
		
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		
		c1.print();
		c2.print();
		c3.print();
		/*
		 * scount : 3
		 * icount : 1
		 * scount : 3
		 * icount : 1
		 * scount : 3
		 * icount : 1 
		 */
	}
}

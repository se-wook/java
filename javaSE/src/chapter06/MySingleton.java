package chapter06;

/**
 * 
 * Singleton Pattern
 * 	- 클래스로 부터 생성된 객체가 오직 하나임을 보장하는 패턴.
 *  - 규칙
 *  	1. 해당 클래스 타입의 속성을 [private] static으로 선언한다.
 *  	2. 생성자도 private로 선언한다.
 *  	3. 해당 클래스의 객체를 전달하는 메소드를 public static으로 선언한다. 
 *
 */
public class MySingleton {
	private static MySingleton instance;

	private MySingleton() { // 외부에서 객체 생성불가.
	}
	
	public static MySingleton getInstance() {
		if(instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}
	
}

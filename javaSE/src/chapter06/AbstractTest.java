package chapter06;

import java.util.Calendar;

/**
 * abstract : 추상적인 특징을 부여
 * - 메서드 : 
 * 	 > 메서드의 선언부만 작성하고 구현을 하지 않음.
 * 	 > static(정적이라)도 안되고 final(override 불가라)도 안됨.
 * 	 > sub class에서 추상메서드를 반드시 override하게 한다.
 * 		=> sub class에서 추상메서드를 override 하지 않으면 compile error!
 * 	 > 형식]
 * 		[access modifier] abstract 리턴타입 메소드명 ([인자들..]); // 끝에 중괄호 있으면 에러난다.
 *   > 내용은 없어서 가볍게 상속, 자식이 override 했다는 것을 보장해줌.(일반 메서드로 두었을 때, 다형성에서 아무것도 실행 안될수도?)
 * 	 > 효과
 * 		1. 가볍게 상속
 * 		2. override에 대한 성능 저하가 쪼금 감소.
 * 		3. sub에서 반드시 override 하도록 설계시 제어하는 역할
 * 	 > 목적
 * 		1. sub들의 구현부가 서로 너무 달라서 공통 코드가 없는 경우.(super에서 구현하는 것이 의미없이 무거움)
 *  	2. 추후에 어떻게 변할지 모르겠다, 예측할 수 없다.	 
 * 
 * - 클래스 : 
 * 	 > 추상 클래스는 객체 생성을 할 수 없다.
 * 	 > 상속 전용으로 사용 => 다형성으로 사용 (부모클래스로 자식 객체 참조 가능)
 *   > 클래스 내에 추상 메소드가 하나라도 있으면 추상 클래스로 선언 해야한다.
 */


abstract class Animal {
	private String name;
	private String kind;
	private int age;
	
	/** 추상 클래스라도 sub에 의해 호출 될 수 있으므로 필요 시 생성자를 선언한다.*/
	public Animal() {}
	public Animal(String name, String kind, int age) {
		this.name = name;
		this.kind = kind;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public abstract void bark(); // 구현부 (= 중괄호 {}) 있으면 에러난다.
	public abstract void special(); 
}

class Dog extends Animal {

	public void bark() {
		System.out.println("댕댕");
	}
	public void special() {
		keep();
	}
	public void keep() {
		Calendar today = Calendar.getInstance();
		int time = today.get(Calendar.HOUR_OF_DAY);
		if(time >= 9 && time < 18) {
			System.out.println("잘 지키고 있어요");
		}else {
			System.out.println("나도 좀 쉽시당!!!");
		}
	}
}
/**
 * 추상 클래스를 상속받은 클래스가 아직도 구현하기 애매하다면
 * 또 추상 클래스로 선언하면 된다. (그 sub 클래스들이 구현하면된다.)
 */
abstract class Mammal extends Animal{
	
}

class Duck extends Animal{
	public Duck() {}
	
	public Duck(String name, String kind, int age) {
		super(name, kind, age);
	}
	public void bark() {
		System.out.println("꽥꽥");
	}
	public void special() {
		fly();
	}
	public void fly() {
		String kind = getKind();
		if(kind == null || kind.equals("집오리")) {
			System.out.println("오리는 날 수 없다 엄마에게 혼났죠~~~ ㅜ.ㅜ");
		}else {
			System.out.println("날아올라");
		}
	}
}

public class AbstractTest {
	public static void main(String[] args) {
//		추상 클래스는 생성자를 통해 객체 생성할 수 없다.
//		Animal animal = new Animal();
		
//		추상클래스라도 다형성에 의해 sub 객체를 참조할 수 있다.
		Animal ani = new Dog();
		
//		추상클래스라도 배열 객체는 생성할 수 있다.
		Animal[] animals = new Animal[2];
		animals[0] = new Dog();
		animals[1] = new Duck();
		for(Animal animal : animals) {
			animal.bark();
//			if (animal instanceof Dog) {
//				Dog dog = (Dog) animal;
//				dog.keep();
//			}else if (animal instanceof Duck) {
//				Duck duck = (Duck) animal;
//				duck.fly();
//			}
			animal.special(); // override를 통해 shadow impact 해결
		}
	}
}

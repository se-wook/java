package chapter05_1;

import org.omg.CosNaming.IstringHelper;

public class PolymorphismTest {

	public static void main(String[] args) {
		/**
		 * Reference  다형성
		 * - Super 타입의 변수로 Sub 타입의 객체를 참조할 수 있다.
		 */
		
		Employee emp = new Employee();
		emp = new Manager(); // 다형성
		emp = new Engineer(); // 다형성
		
//		Manager mgr = new Employee(); // 다형성 아님
//		Manager mgr = new Engineer(); // 다형성 아님
		
//		다형성 관계에서는 sub에 추가된 속성, 메서드에 접근할 수 없다. => shadow impact
//		System.out.println(emp.getSkill()); // 다형성 그림자.
		
		/**
		 * Reference 형 변환
		 * - 자동 형 변환 (up-casting) : 상위 개념으로 갈 때 자동
		 * 	 - Sub to Super 형 변환 시 => 모든 Sub 타입은 Super 타입으로 자동 형 변환 됨.
		 * - 명시적 형 변환 (down-casting) : 하위 개념으로 갈 때 명시
		 * 	 - Super to Sub 형 변환 시 => 모든 Super가 Sub 타입으로 형 변환 되지 않음(***중요)
		 * 	 - Super 타입이 참조하고 있는 객체의 Sub 타입으로만 형변환 할 수 있다.
		 * 
		 * cf) ClassCastException : 참조하고 있는 객체가 아닌 다른 타입으로 형 변환시 발생
		 */
		
		Manager mgr1 = new Manager();
		Employee emp1 = mgr1; // Up casting
		
		Engineer eng1 = new Engineer();
		emp1 = eng1; // Up casting
		
		Engineer eng2 = (Engineer)emp1; // Down casting
		
//		emp1 변수가 참조하는 객체는 Engnieer이므로 Manager로 형 변환시 CCE
//		Manager mgr2 = (Manager)emp1; // CCE (ClassCastingException) : 잘못된 형 변환.
		
		/**
		 * instanceof : Reference 타입에 대한 형 검사.
		 * [형식] 객체 instanceof Type
		 * 	- 객체가 해당 type이면 true, 그렇지 않으면 false를 리턴하는 operator
		 * 
		 * - 주의 : 형 검사시 sub 타입부터 검사해야한다. -> 모든 sub는 super도 되니까.
		 * 	 마지막 ELSE IF로  instanceof Employee 걸어야됨
		 */
		
		if (emp1 instanceof Manager) {
			Manager mgr3 = (Manager) emp1;
			System.out.println("emp1은 manager다. 직위 : " + mgr3.getPosition());
		}else if (emp1 instanceof Engineer) {
			Engineer eng3 = (Engineer) emp1;
			System.out.println("emp1은 Engineer다. 기술 : " + eng3.getSkill());
		}
		
		/**
		 * Virtual Invocation (= Dynamic Binding = Dynamic Linking)
		 * - 다형성 관계에서 override된 메서드가 호출될 것이다.
		 */
		System.out.println(emp1.toString()); // engineer의 toString이 출력된다.
		
		Employee empt = new Engineer();
		Engineer eng123 = (Engineer)empt;
		eng123.setSkill("자바");
		
		
		
		//main end
		System.out.println("main end");
	}

}

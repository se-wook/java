package chapter05;

public class PolymorphismTest {

	public static void main(String[] args) {
		/*
		 * Reference 다형성 
		 * - Super 타입의 변수로  sub타입의 객체를 참조할 수 있다. 
		 */
		Employee emp = new Employee();
		emp = new Manager();			//다형성
		emp = new Engineer();			//다형성 
	
//		Manager mrg = new Employee();	//다형성 아님
//		Manager mrg = new Engineer();	//다형성 아님
		
//		다형성 관계에서는 sub에 추가된 속성, 메서드에 접근 불가 => Shadow Impact
//		System.out.println(emp.getSkill());
		
		
		/*
		 * Reference 형변환 
		 * 자동 형변환(Up casting)     sub 타입에서 super 타입으로 형변환시
		 * 			=> 모든 sub타입은 super 타입으로 자동 형변환 됨. 
		 *  
		 * 명시적 형변환(Down casting)  super 타입에서 sub 타입으로 형변환시
		 * 			=> super타입이 참조하고 있는 객체의  sub타입으로만 형변환 됨. 
		 * 
		 * ClassCastException : 참조하고 있는 객체가 아닌 다른 타입으로 형변환시 발생 
		 */
		Manager mgr1 = new Manager();
		Employee emp1 = mgr1;			//up casting
		
		Engineer eng1= new Engineer();
		emp1 = eng1;					//up casting
		
		Engineer eng2 = (Engineer)emp1;	//down casting
		
//		emp1변수가 참조하는 객체는 Engineer이므로 Mananger로 형변환시 ClassCastException 발생
//		Manager  mgr2 = (Manager)emp1;	
		
		/*
		 * instanceof : Reference 타입에 대한 형검사.
		 * 형식]   객체 instanceof Type
		 *   - 객체가 해당 타입이면 true, 해당 타입이 아니면  false
		 *   주의사항 : 형검사시 sub타입 부터 검사해야 한다. 
		 *   
		 */
//		if (emp1 instanceof Employee) {
//			System.out.println("emp1은 Employee입니다.");
//		}else
		if (emp1 instanceof Manager) {
			Manager mgr3 = (Manager) emp1;
			System.out.println("emp1은 Manager입니다.   직위:"+mgr3.getPosition());
		}else if (emp1 instanceof Engineer) {
			Engineer eng3 = (Engineer) emp1;
			System.out.println("emp1은 Engineer입니다.   보유기술:"+eng3.getSkill());
		}else if (emp1 instanceof Employee) {
			System.out.println("emp1은 Employee입니다.");
		}
		
		/*
		 * Virtual Invocation(Dynamic binding = Dynamic link)
		 * - 다형성 관계에서 Override된 메서드가 호출됨.
		 */
		System.out.println(emp1.toString());
		System.out.println("main end.... ");
		Customer cust = new MainCustomer("ssafy", 2, "강남구 역삼동", "알고리즘 풀기");
		System.out.println(cust.customerInfo());
	}
}






















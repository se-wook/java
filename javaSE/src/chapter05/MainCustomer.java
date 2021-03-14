package chapter05;

public class MainCustomer extends Customer {
	private String hobby;

	public MainCustomer() {
		super();
	}

	public MainCustomer(String name, int age, String address, String hobby) {
		/*
		 * 생성자는 상속되지 않지만 호출을 통해 코드를 재사용할 수 있다.
		 * 주의점 : 생성자 호출은 생성자의 첫번째 명령에서만 호출할 수 있다.
		 * 부모의 기본생성자가 없으면, 자식 기본 생성자에서 컴파일 에러가 난다. -> 부모에 기본생성자가 있는게 낫다.
		 * -> 자식에서 인자있는 생성자를 호출해야되는데 좋은 방식은 아님 (내가 초기화를 해야됨)
		 * -> 부득이하게 특정값을 받아서 객체를 생성해야 하는 경우는 예외지만.
		 */
		//setName(name); // 해도되고
		super(name,age,address); // 생성자 호출 해도 되고 (첫 명령)
 		this.hobby = hobby;
	}
	/**
	 * Method Override (메서드 재정의)
	 * 1. 전체적인 기능은 동일하고 상세구현이 조금 다를 때 사용한다. 
	 *    이 때 상속 받은 메서드와 이름, 인자(overloading과의 차이점), 리턴타입을 동일하게
	 * 
	 * - 효과
	 * 2. 메서드 호출 방법과 리턴 타입이 기존과 같아서 호출 방법과 호출 후 처리방법이 동일하므로 
	 *    기존 코드 수정없이 변경된 내용을 반영할 수 있다.
	 * 3. 부모 객체인지 자식 객체인지 구별하지 않고 기능이 같으면 동일 이름으로 메서드를 호출해서 사용한다.
	 * 		=> 메서드 호출에 대한 편리성
	 * 4. 다형성 관계에서 override된 메서드가 호출된다.
	 * 		=> 수정해야 되는 경우 상속 받아 메서드 override하면 기존의 코드를 수정하지 않고 변경된
	 * 		      내용을 반영 할 수 있다.
	 * 5. shadow impact 문제를 해결할 수 있다. (*Sub에 추가된 속성과 메소드를 볼수없는 현상)
	 *  
	 * 
	 * - 규칙
	 * 5. 메서드 이름과 인자는 반드시 같아야한다.
	 * 6. 리턴타입
	 * 		1.7 버전 : 상속받은 메서드와 리턴타입이 반드시 같아야한다.
	 * 		1.8 버전 : 상속받은 메서드와 리턴타입이 같거나 sub를 리턴한다.
	 * 		ex)
	 * 			부모   	 	   public Customer getCustomer(); // customer 리턴
	 * 			자식 override - public Customer getCustomer(); 
	 * 				  		 - public MainCustomer getCustomer(); // 자식에서  둘다 가능.
	 * 7. access modifier는 같거나 보다 넓은 범위로 선언해야한다. (***중요)
	 *  	=> 범위를 줄이면 컴파일 에러 발생. (부모가 protected면 자식은 protected or public)
	 * 8. Exception 예외던지기 (***중요)
	 * 	    부모 메서드와 같은 레벨의 exception을 던지거나 sub를 던지거나 예외를 안던진다.
	 *
	 *  
	 */
	public String customerInfo() {
//		return "이름:"+name+"  나이:"+age+"  주소:"+address + "  취미:" +hobby; 
		/*
		 * 재정의에 의해 무시된 상속받은 메서드를 호출할 때 super 를 통해 접근.
		 * 	super.메서드이름() , super.속성  // 까지도 가능
		 */
		return super.customerInfo() +"  취미:" +hobby; 
	}
}

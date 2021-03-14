package chapter04;

public class Customer {
	String name;
	int age;
	String address;
	
	public Customer() {
//		name = "ssafy";
//		age = 2;
//		address = "seoul";
//		new Customer("ssafy",2,"Seoul"); // 메모리를 또 잡아먹으니까
		this("ssafy",2,"seoul"); //call만 하자
		name = "?";
	}
/**
 * this 용법
 * 1. 속성과 로컬 변수 이름이 같을 때 this.
 * 2. 코드 재사용을 위해 인자가 다른 생성자를 호출할 때. this()
 * 		주의 : 생성자 호출은 생성자의 첫번째 명령에서만 호출이 된다.
 * 3. 클래스 내부에서 해당 클래스의 객체가 필요한 경우. ex) 이벤트 처리
 * 
 */
	public Customer(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public boolean equals(Customer cust) {
		return this == cust;
	}
	
	String customerInfo() {
		return "이름 : "+name+" 나이 : "+age+" 주소 : "+address;
	}
}

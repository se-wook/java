package chapter05;

public class InheritanceTest {

	public static void main(String[] args) {
		MainCustomer cust1 = new MainCustomer("ssafy",2,"역삼","코딩");
		System.out.println(cust1.customerInfo());
		Customer cust2 = new Customer("홍길동",3,"율도국");
		System.out.println(cust2.customerInfo());
	}
}

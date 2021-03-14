package chapter05.sub;

import chapter05.Customer;
public class VVip extends Customer {
	public void test() {
//		super.test();			//패키지가 달라서 접근 불가
		System.out.println("VVip클래스의 test()가 호출됨.");
	}
	public void service() {
		super.service();		//protected이므로 접근 가능 
		System.out.println("VVip클래스의 service()가 호출됨.");
	}
}

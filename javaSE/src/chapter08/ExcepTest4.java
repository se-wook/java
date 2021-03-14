package chapter08;

import chapter05.Employee;

public class ExcepTest4 {
	public static void main(String[] args) {
		
		try {
			//몇 몇 error를 제외하면 error로 Throwable로 예외 처리 가능 
			Employee[] emps = new Employee[2111111111];
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("main end.....");
	}
}

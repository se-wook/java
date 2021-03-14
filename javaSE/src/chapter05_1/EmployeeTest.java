package chapter05_1;

import java.util.Arrays;

public class EmployeeTest {

	public static void main(String[] args) {
//		Manager mgr = new Manager("1","ssafy",5000000,"팀장");
//		System.out.println(mgr);
//		Engineer eng = new Engineer("2","kdg",4500000,"자바");
//		System.out.println(eng);
//		
//		int[] a = new int[3];
//		String s = new String();
//		
//		/*
//		 * 실제 객체 생성해서 해시코드를 담는 것.
//		 */
//		Employee emp = new Employee("3","길동홍",30000000);
//		/*
//		 * 배열 객체 생성 : 해시코드 값은 null이 들어있는거임
//		 */
//		Employee[] emps = new Employee[2]; 
//		System.out.println(Arrays.toString(emps));
//		
//		emps[0] = emp;
//		emps[1] = new Employee("4","멀캠",9182374);
//		System.out.println(Arrays.toString(emps));

		/**
		 * 두번째
		 */
		
//		EmployeeManager manager = new EmployeeManager();
//		manager.add(new Employee("1","홍길동",1929291));
////		manager.add(new Employee("1","홍길동",1929291));
//		manager.add(new Manager("2","길동홍",35000000, "대리"));
//		manager.add(new Engineer("3","고길동",35000000, "자바"));
//		
//		
//		System.out.println(manager.findEmployee("1"));
//		System.out.println(manager.findEmployee("2"));
//		System.out.println(manager.findEmployee("3"));
//		System.out.println(manager.findEmployee("4"));

		/**
		 * 세번째
		 */
		EmployeePolyManager manager = new EmployeePolyManager();
		manager.add(new Employee("1","홍길동",1929291));
		manager.add(new Manager("2","길동홍",35000000, "대리"));
		manager.add(new Engineer("3","고길동",35000000, "자바"));
		
		System.out.println("--------등록 후 결과---------");
		manager.print();
		System.out.println("--------등록 후 결과---------");
		manager.update(new Engineer("1","홍길동",35000000,"java"));
		manager.print();
		
		System.out.println("-----------검색 결과----------");
		System.out.println(manager.findEmployee("1"));
		System.out.println(manager.findEmployee("2"));
		System.out.println(manager.findEmployee("3"));
		System.out.println(manager.findEmployee("4"));
	}

}

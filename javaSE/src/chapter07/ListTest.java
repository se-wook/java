package chapter07;

import java.util.ArrayList;
import java.util.LinkedList;

import chapter05_1.Employee;
import chapter05_1.Manager;

/**
 * List :
 *  - 데이터를 저장한 순서대로 저장해준다.
 *  - 데이터의 index는 0부터 size()-1까지
 *  - 중간 삽입할 수 있는 Index는 0부터 size()까지 이다.
 *  	=> 범위를 벗어나면 IndexOutOfBoundsException 발생.
 *  - 데이터를 중복해서 저장할 수 있다. 
 *	- indexOf(Object o), lastIndexOf(Object o), contains(Object o)
 *	  , remove(Object o)에서 해당 기능을 수행하기 위해 equals(Object o)를 
 *	    호출해서 객체가 같은지 비교 후 처리한다.
 *	- 
 */

public class ListTest {
	public static void main(String[] args) {
		ArrayList list = null; // 기본 생성자로 생성하면 안됨.
		LinkedList list2 = null; // 기본 생성자로 생성해도 됨.
		
		list = new ArrayList(10);
		list2 = new LinkedList(); // 똑같
		list2.add("hello");
		list2.add("hello");
		list2.add("java");
		list2.add(3.14);
		list2.add(256);
		list2.add(new Employee("1","1",50000000));
//		list2.add(3,256);
//		list2.add(6,256); // IOOBE
		Object o = list2.get(5);
		if (o instanceof Employee) {
			Employee emp = (Employee) o;
			System.out.println(emp.getEmpno() + " " + emp.getName());
			
		}
		System.out.println(list2);
		
		/** 
		 * java5 부터 컬렉션에 Generic을 적용 
		 * - 선언과 생성시 저장할 타입을 지정
		 *   => 지정한 타입 외에는 저장할 수 없다.
		 * - 추출시 형 변환 없이 바로 사용 
		 * - Generic 설정시 선언과 생성에서 다형성 안됨.
		 * - Generic을 super 타입으로 설정하면 다형성에의해 sub도 저장은 가능
		 * - 형식]
		 * 	 	컬렉션<저장할타입> 변수 = new 컬렉션<저장할타입>(); 
		 * 
		 * */
		
		ArrayList<Employee> list3 = new ArrayList<Employee>(10);
//		Generic 설정시 선언과 생성에서 다형성 안됨.
//		ArrayList<Employee> list3 = new ArrayList<Manager>(10);
		
		list3.add(new Employee());
		
//		Generic을 super 타입으로 설정하면 다형성에의해 sub도 저장 가능
		list3.add(new Manager()); 
		
//		Generic에의해 설정된 타입 외에는 저장 불가능.
//		list3.add("hello"); 
		
		Employee emp = list3.get(1);
		System.out.println(emp);
		
//		equals 메소드로 같은지 다른지 비교하기 때문에 employee 클래스에서 equals함수를 적절히 override 하는게 필요하다.
		int index = list2.indexOf(new Employee("1","1",50000000));
		System.out.println("index : " + index);
		
	}
}

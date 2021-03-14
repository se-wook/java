package chapter07;

import java.util.HashSet;

import chapter05_1.Employee;

/**
 * Set
 * 	- 동일한 객체를 저장하지 않음
 * 	  => 데이터의 unique성 보장
 *  - add(Object o), contains(Object o), remove(Object o)에서
 *    equals(Object o)와 hashCode()를 호출하여 객체가 같은지 여부를 비교한다.
 *  - 데이터를 저장한 순서대로 저장하지 않는다.
 *  - index가 없다.
 *
 */
public class SetTest {
	public static void main(String[] args) {
		HashSet<String> set1 = new HashSet<>();
		System.out.println(set1.add("Hello"));
		System.out.println(set1.add("Hello"));
		System.out.println(set1.add("World"));
		System.out.println(set1.add("Ssafy"));
		System.out.println(set1);
		
		HashSet<Employee> set2 = new HashSet<>();
//		employee 클래스에 equals와 hashcode 둘다 override되어있어야 set이 정상 작동한다.
//		중복된 데이터라 하나만 들어가야 정상.
		System.out.println(set2.add(new Employee("1","1",4000000)));
		System.out.println(set2.add(new Employee("1","1",4000000)));
		System.out.println(set2);
		
		for (String str : set1) {
			System.out.println(str);
		}
	}
}

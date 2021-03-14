package chapter07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import chapter05_1.Employee;

public class SortTest {
	public static void main(String[] args) {
		/**
		 * 배열 정렬
		 * Arrays.sort(..)
		 * 
		 */
		int[] a1 = {5,1,2,3,8,4,8,0};
		Arrays.sort(a1);
		System.out.println(Arrays.toString(a1));
		
		String[] a2 = {"hello","ssafy","java","world"};
		Arrays.sort(a2);
		System.out.println(Arrays.toString(a2));
		
		Employee[] emps = new Employee[6];
		emps[0] = new Employee("1","ssafy1",3500000);
		emps[1] = new Employee("6","ssafy6",2500000);
		emps[2] = new Employee("3","ssafy3",1500000);
		emps[3] = new Employee("5","ssafy5",5500000);
		emps[4] = new Employee("4","ssafy4",4500000);
		emps[5] = new Employee("2","ssafy2",8500000);
		
		Arrays.sort(emps); // Comparable 이 아니면 CompareTo 오버라이딩
		System.out.println("----------------------기본: 내림차순-----------------------");
		for(Employee emp : emps) {
			System.out.println(emp);
		}
//		System.out.println(Arrays.toString(emps));
		Arrays.sort(emps, new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
//				오름차순 : 첫번째인자 - 두번째인자
//				내림차순 : 두번째인자 - 첫번째인자
				if(o1 != null && o2 != null) {
					return o1.getSalary() - o2.getSalary();
				}
				return 0;
			}
		});
//		System.out.println(Arrays.toString(emps));
		System.out.println("----------------------변경: 오름차순-----------------------");
		for(Employee emp : emps) {
			System.out.println(emp);
		}
		System.out.println("----------------------기본: 내림차순-----------------------");
		ArrayList<Employee> list = new ArrayList<>(5);
		list.add(new Employee("1","ssafy1",3500000));
		list.add(new Employee("6","ssafy6",2500000));
		list.add(new Employee("3","ssafy3",1500000));
		list.add(new Employee("5","ssafy5",5500000));
		list.add(new Employee("4","ssafy4",4500000));
		list.add(new Employee("2","ssafy2",8500000));
		Collections.sort(list);
		for(Employee emp : list) {
			System.out.println(emp);
		}
		System.out.println("----------------------변경: 오름차순-----------------------");
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1 != null && o2 != null && o1.getName() != null && o2.getName() != null) {
					return o1.getName().compareTo(o2.getName());
				}
				return 0;
			}
		});
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
	}
	
}

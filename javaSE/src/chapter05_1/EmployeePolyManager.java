package chapter05_1;

import java.util.Arrays;

public class EmployeePolyManager {
	/**
	 * 다형성을 배열에 적용해보자.
	 * - 모든 sub타입은 super타입으로 자동 형 변환 되므로 super 타입의 배열에
	 * 	 sub 타입도 저장할 수 있다. ==> super 타입의 배열만 선언하면됨..
	 */
	
	/** 일반직 사원을 저장하는 배열 */
	private Employee[] emps;
	/** 각 배열에 저장된 사원 수 = 다음 저장 위치 */
	private int empIndex;
	public EmployeePolyManager() {
		emps = new Employee[10];
	}
	
	/**
	 * 사원 번호에 해당하는 사원이 저장된 배열의 index를 리턴
	 * @param empno  찾을 사원번호
	 * @return 사원 번호에 해당하는 사원을 찾은경우 저장된 배열의 index를 리턴
	 * 		      못 찾은 경우 -1을 리턴
	 */
	public int findIndex(String empno) {
		if (empno != null) {
			for (int i = 0; i < empIndex; i++) {
				if (empno.equals(emps[i].getEmpno())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	
	/**
	 * 리턴 타입에 다형성을 적용해보자.
	 * - 모든 sub 타입은 super 타입으로 자동 형 변환 되므로 리턴 타입을 super 타입으로
	 *   선언하면 sub타입의 객체도 리턴할 수 있다!!
	 */
	/** 사원 번호에 해당하는 사원을 검색 */
	public Employee findEmployee(String empno) {
		int index = findIndex(empno);
		if(index != -1) {
			return emps[index];
		}else {
			return null;
		}
	}

	
	/**
	 * 메소드 인자에 다형성을 적용해보자.
	 * - 모든 sub타입은 super타입으로 자동 형 변환되므로
	 *   메서드 인자를 super타입으로 선언하면 sub타입의 객체도 인자로 전달 받을 수 있다.
	 *   => 메소드 오버로딩을 줄일 수 있게됨.
	 * @param emp
	 */
	public void add(Employee emp) {
		System.out.println("employ 등록!!");
		if (emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index != -1) {
				System.err.printf(" %s번 사원번호는 이미 등록된 번호 입니다.\n", empno);
			}else { // 동일한 사원번호로 등록된 사원이 없으므로 등록하면 된다.
				if(empIndex >= emps.length) {
					emps = Arrays.copyOf(emps, empIndex+5);
				}
				emps[empIndex++] = emp;
			}
		}
	}
	public void update(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index != -1) {
				emps[index] = emp;
				return;
			}
		}
		System.out.println("수정 불가 : 사원번호에 해당하는 사원을 찾을수 없습니다.");
	}
	/**
	 * 삭제한 공간을 null 로 두면 후에 탐색하거나 할때 NPE
	 * 1. 땡겨서 채운다. (정렬된 자료에서 사용, 속도는 느림 overhead)
	 * 2. 맨뒤에서 하나 가져와서 채운다. (속도 빠름)
	 * @param empno
	 */
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index != -1) {
			emps[index] = emps[--empIndex];
			//emps[empIndex] = null을 굳이 할 필요 없음.
		}else {
			System.out.println("삭제 불가 : 사원번호에 해당하는 사원을 찾을 수 없습니다.");
		}
	}
	
	public void print() {
		for(int i=0;i<empIndex;i++) {
			System.out.println(emps[i]);
		}
	}
}

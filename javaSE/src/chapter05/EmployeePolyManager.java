package chapter05;

import java.util.Arrays;

public class EmployeePolyManager {
	/**
	 * 다형성을 배열에 적용 
	 * - 모든 sub타입은 super타입으로 자동 형변환되므로 super타입의 배열에
	 *   sub타입도 저장할 수 있다.  
	 */
	/**일반 사원을 저장하는 배열 */
	private Employee[] emps;
	/**emps배열에 저장된 사원 수, 다음 저장 위치 */
	private int empIndex;
	public EmployeePolyManager() {
		emps = new Employee[10];
	}
	/**
	 * 사원번호에 해당하는 사원이 저장된 배열의 index를 리턴 
	 * @param empno  찾을 사원의 사원번호
	 * @return 사원번호에 해당하는 사원을 찾은 경우 저장된 배열의 index를 리턴
	 *         못 찾은 경우 -1을 리턴
	 */
	public int findIndex(String empno) {
		if(empno != null) {
			for (int i = 0; i < empIndex; i++) {
				if(empno.equals(emps[i].getEmpno())) {
					return i;
				}
			}
		}
		return -1;
	}
	/**
	 * 리턴 타입에 다형성을 적용 
	 * 모든 sub타입은 super타입으로 자동 형변환되므로 리턴 타입을 super타입으로 
	 * 선언하면 sub타입의 객체도 리턴할 수 있다. 
	 */
	/**사원번호에 해당하는 사원을 검색 */
	public Employee findEmployee(String empno) {
		int index = findIndex(empno);
		if(index > -1) {
			return emps[index];
		}else {
			return null;
		}
	}
	
	/**
	 * 다형성을 메서드 인자에 적용 
	 * 모든 sub타입은 super타입으로 자동 형변환되므로 
	 * 메서드 인자를 super타입으로 선언하면 sub타입의 객체도 인자로 전달 받을 수 있다. 
	 *  ==> 메서드 overloading을 줄일 수 있다. 
	 */
	/**
	 * 
	 * @param emp
	 */
	public void add(Employee emp) {
		System.out.println("Employee 등록..........");
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index>-1) {
				System.err.printf("%s번 사원번호는 이미 등록된 번호입니다.\n",empno);
			}else { //동일한 사원번호로 등록된 사원이 없으므로 등록 
				if(empIndex >= emps.length) { //배열이 꽉찼기 때문에 배열 크기 변경 
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
			if( index > -1) {
				emps[index] = emp;
				return;
			}
		}
		System.out.println("사원번호에 해당하는 사원이 등록되지 않아 수정할 수 없습니다.");
	}
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index > -1) {
			emps[index] = emps[--empIndex];
		}else {
			System.out.println("사원번호에 해당하는 사원이 등록되지 않아 삭제할 수 없습니다.");
		}
	}
	public void print() {
		for (int i = 0; i < empIndex; i++) {
			System.out.println(emps[i].toString());//virtual Invoke
		}
	}
}












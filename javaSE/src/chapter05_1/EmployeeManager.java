package chapter05_1;

import java.util.Arrays;

public class EmployeeManager {
	/** 일반직 사원을 저장하는 배열 */
	private Employee[] emps;
	/** 관리직 사원을 저장하는 배열 */
	private Manager[] mgrs;
	/** 기술직 사원을 저장하는 배열 */
	private Engineer[] engs;
	/** 각 배열에 저장된 사원 수 = 다음 저장 위치 */
	private int empIndex;
	private int mgrIndex;
	private int engIndex;

	public EmployeeManager() {
		emps = new Employee[10];
		mgrs = new Manager[5];
		engs = new Engineer[7];
	}

	/** 사원 번호에 해당하는 사원을 검색 */
	public String findEmployee(String empno) {
		if (empno != null) {
			for (int i = 0; i < empIndex; i++) {
				if (empno.equals(emps[i].getEmpno())) {
					return emps[i].toString();
				}
			}
			for (int i = 0; i < mgrIndex; i++) {
				if (empno.equals(mgrs[i].getEmpno())) {
					return mgrs[i].toString();
				}
			}
			for (int i = 0; i < engIndex; i++) {
				if (empno.equals(engs[i].getEmpno())) {
					return engs[i].toString();
				}
			}
		}
		return "사원 번호에 해당하는 사원 정보가 등록되지않았습니다.";
	}

	public void add(Employee emp) {
		System.out.println("employ 등록!!");
		if (emp != null) {
			String empno = emp.getEmpno();
			boolean isFind = false;
			for (int i = 0; i < empIndex; i++) {
				if (empno.equals(emps[i].getEmpno())) {
					isFind = true;
					break;
				}
			}
			if (!isFind) {
				for (int i = 0; i < mgrIndex; i++) {
					if (empno.equals(mgrs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if (!isFind) {
				for (int i = 0; i < engIndex; i++) {
					if (empno.equals(engs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if(isFind) {
				System.err.printf(" %s번 사원번호는 이미 등록된 번호 입니다.\n", empno);
			}else { // 동일한 사원번호로 등록된 사원이 없으므로 등록하면 된다.
				if(empIndex >= emps.length) {
//					Employee[] copy = new Employee[empIndex+5];
//					System.arraycopy(emps, 0, copy, 0, empIndex);
//					emps = copy; // 복사
					emps = Arrays.copyOf(emps, empIndex+5); // 위 코드랑 같은거
				}
				emps[empIndex++] = emp;
				
			}
		}
	}
	public void add(Manager emp) {
		System.out.println("manager 등록!!");
		if (emp != null) {
			String empno = emp.getEmpno();
			boolean isFind = false;
			for (int i = 0; i < empIndex; i++) {
				if (empno.equals(emps[i].getEmpno())) {
					isFind = true;
					break;
				}
			}
			if (!isFind) {
				for (int i = 0; i < mgrIndex; i++) {
					if (empno.equals(mgrs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if (!isFind) {
				for (int i = 0; i < engIndex; i++) {
					if (empno.equals(engs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if(isFind) {
				System.err.printf(" %s번 사원번호는 이미 등록된 번호 입니다.\n", empno);
			}else {
				if(mgrIndex >= mgrs.length) {
					mgrs = Arrays.copyOf(mgrs, mgrIndex+5);
				}
				mgrs[mgrIndex++] = emp;
			}
		}
		
	}
	public void add(Engineer emp) {
		System.out.println("Engineer 등록!!");
		if (emp != null) {
			String empno = emp.getEmpno();
			boolean isFind = false;
			for (int i = 0; i < empIndex; i++) {
				if (empno.equals(emps[i].getEmpno())) {
					isFind = true;
					break;
				}
			}
			if (!isFind) {
				for (int i = 0; i < mgrIndex; i++) {
					if (empno.equals(mgrs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if (!isFind) {
				for (int i = 0; i < engIndex; i++) {
					if (empno.equals(engs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if(isFind) {
				System.err.printf(" %s번 사원번호는 이미 등록된 번호 입니다.\n", empno);
			}else {
				if(engIndex >= engs.length) {
					engs = Arrays.copyOf(engs, engIndex+5);
				}
				engs[engIndex++] = emp;
			}
		}
		
	}
}

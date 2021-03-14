package com.ssafy.model.dao;

import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.CannotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;

public class EmployeePolyManager implements EmployeeDao {
	
	private List<Employee> emps;

	public EmployeePolyManager() {
		emps = new LinkedList<Employee>();
	}
	
	public int findIndex(String empno) {
		if(empno != null) {
			for(int i=0, empIndex=emps.size(); i<empIndex; i++) {
				Employee emp = emps.get(i);
				if(empno.equals(emp.getEmpno())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	@Override
	public Employee findEmployee(String empno) {
		int index = findIndex(empno);
		if(index > -1) {
			return emps.get(index);
		} else {
			String msg = String.format("%s번 사원번호는 등록되지 않은 사원번호입니다.",empno);
			throw new CannotFindException(msg);
		}
	}
	
	@Override
	public void add(Employee emp) {
		System.out.println("Employee 등록.........");
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			
			if(index>-1) {
				String msg = String.format("%s번 사원번호는 이미 등록된 번호입니다.", empno);
				throw new DuplicateException(msg);
			} else {
				emps.add(emp);
			}
		}
	}
	
	@Override
	public void update(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index > -1) {
				emps.set(index, emp);
				return;
			} else {
				throw new CannotFindException("사원번호에 해당하는 사원이 등록되지 않아 수정할 수 없습니다.");
			}
		} else {
			throw new CannotFindException("수정할 사원 정보를 입력해주세요.");
		}
	}

	@Override
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index > -1) {
			emps.remove(index);
			return;
		} else {
			throw new CannotFindException("\"사원번호에 해당하는 사원이 등록되지 않아 삭제할 수 없습니다.\"");
		}
	}
	
	public void print() {
		for(Employee emp : emps) {
			System.out.println(emp);
		}
	}

	@Override
	public void close() {
		System.exit(0); // JVM 종료
	}

	@Override
	public List<Employee> searchAll() {
		return emps;
	}
	
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}	

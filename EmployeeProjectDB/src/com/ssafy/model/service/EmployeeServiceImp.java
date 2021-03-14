package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.EmployeeDao;
import com.ssafy.model.dao.EmployeeDaoImp;
import com.ssafy.model.dto.CanNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;

public class EmployeeServiceImp implements EmployeeService {
	private EmployeeDao dao = new EmployeeDaoImp();
	@Override
	public Employee findEmployee(String empno) throws CanNotFindException {
		try {
			return dao.findEmployee(empno);
		} catch (Exception e) {
			e.printStackTrace(); // 나중에 오류 없으면 지워버림
			throw new CanNotFindException("사원을 찾는 중 오류가 발생했습니다.");
		}
	}

	@Override
	public List<Employee> searchAll() {
		try {
			return dao.searchAll();
		} catch (Exception e) {
			throw new RuntimeException("사원 리스트를 검색 중 오류 발생");
		}
	}
	@Override
	public void add(Employee emp) throws DuplicateException {
		try {
			Employee find = dao.findEmployee(emp.getEmpno());
			if(find != null) {
				throw new DuplicateException("이미 등록된 사원 번호 입니다.");
			}else {
				dao.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DuplicateException("사원정보를 저장 중 오류 발생");
		}
	}

	@Override
	public void update(Employee emp) throws CanNotFindException {
		try {
			Employee find = dao.findEmployee(emp.getEmpno());
			if(find == null) {
				throw new CanNotFindException("수정할 사원 정보를 찾지 못했습니다.");
			}else {
				dao.update(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CanNotFindException("사원정보를 수정 중 오류 발생");
		}
	}

	@Override
	public void remove(String empno) throws CanNotFindException {
		try {
			Employee find = dao.findEmployee(empno);
			if(find == null) {
				throw new CanNotFindException("삭제할 사원 정보를 찾지 못했습니다.");
			}else {
				dao.remove(empno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CanNotFindException("사원정보를 삭제 중 오류 발생");
		}
	}

	@Override
	public void close() {
		System.exit(0);
	}


}

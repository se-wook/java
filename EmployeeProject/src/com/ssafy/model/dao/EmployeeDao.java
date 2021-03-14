package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.Employee;

public interface EmployeeDao {
	
	/** 사원 번호에 해당하는 사원을 검색 */
	Employee findEmployee(String empno);
	void add(Employee emp);
	void load();
	void save();
	void update(Employee emp);
	void remove(String empno);
	void close();
	List<Employee> searchAll();
}
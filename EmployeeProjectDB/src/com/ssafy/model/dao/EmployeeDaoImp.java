package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Employee;
import com.ssafy.util.DBUtil;

public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public Employee findEmployee(String empno) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		try {
			con = DBUtil.getConnection();
			String sql = "select empno, ename, sal from emp where empno = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, empno);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getString("empno"),rs.getString("ename"),rs.getInt("sal"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}

	@Override
	public void add(Employee emp) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into emp(empno, ename, sal) values(?,?,?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(emp.getEmpno()));
			stmt.setString(2, emp.getName());
			stmt.setInt(3, emp.getSalary());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Employee emp) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update emp set ename=?, sal=? where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, emp.getName());
			stmt.setInt(2, emp.getSalary());
			stmt.setInt(3, Integer.parseInt(emp.getEmpno()));
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void remove(String empno) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from emp where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, empno);
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> searchAll() throws SQLException{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		try {
			con = DBUtil.getConnection();
			String sql = "select empno, ename, sal from emp ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Employee> emps = new ArrayList<Employee>();
			while(rs.next()) {
				emps.add(new Employee(rs.getString("empno"),rs.getString("ename"),rs.getInt("sal")));

			}
			return emps;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}

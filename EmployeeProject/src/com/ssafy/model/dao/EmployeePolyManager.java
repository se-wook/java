package com.ssafy.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.CanNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;

public class EmployeePolyManager implements EmployeeDao {
	/**
	 * 다형성을 배열에 적용해보자.
	 * - 모든 sub타입은 super타입으로 자동 형 변환 되므로 super 타입의 배열에
	 * 	 sub 타입도 저장할 수 있다. ==> super 타입의 배열만 선언하면됨..
	 */
	
	/** 일반직 사원을 저장하는 배열 */
	private List<Employee> emps; // map!
	
	/* file */
	private String fileName = "employee.txt";
	
	/** 각 배열에 저장된 사원 수 = 다음 저장 위치 */
	private int empIndex;
	public EmployeePolyManager() {
		emps = new LinkedList<Employee>();
		load();
	}
	
	
	public void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(fileName);
			if(file.exists() && file.canRead()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				emps = (List) ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {try {ois.close();}catch(Exception e) {}}
			if(fis != null) {try {fis.close();}catch(Exception e) {}}
		}
	}
	
	public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emps);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {try {oos.close();}catch(Exception e) {}} // 작은문 닫고
			if(fos != null) {try {fos.close();}catch(Exception e) {}} // 큰문 닫기
		}
	}
	
	
	/**
	 * 사원 번호에 해당하는 사원이 저장된 배열의 index를 리턴
	 * @param empno  찾을 사원번호
	 * @return 사원 번호에 해당하는 사원을 찾은경우 저장된 배열의 index를 리턴
	 * 		      못 찾은 경우 -1을 리턴
	 */
	public int findIndex(String empno) {
		if (empno != null) {
			for (int i = 0, empIndex = emps.size(); i < empIndex; i++) {
				Employee emp = emps.get(i);
				if (empno.equals(emp.getEmpno())) {
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
	@Override
	public Employee findEmployee(String empno) {
		int index = findIndex(empno);
		if(index != -1) {
			return emps.get(index);
		}else {
			throw new CanNotFindException("사원번호에 해당하는 사원을 찾을 수 없습니다.");
		}
	}

	
	@Override
	public void add(Employee emp) {
		System.out.println("employ 등록!!");
		if (emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index != -1) {
				String msg = String.format(" %s번 사원번호는 이미 등록된 번호 입니다.\n", empno);
				throw new DuplicateException(msg);
			}else { // 동일한 사원번호로 등록된 사원이 없으므로 등록하면 된다.
				emps.add(emp);
			}
		}
	}

	@Override
	public void update(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index != -1) {
				emps.set(index, emp);
				return;
			}else {
				throw new CanNotFindException("수정 불가 : 사원번호에 해당하는 사원을 찾을수 없습니다.");
			}
		}else {
			throw new CanNotFindException("수정 불가 : 수정할 사원 정보를 입력해주세요.");
		}
	}

	@Override
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index != -1) {
//			emps[index] = emps[--empIndex];
//			emps[empIndex] = null을 굳이 할 필요 없음.
			emps.remove(index);
		}else {
			throw new CanNotFindException("삭제 불가 : 사원번호에 해당하는 사원을 찾을 수 없습니다.");
		}
//		save();
	}

	
	public void close() {
		save(); 
		System.exit(0); // JVM 종료
	}
	public List<Employee> searchAll(){
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}

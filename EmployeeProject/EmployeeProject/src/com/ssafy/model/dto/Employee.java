package com.ssafy.model.dto;

public class Employee implements Cloneable{
	
	private String empno;
	private String name;
	private int    salary;
	
	public Employee() {}
	
	public Employee(String empno, String name, int salary) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}

	/*public String toString() {
		return "사원번호 : " + empno + "\t이름 : " + name + "\t급여 : " + salary;
	}*/	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append("empno=").append(empno).append(", name=").append(name).append(", salary=")
				.append(salary);
		return builder.toString();
	}
	
	
	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Employee) {
			Employee emp = (Employee)obj;
			if(empno != null && empno.equals(emp.empno)) {
				return true;
			}
		}		
		return false;
	}
	
	/*public int hashCode() {
		int empnoHash = empno != null ? empno.hashCode() : 1;
		int nameHash = name != null ? name.hashCode() : 1;
		return empnoHash + nameHash + salary;
	}*/
	
	/**
	 *  객체의 내용이 똑같은 객체를 생성해서 리턴
	 *   - Object에서 protected로 선언했기 때문에 함수를 사용할려면 반드시 Override 해야한다.
	 *   - Cloneable 인터페이스를 구현해야 한다. (안하면 Exception 예외발생)
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

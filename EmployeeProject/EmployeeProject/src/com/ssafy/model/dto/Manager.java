package com.ssafy.model.dto;

public class Manager extends Employee{
	
	private String position;
	
	public Manager() { super(); }

	public Manager(String empno, String name, int salary, String position) {
		super(empno, name, salary);
		this.position = position;
	}
	
	public String toString() {
		return super.toString() + "\t직위 : " + position;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}

package com.ssafy.model.dto;

public class Engineer extends Employee{
	
	private String skill;
	
	public Engineer() { super(); }

	public Engineer(String empno, String name, int salary, String skill) {
		super(empno, name, salary);
		this.skill = skill;
	}
	
	/*public String toString() {
		return super.toString() + "\t스킬 : " + skill;
	}*/
	
	public String toString() {
		return new StringBuilder(50)
					.append(super.toString())
					.append(" 보유기술:")
					.append(skill)
					.toString();
	}
	
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
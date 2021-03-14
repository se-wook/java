package chapter05_1;

public class Engineer extends Employee{
	private String skill;

	public Engineer() {	}

	public Engineer(String empno, String name, int salary, String skill) {
		super(empno, name, salary);
		this.skill = skill;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public String toString() {
		// StringBuilder 기본 16????
		return new StringBuilder(super.toString()).append(" 기술:").append(skill).toString();
	}
}

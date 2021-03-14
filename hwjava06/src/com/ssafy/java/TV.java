package com.ssafy.java;

public class TV extends Product{
	private String displayType;
	private int inch;
	
	public TV() {
	}
	
	public TV(String productNo, String productName, String displayType, int price, int amount, int inch) {
		super(productNo, productName, price, amount);
		setDisplayType(displayType);
		setInch(inch);
	}
	
	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		if(inch < 0) {
			System.out.println("인치는 0보다 작게 설정할 수 없습니다.");
			return;
		}
		this.inch = inch;
	}

	public String toString() {
		return super.toString() + " | " + inch + " | " + displayType;
	}
	
	
	
}

package com.ssafy.java;

public class TV {
	private String productNo, productName, displayType;
	private int price, amount, inch;
	
	public TV() {
		setProductNo("");
		setProductName("");
		setDisplayType("-");
		setPrice(0);
		setAmount(0);
		setInch(0);
	}
	
	public TV(String productNo, String productName, String displayType, int price, int amount, int inch) {
		setProductNo(productNo);
		setProductName(productName);
		setDisplayType(displayType);
		setPrice(price);
		setAmount(amount);
		setInch(inch);
	}
	
	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price < 0) {
			System.out.println("가격은 0보다 작게 설정할 수 없습니다.");
			return;
		}
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if(amount < 0) {
			System.out.println("수량은 0보다 작게 설정할 수 없습니다.");
			return;
		}
		this.amount = amount;
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
		return productNo + " | " + productName + " | " + price + " | "
				+ amount + " | " + inch + " | " + displayType;
	}
	
	
	
}

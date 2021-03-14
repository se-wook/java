package com.ssafy.java;

public class Refrigerator {
	private String productNo, productName;
	private int price, amount, capacity;
	
	public Refrigerator() {
		setProductNo("");
		setProductName("");
		setPrice(0);
		setAmount(0);
		setCapacity(0);
	}

	public Refrigerator(String productNo, String productName, int price, int amount, int capacity) {
		setProductNo(productNo);
		setProductName(productName);
		setPrice(price);
		setAmount(amount);
		setCapacity(capacity);
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if(amount < 0) {
			System.out.println("용량은 0보다 작게 설정할 수 없습니다.");
			return;
		}
		this.capacity = capacity;
	}

	public String toString() {
		return productNo + " | " + productName + " | " + price + " | "
				+ amount + " | " + capacity;
	}
	
}

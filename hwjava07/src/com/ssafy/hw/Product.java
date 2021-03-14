package com.ssafy.hw;

public class Product {
	private String productNo, productName;
	private int price, amount;

	public Product() {
	}

	public Product(String productNo, String productName, int price, int amount) {
		setProductNo(productNo);
		setProductName(productName);
		setPrice(price);
		setAmount(amount);
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
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String toString() {
		return productNo + " | " + productName + " | " + price + " | " + amount;

	}
}

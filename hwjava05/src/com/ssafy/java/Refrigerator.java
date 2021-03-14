package com.ssafy.java;

public class Refrigerator extends Product{
	private int capacity;
	
	public Refrigerator() {}

	public Refrigerator(String productNo, String productName, int price, int amount, int capacity) {
		super(productNo, productName, price, amount);
		setCapacity(capacity);
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String toString() {
		return super.toString() + " | " + capacity;
	}
	
}

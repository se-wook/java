package com.ssafy.java;

public class SmartPhone extends Product{
	private String vendor, model;

	public SmartPhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String productNo, String productName, int price, int amount, String vendor, String model) {
		super(productNo, productName, price, amount);
		setVendor(vendor);
		setModel(model);
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String toString() {
		return super.toString() + " " + vendor + " " + model;
	}
	
}

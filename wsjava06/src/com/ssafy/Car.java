package com.ssafy;

public class Car {
	private String num, model;
	private int price;
	public Car() {}
	public Car(String num, String model, int price) {
		setNum(num);
		setModel(model);
		setPrice(price);
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			System.err.println("가격은 0보다 작을 수 없습니다.");
			return;
		}
		this.price = price;
	}
	public String toString() {
		return num + " / " + model + " / " + price + " 원 / ";
	}
}

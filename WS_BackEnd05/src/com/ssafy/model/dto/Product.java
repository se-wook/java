package com.ssafy.model.dto;

import java.io.Serializable;

public class Product implements Serializable {
	private String no;
	private String name;
	private String price;
	private String desc;
	public Product() {
		super();
	}
	public Product(String no, String name, String price, String desc) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.desc = desc;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Product [no="+ no +", name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}
	
}

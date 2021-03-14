package com.ssafy.ws;

import java.io.Serializable;

public class Book implements Serializable{
	private String isbn, title;
	private int price, quantity;
	public Book() {}
	
	public Book(String isbn, String title, int price, int quantity) {
		setIsbn(isbn);
		setTitle(title);
		setPrice(price);
		setQuantity(quantity);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return isbn + " | "+ title + " | " + price + " | " + quantity;
	}
	
}

package com.ssafy.Book;

public class Book {
	private String isbn, title, author, publisher, desc;
	private int price;
	public Book() {}
	
	public Book(String isbn, String title, String author, String publisher, String desc, int price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.desc = desc;
		this.price = price;
	}

	public String toString() {
		return isbn + " | " + String.format("%-10s", title) + " | " + author + " | " + publisher + " | "
				+ price + " | " + desc;
	}
	
}

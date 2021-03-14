package com.ssafy.ws;

import java.util.Arrays;

public class BookManager {
	private Book[] books;
	private int idx;
	
	public BookManager() {
		books = new Book[10];
		idx = 0;
	}
	
	public int findIndex(String isbn) {
		if(isbn != null) {
			for(int i=0;i<idx;i++) {
				if(isbn.equals(books[i].getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void add(Book book) {
		if(book != null) {
			String isbn = book.getIsbn();
			int bookidx = findIndex(isbn);
			if(bookidx != -1) {
				System.out.println("이미 등록된 isbn입니다.");
			}else {
				if(idx >= books.length) {
					books = Arrays.copyOf(books, idx+5);
				}
				books[idx++] = book;
			}
		}
	}
	
	public void showAll() {
		for(int i=0;i<idx;i++) {
			System.out.println(books[i]);
		}
	}
	
	public void isbnSearch(String isbn) {
		int bookidx = findIndex(isbn);
		if(bookidx != -1) {
			System.out.println(books[bookidx]);
		}else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public void titleSearch(String title) {
		for(int i=0;i<idx;i++) {
			if(books[i].getTitle().contains(title)) {
				System.out.println(books[i]);
			}
		}
	}
	public void bookSearch() {
		for(int i=0;i<idx;i++) {
			if (!(books[i] instanceof Magazine)) {
				System.out.println(books[i]);					
			}
		}
	}
	public void magazineSearch() {
		for(int i=0;i<idx;i++) {
			if (books[i] instanceof Magazine) {
				System.out.println(books[i]);
			}
		}
	}
	public void publisherSearch(String publisher) {
		for(int i=0;i<idx;i++) {
			if(publisher.equals(books[i].getPublisher())) {
				System.out.println(books[i]);
			}
		}
	}
	public void priceSearch(int price) {
		for(int i=0;i<idx;i++) {
			if(books[i].getPrice() < price) {
				System.out.println(books[i]);
			}
		}
	}
	public int sum() {
		int p = 0;
		for(int i=0;i<idx;i++) {
			p += books[i].getPrice();
		}
		return p;
	}
	public int average() {
		int p = sum();
		return p/idx;
	}
	
}

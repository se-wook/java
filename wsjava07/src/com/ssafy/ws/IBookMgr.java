package com.ssafy.ws;

import java.util.List;

public interface IBookMgr {

	int findIndex(String isbn);
	void add(Book book);
	List<Book> searchAll();
	void isbnSearch(String isbn);
	void titleSearch(String title);
	void bookSearch();
	void magazineSearch();
	void magazineSearch(int year);
	void publisherSearch(String publisher);
	void priceSearch(int price);
	int sum();
	int average();
}
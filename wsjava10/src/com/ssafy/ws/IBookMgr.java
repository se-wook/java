package com.ssafy.ws;

import java.util.List;

public interface IBookMgr {

	int findIndex(String isbn);
	void add(Book book);
	List<Book> search();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	void open();
	void close();
	void save();
}
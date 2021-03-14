package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Book;

public interface BookDAO {
	public void insertBook(Book book) throws SQLException;
	public void updateBook(Book book) throws SQLException;
	public void deleteBook(String isbn) throws SQLException;
	public Book findBook(String isbn) throws SQLException;
	public List<Book> listBooks() throws SQLException;
	public int count() throws SQLException; // 페이징 처리
}

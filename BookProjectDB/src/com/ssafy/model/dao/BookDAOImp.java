package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.Book;
import com.ssafy.util.DBUtil;

public class BookDAOImp implements BookDAO {

	@Override
	public void insertBook(Book book) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into books (isbn, title, author, publisher, price, description) "
						+ " values(?,?,?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getPublisher());
			stmt.setInt(5, book.getPrice());
			stmt.setString(6, book.getDescription());
			stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update books set title = ?,"
						+ " author = ?, publisher = ?,"
						+ " price = ? , description = ?) "
						+ " where isbn=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getPublisher());
			stmt.setInt(4, book.getPrice());
			stmt.setString(5, book.getDescription());
			stmt.setString(6, book.getIsbn());
			stmt.executeUpdate();

		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void deleteBook(String isbn) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from books where isbn=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public Book findBook(String isbn) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from books where isbn =? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Book(isbn, rs.getString("title"), rs.getString("author")
						, rs.getString("publisher"), rs.getInt("price"), rs.getString("description"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}

	@Override
	public List<Book> listBooks() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from books ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Book> books = new LinkedList<Book>();
			if(rs.next()) {
				books.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author")
						, rs.getString("publisher"), rs.getInt("price"), rs.getString("description")));
			}
			return books;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public int count() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select count(*) as cnt from books ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return 0;
	}

}

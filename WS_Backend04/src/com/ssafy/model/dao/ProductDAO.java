package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Product;


public interface ProductDAO {
	public int lastSearch() throws SQLException;
	public Product search(String id) throws SQLException;
	public List<Product> searchAll( ) throws SQLException;
	public void add(Product product)	 throws SQLException;
	public void update(Product product)throws SQLException;
	public void remove(String id)    throws SQLException;
}

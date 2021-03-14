package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductService {
	public Product search(String id);
	public int lastSearch();
	public List<Product> searchAll();
	public void add(Product product);
	public void update(Product product);
	public void remove(String id);
}

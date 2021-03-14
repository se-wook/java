package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.ProductDAO;
import com.ssafy.model.dao.ProductDAOImp;
import com.ssafy.model.dto.Product;
import com.ssafy.model.dto.ProductException;

public class ProductServiceImp implements ProductService {
	private ProductDAO dao = new ProductDAOImp();

	@Override
	public Product search(String id) {
		try {
			Product product = dao.search(id);
			if(product == null) {
				throw new ProductException("등록되지 않은 제품입니다.");
			}else {
			   return product;
			}
		} catch (Exception e) {
			throw new ProductException();
		}
	}

	@Override
	public List<Product> searchAll() {
		try {
			return dao.searchAll();
		}catch (SQLException e) {
			throw new ProductException();
		}
	}
	
	@Override
	public void add(Product product) {
		try {
			Product find = dao.search(product.getName());
			if(find != null) {
				throw new ProductException("이미 등록된 제품입니다.");
			}else {
				dao.add(product);
			}
		} catch (SQLException e) {
			throw new ProductException();
		}
	}

	@Override
	public void update(Product product) {
		try {
			Product find = dao.search(product.getName());
			if(find == null) {
				throw new ProductException("수정할 제품 정보가 없습니다.");
			}else {
				dao.update(product);
			}
		} catch (SQLException e) {
			throw new ProductException();
		}
	}

	@Override
	public void remove(String id) {
		try {
			Product find = dao.search(id);
			if(find == null) {
				throw new ProductException("삭제할 제품 정보가 없습니다.");
			}else {
				dao.remove(id);
			}
		} catch (SQLException e) {
			throw new ProductException();
		}
	}

	@Override
	public String lastSearch() {
		try {
			String find = dao.lastSearch();
			if(find == "") {
				throw new ProductException("등록된 제품이 없습니다.");
			}else {
				return find;
			}
		} catch (SQLException e) {
			throw new ProductException();
		}
	}

}

package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.Product;
import com.ssafy.util.DBUtil;

public class ProductDAOImp implements ProductDAO {

	@Override
	public Product search(String id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from goods where gno = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Product(rs.getString("gno")
								, rs.getString("brand")
								, rs.getString("price")
						        , rs.getString("info"));
			}
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
		return null;
	}

	@Override
	public List<Product> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from goods  ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Product> product = new ArrayList<Product>();
			while(rs.next()) {
				product.add(new Product(rs.getString("gno")
									  , rs.getString("brand")
							          , rs.getString("price")
							          , rs.getString("info")));
			}
			return product;
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
	}

	@Override
	public void add(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into goods(brand, price, info) "
					   + " values(?,?,?) ";
			System.out.println(sql);
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, product.getName());		
			stmt.setString(idx++, product.getPrice());		
			stmt.setString(idx++, product.getDesc());		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update goods set price=?, info=? "
						+"                  where brand=? " ;
			
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, product.getPrice());		
			stmt.setString(idx++, product.getDesc());		
			stmt.setString(idx++, product.getName());		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void remove(String id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from goods where gno=? " ;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public String lastSearch() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		String num = "";
		try {
			con = DBUtil.getConnection();
			String sql = " select gno+1 as gno from goods order by gno desc limit 1 ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				num = rs.getString("gno");
			}
			return num;
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
	}

}

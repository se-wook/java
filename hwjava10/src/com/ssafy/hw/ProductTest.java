package com.ssafy.hw;

import java.util.List;

public class ProductTest {

	public static void main(String[] args)  {
		
		ProductMgrImpl pm = new ProductMgrImpl();
		// 1. 상품 정보 add
		try {
			pm.add(new TV("2000", "Samsung-TV001", "A", 500000, 10, 72));
			pm.add(new TV("2001", "Samsung-TV002", "B", 100000, 20, 32));
			pm.add(new Refrigerator("1000","Samsung-RA101", 700000, 10, 1000));
			pm.add(new Refrigerator("1001","Samsung-RA201", 500000, 20, 3000));
		} catch (DuplicateException e) {
			e.printStackTrace();
		}
		
//		try {
//			pm.add(new TV("2002", "Samsung-TV003", "C", 200000, 30, 42));
//		} catch (DuplicateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			pm.add(new Refrigerator("1002","Samsung-RA102", 800000, 30, 2000));
//		} catch (DuplicateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		

		// 2. 상품 전체 검색
		System.out.println("*************************상품 전체 검색**************************");
		pm.searchAll();
		List<Product> products = pm.searchAll();
		for(Product p : products) {
			System.out.println(p);
		}
		
		pm.send();
		pm.save();
	}


}

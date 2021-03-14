package com.ssafy.java;

public class ProductTest {

	public static void main(String[] args) {
//		private String productNo, productName;
//		private int price, amount, capacity;
		TV t1 = new TV("2000", "Samsung-TV001", "A", 500000, 10, 75);
		TV t2 = new TV();
		t2.setProductNo("2001");
		t2.setProductName("Samsung-TV002");
		t2.setPrice(700000);
		Refrigerator r1 = new Refrigerator("1000","Samsung-RA101", 700000, 20, 1000);
		System.out.println("************제품 정보***************");
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(r1.toString());
		
		
	}

}

package chapter15_dom;

import com.google.gson.Gson;

import chapter05.Customer;
import chapter15.Weather;

/**
 * JSON 데이터를 객체로 변환 
 */
public class JSONTest2 {
	public static void main(String[] args) {
		String json = "{\"name\":\"홍길동\",\"age\":17,\"address\":\"율도국\"}";
		Gson gson = new Gson();
		
		/**
		 * Class 정보를 추출하는 방법
		 * 1. 객체 생성후 객체를 통해 추출
		 * 		Customer c = new Customer();
		 * 		c.getClass();
		 * 2. 클래스명.class
		 * 		Customer.class
		 */
		
		Customer cust = gson.fromJson(json, Customer.class);
		System.out.println(cust);
	}
}

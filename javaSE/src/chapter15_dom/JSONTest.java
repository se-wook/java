package chapter15_dom;

import com.google.gson.Gson;

import chapter04.Customer;

public class JSONTest {
	public static void main(String[] args) {
		Customer cust = new Customer("홍길동",17,"율도국");
		Gson gson = new Gson();
		//String toJson(Object o) : 인자를  JSON 데이터로 변경하는 기능
		String json = gson.toJson(cust);
		System.out.println(json);
		Customer[] custs = {
			cust, new Customer("ssafy",2,"강남구")
		};
		System.out.println(gson.toJson(custs));
	}
}

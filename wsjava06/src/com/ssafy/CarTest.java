package com.ssafy;

public class CarTest {

	public static void main(String[] args) {
		CarMgr cm = CarMgr.getInstance();
		
		Car c1 = new Car("1000", "현대자동차", 50000);
		Car c2 = new Car("1001", "기아자동차", 60000);
		Truck t1 = new Truck("1002", "현대트럭", 70000,5);
		Truck t2 = new Truck("1003", "기아트럭", 80000,6);
		Bus b1 = new Bus("1004", "현대버스", 90000,40);
		Bus b2 = new Bus("1005", "기아버스", 100000,45);
		
		cm.add(c1);
		cm.add(c2);
		cm.add(t1);
		cm.add(t2);
//		cm.add(t1); // 이미 존재하는 차량 추가.
		cm.add(b1);
		cm.add(b2);
		
		Car[] cr = cm.search();
		for(int i=0;i<cr.length;i++) {
			if(cr[i] == null) break;
			System.out.println(cr[i]);
		}
		System.out.println("======================");
		cr = cm.search(80000);
		for(int i=0;i<cr.length;i++) {
			if(cr[i] == null) break;
			System.out.println(cr[i]);
		}
		System.out.println("======================");
		System.out.println(cm.search("1004"));
		System.out.println("======================");
		cm.update("1004",10);
		System.out.println(cm.search("1004"));
		System.out.println("======================");
		cm.delete("1004");
		System.out.println(cm.search("1004"));
		System.out.println(cm.size() + " 대");
		System.out.println(cm.totalPrice() + " 원");
		
	}

}

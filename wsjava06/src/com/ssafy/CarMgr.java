package com.ssafy;

import java.util.Arrays;

import com.ssafy.Car;

public class CarMgr {
	private Car[] cars = new Car[100];
	private int index;
	private static CarMgr manager;

	private CarMgr() {}
	
	public static CarMgr getInstance() {
		if(manager == null) {
			manager = new CarMgr();
		}
		return manager;
	}
	
	/** 파라메터로 전달된 차량 정보를 배열에 저장 */
	public void add (Car c) {
		if(c != null) {
			String carnum = c.getNum();
			int cidx = -1;
			for(int i=0;i<index;i++) {
				if(carnum.equals(cars[i].getNum())) {
					cidx  = i;
				}
			}
			if(cidx == -1) {
				if(index >= cars.length) {
					Arrays.copyOf(cars, index + 100);
				}
				cars[index++] = c;
			}else {
				System.err.printf("%s : 동일한 번호를 갖는 차량이 존재합니다.",carnum);
			}
		}
	}
	/** 현재 저장된 모든 차량 정보를 리턴 */
	public Car[] search() {
		return cars;
	}
	/** 파라메터로 전달된 번호와 같은 차량정보를 리턴 */
	public Car search(String num) {
		for(int i=0;i<index;i++) {
			if(num.equals(cars[i].getNum())){
				return cars[i];
			}
		}
		return null;
	}
	/** 파라메터로 전달된 가격보다 작은 차량 정보 들을 리턴 */
	public Car[] search(int price) {
		Car[] c1 = new Car[100];
		int cidx = 0;
		for(int i=0;i<index;i++) {
			if(cars[i].getPrice() < price) { // 낮은 가격 검색후 배열에 추가
				c1[cidx++] = cars[i];
			}
			
			if(cidx >= c1.length) { // 배열 길이 증가
				Arrays.copyOf(c1, cidx+100);
			}
		}
		return c1;
	}
	/** 파라메터로 전달된 번호의 차량을 검색하여 가격을 수정  */
	public void update(String num, int price) {
		boolean flag = false;
		for(int i=0;i<index;i++) {
			if(num.equals(cars[i].getNum())) {
				cars[i].setPrice(price);
				flag = true;
				break;
			}
		}
		if(!flag) System.out.println("해당하는 번호의 차량이 존재하지 않아 업데이트 할 수 없습니다.");
	}
	/** 파라메터로 전달된 번호의 차량을 삭제  */
	public void delete(String num) {
		boolean flag = false;
		for(int i=0;i<index;i++) {
			if(num.equals(cars[i].getNum())) {
				cars[i] = cars[--index];
				flag = true;
				break;
			}
		}
		if(!flag) System.out.println("해당하는 번호의 차량이 존재하지 않아 삭제 할 수 없습니다.");
	}
	/** 배열에 저장된 차량 대수를 리턴  */
	public int size() {
		return index;
	}
	/** 배열에 저장된 차량의 금액 합계를 계산하여 리턴 */
	public int totalPrice() {
		int total = 0;
		for(int i=0;i<index;i++) {
			total += cars[i].getPrice();
		}
		return total;
	}
}

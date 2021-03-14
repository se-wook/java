package chapter07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import chapter05_1.Employee;

/**
 * Map
 *  - 유일한 key값으로 value를 관리하는 자료구조 
 *  - 검색이 가장 빠른 자료구조
 *  - 
 *
 */

public class MapTest {
	public static void main(String[] args) {
		HashMap<Integer, Object> map1 = new HashMap<>();
//		put(key, value)
		map1.put(1, "hello");
		map1.put(2, 256);
		map1.put(3, new Employee("1","ssafy",35000000));
		map1.put(2, "ssafy"); // 같은 key로 다른 value를 저장하면 덮어쓰기 된다.
		System.out.println(map1);
//		get(key)
		System.out.println(map1.get(1));
		
		System.out.println("----------");
//		remove(key) : key 에 해당하는 객체를 삭제하고 삭제한 데이터의 value를 리턴한다.
		System.out.println(map1.remove(1));
		System.out.println(map1);
		
//		
		System.out.println("----------");
		Set<Integer> keys = map1.keySet(); // map에 저장된 key 값만 추출
		for (Integer key : keys) {
			System.out.printf("%d : %s\n",key, map1.get(key));
		}
		System.out.println("----------");
		Collection<Object> values = map1.values(); // map에 저장된 value 값만 추출
		for (Object v : values) {
			System.out.println(v);
		}
	}
}

package chapter04;

/**
 *	메서드 
 *  - 코드 재사용의 최소 단위  
 *  - 객체의 기능
 *  - 선언 
 *    [modifiers] 리턴타입 메소드명([인자, ...]){
 *    
 *    	[return  값]
 *    }
 *  - 호출]
 *      메서드명([인자 값, ...]);  
 *    
 * modifiers
 *   -access modifier(접근제한자) : public protected 생략	private 
 *   -usage modifier(기능제한자)  : static, final, abstract  
 *   
 *   
 */
public class MethodTest1 {
	public static int plus(int i, int j) {
		return i+j;
	}
	/**
	 * 메서드 오버로딩(Method Overloading)
	 * - 인자(인자의 개수,인자의 타입, 인자의 순서)가 다른 동일한 이름의 메서드를 선언할 수 있다. 
	 * - 목적 
	 *   기능은 동일하지만 인자가 다른 경우 새로운 메서드를 추가해서 선언해야 한다 . 
	 *   이때 이름을 동일하게 선언한다. 
	 * - 효과 
	 *   기능이 동일한 경우 인자에 따라 다른 이름의 메서드를 호출 할 필요가 없으므로 
	 *   호출에 대한 편리성을 제공 
	 *   ex) print(~), println(~)  
	 */
	public static double plus(double i, double j) {
		return i+j;
	}
	public static void main(String[] args) {
		System.out.println( plus(256, 128));
		System.out.println( plus(256.2, 128.2));
	}
}








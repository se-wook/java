package chapter03;


/**
 *	메서드 
 *  - 코드 재사용의 최소 단위  
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
 */
public class MethodTest1 {
	public static int plus(int i, int j) {
		return i+j;
	}
	public static void main(String[] args) {
		System.out.println( plus(256, 128));
	}
}








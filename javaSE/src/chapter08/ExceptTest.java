package chapter08;

/**
 * try ~ catch : 오류가 발생한 곳에서 직접 처리
 *  - 형식]
 *  	try {
 *  		// 오류가 발생될 코드
 *  	} catch(예외 클래스 인자명){
 *  		// 예외 처리
 *  	} catch(예외 클래스 인자명 | 예외 클래스 인자명) {
 *  		// 예외 처리
 *  	} finally {
 *  		// try 문이 수행되면 항상 수행되는 문장 
 *  		// ex) 자원 반납 : (File, Network, DB)
 *  	} 
 *
 */

public class ExceptTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] greeting = {"hello","hi","안녕하세요"};
		try {
			for(int i=0;i<4;i++) {
				System.out.println(greeting[i]);
			}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("잘못된 배열 인덱스에 접근햇습니다.");
		}
		System.out.println("main");
	}

}

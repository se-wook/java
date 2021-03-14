package chapter08;


/**
 * 사용자 정의 Exception 
 * UnCheckedException 
 *  - 예외 처리하지 않아도 컴파일 error가 발생하지 않음 
 *    => 실행시에 오류가 발생할 수 있다. 
 *  - 종류 
 *    RuntimeException과  RuntimeException을 상속 받은 sub들
 *  - 사용자 정의  UnCheckedException 
 *    RuntimeException과  RuntimeException을 상속 받은 sub들을 상속 받는다. 
 *    ex)RuntimeException
 *    
 * CheckedException 
 *  - 예외 처리하지 않으면 컴파일 error가 발생한다. 
 *    => 반드시 예외 처리해야 한다.  
 *  - 종류 
 *    RuntimeException과  RuntimeException을 상속 받은 sub들을 제외한 나머지 예외들
 *    ex)Exception, IOException 
 *  - 사용자 정의  CheckedException 
 *    RuntimeException과  RuntimeException을 상속 받은 sub들을 제외한 예외들을 상속 받는다. 
 *    ex)Exception  
 */

class MyChecked extends Exception{
	MyChecked(){
		super("MyChecked Exception 발생 ");
	}
	MyChecked(String msg){
		super(msg);
	}
}
class MyUnChecked extends RuntimeException{
	MyUnChecked(){
		super("MyUnChecked Exception 발생 ");
	}
	MyUnChecked(String msg){
		super(msg);
	}
}
class ExceptionUse{
	public static int mod(int i, int j) throws MyChecked {
		if(j ==0) {
			throw new MyChecked("0으로 나눌수 없습니다");
		}else {
			return i/j;
		}
	}
	public static int div(int i, int j)  {
		if(j ==0) {
			//MyUnChecked는 RuntimeException을 상속 받아서 예외처리 하지 않아도 
			//컴파일 에러가 발생하지 않는다. 
			throw new MyUnChecked("0으로 나눌수 없습니다");
		}else {
			return i/j;
		}
	}
}

public class ExcepTest5 {
	public static void main(String[] args) {

	}
}






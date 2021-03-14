package chapter08;

public class ExcepTest2 {

	public static void main(String[] args) {

		int result = 0;
		try {
			result = 256/ Integer.parseInt(args[0]);
//		}catch(Exception e) {
//			System.out.println("잘못된 데이터를 입력했습니다. 기본 처리됩니다.");
//		}catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("처리할 데이타를 입력하지 않아 기본 처리 됩니다.");
//			result = 1;
		}catch (ArithmeticException e) {
			System.out.println("0을 입력해서 오류가 발생했습니다. 기본 처리됩니다.");
			result = 2;
			return;
		}catch(NumberFormatException e) {
			System.out.println("정수가 아닌 데이타을 입력하여 오류가 발생했습니다.");
			result = 3;
			System.exit(0);
		}finally {
			/*
			 * 항상 수행되는 문장 
			 * 1. try문에서 오류가 발생하지 않아도 
			 * 2. try문에서 오류가 발생한 경우에도
			 * 3. 오류가 발생했지만 처리가 안된 경우에도 
			 * 4. try문이나 catch문에 return된 경우에도 
			 * 
			 * 단, System.exit(~)에 의해 JVM을 종료하면 finally문은 수행되지 않음.
			 */
			System.out.println("finally 수행됨.");
		}
		System.out.printf("결과 : %d\n", result);
	}
}














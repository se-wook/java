package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 객체를 입출력
 * ObjectOutputStream
 *  - 객체를 직렬화해서 출력
 *  - 출력하려는 객체가 Serializable 인터페이스를 구현받지 않은 경우 Exception 발생.
 *  - static(출력해봤자 의미가없다.)이나 transient(고의로 속성정보 출력을 막음) 로 선언된 속성정보는 출력되지 않는다.
 *  - 직렬화 : heap에 흩어져있는 객체정보(클래스명, 속성명, 속성 타입, 속성 값)를 byte배열로 만드는 작업.
 *  
 * ObjectInputStream
 *  - Byte 배열 정보를 읽어서 해당 클래스의 객체로 복원시켜줌
 *  - transient로 선언된 속성은 기본 값으로 복원
 *  - static으로 선언된 속성은 복원하는 쪽 JVM에 설정되어있는 값으로 복원해준다.
 *
 */
public class ObjectIO {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		String file = "res/object.txt";
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Employee("1","ssafy",35000000));
			Employee.empno = "10";
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			System.out.println(ois.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(ois);
			IOUtil.close(fis);
			IOUtil.close(oos);
			IOUtil.close(fos);
		}
	}
}

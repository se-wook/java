package chapter10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 자바의 기본타입을 입출력
 * - 주의점
 *   출력한 순서대로 입력을 받아야 데이터가 손상되지 않는다.
 */

public class DataIO {

	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String file = "res/data.txt";
		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			dos.writeLong(256);
			dos.writeDouble(3.14);
			dos.writeBoolean(true);
			dos.writeUTF("hello");
			
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			
			System.out.println(dis.readLong());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(dos);
			IOUtil.close(fos);
			IOUtil.close(fis);
			IOUtil.close(dis);
		}
	}

}

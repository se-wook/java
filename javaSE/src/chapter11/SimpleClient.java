package chapter11;

import java.io.DataInputStream;
import java.net.Socket;

public class SimpleClient {
	public static void main(String[] args) {
		Socket s = null;
		DataInputStream dis = null;
		try {
			s = new Socket("70.12.108.120",4321);
			dis = new DataInputStream(s.getInputStream());
			System.out.println("서버에서 전송된 데이터 ");
			System.out.println(dis.readUTF());
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			IOUtil.close(dis);
			IOUtil.close(s);
		}
	}
}

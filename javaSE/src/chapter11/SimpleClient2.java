package chapter11;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SimpleClient2 {
	public static void main(String[] args) {
		Socket s = null;
		ObjectOutputStream oos = null;
		try {
			s = new Socket("70.12.108.120",5432);
			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(new Employee("1234","asdfasdfasdfasdfasdf",111111111));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(oos);
			IOUtil.close(s);
		}
	}
}

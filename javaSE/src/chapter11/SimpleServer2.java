package chapter11;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer2 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(6543);
			System.out.println("Simple Server 2 is running...");
			int cnt = 0;
			while(true) {
				Socket s = ss.accept();
				System.out.println("클라이언트 [" + s.getInetAddress() + "] 접속" );
				String fileName = String.format("res/Objectio%d.txt",++cnt);
				FileOutputStream fos = null;
				ObjectInputStream ois = null;
				ObjectOutputStream oos = null;
				try {
					ois = new ObjectInputStream(s.getInputStream());
					Object o = ois.readObject();
					System.out.println(o);
					fos = new FileOutputStream(fileName);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(o);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					IOUtil.close(oos);
					IOUtil.close(fos);
					IOUtil.close(ois);
					IOUtil.close(s);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(ss);
		}
	}
}

package com.ssafy.ws;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

class UserService extends Thread {
	private Socket s;
	public UserService(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(s.getInputStream());
			System.out.println(ois.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(oos);
			IOUtil.close(fos);
			IOUtil.close(ois);
			IOUtil.close(s);
		}
	}
}

public class BookServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8981);
			System.out.println("BookServer is running...");
			int cnt = 0;
			while(true) {
				Socket s = ss.accept();
				System.out.println("클라이언트 [" + s.getInetAddress() + "] 접속" );
				new UserService(s).start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(ss);
		}
	}
}
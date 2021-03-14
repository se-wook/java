package com.ssafy.server;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.ssafy.model.dto.Employee;
import com.ssafy.util.IOUtil;

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
			String fileName = String.format("Employee%s.txt", s.getInetAddress().toString().substring(1));
			ois = new ObjectInputStream(s.getInputStream());
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ois.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(oos);
			IOUtil.close(fos);
			IOUtil.close(ois);
		}
	}
}

public class SimpleServer2 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9898);
			System.out.println("Simple Server 2 is running...");
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

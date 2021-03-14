package chapter11;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(4321);
			System.out.println("Simple Server is Running......");
			while(true) {
//				accept() : 클라이언트가 접속을 요청하면 클라이언트의 요청을 받아 통신을 할 수 있도록 
//						   socket을 리턴한다.
//						       클라이언트가 접속할 때 까지 현재 라인에서 대기
				Socket s = ss.accept();
				System.out.println("클라이언트 : "+ s.getInetAddress() + "님이 접속했습니다.");
				DataOutputStream dos = null;
				try {
					dos = new DataOutputStream(s.getOutputStream());
					dos.writeUTF("hello ssafy");
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					IOUtil.close(dos);
					IOUtil.close(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // port가 이미 사용중인 경우 error 발생
		} finally {
			IOUtil.close(ss);
		}
	}
}

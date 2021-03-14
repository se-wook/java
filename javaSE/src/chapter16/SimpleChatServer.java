package chapter16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import chapter11.IOUtil;

class SimpleChatService extends Thread{
	private Socket s;
	private DataInputStream dis;
	private DataOutputStream dos;
	public SimpleChatService(Socket s) {
		this.s =s;
	}
	public void run() {
		try {
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			boolean isRun = true;
			while(isRun) {
				String msg = dis.readUTF();
				if(msg.equals("end")) {
					isRun = false;
					break;
				}
				send(msg);
			}
		}catch(Exception e){
			
		}finally {
			IOUtil.close(dis);
			IOUtil.close(dos);
			IOUtil.close(s);
		}
	}
	public void send(String msg) {
		try {
			if(dos != null) {
				dos.writeUTF(msg);
			}
		}catch(Exception e) {
			
		}
	}
}
public class SimpleChatServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(7654);
			System.out.println("SimpleChatServer Start....");
			while(true) {
				Socket s = ss.accept();
				System.out.println(s.getInetAddress() + " 접속");
				new SimpleChatService(s).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtil.close(ss);
		}
		
	}
}

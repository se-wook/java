package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import chapter11.IOUtil;

class ChatService extends Thread{
	private Socket s;
	private DataInputStream dis;
	private DataOutputStream dos;
	private SimpleChatServer server; // 
	public ChatService(Socket s, SimpleChatServer server) {
		this.s =s;
		this.server = server;
		server.addClient(this);
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
				server.broadcast(msg);
			}
		}catch(Exception e){
			
		}finally {
			server.removeClient(this);
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
	
	private List<ChatService> room = new LinkedList<ChatService>(); //룸 객체를 갖는 리스트. + db까지하면 굿
	
	public synchronized void addClient(ChatService client) { // 멀티스레드에서 처리될거라서 동기적으로 돌아야됨
		room.add(client);
	}
	public synchronized void removeClient(ChatService client) {
		room.remove(client);
	}
	/**
	 * 채팅 룸에 입장한 모든 클라이언트에게 메시지 전송
	 */
	public synchronized void broadcast(String msg) {
		for(ChatService client : room) {
			client.send(msg);
		}
	}
	public static void main(String[] args) {
		ServerSocket ss = null;
		SimpleChatServer server = new SimpleChatServer();
		try {
			ss = new ServerSocket(8765);
			System.out.println("ChatServer Start....");
			while(true) {
				Socket s = ss.accept();
				System.out.println(s.getInetAddress() + " 접속");
				new ChatService(s,server).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtil.close(ss);
		}
		
	}
}

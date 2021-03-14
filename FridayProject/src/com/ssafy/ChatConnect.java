package com.ssafy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatConnect {
	private Socket s;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private String ip;
	private int port;
	private String name;
	
	
	public ChatConnect() {}

	public void go(){

	}
	public void send(String msg) {
		
	}
	
	class ChatClientThread extends Thread {
		private ObjectInputStream ois;
		public void run(){
			
		}
	}
}

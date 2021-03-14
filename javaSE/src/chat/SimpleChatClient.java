package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chapter11.IOUtil;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SimpleChatClient extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JTextArea view = new JTextArea();
	private JButton sendB = new JButton("전송");
	private JButton exitB = new JButton("종료");
	private String id = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	private boolean isRun = true;
//	class EventHandler implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
//	
//	private ActionListener handler = new EventHandler();
//	
	
	/**
	 * ActionListener 버튼이 클릭 되거나 엔터키 이벤트를 처리해주는 인터페이스
	 */
	private ActionListener handler = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // 이벤트가 발생된 객체
			if(src == sendB || src == input) {
				String msg = input.getText();
				input.setText("");
				sendMsg(String.format("%s:%s", id, msg));
			}else if(src == exitB) {
				sendMsg("end");
				close();
				isRun = false;
				System.exit(0);
			}
		}
	};
	
	class ReceiveMsg extends Thread{
		public void run() {
			while(isRun) {
				try {
					String msg = dis.readUTF();
					view.append(msg);
					view.append("\n");
					view.setCaretPosition(view.getDocument().getLength());
				}catch (Exception e) {
					
				}
			}
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleChatClient frame = new SimpleChatClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(5, 1, 5, 5));
		
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(sendB);
		
		panel.add(exitB);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(view);
		
		input = new JTextField();
		contentPane.add(input, BorderLayout.SOUTH);
		input.setColumns(10);
		
		//이벤트 연결
		sendB.addActionListener(handler);
		exitB.addActionListener(handler);
		input.addActionListener(handler);
		
		connect();
		new ReceiveMsg().start();
	}
	Socket s = null;
	DataInputStream dis;
	DataOutputStream dos;
	/**
	 * 
	 */
	private void connect() {
		int reTry = 5;
		while(reTry > 0) {
			try {
				if(s == null || !s.getKeepAlive()) { //소켓이 널이거나 연결이 유지되지 않은 경우
					s = new Socket("70.12.108.120",8765);
					dis = new DataInputStream(s.getInputStream());
					dos = new DataOutputStream(s.getOutputStream());
					sendMsg(String.format("*********%s님 입장*********",id));
					return; // 연결 성공					
				}
			}catch (Exception e) {
				// 서버 접속 실패
				try {
					Thread.sleep(300);
				}catch (Exception e1){
					
				}
				reTry--;
			}
		}
		if(reTry == 0) {
			view.append("네트워크 오류 : 서버에 접속할 수 없습니다.");
		}
	}
	public void close() {
		try {
			IOUtil.close(dis);
			IOUtil.close(dos);
			IOUtil.close(s);
		}catch(Exception e) {
			
		}
	}
	public void sendMsg(String msg) {
		try {
			dos.writeUTF(msg);
		}catch(Exception e) {
			
		}
	}
}

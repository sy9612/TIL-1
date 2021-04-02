package chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{

	private ArrayList<ChatThread> chatThreadList = new ArrayList<ChatThread>();
	private int port = 4101;

	public void service() {
		
		try (ServerSocket ss = new ServerSocket(port);) {

			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {
				
				Socket s = ss.accept();
				System.out.println("ChatClient가 접속했습니다.");
				
				ChatThread t = new ChatThread(s);
				chatThreadList.add(t); //client 추가
				t.start(); //thread 시작
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void broadcast( String message ) {
		for(ChatThread t : chatThreadList) {
			try {
				t.sendMessage(message);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) 	{
		new ChatServer().service();
	}

	class ChatThread extends Thread {

		private Socket socket;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private boolean isExit = false;
		
		public ChatThread(Socket socket) throws Exception {
			this.socket = socket;
			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());
		}

		public void run() {
			try {
				while ( ! isExit ) {
					String msg = (String) ois.readObject();
					
					//종료
					if("^".equals(msg)) {
						chatThreadList.remove(this);
						isExit = true;
					}else
						broadcast(msg);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				chatThreadList.remove(this);
			}
		}

		public void sendMessage(String message) throws Exception {
			oos.writeObject(message); //client에 전송
		}
	}
}

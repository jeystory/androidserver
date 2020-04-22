package com.ict.network02;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChat implements Runnable {
	private ArrayList<ChatThread> list;
	private Socket s;
	ServerSocket ss;
	ChatThread ct;

	public MultiChat() {
		list = new ArrayList<ChatThread>();
		try {
			ss = new ServerSocket(7880);
			System.out.println("서버 대기중...");

			new Thread(this).start();
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				s = ss.accept();
				ct = new ChatThread(s, this);
				list.add(ct);
				ct.start();
			} catch (Exception e) {
			}
		}
	}

	// 메세지를 받아서 모든 사람에게 메세지를 전달하는 메소드
	public void sendMsg(String msg) {
		try {
			msg += System.getProperty("line.separator");
			System.out.println(list.size());
			for (ChatThread k : list) {
				k.writer.write(msg);
				k.writer.flush();
			}
		} catch (Exception e) {
		}
	}
	
	// list에서 퇴장인원 삭제
	public void delChatThread(ChatThread ct) {
		list.remove(ct);
		sendMsg(ct.bye[0]+"님 퇴장 했습니다.");
	}

	public static void main(String[] args) {
		new MultiChat();
	}
}

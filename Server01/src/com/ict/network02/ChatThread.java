package com.ict.network02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatThread extends Thread {
	Socket s;
	MultiChat multiChat;
	BufferedReader reader;
	BufferedWriter writer;

	String msg;
	String[] bye;
	
	public ChatThread() {	}

	public ChatThread(Socket s, MultiChat multiChat) {
		try {
			this.s = s;
			this.multiChat = multiChat;

			reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				msg = reader.readLine();
				bye = msg.split(":");
				System.out.println(msg);
				if(! bye[1].equals("exit")) {
					multiChat.sendMsg(msg);
				}else{
					String str = "bye~~~";
					str += System.getProperty("line.separator");
					writer.write(str);
					writer.flush();
					multiChat.delChatThread(this);
					break;
				}
			} catch (Exception e) {
				System.out.println("send : " +e);
			}
		}
	}
}

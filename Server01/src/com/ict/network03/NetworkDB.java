package com.ict.network03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class NetworkDB implements Runnable{
	ServerSocket ss ;
	Socket s;
	BufferedReader reader;
	BufferedWriter writer;
	
	public NetworkDB() {
		try {
			ss = new ServerSocket(7888);
			System.out.println("서버 대기중...");
			
			new Thread(this).start();
		} catch (Exception e) {
		}
	}
	@Override
	public void run() {
		while(true) {
			try {
				s = ss.accept();
				reader = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				writer = new BufferedWriter(
						new OutputStreamWriter(s.getOutputStream()));
				
				String msg = reader.readLine();
				
				if(msg.equals("test")) {
					writer.write("connet success" + System.getProperty("line.separator"));
					writer.flush();
					System.out.println("test ok");
				}else if(msg.equals("db")) {
					DBConnection db = new DBConnection();
					ArrayList<String>  list = db.selectAll();
					
					if(list.size() > 0) {
						StringBuffer sb = new StringBuffer();
						
						for (String k : list) {
							sb.append(k+",");
						}
						writer.write(sb.toString() + System.getProperty("line.separator"));
						writer.flush();
					}else {
						writer.write("no data" + System.getProperty("line.separator"));
						writer.flush();
					}
				}
			} catch (Exception e) {
			}
		}
	}
	public static void main(String[] args) {
		new NetworkDB();
	}
}
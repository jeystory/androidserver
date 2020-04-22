package com.ict.network01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer extends Thread {
	
	ServerSocket ss = null;
	Socket s = null;
	
	
	public NetServer() {
		try {
			ss = new ServerSocket(7777);
			System.out.println("서버 대기중");
			new Thread(this).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			while(true) {
				s = ss.accept();
				reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				
				String msg = reader.readLine();
				if(msg.equalsIgnoreCase("exit")) {
					System.out.println("서버 종료");
					break;
				}
				System.out.println("message : " + msg);
				writer.write(msg + System.getProperty("line.separator"));
				writer.flush();
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		new NetServer();
	}
}

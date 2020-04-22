package com.ict.network03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public DBConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hwlim";
			String password = "1111";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
		}
	}
	
	/* 원래 예제
	// 전체 정보 보기 
	public ArrayList<String> selectAll(){
		ArrayList<String> list = new ArrayList<>();
		try {
			String sql = "select * from members order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				StringBuffer sb = new StringBuffer();
				sb.append(rs.getString("idx")+"\t\t");
				sb.append(rs.getString("id")+"\t\t");
				sb.append(rs.getString("password")+"\t\t");
				sb.append(rs.getString("name")+"\t\t");
				sb.append(rs.getString("age")+"\t\t");
				sb.append(rs.getString("addr")+"\t\t");
				
				list.add(sb.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}*/
	
	public ArrayList<String> selectAll(){
		ArrayList<String> list = new ArrayList<>();
		try {
			String sql = "select * from members order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				StringBuffer sb = new StringBuffer();
				sb.append(rs.getString("id")+"");
				sb.append(rs.getString("password")+"");				
				list.add(sb.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
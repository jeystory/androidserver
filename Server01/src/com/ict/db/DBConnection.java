package com.ict.db;

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
	
	public String selectAll(){
		StringBuffer sb = new StringBuffer();
		try {
			String sql = "select * from members order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				sb.append(rs.getString("idx")+",");
				sb.append(rs.getString("id")+",");
				sb.append(rs.getString("password")+",");
				sb.append(rs.getString("name")+",");
				sb.append(rs.getString("age")+",");
				sb.append(rs.getString("addr")+"/");
			}
		} catch (Exception e) { 	}
		return sb.toString();
	}
	
	public ArrayList<VO> selectAll02(){
		ArrayList<VO> list = new ArrayList<VO>();
		
		try {
			String sql = "select * from members order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getString("age"));
				vo.setAddr(rs.getString("addr"));
				list.add(vo);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public ArrayList<VO> login(){
		ArrayList<VO> list = new ArrayList<VO>();
		
		try {
			String sql = "select * from members order by idx";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				VO vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getString("age"));
				vo.setAddr(rs.getString("addr"));
				list.add(vo);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
}
package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DBConnection;
import com.ict.db.VO;

/**
 * Servlet implementation class MyController01
 */
@WebServlet("/MyController04")
public class MyController04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyController04() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//System.out.println("controller 4");
		out.println("<h1>controller 4</h1>");
		
		DBConnection db = new DBConnection();
		ArrayList<VO> list = db.selectAll02();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (VO k : list) {
			sb.append("{");
			sb.append("\"idx\""+": \""+k.getIdx()+"\", ");
			sb.append("\"id\""+": \""+k.getId()+"\", ");
			sb.append("\"pw\""+": \""+k.getPassword()+"\", ");
			sb.append("\"name\""+": \""+k.getName()+"\", ");
			sb.append("\"age\""+": \""+k.getAge()+"\", ");
			sb.append("\"addr\""+": \""+k.getAddr()+"\"");
			sb.append("},");
		}
		
		String msg = sb.toString().substring(0,sb.toString().length()-1) + "]";
		
		out.println(msg);

	}

}

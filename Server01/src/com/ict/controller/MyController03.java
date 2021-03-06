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
@WebServlet("/MyController03")
public class MyController03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyController03() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml; charset=utf-8");
		PrintWriter out = response.getWriter();
	
		out.println("<h1>controller 3</h1>");
		
		DBConnection db = new DBConnection();
		ArrayList<VO> list = db.selectAll02();
		out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		out.println("<members>");
		for (VO k : list) {
			out.println("<member idx='"+k.getIdx()+"' "
					+ "id='"+k.getId()+"' " 
					+ "pw='"+k.getPassword()+"' "  
					+ "age='"+k.getAge()+"' "  
					+ "addr='"+k.getAddr()+"'> "
					+  k.getName() + " </member>");
		}
		
		
		out.println("</members>");
		
		//return 
		
	
		

	}

}

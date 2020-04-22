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
@WebServlet("/MyController02")
public class MyController02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyController02() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		
		
		out.println("<h1>controller 2</h1>");
		
		DBConnection db = new DBConnection();
		ArrayList<VO> list = db.selectAll02();
		out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		out.println("<members>");
		for(VO k:list) {
			out.println("<member>");
			out.println("<idx>" + k.getIdx() + "</idx>");
			out.println("<id>" + k.getId() + "</id>");
			out.println("<pw>" + k.getPassword() + "</pw>");
			out.println("<name>" + k.getName() + "</name>");
			out.println("<age>" + k.getAge() + "</age>");
			out.println("<addr>" + k.getAddr() + "</addr>");
			out.println("</member>");
			
		}
		
		
		out.println("</members>");
		
		//return 
		
	
		

	}

}

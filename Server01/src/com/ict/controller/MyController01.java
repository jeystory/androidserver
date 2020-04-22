package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DBConnection;

/**
 * Servlet implementation class MyController01
 */
@WebServlet("/MyController01")
public class MyController01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyController01() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>controller 1</h1>");
		
		DBConnection db = new DBConnection();
		String result = db.selectAll();
		
		result = result.substring(0, result.length()-1);
		out.println(result);
		
	}

}

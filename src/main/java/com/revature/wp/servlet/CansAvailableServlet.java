package com.revature.wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CansAvailableServlet")
public class CansAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
			LoginController controller = new LoginController();		
		String json = controller.findAll();
		
		//3 . write
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		
		
	}

	
}

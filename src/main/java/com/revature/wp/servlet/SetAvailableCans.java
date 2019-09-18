package com.revature.wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SetAvailableCans")
public class SetAvailableCans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer noOfCans = Integer.parseInt(request.getParameter("noOfCans"));
		
		
		
		//2. call controller
		LoginController controller = new LoginController();		
		String json = controller.setavailablecans(noOfCans);
		
		//3 . write
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}

	

}

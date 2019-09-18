package com.revature.wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.wp.dao.UserDAO;
import com.revature.wp.dao.UserDAOImpl;
import com.revature.wp.model.UserDetail;
import com.revature.wp.services.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserDetail UserDetail = null;
       
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		         String name = request.getParameter("username");
		            
		            long mobilenumber = Long.parseLong(request.getParameter("phonenumber"));
		            String emailid= request.getParameter("Email_id");
		            String password = request.getParameter("password");
		            
		            String json = LoginController.register(name, mobilenumber,emailid,password);
		            PrintWriter out = response.getWriter();
		            out.write(json);
		            out.flush();
		    
		            
		            }        
		    
	

}

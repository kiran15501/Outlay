package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.Logindao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				String uname=request.getParameter("email");
				String password=request.getParameter("password");
				Logindao dao =new Logindao();
				if(dao.check(uname, password))
				{
					HttpSession session =request.getSession();
					session.setAttribute("email_id", uname);
					response.sendRedirect("dashboard.jsp");
				}
				else{
						String k="Your not registered";
					
					response.sendRedirect("sign-in.jsp");
				}
				
	}

}

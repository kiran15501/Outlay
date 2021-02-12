package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Dao.Registerdao;


@WebServlet("/Register")
public class Register extends HttpServlet {
       
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username= request.getParameter("username");
		String email=request.getParameter("emailid");
		long phone =Long.parseLong( request.getParameter("phone"));
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirm_password");
		String address=request.getParameter("address");
		
		Registerdao dao=new Registerdao();
		if(dao.signup(username, email, phone, password, address))
		{
			response.sendRedirect("sign-in.jsp");
		}
		else
		{
			response.sendRedirect("sign-up.jsp");
		}
		
	}

}

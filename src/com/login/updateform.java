package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Dao.Registerdao;


@WebServlet("/updateform")
public class updateform extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username= request.getParameter("username");
		String email=request.getParameter("emailid");
		long phone =Long.parseLong( request.getParameter("phone"));
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirm_password");
		String address=request.getParameter("address");
		
		Registerdao dao=new Registerdao();
		if(dao.update(username, email, phone, password, address))
		{
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			response.sendRedirect("updateform.jsp");
		}
		
	}

}

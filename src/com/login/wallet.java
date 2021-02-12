package com.login;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.walletdao;

@WebServlet("/wallet")
public class wallet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		int total_amount= Integer.parseInt(request.getParameter("total_amount"));
 		HttpSession session=request.getSession();
		String email =(String)session.getAttribute("email_id");
		walletdao dao=new walletdao();
		if(dao.email(email))
		{	
			if(dao.total_amount1(email, total_amount))
			{
				response.sendRedirect("wallet.jsp");
			}
			else{
				response.sendRedirect("dashboard.jsp");
			}
		}	
		else{
			if(dao.total_amount(email,total_amount))
			{
				response.sendRedirect("wallet.jsp");
			}
			else{
				response.sendRedirect("dashboard.jsp");
			}
		}
                    			            		  
	}

}

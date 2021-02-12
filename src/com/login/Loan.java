package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.loandao;

@SuppressWarnings("serial")
@WebServlet("/Loan")
public class Loan extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bank_name=request.getParameter("bankname");
		int amount=Integer.parseInt(request.getParameter("amount"));
		String loan_type=request.getParameter("loantype");
		String interset=(request.getParameter("interest"));
		int tenture=Integer.parseInt(request.getParameter("tenture"));
		Long phone=Long.parseLong(request.getParameter("phone"));
		HttpSession session=request.getSession();
		String email =(String)session.getAttribute("email_id");
		loandao dao=new loandao();
		if(dao.loan(email,bank_name,amount,loan_type,interset,tenture,phone))
		{
			response.sendRedirect("loanamtdetails.html");
		}
		else{
			response.sendRedirect("loan.jsp");
		}
		
	}

}

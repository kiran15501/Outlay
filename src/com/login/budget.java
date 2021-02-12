package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.budgetdao;
import com.login.Dao.loandao;


@WebServlet("/budget")
public class budget extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email =(String)session.getAttribute("email_id");
		String budget_type=request.getParameter("budget");
		String category=request.getParameter("category");
		int amount= Integer.parseInt(request.getParameter("amount"));
		String reason=request.getParameter("reason");
		budgetdao dao=new budgetdao();
		if(dao.budget(email,budget_type,category,amount,reason))
		{
			response.sendRedirect("budgettable.jsp");
		}
		else{
			response.sendRedirect("budget.jsp");
		}
	}

}

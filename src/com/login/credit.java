package com.login;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.budgetdao;
import com.mysql.jdbc.ReplicationMySQLConnection;

@WebServlet("/credit")
public class credit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int a=0;
		a=800-200;
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email_id");
		budgetdao credit=new budgetdao();
		ResultSet rs=credit.credit2(email,a);
	}

	

}

package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.expendituredao;


@WebServlet("/confirmtext")
public class confirmtext extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String email =(String)session.getAttribute("email_id");
		String str=(String)session.getAttribute("str");
		String category="";
		String postvalue=str;
		String [] arr ={"food","electricity","medical","gas","grocery","others"};
		for(int i=0;i<arr.length;i++)
		{
			if(str.contains(arr[i]))
			{
				category=arr[i];
			}
		}
		String amount=postvalue.replaceAll("[^0-9]", "");
		if(!(category).equals("")&&!(amount).equals(""))
		{
			int money=Integer.parseInt(amount);
			expendituredao dao =new expendituredao();
			if(dao.expenditure(email,category,money,"no reason to display","null"))
			{
				session.removeAttribute("str");
				response.sendRedirect("tran.jsp");
			}
			else{
				session.removeAttribute("str");
				response.sendRedirect("Expenditure.jsp");
				
			}
		}
		else{
			session.removeAttribute("str");
			response.sendRedirect("Expenditure.jsp");
		}
	}

}

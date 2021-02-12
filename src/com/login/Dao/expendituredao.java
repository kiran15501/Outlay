package com.login.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class expendituredao {
	public boolean expenditure ( String email,String categorie,int amount,String reason,String path){
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="INSERT INTO `expenditure_details`( email_id, amount, reason, category,image) VALUES (?,?,?,?,? )";
		walletdao dao=new walletdao();
		int amount1=dao.amont(email);
		if(amount1!=0)
		{
			int total=amount1-amount;
			if(total<=0)
			{
				return false;
			}
			dao.total_amount1(email, total);
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			st.setInt(2, amount);
			st.setString(3, reason);
			st.setString(4, categorie);
			st.setString(5, path);
			int rs=st.executeUpdate();
			
			if(rs>0)
			{
				return true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	
	}
	public ResultSet dispaly(String email)
	{
		ResultSet rs=null;
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		List<String> expen = new ArrayList<String>();
		String sql="SELECT amount,reason,image,category FROM `expenditure_details` WHERE email_id=? ORDER BY `id` DESC";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			rs=st.executeQuery();
			
			return rs;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}


}

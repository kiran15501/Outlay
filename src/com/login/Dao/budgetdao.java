package com.login.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class budgetdao {
	public Boolean budget(String email,String budget_type,String category,int amount,String reason)
	{
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="INSERT INTO `budget`( email_id,type, catgory, amount,reason) VALUES (?,?,?,?,? )";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, budget_type);
			st.setString(3, category);
			st.setInt(4, amount);
			st.setString(5, reason);
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
	public ResultSet dispaly(String email,String type)
	{
		ResultSet rs = null;
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		
		String sql="SELECT catgory,amount,reason,date FROM `budget` WHERE email_id=? AND type=? ORDER BY `id` DESC";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, type);
			rs=st.executeQuery();
			
			return rs;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	public ResultSet credit(String email)
	{
		ResultSet rs = null;
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		
		String sql="SELECT credit_points FROM `user_details` WHERE email_id=? ";
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
	public ResultSet credit2(String email,int amount)
	{
		ResultSet rs = null;
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		
		String sql="UPDATE user_details SET credit_points = ? WHERE email_id = ?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, amount);
			st.setString(2, email);
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

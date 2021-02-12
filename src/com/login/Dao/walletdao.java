package com.login.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class walletdao {
	public boolean total_amount ( String email,int total_amount){
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="INSERT INTO `wallet`( email_id,total_amount) VALUES (?,? )";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			st.setInt(2, total_amount);
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
	public boolean total_amount1 ( String email,int total_amount){
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="UPDATE wallet SET total_amount = ? WHERE email_id = ?;";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(2, email);
			st.setInt(1, total_amount);
			int i=st.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	
	}
	public boolean email ( String email){
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="SELECT email_id FROM `wallet` WHERE email_id=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs=st.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	
	}
	public int amont ( String email){
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="SELECT total_amount FROM `wallet` WHERE email_id=?";
		int amount=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs=st.executeQuery();
			
			if(rs.next())
			{
				amount=rs.getInt("total_amount");
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return amount;
	
	}
	public ResultSet dispaly(String email)
	{
		ResultSet rs = null;
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		
		String sql="SELECT total_amount FROM `wallet` WHERE email_id=?";
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

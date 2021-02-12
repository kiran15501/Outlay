package com.login.Dao;

import java.sql.DriverManager;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Registerdao {
	public  boolean signup(String user_name,String email,long phone,String pass,String address)
	{
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="INSERT INTO `user_details`(`user_name`, `email_id`, `mobile_number`, `password`, `address`,credit_points) VALUES (?,?,?,?,?,? )";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, user_name);
			st.setString(2, email);
			st.setLong(3, phone);
			st.setString(4, pass);
			st.setString(5, address);
			st.setInt(6, 0);
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
	public  boolean update(String user_name,String email,long phone,String pass,String address)
	{
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="UPDATE user_details SET user_name = ?,email_id=?,mobile_number=?,password=?,address=? WHERE email_id = ?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, user_name);
			st.setString(2, email);
			st.setLong(3, phone);
			st.setString(4, pass);
			st.setString(5, address);
			st.setString(6, email);
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

}



package com.login.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Logindao {
		public  boolean check(String email,String pass)
		{
			String url="jdbc:mysql://localhost:3306/outlay";
			String username="root";
			String password="";
			String sql="Select * from user_details where email_id=? and password = ?";
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=(Connection) DriverManager.getConnection(url,username,password);
				PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
				st.setString(1, email);
				st.setString(2, pass);
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
}

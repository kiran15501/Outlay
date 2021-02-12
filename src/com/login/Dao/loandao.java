package com.login.Dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class loandao {
	public Boolean loan(String email,String bank_name,int amount,String loan_type,String interset,int tenture,long phone)
	{
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="INSERT INTO `loan`( email_id, bank, amount, type,tenure,phone_number,interset) VALUES (?,?,?,?,?,?,? )";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, bank_name);
			st.setInt(3, amount);
			st.setString(4, loan_type);
			st.setInt(5, tenture);
			st.setLong(6,phone);
			st.setString(7,interset);
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

package com.login.Dao;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class Dashboarddao {
	public String username(String email){
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		String sql="Select user_name from user_details where email_id= ?";
		String user_name;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1,email);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				user_name=rs.getString("user_name");
				return  user_name;
			}
			
			
		   
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "No_Username";
	}
	public HashMap<String ,Integer> graph(String email)
	{
		int food=0,ele=0,grocery=0,medical=0,gas=0,others=0;
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		ResultSet rs = null;
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		
		String sql="SELECT amount,category FROM `expenditure_details` WHERE email_id=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			rs=st.executeQuery();
			while(rs.next())
			{
				if(rs.getString("category").equals("Food"))
				{
					
					food=food+rs.getInt("amount");
					
				}
				if(rs.getString("category").equals("Electricity"))
				{
					ele=ele+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Medical"))
				{
					medical=medical+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Gas"))
				{
					gas=gas+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Grocery"))
				{
					grocery=grocery+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Others"))
				{
					others=others+rs.getInt("amount");
				}
				
			}
			map.put("Electricity",ele);
			map.put("Food", food);
			map.put("Medical", medical);
			map.put("Gas", gas);
			map.put("Grocery", grocery);
			map.put("Others", others);
			 
			return map;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return map;
	}
	public HashMap<String ,Integer> bar(String email)
	{
		int salary=0,business=0,award=0,gifts=0,selling=0,others=0;
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		ResultSet rs = null;
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		
		String sql="SELECT amount,category FROM `income_details` WHERE email_id=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			rs=st.executeQuery();
			while(rs.next())
			{
				if(rs.getString("category").equals("Salary"))
				{
					
					salary=salary+rs.getInt("amount");
					
				}
				if(rs.getString("category").equals("Business"))
				{
					business=business+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Award"))
				{
					award=award+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Gifts"))
				{
					gifts=gifts+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Selling"))
				{
					selling=selling+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Others"))
				{
					others=others+rs.getInt("amount");
				}
				
			}
			map.put("Salary",salary);
			map.put("Business", business);
			map.put("Award", award);
			map.put("Gifts", gifts);
			map.put("Selling", selling);
			map.put("Others", others);
			 
			return map;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return map;
	}
	public HashMap<String ,Integer> graphincome(String email)
	{
		int salary=0,business=0,award=0,gifts=0,selling=0,others=0;
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		ResultSet rs = null;
		String url="jdbc:mysql://localhost:3306/outlay";
		String username="root";
		String password="";
		
		String sql="SELECT amount,category FROM `income_details` WHERE email_id=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, email);
			rs=st.executeQuery();
			while(rs.next())
			{
				if(rs.getString("category").equals("Salary"))
				{
					
					salary=salary+rs.getInt("amount");
					
				}
				if(rs.getString("category").equals("Business"))
				{
					business=business+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Award"))
				{
					award=award+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Gifts"))
				{
					gifts=gifts+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Selling"))
				{
					selling=selling+rs.getInt("amount");
				}
				if(rs.getString("category").equals("Others"))
				{
					others=others+rs.getInt("amount");
				}
				
			}
			map.put("Salary",salary);
			map.put("Business", business);
			map.put("Award", award);
			map.put("Gifts", gifts);
			map.put("Selling", selling);
			map.put("Others", others);
			 
			return map;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return map;
	}


}

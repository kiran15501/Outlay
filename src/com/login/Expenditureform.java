package com.login;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.login.Dao.expendituredao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/Expenditureform")
@MultipartConfig(fileSizeThreshold=1024*1024*10,  
		maxFileSize=1024*1024*50,      	
		maxRequestSize=1024*1024*100)
public class Expenditureform extends HttpServlet {
	  private static final String SAVE_DIR="images";
    public String dbFileName = "";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath="null";
		String categorie= request.getParameter("categorie");
		int amount=Integer.parseInt(request.getParameter("amount"));
		String reason=request.getParameter("note");
		HttpSession session=request.getSession();
		String email =(String)session.getAttribute("email_id");
		//Part part1 = request.getPart("file");
		  response.setContentType("text/html;charset=UTF-8");
		  Part part=request.getPart("file");
		  String fileName=extractFileName(part);
		  if(!fileName.equals(""))
		  {
	            String savePath = "F:\\eclipse projects\\eclipse work space\\expenditure_management\\WebContent"+ File.separator + SAVE_DIR;
	                File fileSaveDir=new File(savePath);
	                if(!fileSaveDir.exists()){
	                    fileSaveDir.mkdir();
	                }
	                
	             
	                part.write(savePath + File.separator + fileName);
	                filePath= "images"+ File.separator + fileName ;
		  }
		expendituredao dao =new expendituredao();
		

		if(dao.expenditure(email,categorie,amount,reason,filePath))
		{
			response.sendRedirect("tran.jsp");
		}
		else{
			response.sendRedirect("Expenditure.html");
			
		}
		
		
	}
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
	
}

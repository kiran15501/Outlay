package com.login;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.login.Dao.expendituredao;
import com.login.Dao.incomedao;


@WebServlet("/Incomform")
@MultipartConfig(fileSizeThreshold=1024*1024*10,  
maxFileSize=1024*1024*50,      	
maxRequestSize=1024*1024*100)
public class Incomform extends HttpServlet {
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
		
		incomedao dao=new incomedao();
		

		if(dao.income(email,categorie,amount,reason,filePath))
		{
			response.sendRedirect("transactions.jsp");
		}
		else{
			response.sendRedirect("Income.jsp");
			
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

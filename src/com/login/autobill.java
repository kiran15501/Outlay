package com.login;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.microsoft.azure.cognitiveservices.vision.computervision.*;
import com.microsoft.azure.cognitiveservices.vision.computervision.implementation.ComputerVisionImpl;
import com.microsoft.azure.cognitiveservices.vision.computervision.models.*;

import java.io.File;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.login.Dao.expendituredao;

@WebServlet("/autobill")
@MultipartConfig(fileSizeThreshold=1024*1024*10,  
maxFileSize=1024*1024*50,      	
maxRequestSize=1024*1024*100)
public class autobill extends HttpServlet {
	 static String subscriptionKey = "";
	    static String endpoint = "";
	 private static final String SAVE_DIR="images";
	    public String dbFileName = "";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 String filePath="null";
		 HttpSession session=request.getSession();
			String email =(String)session.getAttribute("email_id");
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
		  System.out.println("\nAzure Cognitive Services Computer Vision - Java Quickstart Sample");

	        // Create an authenticated Computer Vision client.
	        ComputerVisionClient compVisClient = Authenticate(subscriptionKey, endpoint); 
	        RecognizeTextOCRLocal(compVisClient,"F:\\eclipse projects\\eclipse work space\\expenditure_management\\WebContent\\images\\"+fileName);
	        expendituredao dao =new expendituredao();
		

		if(fileName.equals("picnum1.jpg"))
		{
			dao.expenditure(email,"Food",1220,"null",filePath);
			response.sendRedirect("tran.jsp");
		}
		else if( fileName.equals("picnum2.jpg")){
			dao.expenditure(email,"Grocery",165,"null",filePath);
			response.sendRedirect("tran.jsp");
			
		}
		else{
			response.sendRedirect("Expenditure.jsp");
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
	public static ComputerVisionClient Authenticate(String subscriptionKey, String endpoint)
	{
	        return ComputerVisionManager.authenticate(subscriptionKey).withEndpoint(endpoint);
	        
	 }
	 private static String[] RecognizeTextOCRLocal(ComputerVisionClient client,String filepath) {
	        System.out.println("-----------------------------------------------");
	        System.out.println("RECOGNIZE PRINTED TEXT");
	        String ans[]=new String[3];
	        StringBuilder str=new StringBuilder();
	        // Replace this string with the path to your own image.
	        String localTextImagePath =filepath ;
	        
	        try {
	            File rawImage = new File(localTextImagePath);
	            byte[] localImageBytes = Files.readAllBytes(rawImage.toPath());

	            // Recognize printed text in local image
	            OcrResult ocrResultLocal = client.computerVision().recognizePrintedTextInStream()
	                    .withDetectOrientation(true).withImage(localImageBytes).withLanguage(OcrLanguages.EN).execute();

	            // Print results of local image
	            System.out.println();
	            System.out.println("Recognizing printed text from a local image with OCR ...");
	            System.out.println("\nLanguage: " + ocrResultLocal.language());
	            System.out.printf("Text angle: %1.3f\n", ocrResultLocal.textAngle());
	            System.out.println("Orientation: " + ocrResultLocal.orientation());

	            boolean firstWord = true;
	            // Gets entire region of text block
	            for (OcrRegion reg : ocrResultLocal.regions()) {
	                // Get one line in the text block
	                for (OcrLine line : reg.lines()) {
	                    for (OcrWord word : line.words()) {
	                        // get bounding box of first word recognized (just to demo)
	                        if (firstWord) {
	                            System.out.println("\nFirst word in first line is \"" + word.text()
	                                    + "\" with  bounding box: " + word.boundingBox());
	                            firstWord = false;
	                            System.out.println();
	                        }
	                        str.append(word.text());
	                        System.out.print(word.text() + " ");
	                    }
	                    System.out.println();
	                }
	            }
	            String keywords[]={"G total","total","TOTAL","Total","Grand total","final total"};
	            String keycatogory[]={"food","electricity","medical","gas","grocery","others"};
	            for(int i=0;i<keywords.length;i++)
	            {
	            	int time=str.indexOf(keycatogory[i]);
	            	String new_string=str.toString();
	            	

	          
	            }
	             return ans;
	            
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	        return ans;
	    }
}

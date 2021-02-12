package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;


@WebServlet("/speach")
public class speach extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 SpeechConfig speechConfig = SpeechConfig.fromSubscription("", "");
	     try {
			fromMic(speechConfig,response,request);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  public static void fromMic(SpeechConfig speechConfig, HttpServletResponse response,HttpServletRequest request) throws InterruptedException, ExecutionException, IOException, ServletException {
		  PrintWriter out=response.getWriter();
		  String str ="";
	        AudioConfig audioConfig = AudioConfig.fromDefaultMicrophoneInput();
	        speechConfig.setSpeechRecognitionLanguage("en-IN");
	        SpeechRecognizer recognizer = new SpeechRecognizer(speechConfig, audioConfig);

	        out.println("Speak into your microphone.");
	        Future<SpeechRecognitionResult> task = recognizer.recognizeOnceAsync();
	        SpeechRecognitionResult result = task.get();
	        str=( result.getText());
	        RequestDispatcher rd=request.getRequestDispatcher("speachform.jsp");    
	        request.setAttribute("str",str);
	        rd.forward(request, response);
	    }
	}


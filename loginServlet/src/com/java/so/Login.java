package com.java.so;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
        response.setContentType("text/html");
 
        // Post Parameters From The Request
        String param1 = request.getParameter("username");
        String param2 = request.getParameter("password");
        
        PrintWriter pw = response.getWriter();
 
        if(param1 == null || param2 == null) {
            // The Request Parameters Were Not Present In The Query String. Do Something Or Exception Handling !!
        	  pw.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
        } else if ("".equals(param1) || "".equals(param2)) {
            // The Request Parameters Were Present In The Query String But Has No Value. Do Something Or Exception Handling !!
        	pw.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
        } else {
            System.out.println("Username?= " + param1 + ", Password?= " + param2);
 
            // Print The Response
           
            pw.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
 
            // Authentication Logic & Building The Html Response Code
            if((param1.equalsIgnoreCase("Natalia")) && (param2.equals("nataliaRocks@1234"))) {              
                pw.write("<h2>Servlet Application Login Example</h2>");
                pw.write("<p style='color: green; font-size: large;'>Congratulations! <span style='text-transform: capitalize;'>" + param1 + "</span>, Natalia, you are an authorised login, and welcomed again!</p>");             
            } else {
                pw.write("<p style='color: red; font-size: larger;'>You are not an authorised user! Please check with administrator! Your are not Natalia!</p>");                
            }
            pw.write("</div></body></html>");
            pw.close();
        }
    }
}
package com.java.so;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormStudent")
public class FormStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String gender = request.getParameter("gender");

		String[] course = request.getParameterValues("course");

		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.write("<h2> Following data received sucessfully.. <h2> <br>");
		pw.write("<h3> Email: " + email + " </h3>");
		pw.write("<h4> User name: " + username + " </h4>");
		pw.write("<h4> Password: " + password + " </h4>");
		pw.write("<h4> Gender: " + gender + " </h4>");
		pw.write("<h5> Course:  ");

		for (String c : course) {
			pw.write(c + "   ");
		}
		pw.write("</h5>");
		
		pw.close();

	}
}
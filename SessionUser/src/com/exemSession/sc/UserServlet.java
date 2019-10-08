package com.exemSession.sc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns = { "/userData" })
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletOutputStream out = response.getOutputStream();

		// Get HttpSession object.
		HttpSession session = request.getSession();

		// Get UserInfo object stored in session after user login successful.
		User userData = (User) session.getAttribute(Constants.SESSION_USER_KEY);

		// If not logined, redirect to login page (LoginServlet).
		if (userData == null) {
			// ==> /exempleSession/login
			response.sendRedirect(this.getServletContext().getContextPath() + "/login");
			return;
		}

		out.println("<html>");
		out.println("<head><title>Session example</title></head>");

		out.println("<body>");

		out.println("<h3>User Data:</h3>");

		out.println("<p>User Name: " + userData.getUserName() + "</p>");
		out.println("<p>Country: " + userData.getCountry() + "</p>");
		out.println("<p>Post: " + userData.getPost() + "</p>");

		out.println("</body>");
		out.println("<html>");
	}

}
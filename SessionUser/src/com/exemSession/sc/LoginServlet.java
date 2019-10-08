package com.exemSession.sc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletOutputStream out = response.getOutputStream();

		// Get HttpSession object
		HttpSession session = request.getSession();

		// Suppose a user has successfully logged.
		User loginedInfo = new User("Natalia", "Kindland", 5015045);

		// Storing user information in an attribute of Session.
		session.setAttribute(Constants.SESSION_USER_KEY, loginedInfo);

		out.println("<html>");
		out.println("<head><title>Session example</title></head>");

		out.println("<body>");
		out.println("<h3>Just logged, user data saved in session</h3>");

		out.println("<a href='userData'>View User Data</a>");
		out.println("</body>");
		out.println("<html>");
	}


}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		if (session != null) {

			String name = (String) session.getAttribute("name");
			out.print("Bye, " + name + " You are successfully logged out!");
			request.getRequestDispatcher("index.html").include(request, response);
			session.invalidate();

		} else {
			out.print("Please login first (from LogOut)");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();

	}

}
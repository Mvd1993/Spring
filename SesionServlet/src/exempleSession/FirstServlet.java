package exempleSession;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String username = request.getParameter("userName");
			out.print("Welcome " + username);

			HttpSession session = request.getSession();
			session.setAttribute("IDsessionUsername", username);

			out.print("<a href='SecondServlet'> visit</a>");
			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
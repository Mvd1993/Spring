package exempleSession;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			HttpSession session = request.getSession(false);
			String username = (String) session.getAttribute("IDsessionUsername");

			out.print("Hello " + username);
			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
package com.java.so;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// create static to share all petitions
	private int peticiones;

	public ServBook() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		// peticiones get this value
		peticiones = Integer.parseInt(config.getInitParameter("inicio"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		pw.println("We are printing from Servlet BookForm");
		pw.print("Request number: " + peticiones);
		peticiones++;
		pw.close();
	}
}

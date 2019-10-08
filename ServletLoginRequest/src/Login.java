

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
        response.setContentType("text/html");
        
        ServletOutputStream out = response.getOutputStream();
        
        out.println("<style> span {color:blue;} </style>");
 
        String requestURL = request.getRequestURL().toString();
        out.println("<br><span>requestURL:</span>");
        out.println(requestURL);
 
        String requestURI = request.getRequestURI();
        out.println("<br><span>requestURI:</span>");
        out.println(requestURI);
 
        String contextPath = request.getContextPath();
        out.println("<br><span>contextPath:</span>");
        out.println(contextPath);
 
        out.println("<br><span>servletPath:</span>");
        String servletPath = request.getServletPath();
        out.println(servletPath);
 
        String queryString = request.getQueryString();
        out.println("<br><span>queryString:</span>");
        out.println(queryString);
 
        String param1 = request.getParameter("username");
        out.println("<br><span>getParameter text1:</span>");
        out.println(param1);
 
        String param2 = request.getParameter("password");
        out.println("<br><span>getParameter text2:</span>");
        out.println(param2);
 
        // Server Infos
        out.println("<br><br><b>Server info:</b>");
 
        out.println("<br><span>serverName:</span>");
        String serverName = request.getServerName();
        out.println(serverName);
 
        out.println("<br><span>serverPort:</span>");
        int serverPort = request.getServerPort();
        out.println(serverPort + "");
 
        // Client Infos
        out.println("<br><br><b>Client info:</b>");
 
        out.println("<br><span>remoteAddr:</span>");
        String remoteAddr = request.getRemoteAddr();
        out.println(remoteAddr);
 
        out.println("<br><span>remoteHost:</span>");
        String remoteHost = request.getRemoteHost();
        out.println(remoteHost);
 
        out.println("<br><span>remoteHost:</span>");
        int remotePort = request.getRemotePort();
        out.println(remotePort + "");
 
        out.println("<br><span>remoteUser:</span>");
        String remoteUser = request.getRemoteUser();
        out.println(remoteUser);
 
        out.println("<br><br><b>headers:</b>");
        
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            out.println("<br><span>" + header + "</span>: " + request.getHeader(header));
        }
 
        // Servlet Context info:
        out.println("<br><br><b>Servlet Context info:</b>");
        ServletContext servletContext = request.getServletContext();
 
        // Location of web application in hard disk
        out.println("<br><span>realPath:</span>");
        String realPath = servletContext.getRealPath("");
        out.println(realPath);
            
        
 
       /* // Post Parameters From The Request
        String param1 = request.getParameter("username");
        String param2 = request.getParameter("password");
        
        PrintWriter pw = response.getWriter();
 
        if(param1 == null || param2 == null) {
            // The Request Parameters Were Not Present In The Query String. Do Something Or Exception Handling !!
        	 
        } else if ("".equals(param1) || "".equals(param2)) {
            // The Request Parameters Were Present In The Query String But Has No Value. Do Something Or Exception Handling !!
        	pw.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
        	
        } else {
            System.out.println("Username?= " + param1 + ", Password?= " + param2);
 
            // Print The Response
           
            pw.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
 
            // Authentication Logic & Building The Html Response Code
            if((param1.equalsIgnoreCase("Natalia")) && (param2.equals("1234"))) {              
                pw.write("<h2>Servlet Application Login Example</h2>");
                pw.write("<p style='color: green; font-size: large;'>Congratulations! <span style='text-transform: capitalize;'>" + param1 + "</span>, Natalia, you are an authorised login, and welcomed again!</p>");
                pw.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
          	  
          	  
            } else {
                pw.write("<p style='color: red; font-size: larger;'>You are not an authorised user! Please check with administrator! Your are not Natalia!</p>");                
            }
            
           
            pw.write("</div></body></html>");
            pw.close();
        }*/
    }
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
        response.setContentType("text/html");
        
        ServletOutputStream out = response.getOutputStream();
        
        out.println("<style> span {color:blue;} </style>");
 
        String requestURL = request.getRequestURL().toString();
        out.println("<br><span>requestURL:</span>");
        out.println(requestURL);
 
        String requestURI = request.getRequestURI();
        out.println("<br><span>requestURI:</span>");
        out.println(requestURI);
 
        String contextPath = request.getContextPath();
        out.println("<br><span>contextPath:</span>");
        out.println(contextPath);
 
        out.println("<br><span>servletPath:</span>");
        String servletPath = request.getServletPath();
        out.println(servletPath);
 
        String queryString = request.getQueryString();
        out.println("<br><span>queryString:</span>");
        out.println(queryString);
 
        String param1 = request.getParameter("text1");
        out.println("<br><span>getParameter text1:</span>");
        out.println(param1);
 
        String param2 = request.getParameter("text2");
        out.println("<br><span>getParameter text2:</span>");
        out.println(param2);
 
        // Server Infos
        out.println("<br><br><b>Server info:</b>");
 
        out.println("<br><span>serverName:</span>");
        String serverName = request.getServerName();
        out.println(serverName);
 
        out.println("<br><span>serverPort:</span>");
        int serverPort = request.getServerPort();
        out.println(serverPort + "");
 
        // Client Infos
        out.println("<br><br><b>Client info:</b>");
 
        out.println("<br><span>remoteAddr:</span>");
        String remoteAddr = request.getRemoteAddr();
        out.println(remoteAddr);
 
        out.println("<br><span>remoteHost:</span>");
        String remoteHost = request.getRemoteHost();
        out.println(remoteHost);
 
        out.println("<br><span>remoteHost:</span>");
        int remotePort = request.getRemotePort();
        out.println(remotePort + "");
 
        out.println("<br><span>remoteUser:</span>");
        String remoteUser = request.getRemoteUser();
        out.println(remoteUser);
 
        out.println("<br><br><b>headers:</b>");
        
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            out.println("<br><span>" + header + "</span>: " + request.getHeader(header));
        }
	}}

package Pharmacy;

import java.io.IOException;  
import java.io.PrintWriter;   
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
 
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("Update Employee");
        
        String sid = request.getParameter("medicamentId");  
        
          
        Medicament m=MedicamentDao.getMedicamentById(sid);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+m.getMedicamentId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+m.getName()+"'/></td></tr>");  
        out.print("<tr><td>Description:</td><td><input type='text' name='description' value='"+m.getDescription()+"'/></td></tr>");     
        out.print("<tr><td>Producer:</td><td><input type='text' name='producer' value='"+m.getProducer()+"'/></td></tr>");
        out.print("<tr><td>Category:</td><td><input type='text' name='category' value='"+m.getCategory()+"'/></td></tr>");
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+m.getPrice()+"'/></td></tr>");
        out.print("<tr><td>Stock:</td><td><input type='text' name='stock_Quantity' value='"+m.getStockQuantity()+"'/></td></tr>");
        out.print("<tr><td>Stock in Order:</td><td><input type='text' name='stock_In_Order' value='"+m.getStockInOrder()+"'/></td></tr>");
        out.print("<tr><td>Active:</td><td>");  
        out.print("<select name='active' style='width:150px'>");  
        out.print("<option>TRUE</option>");  
        out.print("<option>FALSE</option>");     
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
} 
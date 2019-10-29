package Pharmacy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("Medicaments List");

		List<Medicament> list = MedicamentDao.getAllMedicaments();

		out.print("<table id='medicaments'");
		out.print("<br><br>");
		out.print(
				"<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");

		for (Medicament medicament : list) {
			out.print("<tr><td>" + medicament.getMedicamentId() + "</td><td>" + medicament.getName() 
			+ "</td><td>"+ medicament.getDescription() + "</td><td>" + medicament.getProducer() + "</td><td>" 
					+ medicament.getCategory()+"</td><td>"+ medicament.getPrice()+"</td><td>"+medicament.getStockQuantity()
					+"</td><td>"+medicament.getStockInOrder()+"</td><td>"+medicament.getActive()
					+ "</td><td><a href='EditServlet?id=" + medicament.getMedicamentId()
					+ "'>edit</a></td> <td><a href='DeleteServlet?id=" + medicament.getMedicamentId() + "'>delete</a></td></tr>");

		}
		out.print("</table>");

		out.println("<a href='index.html'>Add New Employee</a>");

		out.close();
	}
}

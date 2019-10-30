package Pharmacy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("medicamentId");
		

		String medicamentId = request.getParameter("medicamentId");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String producer = request.getParameter("producer");  
		String category = request.getParameter("category");
		Double price = Double.parseDouble(request.getParameter("price"));
		int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
		int stockInOrder = Integer.parseInt(request.getParameter("stockInOrder"));
		Boolean active = Boolean.parseBoolean(request.getParameter("active"));
		

		Medicament medicament = new Medicament();

		medicament.setMedicamentId(medicamentId);
		medicament.setName(name);
		medicament.setDescription(description);
		medicament.setProducer(producer);
		medicament.setCategory(category);
		medicament.setPrice(price);
		medicament.setStockQuantity(stockQuantity);
		medicament.setStockInOrder(stockInOrder);
		medicament.setActive(active);
		

		int status = MedicamentDao.update(medicament);

		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}
		out.close();
	}
}
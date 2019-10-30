package Pharmacy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		String medicamentId = request.getParameter("medicamentId");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String producer = request.getParameter("producer");  
		String category = request.getParameter("category");
		Double price = Double.parseDouble(request.getParameter("price"));
		int stock_Quantity = Integer.parseInt(request.getParameter("stockQuantity"));
		int stock_In_Order = Integer.parseInt(request.getParameter("stockInOrder"));
		Boolean active = Boolean.parseBoolean(request.getParameter("active"));

		Medicament medicament = new Medicament();
		
		medicament.setMedicamentId(medicamentId);
		medicament.setName(name);
		medicament.setDescription(description);
		medicament.setProducer(producer);
		medicament.setCategory(category);
		medicament.setPrice(price);
		medicament.setStockQuantity(stock_Quantity);
		medicament.setStockInOrder(stock_In_Order);
		medicament.setActive(active);
		
		
	

		int status = MedicamentDao.save(medicament);

		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}
}

package com.java.so;

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

        String medicamentId = request.getParameter("medicamentId");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        String stockQuantity = request.getParameter("stockQuantity");
        String stockInOrder = request.getParameter("stockInOrder");
        String active = request.getParameter("active");

        Medicament medicament = new Medicament();
        medicament.setMedicamentId(medicamentId);
        medicament.setName(name);
        medicament.setPrice(Double.parseDouble(price));
        medicament.setDescription(description);
        medicament.setProducer(producer);
        medicament.setStockQuantity(Long.parseLong(stockQuantity));
        medicament.setStockInOrder(Long.parseLong(stockInOrder));
        medicament.setActive(Boolean.parseBoolean(active));

        int status = MedicamentDao.update(medicament);

        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }
        out.close();
    }
}

package car.tp4.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.tp4.entity.BookBean;
import car.tp4.entity.PanierBean;

@WebServlet("/supprimerDuPanier")
public class SupprimerDuPanierServlet extends HttpServlet{
	
	@EJB
	private PanierBean panierBean;
	
	@EJB
	private BookBean bookBean;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		
		panierBean.removeBook(id);
		bookBean.incrementerStock(id);
		
		response.sendRedirect("/books");
	}

}

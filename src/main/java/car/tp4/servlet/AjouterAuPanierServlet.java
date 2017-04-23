package car.tp4.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.tp4.entity.Book;
import car.tp4.entity.BookBean;
import car.tp4.entity.PanierBean;

@WebServlet("/ajouterAuPanier")
public class AjouterAuPanierServlet extends HttpServlet{

	@EJB
	private PanierBean panierBean;
	
	@EJB
	private BookBean bookBean;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Book b = bookBean.getBookById(id);
	    panierBean.addBook(b);
	    
		request.setAttribute("panier", panierBean.getPanier());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/panier.jsp");
		dispatcher.forward(request, response);
	}
}

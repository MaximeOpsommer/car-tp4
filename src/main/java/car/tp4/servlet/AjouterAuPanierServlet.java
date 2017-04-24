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

/**
 * Servlet permettant l'ajout d'un livre dans le panier
 * 
 * @author Serial
 *
 */
@WebServlet("/ajouterAuPanier")
public class AjouterAuPanierServlet extends HttpServlet{

	/**
	 * le panier de commande
	 */
	@EJB
	private PanierBean panierBean;
	
	/**
	 * la biliotheque de livres 
	 */
	@EJB
	private BookBean bookBean;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		String titre = request.getParameter("title");
		String auteur = request.getParameter("author");
		int annee = Integer.parseInt(request.getParameter("year"));
		Book b = bookBean.getBookByInfos(titre, auteur, annee);
		
		boolean livreAjoute = false;
		if(b.getQuantity() > 0){
			bookBean.decrementerStock(b.getId());
			panierBean.addBook(b);
			livreAjoute = true;
		}
		
		response.sendRedirect("books");
		
	}
}

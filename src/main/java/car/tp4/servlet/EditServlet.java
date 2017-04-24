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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	@EJB
	private BookBean bookBean;
	
	@EJB
	private PanierBean panierBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		
		Book book = bookBean.getBookById(id);
		System.out.println("HERE I AM, IN EDIT SEVLET");
		
		if(book != null) {
			System.out.println("AND YOUR BOOK IS NOT NULL, WELL DONE");
			System.out.println(book.getAuthor());
			request.setAttribute("author", book.getAuthor());
			request.setAttribute("title", book.getTitle());
			request.setAttribute("year", book.getYear() + "");
		} else {
			System.out.println("AND YOUT BOOK IS NULL ASSHOLE");
			request.setAttribute("author", "caca");
			request.setAttribute("title", "bite");
			request.setAttribute("year", "boob");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/edit.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		String titre = request.getParameter("title");
		String auteur = request.getParameter("author");
		int annee = Integer.parseInt(request.getParameter("year"));
		System.out.println("HEY? YOU WANT TO ADD A BOOK TO YOUR CART ?");
		Book b = bookBean.getBookByInfos(titre, auteur, annee);
		System.out.println(b.getAuthor());
		
		if(b.getQuantity() > 0){
			b.setQuantity(b.getQuantity() -1);
			panierBean.addBook(b);
		}
		
		System.out.println(panierBean.getPanier());
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/book.jsp");
		dispatcher.forward(request, response);
		
	}

}

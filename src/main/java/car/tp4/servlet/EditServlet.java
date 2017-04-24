package car.tp4.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		
		if(book != null) {
			request.setAttribute("author", book.getAuthor());
			request.setAttribute("title", book.getTitle());
			request.setAttribute("year", book.getYear() + "");
			request.setAttribute("quantity", book.getQuantity()+"");
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

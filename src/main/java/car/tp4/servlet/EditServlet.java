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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	@EJB
	private BookBean bookBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		
		Book book = bookBean.getBookById(id);
		
		if(book != null) {
			request.setAttribute("author", book.getAuthor());
			request.setAttribute("title", book.getTitle());
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/edit.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/book.jsp");
	    String titre = request.getParameter("titre");
	    String auteur = request.getParameter("auteur");
	    int annee = Integer.parseInt(request.getParameter("annee"));
	    bookBean.addBook(new Book(auteur, titre, annee));
	    dispatcher.forward(request, response);
	}

}

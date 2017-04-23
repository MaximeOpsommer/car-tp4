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

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

	@EJB
	private BookBean bookBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("books", bookBean.getAllBooks());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/create.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

	    //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/book.jsp");
	    String titre = request.getParameter("titre");
	    String auteur = request.getParameter("auteur");
	    //request.setAttribute("books", bookBean.getAllBooks());
	    bookBean.addBook(new Book(auteur, titre));
	    //dispatcher.forward(request, response);
	    response.sendRedirect("books");
	}

}

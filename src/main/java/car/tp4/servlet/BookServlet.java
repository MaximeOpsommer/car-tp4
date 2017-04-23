package car.tp4.servlet;

import car.tp4.entity.Book;
import car.tp4.entity.BookBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

	@EJB
	private BookBean bookBean;

	@Override
	public void init() throws ServletException {
		if(bookBean.isEmpty()) {			
			bookBean.addBook(new Book("J. R. R. Tolkien", "The Lord of the Rings", 1970));
			bookBean.addBook(new Book("Matthieu Bellamy", "La pizza bonne et peu chère, c'est par ici !", 2015));
			bookBean.addBook(new Book("Camille Breuzon", "Camille et la bite", 2016));
			bookBean.addBook(new Book("Alexandre Delassus", "Le caca, c'est merveilleux", 2017));
			bookBean.addBook(new Book("Maxime Opsommer", "J'suis dans l'turfu !", 2018));
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("books", bookBean.getAllBooks());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/book.jsp");
		dispatcher.forward(request, response);
	}
}

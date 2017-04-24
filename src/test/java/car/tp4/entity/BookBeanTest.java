package car.tp4.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BookBeanTest {
	
	private BookBean bookBean;
	
	@Before
	public void init() {
		bookBean = new BookBean();
	}

	@Test
	public void testBooks() {
		assertEquals(new ArrayList<Book>(), bookBean.getAllBooks());
		List<Book> books = new ArrayList<Book>();
		Book book = new Book("Camille Breuzon", "Livre de Camille Breuzon", 2017);
		books.add(book);
		bookBean.addBook(book);
		assertEquals(books, bookBean.getAllBooks());
	}

}

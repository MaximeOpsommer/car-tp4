package car.tp4.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CommandTest {
	
	private Command command;
	
	@Before
	public void init() {
		command = new Command();
	}

	@Test
	public void testBooks() {
		List<Book> books = new ArrayList<Book>();
		Book book = new Book("Camille Breuzon", "Livre de Camille Breuzon", 2017);
		books.add(book);
		assertEquals(new ArrayList<Book>(), command.getBooks());
		command.setBooks(books);
		assertEquals(books, command.getBooks());
	}
	
	@Test
	public void testConfirmCommand() {
		List<Book> books = new ArrayList<Book>();
		Book book1 = new Book("Camille Breuzon", "Livre de Camille Breuzon", 2017);
		Book book2 = new Book("Maxime Opsommer", "Livre de Maxime Opsommer", 2017, 0);
		books.add(book1);
		books.add(book2);
		command.setBooks(books);
		assertEquals(1, book1.getQuantity());
		assertEquals(0, book2.getQuantity());
		command.confirmCommand();
		assertEquals(0, book1.getQuantity());
		assertEquals(0, book2.getQuantity());
	}

}

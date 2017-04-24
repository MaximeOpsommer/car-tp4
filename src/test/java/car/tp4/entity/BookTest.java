package car.tp4.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	private Book book1;
	private Book book2;
	
	@Before
	public void init() {
		book1 = new Book("Camille Breuzon", "Livre de Camille", 2015);
		book2 = new Book("Camille Breuzon", "Livre de Camille", 2015, 1);
	}
	
	@Test
	public void testId() {
		book1.setId(1);
		assertEquals(1, book1.getId());
	}
	
	@Test
	public void testAuthor() {
		assertEquals("Camille Breuzon", book1.getAuthor());
		book1.setAuthor("Camille");
		assertEquals("Camille", book1.getAuthor());
	}
	
	@Test
	public void testTitle() {
		assertEquals("Livre de Camille", book1.getTitle());
		book1.setTitle("Titre");
		assertEquals("Titre", book1.getTitle());
	}
	
	@Test
	public void testYear() {
		assertEquals(2015, book1.getYear());
		book1.setYear(2017);
		assertEquals(2017, book1.getYear());
	}
	
	@Test
	public void testQuantity() {
		assertEquals(1, book1.getQuantity());
		book1.setQuantity(2);
		assertEquals(2, book1.getQuantity());
	}
	
	@Test
	public void testEquals() {
		assertEquals(book1, book1);
		assertNotEquals(book1, null);
		assertNotEquals(book1, new Integer(1));
		book2.setId(123456789);
		assertNotEquals(book1, book2);
		book2.setId(book1.getId());
		assertEquals(book1, book1);
		book2.setAuthor("Maxime Opsommer");
		assertNotEquals(book1, book2);
		book2.setAuthor(book1.getAuthor());
		book2.setYear(2017);
		assertNotEquals(book1, book2);
		book2.setYear(book1.getYear());
		book2.setTitle("Livre de Maxime Opsommer");
		assertNotEquals(book1, book2);
	}
	
	@Test
	public void testHashCode() {
		assertEquals(1298415228, book1.hashCode());
	}
	
	@Test
	public void testToString() {
		assertEquals("Book {author='Camille Breuzon', title='Livre de Camille', year='2015'}", book1.toString());
	}

}

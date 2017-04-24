package car.tp4.entity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class BookBean {

	@PersistenceContext(unitName = "book-pu")
	private EntityManager entityManager;
	
	private List<Book> books = new ArrayList<Book>();

	public void addBook(Book book) {
		entityManager.persist(book);
	}

	public List<Book> getAllBooks() {
		Query query = entityManager.createQuery("SELECT m from Book as m");
		books =  query.getResultList();
		return books;
	}
	
	public boolean isEmpty() {
		return getAllBooks().isEmpty();
	}
	
	public Book getBookById(long id) {
		//List<Book> books = getAllBooks();
		
		for(Book b : books) {
			if(b.getId() == id)
				return b;
		}
		
		return null;
	}
	
	public void decrementerStock(Book b){
		for(Book book : books){
			if(book.equals(book))
				book.setQuantity(book.getQuantity() - 1);
		}
	}
	
	public Book getBookByInfos(String title, String author, int year){
		//List<Book> books = getAllBooks();
		for(Book b : books) {
			if(b.getAuthor().equals(author) && b.getTitle().equals(title) && b.getYear() == year)
				return b;
		}
		
		return null;
	}
}
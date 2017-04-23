package car.tp4.entity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local
public class BookBean {

	@PersistenceContext(unitName = "book-pu")
	private EntityManager entityManager;

	public void addBook(Book book) {
		entityManager.persist(book);
	}

	public List<Book> getAllBooks() {
		Query query = entityManager.createQuery("SELECT m from Book as m");
		return query.getResultList();
	}
	
	public boolean isEmpty() {
		return getAllBooks().isEmpty();
	}
	
	public Book getBookById(long id) {
		List<Book> books = getAllBooks();
		
		for(Book b : books) {
			if(b.getId() == id)
				return b;
		}
		
		return null;
	}
	
	public Book getBookByInfos(String title, String author, int year){
		Query query = entityManager.createQuery("SELECT m from Book as m where m.author = " + author + " and m.title = " + title + 
				" and year = " + year);
		return (Book) query.getResultList().get(0);
	}
}
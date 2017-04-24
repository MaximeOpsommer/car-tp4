package car.tp4.entity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe bean permettant la gestion d'une bibliothèque en ligne
 * 
 * @author Serial
 *
 */
@Stateless
@Local
public class BookBean {

	@PersistenceContext(unitName = "book-pu")
	private EntityManager entityManager;
	
	/**
	 * liste des livres de la bibliothèque
	 */
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
		for(Book b : books) {
			if(b.getId() == id)
				return b;
		}
		
		return null;
	}
	
	
	/**
	 * permet de réduire le stock de livre
	 * @param id - L'identifiant du livre
	 */
	public void decrementerStock(long id) {
		Query query = entityManager.createQuery("UPDATE Book as b SET b.quantity = (b.quantity - 1) WHERE b.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	/**
	 * permet d'augmenter de 1 le stock d'un livre
	 * @param id - L'identifiant du livre
	 */
	public void incrementerStock(long id) {
		Query query = entityManager.createQuery("UPDATE Book as b SET b.quantity = (b.quantity + 1) WHERE b.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	/**
	 * Retourne le livre ayant les propriétés passées en paramètre
	 * 
	 * @param title
	 * @param author
	 * @param year
	 * @return
	 */
	public Book getBookByInfos(String title, String author, int year){
		for(Book b : books) {
			if(b.getAuthor().equals(author) && b.getTitle().equals(title) && b.getYear() == year)
				return b;
		}
		
		return null;
	}
}
package car.tp4.entity;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local
public class PanierBean {

	@PersistenceContext(unitName="panier-pu")
	private EntityManager entityManager;
	
	private List<Book> panier = new ArrayList<Book>();
	
	public void addBook(Book book){
//		entityManager.persist(book);
		panier.add(book);
	}
	
	public List<Book> getPanier() {
		return panier;
	}
	

}

package car.tp4.entity;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
@Local
public class PanierBean {

	@PersistenceContext(unitName="panier-pu")
	private EntityManager entityManager;
	
	
	public void addBook(Book book){
		entityManager.persist(book);
	}
	
	public List<Book> getPanier() {
		Query query = entityManager.createQuery("SELECT m from Panier as m");
		return query.getResultList();
	}
	

}

package car.tp4.entity;

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
	
	
	public void addBook(Book book){
		entityManager.persist(book);
	}
	
	public List<Book> getPanier() {
		Query query = entityManager.createQuery("SELECT m from Panier as m");
		return query.getResultList();
	}
	

}

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
		panier.add(book);
	}
	
	public List<Book> getPanier() {
		return panier;
	}
	
	public void removeBook(long id){
		int index = 0;
		boolean flag = false;
		for(Book b : panier){
			if(id == b.getId()){
				index = panier.indexOf(b);
				flag = true;
				break;
			}
		}
		
		if(flag){
			panier.remove(index);
		}
		
	}
	

}

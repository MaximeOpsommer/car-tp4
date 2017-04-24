package car.tp4.entity;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Classe bean permettant de gérer le panier de commande de livres
 * 
 * @author Serial
 *
 */
@Stateless
@Local
public class PanierBean {

	@PersistenceContext(unitName="panier-pu")
	private EntityManager entityManager;
	
	/**
	 * liste des livres dans le panier 
	 */
	private List<Book> panier = new ArrayList<Book>();
	
	/**
	 * ajoute un livre dans le panier
	 * @param book - Le livre à ajouter
	 */
	public void addBook(Book book){
		panier.add(book);
	}
	
	/**
	 * retourne la liste des livres du panier
	 * @return
	 */
	public List<Book> getPanier() {
		return panier;
	}
	
	/**
	 * Retire un livre du panier
	 * @param id - L'identifiant du livre
	 */
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

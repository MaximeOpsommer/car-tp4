package car.tp4.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private List<Book> panier;
	
	public Panier(){
		panier = new ArrayList<Book>();
	}
	
	public List<Book> getPanier(){
		return panier;
	}
}

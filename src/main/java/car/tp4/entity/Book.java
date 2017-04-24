package car.tp4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Serial
 * 
 * Classe représentant un livre
 * Cette entité est persistante dans l'application
 *
 */
@Entity
public class Book {
	
	/**
	 * identifiant du livre
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	/**
	 * auteur du livre
	 */
	private String author;
	
	
	/**
	 * titre du livre
	 */
	private String title;
	
	
	/**
	 * année du parution du livre 
	 */
	private int year;
	
	
	/**
	 * quantité disponible dans le stock 
	 */
	private int quantity;

	
	public Book() {
		//Constructeur vide par défaut : d'autres contstructeurs sont disponibles
	}
	
	/**
	 * Créer un livre avec une quantité disponible égale à 1
	 * @param author
	 * @param title
	 * @param year
	 */
	public Book(String author, String title, int year) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.quantity = 1;
	}
	
	/**
	 * Créer un livre avec toutes les propriétés en paramètre
	 * @param author
	 * @param title
	 * @param year
	 * @param quantity
	 */
	public Book(String author, String title, int year,  int quantity) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.quantity = quantity;
	}

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Retourne la quantité du stock disponible
	 * @return
	 */
	public int getQuantity(){
		return this.quantity;
	}
	
	/**
	 * Affecte la nouvelle valeur en paramètre à la quantité du stock disponible
	 * @param newQuantity
	 */
	public void setQuantity(int newQuantity){
		this.quantity = newQuantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Book book = (Book) o;

		if (id != book.id)
			return false;
		if (!author.equals(book.author))
			return false;
		if(!(year == book.year))
			return false;
		return title.equals(book.title);
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + author.hashCode();
		result = 31 * result + title.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Book {" + "author='" + author + '\'' + ", title='" + title + '\'' + ", year='" + year + '\'' + '}';
	}
}

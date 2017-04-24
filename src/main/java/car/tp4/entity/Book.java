package car.tp4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String author;
	private String title;
	private int year;
	private int quantity;

	public Book() {
		
	}
	
	public Book(String author, String title, int year) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.quantity = 1;
	}
	
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
	
	public int getQuantity(){
		return this.quantity;
	}
	
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

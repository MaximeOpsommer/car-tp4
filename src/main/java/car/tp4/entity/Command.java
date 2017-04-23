package car.tp4.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Command {

	@GeneratedValue
	@Id
	private long id;

	private List<Book> books;
	
	public Command() {
		books = new ArrayList<Book>();
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void confirmCommand(){
		for(Book b : books){
			int q = b.getQuantity();
			if(q > 0){
				b.setQuantity(q - 1);
			}
		}
	}

}

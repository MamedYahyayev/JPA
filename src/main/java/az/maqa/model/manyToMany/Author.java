package az.maqa.model.manyToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String surname;

	private Date birthDate;

	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"), 
				inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> books = new ArrayList<Book>();

	public Author() {

	}

	public Author(String name, String surname, Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

	public void addBooks(Book book) {
		this.books.add(book);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}

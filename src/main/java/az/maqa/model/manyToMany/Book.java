package az.maqa.model.manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private int copy;

	private int pageSize;

	@ManyToMany(mappedBy = "books")
	private List<Author> authors = new ArrayList<Author>();

	public Book() {

	}

	public Book(String title, int copy, int pageSize) {
		this.title = title;
		this.copy = copy;
		this.pageSize = pageSize;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getCopy() {
		return copy;
	}

	public int getPageSize() {
		return pageSize;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCopy(int copy) {
		this.copy = copy;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}

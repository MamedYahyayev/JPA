package az.maqa.main.manyToMany;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import az.maqa.model.manyToMany.Author;
import az.maqa.model.manyToMany.Book;

public class MainPersist {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		Book book1 = new Book("Abc", 25, 258);
		Book book2 = new Book("Xyz", 43, 147);
		Book book3 = new Book("Lmn", 5, 354);

		Author author1 = new Author("Samir", "Samirov", new Date());

		author1.addBooks(book1);
		author1.addBooks(book2);

		Author author2 = new Author("Amin", "Qasimov", new Date());
		author2.addBooks(book1);
		author2.addBooks(book3);

		entityManager.getTransaction().begin();

		entityManager.persist(author1);
		entityManager.persist(author2);
		entityManager.persist(book1);
		entityManager.persist(book2);
		entityManager.persist(book3);

		entityManager.getTransaction().commit();

	}

}

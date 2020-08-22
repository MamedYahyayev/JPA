package az.maqa.embedded.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import az.maqa.embedded.model.Address;
import az.maqa.embedded.model.User;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		User user = new User("Samir", "Samirov", 25, "0552694712", "samir@gmail.com");

		Address address = new Address("Azerbaijan", "Baku", "A.Valiyev", 2547);

		user.setAddress(address);

		entityManager.getTransaction().begin();

		entityManager.persist(user);

		entityManager.getTransaction().commit();

	}

}

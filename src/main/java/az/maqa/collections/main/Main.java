package az.maqa.collections.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import az.maqa.collections.model.Address;
import az.maqa.collections.model.Teacher;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		Teacher teacher = new Teacher("Samir", "Samirov", 25);
		Teacher teacher2 = new Teacher("Veli", "Demir", 29);

		Address address = new Address("Azerbaijan", "Baku", "A.Valiyev", 2547);
		Address address1 = new Address("Azerbaijan", "Seki", "M.Sabanov", 457);
		Address address2 = new Address("Turkiye", "Istanbul", "M.Agaoglu", 57896);

		teacher.getAddresses().add(address);
		teacher.getAddresses().add(address1);
		teacher2.getAddresses().add(address2);

		entityManager.getTransaction().begin();

		entityManager.persist(teacher);
		entityManager.persist(teacher2);
		

		entityManager.getTransaction().commit();
	}

}

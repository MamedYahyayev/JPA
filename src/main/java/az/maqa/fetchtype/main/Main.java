package az.maqa.fetchtype.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import az.maqa.fetchtype.model.Doctor;
import az.maqa.fetchtype.model.Laptop;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		Doctor doctor = new Doctor("Samir", "Samirov", 25);

		Laptop laptop = new Laptop("Apple", 3000);
		laptop.setDescription("The best laptop in the world");
		laptop.setAvailable(true);

		laptop.setDoctor(doctor);
		
		entityManager.getTransaction().begin();

		entityManager.persist(doctor);

		entityManager.persist(laptop);

		entityManager.getTransaction().commit();
		
	

	}
}

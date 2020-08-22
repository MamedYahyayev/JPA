package az.maqa.mappedsuperclass.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import az.maqa.mappedsuperclass.model.Course;
import az.maqa.mappedsuperclass.model.Student;

public class Persist {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		Student student = new Student("Samir", "Samirov", 25, "samir@gmail.com", new Date());
		Course course = new Course("Java", (double) 120, 6);

		entityManager.getTransaction().begin();

		entityManager.persist(student);
		entityManager.persist(course);

		entityManager.getTransaction().commit();
	}

}

package az.maqa.mappedsuperclass.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import az.maqa.mappedsuperclass.model.Course;
import az.maqa.mappedsuperclass.model.Student;
import az.maqa.mappedsuperclass.model.StudentCourse;

public class CreateStudentCourseTable {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		Student student = new Student("Samir", "Samirov", 25, "samir@gmail.com", new Date());
		Course course = new Course("Java", (double) 120, 6);

		StudentCourse studentCourse = new StudentCourse(student , course);

		entityManager.getTransaction().begin();

		entityManager.persist(studentCourse);

		entityManager.getTransaction().commit();

	}

}

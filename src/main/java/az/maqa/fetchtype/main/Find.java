package az.maqa.fetchtype.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import az.maqa.fetchtype.model.Doctor;


public class Find {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();
		
		Doctor doctor = entityManager.find(Doctor.class, 1L);
		
		System.out.println(doctor.getName());
		
		doctor.getLaptops().forEach(System.out::println);
		
		
		
	}
}

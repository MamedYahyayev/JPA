package az.maqa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import az.maqa.model.Employee;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();

		Employee employee = entityManager.find(Employee.class, 1L);

		System.out.println("Before Update : " + employee);
		
		employee.setAge(25);
		employee.setEmail("samir_1995@gmail.com");
		employee.setSalary(4200);
		employee.setExperience(3);
		
		transaction.begin();
		
		entityManager.merge(employee);
		
		transaction.commit();
		
		System.out.println("After Update : " + employee);

	}

}

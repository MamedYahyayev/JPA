package az.maqa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import az.maqa.model.Employee;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();

		Employee employeeAsim = entityManager.find(Employee.class, 3L);

		System.out.println(employeeAsim);

		transaction.begin();

		entityManager.remove(employeeAsim);

		transaction.commit();
		
		Employee employee = entityManager.find(Employee.class, 3L);

		if(employee == null)
			System.out.println("Employee was deleted...");
		
	}

}

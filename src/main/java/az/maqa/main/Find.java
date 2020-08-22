package az.maqa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import az.maqa.model.Address;
import az.maqa.model.Employee;

public class Find {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		Employee employee = entityManager.find(Employee.class, 1L);
		Address address = entityManager.find(Address.class, 3L);

		System.out.println(address.getEmployee());
		
		if (employee != null)
			System.out.println(employee);
		else
			System.err.println("Employee was not found");
		
		transaction.commit();

	}

}

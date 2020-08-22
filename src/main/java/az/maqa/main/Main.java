package az.maqa.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import az.maqa.model.Address;
import az.maqa.model.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();

		Employee employee = employee();
		Address address = new Address();
		address.setCity("Baki");
		address.setPostalCode(152);
		address.setStreet("Y.Eliyev");

		employee.setAddress(address);

		Employee employee2 = employee2();
		Address address2 = new Address();
		address2.setCity("Seki");
		address2.setPostalCode(1500);
		address2.setStreet("A.Asimov");

		employee2.setAddress(address2);

		Employee employee3 = employee3();
		Address address3 = new Address();
		address3.setCity("Gence");
		address3.setPostalCode(120);
		address3.setStreet("Q.Qalibov");

		employee3.setAddress(address3);

		checkPossibleCase(employee, employee2);

		transaction.begin();

		entityManager.persist(employee);
	//	entityManager.persist(address);

		entityManager.persist(employee2);
	//	entityManager.persist(address2);

		entityManager.persist(employee3);
	//	entityManager.persist(address3);

		transaction.commit();

		Employee employeeFind1 = entityManager.find(Employee.class, 1L);
		Address addressFind1 = entityManager.find(Address.class, 1L);
		System.out.println(employeeFind1);
		System.out.println(addressFind1);

	}

	private static Employee employee3() {
		Employee employee3 = new Employee();
		employee3.setName("Asim");
		employee3.setSurname("Asimov");
		employee3.setAge(29);
		employee3.setBirthOfDate(new Date());
		employee3.setEmail("asimov@gmail.com");
		employee3.setExperience(2);
		employee3.setSalary(2550);
		return employee3;
	}

	private static void checkPossibleCase(Employee employee, Employee employee2) {
		if (employee2.getEmail().equalsIgnoreCase(employee.getEmail())) {
			throw new RuntimeException("Email must be unique");
		}

		if (employee.getName().length() > 25)
			throw new RuntimeException("Name must be less than 25 characters");
	}

	private static Employee employee2() {
		Employee employee2 = new Employee();
		employee2.setName("Samire");
		employee2.setSurname("Samirova");
		employee2.setAge(25);
		employee2.setBirthOfDate(new Date());
		employee2.setEmail("samire@gmail.com");
		employee2.setExperience(2);
		employee2.setSalary(2550);
		return employee2;
	}

	private static Employee employee() {
		Employee employee = new Employee();
		employee.setName("Samir");
		employee.setSurname("Samirov");
		employee.setAge(25);
		employee.setBirthOfDate(new Date());
		employee.setEmail("samir@gmail.com");
		employee.setExperience(2);
		employee.setSalary(2550);
		return employee;
	}
}

package az.maqa.main.oneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import az.maqa.model.oneToMany.Customer;
import az.maqa.model.oneToMany.Product;

public class MainPersist {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		Customer customer = new Customer("Samir", "Samirov", 25);

		Product product = new Product("Samsung", (double) 2500, 120);
		product.setCustomer(customer);

		Product product2 = new Product("Iphone 5S", (double) 1200, 10);
		product2.setCustomer(customer);

		entityManager.getTransaction().begin();

		entityManager.persist(product);
		entityManager.persist(product2);

		entityManager.getTransaction().commit();

		
		// Find
			Product productFind = entityManager.find(Product.class, 1L);
			System.out.println(productFind);

			Customer customerFind = entityManager.find(Customer.class, 1L);
			System.out.println(customerFind);

	}

}

package az.maqa.main.oneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import az.maqa.model.oneToMany.Customer;

public class MainFind {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		// Find
		Customer customersProduct = entityManager.find(Customer.class, 1L);
		System.out.println(customersProduct.getProducts());
	}
}

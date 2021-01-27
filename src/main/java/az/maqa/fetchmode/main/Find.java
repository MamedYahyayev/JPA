package az.maqa.fetchmode.main;

import az.maqa.fetchmode.model.ShopCustomer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Find {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        List<ShopCustomer> customers = entityManager.createQuery("SELECT s from ShopCustomer s", ShopCustomer.class).getResultList();

        customers.forEach(customer -> customer.getOrders().forEach(order -> System.out.println(order.getName())));


    }
}

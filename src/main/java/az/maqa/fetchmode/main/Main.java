package az.maqa.fetchmode.main;

import az.maqa.fetchmode.model.ShopCustomer;
import az.maqa.fetchmode.model.ShopOrder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        ShopCustomer customer = new ShopCustomer("Samir", "Samirov");

        ShopOrder order = new ShopOrder("Cola");
        order.setCustomer(customer);

        ShopOrder order2 = new ShopOrder("Fanta");
        order2.setCustomer(customer);

        Set<ShopOrder> orders = new HashSet<>();
        orders.add(order);
        orders.add(order2);

        customer.setOrders(orders);

        entityManager.getTransaction().begin();

        entityManager.persist(customer);

        entityManager.getTransaction().commit();
    }
}

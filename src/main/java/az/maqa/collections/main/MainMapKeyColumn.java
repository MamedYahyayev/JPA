package az.maqa.collections.main;

import az.maqa.collections.model.EmployeeMapKeyColumn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class MainMapKeyColumn {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        Map<String, Integer> items = new HashMap<>();
        items.put("ball", 2);
        items.put("roof", 1);

        EmployeeMapKeyColumn employee = new EmployeeMapKeyColumn("Samir" , "Samirov" , items);

        entityManager.getTransaction().begin();

        entityManager.persist(employee);

        entityManager.getTransaction().commit();
    }
}

package az.maqa.flush.main;

import az.maqa.flush.model.Debt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        Debt debt1 = new Debt(1L, "Water", 120D);
        Debt debt2 = new Debt(2L, "Water", 120D);

        entityManager.getTransaction().begin();

        entityManager.persist(debt1);
        entityManager.persist(debt2);

        entityManager.flush();

        findDebt(entityManager);

        entityManager.close();
    }

    public static void findDebt(EntityManager entityManager){
        Query query = entityManager.createQuery("Select d from Debt d");
        System.out.println("Debts:");
        System.out.println(query.getResultList());
    }


}

package az.maqa.auditing.hibernate.main;

import az.maqa.auditing.hibernate.model.Tax;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TaxMainClass {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        Tax tax = new Tax("Water");

        entityManager.getTransaction().begin();

        entityManager.persist(tax);

        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();

        Tax foundedTax = entityManager.find(Tax.class, 5L);
        System.out.println("Founded Tax: " + foundedTax);

        foundedTax.setTax("Rent");
        entityManager.persist(foundedTax);

        entityManager.getTransaction().commit();

        // Read Audit from table
        AuditReader reader = AuditReaderFactory.get(entityManager);
        AuditQuery query = reader.createQuery().forEntitiesAtRevision(Tax.class, 1);
        System.out.println(query.getResultList());

    }
}

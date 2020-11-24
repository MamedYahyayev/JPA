package az.maqa.inheritance.defaultinheritance.tableperconcrete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        PersonConcrete person = new PersonConcrete("Samir", "Samirov");
        EmployeeConcrete employee = new EmployeeConcrete("Kazim", "Kazimov", 1200);
        StudentConcrete student = new StudentConcrete("Famil", "Familov", 2);


        entityManager.getTransaction().begin();

        entityManager.persist(person);
        entityManager.persist(employee);
        entityManager.persist(student);

        entityManager.getTransaction().commit();
    }
}

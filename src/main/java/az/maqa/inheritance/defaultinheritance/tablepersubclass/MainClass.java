package az.maqa.inheritance.defaultinheritance.tablepersubclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        PersonSubclass person = new PersonSubclass("Samir", "Samirov");
        EmployeeSubclass employee = new EmployeeSubclass("Kazim", "Kazimov", 1200);
        StudentSubclass student = new StudentSubclass("Famil", "Familov", 2);


        entityManager.getTransaction().begin();

        entityManager.persist(person);
        entityManager.persist(employee);
        entityManager.persist(student);

        entityManager.getTransaction().commit();
    }
}

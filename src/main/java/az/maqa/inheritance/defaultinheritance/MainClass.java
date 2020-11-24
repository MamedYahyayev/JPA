package az.maqa.inheritance.defaultinheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        Person person = new Person("Samir", "Samirov");
        EmployeeInheritance employee = new EmployeeInheritance("Kazim", "Kazimov", 1200);
        StudentInheritance student = new StudentInheritance("Famil", "Familov", 2);


        entityManager.getTransaction().begin();

        entityManager.persist(person);
        entityManager.persist(employee);
        entityManager.persist(student);

        entityManager.getTransaction().commit();
    }
}

package az.maqa.inheritance.defaultinheritance.annotation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        PersonAnnotation person = new PersonAnnotation("Ali", "Aliyev");
        EmployeeAnnotation employee = new EmployeeAnnotation("Kazim", "Kazimov", 1200);
        StudentAnnotation student = new StudentAnnotation("Famil", "Familov", 4);

        entityManager.getTransaction().begin();

        entityManager.persist(person);
        entityManager.persist(employee);
        entityManager.persist(student);

        entityManager.getTransaction().commit();


    }

}

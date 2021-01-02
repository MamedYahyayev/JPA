package az.maqa.auditing.main;

import az.maqa.auditing.model.FamilyMembers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AuditingMainClass {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        List<String> characters = new ArrayList<>();
        characters.add("optimistic");
        characters.add("choleric");

        FamilyMembers members = new FamilyMembers("Samir", "Samirov", characters);

        entityManager.getTransaction().begin();

        entityManager.persist(members);

        FamilyMembers foundedMember = entityManager.find(FamilyMembers.class, 56L);
        if (foundedMember != null) {
            System.out.println("Founded Member: " + foundedMember);
            foundedMember.setSurname("Zakirov2");
            entityManager.persist(foundedMember);
        }

        FamilyMembers findForDelete = entityManager.find(FamilyMembers.class, 206L);
        if (findForDelete != null) {
            entityManager.remove(findForDelete);
        }

        entityManager.getTransaction().commit();

    }
}

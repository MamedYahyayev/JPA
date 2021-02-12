package az.maqa.oneToOne.main;

import az.maqa.oneToOne.model.MediumPost;
import az.maqa.oneToOne.model.MediumPostDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        MediumPost mediumPost = entityManager.find(MediumPost.class, 1L);
        MediumPostDetails details = mediumPost.getDetails();

        details.setDetails("Hello From Post 1");
        mediumPost.setDetails(details);

        entityManager.getTransaction().begin();

        entityManager.persist(mediumPost);

        entityManager.getTransaction().commit();


    }
}

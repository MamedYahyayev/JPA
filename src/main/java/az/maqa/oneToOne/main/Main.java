package az.maqa.oneToOne.main;

import az.maqa.oneToOne.model.MediumPost;
import az.maqa.oneToOne.model.MediumPostDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        MediumPostDetails details = new MediumPostDetails();
        details.setDetails("The best Post in the world");

        MediumPost post = new MediumPost();
        post.setTitle("Post 1");

        post.setDetails(details);

        entityManager.getTransaction().begin();

        entityManager.persist(post);

        entityManager.getTransaction().commit();
    }
}

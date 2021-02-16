package az.maqa.lazyToOne.main;

import az.maqa.lazyToOne.model.CarPost;
import az.maqa.lazyToOne.model.CarPostDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        CarPostDetails details = new CarPostDetails("First review");
        CarPost post = new CarPost("Car post");

        post.setDetails(details);
        details.setPost(post);

        entityManager.getTransaction().begin();

        entityManager.persist(post);
        entityManager.persist(details);

        entityManager.getTransaction().commit();
    }
}

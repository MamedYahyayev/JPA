package az.maqa.orphanremoval.main;

import az.maqa.orphanremoval.model.StackOverFlowPost;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Delete {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        StackOverFlowPost post = entityManager.find(StackOverFlowPost.class, 4L);
        post.removeComment(post.getComments().get(0));

        entityManager.getTransaction().begin();


        entityManager.getTransaction().commit();
    }
}

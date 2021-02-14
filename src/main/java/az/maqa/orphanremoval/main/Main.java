package az.maqa.orphanremoval.main;

import az.maqa.orphanremoval.model.StackOverFlowPost;
import az.maqa.orphanremoval.model.StackOverFlowPostComment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        StackOverFlowPostComment comment = new StackOverFlowPostComment();
        comment.setReview("First Comment");

        StackOverFlowPostComment comment2 = new StackOverFlowPostComment();
        comment2.setReview("Second Comment");


        StackOverFlowPost post = new StackOverFlowPost();
        post.setTitle("The first Post");
        post.addComment(comment);
        post.addComment(comment2);

        entityManager.getTransaction().begin();

        entityManager.persist(post);

        entityManager.getTransaction().commit();
    }
}

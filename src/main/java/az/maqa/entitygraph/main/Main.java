package az.maqa.entitygraph.main;

import az.maqa.entitygraph.model.OnlineComment;
import az.maqa.entitygraph.model.OnlinePost;
import az.maqa.entitygraph.model.OnlineUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        OnlineUser user = new OnlineUser("Samir", "samir@gmail.com");
        OnlineComment comment = new OnlineComment();
        OnlinePost post = new OnlinePost();

        comment.setReply("Great Post!");
        post.setSubject("Entity Graph");

        post.setUser(user);
        post.setComments(List.of(comment));

        comment.setUser(user);
        comment.setPost(post);

        entityManager.getTransaction().begin();

        entityManager.persist(post);
        entityManager.persist(comment);
        entityManager.persist(user);

        entityManager.getTransaction().commit();


    }

}

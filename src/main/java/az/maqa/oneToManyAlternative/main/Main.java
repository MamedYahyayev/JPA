package az.maqa.oneToManyAlternative.main;

import az.maqa.oneToManyAlternative.model.ApplePost;
import az.maqa.oneToManyAlternative.model.AppleTag;
import az.maqa.oneToManyAlternative.model.PostTag;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        AppleTag tag = new AppleTag();
        tag.setName("Java");

        ApplePost post = new ApplePost();
        post.setTitle("New Post");

        PostTag postTag = new PostTag(post, tag);

        post.setTags(List.of(postTag));
        tag.setPosts(List.of(postTag));

        entityManager.getTransaction().begin();

        entityManager.persist(tag);
        entityManager.persist(post);

        entityManager.getTransaction().commit();
    }
}

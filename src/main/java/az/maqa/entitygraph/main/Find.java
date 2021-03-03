package az.maqa.entitygraph.main;

import az.maqa.entitygraph.model.OnlinePost;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        EntityGraph entityGraph = entityManager.getEntityGraph("post-entity-graph-with-comment-users");
        OnlinePost post = entityManager.createQuery("select p from OnlinePost p where p.id = :id", OnlinePost.class)
                .setParameter("id", 1L)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getSingleResult();

        System.out.println(post);

    }

}

package az.maqa.cache.main;

import az.maqa.cache.model.BikeComments;
import az.maqa.cache.model.BikePost;
import net.sf.ehcache.CacheManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        for (int i = 0; i < 100; i++) {
            entityManager.getTransaction().begin();

            BikePost post = new BikePost("First Bike Post");
            BikeComments comments = new BikeComments("The First Comment");

            entityManager.persist(post);
            entityManager.persist(comments);

            entityManager.getTransaction().commit();
        }
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("az.maqa.cache.model.BikePost").getSize();
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>Size:" + size);

    }

}

package az.maqa.cache.main;

import az.maqa.cache.model.BikePost;
import net.sf.ehcache.CacheManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class MainFind {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        Scanner sc = new Scanner(System.in);
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("az.maqa.cache.model.BikePost").getSize();
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>Size:" + size);

        switch (sc.nextInt()) {
            case 1:
                retrieveComments(entityManager);
                break;
            case 2:
                retrieveComments(entityManager);
                break;
            case 3:
                retrieveComments(entityManager);
                break;
            default:
                System.out.println("Not valid choice");
        }

        main(args);

    }

    public static void retrieveComments(EntityManager entityManager) {
        BikePost comments = entityManager.find(BikePost.class, 52L);
        System.out.println(comments);
    }
}

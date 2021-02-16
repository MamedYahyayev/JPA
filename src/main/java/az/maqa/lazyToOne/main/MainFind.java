package az.maqa.lazyToOne.main;

import az.maqa.lazyToOne.model.CarPost;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainFind {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

        EntityManager entityManager = factory.createEntityManager();

        CarPost carPost = entityManager.find(CarPost.class, 1L);

    }
}

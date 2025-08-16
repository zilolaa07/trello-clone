package uz.pdp.dto.utils;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {

    private static EntityManagerFactory emf;

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("my-trello");
            System.out.println(">>> EntityManagerFactory created");
        }
        return emf;
    }

    public static synchronized void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println(">>> EntityManagerFactory closed");
        }
    }
}
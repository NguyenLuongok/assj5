package AssgmentJava5.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Service {
    public static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    public static EntityManager entityManagers = entityManagerFactory.createEntityManager();


    protected static void beginTransaction() {
       entityManagers.getTransaction().begin();
    }

    protected static void commit() {
        entityManagers.getTransaction().commit();
        disponse();
    }

    protected static void disponse() {
        entityManagerFactory.close();
        entityManagers.close();
    }

    protected void rollback() {
        entityManagers.getTransaction().rollback();
    }
}

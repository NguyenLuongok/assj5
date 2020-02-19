package AssgmentJava5.Dao;


import AssgmentJava5.Model.DepartsEntity;
import AssgmentJava5.Service.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DepartsDao extends Service{
    public static void create(DepartsEntity departsEntity) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        try {
            entityManagers.getTransaction().begin();
            entityManagers.persist(departsEntity);
            entityManagers.getTransaction().commit();
            entityManagerFactory.close();
        }
        catch (Exception e){
            e.printStackTrace();
            entityManagers.getTransaction().rollback();
        }
    }

    public static List<DepartsEntity> findAll() {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        try {
            entityManagers.getTransaction().begin();
            List<DepartsEntity> departsEntity = entityManagers.createQuery("SELECT d from DepartsEntity d", DepartsEntity.class).getResultList();
            entityManagers.close();
            entityManagerFactory.close();
            return departsEntity;
        } catch (Exception e) {
            e.printStackTrace();
            entityManagers.getTransaction().rollback();
        }
        return null;
    }
    public static DepartsEntity findId(int id) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        return entityManagers.find(DepartsEntity.class, id);
    }

    public static void update(DepartsEntity departsEntity) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        entityManagers.merge(departsEntity);
        entityManagers.getTransaction().commit();
        entityManagers.close();
        entityManagerFactory.close();
    }

    public static void delete(int id) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        entityManagers.remove(entityManagers.find(DepartsEntity.class, id));
        entityManagers.getTransaction().commit();

    }
}



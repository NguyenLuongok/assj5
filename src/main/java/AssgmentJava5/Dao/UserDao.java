package AssgmentJava5.Dao;

import AssgmentJava5.Model.UsersEntity;
import AssgmentJava5.Service.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDao extends Service {

    public static List<UsersEntity> findAll() {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        try {
            entityManagers.getTransaction().begin();
            List<UsersEntity> list = entityManagers.createQuery("SELECT d from UsersEntity d", UsersEntity.class).getResultList();
            entityManagers.getTransaction().commit();
            entityManagers.close();
            entityManagerFactory.close();
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
            entityManagers.getTransaction().rollback();
        }
        return null;
    }
    public static void create(UsersEntity usersEntity) throws Exception{
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        entityManagers.persist(usersEntity);
        entityManagers.getTransaction().commit();
        entityManagers.close();
        entityManagerFactory.close();
    }
    public static void update(UsersEntity usersEntity) throws Exception{
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        entityManagers.merge(usersEntity);
        entityManagers.getTransaction().commit();
        entityManagers.close();
        entityManagerFactory.close();
    }
    public static void delete(String userName) throws Exception{
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        entityManagers.remove(entityManagers.find(UsersEntity.class,userName));
        entityManagers.getTransaction().commit();
        entityManagers.close();
        entityManagerFactory.close();
    }
}

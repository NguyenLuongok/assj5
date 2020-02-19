package AssgmentJava5.Dao;

import AssgmentJava5.Model.StaffsEntity;
import AssgmentJava5.Service.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Blob;
import java.util.List;

public class StaffsDao extends Service {

    public static void create(StaffsEntity staffsEntity) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
       try {
           entityManagers.getTransaction().begin();
           entityManagers.persist(staffsEntity);
           entityManagers.getTransaction().commit();
           entityManagerFactory.close();
           entityManagers.close();
       }
       catch (Exception e){
           e.printStackTrace();
           entityManagers.getTransaction().rollback();
       }
    }

    public static StaffsEntity findId(int id) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
       try {
           entityManagers.getTransaction().begin();
           StaffsEntity staffsEntity = entityManagers.find(StaffsEntity.class, id);
           entityManagers.getTransaction().commit();
           entityManagerFactory.close();
           entityManagers.close();
           return staffsEntity;
       }
       catch (Exception e){
           e.printStackTrace();
           entityManagers.getTransaction().rollback();
       }
        return null;
    }
    public static List<StaffsEntity> findAll(){
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
       try {
           entityManagers.getTransaction().begin();
           List<StaffsEntity> staffsEntities = entityManagers.createQuery("SELECT s from StaffsEntity s INNER JOIN DepartsEntity d on s.departld= d.id", StaffsEntity.class).getResultList();
           entityManagers.close();
           entityManagerFactory.close();
           return staffsEntities;
       }
       catch (Exception e){
           e.printStackTrace();
           entityManagers.getTransaction().rollback();
       }
        return null;
    }
    public static void update(StaffsEntity staffsEntity) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        try {
            entityManagers.getTransaction().begin();
            entityManagers.merge(staffsEntity);
            entityManagers.getTransaction().commit();
            entityManagers.close();
            entityManagerFactory.close();
        }
        catch (Exception e){
            e.printStackTrace();
            entityManagers.getTransaction().rollback();
        }
    }

    public static void delete(int id) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        try{
            entityManagers.getTransaction().begin();
            entityManagers.remove(entityManagers.find(StaffsEntity.class, id));
            entityManagers.getTransaction().commit();
            entityManagers.close();
            entityManagerFactory.close();
        }
        catch (Exception e){
            e.printStackTrace();
            entityManagers.getTransaction().rollback();
        }
    }
    public static List<StaffsEntity> searchStaff(String name) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<StaffsEntity> query = entityManagers.createQuery("SELECT s from StaffsEntity s where s.name like :name", StaffsEntity.class);
            query.setParameter("name","%"+name+"%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManagers.getTransaction().rollback();
        }
        return null;
    }

}

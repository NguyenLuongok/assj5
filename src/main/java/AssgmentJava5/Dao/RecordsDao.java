package AssgmentJava5.Dao;


import AssgmentJava5.Model.DepartsEntity;
import AssgmentJava5.Model.RecordsEntity;
import org.hibernate.Session;
import org.hibernate.jpa.QueryHints;

import javax.persistence.*;
import java.util.List;

public class RecordsDao {
    public static List<RecordsEntity> findAll(){
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        try {
            entityManagers.getTransaction().begin();
            TypedQuery<RecordsEntity> r = entityManagers.createQuery("select r from RecordsEntity r",RecordsEntity.class);
            r.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH,false);
            List<RecordsEntity> recordsEntities = r.getResultList();
            return recordsEntities;
        } catch (Exception e) {
            e.printStackTrace();
            entityManagers.getTransaction().rollback();
        }
        entityManagers.close();
        entityManagerFactory.close();
        return null;
    }

    public static void create(RecordsEntity recordsEntity) throws Exception{
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        entityManagers.persist(recordsEntity);
        entityManagers.getTransaction().commit();
        entityManagers.close();
        entityManagerFactory.close();
    }
    public static void update(RecordsEntity recordsEntity) throws Exception{
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        entityManagers.merge(recordsEntity);
        entityManagers.getTransaction().commit();
        entityManagers.close();
        entityManagerFactory.close();
    }
     public static void remove(int id) throws Exception{
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManagers = entityManagerFactory.createEntityManager();
        entityManagers.getTransaction().begin();
        entityManagers.remove(entityManagers.find(RecordsEntity.class,id));
        entityManagers.getTransaction().commit();
        entityManagers.close();
        entityManagerFactory.close();
    }

    public static void main(String[] args) {
        List<RecordsEntity> list = findAll();
        for(RecordsEntity r:list){
            System.out.println(r.getStaffsEntity().getName());
        }
    }
}

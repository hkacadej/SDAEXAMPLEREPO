package dao;

import entity.RegionEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RegionDAO {
    private Session session;

    public RegionDAO() {
        session = new Configuration().configure()
                .addAnnotatedClass(RegionEntity.class)
                .buildSessionFactory().openSession();
    }

    public RegionEntity getRegion(int id) {

        RegionEntity regionEntity = null;

        try {
            session.beginTransaction();
            regionEntity =  session.get(RegionEntity.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
        }

        return regionEntity;
    }

    public void save(RegionEntity regionEntity) {
        try {
            session.beginTransaction();
            session.save(regionEntity);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
        }

    }

    public void update(RegionEntity regionEntity) {
        try {
            session.beginTransaction();
            session.update(regionEntity);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(RegionEntity regionEntity) {
        try {
            session.beginTransaction();
            session.delete(regionEntity);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    private static List<RegionEntity> getAllREgions(){
        List<RegionEntity> regions = new ArrayList<>();

        // create the sessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(RegionEntity.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            regions = session.createQuery("from RegionEntity",RegionEntity.class).getResultList();

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println("Error getting all persons: " + e.getMessage());
        }

        return regions;
    }

}

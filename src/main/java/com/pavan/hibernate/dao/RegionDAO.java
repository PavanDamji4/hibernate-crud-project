package com.pavan.hibernate.dao;

import com.pavan.hibernate.model.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RegionDAO {
    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void saveRegion(Region region) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(region);
        tx.commit();
        session.close();
    }

    public List<Region> getAllRegions() {
        Session session = factory.openSession();
        List<Region> regions = session.createQuery("from Region", Region.class).list();
        session.close();
        return regions;
    }
}

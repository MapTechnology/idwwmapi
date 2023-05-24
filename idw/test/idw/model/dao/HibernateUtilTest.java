package idw.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtilTest extends HibernateUtil{
    private static final SessionFactory sessionFactory;
    
    public static String HIBERNATE_CFG = "test/hibernatetest.cfg.xml";
    
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            sessionFactory = new AnnotationConfiguration()  
                             .configure(HIBERNATE_CFG)  
                             .buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

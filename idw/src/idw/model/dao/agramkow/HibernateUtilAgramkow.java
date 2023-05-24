package idw.model.dao.agramkow;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtilAgramkow {
	
	private static SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernateagramkow.cfg.xml
            sessionFactory = new AnnotationConfiguration()  
                             .configure("hibernateagramkow.cfg.xml")  
                             .buildSessionFactory();
        } catch (Throwable ex) {
        	ex.printStackTrace();
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}

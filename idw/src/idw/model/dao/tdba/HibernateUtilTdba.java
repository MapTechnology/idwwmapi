package idw.model.dao.tdba;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtilTdba {
	
	private static SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            sessionFactory = new AnnotationConfiguration()  
                             .configure("hibernatetdba.cfg.xml")  
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

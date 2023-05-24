package idw.model.dao.manutencao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtilManutencao {
	
	private static SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            sessionFactory = new AnnotationConfiguration()  
                             .configure("hibernateManutencao.cfg.xml")  
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

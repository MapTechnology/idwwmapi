package idw.model.dao.aoikyzl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtilAoiKyZl {
	
	private final SessionFactory sessionFactory;
	
	@SuppressWarnings("deprecation")
	public HibernateUtilAoiKyZl(String teste) {
		
		 try {
           
       	
           sessionFactory = new AnnotationConfiguration()  
                            .configure(teste+".cfg.xml")  
                           .buildSessionFactory();
       } catch (Throwable ex) {
       	ex.printStackTrace();
           
          System.err.println("Initial SessionFactory creation failed." + ex);
           throw new ExceptionInInitializerError(ex);
       }
		
	}
	

//    static {
//        try {
//            // Create the SessionFactory from hibernateagramkow.cfg.xml
//        	//Usou-se o hibernate agramkow pois o hibernate aoikyzl não estava sendo encontrado
//            sessionFactory = new AnnotationConfiguration()  
//                             .configure("hibernateagramkow.cfg.xml")  
//                             .buildSessionFactory();
//        } catch (Throwable ex) {
//        	ex.printStackTrace();
//            // Make sure you log the exception, as it might be swallowed
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
            
    
}

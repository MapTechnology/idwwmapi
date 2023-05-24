package idw.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import idw.model.dao.interceptor.AuditorInterceptor;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    private static String HIBERNATE_CFG = "hibernate.cfg.xml";
    
    static {
        try {
        	// A linha abaixo foi comentada, pq o metodo esta depracated
            //sessionFactory = new AnnotationConfiguration().configure(HIBERNATE_CFG).buildSessionFactory();
        	
        	/* Em geral o trecho abaixo ate sessionFactor é o normalmente usado para acesso
        	 * ao banco. Foi comentado pq esta depracated
        	Configuration conf = new Configuration();
        	// A linha abaixo pode ser descomentada qdo se desejar um interceptor nos eventos de pesquisa delete insert etc
        	conf.setInterceptor(new AuditorInterceptor());
        	sessionFactory = conf.configure(HIBERNATE_CFG).buildSessionFactory();
        	 */
        	
        	
        	Configuration configuration = new Configuration();
        	// Descomentar a linha abaixo para ativar o Interceptor do Hibernate
//        	configuration.setInterceptor(new AuditorInterceptor());
        	
            configuration.configure(HIBERNATE_CFG);
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
        	ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
//    public static Statistics getStatistics() {
//        if (!sessionFactory.getStatistics().isStatisticsEnabled()) {
//        	sessionFactory.getStatistics().setStatisticsEnabled(true);
//        }
//        return sessionFactory.getStatistics();
//     }

}

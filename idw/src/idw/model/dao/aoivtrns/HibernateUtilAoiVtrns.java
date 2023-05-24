package idw.model.dao.aoivtrns;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtilAoiVtrns {
	private static final SessionFactory sessionFactory;

	private static String HIBERNATE_CFG = "hibernateaoivtrns.cfg.xml";

	static {
		try {
			Configuration configuration = new Configuration();

			configuration.configure(HIBERNATE_CFG);
			ServiceRegistry serviceRegistry =
					new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

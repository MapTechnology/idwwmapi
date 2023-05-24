package idw.model.dao.erp;

import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;

public class DAOGenericoErp extends AbstractDAOGenerico{
	@Override
	protected SessionFactory getSessionFactory(){
    	return HibernateUtilErp.getSessionFactory();
    }
}

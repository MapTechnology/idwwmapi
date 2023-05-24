package idw.model.dao.cck;


import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;


public class DAOGenericoCck extends AbstractDAOGenerico {

	@Override
	protected SessionFactory getSessionFactory(){
    	return HibernateUtilCck.getSessionFactory();
    }

	public DAOGenericoCck getDao(){
		return this;
	}

	public void setDao(DAOGenericoCck dao){
		this.setSession(dao.getSession());
	}
}

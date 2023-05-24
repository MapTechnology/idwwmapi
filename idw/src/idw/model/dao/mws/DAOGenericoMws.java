package idw.model.dao.mws;

import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;

public class DAOGenericoMws extends AbstractDAOGenerico {

	@Override
	protected SessionFactory getSessionFactory() {
		return HibernateUtilMws.getSessionFactory();
	}
	public DAOGenericoMws getDao(){
		return this;
	}
	
	public void setDao(DAOGenericoMws dao){
		this.setSession(dao.getSession());
	}

}

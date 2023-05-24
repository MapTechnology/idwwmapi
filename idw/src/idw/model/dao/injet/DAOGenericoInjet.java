package idw.model.dao.injet;

import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;

public class DAOGenericoInjet extends AbstractDAOGenerico {

	@Override
	protected SessionFactory getSessionFactory() {
		return HibernateUtilInjet.getSessionFactory();
	}
	public DAOGenericoInjet getDao(){
		return this;
	}
	
	public void setDao(DAOGenericoInjet dao){
		this.setSession(dao.getSession());
	}

}

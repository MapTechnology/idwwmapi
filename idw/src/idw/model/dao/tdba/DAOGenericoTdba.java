package idw.model.dao.tdba;

import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;

public class DAOGenericoTdba extends AbstractDAOGenerico {

	@Override
	protected SessionFactory getSessionFactory() {
		return HibernateUtilTdba.getSessionFactory();
	}
	public DAOGenericoTdba getDao(){
		return this;
	}
	
	public void setDao(DAOGenericoTdba dao){
		this.setSession(dao.getSession());
	}

}

package idw.model.dao.aoivtrns;


import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;


public class DAOGenericoAoiVtrns extends AbstractDAOGenerico {

	@Override
	protected SessionFactory getSessionFactory(){
    	return HibernateUtilAoiVtrns.getSessionFactory();
    }


	public DAOGenericoAoiVtrns getDaoAoiVtrns(){
		return this;
	}

	public void setDao(DAOGenericoAoiVtrns dao){
		this.setSession(dao.getSession());
	}
}

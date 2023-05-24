package idw.model.dao.agramkow;

import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;

public class DAOGenericoAgramkow extends AbstractDAOGenerico {

	@Override
	protected SessionFactory getSessionFactory() {
		return HibernateUtilAgramkow.getSessionFactory();
	}
	public DAOGenericoAgramkow getDao(){
		return this;
	}
	
	public void setDao(DAOGenericoAgramkow dao){
		this.setSession(dao.getSession());
	}

}

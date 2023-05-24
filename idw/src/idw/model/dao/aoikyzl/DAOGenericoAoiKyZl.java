package idw.model.dao.aoikyzl;

import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;

public class DAOGenericoAoiKyZl extends AbstractDAOGenerico {
	private  HibernateUtilAoiKyZl hibernateUtil ;
	
	public DAOGenericoAoiKyZl(String url){
		hibernateUtil = new HibernateUtilAoiKyZl(url);
	}
	
	public DAOGenericoAoiKyZl(){
		
		
	}

	@Override
	protected SessionFactory getSessionFactory() {
		return hibernateUtil.getSessionFactory();
	}
	public DAOGenericoAoiKyZl getDao(){
		return this;
	}
	
	public void setDao(DAOGenericoAoiKyZl dao){
		this.setSession(dao.getSession());
	}

}

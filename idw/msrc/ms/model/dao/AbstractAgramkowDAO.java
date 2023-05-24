package ms.model.dao;

import org.hibernate.Session;

import idw.model.dao.IDao;
import idw.model.dao.agramkow.DAOGenericoAgramkow;

public abstract class AbstractAgramkowDAO implements IDao {
	private DAOGenericoAgramkow daoAgramkow = null;
	
	public AbstractAgramkowDAO() {		
		if(daoAgramkow == null){
			daoAgramkow = new DAOGenericoAgramkow();
		}
	}
	public AbstractAgramkowDAO(DAOGenericoAgramkow daoAgramkow) {
		this.daoAgramkow = daoAgramkow;
	}
	public void iniciaConexaoBanco(){
		iniciaConexaoBanco(null);
	}
	
	@Override
	public void iniciaConexaoBanco(Session sessao){	
		daoAgramkow.iniciaSessao();
		daoAgramkow.iniciaTransacao();
	}
	@Override
	public void finalizaConexaoBanco(){
		try {
			daoAgramkow.finalizaTransacao();
			daoAgramkow.finalizaSessao();
		} catch (Exception e){
		}		
	}
	
	public DAOGenericoAgramkow getDaoAgramkow() {
		return daoAgramkow;
	}
	public void setDaoAgramkow(DAOGenericoAgramkow daoAgramkow){
		this.daoAgramkow = daoAgramkow;
	}
}

package idw.model.rn;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import idw.model.dao.AbstractDAOGenerico;
import idw.model.dao.IDao;

public abstract class AbstractRN<T extends AbstractDAOGenerico> implements IDao {
	private T dao;

	public AbstractRN(T dao){		
		this.dao = dao;
	}

	public T getDao(){
		return this.dao;
	}

	public void setDao(T dao){
		this.dao = dao;
	}

	public Session getDaoSession(){
		return this.getDao().getSession();
	}

	public StatelessSession getDaoSessionStatless(){
		return this.getDao().getSessionStateless();
	}

	public void setDaoSession(Session session){
		this.getDao().setSession(session);
	}

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}
	
	public void iniciaConexaoBancoStatless() {
		iniciaConexaoBancoStatless(null);
	}


	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.getDao().iniciaSessao();
		this.getDao().iniciaTransacao();
	}
	
	public void iniciaConexaoBancoStatless(Session sessao) {
		this.getDao().iniciaSessaoStateless();
		this.getDao().iniciaTransacaoStateless();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.getDao().finalizaTransacao();
		this.getDao().finalizaSessao();
	}
	
	public void finalizaConexaoBancoStatless() {
		this.getDao().finalizaTransacaoStateless();
		this.getDao().finalizaSessaoStateless();
	}
	
	public void rollbackTransacao(){
		this.getDao().rollBackTransacao();
	}
}

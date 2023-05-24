package ms.model.dao;

import org.hibernate.Session;

import idw.model.dao.IDao;
import idw.model.dao.injet.DAOGenericoInjet;

public abstract class AbstractInjetDAO implements IDao {
	private DAOGenericoInjet daoInjet = null;
	
	public AbstractInjetDAO() {		
		if(daoInjet == null){
			daoInjet = new DAOGenericoInjet();
		}
	}
	public AbstractInjetDAO(DAOGenericoInjet daoInjet) {
		this.daoInjet = daoInjet;
	}
	public void iniciaConexaoBanco(){
		iniciaConexaoBanco(null);
	}
	
	@Override
	public void iniciaConexaoBanco(Session sessao){	
		daoInjet.iniciaSessao();
		daoInjet.iniciaTransacao();
	}
	@Override
	public void finalizaConexaoBanco(){
		try {
			daoInjet.finalizaTransacao();
			daoInjet.finalizaSessao();
		} catch (Exception e){
		}		
	}
	
	public DAOGenericoInjet getDaoInjet() {
		return daoInjet;
	}
	public void setDaoInjet(DAOGenericoInjet daoInjet){
		this.daoInjet = daoInjet;
	}
}

package ms.model.dao;

import org.hibernate.Session;

import idw.model.dao.IDao;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.mws.DAOGenericoMws;
import idw.model.dao.tdba.DAOGenericoTdba;

public abstract class AbstractMwsTdbaInjetDAO implements IDao {
	private DAOGenericoTdba daoTdba = null;
	private DAOGenericoMws daoMws = null;
	private DAOGenericoInjet daoInjet = null;
	
	public AbstractMwsTdbaInjetDAO() {
		if(daoTdba == null) {
			daoTdba = new DAOGenericoTdba();
		}
		if(daoMws == null){
			daoMws = new DAOGenericoMws();
		}
		if(daoInjet == null){
			daoInjet = new DAOGenericoInjet();
		}
	}
	public AbstractMwsTdbaInjetDAO(DAOGenericoMws daoMws,DAOGenericoTdba daoTdba, DAOGenericoInjet daoInjet) {
		this.daoTdba = daoTdba;
		this.daoMws = daoMws;
		this.daoInjet = daoInjet;
	}
	public void iniciaConexaoBanco(){
		iniciaConexaoBanco(null);
	}
	@Override
	public void iniciaConexaoBanco(Session sessao){	
		daoTdba.iniciaSessao();
		daoTdba.iniciaTransacao();
		
		daoMws.iniciaSessao();
		daoMws.iniciaTransacao();
		
		daoInjet.iniciaSessao();
		daoInjet.iniciaTransacao();
		
	}
	@Override
	public void finalizaConexaoBanco(){
		try {
			daoTdba.finalizaTransacao();
			daoTdba.finalizaSessao();
		} catch (Exception e){
		}
		try {
			daoMws.finalizaTransacao();
			daoMws.finalizaSessao();
		} catch (Exception e){
		}		
		try{
			daoInjet.finalizaTransacao();
			daoInjet.finalizaSessao();
		}catch(Exception e){
			
		}
	}
	public DAOGenericoTdba getDaoTdba() {
		return daoTdba;
	}
	public void setDaoTdba(DAOGenericoTdba daoTdba){
		this.daoTdba = daoTdba;
	}
	
	public DAOGenericoMws getDaoMws() {
		return daoMws;
	}
	public void setDaoMws(DAOGenericoMws daoMws){
		this.daoMws = daoMws;
	}
	public DAOGenericoInjet getDaoInjet(){
		return daoInjet;
	}
	public void setDaoInjet(DAOGenericoInjet daoInjet){
		this.daoInjet = daoInjet;
	}
}

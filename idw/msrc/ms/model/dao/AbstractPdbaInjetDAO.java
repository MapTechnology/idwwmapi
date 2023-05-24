package ms.model.dao;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public abstract class AbstractPdbaInjetDAO implements IDao {
	private DAOGenerico daoPdba = null;
	private DAOGenericoInjet daoInjet = null;
	
	public AbstractPdbaInjetDAO() {
		if(daoPdba == null) {
			daoPdba = new DAOGenerico();
		}
		if(daoInjet == null){
			daoInjet = new DAOGenericoInjet();
		}
	}
	public AbstractPdbaInjetDAO(DAOGenericoInjet daoInjet,DAOGenerico daoPdba) {
		this.daoPdba = daoPdba;
		this.daoInjet = daoInjet;
	}
	
	public void iniciaConexaoBanco(){
		iniciaConexaoBanco(null);
	}
	
	@Override
	public void iniciaConexaoBanco(Session sessao){	
		daoPdba.iniciaSessao();
		daoPdba.iniciaTransacao();
		daoInjet.iniciaSessao();
		daoInjet.iniciaTransacao();
	}
	public void iniciaConexaoBanco(IdwLogger log, int idLog){	
		daoPdba.iniciaSessao(log, idLog);
		daoPdba.iniciaTransacao();
		daoInjet.iniciaSessao();
		daoInjet.iniciaTransacao();
	}
	@Override
	public void finalizaConexaoBanco(){
		try {
			daoPdba.finalizaTransacao();
			daoPdba.finalizaSessao();
		} catch (Exception e){
		}
		try {
			daoInjet.finalizaTransacao();
			daoInjet.finalizaSessao();
		} catch (Exception e){
		}		
	}
	public void finalizaConexaoBanco(IdwLogger log, int idLog) throws SemSGBDException{
		try {
			daoPdba.finalizaTransacao(log, idLog);
			daoPdba.finalizaSessao(log, idLog);
		} catch (Exception e){
			log.info("erro no pdba", e);
			throw new SemSGBDException();
		}
		try {
			daoInjet.finalizaTransacao(log, idLog);
			daoInjet.finalizaSessao(log, idLog);
		} catch (Exception e){
			log.info("erro no injet", e);
		}		
	}
	public DAOGenerico getDaoPdba() {
		return daoPdba;
	}
	public void setDaoPdba(DAOGenerico daoPdba){
		this.daoPdba = daoPdba;
	}
	
	public DAOGenericoInjet getDaoInjet() {
		return daoInjet;
	}
	public void setDaoInjet(DAOGenericoInjet daoInjet){
		this.daoInjet = daoInjet;
	}
}

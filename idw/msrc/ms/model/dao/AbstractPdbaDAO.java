package ms.model.dao;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;

public abstract class AbstractPdbaDAO implements IDao {
	private DAOGenerico daoPdba = null;
	
	public AbstractPdbaDAO() {
		if(daoPdba == null) {
			daoPdba = new DAOGenerico();
		}
	}
	public AbstractPdbaDAO(DAOGenerico daoPdba) {
		this.daoPdba = daoPdba;
	}
	@Override
	public void iniciaConexaoBanco(Session sessao){	
		daoPdba.iniciaSessao();
		daoPdba.iniciaTransacao();
	}
	@Override
	public void finalizaConexaoBanco(){
		try {
			daoPdba.finalizaTransacao();
			daoPdba.finalizaSessao();
		} catch (Exception e){
		}
	}
	public DAOGenerico getDaoPdba() {
		return daoPdba;
	}
	public void setDaoPdba(DAOGenerico daoPdba){
		this.daoPdba = daoPdba;
	}
}

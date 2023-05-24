package ms.model.dao;

import org.hibernate.Session;
import idw.model.dao.IDao;
import idw.model.dao.aoikyzl.DAOGenericoAoiKyZl;


public abstract class AbstractAoiKyZlDAO implements IDao {
	
private DAOGenericoAoiKyZl daoAoiKyZl = null;
	
	public AbstractAoiKyZlDAO() {		
		if(daoAoiKyZl == null){
			daoAoiKyZl = new DAOGenericoAoiKyZl();
		}
	}
	public AbstractAoiKyZlDAO(DAOGenericoAoiKyZl daoAoiKyZl) {
		this.daoAoiKyZl = daoAoiKyZl;
	}
	public void iniciaConexaoBanco(){
		iniciaConexaoBanco(null);
	}
	
	@Override
	public void iniciaConexaoBanco(Session sessao){	
		daoAoiKyZl.iniciaSessao();
		daoAoiKyZl.iniciaTransacao();
	}
	@Override
	public void finalizaConexaoBanco(){
		try {
			daoAoiKyZl.finalizaTransacao();
			daoAoiKyZl.finalizaSessao();
		} catch (Exception e){
		}		
	}
	
	public DAOGenericoAoiKyZl getDaoAoiKyZl() {
		return daoAoiKyZl;
	}
	public void setDaoAoiKyZl(DAOGenericoAoiKyZl daoAoiKyZl){
		this.daoAoiKyZl = daoAoiKyZl;
	}


}

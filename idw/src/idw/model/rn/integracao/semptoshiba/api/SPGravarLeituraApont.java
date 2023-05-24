package idw.model.rn.integracao.semptoshiba.api;

import org.hibernate.Query;

import idw.model.dao.StoreProcedure;
import idw.model.dao.erp.DAOGenericoErp;

public final class SPGravarLeituraApont extends StoreProcedure{

	private final static String STORE_PROCEDURE_NAME = "spc_MAPGravarLeituraApont";

	@Override
	public String getName() {
		return STORE_PROCEDURE_NAME;
	}			

	public SPGravarLeituraApont(DAOGenericoErp dao, String numGrim){
		super(dao, numGrim);
	}

	public void execute(){
		Query q = getQuery(); 
		q.executeUpdate();
	}
	
}

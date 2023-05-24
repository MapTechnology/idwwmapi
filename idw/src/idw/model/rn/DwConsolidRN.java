package idw.model.rn;

import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolidDAO;
import idw.model.pojos.DwConsol;

public class DwConsolidRN extends AbstractRN<DAOGenerico> {

	public DwConsolidRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public DwConsolidRN() {
		this(null);
	}
	
	public List<DwConsol> getTodosOmUsrAtivosOrdenadoPorNome(String cdProduto, long idGt, Date dtInicio, Date dtfim) {
		DwConsolidDAO dao = new DwConsolidDAO(getDaoSession());
		return dao.getOeePizza(cdProduto, idGt, dtInicio, dtfim);
	}

}

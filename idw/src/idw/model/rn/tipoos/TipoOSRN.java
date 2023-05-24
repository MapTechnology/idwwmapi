package idw.model.rn.tipoos;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.MmTpos;
import idw.model.rn.AbstractRN;

public class TipoOSRN extends AbstractRN<DAOGenerico> {

	public TipoOSRN() {
		super(new DAOGenerico());
	}
	
	public TipoOSRN(DAOGenerico dao) {
		super(dao);
	}

	public TiposOSDTO pesquisarTiposOs(String valor) {
		TiposOSDTO retorno = new TiposOSDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from MmTpos a");
		q.append("where (a.cdTpos like :cd");
		q.append("or a.dsTpos like :ds)");
		q.append("and a.stAtivo = 1");
		
		q.defineParametro("cd", "%" + valor + "%");
		q.defineParametro("ds", "%" + valor + "%");
		
		List<MmTpos> lista = q.list();
		retorno.setTiposos(new ArrayList<TipoOSDTO>());
		for (MmTpos mmtpos : lista) {
			TipoOSDTO dto = new TipoOSDTO();
			dto.setMmtpos(mmtpos.clone(false));
			retorno.getTiposos().add(dto);
		}
		return retorno;
	}
	
	public MmTpos pesquisarMmTposById(Long id) {
		return (MmTpos) getDao().findById(MmTpos.class, id, false);
	}
}

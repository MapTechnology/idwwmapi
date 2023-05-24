package idw.model.rn.cc;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmCc;
import idw.model.rn.AbstractRN;

public class CcRN extends AbstractRN<DAOGenerico>{

	public CcRN() {
		super(new DAOGenerico());
	}
	
	public CcRN(DAOGenerico dao) {
		super(dao);
	}

	public  CcsDTO getOmCcPorLikeCdDs(String cdCc){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("FROM OmCc t");
		q.append("WHERE (t.cdCc like :cdCc or t.dsCc like :ds)");
		q.append("AND t.stAtivo = :stAtivo");
		q.defineParametro("cdCc", cdCc);
		q.defineParametro("ds", cdCc);
		q.defineParametro("stAtivo", (byte)1);
		List<OmCc> lista = q.list();
		CcsDTO retorno = new CcsDTO();
		retorno.setCcs(new ArrayList<CcDTO>());
		for (OmCc omcc : lista) {
			CcDTO dto =  new CcDTO();
			dto.setOmcc(omcc.clone(false));
			retorno.getCcs().add(dto);
		}
		
		return retorno;
	}


}

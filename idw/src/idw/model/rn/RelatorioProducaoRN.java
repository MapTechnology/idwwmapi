package idw.model.rn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolParam;
import idw.model.pojos.DwConsolid;

/**
 *
 * @author milton
 *
 */
public class RelatorioProducaoRN extends AbstractRN<DAOGenerico> {

	
	public RelatorioProducaoRN(DAOGenerico dao) {
		super(dao);
	}

	public BigDecimal getValores(Date dtInicial, Date dtFinal, String cdMaquina, String cdTurno){
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select a");
		q.append("from DwConsolid a");
		q.append("join fetch a.dwConsols b");
		q.append("join fetch b.dwConsolParams c");
		q.append("join c.dwFtParam d");
		q.append("join a.omPt ompt");
		q.append("where a.tpId = 1");
		q.append("and d.idFtParam = 6");
		q.append("and c.tpReferencia = 0"); // total
		q.append("and ompt.cdPt = :cdpt");
		q.append("and a.dtReferencia between :dti and :dtf");
		if (cdTurno != null && cdTurno.equals("") == false)
			q.append("and a.dwTurno.cdTurno = :idTurno");

		q.defineParametroData("dti", dtInicial);
		q.defineParametroData("dtf", dtFinal);
		q.defineParametro("cdpt", cdMaquina);
		q.defineParametro("idTurno", cdTurno);
		
		List<DwConsolid> lista = q.list();
		
		BigDecimal totalKw = BigDecimal.ZERO;
		for(DwConsolid id : lista){
			for (DwConsol con : id.getDwConsols()) {
				for (DwConsolParam param : con.getDwConsolParams()) {
					totalKw = totalKw.add(param.getVlSomado());
				}
			}
		}
		
		return totalKw;
		
	}
}

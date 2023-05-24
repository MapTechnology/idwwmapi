package idw.model.dao;

import idw.model.pojos.DwConsolpa;
import idw.model.rn.DataHoraRN;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class DwConsolpaDAO {
	
	private final MapQuery q;

    public DwConsolpaDAO(Session session) {
        q = new MapQuery(session);
    }
    
    public List<DwConsolpa> getParadasPizza(String cdProduto, long idGt, Date dtInicio, Date dtfim) {
		q.append("SELECT dwConsolpa");
		q.append("FROM DwConsolpa dwConsolpa");
		q.append("INNER JOIN dwConsolpa.dwTParada dwTParada");
		q.append("LEFT JOIN dwTParada.dwTArea dwTArea");
		q.append("WHERE dwConsolpa.dwConsol IN");
		q.append("(");
		q.append("SELECT dwConsol");
		q.append("FROM DwConsol dwConsol");
		q.append("INNER JOIN dwConsol.dwConsolid dwConsolid");
		q.append("INNER JOIN dwConsol.dwConsolprs dwConsolpr");
		q.append("INNER JOIN dwConsolpr.omProduto omProduto");
		q.append("INNER JOIN dwConsolid.omPt omPt");
		q.append("INNER JOIN omPt.omGt omGt");
		q.append("INNER JOIN dwConsolid.dwTurno dwTurno");
		q.append("INNER JOIN dwConsolid.dwPepro dwPepro");
		q.append("WHERE dwConsolid.stAtivo IS NULL");
		q.append("AND dwTurno.idTurno <> 1");
		q.append("AND dwConsolid.tpId = 1");
		q.append("AND dwPepro.idPepro = 1");
		q.append("AND omProduto.cdProduto = :cdProduto");
		q.append("AND omProduto.stAtivo = 1");
		q.append("AND dwConsolid.omGt IS NULL");
		q.append("AND omGt.idGt = :idGt");
		q.append("AND dwConsolid.dtReferencia BETWEEN :dtInicio AND :dtfim");
		q.append(")");

		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("idGt", idGt);
		q.defineParametroData("dtInicio", DataHoraRN.getDataSemHora(dtInicio));
		q.defineParametroData("dtfim", DataHoraRN.getDataSemHora(dtfim));

		return q.list();
	}
    
    public List<DwConsolpa> getParadasBarra(String cdProduto, Long idGt, Long idArea, Date dtInicio, Date dtfim) {
		q.append("SELECT dwConsolpa");
		q.append("FROM DwConsolpa dwConsolpa");
		q.append("INNER JOIN dwConsolpa.dwTParada dwTParada");
		q.append("LEFT JOIN dwTParada.dwTArea dwTArea");
		q.append("WHERE dwConsolpa.dwConsol IN");
		q.append("(");
		q.append("SELECT dwConsol");
		q.append("FROM DwConsol dwConsol");
		q.append("INNER JOIN dwConsol.dwConsolid dwConsolid");
		q.append("INNER JOIN dwConsol.dwConsolprs dwConsolpr");
		q.append("INNER JOIN dwConsolpr.omProduto omProduto");
		q.append("INNER JOIN dwConsolid.omPt omPt");
		q.append("INNER JOIN omPt.omGt omGt");
		q.append("INNER JOIN dwConsolid.dwTurno dwTurno");
		q.append("INNER JOIN dwConsolid.dwPepro dwPepro");
		q.append("WHERE dwConsolid.stAtivo IS NULL");
		q.append("AND dwTurno.idTurno <> 1");
		q.append("AND dwConsolid.tpId = 1");
		q.append("AND dwPepro.idPepro = 1");
		q.append("AND omProduto.cdProduto = :cdProduto");
		q.append("AND omProduto.stAtivo = 1");
		q.append("AND dwConsolid.omGt IS NULL");
		q.append("AND omGt.idGt = :idGt");
		q.append("AND dwConsolid.dtReferencia BETWEEN :dtInicio AND :dtfim");
		q.append(")");
		
		if(idArea == null) {
			q.append("AND dwTArea.cdArea IS NULL");
		} else {
			q.append("AND dwTArea.idArea = :idArea");
		}
		q.append("ORDER BY dwConsolpa.segAutoTempoparadaCp DESC");

		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("idGt", idGt);
		q.defineParametro("idArea", idArea);
		q.defineParametroData("dtInicio", DataHoraRN.getDataSemHora(dtInicio));
		q.defineParametroData("dtfim", DataHoraRN.getDataSemHora(dtfim));

		return q.list();
	}

}

package idw.model.dao;

import idw.model.pojos.DwRtcic;
import idw.model.rn.DataHoraRN;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class DwRtCicDAO {
	
	private final MapQuery q;

    public DwRtCicDAO(Session session) {
        q = new MapQuery(session);
    }
    
    public List<DwRtcic> getCiclosBarra(String cdProduto, long idGt, Date dtInicio, Date dtfim) {
		q.append("SELECT dwRtcic");
		q.append("FROM DwRtcic dwRtcic");
		q.append("WHERE dwRtcic.dwRt IN");
		q.append("(");
		q.append("SELECT dwConsolid");
		q.append("FROM DwConsolid dwConsolid");
		q.append("INNER JOIN dwConsolid.dwConsols dwConsol");
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
		q.append("ORDER BY dwRtcic.dthrIciclo DESC");

		q.defineParametro("cdProduto", cdProduto);
		q.defineParametro("idGt", idGt);
		q.defineParametroData("dtInicio", DataHoraRN.getDataSemHora(dtInicio));
		q.defineParametroData("dtfim", DataHoraRN.getDataSemHora(dtfim));
		
		q.setMaxResults(50);

		return q.list();
	}

}

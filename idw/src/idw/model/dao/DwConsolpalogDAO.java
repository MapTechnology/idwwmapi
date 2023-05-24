package idw.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.DataHoraRN;
import idw.util.SQLUtils;

public class DwConsolpalogDAO {
	private final Session session;
	
	public DwConsolpalogDAO(Session session) {
		this.session = session;
	}
	
	public List<DwConsolpalog> getParadasFechadasNoPeriodo(OmPt omPt, Date dtHrInicio, Date dtHrFimFim) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolpalog FROM DwConsolpalog dwConsolpalog");
		q.append("WHERE dwConsolpalog.omPt = :omPt");
		q.append("AND ");
		q.append(SQLUtils.getSQLDentroPeriodo("dwConsolpalog.dthrIparada", "dwConsolpalog.dthrFparada", ":dthrI", ":dthrF"));
		q.append("ORDER BY dwConsolpalog.idConsolpalog");
		q.defineParametro("omPt", omPt);
		q.defineParametro("dthrI", dtHrInicio);
		q.defineParametro("dthrF", dtHrFimFim);
		return q.list();
	}
	
	public List<DwConsolpalog> obtemDwConsolpalogPeriodo(long idPt, Date dthrInicio, Date dthrFim, boolean isConsiderarParadaAberta){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolpalog ");
		q.append("FROM DwConsolpalog dwConsolpalog ");
		q.append("WHERE dwConsolpalog.omPt.idPt = :idPt ");		
		q.append("AND (");
		q.append("     (dwConsolpalog.dthrIparada >= :dthrInicio AND dwConsolpalog.dthrIparada <= :dthrFim)");
		q.append("     OR");
		q.append("     (dwConsolpalog.dthrFparada >= :dthrInicio AND dwConsolpalog.dthrFparada <= :dthrFim)");
		q.append("     OR");
		q.append("     (dwConsolpalog.dthrIparada <= :dthrInicio AND dwConsolpalog.dthrFparada >= :dthrFim)");
		q.append("     OR");
		q.append("     (dwConsolpalog.dthrIparada <= :dthrInicio AND dwConsolpalog.dthrFparada IS NULL)");		
		q.append("    )");
		
		if(!isConsiderarParadaAberta){
			q.append(" AND NOT dwConsolpalog.dthrFparada IS NULL");
		}
		q.append("order by dwConsolpalog.idConsolpalog");

		q.defineParametro("idPt", idPt);
		
		q.defineParametroTimestamp("dthrInicio", dthrInicio);
		q.defineParametroTimestamp("dthrFim", dthrFim);
		
		
		List<DwConsolpalog> listDwConsolpalog = q.list();
		
		return(listDwConsolpalog);		
	}

	public DwConsolpalog getUltimaParadaPeriodoComFimParadaDiferenteFimPeriodo(OmPt omPt, PpCp ppCp, Date dthrInicio, Date dthrFim) {
		
		if (DataHoraRN.before(dthrInicio, dthrFim)) {
			MapQuery q = new MapQuery(session);
			q.append("SELECT dwConsolpalog ");
			q.append("FROM DwConsolpalog dwConsolpalog ");
			q.append("WHERE dwConsolpalog.omPt = :omPt ");
			q.append(" AND " + SQLUtils.getSQLDentroPeriodo("dwConsolpalog.dthrIparada", "dwConsolpalog.dthrFparada", ":inicio", ":fim"));
			q.append(" AND (NOT dwConsolpalog.dthrFparada = :fim)");
			q.append(" AND dwConsolpalog.ppCp = :ppCp ");
			q.append(" ORDER BY dwConsolpalog.idConsolpalog DESC");
			q.defineParametro("omPt", omPt);
			q.defineParametroTimestamp("inicio", dthrInicio);
			q.defineParametroTimestamp("fim", dthrFim);
			q.defineParametro("ppCp", ppCp);
			q.setMaxResults(1);
			return (DwConsolpalog) q.uniqueResult();
		}else {
			return null;
		}
		
	}
	
	public List<DwConsolpalog> getParadasAbertas(Long idPt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolpalog ");
		q.append("FROM DwConsolpalog dwConsolpalog ");
		q.append("JOIN dwConsolpalog.omPt omPt ");
		q.append("WHERE omPt.idPt = :idPt ");
		q.append(" AND dwConsolpalog.dthrFparada IS NULL ");
		q.append(" ORDER BY dwConsolpalog.idConsolpalog ");
		q.defineParametro("idPt", idPt);
		return q.list();		
	}
	
}

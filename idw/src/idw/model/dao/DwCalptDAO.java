package idw.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwCalpt;
import idw.model.pojos.OmPt;
import idw.util.SQLUtils;

public class DwCalptDAO {
	private final Session session;
	
	public DwCalptDAO(Session session) {
	
		this.session = session;
	}

	public List<DwCalpt>getDwCalsPtAtivos(OmPt ompt, Date dthrI, Date dthrF) {
		MapQuery q = new MapQuery(session);
//		q.append("SELECT dwcalpt ");
//		q.append("FROM DwCalpt dwcalpt ");
//		q.append("JOIN FETCH dwcalpt.dwCal dwcal ");
//		q.append("JOIN dwcalpt.omPt ompt");
//		if (ompt.getCdPt() != null && ompt.getCdPt().equals("") == false) {
//			q.append("WHERE ompt.cdPt = :cdpt ");
//		} else {
//			q.append("WHERE ompt.idPt = :idpt");
//		}
//		q.append(" AND ");
//		q.append(SQLUtils.getSQLDentroPeriodoConsiderandoAberto("dwcal.dthrIvalidade", "dwcal.dthrFvalidade", ":dthrI", ":dthrF"));
//		q.append("AND dwcal.stAtivo = :stAtivo");
//		q.append("ORDER BY dwcal.dthrIvalidade");

		String hql = getHQLDwCalPtsAtivos(ompt, dthrI, dthrF);
		q.append(hql);
		
		q.defineParametro("cdpt", ompt.getCdPt());
		q.defineParametro("idpt", ompt.getIdPt());
		q.defineParametroTimestamp("dthrI", dthrI);
		q.defineParametroTimestamp("dthrF", dthrF);
		q.defineParametro("stAtivo", new Byte((byte)1));
		
		return q.list();
	}
	
	/**
	 * Pega o primeiro calendário ativo do período para o PT
	 * @param ompt
	 * @param dthrI
	 * @param dthrF
	 * @return
	 */
	public DwCalpt getDwCalPtAtivo(OmPt ompt, Date dthrI, Date dthrF) {
		MapQuery q = new MapQuery(session);
//		q.append("SELECT dwcalpt ");
//		q.append("FROM DwCalpt dwcalpt ");
//		q.append("JOIN FETCH dwcalpt.dwCal dwcal ");
//		q.append("JOIN dwcalpt.omPt ompt");
//		if (ompt.getCdPt() != null && ompt.getCdPt().equals("") == false) {
//			q.append("WHERE ompt.cdPt = :cdpt ");
//		} else {
//			q.append("WHERE ompt.idPt = :idpt");
//		}
//		q.append(" AND ");
//		q.append(SQLUtils.getSQLDentroPeriodoConsiderandoAberto("dwcal.dthrIvalidade", "dwcal.dthrFvalidade", ":dthrI", ":dthrF"));
//		q.append("AND dwcal.stAtivo = :stAtivo");
//		q.append("ORDER BY dwcal.dthrIvalidade");
		
		String hql = getHQLDwCalPtsAtivos(ompt, dthrI, dthrF);
		q.append(hql);
		
		q.defineParametro("cdpt", ompt.getCdPt());
		q.defineParametro("idpt", ompt.getIdPt());
		q.defineParametroTimestamp("dthrI", dthrI);
		q.defineParametroTimestamp("dthrF", dthrF);
		q.defineParametro("stAtivo", new Byte((byte)1));
		q.setMaxResults(1);
		
		return (DwCalpt) q.uniqueResult();
	}
	
	private String getHQLDwCalPtsAtivos(OmPt ompt, Date dthrI, Date dthrF) {
		StringBuilder sb = new StringBuilder()
				.append(" SELECT dwcalpt ")
				.append(" FROM DwCalpt dwcalpt ")
				.append(" JOIN FETCH dwcalpt.dwCal dwcal ")
				.append(" JOIN dwcalpt.omPt ompt ");
		
		if (ompt.getCdPt() != null && ompt.getCdPt().equals("") == false) {
			sb.append(" WHERE ompt.cdPt = :cdpt AND ompt.stAtivo = 1 ");
		} else {
			sb.append(" WHERE ompt.idPt = :idpt ");
		}
		sb.append(" AND ");
		sb.append(SQLUtils.getSQLDentroPeriodoConsiderandoAberto("dwcal.dthrIvalidade", "dwcal.dthrFvalidade", ":dthrI", ":dthrF"));
		sb.append(" AND dwcal.stAtivo = :stAtivo");
		sb.append(" ORDER BY dwcal.dthrIvalidade");
		return sb.toString();
	}
	
}

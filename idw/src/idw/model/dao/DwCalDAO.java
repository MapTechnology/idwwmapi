package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolpalog;

public class DwCalDAO {
	
	private Session session;
	
	public DwCalDAO(Session session){
		this.session = session;
	}
	
	public DwCal getDwCalPorCdAtivo(String cdCal){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwCal dwcal");
		q.append("WHERE dwcal.stAtivo = :stAtivo");
		q.append("AND dwcal.cdCal = :cdcal");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdcal", cdCal);
		q.setMaxResults(1);
		return (DwCal) q.uniqueResult();
	}
	
	public DwCal getDwCalPorId(long idCal){
		MapQuery query = new MapQuery(session);
		query.append("SELECT dwcal");
		query.append("FROM DwCal dwcal");		
		query.append("WHERE dwcal.idCal = :idCal ");
		query.defineParametro("idCal", idCal);
		
		DwCal dwCal = (DwCal) query.uniqueResult();
		return dwCal;
	}

	/**
	 * Pega calendario usado na consolidação da parada, que seja diferente do calendário indefinido 
	 * @param dwConsolpalog
	 * @param dwCalIndefinido
	 * @return
	 */
	public DwCal getDwCalFromDwConsolpalog(DwConsolpalog dwConsolpalog, DwCal dwCalIndefinido) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwCal FROM DwConsolpaoco dwConsolpaoco");
		q.append("JOIN dwConsolpaoco.dwConsolpa dwConsolpa");
		q.append("JOIN dwConsolpa.dwConsol dwConsol");
		q.append("JOIN dwConsol.dwConsolid dwConsolid");
		q.append("JOIN dwConsolid.dwCal dwCal");
		q.append("WHERE dwConsolpaoco.dwConsolpalog = :dwConsolpalog");
		q.append("AND dwConsolid.dwCal <> :dwCalIndefinido");
		q.append("ORDER BY dwConsolpaoco.idConsolpaoco");
		q.defineParametro("dwConsolpalog", dwConsolpalog);
		q.defineParametro("dwCalIndefinido", dwCalIndefinido);
		q.setMaxResults(1);
		return (DwCal) q.uniqueResult();
	}
	
	
}

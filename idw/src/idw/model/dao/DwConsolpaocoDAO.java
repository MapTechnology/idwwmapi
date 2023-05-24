package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTParada;

public class DwConsolpaocoDAO {
	private final Session session;
	
	public DwConsolpaocoDAO(Session session){
		this.session = session;
	}
	
	public DwConsolpaoco getDwConsolpaoco(DwConsol dwConsol, DwTParada dwTParada, DwConsolpalog dwConsolpalog){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolpaoco FROM DwConsolpaoco dwConsolpaoco");
		q.append("JOIN FETCH dwConsolpaoco.dwConsolpa dwConsolpa");
		q.append("JOIN dwConsolpa.dwTParada dwTParada");		
		q.append("WHERE dwConsolpa.dwConsol = :dwConsol");
		q.append("and dwConsolpa.dwTParada = :dwTParada");
		q.append("and dwConsolpaoco.dwConsolpalog = :dwConsolpalog");
		q.defineParametro("dwConsol", dwConsol);
		q.defineParametro("dwTParada", dwTParada);
		q.defineParametro("dwConsolpalog", dwConsolpalog);
		q.setMaxResults(1);
		return (DwConsolpaoco) q.uniqueResult();
	}
	
}

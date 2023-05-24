package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRapGrupo;

public class DwRapGrupoDAO {
	
	private final Session session;
	
	public DwRapGrupoDAO(Session session){
		this.session = session;
	}
	
	public DwRapGrupo getDwRapGrupo(DwGrupoFerramenta dwgrupo, DwRap dwrap) {
		MapQuery q = new MapQuery(session);		
		q.append("SELECT a");
		q.append("FROM DwRapGrupo a");
		q.append("WHERE a.dwRap = :dwrap");
		q.append("AND a.dwGrupoFerramenta = :dwgrupo");
		q.defineParametro("dwrap", dwrap);
		q.defineParametro("dwgrupo", dwgrupo);		
		q.setMaxResults(1);		
		return (DwRapGrupo) q.uniqueResult();
	}
	
	public List<DwRap> getRapsDoGrupoRap(DwGrupoFerramenta grupo) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT rap");
		q.append("FROM DwRapGrupo a");
		q.append("JOIN a.dwRap rap");
		q.append("WHERE a.dwGrupoFerramenta.cdGrupoFerramenta = :cdgrupo");
		q.append("and rap.stAtivo = 1");
		q.append("ORDER BY rap.cdRap");
		q.defineParametro("cdgrupo", grupo.getCdGrupoFerramenta());
		return q.list();
	}

}

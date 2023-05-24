package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwRt;
import idw.model.pojos.OmPt;

public class DwRtDAO {
	private final Session session;
	
	public DwRtDAO(Session session){
		this.session = session;
	}
	
	public DwRt getUltimoDwRtDoIdPt(Long idPt) {
		OmPtDAO daopt = new OmPtDAO(session);
		OmPt ompt = daopt.getOmPtPorId(idPt);

		MapQuery q = new MapQuery(session);
		q.append("SELECT dwrt ");
		q.append("FROM DwRt dwrt ");
		q.append("where dwrt.omPt.idPt = :idPt ");
		if (ompt != null && ompt.getPpCp() != null)
			q.append("and dwrt.ppCp = :ppcp");

		q.append("ORDER BY dwrt.idRt DESC");
		q.defineParametro("idPt", idPt);
		if (ompt != null && ompt.getPpCp() != null)
			q.defineParametro("ppcp", ompt.getPpCp());
		q.setMaxResults(1);
		return(DwRt) q.uniqueResult();
	}
	
	public DwRt getUltimoDwRtDoCdPt(String cdPt) {
		OmPtDAO daopt = new OmPtDAO(session);
		OmPt ompt = daopt.getOmPtPorCdAtivoOrderById(cdPt);
		
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwrt ");
		q.append("FROM DwRt dwrt ");
		q.append("join dwrt.omPt ompt");
		q.append("where ompt.cdPt = :cdPt ");
		if (ompt != null && ompt.getPpCp() != null)
			q.append("and dwrt.ppCp = :ppcp");
		
		q.append("ORDER BY dwrt.idRt DESC");
		q.defineParametro("cdPt", cdPt);
		if (ompt != null && ompt.getPpCp() != null)
			q.defineParametro("ppcp", ompt.getPpCp());
		
		q.setMaxResults(1);
		return(DwRt) q.uniqueResult();
	}	
	
}

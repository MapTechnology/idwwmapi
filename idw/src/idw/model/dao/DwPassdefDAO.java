package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwPassdef;

public class DwPassdefDAO {
	private final Session session;

	public DwPassdefDAO(Session session) {
		this.session = session;
	}

	public List<DwPassdef> getDwPassdefDwConsolid(Long idConsolid) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT dwPassdef FROM DwPassdef dwPassdef");
		q.append("JOIN FETCH dwPassdef.dwPassagem dwPassagem");
		q.append("JOIN FETCH dwPassagem.dwConsolid dwConsolid");
		q.append("JOIN dwConsolid.omPt omPt");
		q.append("JOIN omPt.omGt omGt");
		q.append("WHERE dwConsolid.idConsolid = :idConsolid");

		q.defineParametro("idConsolid", idConsolid);

		return q.list();
	}

}

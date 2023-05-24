package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwTArea;

public class DwTAreaDAO {
	
	private Session session;

	public DwTAreaDAO(Session session) {
		this.session = session;
	}
	
	public List<DwTArea> getAreasAtivas() {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwTArea t ");
		q.append("WHERE t.stAtivo = :stAtivo");
		q.defineParametro("stAtivo", (byte)1);
		return q.list();
	}
	
}
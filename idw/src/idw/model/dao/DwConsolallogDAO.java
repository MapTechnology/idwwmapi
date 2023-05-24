package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwConsolallog;

public class DwConsolallogDAO {
	
	private Session session;

	public DwConsolallogDAO(Session session) {
		this.session = session;
	}
	
	public DwConsolallog getDwConsolallogPorId(Long id){
		MapQuery q = new MapQuery(session);
		q.append("SELECT c");
		q.append("FROM DwConsolallog c");
		q.append("WHERE c.idConsolallog = :id");
		q.defineParametro("id", id);
		return (DwConsolallog) q.uniqueResult();
		
	}

}

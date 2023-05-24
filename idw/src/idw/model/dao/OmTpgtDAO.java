package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.OmTpgt;

public class OmTpgtDAO {
	
	private Session session;
	
	public OmTpgtDAO(Session session){
		this.session = session;
	}
	
	public OmTpgt getOmTpgtPorCdAtivoOrderById(String cdTpgt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmTpgt t");
		q.append("WHERE t.cdTpgt = :cdTpgt");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idTpgt");
		q.defineParametro("cdTpgt", cdTpgt);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmTpgt) q.uniqueResult();
	}

}

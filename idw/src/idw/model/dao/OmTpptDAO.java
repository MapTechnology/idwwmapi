package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.OmTppt;

public class OmTpptDAO {

	private Session session;
	
	public OmTpptDAO(Session session){
		this.session = session;
	}
	
	public OmTppt getOmTpptPorCdAtivoOrderById(String cdTppt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmTppt t");
		q.append("WHERE t.cdTppt = :cdTppt");		
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idTppt");
		q.defineParametro("cdTppt", cdTppt);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmTppt) q.uniqueResult();
	}
	
}

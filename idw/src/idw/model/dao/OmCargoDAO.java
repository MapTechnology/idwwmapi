package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.OmCargo;

public class OmCargoDAO {
	
	private Session session;
	
	public OmCargoDAO(Session session){
		this.session = session;
	}
	
	public OmCargo getOmCargoOrderById(String cdCargo){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmCargo t");
		q.append("WHERE t.cdCargo = :cdCargo");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idCargo");
		q.defineParametro("cdCargo", cdCargo);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmCargo) q.uniqueResult();
	}

}

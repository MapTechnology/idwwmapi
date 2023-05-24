package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.OmCc;

public class OmCcDAO {
	
	private Session session;
	
	public OmCcDAO(Session session){
		this.session = session;
	}
	
	public OmCc getOmCcPorCdAtivoOrderById(String cdCc){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmCc t");
		q.append("WHERE t.cdCc = :cdCc");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idCc");
		q.defineParametro("cdCc", cdCc);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmCc) q.uniqueResult();
	}

	
}

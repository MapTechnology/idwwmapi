package idw.model.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.MsIc;

public class MsIcDAO {
	
	private Session session;
	
	public MsIcDAO(Session session){
		this.session = session;
	}
	
	public MsIc getMsIc(int idIc){
		MapQuery q = new MapQuery(session);
		q.append("FROM MsIc msic");
		q.append("WHERE msic.idIc = :idic");
		q.defineParametro("idic", new BigDecimal(idIc));
		return (MsIc) q.uniqueResult();
	}
	
	public List<MsIc> getMsIcsStandalone(int tpIc) {
		MapQuery q = new MapQuery(session);
		q.append("FROM MsIc ic");
		q.append("WHERE ic.stAtivo = :stAtivo");
		q.append("AND ic.tpIc = :tpIc");
		q.defineParametro("stAtivo", BigDecimal.ONE);
		q.defineParametro("tpIc", new BigDecimal(tpIc));
		return q.list();
	}

}

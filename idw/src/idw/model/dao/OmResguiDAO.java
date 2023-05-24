package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.OmResgui;

public class OmResguiDAO {
	
	private Session session;
	
	public OmResguiDAO(Session session){
		this.session = session;
	}
	
	public OmResgui getOmResguiPorId(long idResgui){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmResgui t ");
		q.append("WHERE t.idResgui = :idResgui");
		q.defineParametro("idResgui", idResgui);
		return (OmResgui) q.uniqueResult();
	}
	
	public OmResgui getOmResguiPorCdAtivoOrderById(String cdResgui){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmResgui t");
		q.append("WHERE t.cdResgui = :cdResgui");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idResgui");
		q.defineParametro("cdResgui", cdResgui);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmResgui) q.uniqueResult();
	}
	
	public OmResgui getOmResguiPorCd(String cdResgui){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmResgui t ");
		q.append("WHERE t.cdResgui = :cdResgui");
		q.defineParametro("cdResgui", cdResgui);
		q.setMaxResults(1);
		return (OmResgui) q.uniqueResult();
	}

}

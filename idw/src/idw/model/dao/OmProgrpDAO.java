package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmProgrp;

public class OmProgrpDAO {
	
	private final Session session;
	
	public OmProgrpDAO(Session session) {
		this.session = session;
	}
	
	public List<OmProgrp> getTodosOmProgrpExcetoPadrao(){
		MapQuery query = new MapQuery(session);
		query.append("FROM OmProgrp omProgrp");
		query.append("WHERE omProgrp.idProgrp <> :idProgrp ");
		query.defineParametro("idProgrp", (long) 1);
		return query.list();
	}
	
	public OmProgrp getOmProgrpPorCdAtivoOrderById(String cdProgrp){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmProgrp t");
		q.append("WHERE t.cdProgrp = :cdProgrp");
		q.append("AND t.stAtivo = :stAtivo");
		q.append("ORDER BY t.idProgrp");
		q.defineParametro("cdProgrp", cdProgrp);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmProgrp) q.uniqueResult();
	}
	
}

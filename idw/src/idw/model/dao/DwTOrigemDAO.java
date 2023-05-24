package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwTOrigem;

public class DwTOrigemDAO {

	private Session session;
	
	public DwTOrigemDAO(Session session){
		this.session = session;
	}
	
	public List<DwTOrigem> getOrigemAtivas(String cdOrigem, String dsOrigem, String cdtppt){
		
		MapQuery q = new MapQuery(session);
		
		q.append("select origem");
		q.append("FROM DwTOrigem origem");
		q.append("join fetch origem.omTppt omtppt");
		q.append("WHERE origem.stAtivo = :stAtivo");
		
		if (!cdOrigem.equals("") && !dsOrigem.equals("")) {
			q.append("AND origem.cdTorigem = :cdOrigem OR origem.dsTorigem = :dsOrigem");
		} else if (!cdOrigem.equals("")) {
			q.append("AND origem.cdTorigem = :cdOrigem");
		} else if (!dsOrigem.equals("")) {
			q.append("AND origem.dsTorigem = :dsOrigem");
		}
		if (cdtppt != null && cdtppt.equals("") == false) {
			q.append("and omtppt.cdTppt = :cdtppt");
		}
		
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdOrigem", cdOrigem);
		q.defineParametro("dsOrigem", dsOrigem);
		q.defineParametro("cdtppt", cdtppt);
		
		return q.list();
	
	}
	
	public DwTOrigem getDwTOrigemPorCdAtivo(String cdTorigem){
		
		MapQuery q = new MapQuery(session);
		
		q.append("FROM DwTOrigem origem");
		q.append("WHERE origem.cdTorigem = :cdTorigem");
		q.append("AND origem.stAtivo = :stAtivo");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdTorigem", cdTorigem);
		
		return (DwTOrigem) q.uniqueResult();
	
	}

}

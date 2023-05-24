package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.OmCfg;

public class OmCfgDAO {
	
	private Session session;
	
	public OmCfgDAO(Session session){
		this.session = session;
	}

	public OmCfg getOmCfgPorId(long idCfg){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmCfg omcfg");
		q.append("WHERE omcfg.idCfg = :idcfg");
		q.defineParametro("idcfg", idCfg);
		return (OmCfg) q.uniqueResult();
	}
	
	public OmCfg getConfigGeral(){
		MapQuery q = new MapQuery(session);
		q.append("SELECT omcfg ");
		q.append("FROM OmCfg omcfg ");
		q.append("WHERE omcfg.stAtivo = :stAtivo ");
		q.defineParametro("stAtivo", (byte) 1);
		q.setMaxResults(1);
//		q.query().setTimeout(LockOptions.NO_WAIT);
//		q.query().setLockOptions(LockOptions.NONE);
		return (OmCfg) q.uniqueResult();
	}
	
	public OmCfg getUltimaConfigGeralAtiva(){
		MapQuery q = new MapQuery(session);
		q.append("SELECT omcfg ");
		q.append("FROM OmCfg omcfg ");
		q.append("ORDER BY omcfg.idCfg DESC");
		q.setMaxResults(1);
		return (OmCfg) q.uniqueResult();
	}
	
}

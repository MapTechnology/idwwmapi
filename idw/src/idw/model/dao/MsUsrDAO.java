package idw.model.dao;

import java.math.BigDecimal;

import org.hibernate.Session;

import idw.model.pojos.MsUsr;

public class MsUsrDAO {

	private Session session;
	
	public MsUsrDAO(Session session){
		this.session = session;
	}
	
	public MsUsr getMsUsrPorLoginAtivo(String login) {
		MapQuery q = new MapQuery(session);
		q.append("FROM MsUsr msusr ");
		q.append("WHERE msusr.login = :login ");
		q.append("AND msusr.stAtivo = :stAtivo ");
		q.defineParametro("stAtivo", BigDecimal.ONE);
		q.defineParametro("login", login);
		q.setMaxResults(1);
		return (MsUsr) q.uniqueResult();
	}
	
	public MsUsr getMsUsrPorCdAtivo(String cdUsr) {
		MapQuery q = new MapQuery(session);
		q.append("FROM MsUsr msusr ");
		q.append("WHERE msusr.cdUsr = :cdUsr ");
		q.append("AND msusr.stAtivo = :stAtivo ");
		q.defineParametro("stAtivo", BigDecimal.ONE);
		q.defineParametro("cdUsr", cdUsr);
		q.setMaxResults(1);
		return (MsUsr) q.uniqueResult();
	}
	
}

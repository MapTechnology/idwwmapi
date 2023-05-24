package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwGrpativ;

public class DwGrpativDAO {

	private final Session session;
	
	public DwGrpativDAO(Session session){
		this.session = session;
	}
	
	public DwGrpativ getDwGrpativPorId(long idGrpativ) {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwGrpativ ga");
		q.append("WHERE ga.idGrpativ = :idGrpativ");
		q.defineParametro("idGrpativ", idGrpativ);
		return (DwGrpativ) q.uniqueResult();
	}
	
	public DwGrpativ getDwGrpativPorCdAtivo(String cdGrpativ) {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwGrpativ ga");
		q.append("WHERE ga.stAtivo = :stativo");
		q.append("AND ga.cdGrpativ = :codigo");
		q.defineParametro("stativo", (byte) 1);
		q.defineParametro("codigo", cdGrpativ);
		q.setMaxResults(1);
		return (DwGrpativ) q.uniqueResult();
	}
	
}
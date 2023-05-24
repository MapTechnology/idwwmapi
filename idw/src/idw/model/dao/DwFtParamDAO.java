package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwFtParam;

public class DwFtParamDAO {
	
	private Session session;
	
	public DwFtParamDAO(Session session){
		this.session = session;
	}
	
	public DwFtParam getDwFtParamPorId(long idFtParam){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwFtParam t");
		q.append("WHERE t.idFtParam = :idFtParam");
		q.defineParametro("idFtParam", idFtParam);
		q.setMaxResults(1);
		return (DwFtParam) q.uniqueResult();
	}

	public DwFtParam getDwFtParamPorDs(String ds){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwFtParam t");
		q.append("WHERE t.dsParametro = :ds");
		q.defineParametro("ds", ds);
		q.setMaxResults(1);
		return (DwFtParam) q.uniqueResult();
	}
}

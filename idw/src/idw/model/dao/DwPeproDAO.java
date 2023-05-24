package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.DwPepro;

public class DwPeproDAO {
	
	private Session session;
	
	public DwPeproDAO(Session session){
		this.session = session;
	}
	
	public DwPepro getDwPeproPorId(long idPepro){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwPepro t");
		q.append("WHERE t.idPepro = :idPepro");
		q.defineParametro("idPepro", idPepro);
		return (DwPepro) q.uniqueResult();
	}

}

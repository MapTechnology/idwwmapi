package idw.model.dao;
import org.hibernate.Session;

import idw.model.pojos.OmIndgt;
import idw.model.pojos.template.OmIndTemplate;


public class OmIndgtDAO {
	
	private Session session;
	
	public OmIndgtDAO(Session session){
		this.session = session;
	}
	
	public OmIndgt getOmIndGt(OmIndTemplate.Tipo tipo, String cdGt){
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT omIndgt ");
		q.append("FROM OmIndgt omIndgt ");
		q.append("INNER JOIN omIndgt.omInd omInd");
		q.append("INNER JOIN omIndgt.omGt omGt");
		q.append("WHERE omInd.idInd = :idInd");
		q.append("AND omGt.cdGt = :cdGt");
		q.defineParametro("idInd", tipo.getId());
		q.defineParametro("cdGt", cdGt);
		q.setMaxResults(1);
		return (OmIndgt) q.uniqueResult();
				
	}
	
}
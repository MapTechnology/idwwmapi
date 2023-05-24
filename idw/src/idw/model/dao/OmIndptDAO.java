package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.OmIndpt;
import idw.model.pojos.template.OmIndTemplate;

public class OmIndptDAO {
	
	private Session session;
	
	public OmIndptDAO(Session session){
		this.session = session;
	}
	
	public OmIndpt getOmIndpt(OmIndTemplate.Tipo tipo, String cdPt){
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT omIndpt ");
		q.append("FROM OmIndpt omIndpt ");
		q.append("INNER JOIN omIndpt.omInd omInd");
		q.append("INNER JOIN omIndpt.omPt omPt");
		q.append("WHERE omInd.idInd = :idInd");
		q.append("AND omPt.cdPt = :cdPt");
		q.defineParametro("idInd", tipo.getId());
		q.defineParametro("cdPt", cdPt);
		q.setMaxResults(1);
		return (OmIndpt) q.uniqueResult();
				
	}
	
}
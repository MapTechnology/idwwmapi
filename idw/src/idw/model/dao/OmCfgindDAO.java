package idw.model.dao;
import org.hibernate.Session;

import idw.model.pojos.OmCfgind;
import idw.model.pojos.template.OmIndTemplate;


public class OmCfgindDAO {
	
	private Session session;
	
	public OmCfgindDAO(Session session){
		this.session = session;
	}
	
	public OmCfgind getOmCfgind(OmIndTemplate.Tipo tipo){
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT omCfgind ");
		q.append("FROM OmCfgind omCfgind ");
		q.append("INNER JOIN omCfgind.omInd omInd");
		q.append("WHERE omInd.idInd = :idInd");
		q.defineParametro("idInd", tipo.getId());
		q.setMaxResults(1);
		return (OmCfgind) q.uniqueResult();
				
	}
	
}
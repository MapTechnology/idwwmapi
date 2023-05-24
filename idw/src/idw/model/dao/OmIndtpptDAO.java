package idw.model.dao;

import org.hibernate.Session;

import idw.model.pojos.OmIndtppt;
import idw.model.pojos.template.OmIndTemplate;
import idw.model.pojos.template.OmTpptTemplate;

public class OmIndtpptDAO {
	
	private Session session;
	
	public OmIndtpptDAO(Session session){
		this.session = session;
	}
	
	public OmIndtppt getOmIndtppt(OmIndTemplate.Tipo tipoInd, OmTpptTemplate.Type tipoTppt){
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT omIndtppt ");
		q.append("FROM OmIndtppt omIndtppt ");
		q.append("INNER JOIN omIndtppt.omInd omInd");
		q.append("INNER JOIN omIndtppt.omTppt omTppt");
		q.append("WHERE omInd.idInd = :idInd");
		q.append("AND omTppt.idTppt = :idTppt");
		q.defineParametro("idInd", tipoInd.getId());
		q.defineParametro("idTppt", tipoTppt.getId());
		q.setMaxResults(1);
		return (OmIndtppt) q.uniqueResult();
	}
	
}
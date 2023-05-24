package idw.model.dao;

import org.hibernate.Session;

public class OmHomoptDAO {
	
	private Session session;

	public OmHomoptDAO(Session session){
		this.session = session;
	}
	
	//ESSE METODO DEVERIA SER CHAMANDO NO METODO (VALIDARHOMOLOGACOESGT) EM GTRN
//	public OmHomopt getOmHomoptComUsr(long idUsr){
//		MapQuery q = new MapQuery(session);
//		q.append("FROM OmHomopt t");
//		q.append("WHERE t.omUsrByIdUsrhomologado.idUsr = :idUsr");
//		q.defineParametro("idUsr", idUsr);
//		q.setMaxResults(1);
//		return (OmHomopt) q.uniqueResult();
//	}
	
}

package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcnc;

public class OmPtcncDAO {

	private Session session;

	public OmPtcncDAO(Session session) {
		this.session = session;
	}

	// pega o CNC por id
	public OmPtcnc getOmPtCncPorId(long idPtCnc) {
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPtcnc omptcnc");
		q.append("WHERE omptcnc.idPtcnc = :idPtCnc");
		q.defineParametro("idPtCNC", idPtCnc);
		q.setMaxResults(1);
		return (OmPtcnc) q.uniqueResult();
	}

	// //pega o CNC ativo por id
	 public OmPtcnc getOmPtCncPorCdAtivoOrderById(String cdPt){
	 MapQuery q = new MapQuery(session);
	 q.append("FROM OmPtcnc omptcnc");
	 q.append("WHERE omptcnc.pt.cdPt = :cdPt");
	 q.append("AND omptCnc.stAtivo = :stAtivo");
	 q.append("ORDER BY omptCnc.idPtCnc ");
	 q.defineParametro("cdPt", cdPt);
	 q.defineParametro("stAtivo", (byte)1);
	 q.setMaxResults(1);
	 return (OmPtcnc) q.uniqueResult();
	 }


		public List<OmPtcnc> getOmPtCncPreenchido(long idPt) {
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPtcnc omptcnc");
		q.append("WHERE (omptcnc.omPtByIdPtFilho.idPt = :idpt)");
		q.defineParametro("idpt", idPt);
		
		return q.list();
	}
	
	public List<OmPt> getOmPtcAtivoSemCnc() {
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPt ompt");
//		q.append("WHERE NOT EXISTS(");
//		q.append("FROM OmPtcnc omptcnc");
//		q.append("WHERE (omptcnc.omPtByIdPtFilho.idPt = ompt.idPt)");
//		q.append("OR (omptcnc.omPtByIdPt.idPt = ompt.idPt))");
		q.append("where ompt.stAtivo = :stativo");
		q.defineParametro("stativo", (byte) 1);
		return q.list();
	}

}
package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmPa;
import idw.model.pojos.OmPt;

public class OmPaDAO {
	private Session session;
	
	public OmPaDAO(Session session){
		this.session = session;
	}
	
	public List<OmPa> getOmPas(String cdPa, String dsPa, Long idPt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPa pa");
		q.append("WHERE pa.stAtivo = :stAtivo");
		if(idPt != null){
			q.append("AND pa.omPt.idPt = :idPt");
		}		
		if(!cdPa.equals("") && !dsPa.equals("")){
			q.append("AND (pa.cdPa = :cdPa OR pa.dsPa = :dsPa)");
		}else if(!cdPa.equals("")){
			q.append("AND pa.cdPa = :cdPa");
		}else if(!dsPa.equals("")){
			q.append("AND pa.dsPa = :dsPa");
		}
		q.defineParametro("idPt", idPt);
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdPa", cdPa);
		q.defineParametro("dsPa", dsPa);
		return q.list();
	}

	public OmPa getOmPa(OmPt omPt, String cdPa) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT omPa FROM OmPa omPa");
		q.append("WHERE omPa.omPt = :omPt");
		q.append("AND omPa.cdPa = :cdPa");
		q.append("AND omPa.stAtivo = 1");
		q.defineParametro("omPt", omPt);
		q.defineParametro("cdPa", cdPa);
		return (OmPa) q.uniqueResult();
	}
	
	public OmPa getOmPaPorId(long idPa) {
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPa omPa");
		q.append("WHERE omPa.idPa = :idPa");
		q.defineParametro("idPa", idPa);
		return (OmPa) q.uniqueResult();
	}
	
}

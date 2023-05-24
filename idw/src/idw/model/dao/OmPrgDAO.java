package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmPrg;

public class OmPrgDAO {

	private Session session;
	
	public OmPrgDAO(Session session){
		this.session = session;
	}
	
	public List<OmPrg> getOmPrgs(String cdPrg, String dsPrg, Long idPt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmPrg prg");
		q.append("WHERE prg.stAtivo = :stAtivo");
		if(idPt != null){
			q.append("AND prg.omPt.idPt = :idPt");
		}
		if (!cdPrg.equals("") && !dsPrg.equals("")) {
			q.append("AND (prg.cdPrg = :cdPrg or prg.dsPrg = :dsPrg)");
		} else if (!cdPrg.equals("")) {
			q.append("AND prg.cdPrg = :cdPrg");
		} else if (!dsPrg.equals("")) {
			q.append("AND prg.dsPrg = :dsPrg");
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdPrg", cdPrg);
		q.defineParametro("dsPrg", dsPrg);
		q.defineParametro("idPt", idPt);		
		return q.list();
	}
	
}	

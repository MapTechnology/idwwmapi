package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPt;
import idw.webservices.dto.LeiturasCODTO;

public class OmMapaDAO {
	
	private Session session;
	
	public OmMapaDAO(Session session){
		this.session = session;
	}
	
	public List<OmMapa> setCorrente(LeiturasCODTO leituras, OmPt omPt){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmMapa t ");
		q.append("WHERE t.cdMapa =:cdMapa AND t.stAtivo = 1 ");
		q.append("AND t.omPt.idPt =:idpt ORDER BY t.revisao DESC ");
		if (leituras.getMapa().getCdMapa() != null && leituras.getMapa().getCdMapa().trim().equals("") == false)
			q.defineParametro("cdMapa", leituras.getMapa().getCdMapa());
		else
			q.defineParametro("cdMapa", leituras.getLeituras().get(0).getPosicaoASerLida().getCdMapa());
		
		q.defineParametro("idpt", omPt.getIdPt());
		System.out.println(q.hqlToString() + " cdmapa = " + leituras.getMapa().getCdMapa() + " ompt=" + omPt.getIdPt());
		return q.list();
	}
	
	public OmMapa getOmMapa(Long idPt, String cdMapa){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmMapa mapa");
		q.append("WHERE mapa.stAtivo = :stAtivo");
		q.append("AND mapa.omPt.idPt = :idPt");
		q.append("AND mapa.cdMapa LIKE :nrop");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("idPt", idPt);
		q.defineParametro("nrop", cdMapa + "%");
		return (OmMapa) q.uniqueResult();
	}
	
	public OmMapa getMapaDeAlimentacao(String cdMapa, OmPt pt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT mapa");
		q.append("FROM OmMapa mapa");
		q.append("WHERE mapa.stAtivo = 1");
		q.append("AND mapa.cdMapa = :op");
		q.append("AND mapa.omPt.idPt = :idpt");
		q.append("ORDER BY mapa.idMapa DESC");

		q.defineParametro("op", cdMapa);
		q.defineParametro("idpt", pt.getIdPt());
		
		q.setMaxResults(1);

		return (OmMapa) q.uniqueResult();
	}

}
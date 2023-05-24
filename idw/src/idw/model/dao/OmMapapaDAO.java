package idw.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.webservices.dto.LeituraCODTO;

public class OmMapapaDAO {
	
	private Session session;
	
	public OmMapapaDAO(Session session){
		this.session = session;
	}
	
	public List<OmMapapa> setRealimentacao(LeituraCODTO leitura){
		MapQuery q = new MapQuery(session);
		
		q.append("FROM OmMapapa t ");
		q.append("WHERE t.idMapapa =:idMapapa ");
		q.defineParametro("idMapapa", leitura.getPosicaoASerLida().getIdMapapa());
		//q.defineParametro("idMapapa", String.valueOf(leitura.getPosicaoASerLida().getIdMapapa()));
		
		return q.list();
	}

	/* Metodo abaixo deve considerar tambem as posicoes dos mapas em anexo */
	public List<OmMapapa> getOmMapaPA(LeituraCODTO leitura, OmMapa omMapa){
		MapQuery qm = new MapQuery(session);
		qm.append("select distinct c.cdMapa");
		qm.append("from OmMapa a");
		qm.append("join a.omMapaAnexoForIdMapa b");
		qm.append("join b.omMapaByIdMapaFilho c");
		qm.append("where a = :ommapa");
		qm.defineParametro("ommapa", omMapa);
		List<Object> cdmapas = qm.list();
		cdmapas.add(omMapa.getCdMapa());
		
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT ommapapa ");
		q.append("FROM OmMapapa ommapapa ");
		q.append("JOIN ommapapa.omMapa ommapa ");
		q.append("JOIN ommapapa.omPa ompa ");
		q.append("WHERE ommapa.cdMapa in (:idmapa)");
		q.append("and ommapa.stAtivo = 1");
		q.append("AND ompa.cdPa =:cdpa ");
		q.append("and ommapa.omPt = :ompt");
		
		q.defineListaParametro("idmapa", cdmapas);
		q.defineParametro("cdpa", leitura.getPosicaoASerLida().getCdFeeder());
		q.defineParametro("ompt", omMapa.getOmPt());
		return q.list();
	}
	
	public OmMapapa getPosicaoValida(String maquina, String mapa, String cdPa, String cdProduto) {
		MapQuery qm = new MapQuery(session);
		qm.append("select c");
		qm.append("from OmMapa a");
		qm.append("join a.omMapaAnexoForIdMapa b");
		qm.append("join b.omMapaByIdMapaFilho c");
		qm.append("where a.stAtivo = 1");
		qm.append("and a.cdMapa = :cdmapa");
		
		qm.defineParametro("cdmapa", mapa);
		
		List<OmMapa> mapas = qm.list();
		List<Object> cdmapas = new ArrayList<>();
		
		for (OmMapa ommapa : mapas) {
			cdmapas.add(ommapa.getCdMapa());
		}
		cdmapas.add(mapa);
		
		MapQuery q = new MapQuery(session);
		q.append("select mapapa ");
		q.append("from OmMapapa mapapa ");				
		q.append("inner join mapapa.omMapa mapa ");				
		q.append("left  join mapa.omPt pt ");
		q.append("left  join mapapa.omPa ompa ");	
		q.append("left  join mapapa.omProduto produto ");
		q.append("where mapa.stAtivo = 1 ");
		q.append("and pt.cdPt = :cdpt ");
		q.append("and mapa.cdMapa in (:cdmapa) ");
		q.append("and ompa.stAtivo = 1 ");
		q.append("and produto.stAtivo = 1 ");
		q.append("and ompa.cdPa = :cdpa ");
		q.append("and ompa.omPt.idPt = mapa.omPt.idPt ");
		q.append("and produto.cdProduto = :cdproduto ");
		q.append("and pt.stAtivo = 1");
		q.append("order by mapa.revisao desc ");
		
		
		q.defineParametro("cdpt", maquina);
		q.defineListaParametro("cdmapa", cdmapas);
		q.defineParametro("cdpa", cdPa);
		q.defineParametro("cdproduto", cdProduto);
		q.setMaxResults(1);
		
		OmMapapa omMapapa = (OmMapapa) q.uniqueResult();
		
		
		return omMapapa;
	}
	
}
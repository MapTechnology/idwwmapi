package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwRota;
import idw.model.pojos.OmProduto;

public class DwRotaDAO {
	
	private Session session;
	
	public DwRotaDAO(Session session) {
		this.session = session;
	}
	
	public DwRota getDwRotaPorProduto(OmProduto produto) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwrota");
		q.append("FROM DwRota dwrota");
		q.append("JOIN FETCH dwrota.dwRotapassos dwrotapasso");
		q.append("LEFT JOIN FETCH dwrotapasso.dwRpPredecessorasForIdRotapassoPai predecessoras");
		q.append("WHERE dwrota.stAtivo = :stAtivo");
		q.append("AND dwrota.omProduto = :omproduto");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("omproduto", produto);
		q.setMaxResults(1);
		return (DwRota) q.uniqueResult();
	}
	
	public DwRota getDwRotaPorProduto(String cdProduto) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwrota");
		q.append("FROM DwRota dwrota");
		q.append("JOIN FETCH dwrota.dwRotapassos dwrotapasso");
		q.append("JOIN dwrota.omProduto omProduto");
		q.append("LEFT JOIN FETCH dwrotapasso.dwRpPredecessorasForIdRotapassoPai predecessoras");
		q.append("WHERE dwrota.stAtivo = :stAtivo");
		q.append("AND omProduto.cdProduto = :cdProduto");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdProduto", cdProduto);
		q.setMaxResults(1);
		return (DwRota) q.uniqueResult();		
	}
	
	public DwRota getDwRotaAtivaPorCd(String cdRota) {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwRota rota");
		q.append("WHERE rota.stAtivo = :stAtivo");
		q.append("AND rota.cdRota = :cdRota");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdRota", cdRota);
		return (DwRota) q.uniqueResult();
	}
	
	public DwRota getDwRotaPorId(long idRota) {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwRota rota");
		q.append("WHERE rota.idRota = :idRota");
		q.defineParametro("idRota", idRota);
		return (DwRota) q.uniqueResult();
	}
	
	public List<DwRota> getDwRotasAtivasPorProdutoFinal(OmProduto produtoFinal, String cdGt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT rota");
		q.append("FROM DwRota rota");
		q.append("JOIN rota.omProduto produto");
		q.append("join rota.omGt b");
		q.append("WHERE produto.idProduto = :idProduto");
		q.append("AND rota.stAtivo = :stAtivo");
		
		if (cdGt != null) {
			q.append("and b.cdGt = :cdgt");
			q.defineParametro("cdgt", cdGt);
		}
		q.defineParametro("idProduto", produtoFinal.getIdProduto());
		q.defineParametro("stAtivo", (byte) 1);
		return q.list();
	}

}
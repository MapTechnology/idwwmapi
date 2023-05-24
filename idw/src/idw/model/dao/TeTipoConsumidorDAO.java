package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.TeTipoConsumidor;
import idw.webservices.dto.PesquisaDTO;

public class TeTipoConsumidorDAO {
	
	private Session session;
	
	public TeTipoConsumidorDAO(Session session) {
		this.session = session;
	}
	
	public TeTipoConsumidor getTeTipoConsumidorPorId(long idTipoConsumidor) {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeTipoConsumidor consumidor");
		q.append("WHERE consumidor.idTipoConsumidor = :id");
		q.defineParametro("id", idTipoConsumidor);
		return (TeTipoConsumidor) q.uniqueResult();
	}

	public TeTipoConsumidor getTeTipoConsumidorPorCdAtivo(String cdTipoConsumidor) {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeTipoConsumidor consumidor");
		q.append("WHERE consumidor.cdTipoConsumidor = :cd");
		q.append("AND consumidor.stAtivo = :stAtivo");
		q.defineParametro("cd", cdTipoConsumidor);
		q.defineParametro("stAtivo", (byte)1);
		return (TeTipoConsumidor) q.uniqueResult();
	}
	
	public List<TeTipoConsumidor> pesquisaTeTipoConsumidorPorCdOuDsAtivo(PesquisaDTO pesquisa) {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeTipoConsumidor consumidor");
		q.append("WHERE consumidor.stAtivo = :stAtivo");

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("AND (consumidor.cdTipoConsumidor = :cdTipoConsumidor OR consumidor.dsTipoConsumidor = :dsTipoConsumidor)");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("AND consumidor.cdTipoConsumidor = :cdTipoConsumidor");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("AND consumidor.cdTipoConsumidor = :cdTipoConsumidor");
		}

		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdTipoConsumidor", pesquisa.getCodigo());
		q.defineParametro("dsTipoConsumidor", pesquisa.getDescricao());
		
		return q.list();
	}
	
}

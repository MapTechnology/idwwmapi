package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.TeLei;
import idw.webservices.dto.PesquisaDTO;

public class TeLeiDAO {
	
	private Session session;
	
	public TeLeiDAO(Session session) {
		this.session = session;
	}
	
	public List<TeLei> pesquisaTeLeiPorCdOuDsAtivo(PesquisaDTO pesquisa) {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeLei leiVigente");
//		q.append("WHERE leiVigente.stAtivo = :stAtivo");
		q.append("WHERE 1 = 1"); //remover

		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("AND (leiVigente.cdLei = :cdLei OR leiVigente.dsLei = :dsLei)");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("AND leiVigente.cdLei = :cdLei");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("AND leiVigente.dsLei = :dsLei");
		}

		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdLei", pesquisa.getCodigo());
		q.defineParametro("dsLei", pesquisa.getDescricao());
		
		return q.list();
	}

}

package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.TeConcessionaria;
import idw.webservices.dto.PesquisaDTO;

public class TeConcessionariaDAO {

	private Session session;
	
	public TeConcessionariaDAO(Session session) {
		this.session = session;
	}
	
	public List<TeConcessionaria> getTeConcessionariaPorCdOuDsAtivo(PesquisaDTO pesquisa) {
		MapQuery q = new MapQuery(session);
		q.append("FROM TeConcessionaria concessionaria");
		q.append("WHERE concessionaria.stAtivo = :stAtivo");
		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("AND (concessionaria.cdConcessionaria = :cdConcessionaria OR concessionaria.dsConcessionaria = :dsConcessionaria)");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("AND concessionaria.cdConcessionaria = :cdConcessionaria");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("AND concessionaria.dsConcessionaria = :dsConcessionaria");
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdConcessionaria", pesquisa.getCodigo());
		q.defineParametro("dsConcessionaria", pesquisa.getDescricao());
		return q.list();
	}

}

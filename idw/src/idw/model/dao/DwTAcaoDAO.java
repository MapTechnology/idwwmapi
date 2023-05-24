package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwTAcao;

public class DwTAcaoDAO {

	private Session session;
	
	public DwTAcaoDAO(Session session){
		this.session = session;
	}
	
	public List<DwTAcao> getDwTAcao(String cdAcao, String dsAcao){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwTAcao acao");
		q.append("WHERE acao.stAtivo = :stAtivo");
		if (!cdAcao.equals("") && !dsAcao.equals("")) {
			q.append("AND acao.cdTacao = :cdAcao OR acao.dsTacao = :dsAcao");
		} else if (!cdAcao.equals("")) {
			q.append("AND acao.cdTacao = :cdAcao");
		} else if (!dsAcao.equals("")) {
			q.append("AND acao.dsTacao = :dsAcao");
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdAcao", cdAcao);
		q.defineParametro("dsAcao", dsAcao);
		return q.list();
	}
	
	public DwTAcao getDwTAcaoPorCdAtivo(String cdTacao){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwTAcao acao");
		q.append("WHERE acao.cdTacao = :cdTacao");
		q.append("AND acao.stAtivo = :stAtivo");
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdTacao", cdTacao);
		q.setMaxResults(1);
		return (DwTAcao) q.uniqueResult();
	}
	
}

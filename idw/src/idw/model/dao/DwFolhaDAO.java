package idw.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwProcedimento;

public class DwFolhaDAO {
	private final Session session;
	private StatelessSession sessionStateless;
	
	public DwFolhaDAO(Session session){
		this.session = session;
	}
	
	
	
	public void setSessionStateless(StatelessSession sessionStateless) {
		this.sessionStateless = sessionStateless;
	}



	public void alterarDwProcedimentoTodasFolhas(DwProcedimento dwProcedimentoAntigo, DwProcedimento dwProcedimentoNovo){
		MapQuery q = new MapQuery(session);
		q.append("update DwFolha dwFolha");
		q.append(" set dwFolha.dwProcedimento = :dwProcedimentoNovo");
		q.append(" where dwFolha.dwProcedimento = :dwProcedimentoAntigo");
		q.defineParametro("dwProcedimentoAntigo", dwProcedimentoAntigo);
		q.defineParametro("dwProcedimentoNovo", dwProcedimentoNovo);
		q.query().executeUpdate();		
	}
	
	public DwFolha getDwFolhaPorId(long idFolha){
		MapQuery q;
		if (session != null)
			q = new MapQuery(session);
		else
			q = new MapQuery(sessionStateless);
		
		q.append("FROM DwFolha folha");
		q.append("WHERE folha.idFolha = :idFolha");
		q.defineParametro("idFolha", idFolha);
		return (DwFolha) q.uniqueResult();
	}
	
	public DwFolha getDwFolhaPorCd(String cdFolha){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwFolha folha");
		q.append("WHERE folha.cdFolha = :cdFolha");
		q.append("AND folha.stAtivo = :stAtivo");
		q.defineParametro("cdFolha", cdFolha);
		q.defineParametro("stAtivo", (byte) 1);
		return (DwFolha) q.uniqueResult();
	}
	
	public List<DwFolha> getDwFolhasPorProcedimento(long idProcedimento) {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwFolha folha");
		q.append("WHERE folha.stAtivo = :stAtivo");
		q.append("AND folha.dwProcedimento.idProcedimento = :idProcedimento");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("idProcedimento", idProcedimento);
		return q.list();
	}
	
}
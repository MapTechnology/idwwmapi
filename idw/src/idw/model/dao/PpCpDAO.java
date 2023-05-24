package idw.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import idw.model.pojos.PpCp;

public class PpCpDAO {
	
	private Session session = null;
	private StatelessSession sessionStateless = null;
	
	public PpCpDAO(Session session) {
		this.session = session;
	}
	public void setSessionStateless(StatelessSession sessao) {
		this.sessionStateless = sessao;
	}
	
	public List<PpCp> getPpCpsDaFolha(Long idFolha) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT ppcp");
		q.append("FROM PpCp ppcp");
		q.append("JOIN ppcp.dwFolha folha");
		q.append("WHERE ppcp.stAtivo = :stAtivo");
		q.append("AND folha.idFolha = :idFolha");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("idFolha", idFolha);
		return q.list();
	}
	
	public List<PpCp> getPpCpLikeNrDoc(String nrOp) {
		MapQuery q;
		if (session != null)
			q = new MapQuery(session);
		else
			q = new MapQuery(sessionStateless);
		
		q.append("select distinct ppcp");
		q.append("FROM PpCp ppcp");
		q.append("join fetch ppcp.ppCpprodutos ppcpproduto");
		q.append("join fetch ppcpproduto.omProduto omprodutoppcp");
		q.append("join fetch ppcp.dwFolha dwfolha");
		q.append("join fetch ppcp.omPt ompt");
		q.append("left join fetch ppcp.dwRota dwrota");
		q.append("left join fetch dwrota.omProduto omprodutorota");
		q.append("left join fetch ppcp.ppCliente ppcliente");
		
		q.append("left join fetch omprodutoppcp.omProgrp omprogrp");
		q.append("left join fetch dwfolha.dwFolhaiacs dwfolhaiac");
		q.append("left join fetch dwfolhaiac.omProduto omprodutoiac");
		q.append("left join fetch dwfolha.dwFolharaps dwfolharap");
		q.append("left join fetch dwfolharap.dwFolharapcoms dwfolharapcom");
		q.append("left join fetch dwfolharapcom.omProduto omprodutorapcom");
		q.append("left join fetch ppcp.ppCpnseries ppcpnserie");
		q.append("WHERE ppcp.stAtivo = :stAtivo");
		
		if (nrOp != null && nrOp.equals("") == false)
			q.append("and ppcpproduto.nrDoc = :nrdoc");
		else
			q.append("and ppcpproduto.nrDoc is null");
		
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("nrdoc", nrOp);
		return q.list();
	}
	
	public PpCp getPpCpPorId(Long idCp){
		MapQuery q = new MapQuery(session);
		q.append("FROM PpCp ppcp");
		q.append("WHERE ppcp.idCp = :idCp");
		q.defineParametro("idCp", idCp);
		return (PpCp) q.uniqueResult();
	}
	
	public PpCp getPpCpPorCdOrdeByIdDesc(String cdCp){
		MapQuery q = new MapQuery(session);
		q.append("FROM PpCp ppcp");
		q.append("WHERE ppcp.cdCp = :cdCp");
		q.append("ORDER BY ppcp.idCp DESC");
		q.defineParametro("cdCp", cdCp);
		return (PpCp) q.uniqueResult();
		
		//190515 Ver anotação //190515
	}
	

	public PpCp getPpCpPorCdCpPtOrdeByIdDesc(String cdCp, String cdPt){
		
		// Banco: FLEX (sqls); Monitorizacao->FILTRO:02MAI2019->PRIMTURNO->IAC->LIN13->QP3L13->FICHAMAQUINA->GraficoCiclos->CicloMedio->Click2aBarra.
		//cdCp = CONV. FSP006 NV_L13_T00
		//TODO: 190515 Avaliar motivo de ser de uma chamada de rotina 'getPpCpPorCdOrdeByIdDesc'
		//190515 - NECESSIDADE DE CORREÇÃO DETECTADA EM 190515: aqui foi criada nova rotina
		//190515 - nova rotina: especificando o PT (pois antes vinha trazendo uma mesma CP para PTs distintos) Gerava erro 'NonUniqueResultException'.
		//190515 - convencionado aqui que deveria especificar o PT devido que o usuario na tela especificou o PT.
		//190515: ERRO idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO@55858be1
		//190515: ERRO GRAVE: The RuntimeException could not be mapped to a response, re-throwing to the HTTP container
		//190515: ERRO org.hibernate.NonUniqueResultException: query did not return a unique result: 2
		//190515: ERRO at idw.model.dao.PpCpDAO.getPpCpPorCdOrdeByIdDesc(PpCpDAO.java:84)
		//190515: ERRO getPpCpPorCdOrdeByIdDesc(String cdCp)
		//190515: ERRO at idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebProducaoRN.getfiltroDetalheProducaoHora(DetalheMonitorizacaoWebProducaoRN.java:325)
		
		MapQuery q = new MapQuery(session);
		q.append(" FROM PpCp ppcp");
		q.append(" join fetch ppcp.omPt ompt ");
		q.append("WHERE ppcp.cdCp = :cdCp");
		q.append(" AND ompt.cdPt = :cdPt");
		q.append("ORDER BY ppcp.idCp DESC");
		q.defineParametro("cdCp", cdCp);
		q.defineParametro("cdPt", cdPt);
		return (PpCp) q.uniqueResult();
	}
	

	public PpCp getPpCpPorCdCpIdPtOrdeByIdDesc(String cdCp, Long idPt){
		MapQuery q = new MapQuery(session);
		q.append(" FROM PpCp ppcp");
		q.append(" join fetch ppcp.omPt ompt ");
		q.append("WHERE ppcp.cdCp = :cdCp");
		q.append(" AND ompt.idPt = :idPt");
		q.append("ORDER BY ppcp.idCp DESC");
		q.defineParametro("cdCp", cdCp);
		q.defineParametro("idPt", idPt);
		return (PpCp) q.uniqueResult();
	}
	
}
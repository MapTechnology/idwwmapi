package idw.model.rn.integracao.tdba;

import java.math.BigInteger;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJoblog;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.Util;

public abstract class AIntegracaoTDBA {
	
	protected DAOGenerico dao;
	protected DAOGenericoErp daoERP;
	protected OmCfg omcfg;
	protected int qtItensImportados = 0;

	protected String mensagem_resultado;
	protected int stregistro;
	
	public AIntegracaoTDBA(DAOGenerico dao, DAOGenericoErp daoERP) {
		super();
		this.dao = dao;
		this.daoERP = daoERP;
		
		// obtem a configuracao geral atual para ter acesso ao usuario de referencia para a importacao
		omcfg = Util.getConfigGeral(dao.getSessionStateless());
	}

	public abstract boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog);
	
	
	/*
	 * Metodo para marcar como processado registro importado
	 */
	public void atualizarResultado(BigInteger id, int stregistro, String mensagem_resultado, String tabela) {
		this.mensagem_resultado = mensagem_resultado;
		this.stregistro = stregistro;
		
		MapQuery sql = new MapQuery(daoERP.getSession());
		sql.append("update ");
		sql.append(tabela);
		sql.append(" set st_registro=:stregistro, motivo_recusado=:motivo, dthr_processamento=:dthr");
		if (tabela.equals("mi_operador_idw")) {
			sql.append(", senha_acesso = :senha");
		}
		sql.append("where id=:id");
		
		sql.querySQL().setParameter("stregistro", stregistro);
		sql.querySQL().setParameter("motivo", mensagem_resultado);
		sql.querySQL().setParameter("dthr", DataHoraRN.getDataHoraAtual());
		sql.querySQL().setParameter("id", id);
		if (tabela.equals("mi_operador_idw")) {
			sql.querySQL().setParameter("senha", "");
		}
		
		sql.querySQL().executeUpdate();
		
		
	}
	
	
	public String getResultado() {
		return this.mensagem_resultado;
	}
	
	public int getStregistro()  {
		return this.stregistro;
	}

	
	public int getQtItensImportados() {
		return this.qtItensImportados;
	}
}

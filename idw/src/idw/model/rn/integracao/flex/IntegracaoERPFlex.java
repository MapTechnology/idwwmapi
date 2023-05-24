package idw.model.rn.integracao.flex;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmJob;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.template.OmJobRecursoTemplate;
import idw.model.pojos.template.OmJobdetlogTemplate;
import idw.model.pojos.template.OmJoblogTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.GrupoProdutoRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.integracao.AIntegracaoBackground;
import idw.util.IdwLogger;

public class IntegracaoERPFlex extends AIntegracaoBackground{
	
	private DAOGenericoErp daoERP = new DAOGenericoErp();

	public IntegracaoERPFlex() {
		super(new DAOGenerico());
	}
	
	public IntegracaoERPFlex(DAOGenerico dao) {
		super(dao);

	}

	@Override
	public void integrar(IdwLogger log, int idLog) {
		// Pesquisar novamente OmJob pois o disponivel esta sem sessao
		this.setOmjob(getDao().findById(OmJob.class, getOmjob().getIdJob(), false));
		// Gera um log de execucao do job
		OmJoblog joblog = new OmJoblog();

		joblog.setDthrIexecucao(DataHoraRN.getDataHoraAtual());
		joblog.setIdJoblog(null);
		joblog.setOmJob(getOmjob());
		joblog.setStExecucao(OmJoblogTemplate._StExecucao.SUCESSO.getValue());
		getDao().makePersistent(joblog);
		
		log.info(idLog, 0, "Incluido omjoblog com id = " + joblog.getIdJoblog());

		
		boolean isSucesso = true;
		boolean isImportouAlgo = false;
		
		StringBuilder dsImportacao = new StringBuilder();
		
		List<OmJobdet> dets = pesquisarOmJobdets(getOmjob());
		
		Collections.sort(dets, new Comparator<OmJobdet>() {
			@Override
			public int compare(OmJobdet o1, OmJobdet o2) {
				return o1.getOrdem().compareTo(o2.getOrdem());
			}
		});
		// verifica todas as importacoes configuradas no job
		for (OmJobdet det : dets) {
			
			if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoGrupoProduto.getId())) {
				log.info(idLog, 0, "Vou importar o grupo de produto");
				isImportouAlgo = integrarGrupoProduto(joblog, det, log, idLog);
				log.info(idLog, 0, "Finalizou grupo produto = " + isImportouAlgo);
				if ( isImportouAlgo == false) {
					isSucesso = false;
					dsImportacao.append("Grupo Produto finalizou com falha");
				}
			}
		}

		if (isSucesso == false) {
			joblog.setStExecucao(OmJoblogTemplate._StExecucao.ERRO.getValue());
			joblog.setDsExecucao(dsImportacao.toString());
		} else {
			if (isImportouAlgo)
				joblog.setDsExecucao("Sucesso");
			else
				joblog.setDsExecucao("Sem dados para serem importados");
		}
		
		joblog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
		
		getDao().getSessionStateless().update(joblog);

	}
	
	
	/* Integra a view VW_PRODUTOS_BLOCKCHAIN DA FLEX
	 * 
	 */
	private boolean integrarGrupoProduto(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean isretornou = false;
		
		try {
			daoERP.iniciaConexaoBanco();
			MapQuery q = new MapQuery(daoERP.getSession());
			q.append("select * from VW_PRODUTOS_BLOCKCHAIN");
			
			List<Object> lista = q.querySQL().list();
			
			ProdutoRN rn = new ProdutoRN(getDao());
			GrupoProdutoRN grn = new GrupoProdutoRN();
			grn.setDao(getDao());
			grn.setSessionStateless(getDaoSessionStatless());
			
			
			for (Object linha : lista) {
				Object[] registro = (Object[])linha;
				
				String codigo = registro[0].toString().trim();
				String descricao = registro[1].toString().trim();
//				String tipo = registro[2].toString();
				String classificacao = registro[3].toString().trim();
				
				
				// Procura codigo em omproduto.cdproduto
				OmProduto omproduto = null;
				try {
					omproduto = rn.getOmProduto(codigo);
				} catch (RegistroDesconhecidoException e) {
					continue;
				}
				// Procura o grupo do produto pois a sessao é statless
				OmProgrp omprogrp = null;
				if (omproduto.getOmProgrp() != null)
					omprogrp = grn.pesquisarOmProgrpById(omproduto.getOmProgrp().getIdProgrp());
				else {
					log.info(idLog, 0, "O produto " + omproduto.getCdProduto() + " nao tem um grupo. E deve ser do grupo [" + classificacao + "].");
					incluirJobdetlog(joblog, det, "O produto " + omproduto.getCdProduto() + " nao tem um grupo. E deve ser do grupo [" + classificacao + "]", OmJobdetlogTemplate._StExecucao.ERRO.getValue());
				}
					
				// Se o grupo do produto for diferente da classificacao, entao procurar o novo grupo e alterar o produto
				if (omprogrp == null || (omprogrp != null && omprogrp.getCdProgrp().equals(classificacao) == false) ) {
					// Procura omprogrp usando classificacao
					OmProgrp omprogrpAux = grn.pesquisarOmProgrpByCdStAtivo(classificacao);
					if (omprogrpAux != null) {
						if (omprogrp == null || omprogrp.getCdProgrp().equals(omprogrpAux.getCdProgrp()) == false) {
							omproduto.setDsProduto(descricao);
							omproduto.setOmProgrp(omprogrpAux);
							
							getDao().makePersistent(omproduto);
							log.info(idLog, 0, "Alterando para grupo " + omprogrpAux.getCdProgrp() + " o produto " + omproduto.getCdProduto());
							incluirJobdetlog(joblog, det, "Alterando para grupo [" + omprogrpAux.getCdProgrp() + "] o produto " + omproduto.getCdProduto(), OmJobdetlogTemplate._StExecucao.SUCESSO.getValue());
						} else {
							log.info(idLog, 0, "Produto " + omproduto.getCdProduto() + " sem alteração.");
							incluirJobdetlog(joblog, det, "Produto [" + omproduto.getCdProduto() + "] sem alteração.", OmJobdetlogTemplate._StExecucao.SUCESSO.getValue());
						}
					} else {
						log.info(idLog, 0, "A classificacao [" + classificacao + "] nao encontrada. Produto [" + codigo + "]");
						incluirJobdetlog(joblog, det, "A classificacao [" + classificacao + "] nao encontrada para o produto [" + codigo + "]. Cadastrar na opção Plataforma-família de produto", OmJobdetlogTemplate._StExecucao.ERRO.getValue());
					}
				}
			}
			
		} catch (Exception e) {
			log.info(idLog, 0, "Excessao", e);
			e.printStackTrace();
			isretornou = false;
			incluirJobdetlog(joblog, det, e.getMessage(), OmJobdetlogTemplate._StExecucao.ERRO.getValue());
		} finally {
			daoERP.finalizaConexaoBanco();
		}
		return isretornou;
	}
	
	private void incluirJobdetlog(OmJoblog joblog, OmJobdet det, String mensagem, byte st) {
		OmJobdetlog detlog = new OmJobdetlog();
		
		detlog.setDthrIexecucao(DataHoraRN.getDataHoraAtual());
		detlog.setIdJobdetlog(null);
		detlog.setOmJobdet(det);
		detlog.setOmJoblog(joblog);
		detlog.setStExecucao(st);
		detlog.setUrlOrigem(null);
		detlog.setDsExecucao(mensagem);
		
		getDao().makePersistent(detlog);
	}
}

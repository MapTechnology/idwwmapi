package idw.model.rn.integracao.tdba;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.pojos.OmJob;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.template.OmJobRecursoTemplate;
import idw.model.pojos.template.OmJoblogTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.integracao.AIntegracaoBackground;
import idw.util.IdwLogger;

public class IntegracaoTDBARN extends AIntegracaoBackground {

	private DAOGenericoErp daoERP = new DAOGenericoErp();

	public IntegracaoTDBARN() {
		super(new DAOGenerico());
	}

	public IntegracaoTDBARN(DAOGenerico dao) {
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

		log.info(idLog, 5, "INICIO TDBA - Incluido omjoblog com id = " + joblog.getIdJoblog());

		try {
			// Abrir a conexao com o banco TDBA
			daoERP.iniciaConexaoBanco();

			boolean isSucesso = true;
			int qtItensImportados = 0;

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

				// avalia se importa posto de trabalho
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoPosto.getId())) {
					log.info(idLog, 10, "Vou importar o posto de trabalho");
					IntegracaoTDBAPostoRN rn = new IntegracaoTDBAPostoRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou importacao posto de trabalho com " + rn.getQtItensImportados() + " importados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("Posto com falha");
					}
				}

				daoERP.flushReiniciandoTransacao();
				
				// Avalia se importa cliente
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoCliente.getId())) {
					log.info(idLog, 10, "Vou importar o cliente");
					IntegracaoTDBAClienteRN rn = new IntegracaoTDBAClienteRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou importacao cliente com " + rn.getQtItensImportados() + " importados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("Cliente com falha");
					}
				}

				
				
				daoERP.flushReiniciandoTransacao();
				
				
				// Avalia se importa ferramenta
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoFerramenta.getId())) {
					log.info(idLog, 10, "Vou importar a ferramenta");
					IntegracaoTDBAFerramentaRN rn = new IntegracaoTDBAFerramentaRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou importacao ferramenta com " + rn.getQtItensImportados() + " importados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("Ferramenta com falha");
					}
				}

				
				
				daoERP.flushReiniciandoTransacao();
				
				
				// Avalia se importa produto
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoBOM.getId())) {
					log.info(idLog, 10, "Vou importar o produto");
					IntegracaoTDBAProdutoRN rn = new IntegracaoTDBAProdutoRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou importacao produto com " + rn.getQtItensImportados() + " importados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("Produto com falha");
					}
				}

				
				
				daoERP.flushReiniciandoTransacao();
				
				
				// Avalia se importa folha de processo
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoFolha.getId())) {
					log.info(idLog, 10, "Vou importar folha de processo");
					IntegracaoTDBAFolhaRN rn = new IntegracaoTDBAFolhaRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou importacao folha processo com " + rn.getQtItensImportados() + " importados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("Folha processo com falha");
					} else {
						rn.qtItensImportados = 0;
						resultado = rn.integrarCiclos(joblog, det, log, idLog);
						log.info(idLog, 10, "Finalizou importacao da folha ciclos com " + rn.getQtItensImportados() + " importados");
						qtItensImportados += rn.getQtItensImportados();
						if (resultado == false) {
							isSucesso = false;
							dsImportacao.append("Folha de ciclos com falha");
						}
					}
				}
				
				daoERP.flushReiniciandoTransacao();

				// Avalia se importa usuarios
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoUsuario.getId())) {
					log.info(idLog, 10, "Vou importar usuarios");
					IntegracaoTDBAUsuarioRN rn = new IntegracaoTDBAUsuarioRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou importacao usuarios com " + rn.getQtItensImportados() + " importados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("Usuarios com falha");
					}
				}

				
				daoERP.flushReiniciandoTransacao();
				
				// Avalia se importa OP
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoOP.getId())) {
					log.info(idLog, 10, "Vou importar OP");
					IntegracaoTDBAOPRN rn = new IntegracaoTDBAOPRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou importacao OP com " + rn.getQtItensImportados() + " importados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("OP com falha");
					}
				}
				
				
				daoERP.flushReiniciandoTransacao();
				
				
				// Avalia exportacao producao
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ExportacaoProducao.getId())) {
					log.info(idLog, 10, "Vou exportar produção");
					IntegracaoTDBAProducaoRN rn = new IntegracaoTDBAProducaoRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou exportação produção com " + rn.getQtItensImportados() + " exportados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("Produção com falha");
					}
				}

				
				daoERP.flushReiniciandoTransacao();

				
				// Avalia exportacao paradas
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ExportacaoParada.getId())) {
					log.info(idLog, 10, "Vou exportar paradas");
					IntegracaoTDBAParadaRN rn = new IntegracaoTDBAParadaRN(getDao(), daoERP);
					boolean resultado = rn.integrar(joblog, det, log, idLog);
					log.info(idLog, 10, "Finalizou exportação paradas com " + rn.getQtItensImportados() + " exportados");
					qtItensImportados += rn.getQtItensImportados();
					if (resultado == false) {
						isSucesso = false;
						dsImportacao.append("Parada com falha");
					}
				}

			}

			if (isSucesso == false) {
				joblog.setStExecucao(OmJoblogTemplate._StExecucao.ERRO.getValue());
				joblog.setDsExecucao(dsImportacao.toString());
			} else {
				if (qtItensImportados > 0)
					joblog.setDsExecucao("Sucesso com " + qtItensImportados + " importados.");
				else
					joblog.setDsExecucao("Sucesso. Sem itens importados.");
			}

			joblog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());

			getDao().getSessionStateless().update(joblog);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 5, "Excessao:", e);
		} finally {
			log.info(idLog, 5, "FIM TDBA");
			daoERP.finalizaConexaoBanco();
		}
	}
}

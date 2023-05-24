package idw.model.rn.integracao.arquivotexto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmJob;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.template.OmJobRecursoTemplate;
import idw.model.pojos.template.OmJoblogTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.integracao.AIntegracaoBackground;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;

public class IntegracaoArquivoTextoRN extends AIntegracaoBackground{

	public IntegracaoArquivoTextoRN() {
		super(new DAOGenerico());
	}
	public IntegracaoArquivoTextoRN(DAOGenerico dao) {
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
			

			// Obtem a lista de arquivos do diretorio de origem
			String[] arquivos = ArquivosDiretorios.getArquivosNoDiretorio(det.getUrlOrigem());
			
			// Se nao existir nenhum arquivo pode ser que a urlOrigem seja um arquivo especifico. Nesse caso
			// testar o arquivo
			if (arquivos == null) {
				if (ArquivosDiretorios.isExisteArquivo(det.getUrlOrigem())) {
					arquivos = new String[]{det.getUrlOrigem()};
				}
						
			}
			
			// Filtra os arquivos que ainda nao foram processados com sucesso
			List<String> arquivosFiltrados = filtrarArquivos(arquivos, det);
			
			for (String arq : arquivosFiltrados) {
				
				log.info(idLog, 0, "Avaliando arquivo " + arq);
			
				// Se importar BOM
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoBOM.getId())) {
					IntegracaoBOMRN rn = new IntegracaoBOMRN();
					log.info(idLog, 0, "Vou importar o BOM");
					isImportouAlgo = rn.integrarBOM(joblog, det, arq, getDao());
					log.info(idLog, 0, "Finalizou o BOM = " + isImportouAlgo);
					if ( isImportouAlgo == false) {
						isSucesso = false;
						dsImportacao.append("BOM falhou");
					}
				}
	
				// Se importar OP
				if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoOP.getId())) {
					IntegracaoOPRN rn = new IntegracaoOPRN();
					log.info(idLog, 0, "Vou importar o OP");
					int st = rn.integrarOP(joblog, det, arq, getDao(), log, idLog);
					log.info(idLog, 0, "Finalizou a OP = " + st);
					if ( st == IntegracaoOPRN._ResultadoIntegracao.ERRO.getValue()) {
						isSucesso = false;
						dsImportacao.append("OP falhou");
					} else if (st == IntegracaoOPRN._ResultadoIntegracao.SUCESSO_COM_ADVERTENCIA.getValue()) {
						isSucesso = false;
						dsImportacao.append("OP com advertência");
					} else if (st == IntegracaoOPRN._ResultadoIntegracao.SUCESSO.getValue()) {
						isSucesso = false;
						dsImportacao.append("OPs importadas.");
					}
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

	/* Pega todos os arquivos que ainda nao tenham sido processados
	 * 
	 */
	private List<String> filtrarArquivos(String[] arquivos, OmJobdet det) {
		List<String> retorno = new ArrayList<>();
		
		if (arquivos == null)
			return retorno;
		
		MapQuery q = new MapQuery(getDaoSessionStatless());
		q.append("select a");
		q.append("from OmJobdetlog a");
		q.append("where a.urlOrigem = :url");
		q.append("and a.omJobdet = :omjobdet");
		q.append("and a.stExecucao = 1");
		q.append("order by a.idJobdetlog desc");
		
		q.defineParametro("omjobdet", det);
		
		for (int i = 0; i < arquivos.length; i++) {
			String dthrCriacao = DataHoraRN.dateToStringYYYYMMDDHHMMSS(ArquivosDiretorios.getDtHrModificacao(arquivos[i]));
			String idArquivo = arquivos[i] + dthrCriacao;
			
			q.defineParametro("url", idArquivo);
			q.setMaxResults(1);
			
			OmJobdetlog joblog = (OmJobdetlog) q.uniqueResult();
			
			if (joblog == null)
				retorno.add(arquivos[i]);
			
			joblog = null;
		}
		
		return retorno;
	}


}

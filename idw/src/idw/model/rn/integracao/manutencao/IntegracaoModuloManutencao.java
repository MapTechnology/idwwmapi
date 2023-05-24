package idw.model.rn.integracao.manutencao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.manutencao.DAOGenericoManutencao;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmJob;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpIndisp;
import idw.model.pojos.PpIndispRappt;
import idw.model.pojos.manutencao.ServidorAtividadesordem;
import idw.model.pojos.manutencao.ServidorOrdemmanutencao;
import idw.model.pojos.template.OmJobRecursoTemplate;
import idw.model.pojos.template.OmJoblogTemplate;
import idw.model.pojos.template.PpIndispRapptTemplate;
import idw.model.pojos.template.PpIndispTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.PlanoIndisponibilidadeRN;
import idw.model.rn.integracao.AIntegracaoBackground;
import idw.util.IdwLogger;
import idw.util.Util;

public class IntegracaoModuloManutencao extends AIntegracaoBackground{

	public IntegracaoModuloManutencao() {
		super(new DAOGenerico());
	}
	public IntegracaoModuloManutencao(DAOGenerico dao) {
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
			
			if (det.getOmJobRecurso().getIdJobRecurso().equals(OmJobRecursoTemplate._TipoRecurso.ImportacaoIndisponibilidade.getId())) {
				log.info(idLog, 0, "Vou importar as indisponibilidades");
				isImportouAlgo = integrarIndisponibilidades(joblog, det, log, idLog);
				log.info(idLog, 0, "Finalizou indisponibilidade = " + isImportouAlgo);
				if ( isImportouAlgo == false) {
					isSucesso = false;
					dsImportacao.append("Indisponibilidades finalizou com falha");
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

	
	private boolean integrarIndisponibilidades(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean isretorno = false;
		
		OmCfg omcfg = Util.getConfigGeral(getDao().getSessionStateless());
		
		DAOGenericoManutencao daoM = new DAOGenericoManutencao();
		
		try {
			daoM.iniciaConexaoBanco();
			
			MapQuery q = new MapQuery(daoM.getSession());
			
			q.append("select a");
			q.append("from ServidorOrdemmanutencao a");
			q.append("join fetch a.servidorAtividades b");
//			q.append("where a.tipo = 1"); desabilitado para teste

			List<ServidorOrdemmanutencao> lista = q.list();
			
			for (ServidorOrdemmanutencao om : lista) {
				PpIndisp indisp = obtemOuIncluiPPIndisp(om, omcfg);
				ServidorAtividadesordem inicio = obtemInicio(om);
				ServidorAtividadesordem fim = obtemFim(om);
				
				incluirOuAlterarPpIndisp(indisp, om, inicio, fim, log, idLog);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			isretorno = false;
		} finally {
			daoM.finalizaConexaoBanco();
		}
		
		return isretorno;
	}
	
	private void incluirOuAlterarPpIndisp(PpIndisp indisp, ServidorOrdemmanutencao om, ServidorAtividadesordem inicio, ServidorAtividadesordem fim, IdwLogger log, int idLog) {
		// Incluir em PpIndispRapPt
		Date dthrInicio = DataHoraRN.stringToDate(inicio.getDataInicio(), "yyyy-MM-dd HH:mm:ss");
		Date dthrFim = DataHoraRN.stringToDate(fim.getDataInicio(), "yyyy-MM-dd HH:mm:ss");
		
		/* encontra o pT */
		OmPt ompt;

		PTRN prn = new PTRN(getDao());
		try {
			ompt = prn.getOmPt(om.getServidorConjuntos().getNome());
		} catch (RegistroDesconhecidoException e) {
			log.info("O PT " + om.getServidorConjuntos().getNome() + " desconhecido.");
			return;
		}
		
		/* Procura se ja existe o registro da indisponibilidade */
		PpIndispRappt indispt = obtemIndisPt(indisp, om, dthrInicio, dthrFim, ompt);
		
		if (indispt == null) {
			
			indispt = new PpIndispRappt();
			
			indispt.setDsIndispRappt(inicio.getDescricao());
			
			indispt.setDthrInicio(dthrInicio);
			indispt.setDthrFinal(dthrFim);
	
			indispt.setIdIndispRappt(null);
			indispt.setOmPt(ompt);
			indispt.setPpIndisp(indisp);
			indispt.setQtIndisp(BigDecimal.ONE);
			indispt.setTpRecurso(PpIndispRapptTemplate._TpRecurso._PT.getValue());
			
			getDao().makePersistent(indispt);
		}		
		
	}
	
	private PpIndispRappt obtemIndisPt(PpIndisp indisp, ServidorOrdemmanutencao om, Date dthrInicio, Date dthrFim, OmPt ompt) {
		PpIndispRappt retorno = null;
		
		for (PpIndispRappt indisppt : indisp.getPpIndispRappts()) {
			if (DataHoraRN.compareTo(indisppt.getDthrInicio(), dthrInicio) == 0 && 
					DataHoraRN.compareTo(indisppt.getDthrFinal(), dthrFim) == 0 &&
					indisppt.getOmPt() != null &&
					indisppt.getOmPt().getCdPt().equals(om.getServidorConjuntos().getNome()) ){
				retorno = indisppt;
			}
		}
		
		return retorno;
	}
	
	private ServidorAtividadesordem obtemFim(ServidorOrdemmanutencao om) {
		List<ServidorAtividadesordem> lista = new ArrayList<>(om.getServidorAtividades());
		Collections.sort(lista, new Comparator<ServidorAtividadesordem>() {
			@Override
			public int compare(ServidorAtividadesordem o1, ServidorAtividadesordem o2) {
				return o1.getDataInicio().compareTo(o2.getDataInicio()) * -1;
			}
		});
		
		return lista.get(0);
	}
	
	private ServidorAtividadesordem obtemInicio(ServidorOrdemmanutencao om) {
		List<ServidorAtividadesordem> lista = new ArrayList<>(om.getServidorAtividades());
		Collections.sort(lista, new Comparator<ServidorAtividadesordem>() {
			@Override
			public int compare(ServidorAtividadesordem o1, ServidorAtividadesordem o2) {
				return o1.getDataInicio().compareTo(o2.getDataInicio());
			}
		});
		
		return lista.get(0);
	}
	
	private PpIndisp obtemOuIncluiPPIndisp(ServidorOrdemmanutencao om, OmCfg omcfg) {
		PlanoIndisponibilidadeRN rn = new PlanoIndisponibilidadeRN(getDao());
		rn.setCdIndisp(om.getCodigo());
		PpIndisp indisp = rn.pesquisarPlanoByCdESt();
		
		if (indisp == null) {
			indisp = new PpIndisp();
			
			indisp.setIdIndisp(null);
			indisp.setCdIndisp(om.getCodigo());
			indisp.setDsIndisp(om.getDescricao());
			indisp.setDtRevisao(DataHoraRN.getDataHoraAtual());
			indisp.setDtStativo(indisp.getDtRevisao());
			indisp.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			indisp.setOmUsrByIdUsrstativo(indisp.getOmUsrByIdUsrrevisao());
			indisp.setRevisao(1l);
			indisp.setStAtivo(1);
			indisp.setStIndisp(PpIndispTemplate._StIndisp.USARPLANEJAMENTO.getValue());
			
			getDao().makePersistent(indisp);
		}
		
		return indisp;
	}

}

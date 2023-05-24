package idw.model.rn.consolidacao.parada;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.Transaction;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolidDAO;
import idw.model.dao.DwConsolpalogDAO;
import idw.model.dao.DwConsolptDAO;
import idw.model.dao.OmPtDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.alerta.ConsolidacaoInicioAlerta;
import idw.util.IdwLogger;
import idw.util.Util;
import injetws.model.excessoes.SemSGBDException;

/**
 * Faz o tratamento da consolidação de parada aberta.
 * <p>
 * Quando uma parada está aberta, seu período precisa ser contabilizado nos cálculos de indicadores. Então depois que os eventos da máquina
 * são processados, {@link #consolidar()} é chamado, identificando se tem uma parada aberta, e se tiver, seu tempo será incluído incluído no
 * banco de dados. É como se a parada fosse "fechada" no momento da avaliação.
 *
 * @author Milton
 *
 */
public class ConsolidacaoParadaAberta {
	private static final int TEMPO_LIMITE_CONSOLIDACAO_PARADA_ABERTA_EM_HORAS = 6;
	private static final int TEMPO_MINIMO_PARA_CONSOLIDACAO_PARADA_ABERTA_EM_SEGUNDOS = 30;
	private final DAOGenerico dao;
	private final String cdPt;
	private final IdwLogger log;
	private final int idLog;
	private int identacao;

	public ConsolidacaoParadaAberta(DAOGenerico dao, String cdPt) {
		super();
		this.dao = dao;
		this.cdPt = cdPt;
		this.log = new IdwLogger("ConsolidacaoParadaAberta-" + cdPt);
		this.idLog = this.log.getIdAleatorio();
		this.identacao = 0;
	}

	public void consolidar() {

		Transaction tx = null;
		OmPt omPt = null;
		try {
			log.info(idLog, identacao, "INICIO - ConsolidacaoParadaAberta");
			
			identacao += 5;

			tx = dao.getSession().beginTransaction();

			OmPtDAO omPtDAO = new OmPtDAO(dao.getSession());
			omPt = omPtDAO.getOmPtPorCdAtivoOrderById(cdPt);

			DwConsolpt dwConsolpt = null;
			
			if (omPt != null) {
				DwConsolptDAO dwConsolptDAO = new DwConsolptDAO(dao.getSession());
				dwConsolpt = dwConsolptDAO.getDwConsolpt(omPt);
			}
			
			if (dwConsolpt != null) {

				DwConsolpalog dwConsolpalog = dwConsolpt.getDwConsolpalog();
				boolean isParadaAberta = (dwConsolpalog != null) && (dwConsolpalog.isAberta());
				if (isParadaAberta) {

					checarSeTemMaisDeUmaParadaAberta(omPt);

					if (dwConsolpalog.getDthrFparadaAb() == null) {
						dwConsolpalog.setDthrFparadaAb(dwConsolpalog.getDthrIparada());
					}

					Date dtHrFParRef = getDtHrFRef(dwConsolpalog.getDthrFparadaAb());

					if (DataHoraRN.before(dwConsolpalog.getDthrFparadaAb(), dtHrFParRef)) {

						int tempoParaConsolidar = DataHoraRN.getQuantidadeSegundosNoPeriodo(dwConsolpalog.getDthrFparadaAb(), dtHrFParRef);
						if (tempoParaConsolidar > TEMPO_MINIMO_PARA_CONSOLIDACAO_PARADA_ABERTA_EM_SEGUNDOS) {
							if (omPt.getIsConsolpendente()) {
								log.info(idLog, identacao, "Consolidação de parada aberta não será realizada porque há eventos pendentes de consolidação. Pt: " + omPt.getCdPt() + " parada: " + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwConsolpalog.getDthrIparada()));
							} else {
								consolidarParadaAberta(dwConsolpt, dwConsolpalog, dtHrFParRef);
							}
							verificarParadaExtrapolada(omPt, dwConsolpt, dwConsolpalog, dtHrFParRef);
						}

					}

				}

			}

			tx.commit();

		} catch (Exception e) {
			if (omPt != null) {
				log.info(idLog, identacao, "erro consolidacaoParadaAberta para o pt " + omPt.getCdPt(), e);
			}
			
			e.printStackTrace();

			log.info(e.getMessage(), e);

			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);

		} finally {
			dao.clear();
			
			log.info(idLog, 0, "FIM - ConsolidacaoParadaAberta");
		}

	}

	private void checarSeTemMaisDeUmaParadaAberta(OmPt omPt) {
		DwConsolpalogDAO dwConsolpalogDAO = new DwConsolpalogDAO(dao.getSession());
		List<DwConsolpalog> paradasAbertas = dwConsolpalogDAO.getParadasAbertas(omPt.getIdPt());
		if (paradasAbertas.size() > 1) {
			StringBuilder sb = new StringBuilder();
			for (DwConsolpalog dwConsolpalog : paradasAbertas) {
				sb.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dwConsolpalog.getDthrIparada()));
				sb.append(" ");
			}

			throw new IllegalStateException(
					"Consolidação de parada aberta não pode rodar, "
							+ "pois existe mais de uma paradas aberta para o posto de trabalho. "
							+ " Pt: " + cdPt + " paradas: " + sb.toString());
		}

	}

	private void consolidarParadaAberta(DwConsolpt dwConsolpt, DwConsolpalog dwConsolpalog, Date dtHrFParRef) throws SemCalendarioException, SemPlanejamentoException, SemSGBDException, SemCicloPadraoException {

		OmCfg omCfg = Util.getConfigGeral(dao.getSession());

		DwConsolidDAO dwConsolidDAO = new DwConsolidDAO(dao.getSession());
		DwConsolid ultimoDwConsolidParada = dwConsolidDAO.getUltimoDwConsolidParada(dwConsolpalog, TpId.TURNO);
		
		Validate.notNull(ultimoDwConsolidParada, "ultima parada desconhecida para dwconsolpalog.id=" + dwConsolpalog.getIdConsolpalog() + " do pt " + dwConsolpalog.getOmPt().getCdPt());
		
		PpCp ppCp = ultimoDwConsolidParada.getPpCp();
		DwFolha dwFolha = ultimoDwConsolidParada.getDwFolha();
		DwPepro dwPepro = ultimoDwConsolidParada.getDwPepro();

		ConsolidacaoParada consolidacaoParada = new ConsolidacaoParada(dao);
		
		
		ConsolidacaoPeriodoParada consolidacaoPeriodoParada = new ConsolidacaoPeriodoParada(log, idLog, identacao, consolidacaoParada, omCfg, dwConsolpt, ppCp, dwFolha, dwPepro, true);

		// abate tempo se necessário
		boolean isAbaterTempoParada = consolidacaoParada.isAbaterTempoParada(dwConsolpt, dwConsolpalog, dwConsolpalog.getDwTParada(), dtHrFParRef);
		if (isAbaterTempoParada) {
			Date dtHrFRef = (dwConsolpalog.getDthrFparadaAb() == null ? dwConsolpalog.getDthrIparada() : dwConsolpalog.getDthrFparadaAb());

			log.info(idLog, identacao, "Abatendo tempo consolidado de parada aberta. Pt:" + cdPt
					+ " parada: " + DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dwConsolpalog.getDthrIparada())
					+ " periodo: "
					+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dwConsolpalog.getDthrIparada()) + " - "
					+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dtHrFRef));

			consolidacaoPeriodoParada.consolidar(true, dwConsolpalog.getDthrIparada(), dtHrFRef, dwConsolpalog, null, "abatendo-ConsolidacaoParadaAberta");
			dwConsolpalog.setDthrFparadaAb(dwConsolpalog.getDthrIparada());
		}

		// Continua consolidação de parada de onde parou
		Date dtHrIParRef = dwConsolpalog.getDthrFparadaAb();

		log.info(idLog, identacao, "Consolidando tempo de parada aberta. Pt:" + cdPt
				+ " parada: " + DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dwConsolpalog.getDthrIparada())
				+ " periodo: "
				+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dtHrIParRef) + " - "
				+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dtHrFParRef));

		consolidacaoPeriodoParada.consolidar(false, dtHrIParRef, dtHrFParRef, dwConsolpalog, null, "ConsolidacaoParadaAberta");
		dwConsolpalog.setDthrFparadaAb(dtHrFParRef);

	}
	
	/**
	 * Metodo responsavel em tratar a extrapolacao da parada
	 * @throws SemCalendarioException 
	 * @throws EventoInvalidoException 
	 * @throws RegistroDesconhecidoException 
	 * @throws SemPlanejamentoException 
	 * @throws SemCicloPadraoException 
	 * @throws SemSGBDException 
	 * @throws IllegalArgumentException 
	 */
	private void verificarParadaExtrapolada(OmPt ompt, DwConsolpt dwConsolpt, DwConsolpalog dwConsolpalog, Date dtHrFParRef) throws SemCalendarioException, IllegalArgumentException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException, RegistroDesconhecidoException, EventoInvalidoException {
		// Verifica se a parada em aberto extrapolou
		int segDuracao = DataHoraRN.getQuantidadeSegundosNoPeriodo(dwConsolpalog.getDthrIparada(), dtHrFParRef);

		TurnoRN turnoRN = new TurnoRN(dao);
		OmCfg omcfg = null;
		List<DwCalsem> dwCalsems = null;
		
		// Verifica se extrapolou para abertura de alerta
		if (dwConsolpalog.getDwTParada().getSegTimeoutalerta() != null && segDuracao >= dwConsolpalog.getDwTParada().getSegTimeoutalerta().intValue()) {
			// Verifica se ja existe alerta de extrapolacao em aberto
			ConsolidaRN rn = new ConsolidaRN(dao);
			/* Alessandre em 24-05-22 linha abaixo substituida pela seguinte para atender ao chamado #7840
			 * pois o alerta a ser pesquisado deve ser o alerta com a data e hora de inicio em questão mesmo que já tenha sido aberto e fechado anteriormente
			DwConsolallog allog = rn.getDwConsolalLogAbertoDepoisDoHorario(dwConsolpalog.getOmPt(), dwConsolpalog.getDwTParada().getDwTAlerta(), dwConsolpalog.getDthrIparada());
			 */
			DwConsolallog allog = rn.getDwConsolalLogAbertoDepoisDoHorario(dwConsolpalog.getOmPt(), dwConsolpalog.getDwTParada().getDwTAlerta(), dwConsolpalog.getDthrIparada());
			
			// Extrapolou. Lancar abertura de alerta se ainda tiver sido lancado
			if (allog == null)  {
				ConsolidacaoInicioAlerta crn = new ConsolidacaoInicioAlerta();
				crn.setDao(dao);
				omcfg = Util.getConfigGeral(dao.getSession());
				MsEvt msevt = new MsEvt();
				dao.evict(msevt);
				
				Date dtHrFParRefAux = DataHoraRN.subtraiSegundosDaData(dtHrFParRef, (segDuracao - dwConsolpalog.getDwTParada().getSegTimeoutalerta().intValue()));

				msevt.setDthrEvento(dtHrFParRefAux);
				msevt.setCdAlerta(dwConsolpalog.getDwTParada().getDwTAlerta().getCdTalerta());
				msevt.setNrop(dwConsolpalog.getOmPt().getMsPtColeta().getNrop());
				//msevt.setDwPepro(dwPepro); de onde pegar???
				
				dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(dwConsolpalog.getOmPt(), dtHrFParRefAux);
				crn.executarConsolidacao(dwConsolpalog.getOmPt(), dwConsolpt, dwCalsems, msevt, omcfg, log, 0, 0);
			}
			
			
		}
		
		
		verificarParadaExtrapolacaoParada(ompt, dwConsolpt, dwConsolpalog, dtHrFParRef, segDuracao, turnoRN, omcfg, dwCalsems);
	}

	/* Metodo para avaliar se a parada pode ser extrapaloada e se for fechar e abrir nova parada
	 * 
	 */
	private void verificarParadaExtrapolacaoParada(OmPt ompt, DwConsolpt dwConsolpt, DwConsolpalog dwConsolpalog, Date dtHrFParRef,
			int segDuracao, TurnoRN turnoRN, OmCfg omcfg, List<DwCalsem> dwCalsems) throws SemCalendarioException, SemSGBDException,
			SemCicloPadraoException, SemPlanejamentoException, RegistroDesconhecidoException, EventoInvalidoException {
		
		// Verifica se extrapolou para abertura de outra parada
		if (dwConsolpalog.getDwTParada().getSegExtrapolacao() != null)
			log.info(idLog, 0, "verificando extrapolacao idTparada=" + dwConsolpalog.getDwTParada().getIdTparada() + " segDuracao=" + segDuracao + " limite=" + dwConsolpalog.getDwTParada().getSegExtrapolacao());
		
		if (	dwConsolpalog.getDwTParada().getSegExtrapolacao() != null && 
				dwConsolpalog.getDwTParada().getSegExtrapolacao().compareTo(BigDecimal.ZERO) > 0 &&
				segDuracao >= dwConsolpalog.getDwTParada().getSegExtrapolacao().intValue()) {

			log.info(idLog, 0, "extrapolou idTparada="+ dwConsolpalog.getDwTParada().getIdTparada() + " segDuracao=" + segDuracao + " limite=" + dwConsolpalog.getDwTParada().getSegExtrapolacao());
			if (omcfg == null) {
				omcfg = Util.getConfigGeral(dao.getSession());
			}
			
			if (dwCalsems == null) {
				dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(dwConsolpalog.getOmPt(), dtHrFParRef);
			}

			// Recalculando a data e hora de referencia para "bater" o final exatamente com o tempo da extrapolacao. Ou seja, se a duracao
			Date dtHrFParRefAux = DataHoraRN.subtraiSegundosDaData(dtHrFParRef, (segDuracao - dwConsolpalog.getDwTParada().getSegExtrapolacao().intValue()));
			
			// Se extrapolou a parada, entao fechar a parada e abrir uma nova com outro motivo
			ConsolidacaoFimParada frn = new ConsolidacaoFimParada(dao);
			MsEvt msEvtFParada = new MsEvt();
			dao.evict(msEvtFParada);
			msEvtFParada.setDthrEvento(dtHrFParRefAux);
			msEvtFParada.setNrop(dwConsolpalog.getOmPt().getMsPtColeta().getNrop());
			// Iniciar nova parada
			ConsolidacaoInicioParada irn = new ConsolidacaoInicioParada(dao);
			MsEvt msEvtIParada = new MsEvt();
			dao.evict(msEvtIParada);
			msEvtIParada.setDthrEvento(dtHrFParRefAux);
			msEvtIParada.setNrop(dwConsolpalog.getOmPt().getMsPtColeta().getNrop());
			if (msEvtIParada.getNrop() == null)
				msEvtIParada.setNrop(dwConsolpalog.getOmPt().getPpCp().getNrop());
			
			// Consolidar novo motivo de parada
			ConsolidacaoMotivoParada prn = new ConsolidacaoMotivoParada();
			prn.setDao(dao);
			MsEvt msEvtMotivo = new MsEvt();
			dao.evict(msEvtMotivo);
			msEvtMotivo.setDthrEvento(dtHrFParRefAux);
			msEvtMotivo.setCdParada(dwConsolpalog.getDwTParada().getDwTParadaextra().getCdTparada());
			msEvtMotivo.setNrop(dwConsolpalog.getOmPt().getMsPtColeta().getNrop());

			
			frn.executarConsolidacao(dwConsolpalog.getOmPt(), dwConsolpt, dwCalsems, msEvtFParada, omcfg, log, 0, 0);

			irn.executarConsolidacao(dwConsolpalog.getOmPt(), dwConsolpt, dwCalsems, msEvtIParada, omcfg, log, 0, 0);

			prn.executarConsolidacao(dwConsolpalog.getOmPt(), dwConsolpt, dwCalsems, msEvtMotivo, omcfg, log, 0, 0);
			
			// Alterar MsPtColeta para o heartbeat poder informar ao coletor os dados da nova parada aberta
			ompt.getMsPtColeta().setDthrIparada(dtHrFParRefAux);
			ompt.getMsPtColeta().setDwTParada(dwConsolpalog.getDwTParada().getDwTParadaextra());
			ompt.getMsPtColeta().setIsParada(true);
			dao.makePersistent(ompt.getMsPtColeta());
		}
	}

	private Date getDtHrFRef(Date dthHrIRef) {
		Date dtHrFRef = DataHoraRN.getDataHoraAtual();

		// Data de início maior que fim, vai usar o início como referencia do fim
		if (DataHoraRN.compareTo(dthHrIRef, dtHrFRef) >= 0) {
			return dthHrIRef;
		} else {
			int horas = DataHoraRN.getQuantidadeHorasNoPeriodo(dthHrIRef, dtHrFRef);
			if (horas > TEMPO_LIMITE_CONSOLIDACAO_PARADA_ABERTA_EM_HORAS) {
				dtHrFRef = DataHoraRN.adicionaHorasDaData(dthHrIRef, TEMPO_LIMITE_CONSOLIDACAO_PARADA_ABERTA_EM_HORAS);
			}

			/*
			 * Remove miliseconds da data, porque os campos data do Oracle não são compatíveis com milissegundos. Então ele consolidava a
			 * primeira vez corretamente, mas na proxima vez, ao continuar de onde parou, não considerava queiniciava as 2017/07/12
			 * 01:01:01.600", e sim "2017/07/12 01:01:01", consolidando novamente este 600 milissegundos.
			 */
			dtHrFRef = DataHoraRN.getDataSemMilissegundo(dtHrFRef);

			return dtHrFRef;
		}

	}
}

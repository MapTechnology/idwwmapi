package idw.model.rn.consolidacao.parada;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolidDAO;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalsem;
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
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.model.rn.consolidacao.alerta.ConsolidacaoFimAlerta;
import idw.model.rn.consolidacao.planejamento.ConsolidacaoPlanejamento;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimParada extends ConsolidacaoParada implements IConsolidacao {

	public ConsolidacaoFimParada(){
		super();
	}
	
	public ConsolidacaoFimParada(DAOGenerico dao) {
		super(dao);
	}


	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt,
			List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log,
			int idLog, int identacao) throws SemCalendarioException,
			SemSGBDException, SemCicloPadraoException,
			SemPlanejamentoException, RegistroDesconhecidoException,
			IllegalArgumentException, EventoInvalidoException {

		
		Date dtHrFimParada = msEvt.getDthrEvento();
		
		Validate.notNull(omPt, "Posto de trabalho esta nulo");
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");

		if (dtHrFimParada == null) {
			throw new EventoInvalidoException(msEvt, "Fim da parada esta nulo");
		}
		
		DwConsolpalog dwConsolpalog = dwconsolpt.getDwConsolpalog();
		if (dwConsolpalog == null ) {
			dwConsolpalog = this.getUltimaParadaFromDwConsolpalog(omPt);
			if (dwConsolpalog == null) {
				throw new EventoInvalidoException(msEvt, "Parada anterior não encontrada");
			}
		}
			
		if (!dwConsolpalog.isAberta()) {
			throw new EventoInvalidoException(msEvt, "Parada ja esta fechada. idConsolpalog=" + dwConsolpalog.getIdConsolpalog());
		}
		log.info(idLog, identacao, "consolidarFimParada - INICIO");
		consolidarFimParada(omPt, dwconsolpt, omcfg, log, idLog, identacao + 5, dtHrFimParada, dwConsolpalog);
		log.info(idLog, identacao, "consolidarFimParada - FIM");

		ConsolidacaoPlanejamento consolidacaoPlanejamento = new ConsolidacaoPlanejamento(getDao());
		consolidacaoPlanejamento.setInicioPpCpentsai(dwConsolpalog.getPpCp(), omPt, dwConsolpalog.getDthrIparada());
		log.info(idLog, identacao, "executou planejamento");
		
		/* Se a parada for de abertura de alerta automaticamente, entao esse alerta deve ser fechado ao se fechar a parada
		 * 
		 */
		if (dwConsolpalog.getDwTParada().getDwTAlerta() != null) {
			// Fechar alerta em aberto
			ConsolidacaoFimAlerta rn = new ConsolidacaoFimAlerta(getDao());
			try {
				MsEvt msEvtAlerta = new MsEvt();
				getDao().evict(msEvtAlerta);
				msEvtAlerta.setDthrEvento(msEvt.getDthrEvento());
				msEvtAlerta.setCdAlerta(dwConsolpalog.getDwTParada().getDwTAlerta().getCdTalerta());
				msEvtAlerta.setMsMsicup(msEvt.getMsMsicup());
				msEvtAlerta.setDwPepro(msEvt.getDwPepro());
				msEvtAlerta.setNrop(msEvt.getNrop());
				msEvtAlerta.setCdProduto(msEvt.getCdProduto());

				log.info(idLog, identacao, "vou executar fim alerta");
				rn.executarConsolidacao(omPt, dwconsolpt, dwCalsems, msEvtAlerta, omcfg, log, idLog, identacao);
				log.info(idLog, identacao, "executou fim alerta");
			} catch (ReprocessarMsEvtException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumeroSerieIrregularException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CicloJaContabilizadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void consolidarFimParada(OmPt omPt, DwConsolpt dwconsolpt, OmCfg omcfg, IdwLogger log, int idLog, int identacao,
			Date dtHrFimParada, DwConsolpalog dwConsolpalog)
			throws SemCalendarioException, SemPlanejamentoException, SemSGBDException, SemCicloPadraoException {
		List<DwCalsem> dwCalsems;
		DwConsolidDAO dwConsolidDAO = new DwConsolidDAO(getDaoSession());		
		DwConsolid ultimoDwConsolidParada = dwConsolidDAO.getUltimoDwConsolidParada(dwConsolpalog, TpId.TURNO);
		
		// Usa as mesmas configurações do início de parada
		PpCp ppCp = ultimoDwConsolidParada.getPpCp();
		DwCal dwCal = ultimoDwConsolidParada.getDwCal();
		DwFolha dwFolha = ultimoDwConsolidParada.getDwFolha();
		DwPepro dwPepro = ultimoDwConsolidParada.getDwPepro();		
		TurnoRN turnoRN = new TurnoRN(getDao());
		dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidos(dwCal.getIdCal());

		consolidarFimParada(omPt, dwconsolpt, dwCalsems, ppCp, dwFolha, dwConsolpalog, dtHrFimParada, omcfg, log, idLog, identacao, dwPepro);
	}

	/**
	 * Consolidar o final de parada
	 * @param omPt
	 * @param dwConsolpt
	 * @param ppCp
	 * @param dwFolha
	 * @param dwConsolpalog
	 * @param dtHrFimParada
	 * @param omcfg
	 * @param log
	 * @throws SemPlanejamentoException
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 * @throws SemCicloPadraoException
	 */
	public void consolidarFimParada(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, 
			DwFolha dwFolha, DwConsolpalog dwConsolpalog, Date dtHrFimParada, OmCfg omcfg, 
			IdwLogger log, int idLog, int identacao, DwPepro dwPepro) 
					throws SemPlanejamentoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		Validate.notNull(omPt, "Posto de trablaho estsa nulo");
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");
		Validate.notNull(ppCp,"ppCp esta nulo");
		Validate.notNull(dwFolha, "dwFolha esta nulo");
		Validate.notNull(dwConsolpalog, "dwConsolpalog esta nulo");

		Date dtHrInicioParada = dwConsolpalog.getDthrIparada();
		
		if (DataHoraRN.before(dtHrFimParada, dtHrInicioParada)) {
			log.novaMensagem();
			log.addMensagem("Inicio de parada é maior que fim. Irá assumir a mesma data de início para finalização.  dtHrInicioParada:");
			log.addMensagem(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrInicioParada));
			log.addMensagem(" dtHrFimParada:");
			log.addMensagem(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHrFimParada));
			log.addMensagem(" Pt: ");
			log.addMensagem(omPt.getCdPt());
			log.info(idLog, identacao);
			
			dtHrFimParada = dtHrInicioParada;
		}
		
		ConsolidacaoPeriodoParada consolidacaoPeriodoParada = new ConsolidacaoPeriodoParada(log, idLog, identacao, this, omcfg, dwConsolpt, ppCp, dwFolha, dwPepro, true);

		/*
		O trecho abaixo verifica se é necessário abater o tempo das paradas dos periodos que já passaram (turno ou hora)
		Se for o caso, entao a data de referencia de fim de parada SEMPRE deve ser o fim da parada que veio pelo evento e NUNCA com o 
		fim da parada em aberto pois o fim da parada em aberto leva em conta o horario do servidor que na maior parte dos casos nao esta sincronizada com os coletores
		*/
		boolean isAbaterTempoParada = isAbaterTempoParada(dwConsolpt, dwConsolpalog, dwConsolpalog.getDwTParada(), dtHrFimParada);
		if (isAbaterTempoParada) {			
			Date dtHrFRef = (dwConsolpalog.getDthrFparadaAb() == null ? dwConsolpalog.getDthrIparada() : dwConsolpalog.getDthrFparadaAb());
			log.novaMensagem();
			log.addMensagem("Abatendo tempo consolidado de parada aberta. Pt:");
			log.addMensagem(omPt.getCdPt());
			log.addMensagem(" parada: ");
			log.addMensagem(DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dwConsolpalog.getDthrIparada()));
			log.addMensagem(" periodo: ");
			log.addMensagem(DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dwConsolpalog.getDthrIparada()));
			log.addMensagem(" - ");
			log.addMensagem(DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dtHrFRef));
			log.info(idLog, identacao);
			
			// como true está sendo passado, o tempo sera abatido ao inves de acrescido
			consolidacaoPeriodoParada.consolidar(isAbaterTempoParada, dwConsolpalog.getDthrIparada(), dtHrFRef, dwConsolpalog, null, "abater-consolidarFimParada");
			dwConsolpalog.setDthrFparadaAb(dwConsolpalog.getDthrIparada());
		}
		Date dtHrInicioConsolidacao = dwConsolpalog.getDthrFparadaAb();
		if(dtHrInicioConsolidacao == null){
			dtHrInicioConsolidacao = dwConsolpalog.getDthrIparada();
		}
	
		dwConsolpalog.setDthrFparada(dtHrFimParada);

		BigDecimal duracaoParada = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodo(dtHrInicioParada, dtHrFimParada);
		
		if(dwConsolpalog.getDwTParada().getIsPesa() == null ||dwConsolpalog.getDwTParada().getIsPesa()){
			dwConsolpalog.setSegAutoTempoparadaCp(duracaoParada);
		}else{
			dwConsolpalog.setSegAutoTempoparadaSp(duracaoParada);
		}
		
		consolidacaoPeriodoParada.consolidar(false, dtHrInicioConsolidacao, dtHrFimParada, dwConsolpalog, dtHrFimParada, "ConsolidacaoFimParada");
		
		dwConsolpalog.setDthrFparadaAb(null);
	}


	/**
	 * Força a finaliza��oo da parada. 
	 * @param dtHrFimParada Se a data de fim da parada for menor que a de início, fecha a parada com a mesta data/hora do início. 
	 * @param omPt
	 * @param dwConsolpt
	 * @param dwCalsems
	 * @param ppCp
	 * @param dwFolha
	 * @param dwConsolpalog
	 * @param omcfg
	 * @param log
	 * @param idLog
	 * @param identacao
	 * @param motivoFinalizacao
	 * @throws ReprocessarMsEvtException 
	 */
	public void forcarFinalizacaoParadaAberta(Date dtHrFimParada, OmPt omPt, DwConsolpt dwConsolpt, 
			DwConsolpalog dwConsolpalog, OmCfg omcfg, 
			IdwLogger log, int idLog, int identacao, String motivoFinalizacao) throws ReprocessarMsEvtException{
		
		if(dwConsolpalog != null && dwConsolpalog.isAberta()){
			try{
				log.info(idLog, identacao, motivoFinalizacao);
				consolidarFimParada(omPt, dwConsolpt, omcfg, log, idLog, identacao, dtHrFimParada, dwConsolpalog);
			}catch(Exception e){
				e.printStackTrace();
				log.info(idLog, identacao, e.getMessage(), e);
				throw new ReprocessarMsEvtException(omPt.getCdPt() + " - Não foi possível finalizar parada. " + motivoFinalizacao);
			}
		}
		
	}	
}

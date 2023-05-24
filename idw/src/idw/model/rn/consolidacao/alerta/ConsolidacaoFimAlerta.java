package idw.model.rn.consolidacao.alerta;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolal;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolaloco;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFimAlerta  extends ConsolidaRN implements IConsolidacao {
	
	public ConsolidacaoFimAlerta() {
		super();
	}
	
	public ConsolidacaoFimAlerta(DAOGenerico dao) {
		super(dao);
	}

	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msevt,
			OmCfg omcfg, IdwLogger log, int idLog, int identacao)
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException,
					RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException,
					NumeroSerieIrregularException, CicloJaContabilizadoException {

		Date dthrFalerta = msevt.getDthrEvento();

		Validate.notNull(omPt, "Posto de trabalho esta nulo");
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");
		//Validate.notNull(dthrIalerta, "Data hora de inicio de alerta nao informado");

		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevt, omcfg);
		Validate.notNull(ppCp, "ppCp nao pode ser nulo");
		//ppCp.mudarDthrIniciorealIfNull(dthrIalerta);
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"nao tem folha ativa para o ppCp");

		List<DwConsolallog> dwConsolallogs = obtemListaDwConsolallog(omPt, msevt.getCdAlerta());
		// Alessandre em 05-05-17 se a lista estiver vazia eh pode ser que o codigo alerta seja do padrao injet 00000, pesquisar novamente com esse padrao
		// Isso se o codigo passado tiver menos de 6 posicoes
		// Alessandre em 22-06-17 comentei o if abaixo pois o padrao injet nao sera tratado
		// ou seja o coletor manda ou nao com os zeros a esquerda
		/*if (dwConsolallogs.isEmpty() && msevt.getCdAlerta() != null && msevt.getCdAlerta().length() < 6) {
			String cdAlerta = FuncoesApoioInjet.getCodigoPadraoInjet(msevt.getCdAlerta());
			dwConsolallogs = obtemListaDwConsolallog(omPt, cdAlerta);
		}*/
		DwPepro dwPepro = msevt.getDwPepro();
		fecharAlertasTodosOsPeriodos(dwConsolallogs, dwCalsems, omPt, ppCp, dwFolha, omcfg, dwPepro, dthrFalerta, log, idLog, identacao);
	}

	// Metodo que efetivamente fecha o alerta
	public void fecharAlertasTodosOsPeriodos(List<DwConsolallog> dwConsolallogs, List<DwCalsem> dwCalsems, OmPt omPt, PpCp ppCp, DwFolha dwFolha, 
			OmCfg omcfg, DwPepro dwPepro, Date dthrFalerta, IdwLogger log, int idLog, int identacao) 
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		fecharAlertasTurnos(dwConsolallogs, dwCalsems, omPt, ppCp, dwFolha, omcfg, dwPepro, dthrFalerta, log, idLog, identacao);
		fecharAlertasAcumulado(dwConsolallogs, dwCalsems, omPt, ppCp, dwFolha, omcfg, dwPepro, dthrFalerta, log, idLog, identacao);
	}
	
	/* Fecha os alertas durante o acumulado
	 * 
	 */
	private void fecharAlertasAcumulado(List<DwConsolallog> dwConsolallogs, List<DwCalsem> dwCalsems, OmPt omPt, PpCp ppCp, DwFolha dwFolha, OmCfg omcfg, DwPepro dwPepro, Date dthrFalerta, IdwLogger log, int idLog, int identacao) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		

		for (DwConsolallog dwconsolallog : dwConsolallogs) {

			TurnoRN turnoRN = new TurnoRN(getDao());

			// Pega os períodos com os turnos
			//List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.obtemTurnosPeriodo(omPt.getIdPt(), dwconsolallog.getDthrIalerta(), dwconsolallog.getDthrFalerta(), null, 0, 0, omcfg);
			List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.getTurnoAtualDTOsPeriodo(dwCalsems, dwconsolallog.getDthrIalerta(), dwconsolallog.getDthrFalerta());

			TurnoAtualDTO turnoAtualDTO;
			
			if (listaTurnoAtualDTO.isEmpty()) {
				throw new SemCalendarioException();				
			} else
				turnoAtualDTO = listaTurnoAtualDTO.get(0);
			
			DwConsolid dwConsolid = this.obtemConsolIdAcumulado(omPt, ppCp, dwFolha, turnoAtualDTO);
			// Pega dwConsol
			DwConsol dwConsol = null;
			for(DwConsol item:dwConsolid.getDwConsols()){
				dwConsol = item;
				break;
			}
			
			
			DwConsolal dwConsolal = this.getDwConsolal(dwConsol.getIdConsol(), dwconsolallog.getDwTAlerta().getIdTalerta());
			if(dwConsolal == null){
				dwConsolal = new DwConsolal();
				dwConsolal.setDwConsol(dwConsol);
				dwConsolal.setDwTAlerta(dwconsolallog.getDwTAlerta());
				dwConsolal.setSegAutoTempoalerta(new BigDecimal(0));
			}
			// Remove um nullpointer com os ifs abaixo
			if (dwConsolal.getSegAutoTempoalerta() == null)
				dwConsolal.setSegAutoTempoalerta(BigDecimal.ZERO);

			Date dthrIRef = dwconsolallog.getDthrIalerta();
			Date dthrFRef = dwconsolallog.getDthrFalerta();
			
			BigDecimal tempo = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dthrIRef, dthrFRef);
			
			if (tempo == null)
				tempo = BigDecimal.ZERO;

			dwConsolal.setSegAutoTempoalerta(dwConsolal.getSegAutoTempoalerta().add(tempo));
			this.getDao().makePersistent(dwConsolal);

			// Atualiza dwConsolmooco
			DwConsolaloco dwConsolaloco = this.getDwConsolaloco(dwConsolal.getIdConsolal(), dwconsolallog.getIdConsolallog());
			if(dwConsolaloco == null){
				dwConsolaloco = new DwConsolaloco();
				dwConsolaloco.setDwConsolal(dwConsolal);
				dwConsolaloco.setDwConsolallog(dwconsolallog);
			}
			dwConsolaloco.setDthrIalerta(dthrIRef);
			dwConsolaloco.setDthrFalerta(dthrFRef);
			dwConsolaloco.setIsContinuaproximoperiodo(false);
			this.getDao().makePersistent(dwConsolaloco);

		}
	}

	/* Fecha os alertas para o turno
	 * 
	 */
	private void fecharAlertasTurnos(List<DwConsolallog> dwConsolallogs, List<DwCalsem> dwCalsems, OmPt omPt, PpCp ppCp, 
			DwFolha dwFolha, OmCfg omcfg, DwPepro dwPepro, Date dthrFalerta, IdwLogger log, int idLog, int identacao) 
			throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		
		TempoRealRN trn = new TempoRealRN(getDao());
		for (DwConsolallog dwconsolallog : dwConsolallogs) {
			dwconsolallog.setDthrFalerta(dthrFalerta);
			this.getDao().makePersistent(dwconsolallog);


			TurnoRN turnoRN = new TurnoRN(getDao());

			// Pega os períodos com os turnos
			//List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.obtemTurnosPeriodo(omPt.getIdPt(), dwconsolallog.getDthrIalerta(), dwconsolallog.getDthrFalerta(), null, 0, 0, omcfg);
			List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.getTurnoAtualDTOsPeriodo(dwCalsems, dwconsolallog.getDthrIalerta(), dwconsolallog.getDthrFalerta());
			for(TurnoAtualDTO turnoAtual: listaTurnoAtualDTO){
				Date dthrIRef = (DataHoraRN.before(dwconsolallog.getDthrIalerta(), turnoAtual.getDtHrITurnoComTolerancia()) ? turnoAtual.getDtHrITurnoComTolerancia() : dwconsolallog.getDthrIalerta());
				Date dthrFRef = (DataHoraRN.before(dwconsolallog.getDthrFalerta(), turnoAtual.getDtHrFTurnoComTolerancia()) ? dwconsolallog.getDthrFalerta() : turnoAtual.getDtHrFTurnoComTolerancia());

				boolean isUltimoPeriodo = (DataHoraRN.equals(dthrFRef, turnoAtual.getDtHrFTurnoComTolerancia()));
				log.info(idLog, identacao, "Ultimo periodo = " + isUltimoPeriodo + " dthrFRef = " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrFRef) + " dthrFTurnoComTolerancia=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(turnoAtual.getDtHrFTurnoComTolerancia()));

				BigDecimal tempo = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dthrIRef, dthrFRef);

				DwConsolid dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, dthrIRef, omcfg, dwPepro);

				// Pega dwConsol
				DwConsol dwConsol = null;
				for(DwConsol item:dwConsolid.getDwConsols()){
					dwConsol = item;
					break;
				}

				DwConsolal dwConsolal = this.getDwConsolal(dwConsol.getIdConsol(), dwconsolallog.getDwTAlerta().getIdTalerta());
				if(dwConsolal == null){
					dwConsolal = new DwConsolal();
					dwConsolal.setDwConsol(dwConsol);
					dwConsolal.setDwTAlerta(dwconsolallog.getDwTAlerta());
					dwConsolal.setSegAutoTempoalerta(new BigDecimal(0));
				}
				// Remove um nullpointer com os ifs abaixo
				if (dwConsolal.getSegAutoTempoalerta() == null)
					dwConsolal.setSegAutoTempoalerta(BigDecimal.ZERO);

				if (tempo == null)
					tempo = BigDecimal.ZERO;

				dwConsolal.setSegAutoTempoalerta(dwConsolal.getSegAutoTempoalerta().add(tempo));

				this.getDao().makePersistent(dwConsolal);
				// Atualiza dwConsolmooco
				DwConsolaloco dwConsolaloco = this.getDwConsolaloco(dwConsolal.getIdConsolal(), dwconsolallog.getIdConsolallog());
				if(dwConsolaloco == null){
					dwConsolaloco = new DwConsolaloco();
					dwConsolaloco.setDwConsolal(dwConsolal);
					dwConsolaloco.setDwConsolallog(dwconsolallog);
				}
				dwConsolaloco.setDthrIalerta(dthrIRef);
				dwConsolaloco.setDthrFalerta(dthrFRef);
				dwConsolaloco.setIsContinuaproximoperiodo(!isUltimoPeriodo);

				this.getDao().makePersistent(dwConsolaloco);

				List<DwConsolallog> dwConsolmoComAlertaAberto = this.getDwConsolalComAlertaAberto(omPt);
				
				/* Alessandre em 05-05-17 a linha abaixo foi comentada pq utiliza a dthrevento, mas como estamos em um loop avaliando varios turnos
				 * o dwrt é diferente para cada turno e devemos mudar dwrt de cada turno. Assim a dthr a ser usada é de inicio de turno
				 * ao inves do evento.
				 */
				//DwRt dwRt = trn.obtemDwRtParaHeartBeat(msevt.getDthrEvento(), omPt, log, idLog, msevt);
				DwRt dwRt = trn.obtemDwRtParaHeartBeatSemClonarTurnoDTO(dthrIRef, omPt, log, dwPepro);
				
				dwRt.setIsAlerta(!dwConsolmoComAlertaAberto.isEmpty());
				log.info(idLog, identacao, "Qtde operadores logados = " + dwConsolmoComAlertaAberto.size() + " valor de dwrt.isAlerta=" + dwRt.getIsAlerta());
			}
		}

		
	}

	/**
	 * Busca DwConsolallog
	 * @param idPt
	 * @param dthrIalerta
	 * @return
	 */
	private List<DwConsolallog> obtemListaDwConsolallog(OmPt ompt, String cdAlerta){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT dwConsolallog ");
		q.append("FROM DwConsolallog dwConsolallog ");
		q.append("join dwConsolallog.dwTAlerta dwtalerta");
		q.append("join dwConsolallog.omPt ompt");
		q.append("WHERE ompt.cdPt = :cdPt ");
		q.append("AND dwConsolallog.dthrFalerta is null");
		q.append("and dwtalerta.cdTalerta = :cdalerta");

		q.defineParametro("cdPt", ompt.getCdPt());
		q.defineParametro("cdalerta", cdAlerta);

		return q.list();
	}
}

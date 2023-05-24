package idw.model.rn.consolidacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwCalptDAO;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalpt;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.util.IdwLogger;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;
import ms.util.UtilsThreads;

/**
 *
 * Faz a quebra dos Periodos para consolidacao em de Hora, Turno, mes e Acumulado
 * <br>Se baseando nos dados passados no construtor
 * <br>Depois que esta classe � instanciada. � possivel acessar os Periodos gerados:
 * <br>{@link #getPeriodoAcumulado()}, {@link #getPeriodosMesAno()}, {@link #getPeriodosTurno()}, {@link #getPeriodosHora()}
 * <br> Para consolidar os dados para cada item deste Periodo chamar {@link #consolidar(IConsolidacaoPeriodo, PpCp, DwFolha)}
 *    
 * @author milton
 * @see IConsolidacaoPeriodo
 */
public final class ConsolidacaoPeriodo extends AbstractRN<DAOGenerico> {
	private final OmPt omPt;
	/** inicio do Periodo, base para inicial para a quebra de Periodo */
	private final Date dtHrInicio;
	/** Fim do Periodo, base para final para a quebra de Periodo */
	private final Date dtHrFim;
	
	private final DwCal dwCal;
	
	private final List<PeriodoDTO> periodosTurno = new ArrayList<PeriodoDTO>();
	private final List<PeriodoDTO> periodosMesAno = new ArrayList<PeriodoDTO>();
	private List<PeriodoDTO> periodosHora = new ArrayList<PeriodoDTO>();
	
	/** Periodo do acumulado, que corresponde ao OmPt e PpCp */
	private final PeriodoDTO periodoAcumulado = new PeriodoDTO();	
	
	private final ConsolidaRN consolidaRN;
	
	/** 
	 * TODO condicao temporaria de mes, ate que consolidacao seja totalmente testada
	 * estando ok, sempre disponibilizar consolidacao
	 */
	public static final boolean USAR_CONSOLIDACAO_POR_MESANO = false;
	
	/**
	 *	Constroi instancia e suas quebras por acumulado, mes, turno e hora.
	 * @param dao
	 * @param omPt
	 * @param omcfg
	 * @param dwCalsems lista com o calendario do pt
	 * @param dtHrInicio
	 * @param dtHrFim
	 * @param dwCal quando nulo, irá pegar o primeiro calendário válido para o PT no período
	 * @see #getPeriodoAcumulado()
	 * @see #getPeriodosMesAno()
	 * @see #getPeriodosTurno()
	 * @see #getPeriodosHora()
	 */
	public ConsolidacaoPeriodo(
			DAOGenerico dao,
			OmPt omPt, OmCfg omcfg, 
			Date dtHrInicio, Date dtHrFim, 
			DwCal dwCal,
			IdwLogger log,
			int idLog,
			int identacao) throws SemCalendarioException, SemSGBDException{
		super(dao);
		this.consolidaRN = new ConsolidaRN(dao);
		this.omPt = omPt;		
		this.dtHrInicio = dtHrInicio;
		this.dtHrFim =  dtHrFim;
		if (dwCal == null) {
			dwCal = getDwCalParaPt(omPt, omcfg, dtHrInicio, dtHrFim);
		}
		this.dwCal = dwCal;
		
		this.montarPeriodos(log, idLog, identacao);
		
	}

	public DwCal getDwCalParaPt(OmPt omPt, OmCfg omcfg, Date dtHrInicio, Date dtHrFim) {
		DwCal dwCal;
		DwCalptDAO dwCalDAO = new DwCalptDAO(getDaoSession());
		DwCalpt dwCalpt = dwCalDAO.getDwCalPtAtivo(omPt, dtHrInicio, dtHrFim);
		// Verifica se usa o calendário indefinido ou o vinculado ao PT
		dwCal = (dwCalpt == null ? omcfg.getDwCal() : dwCalpt.getDwCal());
		return dwCal;
	}

	/**
	 * Periodo distribuidas em horas
	 * @return
	 */
	public List<PeriodoDTO> getPeriodosHora() {
		return periodosHora;
	}


	/**
	 * Periodo distribuido em turnos 
	 * @return
	 */
	public List<PeriodoDTO> getPeriodosTurno() {
		return periodosTurno;
	}

	
	/**
	 * Periodo distribuido em ano/mes
	 * @return
	 */
	public List<PeriodoDTO> getPeriodosMesAno() {
		return periodosMesAno;
	}

	
	/**
	 * Periodo do acumulado
	 * @return
	 */
	public PeriodoDTO getPeriodoAcumulado() {
		return periodoAcumulado;
	}


	/**
	 * Consolida para todos os períodos: hora, turno, mês/ano e acumulado
	 * @throws SemCicloPadraoException 
	 * @throws SemSGBDException 
	 * @throws SemCalendarioException 
	 * @see #getPeriodosHora()
	 * @see #getPeriodosTurno()
	 * @see #getPeriodosMesAno()
	 * @see #getPeriodoAcumulado()
	 *
	 */
	public void consolidar(IdwLogger log, int idLog, int identacao, PpCp ppCp, DwFolha dwFolha, DwPepro dwPepro, IConsolidacaoPeriodo consolidacaoPeriodo, String chamador) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		consolidarEmTurnos(log, idLog, identacao, consolidacaoPeriodo, ppCp, dwFolha, dwPepro, chamador);
		consolidarEmHoras(log, idLog, identacao, consolidacaoPeriodo, ppCp, dwFolha, dwPepro, chamador);		
		//consolidarEmMeses(log, consolidacaoPeriodo, ppCp, dwFolha, dwPepro);
		consolidarEmAcumulado(log, consolidacaoPeriodo, ppCp, dwFolha, dwPepro, idLog, identacao, chamador);

	}

	/**
	 *  Monta os Periodos de turno, hora, mes/ano e acumulado 
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	private void montarPeriodos(IdwLogger log, int idLog, int identacao) throws SemCalendarioException, SemSGBDException{

		TurnoRN turnoRN = new TurnoRN(getDao());
		List<DwCalsem> dwCalsems;
		List<TurnoAtualDTO> turnoAtualDTOs;
		
		log.info(idLog, identacao, "vou chamar getCalendarioSemanalComTurnosIndefinidos");
		dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidos(dwCal.getIdCal());
		log.info(idLog, identacao, "executado getCalendarioSemanalComTurnosIndefinidos");
		
		log.info(idLog, identacao, "vou chamar getTurnoAtualDTOPeriodo");
		turnoAtualDTOs = turnoRN.getTurnoAtualDTOsPeriodo(
				dwCalsems, 
				this.dtHrInicio, 
				this.dtHrFim);
		log.info(idLog, identacao, "executado getTurnoAtualDTOPeriodo turnoAtualDTO.size = " + turnoAtualDTOs.size());
		for (TurnoAtualDTO turnoAtualDTO : turnoAtualDTOs) {

			log.info(idLog, identacao, "addTurnoAtual = " + turnoAtualDTO.toString());
			// Turno
			PeriodoDTO periodoDTOTurno =  addPeriodosTurno(turnoAtualDTO);
			
			// Mes Ano
			addPeriodosMesAno(turnoAtualDTO, periodoDTOTurno);
			
			// Acumulado
			setPeriodoAcumulado(turnoAtualDTO, periodoDTOTurno);				
			
			// Hora
			List<PeriodoDTO> periodosHoraCalendario = this.consolidaRN.obtemHorasPeriodo(periodoDTOTurno.getDtHrInicio(), periodoDTOTurno.getDtHrFim());
			
			for(PeriodoDTO periodo: periodosHoraCalendario){
				periodo.setDtHrInicio(getDtHrIRef(periodo.getDtHrInicio(), periodo.getDtHrInicio()));
				periodo.setDtHrFim(getDtHrFRef(periodo.getDtHrFim(), periodo.getDtHrFim()));
				periodo.setTurnoAtualDTO(turnoAtualDTO);
				periodo.setDuracao(new Long(DataHoraRN.getQuantidadeSegundosNoPeriodo(periodo.getDtHrInicio(), periodo.getDtHrFim())));
			}
			periodosHora.addAll(periodosHoraCalendario);
			UtilsThreads.pausaNaThread(10l);
		}
	}
	
	private Date getDtHrIRef(Date... dtHrs){
 		dtHrs =  ArrayUtils.add(dtHrs, this.dtHrInicio);
 		return DataHoraRN.getMaiorData(dtHrs);
	}
	
	private Date getDtHrFRef(Date... dtHrs){
 		dtHrs =  ArrayUtils.add(dtHrs, this.dtHrFim);
 		return DataHoraRN.getMenorData(dtHrs);
	}
	
	
	/**
	 * Consolida os turnos
	 * @throws SemCicloPadraoException 
	 * @throws SemSGBDException 
	 * @throws SemCalendarioException 
	 */
	private void consolidarEmTurnos(IdwLogger log, int idLog, int identacao, final IConsolidacaoPeriodo consolidacaoPeriodo, PpCp ppCp, DwFolha dwFolha, DwPepro dwPepro, String chamador) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		log.info(idLog, identacao, "consolidarEmTurnos periodosTurno.size=" + this.periodosTurno.size());
		for(PeriodoDTO periodoDTO: this.periodosTurno){
			log.info(idLog, identacao, "Consolidando no periodo " + periodoDTO.toString());
			DwConsolid dwConsolidTurno = this.consolidaRN.obtemConsolIdTurno(log, idLog, identacao+5, omPt, ppCp, dwFolha, periodoDTO.getTurnoAtualDTO(), dwPepro);
			consolidacaoPeriodo.consolidarTurno(dwConsolidTurno, periodoDTO.getDtHrInicio(), periodoDTO.getDtHrFim(), periodoDTO.getDuracao(), log, idLog, identacao+5, chamador);
			log.info(idLog, identacao, "Fim Consonlidando no periodo");
			UtilsThreads.pausaNaThread(10l);
		}
		log.info(idLog, identacao, "fim consolidarEmTurnos");

	}

//	/**
//	 * Consolidar em meses
//	 * @throws SemCalendarioException
//	 * @throws SemSGBDException
//	 */
//	private void consolidarEmMeses(final IConsolidacaoPeriodo consolidacaoPeriodo, PpCp ppCp, DwFolha dwFolha, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
//
//		if(USAR_CONSOLIDACAO_POR_MESANO){
//			for(PeriodoDTO periodoDTO: this.periodosMesAno){
//				DwConsolid dwConsolidMesAno = this.consolidaRN.obtemConsolIdMes(omPt, ppCp, dwFolha, periodoDTO.getTurnoAtualDTO(), dwPepro);
//				Date dtHrIRef = getDtHrIRef(periodoDTO.getDtHrInicio());
//				Date dtHrFRef = getDtHrFRef(periodoDTO.getDtHrFim());
//				consolidacaoPeriodo.consolidarMes(dwConsolidMesAno, dtHrIRef, dtHrFRef, periodoDTO.getDuracao());
//			}
//		}
//	}

	/**
	 * Consolidar no acumulado
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	private void consolidarEmAcumulado(IdwLogger log, final IConsolidacaoPeriodo consolidacaoPeriodo, PpCp ppCp, DwFolha dwFolha, DwPepro dwPepro, int idLog, int identacao, String chamador) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		DwConsolid dwConsolidAcumulado = this.consolidaRN.obtemConsolIdAcumulado(omPt, ppCp, dwFolha, this.periodoAcumulado.getTurnoAtualDTO());
		consolidacaoPeriodo.consolidarAcumulado(dwConsolidAcumulado, dtHrInicio, dtHrFim, periodoAcumulado.getDuracao(), log, idLog, identacao, chamador);
	}

	/**
	 * Consolidar periodo em horas
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	private void consolidarEmHoras(IdwLogger log, int idLog, int identacao, final IConsolidacaoPeriodo consolidacaoPeriodo, PpCp ppCp, DwFolha dwFolha, DwPepro dwPepro, String chamador) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		log.info(idLog, identacao, "consolidarEmHoras periodosHora.size=" + this.periodosHora.size());
		for(PeriodoDTO periodo: this.periodosHora){
			log.info(idLog, identacao, "periodosHoras " + periodo.toString());
			DwConsolid dwConsolidHora = this.consolidaRN.obtemConsolIdHora(this.omPt, ppCp, dwFolha, periodo.getDtHrInicio(), periodo.getTurnoAtualDTO(), dwPepro);
			consolidacaoPeriodo.consolidarHora(dwConsolidHora, periodo.getDtHrInicio(), periodo.getDtHrFim(), periodo.getDuracao(), log, idLog, identacao + 5, chamador);
			
			UtilsThreads.pausaNaThread(100l);
		}
	}
	
	/**
	 * Adiciona periodo por turno
	 * @param turnoAtualDTO
	 * @param duracao
	 */
	private PeriodoDTO addPeriodosTurno(TurnoAtualDTO turnoAtualDTO){
		PeriodoDTO periodoDTO = new PeriodoDTO();
		Date dtHrIRef = getDtHrIRef(turnoAtualDTO.getDtHrITurnoComTolerancia());
		Date dtHrFRef = getDtHrFRef(turnoAtualDTO.getDtHrFTurnoComTolerancia());
		periodoDTO.setDtHrInicio(dtHrIRef);
		periodoDTO.setDtHrFim(dtHrFRef);
		periodoDTO.setTurnoAtualDTO(turnoAtualDTO);
		Long duracao = new Long (DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrIRef, dtHrFRef));
		periodoDTO.setDuracao(duracao);		
		this.periodosTurno.add(periodoDTO);
		return periodoDTO;
	}

	/**
	 * Insere periodo do turno para o mes, verificando se ja existe na colecao. (ano, mes e turno)
	 * <br>O mes/ano sera baseado no dia de referencia do turno
	 * <br>Inicio e fim do Periodo tambem sera baseado nas datas de inicio e fim do turno, levando em consideracao o
	 * @param turnoAtualDTO
	 */
	private void addPeriodosMesAno(TurnoAtualDTO turnoAtualDTO, PeriodoDTO periodoDTOTurno){
		
		if(this.periodosMesAno.isEmpty()){
			
			PeriodoDTO periodoDTO = new PeriodoDTO();
			periodoDTO.setTurnoAtualDTO(new TurnoAtualDTO());
			periodoDTO.getTurnoAtualDTO().setDtReferencia(turnoAtualDTO.getDtReferencia());
			periodoDTO.getTurnoAtualDTO().setDtHrITurno(turnoAtualDTO.getDtHrITurno());
			periodoDTO.getTurnoAtualDTO().setDtHrFTurno(turnoAtualDTO.getDtHrFTurno());
			periodoDTO.setDtHrInicio(
					DataHoraRN.getMaiorData(this.dtHrInicio, periodoDTO.getTurnoAtualDTO().getDtHrITurno()));
			// O fim do Periodo deve ser o maior fim de turno, dos turno acumlados do mes.
			// Mas se o fim passado para a classe for menor, us�-la			
			periodoDTO.setDtHrFim(
					DataHoraRN.getMenorData(this.dtHrFim, periodoDTO.getTurnoAtualDTO().getDtHrFTurno()));

			periodoDTO.setDuracao(periodoDTOTurno.getDuracao());			
			this.periodosMesAno.add(periodoDTO);			
			
		} else {
			
			int mes = DataHoraRN.getApenasMes(turnoAtualDTO.getDtReferencia());
			int ano = DataHoraRN.getApenasAno(turnoAtualDTO.getDtReferencia());
			
			// Lista deve estar ordenada pelo inicio de seu Periodo.
			PeriodoDTO item = this.periodosMesAno.get(this.periodosMesAno.size() - 1);
			
			int mesItem = DataHoraRN.getApenasMes(item.getTurnoAtualDTO().getDtReferencia());
			int anoItem = DataHoraRN.getApenasAno(item.getTurnoAtualDTO().getDtReferencia());
			
			// Se ja existir Periodo
			if((mesItem == mes) && (anoItem == ano)){
				item.setDuracao(item.getDuracao() + periodoDTOTurno.getDuracao());
				// Guarda o menor inicio de turno
				item.getTurnoAtualDTO().setDtHrITurno(
						DataHoraRN.getMenorData(item.getTurnoAtualDTO().getDtHrITurno(), turnoAtualDTO.getDtHrITurno()));				
				// Guarda o maior fim de turno
				item.getTurnoAtualDTO().setDtHrFTurno(
						DataHoraRN.getMaiorData(item.getTurnoAtualDTO().getDtHrFTurno(), turnoAtualDTO.getDtHrFTurno()));
				
				// O fim do Periodo deve ser o maior fim de turno, dos turno acumlados do mes.
				// Mas se o fim passado para a classe for menor, us�-la
				item.setDtHrFim(DataHoraRN.getMaiorData(item.getDtHrFim(), periodoDTOTurno.getDtHrFim()));
				
			}

		}		
		
	}

	/**
	 * Ajusta Periodo acumulado
	 */
	private void setPeriodoAcumulado(TurnoAtualDTO turnoAtualDTO, PeriodoDTO periodoDTOTurno){

		if(this.periodoAcumulado.getDtHrInicio() == null){
			this.periodoAcumulado.setDtHrInicio(this.dtHrInicio);
		}
		if(this.periodoAcumulado.getDtHrFim() == null){
			this.periodoAcumulado.setDtHrFim(this.dtHrFim);
		}
		
		if(this.periodoAcumulado.getTurnoAtualDTO() == null){
			this.periodoAcumulado.setTurnoAtualDTO(turnoAtualDTO);
		}
		this.periodoAcumulado.setDtHrInicio(
				DataHoraRN.getMenorData(this.periodoAcumulado.getDtHrInicio(), 
						periodoDTOTurno.getDtHrInicio()));
		
		this.periodoAcumulado.setDtHrFim(
				DataHoraRN.getMenorData(this.periodoAcumulado.getDtHrFim(), 
						periodoDTOTurno.getDtHrFim()));			
		
		this.periodoAcumulado.setDuracao(this.periodoAcumulado.getDuracao() + periodoDTOTurno.getDuracao());
	}
	
}

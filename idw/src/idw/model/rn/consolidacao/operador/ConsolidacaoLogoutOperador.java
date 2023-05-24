package idw.model.rn.consolidacao.operador;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolmooco;
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
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;
import ms.util.UtilsThreads;

public class ConsolidacaoLogoutOperador extends ConsolidaRN implements IConsolidacao{

	/**
	 * Consolidar logout de operador
	 * @param omPt
	 * @param dwCalsems
	 * @param msevt
	 * @param omcfg
	 * @throws RegistroDesconhecidoException
	 * @throws SemSGBDException
	 * @throws SemCalendarioException
	 */
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg, IdwLogger log, int idLog, int identacao)  throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException {

		Date dthrLogin = msevt.getDthrEventoanterior();
		Date dthrLogout = msevt.getDthrEvento();

		Validate.notNull(omPt, "Posto de trablaho est� nulo");
		Validate.notNull(omPt.getIdPt(), "idPt est� nulo");
		// Alessandre em 22-7-14 comentei o valid abaixo pois o logout eh feito para todos os logins abertos daquele operador na maquina
		//Validate.notNull(dthrLogin, "Data hora de login n�o informado");

		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevt, omcfg);
		Validate.notNull(ppCp, "ppCp nao pode ser nulo");
		ppCp.mudarDthrIniciorealIfNull(dthrLogin);
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"n�o tem folha ativa para o ppCp");

		//System.out.println("OBTENDO LOGINS PARA " + omPt.getCdPt() + " login = " + msevt.getLogin());
		List<DwConsolmolog> lista = this.obtemListaDwConsolmologEmAbertoByLogin(omPt, msevt.getLogin());
		
		if (lista == null || lista.size() <= 0) {
			//System.out.println("OBTENDO LOGINS PARA " + omPt.getCdPt() + " cdusuario = " + msevt.getLogin());
			lista = this.obtemListaDwConsolmologEmAbertoByCd(omPt, msevt.getLogin());
		}
		
		//System.out.println("Qtde de logins abertos " + lista.size());
		for (DwConsolmolog dwconsolmolog : lista) {
			log.info("Setando fim logout em " + dwconsolmolog.getIdConsolmolog() + " com " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrLogout));
			dwconsolmolog.setDthrFlogin(dthrLogout);
			this.getDao().makePersistent(dwconsolmolog);
			// Alessandre 7-2-14 desativei a consolidacao da maodeobra, pq estava dando um erro que nao deixava marcar como 2 o msevt, possivelmente ocasionado
			// pelo for acima q inclui. Mas a linha abaixo dever� ser descomentada e o problema resolvido.
			
			
//			utilizar a op de cada periodo, sem isso a op atual vai ser registrada em todos os periodos de forma errada
			
			
			consolidarLogoutTodosPeriodos(log, idLog, omPt, dwCalsems, dwconsolmolog, omcfg, msevt.getDwPepro());
			UtilsThreads.pausaNaThread(10l);
		}
	}
	/**
	 * Consolidar logout em todos os periodos
	 * @param omPt
	 * @param dwConsolmolog
	 * @param ppCp
	 * @param omcfg
	 * @throws SemSGBDException
	 * @throws SemCalendarioException
	 */
	private void consolidarLogoutTodosPeriodos(IdwLogger log, int idLog, OmPt omPt, List<DwCalsem> dwCalsems, DwConsolmolog dwConsolmolog, OmCfg omcfg, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		consolidarLogoutTurno(log, idLog, omPt, dwCalsems, dwConsolmolog, omcfg, dwPepro);
		
		// Alessandre em 17-09-20 comentei a consolidacao por hora para minimizar o processamento e aparentemente os dados do operador por hora nao estao sendo usados
		//consolidarLogoutHora(log, idLog, omPt, dwCalsems, dwConsolmolog, omcfg, dwPepro);

	}
	/**
	 * Consolidar logout para o turno
	 * @param omPt
	 * @param dwConsolmolog
	 * @param ppCp
	 * @param omcfg
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	private void consolidarLogoutTurno(IdwLogger log, int idLog, OmPt omPt, List<DwCalsem> dwCalsems, DwConsolmolog dwConsolmolog, OmCfg omcfg, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		TurnoRN turnoRN = new TurnoRN(getDao());

		// Pega os per�odos com os turnos
		//List<TurnoAtualDTO>  listaTurnoAtualDTO = turnoRN.obtemTurnosPeriodo(omPt.getIdPt(), dwConsolmolog.getDthrIlogin(), dwConsolmolog.getDthrFlogin(), null, 0, 0, omcfg);
		List<TurnoAtualDTO> listaTurnoAtualDTO = turnoRN.getTurnoAtualDTOsPeriodo(dwCalsems, dwConsolmolog.getDthrIlogin(), dwConsolmolog.getDthrFlogin());
		
		for (TurnoAtualDTO turnoAux : listaTurnoAtualDTO) {
			log.info(idLog, 0, "logout no turno " + turnoAux);
		}
		for(TurnoAtualDTO turnoAtual: listaTurnoAtualDTO){
			log.info(idLog, 0, "Consolidando fim login para " + turnoAtual);
			
			List<DwConsolid> ids = pesquisarDwConsolid(turnoAtual.getDtReferencia(), turnoAtual.getIdTurno(), omPt, dwConsolmolog.getDthrIlogin());
			
			for (DwConsolid idAux : ids) {
				log.info(idLog, 0, "ids impactador " + idAux.getIdConsolid());
			}
			
			// parada cada turno, consolidar o logn apenas uma vez por OP. assim foi criado um list para evitar de reperitr a OP
			List<String> ops = new ArrayList<>();
			for (DwConsolid id : ids) {
				if (ops.contains(id.getPpCp().getNrop()) == false) {
					consolidarLogoutDwConsolid(log, idLog, id, turnoAtual.getDtHrITurnoComTolerancia(), turnoAtual.getDtHrFTurnoComTolerancia(), dwConsolmolog, omcfg, dwPepro, true);
					ops.add(id.getPpCp().getNrop());
				}
			}
			UtilsThreads.pausaNaThread(10l);
		}

	}

	/**
	 * Consolidar logout para a hora
	 * @param omPt
	 * @param dwCalsems
	 * @param dwConsolmolog
	 * @param ppCp
	 * @param dwFolha
	 * @param omcfg 
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 * @throws SemCicloPadraoException
	 */
	private void consolidarLogoutHora(IdwLogger log, int idLog, OmPt omPt, List<DwCalsem> dwCalsems, DwConsolmolog dwConsolmolog, OmCfg omcfg, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		// Pega os per�odos com os turnos
		List<PeriodoDTO>  listaPeriodoDTO = this.obtemHorasPeriodo(dwConsolmolog.getDthrIlogin(), dwConsolmolog.getDthrFlogin());
		for(PeriodoDTO periodoDTO: listaPeriodoDTO){
			List<DwConsolid> ids = pesquisarDwConsolidByHora(periodoDTO.getDtHrInicio(), periodoDTO.getDtHrFim(), omPt, dwConsolmolog.getDthrIlogin());
			// parada cada turno, consolidar o logn apenas uma vez por OP. assim foi criado um list para evitar de reperitr a OP
			List<String> ops = new ArrayList<>();
			for (DwConsolid id : ids) {
				if (ops.contains(id.getPpCp().getNrop()) == false) {
					consolidarLogoutDwConsolid(log, idLog, id, periodoDTO.getDtHrInicio(), periodoDTO.getDtHrFim(), dwConsolmolog, omcfg, dwPepro, false);
					ops.add(id.getPpCp().getNrop());
				}
			}
			UtilsThreads.pausaNaThread(10l);
		}
	}

	/**
	 * Consolidar logout para o DwConsolid
	 * @param dwConsolid
	 * @param dtHrIPeriodo
	 * @param dtHrFPeriodo
	 * @param omPt
	 * @param dwConsolmolog
	 * @param ppCp
	 * @param omcfg
	 * @throws SemCalendarioException 
	 */
	private void consolidarLogoutDwConsolid(IdwLogger log, int idLog, DwConsolid dwConsolid, Date dtHrIPeriodo, Date dtHrFPeriodo, 
			DwConsolmolog dwConsolmolog, OmCfg omcfg, DwPepro dwPepro, boolean isConsolidandoTurno) throws SemCalendarioException{

		Date dthrIRef = (DataHoraRN.before(dwConsolmolog.getDthrIlogin(), dtHrIPeriodo) ? dwConsolmolog.getDthrIlogin() : dtHrIPeriodo);
		Date dthrFRef = (DataHoraRN.before(dwConsolmolog.getDthrFlogin(), dtHrFPeriodo) ? dwConsolmolog.getDthrFlogin() : dtHrFPeriodo);

		boolean ultimoPeriodo = (DataHoraRN.equals(dthrFRef, dtHrFPeriodo));

		BigDecimal tempo = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dthrIRef, dthrFRef);

		// Pega dwConsol
		DwConsol dwConsol = null;
		for(DwConsol item:dwConsolid.getDwConsols()){
			dwConsol = item;
			break;
		}
		TempoRealRN trn = new TempoRealRN(getDao());

		// Atualiza dwConsolmo
		DwConsolmo dwConsolmo = this.getDwConsolmo(dwConsol.getIdConsol(), dwConsolmolog.getOmUsr().getIdUsr());
		if(dwConsolmo == null){
			dwConsolmo = new DwConsolmo();
			dwConsolmo.setDwConsol(dwConsol);
			dwConsolmo.setOmUsr(dwConsolmolog.getOmUsr());
			dwConsolmo.setSegAutoTempologin(new BigDecimal(0));
			this.getDao().makePersistent(dwConsolmo);
		}
		if (dwConsolmo.getSegAutoTempologin() == null)
			dwConsolmo.setSegAutoTempologin(BigDecimal.ZERO);
		
		dwConsolmo.setSegAutoTempologin(dwConsolmo.getSegAutoTempologin().add(tempo));

		// Atualiza dwConsolmooco
		DwConsolmooco dwConsolmooco = this.getDwConsolmooco(dwConsolmo.getIdConsolmo(),dwConsolmolog.getIdConsolmolog());
		if(dwConsolmooco == null){
			dwConsolmooco = new DwConsolmooco();
			dwConsolmooco.setDwConsolmo(dwConsolmo);
			dwConsolmooco.setDwConsolmolog(dwConsolmolog);
			this.getDao().makePersistent(dwConsolmooco);
		}
		dwConsolmooco.setDthrIlogin(dthrIRef);
		dwConsolmooco.setDthrFlogin(dthrFRef);
		dwConsolmooco.setIsContinuaproximoperiodo(!ultimoPeriodo);

		
		// Aqui devo procurar o DWRT correto, n�o pode ser o que est� no dwconsolid pois o operadore pode ter se logado em uma OP
		// e ter feito logout em outra OP, assim, o dwrt que deve ser modificado � o atual
		DwRt dwrt = null;
		
		// Alessandre: em 30-7-15 comentei a linha abaixo pois o ulitmoDwRT incluido pode nao ser do turno avaliado. Em alguns casos eh criado um dwRT para uma data antiga
		// Substitui pela seguinte que teoricamente deve pegar o ultimo dwRT no turno de referencia
		//dwrt = getUltimoDwRt(dwConsolid.getOmPt().getIdPt());
		if (isConsolidandoTurno)
			dwrt = trn.obtemDwRtParaHeartBeatSemClonarTurnoDTO(dthrFRef, dwConsolid.getOmPt(), log, dwPepro);
		
		if(dwrt != null){
			log.info(idLog, 0, "IDRT = " + dwrt.getIdRt() + " encontrado para dthrFRef= " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrFRef));
			List<DwConsolmolog> dwConsolmoComLoginAberto = this.getDwConsolmologComLoginAberto(dwConsolid.getOmPt().getIdPt());
			log.info(idLog, 0, "QTDE DE OPERADORES LOGADOS=" + dwConsolmoComLoginAberto.size());
			
			dwrt.setIsOperador(!dwConsolmoComLoginAberto.isEmpty());
			log.info(idLog, 0, "ALTERANDO IDRT = " + dwrt.getIdRt() + " isOperador=" + dwrt.getIsOperador());
			getDao().makePersistent(dwrt);
		}

	}





	/**
	 * Busca DwConsolmolog
	 * @param idPt
	 * @param dthrIlogin
	 * @return
	 */
	public List<DwConsolmolog> obtemListaDwConsolmologEmAbertoByLogin(OmPt ompt, String login){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT dwConsolmolog ");
		q.append("FROM DwConsolmolog dwConsolmolog ");
		q.append("join dwConsolmolog.omPt ompt");
		q.append("join dwConsolmolog.omUsr omusr");
		q.append("WHERE ompt.cdPt = :cdpt ");
		q.append("AND omusr.login = :login");
		q.append("and dwConsolmolog.dthrFlogin is null");
		
		q.defineParametro("cdpt", ompt.getCdPt());
		q.defineParametro("login", login);
		
		return q.list();
	}

	public List<DwConsolmolog> obtemListaDwConsolmologEmAbertoByCd(OmPt ompt, String cd){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT dwConsolmolog ");
		q.append("FROM DwConsolmolog dwConsolmolog ");
		q.append("join dwConsolmolog.omPt ompt");
		q.append("join dwConsolmolog.omUsr omusr");
		q.append("WHERE ompt.cdPt = :cdpt ");
		q.append("AND omusr.cdUsr = :login");
		q.append("and dwConsolmolog.dthrFlogin is null");
		
		q.defineParametro("cdpt", ompt.getCdPt());
		q.defineParametro("login", cd);
		
		return q.list();
	}
}

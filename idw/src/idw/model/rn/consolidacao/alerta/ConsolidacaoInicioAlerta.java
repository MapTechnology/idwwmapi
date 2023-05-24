package idw.model.rn.consolidacao.alerta;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolal;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolaloco;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.rn.AlertaRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoInicioAlerta extends ConsolidaRN implements IConsolidacao{

	/**
	 * Consolidar início de alerta
	 * @param omPt
	 * @param dwConsolpt
	 * @param dwCalsems
	 * @param msevt
	 * @param omcfg
	 * @param log
	 * @throws RegistroDesconhecidoException
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg, IdwLogger log, int idLog, int identacao)  throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException {

		Date dthrIalerta = msevt.getDthrEvento();
		String cdAlerta = msevt.getCdAlerta();

		Validate.notNull(omPt, "Posto de trabalho esta nulo");
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");
		Validate.notNull(dthrIalerta, "Data hora de alerta nao informado");
		Validate.notEmpty(cdAlerta, "Codigo do alerta nao preenchido");
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevt, omcfg);
		Validate.notNull(ppCp, "ppCp nao pode ser nulo");
		ppCp.mudarDthrIniciorealIfNull(dthrIalerta);
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"nao tem folha ativa para o ppCp");
		AlertaRN alertaRN = new AlertaRN();
		alertaRN.setDaoSession(this.getDao().getSession());
		DwTAlerta dwTAlerta = null;

		try {
			dwTAlerta = alertaRN.getDwTAlerta(cdAlerta, omPt.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
			String cdAlertaAux = UtilsString.getZerosAEsquerda(cdAlerta, 6);
			try {
				dwTAlerta = alertaRN.getDwTAlerta(cdAlertaAux, omPt.getOmTppt());
			} catch (RegistroDesconhecidoException e1) {
				// Se nao existir o alerta inclui-lo. Solicitação feita pela Sony devido as centenas de alertas vindos dos arquivos de log
				dwTAlerta = new DwTAlerta();
				dwTAlerta.setCdTalerta(cdAlerta);
				// Ailton 08-06-17: Cadastro da descricao do alerta
				if (msevt.getCb() == null || (msevt.getCb() != null && msevt.getCb().equals("")))
					dwTAlerta.setDsTalerta("Cadastrado automaticamente pela coleta");
				else
					dwTAlerta.setDsTalerta(msevt.getCb() + " - Cadastro Automatico");
				
				dwTAlerta.setDtRevisao(DataHoraRN.getDataHoraAtual());
				dwTAlerta.setDtStativo(dwTAlerta.getDtRevisao());
				dwTAlerta.setIdTalerta(0l);
				dwTAlerta.setIsAutomatico(false);
				dwTAlerta.setIsTimeout(false);
				dwTAlerta.setOmTppt(omPt.getOmTppt());
				dwTAlerta.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
				dwTAlerta.setOmUsrByIdUsrstativo(dwTAlerta.getOmUsrByIdUsrrevisao());
				dwTAlerta.setRevisao(1l);
				dwTAlerta.setStAtivo((byte) 1);
				getDao().makePersistent(dwTAlerta);
			}
		}

		// Se existir o mesmo alerta jÃ¡ aberto, descartar o segundo alerta
		DwConsolallog dwConsolallog = null;

		dwConsolallog = getDwConsolalLogComAlertaAberto(omPt, dwTAlerta);
		if (dwConsolallog != null) {
			dwConsolallog = null; // forcar o erro no valid abaixo
			//O alerta ja esta aberto, descartar o evento
			Validate.notNull(dwConsolallog, "Alerta ja aberto");
		}
		
		// Obtem o operador logado
		OmUsr omUsr = null;
		List<DwConsolmolog> operadores = getDwConsolmologComLoginAberto(omPt.getIdPt());
		if (operadores != null && operadores.size() > 0) {
			omUsr = operadores.get(0).getOmUsr();
		}
		
		// Inclui novo alerta
		dwConsolallog = new DwConsolallog();
		dwConsolallog.setDthrIalerta(dthrIalerta);
		dwConsolallog.setOmPt(omPt);
		dwConsolallog.setDwTAlerta(dwTAlerta);
		dwConsolallog.setOmUsr(omUsr);
		this.getDao().makePersistent(dwConsolallog);
		
		consolidarInicioAlertaTodosPeridos(log, idLog, identacao, omPt, dwconsolpt, dwCalsems, ppCp, dwFolha, dwConsolallog, omcfg, msevt.getDwPepro());

	}


	/**
	 * Consolidar início alerta para todos os perÃ­odos
	 * @param omPt
	 * @param dwConsolpt
	 * @param ppCp
	 * @param dwConsolallog
	 * @param omcfg
	 * @throws SemSGBDException
	 * @throws SemCalendarioException
	 */
	private void consolidarInicioAlertaTodosPeridos(IdwLogger log, int idLog, int identacao, OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, 
			PpCp ppCp, DwFolha dwFolha, DwConsolallog dwConsolallog, OmCfg omcfg, DwPepro dwPepro) 
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		consolidarInicioAlertaTurno(log, idLog, identacao, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolallog, omcfg, dwPepro);
		consolidarInicioAlertaHora(log, idLog, omPt, dwConsolpt, dwCalsems, ppCp, dwFolha, dwConsolallog, omcfg, dwPepro);

	}



	/**
	 * Consolidar início do alerta no turno
	 * @param omPt
	 * @param dwConsolpt
	 * @param ppCp
	 * @param dwConsolallog
	 * @param omcfg
	 * @throws SemSGBDException
	 * @throws SemCalendarioException
	 */
	private void consolidarInicioAlertaTurno(IdwLogger log, int idLog, int identacao, OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, 
			PpCp ppCp, DwFolha dwFolha, DwConsolallog dwConsolallog, OmCfg omcfg, DwPepro dwPepro) 
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		DwConsolid dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, dwConsolallog.getDthrIalerta(), omcfg, dwPepro);

		consolidarInicioAlertaDwConsolid(log, idLog, dwConsolid, dwConsolpt, dwConsolallog);
		
		// Atualizar DwRt. DwRt existe apenas para o turno, numca para a hora
		// Obter o ultimo dwrt 
		TempoRealRN trn = new TempoRealRN(getDao());
		DwRt dwrt = trn.obtemDwRtParaHeartBeatSemClonarTurnoDTO(dwConsolallog.getDthrIalerta(), omPt, log, dwPepro);
		
		if(dwrt != null){
			log.info(idLog, identacao, "Setando Alerta TRUE para dwrt.idRt=" + dwrt.getIdRt());
			dwrt.setIsAlerta(true);
			this.getDao().makePersistent(dwrt);
		} else {
			log.info(idLog, identacao, "Não setou Alerta TRUE pois não encontrou dwrt para inicio de alerta = " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dwConsolallog.getDthrIalerta()) + " em idconsolallog = " + dwConsolallog.getIdConsolallog());
		}
	}



	/**
	 * Consolidar início do alerta para a hora
	 * @param omPt
	 * @param dwConsolpt
	 * @param ppCp
	 * @param dwConsolallog
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	private void consolidarInicioAlertaHora(IdwLogger log, int idLog, OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, PpCp ppCp, 
			DwFolha dwFolha, DwConsolallog dwConsolallog, OmCfg omCfg, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		DwConsolid dwConsolid = this.obtemConsolIdHora(omPt, dwCalsems, ppCp, dwFolha, dwConsolallog.getDthrIalerta(), omCfg, dwPepro);

		consolidarInicioAlertaDwConsolid(log, idLog, dwConsolid, dwConsolpt, dwConsolallog);

	}

	
	
	
	/**
	 * Consolidar início do alerta para o DwConsolid
	 * @param dwConsolid
	 * @param dwConsolallog
	 */
	private void consolidarInicioAlertaDwConsolid(IdwLogger log, int idLog, DwConsolid dwConsolid, DwConsolpt dwConsolpt, DwConsolallog dwConsolallog){

		// Pega dwConsol
		DwConsol dwConsol = null;
		for(DwConsol item:dwConsolid.getDwConsols()){
			dwConsol = item;
			break;
		}

		DwConsolal dwConsolal = this.getDwConsolal(dwConsol.getIdConsol(), dwConsolallog.getDwTAlerta().getIdTalerta());
		if(dwConsolal == null){
			dwConsolal = new DwConsolal();
			dwConsolal.setDwConsol(dwConsol);
			dwConsolal.setDwTAlerta(dwConsolallog.getDwTAlerta());
		}
		this.getDao().makePersistent(dwConsolal);

		// Atualizar DwConsolmooco
		DwConsolaloco dwConsolaloco = new DwConsolaloco();
		dwConsolaloco.setDwConsolal(dwConsolal);
		dwConsolaloco.setDwConsolallog(dwConsolallog);
		dwConsolaloco.setDthrIalerta(dwConsolallog.getDthrIalerta());
		dwConsolaloco.setIsContinuaproximoperiodo(false);
		this.getDao().makePersistent(dwConsolaloco);
	}

}

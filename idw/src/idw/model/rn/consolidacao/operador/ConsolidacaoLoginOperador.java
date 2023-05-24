package idw.model.rn.consolidacao.operador;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

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
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoLoginOperador extends ConsolidaRN implements IConsolidacao{

	/**
	 * TODO documentar procedimento
	 * TODO usar como modelo a consolida��o de refugo
	 * @param omPt
	 * @param list <dwCalSem>
	 * @param msEvt
	 * @param omcfg
	 * @param log
	 * @throws SemCicloPadraoException 
	 * @throws SemSGBDException 
	 * @throws SemCalendarioException 
	 */
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg, IdwLogger log, int idLog, int identacao)  throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException {
		
		Date dthrLogin = msevt.getDthrEvento();
		String cdUsuario = msevt.getLogin();

		Validate.notNull(omPt, "Posto de trabalho est� nulo");
		Validate.notNull(omPt.getIdPt(), "idPt est� nulo");
		Validate.notNull(dthrLogin, "Data hora de login n�o informado");
		Validate.notEmpty(cdUsuario, "C�digo do usu�rio n�o preenchido");
		

		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevt, omcfg);
		Validate.notNull(ppCp, "ppCp nao pode ser nulo");
		ppCp.mudarDthrIniciorealIfNull(dthrLogin);
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"n�o tem folha ativa para o ppCp");

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.getDao().getSession());
		OmUsr omUsr;
		try {
			omUsr = usuarioRN.getOmUsr(cdUsuario);
		} catch (RegistroDesconhecidoException e) {
			omUsr = usuarioRN.getUsuarioByLoginEStAtivo(cdUsuario);
		}
		Validate.notNull(omUsr,"usuario desconhecido " + cdUsuario);

		consolidarLoginTodosPeriodos(log, idLog, identacao, dthrLogin, omUsr, omPt, dwCalsems, ppCp, dwFolha, omcfg, msevt.getDwPepro());
	}

	/**
	 * Consolida o login para todos os periodos (hora, turno, mes, ano, acumulado)
	 * @param dthrLogin
	 * @param omUsr
	 * @param omPt
	 * @param ppCp
	 * @param omcfg
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	private void consolidarLoginTodosPeriodos(IdwLogger log, int idLog, int identacao, Date dthrLogin, OmUsr omUsr, OmPt omPt, 
			List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, OmCfg omcfg, DwPepro dwPepro) 
					throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		// Verificar se ja existe um login aberto para a maquina do operador. Se sim, nao consolidar o registro
		DwConsolmolog dwConsolmolog = null;
		
		dwConsolmolog = getDwConsolmologComLoginAbertoECdLogin(omPt.getIdPt(), omUsr.getLogin());
		
		if (dwConsolmolog != null) {
			// Descartar o login pois operador ja logado
			dwConsolmolog = null;
			Validate.notNull(dwConsolmolog, "Operador " + omUsr.getLogin() + " ja logado no posto " + omPt.getCdPt());
		}
		
		dwConsolmolog = new DwConsolmolog();
		dwConsolmolog.setDthrIlogin(dthrLogin);
		dwConsolmolog.setOmGt(omPt.getOmGt());
		dwConsolmolog.setOmPt(omPt);
		dwConsolmolog.setOmUsr(omUsr);
		this.getDao().makePersistent(dwConsolmolog);

		consolidarLoginTurno(log, idLog, identacao, dwConsolmolog, omPt, dwCalsems, ppCp, dwFolha, omcfg, dwPepro);
		consolidarLoginHora(log, idLog, dwConsolmolog, omPt, dwCalsems, ppCp, dwFolha, omcfg, dwPepro);

	}

	private void consolidarLoginTurno(IdwLogger log, int idLog, int identacao, DwConsolmolog dwConsolmolog, OmPt omPt, List<DwCalsem> dwCalsems, 
			PpCp ppCp, DwFolha dwFolha, OmCfg omcfg, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		DwConsolid dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, dwConsolmolog.getDthrIlogin(), omcfg, dwPepro);

		consolidarLoginDwConsolid(log, idLog, dwPepro, dwConsolid, dwConsolmolog, omPt, ppCp);

	}

	/**
	 * Consolida login para a hora
	 * @param dwConsolmolog
	 * @param omPt
	 * @param ppCp
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	private void consolidarLoginHora(IdwLogger log, int idLog, DwConsolmolog dwConsolmolog, OmPt omPt, 
			List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, OmCfg omCfg, DwPepro dwPepro) 
			throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{

		DwConsolid dwConsolid = this.obtemConsolIdHora(omPt, dwCalsems, ppCp, dwFolha, dwConsolmolog.getDthrIlogin(), omCfg, dwPepro);
		consolidarLoginDwConsolid(log, idLog, dwPepro, dwConsolid, dwConsolmolog, omPt, ppCp);
	}


	/**
	 * Consolida��o de login
	 * @param dwConsolid
	 * @param dwConsolmolog
	 * @param omPt
	 * @param ppCp
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	private void consolidarLoginDwConsolid(IdwLogger log, int idLog, DwPepro dwPepro, DwConsolid dwConsolid, DwConsolmolog dwConsolmolog, OmPt omPt, PpCp ppCp) throws SemCalendarioException, SemSGBDException{

		// Pega dwConsol
		DwConsol dwConsol = null;
		for(DwConsol item:dwConsolid.getDwConsols()){
			dwConsol = item;
			break;
		}
		TempoRealRN trn = new TempoRealRN(getDao());

		// TODO milton - verificar se login j� est� aberto


		DwConsolmo dwConsolmo = this.getDwConsolmo(dwConsol.getIdConsol(),dwConsolmolog.getOmUsr().getIdUsr());
		if(dwConsolmo == null){
			dwConsolmo = new DwConsolmo();
			dwConsolmo.setDwConsol(dwConsol);
			dwConsolmo.setOmUsr(dwConsolmolog.getOmUsr());
		}

		this.getDao().makePersistent(dwConsolmo);

		// Atualizar DwConsolmooco
		DwConsolmooco dwConsolmooco = new DwConsolmooco();
		dwConsolmooco.setDwConsolmo(dwConsolmo);
		dwConsolmooco.setDwConsolmolog(dwConsolmolog);
		dwConsolmooco.setDthrIlogin(dwConsolmolog.getDthrIlogin());
		dwConsolmooco.setIsContinuaproximoperiodo(false);

		this.getDao().makePersistent(dwConsolmooco);

		// Atualizar DwRt
		DwRt dwRt = trn.obtemDwRtParaHeartBeatSemClonarTurnoDTO(dwConsolmolog.getDthrIlogin(), omPt, log, dwPepro);
		if(dwRt != null){
			dwRt.setIsOperador(true);
			this.getDao().makePersistent(dwRt);
		}

	}


	/* abaixo metodo q consolidava apenas dwconsolmolog
	 * 		Validate.notNull(omPt, "Ompt � nulo");
		Validate.notNull(msEvt, "msEvt � nulo");
		Validate.notNull(omcfg, "omcfg � nulo");
		Validate.notNull(log, "log � nulo");
		Validate.notNull(dwCalsems, "Lista de calendario nula");
		
		PpCp ppCp = obtemPpCp(omPt, dwCalsems, msEvt, omcfg);
		Validate.notNull(ppCp, "ppCp n�o pode ser nulo");

		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"n�o tem folha ativa para o ppCp");

		Date dtHrInicioCiclo = msEvt.getDthrEvento();

		// Pega ConsolId
		DwConsolid dwConsolid = this.obtemConsolIdTurno(omPt, dwCalsems, ppCp, dwFolha, dtHrInicioCiclo, omcfg);

		//Pesquisa o usuario
		UsuarioRN rn = new UsuarioRN(this.getDao());
		OmUsr omusr = null;
		omusr = rn.getUsuarioByCdEStAtivo(msEvt.getLogin());

		
		// Inserir em dwconsolmolog
		DwConsolmolog ope = new DwConsolmolog();
		
		ope.setDthrFlogin(null);
		ope.setDthrIlogin(msEvt.getDthrEvento());
		ope.setIdConsolmolog(null);
		ope.setOmPt(omPt);
		ope.setOmUsr(omusr);
		ope.setOmGt(null);
		
		getDao().makePersistent(ope);
		getDao().flushReiniciandoTransacao();
		
		// Seta operador logado no realtime
		DwRt dwrt = dwConsolid.getDwRt();
		dwrt.setIsOperador(true);
	}
	
	/**
	 * Consolidar o login de operador
	 * @param omPt
	 * @param dwCalsems
	 * @param msevt
	 * @param omcfg
	 * @throws RegistroDesconhecidoException
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
}

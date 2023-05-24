package idw.model.rn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmHomogt;
import idw.model.pojos.OmHomopt;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.LoginDTO;
import idw.webservices.dto.LogoutDTO;
import idw.webservices.dto.PassagemDTO;
import injetws.model.excessoes.SemSGBDException;

public class LoginRN extends DAOGenerico {

	public LogoutDTO setLogoutDTO(LogoutDTO logout) throws SemCalendarioException, SemSGBDException {
		IdwLogger log = new IdwLogger("LoginRN");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		LogoutDTO retorno = new LogoutDTO();

		// Obtem configura��es necess�rias para o logout
		// Identifica os dados da configuracao geral do sistema
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(this.getSession());
		if (oOmCfg == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getSEM_CONFIGURACAO());
			return (retorno);
		} else { // if(oOmCfg != null)
			retorno.setSegFeedbacklogin(oOmCfg.getSegFeedbacklogin()); // Tempo
			// em
			// segundos
			// em
			// que a
			// luz
			// de
			// feed-back
			// do
			// login
			// ir�
			// ficar
			// acessa
			retorno.setSegAutologout(oOmCfg.getSegAutologout()); // Tempo em
			// segundos
			// para o
			// logout
			// autom�tico
			// do
			// operador
			// quando
			// nenhum
			// teste
			// estiver
			// sendo
			// realizado
			// no posto.
			// (Copiar
			// atributo
			// para a
			// receita
		}

		// Verifica��o se o usu�rio existe
		OmUsr oOmUsr = null;
		oOmUsr = this.getOmUsr(logout.getCdUsr());

		if (oOmUsr == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getUSUARIO_DESCONHECIDO());
			return (retorno);
		} else { // se oOmUsr != null
			logout.setIdUsr(oOmUsr.getIdUsr());
		}

		// Verifica��o logout no GT se Usu�rio existir
		// Verifica se o usu�rio j� est� logado no GT
		DwConsolmolog oDwConsolmologGt = null;
		oDwConsolmologGt = this.getDwConsolmologGt(logout);

		if (oDwConsolmologGt == null) { // nao esta logado no GT
			retorno.getResultado().setIdmensagem(retorno.getResultado().getSUPERVISOR_NAO_LOGADO());

			// verifica se tem outro logado
			oDwConsolmologGt = this.getUsrLoginGt(logout.getIdGt());

			if (oDwConsolmologGt != null) { // se existir
				retorno.getResultado().setIdmensagem(retorno.getResultado().getOUTRO_SUPERVISOR_LOGADO());
			}
		} else {
			// se esta logado no GT ent�o logout no GT
			this.logoutGt(logout);

			retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGOUT_GT_COM_SUCESSO());

			return (retorno);
		}

		// Verifica��o logout no PT se usu�rio existir e n�o tiver ocorrido
		// logout no GT
		// Verifica se o usu�rio j� est� logado no PT
		DwConsolmolog oDwConsolmologPt = null;
		oDwConsolmologPt = this.getDwConsolmologPt(logout);

		if (oDwConsolmologPt == null) {
			/**
			 * NUNCA DEVE ENTRAR AQUI, SE ENTRAR, O CONCENTRADOR ESTA COM ERRO,
			 * POIS SE PASSAR O CARTAO DE UM USUARIO QUE NAO ESTEJA LOGADO, TEM
			 * QUE LOGAR, E NAO TENTAR DESLOGAR
			 */
			retorno.getResultado().setIdmensagem(retorno.getResultado().getOPERADOR_NAO_LOGADO());

			// verifica se outro est� logado
			oDwConsolmologPt = this.getUsrLoginPt(logout.getIdPt());
			if (oDwConsolmologPt != null) {
				retorno.getResultado().setIdmensagem(retorno.getResultado().getOUTRO_OPERADOR_LOGADO());
			}
		} else { // se logado no PT ent�o logout no PT
			// logout do PT
			this.logoutPt(logout);

			// seta passagemDTO para passar como paramtro para obter consolid
			PassagemDTO oPassagemDTO = new PassagemDTO();
			oPassagemDTO.setIdPt(logout.getIdPt());
			oPassagemDTO.setDtHrEvento(logout.getDtHrFLogin());
			oPassagemDTO.setDtHrEventoAnterior(logout.getDtHrFLogin());
			// oPassagemDTO.setIdTppt(oSessaoDTO.getIdTppt()); // obtem consolid
			// nao usa
			oPassagemDTO.setIdGt(logout.getIdGt());

			// obtendo o OmPt para obter a ultima folha daquele posto.
			OmPt oOmPt = null;
			oOmPt = this.getOmPtById(logout.getIdPt());

			// obtem a ultima folha usada no posto de passagem
			DwFolha oDwFolha = null;
			if (oOmPt != null) {
				oDwFolha = oOmPt.getDwFolha();
			}

			// atualizar dados para monitorizacao em tempo real
			// obtem consolid.c
			ConsolidaRN oConsolidaRN = new ConsolidaRN();
			oConsolidaRN.getDao().setSession(this.getSession());

			DwConsolid oDwConsolid = null;

			oDwConsolid = oConsolidaRN.obtemConsolIdTurno(log, idLog, identacao, oPassagemDTO, oDwFolha);

			oDwConsolid.getDwRt().setIsOperador(false);
			// merge
			// atualiza dw_rt
			this.getSession().merge(oDwConsolid.getDwRt());

			retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGOUT_PT_COM_SUCESSO());
		}

		return (retorno);
	}

	public DwConsolmolog getUsrLoginPt(Long idPt) {
		String hql = "";

		// select * from dw_consolmolog where dthr_flogin is null and
		// id_pt = logout.id_pt

		hql += "SELECT dwconsolmolog ";
		hql += "FROM DwConsolmolog dwconsolmolog ";
		hql += "JOIN dwconsolmolog.omPt ompt ";
		hql += "WHERE (dwconsolmolog.dthrFlogin IS NULL) AND ";
		hql += "(ompt.idPt = ::idPt)";

		hql = hql.replaceAll("::idPt", idPt.toString());

		DwConsolmolog oDwConsolmolog = null;
		try {
			oDwConsolmolog = Util.getDadosBanco(new DwConsolmolog(), this
					.getSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ??????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oDwConsolmolog = null;
		}

		return (oDwConsolmolog);
	}

	private DwConsolmolog getUsrLoginGt(Long idGt) {
		String hql = "";

		// select * from dw_consolmolog where dthr_flogin is null and
		// id_gt = logout.id_gt

		hql += "SELECT dwconsolmolog ";
		hql += "FROM DwConsolmolog dwconsolmolog ";
		hql += "JOIN dwconsolmolog.omGt omgt ";
		hql += "WHERE (dwconsolmolog.dthrFlogin IS NULL) AND ";
		hql += "(omgt.idGt = ::idGt)";

		hql = hql.replaceAll("::idGt", idGt.toString());

		DwConsolmolog oDwConsolmolog = null;
		try {
			oDwConsolmolog = Util.getDadosBanco(new DwConsolmolog(), this
					.getSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ??????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oDwConsolmolog = null;
		}

		return (oDwConsolmolog);
	}

	public LoginDTO setLoginDTO(LoginDTO login) throws SemCalendarioException,
			SemSGBDException {
		IdwLogger log = new IdwLogger("LoginRN");
		int idLog = log.getIdAleatorio();
		int identacao = 0;

		LoginDTO retorno = new LoginDTO();
		retorno.getResultado().setIdmensagem(
				retorno.getResultado().getUSUARIO_DESCONHECIDO());

		// Obtem configura��es necess�rias para o login
		// Identifica os dados da configuracao geral do sistema
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(this.getSession());
		if (oOmCfg == null) {
			retorno.getResultado().setIdmensagem(
					retorno.getResultado().getSEM_CONFIGURACAO());
			return (retorno);
		} else { // if(oOmCfg != null)
			retorno.setSegFeedbacklogin(oOmCfg.getSegFeedbacklogin()); // Tempo
																		// em
																		// segundos
																		// em
																		// que a
																		// luz
																		// de
																		// feed-back
																		// do
																		// login
																		// ir�
																		// ficar
																		// acessa
			retorno.setSegAutologout(oOmCfg.getSegAutologout()); // Tempo em
			// segundos
			// para o
			// logout
			// autom�tico
			// do
			// operador quando nenhum teste estiver sendo realizado no posto.
			// (Copiar atributo para a receita
			// nao existe mais
			// retorno.setSegFeedbackTesteIndisp(oOmCfg.getsegfeedbacktesteindisp());
			// // Tempo em segundos em que todas as luzes do andon ou as luzes
			// de resultado do painel devem piscar na tentativa de inicializa��o
			// de um teste quando um operador n�o estiver logado
		}

		// Verifica��o se o usu�rio existe
		OmUsr oOmUsr = null;
		oOmUsr = this.getOmUsr(login.getCdUsr());

		if (oOmUsr == null) {
			retorno.getResultado().setIdmensagem(
					retorno.getResultado().getUSUARIO_DESCONHECIDO());
			// TODO: verificar se eh para fazer isso mesmo
			return (retorno);
		} else { // se oOmUsr != null
			login.setIdUsr(oOmUsr.getIdUsr());
			retorno.setIdUsr(oOmUsr.getIdUsr());
			retorno.setCdUsr(oOmUsr.getCdUsr());
		}

		// Verifica se o Gt existe
		OmGt omgt = null;
		omgt = (OmGt) findById(OmGt.class, login.getIdGt(), false);

		if (omgt == null) {
			retorno.getResultado().setIdmensagem(
					retorno.getResultado().getERRO_DESCONHECIDO());
			return (retorno);
		}

		// Verifica se o Pt existe
		OmPt ompt = null;
		ompt = this.getOmPtById(login.getIdPt());

		if (ompt == null) {
			retorno.getResultado().setIdmensagem(
					retorno.getResultado().getPT_DESCONHECIDO());
			return (retorno);
		}

		// Verifica se o usuario eh supervisor
		if (oOmUsr.getOmUsrgrp().getIdUsrgrp() == oOmCfg
				.getOmUsrgrpByIdUsrgrpsupervisor().getIdUsrgrp()) {
			// Verifica��o login no GT se Usu�rio existir
			OmHomogt oOmUsrGt = null;
			oOmUsrGt = this.getOmUsrGt(oOmUsr.getIdUsr(), login.getIdGt());

			if (oOmUsrGt == null) { // se login nao tiver homologado no gt
				// prossegue no fluxo normal, pois o login poder� ser feito no
				// PT ao inv�s do GT.
				retorno.getResultado().setIdmensagem(
						retorno.getResultado().getLOGIN_NAO_HOMOLOGADO());
				return retorno;
			}

			// Verifica se o usu�rio j� est� logado no GT
			DwConsolmolog oDwConsolmolog = null;
			oDwConsolmolog = this.getDwConsolmologGt(login);

			// se N�O logado no GT ent�o logar no GT (sem registro no select
			// acima)
			if (oDwConsolmolog == null) {
				// Verifica se outro usu�rio est� logado no GT, se sim efetuar
				// logout
				this.logoutGt(login);

				// registrando login no gt
				this.loginGt(login, omgt, oOmUsr);

				retorno.getResultado().setIdmensagem(
						retorno.getResultado().getLOGIN_GT_COM_SUCESSO());
			} else { // se n�o
				retorno.getResultado().setIdmensagem(
						retorno.getResultado().getLOGIN_GT_PRE_EXISTENTE());
			}

			// se ele tiver homologado no gt, sempre vai retornar aqui
			return (retorno);
		}

		// Verifica se o usuario tem direitos de trabalho no PT
		// Verifica��o login no PT se usu�rio existir e n�o tiver ocorrido
		// login no GT
		OmHomopt oOmUsrPt = null;
		oOmUsrPt = this.getOmUsrPt(login);

		if (oOmUsrPt == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGIN_NAO_HOMOLOGADO());
		} else {
			// Se o direito de acesso for tecnico de manuten��o
			if (oOmUsrPt.getTpHomopt() == (byte) 2) /* manutencao */{
				retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGIN_MANUTENCAO());
				return retorno;
			}
			// Se o direito de acesso for aferidor
			if (oOmUsrPt.getTpHomopt() == (byte) 1) /* afericao */{
				retorno.getResultado().setIdmensagem(retorno.getResultado().getLOGIN_AFERICAO());
				return retorno;
			}
			
			
			// Verifica se o usu�rio j� est� logado no PT
			DwConsolmolog oDwConsolmolog = null;
			oDwConsolmolog = this.getDwConsolmologPt(login);

			if (oDwConsolmolog == null) { // se N�O logado no PT ent�o logar
				// no PT (sem registro no select
				// acima)
				// Verifica se outro usu�rio est� logado no PT, se sim
				// efetuar logout
				this.logoutPt(login);

				// registrando login no pt
				this.loginPt(login, ompt, oOmUsr);

				// seta passagemDTO para passar como paramtro para obter
				// consolid
				PassagemDTO oPassagemDTO = new PassagemDTO();
				oPassagemDTO.setIdPt(login.getIdPt());
				oPassagemDTO.setDtHrEvento(login.getDtHrILogin());
				oPassagemDTO.setDtHrEventoAnterior(login.getDtHrILogin());
				// oPassagemDTO.setIdTppt(oSessaoDTO.getIdTppt()); // obtem
				// consolid nao usa
				oPassagemDTO.setIdGt(login.getIdGt());

				// obtendo o OmPt para obter a ultima folha daquele posto.
				OmPt oOmPt = null;
				oOmPt = this.getOmPtById(login.getIdPt());

				// obtem a ultima folha usada no posto de passagem
				DwFolha oDwFolha = null;
				if (oOmPt != null) {
					oDwFolha = oOmPt.getDwFolha();
				}

				// atualizar dados para monitorizacao em tempo real
				// obtem consolid.c
				ConsolidaRN oConsolidaRN = new ConsolidaRN();
				oConsolidaRN.getDao().setSession(this.getSession());

				DwConsolid oDwConsolid = null;

				oDwConsolid = oConsolidaRN.obtemConsolIdTurno(log, idLog, identacao, oPassagemDTO, oDwFolha);

				oDwConsolid.getDwRt().setIsOperador(true);
				// merge
				// atualiza dw_rt
				this.getSession().merge(oDwConsolid.getDwRt());

				retorno.getResultado().setIdmensagem(
						retorno.getResultado().getLOGIN_PT_COM_SUCESSO());
			} else {
				retorno.getResultado().setIdmensagem(
						retorno.getResultado().getLOGIN_PT_PRE_EXISTENTE());
			}
		}
		return (retorno);
	}

	public OmPt getOmPtById(Long idPt) {
		String hql = "";

		hql += "SELECT ompt ";
		hql += "FROM OmPt ompt ";
		hql += "WHERE (ompt.idPt = ::idPt)";

		hql = hql.replaceAll("::idPt", idPt.toString());

		OmPt oOmPt = null;
		try {
			oOmPt = Util.getDadosBanco(new OmPt(), this.getSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oOmPt = null;
		}

		return (oOmPt);
	}

	public void loginPt(LoginDTO login, OmPt ompt, OmUsr omusr) {
		// insert into dw_consolmolog (dthr_ilogin, ms_dthrilogin, dthr_flogin,
		// ms_dthrflogin, id_usr, id_gt, id_pt) values
		// (login.dthrilogin, login.dthrilogin.milisegundos(), null, null,
		// login.id_usr, null, login.id_pt)

		DwConsolmolog dw = new DwConsolmolog();

		dw.setDthrFlogin(null);
		dw.setDthrIlogin(login.getDtHrILogin());
		dw.setMsDthrflogin(null);
		dw.setMsDthrilogin(DataHoraRN.getApenasMilisegundos(login
				.getDtHrILogin()));

		dw.setOmPt(ompt);
		dw.setOmUsr(omusr);

		makePersistent(dw);
	}

	public void logoutPt(LoginDTO login) {
		logoutPt(login.getDtHrILogin(), login.getIdPt());
	}

	public void logoutPt(LogoutDTO logout) {
		logoutPt(logout.getDtHrFLogin(), logout.getIdPt());
	}

	public void logoutPt(Date dtHrLogout, Long idPt) {
		String sql = "";

		// update dw_consolmolog set dthr_flogin = login.dthrilogin,
		// ms_dthrflogin = login.dthrilogin.milisegundos() where
		// dthr_flogin is null and id_pt = login.id_pt

		sql += "UPDATE dw_consolmolog SET ";
		sql += "	dthr_flogin = :dthr_flogin, ";
		sql += "	ms_dthrflogin = ::ms_dthrflogin ";
		sql += "WHERE (dthr_flogin IS NULL) AND ";
		sql += "	(id_pt = ::id_pt)";

		// pegando milisegundos da data
		String milisecs = new SimpleDateFormat("SSS").format(dtHrLogout);

		sql = sql.replaceAll("::ms_dthrflogin", milisecs);
		sql = sql.replaceAll("::id_pt", idPt.toString());

		Query q = this.getSession().createSQLQuery(sql);

		q.setTimestamp("dthr_flogin", dtHrLogout);

		q.executeUpdate();
		// TODO: o que fazer se der erro???????
	}

	private DwConsolmolog getDwConsolmologPt(LogoutDTO logout) {
		return (this.getDwConsolmologPt(logout.getIdUsr(), logout.getIdPt()));
	}

	private DwConsolmolog getDwConsolmologPt(LoginDTO login) {
		return (this.getDwConsolmologPt(login.getIdUsr(), login.getIdPt()));
	}

	public DwConsolmolog getDwConsolmologPt(Long idUsr, Long idPt) {
		String hql = "";

		// select * from dw_consolmolog where id_usr = login.id_usr and
		// dthr_flogin is null and id_pt = login.id_pt

		hql += "SELECT dwconsolmolog ";
		hql += "FROM DwConsolmolog dwconsolmolog ";
		hql += "JOIN dwconsolmolog.omUsr omusr ";
		hql += "JOIN dwconsolmolog.omPt ompt ";
		hql += "WHERE (omusr.idUsr = ::idUsr) AND ";
		hql += "(dwconsolmolog.dthrFlogin IS NULL) AND ";
		hql += "(ompt.idPt = ::idPt)";

		hql = hql.replaceAll("::idUsr", idUsr.toString());
		hql = hql.replaceAll("::idPt", idPt.toString());

		DwConsolmolog oDwConsolmolog = null;
		try {
			oDwConsolmolog = Util.getDadosBanco(new DwConsolmolog(), this.getSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oDwConsolmolog = null;
		}

		return (oDwConsolmolog);
	}

	public OmHomopt getOmUsrPt(LoginDTO login) {
		MapQuery q = new MapQuery(this.getSession());

		// select *
		// from om_usr
		// join om_homopt on om_homopt.id_usrhomologado = om_usr.id_usr
		// where st_ativo=1 and cd_usr = login.cd_usr and
		// om_homopt.id_pt = login.id_pt

		q.append("SELECT omhomopt ");
		q.append("FROM OmHomopt omhomopt ");
		// hql += "JOIN omhomopt.omUsrByIdUsrhomologado omusr ";
		// hql += "JOIN omhomopt.omPt ompt ";
		q.append("WHERE ");
		q.append("omhomopt.omUsrByIdUsrhomologado.idUsr = :idUsr AND ");
		q.append("omhomopt.omPt.idPt = :idPt ");

		q.defineParametro("idUsr", login.getIdUsr());
		q.defineParametro("idPt", login.getIdPt());

		q.query().setMaxResults(1);
		
		OmHomopt oOmHomopt = null;

		oOmHomopt = (OmHomopt) q.query().uniqueResult();
		
		q = null;

		return (oOmHomopt);
	}

	// loga nego no gt
	public void loginGt(LoginDTO login, OmGt omgt, OmUsr omusr) {
		// insert into dw_consolmolog (dthr_ilogin, ms_dthrilogin, dthr_flogin,
		// ms_dthrflogin, id_usr, id_gt, id_pt) values
		// (login.dthrilogin, login.dthrilogin.milisegundos(), null, null,
		// login.id_usr, login.id_gt, null)

		DwConsolmolog dw = new DwConsolmolog();

		dw.setDthrFlogin(null);
		dw.setDthrIlogin(login.getDtHrILogin());
		dw.setMsDthrflogin(null);
		dw.setMsDthrilogin(DataHoraRN.getApenasMilisegundos(login
				.getDtHrILogin()));

		dw.setOmGt(omgt);
		dw.setOmUsr(omusr);

		makePersistent(dw);
	}

	private void logoutGt(LoginDTO login) {
		logoutGt(login.getDtHrILogin(), login.getIdGt());
	}

	private void logoutGt(LogoutDTO logout) {
		logoutGt(logout.getDtHrFLogin(), logout.getIdGt());
	}

	// desloga qq um do GT
	private void logoutGt(Date dtHrLogout, Long idGt) {
		String sql = "";

		// update dw_consolmolog set dthr_flogin = login.dthrilogin,
		// ms_dthrflogin = login.dthrilogin.milisegundos()
		// where dthr_flogin is null and id_gt = login.id_gt

		sql += "UPDATE dw_consolmolog SET ";
		sql += "dthr_flogin = :dthr_flogin, ";
		sql += "ms_dthrflogin = ::ms_dthrflogin ";
		sql += "WHERE (dthr_flogin IS NULL) AND ";
		sql += "(id_gt = ::id_gt)";

		// pegando milisegundos da data
		String milisecs = new SimpleDateFormat("SSS").format(dtHrLogout);

		sql = sql.replaceAll("::ms_dthrflogin", milisecs);
		sql = sql.replaceAll("::id_gt", idGt.toString());

		Query q = this.getSession().createSQLQuery(sql);

		q.setTimestamp("dthr_flogin", dtHrLogout);

		q.executeUpdate();
		// TODO: o que fazer se der erro???????
	}

	private DwConsolmolog getDwConsolmologGt(LogoutDTO logout) {
		return (this.getDwConsolmologGt(logout.getIdUsr(), logout.getIdGt()));
	}

	private DwConsolmolog getDwConsolmologGt(LoginDTO login) {
		return (this.getDwConsolmologGt(login.getIdUsr(), login.getIdGt()));
	}

	public DwConsolmolog getDwConsolmologGt(Long idUsr, Long idGt) {
		MapQuery q = new MapQuery(this.getSession());

		// select * from dw_consolmolog where id_usr = login.id_usr and
		// dthr_flogin is null and id_gt = login.id_gt

		q.append("SELECT dwconsolmolog ");
		q.append("FROM DwConsolmolog dwconsolmolog ");
		// hql += "JOIN dwconsolmolog.omUsr omusr ";
		// hql += "JOIN dwconsolmolog.omGt omgt ";
		q.append("WHERE dwconsolmolog.omUsr.idUsr = :idUsr AND ");
		q.append("dwconsolmolog.dthrFlogin IS NULL AND ");
		q.append("dwconsolmolog.omGt.idGt = :idGt ");

		q.defineParametro("idUsr", idUsr);
		q.defineParametro("idGt", idGt);

		DwConsolmolog oDwConsolmolog = null;

		oDwConsolmolog = (DwConsolmolog) q.query().uniqueResult();

		q = null;
		
		return (oDwConsolmolog);
	}

	public OmHomogt getOmUsrGt(Long idUsr, Long idGt) {
		String hql = "";

		// select *
		// from om_usr
		// join om_homogt on om_homogt.id_usrhomologado = om_usr.id_usr
		// where (st_ativo=1) and (cd_usr = login.cd_usr) and
		// (om_homogt.id_gt = login.id_gt)

		hql += "SELECT omhomogt ";
		hql += "FROM OmHomogt omhomogt ";
		// hql += "JOIN omhomogt.omUsrByIdUsrhomologado omusr ";
		// hql += "JOIN omhomogt.omGt omgt ";
		hql += "WHERE ";
		hql += "omhomogt.omUsrByIdUsrhomologado.idUsr = ::idUsr AND ";
		hql += "omhomogt.omGt.idGt = ::idGt";

		hql = hql.replaceAll("::idUsr", idUsr.toString());
		hql = hql.replaceAll("::idGt", idGt.toString());

		OmHomogt oOmHomogt = null;
		try {
			oOmHomogt = Util.getDadosBanco(new OmHomogt(), this.getSession(),
					hql);
		} catch (SemSGBDException e) {
			// TODO: ??????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oOmHomogt = null;
		}

		return (oOmHomogt);
	}

	public OmUsr getOmUsr(String cdUsr) {
		OmUsr oOmUsr = null;

		if (cdUsr == null)
			return oOmUsr;

		String hql = "";

		hql += "SELECT omusr ";
		hql += "FROM OmUsr omusr ";
		hql += "WHERE omusr.stAtivo = 1 AND ";
		hql += "omusr.cdUsr = '::cdUsr'";

		hql = hql.replaceAll("::cdUsr", cdUsr);

		try {
			oOmUsr = Util.getDadosBanco(new OmUsr(), this.getSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: o que fazer se der pau no banco???????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oOmUsr = null;
		}

		return (oOmUsr);
	}

	public DwConsolmolog getSupervisorGt(Long idGt) {
		MapQuery q = new MapQuery(this.getSession());

		// select * from dw_consolmolog where id_gt = passagem.id_gt and
		// dthr_flogin is null;

		q.append("SELECT dwconsolmolog ");
		q.append("FROM DwConsolmolog dwconsolmolog ");
		q.append("JOIN dwconsolmolog.omGt omgt ");
		q.append("WHERE omgt.idGt = :idGt AND ");
		q.append("dwconsolmolog.dthrFlogin IS NULL ");

		q.defineParametro("idGt", idGt);
		q.query().setMaxResults(1);

		DwConsolmolog oDwConsolmolog = null;

		oDwConsolmolog = (DwConsolmolog) q.query().uniqueResult();

		q = null;
		
		return (oDwConsolmolog);
	}
	public OmUsr getUsuarioById(Long idUsr) {
		MapQuery q = new MapQuery(this.getSession());

		// select * from om_usr where cd_usr = cb and st_ativo = 1

		q.append("SELECT omusr ");
		q.append("FROM OmUsr omusr ");
		q.append("WHERE omusr.idUsr = :idUsr AND ");
		q.append("omusr.stAtivo = 1 ");

		q.defineParametro("idUsr", idUsr);
		q.query().setMaxResults(1);

		OmUsr oOmUsr = null;
		
		oOmUsr = (OmUsr) q.query().uniqueResult();
		
		q = null;

		return(oOmUsr);
	}
	
	@SuppressWarnings("unchecked")
	public List<DwConsolmolog> getUsrsLoginPt(Long idPt) {
		MapQuery q = new MapQuery(this.getSession());

		// select * from dw_consolmolog where dthr_flogin is null and
		// id_pt = logout.id_pt

		q.append("SELECT dwconsolmolog ");
		q.append("FROM DwConsolmolog dwconsolmolog ");
		q.append("JOIN dwconsolmolog.omPt ompt ");
		q.append("WHERE (dwconsolmolog.dthrFlogin IS NULL) AND ");
		q.append("(ompt.idPt = :idPt)");
		
		q.defineParametro("idPt", idPt);

		List<DwConsolmolog> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<DwConsolmolog> lista = new ArrayList<DwConsolmolog>();

		if (listaPesquisa != null) {
			for (DwConsolmolog item : listaPesquisa) {
				DwConsolmolog dwc = new DwConsolmolog();
				dwc = item;
				
				lista.add(dwc);
			}
		}

		return lista;
	}
	
}

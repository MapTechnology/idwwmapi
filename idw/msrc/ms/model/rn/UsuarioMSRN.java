package ms.model.rn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwRt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUp;
import idw.model.pojos.MsUsr;
import idw.model.pojos.OmGrnts;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.pojos.template.OmGrntsTemplate;
import idw.model.pojos.template.OmResguiTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.HashMD5;
import idw.model.rn.PTRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.consolidacao.operador.ConsolidacaoLogoutOperador;
import idw.util.IdwLogger;
import idw.webservices.dto.UsuarioDTO;
import injetws.model.IwsFacade;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import ms.excessao.UsuarioDesconhecidoException;
import ms.model.dto.EventoColetado;
import ms.model.dto.UsuarioMSDTO;


public class UsuarioMSRN extends UsuarioMSDTO implements IDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3992976804031871218L;
	private transient DAOGenerico dao = null;


	public UsuarioMSRN(){
		if (this.dao == null)
			dao = new DAOGenerico();
		
	}
	public UsuarioMSRN(DAOGenerico dao){
		this.dao = dao;
	}
	@Override
	public void iniciaConexaoBanco(Session sessao){
		dao.iniciaSessao();
		dao.iniciaTransacao();
	}
	@Override
	public void finalizaConexaoBanco(){
		dao.finalizaTransacao();
		dao.finalizaSessao();
	}
	public void setUsuarioDTO(UsuarioMSDTO usuarioDTO){
		this.setLogin(usuarioDTO.getLogin());
		this.setSenha(usuarioDTO.getSenha());
	}
	
	
	public UsuarioMSDTO isUsuarioAutenticado() throws UsuarioDesconhecidoException{
		MsUsr msusr = null;
		UsuarioMSDTO usuarioRetorno = getUsuarioDTO();
		msusr = pesquisarMsUsrUsandoLogin();
		
		if (msusr == null)
			throw new UsuarioDesconhecidoException();
		
		try {
			if (HashMD5.isSenhaValida(msusr.getSenha(), getSenha()) == false){
				
				usuarioRetorno.setResultadoEvento(getERRO_LOGIN_INVALIDO());
				return usuarioRetorno;
			}
		} catch (idw.model.excessoes.DigestFileException e) {			
			e.printStackTrace();
			usuarioRetorno.setResultadoEvento(getERRO_LOGIN_INVALIDO());
			return usuarioRetorno;
		}
		usuarioRetorno.setMsusr(msusr.clone());
		usuarioRetorno.setResultadoEvento(getEVENTO_BEM_SUCEDIDO());
		return usuarioRetorno;
	}
	
	public MsUsr pesquisarMsUsrUsandoLogin(){
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select msusr ");
		q.append("from MsUsr msusr ");
		q.append("where msusr.login = :login ");
		q.append("and msusr.stAtivo = 1 ");
		
		q.defineParametro("login", this.getLogin());
		
		q.setMaxResults(1);
		
		return (MsUsr) q.uniqueResult();
	}
	
	public MsUsr pesquisarMsUsrUsandoById(){
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select msusr ");
		q.append("from MsUsr msusr ");
		q.append("where msusr.idUsr = :idusr ");
		
		q.defineParametro("idusr", new BigDecimal(this.getIdUsr()));
				
		return (MsUsr) q.uniqueResult();
	}
	
	public MsEvt isLogoutEfetuado(EventoColetado evento){
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();
		
		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDao().getSession());
		// Descobrir o evento de login para poder associar ao evento de logout
		MsEvt msevtLogin = null;
		msevtLogin = eventoRN.pesquisarMsEvtUltimoEventoAberto(evento, MsTpevtTemplate.Type.INICIO_LOGIN.getId());

		return eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.FIM_LOGIN.getId(), msevtLogin);
	}
	
	public boolean deslogarUsuario(String cdPt, String login, Date dthrLogout) {
		UpRN uprn = new UpRN(getDao(), null);
		MsUp msup = uprn.pesquisarMsUpPorIdUp(new BigDecimal(cdPt));
		if (msup == null) {
			msup = uprn.pesquisarMsUpPorIdUpPdba(cdPt);
			if (msup == null)
				return false;
		}
		
		OmPt ompt;
		PTRN prn = new PTRN(getDao());
		ompt = prn.pesquisarPtByCdPtStAtivo(msup.getCdUp());
		if (ompt == null)
			return false;
		ConsolidacaoLogoutOperador lrn = new ConsolidacaoLogoutOperador();
		lrn.setDao(getDao());
		
		List<DwConsolmolog> lista = lrn.obtemListaDwConsolmologEmAbertoByLogin(ompt, login);
		if (lista == null || lista.size() <= 0) {
			lista = lrn.obtemListaDwConsolmologEmAbertoByCd(ompt, login);
		}
		
		for (DwConsolmolog dwconsolmolog : lista) {
			dwconsolmolog.setDthrFlogin(dthrLogout);
			this.getDao().makePersistent(dwconsolmolog);
		}
		// Alterar em dwrt setando operador logado
		TempoRealRN trn = new TempoRealRN(getDao());
		ConsolidaRN crn = new ConsolidaRN(getDao());
		
		//DwRt dwrt = rnc.obtemDwRtParaHeartBeat(dthrLogout, ompt);
		// Alessandre realivara linha acima
		DwRt dwrt = trn.getUltimoDwRt(ompt.getIdPt());
		if (dwrt != null) {
			// verifica se tem operador logado ainda
			List<DwConsolmolog> logins = crn.getDwConsolmologComLoginAberto(ompt.getIdPt());
			if (logins.size() > 0)
				dwrt.setIsOperador(true);
			else
				dwrt.setIsOperador(false);
			
			getDao().makePersistent(dwrt);
		}

		
		return true;
	}
	
	public boolean logarUsuario(String cdPt, String login, Date dthrLogin) {
		UsuarioRN rn = new UsuarioRN(getDao());
		OmUsr omusr;
		
		// Verificar se existe o usuario na base IDW
		omusr = rn.getUsuarioByCdEStAtivo(login);
		if (omusr == null) {
			// Se nao encontrou procurar no campo login
			omusr = rn.getUsuarioByLoginEStAtivo(login);
			if (omusr == null) {
				
				return false;
			}
		}
		// Verificar se o usuario tem direito de se logar no CLP
		for (OmGrnts omgrnt : omusr.getOmUsrgrp().getOmGrntses()) {
			if (omgrnt.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINOPERADOR.getValue()) {
				// Se o direito for negado retornar false
				if (omgrnt.getTpAcesso().equals(OmGrntsTemplate._TpAcesso._ACESSONEGADO.getValue()) == true)
					return false;
			}
		}
		
		
		UpRN uprn = new UpRN(getDao(), null);
		
		MsUp msup = uprn.pesquisarMsUpPorIdUp(new BigDecimal(cdPt));
		if (msup == null) {
			msup = uprn.pesquisarMsUpPorIdUpPdba(cdPt);
			if (msup == null) {
				
				return false;
			}
		}
		
		OmPt ompt;
		PTRN prn = new PTRN(getDao());
		ompt = prn.pesquisarPtByCdPtStAtivo(msup.getCdUp());
		if (ompt == null) {
			
			return false;
		}

		ConsolidacaoLogoutOperador lrn = new ConsolidacaoLogoutOperador();
		lrn.setDao(getDao());
		
		List<DwConsolmolog> lista = lrn.obtemListaDwConsolmologEmAbertoByLogin(ompt, login);

		if (lista.size() > 0) {
			
			return false;
		}
		
		DwConsolmolog dwConsolmolog = null;
		dwConsolmolog = new DwConsolmolog();
		dwConsolmolog.setDthrIlogin(dthrLogin);
		dwConsolmolog.setOmGt(ompt.getOmGt());
		dwConsolmolog.setOmPt(ompt);
		dwConsolmolog.setOmUsr(omusr);
		this.getDao().makePersistent(dwConsolmolog);

		// Alterar em dwrt setando operador logado
		TempoRealRN trn = new TempoRealRN(getDao());
		DwRt dwrt = trn.getUltimoDwRt(ompt.getIdPt());
		if (dwrt != null) {
			dwrt.setIsOperador(true);
			getDao().makePersistent(dwrt);
		}

		
		return true;
	}
	public MsEvt logarUsuario(EventoColetado evento){
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();
		
		
		UsuarioRN rn = new UsuarioRN(getDao());
		OmUsr omusr;
		
		// Verificar se existe o usuario na base IDW
		omusr = rn.getUsuarioByCdEStAtivo(evento.getLogin());
		if (omusr == null) {
			// Se nao encontrou procurar no campo login
			omusr = rn.getUsuarioByLoginEStAtivo(evento.getLogin());
			if (omusr == null) {
				return null;
			}
		}
		// Verificar se o usuario tem direito de se logar no CLP
		for (OmGrnts omgrnt : omusr.getOmUsrgrp().getOmGrntses()) {
			if (omgrnt.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINOPERADOR.getValue()) {
				// Se o direito for negado retornar false
				if (omgrnt.getTpAcesso().equals(OmGrntsTemplate._TpAcesso._ACESSONEGADO.getValue()) == true)
					return null;
			}
		}

		
		// valida a senha do operador
		try {
			String senhacrip = HashMD5.getHashCode(evento.getSenha());
			
			/* Quando esse metodo eh chamado a partir de um coletor InovaEco ou CPFlex a senha nao vem mais no Evento coletado
			 * pois ela foi validada previamente. Entao quando senhacrip estiver null vou pressupor que o coletor
			 * eh o ECO e aceitar sem verificar a senha.
			 * Avaliar se para outros coletor o login vai ser efetivado se o valor for null
			 */
			if (evento.getSenha() != null && HashMD5.isSenhaValida(omusr.getSenha(), senhacrip) == false){

				if (HashMD5.isSenhaValida(omusr.getSenha(), evento.getSenha())==false) {
					return null;
				}
			}
		} catch (idw.model.excessoes.DigestFileException e) {
			return null;
		}

		
		
		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDao().getSession());
		
		return eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.INICIO_LOGIN.getId(), null);
	}
	
	
	
	public boolean isUsuarioOperadorAutenticado(String idup, String login, String senha){
		
		
		//TODO:mudar para chamada do Facade 
		IwsAutenticacaoDTO autenticacaoDTO= new IwsAutenticacaoDTO();
		autenticacaoDTO= IwsFacade.getInstancia().getTr_Autorizacao(idup, login, senha, 0, DataHoraRN.getDataHoraAtual(), false);
		if (autenticacaoDTO != null){
			if (autenticacaoDTO.getIsAutorizado()){
				//TODO:mudar para chamada do Facade 
				//iRN.efetuaLogin(idup, login, DataHoraRN.getDataHoraAtual());							
				return true;
			}
			
		}
		return false;		
	}
	

	public DAOGenerico getDao(){
		return this.dao;
	}

	public idw.webservices.dto.UsuarioDTO isOperadorAutenticado(String login, String senha) {
		UsuarioRN rn = new UsuarioRN(getDao());
		OmUsr omusr;
		UsuarioDTO retorno = new UsuarioDTO();
		
		// Verificar se existe o usuario na base IDW
		omusr = rn.getUsuarioByCdEStAtivo(login);
		if (omusr == null) {
			// Se nao encontrou procurar no campo login
			omusr = rn.getUsuarioByLoginEStAtivo(login);
			if (omusr == null) {
				retorno.setResultadoEvento(1);
				return retorno;
			}
		}
		// Verificar se o usuario tem direito de se logar no CLP
		for (OmGrnts omgrnt : omusr.getOmUsrgrp().getOmGrntses()) {
			if (omgrnt.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINOPERADOR.getValue()) {
				// Se o direito for negado retornar false
				if (omgrnt.getTpAcesso().equals(OmGrntsTemplate._TpAcesso._ACESSONEGADO.getValue()) == true) {
					retorno.setResultadoEvento(1);
					return retorno;
				}
			}
		}

		
		// valida a senha do operador
		try {
			String senhacrip = HashMD5.getHashCode(senha);
			if (HashMD5.isSenhaValida(omusr.getSenha(), senhacrip) == false){
				if (HashMD5.isSenhaValida(omusr.getSenha(), senha) == false) {
					retorno.setResultadoEvento(1);
					return retorno;
				}
			}
		} catch (idw.model.excessoes.DigestFileException e) {
			retorno.setResultadoEvento(1);
			return retorno;
		}
		retorno.setResultadoEvento(0);
		retorno.setUsuario(omusr.clone(false));
		return retorno;
	}





	public idw.webservices.dto.UsuarioDTO isSupervisorCancelaEtiqueta(String login, String senha) {
		UsuarioRN rn = new UsuarioRN(getDao());
		OmUsr omusr;
		UsuarioDTO retorno = new UsuarioDTO();
		
		// Verificar se existe o usuario na base IDW
		omusr = rn.getUsuarioByCdEStAtivo(login);
		if (omusr == null) {
			// Se nao encontrou procurar no campo login
			omusr = rn.getUsuarioByLoginEStAtivo(login);
			if (omusr == null) {
				retorno.setResultadoEvento(1);
				return retorno;
			}
		}
		// Verificar se o usuario tem direito de se logar como supervisor
		boolean isDireitoLiberado = false;
		for (OmGrnts omgrnt : omusr.getOmUsrgrp().getOmGrntses()) {
			if (omgrnt.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_AUTUORIZACANCELAMENTOETIQUETA.getValue()) {
				isDireitoLiberado = true;
				// Se o direito for negado retornar false
				if (omgrnt.getTpAcesso().equals(OmGrntsTemplate._TpAcesso._ACESSONEGADO.getValue()) == true) {
					retorno.setResultadoEvento(1);
					return retorno;
				}
			}
		}
		
		if (isDireitoLiberado == false) {
			retorno.setResultadoEvento(1);
			return retorno;
		}

		
		// valida a senha do operador
		try {
			String senhacrip = HashMD5.getHashCode(senha);
			if (HashMD5.isSenhaValida(omusr.getSenha(), senhacrip) == false){
				if (HashMD5.isSenhaValida(omusr.getSenha(), senha) == false) {
					retorno.setResultadoEvento(1);
					return retorno;
				}
			}
		} catch (idw.model.excessoes.DigestFileException e) {
			retorno.setResultadoEvento(1);
			return retorno;
		}
		retorno.setResultadoEvento(0);
		retorno.setUsuario(omusr.clone(false));
		return retorno;
	}

	public idw.webservices.dto.UsuarioDTO isTecnicoTrocaOP(String login, String senha) {
		UsuarioRN rn = new UsuarioRN(getDao());
		OmUsr omusr;
		UsuarioDTO retorno = new UsuarioDTO();
		
		// Verificar se existe o usuario na base IDW
		omusr = rn.getUsuarioByCdEStAtivo(login);
		if (omusr == null) {
			// Se nao encontrou procurar no campo login
			omusr = rn.getUsuarioByLoginEStAtivo(login);
			if (omusr == null) {
				retorno.setResultadoEvento(1);
				return retorno;
			}
		}
		// Verificar se o usuario tem direito de se logar como supervisor
		boolean isDireitoLiberado = false;
		for (OmGrnts omgrnt : omusr.getOmUsrgrp().getOmGrntses()) {
			if (omgrnt.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINTECNICOTROCAOP.getValue()) {
				isDireitoLiberado = true;
				// Se o direito for negado retornar false
				if (omgrnt.getTpAcesso().equals(OmGrntsTemplate._TpAcesso._ACESSONEGADO.getValue()) == true) {
					retorno.setResultadoEvento(1);
					return retorno;
				}
			}
		}
		
		if (isDireitoLiberado == false) {
			retorno.setResultadoEvento(1);
			return retorno;
		}

		
		// valida a senha do operador
		try {
			String senhacrip = HashMD5.getHashCode(senha);
			if (HashMD5.isSenhaValida(omusr.getSenha(), senhacrip) == false){
				if (HashMD5.isSenhaValida(omusr.getSenha(), senha) == false) {
					retorno.setResultadoEvento(1);
					return retorno;
				}
			}
		} catch (idw.model.excessoes.DigestFileException e) {
			retorno.setResultadoEvento(1);
			return retorno;
		}
		retorno.setResultadoEvento(0);
		retorno.setUsuario(omusr.clone(false));
		return retorno;
	}
}

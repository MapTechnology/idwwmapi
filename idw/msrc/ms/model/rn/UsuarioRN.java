package ms.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUsr;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.IwsFacade;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsErroDTO;

import java.math.BigDecimal;

import org.hibernate.Session;

import ms.excessao.DigestFileException;
import ms.excessao.UsuarioDesconhecidoException;
import ms.model.dto.EventoColetado;
import ms.model.dto.UsuarioMSDTO;


public class UsuarioRN extends UsuarioMSDTO implements IDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3992976804031871218L;
	private transient DAOGenerico dao = null;
	private IdwLogger log=null;	

	public UsuarioRN(){
		if (this.dao == null)
			dao = new DAOGenerico();
		
	}
	public UsuarioRN(DAOGenerico dao){
		this.dao = dao;
	}
	@Override
	public void iniciaConexaoBanco(Session sessao){
		dao.iniciaSessao();
		dao.iniciaTransacao();
	}
	@Override
	public void finalizaConexaoBanco(){
		dao.finalizaSessao();
		dao.finalizaTransacao();
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
			if (!HashMD5.isSenhaValida(msusr.getSenha(),getSenha())){
				
				usuarioRetorno.setResultadoEvento(getERRO_LOGIN_INVALIDO());
				return usuarioRetorno;
			}
		} catch (DigestFileException e) {			
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
	
	public boolean isLogoutEfetuado(EventoColetado evento){
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();
		
		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDao().getSession());
		// Descobrir o evento de login para poder associar ao evento de logout
		MsEvt msevtLogin = null;
		msevtLogin = eventoRN.pesquisarMsEvtUltimoEventoAberto(evento, MsTpevtTemplate.Type.INICIO_LOGIN.getId());
		eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.FIM_LOGIN.getId(), msevtLogin);
		//TODO: Verificar o que fazer com msevt
		boolean isRetorno = true;
		
		if (evento.isChamarInjetWs() == true) {
			//TODO:mudar para chamada do Facade
			//DAOGenerico daoPdba = new DAOGenerico();
			//DAOGenericoInjet daoInjet = new DAOGenericoInjet();
			//injetws.model.rn.InfoRN iRn = new injetws.model.rn.InfoRN(log, daoInjet, daoPdba);
			//InfoRN iRn = new InfoRN(log, daoInjet, daoPdba);
			//iRn.efetuaLogout(msevt.getMsMsicup().getMsUp().getIduppdba(), evento.getLogin(), DataHoraRN.getDataHoraAtual(), evento.getDthrEvento());
			//MaoDeObraPdbaMsEvtRN rn = new MaoDeObraPdbaMsEvtRN();
			//rn.setTr_operadorFim(msevt.getMsMsicup().getMsUp().getIduppdba(),  evento.getLogin(), DataHoraRN.getDataHoraAtual(), evento.getDthrEvento());
			//MswsComEvt mswEvt = new MswsComEvt();
			//mswEvt.setTr_operadorFim(msevt.getMsMsicup().getMsUp().getIduppdba(),  evento.getLogin(), DataHoraRN.getDataHoraAtual(), evento.getDthrEvento());
			IwsErroDTO iws = new IwsErroDTO();
			iws = IwsFacade.getInstancia().efetuaLogout(evento.getIcUpDTO().getUpDTO().getIdUpPDBA(),  evento.getLogin(), DataHoraRN.getDataHoraAtual(), evento.getDthrEvento());
			if(iws.getSucesso() == false){
				isRetorno = false;
			}
		}
		return isRetorno;
	}
	
	public boolean logarUsuario(EventoColetado evento){
		IdwLogger log = evento.getLog();
		int identacao = evento.getIdentacao();
		int idLog = evento.getIdLog();
		
		// Sempre salvar em msEvt o evento, mesmo que seja recusado pelo injetws
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDao().getSession());
		eventoRN.incluirEvento(log, idLog, identacao, evento, MsTpevtTemplate.Type.INICIO_LOGIN.getId(), null);

		boolean isRetorno = true;
		
		if (evento.isChamarInjetWs() == true) {
			IwsErroDTO iws = new IwsErroDTO();
			iws = IwsFacade.getInstancia().efetuaLogin(evento.getIcUpDTO().getUpDTO().getIdUpPDBA(), evento.getLogin(), evento.getDthrEvento());
			if(iws.getSucesso() == false){
				isRetorno = false;
			}
		}
		
		return isRetorno;
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
	
}

package ms.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MsEvtDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsMs;
import idw.model.pojos.MsUp;
import idw.model.pojos.template.MsEvtTemplate.StEvt;
import idw.model.pojos.template.MsIcTemplate;
import idw.model.rn.CIPRN;
import idw.model.rn.CpRN;
import idw.model.rn.VarRitmoRN;
import idw.util.IdwLogger;
import idw.webservices.dto.UsuarioDTO;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.coleta.dto.IndicadoresColetaGraficoInjetDTO;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.ParadaColetaComAndonDTO;
import ms.coleta.dto.ParadasColetaComAndonDTO;
import ms.coleta.dto.TAndonSADTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.excessao.FuncionalidadeIndisponivelException;
import ms.excessao.IcDesconhecidoException;
import ms.excessao.MsDesconhecidoException;
import ms.excessao.ServicoFalhouException;
import ms.excessao.UsuarioDesconhecidoException;
import ms.model.dto.BcDTO;
import ms.model.dto.ConfiguraHibernateDTO;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.IhmDTO;
import ms.model.dto.ListaBcDTO;
import ms.model.dto.ListaEvtDTO;
import ms.model.dto.ListaIcDTO;
import ms.model.dto.ListaIhmDTO;
import ms.model.dto.ListaMSDTO;
import ms.model.dto.ListaUPDTO;
import ms.model.dto.Log4jDTO;
import ms.model.dto.MsDTO;
import ms.model.dto.MsicupsDTO;
import ms.model.dto.OPAutomaticaDTO;
import ms.model.dto.UpDTO;
import ms.model.dto.UsuarioMSDTO;
import ms.model.dto.WebXMLDTO;
import ms.model.ic.FirmwaresDTO;
import ms.model.rn.BcRN;
import ms.model.rn.ConfiguraHibernateRN;
import ms.model.rn.EventoRN;
import ms.model.rn.IcRN;
import ms.model.rn.IhmRN;
import ms.model.rn.Log4jRN;
import ms.model.rn.MsRN;
import ms.model.rn.UpRN;
import ms.model.rn.UsuarioMSRN;
import ms.model.rn.WebXMLRN;
import ms.model.rn.coletaComAndon.ColetaGraficoRN;
import ms.model.rn.coletaComAndon.OperadorRN;
import ms.model.rn.coletaComAndon.ParadaColetaComAndonRN;
import ms.model.rn.importacao.pdba.ImportacaoManual;

public class MsFacade{
	private static final Log log = LogFactory.getLog(MsFacade.class);
	private static MsFacade instancia = null;
	private  String caminhoRelativo;
	private MsFacade(){
	}
	public static MsFacade getInstancia(){
		if (instancia == null)
			instancia = new MsFacade();
		return instancia;
	}

	public MsDTO registraIhmNoMs(IhmDTO ihmdto, MsDTO msdto) {
		
		MsRN msRN = new MsRN();
		try {			
			msRN.iniciaConexaoBanco();
			msRN.setMsDTO(msdto);
			msRN.registrarIHM(ihmdto);
		} catch (Exception e){
			e.printStackTrace();
			getLog().info(e);
		} finally {
			try{
				msRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				msRN.finalizaConexaoBanco();
			}
		}
		return msRN.getMsdDTO();
	}
	
	public IwsConsultaDTO consulta(MensagemRecebida mensagem, EventoColetado evento){
		UpRN upRN = new UpRN();
		if(upRN.getDaoInjet() == null)
			upRN.setDaoInjet(new DAOGenericoInjet());
		upRN.iniciaConexaoBanco();
		IwsConsultaDTO consulta = null;
		consulta = upRN.consultaIHMInjet(mensagem, evento);
		upRN.finalizaConexaoBanco();
		return consulta;		
		
	}	
	
	public MsEvt iniciarNovaOP(EventoColetado evento){
	    UpRN upRN = new UpRN();
		MsEvt msevt;

		try {
			if(upRN.getDaoInjet() == null)
				upRN.setDaoInjet(new DAOGenericoInjet());
			
			upRN.iniciaConexaoBanco();
			
			msevt = upRN.iniciarNovaOP(evento);
			
			
		    if (msevt != null) {
		    	upRN.iniciarNovaOpRestoLinha(evento);
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
			msevt = null;
		} finally {
			upRN.finalizaConexaoBanco();
		}
		return msevt;
	}
	
	public MsEvt iniciarCIP(EventoColetado evento){
	    CIPRN cipRN = new CIPRN();
	    MsEvt retorno = null;
	    cipRN.iniciaConexaoBanco();
		
		retorno = cipRN.iniciarCIP(evento);
		
		cipRN.finalizaConexaoBanco();
		return retorno;
	}
	
	public MsEvt finalizarCIP(EventoColetado evento){
	    CIPRN cipRN = new CIPRN();
	    MsEvt retorno = null;
	    cipRN.iniciaConexaoBanco();
		
		retorno = cipRN.finalizarCIP(evento);
		
		cipRN.finalizaConexaoBanco();
		return retorno;
	}
	
	public boolean iniciarVarRitmo(EventoColetado evento){
	    VarRitmoRN varRitmoRN = new VarRitmoRN();
	    boolean retorno = false;
	    varRitmoRN.iniciaConexaoBanco();
		
		retorno = varRitmoRN.iniciarVarRitmo(evento);
		
		varRitmoRN.finalizaConexaoBanco();
		return retorno;
	}
	
	public boolean informaMotivoVarRitmo(EventoColetado evento){
	    VarRitmoRN varRitmoRN = new VarRitmoRN();
	    boolean retorno = false;
	    varRitmoRN.iniciaConexaoBanco();
		
		retorno = varRitmoRN.informaMotivoVarRitmo(evento);
		
		varRitmoRN.finalizaConexaoBanco();
		return retorno;
	}
	
	public boolean finalizarVarRitmo(EventoColetado evento){
		VarRitmoRN varRitmoRN = new VarRitmoRN();
	    boolean retorno = false;
	    varRitmoRN.iniciaConexaoBanco();
		
		retorno = varRitmoRN.finalizarVarRitmo(evento);
		
		varRitmoRN.finalizaConexaoBanco();
		return retorno;
	}
	
	public void finalizaParada(EventoColetado evento) throws Exception{
		UpRN UpRN = new UpRN();
		if(UpRN.getDaoInjet() == null)
			UpRN.setDaoInjet(new DAOGenericoInjet());
		UpRN.iniciaConexaoBanco();
		
		
	    try {
			UpRN.finalParada(evento);
		} catch (Exception e) {
           throw e; 
		}finally{
			UpRN.finalizaConexaoBanco();	
		}
				
	    
				
	}
	public IwsParadaDTO validaParada(EventoColetado evento){
		UpRN UpRN = new UpRN();
		if (Stubdelegate.getInstancia().isInjetAtivo() == true){
		if(UpRN.getDaoInjet() == null)
			UpRN.setDaoInjet(new DAOGenericoInjet());
		}else{
			if(UpRN.getDaoPdba()== null)
				UpRN.setDaoPdba(new DAOGenerico());
		}
		
		UpRN.iniciaConexaoBanco();
		
		IwsParadaDTO parada = null;
		
		parada = UpRN.validaParada(evento); 
				
	    UpRN.finalizaConexaoBanco();
				
	    return parada;
	}	
	
	
	public boolean validaJustificativa(String idup, String cdjust){
		UpRN upRN = new UpRN();
		boolean retorno;
		if(upRN.getDaoInjet() == null)
			upRN.setDaoInjet(new DAOGenericoInjet());
		upRN.iniciaConexaoBanco();
		retorno = upRN.validaJustificativa(idup,cdjust);
		upRN.finalizaConexaoBanco();
		return retorno;	
	}
	
	public boolean validaCausa(String idup, String cdcausa){
		UpRN upRN = new UpRN();
		boolean retorno;
		if(upRN.getDaoInjet() == null)
			upRN.setDaoInjet(new DAOGenericoInjet());
		upRN.iniciaConexaoBanco();
	    retorno = upRN.validaCausa(idup,cdcausa);
		upRN.finalizaConexaoBanco();
		return retorno;
		
	}
	
	public boolean validaAcao(String idup, String cdacao){
		UpRN upRN = new UpRN();
		boolean retorno;
		if(upRN.getDaoInjet() == null)
			upRN.setDaoInjet(new DAOGenericoInjet());
		upRN.iniciaConexaoBanco();
	    retorno = upRN.validaAcao(idup,cdacao);
		upRN.finalizaConexaoBanco();
		return retorno;
		
	}
	
	
    
    
	public MsEvt inserirNovoRefugo(EventoColetado evento){
		UpRN upRN = new UpRN();
		if (Stubdelegate.getInstancia().isInjetAtivo() == true){
			if(upRN.getDaoInjet() == null)
				upRN.setDaoInjet(new DAOGenericoInjet());
		}else{
			if(upRN.getDaoPdba() == null)
				upRN.setDaoPdba(new DAOGenerico());
		}
		upRN.iniciaConexaoBanco();
		
		MsEvt msevt;
		
		try {
			msevt = upRN.inserirNovoRefugo(evento);
		} catch (ServicoFalhouException e) {
			e.printStackTrace();
			msevt = null;
		} finally {
			upRN.finalizaConexaoBanco();
		}
				
		return msevt;
			
		
	}
	
   public  IwsRefugoDTO verificaCausaAcaoRefugo(EventoColetado evento){
		
		UpRN upRN = new UpRN();
		if (Stubdelegate.getInstancia().isInjetAtivo() == true){
			if(upRN.getDaoInjet() == null)
				upRN.setDaoInjet(new DAOGenericoInjet());
		}else{
			if(upRN.getDaoPdba() == null)
				upRN.setDaoPdba(new DAOGenerico());
		}
		upRN.iniciaConexaoBanco();
		
		IwsRefugoDTO refugo = null;
		
		refugo = upRN.verificaCausaAcaoRefugo(evento); 
			
		upRN.finalizaConexaoBanco();
				
		return refugo;	 
				
		
	}
	
	public boolean apagaUltimoRefugo(EventoColetado evento){
		boolean retorno;
		UpRN upRN = new UpRN();
		if (Stubdelegate.getInstancia().isInjetAtivo() == true){
			if(upRN.getDaoInjet() == null)
				upRN.setDaoInjet(new DAOGenericoInjet());
		}else{
			if(upRN.getDaoPdba() == null)
				upRN.setDaoPdba(new DAOGenerico());
		}
		upRN.iniciaConexaoBanco();
		retorno = upRN.apagaUltimoRefugo(evento);
		upRN.finalizaConexaoBanco();
		return retorno;
	}
	
	
	public boolean isUsuarioOperadorAutenticado(String idup,String login, String senha){
		UsuarioMSRN usuarioRN = new UsuarioMSRN();
		
		UpRN u = new UpRN();
		if(u.getDaoInjet() == null)
			u.setDaoInjet(new DAOGenericoInjet());
		try {
			u.iniciaConexaoBanco();
			MsUp msUp = u.pesquisarMsUpPorCdUpStAtivo(idup);
			u.finalizaConexaoBanco();
			if (msUp!= null){
				
				return usuarioRN.isUsuarioOperadorAutenticado(msUp.getIduppdba().toString(),login,senha);
			     
			}else{
				return false;	
			}
			
		} catch (RegistroDesconhecidoException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public MsDTO removeRegistraIhmNoMs(IhmDTO ihmdto, MsDTO msdto){		
		MsRN msRN = new MsRN();
		try {			
			msRN.iniciaConexaoBanco();
			msRN.setMsDTO(msdto);
			msRN.removerRegistroIHM(ihmdto);
		} catch (Exception e){
			e.printStackTrace();
			getLog().info(e);
		} finally {
			try{
				msRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				msRN.finalizaConexaoBanco();
			}
		}
		return msRN.getMsdDTO();
	}
	public MsDTO heartbeat(MsDTO msdto) {		
		MsDTO retorno = null;
		MsRN msRN = new MsRN();
		try {			
			msRN.iniciaConexaoBanco();
			msRN.setMsDTO(msdto);
			retorno = msRN.heartBeat();
		}catch (MsDesconhecidoException e) {
			getLog().info("MS nao cadastrado: "+ msdto.getUrlConexao());
		}catch (Exception e){
			e.printStackTrace();
			getLog().info(e);
			msRN.rollBackTransacao();
		} finally {
			try{
				msRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				msRN.finalizaConexaoBanco();
			}
		}
		return retorno;
	}
	public MsEvt inicioParada(Session sessao, EventoColetado evento){
		UpRN upRN = new UpRN();
		MsEvt msevt = null;
		try {
			upRN.iniciaConexaoBanco(sessao);
			
			msevt = upRN.inicioParada(evento);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (Stubdelegate.getInstancia().isInjetAtivo() == false) {
				evento.getLog().iniciaAvaliacao("finalizaConexaoBanco");
				upRN.finalizaConexaoBanco(evento.getLog());
				evento.getLog().paraAvaliacao();
				evento.getLog().info(evento.getLog().getAvaliacaoCompleta());
			}
		}
		return msevt;
	}
	public void finalParada(EventoColetado evento) {
		UpRN upRN = new UpRN();
		try {
			upRN.iniciaConexaoBanco();
			//upRN.setUpDTO(evento.getIcUpDTO().getUp());
			upRN.finalParada(evento);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (evento.getLog() !=null){
				evento.getLog().iniciaAvaliacao("finalizaConexaoBanco");
				upRN.finalizaConexaoBanco();
				evento.getLog().paraAvaliacao();
				evento.getLog().info(evento.getLog().getAvaliacaoCompleta());	
			}
			
		}
	}
	public UsuarioMSDTO isUsuarioAutenticado(UsuarioMSDTO usuarioDTO){
		UsuarioMSDTO retorno = new UsuarioMSDTO();
		UsuarioMSRN rn = new UsuarioMSRN();
		rn.iniciaConexaoBanco(null);
		rn.setUsuarioDTO(usuarioDTO);
		try {
			retorno = rn.isUsuarioAutenticado();
			
		} catch (UsuarioDesconhecidoException e){
			retorno.setResultadoEvento(rn.getERRO_LOGIN_INVALIDO());
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	public ListaIcDTO getListaIcDTO(IcDTO icDTO) {
		ListaIcDTO resultado = null;
		IcRN rn = new IcRN();		
		try {
			rn.iniciaConexaoBanco(null);
			rn.setIcDTO(icDTO);
			resultado = rn.getListaIcDTO();
		} catch(IcDesconhecidoException e) {
		} finally {
			rn.finalizaConexaoBanco();
		}
		return resultado;
	}
	
	public ListaIcDTO metMsIcsStandalone() {
		IcRN rn = new IcRN();
		ListaIcDTO retorno = new ListaIcDTO();
		try {
			rn.iniciaConexaoBanco(null);
			retorno = rn.getMsIcsPorTp();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return retorno;
	}
	
	public ListaIcDTO salvarIcDTO(IcDTO icDTO) {
		IcRN rn = new IcRN();
		ListaIcDTO resultado = null;
		
		rn.iniciaConexaoBanco(null);
		rn.setIcDTO(icDTO);
		
		try {
			resultado = rn.salvarIcDTO();
			if (resultado.getResultadoDTO().getIdMensagem() != resultado.getResultadoDTO().COM_SUCESSO)
				rn.getDao().rollBackTransacao();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	public ListaIcDTO removeIcDTO(IcDTO icDTO) {
		IcRN rn = new IcRN();
		ListaIcDTO resultado = null;
		
		try {
			rn.iniciaConexaoBanco(null);
			rn.setIcDTO(icDTO);
			resultado = rn.removeIcDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	
	public ListaIhmDTO getListaIhmDTO(IhmDTO ihmDTO) {
		IhmRN rn = new IhmRN();
		ListaIhmDTO resultado = null;
		
		rn.iniciaConexaoBanco();
		rn.setIhmDTO(ihmDTO);
		
		try {
			resultado = rn.getListaIhmDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	public ListaIhmDTO setihmDTO(IhmDTO ihmDTO) {
		IhmRN rn = new IhmRN();
		ListaIhmDTO resultado = null;
		
		rn.iniciaConexaoBanco();
		rn.setIhmDTO(ihmDTO);
		
		try {
			resultado = rn.salvarIhmDTO();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	public ListaIhmDTO removeIhmDTO(IhmDTO ihmDTO) {
		IhmRN rn = new IhmRN();
		ListaIhmDTO resultado = null;
		
		rn.iniciaConexaoBanco();
		rn.setIhmDTO(ihmDTO);
		
		try {
			resultado = rn.removeIhmDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	
	public ListaMSDTO getListaMSDTO(MsDTO msdto) {
		
		ListaMSDTO resultado = null;				
		MsRN msRN = new MsRN();
		try {			
			msRN.iniciaConexaoBanco();
			msRN.setMsDTO(msdto);
			resultado = msRN.getListaMSDTO();
		} catch (Exception e){
			e.printStackTrace();
			getLog().info(e);
		} finally {
			try{
				msRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				msRN.finalizaConexaoBanco();
			}
			msRN = null;
		}		
		return resultado;
	}
	public ListaMSDTO setMSDTO(MsDTO msdto) {		
		ListaMSDTO resultado = null;
		MsRN msRN = new MsRN();
		try {			
			msRN.iniciaConexaoBanco();
			msRN.setMsDTO(msdto);
			resultado = msRN.setMSDTO();
			if (resultado.getResultadoDTO().getIdMensagem() != resultado.getResultadoDTO().COM_SUCESSO)
				msRN.rollBackTransacao();
		} catch (Exception e){
			e.printStackTrace();
			getLog().info(e);
		} finally {
			try{
				msRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				msRN.finalizaConexaoBanco();
			}
			msRN = null;
		}		
		return resultado;
	}
	public ListaMSDTO removeMSDTO(MsDTO msdto) {
		ListaMSDTO resultado = null;
		MsRN msRN = new MsRN();
		try {			
			msRN.iniciaConexaoBanco();
			msRN.setMsDTO(msdto);
			resultado = msRN.removeMSDTO();
		} catch (Exception e){
			e.printStackTrace();
			getLog().info(e);
		} finally {
			try{
				msRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				msRN.finalizaConexaoBanco();
			}
			msRN = null;
		}		
		return resultado;
	}
	public ListaUPDTO getTodosUPDTO() {
		UpRN rn = new UpRN();
		ListaUPDTO resultado = null;
		
		rn.iniciaConexaoBanco();
		
		try {
			resultado = rn.getTodosUPDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	public ListaIcDTO getTodosIcDTO() {
		IcRN rn = new IcRN();
		ListaIcDTO resultado = null;
		
		rn.iniciaConexaoBanco(null);
		
		try {
			resultado = rn.getTodosIcDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	public IcDTO pesquisarMsIcPorUrlConexao(String urlconexao) {
		IcRN rn = new IcRN();
		IcDTO resultado = null;
		
		
		try {
			rn.iniciaConexaoBanco(null);

			resultado = rn.pesquisarMsIcPorUrlConexao(urlconexao);
			
			if (resultado == null)
				return new IcDTO(); // Isso gera um erro na coleta fuji que ja era tratado
			
			// Alessandre: o trecho abaixo nao era pra estar no facade,
			// mas o qdo o insert chama esse metodo da um loop infinito no webservice
			for (IcUpDTO icupdto : resultado.getMsIcUpDTOLocais()) {
				icupdto.setIc(null);
			}
		} catch (Exception e) {
			resultado = new IcDTO();
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	public ListaIhmDTO getTodosIhmDTO() {
		IhmRN rn = new IhmRN();
		ListaIhmDTO resultado = null;
		
		rn.iniciaConexaoBanco();
		
		try {
			resultado = rn.getTodosIhmDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return resultado;
	}
	public ListaUPDTO getListaupDTO(UpDTO upDTO) {
		ListaUPDTO retorno = null;
		UpRN rn = new UpRN();
		
		rn.iniciaConexaoBanco();
		rn.setUpDTO(upDTO);
		
		try {
			retorno = rn.getListaUpDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}		
		return retorno;
	}
	public ListaUPDTO salvarUpDTO(UpDTO upDTO) {
		ListaUPDTO retorno = null;
		UpRN rn = new UpRN();
		
		rn.iniciaConexaoBanco();
		rn.setUpDTO(upDTO);
		
		try {
			retorno = rn.salvarUpDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	public ListaUPDTO removeUpDTO(UpDTO upDTO) {
		ListaUPDTO retorno = null;
		UpRN rn = new UpRN();
		
		rn.iniciaConexaoBanco();
		rn.setUpDTO(upDTO);
		
		try {
			retorno = rn.removeUpDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	public ListaUPDTO removeUpsDTO(ListaUPDTO lista) {
		ListaUPDTO retorno = null;
		UpRN rn = new UpRN();
		
		rn.iniciaConexaoBanco();
		try {
			retorno = rn.removeUpsDTO(lista);
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	public ListaUPDTO getTodosPrUp() {
		ListaUPDTO retorno = null;
		UpRN rn = new UpRN();
		
		rn.iniciaConexaoBanco();
		
		try {
			retorno = rn.getTodosPrUp();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	public ListaEvtDTO pesquisarListaEvtDTO(String cdUp, Integer qtLinhas) {
		ListaEvtDTO retorno = null;
		EventoRN rn = new EventoRN();
		
		rn.iniciaConexaoBanco();
		
		try {
			retorno = rn.pesquisarListaEvtDTO(cdUp, qtLinhas);
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	
	public boolean salvarConfiguracaoLog4j(Log4jDTO logDTO){
		Log4jRN logRN = new Log4jRN();
		return logRN.salvar(logDTO);
	}
	
	public Log4jDTO getPropriedadesLog4j(){
		Log4jRN logRN = new Log4jRN();
		return logRN.carregarPropriedades();
	}
	
	
	public boolean configuraWebXml(WebXMLDTO webDTO){
		WebXMLRN webRN = new WebXMLRN();
		return webRN.configuraWebXML(webDTO);
		
	}
	
	public WebXMLDTO getPropriedadesWebXml(){
		WebXMLRN webRN = new WebXMLRN();
		return  webRN.getPropriedadesWebXml();
	}
	
	public String pesquisarLog(BigDecimal idEvento, BigDecimal tpEvento){
		EventoRN rn = new EventoRN();
		rn.iniciaConexaoBanco();
		String retorno = rn.pesquisarLog(idEvento, tpEvento);
		rn.finalizaConexaoBanco();
		return retorno;
	}
	
	
	//tipoHibernate = 0 -> hibernate.cfg.xml | = 1 -> hibernateinjet.cfg.xml
	public boolean salvarConfiguracoesHibernate(ConfiguraHibernateDTO configuraHibernateDTO, int tipoHibernate){
		IdwLogger log = new IdwLogger("Configuraçãoo Hibernate");
		log.iniciaAvaliacao("SALVAR CONFIGURAÃ‡ÃƒO HIBERNATE");
		
		ConfiguraHibernateRN cfgHibernateRN = new ConfiguraHibernateRN();
		try {
			
			log.info("caminho Relativo :" + getCaminhoRelativo());
			   
            if (tipoHibernate == 0){
            	configuraHibernateDTO.setCaminhoArquivo(getCaminhoRelativo() + "\\WEB-INF\\classes\\hibernate.cfg.xml");
            }else{
            	configuraHibernateDTO.setCaminhoArquivo(getCaminhoRelativo() + "\\WEB-INF\\classes\\hibernateinjet.cfg.xml");
            }
			cfgHibernateRN.configuraHibernate(configuraHibernateDTO);
			return true;
		} catch (FuncionalidadeIndisponivelException e) {
			
			return false;
		}finally{
			log.paraAvaliacao();
			log.info("FIM SALVAR CONFIGURAÃ‡ÃƒO HIBERNATE  :" + log.getAvaliacaoCompleta());
		}
		
	}
	
	public ConfiguraHibernateDTO pesquisaConfiguracaoHibernate(int tipoHibernate){
		IdwLogger log = new IdwLogger("Configuraçãoo Hibernate");
		log.iniciaAvaliacao("RECUPERAR CONFIGURAÃ‡ÃƒO HIBERNATE");
	        
		ConfiguraHibernateRN cfgHibernateRN = new ConfiguraHibernateRN();
		ConfiguraHibernateDTO retorno = null;
		
		if (tipoHibernate == 0){
			retorno = cfgHibernateRN.recuperaConfiguracaoHibernate(getCaminhoRelativo() + "\\WEB-INF\\classes\\hibernate.cfg.xml");
        }else{
        	retorno = cfgHibernateRN.recuperaConfiguracaoHibernate(getCaminhoRelativo() + "\\WEB-INF\\classes\\hibernateinjet.cfg.xml");
        }
		log.paraAvaliacao();
		log.info("FIM RECUPERAÃ‡ÃƒO CONFIGURAÃ‡ÃƒO HIBERNATE  :" + log.getAvaliacaoCompleta()   );
		
		return retorno;
	}
	
	
	
	public ListaBcDTO pesquisarListaBcs(BcDTO bcdto) {
		ListaBcDTO retorno = null;
		BcRN rn = new BcRN();
		
		rn.iniciaConexaoBanco(null);
		
		try {
			retorno = rn.pesquisarListaBcDTO();
		} catch (RegistroDesconhecidoException e){
			retorno = new ListaBcDTO();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}

	public ListaMSDTO importacaoManual(Long idMs, String login) {
		ImportacaoManual rn = new ImportacaoManual();
		ListaMSDTO retorno = null;
		
		rn.iniciaConexaoBanco();
		
		try {
			retorno = rn.importar(idMs, login);
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	public void setCaminhoRelativo(String caminhoRelativo) {
		this.caminhoRelativo = caminhoRelativo;
	}

	public String getCaminhoRelativo() {
		return caminhoRelativo;
	}
	
	public void icHeartBeat(int idLog, String urlIC, EventoColetado evento) throws ServicoFalhouException{
		UpRN upRN = new UpRN();
		try {
			upRN.iniciaConexaoBanco();

			// TODO: Adotar uma implementacao mais eficiente.
			if (evento.getLog() == null)
				evento.setLog(new IdwLogger("IcHeartBeat-" + urlIC));
			
			idLog = evento.getLog().getIdAleatorio();
			
			upRN.icHeartBeat(idLog, urlIC, evento);
		} catch (Exception e){
			e.printStackTrace();
			evento.getLog().info("Ocorreu excessao abaixo", e);
		} finally {
			evento.getLog().iniciaAvaliacao("finalizaConexaoBanco");
			upRN.finalizaConexaoBanco();
			evento.getLog().paraAvaliacao();
			evento.getLog().info(idLog, 18, evento.getLog().getAvaliacaoCompleta());
		}
	}
	

	public void trataEventos(int idLog, IcDTO msIcDTO) throws ServicoFalhouException{
		UpRN pdbaupRN = new UpRN();
		try {
			pdbaupRN.iniciaConexaoBanco();
			pdbaupRN.trataEventos(idLog, msIcDTO);
		} catch (Exception e){
			e.printStackTrace();
			log.info("Ocorreu excessao abaixo", e);
		} finally {
			pdbaupRN.finalizaConexaoBanco();
			
		}
	}
	public Log getLog() {
		return log;
	}	
	
	public IcDTO salvarIcSimplificado(IcDTO icDTO,IcDTO icDTOParaRemocao){
		IcRN rn = new IcRN();
		IcDTO retorno = null;
		try{
			rn.iniciaConexaoBanco(null);
			retorno =  rn.salvarIcSimplificado(icDTO,icDTOParaRemocao);
		}catch(Exception e){
			rn.getDao().rollBackTransacao();
			e.printStackTrace();
		}finally{
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	
	public boolean validaSeUpEstaSendoUsada(String cdUp, BigDecimal idic) {
		UpRN rn = new UpRN();
		boolean retorno = false;
		try{
			rn.iniciaConexaoBanco();
			retorno =  rn.validaSeUpEstaSendoUsada(cdUp,idic) ;
		}catch(Exception e){
			rn.getDaoPdba().rollBackTransacao();
			e.printStackTrace();
		}finally{
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
		
	}
	
	public ListaBcDTO getListBcDTO(){
		BcRN bcRn = new BcRN();
		ListaBcDTO retorno = null;
		try{
			retorno = bcRn.pesquisarListaBcDTO();
			return retorno;
		}catch(Exception e){
			e.getMessage();
		}finally{
			bcRn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	
	public ListaIcDTO getListaMsIC(){
		 IcRN rn = new IcRN();
		 rn.iniciaConexaoBanco(null);
		 ListaIcDTO retorno = new ListaIcDTO();
		 retorno = rn.getListaMsIC();
		 rn.finalizaConexaoBanco();
		 return retorno;	
	}	
	
	public ListaUPDTO getListaMsUP(){
		 UpRN rn = new UpRN();
		 rn.iniciaConexaoBanco();
		 ListaUPDTO retorno = new ListaUPDTO();
		 retorno = rn.getListaMsUP();
		 rn.finalizaConexaoBanco();
		 return retorno;	
	}	
	
	public MsicupsDTO getListaMsicup(){
		 IcRN rn = new IcRN();
		 rn.iniciaConexaoBanco(null);
		 MsicupsDTO retorno = new MsicupsDTO();
		 retorno = rn.getListaMsicup();
		 rn.finalizaConexaoBanco();
		 return retorno;	
	}	
	
	public MsMs pesquisarMsMsPorURLConexaoComParametro(String UrlConexao){
		 MsRN rn = new MsRN();
		 rn.iniciaConexaoBanco();
		 MsMs retorno = new MsMs();
		 retorno = rn.pesquisarMsMsPorURLConexaoComParametro(UrlConexao);
		 rn.finalizaConexaoBanco();
		 return retorno;	
	}	

	public List<MsUp> pesquisarListaMsUpPorURLConexaoIc(String urlConexao){
		 UpRN rn = new UpRN();
		 rn.iniciaConexaoBanco();
		 List<MsUp> retorno = null;
		 retorno = rn.pesquisarListaMsUpPorUrlConexaoIC(urlConexao);
		 rn.finalizaConexaoBanco();
		 return retorno;	
	}	

	
	public String obtemFileToUpload(String UrlConexaoIC){
		IcRN rn = new IcRN();
		rn.setUrl_conexao(UrlConexaoIC);
		rn.setTp_ic(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue());
		try{
			rn.iniciaConexaoBanco(null);
			return rn.obtemFirmwareToIC();
		}catch(Exception e){
			log.info("obtemFileToUpload("+UrlConexaoIC+")"+" Erro ao Obter Firmware");
		}finally{
			rn.finalizaConexaoBanco();
		}
		
		return null;
	}
	
	public boolean isICCadastrado(String UrlConexaoIC) {		
		IcRN rn = new IcRN();
		rn.setUrl_conexao(UrlConexaoIC);
		rn.setTp_ic(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue());
		
		try{
			rn.iniciaConexaoBanco(null);
			rn.isICCadastrado();
		}catch(IcDesconhecidoException exc){
			return false;
		}catch(Exception e){
			log.info("isICCadastrado("+UrlConexaoIC+")"+" Erro ao Verificar cadastro IC");
		}finally{
			rn.finalizaConexaoBanco();
		}
		return true;
	}
	
	public boolean existeUPParaIC(String UrlConexaoIC) {
		IcRN rn = new IcRN();
		rn.setUrl_conexao(UrlConexaoIC);
		rn.setTp_ic(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue());
		
		try{
			rn.iniciaConexaoBanco(null);
			rn.existeUPParaIC();
		}catch(IcDesconhecidoException exc){
			return false;
		}catch(Exception e){
			log.info("isICCadastrado("+UrlConexaoIC+")"+" Erro ao Verificar cadastro IC");
		}finally{
			rn.finalizaConexaoBanco();
		}
		return true;
	}
	
	public FirmwaresDTO getFirmwares(){
		IcRN rn = new IcRN();
		rn.iniciaConexaoBanco(null);
		FirmwaresDTO retorno = rn.listaFirmwares();
		rn.finalizaConexaoBanco();
		return retorno;
	}

	public String isOperador(String cracha){
		OperadorRN rn = new OperadorRN();
		
		rn.iniciaConexaoBanco();
		String isRetorno = rn.isOperador(cracha);
		rn.finalizaConexaoBanco();
		
		return isRetorno;
	}
	
	public ParadaColetaComAndonDTO getMaiorParadaColetaComAndon(String idUP, Date dtHr1, Date dtHr2){
		ParadaColetaComAndonRN rn = new ParadaColetaComAndonRN();
		rn.iniciaConexaoBanco();
		ParadaColetaComAndonDTO retorno = rn.getMaiorParadaColetaComAndon(idUP, dtHr1, dtHr2);
		rn.finalizaConexaoBanco();
		return retorno;
	}
	
	public ParadasColetaComAndonDTO getMaioresParadasColetaComAndon(String cdMaquina, Date dtHrAtual){
		
		ParadasColetaComAndonDTO retorno = new ParadasColetaComAndonDTO();
		ParadaColetaComAndonRN rn = new ParadaColetaComAndonRN();
		rn.iniciaConexaoBanco();
		
		try
		{
			retorno = rn.getMaioresParadasColetaComAndon(cdMaquina, dtHrAtual);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		rn.finalizaConexaoBanco();
		
		return retorno;
	
	}
	
	public IndicadoresColetaGraficoInjetDTO getGraficoOEEHoraHora(String cdMaquina, Date dthrAtual)
	{
		IndicadoresColetaGraficoInjetDTO retorno = new IndicadoresColetaGraficoInjetDTO();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaGraficoRN rn =  new ColetaGraficoRN(daoInjet);

		rn.iniciaConexaoBanco();
		
		try 
		{
			retorno = rn.getGraficoOEEHoraHora(cdMaquina, dthrAtual);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rn.finalizaConexaoBanco();
		
		return retorno;	
	}		
	public void validaErro(EventoColetado evento){
		UpRN upRN = new UpRN();
		try {
			upRN.iniciaConexaoBanco();
			//upRN.setUpDTO(evento.getIcUpDTO().getUp());
		//	upRN.insereErroInsersora(evento);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			evento.getLog().iniciaAvaliacao("finalizaConexaoBanco");
			upRN.finalizaConexaoBanco();
			evento.getLog().paraAvaliacao();
			evento.getLog().info(evento.getLog().getAvaliacaoCompleta());
		}
	}
	
	public boolean executaManutencaoMsEvt(IdwLogger olog,Date dthrrefExclusao,int numeroRegistros) {		
		EventoRN eventoRN = new EventoRN();
		boolean retorno = false;
		try {		
			olog.info("Iniciando MsFacade.executaManutencaoMsEvt");
			eventoRN.iniciaConexaoBanco();				
			retorno=eventoRN.pesquisaDeletaUltimosMsEvtByDtHr(olog, dthrrefExclusao, numeroRegistros);
			olog.info("Excluindo eventos anteriores a "+dthrrefExclusao);
			olog.info("Finalizando MsFacade.executaManutencaoMsEvt");
			
		}catch (Exception e){
			olog.info("Erro em  MsFacade.executaManutencaoMsEvt");
			e.printStackTrace();
			
			olog.info(e);
		} finally {
			try{
				eventoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				eventoRN.finalizaConexaoBanco();
			}
		}
		return retorno;
	}
	
	public TAndonSADTO getAndonsSA(Long idPa){
		IcRN rn = new IcRN();
		TAndonSADTO itemRetorno=new TAndonSADTO();
		try {
			rn.iniciaConexaoBanco(null);
			itemRetorno = rn.getAndonsSA(idPa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rn.finalizaConexaoBanco();
		}
		rn = null;
		return itemRetorno;
	}
	
	public IcUpDTO pesquisarIcUpDtoPorIdUpPdba(String idUpPdba){
		UpRN upRN = new UpRN();
		IcUpDTO icupdto=null;
		try {
			upRN.iniciaConexaoBanco();
			icupdto=upRN.pesquisarIcUpDtoPorIdUpPdba(idUpPdba);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			upRN.finalizaConexaoBanco();
		}
		return icupdto;
	}	
	
	public OPAutomaticaDTO criaOPAutomatica(EventoColetado evt) {
		CpRN crn = new CpRN();
		OPAutomaticaDTO retorno = null;
		try {
			crn.iniciaConexaoBanco();
			retorno = crn.criarOPAutomatica(evt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			crn.finalizaConexaoBanco();
		}
		return retorno;
		
	}
	
	public ConsultaInovaSADTO consultaGenericaINOVASA(EventoColetado evt){
		UpRN upRN = new UpRN();
		ConsultaInovaSADTO retorno = null;
		try {
			upRN.iniciaConexaoBanco();
			retorno=upRN.consultaGenericaINOVASA(evt);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			upRN.finalizaConexaoBanco();
		}
		return retorno;
	}

	public idw.webservices.dto.UsuarioDTO isOperadorAutenticado(String login, String senha) {
		UsuarioMSRN rn = new UsuarioMSRN();
		idw.webservices.dto.UsuarioDTO retorno;
		try {
			rn.iniciaConexaoBanco(null);
			retorno = rn.isOperadorAutenticado(login, senha);
		} catch (Exception e) {
			retorno = new UsuarioDTO();
			retorno.setResultadoEvento(1);
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public idw.webservices.dto.UsuarioDTO isSupervisorCancelaEtiqueta(String login, String senha) {
		UsuarioMSRN rn = new UsuarioMSRN();
		idw.webservices.dto.UsuarioDTO retorno;
		try {
			rn.iniciaConexaoBanco(null);
			retorno = rn.isSupervisorCancelaEtiqueta(login, senha);
		} catch (Exception e) {
			retorno = new UsuarioDTO();
			retorno.setResultadoEvento(1);
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	public idw.webservices.dto.UsuarioDTO isTecnicoTrocaOP(String login, String senha) {
		UsuarioMSRN rn = new UsuarioMSRN();
		idw.webservices.dto.UsuarioDTO retorno;
		try {
			rn.iniciaConexaoBanco(null);
			retorno = rn.isTecnicoTrocaOP(login, senha);
		} catch (Exception e) {
			retorno = new UsuarioDTO();
			retorno.setResultadoEvento(1);
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}
	
	public MsEvt pesquisarMsEvtUltimoEventoLancado(String cdUp){
		EventoRN rn = new EventoRN();
		MsEvt msevt = null;
		try {
			rn.iniciaConexaoBanco(null);
			msevt = rn.pesquisarMsEvtUltimoEventoLancado(cdUp);
			if (msevt == null)
				log.error("pesquisarMsEvtUltimoEventoLancado: msevt null");
		} catch (Exception e){
			log.error("pesquisarMsEvtUltimoEventoLancado: erro ao obter msevt: " + e.toString());
		} finally {
			rn.finalizaConexaoBanco();
		}
		return msevt;
	}
	
	public MsEvt pesquisarMsEvtUltimoEventoLancadoComOrigem(String cdUp){
		EventoRN rn = new EventoRN();
		MsEvt msevt = null;
		try {
			rn.iniciaConexaoBanco(null);
			msevt = rn.pesquisarMsEvtUltimoEventoLancadoComOrigem(cdUp);
			if (msevt == null)
				log.error("pesquisarMsEvtUltimoEventoLancado: msevt null");
		} catch (Exception e){
			log.error("pesquisarMsEvtUltimoEventoLancado: erro ao obter msevt: " + e.toString());
		} finally {
			rn.finalizaConexaoBanco();
		}
		return msevt;
	}
	
	public MsEvt pesquisarMsEvtUltimoEventoLancado(String cdOp, String cdUp){
		EventoRN rn = new EventoRN();
		MsEvt msevt = null;
		try {
			rn.iniciaConexaoBanco(null);
			msevt = rn.pesquisarMsEvtUltimoEventoLancado(cdOp, cdUp);
			if (msevt == null)
				log.error("pesquisarMsEvtUltimoEventoLancado: msevt null");
		} catch (Exception e){
			log.error("pesquisarMsEvtUltimoEventoLancado: erro ao obter msevt: " + e.toString());
		} finally {
			rn.finalizaConexaoBanco();
		}
		return msevt;
	}

	public List<Object> pesquisarUps(String mac) {
		MsRN rn = new MsRN();
		List<Object> retorno;
		try {
			rn.iniciaConexaoBanco();
			retorno = rn.pesquisarUps(mac);
		} catch (Exception e) {
			retorno = new ArrayList<Object>();
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	public List<Long> mapConsumirPesquisarIdsPendentes(String cdUp, int qtRegistros) {
		MsRN rn = new MsRN();
		List<Long> retorno;
		try {
			rn.iniciaConexaoBanco();
			
			MsEvtDAO msEvtDAO = new MsEvtDAO(rn.getSession());
			retorno = msEvtDAO.getIdsEventosPendentesProcessamento(cdUp, qtRegistros);

			
		} catch (Exception e) {
			retorno = new ArrayList<Long>();
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	public MsEvt mapConsumirPesquisarEvento(Long idEvt) {
		MsRN rn = new MsRN();
		MsEvt retorno;
		try {
			rn.iniciaConexaoBanco();
			
			MsEvtDAO msEvtDAO = new MsEvtDAO(rn.getSession());
			retorno = msEvtDAO.getMsEvt(idEvt).clone(true);

			
		} catch (Exception e) {
			retorno = new MsEvt();
			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}

	
	public void mapConsumirFinalizarEvento(Long idEvt, int stEvt, Date dtHrIProcessamento, Date dtHrFimProcessamento, String erroConsol) {
		MsRN rn = new MsRN();
		try {
			rn.iniciaConexaoBanco();
			
			MsEvtDAO msEvtDAO = new MsEvtDAO(rn.getSession());
			msEvtDAO.setStEvt(idEvt, stEvt, dtHrIProcessamento, erroConsol);

			
		} catch (Exception e) {			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

}

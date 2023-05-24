package ms.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery; 
import idw.model.pojos.MsIhm;
import idw.model.pojos.MsUp;
import idw.model.pojos.MsUpihm;
import idw.model.pojos.MsUsr;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ResumoRetornoRegistrosRN;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO; 
import idw.webservices.rest.idw.v2.dto.IhmDTO2;
import idw.webservices.rest.idw.v2.dto.ListaIHMsDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO; 
import idw.webservices.rest.idw.v2.dto.UpIhmDTO2;
import injetws.model.excessoes.RegistroDesconhecidoException;
import ms.excessao.IhmDesconhecidoException;
import ms.model.dto.IhmDTO;
import ms.model.dto.ListaIhmDTO;
import ms.model.dto.ResultadoMSDTO;
import ms.model.dto.UpIhmDTO;

public class IhmRN extends IhmDTO implements IDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1295554322503440122L;
	
	private transient DAOGenerico dao = null;

	public IhmRN(){
		if (dao == null)
			dao = new DAOGenerico();
	}
	public IhmRN(DAOGenerico dao){
		this.dao = dao;
	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		dao.iniciaSessao();
	}
	@Override
	public void finalizaConexaoBanco() {
		dao.finalizaSessao();
	}

	public void setIhmDTO(IhmDTO ihmDTO){
		this.setCdIhm(ihmDTO.getCdIhm());
		this.setConexaoIHM(ihmDTO.getConexaoIHM());
		this.setEventosPendentes(ihmDTO.getEventosPendentes());
		this.setIdIhm(ihmDTO.getIdIhm());
		this.setTipoRequisicaoIHM(ihmDTO.getTipoRequisicaoIHM());
		this.setTipoRequisicaoWS(ihmDTO.getTipoRequisicaoWS());
		this.setTratamentoSinais(ihmDTO.getTratamentoSinais());
		this.setWsDTO(ihmDTO.getWsDTO());
		
		this.setUrl_Conexao(ihmDTO.getUrl_Conexao());
		this.setUrl_ConexaoAlternativo(ihmDTO.getUrl_ConexaoAlternativo());
		this.setUrl_Ip(ihmDTO.getUrl_Ip());
		this.setIsUpRegistrado(ihmDTO.getIsUpRegistrado());
		this.setIsTodosEvt(ihmDTO.getIsTodosEvt());
		this.setIsEvtPendente(ihmDTO.getIsEvtPendente());
		this.setIsEvtCicloFechado(ihmDTO.getIsEvtCicloFechado());
		this.setIsEvtTrabalhando(ihmDTO.getIsEvtTrabalhando());
		this.setIsEvtParada(ihmDTO.getIsEvtParada());
		this.setIsEvtRefugo(ihmDTO.getIsEvtRefugo());
		this.setIsEvtAlerta(ihmDTO.getIsEvtAlerta());
		this.setIsEvtLogin(ihmDTO.getIsEvtLogin());
		this.setLoginUsuario(ihmDTO.getLoginUsuario());
		this.setDthrCadastro(ihmDTO.getDthrCadastro());
		
		this.setUps(ihmDTO.getUps());
	}
	public DAOGenerico getDao() {
		return dao;
	}
	public void setDao(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public MsIhm pesquisarIP()throws IhmDesconhecidoException{
        MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select msihm from MsIhm msihm");
		q.append("where msihm.urlIp = :urlIP ");
		q.defineParametro("urlIP", this.getUrl_Ip().toUpperCase());
		q.setMaxResults(1);
		
		MsIhm exemplo = null;

		exemplo = (MsIhm) q.uniqueResult();
		if (exemplo == null){
			throw new IhmDesconhecidoException();
	    }
	    return exemplo;
	}
	
	public MsIhm pesquisarPorURLConexaoAndURLConexaoALt() throws IhmDesconhecidoException{
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select msihm from MsIhm msihm");
		q.append("where msihm.urlConexao = :urlConexao ");
		q.defineParametro("urlConexao", this.getUrl_Conexao().toUpperCase());
		q.setMaxResults(1);
		
		MsIhm exemplo = null;

		exemplo = (MsIhm) q.uniqueResult();
		
		if (exemplo == null){
			q.novaConsulta();
			
			q.append("select msihm from MsIhm msihm");
			q.append("where msihm.urlConexaoalt = :urlConexao ");
			q.defineParametro("urlConexao", this.getUrl_Conexao().toUpperCase());
			q.setMaxResults(1);
			
			exemplo = (MsIhm) q.uniqueResult();
			
			if(exemplo == null)
				throw new IhmDesconhecidoException();
		}

		return exemplo;
	}
	
	public MsIhm pesquisarMsIhmPorURLConexao() throws IhmDesconhecidoException{
		MapQuery q = new MapQuery(dao.getSession());
		
		// Alessandre 26-6-14 acrescentei o left no hql abaixo pois na hora do registro o ihm nao eh encontrado logo msupihms nao eh incluido
		q.append("select distinct msihm from MsIhm msihm");
		q.append("left join fetch msihm.msUpihms msupihm ");
		q.append("left join fetch msupihm.msUp msup");
		q.append("where msihm.urlConexao like :urlConexao ");
		q.append("and (msup.stAtivo = 1 or msup is null) ");
		q.defineParametro("urlConexao", "%" + this.getUrl_Conexao().toUpperCase() + "%");
		q.setMaxResults(1);
		
		MsIhm exemplo = null;

		exemplo = (MsIhm) q.uniqueResult();
		
		if (exemplo == null){
			q.novaConsulta();
			
			// Alessandre 26-6-14 acrescentei o left no hql abaixo pois na hora do registro o ihm nao eh encontrado logo msupihms nao eh incluido
			q.append("select distinct msihm from MsIhm msihm");
			q.append("left join fetch msihm.msUpihms msupihm ");
			q.append("left join fetch msupihm.msUp msup");
			q.append("where msihm.urlConexaoalt like :urlConexao ");
			q.append("and (msup.stAtivo = 1 or msup is null) ");

			q.defineParametro("urlConexao", "%" + this.getUrl_Conexao().toUpperCase() + "%");
			q.setMaxResults(1);
			
			exemplo = (MsIhm) q.uniqueResult();
			
			if (exemplo == null)
				throw new IhmDesconhecidoException();
		}

		return exemplo;
	}
	public ListaIhmDTO getListaIhmDTO() throws IhmDesconhecidoException {
		List<MsIhm> lista = null;
		ArrayList<IhmDTO> listaihmdto = new ArrayList<IhmDTO>();
		ListaIhmDTO listaIhmDTO = new ListaIhmDTO();
		IhmDTO ihmDTO = null;
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		
		lista = pesquisarMsIhm();
		if(lista.isEmpty()) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_LISTA_VAZIA);
		}
		else {
			for(MsIhm msihm : lista) {
				ihmDTO = null;
				ihmDTO = new IhmDTO();
				ihmDTO.setCdIhm(msihm.getCdIhm());
				ihmDTO.setIdIhm(msihm.getIdIhm().intValue());
				ihmDTO.setUrl_Conexao(msihm.getUrlConexao());
				ihmDTO.setUrl_ConexaoAlternativo(msihm.getUrlConexaoalt());
				ihmDTO.setUrl_Ip(msihm.getUrlIp());
				ihmDTO.setIsUpRegistrado(msihm.getIsUpreg());
				ihmDTO.setIsTodosEvt(msihm.getIsEvttodos());
				ihmDTO.setIsEvtPendente(msihm.getIsEvtpnd());
				ihmDTO.setIsEvtCicloFechado(msihm.getIsEvtciclofechado());
				ihmDTO.setIsEvtTrabalhando(msihm.getIsEvttrabalhando());
				ihmDTO.setIsEvtParada(msihm.getIsEvtparada());
				ihmDTO.setIsEvtRefugo(msihm.getIsEvtrefugo());
				ihmDTO.setIsEvtAlerta(msihm.getIsEvtalerta());
				ihmDTO.setIsEvtLogin(msihm.getIsEvtlogin());
				ihmDTO.setDthrCadastro(msihm.getDthrCadastro());
				
				for (MsUpihm up : msihm.getMsUpihms()) {
					if (up.getMsUp().getStAtivo().equals(BigDecimal.ZERO) )
						continue;
					
					UpIhmDTO dto = new UpIhmDTO(up);
					ihmDTO.getUps().add(dto);
							
				}
							
				listaihmdto.add(ihmDTO);
			}
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		}
		
		listaIhmDTO.setResultadoDTO(resultadoDTO);
		listaIhmDTO.setListaIhmDTO(listaihmdto);
		
		
		return listaIhmDTO;
		
	}
	
	private List<MsIhm> pesquisarMsIhm() {
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select distinct msihm ");
		q.append("from MsIhm msihm ");
		q.append("left join fetch msihm.msUpihms b");
		
		q.appendWhere(MapQuery._NULL, "msihm.cdIhm = :cdihm ", this.getCdIhm()!= null && !this.getCdIhm().equals(""));
		q.appendWhere(MapQuery._AND, "msihm.urlConexao = :urlconexao ", this.getUrl_Conexao()!= null && !this.getUrl_Conexao().equals(""));
		q.appendWhere(MapQuery._AND, "msihm.urlConexaoalt = :urlconexaoalt ", this.getUrl_ConexaoAlternativo()!= null && !this.getUrl_ConexaoAlternativo().equals(""));
		q.appendWhere(MapQuery._AND, "msihm.urlIp = :urlip ", this.getUrl_Ip() != null && !this.getUrl_Ip().equals(""));
		q.appendWhere(MapQuery._AND, "msihm.isUpreg >= 1 ", this.getIsUpRegistrado() != null);
		q.appendWhere(MapQuery._AND, "msihm.isEvttodos >= 1 ", this.getIsTodosEvt() != null);
		q.appendWhere(MapQuery._AND, "msihm.isEvtpnd >= 1 ", this.getIsEvtPendente() != null);
		q.appendWhere(MapQuery._AND, "msihm.isEvtciclofechado >= 1 ", this.getIsEvtCicloFechado() != null);
		q.appendWhere(MapQuery._AND, "msihm.isEvttrabalhando >= 1 ", this.getIsEvtTrabalhando() != null);
		q.appendWhere(MapQuery._AND, "msihm.isEvtparada >= 1 ", this.getIsEvtParada() != null);
		q.appendWhere(MapQuery._AND, "msihm.isEvtrefugo >= 1 ", this.getIsEvtRefugo() != null);
		q.appendWhere(MapQuery._AND, "msihm.isEvtalerta >= 1 ", this.getIsEvtAlerta() != null);
		q.appendWhere(MapQuery._AND, "msihm.isEvtlogin >= 1 ", this.getIsEvtLogin() != null);
		
		q.defineParametro("cdihm", this.getCdIhm());
		q.defineParametro("urlconexao", this.getUrl_Conexao());
		q.defineParametro("urlconexaoalt", this.getUrl_ConexaoAlternativo());
		q.defineParametro("urlip", this.getUrl_Ip());

		return q.list();
	}
	
	private Boolean validarURLConexao(IhmDTO ihmdto, List<IhmDTO> lista, ListaIhmDTO listaIhmDTO,ResultadoMSDTO resultadoDTO){
		MsIhm msihmAux = null;
		try {
			msihmAux = pesquisarPorURLConexaoAndURLConexaoALt();
			if(msihmAux != null && (getIdIhm() == null || (getIdIhm() != null && getIdIhm().equals(msihmAux.getIdIhm()) == true) ) ){
				resultadoDTO.setIdMensagem(resultadoDTO.ERRO_URL_CONEXAO_JA_CADASTRADA);
				ihmdto.setCdIhm(msihmAux.getCdIhm());
				lista.add(ihmdto);
				listaIhmDTO.setListaIhmDTO(lista);
				listaIhmDTO.setResultadoDTO(resultadoDTO);
				return false;
			}
		} catch (IhmDesconhecidoException e) {
		}
		return true;
	}
	
	private Boolean validarIP(IhmDTO ihmdto, List<IhmDTO> lista, ListaIhmDTO listaIhmDTO,ResultadoMSDTO resultadoDTO){
				MsIhm msihmAux = null;
				try {
					msihmAux = pesquisarIP();
					if(msihmAux != null && (getIdIhm() == null || (getIdIhm() != null && getIdIhm().equals(msihmAux.getIdIhm()) == true) )){
						resultadoDTO.setIdMensagem(resultadoDTO.ERRO_IP_JA_CADASTRADA);
						ihmdto.setCdIhm(msihmAux.getCdIhm());
						lista.add(ihmdto);
						listaIhmDTO.setListaIhmDTO(lista);
						listaIhmDTO.setResultadoDTO(resultadoDTO);
						return false;
					}
				} catch (IhmDesconhecidoException e) {
				}
				return true;
	}

	private Boolean validarUsuario(String login, ResultadoMSDTO resultadoDTO){
		UsuarioMSRN rn = new UsuarioMSRN(getDao());
		rn.setLogin(login);
		MsUsr msusr = rn.pesquisarMsUsrUsandoLogin();
		if (msusr == null) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_USUARIO_DESCONHECIDO);
			return false;
		}
		return true;
	}
	
	public ListaIhmDTO salvarIhmDTO() {
		MsIhm msihm = null;
		MsUsr msusr = null;
		IhmDTO ihmdto = new IhmDTO();
		List<IhmDTO> lista = new ArrayList<IhmDTO>();
		ListaIhmDTO listaIhmDTO = new ListaIhmDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		Date data = new Date();
		
		if(this.getCdIhm() == null || (this.getCdIhm() != null  && this.getCdIhm().equals("") ) ) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDIC_DESCONHECIDO);
			lista.add(ihmdto);
			listaIhmDTO.setListaIhmDTO(lista);
			listaIhmDTO.setResultadoDTO(resultadoDTO);
			return listaIhmDTO;
		}

		if(this.getUrl_Ip() == null || (this.getUrl_Ip() != null  && this.getUrl_Ip().equals("") ) ) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_URL_DESCONHECIDA);
			lista.add(ihmdto);
			listaIhmDTO.setListaIhmDTO(lista);
			listaIhmDTO.setResultadoDTO(resultadoDTO);
			return listaIhmDTO;
		}

		if(this.getUrl_Conexao() == null || (this.getUrl_Conexao() != null  && this.getUrl_Conexao().equals("") ) ) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_URL_DESCONHECIDA);
			lista.add(ihmdto);
			listaIhmDTO.setListaIhmDTO(lista);
			listaIhmDTO.setResultadoDTO(resultadoDTO);
			return listaIhmDTO;
		}

		// verifica se a URL ja existe em outro cadastro
		if(validarURLConexao(ihmdto,lista,listaIhmDTO,resultadoDTO) == false){
			lista.add(ihmdto);
			listaIhmDTO.setListaIhmDTO(lista);
			listaIhmDTO.setResultadoDTO(resultadoDTO);
			return listaIhmDTO;
		}
		
		//verifica se o IP existe em outro cadastro
		if(validarIP(ihmdto,lista,listaIhmDTO,resultadoDTO) == false){
			lista.add(ihmdto);
			listaIhmDTO.setListaIhmDTO(lista);
			listaIhmDTO.setResultadoDTO(resultadoDTO);
			return listaIhmDTO;
		}
		
		// Verifica se o usuario existe
		if (validarUsuario(this.getLoginUsuario(), resultadoDTO) == false) {
			lista.add(ihmdto);
			listaIhmDTO.setListaIhmDTO(lista);
			listaIhmDTO.setResultadoDTO(resultadoDTO);
			return listaIhmDTO;
		}
		// Continua com o cadastro se nenhuma inconsistencia foi encontrada
		msihm = pesquisarMsIhmPorCdIhm();

		if (msihm == null) {
			msihm = new MsIhm();
			msihm.setCdIhm(this.getCdIhm());
			msihm.setIdIhm(null);
		}

		msihm.setUrlConexao(this.getUrl_Conexao());
		msihm.setUrlConexaoalt(this.getUrl_ConexaoAlternativo());
		msihm.setUrlIp(this.getUrl_Ip());
		msihm.setDthrCadastro(data);

		msusr = pesquisarMsUsr();
		msihm.setMsUsr(msusr);

		msihm.setIsUpreg(this.getIsUpRegistrado());
		msihm.setIsEvttodos(this.getIsTodosEvt());
		msihm.setIsEvtpnd(this.getIsEvtPendente());
		msihm.setIsEvtciclofechado(this.getIsEvtCicloFechado());
		msihm.setIsEvttrabalhando(this.getIsEvtTrabalhando());
		msihm.setIsEvtparada(this.getIsEvtParada());
		msihm.setIsEvtrefugo(this.getIsEvtRefugo());
		msihm.setIsEvtalerta(this.getIsEvtAlerta());
		msihm.setIsEvtlogin(this.getIsEvtLogin());

		dao.iniciaTransacao();
		msihm = dao.makePersistent(msihm);
		
		/* Salvar tambem as ups associadas ao IHM
		 * 
		 */
		// Remover os antigos para adicionar os novos
		for (MsUpihm upihm : msihm.getMsUpihms()) {
			dao.delete(upihm);
		}
		
		Set<MsUpihm> ups = new HashSet<>();
		if (getUps().isEmpty() == false) {
			
			UpRN rn = new UpRN();
			rn.setDaoPdba(dao);
			for (UpIhmDTO updto : getUps()) {
				MsUp msUp;
				try {
					msUp = rn.pesquisarMsUpPorCdUpStAtivo(updto.getUp().getCd_up());
				} catch (RegistroDesconhecidoException e) {
					continue;
				}
				MsUpihm upihm = new MsUpihm();
				upihm.setDthrCadastro(DataHoraRN.getDataHoraAtual());
				upihm.setIdUpihm(null);
				upihm.setMsIhm(msihm);
				upihm.setMsUp(msUp);
				ups.add(upihm);
				dao.makePersistent(upihm);
			}
		}

		ihmdto.setCdIhm(msihm.getCdIhm());
		ihmdto.setIdIhm(msihm.getIdIhm().intValue());
		ihmdto.setUrl_Conexao(msihm.getUrlConexao());
		ihmdto.setUrl_ConexaoAlternativo(msihm.getUrlConexaoalt());

		ihmdto.setUrl_Ip(msihm.getUrlIp());
		ihmdto.setIsUpRegistrado(msihm.getIsUpreg());
		ihmdto.setIsTodosEvt(msihm.getIsEvttodos());
		ihmdto.setIsEvtPendente(msihm.getIsEvtpnd());
		ihmdto.setIsEvtCicloFechado(msihm.getIsEvtciclofechado());
		ihmdto.setIsEvtTrabalhando(msihm.getIsEvttrabalhando());
		ihmdto.setIsEvtParada(msihm.getIsEvtparada());
		ihmdto.setIsEvtRefugo(msihm.getIsEvtrefugo());
		ihmdto.setIsEvtAlerta(msihm.getIsEvtalerta());
		ihmdto.setIsEvtLogin(msihm.getIsEvtlogin());
		ihmdto.setDthrCadastro(msihm.getDthrCadastro());
		
		/* Retornar tambem a lsita das ups
		 * 
		 */
		for (MsUpihm up : ups) {
			if (up.getMsUp().getStAtivo().equals(BigDecimal.ZERO) )
				continue;
			
			UpIhmDTO dto = new UpIhmDTO(up);
			ihmdto.getUps().add(dto);
					
		}

		
		resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);		
		
		dao.commitaTransacao(dao.getSession());
		lista.add(ihmdto);
		listaIhmDTO.setListaIhmDTO(lista);
		listaIhmDTO.setResultadoDTO(resultadoDTO);
		
		return listaIhmDTO;
	}
	
	
	private MsUsr pesquisarMsUsr() {
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select msusr ");
		q.append("from MsUsr msusr ");
		q.append("where msusr.login = :login ");
		q.append("and msusr.stAtivo = 1 ");
		
		q.defineParametro("login", this.getLoginUsuario());
		
		q.setMaxResults(1);
		
		return (MsUsr) q.uniqueResult();
		
	}
	public MsIhm pesquisarMsIhmPorCdIhm() {
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select msihm ");
		q.append("from MsIhm msihm ");
		q.append("where msihm.cdIhm = :cdihm");
		
		q.defineParametro("cdihm", this.getCdIhm());
		q.setMaxResults(1);

		return (MsIhm) q.uniqueResult();
	}
	public ListaIhmDTO removeIhmDTO() {
		ListaIhmDTO listaIhmDTO = null;
		
		listaIhmDTO = removeRegistro();
		
		return listaIhmDTO;
	}
	private ListaIhmDTO removeRegistro() {
		MsIhm msihm = null;
		MapQuery q = new MapQuery(this.dao.getSession());
		IhmDTO ihmdto = new IhmDTO();
		ArrayList<IhmDTO> lista = new ArrayList<IhmDTO>();
		ListaIhmDTO listaIhmDTO = new ListaIhmDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		
		q.append("select msihm from MsIhm msihm ");
		q.append("where msihm.idIhm = :id");
		
		q.defineParametro("id", new BigDecimal(this.getIdIhm()));
		
		q.setMaxResults(1);
		
		msihm = (MsIhm)q.uniqueResult();
		
		/*
		 * Removendo vinculos, j� excluidos da up, caso ainda exista algum
		 * motivo: a up � feita com exclus�o l�gica, por isso ainda existem registro da up mesmo ja excluida com o ihm
		 */
		MapQuery querymsupihm = new  MapQuery(dao.getSession());
		
		querymsupihm.append("SELECT msupihm");
		querymsupihm.append("FROM MsUpihm msupihm");
		querymsupihm.append("left join fetch msupihm.msIhm msihm");
		querymsupihm.append("left join fetch msupihm.msUp msup");
		querymsupihm.append("WHERE msihm.idIhm = :id");
		querymsupihm.append("AND msup.stAtivo = 0");
		querymsupihm.defineParametro("id", new BigDecimal(this.getIdIhm()));
		
		List<MsUpihm> listaMsUpIhm = querymsupihm.list();
		
		boolean issucesso = true;
		try{
			dao.iniciaTransacao();
			if(listaMsUpIhm != null){
				for(MsUpihm upihm: listaMsUpIhm){
					dao.getSession().delete(upihm);
				}
			}
			dao.getSession().delete(msihm);
			dao.commitaTransacao(dao.getSession());	
		}catch(Exception e){
			issucesso = false;
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_IHM_JA_VINCULADO);	
		}
		
		if(issucesso){
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		}
		
		
		lista.add(ihmdto);
		listaIhmDTO.setListaIhmDTO(lista);
		listaIhmDTO.setResultadoDTO(resultadoDTO);
		
		return listaIhmDTO;
	}
	
	public ListaIhmDTO getTodosIhmDTO() {
		
		List<MsIhm> listamsihm = null;
		ArrayList<IhmDTO> listaihmdto = new ArrayList<IhmDTO>();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		ListaIhmDTO listaihmDTO = new ListaIhmDTO();
		IhmDTO ihmDTO = null;
		
		MapQuery q = new MapQuery(dao.getSession());

		q.append("select msihm from MsIhm msihm");

		listamsihm = q.list();

		if(listamsihm != null) {
			for(MsIhm msihm : listamsihm) {
				ihmDTO = null;
				ihmDTO = new IhmDTO();
				ihmDTO.setCdIhm(msihm.getCdIhm());
				ihmDTO.setUrl_Ip(msihm.getUrlIp());
				ihmDTO.setIdIhm(msihm.getIdIhm().intValue());
				ihmDTO.setUrl_Conexao(msihm.getUrlConexao());
				ihmDTO.setUrl_ConexaoAlternativo(msihm.getUrlConexaoalt());

				listaihmdto.add(ihmDTO);
			}
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		} else {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_LISTA_VAZIA);
		}
		
		listaihmDTO.setListaIhmDTO(listaihmdto);
		listaihmDTO.setResultadoDTO(resultadoDTO);
		
		return listaihmDTO;
	}
	
	
	@SuppressWarnings("unused")
	public ListaIHMsDTO getIHMsDTO(FiltroPesquisaDTO filtro) {
		ListaIHMsDTO retorno = new ListaIHMsDTO();
		retorno.setItems(new ArrayList<IhmDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
				
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select DISTINCT t ");
		q.append("from MsIhm t ");
		//q.append("left join fetch t.msUpihms ihm ");
		q.append("where 1=1 ");
				
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){			
			q.append("AND (");
			q.append(" upper(t.cdIhm) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.urlConexao) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
 
 		q.append("ORDER BY t.cdIhm");
 		
 		List<MsIhm> lista =  q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
 		for (MsIhm reg : lista) {
 			IhmDTO2 dto = new IhmDTO2();
 			dto.setIdIHM(reg.getIdIhm().intValue());
 			dto.setCdIHM(reg.getCdIhm());
 			dto.setUrlConexao(reg.getUrlConexao());
 			dto.setCdUsrRev(reg.getMsUsr().getCdUsr());
 			dto.setUps(new ArrayList<UpIhmDTO2>());
 		
 			for(MsUpihm up : reg.getMsUpihms()) {
 				if (up.getMsUp().getStAtivo().intValue() == 1) {
 	 				UpIhmDTO2 ihm = new UpIhmDTO2();
 	 				ihm.setCdUP(up.getMsUp().getCdUp());
 	 				dto.getUps().add(ihm);	
 				}
 			}
 			
 			Collections.sort(dto.getUps(), comparaCodigo);
 			retorno.getItems().add(dto);
 		}
		
		
 		if (lista.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, lista.size()));
 			resRN = null;
 		}
		
		q = null;
		lista = null;		
		
		return retorno;
	}

	@SuppressWarnings("unused")
	public IhmDTO2 getIHMByCd(String cdIHM) {
		IhmDTO2 retorno = new IhmDTO2();
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select DISTINCT t ");
		q.append("from MsIhm t ");
		//q.append("left join fetch t.msUpihms ihm ");
		q.append("where t.cdIhm = :cdihm");
 		q.defineParametro("cdihm", cdIHM);
 		
 		List<MsIhm> lista =  q.list();
 		if (lista.size() > 0) {  
 			retorno.setIdIHM(lista.get(0).getIdIhm().intValue());
 			retorno.setCdIHM(lista.get(0).getCdIhm());
 			retorno.setUrlConexao(lista.get(0).getUrlConexao());
 			retorno.setCdUsrRev(lista.get(0).getMsUsr().getCdUsr());
 			retorno.setUps(new ArrayList<UpIhmDTO2>());
 		
 			for(MsUpihm up : lista.get(0).getMsUpihms()) {
 				if (up.getMsUp().getStAtivo().intValue() == 1) {
	 				UpIhmDTO2 ihm = new UpIhmDTO2();
	 				ihm.setCdUP(up.getMsUp().getCdUp());
	 				retorno.getUps().add(ihm);
 				}
 			}
 			
 			Collections.sort(retorno.getUps(), comparaCodigo);
 		}
		
		return retorno;
	}
	
	//comparators 
	private static final Comparator<UpIhmDTO2> comparaCodigo = new Comparator<UpIhmDTO2>() {
		@Override
		public int compare(UpIhmDTO2 o1, UpIhmDTO2 o2) {
			return o1.getCdUP().compareTo(o2.getCdUP());
		}
	};

}

package idw.webservices.rest.idw.v2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.SQLQuery;

import com.google.gson.Gson;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MsUsrDAO;
import idw.model.dao.OmPtDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.excessoes.DigestFileException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalpt;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwFolha; 
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRapGrupo;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTJust;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.DwTurno;
import idw.model.pojos.MsUp;
import idw.model.pojos.MsUsr;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmFor;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTpgt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.injet.Ijtbusureqtec;
import idw.model.pojos.template.OmObjTemplate;
import idw.model.rn.AlertaRN;
import idw.model.rn.AreaRN;
import idw.model.rn.CalendarioRN;
import idw.model.rn.CargoRN;
import idw.model.rn.CausaRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwRapRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.GTRN;
import idw.model.rn.GrupoFerramentaRN;
import idw.model.rn.GrupoUsuarioRN;
import idw.model.rn.HashMD5;
import idw.model.rn.JustificativaRN;
import idw.model.rn.PTRN;
import idw.model.rn.ParadaRN;
import idw.model.rn.PpClienteRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.RefugoRN;
import idw.model.rn.TAcaoRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.op.OpSimplesRN;
import idw.webservices.dto.AlertaDTO;
import idw.webservices.dto.AlertasDTO;
import idw.webservices.dto.CalendarioDTO;
import idw.webservices.dto.CalendarioPtsDTO;
import idw.webservices.dto.CalendarioSemanalDTO;
import idw.webservices.dto.CalendarioWizardDTO;
import idw.webservices.dto.CalendariosDTO;
import idw.webservices.dto.CalendariosSemanaisDTO;
import idw.webservices.dto.CpDTO;
import idw.webservices.dto.DWParadaDTO; 
import idw.webservices.dto.DwRapDTO;
import idw.webservices.dto.DwTAreaDTO;
import idw.webservices.dto.DwTAreasDTO;
import idw.webservices.dto.DwTCausaDTO;
import idw.webservices.dto.DwTCausasDTO;
import idw.webservices.dto.DwTJustDTO;
import idw.webservices.dto.DwTJustsDTO;
import idw.webservices.dto.DwTRefugoDTO;
import idw.webservices.dto.DwTRefugosDTO;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.FolhaDTO;
import idw.webservices.dto.FolhasDTO;
import idw.webservices.dto.GTsDTO;
import idw.webservices.dto.GrupoFerramentaDTO;
import idw.webservices.dto.GtDTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.dto.OmCargoDTO;
import idw.webservices.dto.OmCargosDTO;
import idw.webservices.dto.OrdemProducaoProdutoDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.ParadasDTO;
import idw.webservices.dto.PpClienteDTO;
import idw.webservices.dto.PpClientesDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.TAcaoDTO;
import idw.webservices.dto.TAcoesDTO;
import idw.webservices.dto.TurnoDTO;
import idw.webservices.dto.TurnosDTO;
import idw.webservices.dto.UsuarioDTO;
import idw.webservices.dto.UsuariosDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.auth.TokenFilter; 
import idw.webservices.rest.idw.v2.dto.AcaoDTO2;
import idw.webservices.rest.idw.v2.dto.AlertaDTO2;
import idw.webservices.rest.idw.v2.dto.AreaResponsavelDTO;
import idw.webservices.rest.idw.v2.dto.CalendarioDTO2;
import idw.webservices.rest.idw.v2.dto.CalendarioPtDTO2;
import idw.webservices.rest.idw.v2.dto.CalendarioTurnoIntervaloDTO;
import idw.webservices.rest.idw.v2.dto.CalendarioTurnoDTO;
import idw.webservices.rest.idw.v2.dto.CargoDTO;
import idw.webservices.rest.idw.v2.dto.CausaDTO;
import idw.webservices.rest.idw.v2.dto.ClienteDTO2;
import idw.webservices.rest.idw.v2.dto.ErrorDTO2;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.FolhaDTO2;
import idw.webservices.rest.idw.v2.dto.FolhaRapDTO2;
import idw.webservices.rest.idw.v2.dto.FolhaRapProdutoDTO;
import idw.webservices.rest.idw.v2.dto.GrupoFerramentasDTO2;
import idw.webservices.rest.idw.v2.dto.GrupoUsrDTO;
import idw.webservices.rest.idw.v2.dto.GtDTO2;
import idw.webservices.rest.idw.v2.dto.GtLayoutDTO;
import idw.webservices.rest.idw.v2.dto.IcDTO2;
import idw.webservices.rest.idw.v2.dto.IhmDTO2;
import idw.webservices.rest.idw.v2.dto.IhmUpDTO2;
import idw.webservices.rest.idw.v2.dto.JustificativaDTO;
import idw.webservices.rest.idw.v2.dto.ListaAcoesDTO;
import idw.webservices.rest.idw.v2.dto.ListaAlertasDTO;
import idw.webservices.rest.idw.v2.dto.ListaAreaRespDTO;
import idw.webservices.rest.idw.v2.dto.ListaCalendariosDTO;
import idw.webservices.rest.idw.v2.dto.ListaCargosDTO;
import idw.webservices.rest.idw.v2.dto.ListaCausasDTO;
import idw.webservices.rest.idw.v2.dto.ListaClientesDTO;
import idw.webservices.rest.idw.v2.dto.ListaFolhasProcessoDTO;
import idw.webservices.rest.idw.v2.dto.ListaGTsDTO;
import idw.webservices.rest.idw.v2.dto.ListaGrupoFerramentasDTO;
import idw.webservices.rest.idw.v2.dto.ListaGruposAcessoUsrDTO;
import idw.webservices.rest.idw.v2.dto.ListaICsDTO;
import idw.webservices.rest.idw.v2.dto.ListaIHMsDTO;
import idw.webservices.rest.idw.v2.dto.ListaJustificativasDTO;
import idw.webservices.rest.idw.v2.dto.ListaMSsDTO;
import idw.webservices.rest.idw.v2.dto.ListaOPSimplesPesqDTO; 
import idw.webservices.rest.idw.v2.dto.ListaPTsDTO;
import idw.webservices.rest.idw.v2.dto.ListaParadasDTO;
import idw.webservices.rest.idw.v2.dto.ListaProdutosDTO;
import idw.webservices.rest.idw.v2.dto.ListaRapsDTO;
import idw.webservices.rest.idw.v2.dto.ListaRefugosDTO;
import idw.webservices.rest.idw.v2.dto.ListaTurnosDTO;
import idw.webservices.rest.idw.v2.dto.ListaUPsDTO;
import idw.webservices.rest.idw.v2.dto.ListaUsuariosDTO;
import idw.webservices.rest.idw.v2.dto.MsDTO2;
import idw.webservices.rest.idw.v2.dto.OPCadDTO;
import idw.webservices.rest.idw.v2.dto.OPPtCadDTO;
import idw.webservices.rest.idw.v2.dto.ParadaCadDTO;
import idw.webservices.rest.idw.v2.dto.ProdutoDTO2;
import idw.webservices.rest.idw.v2.dto.PtDTO2;
import idw.webservices.rest.idw.v2.dto.PtExcDTO;
import idw.webservices.rest.idw.v2.dto.RapDTO;
import idw.webservices.rest.idw.v2.dto.RefugoCadDTO;
import idw.webservices.rest.idw.v2.dto.ResultadoExclusaoIHM;
import idw.webservices.rest.idw.v2.dto.TurnoDTO2;
import idw.webservices.rest.idw.v2.dto.UpDTO2;
import idw.webservices.rest.idw.v2.dto.UpIcMsDTO2;
import idw.webservices.rest.idw.v2.dto.UpIhmDTO2;
import idw.webservices.rest.idw.v2.dto.UsrDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.IhmDTO;
import ms.model.dto.ListaIcDTO;
import ms.model.dto.ListaIhmDTO;
import ms.model.dto.ListaMSDTO;
import ms.model.dto.ListaUPDTO;
import ms.model.dto.MsDTO;
import ms.model.dto.UpDTO;
import ms.model.dto.UpIhmDTO;
import ms.model.rn.IcRN;
import ms.model.rn.IhmRN;
import ms.model.rn.MsRN;
import ms.model.rn.UpRN;
import ms.util.ConversaoTipos;

@Path("/v2/cadastros")
public class CadastrosResource {

	private final int AUTENTICACAO_USUARIO = 0;
	private final int ACOES = 1;
	private final int ALERTAS = 2;
	private final int AREAS_RESPONSAVEIS = 3;
	private final int CALENDARIOS = 4;
	private final int CARGOS = 5;
	private final int CAUSAS = 6;
	
	// Como não há tratamento de erro para o cadastro de clientes, achei melhor retirar essa declaração
	// para não nos confundir achando que tem.
	// private final int CLIENTES = 7;
	
	private final int FERRAMENTAS = 8;
	private final int FOLHAS_PROCESSOS = 9;
	private final int GRUPOS_FERRAMENTAS = 10;
	private final int GRUPOS_TRABALHO = 11;
	private final int IHMS = 12;
	private final int INTERFACE_COLETOR = 13;
	private final int JUSTIFICATIVAS = 14;
	private final int MODULO_SINAIS = 15;
	private final int ORDENS_PRODUCAO_SIMPLIFICADA = 16;
	private final int PARADAS = 17;
	private final int POSTOS_TRABALHO = 18;
	private final int PRODUTOS = 19;
	private final int REFUGOS = 20;
	private final int RESULTADO_MS_DTO = 21;
	private final int RESULTADO_DTO = 22;
	private final int USUARIOS = 23;
	private final int UPS = 24;
	private final int TURNOS = 25;
	
	
	private static final int qtdItensCadRetornoLista = 5000;
	
	private OmCargo getCargoLocal(CargoRN rn, String cdCargo) {
		OmCargo retorno = new OmCargo();
		try {
			retorno = rn.getOmCargo(cdCargo);
		} catch (RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retorno = null;
		}
		return retorno;
	}

	private OmUsr getUsrLocal(String cdUsr, DAOGenerico dao) {
		OmUsrDAO rn = new OmUsrDAO(dao.getSession());
		return rn.getOmUsrPorCdAtivo(cdUsr);
	}

	private DwTurno getTurnoLocal(TurnoRN rn, String cdTurno) {
		DwTurno retorno = new DwTurno();
		retorno = rn.getDwTurnoPorCodigo(cdTurno);
		return retorno;
	}

	private DwGrupoFerramenta getGrupoFerramentaLocal(GrupoFerramentaRN rn, String cdGrupoFerramenta) {
		DwGrupoFerramenta retorno = new DwGrupoFerramenta();
		retorno = rn.getDwGrpFerramentaPorCodigo(cdGrupoFerramenta);
		return retorno;
	}

	private DwRap getFerramentaLocal(DwRapRN rn, String cdFerramenta, DAOGenerico dao) {
		DwRap retorno = new DwRap();
		retorno = rn.getDwRapPorCodigo(cdFerramenta, dao);
		return retorno;
	}

	private OmPt getPtLocal(PTRN rn, String cdPt) {
		OmPt retorno = new OmPt();
		try {
			retorno = rn.getOmPt(cdPt);
		} catch (RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			retorno = null;
		}
		return retorno;
	}

	private OmProduto getProdutoLocal(ProdutoRN rn, String cdProduto) {
		OmProduto retorno = new OmProduto();
		try {
			retorno = rn.getOmProduto(cdProduto);
		} catch (RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			retorno = null;
		}
		return retorno;
	}

	private OmGt getGtLocal(GTRN rn, String cdGt) {
		OmGt retorno = new OmGt();
		retorno = rn.getOmGtByCdGt(cdGt);
		return retorno;
	}

	private DwTCausa getCausaLocal(CausaRN rn, String cdCausa) {
		DwTCausa retorno = new DwTCausa();
		retorno = rn.getDwTCausa(cdCausa);
		return retorno;
	}

	private DwTAcao getAcaoLocal(TAcaoRN rn, String cdAcao) {
		DwTAcao retorno = new DwTAcao();
		retorno = rn.getDwTAcaoByCd(cdAcao);
		return retorno;
	}

	private DwTJust getJustificativaLocal(JustificativaRN rn, String cdJustificativa) {
		DwTJust retorno = new DwTJust();
		retorno = rn.getDwTJust(cdJustificativa);
		return retorno;
	}

	private DwTArea getAreaResponsavelLocal(AreaRN rn, String cdAreaResponsavel) {
		DwTArea retorno = new DwTArea();
		try {
			retorno = rn.getDwTArea(cdAreaResponsavel, true);
		} catch (RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retorno = null;
		}
		return retorno;
	}

	private DwTAlerta getAlertaLocal(AlertaRN rn, String cdAlerta) {
		DwTAlerta retorno = new DwTAlerta();
		retorno = rn.getDwTAlerta(cdAlerta);
		return retorno;
	}

	private PpCliente getClienteLocal(PpClienteRN rn, String cdCliente) {
		PpCliente retorno = new PpCliente();
		retorno = rn.getPpCliente(cdCliente);
		return retorno;
	}

	private DwFolha getFolhaProcessosLocal(FolhaRN rn, String cdFolha) {
		DwFolha retorno = new DwFolha();
		retorno = rn.getDwFolhaByCd(cdFolha);
		return retorno;
	}

	private DwCal getCalendarioLocal(CalendarioRN rn, String cdCalendario) {
		DwCal retorno = new DwCal();
		retorno = rn.getCalendarioPeloCodigo(cdCalendario);
		return retorno;
	}

	private String getErroTabelado(String tabela, int erro) {
		return "";
	}

	private FiltroPesquisaDTO getFiltroPesquisa(String conteudoPesquisa, Integer pagina, Integer registrosPorPagina) {
		FiltroPesquisaDTO filtro = new FiltroPesquisaDTO();

		if (conteudoPesquisa != null) {
			filtro.setConteudoPesquisa(conteudoPesquisa);
		}

		if (pagina != null) {
			filtro.setPagina(pagina);
		}

		if (registrosPorPagina != null) {
			filtro.setRegistrosPorPagina(registrosPorPagina);
		}

		return filtro;
	}

	// cargos
	@GET
	@Path("/cargos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCargosAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CargoRN rn = new CargoRN();
			rn.setDao(dao);

			ListaCargosDTO retornoConsulta = rn.getCargosDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/cargos/{cdCargo: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCargo(@Context HttpServletRequest request, @PathParam("cdCargo") String cdCargo) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CargoRN rn = new CargoRN();
			rn.setDao(dao);

			CargoDTO retornoConsulta = rn.getCargoByCd(cdCargo);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/cargos/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoCargo(@Context HttpServletRequest request, CargoDTO cargoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CargoRN rn = new CargoRN();
			rn.setDao(dao);

			OmCargoDTO cargo = CargoAtribuiValoresPadraoSalvar(rn, cargoDTO, true);
			OmCargoDTO retorno = rn.setOmCargo(cargo);

			long idCargo = rn.getCargoByCd(cargoDTO.getCdCargo()).getIdCargo();
			retorno.getOmCargo().setIdCargo(idCargo);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(CARGOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				cargoDTO.setIdCargo(retorno.getOmCargo().getIdCargo());
				cargoDTO.setStRegistro(retorno.getOmCargo().getStAtivo().intValue());
				String json = gson.toJson(cargoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// alterar
	@PUT
	@Path("/cargos/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoCargo(@Context HttpServletRequest request, CargoDTO cargoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CargoRN rn = new CargoRN();
			rn.setDao(dao);

			OmCargoDTO cargo = CargoAtribuiValoresPadraoSalvar(rn, cargoDTO, false);
			OmCargoDTO retorno = rn.setOmCargo(cargo);

			long idCargo = rn.getCargoByCd(cargoDTO.getCdCargo()).getIdCargo();
			retorno.getOmCargo().setIdCargo(idCargo);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(CARGOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				cargoDTO.setIdCargo(retorno.getOmCargo().getIdCargo());
				cargoDTO.setStRegistro(retorno.getOmCargo().getStAtivo().intValue());

				String json = gson.toJson(cargoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/cargos/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarCargo(@Context HttpServletRequest request, CargoDTO cargoDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CargoRN rn = new CargoRN();
			rn.setDao(dao);

			OmCargoDTO cargo = CargoAtribuiValoresPadraoSalvar(rn, cargoDTO, false);

			OmCargosDTO cargos = new OmCargosDTO();
			cargos.setListaOmCargoDTO(new ArrayList<OmCargoDTO>());
			cargos.getListaOmCargoDTO().add(cargo);

			OmCargosDTO retorno = rn.removeOmCargo(cargos);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getListaOmCargoDTO().get(0).getResultadoEvento() != retorno.getListaOmCargoDTO().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(CARGOS, retorno.getListaOmCargoDTO().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					cargoDTO.setIdCargo(retorno.getListaOmCargoDTO().get(0).getOmCargo().getIdCargo());
					cargoDTO.setStRegistro(0);

					String json = gson.toJson(cargoDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private OmCargoDTO CargoAtribuiValoresPadraoSalvar(CargoRN rn, CargoDTO cargo, boolean isInclusao) {
		OmCargoDTO cargoSalvar = new OmCargoDTO();

		OmCargo retorno = new OmCargo();

		retorno.setCdCargo(cargo.getCdCargo());
		retorno.setDsCargo(cargo.getDsCargo());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(cargo.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			OmCargo regUpd = getCargoLocal(rn, cargo.getCdCargo());
			retorno.setIdCargo(regUpd.getIdCargo());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		cargoSalvar.setOmCargo(new OmCargo());
		cargoSalvar.setOmCargo(retorno);

		retorno = null;

		return cargoSalvar;
	}

	// turnos
	@GET
	@Path("/turnos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurnosAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			TurnoRN rn = new TurnoRN();
			rn.setDao(dao);
			
			ListaTurnosDTO retornoConsulta = rn.getTurnosDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			dao.finalizaSessaoSemException();
			
		}
		
	}

	@GET
	@Path("/turnos/{cdTurno: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurno(@Context HttpServletRequest request, @PathParam("cdTurno") String cdTurno) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TurnoRN rn = new TurnoRN();
			rn.setDao(dao);

			TurnoDTO2 retornoConsulta = rn.getTurnoByCd(cdTurno);
			dao.commitaTransacao();				
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/turnos/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoTurno(@Context HttpServletRequest request, TurnoDTO2 turnoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TurnoRN rn = new TurnoRN();
			rn.setDao(dao);

			TurnoDTO turno = TurnoAtribuiValoresPadraoSalvar(rn, turnoDTO, true);
			TurnoDTO retorno = rn.setTurnoDTO(turno);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(TURNOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				turnoDTO.setIdTurno(retorno.getTurno().getIdTurno());
				turnoDTO.setStRegistro(retorno.getTurno().getStAtivo().intValue());
				String json = gson.toJson(turnoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/turnos/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoTurno(@Context HttpServletRequest request, TurnoDTO2 turnoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TurnoRN rn = new TurnoRN();
			rn.setDao(dao);

			TurnoDTO turno = TurnoAtribuiValoresPadraoSalvar(rn, turnoDTO, false);
			TurnoDTO retorno = rn.setTurnoDTO(turno);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(TURNOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				turnoDTO.setIdTurno(retorno.getTurno().getIdTurno());
				turnoDTO.setStRegistro(retorno.getTurno().getStAtivo().intValue());

				String json = gson.toJson(turnoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/turnos/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarTurno(@Context HttpServletRequest request, TurnoDTO2 turnoDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TurnoRN rn = new TurnoRN();
			rn.setDao(dao);

			TurnoDTO turno = TurnoAtribuiValoresPadraoSalvar(rn, turnoDTO, false);

			TurnosDTO turnos = new TurnosDTO();
			turnos.setTurnos(new ArrayList<TurnoDTO>());
			turnos.getTurnos().add(turno);

			TurnosDTO retorno = rn.removeTurnosDTO(turnos);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getTurnos().get(0).getResultadoEvento() != retorno.getTurnos().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(TURNOS, retorno.getTurnos().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					turnoDTO.setIdTurno(retorno.getTurnos().get(0).getTurno().getIdTurno());
					turnoDTO.setStRegistro(0);

					String json = gson.toJson(turnoDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private TurnoDTO TurnoAtribuiValoresPadraoSalvar(TurnoRN rn, TurnoDTO2 turno, boolean isInclusao) {

		TurnoDTO turnoSalvar = new TurnoDTO();

		DwTurno retorno = new DwTurno();

		retorno.setCdTurno(turno.getCdTurno());
		retorno.setDsTurno(turno.getDsTurno());
		retorno.setCor(turno.getCor());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(turno.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwTurno regUpd = getTurnoLocal(rn, turno.getCdTurno());
			retorno.setIdTurno(regUpd.getIdTurno());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		turnoSalvar.setTurno(new DwTurno());
		turnoSalvar.setTurno(retorno);

		retorno = null;

		return turnoSalvar;
	}

	// grupos de ferramentas
	@GET
	@Path("/gruposferramentas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrpFerramentasAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GrupoFerramentaRN rn = new GrupoFerramentaRN();
			rn.setDao(dao);

			ListaGrupoFerramentasDTO retornoConsulta = rn.getGrpFerramentasDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/gruposferramentas/{cdGrpFerramenta: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrpFerramenta(@Context HttpServletRequest request, @PathParam("cdGrpFerramenta") String cdGrpFerramenta) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GrupoFerramentaRN rn = new GrupoFerramentaRN();
			rn.setDao(dao);

			GrupoFerramentasDTO2 retornoConsulta = rn.getGrpFerramentaByCd(cdGrpFerramenta);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/gruposferramentas/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoGrupoFerramenta(@Context HttpServletRequest request, GrupoFerramentasDTO2 grpFerramentaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GrupoFerramentaRN rn = new GrupoFerramentaRN();
			rn.setDao(dao);

			GrupoFerramentaDTO grpFerramenta = GrupoFerramentaAtribuiValoresPadraoSalvar(rn, grpFerramentaDTO, true);
			GrupoFerramentaDTO retorno = rn.setDwGrupoFerramenta(grpFerramenta);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(GRUPOS_FERRAMENTAS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				grpFerramentaDTO.setIdGrupoFerramenta(retorno.getDwGrupoFerramenta().getIdGrupoFerramenta());
				grpFerramentaDTO.setStRegistro(retorno.getDwGrupoFerramenta().getStAtivo().intValue());
				String json = gson.toJson(grpFerramentaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/gruposferramentas/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoGrupoFerramenta(@Context HttpServletRequest request, GrupoFerramentasDTO2 grupoFerramentaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GrupoFerramentaRN rn = new GrupoFerramentaRN();
			rn.setDao(dao);

			GrupoFerramentaDTO grpFerramenta = GrupoFerramentaAtribuiValoresPadraoSalvar(rn, grupoFerramentaDTO, false);
			GrupoFerramentaDTO retorno = rn.setDwGrupoFerramenta(grpFerramenta);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(GRUPOS_FERRAMENTAS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				grupoFerramentaDTO.setIdGrupoFerramenta(retorno.getDwGrupoFerramenta().getIdGrupoFerramenta());
				grupoFerramentaDTO.setStRegistro(retorno.getDwGrupoFerramenta().getStAtivo().intValue());

				String json = gson.toJson(grupoFerramentaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/gruposferramentas/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarGrupoFerramentas(@Context HttpServletRequest request, GrupoFerramentasDTO2 grupoFerramentaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GrupoFerramentaRN rn = new GrupoFerramentaRN();
			rn.setDao(dao);

			GrupoFerramentaDTO grupoFerramenta = GrupoFerramentaAtribuiValoresPadraoSalvar(rn, grupoFerramentaDTO, false);
			GrupoFerramentaDTO retorno = rn.excluirDwGrupoFerramenta(grupoFerramenta);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(GRUPOS_FERRAMENTAS, retorno.getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();

				} else {
					grupoFerramentaDTO.setIdGrupoFerramenta(retorno.getDwGrupoFerramenta().getIdGrupoFerramenta());
					grupoFerramentaDTO.setStRegistro(0);

					String json = gson.toJson(grupoFerramentaDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private GrupoFerramentaDTO GrupoFerramentaAtribuiValoresPadraoSalvar(GrupoFerramentaRN rn, GrupoFerramentasDTO2 grupoFerramenta, boolean isInclusao) {

		GrupoFerramentaDTO grupoFerramentaSalvar = new GrupoFerramentaDTO();

		DwGrupoFerramenta retorno = new DwGrupoFerramenta();

		retorno.setCdGrupoFerramenta(grupoFerramenta.getCdGrupoFerramenta());
		retorno.setDsGrupoFerramenta(grupoFerramenta.getDsGrupoFerramenta());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(grupoFerramenta.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwGrupoFerramenta regUpd = getGrupoFerramentaLocal(rn, grupoFerramenta.getCdGrupoFerramenta());
			retorno.setIdGrupoFerramenta(regUpd.getIdGrupoFerramenta());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		grupoFerramentaSalvar.setDwGrupoFerramenta(new DwGrupoFerramenta());
		grupoFerramentaSalvar.setDwGrupoFerramenta(retorno);

		retorno = null;

		return grupoFerramentaSalvar;
	}

	// ferramentas
	@GET
	@Path("/ferramentas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFerramentasAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			DwRapRN rn = new DwRapRN();

			rn.iniciaConexaoBanco();
			ListaRapsDTO retornoConsulta = rn.getFerramentasDTO(filtro);
			rn.finalizaConexaoBanco();

			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();

		}

	}

	@GET
	@Path("/ferramentas/{cdFerramenta: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFerramenta(@Context HttpServletRequest request, @PathParam("cdFerramenta") String cdFerramenta) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			DwRapRN rn = new DwRapRN();

			rn.iniciaConexaoBanco();
			RapDTO retornoConsulta = rn.getFerramentaByCd(cdFerramenta);
			rn.finalizaConexaoBanco();

			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/ferramentas/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovaFerramenta(@Context HttpServletRequest request, RapDTO rapDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		DwRapRN rn = new DwRapRN();

		try {
			dao.iniciaSessao();
			DwRapDTO rap = FerramentaAtribuiValoresPadraoSalvar(rn, rapDTO, true, dao);
			dao.finalizaSessaoSemException();

			rn = new DwRapRN(rap);
			rn.iniciaConexaoBanco();
			DwRapDTO retorno = rn.salvarRegistro();
			rn.finalizaConexaoBanco();

			if (!retorno.getResultadoDTO().isComSucesso()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(FERRAMENTAS, retorno.getResultadoDTO().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				rapDTO.setIdFerramenta(retorno.getIdRap());
				rapDTO.setStRegistro(retorno.getStAtivo().intValue());

				String json = gson.toJson(rapDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.finalizaSessaoSemException();
			rn.rollbackTransacaoConexaoBanco();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
			rn.finalizaSessaoConexaoBanco();

		}

	}

	// alterar
	@PUT
	@Path("/ferramentas/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoFerramentas(@Context HttpServletRequest request, RapDTO rapDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		DwRapRN rn = new DwRapRN();

		try {
			dao.iniciaSessao();
			DwRapDTO rap = FerramentaAtribuiValoresPadraoSalvar(rn, rapDTO, false, dao);
			dao.finalizaSessaoSemException();

			rn = new DwRapRN(rap);
			rn.iniciaConexaoBanco();
			DwRapDTO retorno = rn.salvarRegistro();
			rn.finalizaConexaoBanco();

			if (!retorno.getResultadoDTO().isComSucesso()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(FERRAMENTAS, retorno.getResultadoDTO().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				rapDTO.setIdFerramenta(retorno.getIdRap());
				rapDTO.setStRegistro(retorno.getStAtivo().intValue());

				String json = gson.toJson(rapDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.finalizaSessaoSemException();
			rn.rollbackTransacaoConexaoBanco();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
			rn.finalizaSessaoConexaoBanco();
		}

	}

	// excluir (desativar)
	@PUT
	@Path("/ferramentas/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarFerramenta(@Context HttpServletRequest request, RapDTO rapDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		DwRapRN rn = new DwRapRN();

		try {
			dao.iniciaSessao();
			DwRapDTO rap = FerramentaAtribuiValoresPadraoSalvar(rn, rapDTO, false, dao);
			dao.finalizaSessaoSemException();

			rn = new DwRapRN(rap);
			rn.iniciaConexaoBanco();
			DwRapDTO retorno = rn.excluirRegistro();
			rn.finalizaConexaoBanco();

			if (retorno == null) {
				throw new JsonException("Error");

			} else {
				if (rn.getResultadoDTO().getIdmensagem() != rn.getResultadoDTO().COM_SUCESSO) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(FERRAMENTAS, retorno.getResultadoDTO().getIdmensagem());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					rapDTO.setIdFerramenta(retorno.getIdRap());
					rapDTO.setStRegistro(0);

					String json = gson.toJson(rapDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.finalizaSessaoSemException();
			rn.rollbackTransacaoConexaoBanco();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.finalizaSessaoSemException();
			rn.rollbackTransacaoConexaoBanco();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
			rn.finalizaSessaoConexaoBanco();
		}

	}

	private DwRapDTO FerramentaAtribuiValoresPadraoSalvar(DwRapRN rn, RapDTO rap, boolean isInclusao, DAOGenerico dao) {

		DwRapDTO rapSalvar = new DwRapDTO();

		rapSalvar.setCdRap(rap.getCdFerramenta());
		rapSalvar.setDsRap(rap.getDsFerramenta());
		rapSalvar.setQtTotal(rap.getQtTotal());
		rapSalvar.setQtAlocada(rap.getQtAlocada());

		PpCliente cliente = new PpCliente();
		cliente.setCdCliente(rap.getCdCliente());
		rapSalvar.setPpCliente(cliente);

		DwRapGrupo rapGrupo = null;
		DwGrupoFerramenta dwGrupoFerramenta = new DwGrupoFerramenta();
		GrupoFerramentaRN grupoFerramentaRN = new GrupoFerramentaRN();

		grupoFerramentaRN.setDao(dao);

		dwGrupoFerramenta = grupoFerramentaRN.getDwGrpFerramentaPorCodigo(rap.getCdGrupoFerramenta());

		if (dwGrupoFerramenta != null) {
			rapGrupo = new DwRapGrupo();
			rapGrupo.setDwGrupoFerramenta(dwGrupoFerramenta);
		}

		if (rapGrupo != null) {
			rapSalvar.getDwRapGrupos().add(rapGrupo);
		}

		rapSalvar.setDtRevisao(DataHoraRN.getDataHoraAtual());
		rapSalvar.setDtStativo(rapSalvar.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(rap.getCdUsrRev(), dao.getDao());
		rapSalvar.setOmUsrByIdUsrrevisao(omusrRevisao);
		rapSalvar.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		rapSalvar.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwRap regUpd = getFerramentaLocal(rn, rap.getCdFerramenta(), dao);
			rapSalvar.setIdRap(regUpd.getIdRap());
			rapSalvar.setRevisao(regUpd.getRevisao());
			regUpd = null;

		} else {
			rapSalvar.setRevisao(0l);
		}

		return rapSalvar;
	}

	// gts
	@GET
	@Path("/gts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGtsAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GTRN rn = new GTRN();
			rn.setDao(dao);

			ListaGTsDTO retornoConsulta = rn.getGTsDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/gts/{cdGt: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGt(@Context HttpServletRequest request, @PathParam("cdGt") String cdGt) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GTRN rn = new GTRN();
			rn.setDao(dao);

			GtDTO2 retornoConsulta = rn.getGtByCd(cdGt);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/gts/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoGT(@Context HttpServletRequest request, GtDTO2 gtDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GTRN rn = new GTRN();
			rn.setDao(dao);

			GtDTO gt = GtAtribuiValoresPadraoSalvar(rn, gtDTO, true, dao);
			GtDTO retorno = rn.setGTDTO(gt);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(GRUPOS_TRABALHO, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				gtDTO.setIdGt(retorno.getGt().getIdGt());
				gtDTO.setStRegistro(retorno.getGt().getStAtivo().intValue());
				String json = gson.toJson(gtDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/gts/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoGT(@Context HttpServletRequest request, GtDTO2 gtDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GTRN rn = new GTRN();
			rn.setDao(dao);

			GtDTO gt = GtAtribuiValoresPadraoSalvar(rn, gtDTO, false, dao);
			GtDTO retorno = rn.setGTDTO(gt);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(GRUPOS_TRABALHO, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				gtDTO.setIdGt(retorno.getGt().getIdGt());
				gtDTO.setStRegistro(retorno.getGt().getStAtivo().intValue());

				String json = gson.toJson(gtDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/gts/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarGT(@Context HttpServletRequest request, GtDTO2 gtDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GTRN rn = new GTRN();
			rn.setDao(dao);

			GtDTO gt = GtAtribuiValoresPadraoSalvar(rn, gtDTO, false, dao);

			GTsDTO gts = new GTsDTO();
			gts.setGts(new ArrayList<GtDTO>());
			gts.getGts().add(gt);

			GTsDTO retorno = rn.removeGTsDTO(gts);

			dao.commitaTransacao();
			
			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getGts().get(0).getResultadoEvento() != retorno.getGts().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(GRUPOS_TRABALHO, retorno.getGts().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					gtDTO.setIdGt(retorno.getGts().get(0).getGt().getIdGt());
					gtDTO.setStRegistro(retorno.getGts().get(0).getGt().getStAtivo().intValue());

					String json = gson.toJson(gtDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private GtDTO GtAtribuiValoresPadraoSalvar(GTRN rn, GtDTO2 gt, boolean isInclusao, DAOGenerico dao) {
		GtDTO gtSalvar = new GtDTO();

		OmGt gtRetorno = new OmGt();

		gtRetorno.setCdGt(gt.getCdGt());
		gtRetorno.setDsGt(gt.getDsGt());
		
		if (gt.getLayout() != null) {
		
			Set<OmObj> omobj = new HashSet<OmObj>();
			
			// Percorre lista de objs e atribui
			for (GtLayoutDTO obj : gt.getLayout()) {
				
				OmObj item = new OmObj();
				
				Integer x1 = obj.getX();
				Integer x2 = x1 + 48;
				Integer y1 = obj.getY();
				Integer y2 = y1 + 48;
				item.setX(ConversaoTipos.converteParaBigDecimal(x1.toString()));
				item.setY(ConversaoTipos.converteParaBigDecimal(y1.toString()));
				item.setX2(ConversaoTipos.converteParaBigDecimal(x2.toString()));
				item.setY2(ConversaoTipos.converteParaBigDecimal(y2.toString()));
				
				OmImg img = new OmImg();
				img.setCdImg(rn.CdPtNIDWToOmImg(obj.getIdImg()));
				item.setOmImg(img);
				item.setTpObj(OmObjTemplate.TpObj.TIPO_OBJ_PT.getValue());
				
				OmPtDAO pt = new OmPtDAO(dao.getSession()); 
				item.setOmPt(pt.getOmPtPorCdAtivoOrderById(obj.getCdPt()));
				
				omobj.add(item);
				
			}
			
			gtRetorno.setOmObjsForIdGt(omobj);			
			
		}
				
		
		gtRetorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		gtRetorno.setDtStativo(gtRetorno.getDtRevisao());

		if (!isInclusao) {
			OmGt gtUpd = getGtLocal(rn, gt.getCdGt());
			gtRetorno.setIdGt(gtUpd.getIdGt());
			gtRetorno.setRevisao(gtUpd.getRevisao());
			gtUpd = null;

		} else {
			gtRetorno.setRevisao(0l);
		}

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(gt.getCdUsrRev(), rn.getDao());
		gtRetorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		gtRetorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = getUsrLocal(gt.getCdUsrRev(), rn.getDao());
		gtRetorno.setOmUsrByIdUsrstativo(omusrStativo);

		OmCc omcc = new OmCc();
		omcc.setCdCc("");
		omcc.setDsCc("");
		gtRetorno.setOmCc(omcc);

		OmImg omimg = new OmImg();
		omimg.setCdImg("0");
		gtRetorno.setOmImg(omimg);

		OmTpgt omtpgt = new OmTpgt();
		omtpgt.setCdTpgt("1");
		gtRetorno.setOmTpgt(omtpgt);

		gtRetorno.setCor("");

		gtSalvar.setGt(new OmGt());
		gtSalvar.setGt(gtRetorno);

		gtRetorno = null;

		return gtSalvar;
	}

	// grupos de usuarios
	@GET
	@Path("/gruposacessousr")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGruposUsuariosAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GrupoUsuarioRN rn = new GrupoUsuarioRN();
			rn.setDao(dao);

			ListaGruposAcessoUsrDTO retornoConsulta = rn.getGruposUsrDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/gruposacessousr/{cdGrpUsr: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrupoUsuario(@Context HttpServletRequest request, @PathParam("cdGrpUsr") String cdGrpUsr) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			GrupoUsuarioRN rn = new GrupoUsuarioRN();
			rn.setDao(dao);

			GrupoUsrDTO retornoConsulta = rn.getGrpUsrByCd(cdGrpUsr);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// usuario
	@GET
	@Path("/usuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuariosAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			UsuarioRN rn = new UsuarioRN();
			rn.setDao(dao);

			ListaUsuariosDTO retorno = rn.getUsuariosDTO(filtro);

			dao.commitaTransacao();

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/usuarios/{cdUsr: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@Context HttpServletRequest request, @PathParam("cdUsr") String cdUsr) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			UsuarioRN rn = new UsuarioRN();
			rn.setDao(dao);

			UsrDTO retornoConsulta = rn.getUsrByCd(cdUsr);

			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/usuarios/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoUsr(@Context HttpServletRequest request, UsrDTO usrDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			UsuarioRN rn = new UsuarioRN();
			rn.setDao(dao);

			UsuarioDTO usr = UsuarioAtribuiValoresPadraoSalvar(rn, usrDTO, true);
			UsuarioDTO retorno = rn.setUsuarioDTO(usr);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(USUARIOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				usrDTO.setIdUsr(retorno.getUsuario().getIdUsr());
				usrDTO.setStRegistro(retorno.getUsuario().getStAtivo().intValue());
				usrDTO.setSenha(null);
				String json = gson.toJson(usrDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/usuarios/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoUsr(@Context HttpServletRequest request, UsrDTO usrDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			UsuarioRN rn = new UsuarioRN();
			rn.setDao(dao);

			UsuarioDTO usr = UsuarioAtribuiValoresPadraoSalvar(rn, usrDTO, false);
			UsuarioDTO retorno = rn.setUsuarioDTO(usr);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(USUARIOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				usrDTO.setIdUsr(retorno.getUsuario().getIdUsr());
				usrDTO.setStRegistro(retorno.getUsuario().getStAtivo().intValue());
				usrDTO.setSenha(null);
				String json = gson.toJson(usrDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/usuarios/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarUsuarios(@Context HttpServletRequest request, UsrDTO usrDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			UsuarioRN rn = new UsuarioRN();
			rn.setDao(dao);

			UsuarioDTO usr = UsuarioAtribuiValoresPadraoSalvar(rn, usrDTO, false);

			UsuariosDTO usrs = new UsuariosDTO();
			usrs.setUsuarios(new ArrayList<UsuarioDTO>());
			usrs.getUsuarios().add(usr);

			UsuariosDTO retorno = rn.removeUsuariosDTO(usrs);

			dao.commitaTransacao();
			
			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getUsuarios().get(0).getResultadoEvento() != retorno.getUsuarios().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(USUARIOS, retorno.getUsuarios().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					usrDTO.setIdUsr(retorno.getUsuarios().get(0).getUsuario().getIdUsr());
					usrDTO.setStRegistro(retorno.getUsuarios().get(0).getUsuario().getStAtivo().intValue());
					usrDTO.setSenha(null);

					String json = gson.toJson(usrDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private UsuarioDTO UsuarioAtribuiValoresPadraoSalvar(UsuarioRN rn, UsrDTO usrDTO, boolean isInclusao) {
		UsuarioDTO usrSalvar = new UsuarioDTO();

		OmUsr retorno = new OmUsr();

		retorno.setCdUsr(usrDTO.getCdUsr());
		retorno.setDsNome(usrDTO.getDsUsr());
		retorno.setLogin(usrDTO.getLogin());
		try {
			retorno.setSenha(HashMD5.getHashCode(usrDTO.getSenha()));
		} catch (DigestFileException e) {
			e.printStackTrace();
		}
		retorno.setUrlEmail(usrDTO.getEmail());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(usrDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = getUsrLocal(usrDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			OmUsr objUpd = getUsrLocal(usrDTO.getCdUsr(), rn.getDao());
			retorno.setIdUsr(objUpd.getIdUsr());

			retorno.setRevisao(objUpd.getRevisao());
			objUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		OmUsrgrp grpUsu = new OmUsrgrp();
		grpUsu.setCdUsrgrp(usrDTO.getCdUsrGrp());
		retorno.setOmUsrgrp(grpUsu);

		OmGt gt = new OmGt();
		gt.setCdGt(usrDTO.getCdGt());
		retorno.setOmGt(gt);

		OmCargo cargo = new OmCargo();
		cargo.setCdCargo(usrDTO.getCdCargo());
		retorno.setOmCargo(cargo);

		usrSalvar.setUsuario(new OmUsr());
		usrSalvar.setUsuario(retorno);

		retorno = null;

		return usrSalvar;
	}

	// produto
	@GET
	@Path("/produtos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdutosAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ProdutoRN rn = new ProdutoRN();
			rn.setDao(dao);

			ListaProdutosDTO retornoConsulta = rn.getProdutosDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/produtos/{cdProduto: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduto(@Context HttpServletRequest request, @PathParam("cdProduto") String cdProduto) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ProdutoRN rn = new ProdutoRN();
			rn.setDao(dao);

			ProdutoDTO2 retornoConsulta = rn.getProdutoByCd(cdProduto);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/produtos/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoProduto(@Context HttpServletRequest request, ProdutoDTO2 proDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ProdutoRN rn = new ProdutoRN();
			rn.setDao(dao);

			ProdutoDTO pro = ProdutoAtribuiValoresPadraoSalvar(rn, proDTO, true);
			ProdutoDTO retorno = rn.setProdutoDTO(pro);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;

				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(PRODUTOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				proDTO.setIdProduto(retorno.getProduto().getIdProduto());
				proDTO.setStRegistro(retorno.getProduto().getStAtivo().intValue());
				String json = gson.toJson(proDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/produtos/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoProduto(@Context HttpServletRequest request, ProdutoDTO2 prodDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ProdutoRN rn = new ProdutoRN();
			rn.setDao(dao);

			ProdutoDTO pro = ProdutoAtribuiValoresPadraoSalvar(rn, prodDTO, false);
			ProdutoDTO retorno = rn.setProdutoDTO(pro);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
			
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(PRODUTOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				prodDTO.setIdProduto(retorno.getProduto().getIdProduto());
				prodDTO.setStRegistro(retorno.getProduto().getStAtivo().intValue());
				String json = gson.toJson(prodDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/produtos/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarProduto(@Context HttpServletRequest request, ProdutoDTO2 proDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ProdutoRN rn = new ProdutoRN();
			rn.setDao(dao);

			ProdutoDTO pro = ProdutoAtribuiValoresPadraoDesativar(rn, proDTO);
			ProdutosDTO pros = new ProdutosDTO();
			pros.setProdutos(new ArrayList<ProdutoDTO>());
			pros.getProdutos().add(pro);

			ProdutosDTO retorno = rn.removeProdutosDTO(pros);

			dao.commitaTransacao();
			
			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getProdutos().get(0).getResultadoEvento() != retorno.getProdutos().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(PRODUTOS, retorno.getProdutos().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					proDTO.setIdProduto(retorno.getProdutos().get(0).getProduto().getIdProduto());
					proDTO.setStRegistro(retorno.getProdutos().get(0).getProduto().getStAtivo().intValue());

					String json = gson.toJson(proDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private ProdutoDTO ProdutoAtribuiValoresPadraoSalvar(ProdutoRN rn, ProdutoDTO2 proDTO, boolean isInclusao) {
		ProdutoDTO objSalvar = new ProdutoDTO();

		OmProduto retorno = new OmProduto();

		retorno.setCdProduto(proDTO.getCdProduto());
		retorno.setDsProduto(proDTO.getDsProduto());
		retorno.setTpProduto((byte) 0);
		retorno.setTpClasseabc(rn.getClasseValue(proDTO.getClasseABC()));
		retorno.setVlCustounit(ConversaoTipos.converterParaBigDecimal(proDTO.getCustoUnitario()).setScale(3, RoundingMode.HALF_UP));
		retorno.setGPesoBruto(ConversaoTipos.converterParaBigDecimal(proDTO.getPesoBruto()).setScale(3, RoundingMode.HALF_UP));
		retorno.setGPesoLiquido(ConversaoTipos.converterParaBigDecimal(proDTO.getPesoLiquido()).setScale(3, RoundingMode.HALF_UP));

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(proDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = getUsrLocal(proDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			OmProduto objUpd = getProdutoLocal(rn, proDTO.getCdProduto());
			retorno.setIdProduto(objUpd.getIdProduto());
			retorno.setRevisao(objUpd.getRevisao());
			objUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		PpCliente cliente = new PpCliente();
		cliente.setCdCliente(proDTO.getCdCliente());
		retorno.setPpCliente(cliente);

		OmCc omcc = new OmCc();
		omcc.setCdCc("");
		omcc.setDsCc("");
		retorno.setOmCc(omcc);

		OmFor omfor = new OmFor();
		omfor.setCdFor("");
		omfor.setNmFornecedor("");
		retorno.setOmFor(omfor);

		objSalvar.setProduto(new OmProduto());
		objSalvar.setProduto(retorno);

		retorno = null;

		return objSalvar;
	}

	private ProdutoDTO ProdutoAtribuiValoresPadraoDesativar(ProdutoRN rn, ProdutoDTO2 proDTO) {
		ProdutoDTO objSalvar = new ProdutoDTO();

		OmProduto retorno = new OmProduto();

		retorno.setCdProduto(proDTO.getCdProduto());
		retorno.setTpProduto((byte) 0);

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(proDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = getUsrLocal(proDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		OmProduto objUpd = getProdutoLocal(rn, proDTO.getCdProduto());
		retorno.setIdProduto(objUpd.getIdProduto());
		retorno.setRevisao(objUpd.getRevisao());
		objUpd = null;

		/*
		 * PpCliente cliente = new PpCliente(); cliente.setCdCliente(proDTO.getCdCliente()); retorno.setPpCliente(cliente);
		 */

		OmCc omcc = new OmCc();
		omcc.setCdCc("");
		omcc.setDsCc("");
		retorno.setOmCc(omcc);

		OmFor omfor = new OmFor();
		omfor.setCdFor("");
		omfor.setNmFornecedor("");
		retorno.setOmFor(omfor);

		objSalvar.setProduto(new OmProduto());
		objSalvar.setProduto(retorno);

		retorno = null;

		return objSalvar;
	}
	
	// pts
	@GET
	@Path("/pts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPTsAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			PTRN rn = new PTRN();
			rn.setDao(dao);

			ListaPTsDTO retornoConsulta = rn.getPtsDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/pts/{cdPt: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPT(@Context HttpServletRequest request, @PathParam("cdPt") String cdPt) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			PTRN rn = new PTRN();
			rn.setDao(dao);

			PtDTO2 retornoConsulta = rn.getPtByCd(cdPt);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	// incluir
	@POST
	@Path("/pts/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoPT(@Context HttpServletRequest request, PtDTO2 ptDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			setMsUsrFromOmUsr(dao, ptDTO.getCdUsrRev());
			
			PTRN rn = new PTRN();
			rn.setDao(dao);

			UpRN rnUp = new UpRN();
			rnUp.setDaoPdba(dao);

			PtDTO pt = PtAtribuiValoresPadraoSalvar(rn, ptDTO, true);
			UpDTO up = UpAtribuiValoresPadraoSalvar(rnUp, ptDTO, dao);

			PtDTO retorno = rn.setPtDTO(pt);

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				
				dao.rollbackTransacao();
				
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(POSTOS_TRABALHO, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
				
			} else {
				ptDTO.setIdPt(retorno.getPt().getIdPt());
				ptDTO.setStRegistro(retorno.getPt().getStAtivo().intValue());
				String json = gson.toJson(ptDTO);

				// salva up
				ListaUPDTO retornoUp = null;
				rnUp.setUpDTO(up);

				try {
					// retornoUp = rnUp.salvarUpDTOSemMsUsr();
					
					retornoUp = rnUp.salvarUpDTO();
					
					if (!retornoUp.getResultadoDTO().isComSucesso()) {
						dao.rollBackTransacaoSemException();
						
						responseStatus = Response.Status.BAD_REQUEST;
						
						String codigoErro = CodigoErro(UPS, retornoUp.getResultadoDTO().getIdMensagem());
						ErrorDTO2 error = new ErrorDTO2(codigoErro);
						
						String json2 = gson.toJson(error);
						return Response.status(responseStatus).entity(json2).build();

					} else {
						dao.commitaTransacao();
					}

				} catch (Exception e) {
					dao.rollBackTransacaoSemException();
					responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
					ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
					throw new ResourceWebApplicationException(responseStatus, error);
				}

				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/pts/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoPT(@Context HttpServletRequest request, PtDTO2 ptDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			setMsUsrFromOmUsr(dao, ptDTO.getCdUsrRev());
			
			PTRN rn = new PTRN();
			rn.setDao(dao);

			PtDTO pt = PtAtribuiValoresPadraoSalvar(rn, ptDTO, false);
			PtDTO retorno = rn.setPtDTO(pt);

			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(POSTOS_TRABALHO, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
				
			} else {
				ptDTO.setIdPt(retorno.getPt().getIdPt());
				ptDTO.setStRegistro(retorno.getPt().getStAtivo().intValue());
				String json = gson.toJson(ptDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/pts/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarPT(@Context HttpServletRequest request, PtDTO2 ptDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			setMsUsrFromOmUsr(dao, ptDTO.getCdUsrRev());

			PTRN rn = new PTRN();
			rn.setDao(dao);

			UpRN rnUp = new UpRN();
			rnUp.setDaoPdba(dao);

			PtDTO pt = PtAtribuiValoresPadraoExcluir(rn, ptDTO);
			UpDTO up = UpAtribuiValoresPadraoExcluir(rnUp, ptDTO);

			PTsDTO pts = new PTsDTO();
			pts.setPts(new ArrayList<PtDTO>());
			pts.getPts().add(pt);

			// tem que desativar up antes de desativar pt
			ListaUPDTO retornoUp = null;
			rnUp.setUpDTO(up);
			// retornoUp = rnUp.removeUpDTO();
			retornoUp = rnUp.removeUpDTOSemTransacao();
			
			if (retornoUp == null) {
				throw new JsonException("Error");
				
			} else {
				// dao.commitaTransacao();
				
				if (!retornoUp.getResultadoDTO().isComSucesso()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(UPS, retornoUp.getResultadoDTO().getIdMensagem());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json2 = gson.toJson(error);
					return Response.status(responseStatus).entity(json2).build();
					
				} else {
					// desativa pt

					/*
					// Sessao fechada. Tem que abrir de novo
					dao.finalizaSessao();
					dao.iniciaSessao();
					dao.iniciaTransacao();
					*/
					
					rn = new PTRN();
					rn.setDao(dao);

					PtExcDTO ptExc = new PtExcDTO();

					try {
						PTsDTO retorno = rn.removePTsDTO(pts);
						
						// dao.commitaTransacao();

						// if (retorno.getPts() == null) {
						if (retorno.getPts().get(0).getPt() == null) {
							
							dao.rollBackTransacaoSemException();
							
							responseStatus = Response.Status.BAD_REQUEST;
							
							// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
							String codigoErro = CodigoErro(POSTOS_TRABALHO, retorno.getPts().get(0).getResultadoEvento());
							ErrorDTO2 error = new ErrorDTO2(codigoErro);
							
							String json2 = gson.toJson(error);
							return Response.status(responseStatus).entity(json2).build();
							
						} else {
							dao.commitaTransacao();
							
							ptExc.setIdPt(retorno.getPts().get(0).getPt().getIdPt());
							ptExc.setCdPt(retorno.getPts().get(0).getPt().getCdPt());
							ptExc.setCdUsrRev(ptDTO.getCdUsrRev());
							ptExc.setStRegistro(0);
						}

					} catch (Exception e) {
						dao.rollBackTransacaoSemException();
						responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
						ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
						throw new ResourceWebApplicationException(responseStatus, error);
					}

					String json = gson.toJson(ptExc);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private PtDTO PtAtribuiValoresPadraoSalvar(PTRN rn, PtDTO2 ptDTO, boolean isInclusao) {
		PtDTO objSalvar = new PtDTO();

		OmPt retorno = new OmPt();

		retorno.setCdPt(ptDTO.getCdPt());
		retorno.setDsPt(ptDTO.getDsPt());
		retorno.setDsCurta(ptDTO.getDsCurta());
		retorno.setTpSessao(((Integer) ptDTO.getSessaoCLP()).byteValue());
		retorno.setDsSessao(rn.getDsSessao(retorno.getTpSessao()));
		retorno.setTpClasseabc(rn.getClasseValue(ptDTO.getClasseABC()));
		retorno.setIsParadaFechaciclo(ptDTO.isParadaFechaCiclo());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(ptDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = getUsrLocal(ptDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		retorno.setOrdemnogt(0);
		retorno.setUrlConexao("");
		retorno.setUrlImpressoracb("");
		retorno.setUrlImpressoradoc("");
		retorno.setDepara("");
		retorno.setTpImpprog((byte) 0);

		if (!isInclusao) {
			OmPt objUpd = getPtLocal(rn, ptDTO.getCdPt());
			retorno.setIdPt(objUpd.getIdPt());
			retorno.setRevisao(objUpd.getRevisao());
			objUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		/*
		 * OmCc omcc = new OmCc(); omcc.setCdCc(""); omcc.setDsCc(""); retorno.setOmCc(omcc);
		 */

		OmGt gt = new OmGt();
		gt.setCdGt(ptDTO.getCdGt());
		retorno.setOmGt(gt);

		OmTppt tppt = new OmTppt();
		tppt.setCdTppt("CIC");
		retorno.setOmTppt(tppt);

		objSalvar.setPt(new OmPt());
		objSalvar.setPt(retorno);

		retorno = null;

		return objSalvar;
	}

	private PtDTO PtAtribuiValoresPadraoExcluir(PTRN rn, PtDTO2 ptDTO) {
		PtDTO objSalvar = new PtDTO();

		OmPt retorno = new OmPt();

		retorno.setCdPt(ptDTO.getCdPt());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(ptDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = getUsrLocal(ptDTO.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		OmPt objUpd = getPtLocal(rn, ptDTO.getCdPt());
		retorno.setIdPt(objUpd.getIdPt());
		retorno.setRevisao(objUpd.getRevisao());
		objUpd = null;

		objSalvar.setPt(new OmPt());
		objSalvar.setPt(retorno);

		retorno = null;

		return objSalvar;
	}
	
	private UpDTO UpAtribuiValoresPadraoSalvar(UpRN rn, PtDTO2 ptDTO, DAOGenerico dao) {
		UsuarioRN rnU = new UsuarioRN();
		rnU.setDao(dao);
		
		OmUsr usr = null;
		try {
			usr = rnU.getOmUsr(ptDTO.getCdUsrRev());
		} catch (RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		UpDTO objSalvar = new UpDTO();
		

		objSalvar.setCd_up(ptDTO.getCdPt());
		objSalvar.setDs_up(ptDTO.getDsPt());
		objSalvar.setCdBc("");
		objSalvar.setRevisao(BigDecimal.ONE);
		objSalvar.setStAtivo(BigDecimal.ONE);
		objSalvar.setIdTppt(1L);

		objSalvar.setDthrRevisao(DataHoraRN.getDataHoraAtual());
		objSalvar.setDthrStativo(objSalvar.getDthrRevisao());

		objSalvar.setLoginUsuario(usr.getLogin());
		
		rnU = null;

		return objSalvar;
	}

	private UpDTO UpAtribuiValoresPadraoExcluir(UpRN rn, PtDTO2 ptDTO) {
		UpDTO objSalvar = new UpDTO();

		objSalvar.setCd_up(ptDTO.getCdPt());
		objSalvar.setDs_up(ptDTO.getDsPt());
		objSalvar.setCdBc("");
		objSalvar.setRevisao(BigDecimal.ONE);
		objSalvar.setStAtivo(BigDecimal.ONE);
		objSalvar.setIdTppt(1L);

		objSalvar.setDthrRevisao(DataHoraRN.getDataHoraAtual());
		objSalvar.setDthrStativo(objSalvar.getDthrRevisao());

		objSalvar.setLoginUsuario(ptDTO.getCdUsrRev());

		MsUp objUpd = null;
		try {
			objUpd = rn.pesquisaUmMsUpPorCdUp(ptDTO.getCdPt());
		} catch (injetws.model.excessoes.RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objSalvar.setIdUp(objUpd.getIdUp());
		objSalvar.setRevisao(objUpd.getRevisao());
		objUpd = null;

		return objSalvar;
	}

	// causas
	@GET
	@Path("/causas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCausasAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CausaRN rn = new CausaRN();
			rn.setDao(dao);

			ListaCausasDTO retornoConsulta = rn.getCausasDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/causas/{cdCausa: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCausa(@Context HttpServletRequest request, @PathParam("cdCausa") String cdCausa) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CausaRN rn = new CausaRN();
			rn.setDao(dao);

			CausaDTO retornoConsulta = rn.getCausaByCd(cdCausa);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/causas/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovaCausa(@Context HttpServletRequest request, CausaDTO causaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CausaRN rn = new CausaRN();
			rn.setDao(dao);

			DwTCausaDTO causa = CausaAtribuiValoresPadraoSalvar(rn, causaDTO, true);
			DwTCausaDTO retorno = rn.setTCausa(causa);

			dao.commitaTransacao();

			if (retorno.getResultado().getIdmensagem() != retorno.getResultado().ERRO_DESCONHECIDO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(CAUSAS, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				causaDTO.setIdCausa(retorno.getDwTCausa().getIdTcausa());
				causaDTO.setStRegistro(retorno.getDwTCausa().getStAtivo().intValue());
				String json = gson.toJson(causaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/causas/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoCausa(@Context HttpServletRequest request, CausaDTO causaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CausaRN rn = new CausaRN();
			rn.setDao(dao);

			DwTCausaDTO causa = CausaAtribuiValoresPadraoSalvar(rn, causaDTO, false);
			DwTCausaDTO retorno = rn.setTCausa(causa);

			dao.commitaTransacao();

			if (retorno.getResultado().getIdmensagem() != retorno.getResultado().ERRO_DESCONHECIDO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(CAUSAS, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				causaDTO.setIdCausa(retorno.getDwTCausa().getIdTcausa());
				causaDTO.setStRegistro(retorno.getDwTCausa().getStAtivo().intValue());

				String json = gson.toJson(causaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/causas/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarCausa(@Context HttpServletRequest request, CausaDTO causaDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CausaRN rn = new CausaRN();
			rn.setDao(dao);

			DwTCausaDTO causa = CausaAtribuiValoresPadraoSalvar(rn, causaDTO, false);

			DwTCausasDTO causas = new DwTCausasDTO();
			causas.setListaCausasDTO(new ArrayList<DwTCausaDTO>());
			causas.getListaCausasDTO().add(causa);

			DwTCausasDTO retorno = rn.removeTCausa(causas);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");

			} else {
				if (retorno.getListaCausasDTO().get(0).getResultado().getIdmensagem() != retorno.getListaCausasDTO().get(0).getResultado().ERRO_DESCONHECIDO) {
					responseStatus = Response.Status.BAD_REQUEST;

					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(CAUSAS, retorno.getListaCausasDTO().get(0).getResultado().getIdmensagem());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					causaDTO.setIdCausa(retorno.getListaCausasDTO().get(0).getDwTCausa().getIdTcausa());
					causaDTO.setStRegistro(0);

					String json = gson.toJson(causaDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private DwTCausaDTO CausaAtribuiValoresPadraoSalvar(CausaRN rn, CausaDTO causa, boolean isInclusao) {
		DwTCausaDTO causaSalvar = new DwTCausaDTO();

		DwTCausa retorno = new DwTCausa();

		retorno.setCdTcausa(causa.getCdCausa());
		retorno.setDsTcausa(causa.getDsCausa());

		OmTppt tppt = new OmTppt();
		tppt.setCdTppt("CIC");
		retorno.setOmTppt(tppt);

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(causa.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwTCausa regUpd = getCausaLocal(rn, causa.getCdCausa());
			retorno.setIdTcausa(regUpd.getIdTcausa());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		causaSalvar.setDwTCausa(new DwTCausa());
		causaSalvar.setDwTCausa(retorno);

		retorno = null;

		return causaSalvar;
	}

	// ações
	@GET
	@Path("/acoes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAcoesAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TAcaoRN rn = new TAcaoRN();
			rn.setDao(dao);

			ListaAcoesDTO retornoConsulta = rn.getAcoesDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/acoes/{cdAcao: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAcao(@Context HttpServletRequest request, @PathParam("cdAcao") String cdAcao) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TAcaoRN rn = new TAcaoRN();
			rn.setDao(dao);

			AcaoDTO2 retornoConsulta = rn.getAcaoByCd(cdAcao);
			dao.commitaTransacao();			
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());			

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/acoes/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovaAcao(@Context HttpServletRequest request, AcaoDTO2 acaoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TAcaoRN rn = new TAcaoRN();
			rn.setDao(dao);

			TAcaoDTO acao = AcaoAtribuiValoresPadraoSalvar(rn, acaoDTO, true);
			TAcaoDTO retorno = rn.setTAcaoDTO(acao);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(ACOES, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				acaoDTO.setIdAcao(retorno.getAcao().getIdTacao());
				acaoDTO.setStRegistro(retorno.getAcao().getStAtivo().intValue());
				acaoDTO.setRevisao(retorno.getAcao().getRevisao());

				String json = gson.toJson(acaoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// alterar
	@PUT
	@Path("/acoes/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoAcao(@Context HttpServletRequest request, AcaoDTO2 acaoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TAcaoRN rn = new TAcaoRN();
			rn.setDao(dao);

			// Necessário pegar a "revisao" aqui
			AcaoDTO2 consulta = rn.getAcaoByCd(acaoDTO.getCdAcao());
			acaoDTO.setRevisao(consulta.getRevisao());

			TAcaoDTO acao = AcaoAtribuiValoresPadraoSalvar(rn, acaoDTO, false);
			TAcaoDTO retorno = rn.setTAcaoDTO(acao);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(ACOES, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				acaoDTO.setIdAcao(retorno.getAcao().getIdTacao());
				acaoDTO.setStRegistro(retorno.getAcao().getStAtivo().intValue());
				acaoDTO.setRevisao(retorno.getAcao().getRevisao());

				String json = gson.toJson(acaoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/acoes/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarAcao(@Context HttpServletRequest request, AcaoDTO2 acaoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			TAcaoRN rn = new TAcaoRN();
			rn.setDao(dao);

			TAcaoDTO acao = AcaoAtribuiValoresPadraoSalvar(rn, acaoDTO, false);

			TAcoesDTO acoes = new TAcoesDTO();
			acoes.setAcoes(new ArrayList<TAcaoDTO>());
			acoes.getAcoes().add(acao);

			TAcoesDTO retorno = rn.removeTAcoesDTO(acoes);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");

			} else {
				if (retorno.getAcoes().get(0).getResultadoEvento() != retorno.getAcoes().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(ACOES, retorno.getAcoes().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					acaoDTO.setIdAcao(retorno.getAcoes().get(0).getAcao().getIdTacao());
					acaoDTO.setStRegistro(0);
					acaoDTO.setRevisao(retorno.getAcoes().get(0).getAcao().getRevisao());

					String json = gson.toJson(acaoDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private TAcaoDTO AcaoAtribuiValoresPadraoSalvar(TAcaoRN rn, AcaoDTO2 acao, boolean isInclusao) {
		TAcaoDTO acaoSalvar = new TAcaoDTO();

		DwTAcao retorno = new DwTAcao();

		// Foi necessário colocar nesse cadastro o "id" aqui nesse ponto
		retorno.setIdTacao(acao.getIdAcao() == null ? 0 : acao.getIdAcao());

		retorno.setCdTacao(acao.getCdAcao());
		retorno.setDsTacao(acao.getDsAcao());

		OmTppt tppt = new OmTppt();
		tppt.setCdTppt("CIC");
		retorno.setOmTppt(tppt);

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(acao.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwTAcao regUpd = getAcaoLocal(rn, acao.getCdAcao());
			retorno.setIdTacao(regUpd.getIdTacao());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;
		} else {
			retorno.setRevisao(0l);
		}

		acaoSalvar.setAcao(new DwTAcao());
		acaoSalvar.setAcao(retorno);

		retorno = null;

		return acaoSalvar;
	}

	// justificativas
	@GET
	@Path("/justificativas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJustificativasAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			JustificativaRN rn = new JustificativaRN();
			rn.setDao(dao);

			ListaJustificativasDTO retornoConsulta = rn.getJustificativasDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/justificativas/{cdJustificativa: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJustificativa(@Context HttpServletRequest request, @PathParam("cdJustificativa") String cdJustificativa) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			JustificativaRN rn = new JustificativaRN();
			rn.setDao(dao);

			JustificativaDTO retornoConsulta = rn.getJustificativaByCd(cdJustificativa);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/justificativas/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovaJustificativa(@Context HttpServletRequest request, JustificativaDTO justificativaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {

			dao.iniciaSessao();
			dao.iniciaTransacao();

			JustificativaRN rn = new JustificativaRN();
			rn.setDao(dao);

			DwTJustDTO justificativa = JustificativaAtribuiValoresPadraoSalvar(rn, justificativaDTO, true);
			DwTJustDTO retorno = rn.setTJustificativa(justificativa);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(JUSTIFICATIVAS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				justificativaDTO.setIdJustificativa(retorno.getDwTJust().getIdTjust());
				justificativaDTO.setStRegistro(retorno.getDwTJust().getStAtivo().intValue());
				String json = gson.toJson(justificativaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// alterar
	@PUT
	@Path("/justificativas/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoJustificativa(@Context HttpServletRequest request, JustificativaDTO justificativaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			JustificativaRN rn = new JustificativaRN();
			rn.setDao(dao);

			DwTJustDTO justificativa = JustificativaAtribuiValoresPadraoSalvar(rn, justificativaDTO, false);
			DwTJustDTO retorno = rn.setTJustificativa(justificativa);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(JUSTIFICATIVAS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				justificativaDTO.setIdJustificativa(retorno.getDwTJust().getIdTjust());
				justificativaDTO.setStRegistro(retorno.getDwTJust().getStAtivo().intValue());

				String json = gson.toJson(justificativaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// justificativas (desativar)
	@PUT
	@Path("/justificativas/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarJustificativa(@Context HttpServletRequest request, JustificativaDTO justificativaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			JustificativaRN rn = new JustificativaRN();
			rn.setDao(dao);

			DwTJustDTO justificativa = JustificativaAtribuiValoresPadraoSalvar(rn, justificativaDTO, false);

			DwTJustsDTO justificativas = new DwTJustsDTO();
			justificativas.setListaJustsDTO(new ArrayList<DwTJustDTO>());
			justificativas.getListaJustsDTO().add(justificativa);

			DwTJustsDTO retorno = rn.removeTJustificativa(justificativas);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");

			} else {
				if (retorno.getListaJustsDTO().get(0).getResultadoEvento() != retorno.getListaJustsDTO().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;

					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(JUSTIFICATIVAS, retorno.getListaJustsDTO().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					justificativaDTO.setIdJustificativa(retorno.getListaJustsDTO().get(0).getDwTJust().getIdTjust());
					justificativaDTO.setStRegistro(0);

					String json = gson.toJson(justificativaDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private DwTJustDTO JustificativaAtribuiValoresPadraoSalvar(JustificativaRN rn, JustificativaDTO justificativa, boolean isInclusao) {
		DwTJustDTO justificativaSalvar = new DwTJustDTO();

		DwTJust retorno = new DwTJust();

		retorno.setCdTjust(justificativa.getCdJustificativa());
		retorno.setDsTjust(justificativa.getDsJustificativa());

		OmTppt tppt = new OmTppt();
		tppt.setCdTppt("CIC");
		retorno.setOmTppt(tppt);

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(justificativa.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwTJust regUpd = getJustificativaLocal(rn, justificativa.getCdJustificativa());
			retorno.setIdTjust(regUpd.getIdTjust());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;
		} else {
			retorno.setRevisao(0l);
		}

		justificativaSalvar.setDwTJust(new DwTJust());
		justificativaSalvar.setDwTJust(retorno);

		retorno = null;

		return justificativaSalvar;
	}

	// áreas responsáveis
	@GET
	@Path("/areasresponsaveis")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAreasResponsaveisAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AreaRN rn = new AreaRN();
			rn.setDao(dao);

			ListaAreaRespDTO retornoConsulta = rn.getAreasResponsaveisDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta); 

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/areasresponsaveis/{cdAreaResponsavel: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAreaResponsavel(@Context HttpServletRequest request, @PathParam("cdAreaResponsavel") String cdAreaResponsavel) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AreaRN rn = new AreaRN();
			rn.setDao(dao);

			AreaResponsavelDTO retornoConsulta = rn.getAreaResponsavelByCd(cdAreaResponsavel);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/areasresponsaveis/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovaAreaResponsavel(@Context HttpServletRequest request, AreaResponsavelDTO areaResponsavelDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AreaRN rn = new AreaRN();
			rn.setDao(dao);

			DwTAreaDTO areaResponsavel = AreaResponsavelAtribuiValoresPadraoSalvar(rn, areaResponsavelDTO, true);
			DwTAreaDTO retorno = rn.setTArea(areaResponsavel);

			long idAreaResponsavel = rn.getAreaResponsavelByCd(areaResponsavelDTO.getCdAreaResponsavel()).getIdAreaResponsavel();
			retorno.getDwTArea().setIdArea(idAreaResponsavel);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(AREAS_RESPONSAVEIS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				areaResponsavelDTO.setIdAreaResponsavel(retorno.getDwTArea().getIdArea());
				areaResponsavelDTO.setStRegistro(retorno.getDwTArea().getStAtivo().intValue());
				String json = gson.toJson(areaResponsavelDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// alterar
	@PUT
	@Path("/areasresponsaveis/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoAreaResponsavel(@Context HttpServletRequest request, AreaResponsavelDTO areaResponsavelDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AreaRN rn = new AreaRN();
			rn.setDao(dao);

			DwTAreaDTO areaResponsavel = AreaResponsavelAtribuiValoresPadraoSalvar(rn, areaResponsavelDTO, false);
			DwTAreaDTO retorno = rn.setTArea(areaResponsavel);

			long idAreaResponsavel = rn.getAreaResponsavelByCd(areaResponsavelDTO.getCdAreaResponsavel()).getIdAreaResponsavel();
			retorno.getDwTArea().setIdArea(idAreaResponsavel);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(AREAS_RESPONSAVEIS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				areaResponsavelDTO.setIdAreaResponsavel(retorno.getDwTArea().getIdArea());
				areaResponsavelDTO.setStRegistro(retorno.getDwTArea().getStAtivo().intValue());

				String json = gson.toJson(areaResponsavelDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/areasresponsaveis/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarAreaResponsavel(@Context HttpServletRequest request, AreaResponsavelDTO areaResponsavelDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AreaRN rn = new AreaRN();
			rn.setDao(dao);

			DwTAreaDTO areaResponsavel = AreaResponsavelAtribuiValoresPadraoSalvar(rn, areaResponsavelDTO, false);

			DwTAreasDTO areasResponsaveis = new DwTAreasDTO();
			areasResponsaveis.setListaAreasDTO(new ArrayList<DwTAreaDTO>());
			areasResponsaveis.getListaAreasDTO().add(areaResponsavel);

			DwTAreasDTO retorno = rn.removeTArea(areasResponsaveis);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getListaAreasDTO().get(0).getResultadoEvento() != retorno.getListaAreasDTO().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(AREAS_RESPONSAVEIS, retorno.getListaAreasDTO().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					areaResponsavelDTO.setIdAreaResponsavel(retorno.getListaAreasDTO().get(0).getDwTArea().getIdArea());
					areaResponsavelDTO.setStRegistro(0);

					String json = gson.toJson(areaResponsavelDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private DwTAreaDTO AreaResponsavelAtribuiValoresPadraoSalvar(AreaRN rn, AreaResponsavelDTO areaResponsavel, boolean isInclusao) {
		DwTAreaDTO areaResponsavelSalvar = new DwTAreaDTO();

		DwTArea retorno = new DwTArea();

		retorno.setCdArea(areaResponsavel.getCdAreaResponsavel());
		retorno.setDsArea(areaResponsavel.getDsAreaResponsavel());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(areaResponsavel.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwTArea regUpd = getAreaResponsavelLocal(rn, areaResponsavel.getCdAreaResponsavel());
			retorno.setIdArea(regUpd.getIdArea());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;
		} else {
			retorno.setRevisao(0l);
		}

		areaResponsavelSalvar.setDwTArea(new DwTArea());
		areaResponsavelSalvar.setDwTArea(retorno);

		retorno = null;

		return areaResponsavelSalvar;
	}

	// alertas
	@GET
	@Path("/alertas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlertasAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AlertaRN rn = new AlertaRN();
			rn.setDao(dao);

			ListaAlertasDTO retornoConsulta = rn.getAlertasDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/alertas/{cdAlerta: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlerta(@Context HttpServletRequest request, @PathParam("cdAlerta") String cdAlerta) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AlertaRN rn = new AlertaRN();
			rn.setDao(dao);

			AlertaDTO2 retornoConsulta = rn.getAlertaByCd(cdAlerta);

			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/alertas/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoAlerta(@Context HttpServletRequest request, AlertaDTO2 alertaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AlertaRN rn = new AlertaRN();
			rn.setDao(dao);

			AlertaDTO alerta = AlertaAtribuiValoresPadraoSalvar(rn, alertaDTO, true);
			AlertaDTO retorno = rn.setTAlertaDTO(alerta);

			dao.commitaTransacao();

			if (retorno.getResultado().getIdmensagem() != retorno.getResultado().ERRO_DESCONHECIDO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(ALERTAS, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				alertaDTO.setIdAlerta(retorno.getDwTAlerta().getIdTalerta());
				alertaDTO.setStRegistro(retorno.getDwTAlerta().getStAtivo().intValue());

				String json = gson.toJson(alertaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// alterar
	@PUT
	@Path("/alertas/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoAlerta(@Context HttpServletRequest request, AlertaDTO2 alertaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AlertaRN rn = new AlertaRN();
			rn.setDao(dao);

			AlertaDTO alerta = AlertaAtribuiValoresPadraoSalvar(rn, alertaDTO, false);
			AlertaDTO retorno = rn.setTAlertaDTO(alerta);

			dao.commitaTransacao();

			if (retorno.getResultado().getIdmensagem() != retorno.getResultado().ERRO_DESCONHECIDO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(ALERTAS, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				alertaDTO.setIdAlerta(retorno.getDwTAlerta().getIdTalerta());
				alertaDTO.setStRegistro(retorno.getDwTAlerta().getStAtivo().intValue());

				String json = gson.toJson(alertaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/alertas/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarAlerta(@Context HttpServletRequest request, AlertaDTO2 alertaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AlertaRN rn = new AlertaRN();
			rn.setDao(dao);

			AlertaDTO alerta = AlertaAtribuiValoresPadraoSalvar(rn, alertaDTO, false);

			AlertasDTO alertas = new AlertasDTO();
			alertas.setListaAlertasDTO(new ArrayList<AlertaDTO>());
			alertas.getListaAlertasDTO().add(alerta);

			AlertasDTO retorno = rn.removeTAlertasDTO(alertas);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");

			} else {
				if (retorno.getListaAlertasDTO().get(0).getResultado().getIdmensagem() != retorno.getListaAlertasDTO().get(0).getResultado().ERRO_DESCONHECIDO) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(ALERTAS, retorno.getListaAlertasDTO().get(0).getResultado().getIdmensagem());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					alertaDTO.setIdAlerta(retorno.getListaAlertasDTO().get(0).getDwTAlerta().getIdTalerta());
					alertaDTO.setStRegistro(0);
					
					String json = gson.toJson(alertaDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private AlertaDTO AlertaAtribuiValoresPadraoSalvar(AlertaRN rn, AlertaDTO2 alerta, boolean isInclusao) {
		AlertaDTO alertaSalvar = new AlertaDTO();

		DwTAlerta retorno = new DwTAlerta();

		retorno.setCdTalerta(alerta.getCdAlerta());
		retorno.setDsTalerta(alerta.getDsAlerta());
		retorno.setIsTimeout(alerta.isTimeout());
		retorno.setIsAutomatico(alerta.isAutomatico());

		OmTppt tppt = new OmTppt();
		tppt.setCdTppt("CIC");
		retorno.setOmTppt(tppt);

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(alerta.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwTAlerta regUpd = getAlertaLocal(rn, alerta.getCdAlerta());
			retorno.setIdTalerta(regUpd.getIdTalerta());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;
		} else {
			retorno.setRevisao(0l);
		}

		alertaSalvar.setDwTAlerta(new DwTAlerta());
		alertaSalvar.setDwTAlerta(retorno);

		retorno = null;

		return alertaSalvar;
	}

	// ICs
	@GET
	@Path("/ics")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIcsAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IcRN rn = new IcRN(dao);
			// rn.setDao(dao);

			ListaICsDTO retornoConsulta = rn.getICsDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/ics/{cdIc: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIc(@Context HttpServletRequest request, @PathParam("cdIc") String cdIc) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IcRN rn = new IcRN(dao); 
			
			IcDTO2 retornoConsulta = rn.getICByCd(cdIc);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/ics/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoIC(@Context HttpServletRequest request, IcDTO2 ic) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IcRN rn = new IcRN(dao);
			// rn.setDao(dao);

			setMsUsrFromOmUsr(dao, ic.getCdUsrRev());

			IcDTO icdto = IcAtribuiValoresPadraoSalvar(rn, ic, true);
			rn.setIcDTO(icdto);
			ListaIcDTO retorno = rn.salvarIcDTO();

			dao.commitaTransacao();
			
			if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(INTERFACE_COLETOR, retorno.getResultadoDTO().getIdMensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				ic.setIdIC(retorno.getListaIcDTO().get(0).getIdIc());
				ic.setStRegistro(retorno.getListaIcDTO().get(0).getSt_ativo());

				String json = gson.toJson(ic);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/ics/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoIC(@Context HttpServletRequest request, IcDTO2 ic) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IcRN rn = new IcRN(dao);
			// rn.setDao(dao);

			setMsUsrFromOmUsr(dao, ic.getCdUsrRev());

			IcDTO icdto = IcAtribuiValoresPadraoSalvar(rn, ic, false);
			rn.setIcDTO(icdto);
			ListaIcDTO retorno = rn.salvarIcDTO();

			dao.commitaTransacao();
			
			if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(INTERFACE_COLETOR, retorno.getResultadoDTO().getIdMensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				ic.setIdIC(retorno.getListaIcDTO().get(0).getIdIc());
				ic.setStRegistro(retorno.getListaIcDTO().get(0).getSt_ativo());
				ic.setRevisao(retorno.getListaIcDTO().get(0).getRevisao());

				String json = gson.toJson(ic);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/ics/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarIC(@Context HttpServletRequest request, IcDTO2 ic) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IcRN rn = new IcRN(dao);
			// rn.setDao(dao);

			setMsUsrFromOmUsr(dao, ic.getCdUsrRev());

			IcDTO icdto = IcAtribuiValoresPadraoSalvar(rn, ic, false);
			rn.setIcDTO(icdto);

			ListaIcDTO retorno = rn.removeIcDTO();

			dao.commitaTransacao();
			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(INTERFACE_COLETOR, retorno.getResultadoDTO().getIdMensagem());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					ic.setIdIC(retorno.getListaIcDTO().get(0).getIdIc());
					ic.setStRegistro(retorno.getListaIcDTO().get(0).getSt_ativo());
					ic.setRevisao(retorno.getListaIcDTO().get(0).getRevisao());

					String json = gson.toJson(ic);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private IcDTO IcAtribuiValoresPadraoSalvar(IcRN rn, IcDTO2 ic, boolean isInclusao) {
		IcDTO objSalvar = new IcDTO();

		objSalvar.setCd_ic(ic.getCdIC());
		objSalvar.setDs_ic(ic.getDsIC());
		objSalvar.setUrl_conexao(ic.getUrl());
		objSalvar.setTp_ic(3); // coleta dinamica

		objSalvar.setDthr_revisao(DataHoraRN.getDataHoraAtual());
		objSalvar.setDthr_stativo(objSalvar.getDthr_revisao());

		if (!isInclusao) {
			IcDTO2 objUpd = rn.getICByCd(ic.getCdIC());
			objSalvar.setIdIc(objUpd.getIdIC().intValue());
			objSalvar.setRevisao(objUpd.getRevisao());
			objUpd = null;

		} else {
			objSalvar.setRevisao(1);
		}

		OmUsr usrRev = new OmUsr();
		usrRev = getUsrLocal(ic.getCdUsrRev(), rn.getDao());
		objSalvar.setLoginUsuario(usrRev.getCdUsr());
		objSalvar.setSt_ativo(1);

		return objSalvar;
	}

	private void setMsUsrFromOmUsr(DAOGenerico dao, String cdUsr) {
		MsUsr retorno = new MsUsr();

		MsUsrDAO msUsrRN = new MsUsrDAO(dao.getSession());

		retorno = msUsrRN.getMsUsrPorCdAtivo(cdUsr);
		if (retorno == null) {
			// cria usuário em Ms_Usr
			OmUsr usr = getUsrLocal(cdUsr, dao);

			SQLQuery q = null;

			String strSQL = "";
			strSQL = strSQL.concat("INSERT INTO ms_usr (cd_usr, revisao, nm_usr, dthr_revisao, dthr_stativo, st_ativo, login, senha) ");
			strSQL = strSQL.concat(" VALUES (:cd_usr, :revisao, :nm_usr, :dthr_revisao, :dthr_stativo, :st_ativo, :login, :senha) ");

			// dao.iniciaTransacao();

			q = dao.getSession().createSQLQuery(strSQL);
			q.setParameter("cd_usr", usr.getCdUsr());
			q.setBigDecimal("revisao", BigDecimal.ONE);
			q.setParameter("nm_usr", usr.getDsNome());
			q.setTimestamp("dthr_revisao", DataHoraRN.getDataHoraAtual());
			q.setTimestamp("dthr_stativo", DataHoraRN.getDataHoraAtual());
			q.setBigDecimal("st_ativo", BigDecimal.ONE);
			q.setParameter("login", usr.getLogin());
			q.setParameter("senha", usr.getSenha());
			q.executeUpdate();

			// dao.commitaTransacao();

		}

		msUsrRN = null;
		retorno = null;
	}

	// IHMs
	@GET
	@Path("/ihms")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIHMs(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IhmRN rn = new IhmRN(dao);

			ListaIHMsDTO retornoConsulta = rn.getIHMsDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/ihms/{cdIHM: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIHM(@Context HttpServletRequest request, @PathParam("cdIHM") String cdIHM) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IhmRN rn = new IhmRN(dao);

			IhmDTO2 retornoConsulta = rn.getIHMByCd(cdIHM);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getIdIHM());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/ihms/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoIHM(@Context HttpServletRequest request, IhmDTO2 ihm) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IhmRN rn = new IhmRN(dao);

			setMsUsrFromOmUsr(dao, ihm.getCdUsrRev());

			IhmDTO ihmdto = IHMAtribuiValoresPadraoSalvar(rn, ihm, true);
			rn.setIhmDTO(ihmdto);
			ListaIhmDTO retorno = rn.salvarIhmDTO();

			dao.commitaTransacao();
			
			if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(IHMS, retorno.getResultadoDTO().getIdMensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				ihm.setIdIHM(retorno.getListaIhmDTO().get(0).getIdIhm());

				String json = gson.toJson(ihm);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/ihms/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoIHM(@Context HttpServletRequest request, IhmDTO2 ihm) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IhmRN rn = new IhmRN(dao);

			setMsUsrFromOmUsr(dao, ihm.getCdUsrRev());

			IhmDTO ihmdto = IHMAtribuiValoresPadraoSalvar(rn, ihm, false);
			rn.setIhmDTO(ihmdto);
			ListaIhmDTO retorno = rn.salvarIhmDTO();

			dao.commitaTransacao();
			
			if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(IHMS, retorno.getResultadoDTO().getIdMensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				ihm.setIdIHM(retorno.getListaIhmDTO().get(0).getIdIhm());

				String json = gson.toJson(ihm);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/ihms/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirIHM(@Context HttpServletRequest request, IhmDTO2 ihm) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			IhmRN rn = new IhmRN(dao);

			setMsUsrFromOmUsr(dao, ihm.getCdUsrRev());

			IhmDTO ihmdto = IHMAtribuiValoresPadraoExcluir(rn, ihm);
			rn.setIhmDTO(ihmdto);

			ListaIhmDTO retorno = rn.removeIhmDTO();

			dao.commitaTransacao();
			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(IHMS, retorno.getResultadoDTO().getIdMensagem());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					ResultadoExclusaoIHM resIHM = new ResultadoExclusaoIHM();
					resIHM.setResultadoExclusao(true);

					String json = gson.toJson(resIHM);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private IhmDTO IHMAtribuiValoresPadraoSalvar(IhmRN rn, IhmDTO2 ihm, boolean isInclusao) {
		IhmDTO objSalvar = new IhmDTO();

		objSalvar.setCdIhm(ihm.getCdIHM());
		objSalvar.setUrl_Conexao(ihm.getUrlConexao());
		objSalvar.setUrl_Ip(ihm.getUrlConexao());
		objSalvar.setUrl_ConexaoAlternativo(ihm.getUrlConexao());
		objSalvar.setUps(new ArrayList<UpIhmDTO>());
		objSalvar.setDthrCadastro(DataHoraRN.getDataHoraAtual());

		// percorre lista de ups e atribui
		for (UpIhmDTO2 up : ihm.getUps()) {
			UpIhmDTO reg = new UpIhmDTO();
			UpDTO regU = new UpDTO();
			regU.setCd_up(up.getCdUP());
			reg.setUp(regU);

			objSalvar.getUps().add(reg);
		}

		if (!isInclusao) {
			IhmDTO2 objUpd = rn.getIHMByCd(ihm.getCdIHM());
			objSalvar.setIdIhm(objUpd.getIdIHM());
			objUpd = null;
		}

		OmUsr usrRev = new OmUsr();
		usrRev = getUsrLocal(ihm.getCdUsrRev(), rn.getDao());
		objSalvar.setLoginUsuario(usrRev.getCdUsr());

		return objSalvar;
	}

	private IhmDTO IHMAtribuiValoresPadraoExcluir(IhmRN rn, IhmDTO2 ihm) {
		IhmDTO objSalvar = new IhmDTO();

		objSalvar.setCdIhm(ihm.getCdIHM());
		objSalvar.setUrl_Conexao(ihm.getUrlConexao());
		objSalvar.setUrl_Ip(ihm.getUrlConexao());
		objSalvar.setUrl_ConexaoAlternativo(ihm.getUrlConexao());
		objSalvar.setUps(new ArrayList<UpIhmDTO>());
		objSalvar.setDthrCadastro(DataHoraRN.getDataHoraAtual());

		IhmDTO2 objUpd = rn.getIHMByCd(ihm.getCdIHM());
		objSalvar.setIdIhm(objUpd.getIdIHM());
		objUpd = null;

		OmUsr usrRev = new OmUsr();
		usrRev = getUsrLocal(ihm.getCdUsrRev(), rn.getDao());
		objSalvar.setLoginUsuario(usrRev.getCdUsr());

		return objSalvar;
	}

	// UPs
	@GET
	@Path("/ups")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUPsAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			UpRN rn = new UpRN();
			ListaUPsDTO retornoConsulta = rn.getUPsDTO(filtro, dao);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/ups/{cdUP: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUP(@Context HttpServletRequest request, @PathParam("cdUP") String cdUP) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			UpRN rn = new UpRN();
			UpDTO2 retornoConsulta = rn.getUPByCd(cdUP, dao);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/ups/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoUP(@Context HttpServletRequest request, UpDTO2 up) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			UpRN rn = new UpRN();
			rn.setDaoPdba(dao);

			setMsUsrFromOmUsr(dao, up.getCdUsrRev());

			UpDTO updtto = UPAtribuiValoresPadraoSalvar2(rn, up);
			rn.setUpDTO(updtto);
			ListaUPDTO retorno = rn.salvarUpDTO();

			dao.commitaTransacao();
			
			if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(UPS, retorno.getResultadoDTO().getIdMensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				up.setIdUP(retorno.getListaUPDTO().get(0).getIdUp().intValue());
				up.setStRegistro(retorno.getListaUPDTO().get(0).getStAtivo().intValue());
				String json = gson.toJson(up);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private UpDTO UPAtribuiValoresPadraoSalvar2(UpRN rn, UpDTO2 up) {
		UpDTO objSalvar = new UpDTO();
		IhmRN rnIHM = new IhmRN();
		rnIHM.setDao(rn.getDaoPdba());

		objSalvar.setCd_up(up.getCdUP());
		objSalvar.setUpihmColetados(new ArrayList<UpIhmDTO>());
		objSalvar.setDthrRevisao(DataHoraRN.getDataHoraAtual());
		objSalvar.setDthrStativo(objSalvar.getDthrRevisao());
		objSalvar.setStAtivo(BigDecimal.ONE);

		// percorre lista de ups e atribui
		for (IhmUpDTO2 ihm : up.getIhms()) {
			UpIhmDTO reg = new UpIhmDTO();
			reg.setIhm(new IhmDTO());
			reg.getIhm().setIdIhm(rnIHM.getIHMByCd(ihm.getCdIHM()).getIdIHM());
			objSalvar.getUpihmColetados().add(reg);
		}

		UpDTO2 objUpd = rn.getUPByCd(up.getCdUP(), rn.getDaoPdba());
		objSalvar.setIdUp(new BigDecimal(objUpd.getIdUP()));
		objSalvar.setDs_up(objUpd.getDsUP());
		objUpd = null;

		objSalvar.setLoginUsuario(up.getCdUsrRev());

		rnIHM = null;
		return objSalvar;
	}

	// MSs
	@GET
	@Path("/ms")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			MsRN rn = new MsRN();
			rn.setDao(dao);

			ListaMSsDTO retornoConsulta = rn.getMSsDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/ms/{cdMS: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMS(@Context HttpServletRequest request, @PathParam("cdMS") String cdMS) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			MsRN rn = new MsRN();
			rn.setDao(dao);

			MsDTO2 retornoConsulta = rn.getMSByCd(cdMS);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/ms/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoMS(@Context HttpServletRequest request, MsDTO2 ms) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			MsRN rn = new MsRN();
			rn.setDao(dao);

			setMsUsrFromOmUsr(dao, ms.getCdUsrRev());

			MsDTO msdto = MsAtribuiValoresPadraoSalvar(rn, ms, true);
			rn.setMsDTO(msdto);
			ListaMSDTO retorno = rn.setMSDTO();

			dao.commitaTransacao();
			
			if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(MODULO_SINAIS, retorno.getResultadoDTO().getIdMensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				ms.setIdMS(retorno.getListaMSDTO().get(0).getIdMs().intValue());
				ms.setStRegistro(retorno.getListaMSDTO().get(0).getSt_ativo());

				String json = gson.toJson(ms);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/ms/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoMS(@Context HttpServletRequest request, MsDTO2 ms) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			MsRN rn = new MsRN();
			rn.setDao(dao);

			setMsUsrFromOmUsr(dao, ms.getCdUsrRev());

			MsDTO msdto = MsAtribuiValoresPadraoSalvar(rn, ms, false);
			rn.setMsDTO(msdto);
			ListaMSDTO retorno = rn.setMSDTO();

			dao.commitaTransacao();
			
			if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(MODULO_SINAIS, retorno.getResultadoDTO().getIdMensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				ms.setIdMS(retorno.getListaMSDTO().get(0).getIdMs().intValue());
				ms.setStRegistro(retorno.getListaMSDTO().get(0).getSt_ativo());

				String json = gson.toJson(ms);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/ms/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarMS(@Context HttpServletRequest request, MsDTO2 ms) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			MsRN rn = new MsRN();
			rn.setDao(dao);

			setMsUsrFromOmUsr(dao, ms.getCdUsrRev());

			MsDTO msdto = MsAtribuiValoresPadraoSalvar(rn, ms, false);
			rn.setMsDTO(msdto);

			ListaMSDTO retorno = rn.removeMSDTO();

			dao.commitaTransacao();
			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getResultadoDTO().getIdMensagem() != retorno.getResultadoDTO().COM_SUCESSO) {
					responseStatus = Response.Status.BAD_REQUEST;

					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(MODULO_SINAIS, retorno.getResultadoDTO().getIdMensagem());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					ms.setIdMS(retorno.getListaMSDTO().get(0).getIdMs().intValue());
					ms.setStRegistro(retorno.getListaMSDTO().get(0).getSt_ativo());
					ms.setRevisao(retorno.getListaMSDTO().get(0).getRevisao());

					String json = gson.toJson(ms);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private MsDTO MsAtribuiValoresPadraoSalvar(MsRN rn, MsDTO2 ms, boolean isInclusao) {
		MsDTO objSalvar = new MsDTO();

		objSalvar.setCd_ms(ms.getCdMS());
		objSalvar.setDs_ms(ms.getDsMS());
		objSalvar.setUrlConexao(ms.getMacAddress());
		objSalvar.setIcsColetados(new ArrayList<IcUpDTO>());
		objSalvar.setDthr_revisao(DataHoraRN.getDataHoraAtual());
		objSalvar.setDthr_stativo(objSalvar.getDthr_revisao());
		objSalvar.setSt_ativo(1);

		if (!isInclusao) {
			MsDTO2 objUpd = rn.getMSByCd(ms.getCdMS());
			objSalvar.setIdMs(new BigDecimal(objUpd.getIdMS()));
			objSalvar.setRevisao(objUpd.getRevisao());
			objUpd = null;

		} else {
			objSalvar.setRevisao(1);
		}

		OmUsr usrRev = new OmUsr();
		usrRev = getUsrLocal(ms.getCdUsrRev(), rn.getDao());
		objSalvar.setLoginUsuario(usrRev.getCdUsr());
		objSalvar.setSt_ativo(1);

		if (ms.getAssociacoesUpIc() != null) {
			// percorre lista
			for (UpIcMsDTO2 uim : ms.getAssociacoesUpIc()) {
				IcUpDTO reg = new IcUpDTO();

				UpRN uRN = new UpRN();
				UpDTO2 up2 = uRN.getUPByCd(uim.getCdUP(), rn.getDao());

				IcRN iRN = new IcRN(rn.getDao());
				IcDTO2 ic2 = iRN.getICByCd(uim.getCdIC());

				reg.setUpDTO(new UpDTO());
				reg.getUpDTO().setIdUp(new BigDecimal(up2.getIdUP()));
				reg.getUpDTO().setCd_up(uim.getCdUP());

				reg.setIc(new IcDTO());
				reg.getIc().setIdIc(ic2.getIdIC());
				reg.getIc().setCd_ic(uim.getCdIC());

				reg.setUrlConexao(uim.getUrlConexao());
				reg.setTpConexao(0);

				objSalvar.getIcsColetados().add(reg);
			}
		}

		return objSalvar;
	}

	// clientes
	@GET
	@Path("/clientes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientesAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			PpClienteRN rn = new PpClienteRN();
			rn.setDao(dao);

			ListaClientesDTO retornoConsulta = rn.getClientesDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/clientes/{cdCliente: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCliente(@Context HttpServletRequest request, @PathParam("cdCliente") String cdCliente) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			PpClienteRN rn = new PpClienteRN();
			rn.setDao(dao);

			ClienteDTO2 retornoConsulta = rn.getClienteByCd(cdCliente);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/clientes/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoCliente(@Context HttpServletRequest request, ClienteDTO2 clienteDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			PpClienteRN rn = new PpClienteRN();
			rn.setDao(dao);

			PpClienteDTO cliente = ClienteAtribuiValoresPadraoSalvar(rn, clienteDTO, true);
			PpClienteDTO retorno = rn.setPpClienteDTO(cliente);

			long idCliente = rn.getClienteByCd(clienteDTO.getCdCliente()).getIdCliente();
			retorno.getPpCliente().setIdCliente(idCliente);

			dao.commitaTransacao();

			// NÃO HÁ TRATAMENTO DE ERRO!!!

			clienteDTO.setIdCliente(retorno.getPpCliente().getIdCliente());
			clienteDTO.setStRegistro(retorno.getPpCliente().getStAtivo().intValue());

			String json = gson.toJson(clienteDTO);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// alterar
	@PUT
	@Path("/clientes/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoCliente(@Context HttpServletRequest request, ClienteDTO2 clienteDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			PpClienteRN rn = new PpClienteRN();
			rn.setDao(dao);

			PpClienteDTO cliente = ClienteAtribuiValoresPadraoSalvar(rn, clienteDTO, false);
			PpClienteDTO retorno = rn.setPpClienteDTO(cliente);

			long idCliente = rn.getClienteByCd(clienteDTO.getCdCliente()).getIdCliente();
			retorno.getPpCliente().setIdCliente(idCliente);

			dao.commitaTransacao();

			// NÃO HÁ TRATAMENTO DE ERRO!!!

			clienteDTO.setIdCliente(retorno.getPpCliente().getIdCliente());
			clienteDTO.setStRegistro(retorno.getPpCliente().getStAtivo().intValue());

			String json = gson.toJson(clienteDTO);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/clientes/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarCliente(@Context HttpServletRequest request, ClienteDTO2 clienteDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			PpClienteRN rn = new PpClienteRN();
			rn.setDao(dao);

			PpClienteDTO cliente = ClienteAtribuiValoresPadraoSalvar(rn, clienteDTO, false);

			PpClientesDTO clientes = new PpClientesDTO();
			clientes.setListaPpClientesDTO(new ArrayList<PpClienteDTO>());
			clientes.getListaPpClientesDTO().add(cliente);

			PpClientesDTO retorno = rn.removePpClientesDTO(clientes);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");

			} else {
				// NÃO HÁ TRATAMENTO DE ERRO!!!

				clienteDTO.setIdCliente(retorno.getListaPpClientesDTO().get(0).getPpCliente().getIdCliente());
				clienteDTO.setStRegistro(0);

				String json = gson.toJson(clienteDTO);
				return Response.status(responseStatus).entity(json).build();
				
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	private PpClienteDTO ClienteAtribuiValoresPadraoSalvar(PpClienteRN rn, ClienteDTO2 cliente, boolean isInclusao) {

		PpClienteDTO clienteSalvar = new PpClienteDTO();
		PpCliente retorno = new PpCliente();

		retorno.setCdCliente(cliente.getCdCliente());
		retorno.setNmCliente(cliente.getNmCliente());
		retorno.setTpCliente(cliente.getTpCliente());
		retorno.setCnpjCpf(cliente.getCnpjcpf());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(cliente.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			PpCliente regUpd = getClienteLocal(rn, cliente.getCdCliente());
			retorno.setIdCliente(regUpd.getIdCliente());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		clienteSalvar.setPpCliente(new PpCliente());
		clienteSalvar.setPpCliente(retorno);

		retorno = null;

		return clienteSalvar;

	}

	// refugos
	@GET
	@Path("/refugos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRefugosAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			RefugoRN rn = new RefugoRN();
			rn.setDao(dao);

			ListaRefugosDTO retornoConsulta = rn.getRefugosDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/refugos/{cdRefugo: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRefugo(@Context HttpServletRequest request, @PathParam("cdRefugo") String cdRefugo) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			RefugoRN rn = new RefugoRN();
			rn.setDao(dao);

			RefugoCadDTO retornoConsulta = rn.getRefugoByCd(cdRefugo);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/refugos/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoRefugo(@Context HttpServletRequest request, RefugoCadDTO refugoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			RefugoRN rn = new RefugoRN();
			rn.setDao(dao);

			DwTRefugoDTO refugo = RefugoAtribuiValoresPadraoSalvar(rn, refugoDTO, true);
			DwTRefugoDTO retorno = rn.setTRefugo(refugo);

			dao.commitaTransacao();

			if (retorno.getResultado().getIdmensagem() != 0) {
				responseStatus = Response.Status.BAD_REQUEST;

				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(REFUGOS, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				refugoDTO.setIdRefugo(retorno.getDwTRefugo().getIdTrefugo().intValue());
				refugoDTO.setRevisao(retorno.getDwTRefugo().getRevisao().intValue());
				refugoDTO.setStRegistro(retorno.getDwTRefugo().getStAtivo().intValue());
				String json = gson.toJson(refugoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// alterar
	@PUT
	@Path("/refugos/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoRefugo(@Context HttpServletRequest request, RefugoCadDTO refugoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			RefugoRN rn = new RefugoRN();
			rn.setDao(dao);

			DwTRefugoDTO refugo = RefugoAtribuiValoresPadraoSalvar(rn, refugoDTO, false);
			DwTRefugoDTO retorno = rn.setTRefugo(refugo);

			dao.commitaTransacao();

			if (retorno.getResultado().getIdmensagem() != 0) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(REFUGOS, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				refugoDTO.setIdRefugo(retorno.getDwTRefugo().getIdTrefugo().intValue());
				refugoDTO.setRevisao(retorno.getDwTRefugo().getRevisao().intValue());
				refugoDTO.setStRegistro(retorno.getDwTRefugo().getStAtivo().intValue());
				String json = gson.toJson(refugoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// excluir (desativar)
	@PUT
	@Path("/refugos/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarRefugo(@Context HttpServletRequest request, RefugoCadDTO refugoDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			RefugoRN rn = new RefugoRN();
			rn.setDao(dao);

			DwTRefugoDTO refugo = RefugoAtribuiValoresPadraoSalvar(rn, refugoDTO, false);
			DwTRefugosDTO lista = new DwTRefugosDTO();
			lista.setDwTRefugos(new ArrayList<DwTRefugoDTO>());
			lista.getDwTRefugos().add(refugo);

			DwTRefugosDTO retorno = rn.removeTRefugo(lista);

			dao.commitaTransacao();

			if (retorno.getDwTRefugos().get(0).getResultado().getIdmensagem() != 0) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(REFUGOS, retorno.getDwTRefugos().get(0).getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				refugoDTO.setIdRefugo(retorno.getDwTRefugos().get(0).getDwTRefugo().getIdTrefugo().intValue());
				refugoDTO.setRevisao(retorno.getDwTRefugos().get(0).getDwTRefugo().getRevisao().intValue());
				refugoDTO.setStRegistro(retorno.getDwTRefugos().get(0).getDwTRefugo().getStAtivo().intValue());
				String json = gson.toJson(refugoDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	private DwTRefugoDTO RefugoAtribuiValoresPadraoSalvar(RefugoRN rn, RefugoCadDTO refugo, boolean isInclusao) {
		DwTRefugoDTO refugoSalvar = new DwTRefugoDTO();

		DwTRefugo retorno = new DwTRefugo();
		retorno.setDwTArea(new DwTArea());
		retorno.setOmTppt(new OmTppt());

		retorno.setCdTrefugo(refugo.getCdRefugo());
		retorno.setDsTrefugo(refugo.getDsRefugo());
		retorno.setIsRequerAcao(refugo.isRequerAcao());
		retorno.setIsRequerCausa(refugo.isRequerCausa());
		retorno.getDwTArea().setCdArea(refugo.getCdArea());
		retorno.getOmTppt().setCdTppt("CIC");

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(refugo.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			RefugoCadDTO regUpd = rn.getRefugoByCd(refugo.getCdRefugo());
			retorno.setIdTrefugo((long) regUpd.getIdRefugo());
			retorno.setRevisao((long) regUpd.getRevisao());
			regUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		refugoSalvar.setDwTRefugo(new DwTRefugo());
		refugoSalvar.setDwTRefugo(retorno);

		retorno = null;

		return refugoSalvar;
	}

	// paradas
	@GET
	@Path("/paradas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParadasAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ParadaRN rn = new ParadaRN();
			rn.setDao(dao);

			ListaParadasDTO retornoConsulta = rn.getParadasDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/paradas/{cdParada: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParada(@Context HttpServletRequest request, @PathParam("cdParada") String cdParada) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ParadaRN rn = new ParadaRN();
			rn.setDao(dao);

			ParadaCadDTO retornoConsulta = rn.getParadaByCd(cdParada);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/paradas/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovaParada(@Context HttpServletRequest request, ParadaCadDTO paradaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ParadaRN rn = new ParadaRN();
			rn.setDao(dao);

			DWParadaDTO parada = ParadaAtribuiValoresPadraoSalvar(rn, paradaDTO, true);
			DWParadaDTO retorno = rn.setTparada(parada);

			dao.commitaTransacao();

			if (retorno.getResultado().getIdmensagem() != 0) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(PARADAS, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				paradaDTO.setIdParada(retorno.getDwTParada().getIdTparada().intValue());
				paradaDTO.setRevisao(retorno.getDwTParada().getRevisao().intValue());
				paradaDTO.setStRegistro(retorno.getDwTParada().getStAtivo().intValue());
				String json = gson.toJson(paradaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// alterar
	@PUT
	@Path("/paradas/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoParada(@Context HttpServletRequest request, ParadaCadDTO paradaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ParadaRN rn = new ParadaRN();
			rn.setDao(dao);

			DWParadaDTO parada = ParadaAtribuiValoresPadraoSalvar(rn, paradaDTO, false);
			DWParadaDTO retorno = rn.setTparada(parada);

			dao.commitaTransacao();

			if (retorno.getResultado().getIdmensagem() != 0) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(PARADAS, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);

				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				paradaDTO.setIdParada(retorno.getDwTParada().getIdTparada().intValue());
				paradaDTO.setRevisao(retorno.getDwTParada().getRevisao().intValue());
				paradaDTO.setStRegistro(retorno.getDwTParada().getStAtivo().intValue());
				String json = gson.toJson(paradaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	// excluir (desativar)
	@PUT
	@Path("/paradas/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarParada(@Context HttpServletRequest request, ParadaCadDTO paradaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ParadaRN rn = new ParadaRN();
			rn.setDao(dao);

			DWParadaDTO parada = ParadaAtribuiValoresPadraoExcluir(rn, paradaDTO);
			ParadasDTO lista = new ParadasDTO();
			lista.setDwTParadas(new ArrayList<DWParadaDTO>());
			lista.getDwTParadas().add(parada);

			ParadasDTO retorno = rn.removeTparada(lista);

			dao.commitaTransacao();

			if (retorno == null || retorno.getCamposEmUsoOmCfg() == null) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(PARADAS, retorno.getDwTParadas().get(0).getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
				
			} else if (retorno.getCamposEmUsoOmCfg().getStatus() != 1) { // retorno.getCamposEmUsoOmCfg().STATUS_TEM_CAMPO_EM_USO
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(PARADAS, retorno.getDwTParadas().get(0).getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
				
			} else {
				ResultadoExclusaoIHM resultadoExclusao = new ResultadoExclusaoIHM();
				resultadoExclusao.setResultadoExclusao(true);
				String json = gson.toJson(resultadoExclusao);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	private DWParadaDTO ParadaAtribuiValoresPadraoSalvar(ParadaRN rn, ParadaCadDTO parada, boolean isInclusao) {
		DWParadaDTO paradaSalvar = new DWParadaDTO();

		DwTParada retorno = new DwTParada();
		retorno.setDwTArea(new DwTArea());
		retorno.setOmTppt(new OmTppt());

		retorno.setCdTparada(parada.getCdParada());
		retorno.setDsTparada(parada.getDsParada());

		retorno.setIsRequerAcao(parada.isReqAcao());
		retorno.setIsRequerCausa(parada.isReqCausa());
		retorno.setIsRequerJust(parada.isReqJustificativa());
		retorno.setIsMtbf(parada.isReqMTBFMTTR());
		retorno.setIsRegulagem(parada.isReqCancelamento());
		retorno.setIsPermitecorrecao(parada.isReqPermiteCorrecao());
		retorno.setIsPesa(parada.isReqPesaEficiencia());

		retorno.setQtTec(parada.getQtdTec());

		retorno.getDwTArea().setCdArea(parada.getCdArea());
		retorno.getOmTppt().setCdTppt("CIC");

		// verificacao de timeouts
		if (parada.getTimeOutAlerta() != null) {
			retorno.setDwTAlerta(new DwTAlerta());
			retorno.getDwTAlerta().setCdTalerta(parada.getTimeOutAlerta().getCdAlerta());
			retorno.setSegTimeoutalerta(new BigDecimal(parada.getTimeOutAlerta().getTimeout()));
		}

		if (parada.getTimeOutParada() != null) {
			retorno.setDwTParadaextra(new DwTParada());
			retorno.getDwTParadaextra().setCdTparada(parada.getTimeOutParada().getCdParada());
			retorno.setSegExtrapolacao(new BigDecimal(parada.getTimeOutParada().getTimeout()));
		}

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(parada.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			ParadaCadDTO regUpd = rn.getParadaByCd(parada.getCdParada());
			retorno.setIdTparada((long) regUpd.getIdParada());
			retorno.setRevisao((long) regUpd.getRevisao());
			regUpd = null;

		} else {
			retorno.setRevisao(0l);
		}

		paradaSalvar.setDwTParada(new DwTParada());
		paradaSalvar.setDwTParada(retorno);

		retorno = null;

		return paradaSalvar;
	}

	private DWParadaDTO ParadaAtribuiValoresPadraoExcluir(ParadaRN rn, ParadaCadDTO parada) {
		DWParadaDTO paradaSalvar = new DWParadaDTO();

		DwTParada retorno = new DwTParada();
		retorno.setCdTparada(parada.getCdParada());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(parada.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		ParadaCadDTO regUpd = rn.getParadaByCd(parada.getCdParada());
		retorno.setIdTparada((long) regUpd.getIdParada());
		retorno.setRevisao((long) regUpd.getRevisao());
		regUpd = null;

		paradaSalvar.setDwTParada(new DwTParada());
		paradaSalvar.setDwTParada(retorno);

		retorno = null;

		return paradaSalvar;
	}


	// folhas de processos
	@GET
	@Path("/folhasprocessos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFolhasProcessosAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			FolhaRN rn = new FolhaRN();
			rn.setDao(dao);

			ListaFolhasProcessoDTO retornoConsulta = rn.getFolhasProcessosDTO(filtro);
			dao.commitaTransacao();			
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
		
	}

	@GET
	//@Path("/folhasprocessos/{cdFolha}")
	@Path("/folhasprocessos/{cdFolha: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFolhaProcessos(@Context HttpServletRequest request, @PathParam("cdFolha") String cdFolha) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			FolhaRN rn = new FolhaRN();
			rn.setDao(dao);

			FolhaDTO2 retornoConsulta = rn.getFolhaProcessosByCd(cdFolha);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}


	// incluir
	@POST
	@Path("/folhasprocessos/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovaFolhaProcessos(@Context HttpServletRequest request, FolhaDTO2 folhaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			FolhaRN rn = new FolhaRN();
			rn.setDao(dao);
			
			FolhaDTO folha = FolhaProcessosAtribuiValoresPadraoSalvar(rn, folhaDTO, true);
			FolhaDTO retorno = rn.setFolhaSemCadastroEtapaDTO(folha);
			
			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(FOLHAS_PROCESSOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
				
			} else {
				folhaDTO.setIdFolha(retorno.getFolha().getIdFolha());
				folhaDTO.setStRegistro(retorno.getFolha().getStAtivo().intValue());
				String json = gson.toJson(folhaDTO);
				return Response.status(responseStatus).entity(json).build();
			}
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}
	
	// alterar
	@PUT
	@Path("/folhasprocessos/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoFolhaProcessos(@Context HttpServletRequest request, FolhaDTO2 folhaDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			FolhaRN rn = new FolhaRN();
			rn.setDao(dao);

			FolhaDTO folha = FolhaProcessosAtribuiValoresPadraoSalvar(rn, folhaDTO, false);
			FolhaDTO retorno = rn.setFolhaSemCadastroEtapaDTO(folha);
			
			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(FOLHAS_PROCESSOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				folhaDTO.setIdFolha(retorno.getFolha().getIdFolha());
				folhaDTO.setStRegistro(retorno.getFolha().getStAtivo().intValue());
				String json = gson.toJson(folhaDTO);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// excluir (desativar)
	@PUT
	@Path("/folhasprocessos/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarFolhaProcessos(@Context HttpServletRequest request, FolhaDTO2 folhaDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			FolhaRN rn = new FolhaRN();
			rn.setDao(dao);

			FolhaDTO folha = FolhaProcessosAtribuiValoresPadraoSalvar(rn, folhaDTO, false);

			FolhasDTO folhas = new FolhasDTO();
			folhas.setFolhas(new ArrayList<FolhaDTO>());
			folhas.getFolhas().add(folha);

			FolhasDTO retorno = rn.removeFolhasDTO(folhas);

			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getFolhas().get(0).getResultadoEvento() != retorno.getFolhas().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(FOLHAS_PROCESSOS, retorno.getFolhas().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					folhaDTO.setIdFolha(retorno.getFolhas().get(0).getFolha().getIdFolha());
					folhaDTO.setStRegistro(0);
					String json = gson.toJson(folhaDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	
	private FolhaDTO FolhaProcessosAtribuiValoresPadraoSalvar(FolhaRN rn, FolhaDTO2 folha, boolean isInclusao) {
		FolhaDTO folhaSalvar = new FolhaDTO();
		
		DwFolha retorno = new DwFolha();

		retorno.setCdFolha(folha.getCdFolha());
		retorno.setDsFolha(folha.getDsFolha());

		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());

		OmTppt tppt = new OmTppt();
		tppt.setCdTppt("CIC");
		retorno.setOmTppt(tppt);
		
		OmGt gt = new OmGt();
		gt.setCdGt(folha.getCdGt());
		retorno.setOmGt(gt);
		
		
		retorno.setSegCiclominimo(folha.getCicloMinimo());
		retorno.setSegCiclopadrao(folha.getCicloPadrao());
		retorno.setSegCiclotimeout(folha.getCicloTimeout());
		retorno.setSegSetup(folha.getSetup());
		
		// Se existe ferramenta associada à folha...
		if (folha.getFerramentas() != null) {

			DwRap rap;
			DwFolharap folhaRap;
			
			// Percorre lista de raps e atribui
			for (FolhaRapDTO2 ferramenta : folha.getFerramentas()) {
				
				rap = new DwRap();
				rap.setCdRap(ferramenta.getCdFerramenta());
				
				folhaRap = new DwFolharap();
				folhaRap.setDwRap(rap);
				
				// O tempo de preparação deve ser setado para o tempo de liberação em DwRap
				folhaRap.getDwRap().setSegTempoliberacao(ferramenta.getTempoPreparacao());
				
				for (FolhaRapProdutoDTO produto : ferramenta.getProdutos()) {
					
					DwFolharapcom rapProduto = new DwFolharapcom();
					OmProduto omProduto = new OmProduto();
					
					rapProduto.setIdredzproduto(produto.getIdReduzido());
					rapProduto.setQtTotal(produto.getQtTotal());
					rapProduto.setQtAtiva(produto.getQtAlocada());
					
					omProduto.setCdProduto(produto.getCdProduto());
					rapProduto.setOmProduto(omProduto);
					
					folhaRap.getDwFolharapcoms().add(rapProduto);
					
				}
				
				retorno.getDwFolharaps().add(folhaRap);
				
			}
			
		}
		
		
		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(folha.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);

		if (!isInclusao) {
			DwFolha regUpd = getFolhaProcessosLocal(rn, folha.getCdFolha());
			retorno.setIdFolha(regUpd.getIdFolha());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;

		} else {
			retorno.setRevisao(0l);
			
		}

		folhaSalvar.setFolha(new DwFolha());
		folhaSalvar.setFolha(retorno);

		retorno = null;

		return folhaSalvar;
		
	}
	
	// calendários
	@GET
	@Path("/calendarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCalendariosAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CalendarioRN rn = new CalendarioRN();
			rn.setDao(dao);

			ListaCalendariosDTO retornoConsulta = rn.getCalendariosDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			dao.finalizaSessaoSemException();
		}
		
	}
	
	@GET
	@Path("/calendarios/{cdCalendario: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCalendario(@Context HttpServletRequest request, @PathParam("cdCalendario") String cdCalendario) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CalendarioRN rn = new CalendarioRN();
			rn.setDao(dao);

			CalendarioDTO2 retornoConsulta = rn.getCalendarioByCd(cdCalendario);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getStRegistro());
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	// incluir
	@POST
	@Path("/calendarios/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovoCalendario(@Context HttpServletRequest request, CalendarioDTO2 calendarioDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			CalendarioRN rn = new CalendarioRN();
			rn.setDao(dao);
			rn.setSession(dao.getSession());
			
			CalendarioDTO calendario = CalendarioAtribuiValoresPadraoSalvar(rn, calendarioDTO, true, dao);
			CalendarioDTO retorno = rn.setCalendarioDTO(calendario);
			
			// Prepara os postos para que o front-end receba todos os postos, selecionados ou não.
			// Isso deve ser feito aqui mesmo, antes do COMMIT.
			calendarioDTO = MontaRetornoPostosCalendario(calendarioDTO, dao);
			
			dao.commitaTransacao();
			
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(CALENDARIOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				calendarioDTO.setIdCalendario(retorno.getCalendario().getIdCal());
				calendarioDTO.setStRegistro(retorno.getCalendario().getStAtivo().intValue());
				
				// Prepara os intervalos para que o front-end receba as distribuições dos turnos.
				// Como o "retorno" não retorna os dados do turno, foi necessário usar a variável "calendario".
				calendarioDTO = MontaRetornoIntervalosCalendario(calendarioDTO, calendario);
				
				String json = gson.toJson(calendarioDTO);
				return Response.status(responseStatus).entity(json).build();
				
			}
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
			
		}

	}
	
	// alterar
	@PUT
	@Path("/calendarios/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoCalendario(@Context HttpServletRequest request, CalendarioDTO2 calendarioDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			CalendarioRN rn = new CalendarioRN();
			rn.setDao(dao);
			rn.setSession(dao.getSession());
			
			CalendarioDTO calendario = CalendarioAtribuiValoresPadraoSalvar(rn, calendarioDTO, false, dao);
			CalendarioDTO retorno = rn.setCalendarioDTO(calendario);

			// Prepara os postos para que o front-end receba todos os postos, selecionados ou não.
			// Isso deve ser feito aqui mesmo, antes do COMMIT.
			calendarioDTO = MontaRetornoPostosCalendario(calendarioDTO, dao);

			dao.commitaTransacao();

			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				responseStatus = Response.Status.BAD_REQUEST;

				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(CALENDARIOS, retorno.getResultadoEvento());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				calendarioDTO.setIdCalendario(retorno.getCalendario().getIdCal());
				calendarioDTO.setStRegistro(retorno.getCalendario().getStAtivo().intValue());
				
				// Prepara os intervalos para que o front-end receba as distribuições dos turnos.
				// Como o "retorno" não retorna os dados do turno, foi necessário usar a variável "calendario".
				calendarioDTO = MontaRetornoIntervalosCalendario(calendarioDTO, calendario);
				
				String json = gson.toJson(calendarioDTO);
				return Response.status(responseStatus).entity(json).build();
				
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	private CalendarioDTO CalendarioAtribuiValoresPadraoSalvar(CalendarioRN rn, CalendarioDTO2 calendario, boolean isInclusao, DAOGenerico dao) throws ParseException {
		CalendarioDTO calendarioSalvar = new CalendarioDTO();

		DwCal retorno = new DwCal();
		
		CalendarioSemanalDTO calSemanal = new CalendarioSemanalDTO();
		List<CalendarioSemanalDTO> calendarioSemanal = new ArrayList<CalendarioSemanalDTO>();
		CalendariosSemanaisDTO calendariosSemanais = new CalendariosSemanaisDTO();

		CalendarioPtsDTO calPts = new CalendarioPtsDTO();
		List<DwCalpt> dwPts = new ArrayList<DwCalpt>();
		
		retorno.setCdCal(calendario.getCdCalendario());
		retorno.setDsCal(calendario.getDsCalendario());

		Date dtHrIValidade = null;
		Date dtHrFValidade = null;
		
		if ((calendario.getDtHrIValidade() != null) && (!calendario.getDtHrIValidade().isEmpty())) {
			dtHrIValidade = DataHoraRN.toDateFrom("yyyy-MM-dd", calendario.getDtHrIValidade());
		}
		
		if ((calendario.getDtHrFValidade() != null) && (!calendario.getDtHrFValidade().isEmpty())) {
			dtHrFValidade = DataHoraRN.toDateFrom("yyyy-MM-dd", calendario.getDtHrFValidade());
		}
		
		retorno.setDthrIvalidade(dtHrIValidade);
		retorno.setDthrFvalidade(dtHrFValidade);
		
		
		// ---------------------------------------------------------------
		// Postos
		// ---------------------------------------------------------------
		
		Set<DwCalpt> pts = null;
		
		// Se existe algum pt selecionado...
		if (calendario.getPts() != null) {
			
			pts = new HashSet<DwCalpt>(0);

			DwCalpt dwPt = new DwCalpt();
			
			// Percorre os pts selecionados pelo usuário
			for (CalendarioPtDTO2 pt : calendario.getPts()) {
				
				OmPt ompt = new OmPt();
				PTRN ptRN = new PTRN();
				
				ptRN.setDaoSession(dao.getSession());
				
				PtDTO2 ptDTO = ptRN.getPtByCd(pt.getCdPt());
				
				ompt.setIdPt(ptDTO.getIdPt());
				ompt.setCdPt(ptDTO.getCdPt());
				ompt.setDsPt(ptDTO.getDsPt());
				
				dwPt = new DwCalpt();
				dwPt.setOmPt(ompt);
				
				// Set
				pts.add(dwPt);
				
				// List
				dwPts.add(dwPt);
				;
			}
			
			// Seta os postos para o retorno
			retorno.setDwCalpts(pts);
			
		}
		
		// Seta o objeto "calPts" para setar os postos que vão para o banco de dados
		calPts.setPts(dwPts);
		
		// ---------------------------------------------------------------
		
		
		
		// ---------------------------------------------------------------
		// Intervalos
		// ---------------------------------------------------------------
		
		if (calendario.getTurnos() != null) {

			CalendarioWizardDTO wizard = new CalendarioWizardDTO();
			CalendariosSemanaisDTO intervalos = new CalendariosSemanaisDTO();
			DwCalsem dwCalSem = new DwCalsem();
			
			DwTurno dwTurno;
			
			for (CalendarioTurnoDTO turno : calendario.getTurnos()) {

				// ------------------------------------------------
				// Seta dados para a chamada do "wizard"
				// ------------------------------------------------
				
				wizard = new CalendarioWizardDTO();
				
				TurnoRN turnoRN = new TurnoRN();
				turnoRN.setDaoSession(dao.getSession());
				dwTurno = turnoRN.getDwTurnoPorCodigo(turno.getCdTurno());
				wizard.setTurno(dwTurno);
				
				wizard.setDiasSemana(turno.getDiasSemana());
				
				wizard.setHrInicioTurno(ConversaoTipos.converteHoraParaBigDecimal(turno.getHrInicio() + ":00"));
				wizard.setHrFinalTurno(ConversaoTipos.converteHoraParaBigDecimal(turno.getHrFim() + ":00"));
				
				BigDecimal duracao = ConversaoTipos.converteHoraParaBigDecimal(turno.getDuracao() + ":00");
				wizard.setDuracao(duracao.doubleValue());;
				
				double intervaloQuebraTurno = DataHoraRN.getHHMMEmSegundosCorrigida(turno.getIntervaloQuebraTurno());
				wizard.setIntervalo(intervaloQuebraTurno);
				
				wizard.setPosTolerancia(ConversaoTipos.converterParaBigDecimal(turno.getPosTolerancia()));
				wizard.setPreTolerancia(ConversaoTipos.converterParaBigDecimal(turno.getPreTolerancia()));
				
				wizard.setTpReferencia(turno.getTpRefInicioTurno());
				
				// ------------------------------------------------
				
				// Chama o wizard
				intervalos = rn.wizardCalendario(wizard);
				
				// Seta cada intervalo retornado pelo wizard
				for (CalendarioSemanalDTO intervalo : intervalos.getCalendariosSemanais()) {
				
					dwCalSem = new DwCalsem();
					dwCalSem = intervalo.getCalendarioSemanal();
					dwCalSem.setDwTurno(dwTurno);
					
					retorno.getDwCalsems().add(dwCalSem);
					
					calSemanal = new CalendarioSemanalDTO();
					calSemanal.setCalendarioSemanal(dwCalSem);
					calendarioSemanal.add(calSemanal);
					
				}
				
			}
			
			calendariosSemanais.setCalendariosSemanais(calendarioSemanal);			
			
		}
		
		// ---------------------------------------------------------------
		
		
		retorno.setDtRevisao(DataHoraRN.getDataHoraAtual());
		retorno.setDtStativo(retorno.getDtRevisao());
		
		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(calendario.getCdUsrRev(), rn.getDao());
		retorno.setOmUsrByIdUsrrevisao(omusrRevisao);
		retorno.setStAtivo((byte) 1);

		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		retorno.setOmUsrByIdUsrstativo(omusrStativo);
		
		if (!isInclusao) {
			DwCal regUpd = getCalendarioLocal(rn, calendario.getCdCalendario());
			retorno.setIdCal(regUpd.getIdCal());
			retorno.setRevisao(regUpd.getRevisao());
			regUpd = null;
			
		} else {
			retorno.setRevisao(0l);
		}
		
		calendarioSalvar.setCalendario(new DwCal());
		calendarioSalvar.setCalendario(retorno);
		calendarioSalvar.setCalendariosSemanais(calendariosSemanais);
		calendarioSalvar.setCalendarioPts(calPts);
		
		retorno = null;

		return calendarioSalvar;
	}
	
	// postos com calendário associado
	@GET
	@Path("/calendarios/ptscomcalendario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPtsComCalendario(@Context HttpServletRequest request) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();

			PTRN rn = new PTRN();
			rn.setDao(dao);

			List<CalendarioPtDTO2> retornoConsulta = rn.getPtsComCalendario();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.finalizaSessaoSemException();
			
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			dao.finalizaSessaoSemException();
			
		}
		
	}
	
	// postos sem calendários associados
	@GET
	@Path("/calendarios/ptssemcalendario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPtsSemCalendario(@Context HttpServletRequest request) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();

			PTRN rn = new PTRN();
			rn.setDao(dao);

			List<PtDTO2> retornoConsulta = rn.getPtsSemCalendario();
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.finalizaSessaoSemException();
			
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			dao.finalizaSessaoSemException();
			
		}
		
	}
	
	
	// calendário wizard
	@POST
	@Path("/calendarios/wizard")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCalendarioWizard(@Context HttpServletRequest request, CalendarioTurnoDTO turno) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			// dao.iniciaTransacao();
			
			// ------------------------------------------------
			// Seta dados para a chamada do "wizard"
			// ------------------------------------------------
			
			CalendarioWizardDTO wizard = new CalendarioWizardDTO();
			
			TurnoRN turnoRN = new TurnoRN();
			turnoRN.setDaoSession(dao.getSession());
			DwTurno dwTurno = turnoRN.getDwTurnoPorCodigo(turno.getCdTurno());
			wizard.setTurno(dwTurno);
			
			wizard.setDiasSemana(turno.getDiasSemana());
			
			wizard.setHrInicioTurno(ConversaoTipos.converteHoraParaBigDecimal(turno.getHrInicio() + ":00"));
			wizard.setHrFinalTurno(ConversaoTipos.converteHoraParaBigDecimal(turno.getHrFim() + ":00"));
			
			BigDecimal duracao = ConversaoTipos.converteHoraParaBigDecimal(turno.getDuracao() + ":00");
			wizard.setDuracao(duracao.doubleValue());;
			
			double intervaloQuebraTurno = DataHoraRN.getHHMMEmSegundosCorrigida(turno.getIntervaloQuebraTurno());
			wizard.setIntervalo(intervaloQuebraTurno);
			
			wizard.setPosTolerancia(ConversaoTipos.converterParaBigDecimal(turno.getPosTolerancia()));
			wizard.setPreTolerancia(ConversaoTipos.converterParaBigDecimal(turno.getPreTolerancia()));
			
			wizard.setTpReferencia(turno.getTpRefInicioTurno());
			
			// ------------------------------------------------
			
			
			CalendariosSemanaisDTO intervalosWizard = new CalendariosSemanaisDTO();
			
			CalendarioRN rn = new CalendarioRN();
			rn.setDao(dao.getDao());
			rn.setSession(dao.getSession());
			
			DwCalsem dwCalSem = new DwCalsem();
			DwCal dwCal = new DwCal();
			
			// Chama o wizard
			intervalosWizard = rn.wizardCalendario(wizard);
			
			// Seta cada intervalo retornado pelo wizard
			for (CalendarioSemanalDTO intervalo : intervalosWizard.getCalendariosSemanais()) {
			
				dwCalSem = new DwCalsem();
				dwCalSem = intervalo.getCalendarioSemanal();
				dwCalSem.setDwTurno(dwTurno);
				
				dwCal.getDwCalsems().add(dwCalSem);
				
			}
			
			
 		    // Cria objetos
 			List<CalendarioTurnoIntervaloDTO> intervalos;
 			CalendarioTurnoIntervaloDTO intervalo;
 			
			// Inicializa os intervalos
			intervalos = new ArrayList<CalendarioTurnoIntervaloDTO>();
			
 		  	// Percorre a semana do calendário
 			for (DwCalsem intervaloSemana : dwCal.getDwCalsems()) {

				// Inicializa o intervalo
				intervalo = new CalendarioTurnoIntervaloDTO();
 				
			    // Seta os dados do intervalo
				
				if (intervaloSemana.getOrdem() == null) {
					intervalo.setOrdem(0);	
				} else {
					intervalo.setOrdem(intervaloSemana.getOrdem());
				}
						
 				intervalo.setHrInicio(intervaloSemana.getHrInicialGui());
 				intervalo.setHrFim(intervaloSemana.getHrFinalGui());
		 			
		 		// Calcula a duração do intervalo
		 		duracao = intervaloSemana.getHrFinal().subtract(intervaloSemana.getHrInicial());
		 		
		 		// Se a duração for negativa siginifica que o intervalo começa em um dia e termina no outro
		 		if (duracao.intValue() < 0) {
		 			
 					// Recalcula a duração
 					
 					BigDecimal duracao1 = intervaloSemana.getHrFinal();
 					BigDecimal tempo24horas = new BigDecimal(86400);
 					BigDecimal duracao2 = tempo24horas.subtract(intervaloSemana.getHrInicial());
 					
 					duracao = duracao1.add(duracao2);
		 					
		 		}
		 		
 				// Formata a duração para HH:MM
 				String duracaoIntervalo = DataHoraRN.formatSegundosParaHHMM(duracao.intValue());
 				intervalo.setDuracao(duracaoIntervalo);
 				
 				intervalo.setDiaSemana(ConversaoTipos.converteParaInt(ConversaoTipos.converteParaString(intervaloSemana.getDiasemana(), 0)));
 				
				intervalo.setCdTurno(turno.getCdTurno());
				
				long preToleracia = ConversaoTipos.converterParaLong(intervaloSemana.getSegToleranciapre().intValue());
				long posToleracia = ConversaoTipos.converterParaLong(intervaloSemana.getSegToleranciapos().intValue());
				intervalo.setPreTolerancia(preToleracia);
				intervalo.setPosTolerancia(posToleracia);
				
				intervalo.setTpRefInicioTurno(intervaloSemana.getTpDtreferencia());
				
				intervalo.setIsInicioDeTurno(intervaloSemana.getIsInicioturno());
				intervalo.setIsFimDeTurno(intervaloSemana.getIsFimturno());
				
 				// Adiciona o intervalo
 				intervalos.add(intervalo);
		 				
		 		
			}
			

			// Primeiro ordena os intervalos pelo "dia da semana"
			java.util.Collections.sort(intervalos, new Comparator<CalendarioTurnoIntervaloDTO>() {
				@Override
				public int compare(CalendarioTurnoIntervaloDTO o1, CalendarioTurnoIntervaloDTO o2) {
					return o1.getDiaSemana().compareTo(o2.getDiaSemana());
				}
			});

			
 			// Agora ordena pela "hora de início do intervalo"
			java.util.Collections.sort(intervalos, new Comparator<CalendarioTurnoIntervaloDTO>() {
				@Override
				public int compare(CalendarioTurnoIntervaloDTO o1, CalendarioTurnoIntervaloDTO o2) {
					return o1.getHrInicio().compareTo(o2.getHrInicio());
				}
			});
			
			
			return getResponse(gson, intervalos);
			

		} catch (Exception e) {
			// dao.rollBackTransacaoSemException();
			dao.finalizaSessaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			dao.finalizaSessaoSemException();
			
		}
		
	}
	
	
	

	// Atualiza a parte do JSON de retorno do calendário referente aos postos
	private CalendarioDTO2 MontaRetornoPostosCalendario(CalendarioDTO2 calendarioDTO, DAOGenerico dao) {
		
		// Carrega todos os postos ativos (selecionados ou não pelo usuário)
		PTRN ptRN = new PTRN();
		FiltroPesquisaDTO filtroPts = new FiltroPesquisaDTO();
		filtroPts.setPagina(1);
		filtroPts.setRegistrosPorPagina(1000);				
		ptRN.setDao(dao);
		ptRN.setDaoSession(dao.getSession());
		ListaPTsDTO pstAtivos = ptRN.getPtsDTO(filtroPts);
		List<PtDTO2> listaPts = pstAtivos.getItems();
		
		List<CalendarioPtDTO2> pts = new ArrayList<CalendarioPtDTO2>();
		CalendarioPtDTO2 pt;
		
		// Percorre a lista dos postos ativos
		for (int index = 0; index < listaPts.size(); index++) {

			PtDTO2 item = listaPts.get(index);
			
			pt = new CalendarioPtDTO2();
			pt.setCdPt(item.getCdPt());
			pt.setDsPt(item.getDsPt());
			pt.setSelecionado(false);
			
			if (calendarioDTO.getPts() != null) {
				
	 		  	// Percorre os pts selecionados pelo usuário
	 			for (CalendarioPtDTO2 ptSelecionado : calendarioDTO.getPts()) {

	 				// Se o "pt ativo" estiver no calendário...
					if (item.getCdPt().equals(ptSelecionado.getCdPt())) {
						pt.setSelecionado(true);
						break;
					}
					
	 			}
	 			
			}
 			
 			pts.add(pt);

		}
		
		// Remove todos os pts de "calendarioDTO"
		if (calendarioDTO.getPts() != null) {
			calendarioDTO.getPts().removeAll(pts);	
		}
		
		// Atualiza a lista de pts de "calendarioDTO"
		if (pts != null) {
			calendarioDTO.setPts(pts);	
		}
		
		return calendarioDTO;
		
	}
	
	
	// Atualiza a parte do JSON de retorno do calendário referente aos intervalos
	private CalendarioDTO2 MontaRetornoIntervalosCalendario(CalendarioDTO2 calendarioDTO, CalendarioDTO calendario) {
		
		List<CalendarioTurnoIntervaloDTO> intervalos = new ArrayList<CalendarioTurnoIntervaloDTO>();
		CalendarioTurnoIntervaloDTO intervalo;
		
		// Como o "retorno" não retorna os dados do turno, foi necessário usar a variável "calendario"
		for (DwCalsem calSem : calendario.getCalendario().getDwCalsems()) {
		
			intervalo = new CalendarioTurnoIntervaloDTO();
			intervalo.setHrInicio(calSem.getHrInicialGui());
			intervalo.setHrFim(calSem.getHrFinalGui());
			intervalo.setDuracao(DataHoraRN.formatSegundosParaHHMM(calSem.getSegTempocalendario().intValue()));
			intervalo.setCdTurno(calSem.getDwTurno().getCdTurno());
			
			int index = 0;
			
			for (CalendarioTurnoDTO turno : calendarioDTO.getTurnos()) {
				
				if (turno.getCdTurno().equals(calSem.getDwTurno().getCdTurno())) {
					
					turno.setDsTurno(calSem.getDwTurno().getDsTurno());
					turno.setCor(calSem.getDwTurno().getCor());
					
					calendarioDTO.getTurnos().set(index, turno);
					break;
				}
				
				index = index + 1;
				
			}

			intervalo.setDiaSemana(calSem.getDiasemana().intValue());
			intervalo.setPreTolerancia(calSem.getSegToleranciapre().longValue());
			intervalo.setPosTolerancia(calSem.getSegToleranciapos().longValue());
			intervalo.setTpRefInicioTurno(calSem.getTpDtreferencia());
			intervalo.setOrdem(calSem.getOrdem());
			intervalo.setIsInicioDeTurno(calSem.getIsInicioturno());
			intervalo.setIsFimDeTurno(calSem.getIsFimturno());
			
			intervalos.add(intervalo);
			
		}
		
		// Primeiro ordena os intervalos pelo "dia da semana"
		java.util.Collections.sort(intervalos, new Comparator<CalendarioTurnoIntervaloDTO>() {
			@Override
			public int compare(CalendarioTurnoIntervaloDTO o1, CalendarioTurnoIntervaloDTO o2) {
				return o1.getDiaSemana().compareTo(o2.getDiaSemana());
			}
		});
		
		// Agora ordena pela "hora de início do intervalo"
		java.util.Collections.sort(intervalos, new Comparator<CalendarioTurnoIntervaloDTO>() {
			@Override
			public int compare(CalendarioTurnoIntervaloDTO o1, CalendarioTurnoIntervaloDTO o2) {
				return o1.getHrInicio().compareTo(o2.getHrInicio());
			}
		});
		
		calendarioDTO.setIntervalos(intervalos);
		
		return calendarioDTO;
		
	}
	
	// excluir (desativar)
	@PUT
	@Path("/calendarios/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirDesativarCalendario(@Context HttpServletRequest request, CalendarioDTO2 calendarioDTO) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CalendarioRN rn = new CalendarioRN();
			rn.setDao(dao);
			rn.setSession(dao.getSession());

			CalendarioDTO calendario = CalendarioAtribuiValoresPadraoSalvar(rn, calendarioDTO, false, dao);
			CalendariosDTO calendarios = new CalendariosDTO();
			calendarios.setCalendarios(new ArrayList<CalendarioDTO>());
			calendarios.getCalendarios().add(calendario);
			CalendariosDTO retorno = rn.removeCalendariosDTO(calendarios);
			
			dao.commitaTransacao();

			if (retorno == null) {
				throw new JsonException("Error");
				
			} else {
				if (retorno.getCalendarios().get(0).getResultadoEvento() != retorno.getCalendarios().get(0).getEVENTO_BEM_SUCEDIDO()) {
					responseStatus = Response.Status.BAD_REQUEST;
					
					// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
					String codigoErro = CodigoErro(CALENDARIOS, retorno.getCalendarios().get(0).getResultadoEvento());
					ErrorDTO2 error = new ErrorDTO2(codigoErro);
					
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();
				} else {
					calendarioDTO.setIdCalendario(retorno.getCalendarios().get(0).getCalendario().getIdCal());
					calendarioDTO.setStRegistro(0);

					String json = gson.toJson(calendarioDTO);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (JsonException je) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), je.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
		
	}
	
	
	private Response getResponse(Gson gson, Object retornoConsulta) {
		Response.Status responseStatus = Response.Status.OK;
		gson = new Gson();
		String json = gson.toJson(retornoConsulta);
		return Response.status(responseStatus).entity(json).build();
	}
	
	private Response getResponse(Gson gson, Object retornoConsulta, Integer stRegistro) {
		Response.Status responseStatus = Response.Status.OK;
		gson = new Gson();
		String json;
		
		if (stRegistro== null) {
			return Response.status(responseStatus).build();
		} else {
			json = gson.toJson(retornoConsulta);
			return Response.status(responseStatus).entity(json).build();				
		}			
	}

	private Response getResponse(Gson gson, Object retornoConsulta, String valor) {
		Response.Status responseStatus = Response.Status.OK;
		gson = new Gson();
		String json;
		
		if (valor== null) {
			return Response.status(responseStatus).build();
		} else {
			json = gson.toJson(retornoConsulta);
			return Response.status(responseStatus).entity(json).build();				
		}			
	}
	
	
	// ordens de produção 
	@GET
	@Path("/ops")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOPsAtivas(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa,
			@QueryParam("pagina") Integer pagina, @QueryParam("registrosPorPagina") Integer registrosPorPagina) {
		TokenFilter.validarNIDW(request);
		
		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, pagina, registrosPorPagina);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CpRN rn = new CpRN(dao); 

			ListaOPSimplesPesqDTO retornoConsulta = rn.getOPsSimplesAtivas(filtro);
			dao.commitaTransacao();			
			return getResponse(gson, retornoConsulta);

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
		
	}

	// ordens de produção
	@GET
	@Path("/ops/ptsnovaop")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPtsAtivos(@Context HttpServletRequest request, @QueryParam("conteudoPesquisa") String conteudoPesquisa) {
		TokenFilter.validarNIDW(request);

		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, 1, qtdItensCadRetornoLista);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			PTRN rn = new PTRN();
			rn.setDao(dao);

			ListaPTsDTO retornoConsulta = rn.getPtsDTO(filtro);
			dao.commitaTransacao();
			return getResponse(gson, getListaPtsCadOP(retornoConsulta));

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	private List<OPPtCadDTO> getListaPtsCadOP(ListaPTsDTO listaPtsCad) {
		List<OPPtCadDTO> retorno = new ArrayList<OPPtCadDTO>();

		for (PtDTO2 ptCad : listaPtsCad.getItems()) {
			OPPtCadDTO pt = new OPPtCadDTO();
			pt.setCdPt(ptCad.getCdPt());
			pt.setStatusCp(-1);
			pt.setEditavel(true);

			retorno.add(pt);
		}

		return retorno;
	}

	
	@GET
	@Path("/ops/{nrDoc: (.+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCP(@Context HttpServletRequest request, @PathParam("nrDoc") String nrDoc) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CpRN rn = new CpRN(dao);

			OPCadDTO retornoConsulta = rn.getCpByCd(nrDoc);
			dao.commitaTransacao();
			return getResponse(gson, retornoConsulta, retornoConsulta.getNrDoc());	

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}


	// incluir
	@POST
	@Path("/ops/incluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarNovasOps(@Context HttpServletRequest request, OPCadDTO opsDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CpRN rn = new CpRN(dao);
			
			ListaCPDTO cp = OPSimplesAtribuiValoresPadraoSalvar(rn, opsDTO, true);
			ListaCPDTO retorno = rn.salvarPpCpOrdemProducao(cp);
			
			dao.commitaTransacao();
			
			if (!retorno.getResultado().isComSucesso()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(ORDENS_PRODUCAO_SIMPLIFICADA, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				String json = gson.toJson(retorno.getResultado().isComSucesso());
				return Response.status(responseStatus).entity(json).build();
			}
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}
	
	
	
	// alterar
	@PUT
	@Path("/ops/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAlteracaoOps(@Context HttpServletRequest request, OPCadDTO opsDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			CpRN rn = new CpRN(dao);
			
			ListaCPDTO cp = OPSimplesAtribuiValoresPadraoSalvar(rn, opsDTO, false);
			ListaCPDTO retorno = rn.salvarPpCpOrdemProducao(cp);
			
			dao.commitaTransacao();
			
			if (!retorno.getResultado().isComSucesso()) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				String codigoErro = CodigoErro(ORDENS_PRODUCAO_SIMPLIFICADA, retorno.getResultado().getIdmensagem());
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				String json = gson.toJson(retorno.getResultado().isComSucesso());
				return Response.status(responseStatus).entity(json).build();
			}
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}

	}
	 
	
	// excluir (desativar)
	@PUT
	@Path("/ops/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarExcluirOps(@Context HttpServletRequest request, OPCadDTO opsDTO) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			OpSimplesRN rn = new OpSimplesRN(dao);
			
			int retorno = rn.excluirOPSimples(opsDTO.getNrDoc());
			
			dao.commitaTransacao();
			
			if (retorno == 0) {
				responseStatus = Response.Status.BAD_REQUEST;
				
				// ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "ERRO-0002", "");
				// No caso da exclusão, sempre será "ERRO DESCONHECIDO" (para esse cadastro, código 0)
				String codigoErro = CodigoErro(ORDENS_PRODUCAO_SIMPLIFICADA, 0);
				ErrorDTO2 error = new ErrorDTO2(codigoErro);
				
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				String json = gson.toJson(true);
				return Response.status(responseStatus).entity(json).build();
			}
			
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);

		} finally {
			dao.finalizaSessaoSemException();
		}
	}


	private ListaCPDTO OPSimplesAtribuiValoresPadraoSalvar(CpRN rn, OPCadDTO op, boolean isInclusao) {
		ListaCPDTO listaSalvar = new ListaCPDTO();
		listaSalvar.setListaCps(new ArrayList<CpDTO>());
		listaSalvar.setIsInclusao(isInclusao);
		
		
		OmUsr omusrRevisao = new OmUsr();
		omusrRevisao = getUsrLocal(op.getCdUsrRev(), rn.getDao());
		
		OmUsr omusrStativo = new OmUsr();
		omusrStativo = omusrRevisao;
		
		FolhaRN rnFolha = new FolhaRN(rn.getDao());
		DwFolha folha =  rnFolha.getDwFolhaByCd(op.getCdFolha());
		
		PpClienteRN rnCliente = new PpClienteRN(rn.getDao());
		PpCliente cliente = null;
		if (op.getCdCliente() != null && op.getCdCliente() != "") {
			cliente = rnCliente.getPpCliente(op.getCdCliente());
		}
		
		OmPtDAO rnPt = new OmPtDAO(rn.getDaoSession());
		
		Integer sequencial = 1;
		for (OPPtCadDTO ptOP : op.getPtsSelecionados()) {
			CpDTO cp = new CpDTO();
			cp.setOrdensProducaoProdutoDTO(new ArrayList<OrdemProducaoProdutoDTO>());
			
			// pt
			OmPt pt = rnPt.getOmPtAtivoComUltimaRevisao(ptOP.getCdPt());
			
			PpCp ppcp = new PpCp();
			ppcp.setCdCp(op.getNrDoc().concat(sequencial.toString()));
            ppcp.setDthrInicio(DataHoraRN.stringToDate(op.getDthrIniPlan(), "yyyy-MM-dd HH:mm:ss"));
            ppcp.setDthrFinal(DataHoraRN.stringToDate(op.getDthrFimPlan(), "yyyy-MM-dd HH:mm:ss"));
            ppcp.setDwFolha(folha);
            ppcp.setPpCliente(cliente);
            ppcp.setIdCp(null);
            ppcp.setOmPt(pt);
            ppcp.setOmUsrByIdUsrrevisao(omusrRevisao);
            ppcp.setOmUsrByIdUsrstativo(omusrStativo);
            ppcp.setStCp(0); // cadastrada
            ppcp.setTpCp(0); // producao
            ppcp.setIsFinalserie(op.getCpCritica());

            // percorre lista de produtos
            for (DwFolharapcom frc : folha.getDwFolharaps().iterator().next().getDwFolharapcoms()) {
                OmProduto profrc = frc.getOmProduto();
                PpCpproduto cpproduto = new PpCpproduto();
                cpproduto.setNrDoc(op.getNrDoc());
                cpproduto.setOmProduto(profrc);
                cpproduto.setPcsProducaoplanejada(op.getProdPlan().setScale(0, RoundingMode.DOWN));
                
                ppcp.getPpCpprodutos().add(cpproduto);
            }
            
            
            cp.setCp(ppcp);
            listaSalvar.getListaCps().add(cp);
    		
			sequencial++;
		}
		
		
		rnFolha = null;
		rnCliente = null;
		rnPt = null;

		return listaSalvar;
		
	}
	
	private String CodigoErro(int nomeCadastroOuLogin, int codigo) {
		
		String retorno = "";
		int tabelaRetorno = nomeCadastroOuLogin;
		
		// Como a versão do Java usada neste projeto não permite múltiplas condições em "case", foi necessário
		// fazer esse tratamento inicial antes de entrar no "switch".
		
		// -----------------------------------------------------------------
		// Cadastros que usam a classe ResultadoDTO para tratamento de erros
		// -----------------------------------------------------------------
		if ((nomeCadastroOuLogin == CAUSAS) ||
			(nomeCadastroOuLogin == ALERTAS) ||
			(nomeCadastroOuLogin == REFUGOS) ||
			(nomeCadastroOuLogin == PARADAS) ||
			(nomeCadastroOuLogin == ORDENS_PRODUCAO_SIMPLIFICADA) ||
			(nomeCadastroOuLogin == FERRAMENTAS)
			) {
		
			
			tabelaRetorno = RESULTADO_DTO;
			
		}
		
		// -----------------------------------------------------------------
		

		// -------------------------------------------------------------------
		// Cadastros que usam a classe ResultadoMsDTO para tratamento de erros
		// -------------------------------------------------------------------
		if ((nomeCadastroOuLogin == IHMS) ||
			(nomeCadastroOuLogin == INTERFACE_COLETOR) ||
			(nomeCadastroOuLogin == MODULO_SINAIS) ||
			(nomeCadastroOuLogin == UPS)
			) {
		
			
			tabelaRetorno = RESULTADO_MS_DTO;
			
		}
		
		// -------------------------------------------------------------------

		
		
		switch (tabelaRetorno) {
			
			case AUTENTICACAO_USUARIO:
				// FALHA_AUTENTICACAO
				retorno = "0001";
				break;
				
			
			/*
			// Como não há tratamento de erro para o cadastro de clientes, achei melhor retirar esse trecho
			// para não nos confundir achando que tem.			 
			case CLIENTES:
				// ERRO_DESCONHECIDO
				retorno = "0002";
				break;
			*/
			
			
			case RESULTADO_DTO:
				
				switch (codigo) {
					
 				    // ERRO_DESCONHECIDO
					case 0: retorno = "0002"; break;

					// SEM_CONFIGURACAO
					case 2: retorno = "0004"; break;
					
					// PT_DESCONHECIDO
					case 3: retorno = "0005"; break;
					
					// TIPO_PT_DESCONHECIDO
					case 4: retorno = "0006"; break;
					
					// USUARIO_DESCONHECIDO
					case 5: retorno = "0007"; break;
					
					// LOGIN_NAO_HOMOLOGADO
					case 6: retorno = "0008"; break;
					
					// LOGIN_GT_COM_SUCESSO
					case 7: retorno = "0009"; break;
					
					// LOGIN_GT_PRE_EXISTENTE
					case 8: retorno = "0010"; break;
					
					// LOGIN_PT_PRE_EXISTENTE
					case 9: retorno = "0011"; break;
					
					// LOGIN_PT_COM_SUCESSO
					case 10: retorno = "0012"; break;
					
					// SUPERVISOR_NAO_LOGADO
					case 11: retorno = "0013"; break;
					
					// OUTRO_SUPERVISOR_LOGADO
					case 12: retorno = "0014"; break;
					
					// LOGOUT_GT_COM_SUCESSO
					case 13: retorno = "0015"; break;
					
					// OPERADOR_NAO_LOGADO
					case 14: retorno = "0016"; break;
					
					// OUTRO_OPERADOR_LOGADO
					case 15: retorno = "0017"; break;
					
					// LOGOUT_PT_COM_SUCESSO
					case 16: retorno = "0018"; break;
					
					// PRODUTO_DESCONHECIDO
					case 17: retorno = "0019"; break;
					
					// LOGON_DE_SUPERVISOR
					case 18: retorno = "0020"; break;
					
					// LOGOFF_DE_SUPERVISOR
					case 19: retorno = "0021"; break;
					
					// LOGON_DE_OPERADOR
					case 20: retorno = "0022"; break;

					// LOGOFF_DE_OPERADOR
					case 21: retorno = "0023"; break;
					
					// RE_NAO_AUTORIZADO
					case 22: retorno = "0024"; break;
					
					// PRODUTO_NAO_DEVE_PASSAR_POR_POSTO
					case 23: retorno = "0025"; break;
					
					// ROTEIRO_INCONSISTENTE
					case 24: retorno = "0026"; break;
					
					// PRODUTO_ENTROU_NAO_CONFORME
					case 25: retorno = "0027"; break;
					
					// DEFEITO_DESCONHECIDO
					case 26: retorno = "0028"; break;
					
					// PRODUTO_NAO_ACEITO
					case 27: retorno = "0029"; break;
					
					// ACOPLAMENTO_FINALIZADO
					case 28: retorno = "0030"; break;
					
					// SEM_SGBD
					case 29: retorno = "0031"; break;
					
					// ERROR_SEM_CALENDARIO
					case 30: retorno = "0032"; break;
					
					// ERROR_GT_DESCONHECIDO
					case 31: retorno = "0033"; break;
					
					// ACAO_DESCONHECIDA
					case 32: retorno = "0034"; break;
					
					// CB_NULO
					case 33: retorno = "0035"; break;
					
					// COMPONENTE_NAO_PERTENCE_AO_PRODUTO
					case 34: retorno = "0036"; break;
					
					// CONFIGURACAO_DESCONHECIDA
					case 35: retorno = "0037"; break;
					
					// ERRO_CONFIGURACAO_SENDO_USADA
					case 36: retorno = "0038"; break;
					
					// ERRO_PEPRO_DESCONHECIDO
					case 37: retorno = "0039"; break;
					
					// ERRO_CC_DESCONHECIDO
					case 38: retorno = "0040"; break;
					
					// COMPONENTE_DESCONHECIDO
					case 39: retorno = "0041"; break;
					
					// LOGIN_MANUTENCAO
					case 40: retorno = "0042"; break;
					
					// LOGIN_AFERICAO
					case 41: retorno = "0043"; break;
					
					// ERRO_EXCLUI_STATIVO_ZERO
					case 42: retorno = "0044"; break;
					
					// CODIGO_DESCONHECIDO
					case 43: retorno = "0045"; break;
					
					// PLANO_DESCONHECIDO
					case 44: retorno = "0046"; break;
					
					// REGISTRO_JA_EXISTE
					case 45: retorno = "0047"; break;
					
					// IMP_CLIENTE_DESCONHECIDO
					case 46: retorno = "0048"; break;
					
					// IMP_PRODUTO_DESCONHECIDO
					case 47: retorno = "0049"; break;
					
					// IMP_PLANILHA_NAO_ATENDE_FORMATO_TIPO_A
					case 48: retorno = "0050"; break;
					
					// IMP_NAO_EXISTE_QUANTIDADE_PLANEJADA
					case 49: retorno = "0051"; break;
					
					// IMP_MES_DESCONHECIDO
					case 50: retorno = "0052"; break;
					
					// IMP_ANO_DESCONHECIDO
					case 51: retorno = "0053"; break;
					
					// IMP_DATA_INVALIDA
					case 52: retorno = "0054"; break;
					
					// IMP_PPNECIMPURL_DESCONHECIDO
					case 53: retorno = "0055"; break;
					
					// NECIMP_DESCONHECIDO
					case 54: retorno = "0056"; break;
					
					// CALENDARIO_DESCONHECIDO
					case 55: retorno = "0057"; break;
					
					// TIPO_PLANO_DESCONHECIDO
					case 56: retorno = "0058"; break;
					
					// NECESSIDADE_DESCONHECIDA
					case 57: retorno = "0059"; break;
					
					// CP_DESCONHECIDA
					case 58: retorno = "0060"; break;
					
					// RAP_DESCONHECIDO
					case 59: retorno = "0061"; break;
					
					// ERROR_PLANO_JA_FIRMADO
					case 60: retorno = "0062"; break;
					
					// ERROR_PLANO_MUITO_ANTIGO
					case 61: retorno = "0063"; break;
					
					// ERROR_PLANO_SEM_CP
					case 62: retorno = "0064"; break;
					
					// ERROR_CICLO_PADRAO
					case 63: retorno = "0065"; break;
					
					// ERRO_PARADA_DESCONHECIDA
					case 64: retorno = "0066"; break;
					
					// EST_LOCAL_DESCONHECIDO
					case 65: retorno = "0067"; break;
					
					// ESTOQUE_DESCONHECIDO
					case 66: retorno = "0068"; break;
					
					// ERRO_RES_GUI_DESCONHECIDO
					case 67: retorno = "0069"; break;
					
					// TIPO_GT_DESCONHECIDO
					case 68: retorno = "0070"; break;
					
					// GRP_USUARIO_DESCONHECIDO
					case 69: retorno = "0071"; break;
					
					// FT_PARAM_DESCONHECIDO
					case 70: retorno = "0072"; break;
					
					// OP_COM_PRODUCAO
					case 71: retorno = "0073"; break;
					
					// REFUGO_DESCONHECIDO
					case 72: retorno = "0074"; break;
					
					// QTD_TEC_INVALIDA
					case 73: retorno = "0075"; break;
					
					// ALERTA_TIPO_INVALIDO
					case 74: retorno = "0076"; break;
					
					// PARADA_TIPO_INVALIDO
					case 75: retorno = "0077"; break;
					
					// TIMEOUT_INVALIDO
					case 76: retorno = "0078"; break;
					
					// CLASSIFICACAOABC_INVALIDO
					case 77: retorno = "0079"; break;
					
					// RITMO_INVALIDO
					case 78: retorno = "0080"; break;
					
					// EMPRESA_INVALIDA
					case 79: retorno = "0081"; break;
					
					// CODIGO_EM_USO
					case 80: retorno = "0082"; break;
					
					// PRODUTO_ACABADO_INVALIDO
					case 81: retorno = "0083"; break;
					
					// PRODUTO_SEMI_ACABADO_INVALIDO
					case 82: retorno = "0084"; break;
					
					// ALGORITMO_BALANCEAMENTO_INVALIDO
					case 83: retorno = "0085"; break;
					
					// STATUS_BALANCEAMENTO_INVALIDO
					case 84: retorno = "0086"; break;
					
					// ERRO_REATIVACAO_INDISPONIVEL
					case 85: retorno = "0087"; break;
					
					// ERRO_REGISTRO_DESCONHECIDO
					case 86: retorno = "0088"; break;
					
					// FOLHA_DESCONHECIDA
					case 87: retorno = "0089"; break;
					
					// ERRO_CODIGO_EM_USO_NA_COFIGURACAO_GERAL
					case 88: retorno = "0090"; break;
					
					// ERRO_CC_VAZIO
					case 89: retorno = "0091"; break;
					
					// FORA_FAIXA
					case 90: retorno = "0092"; break;
					
					// SEM_MAC_DISPONIVEL
					case 91: retorno = "0093"; break;
					
					// ORIGEM_DESCONHECIDA
					case 92: retorno = "0094"; break;
					
					// FORA_LIMITE
					case 93: retorno = "0095"; break;
						
				}

				break;
				
			
			case RESULTADO_MS_DTO:
				
				switch (codigo) {
					
				    // ERRO_DESCONHECIDO
					case 0: retorno = "0176"; break;
					
				    // ERRO_CDIC_DESCONHECIDO
					case 2: retorno = "0178"; break;
				    
					// ERRO_EXCLUI_STATIVO_ZERO
					case 3: retorno = "0179"; break;
					
				    // ERRO_URL_DESCONHECIDA
					case 4: retorno = "0180"; break;
				    
					// ERRO_CDMS_DESCONHECIDO
					case 5: retorno = "0181"; break;
					
				    // ERRO_LISTA_VAZIA
					case 6: retorno = "0182"; break;
				    
					// ERRO_CDUP_DESCONHECIDO
					case 7: retorno = "0183"; break;
					
				    // ERRO_SALVA_STATIVO_ZERO
					case 8: retorno = "0184"; break;
				    
					// ERRO_USUARIO_DESCONHECIDO
					case 9: retorno = "0185"; break;
					
				    // ERRO_TPIC_INVALIDO
					case 10: retorno = "0186"; break;
				    
					// ERRO_IMPORTACAO_JA_OCORREU
					case 11: retorno = "0187"; break;
					
				    // ERRO_IHM_JA_VINCULADO
					case 12: retorno = "0188"; break;
				    
					// ERRO_URL_CONEXAO_JA_CADASTRADA
					case 13: retorno = "0189"; break;
					
				    // ERRO_IP_JA_CADASTRADA
					case 14: retorno = "0190"; break;
				    
					// ERRO_IC_JA_CADASTRADO
					case 15: retorno = "0191"; break;
				    
					// ERRO_UP_EXCLUIDA
					case 16: retorno = "0192"; break;
					
				}
								
				break;

				
			case ACOES:
				
				switch (codigo) {
					
			    	// ERRO_ACAO_JA_EXISTE
					case 1: retorno = "0111"; break;
				
			    	// ERRO_DESCONHECIDO
					case 3: retorno = "0112"; break;
					
			    	// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0113"; break;
					
			    	// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 5: retorno = "0114"; break;
					
			    	// ERRO_CDACAO_INVALIDO
					case 6: retorno = "0115"; break;
					
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 7: retorno = "0116"; break;
					
			    	// ERRO_TIPOPOSTO_DESCONHECIDO
					case 8: retorno = "0117"; break;
					
				}

				break;
				
				
			case AREAS_RESPONSAVEIS:
				
				switch (codigo) {
					
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 7: retorno = "0119"; break;
				
				}

				break;

				
			case CALENDARIOS:
				
				switch (codigo) {
					
			    	// ERRO_CALENDARIO_JA_EXISTE
					case 1: retorno = "0222"; break;
					
			    	// ERRO_DESCONHECIDO
					case 3: retorno = "0223"; break;
	
			    	// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0224"; break;
					
			    	// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 5: retorno = "0225"; break;
	
			    	// ERRO_CDCALENDARIO_INVALIDO
					case 6: retorno = "0226"; break;
					
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 7: retorno = "0227"; break;
	
			    	// ERRO_DATAFINAL_INFERIOR
					case 8: retorno = "0228"; break;
					
			    	// ERRO_INICIOTURNO_SEM_FIM_ANTERIOR
					case 9: retorno = "0229"; break;
	
			    	// ERRO_FIMTURNO_SEM_INICIO_ANTERIOR
					case 10: retorno = "0230"; break;
					
			    	// ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO
					case 11: retorno = "0231"; break;
	
			    	// ERRO_DIADASEMANA_DESCONHECIDO
					case 12: retorno = "0232"; break;
						
			    	// ERRO_HORAFINAL_MENOR_HORAINICIAL
					case 13: retorno = "0233"; break;
	
			    	// ERRO_TEMPOCALENDARIO_INVALIDO
					case 14: retorno = "0234"; break;
					
			    	// ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO
					case 15: retorno = "0235"; break;
	
			    	// ERRO_TIPODATAREFERENCIA_INVALIDO
					case 16: retorno = "0236"; break;
					
			    	// ERRO_TURNO_DESCONHECIDO
					case 17: retorno = "0237"; break;
	
			    	// ERRO_DATAINICIAL_INVALIDA
					case 18: retorno = "0238"; break;
					
			    	// ERRO_EXISTE_CALENDARIO_EM_ABERTO
					case 19: retorno = "0239"; break;
	
			    	// ERRO_PERIODO_CALENDARIO_CONFLITA
					case 20: retorno = "0240"; break;
					
			    	// ERRO_TURNO_REPETIDO_MESMO_DIA 
					case 21: retorno = "0241"; break;
					
				}
	
				break;

				
			case CARGOS:
				
				switch (codigo) {
					
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 7: retorno = "0104"; break;
				
				}

				break;
				
				
			case FOLHAS_PROCESSOS:
				
				switch (codigo) {
					
			    	// ERRO_FOLHA_JA_EXISTE
					case 1: retorno = "0193"; break;
					
			    	// ERRO_DESCONHECIDO
					case 3: retorno = "0194"; break;
	
			    	// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0195"; break;
					
			    	// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 5: retorno = "0196"; break;
	
			    	// ERRO_CDFOLHA_INVALIDO
					case 6: retorno = "0197"; break;
					
			    	// ERRO_TIPOFOLHA_DESCONHECIDO
					case 7: retorno = "0198"; break;
					
			    	// ERRO_GT_DESCONHECIDO
					case 8: retorno = "0199"; break;
					
			    	// ERRO_TIPOPOSTO_DESCONHECIDO
					case 9: retorno = "0200"; break;
	
			    	// ERRO_TESTE_FUNCIONAL_NAO_DEFINIDOS
					case 10: retorno = "0201"; break;
					
			    	// ERRO_RELACAO_PARTES_FALTANDO
					case 11: retorno = "0202"; break;
	
			    	// ERRO_PRODUTO_PRINCIPAL_DESCONHECIDO
					case 12: retorno = "0203"; break;
					
			    	// ERRO_PRODUTO_COMPONENTE_DESCONHECIDO
					case 13: retorno = "0204"; break;
	
			    	// ERRO_TENSAO_INVALIDA
					case 14: retorno = "0205"; break;
					
			    	// ERRO_PRODUTO_DESCONHECIDO
					case 15: retorno = "0206"; break;
	
			    	// ERRO_SUBETAPA_INVALIDA
					case 16: retorno = "0207"; break;
					
					// ERRO_TEMPO_POSFALHA_INVALIDO
					case 17: retorno = "0208"; break;
	
			    	// ERRO_PARAMETRO_INVALIDO
					case 18: retorno = "0209"; break;
					
			    	// ERRO_LIMITES_MEDICAO_INCONSISTENTES
					case 19: retorno = "0210"; break;
	
			    	// ERRO_VALOR_PARAMETRO_INVALIDO
					case 20: retorno = "0211"; break;
					
			    	//  ERRO_DWRAP_DESCONHECIDA
					case 21: retorno = "0212"; break;

			    	// ERRO_OMPRG_DESCONHECIDO
					case 22: retorno = "0213"; break;
					
			    	// ERRO_FOLHA_DESCONHECIDA
					case 23: retorno = "0214"; break;
	
			    	// ERRO_PT_DESCONHECIDO
					case 24: retorno = "0215"; break;
					
			    	// ERRO_PROCEDIMENTO_DESCONHECIDO
					case 25: retorno = "0216"; break;
	
			    	// ERRO_CICLO_INVALIDO
					case 26: retorno = "0217"; break;
					
			    	// ERRO_PRODUCAO_CICLO_INVALIDA
					case 27: retorno = "0218"; break;
	
			    	// ERRO_OU_RAP_OU_PRODUTOFABRICADO
					case 28: retorno = "0219"; break;
					
			    	// ERRO_EMBALAGEM_DESCONHECIDA
					case 29: retorno = "0220"; break;
	
			    	// ERRO_SCRIPT_DESCONHECIDO
					case 30: retorno = "0221"; break;
					
				}

				break;

				
			case GRUPOS_FERRAMENTAS:
				
				switch (codigo) {

			    	// ERRO_CD_INVALIDO
					case 1: retorno = "0105"; break;
				
			    	// ERRO_GP_FERRAMENTA_JA_EXISTE
					case 2: retorno = "0106"; break;
			    
					// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 3: retorno = "0107"; break;

			    	// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0108"; break;

			    	// ERRO_DESCONHECIDO
					case 5: retorno = "0109"; break;

			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 7: retorno = "0110"; break;
					
				}

				break;

				
			case GRUPOS_TRABALHO:
				
				switch (codigo) {
					
			    	// ERRO_GT_JA_EXISTE
					case 1: retorno = "0120"; break;
	
			    	// ERRO_IMG_DESCONHECIDO
					case 2: retorno = "0121"; break;
	
			    	// ERRO_CC_DESCONHECIDO
					case 3: retorno = "0122"; break;
	
			    	// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0123"; break;
					
			    	// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 5: retorno = "0124"; break;
	
			    	// ERRO_DESCONHECIDO
					case 6: retorno = "0125"; break;
					
			    	// ERRO_CDGT_INVALIDO
					case 7: retorno = "0126"; break;
	
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 8: retorno = "0127"; break;
					
			    	// ERRO_TIPOGT_DESCONHECIDO
					case 9: retorno = "0128"; break;
	
			    	// ERRO_SALVAR_OBJETOS
					case 10: retorno = "0129"; break;
					
			    	// ERRO_GT_EM_USO_NA_COFIGURACAO_GERAL
					case 11: retorno = "0130"; break;
				
				}

				break;

				
			case JUSTIFICATIVAS:
				
				switch (codigo) {
					
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 7: retorno = "0118"; break;
					
				}
				
				break;

				
			case POSTOS_TRABALHO:
				
				switch (codigo) {
					
			    	// ERRO_PT_JA_EXISTE
					case 1: retorno = "0163"; break;
	
			    	// ERRO_TIPOPOSTO_DESCONHECIDO
					case 2: retorno = "0164"; break;
	
			    	// ERRO_CC_DESCONHECIDO
					case 3: retorno = "0165"; break;
	
			    	// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0166"; break;
					
			    	// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 5: retorno = "0167"; break;
	
			    	// ERRO_DESCONHECIDO
					case 6: retorno = "0168"; break;
					
			    	// ERRO_CDPT_INVALIDO
					case 7: retorno = "0169"; break;
	
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 8: retorno = "0170"; break;
					
			    	// ERRO_GRUPOTRABALHO_DESCONHECIDO
					case 9: retorno = "0171"; break;
	
			    	// ERRO_TP_IMPPROG
					case 10: retorno = "0172"; break;
					
			    	// ERRO_PERC_VARITMO_VAZIO
					case 11: retorno = "0173"; break;
	
			    	// ERRO_QTD_VARITMO_VAZIO
					case 12: retorno = "0174"; break;
					
			    	// ERRO_UP_EXISTE
					case 13: retorno = "0175"; break;				
					
				}

				break;

				
			case PRODUTOS:
				
				switch (codigo) {
				
			    	// ERRO_PRODUTO_JA_EXISTE
					case 1: retorno = "0143"; break;
	
			    	// ERRO_CC_DESCONHECIDO
					case 2: retorno = "0144"; break;
	
			    	// ERRO_DESCONHECIDO
					case 3: retorno = "0145"; break;
	
			    	// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0146"; break;
					
			    	// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 5: retorno = "0147"; break;
	
			    	// ERRO_CDPRODUTO_INVALIDO
					case 6: retorno = "0148"; break;
					
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 7: retorno = "0149"; break;
	
			    	// ERRO_FOR_DESCONHECIDO
					case 8: retorno = "0150"; break;
					
			    	// ERRO_GRUPOPRODUTO_DESCONHECIDO
					case 9: retorno = "0151"; break;
	
			    	// ERRO_TIPOPRODUTO_VAZIO
					case 10: retorno = "0152"; break;
					
			    	// ERRO_AGRUPADOR_DESCONHECIDO
					case 11: retorno = "0153"; break;
	
			    	// ERRO_CLIENTE_DESCONHECIDO
					case 12: retorno = "0154"; break;
						
			    	// ERRO_ITEM_DENTRO_DE_SEU_SUBITEM
					case 13: retorno = "0155"; break;
	
			    	// ERRO_INTEGRACAO_JA_REALIZADA
					case 14: retorno = "0156"; break;
					
			    	// ERRO_SEM_CONFIGURACAO
					case 15: retorno = "0157"; break;
	
			    	// ERRO_SEMIACABADO_INVALIDO
					case 16: retorno = "0158"; break;
					
			    	// ERRO_PESOS_INVALIDOS
					case 17: retorno = "0159"; break;
	
			    	// ERRO_PRODUTO_EM_USO_NA_COFIGURACAO_GERAL
					case 18: retorno = "0160"; break;
					
			    	// ERRO_NS_INVALIDO
					case 19: retorno = "0161"; break;
	
			    	// ERRO_MULTIPLO
					case 20: retorno = "0162"; break;
					
				}
				
				break;

				
			case USUARIOS:
				
				switch (codigo) {
					
			    	// ERRO_USUARIO_JA_EXISTE
					case 1: retorno = "0131"; break;
	
			    	// ERRO_GRUPO_DESCONHECIDO
					case 2: retorno = "0132"; break;
	
			    	// ERRO_CC_DESCONHECIDO
					case 3: retorno = "0133"; break;
	
			    	// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0134"; break;
					
			    	// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 5: retorno = "0135"; break;
	
			    	// ERRO_DESCONHECIDO
					case 6: retorno = "0136"; break;
					
			    	// ERRO_CDUSR_INVALIDO
					case 7: retorno = "0137"; break;
	
			    	// ERRO_LOGIN_INVALIDO
					case 8: retorno = "0138"; break;
					
			    	// ERRO_CARGO_DESCONHECIDO
					case 9: retorno = "0139"; break;
	
			    	// ERRO_REATIVACAO_INDISPONIVEL
					case 10: retorno = "0140"; break;
					
			    	// USUARIO_EM_USO_NA_COFIGURACAO_GERAL
					case 11: retorno = "0141"; break;
					
			    	// ERRO_USUARIO_LOGADO
					case 12: retorno = "0142"; break;
					
				}

				break;
				

			case TURNOS:
				
				switch (codigo) {
					
			    	// ERRO_TURNO_JA_EXISTE
					case 1: retorno = "0097"; break;

					// ERRO_DESCONHECIDO
					case 3: retorno = "0098"; break;

					// ERRO_USUARIO_REVISAO_DESCONHECIDO
					case 4: retorno = "0099"; break;

					// ERRO_USUARIO_STATUS_DESCONHECIDO
					case 5: retorno = "0100"; break;

					// ERRO_CDTURNO_INVALIDO
					case 6: retorno = "0101"; break;

					// ERRO_REATIVACAO_INDISPONIVEL
					case 7: retorno = "0102"; break;

					// ERRO_DS_INVALIDA
					case 8: retorno = "0103"; break;
					
				}

				break;
				
		}
		
		
		return retorno;
		
	}

		
}

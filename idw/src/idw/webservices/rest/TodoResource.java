package idw.webservices.rest;


import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwDetativ;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamon;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.DwProreaativobs;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.rn.DataHoraRN;
import idw.util.ZipDirectory;
import idw.webservices.dto.AcaoDTO;
import idw.webservices.dto.AtividadesRealizadasDTO;
import idw.webservices.dto.ConfiguracaoCheckFeederDTO;
import idw.webservices.dto.ConfiguracaoCheckLevelDTO;
import idw.webservices.dto.CpsDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.DetalhamentoParadaDTO;
import idw.webservices.dto.DwOperacaoDTO;
import idw.webservices.dto.DwOperacoesDTO;
import idw.webservices.dto.DwTAcoes;
import idw.webservices.dto.DwTCausasDTO;
import idw.webservices.dto.DwTJustsDTO;
import idw.webservices.dto.FiltroParadasDTO;
import idw.webservices.dto.GtDTO;
import idw.webservices.dto.LeiturasCODTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.dto.MapasCODTO;
import idw.webservices.dto.MonitorizacoesCheckFeederDTO;
import idw.webservices.dto.MontagensDTO;
import idw.webservices.dto.NaoConformidadeDTO;
import idw.webservices.dto.OperacoesInprocessDTO;
import idw.webservices.dto.PTsDTO;
import idw.webservices.dto.PassagemDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasRestDTO;
import idw.webservices.dto.PosicoesCODTO;
import idw.webservices.dto.ResultadoEntradaLocalProdutoDTO;
import idw.webservices.dto.ResultadoEventoREST;
import idw.webservices.dto.UsuarioCODTO;
import idw.webservices.dto.UsuarioDTO;
import idw.webservices.dto.UsuariosDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.ic.inova.Stubdelegate;
import ms.model.rn.UpRN;

@Path("/todo")
public class TodoResource {

	@GET
	@Path("get/{json}")
	@Produces(("application/json; charset=UTF-8"))
	public List<GtDTO> getAndroidGTsComLayoutDTO(@PathParam("json") String json) {
		return IdwFacade.getInstancia().getGTsComLayoutDTOAndroid();
	}

	@GET
	@Path("isUsuarioAutenticado/{login}-{senha}")
	@Produces(("application/json; charset=UTF-8"))
	public UsuarioDTO isUsuarioAutenticado(@PathParam("login") String login, @PathParam("senha") String senha) {
		UsuarioDTO filtro = new UsuarioDTO();
		OmUsr omUsr = new OmUsr();
		omUsr.setLogin(login);
		omUsr.setSenha(senha);
		filtro.setUsuario(omUsr);
		return IdwFacade.getInstancia().isUsuarioAutenticado(filtro);
	}

	@GET
	@Path("pesquisarProximosCpsPorUsuario/{cdUsuario}")
	@Produces(("application/json; charset=UTF-8"))
	public CpsDTO pesquisarProximosCpsPorUsuario(@PathParam("cdUsuario") String cdUsuario) {

		return IdwFacade.getInstancia().pesquisarProximosCpsPorUsuario(cdUsuario);
	}

	/**
	 * REST SMED
	 * 
	 * @return UsuariosDTO - OmUsr
	 * @author George Lucas Gomes
	 */
	@GET
	@Path("getUsuarios")
	@Produces(("application/json; charset=UTF-8"))
	public UsuariosDTO getUsuarios() {
		return IdwFacade.getInstancia().getUsuarios();
	}

	/**
	 * Adicionado DwProrreaUsr Última edi��oo: George Lucas Gomes - 21/07/2015
	 * 
	 * @param personParams
	 * @return
	 */
	@POST
	@Path("finalizarSetup")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String finalizarSetup(
			MultivaluedMap<String, String> personParams) {

		String json = personParams.getFirst("jsonAtvRealizadas");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		AtividadesRealizadasDTO realizadasDTO = gson.fromJson(json, AtividadesRealizadasDTO.class);
		return IdwFacade.getInstancia().finalizarSetup(realizadasDTO);

	}

	@GET
	@Path("getDwDetativ/{idProcativ}")
	@Produces(("application/json; charset=UTF-8"))
	public List<DwDetativ> getDwDetativ(@PathParam("idProcativ") String idProcativ) {
		Long idProcativL = new Long(idProcativ);
		List<DwDetativ> lista = new ArrayList<DwDetativ>();
		lista = IdwFacade.getInstancia().getDwDetativ(idProcativL);
		for (DwDetativ dwDetativ : lista) {
			dwDetativ.setFoto(null);

		}
		return lista;
	}

	@GET
	@Path("getAllDwDetativs/{idProcedimento}")
	@Produces(("application/json; charset=UTF-8"))
	public List<DwDetativ> getAllDwDetativs(@PathParam("idProcedimento") String idProcedimento) {
		Long idProcedimentoL = new Long(idProcedimento);
		List<DwDetativ> lista = new ArrayList<DwDetativ>();
		lista = IdwFacade.getInstancia().getAllDwDetativs(idProcedimentoL);
		for (DwDetativ dwDetativ : lista) {
			dwDetativ.setFoto(null);

		}
		return lista;
	}

	@GET
	@Path("getFoto/{idDetativ}")
	@Produces("image/png")
	public byte[] getFoto(@PathParam("idDetativ") String idDetativ) {
		Long idDetativL = new Long(idDetativ);
		byte retorno[] = null;
		DwDetativ detativ = IdwFacade.getInstancia().getFoto(idDetativL);
		if (detativ.getTpDetativ() == 1 || detativ.getTpDetativ() == 2) {
			// Alessandre em 18-08-16 transformei foto em primitiva pois no pg nao estava funcionando
			retorno = detativ.getFoto();
		}
		return retorno;
	}

	@POST
	@Path("novaObs")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public DwProreaativobs post(
			MultivaluedMap<String, String> personParams) {

		String idProreaativL = personParams.getFirst("idProreaativ");
		String dsObs = personParams.getFirst("dsObs");
		String dthr = personParams.getFirst("dthr");

		Long idProreaativ = new Long(idProreaativL);
		Date dthrObs = DataHoraRN.stringToDate(dthr, DataHoraRN.YYYYMMDDHHMMSS);

		// System.out.println("Storing posted " + idProreaativL + " " + dsObs + " " + dthr);
		DwProreaativobs dwProreaativobs = IdwFacade.getInstancia().novaObs(idProreaativ, dsObs, dthrObs);

		return dwProreaativobs;
	}

	/**
	 * CheckFeeder
	 */

	@GET
	@Path("getConfiguracaoCheckFeeder")
	@Produces(("application/json; charset=UTF-8"))
	public ConfiguracaoCheckFeederDTO getConfiguracaoCheckFeeder() {
		return IdwFacade.getInstancia().getConfiguracao();
	}

	@GET
	@Path("getUsuarioCODTO/{matricula}")
	@Produces(("application/json; charset=UTF-8"))
	public UsuarioCODTO getUsuarioCODTO(@PathParam("matricula") String matricula) {
		return IdwFacade.getInstancia().getUsuarioCODTO(matricula);
	}

	@GET
	@Path("getMapasCODTO/{maquina}")
	@Produces(("application/json; charset=UTF-8"))
	public MapasCODTO getMapasCODTO(@PathParam("maquina") String maquina) {
		return IdwFacade.getInstancia().getMapasCODTO(maquina);
	}

	@GET
	@Path("isMapaValido/{maquina}---{mapa}")
	@Produces(("application/json; charset=UTF-8"))
	public ResultadoEventoREST isMapaValido(@PathParam("maquina") String maquina,
			@PathParam("mapa") String mapa) {

		ResultadoEventoREST resultadoEventoREST = new ResultadoEventoREST();

		if (IdwFacade.getInstancia().isMapaValido(maquina, mapa)) {
			resultadoEventoREST.setResultadoEvento(resultadoEventoREST.getEVENTO_BEM_SUCEDIDO());
		} else {
			resultadoEventoREST.setResultadoEvento(resultadoEventoREST.getEVENTO_MAL_SUCEDIDO());
		}

		resultadoEventoREST.setDthr(DataHoraRN.getDataHoraAtual());

		return resultadoEventoREST;
	}

	@GET
	@Path("getCorrente/{idAlimCorrente}")
	@Produces(("application/json; charset=UTF-8"))
	public LeiturasCODTO getCorrente(@PathParam("idAlimCorrente") Long idAlimCorrente) {
		return IdwFacade.getInstancia().getCorrente(idAlimCorrente);
	}

	@GET
	@Path("getPosicoesCODTO/{maquina}---{mapa}")
	@Produces(("application/json; charset=UTF-8"))
	public PosicoesCODTO getPosicoesCODTO(@PathParam("maquina") String maquina, @PathParam("mapa") String mapa) {
		return IdwFacade.getInstancia().getPosicoesCODTO(maquina, mapa, false);
	}

	@POST
	@Path("validaPosicoes/{maquina}---{mapa}")
	@Produces(("application/json; charset=UTF-8"))
	public String validaPosicoes(MultivaluedMap<String, String> personParams,
			@PathParam("maquina") String maquina,
			@PathParam("mapa") String mapa) {

		String json = personParams.getFirst("jsonPosicoes");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		PosicoesCODTO posicoes = gson.fromJson(json, PosicoesCODTO.class);

		return IdwFacade.getInstancia().validaPosicoes(posicoes, maquina, mapa);
	}

	@PUT
	@Path("desalimentacaoPt/{OmPt}---{Usr}")
	public void desalimentacaoPt(@PathParam("OmPt") String OmPt, @PathParam("Usr") String usr) {
		IdwFacade.getInstancia().desalimentacao(OmPt, Long.valueOf(usr));
	}

	// ----------------------------------------------------

	@GET
	@Path("getProdutoByCdEStAtivo/{cdProduto}")
	@Produces(("application/json; charset=UTF-8"))
	public String getProdutoByCdEStAtivo(@PathParam("cdProduto") String cdProduto) {
		return String.valueOf(IdwFacade.getInstancia().getProdutoByCdEStAtivo(cdProduto));
	}

	@GET
	@Path("getMonitorizacaoCheckFeeder/{cdPt}")
	@Produces(("application/json; charset=UTF-8"))
	public MonitorizacoesCheckFeederDTO getMonitorizacaoCheckFeeder(@PathParam("cdPt") String cdPt) {
		return IdwFacade.getInstancia().getMonitorizacaoCheckFeeder(cdPt);
	}

	@GET
	@Path("isUsuarioAutorizadoLiberarCF/{matricula}")
	@Produces(("application/json; charset=UTF-8"))
	public UsuarioCODTO isUsuarioAutorizadoLiberarCF(@PathParam("matricula") String matricula) {
		return IdwFacade.getInstancia().isUsuarioAutorizadoLiberarCF(matricula);
	}

	@POST
	@Path("pesquisaOmprodutoPost")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(("application/json; charset=UTF-8"))
	public PesquisasRestDTO pesquisaOmprodutoPost(MultivaluedMap<String, String> personParams) {
		String json = personParams.getFirst("pesquisa");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		PesquisaDTO pesquisa = gson.fromJson(json, PesquisaDTO.class);

		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaOmprodutoFinal(pesquisa));
	}

	@GET
	@Path("pesquisaOmproduto/{pesquisa}")
	@Produces(("application/json; charset=UTF-8"))
	public PesquisasRestDTO pesquisaOmproduto(@PathParam("pesquisa") PesquisaDTO pesquisa) {
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaOmprodutoFinal(pesquisa));
	}

	@GET
	@Path("pesquisaOmprodutoComponente/{pesquisa}")
	@Produces(("application/json; charset=UTF-8"))
	public PesquisasRestDTO pesquisaOmprodutoComponente(@PathParam("pesquisa") PesquisaDTO pesquisa) {
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaOmprodutoComponente(pesquisa));
	}

	@GET
	@Path("isProdutoEAlternativo/{cdProduto}-{cdProdutoLido}")
	@Produces(("application/json; charset=UTF-8"))
	public String isProdutoEAlternativo(@PathParam("cdProduto") String cdProduto,
			@PathParam("cdProdutoLido") String cdProdutoLido) {
		return String.valueOf(IdwFacade.getInstancia().isProdutoEAlternativo(cdProduto, cdProdutoLido));
	}

	@GET
	@Path("validaPosicaoEProdutoRealim/{posicao}-{produto}-{maquina}-{mapa}")
	@Produces(("application/json; charset=UTF-8"))
	public String validaPosicaoEProdutoRealim(@PathParam("posicao") String posicao,
			@PathParam("produto") String produto,
			@PathParam("maquina") String maquina,
			@PathParam("mapa") String mapa) {
		return String.valueOf(IdwFacade.getInstancia().validaPosicaoEProdutoRealim(posicao, produto, maquina, mapa));
	}

	@POST
	@Path("setConferenciaOuPre")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String setConferenciaOuPre(
			MultivaluedMap<String, String> personParams) {

		String json = personParams.getFirst("jsonLeituras");
		System.out.println(json);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		LeiturasCODTO leituras = gson.fromJson(json, LeiturasCODTO.class);

		return String.valueOf(IdwFacade.getInstancia().setConferenciaOuPre(leituras));
	}

	@POST
	@Path("setRealimentacao")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String setRealimentacao(
			MultivaluedMap<String, String> personParams) {

		String json = personParams.getFirst("jsonLeituras");
		System.out.println(json);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		LeiturasCODTO leituras = gson.fromJson(json, LeiturasCODTO.class);

		return String.valueOf(IdwFacade.getInstancia().setRealimentacao(leituras));
	}

	@POST
	@Path("setCorrente")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public LeiturasCODTO setCorrente(
			MultivaluedMap<String, String> personParams) {

		String json = personParams.getFirst("jsonLeituras");
		System.out.println(json);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		LeiturasCODTO leituras = gson.fromJson(json, LeiturasCODTO.class);

		return IdwFacade.getInstancia().setCorrente(leituras);
	}

	@POST
	@Path("assumePreConferencia")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void assumePreConferencia(
			MultivaluedMap<String, String> personParams) {

		String maquina = personParams.getFirst("maquina");
		IdwFacade.getInstancia().assumePreConferencia(maquina);
	}

	// ------------------------------- CHECKLEVEL ---------------------------------------------------------

	@GET
	@Path("getConfiguracaoCheckLevel")
	@Produces(MediaType.APPLICATION_JSON)
	public ConfiguracaoCheckLevelDTO getConfiguracaoCheckLevel() {
		return IdwFacade.getInstancia().getConfiguracaoCheckLevel();
	}

	@POST
	@Path("setMovimentacaoLocalProduto")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoEntradaLocalProdutoDTO setMovimentacaoLocalProduto(
			MultivaluedMap<String, String> personParams) {
		String cdLocalOrigem = personParams.getFirst("cdLocalOrigem");
		String cdProduto = personParams.getFirst("cdProduto");
		String cdLocalDestino = personParams.getFirst("cdLocalDestino");
		Integer qtdEntrada = Integer.valueOf(personParams.getFirst("qtdEntrada"));
		String usuario = personParams.getFirst("usuario");
		return IdwFacade.getInstancia().setMovimentacaoLocalProduto(cdLocalOrigem, cdProduto,
				cdLocalDestino, qtdEntrada, usuario);
	}

	@POST
	@Path("setEntradaLocalProduto")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoEntradaLocalProdutoDTO setEntradaLocalProduto(
			MultivaluedMap<String, String> personParams) {
		String cdProduto = personParams.getFirst("cdProduto");
		String cdLocalDestino = personParams.getFirst("cdLocalDestino");
		int qtdEntrada = Integer.valueOf(personParams.getFirst("qtdEntrada"));
		String usuario = personParams.getFirst("usuario");
		return IdwFacade.getInstancia().setEntradaLocalProduto(cdProduto, cdLocalDestino, qtdEntrada, usuario);
	}

	// ----------------------------------------------------------------------------------------------------
	// IHM - Android
	@POST
	@Path("getOcorrenciasParadas")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public DetalhamentoParadaDTO getOcorrenciasParadas(MultivaluedMap<String, String> personParams) throws Exception {
		FiltroParadasDTO filtro = new FiltroParadasDTO();
		String debug = personParams.getFirst("dataInicio");
		Date data = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(debug);
		filtro.setDataInicio(data);
		debug = personParams.getFirst("dataFim");
		data = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(debug);
		filtro.setDataFim(data);
		filtro.setPt(new OmPt());
		filtro.getPt().setCdPt(personParams.getFirst("dsUp"));

		return IdwFacade.getInstancia().getOcorrenciasParadasREST(filtro);
	}

	@POST
	@Path("pesquisaParada")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTParada(MultivaluedMap<String, String> personParams) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(personParams.getFirst("cdParada"));
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTParada(pesquisaDTO));
	}

	@GET
	@Path("pesquisaParada/{cdParada}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTParada(@PathParam("cdParada") String cdParada, @PathParam("idTppt") String idTppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdParada);
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTParada(pesquisaDTO));
	}
	
	@GET
	@Path("pesquisaCausasJustificativasAcoes/{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public Response pesquisaDwTCausasJustificativasAcoes(@PathParam("idTppt") String idTppt, @QueryParam("isCausa") String isCausa, @QueryParam("isAcao") String isAcao, @QueryParam("isJustificativa") String isJustificativa) throws Exception {
		//Gson gson = new Gson();
		String causasJson = "";
		String acoesJson = "";
		String justificativasJson = "";
		
		// A ExclusionStrategy e utilizada para reduzir o tamanho das respostas retornadas
		// por essa API
		// https://www.baeldung.com/gson-exclude-fields-serialization
		ExclusionStrategy strategy = new ExclusionStrategy() {
			@Override
			public boolean shouldSkipField(FieldAttributes field) {
				if (field.getName().contains("dwT")
						|| field.getName().contains("cdT")
						|| field.getName().contains("dsT")) {
					return false;
				}
				return true;
			}

			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				return false;
			}
		};
		Gson gson = new GsonBuilder().addSerializationExclusionStrategy(strategy).create();
		
		if (isCausa!=null && isCausa.equals("1")) {
			DwTCausasDTO causas = IdwFacade.getInstancia().getTCausa(Long.parseLong(idTppt));
			causasJson = gson.toJson(causas.getListaCausasDTO());
		}
		
		if (isAcao!=null && isAcao.equals("1")) {
			DwTAcoes acoes = IdwFacade.getInstancia().getTAcao(Long.parseLong(idTppt));
			acoesJson = gson.toJson(acoes.getListaDwTAcoes());
		}
		
		if (isJustificativa !=null && isJustificativa.equals("1")) {
			DwTJustsDTO justificativas = IdwFacade.getInstancia().getTJustificativa(Long.parseLong(idTppt));
			justificativasJson = gson.toJson(justificativas.getListaJustsDTO());
		}
		
		
		String retorno = "{\"causasJson\" : " + causasJson + " ,"
				+ "\"acoesJson\" : " + acoesJson + " ,"
				+ " \"justificativasJson\": " + justificativasJson +"}"; 
		 return Response.status(Response.Status.OK).entity(retorno).build();
	}

	@POST
	@Path("pesquisaCausa")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTCausa(MultivaluedMap<String, String> personParams) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(personParams.getFirst("cdCausa"));
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTCausa(pesquisaDTO));
	}

	@GET
	@Path("pesquisaCausa/{cdCausa}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTCausaGet(@PathParam("cdCausa") String cdCausa, @PathParam("idTppt") String idTppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdCausa);
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTCausa(pesquisaDTO));
	}

	@POST
	@Path("pesquisaAcao")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//@Produces("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTAcao(MultivaluedMap<String, String> personParams) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(personParams.getFirst("cdAcao"));
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTAcao(pesquisaDTO));
	}

	@GET
	@Path("pesquisaAcao/{cdAcao}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTAcaoGet(@PathParam("cdAcao") String cdAcao, @PathParam("idTppt") String idTppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdAcao);
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTAcao(pesquisaDTO));
	}

	@POST
	@Path("pesquisaJustificativa")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTJustificativa(MultivaluedMap<String, String> personParams) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(personParams.getFirst("cdJustificativa"));
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTJust(pesquisaDTO));
	}

	@GET
	@Path("pesquisaJustificativa/{cdJust}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTJustificativaGet(@PathParam("cdJust") String cdJust, @PathParam("idTppt") String idTppt)
			throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdJust);
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTJust(pesquisaDTO));
	}

	@POST
	@Path("corrigeLogParadas")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String corrigeLogParadas(MultivaluedMap<String, String> personParams) throws Exception {
		DetalhamentoParadaDTO detalhamentoParadaDTO = new DetalhamentoParadaDTO();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		String paradas = personParams.getFirst("corrigeLogParadas");
		detalhamentoParadaDTO = gson.fromJson(paradas, DetalhamentoParadaDTO.class);
		if (IdwFacade.getInstancia().corrigeLogParadas(detalhamentoParadaDTO)) {
			return "1";
		} else {
			return "0";
		}
	}

	@GET
	@Path("pesquisaRefugo/{cdRefugo}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PesquisasRestDTO pesquisaDwTRefugo(@PathParam("cdRefugo") String cdRefugo, @PathParam("idTppt") String idTppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdRefugo);
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTRefugo(pesquisaDTO));
	}
	
	@GET
	@Path("getPpCpByCdPt/{ompt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public ListaCPDTO getPpCpByCdPt(@PathParam("ompt") String ompt) throws Exception {
		OmPt omPt = new OmPt();
		omPt.setCdPt(ompt);
		return IdwFacade.getInstancia().getPpCpByCdPt(omPt);
	}
	
	// ------------------------------------------------------------------------------------------------------------

	// ---------------------------------InProcess-------------------------------------------------------------------

	@GET
	@Path("getPtsAtivos")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public PTsDTO getPtsAtivos() throws Exception {
		return IdwFacade.getInstancia().getPtsAtivos();
	}

	@GET
	@Path("getDwOperacaoInProcess")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String getDwOperacaoInProcess() throws Exception {
		DwOperacoesDTO dwOperacoesDTO = IdwFacade.getInstancia().getDwOperacaoInProcess();
		OperacoesInprocessDTO operacoesInprocessDTO = new OperacoesInprocessDTO();
		String jsonString = null;
		if (dwOperacoesDTO.getListaOperacoesDTO().size() > 0) {
			File pasta = new File(Stubedelegate.getInstancia().getPathRelativo() + "/inprocess");
			if (pasta.exists()) {
				for (File file : pasta.listFiles()) {
					file.delete();
				}
			} else {
				pasta.mkdir();
			}
			Gson gson = new Gson();
			for (DwOperacaoDTO oper : dwOperacoesDTO.getListaOperacoesDTO()) {
				operacoesInprocessDTO.adicionaOperacaoInprocessDTO(oper.getDwOperacao());
				jsonString = gson.toJson(oper);
				try (PrintWriter out = new PrintWriter(pasta.getCanonicalPath() + "\\" +
						oper.getDwOperacao().getId() + ".mapcardoso")) {
					out.println(jsonString);
				} catch (Exception e) {
					return "0";
				}
			}
			jsonString = gson.toJson(operacoesInprocessDTO);
			try (PrintWriter out = new PrintWriter(pasta.getCanonicalPath() + "\\" +
					"index" + ".mapcardoso")) {
				out.println(jsonString);
			} catch (Exception e) {
				return "0";
			}
			List<File> listaArquivos = new ArrayList<File>();
			ZipDirectory.getAllFiles(pasta, listaArquivos);
			ZipDirectory.writeZipFile(pasta, listaArquivos, false);
			return "1";
		} else {
			return "0";
		}
	}

	// ---------------------------------Posto de Reprocesso Web----------------------------------------------------

	@GET
	@Path("isNumeroSerieRefugado/{ns}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String isNumeroSerieRefugado(@PathParam("ns") String ns) {
		String retorno;
		try {
			retorno = String.valueOf(IdwFacade.getInstancia().isNumeroSerieRefugado(ns));
		} catch (Exception e) {
			return "false";
		}

		return retorno;
	}

	@GET
	@Path("getOmPt/{cdPt}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("application/json; charset=UTF-8")
	//@Produces(MediaType.TEXT_PLAIN)
//	public idw.webservices.dto.PtDTO getOmPt(@PathParam("cdPt") String cdPt) throws Exception {
	public String getOmPt(@PathParam("cdPt") String cdPt) throws Exception {
		idw.webservices.dto.PtDTO ptDto = new idw.webservices.dto.PtDTO();
		idw.model.pojos.OmPt ompt = new OmPt();
		ompt.setCdPt(cdPt);
		ptDto.setPt(ompt);
		PTsDTO ptsDTO = IdwFacade.getInstancia().getPTsDTO(ptDto);
		ptDto.setPt(null);
		if (ptsDTO != null) {
			for (idw.webservices.dto.PtDTO item : ptsDTO.getPts()) {
				if (item.getPt().getCdPt().equals(cdPt)) {
					ptDto = item;
				}
			}

		}

		// Conversao java object to jso
		return toJson(ptDto);
	}

	@GET
	@Path("getValidarNumeroDeSerie/{cdpt}----{nrop}----{ns}----{cdproduto}----{idpt}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getValidarNumeroDeSerie(@PathParam("cdpt") String cdpt, @PathParam("nrop") String nrop, @PathParam("ns") String ns,
			@PathParam("cdproduto") String cdproduto, @PathParam("idpt") Long idpt) {
		String retorno;
		try {
			retorno = Integer.toString(IdwFacade.getInstancia().getValidarNumeroDeSerie(cdpt, nrop, ns, cdproduto, idpt, false));
		} catch (Exception e) {
			return "-1";
		}

		return retorno;
	}

	@POST
	@Path("regristrarTesteSimples")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public void regristrarTesteSimples(MultivaluedMap<String, String> personParams) throws Exception {
		String cdPt = personParams.getFirst("cdPt");
		String cdOp = personParams.getFirst("cdOp");
		String cb = personParams.getFirst("cb");
		String dthr = personParams.getFirst("dthr");
		Integer stTeste = Integer.parseInt(personParams.getFirst("stTeste"));
		String qtde = personParams.getFirst("qtde");

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = formatador.parse(dthr);

		IdwFacade.getInstancia().regristrarTesteSimples(cdPt, cdOp, cb, data, stTeste, qtde);
	}

	@GET
	@Path("pesquisaDwTDefeitoTppt/{idTppt}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	// public PesquisasRestDTO pesquisaDwTDefeitoTppt(@PathParam("idTppt") String idTppt) {
	public String pesquisaDwTDefeitoTppt(@PathParam("idTppt") String idTppt) {
		PesquisaDTO pesquisa = new PesquisaDTO();
		PesquisasRestDTO retorno;
		try {
			OmTppt omTppt = new OmTppt();
			omTppt.setIdTppt(Long.parseLong(idTppt));
			pesquisa.setRegistro(omTppt);
			pesquisa.setCodigo("");
			pesquisa.setDescricao("");
			retorno = new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTDefeito(pesquisa));

		} catch (Exception e) {
			e.printStackTrace();
			retorno = new PesquisasRestDTO();
		}

		// return retorno;
		// Conversao java object to jso
		return toJson(retorno);
	}

	@POST
	@Path("registrarTesteDefeito")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public void regristrarTesteDefeito(MultivaluedMap<String, String> personParams) throws Exception {
		String cdPt = personParams.getFirst("cdPt");
		String cdOp = personParams.getFirst("cdOp");
		String cb = personParams.getFirst("cb");
		String dthr = personParams.getFirst("dthr");
		String cdDefeito = personParams.getFirst("cdDefeito");
		String qtde = personParams.getFirst("qtde");

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = formatador.parse(dthr);

		IdwFacade.getInstancia().regristrarTesteDefeito(cdPt, cdOp, cb, data,
				cdDefeito, qtde, null, ""); // Alessandre em 7-4-17 null para area responsavel
	}

	@GET
	@Path("getDwFolhaPassagem/{cdPt}----{nrop}----{cb}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	// public DwFolha getDwFolhaPassagem(@PathParam("cdPt") String cdPt, @PathParam("nrop") String nrop, @PathParam("cb") String cb) {
	public String getDwFolhaPassagem(@PathParam("cdPt") String cdPt, @PathParam("nrop") String nrop, @PathParam("cb") String cb) {
		// return IdwFacade.getInstancia().getDwFolhaPassagem(cdPt, nrop, cb);
		
		// Conversao java object to jso
		return toJson(IdwFacade.getInstancia().getDwFolhaPassagem(cdPt, nrop, cb));
	}

	@GET
	@Path("getMascaraCdProdutomp")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getMascaraCdProdutomp() {
		return IdwFacade.getInstancia().getMascaraCdProdutomp();
	}

	@GET
	@Path("getIdOmProduto/{cdProduto}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getOmProduto(@PathParam("cdProduto") String cdProduto) {
		String retorno;
		try {
			Long id = IdwFacade.getInstancia().pesquisaOmproduto(cdProduto).getIdProduto();
			retorno = String.valueOf(id);
		} catch (Exception e) {
			return "-1";
		}
		return retorno;
	}

	@POST
	@Path("registrarMontagem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public void registrarMontagem(MultivaluedMap<String, String> personParams) throws Exception {
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd'T'HH:mm:ss").create();
		String cdPt = personParams.getFirst("cdPt");
		String cdOp = personParams.getFirst("cdOp");
		String cb = personParams.getFirst("cb");
		String dthr = personParams.getFirst("dthr");
		MontagensDTO lista = gson.fromJson(personParams.getFirst("lista"), MontagensDTO.class);
		String qtde = personParams.getFirst("qtde");

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = formatador.parse(dthr);

		IdwFacade.getInstancia().registrarMontagem(cdPt, cdOp, cb, data, lista, qtde);
	}

	@GET
	@Path("obtemNaoConformidadesAtuais/{ns}----{cdpt}")
	@Consumes(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json; charset=UTF-8")
//	@Produces(MediaType.TEXT_PLAIN)
//	public PassagemDTO obtemNaoConformidadesAtuais(@PathParam("ns") String ns, @PathParam("cdpt") String cdpt) {
	public String obtemNaoConformidadesAtuais(@PathParam("ns") String ns, @PathParam("cdpt") String cdpt) {
		PassagemDTO retorno = new PassagemDTO();
		retorno.setCb(ns);
		retorno.setCdPt(cdpt);
		try {
			retorno = IdwFacade.getInstancia().obtemNaoConformidadesAtuais(retorno);
		} catch (Exception e) {
			return null;
		}
		// Economia de espaco
		//retorno.setResultado(null);
		
		// Conversao java object to json
		return toJson(retorno);
	}

	@GET
	@Path("pesquisaDwTAcao/{idtppt}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("application/json; charset=UTF-8")
	// @Produces(MediaType.TEXT_PLAIN)
	//public PesquisasRestDTO pesquisaDwTAcaoOmtppt(@PathParam("idtppt") String idtppt) throws Exception {
	public String pesquisaDwTAcaoOmtppt(@PathParam("idtppt") String idtppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idtppt));
		// return new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTAcao(pesquisaDTO));
		return toJson(new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTAcao(pesquisaDTO)));
	}

	@POST
	@Path("postoReprocesso")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public void postoReprocesso(MultivaluedMap<String, String> personParams) throws Exception {
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd'T'HH:mm:ss").create();
		String ns = personParams.getFirst("ns");
		String cdpt = personParams.getFirst("cdpt");
		String cdcp = personParams.getFirst("cdcp");
		String idtppt = personParams.getFirst("idtppt");
		String acao = personParams.getFirst("acao");
		Boolean isArray = Boolean.parseBoolean(personParams.getFirst("isArray"));

		if (isArray) {
			Type listType = new TypeToken<ArrayList<NaoConformidadeDTO>>() {
			}.getType();
			List<NaoConformidadeDTO> listaNC = gson.fromJson(personParams.getFirst("dto"), listType);

			for (NaoConformidadeDTO dto : listaNC) {
				PassagemDTO passagem = new PassagemDTO();
				passagem.setCb(ns);
				passagem.setCdPt(cdpt);
				passagem.setDtHrEvento(DataHoraRN.getDataHoraAtual());
				passagem.setCdOp(cdcp);
				passagem.setIdTppt(Long.valueOf(idtppt));

				DefeitoDTO defeitodto = new DefeitoDTO();

				defeitodto.setIdPassagem(dto.getIdPassagem());
				defeitodto.setIdPassdef(dto.getIdPassdef());
				defeitodto.setIdTppt(dto.getTppt());
				defeitodto.setIdTDefeito(dto.getIdTDefeito());

				AcaoDTO acaodto = new AcaoDTO();
				acaodto.setCb(acao); // codigo da acao
				acaodto.setComponente(null);
				acaodto.setDefeito(defeitodto);
				acaodto.setIdTppt(Long.parseLong(idtppt));

				passagem.getListaAcoes().add(acaodto);

				IdwFacade.getInstancia().postoReprocesso(passagem);
			}

		} else {
			// NaoConformidadeDTO dto = gson.fromJson(personParams.getFirst("dto"), NaoConformidadeDTO.class);
			NaoConformidadeDTO dto = new NaoConformidadeDTO();
			dto.setCdPt(personParams.getFirst("dto[cdPt]"));
			dto.setDsCurta(personParams.getFirst("dto[dsCurta]"));
			dto.setDsNaoConformidade(personParams.getFirst("dto[dsNaoConformidade]"));
			// dto.setDthrNC(personParams.getFirst("dto[dthrNC]"));
			dto.setIdPassagem(Long.parseLong(personParams.getFirst("dto[idPassagem]")));
			dto.setIdPassdef(Long.parseLong(personParams.getFirst("dto[idPassdef]")));
			dto.setTppt(Integer.parseInt(personParams.getFirst("dto[tppt]")));
			dto.setIdTDefeito(Long.valueOf(Integer.parseInt(personParams.getFirst("dto[idTDefeito]"))));
					
			PassagemDTO passagem = new PassagemDTO();
			passagem.setCb(ns);
			passagem.setCdPt(cdpt);
			passagem.setDtHrEvento(DataHoraRN.getDataHoraAtual());
			passagem.setCdOp(cdcp);
			passagem.setIdTppt(Long.valueOf(idtppt));
			passagem.getResultado().setIdmensagem(1); // com sucesso
			

			DefeitoDTO defeitodto = new DefeitoDTO();

			defeitodto.setIdPassagem(dto.getIdPassagem());
			defeitodto.setIdPassdef(dto.getIdPassdef());
			defeitodto.setIdTppt(dto.getTppt());
			defeitodto.setIdTDefeito(dto.getIdTDefeito());

			AcaoDTO acaodto = new AcaoDTO();
			acaodto.setCb(acao); // codigo da acao
			acaodto.setComponente(null);
			acaodto.setDefeito(defeitodto);
			acaodto.setIdTppt(Long.parseLong(idtppt));

			passagem.getListaAcoes().add(acaodto);
			
			// Setando o produto acoplado na passagem
			DwFolha dwFolha =  IdwFacade.getInstancia().getDwFolhaPassagem(cdpt, cdcp, ns);
			for (DwFolhamon dwfolhamon : dwFolha.getDwFolhamons()) {
				for (DwFolhamoncomp dwfolhamoncomp : dwfolhamon.getDwFolhamoncomps()) {
					passagem.setIdProduto(dwfolhamoncomp.getOmProduto().getIdProduto());
				}
			}

			passagem.setIdGt(Long.parseLong(personParams.getFirst("ompt[omGt][idGt]")));
			
			IdwFacade.getInstancia().postoReprocesso(passagem);
		}

	}

	/**
	 * Versao modificada com melhorias de desempenho
	 * @param personParams
	 * @return String Json
	 * @throws Exception
	 */
	@POST
	@Path("getOcorrenciasParadasWeb")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public String getOcorrenciasParadasWeb(MultivaluedMap<String, String> personParams) throws Exception {
		FiltroParadasDTO filtro = new FiltroParadasDTO();
		String debug = personParams.getFirst("dataInicio");
		Date data = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(debug);
		filtro.setDataInicio(data);
		debug = personParams.getFirst("dataFim");
		data = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(debug);
		filtro.setDataFim(data);
		filtro.setPt(new OmPt());
		filtro.getPt().setCdPt(personParams.getFirst("dsUp"));

		return toJson(IdwFacade.getInstancia().getOcorrenciasParadasREST(filtro));
	}
	
	
	@GET
	@Path("verificaDisponibilidadeBanco")
	@Produces(MediaType.APPLICATION_JSON)
	public Response verificaDisponibilidadeBanco() {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		UpRN upRN = new UpRN();
		DAOGenerico daoPDBA = null;
		boolean retorno = true;
		
		try {
			//upRN.iniciaConexaoBanco();
			//upRN.getDaoPdba();
			daoPDBA = upRN.getDaoPdba();
			if (daoPDBA != null) {
				daoPDBA.iniciaSessao();
				if (daoPDBA.iniciaTransacaoComRetorno() == null)
					retorno = false;
			} else {
				retorno = false;
			}
		} catch (Exception e) {
			// se houve excecao, conexao com o banco nao pode ser estabelecida
			retorno = false;
		} finally {
			try {
				upRN.finalizaConexaoBanco();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String json = gson.toJson(retorno);
		return Response.status(responseStatus).entity(json).build();
	}
	
	@GET
	@Path("verificaDisponibilidadeBancoInjet")
	@Produces(MediaType.APPLICATION_JSON)
	public Response verificaDisponibilidadeBancoInjet() {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		UpRN upRN = new UpRN();
		DAOGenericoInjet daoInjet = null;
		boolean retorno = true;
		
		try {
			daoInjet = upRN.getDaoInjet();
			if (daoInjet != null && Stubdelegate.getInstancia().isInjetAtivo() == true) {
				daoInjet.iniciaSessao();
				if (daoInjet.iniciaTransacaoComRetorno() == null)
					retorno = false;
			} else {
				retorno = false;
			}
		} catch (Exception e) {
			// se houve excecao, conexao com o banco nao pode ser estabelecida
			retorno = false;
		} finally {
			try {
				upRN.finalizaConexaoBanco();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String json = gson.toJson(retorno);
		return Response.status(responseStatus).entity(json).build();
	}
	
	
	// ------------------------------------------------------------------------------------------------------------

	public boolean ping() {
		return true;
	}
	
	@GET
	@Path("getDthr")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDthr() {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		String retorno;
		Date data = new Date();
		
		String formatoSaida = ("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat(formatoSaida);
		retorno = sdf.format(data);
		
		String json = gson.toJson(retorno);
		
		return Response.status(responseStatus).entity(json).build();
	}
	
	private String toJson(Object obj) {
		// Conversao java object to json
		Gson gson = new Gson();
		String jsonRetorno = null; 
		jsonRetorno = gson.toJson(obj);
		// return ptDto;
		return jsonRetorno;
	}

}

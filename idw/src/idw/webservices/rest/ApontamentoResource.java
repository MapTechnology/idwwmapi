package idw.webservices.rest;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import idw.webservices.dto.CicloDTO;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.auth.TokenFilter;
import idw.webservices.rest.dto.apontamento.ParamsLancaFimCicloDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.ClienteRegistrado;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.IhmDesconhecidoException;
import ms.excessao.MsDesconhecidoException;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.model.dto.MsDTO;
import ms.util.ConversaoTipos;
import ms.util.UtilsString;


@Path("/apontamentos")
public class ApontamentoResource extends AbstractResource{
	
	@Context
	private HttpServletRequest httpRequest;
	
	@POST
	@Path("consulta")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	//public Response realizaConsulta() throws Exception {
	public Response realizaConsulta(MultivaluedMap<String, String> params) throws Exception {
		String cdPt = params.getFirst("cdPt");
		String cdConsulta = params.getFirst("cdConsulta");
//		String cdPt = httpRequest.getParameter("cdPt");
//		String cdConsulta = httpRequest.getParameter("cdConsulta");
		
		
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setCdconsulta(cdConsulta);
		eventoColetado.setUp(cdPt);
		eventoColetado.setTipoEvento(ServicoFactory._CONSULTA);
		
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdPt);
		if (icupdto == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{  \"icupdto\" : \"null\" }").build();
		eventoColetado.setIcUpDTO(icupdto);
		
		MensagemRecebida mensagemRecebida = new MensagemRecebida(eventoColetado);	
		mensagemRecebida.setLog(getIdwLogger());
		mensagemRecebida.getEventoColetado().setLog(getIdwLogger());
		mensagemRecebida.setDadosIcDTO(icupdto.getIc());
		
		MsEvt retorno = ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);

		if (retorno != null) {
			Response.Status responseStatus = Response.Status.OK;
			String cb = retorno.getCb();
			String response = "{\"CampoRSP\" : \"" + cb + "\"}";
			return Response.status(responseStatus).entity(response).build();
		}
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	
	
	@POST
	@Path("lancaCiclo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response lancaCiclo(MultivaluedMap<String, String> params) throws Exception {
		String cdpt = params.getFirst("cdpt");
		String cdcp = params.getFirst("cdcp");
		String qtde = params.getFirst("qtde");
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setCdop(cdcp);
		eventoColetado.setQtde(qtde);
		eventoColetado.setUp(cdpt);
		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO);
		
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);
		if (icupdto == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{  \"icupdto\" : \"null\" }").build();
		eventoColetado.setIcUpDTO(icupdto);
		
		MensagemRecebida mensagemRecebida = new MensagemRecebida(eventoColetado);	
		mensagemRecebida.setLog(getIdwLogger());
		mensagemRecebida.setDadosIcDTO(icupdto.getIc());
		
		ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		
		Response.Status responseStatus = Response.Status.OK;
		return Response.status(responseStatus).build();
	}

	/* Alessandre em 12-04-21 para atender a empresa INOVA
	 * Esse metodo tem como objetivo substituir o metodo lancaCiclo permitindo receber o codigo a mais
	 * o codigo do produto, descricao do produto, e o tiketime do posto
	 * Assim será possivel cadastrar automaticamente a folha de processo 
	 */
	@POST
	@Path("lancaCicloComTT")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response lancaCicloComTT(MultivaluedMap<String, String> params) throws Exception {
		IdwLogger log = new IdwLogger("lancaCicloComTT");
		String cdpt = params.getFirst("cdpt");
		String cdcp = params.getFirst("cdcp");
		String qtde = params.getFirst("qtde");
		String cdproduto = params.getFirst("cdproduto");
		String takttime = params.getFirst("takttime");
		
		log.info("Recebeu cdpt=" + cdpt + " cdcp=" + cdcp + " qtde " + qtde + " cdproduto=" + cdproduto + " tt=" + takttime);
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setCdop(cdcp);
		eventoColetado.setQtde(qtde);
		eventoColetado.setUp(cdpt);
		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO);
		eventoColetado.setCdproduto(cdproduto);
		try {
			eventoColetado.setSegCiclopadrao(ConversaoTipos.converteParaBigDecimal(takttime) );
		} catch (Exception e) {
			e.printStackTrace();
			eventoColetado.setSegCiclopadrao(null);
		}
		
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);
		if (icupdto == null) {
			log.info("nao encontrou icupdto");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{  \"icupdto\" : \"null\" }").build();
		}
		
		eventoColetado.setIcUpDTO(icupdto);
		
		MensagemRecebida mensagemRecebida = new MensagemRecebida(eventoColetado);	
		mensagemRecebida.setLog(getIdwLogger());
		mensagemRecebida.setDadosIcDTO(icupdto.getIc());
		
		ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		
		Response.Status responseStatus = Response.Status.OK;
		return Response.status(responseStatus).build();
	}

	@POST
	@Path("lancaEventoHeartbeat")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response lancaEventoHeartbeat(MultivaluedMap<String, String> params) throws Exception {
		String cdpt = params.getFirst("cdpt");
		String nrOp = params.getFirst("op");
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setUp(cdpt);
		eventoColetado.setTipoEvento(ServicoFactory._IC_HEART_BEAT);
		
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);
		if (icupdto == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{  \"icupdto\" : \"null\" }").build();
		
		eventoColetado.setIcUpDTO(icupdto);
		
		MensagemRecebida mensagemRecebida = new MensagemRecebida(eventoColetado);	
		mensagemRecebida.setLog(getIdwLogger());
		mensagemRecebida.setDadosIcDTO(icupdto.getIc());
		
		ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		
		if (nrOp == null)
			return Response.status(Response.Status.OK).build();
		
		Gson gson = new Gson();
		CicloDTO cicloDTO = null;
		try {
			cicloDTO = IdwFacade.getInstancia().getCicloTimeoutEPadrao(nrOp, cdpt);
		} catch (Exception e) {
			e.printStackTrace();
			String retorno = e.getMessage();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retorno).build();
		}
		
		if (cicloDTO != null && cicloDTO.getCicloPadrao() != null 
				&& cicloDTO.getEficienciaCiclo()!=null) {
			String json = gson.toJson(cicloDTO);
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			String retorno = "{\"cicloPadrao\" : \"" + cicloDTO.getCicloPadrao() + "\" ,"
					+ " \"eficienciaCiclo\": \"" + cicloDTO.getEficienciaCiclo()+"\"}"; 
			 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retorno).build();
		}
	}

	@POST
	@Path("lancaInicioParada")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response lancaInicioParada(MultivaluedMap<String, String> params) throws Exception {
		String cdpt = params.getFirst("cdpt");
		String dthr = params.getFirst("dthr");
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setUp(cdpt);
		eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA);
		
		if (dthr == null || !dthr.contains("/")) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{ \"dthr\" : \"null\" }").build();
		}
		
		Date dthrEvento = UtilsString.convertStringToDate(dthr);
		eventoColetado.setDthrEvento(dthrEvento);
		if (dthrEvento == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{ \"dthrEvento\" : \"null\" }").build();
		
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);
		if (icupdto == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{  \"icupdto\" : \"null\" }").build();
		eventoColetado.setIcUpDTO(icupdto);
		
		MensagemRecebida mensagemRecebida = new MensagemRecebida(eventoColetado);	
		mensagemRecebida.setLog(getIdwLogger());
		mensagemRecebida.setDadosIcDTO(icupdto.getIc());
		
		ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		
		Response.Status responseStatus = Response.Status.OK;
		return Response.status(responseStatus).build();
	}
	
	@POST
	@Path("lancaFimParada")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response lancaFimParada(MultivaluedMap<String, String> params) throws Exception {
		String cdpt = params.getFirst("cdpt");
		String dthr = params.getFirst("dthr");
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setUp(cdpt);
		eventoColetado.setTipoEvento(ServicoFactory._FIM_PARADA);
		
		if (dthr == null || !dthr.contains("/")) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{ \"dthr\" : \"null\" }").build();
		}
		
		Date dthrEvento = UtilsString.convertStringToDate(dthr);
		eventoColetado.setDthrEvento(dthrEvento);
		if (dthrEvento == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{ \"dthrEvento\" : \"null\" }").build();
		
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);
		if (icupdto == null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{  \"icupdto\" : \"null\" }").build();
		eventoColetado.setIcUpDTO(icupdto);
		
		MensagemRecebida mensagemRecebida = new MensagemRecebida(eventoColetado);	
		mensagemRecebida.setLog(getIdwLogger());
		mensagemRecebida.setDadosIcDTO(icupdto.getIc());
		
		ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		
		Response.Status responseStatus = Response.Status.OK;
		return Response.status(responseStatus).build();
	}
	
	// LEGADO ------------------------------------------------------------------------------------------------------------------
	// AVALIAR SE PODE SER REMOVIDO
	@POST
	@Path("lancaFimCiclo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lancaFimCiclo(@Context HttpServletRequest request, ParamsLancaFimCicloDTO params) {
		
		//TokenFilter.validar(request);
		
		DAOGenerico dao = new DAOGenerico();

		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd'T'HH:mm:ss").create();
		
		Response.Status responseStatus = Response.Status.OK;

		String cdpt = params.getCdPt();
		String cdcp = params.getCdCp();
		// String idpt = Long.toString(  params.getIdPt() );
		String qtde = Long.toString( params.getQtde() );
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setTipoEvento(2);
		eventoColetado.setCdop(cdcp);
		eventoColetado.setQtde(qtde);
		eventoColetado.setUp(cdpt);
		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO);

		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);
		eventoColetado.setIcUpDTO(icupdto);

		MensagemRecebida mensagemRecebida = new MensagemRecebida(eventoColetado);	
		mensagemRecebida.setLog(getIdwLogger());
		mensagemRecebida.setDadosIcDTO(icupdto.getIc());

		try{
			ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		}catch(ServicoFalhouException e)
		{
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		}

		String json = gson.toJson(mensagemRecebida);
		return Response.status(responseStatus).entity(json).build();
	}



	@POST
	@Path("lancaHeartbeat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lancaHeartbeat(@Context HttpServletRequest request, ParamsLancaFimCicloDTO params) {
		
		//TokenFilter.validar(request);
		
		DAOGenerico dao = new DAOGenerico();

		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd'T'HH:mm:ss").create();
		
		Response.Status responseStatus = Response.Status.OK;

		String cdpt = params.getCdPt();
		String cdcp = params.getCdCp();
		// String idpt = Long.toString(  params.getIdPt() );
		String qtde = Long.toString( params.getQtde() );
		
		EventoColetado eventoColetado = new EventoColetado();
		eventoColetado.setDthrEvento(new Date());
		eventoColetado.setTipoEvento(2);
		eventoColetado.setCdop(cdcp);
		eventoColetado.setQtde(qtde);
		eventoColetado.setUp(cdpt);
		eventoColetado.setTipoEvento(ServicoFactory._IC_HEART_BEAT);

		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);
		eventoColetado.setIcUpDTO(icupdto);

		MensagemRecebida mensagemRecebida = new MensagemRecebida(eventoColetado);	
		mensagemRecebida.setLog(getIdwLogger());
		mensagemRecebida.setDadosIcDTO(icupdto.getIc());

		try{
			ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		}catch(ServicoFalhouException e)
		{
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		}

		String json = gson.toJson(mensagemRecebida);
		return Response.status(responseStatus).entity(json).build();
	}
	
	
}

package idw.webservices.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.IdwFacade;
import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.pojos.template.MsEvtTemplate.StEvt;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.dto.CodigoDescricaoDTO;
import idw.webservices.rest.dto.DadosTempoRealDTO;
import idw.webservices.rest.dto.EventoResourceDTO;
import injetws.model.IwsFacade;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsHorarioDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsReleDTO;
import ms.model.MsFacade;
import ms.util.ConversaoTipos;

public class ColetaFacade {
	
	private static ColetaFacade instancia = null;
	
	private ColetaFacade() {
		super();
	}
	
	
	public static ColetaFacade getInstancia() {
		if (instancia == null) {
			instancia = new ColetaFacade();
		}

		return instancia;
	}

	// Metodo para controle do fim de ciclo
	public Response fimCiclo(@Context HttpServletRequest request) {
		EventoResourceDTO eventoResource = new EventoResourceDTO();
		
		eventoResource.setIdup(request.getParameter("idup") );
		eventoResource.setDthrEvento(request.getParameter("dthrEvento"));
		
		Date dthrEvento =  DataHoraRN.stringToDate(eventoResource.getDthrEvento(), "yyyy-MM-dd-HH:mm:ss.SSS");
		
		System.out.println(eventoResource.getIdup() + " - " + DataHoraRN.getDataHoraAtualFormatada() + " - dthrEvento=" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrEvento) );
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			
			
			// Se o IDW estiver ativo entao enviar dados para MsWsComEvt
			IwsReleDTO retorno = new IwsReleDTO();
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_CicloFim(eventoResource.getIdup(), dthrEvento, eventoResource.getDados());
			}  else {
				retorno = IwsFacade.getInstancia().setTr_CicloFim(eventoResource.getIdup(), dthrEvento, eventoResource.getDados());
			}
			
			String json = gson.toJson(retorno); //alerta: nesta configuração apenas NAO NULOS retornam dados; os nulos ficam omissos aqui no json; mas possivel redefinir gson para forçar retornar ainda assim os NULOS.
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	public Response getDtHrAtual(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			String dthrEvento = DataHoraRN.getDataHoraAtualFormatada();
			String json = gson.toJson(dthrEvento); //alerta: nesta configuração apenas NAO NULOS retornam dados; os nulos ficam omissos aqui no json; mas possivel redefinir gson para forçar retornar ainda assim os NULOS.
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}


	/* Metodo usado para inicializacao do inova mini com os dados da up, alem de servir
	 * para o heartbeat
	 */
	public Response setUpBeat(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsHorarioDTO retorno;
			
			String mac = request.getParameter("ip");
			Date dthrEvento =  DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			boolean isLogoutNaViradaTurno = true;
			boolean isFechaParadaNaViradaTurno = true;

			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setUPBeat(mac, dthrEvento, isLogoutNaViradaTurno, isFechaParadaNaViradaTurno);
			}  else {
				retorno = IwsFacade.getInstancia().setUPBeatMac(mac, dthrEvento, isLogoutNaViradaTurno, isFechaParadaNaViradaTurno);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	/* Valida autenticacao do operador
	 * 
	 */
	public Response getTr_Autorizacao(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsAutenticacaoDTO retorno;
			
			Date dthrEvento =  DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			
			String idUp = request.getParameter("idup");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			int avaliar = 1;
			Boolean validaPorDsUsuario = false;
			
			
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().getTr_Autorizacao(idUp, login, senha, avaliar, dthrEvento, validaPorDsUsuario);
			}  else {
				retorno = IwsFacade.getInstancia().getTr_Autorizacao(idUp, login, senha, avaliar, dthrEvento, validaPorDsUsuario);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}
	
	
	/* Login a partir do coletor
	 * 
	 */
	public Response setTr_operadorInicio(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsErroDTO retorno;
			
			Date dthrEvento =  DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			
			String idUp = request.getParameter("idup");
			String login = request.getParameter("login");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_operadorInicio(idUp, login, dthrEvento);
			}  else {
				retorno = IwsFacade.getInstancia().efetuaLogin(idUp, login, dthrEvento);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}
	
	
	/* Facade para chamada da RN de logout do coletor
	 * 
	 */
	public Response setTr_operadorFim(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsErroDTO retorno;
			
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			Date dthrILogin = DataHoraRN.stringToDate(request.getParameter("dthrILogin"), "yyyy-MM-dd-HH:mm:ss.SSS");
			
			String idUp = request.getParameter("idup");
			String login = request.getParameter("login");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_operadorFim(idUp, login, dthrEvento, dthrILogin);
			}  else {
				retorno = IwsFacade.getInstancia().efetuaLogout(idUp, login, dthrEvento, dthrILogin);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	
	
	
	/* Validacao do codigo do alerta
	 * 
	 */
	public Response getTr_TabAlertaSetaCod(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsAlertaDTO retorno;
	
			
			String cdalerta = request.getParameter("cdalerta");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().getTr_TabAlertaSetaCod(cdalerta);
			}  else {
				retorno = IwsFacade.getInstancia().getTr_TabAlertaSetaCod(cdalerta);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}
	
	
	/* Inicia um alerta
	 * 
	 */
	public Response setTr_alertaInicio(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			
			String idUp = request.getParameter("idup");
			String cdalerta = request.getParameter("cdalerta");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_alertaInicio(idUp, cdalerta, dthrEvento);
			}  else {
				retorno = IwsFacade.getInstancia().setTr_AlertaInicio(idUp, cdalerta, dthrEvento);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response setTr_alertaFim(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			
			String idUp = request.getParameter("idup");
			String cdalerta = request.getParameter("cdalerta");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_alertaFim(idUp, cdalerta, dthrEvento);
			}  else {
				retorno = IwsFacade.getInstancia().setTr_AlertaFim(idUp, cdalerta, dthrEvento);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}




	public Response setTr_Consula(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsConsultaDTO retorno;
			
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			
			String idUp = request.getParameter("idup");
			String cdconsulta = request.getParameter("cdconsulta");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_Consulta(cdconsulta, idUp, dthrEvento);
			}  else {
				retorno = IwsFacade.getInstancia().setTr_Consulta(cdconsulta, idUp, dthrEvento);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	public Response getTr_ValidaCodRefugo(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsRefugoDTO retorno;
			
			String idUp = request.getParameter("idup");
			String cdrefugo = request.getParameter("cdrefugo");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().getTr_ValidaCodRefugo(idUp, cdrefugo);
			}  else {
				retorno = IwsFacade.getInstancia().getTr_TabValidaCodRefugo(idUp, cdrefugo);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	public Response setTr_LancaEventoRefugo(@Context HttpServletRequest request){
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsRefugoDTO retorno;
			
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			String idUp = request.getParameter("idup");
			String cdrefugo = request.getParameter("cdrefugo");
			String cdcausa = request.getParameter("cdcausa");
			String idProdutoReduzido = request.getParameter("idprodutoreduzido");
			String cdacao = request.getParameter("cdacao");
			String quantidade = request.getParameter("quantidade");
			
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_LancaEventoRefugo(cdrefugo, cdcausa, cdacao, quantidade, idUp, idProdutoReduzido, dthrEvento);
			}  else {
				retorno = IwsFacade.getInstancia().setTr_LancaEventoRefugo(cdrefugo, cdcausa, cdacao, quantidade, idUp, idProdutoReduzido, dthrEvento);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}





	public Response getTr_validaCausa(@Context HttpServletRequest request){
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			
			String cdcausa = request.getParameter("cdcausa");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().getTr_validaCausa(cdcausa);
			}  else {
				retorno = IwsFacade.getInstancia().validaCausa(cdcausa);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}






	public Response getTr_validaAcao(@Context HttpServletRequest request){
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			
			String cdacao = request.getParameter("cdacao");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().getTr_validaAcao(cdacao);
			}  else {
				retorno = IwsFacade.getInstancia().validaAcao(cdacao);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	public Response getTr_TabParadaSetaCod(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsParadaDTO retorno;
			
			String idUp = request.getParameter("idup");
			String cdparada = request.getParameter("cdparada");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().getTr_TabParadaSetaCod(idUp, cdparada);
			}  else {
				retorno = IwsFacade.getInstancia().getTr_TabParadaSetaCod(idUp, cdparada);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	
	
	


	public Response setTr_paradaInicio(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsCicloDTO retorno;
			
			String idUp = request.getParameter("idup");
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			Boolean isParadaAutomatica = request.getParameter("isParadaAutomatica").equals("1") ? true : false;
			Boolean isParadaPersistente = request.getParameter("isParadaPersistente").equals("1") ? true : false;
			Boolean isParadaPeriodoSemConexao = request.getParameter("isParadaPeriodoSemConexao").equals("1") ? true : false;
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_paradaInicio(idUp, dthrEvento, isParadaAutomatica, isParadaPersistente, isParadaPeriodoSemConexao);
			}  else {
				retorno = IwsFacade.getInstancia().setTr_paradaInicio(idUp, dthrEvento, isParadaAutomatica, isParadaPersistente, isParadaPeriodoSemConexao);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response setTr_paradaFim(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			
			String idUp = request.getParameter("idup");
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_paradaFim(idUp, dthrEvento);
			}  else {
				retorno = IwsFacade.getInstancia().setTr_paradaFim(idUp, dthrEvento);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response setTr_paradaMotivo(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			
			String idUp = request.getParameter("idup");
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			String idParada = request.getParameter("cdparada");
			String idAcao = request.getParameter("cdacao");
			String idCausa = request.getParameter("cdcausa");
			String idJustificativa = request.getParameter("cdjustificativa");
			String idTecnicoResponsavel = request.getParameter("cdtecnicoresponsavel");
			String idTecnicoUm = request.getParameter("cdtecnicoum");
			String idTecnicoDois = request.getParameter("cdtecnicodois");
			String idLocal = request.getParameter("cdlocal");
			boolean isParadaRegulagem  = request.getParameter("isParadaRegulagem").equals("1") ? true : false;
			String tipoParPreConfig = request.getParameter("tipoParPreConfig");
			int batidas = ConversaoTipos.converteParaInt(request.getParameter("batidas"));
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_paradaMotivo(idUp, dthrEvento, idParada, idAcao, idCausa, idJustificativa, idTecnicoResponsavel, idTecnicoUm, idTecnicoDois, idLocal, isParadaRegulagem, tipoParPreConfig, batidas);
			}  else {
				retorno = IwsFacade.getInstancia().setTr_paradaMotivo(idUp, dthrEvento, idParada, idAcao, idCausa, idJustificativa, idTecnicoResponsavel, idTecnicoUm, idTecnicoDois, idLocal, isParadaRegulagem, tipoParPreConfig, batidas);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response getTr_validaJustificativa(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			boolean retorno;
			
			String cdjustificativa = request.getParameter("cdjustificativa");
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().getTr_validaJustificativa(cdjustificativa);
			}  else {
				retorno = IwsFacade.getInstancia().validaJustificativa(cdjustificativa);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	public Response getTr_planejamento(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsCpDTO retorno;
			
			String idUp = request.getParameter("idup");
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			String cdmolde = request.getParameter("cdmolde");
			String stCriacaoCP = request.getParameter("stcriacaocp");
			String nrop = request.getParameter("nrop");
			
			
			IwsCpDTO cpEntrada = new IwsCpDTO();
			cpEntrada.setCdmolde(cdmolde);
			cpEntrada.setNrop(nrop);
			cpEntrada.setStCriacaoCP(stCriacaoCP);
			
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().getTr_planejamento(idUp, cpEntrada, dthrEvento);
			}  else {
				retorno = IwsFacade.getInstancia().planejamento(idUp, cpEntrada, dthrEvento);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}




	public Response setTr_fimplanejamento(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			boolean retorno;
			
			String idUp = request.getParameter("idup");
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			int batidas = ConversaoTipos.converteParaInt(request.getParameter("batidas"));
			
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().fimPlanejamento(idUp, dthrEvento, batidas);
			}  else {
				retorno = IwsFacade.getInstancia().fimPlanejamento(idUp, dthrEvento, batidas, false);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}





	public Response setTr_ApagaUltimoRefugo(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			boolean retorno;
			
			String idUp = request.getParameter("idup");
			String cdRefugo = request.getParameter("cdrefugo");
			String idRdzProduto = request.getParameter("idrdzproduto");
			
			Date dthrEvento = DataHoraRN.stringToDate(request.getParameter("dthrEvento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			Date dthrRefugo = DataHoraRN.stringToDate(request.getParameter("dthrRefugo"), "yyyy-MM-dd-HH:mm:ss.SSS");
			String miliDtHrRefugo = "";
			
			
			if (IdwFacade.IS_IDW_ATIVO) {
				retorno = IdwFacade.getInstancia().setTr_ApagaUltimoRefugo(cdRefugo, idRdzProduto, dthrRefugo, miliDtHrRefugo, idUp, dthrEvento);
			}  else {
				retorno = IwsFacade.getInstancia().setTr_ApagaUltimoRefugo(cdRefugo, idRdzProduto, dthrRefugo, miliDtHrRefugo, idUp, dthrEvento);
			}
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}


	public Response pesquisarUps(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			List<Object> retorno;
			
			String mac = request.getParameter("mac");
			
			
			retorno = MsFacade.getInstancia().pesquisarUps(mac);
			
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	public Response getListaParadasAtivasPT(@Context HttpServletRequest request) {
		//TokenFilter.validar(request);
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			List<CodigoDescricaoDTO> retorno = new ArrayList<CodigoDescricaoDTO>();
			
			String cdMaquina = request.getParameter("cdMaquina"); 						
			retorno = IdwFacade.getInstancia().getListaParadasAtivasPT(cdMaquina);
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}
	
	
	public Response getDadosTempoReal(@Context HttpServletRequest request) {
		//TokenFilter.validar(request);
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			DadosTempoRealDTO retorno;
			
			String cdMaquina = request.getParameter("cdMaquina"); 						
			retorno = IdwFacade.getInstancia().getDadosTempoReal(cdMaquina);
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
			
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}
	
	public Response enviaAlteracaoParada(@Context HttpServletRequest request) {
		//TokenFilter.validar(request);
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			boolean retorno;
			
			String cdMaquina = request.getParameter("cdMaquina"); 	
			String cdParada = request.getParameter("cdParada"); 	
			
			DadosTempoRealDTO dados = IdwFacade.getInstancia().getDadosTempoReal(cdMaquina);
 
			retorno = IdwFacade.getInstancia().setTr_paradaMotivo(
					dados.getIdUP(), 
					DataHoraRN.getDataHoraAtual(), 
					cdParada, 
					"", 
					"", 
					"", 
					"", 
					"", 
					"", 
					"", 
					false, 
					"", 
					0);
			
			String json = gson.toJson(retorno); 
			return Response.status(responseStatus).entity(json).build();
			
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	
	public Response mapConsumirPesquisarIdsPendentes(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			List<Long> retorno;
			
			String cdup = request.getParameter("cdup");
			Integer qtRegistros = ConversaoTipos.converteParaInt(request.getParameter("qtRegistros"));
			
			
			retorno = (List<Long>) MsFacade.getInstancia().mapConsumirPesquisarIdsPendentes(cdup, qtRegistros);
			
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}




	public Response mapConsumirPesquisarEvento(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MsEvt retorno;
			
			Long idEvt = ConversaoTipos.converterParaLong(request.getParameter("idevt"));
			
			
			retorno = MsFacade.getInstancia().mapConsumirPesquisarEvento(idEvt);
			
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	public Response mapConsumirFinalizarEvento(@Context HttpServletRequest request) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {			
			Long idEvt = ConversaoTipos.converterParaLong(request.getParameter("idevt"));
			int _stevt = ConversaoTipos.converteParaInt(request.getParameter("stevt"));
			Date dtHrIProcessamento = DataHoraRN.stringToDate(request.getParameter("dthriprocessamento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			Date dtHrFimProcessamento = DataHoraRN.stringToDate(request.getParameter("dthrfprocessamento"), "yyyy-MM-dd-HH:mm:ss.SSS");
			String erroConsol = request.getParameter("erroconsol");
			
			MsFacade.getInstancia().mapConsumirFinalizarEvento(idEvt, _stevt, dtHrIProcessamento, dtHrFimProcessamento, erroConsol);
			
			String json = gson.toJson(true);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

}

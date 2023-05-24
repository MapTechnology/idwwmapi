package idw.webservices.rest.idw.v2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmUsr;
import idw.model.rn.AlertaRN;
import idw.model.rn.CausaRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.JustificativaRN;
import idw.model.rn.PTRN;
import idw.model.rn.ParadaRN;
import idw.model.rn.RefugoRN;
import idw.model.rn.TAcaoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.op.OpSimplesRN;
import idw.model.rn.web.vf.monitorizacao.MonitorizacaoWebRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.auth.TokenFilter;
import idw.webservices.rest.idw.v2.dto.AlertaOcorDTO;
import idw.webservices.rest.idw.v2.dto.EvtIHMAlertaDTO;
import idw.webservices.rest.idw.v2.dto.EvtIHMOPDTO;
import idw.webservices.rest.idw.v2.dto.EvtIHMLoginDTO;
import idw.webservices.rest.idw.v2.dto.EvtIHMParadaDTO;
import idw.webservices.rest.idw.v2.dto.EvtIHMRefugoDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.FolhaRapProdutoDTO;
import idw.webservices.rest.idw.v2.dto.IhmDTO2;
import idw.webservices.rest.idw.v2.dto.ListaAcoesDTO;
import idw.webservices.rest.idw.v2.dto.ListaAlertasDTO;
import idw.webservices.rest.idw.v2.dto.ListaCausasDTO;
import idw.webservices.rest.idw.v2.dto.ListaJustificativasDTO;
import idw.webservices.rest.idw.v2.dto.ListaParadasDTO;
import idw.webservices.rest.idw.v2.dto.ListaRefugosDTO;
import idw.webservices.rest.idw.v2.dto.LoginDTO;
import idw.webservices.rest.idw.v2.dto.LoginOcorDTO;
import idw.webservices.rest.idw.v2.dto.MaquinaIHMDTO;
import idw.webservices.rest.idw.v2.dto.OpComRapDTO;
import idw.webservices.rest.idw.v2.dto.ParadaCadDTO;
import idw.webservices.rest.idw.v2.dto.ParadaOcorDTO;
import idw.webservices.rest.idw.v2.dto.PtDTO2;
import idw.webservices.rest.idw.v2.dto.RefugoOcorDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import ms.model.rn.IhmRN;
import ms.model.rn.UpRN;

@Path("/v2/coletaihm")
public class ColetaIHMResource {
	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";

	private static final int qtdItensCadRetornoLista = 5000;

	@GET
	@Path("/pts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaPtsIHM(@HeaderParam("authorization") String authString, @QueryParam("ihm") String ihm) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsIHMValida(ihm, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "IHM inválida", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				List<MaquinaIHMDTO> retorno = rn.getListaPtsIHM(ihm);
				dao.commitaTransacao();
				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/indicadorespt")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIndicadoresPt(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				MaquinaIHMDTO retorno = rn.getIndicadoresPt(cdPt);
				dao.commitaTransacao();
				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/ptsselecao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIndicadoresIHM(@HeaderParam("authorization") String authString, @QueryParam("ihm") String ihm) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsIHMValida(ihm, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "IHM inválida", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				List<MaquinaIHMDTO> retorno = rn.getIndicadoresPtsIHM(ihm);
				dao.commitaTransacao();
				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/consulta/indicadoresop")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsultaIndicadoresOP(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				MaquinaIHMDTO retorno = rn.getConsultaIndicadoresOP(cdPt);
				dao.commitaTransacao();
				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/consulta/indicadoreshoraatual")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsultaIndicadoresHora(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				MaquinaIHMDTO retorno = rn.getConsultaIndicadoresHora(cdPt);
				dao.commitaTransacao();

				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/consulta/indicadoresturnoatual")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsultaIndicadoresTurnoAtual(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				MaquinaIHMDTO retorno = rn.getConsultaIndicadoresTurnoAtual(cdPt);
				dao.commitaTransacao();

				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/consulta/indicadoresturnoanterior")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsultaIndicadoresTurnoAnterior(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				MaquinaIHMDTO retorno = rn.getConsultaIndicadoresTurnoAnterior(cdPt);
				dao.commitaTransacao();

				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/alertas/abertos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlertasAbertos(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				List<AlertaOcorDTO> retorno = rn.getAlertasAbertos(cdPt);
				dao.commitaTransacao();

				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/logins/abertos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOperadesComLoginAberto(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				List<LoginOcorDTO> retorno = rn.getLoginsAbertos(cdPt);
				dao.commitaTransacao();

				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/refugos/ultimo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUltimoRefugo(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				RefugoOcorDTO retorno = rn.getUltimoRefugo(cdPt);
				dao.commitaTransacao();

				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/refugos/produtosopatual")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdutosOPAtual(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			List<FolhaRapProdutoDTO> retorno = new ArrayList<FolhaRapProdutoDTO>();

			if (!IsPtValido(cdPt, null)) {
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				FolhaRN rnFolha = new FolhaRN(new DAOGenerico());
				retorno = rnFolha.getProdutosOPAtual(cdPt);
				rnFolha = null;

				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	// alertas
	@GET
	@Path("/alertas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlertasAtivos(
			@HeaderParam("authorization") String authString,
			@QueryParam("conteudoPesquisa") String conteudoPesquisa) {

		TokenFilter.validarBasicAuthNIDW(authString);

		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, 1, qtdItensCadRetornoLista);

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

			String json = gson.toJson(retornoConsulta.getItems());
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

	@POST
	@Path("/alertas/abrir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_alertaInicio(@HeaderParam("authorization") String authString, EvtIHMAlertaDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrIniAlertaMs(), "yyyy-MM-dd HH:mm:ss.SSS");

			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();
			rnUp = null;

			String cdAlerta = evt.getCdAlerta();
			retorno = IdwFacade.getInstancia().setTr_alertaInicio(idUp, cdAlerta, dthrEvento);

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

	@POST
	@Path("/alertas/fechar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_alertaFim(@HeaderParam("authorization") String authString, EvtIHMAlertaDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrFimAlertaMs(), "yyyy-MM-dd HH:mm:ss.SSS");

			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();
			rnUp = null;

			String cdAlerta = evt.getCdAlerta();
			retorno = IdwFacade.getInstancia().setTr_alertaFim(idUp, cdAlerta, dthrEvento);

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

	@POST
	@Path("/logins/validausr")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validaLogin(@HeaderParam("authorization") String authString, EvtIHMLoginDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			UsuarioRN usrRN = new UsuarioRN();
			usrRN.getDao().iniciaSessao();
			OmUsr usr = usrRN.getUsuario(evt.getLogin(), evt.getSenha());
			usrRN.getDao().finalizaSessao();
			usrRN = null;

			if (usr != null) {
				LoginDTO retorno = new LoginDTO();
				retorno.setCdUsr(usr.getCdUsr());
				retorno.setDsUsr(usr.getDsNome());
				retorno.setLogin(usr.getLogin());
				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();

			} else {
				responseStatus = Response.Status.NOT_FOUND;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "USUÁRIO OU SENHA INVÁLIDOS", "");
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	@POST
	@Path("/logins/abrir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_operadorInicio(@HeaderParam("authorization") String authString, EvtIHMLoginDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsErroDTO retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrLoginMs(), "yyyy-MM-dd HH:mm:ss.SSS");

			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();
			rnUp = null;

			UsuarioRN usrRN = new UsuarioRN();
			usrRN.getDao().iniciaSessao();
			String cdOperador = usrRN.getUsrByLogin(evt.getLogin()).getCdUsr();
			OmUsr usr = usrRN.getUsuario(evt.getLogin(), evt.getSenha());
			usrRN.getDao().finalizaSessao();
			usrRN = null;

			if (usr != null) {
				retorno = IdwFacade.getInstancia().setTr_operadorInicio(idUp, cdOperador, dthrEvento);

				if (retorno.getSucesso()) {
					String json = gson.toJson(retorno.getSucesso());
					return Response.status(responseStatus).entity(json).build();
				} else {
					responseStatus = Response.Status.BAD_REQUEST;
					ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), retorno.getMensagem(), retorno.getMensagem());
					throw new ResourceWebApplicationException(responseStatus, error);
				}

			} else {
				responseStatus = Response.Status.NOT_FOUND;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "USUÁRIO OU SENHA INVÁLIDOS", "");
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	@POST
	@Path("/logins/fechar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_operadorFim(@HeaderParam("authorization") String authString, EvtIHMLoginDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsErroDTO retorno;
			Date dthrIni = DataHoraRN.stringToDate(evt.getDthrLoginMs(), "yyyy-MM-dd HH:mm:ss.SSS");
			Date dthrFim = DataHoraRN.stringToDate(evt.getDthrLogoutMs(), "yyyy-MM-dd HH:mm:ss.SSS");

			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();
			rnUp = null;

			UsuarioRN usrRN = new UsuarioRN();
			usrRN.getDao().iniciaSessao();
			String cdOperador = usrRN.getUsrByLogin(evt.getLogin()).getCdUsr();
			OmUsr usr = usrRN.getUsuario(evt.getLogin(), evt.getSenha());
			usrRN.getDao().finalizaSessao();
			usrRN = null;

			if (usr != null) {
				retorno = IdwFacade.getInstancia().setTr_operadorFim(idUp, cdOperador, dthrFim, dthrIni);

				if (retorno.getSucesso()) {
					String json = gson.toJson(retorno.getSucesso());
					return Response.status(responseStatus).entity(json).build();
				} else {
					responseStatus = Response.Status.BAD_REQUEST;
					ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), retorno.getMensagem(), retorno.getMensagem());
					throw new ResourceWebApplicationException(responseStatus, error);
				}

			} else {
				responseStatus = Response.Status.NOT_FOUND;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "USUÁRIO OU SENHA INVÁLIDOS", "");
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	@POST
	@Path("/refugos/refugar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_LancaEventoRefugo(@HeaderParam("authorization") String authString, EvtIHMRefugoDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsRefugoDTO retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrRefugoMs(), "yyyy-MM-dd HH:mm:ss.SSS");

			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();

			FolhaRN rnFolha = new FolhaRN(rnUp.getDaoPdba());
			String idReduzido = rnFolha.getIdReduzidoProdutoCpAtual(evt.getCdPt(), evt.getCdProduto()).toString();

			rnUp = null;
			rnFolha = null;

			retorno = IdwFacade.getInstancia().setTr_LancaEventoRefugo(
					evt.getCdRefugo(),
					evt.getCdCausa(),
					evt.getCdAcao(),
					evt.getQtdRefugada().toString(),
					idUp,
					idReduzido,
					dthrEvento);

			if (retorno != null && !retorno.getIsRefugoValido()) {
				String json = gson.toJson(true);
				return Response.status(responseStatus).entity(json).build();
			} else {
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	@POST
	@Path("/refugos/cancelar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_ApagaUltimoRefugo(@HeaderParam("authorization") String authString, EvtIHMRefugoDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Boolean retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrRefugoMs(), "yyyy-MM-dd HH:mm:ss.SSS");

			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();

			FolhaRN rnFolha = new FolhaRN(rnUp.getDaoPdba());
			String idReduzido = rnFolha.getIdReduzidoProdutoCpAtual(evt.getCdPt(), evt.getCdProduto()).toString();

			rnUp = null;
			rnFolha = null;

			retorno = IdwFacade.getInstancia().setTr_ApagaUltimoRefugo(
					evt.getCdRefugo(),
					idReduzido,
					dthrEvento,
					"", // milisegundos
					idUp,
					DataHoraRN.getDataHoraAtual());

			if (retorno) {
				String json = gson.toJson(true);
				return Response.status(responseStatus).entity(json).build();
			} else {
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	// refugos
	@GET
	@Path("/refugos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRefugosAtivos(@HeaderParam("authorization") String authString,
			@QueryParam("conteudoPesquisa") String conteudoPesquisa) {
		TokenFilter.validarBasicAuthNIDW(authString);

		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, 1, qtdItensCadRetornoLista);

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
			String json = gson.toJson(retornoConsulta.getItems());
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

	// paradas
	@GET
	@Path("/paradas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParadasAtivas(@HeaderParam("authorization") String authString,
			@QueryParam("conteudoPesquisa") String conteudoPesquisa) {
		TokenFilter.validarBasicAuthNIDW(authString);

		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, 1, qtdItensCadRetornoLista);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ParadaRN rn = new ParadaRN();
			rn.setDao(dao);

			ListaParadasDTO retornoConsulta = rn.getParadasDTO(filtro);
			String json = gson.toJson(retornoConsulta.getItems());
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

	// causas
	@GET
	@Path("/causas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCausasAtivas(@HeaderParam("authorization") String authString,
			@QueryParam("conteudoPesquisa") String conteudoPesquisa) {
		TokenFilter.validarBasicAuthNIDW(authString);

		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, 1, qtdItensCadRetornoLista);

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

			String json = gson.toJson(retornoConsulta.getItems());
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

	// ações
	@GET
	@Path("/acoes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAcoesAtivas(@HeaderParam("authorization") String authString,
			@QueryParam("conteudoPesquisa") String conteudoPesquisa) {
		TokenFilter.validarBasicAuthNIDW(authString);

		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, 1, qtdItensCadRetornoLista);

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
			String json = gson.toJson(retornoConsulta.getItems());
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

	// justificativas
	@GET
	@Path("/justificativas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJustificativasAtivas(@HeaderParam("authorization") String authString,
			@QueryParam("conteudoPesquisa") String conteudoPesquisa) {
		TokenFilter.validarBasicAuthNIDW(authString);

		FiltroPesquisaDTO filtro = getFiltroPesquisa(conteudoPesquisa, 1, qtdItensCadRetornoLista);

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
			String json = gson.toJson(retornoConsulta.getItems());
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
	@Path("/paradas/ultima")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUltimaParada(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				ParadaOcorDTO retorno = rn.getUltimaParada(cdPt);
				dao.commitaTransacao();
				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/paradas/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_paradaMotivo(@HeaderParam("authorization") String authString, EvtIHMParadaDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			boolean retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrIniParMs(), "yyyy-MM-dd HH:mm:ss.SSS");

			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();

			DAOGenerico dao = new DAOGenerico();
			dao.iniciaSessao();
			ParadaRN rnPar = new ParadaRN(dao);
			ParadaCadDTO parDTO = rnPar.getParadaByCd(evt.getCdParada());
			dao.finalizaSessao();

			rnUp = null;
			rnPar = null;

			retorno = IdwFacade.getInstancia().setTr_paradaMotivo(
					idUp,
					dthrEvento,
					evt.getCdParada(),
					evt.getCdAcao(),
					evt.getCdCausa(),
					evt.getCdJust(),
					evt.getCdTecResp(),
					evt.getCdTec1(),
					evt.getCdTec2(),
					"",
					parDTO.isReqCancelamento(),
					"",
					0);

			if (retorno) {
				String json = gson.toJson(true);
				return Response.status(responseStatus).entity(json).build();
			} else {
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}


	@POST
	@Path("/paradas/fechar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_paradaFimParadaIni(@HeaderParam("authorization") String authString, EvtIHMParadaDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			boolean retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrIniParMs(), "yyyy-MM-dd HH:mm:ss.SSS");

			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();
			rnUp = null;

			retorno = IdwFacade.getInstancia().setTr_paradaFim(idUp, dthrEvento);

			if (retorno) {
				// Nao retorna nada indicando que deu certo. Quando dá ruim, levanta exception
				IdwFacade.getInstancia().setTr_paradaInicio(idUp, dthrEvento, false, false, false);

				String json = gson.toJson(true);
				return Response.status(responseStatus).entity(json).build();
			} else {
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	@GET
	@Path("/ops/proxima")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProximaOP(@HeaderParam("authorization") String authString, @QueryParam("cdPt") String cdPt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			if (!IsPtValido(cdPt, dao)) {
				dao.rollBackTransacaoSemException();
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "PT INVÁLIDO", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			} else {
				CpRN rn = new CpRN(dao);
				OpComRapDTO retorno = rn.getProximaOPComRapProduto(cdPt);
				dao.commitaTransacao();
				String json = gson.toJson(retorno);
				return Response.status(responseStatus).entity(json).build();
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	

	@POST
	@Path("/ops/iniciar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setNovaOP(@HeaderParam("authorization") String authString, EvtIHMOPDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			IwsCpDTO retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrEvt(), "yyyy-MM-dd HH:mm:ss");
			
			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();
			rnUp = null;

			IwsCpDTO op = new IwsCpDTO();
			op.setNrop(evt.getNrDoc());
			op.setStCriacaoCP(evt.getTpSessao().toString()); 
			op.setCdmolde(evt.getCdRap());
			op.setCdProduto(evt.getCdProduto());
			
			retorno = IdwFacade.getInstancia().getTr_planejamento(idUp, op, dthrEvento);

			if (! retorno.getNrop().equals("")) {
				String json = gson.toJson(true);
				return Response.status(responseStatus).entity(json).build();
			} else {
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	@POST
	@Path("/ops/finalizar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setFimOP(@HeaderParam("authorization") String authString, EvtIHMOPDTO evt) {
		TokenFilter.validarBasicAuthNIDW(authString);

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			boolean retorno;
			Date dthrEvento = DataHoraRN.stringToDate(evt.getDthrEvt(), "yyyy-MM-dd HH:mm:ss");
			
			UpRN rnUp = new UpRN();
			String idUp = rnUp.getUPByCdPt(evt.getCdPt()).getIdUp().toString();
			rnUp = null;
 
			retorno = IdwFacade.getInstancia().fimPlanejamento(idUp, dthrEvento, 0);

			if (retorno) {
				String json = gson.toJson(true);
				return Response.status(responseStatus).entity(json).build();
			} else {
				responseStatus = Response.Status.BAD_REQUEST;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
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

	private boolean IsIHMValida(String cdIHM, DAOGenerico dao) {
		boolean retorno = false;

		IhmRN rn = new IhmRN(dao);
		IhmDTO2 ihm = rn.getIHMByCd(cdIHM);

		if (ihm.getIdIHM() != null) {
			retorno = true;
		}

		rn = null;
		ihm = null;

		return retorno;
	}

	private boolean IsPtValido(String cdPt, DAOGenerico dao) {
		boolean retorno = false;
		boolean sessaoLocal = false;

		if (dao == null) {
			dao = new DAOGenerico();
			dao.iniciaSessao();
			sessaoLocal = true;
		}
		
		PTRN rn = new PTRN(dao);
		PtDTO2 pt = rn.getPtByCd(cdPt);

		if (pt.getCdPt() != null) {
			retorno = true;
		}

		rn = null;
		pt = null;

		if (sessaoLocal) {
			dao = null;
		}
		
		return retorno;
	}
	
}

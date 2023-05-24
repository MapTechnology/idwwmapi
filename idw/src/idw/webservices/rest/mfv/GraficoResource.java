package idw.webservices.rest.mfv;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolpaDAO;
import idw.model.dao.DwRtCicDAO;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwRtcic;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwConsolidRN;
import idw.util.AritmeticaUtil;
import idw.webservices.rest.ResourceWebApplicationException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ms.util.ConversaoTipos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/mfv")
public class GraficoResource {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DATA_ISO8601 = "yyyy-MM-dd";
	public static final String FORMATO_DATA_HORA_ISO8601 = "yyyy-MM-dd HH:mm:ss";

	@GET
	@Path("/oee")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOee(
			@QueryParam("cdProduto") String cdProduto,
			@QueryParam("idGt") int idGt,
			@QueryParam("dtInicio") String dtInicio,
			@QueryParam("dtFim") String dtFim) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			DwConsolidRN dwConsolidRN = new DwConsolidRN(dao);
			List<DwConsol> consols = new ArrayList<DwConsol>();
			if(dtInicio != null && dtFim != null) {
				consols = dwConsolidRN.getTodosOmUsrAtivosOrdenadoPorNome(
						cdProduto,
						idGt,
						DataHoraRN.stringToDate(dtInicio,FORMATO_DATA_ISO8601),
						DataHoraRN.stringToDate(dtFim,FORMATO_DATA_ISO8601));
			}

			BigDecimal disponivel = BigDecimal.ZERO;
			BigDecimal ritmo = BigDecimal.ZERO;
			BigDecimal qualidade = BigDecimal.ZERO;
			BigDecimal parada = BigDecimal.ZERO;

			for(DwConsol consol : consols) {
				if(consol.getSegAutoTempoativo() != null) {
					disponivel = AritmeticaUtil.somar(disponivel, consol.getSegAutoTempoativo());
				}

				if(consol.getSegAutoRitmo() != null) {
					ritmo = AritmeticaUtil.somar(ritmo, consol.getSegAutoRitmo());
				}

				if(consol.getSegAutoTemporefugadas() != null) {
					qualidade = AritmeticaUtil.somar(qualidade, consol.getSegAutoTemporefugadas());
				}

				if(consol.getSegAutoTempoparadaCp() != null) {
					parada = AritmeticaUtil.somar(parada, consol.getSegAutoTempoparadaCp());
				}
			}

			disponivel = AritmeticaUtil.dividir(disponivel, new BigDecimal("3600"));
			ritmo = AritmeticaUtil.dividir(ritmo, new BigDecimal("3600"));
			qualidade = AritmeticaUtil.dividir(qualidade, new BigDecimal("3600"));
			parada = AritmeticaUtil.dividir(parada, new BigDecimal("3600"));

			rootElement.add("disponivel", gson.toJsonTree(ConversaoTipos.converteParaString(disponivel, 2)));
			rootElement.add("ritmo", gson.toJsonTree(ConversaoTipos.converteParaString(ritmo, 2)));
			rootElement.add("qualidade", gson.toJsonTree(ConversaoTipos.converteParaString(qualidade, 2)));
			rootElement.add("parada", gson.toJsonTree(ConversaoTipos.converteParaString(parada, 2)));

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	@GET
	@Path("/ciclosBarra")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCiclosBarra(
			@QueryParam("cdProduto") String cdProduto,
			@QueryParam("idGt") int idGt,
			@QueryParam("dtInicio") String dtInicio,
			@QueryParam("dtFim") String dtFim) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			DwRtCicDAO dwRtCicDAO = new DwRtCicDAO(dao.getSession());
			List<DwRtcic> cics = new ArrayList<DwRtcic>();
			if(dtInicio != null && dtFim != null) {
				cics = dwRtCicDAO.getCiclosBarra(
						cdProduto,
						idGt,
						DataHoraRN.stringToDate(dtInicio,FORMATO_DATA_ISO8601),
						DataHoraRN.stringToDate(dtFim,FORMATO_DATA_ISO8601));
			}

			List<JsonObject> ciclos = new ArrayList<>();
			for(DwRtcic cic : cics) {

				String label = DataHoraRN.dateToString(cic.getDthrIciclo(),FORMATO_DATA_ISO8601);
				label += " . " + cic.getIdRtcic();

				JsonObject ciclo = new JsonObject();
				ciclo.addProperty("label", label);
				ciclo.addProperty("valor", cic.getSegDuracao());

				ciclos.add(ciclo);
			}

			rootElement.add("ciclos", gson.toJsonTree(ciclos));

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

}

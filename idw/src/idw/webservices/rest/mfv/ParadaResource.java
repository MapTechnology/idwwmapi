package idw.webservices.rest.mfv;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolpaDAO;
import idw.model.pojos.DwConsolpa;
import idw.model.rn.DataHoraRN;
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

@Path("/mfv/paradas")
public class ParadaResource {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DATA_ISO8601 = "yyyy-MM-dd";
	public static final String FORMATO_DATA_HORA_ISO8601 = "yyyy-MM-dd HH:mm:ss";

	@GET
	@Path("/pizza")
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

			DwConsolpaDAO dwConsolpaDAO = new DwConsolpaDAO(dao.getSession());
			List<DwConsolpa> consolpas = new ArrayList<DwConsolpa>();
			if(dtInicio != null && dtFim != null) {
				consolpas = dwConsolpaDAO.getParadasPizza(
						cdProduto,
						idGt,
						DataHoraRN.stringToDate(dtInicio, FORMATO_DATA_ISO8601),
						DataHoraRN.stringToDate(dtFim, FORMATO_DATA_ISO8601));
			}

			List<Long> areasSalvas = new ArrayList<>();
			List<JsonObject> paradas = new ArrayList<>();
			for(DwConsolpa i : consolpas) {

				Long area = i.getDwTParada().getDwTArea().getIdArea();
				if(areasSalvas.contains(area)) {
					continue;
				}

				JsonObject parada = new JsonObject();
				parada.addProperty("idArea", area);

				String dsArea = i.getDwTParada().getDwTArea().getDsArea();
				if(dsArea == null) {
					dsArea = "ÁREA INDETERMINADA";
				}

				parada.addProperty("dsArea", dsArea);

				BigDecimal tempoParada = BigDecimal.ZERO;

				for(DwConsolpa j : consolpas) {
					if(j.getDwTParada().getDwTArea().getIdArea() != area) {
						continue;
					}

					if(j.getSegAutoTempoparadaCp() != null) {
						tempoParada = AritmeticaUtil.somar(tempoParada, j.getSegAutoTempoparadaCp());
					}
				}

				tempoParada = AritmeticaUtil.dividir(tempoParada, new BigDecimal("3600"));
				parada.addProperty("tempoParada", ConversaoTipos.converteParaString(tempoParada, 2));

				paradas.add(parada);
				areasSalvas.add(area);
			}

			rootElement.add("paradas", gson.toJsonTree(paradas));

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
	@Path("/barra")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBarra(
			@QueryParam("cdProduto") String cdProduto,
			@QueryParam("idGt") Long idGt,
			@QueryParam("idArea") Long idArea,
			@QueryParam("dtInicio") String dtInicio,
			@QueryParam("dtFim") String dtFim) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			DwConsolpaDAO dwConsolpaDAO = new DwConsolpaDAO(dao.getSession());
			List<DwConsolpa> consolpas = new ArrayList<DwConsolpa>();
			if(dtInicio != null && dtFim != null) {
				consolpas = dwConsolpaDAO.getParadasBarra(
						cdProduto,
						idGt,
						idArea,
						DataHoraRN.stringToDate(dtInicio, FORMATO_DATA_ISO8601),
						DataHoraRN.stringToDate(dtFim, FORMATO_DATA_ISO8601));
			}

			List<Long> paradasSalvas = new ArrayList<>();
			List<JsonObject> paradas = new ArrayList<>();
			for(DwConsolpa i : consolpas) {

				Long paradaId = i.getDwTParada().getIdTparada();
				if(paradasSalvas.contains(paradaId)) {
					continue;
				}

				JsonObject parada = new JsonObject();
				parada.addProperty("idTParada", paradaId);

				String dsTParada = i.getDwTParada().getDsTparada();
				parada.addProperty("dsTParada", dsTParada);

				BigDecimal tempoParada = BigDecimal.ZERO;

				for(DwConsolpa j : consolpas) {
					if(j.getDwTParada().getIdTparada() != paradaId) {
						continue;
					}

					if(j.getSegAutoTempoparadaCp() != null) {
						tempoParada = AritmeticaUtil.somar(tempoParada, j.getSegAutoTempoparadaCp());
					}
				}

				tempoParada = AritmeticaUtil.dividir(tempoParada, new BigDecimal("3600"));
				parada.addProperty("tempoParada", ConversaoTipos.converteParaString(tempoParada, 2));

				paradas.add(parada);
				paradasSalvas.add(paradaId);
			}

			rootElement.add("paradas", gson.toJsonTree(paradas));

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

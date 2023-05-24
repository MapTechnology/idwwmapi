package idw.webservices.rest.cits;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolpaDAO;
import idw.model.dao.OmPaDAO;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.OmPa;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.auth.TokenFilter;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import ms.util.ConversaoTipos;

@Path("/cits/paradas")
public class CitsParadaResource {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DATA_ISO8601 = "yyyy-MM-dd";
	public static final String FORMATO_DATA_HORA_ISO8601 = "yyyy-MM-dd HH:mm:ss";


	@POST
	@Path("/listamotivos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaMotivosParadaToken(@Context HttpServletRequest request) {
	
		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			OmPaDAO daodados = new OmPaDAO(dao.getSession());
			List<OmPa>  lista = new ArrayList<OmPa>();
				lista = daodados.getOmPas(
						"",
						"",
						null);

			List<JsonObject> paradas = new ArrayList<>();
			Long id =  0L;
			String cd = "";
			String ds = "";
			String sid = "";
			for(OmPa i : lista) {

				id =  0L;
				cd = "";
				ds = "";
				sid= "";

				id = i.getIdPa();
				sid = id.toString();

				if(i.getCdPa()!=null){
					cd =i.getCdPa(); 
				}
				if(i.getDsPa()!=null){
					ds =i.getDsPa(); 
				}

				JsonObject parada = new JsonObject();

				parada.addProperty("cdParada", cd);
				parada.addProperty("dsParada", ds);
				parada.addProperty("idParada", sid);

				paradas.add(parada);
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
	@Path("/listamotivos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaMotivosParada(
			) 
			{

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			OmPaDAO daodados = new OmPaDAO(dao.getSession());
			List<OmPa>  lista = new ArrayList<OmPa>();
				lista = daodados.getOmPas(
						"",
						"",
						null);

			List<JsonObject> paradas = new ArrayList<>();
			Long id =  0L;
			String cd = "";
			String ds = "";
			String sid = "";
			for(OmPa i : lista) {

				id =  0L;
				cd = "";
				ds = "";
				sid= "";

				id = i.getIdPa();
				sid = id.toString();

				if(i.getCdPa()!=null){
					cd =i.getCdPa(); 
				}
				if(i.getDsPa()!=null){
					ds =i.getDsPa(); 
				}

				JsonObject parada = new JsonObject();

				parada.addProperty("cdParada", cd);
				parada.addProperty("dsParada", ds);
				parada.addProperty("idParada", sid);

				paradas.add(parada);
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

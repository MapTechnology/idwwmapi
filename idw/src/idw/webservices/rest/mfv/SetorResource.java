package idw.webservices.rest.mfv;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpSetorDAO;
import idw.model.pojos.SpSetor;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.mfv.dto.MfvSetorDTO;

@Path("/mfv/setores")
public class SetorResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIdSetor(@QueryParam("dsSetor") String dsSetor) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpSetorDAO spSetorDAO = new SpSetorDAO(dao.getSession());
			List<SpSetor> spSetores = spSetorDAO.getSetor(dsSetor);

			List<JsonObject> setores = new ArrayList<JsonObject>();
			for(SpSetor spSetor : spSetores) {
				JsonObject setor = new JsonObject();
				setor.addProperty("idSetor", spSetor.getIdSetor());

				setores.add(setor);
			}

			rootElement.add("setores", gson.toJsonTree(setores));

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

	/*

	@GET
	@Path("/getmfv")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSetoresMFV(@QueryParam("cdproduto") String cdproduto) {
		//fa3setoresmfv
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpSetorDAO spSetorDAO = new SpSetorDAO(dao.getSession());
			List<SpSetor> spSetores = spSetorDAO.getSetor(cdproduto);

			List<JsonObject> setores = new ArrayList<JsonObject>();
			for(SpSetor spSetor : spSetores) {
				JsonObject setor = new JsonObject();
				setor.addProperty("idSetor", spSetor.getIdSetor());

				setores.add(setor);
			}

			rootElement.add("setores", gson.toJsonTree(setores));

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
	*/
	
	
	//fa3setoresmfv ok
	@GET
	@Path("/getmfv")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMFVSetoresCdProduto(
			@QueryParam("cdproduto") String cdproduto
	
			) {
		//fa3setoresmfv
		DAOGenerico dao = new DAOGenerico();
		////Gson gson = new Gson();
		
		Gson gson = new GsonBuilder()
				.serializeNulls()
				.create();
		
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpSetorDAO spSetorDAO = new SpSetorDAO(dao.getSession());
			List<MfvSetorDTO> listadto = spSetorDAO.getListaMfvSetoresCdProduto(cdproduto);

			List<JsonObject> setores = new ArrayList<JsonObject>();
			Long idgt = 0L;
			for(MfvSetorDTO dto : listadto) {
				JsonObject setor = new JsonObject();

				idgt = 0L;
				if (dto.getIdgt()!=null){idgt=dto.getIdgt();}
				
				setor.addProperty("idsetor", dto.getIdsetor() );
				setor.addProperty("idgt", idgt );
				setor.addProperty("cdsetor", dto.getCdsetor() );
				setor.addProperty("dssetor", dto.getDssetor() );
				setor.addProperty("tpsetor", dto.getTpsetor() );
				setor.addProperty("ordem", dto.getOrdem() );
				setor.addProperty("diasleadtime", dto.getLeadtime());
				setor.addProperty("segcicletime", dto.getCicletime());
				setor.addProperty("percoee", dto.getPercoee());				

				setor.addProperty("avgciclos", new BigDecimal(10L));
				setor.addProperty("avgoee", new BigDecimal(80L));
				setor.addProperty("sumleadtime", new BigDecimal(100L));				
				
				setores.add(setor);
			}

			rootElement.add("mfvsetores", gson.toJsonTree(setores));

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
	@Path("/getmfvsetores")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMFVSetores(
			@QueryParam("cdproduto") String cdproduto
			,@QueryParam("idsetor") long idsetor
			) {
		//fa3setoresmfv
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpSetorDAO spSetorDAO = new SpSetorDAO(dao.getSession());
			List<MfvSetorDTO> listadto = spSetorDAO.getListaMfvSetores(cdproduto, idsetor);

			List<JsonObject> setores = new ArrayList<JsonObject>();
			for(MfvSetorDTO dto : listadto) {
				JsonObject setor = new JsonObject();
				
				setor.addProperty("tpsetor", dto.getTpsetor() );
				setor.addProperty("leadtime", dto.getLeadtime());
				setor.addProperty("cicletime", dto.getCicletime());
				setor.addProperty("percoee", dto.getPercoee());				

				setores.add(setor);
			}

			rootElement.add("mfvsetores", gson.toJsonTree(setores));

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

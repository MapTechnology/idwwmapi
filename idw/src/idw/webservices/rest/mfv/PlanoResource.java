package idw.webservices.rest.mfv;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpPlanoDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.SpPlano;
import idw.model.pojos.SpPlanoresp;
import idw.model.rn.DataHoraRN;
import idw.model.rn.SpCausaRN;
import idw.model.rn.SpPlanoRN;
import idw.webservices.rest.ResourceWebApplicationException;

@Path("/mfv/planos")
public class PlanoResource {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DATA_ISO8601 = "yyyy-MM-dd";
	public static final String FORMATO_DATA_HORA_ISO8601 = "yyyy-MM-dd HH:mm:ss";

	@GET
	@Path("/getlistaplanos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaPlanos(@QueryParam("idProblema") int idProblema) {
		//fa3getlistaplanos
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpPlanoDAO spPlanoDAO = new SpPlanoDAO(dao.getSession(), this.FORMATO_DATA_ISO8601, this.FORMATO_DATA_HORA_ISO8601);
			List<SpPlano> spPlanos = spPlanoDAO.getListaPlanos(idProblema);

			List<JsonObject> planos = new ArrayList<JsonObject>();
			for(SpPlano spPlano : spPlanos) {

				JsonObject plano = new JsonObject();
				plano.addProperty("id_plano", spPlano.getIdPlano());
				plano.addProperty("id_problema", spPlano.getSpProblema().getIdProblema());
				plano.addProperty("problema_oque", spPlano.getProblemaOque());
				plano.addProperty("acao_como", spPlano.getAcaoComo());
				plano.addProperty("prazoini_quando", DataHoraRN.dateToString(spPlano.getPrazoiniQuando(), FORMATO_DATA_ISO8601));
				plano.addProperty("prazofim_quando", DataHoraRN.dateToString(spPlano.getPrazofimQuando(), FORMATO_DATA_ISO8601));
				plano.addProperty("status_percconclusao", spPlano.getStatusPercconclusao());

				planos.add(plano);
			}

			rootElement.add("planos", gson.toJsonTree(planos));

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
	@Path("/getlistaplanoresps")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaPlanoresps(@QueryParam("idplano") long idplano) {
		//fa3getlistaplanos
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpPlanoDAO spDAO = new SpPlanoDAO(dao.getSession(), this.FORMATO_DATA_ISO8601, this.FORMATO_DATA_HORA_ISO8601);
			List<SpPlanoresp> sps = spDAO.getListaPlanoresps(idplano);

			List<JsonObject> listjsonobj = new ArrayList<JsonObject>();
			String snome = "";
			String sapelido = "";
			
			for(SpPlanoresp sp : sps) {
				snome = "";
				sapelido = "";
				
				if (sp!=null && sp.getOmUsr()!=null && sp.getOmUsr().getDsNome()!=null && !sp.getOmUsr().getDsNome().trim().equals("")){
					snome = sp.getOmUsr().getDsNome();
				}
				if (sp!=null && sp.getOmUsr()!=null && sp.getOmUsr().getDsApelido()!=null && !sp.getOmUsr().getDsApelido().trim().equals("")){
					sapelido = sp.getOmUsr().getDsApelido();
				}
				if (sapelido==null){sapelido="";}
				
				if (sapelido.trim().equals("")){
					if (!snome.trim().equals("")){
						sapelido=snome.trim();
					} else {
						sapelido = "SEM APELIDO";
					}
				}
				if (snome==null){snome="SEM NOME";}

				JsonObject jsonobj = new JsonObject();
				jsonobj.addProperty("id_planoresp", sp.getIdPlanoresp() );
				jsonobj.addProperty("id_plano", sp.getSpPlano().getIdPlano());
				jsonobj.addProperty("idusr", sp.getOmUsr().getIdUsr());//
				jsonobj.addProperty("id_usr", sp.getOmUsr().getIdUsr());//
				jsonobj.addProperty("ds_nome", snome);
				jsonobj.addProperty("apelidousr", sapelido);//ds_apelido
				jsonobj.addProperty("apelido", sapelido);//ds_apelido

				listjsonobj.add(jsonobj);
			}

			rootElement.add("planoresps", gson.toJsonTree(listjsonobj));

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


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarPlano(@QueryParam("idPlano") int idPlano) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpPlanoRN spPlanoRN = new SpPlanoRN(dao, FORMATO_DATA_ISO8601,  FORMATO_DATA_HORA_ISO8601);
			SpPlano spPlano = spPlanoRN.deletarPlano(idPlano);

			JsonObject plano = new JsonObject();
			plano.addProperty("id", spPlano.getIdPlano());
			rootElement.add("plano", plano);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);	
			return Response.status(responseStatus).entity(json).build();
		} catch (RegistroDesconhecidoException e) {
			JsonObject objeto = new JsonObject();
			objeto.addProperty("id", 0);
			rootElement.add("plano", objeto);
			String json = gson.toJson(rootElement);
			responseStatus = Response.Status.OK;
			return Response.status(responseStatus).entity(json).build();	
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}


	//fa3deleteplanoresp
	@DELETE
	@Path("/planoresp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarPlanoresp(@QueryParam("idPlanoresp") int idPlanoresp) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpPlanoRN spPlanoRN = new SpPlanoRN(dao, FORMATO_DATA_ISO8601,  FORMATO_DATA_HORA_ISO8601);
			SpPlanoresp spPlanoresp = spPlanoRN.deletarPlanoresp(idPlanoresp);

			JsonObject planoresp = new JsonObject();
			planoresp.addProperty("id", spPlanoresp.getIdPlanoresp());
			rootElement.add("planoresp", planoresp);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);	
			return Response.status(responseStatus).entity(json).build();
		} catch (RegistroDesconhecidoException e) {
			JsonObject objeto = new JsonObject();
			objeto.addProperty("id", 0);
			rootElement.add("planoresp", objeto);
			String json = gson.toJson(rootElement);
			responseStatus = Response.Status.OK;
			return Response.status(responseStatus).entity(json).build();	
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}	

	// fa3insertupdateplano
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPlano(
			@QueryParam("idPlano") long idPlano
			, @QueryParam("idProblema") long idProblema
			, @QueryParam("problemaoque") String problemaoque
			, @QueryParam("acaocomo") String acaocomo
			, @QueryParam("prazoiniquando") String prazoiniquando
			, @QueryParam("prazofimquando") String prazofimquando
			, @QueryParam("statuspercconclusao") int statuspercconclusao
			) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpPlanoRN spRN = new SpPlanoRN(dao,FORMATO_DATA_ISO8601,  FORMATO_DATA_HORA_ISO8601);
			long id = spRN.insertPlano(
					idPlano 
					,  idProblema
					,  problemaoque 
					,  acaocomo
					,  prazoiniquando
					,  prazofimquando
					,  statuspercconclusao
					);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("plano", jsono);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (RegistroDesconhecidoException e) {
			JsonObject objetivo = new JsonObject();
			objetivo.addProperty("id", 0);
			rootElement.add("plano", objetivo);
			String json = gson.toJson(rootElement);
			responseStatus = Response.Status.OK;
			return Response.status(responseStatus).entity(json).build();	
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}


	// fa3insertupdateplanoresp
	@PUT
	@Path("/planoresp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPlanoresp(
			@QueryParam("idPlanoresp") long idPlanoresp
			, @QueryParam("idPlano") long idPlano
			, @QueryParam("idUsr") long idUsr

			) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpPlanoRN spRN = new SpPlanoRN(dao,FORMATO_DATA_ISO8601,  FORMATO_DATA_HORA_ISO8601);
			long id = spRN.insertPlanoresp(
					idPlanoresp 
					,  idPlano
					,  idUsr 

					);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("planoresp", jsono);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (RegistroDesconhecidoException e) {
			JsonObject objetivo = new JsonObject();
			objetivo.addProperty("id", 0);
			rootElement.add("planoresp", objetivo);
			String json = gson.toJson(rootElement);
			responseStatus = Response.Status.OK;
			return Response.status(responseStatus).entity(json).build();	
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

}

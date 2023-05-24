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
import idw.model.dao.SpProblemaDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.rn.DataHoraRN;
import idw.model.rn.SpProblemaRN;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.mfv.dto.ProblemaDTO;

@Path("/mfv/problema")
public class ProblemaResource {


	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DATA_ISO8601 = "yyyy-MM-dd";
	public static final String FORMATO_DATA_HORA_ISO8601 = "yyyy-MM-dd HH:mm:ss";
	
	@GET
	@Path("/getlistaproblema") //fa3getlistaproblemanw
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaProblema(@QueryParam("ida3") String ida3) {
		//fa3getlistaproblemanw
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpProblemaDAO spDAO = new SpProblemaDAO(dao.getSession(),FORMATO_DATA_ISO8601, FORMATO_DATA_HORA_ISO8601);
			List<ProblemaDTO> listaItensDTO = spDAO.getListaProblema(Long.valueOf( ida3));

			List<JsonObject> listajsonobj = new ArrayList<JsonObject>();
			for(ProblemaDTO itemdto : listaItensDTO) {


				JsonObject jsonobj = new JsonObject();
				
				int id_problema = 0;
				String ds_problema = "";
				String maincd_produto = "";
				int cachep3_ciclosbarra_idgt = 0;
				int cachep3_paradaspizza_idgt = 0;
				int cachep3_defeitosbarra_idgt = 0;
				int cachep3_paradasbarra_cdarea = 0;
				String cachep7_result_dti = "";
				String cachep7_result_dtf = "";

							
				if (itemdto.getIdProblema()!=null){
					id_problema = itemdto.getIdProblema().intValue();
				}
				if (itemdto.getDsProblema()!=null){
					ds_problema = itemdto.getDsProblema();
				}
	
				if (itemdto.getCachep3Ciclosbarraidgt()!=null){
					cachep3_ciclosbarra_idgt = itemdto.getCachep3Ciclosbarraidgt().intValue();
				}
				if (itemdto.getCachep3Pradaspizzaidgt()!=null){
					cachep3_paradaspizza_idgt = itemdto.getCachep3Pradaspizzaidgt().intValue();
				}
				if (itemdto.getCachep3Defeitosbarraidgt()!=null){
					cachep3_defeitosbarra_idgt = itemdto.getCachep3Defeitosbarraidgt().intValue();
				}
				if (itemdto.getCachep3Paradasbarraidarea()!=null){
					cachep3_paradasbarra_cdarea =itemdto.getCachep3Paradasbarraidarea().intValue();
				}
				if (itemdto.getCachep7Resultdti()!=null){
					cachep7_result_dti = DataHoraRN.dateToString(itemdto.getCachep7Resultdti(), FORMATO_DATA_ISO8601) ;
				}
				if (itemdto.getCachep7Resultdtf()!=null){
					cachep7_result_dtf = DataHoraRN.dateToString(itemdto.getCachep7Resultdtf(), FORMATO_DATA_ISO8601) ;
				}
		

				jsonobj.addProperty("idproblema", id_problema);
				jsonobj.addProperty("dsproblema", ds_problema );
				jsonobj.addProperty("cachep3_ciclosbarra_idgt", cachep3_ciclosbarra_idgt );
				jsonobj.addProperty("cachep3_paradaspizza_idgt", cachep3_paradaspizza_idgt );
				jsonobj.addProperty("cachep3_defeitosbarra_idgt",cachep3_defeitosbarra_idgt );
				jsonobj.addProperty("cachep3_paradasbarra_cdarea", cachep3_paradasbarra_cdarea );
				jsonobj.addProperty("cachep7_result_dti",cachep7_result_dti );
				jsonobj.addProperty("cachep7_result_dtf", cachep7_result_dtf );

				listajsonobj.add(jsonobj);

			}

			rootElement.add("listaproblemas", gson.toJsonTree(listajsonobj));

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



	// fa3insertupdateproblema
	@PUT
	@Path("/putprob")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertProblema(
			@QueryParam("idProblema") long idProblema
			, @QueryParam("idSp") long idSp
			, @QueryParam("texto") String texto

			) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpProblemaDAO spDAO = new SpProblemaDAO(dao.getSession(),FORMATO_DATA_ISO8601, FORMATO_DATA_HORA_ISO8601);
			long id = spDAO.insertProblema(idProblema, idSp, texto);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("problema", jsono);

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




	// fa3insertupdateproblemanw
	@PUT
	@Path("/putprobnw")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertProblemaNw(
			@QueryParam("idProblema") long idProblema
			, @QueryParam("idSp") long idSp
			, @QueryParam("texto") String texto
			, @QueryParam("cachep3ciclosbarraidgt") int cachep3ciclosbarraidgt
			, @QueryParam("cachep3paradaspizzaidgt") int cachep3paradaspizzaidgt
			, @QueryParam("cachep3defeitosbarraidgt") int cachep3defeitosbarraidgt
			, @QueryParam("cachep3paradasbarracdarea") String cachep3paradasbarracdarea
			, @QueryParam("cachep7resultdti") String cachep7resultdti
			, @QueryParam("cachep7resultdtf") String cachep7resultdtf
			) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpProblemaDAO spDAO = new SpProblemaDAO(dao.getSession(),FORMATO_DATA_ISO8601, FORMATO_DATA_HORA_ISO8601);
			long id = spDAO.insertProblemaNw(
					idProblema, 
					idSp, 
					texto,
					cachep3ciclosbarraidgt, 
					cachep3paradaspizzaidgt, 
					cachep3defeitosbarraidgt, 
					cachep3paradasbarracdarea,
					cachep7resultdti, 
					cachep7resultdtf								
					);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("problemanw", jsono);

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


	//fa3delproblemacascata
	@DELETE
	@Path("/delprob")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarProblemaCascata(@QueryParam("idProblema") int idProblema) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpProblemaRN spRN = new SpProblemaRN(dao, FORMATO_DATA_ISO8601,  FORMATO_DATA_HORA_ISO8601);
			long id = spRN.deletarProblemaCascata(idProblema);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("problemacascata", jsono);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);	
			return Response.status(responseStatus).entity(json).build();
		} catch (RegistroDesconhecidoException e) {
			JsonObject objeto = new JsonObject();
			objeto.addProperty("id", 0);
			rootElement.add("problemacascata", objeto);
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

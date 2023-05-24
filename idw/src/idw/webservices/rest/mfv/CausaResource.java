package idw.webservices.rest.mfv;

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
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpCausaDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.SpCausa;
import idw.model.rn.SpCausaRN;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.mfv.dto.CausaEfeitoDTO;

@Path("/mfv/causas")
public class CausaResource {

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarCausa(@QueryParam("idCausa") int idCausa) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCausaRN spCausaRN = new SpCausaRN(dao);
			SpCausa spCausa = spCausaRN.deletarCausa(idCausa);

			JsonObject causa = new JsonObject();
			causa.addProperty("id", spCausa.getIdCausa());
			rootElement.add("causa", causa);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);	
			return Response.status(responseStatus).entity(json).build();
		} catch (RegistroDesconhecidoException e) {
			JsonObject causa = new JsonObject();
			causa.addProperty("id", 0);
			rootElement.add("causa", causa);
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

	@DELETE
	@Path("/delcausaefeito") //fa3deletecausaefeito
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarCausaEfeito(@QueryParam("idCausaEfeito") long idCausaEfeito) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCausaRN spRN = new SpCausaRN(dao);

			long id = spRN.deletarCausaEfeito(idCausaEfeito, 5);



			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("causaefeito", jsono);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (RegistroDesconhecidoException e) {
			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", 0);
			rootElement.add("causaefeito", jsono);
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

	@GET
	@Path("/getcausaefeitos") //fa3getcefilhos4cepai
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCausaEfeitoFilhosParaCausaEfeitoPai
	(
			@QueryParam("idProblema") int idProblema,
			@QueryParam("idCausaEfeitoPai") int idCausaEfeitoPai
			) 
	{
		//fa3getcefilhos4cepai

		DAOGenerico dao = new DAOGenerico();

		//Gson gson = new Gson();

		Gson gson = new GsonBuilder()
				.serializeNulls()
				.create();		


		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCausaDAO causaDAO = new SpCausaDAO(dao.getSession());
			List<CausaEfeitoDTO> listCausaEfeitoDTO = causaDAO.getCausaEfeitoFilhosParaCausaEfeitoPai(idProblema, idCausaEfeitoPai);

			JsonArray listJsonArray = new JsonArray();

			JsonObject itemjson = new JsonObject();
			JsonArray itemdeArrayjson = new JsonArray();	
			
			
			
			for(CausaEfeitoDTO item : listCausaEfeitoDTO) {
				itemjson = new JsonObject();
				itemdeArrayjson = new JsonArray();
				

				if (item!=null && item.getIdCatcausa()!=null){
					//itemjson.addProperty("idcatcausa", item.getIdCatcausa() );//itemjson

					
					//itemjson = new JsonObject();
					itemjson.addProperty("idcatcausa", item.getIdCatcausa() );//itemjson
					//listJsonArray.add(itemjson);
					
				//	itemdeArrayjson = new JsonArray();
				//	itemdeArrayjson.add(new JsonPrimitive(item.getIdCatcausa()));
				//	itemjson.add("",new JsonPrimitive(item.getIdCatcausa()));
					
					///listJsonArray.add(itemdeArrayjson);
					
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(new JsonPrimitive(item.getIdCatcausa()));

					
				} else {
					//itemjson.add("idcatcausa", JsonNull.INSTANCE  );
					

					//itemjson = new JsonObject();
					itemjson.add("idcatcausa", JsonNull.INSTANCE  );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(JsonNull.INSTANCE);
					//listJsonArray.add(itemdeArrayjson);
					
				}


				if (item!=null && item.getDsCatcausa()!=null){
					//itemjson.addProperty("dscatcausa", item.getDsCatcausa() );

					//itemjson = new JsonObject();
					itemjson.addProperty("dscatcausa", item.getDsCatcausa() );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(new JsonPrimitive(item.getDsCatcausa()));
					//listJsonArray.add(itemdeArrayjson);
					
				} else {
					//itemjson.add("dscatcausa", JsonNull.INSTANCE );

					//itemjson = new JsonObject();
					itemjson.add("dscatcausa", JsonNull.INSTANCE );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(JsonNull.INSTANCE);
					//listJsonArray.add(itemdeArrayjson);

				}


				if (item!=null && item.getIdCausaefeito()!=null){
					//itemjson.addProperty("idcausaefeito", item.getIdCausaefeito() );

					//itemjson = new JsonObject();
					itemjson.addProperty("idcausaefeito", item.getIdCausaefeito() );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(new JsonPrimitive(item.getIdCausaefeito()));
					//listJsonArray.add(itemdeArrayjson);
					
				} else {
					//itemjson.add("idcausaefeito", JsonNull.INSTANCE  );

					//itemjson = new JsonObject();
					itemjson.add("idcausaefeito", JsonNull.INSTANCE  );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(JsonNull.INSTANCE);
					//listJsonArray.add(itemdeArrayjson);
					
					
				}


				if (item!=null && item.getIdCausaefeitopai()!=null){
					//itemjson.addProperty("idcausaefeitopai", item.getIdCausaefeitopai() );

					//itemjson = new JsonObject();
					itemjson.addProperty("idcausaefeitopai", item.getIdCausaefeitopai() );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(new JsonPrimitive(item.getIdCausaefeitopai()));
					//listJsonArray.add(itemdeArrayjson);
					
				} else {
					//itemjson.add("idcausaefeitopai", JsonNull.INSTANCE );

					//itemjson = new JsonObject();
					itemjson.add("idcausaefeitopai", JsonNull.INSTANCE );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(JsonNull.INSTANCE);
					//listJsonArray.add(itemdeArrayjson);
					
					
				}


				if (item!=null && item.getIdCausapai()!=null){
					//itemjson.addProperty("idcausapai", item.getIdCausapai() );

					//itemjson = new JsonObject();
					itemjson.addProperty("idcausapai", item.getIdCausapai() );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(new JsonPrimitive(item.getIdCausapai()));
					//listJsonArray.add(itemdeArrayjson);
					
				} else {
					//itemjson.add("idcausapai", JsonNull.INSTANCE  );

					//itemjson = new JsonObject();
					itemjson.add("idcausapai", JsonNull.INSTANCE  );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(JsonNull.INSTANCE);
					//listJsonArray.add(itemdeArrayjson);
					
					
				}


				if (item!=null && item.getDsCausapai()!=null){
					//itemjson.addProperty("dscausapai", item.getDsCausapai() );

					//itemjson = new JsonObject();
					itemjson.addProperty("dscausapai", item.getDsCausapai() );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(new JsonPrimitive(item.getDsCausapai()));
					//listJsonArray.add(itemdeArrayjson);
					
				} else {
					//itemjson.add("dscausapai", JsonNull.INSTANCE  );

					//itemjson = new JsonObject();
					itemjson.add("dscausapai", JsonNull.INSTANCE  );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(JsonNull.INSTANCE);
					//listJsonArray.add(itemdeArrayjson);
					
					
				}


				if (item!=null && item.getIdCausa()!=null){
					//itemjson.addProperty("idcausa", item.getIdCausa() );

					//itemjson = new JsonObject();
					itemjson.addProperty("idcausa", item.getIdCausa() );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(new JsonPrimitive(item.getIdCausa()));
					//listJsonArray.add(itemdeArrayjson);
					
				} else {
					//itemjson.add("idcausa", JsonNull.INSTANCE  );

					//itemjson = new JsonObject();
					itemjson.add("idcausa", JsonNull.INSTANCE  );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(JsonNull.INSTANCE);
					//listJsonArray.add(itemdeArrayjson);
					
					
				}


				if (item!=null && item.getDsCausa()!=null){
					//itemjson.addProperty("dscausa", item.getDsCausa() );

					//itemjson = new JsonObject();
					itemjson.addProperty("dscausa", item.getDsCausa() );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(new JsonPrimitive(item.getDsCausa()));
					//listJsonArray.add(itemdeArrayjson);
					
				} else {
					//itemjson.add("dscausa", JsonNull.INSTANCE  );

					//itemjson = new JsonObject();
					itemjson.add("dscausa", JsonNull.INSTANCE  );
					//listJsonArray.add(itemjson);
					//itemdeArrayjson = new JsonArray();
					//itemdeArrayjson.add(itemjson);
					//itemdeArrayjson.add(JsonNull.INSTANCE);
					//listJsonArray.add(itemdeArrayjson);
					
					
				}
				
				
				listJsonArray.add(itemjson);
				
				/////listJsonArray.add(itemdeArrayjson);

				////listJsonArray.add(itemjson);
			//ERAESTE-TIRADO-TESTE	listJsonArray.add(itemjson);
				//listJsonArray.add(itemdeArrayjson);
			}
			
			
			/*
			////testes
			JsonArray jaglobal = new JsonArray();
			JsonObject joglobal = new JsonObject();
			JsonObject jo = null;
			JsonArray ja = null;
			jo = new JsonObject();
			ja = new JsonArray();
			jo.addProperty("idcatcausa", 5);;
			jo.addProperty("dscatcausa", "Medida");;
			ja.add(new JsonPrimitive(5));
			ja.add(new JsonPrimitive("Medida"));
			jaglobal.add(jo);
			jaglobal.add(ja);
			jo = new JsonObject();
			jo.addProperty("dscatcausa", "Medida");
			ja = new JsonArray();
			ja.add(new JsonPrimitive("Medida"));
			jaglobal.add(jo);
			jaglobal.add(ja);
			joglobal.add("todos", jaglobal);
			rootElement.add("causaefeitofilhos", joglobal);
			//testes
			*/
			
			//ORIGINAL rootElement.add("causaefeitofilhos", listJsonArray);

/*
 * 
 		["idcatcausa"]=> int(5) 
		[0]=> int(5) 
		["dscatcausa"]=> string(6) "Medida" 
		[1]=> string(6) "Medida" 
		["idcausaefeito"]=> int(5) 
		[2]=> int(5) 
		["idcausaefeitopai"]=> NULL 
		[3]=> NULL 
		["idcausapai"]=> NULL 
		[4]=> NULL 
		["dscausapai"]=> NULL 
		[5]=> NULL 
		["idcausa"]=> int(5) 
		[6]=> int(5) 
		["dscausa"]=> string(1) "a" 
		[7]=> string(1) "a" 			
 */
			
			rootElement.add("causaefeitofilhos", listJsonArray);
			
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

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCausa(
			@QueryParam("idCausa") long idCausa
			, @QueryParam("texto") String texto
			) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCausaRN spRN = new SpCausaRN(dao);
			long idobj = spRN.insertCausa(idCausa, texto);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", idobj);
			rootElement.add("causa", jsono);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (RegistroDesconhecidoException e) {
			JsonObject objetivo = new JsonObject();
			objetivo.addProperty("id", 0);
			rootElement.add("causa", objetivo);
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


	@PUT
	@Path("/causaefeito")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCausaEfeito(
			@QueryParam("idProblema") long idProblema
			, @QueryParam("idCatCausa") long idCatCausa
			, @QueryParam("idCausaEfeito") long idCausaEfeito
			, @QueryParam("idCausa") long idCausa
			, @QueryParam("textocausa") String textocausa			
			, @QueryParam("idCausaEfeitoPai") long idCausaEfeitoPai

			) {
		//fa3insertupdatecausaefeito

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();


			SpCausaRN spRN = new SpCausaRN(dao);
			CausaEfeitoDTO ret = spRN.insertCausaEfeito(
					idProblema
					, idCatCausa
					, idCausaEfeito
					, idCausa
					, textocausa			
					, idCausaEfeitoPai
					);			

			JsonObject jsono = new JsonObject();
			jsono.addProperty("idcausaefeito", ret.getIdCausaefeito());
			jsono.addProperty("idcausaefeitopai", ret.getIdCausaefeitopai());
			jsono.addProperty("idproblema", ret.getIdProblema());
			jsono.addProperty("idcatcausa", ret.getIdCatcausa());
			jsono.addProperty("idcausa", ret.getIdCausa());
			rootElement.add("causaefeito", jsono);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();				
		} catch (RegistroDesconhecidoException e) {
			JsonObject jsono = new JsonObject();
			jsono.addProperty("idcausaefeito", 0);
			jsono.addProperty("idcausaefeitopai", 0);
			jsono.addProperty("idproblema", 0);
			jsono.addProperty("idcatcausa", 0);
			jsono.addProperty("idcausa", 0);
			rootElement.add("causaefeito", jsono);

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

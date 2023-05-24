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
import idw.model.dao.SpCanvasDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.rn.DataHoraRN;
import idw.model.rn.SpCanvasRN;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.mfv.dto.A3MainDTO;

@Path("/mfv/canvas")
public class CanvasResource {


	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DATA_ISO8601 = "yyyy-MM-dd";
	public static final String FORMATO_DATA_HORA_ISO8601 = "yyyy-MM-dd HH:mm:ss";


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaA3(@QueryParam("idusuario") String idusuario, @QueryParam("chavepesquisa") String chavepesquisa) {
		//fa3getlistaa3temp //fa3getlistaa3TEMP
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCanvasDAO spCanvasDAO = new SpCanvasDAO(dao.getSession(),FORMATO_DATA_ISO8601, FORMATO_DATA_HORA_ISO8601);
			List<A3MainDTO> listaA3maindto = spCanvasDAO.getListaA3(Long.valueOf( idusuario), chavepesquisa);

			List<JsonObject> listaa3 = new ArrayList<JsonObject>();
			for(A3MainDTO a3maisdto : listaA3maindto) {


				JsonObject a3 = new JsonObject();


				
				String id_a3 = "";
				String cd_a3 = "";
				String ds_a3 = "";
				String dt_ia3 = "";
				String dt_fa3 = "";
				String maincd_produto = "";
				String cachep3_ciclosbarra_idgt = "";
				String cachep3_paradaspizza_idgt = "";
				String cachep3_defeitosbarra_idgt = "";
				String cachep3_paradasbarra_cdarea = "";
				String cachep7_result_dti = "";
				String cachep7_result_dtf = "";
				String cd_produto = "";
							
				if (a3maisdto.getIdA3()!=null){
					id_a3 = a3maisdto.getIdA3().toString();
				}
				if (a3maisdto.getCdA3()!=null){
					cd_a3 = a3maisdto.getCdA3();
				}
				if (a3maisdto.getDsA3()!=null){
					ds_a3 = a3maisdto.getDsA3();
				}
				if (a3maisdto.getDtIa3()!=null){
					dt_ia3 = DataHoraRN.dateToString(a3maisdto.getDtIa3(),FORMATO_DATA_ISO8601) ;
				}
				if(a3maisdto.getDtFa3()!=null){
					dt_fa3 = DataHoraRN.dateToString(a3maisdto.getDtFa3(),FORMATO_DATA_ISO8601) ;
				}
				if(a3maisdto.getMainCdproduto()!=null){
					maincd_produto = a3maisdto.getMainCdproduto();
				}
				if (a3maisdto.getCachep3Ciclosbarraidgt()!=null){
					cachep3_ciclosbarra_idgt = a3maisdto.getCachep3Ciclosbarraidgt().toString();
				}
				if (a3maisdto.getCachep3Pradaspizzaidgt()!=null){
					cachep3_paradaspizza_idgt = a3maisdto.getCachep3Pradaspizzaidgt().toString();
				}
				if (a3maisdto.getCachep3Defeitosbarraidgt()!=null){
					cachep3_defeitosbarra_idgt = a3maisdto.getCachep3Defeitosbarraidgt().toString();
				}
				if (a3maisdto.getCachep3Paradasbarracdarea()!=null){
					cachep3_paradasbarra_cdarea = a3maisdto.getCachep3Paradasbarracdarea().toString();
				}
				if (a3maisdto.getCachep7Resultdti()!=null){
					cachep7_result_dti = DataHoraRN.dateToString(a3maisdto.getCachep7Resultdti(),FORMATO_DATA_ISO8601) ;
				}
				if (a3maisdto.getCachep7Resultdtf()!=null){
					cachep7_result_dtf = DataHoraRN.dateToString(a3maisdto.getCachep7Resultdtf(),FORMATO_DATA_ISO8601) ;
				}
				if (a3maisdto.getCdProduto()!=null){
					cd_produto = a3maisdto.getCdProduto();
				}


				a3.addProperty("id_a3", id_a3 );
				a3.addProperty("cd_a3", cd_a3 );
				a3.addProperty("ds_a3", ds_a3 );
				a3.addProperty("dt_ia3", dt_ia3 );
				a3.addProperty("dt_fa3", dt_fa3 );
				a3.addProperty("maincd_produto", maincd_produto );
				a3.addProperty("cachep3_ciclosbarra_idgt", cachep3_ciclosbarra_idgt );
				a3.addProperty("cachep3_paradaspizza_idgt", cachep3_paradaspizza_idgt );
				a3.addProperty("cachep3_defeitosbarra_idgt", cachep3_defeitosbarra_idgt );
				a3.addProperty("cachep3_paradasbarra_cdarea", cachep3_paradasbarra_cdarea );
				a3.addProperty("cachep7_result_dti", cachep7_result_dti );
				a3.addProperty("cachep7_result_dtf", cachep7_result_dtf );
				a3.addProperty("cd_produto", cd_produto);				
				
				
				listaa3.add(a3);

			}

			rootElement.add("listaa3", gson.toJsonTree(listaa3));

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
	@Path("/getlistaa3") //fa3getlistaa3nw
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaA3IdUsr(@QueryParam("idusuario") String idusuario) {
		//fa3getlistaa3temp
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCanvasDAO spCanvasDAO = new SpCanvasDAO(dao.getSession(),FORMATO_DATA_ISO8601,FORMATO_DATA_ISO8601);
			List<A3MainDTO> listaA3maindto = spCanvasDAO.getListaA3IdUsr(Long.valueOf( idusuario));

			List<JsonObject> listaa3 = new ArrayList<JsonObject>();
			for(A3MainDTO a3maisdto : listaA3maindto) {


				JsonObject a3 = new JsonObject();
				
				String id_a3 = "";
				String cd_a3 = "";
				String ds_a3 = "";
				String dt_ia3 = "";
				String dt_fa3 = "";
				String maincd_produto = "";
				String cachep3_ciclosbarra_idgt = "";
				String cachep3_paradaspizza_idgt = "";
				String cachep3_defeitosbarra_idgt = "";
				String cachep3_paradasbarra_cdarea = "";
				String cachep7_result_dti = "";
				String cachep7_result_dtf = "";
				String cd_produto = "";
							
				if (a3maisdto.getIdA3()!=null){
					id_a3 = a3maisdto.getIdA3().toString();
				}
				if (a3maisdto.getCdA3()!=null){
					cd_a3 = a3maisdto.getCdA3();
				}
				if (a3maisdto.getDsA3()!=null){
					ds_a3 = a3maisdto.getDsA3();
				}
				if (a3maisdto.getDtIa3()!=null){
					dt_ia3 = DataHoraRN.dateToString(a3maisdto.getDtIa3(),FORMATO_DATA_ISO8601) ;
				}
				if(a3maisdto.getDtFa3()!=null){
					dt_fa3 = DataHoraRN.dateToString(a3maisdto.getDtFa3(),FORMATO_DATA_ISO8601) ;
				}
				if(a3maisdto.getMainCdproduto()!=null){
					maincd_produto = a3maisdto.getMainCdproduto();
				}
				if (a3maisdto.getCachep3Ciclosbarraidgt()!=null){
					cachep3_ciclosbarra_idgt = a3maisdto.getCachep3Ciclosbarraidgt().toString();
				}
				if (a3maisdto.getCachep3Pradaspizzaidgt()!=null){
					cachep3_paradaspizza_idgt = a3maisdto.getCachep3Pradaspizzaidgt().toString();
				}
				if (a3maisdto.getCachep3Defeitosbarraidgt()!=null){
					cachep3_defeitosbarra_idgt = a3maisdto.getCachep3Defeitosbarraidgt().toString();
				}
				if (a3maisdto.getCachep3Paradasbarracdarea()!=null){
					cachep3_paradasbarra_cdarea = a3maisdto.getCachep3Paradasbarracdarea().toString();
				}
				if (a3maisdto.getCachep7Resultdti()!=null){
					cachep7_result_dti = DataHoraRN.dateToString(a3maisdto.getCachep7Resultdti(),FORMATO_DATA_ISO8601) ;
				}
				if (a3maisdto.getCachep7Resultdtf()!=null){
					cachep7_result_dtf = DataHoraRN.dateToString(a3maisdto.getCachep7Resultdtf(),FORMATO_DATA_ISO8601) ;
				}
				if (a3maisdto.getCdProduto()!=null){
					cd_produto = a3maisdto.getCdProduto();
				}


				a3.addProperty("id_a3", id_a3 );
				a3.addProperty("cd_a3", cd_a3 );
				a3.addProperty("ds_a3", ds_a3 );
				a3.addProperty("dt_ia3", dt_ia3 );
				a3.addProperty("dt_fa3", dt_fa3 );
				a3.addProperty("maincd_produto", maincd_produto );
				///a3.addProperty("cachep3_ciclosbarra_idgt", cachep3_ciclosbarra_idgt );
				///a3.addProperty("cachep3_paradaspizza_idgt", cachep3_paradaspizza_idgt );
				///a3.addProperty("cachep3_defeitosbarra_idgt", cachep3_defeitosbarra_idgt );
				///a3.addProperty("cachep3_paradasbarra_cdarea", cachep3_paradasbarra_cdarea );
				///a3.addProperty("cachep7_result_dti", cachep7_result_dti );
				///a3.addProperty("cachep7_result_dtf", cachep7_result_dtf );
				a3.addProperty("cd_produto", cd_produto);		

				listaa3.add(a3);

			}

			rootElement.add("listaa3", gson.toJsonTree(listaa3));

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
	@Path("/geta3") //fa3geta3nw
	@Produces(MediaType.APPLICATION_JSON)
	public Response getA3(@QueryParam("ida3") String ida3) {
		//fa3geta3nw
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCanvasDAO spCanvasDAO = new SpCanvasDAO(dao.getSession(),FORMATO_DATA_ISO8601,FORMATO_DATA_ISO8601);
			List<A3MainDTO> listaA3maindto = spCanvasDAO.getSp(Long.valueOf( ida3));

			List<JsonObject> listaa3 = new ArrayList<JsonObject>();
			for(A3MainDTO a3maisdto : listaA3maindto) {


				JsonObject a3 = new JsonObject();
		
				String id_a3 = "";
				String cd_a3 = "";
				String ds_a3 = "";
				String dt_ia3 = "";
				String dt_fa3 = "";
				String maincd_produto = "";
				String cachep3_ciclosbarra_idgt = "";
				String cachep3_paradaspizza_idgt = "";
				String cachep3_defeitosbarra_idgt = "";
				String cachep3_paradasbarra_cdarea = "";
				String cachep7_result_dti = "";
				String cachep7_result_dtf = "";
				String cd_produto = "";
							
				if (a3maisdto.getIdA3()!=null){
					id_a3 = a3maisdto.getIdA3().toString();
				}
				if (a3maisdto.getCdA3()!=null){
					cd_a3 = a3maisdto.getCdA3();
				}
				if (a3maisdto.getDsA3()!=null){
					ds_a3 = a3maisdto.getDsA3();
				}
				if (a3maisdto.getDtIa3()!=null){
					dt_ia3 = DataHoraRN.dateToString(a3maisdto.getDtIa3(),FORMATO_DATA_ISO8601) ;
				}
				if(a3maisdto.getDtFa3()!=null){
					dt_fa3 = DataHoraRN.dateToString(a3maisdto.getDtFa3(),FORMATO_DATA_ISO8601) ;
				}
				if(a3maisdto.getMainCdproduto()!=null){
					maincd_produto = a3maisdto.getMainCdproduto();
				}
				if (a3maisdto.getCachep3Ciclosbarraidgt()!=null){
					cachep3_ciclosbarra_idgt = a3maisdto.getCachep3Ciclosbarraidgt().toString();
				}
				if (a3maisdto.getCachep3Pradaspizzaidgt()!=null){
					cachep3_paradaspizza_idgt = a3maisdto.getCachep3Pradaspizzaidgt().toString();
				}
				if (a3maisdto.getCachep3Defeitosbarraidgt()!=null){
					cachep3_defeitosbarra_idgt = a3maisdto.getCachep3Defeitosbarraidgt().toString();
				}
				if (a3maisdto.getCachep3Paradasbarracdarea()!=null){
					cachep3_paradasbarra_cdarea = a3maisdto.getCachep3Paradasbarracdarea().toString();
				}
				if (a3maisdto.getCachep7Resultdti()!=null){
					cachep7_result_dti = DataHoraRN.dateToString(a3maisdto.getCachep7Resultdti(),FORMATO_DATA_ISO8601) ;
				}
				if (a3maisdto.getCachep7Resultdtf()!=null){
					cachep7_result_dtf = DataHoraRN.dateToString(a3maisdto.getCachep7Resultdtf(),FORMATO_DATA_ISO8601) ;
				}
				if (a3maisdto.getCdProduto()!=null){
					cd_produto = a3maisdto.getCdProduto();
				}


				a3.addProperty("id_a3", id_a3 );
				a3.addProperty("cd_a3", cd_a3 );
				a3.addProperty("ds_a3", ds_a3 );
				a3.addProperty("dt_ia3", dt_ia3 );
				a3.addProperty("dt_fa3", dt_fa3 );
				a3.addProperty("maincd_produto", maincd_produto );
				a3.addProperty("cachep3_ciclosbarra_idgt", cachep3_ciclosbarra_idgt );
				a3.addProperty("cachep3_paradaspizza_idgt", cachep3_paradaspizza_idgt );
				a3.addProperty("cachep3_defeitosbarra_idgt", cachep3_defeitosbarra_idgt );
				a3.addProperty("cachep3_paradasbarra_cdarea", cachep3_paradasbarra_cdarea );
				a3.addProperty("cachep7_result_dti", cachep7_result_dti );
				a3.addProperty("cachep7_result_dtf", cachep7_result_dtf );
				a3.addProperty("cd_produto", cd_produto);				
				
				
				listaa3.add(a3);

			}

			rootElement.add("a3", gson.toJsonTree(listaa3));

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


	//fa3insertupdatemainnw
	@PUT
	@Path("/putmain")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMainNw(
			@QueryParam("idSp") long idSp
			, @QueryParam("cdSp") String cdSp
			, @QueryParam("dsSp") String dsSp
			, @QueryParam("dtisp") String dtisp
			, @QueryParam("dtfsp") String dtfsp			
			, @QueryParam("cdproduto") String cdproduto
			, @QueryParam("idusrdono") long idusrdono

			) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCanvasDAO spDAO = new SpCanvasDAO(dao.getSession(),FORMATO_DATA_ISO8601,FORMATO_DATA_ISO8601);
			long id = spDAO.insertMainNw(
					idSp
					, cdSp
					, dsSp
					, dtisp
					, dtfsp			
					, cdproduto
					, idusrdono								
					);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("mainnw", jsono);

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


	//fa3insertupdatevaloresmvf
	@PUT
	@Path("/putmfv")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMfv(
			@QueryParam("cdProduto") String cdProduto
			, @QueryParam("idSetor") long idSetor
			, @QueryParam("leadtime") long leadtime
			, @QueryParam("cicletime") long cicletime
			, @QueryParam("percoee") long percoee
			) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCanvasDAO spDAO = new SpCanvasDAO(dao.getSession(),FORMATO_DATA_ISO8601,FORMATO_DATA_ISO8601);
			long id = spDAO.insertMfv(
					cdProduto
					, idSetor
					, leadtime
					, cicletime
					, percoee							
					);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("mfv", jsono);

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


	//fa3dela3cascata
	@DELETE
	@Path("/dela3")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarA3Cascata(@QueryParam("idSp") int idSp) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCanvasRN spRN = new SpCanvasRN(dao, FORMATO_DATA_ISO8601,  FORMATO_DATA_HORA_ISO8601);
			long id = spRN.deletarA3Cascata(idSp);

			JsonObject jsono = new JsonObject();
			jsono.addProperty("id", id);
			rootElement.add("a3cascata", jsono);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);	
			return Response.status(responseStatus).entity(json).build();
		} catch (RegistroDesconhecidoException e) {
			JsonObject objeto = new JsonObject();
			objeto.addProperty("id", 0);
			rootElement.add("a3cascata", objeto);
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

package idw.webservices.rest.conecthusstencil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolidDAO;
import idw.model.pojos.DwConsol;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.iawm.AnalisesGtIADTO;


public class ConsultasFacade {
	
	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DATA_ISO8601 = "yyyy-MM-dd";
	public static final String FORMATO_DATA_HORA_ISO8601 = "yyyy-MM-dd HH:mm:ss";
	

	private static ConsultasFacade instancia = null;

	private ConsultasFacade() {
		super();
	}

	public static ConsultasFacade getInstancia() {
		if (instancia == null) {
			instancia = new ConsultasFacade();
		}
		return instancia;
	}

	public Response getQtCiclosByMaquinaTurnoDataToken(@Context HttpServletRequest request, FiltroByCdMaqIdTurnoDataDTO filtro) {

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		DAOGenerico dao = new DAOGenerico();
		JsonObject rootElement = new JsonObject();
		
		String cdMaquina = "";
		String dtReferencia = "";
		String idTurno = "";
		Long lidTurno = 0L;
		
		
		if(filtro!=null && filtro.getCdMaquina()!=null) {
			cdMaquina = filtro.getCdMaquina().trim();
		}
		if(filtro!=null && filtro.getData()!=null) {
			dtReferencia = filtro.getData().trim();
		}
		if(filtro!=null && filtro.getIdTurno()!=null) {
			idTurno = filtro.getIdTurno().trim();
		}
		
		if(
				cdMaquina.equals("")
				|| dtReferencia.equals("")
				|| idTurno.equals("")
			){
			responseStatus = Response.Status.BAD_REQUEST;
			Exception e = new Exception();
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);			
		}
		
		Long qtCiclos= 0L;
		String sQtCiclos = "";
		
		try {
			
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			lidTurno = Long.valueOf(idTurno);
			

			DwConsolidDAO cwconsolidDAO = new DwConsolidDAO(dao.getSession());
			List<DwConsol> consols = new ArrayList<DwConsol>();
				consols = cwconsolidDAO.getQtCiclosByMaquinaTurnoDataToken(
						cdMaquina,
						lidTurno,
						DataHoraRN.stringToDate(dtReferencia, FORMATO_DATA_ISO8601));

			//List<JsonObject> listaitensjson = new ArrayList<>();
			for(DwConsol i : consols) {
				
				if (i.getQtAutoCicloprodutivo()!=null) {
					qtCiclos = i.getQtAutoCicloprodutivo().longValue();	
				}
				sQtCiclos = qtCiclos.toString();


				//JsonObject jsonitemobj = new JsonObject();


				//jsonitemobj.addProperty("qtCiclos", sQtCiclos);			
				rootElement.addProperty ("qtCiclos", qtCiclos);
				
				
				//rootElement.add("getQtCiclosByMaquinaTurnoDataToken", jsonitemobj);
				//listaitensjson.add(jsonitemobj);

			}

			// rootElement.add("ciclos", gson.toJsonTree(listaitensjson));
			

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			dao.rollBackTransacaoSemException();			
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
			dao.finalizaSessaoSemException();
		}

	}



	
	
	public Response getTeste(@Context HttpServletRequest request) {

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		DAOGenerico dao = new DAOGenerico();
		JsonObject rootElement = new JsonObject();
		
		String cdMaquina = "";
		String dtReferencia = "";
		String idTurno = "";
		Long lidTurno = 0L;
		
		
		
		Long qtCiclos= 0L;
		String sQtCiclos = "";
		
		AnalisesGtIADTO retorno;
		
		String json = "";
		
		try {
			
			
			retorno = IdwFacade.getInstancia().analiseIaWmGtsReturn();
			
			json = gson.toJson(retorno);
			responseStatus = Response.Status.OK;
			return Response.status(responseStatus).entity(json).build();			
			
			
			/*
			rootElement.addProperty ("Teste", 0);
			responseStatus = Response.Status.OK;
			json = gson.toJson(rootElement);		
			return Response.status(responseStatus).entity(json).build();
			*/
			

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			dao.rollBackTransacaoSemException();			
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
			dao.finalizaSessaoSemException();
		}

	}

	
	
	
	
}

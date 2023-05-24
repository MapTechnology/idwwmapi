package idw.webservices.rest.wmapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.rn.web.vf.monitorizacao.MonitorizacaoWebRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.TurnoDTO;
import idw.webservices.rest.dto.iawm.AnalisesGtIADTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO;
import idw.webservices.rest.idw.v2.dto.PtMonitDTO;

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

	public Response getDadosResposta(@Context HttpServletRequest request, String filtroStringListaCdGts) {

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		DAOGenerico dao = new DAOGenerico();
		JsonObject rootElement = new JsonObject();
		
		Double db = new Double(0L);
		
		String cdMaquina = "";
		String dtReferencia = "";
		String idTurno = "";
		Long lidTurno = 0L;
		
		FiltroMonitorizacaoDTO filtromonitoracao;
		
		List<DadosRespostaMaquinaDTO> maquinasParadas = new ArrayList<DadosRespostaMaquinaDTO>();
		DadosRespostaDTO resposta= new DadosRespostaDTO();
		DadosRespostaMaquinaDTO maquinaparada;
		
		String json = "";
		
		if(filtroStringListaCdGts==null) {
			responseStatus = Response.Status.BAD_REQUEST;
			Exception e = new Exception();
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);			
		}
		List<String> listCodigosGts = Arrays.asList(filtroStringListaCdGts.split("\\s*,\\s*"));
		if(listCodigosGts==null) {
			responseStatus = Response.Status.BAD_REQUEST;
			Exception e = new Exception();
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);			
		}
		if(listCodigosGts.get(0).trim()=="") {
			responseStatus = Response.Status.BAD_REQUEST;
			Exception e = new Exception();
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);			
		}

		
		resposta.setMelhordesempenhoCdGt("NAOLOCALIZADO");
		resposta.setMelhordesempenhoDsGt("NAOLOCALIZADO");
		resposta.setMelhordesempenhoOEE(new Double(0L));
		resposta.setPiordesempenhoCdGt("NAOLOCALIZADO");
		resposta.setPiordesempenhoDsGt("NAOLOCALIZADO");
		resposta.setPiordesempenhoOEE(new Double(0L));
		
		
		
		Long qtCiclos= 0L;
		String sQtCiclos = "";
		
		try {
			
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			TurnoDTO turnoAtualDTO;
			
			MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			for(String scdgt : listCodigosGts) {
				
				
				try {
					turnoAtualDTO = rn.getTurnoAtual(scdgt);
				}catch(Exception e) {
					continue;//parte para o proximo
				}
				if (turnoAtualDTO == null) {
					continue;//parte para o proximo
				}

				filtromonitoracao = new FiltroMonitorizacaoDTO();

				filtromonitoracao.setCdGt(scdgt);
				filtromonitoracao.setIdTurno(turnoAtualDTO.getIdTurno());
				filtromonitoracao.setDtReferencia(turnoAtualDTO.getDtReferencia());
				filtromonitoracao.setTurnoAtual(true);
				filtromonitoracao.setFiltroOp(0);
				
				MonitorizacaoDTO monitorizacaoDTO = rn.getMonitorizacao(filtromonitoracao);
				
				
				if (monitorizacaoDTO == null) {
					continue;//parte para o proximo
						///throw new ResourceWebApplicationException("Error");
				}
				if (monitorizacaoDTO.getInfoPts() != null) {
					
					for (PtMonitDTO itempt : monitorizacaoDTO.getInfoPts()) {
						
						if (itempt.getStFuncionamentoPt()!=null && itempt.getStFuncionamentoPt().intValue()==1) {
							maquinaparada = new  DadosRespostaMaquinaDTO();
							maquinaparada.setCdGt(scdgt);
							maquinaparada.setDsGt(scdgt);
							maquinaparada.setCdPt(itempt.getCdPt());
							maquinaparada.setDsPt(itempt.getDsPt());
							maquinaparada.setParada(itempt.getParada());
							maquinasParadas.add(maquinaparada);
						}
						
						//melhor desempenho
						if(itempt.getIndOEE().doubleValue()>resposta.getMelhordesempenhoOEE().doubleValue()) {
							resposta.setMelhordesempenhoCdGt(scdgt);
							resposta.setMelhordesempenhoDsGt(scdgt);
							resposta.setMelhordesempenhoIdTurno( Long.toString(turnoAtualDTO.getIdTurno()));
							resposta.setMelhordesempenhoCdTurno(turnoAtualDTO.getCdTurno());
							resposta.setMelhordesempenhoDsTurno(turnoAtualDTO.getDsTurno());
							resposta.setMelhordesempenhoCdPt(itempt.getCdPt());
							resposta.setMelhordesempenhoDsPt(itempt.getDsPt());
						}
					
						//pior desempenho
						if(itempt.getIndOEE().doubleValue()!=0L && itempt.getIndOEE().doubleValue() < resposta.getPiordesempenhoOEE().doubleValue()) {
							resposta.setPiordesempenhoCdGt(scdgt);
							resposta.setPiordesempenhoDsGt(scdgt);
							resposta.setPiordesempenhoIdTurno( Long.toString(turnoAtualDTO.getIdTurno()));
							resposta.setPiordesempenhoCdTurno(turnoAtualDTO.getCdTurno());
							resposta.setPiordesempenhoDsTurno(turnoAtualDTO.getDsTurno());
							resposta.setPiordesempenhoCdPt(itempt.getCdPt());
							resposta.setPiordesempenhoDsPt(itempt.getDsPt());
						}
					}
					
					
				}
			}
			
			if(maquinasParadas!=null && maquinasParadas.size()>0) {
				resposta.setListaMaquinasParadas(maquinasParadas);	
			}
			
			
			///dao.commitaTransacao();			
			dao.commitaTransacao(dao.getSession());
			
			
			json = gson.toJson(resposta);
			responseStatus = Response.Status.OK;
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

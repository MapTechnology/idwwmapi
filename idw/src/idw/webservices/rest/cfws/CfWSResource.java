package idw.webservices.rest.cfws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.IdwFacade;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.LeituraCODTO;
import idw.webservices.dto.LeiturasCODTO;
import idw.webservices.dto.MapaCODTO;
import idw.webservices.dto.UsuarioCODTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.cfws.dto.FiltroLeituraCorrenteDTO;
import idw.webservices.rest.cfws.dto.FiltroSetConferenciaOuPreDTO;


@Path("/cfwsr")
public class CfWSResource {
	//TODO: avaliar melhor estrutura singleton para este caso, sendo que de um modo a não impactar em gargalos

	@POST
	@Path("/setcorrente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCorrente(@Context HttpServletRequest request, FiltroLeituraCorrenteDTO filtro) {	
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		System.out.println("ENTROU NO METODO setCorrente");
		
		//log no Console: pode ser desativado caso desejado
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("CHAMADA REST: /cfwsr/setcorrente - " + dateFormat.format(date));		
		
		LeiturasCODTO retornoDTO = null;
		LeiturasCODTO parametroDTO = null;
		LeituraCODTO leituraCODTO = null;
		MapaCODTO mapaCODTO = null;
		UsuarioCODTO usuarioCODTO = null;
		
		try {
			//leitura
			parametroDTO = new LeiturasCODTO();
			parametroDTO.setLeituras(new ArrayList<LeituraCODTO>());
			leituraCODTO = new LeituraCODTO();
			//TODO: talvez 'limpar'/preparar passagem de parametros específicos para LeituraCODTO
			if(filtro!=null && filtro.getLeitura()!=null){
				filtro.getLeitura().setLeituraOk(filtro.isOK());
				leituraCODTO = filtro.getLeitura();	
			}
			parametroDTO.getLeituras().add(leituraCODTO);

			//mapa
			mapaCODTO = new MapaCODTO();
			mapaCODTO.setCdMapa( (filtro.getCdMapa()!=null?filtro.getCdMapa():"") );
			parametroDTO.setMapa(mapaCODTO);

			//tpleitura
			parametroDTO.setTpLeitura( (byte) (filtro.isSimularAlimentacao() ? 2 : 3) );

			//usuario
			usuarioCODTO = new UsuarioCODTO();
			usuarioCODTO.setIdUsuario(filtro.getIdUsuario());
			parametroDTO.setUsuario(usuarioCODTO);
			
			//dthrleitura
			parametroDTO.setMinDtHrLeitura(filtro.getMinDtHrLeitura());
			
			//cdmaquina
			parametroDTO.setCdMaquina((filtro.getCdMaquina()!=null?filtro.getCdMaquina():""));
			
			//tpleitura
			parametroDTO.setTpLeitura(filtro.getTpLeitura());
			
			//status
			parametroDTO.setStatus(filtro.getStatus());

			//Submete setCorrente()
			retornoDTO = IdwFacade.getInstancia().setCorrente(parametroDTO);
			
			
			if(retornoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retornoDTO); //alerta: nesta configuração apenas NAO NULOS retornam dados; os nulos ficam omissos aqui no json; mas possivel redefinir gson para forçar retornar ainda assim os NULOS.
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
			retornoDTO = null;
			parametroDTO = null;
			leituraCODTO = null;
			mapaCODTO = null;
			usuarioCODTO = null;			
		}
	}
	
	
	@POST
	@Path("/setconferenciaoupre")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setConferenciaOuPre(@Context HttpServletRequest request, FiltroSetConferenciaOuPreDTO filtro) {
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		//log no Console: pode ser desativado caso desejado
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("CHAMADA REST: /cfwsr/setconferenciaoupre - " + dateFormat.format(date) );
		
		
		boolean retornoDTO = false;	
		LeiturasCODTO leiturasCODTO = null;
		
		MapaCODTO mapaCODTO = null;
		UsuarioCODTO usuarioCODTO = null;
		
		try {

						
			leiturasCODTO = new LeiturasCODTO();
			
			leiturasCODTO.setLeituras(filtro.getLeituras());			

			//mapa
			mapaCODTO = new MapaCODTO();
			mapaCODTO.setCdMapa( (filtro.getCdMapa()!=null?filtro.getCdMapa():"") );
			leiturasCODTO.setMapa(mapaCODTO);

			//tpleitura
			leiturasCODTO.setTpLeitura(filtro.getTpLeitura());

			//usuario
			usuarioCODTO = new UsuarioCODTO();
			usuarioCODTO.setIdUsuario(filtro.getIdUsuario());
			leiturasCODTO.setUsuario(usuarioCODTO);
			
			//dthrleitura
			leiturasCODTO.setMinDtHrLeitura(filtro.getMinDtHrLeitura());
			
			//cdmaquina
			leiturasCODTO.setCdMaquina((filtro.getCdMaquina()!=null?filtro.getCdMaquina():""));
			
			//idAlim
			leiturasCODTO.setIdAlim(filtro.getIdAlim());
			
			//isExclusividade
			leiturasCODTO.setIsExclusividade(filtro.getIsExclusividade());
			
			//status
			leiturasCODTO.setStatus(filtro.getStatus());
			
			//minDtHrLeitura
			leiturasCODTO.setMinDtHrLeitura(filtro.getMinDtHrLeitura());

			//Submete setCorrente()
			retornoDTO = IdwFacade.getInstancia().setConferenciaOuPre(leiturasCODTO);
			//return IdwFacade.getInstancia().setConferenciaOuPre(leituras);	
			
			if(retornoDTO == false) {
				throw new JsonException("Error");
			}
			
			String json = gson.toJson(retornoDTO); //alerta: nesta configuração apenas NAO NULOS retornam dados; os nulos ficam omissos aqui no json; mas possivel redefinir gson para forçar retornar ainda assim os NULOS.
			return Response.status(responseStatus).entity(json).build();
			
		} catch (JsonException e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
			retornoDTO = false;		
			mapaCODTO = null;
			usuarioCODTO = null;			
		}
		
		
	}
	
	
	@POST
	@Path("/setRealimentacao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setRealimentacao(@Context HttpServletRequest request, FiltroSetConferenciaOuPreDTO filtro) {
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		//log no Console: pode ser desativado caso desejado
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("CHAMADA REST: /cfwsr/setRealimentacao - " + dateFormat.format(date) );
		
		
		boolean retornoDTO = false;	
		LeiturasCODTO leiturasCODTO = null;
		
		MapaCODTO mapaCODTO = null;
		UsuarioCODTO usuarioCODTO = null;
		
		try {

						
			leiturasCODTO = new LeiturasCODTO();
			
			leiturasCODTO.setLeituras(filtro.getLeituras());			

			//mapa
			mapaCODTO = new MapaCODTO();
			mapaCODTO.setCdMapa( (filtro.getCdMapa()!=null?filtro.getCdMapa():"") );
			leiturasCODTO.setMapa(mapaCODTO);

			//tpleitura
			leiturasCODTO.setTpLeitura(filtro.getTpLeitura());

			//usuario
			usuarioCODTO = new UsuarioCODTO();
			usuarioCODTO.setIdUsuario(filtro.getIdUsuario());
			leiturasCODTO.setUsuario(usuarioCODTO);
			
			//dthrleitura
			leiturasCODTO.setMinDtHrLeitura(filtro.getMinDtHrLeitura());
			
			//cdmaquina
			leiturasCODTO.setCdMaquina((filtro.getCdMaquina()!=null?filtro.getCdMaquina():""));
			
			//idAlim
			leiturasCODTO.setIdAlim(filtro.getIdAlim());
			
			//isExclusividade
			leiturasCODTO.setIsExclusividade(filtro.getIsExclusividade());
			
			//status
			leiturasCODTO.setStatus(filtro.getStatus());
			
			//minDtHrLeitura
			leiturasCODTO.setMinDtHrLeitura(filtro.getMinDtHrLeitura());

			//Submete setCorrente()
			retornoDTO = IdwFacade.getInstancia().setRealimentacao(leiturasCODTO);
				
			
			if(retornoDTO == false) {
				throw new JsonException("Error");
			}
			
			String json = gson.toJson(retornoDTO); //alerta: nesta configuração apenas NAO NULOS retornam dados; os nulos ficam omissos aqui no json; mas possivel redefinir gson para forçar retornar ainda assim os NULOS.
			return Response.status(responseStatus).entity(json).build();
			
		} catch (JsonException e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
			retornoDTO = false;		
			mapaCODTO = null;
			usuarioCODTO = null;			
		}
		
		
	}

	
}

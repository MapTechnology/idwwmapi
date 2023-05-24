package idw.webservices.rest.v2.injet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.dao.OmGtDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.rn.monitorizacao.injet.MonitorizacaoVisaoMaquinaInjetV2RN;
import idw.model.rn.web.v2.injet.monitorizacao.MonitorizacaoInjetWebRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.GtRtDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.v2.injet.dto.monitorizacao.DataTurnoReferenciaDTO;
import idw.webservices.rest.v2.injet.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.v2.injet.dto.monitorizacao.GtMonitorizacaoDTO;
import idw.webservices.rest.v2.injet.dto.monitorizacao.MonitorizacaoDTO;
import idw.webservices.rest.v2.injet.dto.monitorizacao.PtMonitorizacaoDTO;




@Path("/v2/injet/monitorizacao")
public class MonitorizacaoResource {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";

	
	@POST
	@Path("/postosativos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostosAtivos(FiltroMonitorizacaoDTO filtro) {	
		//getPostosAtivos
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		boolean isTurnoAtual = false;
		
		if (filtro==null || filtro.getCdGt()==null){
			responseStatus = Response.Status.NOT_ACCEPTABLE;
			return Response.status(responseStatus).entity("").build();
		}

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			
			idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO monitorizacaoDTOv1 = null;
			MonitorizacaoDTO monitorizacaoDTOv2 = null;


			OmGtDAO omGtDAO = new OmGtDAO(dao.getSession());
			OmGt omGt = omGtDAO.getOmGtPorCdAtivoOrderByIdInjet(dao, filtro.getCdGt());
			GtRtDTO gtrtdto = new GtRtDTO();
			MonitorizacaoInjetWebRN mijwrn = new MonitorizacaoInjetWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			gtrtdto = mijwrn.getFiltroGt(filtro, omGt);
			MonitorizacaoVisaoMaquinaInjetV2RN  rnaux = new MonitorizacaoVisaoMaquinaInjetV2RN(dao);
			DataTurnoReferenciaDTO dthrefdto = null;
			dthrefdto = rnaux.getDataTurnoReferencia();			
			isTurnoAtual = false;
			if (dthrefdto!=null && dthrefdto.getDtref()!=null && gtrtdto!=null && gtrtdto.getDtReferencia()!=null){
				if ( (gtrtdto.getDtReferencia().equals(dthrefdto.getDtref()))   ){
					if (gtrtdto.getDwTurno()!=null && gtrtdto.getDwTurno().getCdTurno()!=null && !gtrtdto.getDwTurno().getCdTurno().trim().equals("")){
						if(gtrtdto.getDwTurno().getCdTurno().trim().equals(dthrefdto.getCdturno().trim())){
							isTurnoAtual = true;
						} else {
							isTurnoAtual = false;
						}
					} else {
						if (gtrtdto.getDwTurno()==null){	DwTurno dwt = new DwTurno(); }
						gtrtdto.getDwTurno().setCdTurno(dthrefdto.getCdturno().trim());
						isTurnoAtual = true;
					}
				}
			}

			

			if (isTurnoAtual){
				MonitorizacaoInjetWebRN rn = new MonitorizacaoInjetWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				monitorizacaoDTOv2 = rn.getMonitorizacao(filtro);
				
			} else {
				idw.model.rn.web.injet.monitorizacao.MonitorizacaoInjetWebRN rn = new idw.model.rn.web.injet.monitorizacao.MonitorizacaoInjetWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
				idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO filtrov1 = new idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO();
				filtrov1.setCdGt(filtro.getCdGt());
				filtrov1.setDtReferencia(filtro.getDtReferencia());
				filtrov1.setIdTurno(filtro.getIdTurno());
				filtrov1.setTurnoAtual(filtro.isTurnoAtual());
				filtrov1.setGargalosAgrupados(filtro.isGargalosAgrupados());
				monitorizacaoDTOv1 = rn.getMonitorizacao(filtrov1);
				
				if(monitorizacaoDTOv1!=null){
					monitorizacaoDTOv2 = cpyDTOv1Tov2(monitorizacaoDTOv1);
				}
			}
			
			

			dao.commitaTransacao();
			if(monitorizacaoDTOv1 == null && monitorizacaoDTOv2==null) {
				throw new JsonException("Error");
			}
			
			String json = null;
			if (isTurnoAtual){
				json = gson.toJson(monitorizacaoDTOv2);
			} else {
				json = gson.toJson(monitorizacaoDTOv2); 
			}
			
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	private MonitorizacaoDTO cpyDTOv1Tov2(idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO dtov1){
		MonitorizacaoDTO dtov2retorno = null;
		
		if (dtov1==null){return null;}
		dtov2retorno = new MonitorizacaoDTO();
		
		
		dtov2retorno.setGt(dtov1.getGt());
		if (dtov1.getGts()!=null){
			for (idw.webservices.rest.dto.monitorizacao.GtMonitorizacaoDTO gtv1 :  dtov1.getGts() ){
				GtMonitorizacaoDTO gtv2 = new GtMonitorizacaoDTO();
				gtv2.setCaminhoIcone(gtv1.getCaminhoIcone());
				gtv2.setCdGt(gtv1.getCdGt());
				gtv2.setCorFundo(gtv1.getCorFundo());
				gtv2.setDsGt(gtv1.getDsGt());
				gtv2.setDsGtView(gtv1.getDsGtView());
				//FiltroMonitorizacaoDTO fmv2 = null;
				gtv2.setFiltroDetalhe(null);
				gtv2.setIndiceOEE(gtv1.getIndiceOEE());
				gtv2.setIndiceOEEMeta(gtv1.getIndiceOEEMeta());
				gtv2.setQuantidadePostos(gtv1.getQuantidadePostos());
				if(dtov2retorno.getGts()==null){
					List<GtMonitorizacaoDTO> list = new ArrayList<GtMonitorizacaoDTO>();
					dtov2retorno.setGts(list);
				}
				dtov2retorno.getGts().add(gtv2);
			}
		}
		
		if (dtov1.getPts()!=null){
			for (idw.webservices.rest.dto.monitorizacao.PtMonitorizacaoDTO ptv1 :  dtov1.getPts() ){
				PtMonitorizacaoDTO ptv2 = new PtMonitorizacaoDTO();
				ptv2.setCavidadesAtivasView(ptv1.getCavidadesAtivasView());
				ptv2.setCdProduto(ptv1.getCdProduto());
				ptv2.setCdPt(ptv1.getCdPt());
				ptv2.setCdTipoPosto(ptv1.getCdTipoPosto());
				ptv2.setData(ptv1.getData());
				ptv2.setDsProduto(ptv1.getDsProduto());
				ptv2.setDsPt(ptv1.getDsPt());
				ptv2.setDsView(ptv1.getDsView());
				ptv2.setIcone(ptv1.getIcone());
				ptv2.setIdTurno(ptv1.getIdTurno());
				ptv2.setIndicadores(ptv1.getIndicadores());
				ptv2.setMetaHora(ptv1.getMetaHora());
				ptv2.setOrdem(ptv1.getOrdem());
				ptv2.setTipoPosto(ptv1.getTipoPosto());
				ptv2.setTurno(ptv1.getTurno());
				if(dtov2retorno.getPts()==null){
					List<PtMonitorizacaoDTO> list = new ArrayList<PtMonitorizacaoDTO>();
					dtov2retorno.setPts(list);
				}
				dtov2retorno.getPts().add(ptv2);			
			}
		}
		
		
		
		return dtov2retorno;
	}





}


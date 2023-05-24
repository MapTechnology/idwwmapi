package idw.model;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.pojos.OmCfg;
import idw.model.rn.VerificaPassagemRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.FiltroWebRN;
import idw.util.Util;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.PassagensDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.PtMonitorizacaoDTO;

public class WebFacade extends DAOGenerico {

	public static boolean IS_IDW_ATIVO;

	private static WebFacade instancia = null;

	// Alterar para true ou false para salvar no banco desejado
	private boolean isConsolidarParaInsert = false;
	private boolean isConsolidarParaIDW = true;
	private boolean isIDWAtivo = false;

	/** MASCARAS */
	private String mascaraProduto = "??????";

	private String versaoMobile = "1.15";

	private Date horaServidorBanco;
	private Date horaLocalCapturaServidorBanco;

	private Boolean isRitmosempreNasHrsprod = false;
	
	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";


	private WebFacade() {
		// Na criacao da instancia carregar as configuracoes do omcfg que nao
		// sofrem muitas mudancas.
		// Se essas configuracoes forem modificadas no banco, sera necessario
		// reiniciar o servidor do tomcat
		Session oSession = iniciaSessao();
		OmCfg omcfg = Util.getConfigGeral(oSession);

		if (omcfg != null) {
			if (omcfg.getIsProcessaiacidw() != null)
				this.isConsolidarParaIDW = omcfg.getIsProcessaiacidw();

			if (omcfg.getIsProcessaiacinsert() != null)
				this.isConsolidarParaInsert = omcfg.getIsProcessaiacinsert();

			if (omcfg.getMascaracdprodutoCB() != null)
				this.mascaraProduto = omcfg.getMascaracdprodutoCB();

			if (omcfg.getIsRitmosempreNasHrsprod() != null)
				this.isRitmosempreNasHrsprod = omcfg.getIsRitmosempreNasHrsprod();
		}
		commitaTransacao(oSession);
	}

	public static WebFacade getInstancia() {
		if (instancia == null) {
			instancia = new WebFacade();
		}

		return instancia;
	}


	public static void main(String[] args) {
	}
	
	
	
	public Response getWEBDetalhe(FiltroDetalhePostoDTO filtro) {

		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		FiltroWebRN filtroRN = new FiltroWebRN(FORMATO_DATA, FORMATO_DATA_HORA);

		Response retorno = null;
		
		
		try {
			filtroRN.iniciaConexaoBanco();
			
			DetalheMonitorizacaoWebRN rn = new DetalheMonitorizacaoWebRN(filtroRN.getDao(), FORMATO_DATA, FORMATO_DATA_HORA);
			PtMonitorizacaoDTO ptDTO = rn.getDetalhe(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
			if(ptDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(ptDTO);
			
			ptDTO = null;//2019
			rn = null;//2019
			filtro = null;//2019
			
			retorno = Response.status(responseStatus).entity(json).build();
			
			return retorno;
			
		} catch (Exception e ) {
			
			e.printStackTrace();
			
			filtroRN.getDao().rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			
			throw new ResourceWebApplicationException(responseStatus, error);
			
			
		} finally {
			filtroRN.finalizaConexaoBanco();
			filtroRN = null;
		}
		
		
		
	}
	
}

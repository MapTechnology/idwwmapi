package idw.webservices;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import idw.model.IdwFacade;
import idw.webservices.dto.ConfiguracaoConcentrador;
import injetws.model.excessoes.FalhaSnapshot;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsHorarioDTO;
import injetws.webservices.dto.IwsListaAlertaDTO;
import injetws.webservices.dto.IwsListaMatPrimaDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsRegistroBarCodeDTO;
import injetws.webservices.dto.IwsReleDTO;
import ms.webservice.Msws;

/**
 * @author desen
 *
 */
@WebService(name = "msws", targetNamespace = "http://ms/msws", serviceName = "msws")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MswsComEvt extends Msws{
	@Override
	@WebMethod
	public boolean setTr_alertaInicio(String idUp, String CdAlerta,	Date dthrInicio){
		return IdwFacade.getInstancia().setTr_alertaInicio(idUp, CdAlerta, dthrInicio);
	}
	
	@Override
	@WebMethod
	public boolean setTr_alertaFim(String idUp,String cdAlerta,Date dthrFim) {
		return IdwFacade.getInstancia().setTr_alertaFim(idUp, cdAlerta, dthrFim);
	}
	
	@Override
	@WebMethod
	public IwsErroDTO setTr_operadorInicio(String idUp,String idOperador,Date dthrInicio){
		return IdwFacade.getInstancia().setTr_operadorInicio(idUp, idOperador, dthrInicio);
	}
	
	@Override
	@WebMethod
	public IwsErroDTO setTr_operadorFim(String idUp,String idOperador,Date dthrFim,Date dthrInicio){
		return IdwFacade.getInstancia().setTr_operadorFim(idUp, idOperador, dthrFim, dthrInicio);
	}
	
	@Override
	@WebMethod
	public IwsCicloDTO setTr_paradaInicio(String idUp,Date dthrInicio, Boolean isParadaAutomatica,Boolean isParadaPersistente,Boolean isParPeriodSemConex) {
		IwsCicloDTO retorno = IdwFacade.getInstancia().setTr_paradaInicio(idUp,dthrInicio,isParadaAutomatica,isParadaPersistente,isParPeriodSemConex);
		return retorno;
	}
	
	@Override
	@WebMethod
	public boolean setTr_paradaFim(String idUp, Date dthrFim) {
		boolean isretorno = IdwFacade.getInstancia().setTr_paradaFim(idUp, dthrFim);
		return isretorno;
	}
	
	@Override
	@WebMethod
	public boolean setTr_paradaMotivo(String idUp,Date dthr,String idParada,String idAcao,String idCausa,String idJustificativa, String idTecnicoResponsavel,String idTecnicoUm,String idTecnicoDois,String idLocal,boolean isParadaRegulagem,String tipoParPreConfig,int batidas){
		return IdwFacade.getInstancia().setTr_paradaMotivo(idUp, dthr, idParada, idAcao, idCausa, idJustificativa, idTecnicoResponsavel, idTecnicoUm, idTecnicoDois,idLocal,isParadaRegulagem,tipoParPreConfig,batidas);
	}
		
	@Override
	@WebMethod
	public IwsParadaDTO getTr_TabParadaSetaCod(String idUp,String cdParada){
		return IdwFacade.getInstancia().getTr_TabParadaSetaCod(idUp, cdParada);
	}

	@Override
	@WebMethod
	public IwsCicloDTO setTr_CicloInicio(String idUp,Date dthr,IwsDadosApontamentoDTO dados){ 
		return IdwFacade.getInstancia().setTr_CicloInicio(idUp, dthr,dados);
	}	
	
	@Override
	@WebMethod
	public IwsReleDTO setTr_CicloFim(String idUp,Date dthr,IwsDadosApontamentoDTO dados) throws FalhaSnapshot{ 
		IwsReleDTO retorno = null;
		retorno = IdwFacade.getInstancia().setTr_CicloFim(idUp, dthr, dados);
		return retorno;
	}
	
	@Override
	@WebMethod
	public IwsCpDTO getTr_planejamento(String idUp,IwsCpDTO cpEntrada,Date dthr){
		return IdwFacade.getInstancia().getTr_planejamento(idUp, cpEntrada, dthr);
	}

	@Override
	@WebMethod
	public Boolean setTr_fimplanejamento(String idUp,Date dthrfplanejamento,int batidas){
		return IdwFacade.getInstancia().fimPlanejamento(idUp, dthrfplanejamento,batidas);
	}

	@Override
	@WebMethod
	public IwsHorarioDTO setUPBeatMac(String mac,Date dthrBeat){
		return IdwFacade.getInstancia().setUPBeatMac(mac,dthrBeat);
	}
	@WebMethod
	public IwsHorarioDTO setUPBeat(String mac, Date dthrBeat, boolean isLogoutNaViradaTurno, boolean isFechaParadaNaViradaTurno){
		return IdwFacade.getInstancia().setUPBeat(mac, dthrBeat, isLogoutNaViradaTurno, isFechaParadaNaViradaTurno);
	}

	@Override
	@WebMethod
	public IwsListaUpDTO getTr_inicializacao(String mac,boolean comParadaSemConexao,boolean comParadaDefault,Date dtHr) {
		return IdwFacade.getInstancia().getTr_inicializacao(mac, comParadaSemConexao, comParadaDefault, dtHr);
	}

	/*
	 * (non-Javadoc)
	 * @see ms.webservice.Msws#getInfoUltimoRefugo(java.lang.String)
	 * Esse metodo eh chamado pelo ihm desktop windows para identificar qual o ultimo refugo lancado e mostrar na tela doIHM
	 */
	@Override
	@WebMethod
	public IwsRefugoDTO getInfoUltimoRefugo(String idUp){
		return IdwFacade.getInstancia().getInfoUltimoRefugo(idUp);
	}

	@Override
	@WebMethod
	public IwsAutenticacaoDTO getTr_Autorizacao(String idUp,String login,String password,Integer avaliar,Date DataHrAtual,Boolean validaPorDsUsuario){
		return IdwFacade.getInstancia().getTr_Autorizacao(idUp, login, password, avaliar,DataHrAtual,validaPorDsUsuario);
	}

	@Override
	@WebMethod
	public IwsAutenticacaoDTO getTr_AutorizacaoLogout(String idUp,String login,String password,Date DataHrAtual,Boolean validaPorDsUsuario){
		return IdwFacade.getInstancia().getTr_AutorizacaoLogout(idUp, login, password, DataHrAtual,validaPorDsUsuario);
	}

	@Override
	@WebMethod
	public IwsRefugoDTO getTr_ValidaCodRefugo(String cdMaquina, String cdRefugo){
		return IdwFacade.getInstancia().getTr_ValidaCodRefugo(cdMaquina, cdRefugo);
	}	

	@Override
	@WebMethod 
	public boolean getTr_validaAcao(String cdAcao){		
		return IdwFacade.getInstancia().getTr_validaAcao(cdAcao);
	}
	

	@Override
	@WebMethod 
	public boolean getTr_validaCausa(String cdCausa){
		return IdwFacade.getInstancia().getTr_validaCausa(cdCausa);
	}

	@Override
	@WebMethod 
	public boolean getTr_validaJustificativa(String cdJustificativa){
		return IdwFacade.getInstancia().getTr_validaJustificativa(cdJustificativa);
	}

	@Override
	@WebMethod
	public IwsAlertaDTO getTr_TabAlertaSetaCod(String cdAlerta) {
		return IdwFacade.getInstancia().getTr_TabAlertaSetaCod(cdAlerta);
	}
	
	@Override
	@WebMethod
	public IwsListaAlertaDTO getTr_alertasAbertos(String cdMaquina){
		return IdwFacade.getInstancia().getTr_alertasAbertos(cdMaquina);
	}

	@Override
	@WebMethod
	public IwsRefugoDTO setTr_LancaEventoRefugo(String cdRefugo,String cdCausa,String cdAcao,String Quantidade, String IdUp,String idRdzProduto,Date DataHrAtual){
		return IdwFacade.getInstancia().setTr_LancaEventoRefugo(cdRefugo,  cdCausa,  cdAcao, Quantidade, IdUp,idRdzProduto, DataHrAtual);
	}

	@Override
	@WebMethod
	public IwsListaUpDTO inicializacaoSemEvento(String mac) {
		return IdwFacade.getInstancia().inicializacaoSemEvento(mac);
	}

	@Override
	@WebMethod
	public IwsListaMatPrimaDTO getTr_dadosIntegracaoDoal(String idUp) {
		return new IwsListaMatPrimaDTO();
	}

	@Override
	@WebMethod
	public IwsConsultaDTO setTr_Consula(String cdconsulta, String idup,Date dthr) {
		return IdwFacade.getInstancia().setTr_Consulta(cdconsulta, idup, dthr);
	}
	
	@Override
	@WebMethod
	public Boolean setTr_trataInicioDeCIP(String idup, Date dataReferencia, String tecnico){
		return IdwFacade.getInstancia().setTr_trataInicioDeCIP(idup, dataReferencia, tecnico);
	}	
	
	@Override
	@WebMethod
	public Boolean setTr_trataFimCIP(String idUp,Date dthrfim, String tecnico){
		return IdwFacade.getInstancia().setTr_trataFimCIP(idUp, dthrfim, tecnico);
	}

	@Override
	@WebMethod
	public boolean setTr_ApagaUltimoRefugo(String cdRefugo,	String idRdzProduto,Date DthrUltRefugo,String milisec,String IdUp,Date DataHrAtual){
		return IdwFacade.getInstancia().setTr_ApagaUltimoRefugo(cdRefugo, idRdzProduto, DthrUltRefugo, milisec, IdUp,DataHrAtual);
	}

	@Override
	@WebMethod
	public IwsHorarioDTO getTr_sincronizaHorario(){
		return IdwFacade.getInstancia().getTr_sincronizaHorario();
	}
	
	@WebMethod
	public boolean setRegistroBarCode(IwsRegistroBarCodeDTO barcodeDTO){
		return IdwFacade.getInstancia().setRegistroBarCode(barcodeDTO);
	}
	
	@WebMethod
	public boolean getTr_ValidaLoginSenha(String login, String senha, int avaliar ){
		return IdwFacade.getInstancia().getTr_ValidaLoginSenha(login, senha, avaliar);
	}

	@WebMethod
	public Integer getIdEmpresaInjet(){
		return IdwFacade.getInstancia().getIdEmpresaInjet();
	}

	@WebMethod
    public void salvarConfigConcentrador(ConfiguracaoConcentrador configuracao) {
    	// Para o IDW nao temos um salvar configuracao concentrador ainda
    }

}

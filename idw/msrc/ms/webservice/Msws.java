package ms.webservice;

import java.math.BigDecimal;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import idw.model.IdwFacade;
import idw.model.pojos.MsMs;
import idw.webservices.dto.ConfiguracaoConcentrador;
import idw.webservices.dto.ListaIwsAgendaDeParadaDTO;
import injetws.model.IwsFacade;
import injetws.model.IwsFacadeColetaDiscreta;
import injetws.model.excessoes.FalhaSnapshot;
import injetws.model.excessoes.FalhaSnapshotException;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaLoginsDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaOPsDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaParadaEmAbertoDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaUPsDTO;
import injetws.webservices.dto.IwsColetaDiscretaLoginDTO;
import injetws.webservices.dto.IwsColetaDiscretaOperacaoDTO;
import injetws.webservices.dto.IwsColetaDiscretaParadaEmAbertoDTO;
import injetws.webservices.dto.IwsComplementaOP;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsDadosCCKDTO;
import injetws.webservices.dto.IwsDadosColetadosDTO;
import injetws.webservices.dto.IwsDadosIHMBalancaDTO;
import injetws.webservices.dto.IwsDadosInspDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsFitesaDTO;
import injetws.webservices.dto.IwsHorarioDTO;
import injetws.webservices.dto.IwsInspecaoManualDTO;
import injetws.webservices.dto.IwsListModDTO;
import injetws.webservices.dto.IwsListaAlertaDTO;
import injetws.webservices.dto.IwsListaDadosColetadosDTO;
import injetws.webservices.dto.IwsListaInspecoesAutoDTO;
import injetws.webservices.dto.IwsListaMatPrimaDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsPesoProdutoDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import injetws.webservices.dto.IwsRefugoComDefeitosDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsRegistroBarCodeDTO;
import injetws.webservices.dto.IwsReleDTO;
import injetws.webservices.dto.IwsUpAndonPrcsftDTO;
import injetws.webservices.dto.IwsUpDncDTO;
import injetws.webservices.dto.IwsVariacaoRitmoDTO;
import injetws.webservices.dto.IwsVariacaoRitmoValidaDTO;
import ms.coleta.dto.IndicadoresColetaGraficoInjetDTO;
import ms.coleta.dto.ParadaColetaComAndonDTO;
import ms.coleta.dto.ParadasColetaComAndonDTO;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.IhmDTO;
import ms.model.dto.MsDTO;
import ms.model.dto.MsicupsDTO;


/**
 * @author desen
 *
 */
@WebService(name = "msws", targetNamespace = "http://ms/msws", serviceName = "msws")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Msws {
	@WebMethod
	public MsDTO registraIhmNoMs(IhmDTO ihmdto, MsDTO msdto)  {
		return MsFacade.getInstancia().registraIhmNoMs(ihmdto, msdto);
	}
	@WebMethod
	public MsDTO removeRegistraIhmNoMs(IhmDTO ihmdto, MsDTO msdto)  {
		return MsFacade.getInstancia().removeRegistraIhmNoMs(ihmdto, msdto);
	}
	@WebMethod
	public MsDTO heartbeat(MsDTO msdto) {
		return MsFacade.getInstancia().heartbeat(msdto);
	}
	
	/* Alessandre em 17-01-17
	 *  Acredito q o ws abaixo nao seja usado por ninguem por isso desabilitei
	@WebMethod
	public void inicializaMs(MsDTO msdto) {
		
	}	 */

	@WebMethod
	public void finalParada(EventoColetado evento) {
		MsFacade.getInstancia().finalParada(evento);
	}
	
	/*
	 * Zona de declara��o de Webservices do Antigo InjetWS
	 */
	@WebMethod
	public IwsListaAlertaDTO getTr_alertasAbertos(String cdMaquina){
		return IwsFacade.getInstancia().GetTr_pesquisaAlertasEmAberto(cdMaquina);
	}
	
	@WebMethod
	public boolean setTr_alertaInicio(String idUp, String CdAlerta,	Date dthrInicio) {
		return IwsFacade.getInstancia().setTr_AlertaInicio(idUp, CdAlerta, dthrInicio);
	}
	
	@WebMethod
	public boolean setTr_alertaFim(String idUp,String cdAlerta,Date dthrFim){
		return IwsFacade.getInstancia().setTr_AlertaFim(idUp, cdAlerta, dthrFim);
	}
	
	@WebMethod
	public IwsAlertaDTO getTr_TabAlertaSetaCod(String cdAlerta) {
		return IwsFacade.getInstancia().getTr_TabAlertaSetaCod(cdAlerta);
	}

	@WebMethod
	public IwsUpDncDTO getTr_DncTransferencia(String cdMaquina){
		return IwsFacade.getInstancia().getTr_DncTransferencia(cdMaquina);
	}
	
	@WebMethod
	public IwsHorarioDTO getTr_sincronizaHorario(){
		return IwsFacade.getInstancia().getTr_sincronizaHorario();
	}
	
	@WebMethod
	public IwsListaUpDTO getTr_inicializacao(String mac,boolean comParadaSemConexao,boolean comParadaDefault,Date dtHr) {
		return IwsFacade.getInstancia().inicializacao(mac,comParadaSemConexao,comParadaDefault,dtHr);
	}
	
	@WebMethod
	public IwsListaUpDTO getTr_IdupMACColetaDiscreta(String mac) {
		return IwsFacade.getInstancia().inicializacaoColetaDiscreta(mac);	
	}
	
	@WebMethod
	public IwsListaUpDTO inicializacaoSemEvento(String mac) {
		return IwsFacade.getInstancia().inicializacaoSemEvento(mac);
	}
	
	@WebMethod
	public IwsConsultaDTO setTr_Consula(String CdConsulta,String IdUp,Date DataHrAtual) {	
		return IwsFacade.getInstancia().setTr_Consulta( CdConsulta, IdUp, DataHrAtual);
	}
	
	@WebMethod
	public IwsHorarioDTO setUPBeatMac(String mac,Date dthrBeat){
		return IwsFacade.getInstancia().setUPBeatMac(mac,dthrBeat,false,false);
	}		
	
	@WebMethod
	public IwsHorarioDTO setUPBeat(String mac,Date dthrBeat,boolean isLogoutNaViradaTurno,boolean isFechaParadaNaViradaTurno){
		return IwsFacade.getInstancia().setUPBeatMac(mac,dthrBeat,isLogoutNaViradaTurno,isFechaParadaNaViradaTurno);
	}
	
	@WebMethod
	public boolean getTr_ValidaLoginSenha(String login, String senha, int avaliar ){
		return IwsFacade.getInstancia().getTr_ValidaLoginSenha(login, senha, avaliar);
	}
	
	@WebMethod
	public IwsAutenticacaoDTO getTr_Autorizacao(String idUp,String login,String password,Integer avaliar,Date DataHrAtual,Boolean validaPorDsUsuario){
		return IwsFacade.getInstancia().getTr_Autorizacao(idUp, login, password, avaliar,DataHrAtual,validaPorDsUsuario);
	}

	@WebMethod
	public IwsAutenticacaoDTO getTr_AutorizacaoLogout(String idUp,String login,String password,Date DataHrAtual,Boolean validaPorDsUsuario){
		return IwsFacade.getInstancia().getTr_AutorizacaoLogout(idUp, login, password, DataHrAtual,validaPorDsUsuario);
	}
	
	@WebMethod
	public IwsCpDTO getTr_planejamento(String idUp,IwsCpDTO cpEntrada,Date dthr){
		return IwsFacade.getInstancia().planejamento(idUp, cpEntrada, dthr);
	}
	
	@WebMethod
	public Boolean setTr_fimplanejamento(String idUp,Date dthrfplanejamento,int batidas){
		return IwsFacade.getInstancia().fimPlanejamento(idUp, dthrfplanejamento,batidas, false);
	}

	//Marcos Sardinha: 2018-05-28 - nova assinatura para fechamento de op: necessario por causa de solicitacao da MAPA (fim de op parcial ou total)
	//Rebeca: 2018-06-04 - assinatura para op parcial deve ser diferente da assinatura para op total
	@WebMethod
	public boolean setTr_fimplanejamentoParcial(String idUp,Date dthrfplanejamento,int batidas, boolean isParcial){
		return IwsFacade.getInstancia().fimPlanejamento(idUp, dthrfplanejamento,batidas, isParcial);
	}

	@WebMethod
	public Boolean setTr_trataInicioDeCIP(String idup, Date DataReferencia,String Tecnico){
		return IwsFacade.getInstancia().setTr_trataInicioDeCIP(idup, DataReferencia, Tecnico);
	}	
		
	@WebMethod
	public Boolean setTr_trataFimCIP(String idUp,Date dthrfim,String Tecnico){
		return IwsFacade.getInstancia().setTr_trataFimCIP(idUp, dthrfim, Tecnico);
	}
	
	@WebMethod
	public Boolean setTr_MCSemConexao(String macaddress,Date dthr){ 
		return IwsFacade.getInstancia().setTr_MCSemConexao(macaddress, dthr);		
	}
	
	@WebMethod
	public IwsReleDTO setTr_getRele8(String idup) {
		return IwsFacade.getInstancia().setTr_getRele8(idup);
	}
	
	@WebMethod
	public IwsUpAndonPrcsftDTO setTr_getPrUpAndonPrcsft(String idup) {
		return IwsFacade.getInstancia().setTr_getPrUpAndonPrcsft(idup);
	}
	
	@WebMethod
	public boolean getTr_statusPrUpAndon(String idup,boolean tipo) {
		return IwsFacade.getInstancia().getStatusPrUpAndon(idup,tipo);
	}	
	
	@WebMethod
	public IwsInspecaoManualDTO getTr_VerificaExecInspecao(String idup) {
		return IwsFacade.getInstancia().getTr_VerificaExecInspecao(idup);
	}
	
	@WebMethod
	public IwsInspecaoManualDTO setTr_LancaEventoInspecao( String idUp,Date dtHr) {
		return IwsFacade.getInstancia().setTr_LancaEventoInspecao(idUp, dtHr);
	}
	
	@WebMethod
	public IwsInspecaoManualDTO getTr_ParametrosInspecao(String idUp) { 
		return IwsFacade.getInstancia().getTr_ParametrosInspecao(idUp);
	}
	
	@WebMethod
	public IwsErroDTO setTr_fimInspecao(String idUp,Date dtHr,IwsDadosInspDTO resultadoInspecao) {
		return  IwsFacade.getInstancia().setTr_LancaEventoFimInspecao(idUp, dtHr, resultadoInspecao);
	}	
		
	@WebMethod
	public IwsErroDTO setTr_LancaAberturaInspecao( String idUp,Date dtHr) {
		return IwsFacade.getInstancia().setTr_LancaAberturaInspecao(idUp, dtHr);
	}
	
	@WebMethod 
	public IwsErroDTO setTr_buscaAlertaProbQuali (String cdMaquina){ 
		return IwsFacade.getInstancia().setTr_buscaAleraProbQuali(cdMaquina);
	}
	
	@WebMethod
	public IwsErroDTO setTr_encerraAlertaProbQuali(String idUp,Date dtHr,String cdUsuario) {
		return IwsFacade.getInstancia().encerraAlertaProbQuali(idUp,dtHr,cdUsuario);
	}
	
	@WebMethod
	public void setTr_removeInspecoesInvalidas (String idUp) {
			IwsFacade.getInstancia().setTr_removeInspecoesInvalidas(idUp);			
	}
	
	@WebMethod
	public IwsCpDTO setTr_confirmacaoOp (String idUp,Date dtHr,String stApntSap,IwsCpDTO cpdto) {		
		return IwsFacade.getInstancia().setTr_confirmacaoOp(idUp, dtHr, stApntSap, cpdto);
	}
	
	@WebMethod
	public void setTr_alteraStatusApntSap (String idUp,Date dtHr,String stApntSap) {
		IwsFacade.getInstancia().setTr_alteraStatusApntSap(idUp, dtHr, stApntSap);
	}	
	
	@WebMethod
	public String setTr_alteraCartoesKanban (String idUp,Date dtHr,String quantidade,boolean tipoAlter) {
		return IwsFacade.getInstancia().setTr_alteraCartoesKanban(idUp, dtHr, quantidade, tipoAlter);
	}
	
	@WebMethod
	public void setTr_registroIntegracaoDoal(String idUp,Date dtHr,String txtMsg,boolean alimentacao) {
		IwsFacade.getInstancia().setTr_registroIntegracaoDoal(idUp, dtHr, txtMsg, alimentacao);		
	}
	
	@WebMethod
	public IwsListaMatPrimaDTO getTr_dadosIntegracaoDoal(String idUp) {
		return IwsFacade.getInstancia().getTr_dadosIntegracaoDoal(idUp);
	}
	
	@WebMethod
	public IwsProdMateriaPrimaDTO setTr_lancaApntMateriaPrima(String idUp,Date dtHr,String cdproduto,String cdmateriaprima,
			String estoque,String lote,Double quantidade,int registro,IwsCpDTO cpdto) {
		return IwsFacade.getInstancia().setTr_lancaApntMateriaPrima(idUp, dtHr, cdproduto, cdmateriaprima,
				estoque, lote, quantidade, registro, cpdto);
	}
	
	@WebMethod
	public Boolean setTr_lancaEvento46(IwsVariacaoRitmoDTO oVar,String idUp,Date dthrEvento){
		return IwsFacade.getInstancia().setTr_lancaEvento46( oVar, idUp , dthrEvento);			
	}
	
	@WebMethod
	public IwsVariacaoRitmoValidaDTO validaMotivoVariacaoRitmo(String idup,String cdMotivo){
		 return IwsFacade.getInstancia().validaMotivoVariacaoRitmo(idup, cdMotivo);			
	}	
	
	@WebMethod
	public IwsHorarioDTO getUpsIHM(String mac,Date dthrBeat){			 
		return IwsFacade.getInstancia().getUpsIHMhorario(mac,dthrBeat);
	}
	
	@WebMethod
	public boolean  getTr_stProdutoUsuario(String idUp){
		return IwsFacade.getInstancia().getStProdutoUsuario(idUp);	
	}
	
	@WebMethod
	public IwsListModDTO getTr_operadoresLogados(String idUp){	
		return IwsFacade.getInstancia().getTr_operadoresLogados(idUp);
	}
	
	@WebMethod
	public IwsErroDTO setTr_operadorInicio(String idUp,String idOperador,Date dthrInicio){
		return IwsFacade.getInstancia().efetuaLogin(idUp, idOperador, dthrInicio);
	}
	
	@WebMethod
	public IwsErroDTO setTr_operadorFim(String idUp,String idOperador,Date dthrFim,Date dthrInicio){	
		return IwsFacade.getInstancia().efetuaLogout(idUp, idOperador, dthrFim, dthrInicio);
	}
	
	@WebMethod
	public IwsCicloDTO setTr_paradaInicio(String idUp,Date dthrInicio, Boolean isParadaAutomatica,Boolean isParadaPersistente,Boolean isParPeriodSemConex) {
		return IwsFacade.getInstancia().setTr_paradaInicio(idUp,dthrInicio,isParadaAutomatica,isParadaPersistente,isParPeriodSemConex);
	}
	
	@WebMethod
	public boolean setTr_paradaFim(String idUp, Date dthrFim) {
		return IwsFacade.getInstancia().setTr_paradaFim(idUp, dthrFim);
	}
		
	@WebMethod
	public boolean setTr_paradaMotivo(String idUp,Date dthr,String idParada,String idAcao,String idCausa,String idJustificativa,
	String idTecnicoResponsavel,String idTecnicoUm,String idTecnicoDois,String idLocal,boolean isParadaRegulagem,String tipoParPreConfig,int batidas){
		return IwsFacade.getInstancia().setTr_paradaMotivo(idUp, dthr, idParada, idAcao, idCausa, idJustificativa,
				idTecnicoResponsavel, idTecnicoUm, idTecnicoDois,idLocal,isParadaRegulagem,tipoParPreConfig,batidas);
	}	
	
	@WebMethod
	public IwsParadaDTO getTr_TabParadaSetaCod(String idUp,String cdParada){
		return IwsFacade.getInstancia().getTr_TabParadaSetaCod(idUp, cdParada);
	}
	
	@WebMethod 
	public boolean getTr_validaCausa(String cdCausa){
		return IwsFacade.getInstancia().validaCausa(cdCausa);
	}
	
	@WebMethod 
	public boolean getTr_validaAcao(String cdAcao){		
		return IwsFacade.getInstancia().validaAcao(cdAcao);
	}
	
	@WebMethod 
	public boolean getTr_validaJustificativa(	String cdJustificativa){
		return IwsFacade.getInstancia().validaJustificativa(cdJustificativa);
	}
	
	@WebMethod 
	public boolean getTr_validaLocalParada(String cdLocal){
		return IwsFacade.getInstancia().validaLocalParada(cdLocal);
	}
	
	@WebMethod 
	public boolean setTr_InsereAnotacaoParada(String idUP,String anotacao,Date dtHrEvento){			
		return IwsFacade.getInstancia().setTr_InsereAnotacaoParada(idUP, anotacao,dtHrEvento);
	}
	
	@WebMethod
	public IwsCicloDTO setTr_CicloInicio(String idUp,Date dthr,IwsDadosApontamentoDTO dados){ 
		return IwsFacade.getInstancia().setTr_CicloInicio(idUp, dthr,dados);
	}
	
	@WebMethod
	public IwsReleDTO setTr_CicloFim(String idUp,Date dthr,IwsDadosApontamentoDTO dados) throws FalhaSnapshot{
		IwsReleDTO retorno = null;
		try {
			retorno = IwsFacade.getInstancia().setTr_CicloFim(idUp, dthr,dados);
		} catch (SemSGBDException e) {
			throw new FalhaSnapshot("snapshot", new FalhaSnapshotException());
		}
		return retorno;
	}
	
	@WebMethod
	public IwsInspecaoManualDTO getTr_InspecaoManual(String cdMaquina,Date dthrEvento) {
		return IwsFacade.getInstancia().getTr_InspecaoManual(cdMaquina, dthrEvento);
	}
	
	@WebMethod
	public boolean setTr_InspecaoManual(String idUp,Date dthrEvento,String cdProd,String dthralerta,String result) {	
		return IwsFacade.getInstancia().setTr_InspecaoManual(idUp, dthrEvento, cdProd, dthralerta, result);		
	}	
	
	@WebMethod
	public boolean setTr_ApontamentoAramado(String idUp,Date dthrEvento,String cdProd,String quantidade){
		return IwsFacade.getInstancia().setTr_ApontamentoAramado(idUp, dthrEvento,cdProd,quantidade);			
	}
	
	@WebMethod
	public boolean setTr_ApagaUltimoRefugo(String cdRefugo,	String idRdzProduto,Date DthrUltRefugo,String milisec,String IdUp,Date DataHrAtual){
		return IwsFacade.getInstancia().setTr_ApagaUltimoRefugo(cdRefugo, idRdzProduto, DthrUltRefugo, milisec, IdUp,DataHrAtual);
	}
	
	@WebMethod
	public IwsRefugoDTO getInfoUltimoRefugo(String IdUp){
		return IwsFacade.getInstancia().getInfoUltimoRefugo(IdUp);
	}
	
	@WebMethod
	public IwsRefugoDTO setTr_LancaEventoRefugo(String cdRefugo,String cdCausa,String cdAcao,String Quantidade, String IdUp,String idRdzProduto,Date DataHrAtual){
		return IwsFacade.getInstancia().setTr_LancaEventoRefugo(cdRefugo,  cdCausa,  cdAcao, Quantidade, IdUp,idRdzProduto, DataHrAtual);
	}
	
	@WebMethod
	public IwsRefugoDTO setTr_LancaEventoRefugoDefeito(IwsRefugoComDefeitosDTO refugoComDefeitosDTO,Date dthrRefugo){
		return IwsFacade.getInstancia().setTr_LancaEventoRefugoComDefeitos(refugoComDefeitosDTO, dthrRefugo);
	}
	
	@WebMethod
	public IwsRefugoDTO getTr_ValidaCodRefugo(String cdMaquina, String cdRefugo){
		return IwsFacade.getInstancia().getTr_TabValidaCodRefugo(cdMaquina, cdRefugo);
	}	
	
	@WebMethod
	public boolean setRegistroBarCode(IwsRegistroBarCodeDTO barcodeDTO){
		return IwsFacade.getInstancia().setRegistroBarCode(barcodeDTO);
	}	
	
	@WebMethod
	public boolean setDadosColetados(IwsDadosColetadosDTO dadosDTO){
		return IwsFacade.getInstancia().setDadosColetados( dadosDTO);	
	}
	
	@WebMethod
	public boolean setListaDadosColetados(IwsListaDadosColetadosDTO listadadosDTO){
		return IwsFacade.getInstancia().setListaDadosColetados( listadadosDTO);	
	}	
	
	@WebMethod
	public  MsicupsDTO getListaMsicup(){
		return MsFacade.getInstancia().getListaMsicup();
	}
	
	@WebMethod
	public  MsMs pesquisarMsMsPorURLConexaoComParametro(String UrlConexao){
		return MsFacade.getInstancia().pesquisarMsMsPorURLConexaoComParametro(UrlConexao);
	}
	
	@WebMethod
	public IcDTO pesquisarMsIcPorUrlConexao(String urlconexao){
		return MsFacade.getInstancia().pesquisarMsIcPorUrlConexao(urlconexao);
	}

	@WebMethod
	public injetws.webservices.dto.IwsListaMatPrimaDTO getTr_integracaoMws(String nrOp){
		return  IwsFacade.getInstancia().getTr_integracaoMws(nrOp);
	
	}
	
	@WebMethod
	public  injetws.webservices.dto.IwsErroDTO setTr_integracaoMws(BigDecimal idRegistro, String codBarraLido){
		return IwsFacade.getInstancia().setTr_integracaoMws(idRegistro, codBarraLido);
	}
	
	@WebMethod
	public String isOperador(String cracha){
		return MsFacade.getInstancia().isOperador(cracha);
	}
	
	@WebMethod
	public ParadaColetaComAndonDTO getMaiorParadaColetaComAndon(String idUP, Date dtHr1, Date dtHr2){
		return MsFacade.getInstancia().getMaiorParadaColetaComAndon(idUP, dtHr1, dtHr2);
	}
	
	@WebMethod
	public ParadasColetaComAndonDTO getMaioresParadasColetaComAndon(String cdMaquina, Date dtHrAtual){
		return MsFacade.getInstancia().getMaioresParadasColetaComAndon(cdMaquina, dtHrAtual);
	}
	
	@WebMethod
	public IndicadoresColetaGraficoInjetDTO getGraficoOEEHoraHora(String cdMaquina, Date dthrAtual)
	{
		return MsFacade.getInstancia().getGraficoOEEHoraHora(cdMaquina, dthrAtual);
	}
	
	@WebMethod
	public void validaErro(EventoColetado evento){
		MsFacade.getInstancia().validaErro(evento);
	}
	
	
	@WebMethod
	public IwsErroDTO verificaSeJaEfetouPesagem(@WebParam(name = "idUP", partName = "idUP")	String idUP) {		
		return IwsFacade.getInstancia().verificaSeJaEfetouPesagem(idUP);
	}
	
	@WebMethod
	public IwsErroDTO lancaPesagemAmericaTampas(@WebParam(name = "idUP", partName = "idUP")	String idUP,
			@WebParam(name = "valor", partName = "valor")	BigDecimal Valor,
			@WebParam(name = "dthr", partName = "dthr")	Date dthr) {
		
		return IwsFacade.getInstancia().lancaPesagemAmericaTampas(idUP, Valor,dthr);
	}
	
	@WebMethod
	public IwsErroDTO lancaPerdaResinaAmericaTampas(@WebParam(name = "idUP", partName = "idUP")	String idUP,
			@WebParam(name = "valor", partName = "valor")	BigDecimal Valor,
			@WebParam(name = "dthr", partName = "dthr")	Date dthr) {
		
		return IwsFacade.getInstancia().lancaPerdaResinaAmericaTampas(idUP, Valor,dthr);
	}
	
	@WebMethod
	public IwsErroDTO mudancaCavidadesAtivasNomolde(@WebParam(name = "idUP", partName = "idUP")	String idUP,
			@WebParam(name = "valor", partName = "valor")	int Valor,
			@WebParam(name = "dthr", partName = "dthr")	Date dthr) {
		
		return IwsFacade.getInstancia().mudancaCavidadesAtivasNomolde(idUP, Valor,dthr);
	}	
	
	@WebMethod
	public IwsListaInspecoesAutoDTO obtemListaDeVariaveisParaAferir(@WebParam(name = "idUp", partName = "idUp")	String idUP) {
		return IwsFacade.getInstancia().obtemListaDeVariaveisParaAferir(idUP);	
	}
	
	@WebMethod
	public IwsErroDTO setValidaPesagem(@WebParam(name = "idUp", partName = "idUp")	String idUP,
			@WebParam(name = "dadosDTO", partName = "dadosDTO")IwsRegistroBarCodeDTO dadosDTO,
			@WebParam(name = "peso", partName = "peso")	String peso) {
		return IwsFacade.getInstancia().setValidaPesagem(idUP,dadosDTO,peso);	
	}	
	
	@WebMethod
	public IwsErroDTO setTr_ApontaConsumoCCK(@WebParam(name = "idUp", partName = "idUp")	String idUp, 
			@WebParam(name = "dthr", partName = "dthr") Date dthrEvento,
			@WebParam(name = "dadosCCKDTO", partName = "dadosCCKDTO")IwsDadosCCKDTO dadosCCK ) {
		return IwsFacade.getInstancia().setTr_ApontaConsumoCCK(idUp,dthrEvento,dadosCCK);
	}
	
	@WebMethod
	public IwsPesoProdutoDTO getPesoProduto(@WebParam(name = "idUP", partName = "idUP")String idUP,
			@WebParam(name = "Cdprod", partName = "Cdprod")String Cdprod){
		return IwsFacade.getInstancia().getPesoProduto(idUP,Cdprod);
	}
	
	@WebMethod
	public IwsComplementaOP getTr_verificaSePedeComplemento(@WebParam(name = "idUP", partName = "idUP")String idUP,
			@WebParam(name = "nrop", partName = "nrop")String nrop){
		return IwsFacade.getInstancia().getTr_verificaSePedeComplemento(idUP,nrop);
	}	
	
	@WebMethod
	public IwsErroDTO lancaIncProdPlan(@WebParam(name = "idUP", partName = "idUP")String idUP,
			@WebParam(name = "quantidade", partName = "quantidade")int quantidade,
			@WebParam(name = "dthrevt", partName = "dthrevt")Date dthrevt){
		return IwsFacade.getInstancia().lancaIncProdPlan(idUP,quantidade,dthrevt);
	}	
	
	@WebMethod
	public IwsFitesaDTO getDadosFitesa(@WebParam(name = "ip", partName = "ip")String ip){
		return IwsFacade.getInstancia().getDadosFitesa(ip);
	}
	/*
	 * Trecho abaixo destina-se aos WebMethods da Coleta discreta Senoj 20130604 
	 * 
	 */
	

	@WebMethod
	public void setTr_ApontaAbertLoginColetaDiscreta(@WebParam(name = "idUp", partName = "idUp")String idUp, 
			@WebParam(name = "dthrEvento", partName = "dthrEvento")	Date dthrEvento, 
			@WebParam(name = "cdOperacao", partName = "cdOperacao")	String cdOperacao, 
			@WebParam(name = "cdOperador", partName = "cdOperador")	String cdOperador){
		
		IwsFacadeColetaDiscreta.getInstancia().setTr_ApontaAbertLoginColetaDiscreta(idUp, dthrEvento, cdOperacao, cdOperador);
	}

	@WebMethod
	public void setTr_FechaLoginColetaDiscreta(	@WebParam(name = "idUp", partName = "idUp")	String idUp, 
			@WebParam(name = "dthrEvento", partName = "dthrEvento")	Date dthrEvento, 
			@WebParam(name = "dtHrLogin", partName = "dtHrLogin") Date dtHrLogin, 
			@WebParam(name = "cdOperacao", partName = "cdOperacao") String cdOperacao, 
			@WebParam(name = "cdOperador", partName = "cdOperador")	String cdOperador, 
			@WebParam(name = "idLoginEmAberto", partName = "idLoginEmAberto") String idLoginEmAberto) {
		
		IwsFacadeColetaDiscreta.getInstancia().setTr_FechaLoginColetaDiscreta(idUp, dthrEvento, dtHrLogin, cdOperacao, cdOperador, idLoginEmAberto);
	}
	
	@WebMethod
	public void setTr_ApontaAberturaLoginColetaDiscretaTodasUPs(@WebParam(name = "mac", partName = "mac") String mac, 
			@WebParam(name = "dthrEvento", partName = "dthrEvento")	Date dthrEvento, 
			@WebParam(name = "cdOperacao", partName = "cdOperacao")	String cdOperacao, 
			@WebParam(name = "cdOperador", partName = "cdOperador")	String cdOperador){
		
		IwsFacadeColetaDiscreta.getInstancia().setTr_ApontaAberturaLoginColetaDiscretaTodasUPs(mac, dthrEvento, cdOperacao, cdOperador);
	}

	@WebMethod
	public void setTr_ApontaFechamentoLoginColetaDiscretaTodasUPs(@WebParam(name = "mac", partName = "mac")	String mac, 
			@WebParam(name = "dthrEvento", partName = "dthrEvento")	Date dthrEvento, 
			@WebParam(name = "cdOperacao", partName = "cdOperacao")	String cdOperacao, 
			@WebParam(name = "cdOperador", partName = "cdOperador")	String cdOperador) {
		
		IwsFacadeColetaDiscreta.getInstancia().setTr_ApontaFechamentoLoginColetaDiscretaTodasUPs(mac, dthrEvento, cdOperacao, cdOperador);
	}

	@WebMethod
	public boolean setTr_ExisteLoginAbertoMaquina( @WebParam(name = "idUp", partName = "idUp") String idUP, 
			@WebParam(name = "cdOperador", partName = "cdOperador")	String cdOperador) {
		
		return IwsFacadeColetaDiscreta.getInstancia().setTr_ExisteLoginAbertoMaquina(idUP, cdOperador);
	}

	@WebMethod
	public IwsColetaDiscretaListaLoginsDTO getTr_UPsComLoginAbertoOperadorInformado(@WebParam(name = "mac", partName = "mac") String mac, 
			@WebParam(name = "cdOperacao", partName = "cdOperacao")	String cdOperacao, 
			@WebParam(name = "cdOperador", partName = "cdOperador")	String cdOperador) {
		
		return IwsFacadeColetaDiscreta.getInstancia().getTr_UPsComLoginAbertoOperadorInformado(mac, cdOperacao, cdOperador);
	}

	@WebMethod
	public IwsColetaDiscretaListaLoginsDTO getTr_LoginsAbertosUP(@WebParam(name = "idUp", partName = "idUp")	String idUP) {
		
		return IwsFacadeColetaDiscreta.getInstancia().getTr_LoginsAbertosUP(idUP);
	}
	@WebMethod
	public IwsColetaDiscretaListaUPsDTO getTr_UPsSemLoginOperadorInformado(@WebParam(name = "mac", partName = "mac") String mac, 
			@WebParam(name = "cdOperador", partName = "cdOperador")	String cdOperador) {
		
		return IwsFacadeColetaDiscreta.getInstancia().getTr_UPsSemLoginOperadorInformado(mac, cdOperador);
	}

	@WebMethod
	public String GetNomeOperador(@WebParam(name = "cdusuario", partName = "cdusuario")String cdusuario, 
			@WebParam(name = "idUP", partName = "idUP")	String idUP) {
		
		return IwsFacadeColetaDiscreta.getInstancia().GetNomeOperador(cdusuario, idUP);
	}

	@WebMethod
	public IwsColetaDiscretaLoginDTO getTr_LoginAbertoMaquina (@WebParam(name = "idUp", partName = "idUp")	String idUP, 
			@WebParam(name = "cdOperador", partName = "cdOperador")	String cdOperador) {
		
		return IwsFacadeColetaDiscreta.getInstancia().getTr_LoginAbertoMaquina(idUP, cdOperador);
	}	

	@WebMethod
	public boolean getTr_OpCarregadaEmMaquina(String idUP, String nrOPEstendido)  {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_OpCarregadaEmMaquina(idUP, nrOPEstendido);
	}
	
	@WebMethod
	public String getTr_ValidacaoNovaOPColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao) {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_ValidacaoNovaOPColetaDiscreta(idUp, dthrEvento, nrOP, cdOperacao);
	}
	
	@WebMethod
	public IwsColetaDiscretaListaOPsDTO getTr_OPsEmAbertoMaquina(String idUP) {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_OPsEmAbertoMaquina(idUP);
	}
	
	@WebMethod
	public boolean getTr_ExisteOperacao (String idUP, String cdOperacao, String tpFuncOperacao) {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_ExisteOperacao(idUP, cdOperacao, tpFuncOperacao);
	}

	@WebMethod
	public void setTr_FechaOPColetaDiscreta(String idUp, Date dthrEvento, String nrOP, Date dthrIniPlan, String cdOperacao, String  tpFuncOperacao, String qtdApontada, String idOPEmAberto){
		IwsFacadeColetaDiscreta.getInstancia().setTr_FechaOPColetaDiscreta(idUp, dthrEvento, nrOP, dthrIniPlan, cdOperacao, tpFuncOperacao, qtdApontada, idOPEmAberto);
	}
	
	@WebMethod
	public void setTr_ApontaProducaoColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String qtdApontada)  {
		IwsFacadeColetaDiscreta.getInstancia().setTr_ApontaProducaoColetaDiscreta(idUp, dthrEvento, nrOP, cdOperacao, qtdApontada);
	}
	@WebMethod
	public IwsColetaDiscretaParadaEmAbertoDTO getTr_ParadaEmAbertoMaquina(String idUP, String idOPemAberto) {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_ParadaEmAbertoMaquina(idUP, idOPemAberto);
	}
	@WebMethod
	public IwsColetaDiscretaListaParadaEmAbertoDTO getTr_UPsComParadaEmAbertoOperacaoInformada(String mac, String cdOperacao)  {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_UPsComParadaEmAbertoOperacaoInformada(mac, cdOperacao);
	}
	@WebMethod
	public void setTr_ApontaAberturaParadaColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao)  {
		IwsFacadeColetaDiscreta.getInstancia().setTr_ApontaAberturaParadaColetaDiscretaTodasUPs(mac, dthrEvento, cdOperacao);
	}
	@WebMethod
	public void setTr_ApontaFechamentoParadaColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao)  {
		IwsFacadeColetaDiscreta.getInstancia().setTr_ApontaFechamentoParadaColetaDiscretaTodasUPs(mac, dthrEvento, cdOperacao);
	}


	@WebMethod
	public void setTr_ApontaAbertParadaColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String idOPEmAberto) {
		IwsFacadeColetaDiscreta.getInstancia().setTr_ApontaAbertParadaColetaDiscreta(idUp, dthrEvento, nrOP, cdOperacao, idOPEmAberto);
	}
	
	@WebMethod
	public void setTr_ApontaFechamParadaColetaDiscreta(String idUp, Date dthrEvento, Date dtHrIParada, String nrOP, String cdOperacao, String idOPEmAberto) {
		IwsFacadeColetaDiscreta.getInstancia().setTr_ApontaFechamParadaColetaDiscreta(idUp, dthrEvento, dtHrIParada, nrOP, cdOperacao, idOPEmAberto);
	}
	
	@WebMethod
	public boolean getTr_ExisteParadaEmAbertoMaquina(String idUP)  {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_ExisteParadaEmAbertoMaquina(idUP);
	}
	
	@WebMethod
	public double getTr_OPQtdUltApont(String idOPEmAberto)  {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_OPQtdUltApont(idOPEmAberto);
	}
	
	@WebMethod
	public String getTr_ApontaRefugoColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String qtdRefugada){
		return IwsFacadeColetaDiscreta.getInstancia().getTr_ApontaRefugoColetaDiscreta(idUp, dthrEvento, nrOP, cdOperacao, qtdRefugada);
	}
	
	@WebMethod
	public IwsColetaDiscretaOperacaoDTO getTr_RecuperaOperacao(String idUP, String cdOperacao, String tpFuncOperacao) {
		return IwsFacadeColetaDiscreta.getInstancia().getTr_RecuperaOperacao(idUP, cdOperacao, tpFuncOperacao);
	}
	
	@WebMethod
	public IwsDadosIHMBalancaDTO getTr_SincronizaIHMBalanca(String ip){
		return IwsFacade.getInstancia().getTr_SincronizaIHMBalanca(ip);
	}	
	
	
	@WebMethod
	public void setCepOPC(int zona, double valorlido, double idftparam, IcUpDTO dto, IcDTO Ic,String nrop){
		IdwFacade.getInstancia().setCepOPC(zona, valorlido, idftparam, dto,Ic,nrop);
	}

	@WebMethod
	public IwsParadaDTO getTr_TabParadaSetaAnotacao(String idUp, IwsParadaDTO paradaDTO){
		return IwsFacade.getInstancia().getTr_TabParadaSetaAnotacao(idUp, paradaDTO);
	}
	
	@WebMethod
	public Integer getIdEmpresaInjet(){
		return IwsFacade.getInstancia().getIdEmpresaInjet();
	}
	
	@WebMethod
	public ListaIwsAgendaDeParadaDTO getAgendaParada(String cdPt) {
    	return IdwFacade.getInstancia().getAgendaParada(cdPt);
    }  

	//Chamadas da customização do lote produtivo da SR
	
	@WebMethod
	public boolean setTr_InformaLote(String idUp, String lote, Date dataHrAtual){
		return IwsFacade.getInstancia().setTr_InformaLote(idUp, lote, dataHrAtual);
	}
	
	@WebMethod
	public boolean setTr_FinalizaLote(String idUp, String lote, Date dataHrAtual){
		return IwsFacade.getInstancia().setTr_FinalizaLote(idUp, lote, dataHrAtual);
	}
	
	@WebMethod
	public String getLoteProdutivo(String cdPt) {
    	return IdwFacade.getInstancia().getLoteProdutivo(cdPt);
    }

	@WebMethod
	public boolean getTr_validaCodigoParada(String idUp, String idParada) {
    	return IwsFacade.getInstancia().getTr_validaCodigoParada(idUp, idParada);
    }

	@WebMethod
    public String getCdProdSistCorp(String cdProduto) {
    	return IdwFacade.getInstancia().getCdProdSistCorp(cdProduto);
    }

	@WebMethod
    public void salvarConfigConcentrador(ConfiguracaoConcentrador configuracao) {
    	IwsFacade.getInstancia().salvarConfigConcentrador(configuracao);
    }

	// Ricardo: 05/03/2023
	@WebMethod
    public boolean idwAtivo() {
		return IdwFacade.IS_IDW_ATIVO;
    }
	
	@WebMethod
    public boolean getSimuladorLigado() {
		return IdwFacade.getInstancia().getIsSimuladorLigado();
    }
	
    public void setSimuladorLigado(boolean ligado) {
    	IdwFacade.getInstancia().setIsSimuladorLigado(ligado);
    }

}
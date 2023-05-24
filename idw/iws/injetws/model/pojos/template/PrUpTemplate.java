package injetws.model.pojos.template;

import idw.model.rn.DataHoraRN;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsDadosBCDTO;
import injetws.webservices.dto.IwsDadosCIPDTO;
import injetws.webservices.dto.IwsModDTO;
import injetws.webservices.dto.IwsVariacaoRitmoDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class PrUpTemplate {

	public abstract Date getDthrinicic();
	public abstract Double getMsdthrinicic();
	public abstract Date getDthrfimcic();
	public abstract Double getMsdthrfimcic();
	public abstract Double getTmpcicloparcial();
	public abstract Double getTmpcicloparcialaux();	
	
	public Boolean isSemPrograma = true; 
	public Boolean isEmRegulagem = false;
	public Boolean isParadaEmAberto = false;
	public Date dthrUltimoHeartBeat;
	public Double msDthrUltimoHeartBeat;
	public Boolean isReiniciarUp = false;
	public Date dthrReferenciaParaEventos;
	public Boolean deveLiparUsuarios =false;
	public IwsDadosCIPDTO dadosCIP =null;	
	public IwsDadosBCDTO dadosBC =null;
	public IwsDadosApontamentoDTO dadosApontamento=null;
	public Boolean isLogoutNaViradaTurno = false; 
	public Boolean isFechaParadaNaViradaTurno = false;	

	public Boolean isAlertaProbQuali = false;
	
	public Boolean isInspecaoPendente = false;
	
	public IwsVariacaoRitmoDTO variacaoRitmoDTO;
	
	public Integer resultadoUltimaInspecao = 0; 
	//vlauria 20100404
	/*	A vari�vel resultadoUltimaInspecao segue a seguinte l�gica:
	 *		0 - n�o h� resultado 
	 *		1 - aprovado
	 *		2 - reprovado
	 *		3 - aprovado com restri��o
	 *		4 - usado apenas para determinar que esta vari�vel n�o foi modificada  
	 */

	public String isComApntSAP = null;
	public String statusApntSap = null;
	public String txtMessage = null;
	public List<IwsModDTO> listaLoginsEmAberto = null;
	public List<IwsAlertaDTO> listaAlertasEmAberto = null;	
	public List<IwsAlertaDTO> listaAlertasDiarioDeBordo = null;	
	public boolean isInjOuLiner=false;
	
	public boolean isOPConcluida=false;
	
	
	private boolean isInovaMiniRemoto = false;
	
	public boolean obtemIsOPConcluida(){
	   return this.isOPConcluida;
	}
	
	public void mudaIsOPConcluida (boolean val){
		this.isOPConcluida=val;
	}
		
	public boolean obtemIsInjOuLiner(){
	   return this.isInjOuLiner;
	}
	
	public void mudaIsInjOuLiner (boolean val){
		this.isInjOuLiner=val;
	}
	
	/**
	 * @return the dadosApontamento
	 */
	public IwsDadosApontamentoDTO obtemDadosApontamento() {
		return dadosApontamento;
	}
	/**
	 * @param dadosApontamento the dadosApontamento to set
	 */
	public void mudadadosApontamento(IwsDadosApontamentoDTO dadosApontamento) {
		this.dadosApontamento = dadosApontamento;
	}
	
	/**
	 * @return the dadosBC
	 */
	public IwsDadosBCDTO obtemDadosBC() {
		return dadosBC;
	}
	/**
	 * @param dadosBC the dadosBC to set
	 */
	public void mudaDadosBC(IwsDadosBCDTO dadosBC) {
		this.dadosBC = dadosBC;
	}	
	public void mudaDtHrReferenciaParaEventos(Date dthr){
		this.dthrReferenciaParaEventos = dthr;
	}
	public Date obtemDtHrReferenciaEventos(){
		return this.dthrReferenciaParaEventos;
	}
	public void mudaMsDthrUltimoHeartBeat(Double ms){
		this.msDthrUltimoHeartBeat = ms;
	}
	public Double obtemMsDthrUltimoHeartBeat(){
		return this.msDthrUltimoHeartBeat;
	}
	public void mudaDtHrUltimoHeartBeat(Date dthr){
		this.dthrUltimoHeartBeat = dthr;
	}
	public Date obtemDtHrUltimoHeartBeat(){
		return this.dthrUltimoHeartBeat;
	}
	public void mudaParadaEmAberto(Boolean isParadaEmAberto){
		this.isParadaEmAberto = isParadaEmAberto;
	}
	public Boolean obtemParadaEmAberto(){
		return this.isParadaEmAberto;
	}	
	public void mudaSemPrograma(Boolean isSemPrograma){
		this.isSemPrograma = isSemPrograma;
	}
	public Boolean obtemSemPrograma(){
		return this.isSemPrograma;
	}
	public void mudaLogoutNaViradaTurno(Boolean isLogoutNaViradaTurno){
		this.isLogoutNaViradaTurno = isLogoutNaViradaTurno;
	}
	public Boolean obtemLogoutNaViradaTurno(){
		return this.isLogoutNaViradaTurno;
	}
	public void mudaFechaParadaNaViradaTurno(Boolean isFechaParadaNaViradaTurno){
		this.isFechaParadaNaViradaTurno = isFechaParadaNaViradaTurno;
	}
	public Boolean obtemFechaParadaNaViradaTurno(){
		return this.isFechaParadaNaViradaTurno;
	}
	public Date getDthrinicicComMilisegundos(){
		Calendar data = new GregorianCalendar();
		
		if (getDthrinicic() == null)
			return null;
		
		data.setTime(getDthrinicic());
		data.set(Calendar.MILLISECOND, getMsdthrinicic().intValue());

		return data.getTime();
	}
	
	public Date getDthrfimcicComMilisegundos(){
		Calendar data = new GregorianCalendar();
		
		if (getDthrfimcic() == null)
			return null;
		
		data.setTime(getDthrfimcic());
		data.set(Calendar.MILLISECOND, getMsdthrfimcic().intValue());

		return data.getTime();
	}
	
	public long getTempoCiclo(Date dthrfim){
		return DataHoraRN.getQuantidadeMilisegundosNoPeriodo(getDthrinicicComMilisegundos(), dthrfim);
	}
	
	public long getTempoCicloAtivo(){
		return DataHoraRN.getQuantidadeMilisegundosNoPeriodo(getDthrinicicComMilisegundos(), getDthrfimcicComMilisegundos());
	}
	
	public long getTempoCicloEspera(Date dthrfim){
		return DataHoraRN.getQuantidadeMilisegundosNoPeriodo(getDthrfimcicComMilisegundos(), dthrfim);
	}	
	
	public Double getTmpcicloparcialEspera() {
		return (getTmpcicloparcial() - getTmpcicloparcialaux());
	}
	
	/**
	 * @return the isReiniciarUp
	 */
	public Boolean obtemIsReiniciarUp() {
		return isReiniciarUp;
	}
	/**
	 * @param isReiniciarUp the isReiniciarUp to set
	 */
	public void mudaIsReiniciarUp(Boolean isReiniciarUp) {
		this.isReiniciarUp = isReiniciarUp;
	}
	public void mudaDeveLiparUsuarios(Boolean deveLiparUsuarios){
		this.deveLiparUsuarios = deveLiparUsuarios;
	}
	public Boolean obtemDeveLiparUsuarios(){
		return this.deveLiparUsuarios;
	}
	public void mudaIsEmRegulagem(Boolean isEmRegulagem){
		this.isEmRegulagem = isEmRegulagem;
	}
	public Boolean obtemIsEmRegulagem(){
		return this.isEmRegulagem;
	}
	public void mudaIsAlertaProbQuali(Boolean isAlertaProbQuali) {
		this.isAlertaProbQuali = isAlertaProbQuali;
	}
	public Boolean obtemIsAlertaProbQuali() {
		return isAlertaProbQuali;
	}
	public void mudaResultadoUltimaInspecao(Integer resultadoUltimaInspecao) {
		this.resultadoUltimaInspecao = resultadoUltimaInspecao;
	}
	public Integer obtemResultadoUltimaInspecao() {
		return resultadoUltimaInspecao;
	}
	
	public void mudaInspecaoPendente(Boolean isInspecaoPendente) {
		this.isInspecaoPendente = isInspecaoPendente;
	}
	public Boolean obtemIsInspecaoPendente() {
		return isInspecaoPendente;
	}
	
	public void mudaIsComApntSAP(String apntsap) {	//vlauria 20100505
		this.isComApntSAP = apntsap;
	}
	public String obtemIsComApntSAP() {
		return isComApntSAP;
	}
	
	public void mudaStatusApntSAP(String apntsap) {
		this.statusApntSap = apntsap;
	}
	public String obtemStatusApntSAP() {
		return statusApntSap;
	}
	
	public void mudaTxtMessage(String txt) {
		this.txtMessage = txt;
	}
	public String obtemTxtMessage() {
		return this.txtMessage;
	}
	
	public void mudaListaLoginsEmAberto(List<IwsModDTO> logins) {
		this.listaLoginsEmAberto = new ArrayList<IwsModDTO>();
		if(logins != null)
			this.listaLoginsEmAberto.addAll(logins);
		else
			this.listaLoginsEmAberto = null;
	}
	public List<IwsModDTO> obtemListaLoginsEmAberto() {
		return this.listaLoginsEmAberto;
	}
	
	public void mudaListaAlertasEmAberto(List<IwsAlertaDTO> alertas) {
		this.listaAlertasEmAberto = new ArrayList<IwsAlertaDTO>();
		if(alertas != null)
			this.listaAlertasEmAberto.addAll(alertas);
		else
			this.listaAlertasEmAberto = null;
	}
	public void mudaListaAlertasEmAberto(IwsAlertaDTO[] alertas) {
		this.listaAlertasEmAberto = new ArrayList<IwsAlertaDTO>();
		if(alertas != null) {
			for(IwsAlertaDTO alerta : alertas) {			
				this.listaAlertasEmAberto.add(alerta);
			}		
		}
		else
			this.listaAlertasEmAberto = null;
		
	}
	public List<IwsAlertaDTO> obtemListaAlertasEmAberto() {
		return this.listaAlertasEmAberto;
	}
	
	public void mudaListaAlertasDiarioDeBordo(List<IwsAlertaDTO> alertas) {
		this.listaAlertasDiarioDeBordo=alertas;
		
	}	
	
	public List<IwsAlertaDTO> obtemListaAlertasDiarioDeBordo() {
		return this.listaAlertasDiarioDeBordo;
	}
	
	
	public void mudaDadosCIPDTO(IwsDadosCIPDTO odadosCIP) {
		this.dadosCIP = odadosCIP;
	}
	public IwsDadosCIPDTO obtemDadosCIPDTO() {		
		return this.dadosCIP;
	}
	
	public void mudaVariacaoRitmoDTO(IwsVariacaoRitmoDTO oVar) {
		this.variacaoRitmoDTO = oVar;
	}
	public IwsVariacaoRitmoDTO obtemVariacaoRitmoDTO() {		
		return this.variacaoRitmoDTO;
	}
	
	protected boolean isAtivaLog = false;
	
	public void ativarLog() {
		isAtivaLog = true;
	}
	public void desativarLog() {
		this.isAtivaLog = false;
	}
	public boolean obtemIsInovaMiniRemoto() {
		return isInovaMiniRemoto;
	}
	public void mudaInovaMiniRemoto(boolean isInovaMiniRemoto) {
		this.isInovaMiniRemoto = isInovaMiniRemoto;
	}
	
	
}

package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.rn.DataHoraRN;

@SuppressWarnings("serial")
public class FiltroMaquinaInjetDTO implements Serializable{

	private Date data;
	private Date dtFinal;
	private String cdTurno;
	private String cdMaquina;
	private String cdMaquinaGrupo;
	private String cdMolde;
	private String cdMoldeGrupo;
	private String cdProduto;
	private String nrop;
	
	private Boolean isProcessarTempoReal = false;
	private Boolean isProcessarDetalheMaquina = false;
	private Boolean isObterGruposDaMaquina = false;
	private Boolean isObterRelacaoProdutos = true;
	private Boolean isObterTemposDeSetupDasOPs = false;
	private Boolean isProcessarCompleto = true;
	
	public Boolean getIsProcessarCompleto() {
		return isProcessarCompleto;
	}
	public void setIsProcessarCompleto(Boolean isProcessarCompleto) {
		this.isProcessarCompleto = isProcessarCompleto;
	}
	private boolean isObterParadasPorMotivo = false;
	private boolean isObterParadasPorArea = false;
	
	private Ijtbinj ijtbinj;
	private Ijtbpro ijtbpro;
	
	public Boolean isConsiderarProduto(){
		return (cdProduto == null || cdProduto.equals("") ? false : true);
	}
	public Boolean isConsiderarMolde(){
		return (cdMolde == null || cdMolde.equals("") ? false : true);
	}
	public Boolean isConsiderarTurno(){
		return (cdTurno == null || cdTurno.equals("") ? false : true);
	}
	
	public Boolean isConsiderarMoldeGrupo(){
		return (cdMoldeGrupo == null || cdMoldeGrupo.equals("") ? false : true);
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		if (data == null)
			return null;
		
		// Garantir que apenas a data seja retornada sem a hora
		return DataHoraRN.normalize(data, DataHoraRN._DAY);
	}
	
	public Date getDataComHoraMaxima() {
		// Garantir que a data com hora maxima 23:59:59 seja retornada
		Date retorno = DataHoraRN.normalize(data, DataHoraRN._DAY);
		retorno = DataHoraRN.advanceDate(retorno, 1);
		retorno = DataHoraRN.regressOneSecond(retorno);
		return retorno;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the cdTurno
	 */
	public String getCdTurno() {
		return cdTurno;
	}
	/**
	 * @param cdTurno the cdTurno to set
	 */
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	/**
	 * @return the cdMaquina
	 */
	public String getCdMaquina() {
		return cdMaquina;
	}
	/**
	 * @param cdMaquina the cdMaquina to set
	 */
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	/**
	 * @return the cdMolde
	 */
	public String getCdMolde() {
		return cdMolde;
	}
	/**
	 * @param cdMolde the cdMolde to set
	 */
	public void setCdMolde(String cdMolde) {
		this.cdMolde = cdMolde;
	}
	/**
	 * @return the cdProduto
	 */
	public String getCdProduto() {
		return cdProduto;
	}
	/**
	 * @param cdProduto the cdProduto to set
	 */
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	/**
	 * @return the cdMoldeGrupo
	 */
	public String getCdMoldeGrupo() {
		return cdMoldeGrupo;
	}
	/**
	 * @param cdMoldeGrupo the cdMoldeGrupo to set
	 */
	public void setCdMoldeGrupo(String cdMoldeGrupo) {
		this.cdMoldeGrupo = cdMoldeGrupo;
	}
	/**
	 * @return the cdMaquinaGrupo
	 */
	public String getCdMaquinaGrupo() {
		return cdMaquinaGrupo;
	}
	/**
	 * @param cdMaquinaGrupo the cdMaquinaGrupo to set
	 */
	public void setCdMaquinaGrupo(String cdMaquinaGrupo) {
		this.cdMaquinaGrupo = cdMaquinaGrupo;
	}
	/**
	 * @return the isProcessarTempoReal
	 */
	public Boolean getIsProcessarTempoReal() {
		return isProcessarTempoReal;
	}
	/**
	 * @param isProcessarTempoReal the isProcessarTempoReal to set
	 */
	public void setIsProcessarTempoReal(Boolean isProcessarTempoReal) {
		this.isProcessarTempoReal = isProcessarTempoReal;
	}
	/**
	 * @return the isProcessarDetalheMaquina
	 */
	public Boolean getIsProcessarDetalheMaquina() {
		return isProcessarDetalheMaquina;
	}
	/**
	 * @param isProcessarDetalheMaquina the isProcessarDetalheMaquina to set
	 */
	public void setIsProcessarDetalheMaquina(Boolean isProcessarDetalheMaquina) {
		this.isProcessarDetalheMaquina = isProcessarDetalheMaquina;
	}
	/**
	 * @return the nrop
	 */
	public String getNrop() {
		return nrop;
	}
	/**
	 * @param nrop the nrop to set
	 */
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	/**
	 * @return the isObterParadasPorMotivo
	 */
	public boolean isObterParadasPorMotivo() {
		return isObterParadasPorMotivo;
	}
	/**
	 * @param isObterParadasPorMotivo the isObterParadasPorMotivo to set
	 */
	public void setObterParadasPorMotivo(boolean isObterParadasPorMotivo) {
		this.isObterParadasPorMotivo = isObterParadasPorMotivo;
	}
	/**
	 * @return the isObterParadasPorArea
	 */
	public boolean isObterParadasPorArea() {
		return isObterParadasPorArea;
	}
	/**
	 * @param isObterParadasPorArea the isObterParadasPorArea to set
	 */
	public void setObterParadasPorArea(boolean isObterParadasPorArea) {
		this.isObterParadasPorArea = isObterParadasPorArea;
	}
	/**
	 * @return the dtFinal
	 */
	public Date getDtFinal() {
		if (dtFinal == null){
			dtFinal = data;
		}
		return dtFinal;
	}
	/**
	 * @param dtFinal the dtFinal to set
	 */
	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}
	/**
	 * @return the ijtbinj
	 */
	public Ijtbinj getIjtbinj() {
		return ijtbinj;
	}
	/**
	 * @param ijtbinj the ijtbinj to set
	 */
	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}
	public Boolean getIsObterGruposDaMaquina() {
		return isObterGruposDaMaquina;
	}
	public void setIsObterGruposDaMaquina(Boolean isObterGruposDaMaquina) {
		this.isObterGruposDaMaquina = isObterGruposDaMaquina;
	}
	public Boolean getIsObterRelacaoProdutos() {
		return isObterRelacaoProdutos;
	}
	public void setIsObterRelacaoProdutos(Boolean isObterRelacaoProdutos) {
		this.isObterRelacaoProdutos = isObterRelacaoProdutos;
	}
	public Boolean getIsObterTemposDeSetupDasOPs() {
		return isObterTemposDeSetupDasOPs;
	}
	public void setIsObterTemposDeSetupDasOPs(Boolean isObterTemposDeSetupDasOPs) {
		this.isObterTemposDeSetupDasOPs = isObterTemposDeSetupDasOPs;
	}
	public Ijtbpro getIjtbpro() {
		return ijtbpro;
	}
	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}
}

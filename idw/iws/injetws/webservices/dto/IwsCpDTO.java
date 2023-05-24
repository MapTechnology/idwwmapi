package injetws.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class IwsCpDTO implements Serializable{

	private String nrop;
	private String cdmolde;
	private String cdestrutura;
	private String qtcavidades;
	private Float cicloPadrao;
	private String cdProduto;
	private String qtciclos;
	private String qtcartoes;
	private String producaoPlanejada;
	private Boolean isProducaoValida = true;
	private Boolean isSGBDOnline = true;
	private String stCriacaoCP;
	private Float cfgPercToleranciaSinalCiclo = 0f;
	private Float cfgPercTmpCicloParAuto = 0f;
	private Float cfgTamanhoUmPacoteCiclos = 0f;
	private long cfgTolerTmpCicloParAuto = 0;	
	private String isApntSAP = null;
	private String stApntSAP = null;
	private Boolean planClose = false;
	private String txtMensagem = null;
	private String nropestendido;
	private String cdmoldeestendido;
	private Boolean isOpSemColeta=false;
	private Boolean isBloqueioParadaSemConexao=false;
	private String cdParadaSemProd;
	private Boolean isOpcomloteInsumo=false;
	private Date dthrIPlanejamento;
	private List<IwsProdutoDTO> produtos = new ArrayList<IwsProdutoDTO>();
	
	public Boolean getIsOpcomloteInsumo() {
		return isOpcomloteInsumo;
	}

	public void setIsOpcomloteInsumo(Boolean isOpcomloteInsumo) {
		this.isOpcomloteInsumo = isOpcomloteInsumo;
	}
	
	public void addProdutoDTO(IwsProdutoDTO produtodto){
		this.produtos.add(produtodto);
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
	 * @return the cdmolde
	 */
	public String getCdmolde() {
		return cdmolde;
	}
	/**
	 * @param cdmolde the cdmolde to set
	 */
	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}
	
	/**
	 * @return the cdmoldeestendido
	 */
	public String getCdmoldeestendido() {
		return cdmoldeestendido;
	}
	/**
	 * @param cdmoldeestendido the cdmoldeestendido to set
	 */
	public void setCdmoldeestendido(String cdmoldeestendido) {
		this.cdmoldeestendido = cdmoldeestendido;
	}
	/**
	 * @return the cdestrutura
	 */
	public String getCdestrutura() {
		return cdestrutura;
	}
	/**
	 * @param cdestrutura the cdestrutura to set
	 */
	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}
	/**
	 * @return the qtcavidades
	 */
	public String getQtcavidades() {
		return qtcavidades;
	}
	/**
	 * @param qtcavidades the qtcavidades to set
	 */
	public void setQtcavidades(String qtcavidades) {
		this.qtcavidades = qtcavidades;
	}
	/**
	 * @return the cicloPadrao
	 */
	public Float getCicloPadrao() {
		return cicloPadrao;
	}
	/**
	 * @param cicloPadrao the cicloPadrao to set
	 */
	public void setCicloPadrao(Float cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
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
	 * @return the qtciclos
	 */
	public String getQtciclos() {
		return qtciclos;
	}
	/**
	 * @param qtciclos the qtciclos to set
	 */
	public void setQtciclos(String qtciclos) {
		this.qtciclos = qtciclos;
	}
	/**
	 * @return the producaoPlanejada
	 */
	public String getProducaoPlanejada() {
		return producaoPlanejada;
	}
	/**
	 * @param producaoPlanejada the producaoPlanejada to set
	 */
	public void setProducaoPlanejada(String producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	/**
	 * @return the isProducaoValida
	 */
	public Boolean getIsProducaoValida() {
		return isProducaoValida;
	}
	/**
	 * @param isProducaoValida the isProducaoValida to set
	 */
	public void setIsProducaoValida(Boolean isProducaoValida) {
		this.isProducaoValida = isProducaoValida;
	}
	/**
	 * @return the isSGBDOnline
	 */
	public Boolean getIsSGBDOnline() {
		return isSGBDOnline;
	}
	/**
	 * @param isSGBDOnline the isSGBDOnline to set
	 */
	public void setIsSGBDOnline(Boolean isSGBDOnline) {
		this.isSGBDOnline = isSGBDOnline;
	}
	/**
	 * @return the stCriacaoCP
	 */
	public String getStCriacaoCP() {
		return stCriacaoCP;
	}
	/**
	 * @param stCriacaoCP the stCriacaoCP to set
	 */
	public void setStCriacaoCP(String stCriacaoCP) {
		this.stCriacaoCP = stCriacaoCP;
	}
	/**
	 * @return the dthrIPlanejamento
	 */
	public Date getDthrIPlanejamento() {
		return dthrIPlanejamento;
	}
	/**
	 * @param dthrIPlanejamento the dthrIPlanejamento to set
	 */
	public void setDthrIPlanejamento(Date dthrIPlanejamento) {
		this.dthrIPlanejamento = dthrIPlanejamento;
	}
	/**
	 * @return the produtos
	 */
	public List<IwsProdutoDTO> getProdutos() {
		return produtos;
	}
	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<IwsProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	/**
	 * @return the cfgPercToleranciaSinalCiclo
	 */
	public Float getCfgPercToleranciaSinalCiclo() {
		return cfgPercToleranciaSinalCiclo;
	}
	/**
	 * @param cfgPercToleranciaSinalCiclo the cfgPercToleranciaSinalCiclo to set
	 */
	public void setCfgPercToleranciaSinalCiclo(Float cfgPercToleranciaSinalCiclo) {
		this.cfgPercToleranciaSinalCiclo = cfgPercToleranciaSinalCiclo;
	}
	/**
	 * @return the cfgPercTmpCicloParAuto
	 */
	public Float getCfgPercTmpCicloParAuto() {
		return cfgPercTmpCicloParAuto;
	}
	/**
	 * @param cfgPercTmpCicloParAuto the cfgPercTmpCicloParAuto to set
	 */
	public void setCfgPercTmpCicloParAuto(Float cfgPercTmpCicloParAuto) {
		this.cfgPercTmpCicloParAuto = cfgPercTmpCicloParAuto;
	}
	/**
	 * @return the cfgTamanhoUmPacoteCiclos
	 */
	public Float getCfgTamanhoUmPacoteCiclos() {
		return cfgTamanhoUmPacoteCiclos;
	}
	/**
	 * @param cfgTamanhoUmPacoteCiclos the cfgTamanhoUmPacoteCiclos to set
	 */
	public void setCfgTamanhoUmPacoteCiclos(Float cfgTamanhoUmPacoteCiclos) {
		this.cfgTamanhoUmPacoteCiclos = cfgTamanhoUmPacoteCiclos;
	}
	/**
	 * @param cfgTolerTmpCicloParAuto the cfgTolerTmpCicloParAuto to set
	 */	
	public void setCfgTolerTmpCicloParAuto(long cfgTolerTmpCicloParAuto) { //vlauria 20100203
		this.cfgTolerTmpCicloParAuto = cfgTolerTmpCicloParAuto;
		
	}
	/**
	 * @return the cfgTolerTmpCicloParAuto
	 */	
	public long getCfgTolerTmpCicloParAuto() {
		return cfgTolerTmpCicloParAuto;
	}
	public void setIsApntSAPAtivo(String isComApntSAP) {
		this.isApntSAP = isComApntSAP;
	}
	public String getIsApntSAPAtivo() {
		return isApntSAP;
	}
	public void setStApntSAP(String statusApntSAP) {
		this.stApntSAP = statusApntSAP;
	}
	public String getStApntSAP() {
		return stApntSAP;
	}
	public void setPlanClose(Boolean planValid) {
		this.planClose = planValid;
	}
	public Boolean getPlanClose() {
		return planClose;
	}
	public void setTxtMensagem(String txtMensagem) {
		this.txtMensagem = txtMensagem;
	}
	public String getTxtMensagem() {
		return txtMensagem;
	}
	public void setQtcartoes(String qtcartoes) {
		this.qtcartoes = qtcartoes;
	}
	public String getQtcartoes() {
		return qtcartoes;
	}
	public String getNropestendido() {
		return nropestendido;
	}
	public void setNropestendido(String nropestendido) {
		this.nropestendido = nropestendido;
	}
	
	/**
	 * @return the IsBloqueioParadaSemConexao
	 */
	public Boolean getIsBloqueioParadaSemConexao() {
		return isBloqueioParadaSemConexao;
	}
	/**
	 * @param isBloqueioParadaSemConexao the isBloqueioParadaSemConexao to set
	 */
	public void setIsBloqueioParadaSemConexao(Boolean isBloqueioParadaSemConexao) {
		this.isBloqueioParadaSemConexao = isBloqueioParadaSemConexao;
	}
	
	/**
	 * @return the IsOpSemColeta
	 */
	public Boolean getIsOpSemColeta() {
		return isOpSemColeta;
	}
	/**
	 * @param IsOpSemColeta the IsOpSemColeta to set
	 */
	public void setIsOpSemColeta(Boolean isOpSemColeta) {
		this.isOpSemColeta = isOpSemColeta;
	}	
	
	/**
	 * @return the cdParadaSemProd
	 */
	public String getcdParadaSemProd() {
		return cdParadaSemProd;
	}
	/**
	 * @param cdParadaSemProd the cdParadaSemProd to set
	 */
	public void setcdParadaSemProd(String cdParadaSemProd) {
		this.cdParadaSemProd = cdParadaSemProd;
	}	
	
}

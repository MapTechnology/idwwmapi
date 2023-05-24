package ms.coleta.dto;

import idw.model.pojos.DwConsolciplog;
import idw.webservices.dto.DadosProdutoSADTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SessaoOPDTO {
	private long ultimoIdEvtOP;
	private Date dthrIOp;
	private String nrop = ""; //pegar de um ppcpproduto
	private String filial = "";
	private BigDecimal producaoPlanejada = BigDecimal.ZERO; //soma da producao planejada de cada um dos produtos em ppcp.getPpCpprodutos()
	private String cdproduto = ""; //um cdproduto da OP inteira, usado pra NADA
	private String cdFolha = "";
	private long idFolha;
	private double cicloPadrao;
	private double cicloTimeout;
	private double cicloMinimo;
	private double qtdPcsPorCiclo;
	private int qtPacoteCiclo;
	private int qtFatorContagem;
	private Long qtdeRef;
	private Long qtdePro;
	private Integer qtdeCiclos;
	private Integer qtdProdutos;
	private DwConsolciplog dwConsolciplog;
	private Date dthrICip;
	private int tempoSetup;
	private boolean isFinalSerie;
	private boolean isAlertaCipJaAberto;
	private String cipStatus = "0"; //0=NAO_INICIADO, 1=EM_ANDAMENTO, 2=FINALIZADO
	private List<DadosProdutoSADTO> listaProdutos;
	private List<DadosProdutoSADTO> listaProdutosHoraTurno;
	
	public Date getDthrIOp() {
		return dthrIOp;
	}
	public void setDthrIOp(Date dthrIOp) {
		this.dthrIOp = dthrIOp;
	}
	public String getNrop() {
		return nrop;
	}
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	public BigDecimal getProducaoPlanejada() {
		return producaoPlanejada;
	}
	public void setProducaoPlanejada(BigDecimal producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	public String getCdproduto() {
		return cdproduto;
	}
	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(long idFolha) {
		this.idFolha = idFolha;
	}
	public double getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public double getCicloTimeout() {
		return cicloTimeout;
	}
	public void setCicloTimeout(double cicloTimeout) {
		this.cicloTimeout = cicloTimeout;
	}
	public double getCicloMinimo() {
		return cicloMinimo;
	}
	public void setCicloMinimo(double cicloMinimo) {
		this.cicloMinimo = cicloMinimo;
	}
	public double getQtdPcsPorCiclo() {
		return qtdPcsPorCiclo;
	}
	public void setQtdPcsPorCiclo(double qtdPcsPorCiclo) {
		this.qtdPcsPorCiclo = qtdPcsPorCiclo;
	}
	public Long getQtdeRef() {
		return qtdeRef;
	}
	public void setQtdeRef(Long qtdeRef) {
		this.qtdeRef = qtdeRef;
	}
	public Long getQtdePro() {
		return qtdePro;
	}
	public void setQtdePro(Long qtdePro) {
		this.qtdePro = qtdePro;
	}
	public Integer getQtdeCiclos() {
		return qtdeCiclos;
	}
	public void setQtdeCiclos(Integer qtdeCiclos) {
		this.qtdeCiclos = qtdeCiclos;
	}
	public Integer getQtdProdutos() {
		return qtdProdutos;
	}
	public void setQtdProdutos(Integer qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}
	public DwConsolciplog getDwConsolciplog() {
		return dwConsolciplog;
	}
	public void setDwConsolciplog(DwConsolciplog dwConsolciplog) {
		this.dwConsolciplog = dwConsolciplog;
	}
	public Date getDthrICip() {
		return dthrICip;
	}
	public void setDthrICip(Date dthrICip) {
		this.dthrICip = dthrICip;
	}
	public int getTempoSetup() {
		return tempoSetup;
	}
	public void setTempoSetup(int tempoSetup) {
		this.tempoSetup = tempoSetup;
	}
	public String getCipStatus() {
		return cipStatus;
	}
	public void setCipStatus(String cipStatus) {
		this.cipStatus = cipStatus;
	}
	public List<DadosProdutoSADTO> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<DadosProdutoSADTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public List<DadosProdutoSADTO> getListaProdutosHoraTurno() {
		return listaProdutosHoraTurno;
	}
	public void setListaProdutosHoraTurno(
			List<DadosProdutoSADTO> listaProdutosHoraTurno) {
		this.listaProdutosHoraTurno = listaProdutosHoraTurno;
	}
	public long getUltimoIdEvtOP() {
		return ultimoIdEvtOP;
	}
	public void setUltimoIdEvtOP(long ultimoIdEvtOP) {
		this.ultimoIdEvtOP = ultimoIdEvtOP;
	}
	public boolean isFinalSerie() {
		return isFinalSerie;
	}
	public void setFinalSerie(boolean isFinalSerie) {
		this.isFinalSerie = isFinalSerie;
	}
	public int getQtPacoteCiclo() {
		return qtPacoteCiclo;
	}
	public void setQtPacoteCiclo(int qtPacoteCiclo) {
		this.qtPacoteCiclo = qtPacoteCiclo;
	}
	public int getQtFatorContagem() {
		return qtFatorContagem;
	}
	public void setQtFatorContagem(int qtFatorContagem) {
		this.qtFatorContagem = qtFatorContagem;
	}
	public boolean isAlertaCipJaAberto() {
		return isAlertaCipJaAberto;
	}
	public void setAlertaCipJaAberto(boolean isAlertaCipJaAberto) {
		this.isAlertaCipJaAberto = isAlertaCipJaAberto;
	}
	
}

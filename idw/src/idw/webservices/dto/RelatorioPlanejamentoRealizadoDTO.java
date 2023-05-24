package idw.webservices.dto;

import java.util.List;

public class RelatorioPlanejamentoRealizadoDTO{
	
	private String op;
	private String pedido;
	private String cliente;
	private String situacao;
	private String dataPrevFim;
	private String molde;
	private String produto;
	private String plano;
	private Double planoDouble;
	private String producao;
	private Double producaoDouble;
	private String produzir;
	private Double produzirDouble;
	private String maquina;
	private String prodMaq;
	private Double prodMaqDouble;
	private List<RelatorioPlanejamentoRealizadoDTO> itens;
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getDataPrevFim() {
		return dataPrevFim;
	}
	public void setDataPrevFim(String dataPrevFim) {
		this.dataPrevFim = dataPrevFim;
	}
	public String getMolde() {
		return molde;
	}
	public void setMolde(String molde) {
		this.molde = molde;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	
	public List<RelatorioPlanejamentoRealizadoDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioPlanejamentoRealizadoDTO> itens) {
		this.itens = itens;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public String getProducao() {
		return producao;
	}
	public void setProducao(String producao) {
		this.producao = producao;
	}
	public String getProduzir() {
		return produzir;
	}
	public void setProduzir(String produzir) {
		this.produzir = produzir;
	}
	public String getProdMaq() {
		return prodMaq;
	}
	public void setProdMaq(String prodMaq) {
		this.prodMaq = prodMaq;
	}
	public Double getPlanoDouble() {
		return planoDouble;
	}
	public void setPlanoDouble(Double planoDouble) {
		this.planoDouble = planoDouble;
	}
	public Double getProducaoDouble() {
		return producaoDouble;
	}
	public void setProducaoDouble(Double producaoDouble) {
		this.producaoDouble = producaoDouble;
	}
	public Double getProduzirDouble() {
		return produzirDouble;
	}
	public void setProduzirDouble(Double produzirDouble) {
		this.produzirDouble = produzirDouble;
	}
	public Double getProdMaqDouble() {
		return prodMaqDouble;
	}
	public void setProdMaqDouble(Double prodMaqDouble) {
		this.prodMaqDouble = prodMaqDouble;
	}
	
}

package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.List;

public class ItemRelatorioFichaTecnica {

	private String cdProduto;
	private String dsProduto;
	private String molde;
	private String cavAtivas;
	private String maquina;
	private BigDecimal cioPadrao;
	private String cdCliente;
	private String nmCliente;
	private BigDecimal psBruto;
	private BigDecimal psLiquido;
	
	private List<ItemRelatorioFichaTecnica> itens;

	public String getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	public String getMolde() {
		return molde;
	}

	public void setMolde(String molde) {
		this.molde = molde;
	}

	public String getCavAtivas() {
		return cavAtivas;
	}

	public void setCavAtivas(String cavAtivas) {
		this.cavAtivas = cavAtivas;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public BigDecimal getCioPadrao() {
		return cioPadrao;
	}

	public void setCioPadrao(BigDecimal cioPadrao) {
		this.cioPadrao = cioPadrao;
	}

	public String getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(String cdCliente) {
		this.cdCliente = cdCliente;
	}

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public BigDecimal getPsBruto() {
		return psBruto;
	}

	public void setPsBruto(BigDecimal psBruto) {
		this.psBruto = psBruto;
	}

	public BigDecimal getPsLiquido() {
		return psLiquido;
	}

	public void setPsLiquido(BigDecimal psLiquido) {
		this.psLiquido = psLiquido;
	}

	public List<ItemRelatorioFichaTecnica> getItens() {
		return itens;
	}

	public void setItens(List<ItemRelatorioFichaTecnica> itens) {
		this.itens = itens;
	}

}

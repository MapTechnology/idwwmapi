package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RelatorioDuplicacaoDePartesAcoplamentoDTO implements Serializable {
	
	private String data;
	private String posto;

	private String psNumeroSerieProduto;
	private String psDescricaoProduto;

	private String pmNumeroSerieProduto;
	private String pmDescricaoProduto;	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public String getPsNumeroSerieProduto() {
		return psNumeroSerieProduto;
	}

	public void setPsNumeroSerieProduto(String psNumeroSerieProduto) {
		this.psNumeroSerieProduto = psNumeroSerieProduto;
	}

	public String getPsDescricaoProduto() {
		return psDescricaoProduto;
	}

	public void setPsDescricaoProduto(String psDescricaoProduto) {
		this.psDescricaoProduto = psDescricaoProduto;
	}

	public String getPmNumeroSerieProduto() {
		return pmNumeroSerieProduto;
	}

	public void setPmNumeroSerieProduto(String pmNumeroSerieProduto) {
		this.pmNumeroSerieProduto = pmNumeroSerieProduto;
	}

	public String getPmDescricaoProduto() {
		return pmDescricaoProduto;
	}

	public void setPmDescricaoProduto(String pmDescricaoProduto) {
		this.pmDescricaoProduto = pmDescricaoProduto;
	}

}

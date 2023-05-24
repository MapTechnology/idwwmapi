package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FeederInsersoraDTO implements Serializable{

	private Long idPa;
	private String cdPa;
	private Long idProduto;
	private String cdProduto;
	
	// Abaixo atributos obtidos do driver da OAS, não serao usados no momento
	// apenas concatenados para gera a identificação de cdPa
	private String feederTable; // identificacao da mesa da insersora
	private String scanTrack; // numero do feeder e a identificação L ou R
	private String feederTrack; // numero do feeder
	private String pocket; // posição do feeder
	private String name; // nome do feeder
	public Long getIdPa() {
		return idPa;
	}
	public void setIdPa(Long idPa) {
		this.idPa = idPa;
	}
	public String getCdPa() {
		return cdPa;
	}
	public void setCdPa(String cdPa) {
		this.cdPa = cdPa;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getFeederTable() {
		return feederTable;
	}
	public void setFeederTable(String feederTable) {
		this.feederTable = feederTable;
	}
	public String getScanTrack() {
		return scanTrack;
	}
	public void setScanTrack(String scanTrack) {
		this.scanTrack = scanTrack;
	}
	public String getFeederTrack() {
		return feederTrack;
	}
	public void setFeederTrack(String feederTrack) {
		this.feederTrack = feederTrack;
	}
	public String getPocket() {
		return pocket;
	}
	public void setPocket(String pocket) {
		this.pocket = pocket;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

package idw.webservices.rest.cfws.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import idw.webservices.dto.LeituraCODTO;

@XmlRootElement(name="filtroleituracorrente")
public class FiltroLeituraCorrenteDTO implements Serializable {
	
	private boolean isOK;
	private LeituraCODTO leitura;
	private String cdMaquina;
	private String cdMapa;
	private boolean isSimularAlimentacao;
	private long minDtHrLeitura; //datahora no formato Long datetime
	private long idUsuario;
	private byte status; // 1 com sucesso 2 = abortada
	private byte tpLeitura; // 1 conferencia, 2 preconferencia
	
	public FiltroLeituraCorrenteDTO() {
		super();
	}
	
	
	public LeituraCODTO getLeitura() {
		return leitura;
	}

	public void setLeitura(LeituraCODTO leitura) {
		this.leitura = leitura;
	}

	public String getCdMaquina() {
		return cdMaquina;
	}

	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}

	public String getCdMapa() {
		return cdMapa;
	}

	public void setCdMapa(String cdMapa) {
		this.cdMapa = cdMapa;
	}

	public boolean isSimularAlimentacao() {
		return isSimularAlimentacao;
	}

	public void setSimularAlimentacao(boolean isSimularAlimentacao) {
		this.isSimularAlimentacao = isSimularAlimentacao;
	}

	public long getMinDtHrLeitura() {
		return minDtHrLeitura;
	}

	public void setMinDtHrLeitura(long minDtHrLeitura) {
		this.minDtHrLeitura = minDtHrLeitura;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public byte getTpLeitura() {
		return tpLeitura;
	}

	public void setTpLeitura(byte tpLeitura) {
		this.tpLeitura = tpLeitura;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}
	

	
	
}

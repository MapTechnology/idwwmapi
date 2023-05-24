package idw.webservices.rest.cfws.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import idw.webservices.dto.LeituraCODTO;
import idw.webservices.dto.UsuarioCODTO;

@XmlRootElement(name="filtroleituracorrente")
public class FiltroSetConferenciaOuPreDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<LeituraCODTO> leituras;
	private String cdMaquina;
	private String cdMapa;
	private boolean isSimularAlimentacao;
	private long minDtHrLeitura; //datahora no formato Long datetime
	private String isExclusividade;	
	private long idUsuario;
	private long idAlim; // preenchido na realimentacao
	private byte status; // 1 com sucesso 2 = abortada
	private byte tpLeitura; // 1 conferencia, 2 preconferencia
	
	
	
	
	public FiltroSetConferenciaOuPreDTO() {
		super();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<LeituraCODTO> getLeituras() {
		return leituras;
	}

	public void setLeituras(List<LeituraCODTO> leituras) {
		this.leituras = leituras;
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

	public String getIsExclusividade() {
		return isExclusividade;
	}

	public void setIsExclusividade(String isExclusividade) {
		this.isExclusividade = isExclusividade;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdAlim() {
		return idAlim;
	}

	public void setIdAlim(long idAlim) {
		this.idAlim = idAlim;
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
	
}

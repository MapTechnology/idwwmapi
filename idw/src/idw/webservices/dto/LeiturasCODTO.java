package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

public class LeiturasCODTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapaCODTO mapa;
	private UsuarioCODTO usuario;
	private long idAlim; // preenchido na realimentacao
	private byte status; // 1 com sucesso 2 = abortada
	private byte tpLeitura; // 1 conferencia, 2 preconferencia
	private long minDtHrLeitura;
	private List<LeituraCODTO> leituras;
	private String cdMaquina;
	private String isExclusividade;
	
	
	public String getIsExclusividade() {
		return isExclusividade;
	}
	public void setIsExclusividade(String isExclusividade) {
		this.isExclusividade = isExclusividade;
	}
	public String getCdMaquina() {
		return cdMaquina;
	}
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	public MapaCODTO getMapa() {
		return mapa;
	}
	public void setMapa(MapaCODTO mapa) {
		this.mapa = mapa;
	}
	public UsuarioCODTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioCODTO usuario) {
		this.usuario = usuario;
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
	public List<LeituraCODTO> getLeituras() {
		return leituras;
	}
	public void setLeituras(List<LeituraCODTO> leituras) {
		this.leituras = leituras;
	}
	public long getMinDtHrLeitura() {
		return minDtHrLeitura;
	}
	public void setMinDtHrLeitura(long minDtHrLeitura) {
		this.minDtHrLeitura = minDtHrLeitura;
	}

	
}

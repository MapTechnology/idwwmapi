package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="perdasFerramenta")
public class PerdasFerramentaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cdFerramenta;
	private String corOcorrencia;
	private String quantidadePerdida;
	private FiltroMpDTO filtro;
	
	public String getCdFerramenta() {
		return cdFerramenta;
	}
	public void setCdFerramenta(String cdFerramenta) {
		this.cdFerramenta = cdFerramenta;
	}
	public String getQuantidadePerdida() {
		return quantidadePerdida;
	}
	public void setQuantidadePerdida(String quantidadePerdida) {
		this.quantidadePerdida = quantidadePerdida;
	}
	public FiltroMpDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroMpDTO filtro) {
		this.filtro = filtro;
	}
	public String getCorOcorrencia() {
		return corOcorrencia;
	}
	public void setCorOcorrencia(String corOcorrencia) {
		this.corOcorrencia = corOcorrencia;
	}

}

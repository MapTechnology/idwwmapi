package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroGraficoCep")
public class FiltroGraficoCepDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Byte periodo;
	private FiltroDetalhePostoDTO filtroDetalhePosto;
	private long parametro;
	private Byte referencia;
	
	public Byte getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Byte periodo) {
		this.periodo = periodo;
	}
	public FiltroDetalhePostoDTO getFiltroDetalhePosto() {
		return filtroDetalhePosto;
	}
	public void setFiltroDetalhePosto(FiltroDetalhePostoDTO filtroDetalhePosto) {
		this.filtroDetalhePosto = filtroDetalhePosto;
	}
	public long getParametro() {
		return parametro;
	}
	public void setParametro(long parametro) {
		this.parametro = parametro;
	}
	public Byte getReferencia() {
		return referencia;
	}
	public void setReferencia(Byte referencia) {
		this.referencia = referencia;
	}
	
	
}

package idw.webservices.rest.dto.monitorizacao;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroDetalheRitmo")
public class FiltroDetalheRitmoDTO extends FiltroDetalhePostoDTO {

	private static final long serialVersionUID = 1L;
	
	private int tipo;

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}

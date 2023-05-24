package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="itemRecorrenciaPerdaMateriaPrima")
public class ItemRecorrenciaDetalhePerdaMateriaPrimaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String dtHrPerda;
	private String quantidadePerda;
	private String turno;
	private String posto;
	private String ferramenta;
	private String produto;

	public String getDtHrPerda() {
		return dtHrPerda;
	}
	public void setDtHrPerda(String dtHrPerda) {
		this.dtHrPerda = dtHrPerda;
	}
	public String getQuantidadePerda() {
		return quantidadePerda;
	}
	public void setQuantidadePerda(String quantidadePerda) {
		this.quantidadePerda = quantidadePerda;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}

	
}

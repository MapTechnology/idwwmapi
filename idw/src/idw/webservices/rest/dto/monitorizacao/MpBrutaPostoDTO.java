package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mpBrutaPosto")
public class MpBrutaPostoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String posto;
	private String materiaPrimaBruta;
	 
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getMateriaPrimaBruta() {
		return materiaPrimaBruta;
	}
	public void setMateriaPrimaBruta(String materiaPrimaBruta) {
		this.materiaPrimaBruta = materiaPrimaBruta;
	}
	
	
}

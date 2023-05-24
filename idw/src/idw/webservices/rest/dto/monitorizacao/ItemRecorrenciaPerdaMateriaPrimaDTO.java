package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="itemRecorrenciaPerdaMateriaPrima")
public class ItemRecorrenciaPerdaMateriaPrimaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dtHrInicio;
	private String dtHrFim;
	private String produto;
	private String ferramenta;
	private String quantidadePerda;
	private String indice;
	private String indiceCor;
	private List<ItemRecorrenciaDetalhePerdaMateriaPrimaDTO> perdas;

	public String getDtHrInicio() {
		return dtHrInicio;
	}
	public void setDtHrInicio(String dtHrInicio) {
		this.dtHrInicio = dtHrInicio;
	}
	public String getDtHrFim() {
		return dtHrFim;
	}
	public void setDtHrFim(String dtHrFim) {
		this.dtHrFim = dtHrFim;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getQuantidadePerda() {
		return quantidadePerda;
	}
	public void setQuantidadePerda(String quantidadePerda) {
		this.quantidadePerda = quantidadePerda;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getIndiceCor() {
		return indiceCor;
	}
	public void setIndiceCor(String indiceCor) {
		this.indiceCor = indiceCor;
	}
	public List<ItemRecorrenciaDetalhePerdaMateriaPrimaDTO> getPerdas() {
		return perdas;
	}
	public void setPerdas(List<ItemRecorrenciaDetalhePerdaMateriaPrimaDTO> perdas) {
		this.perdas = perdas;
	}

	
}

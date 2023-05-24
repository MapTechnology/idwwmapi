package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoRecorrencia")
public class GraficoRecorrenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String dtHrInicio;
	private String dtHrFim;
	private String posto;
	private String ferramenta;
	private String produto;
	private String total;
	private String indice;
	private String tempoTotal;
	private String perdaTotal;
	private MetaIndicadorDTO indicador;
	private List<ItemRecorrenciaDTO> itens;
	
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(String tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	public String getPerdaTotal() {
		return perdaTotal;
	}
	public void setPerdaTotal(String perdaTotal) {
		this.perdaTotal = perdaTotal;
	}
	public MetaIndicadorDTO getIndicador() {
		return indicador;
	}
	public void setIndicador(MetaIndicadorDTO indicador) {
		this.indicador = indicador;
	}
	public List<ItemRecorrenciaDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItemRecorrenciaDTO> itens) {
		this.itens = itens;
	}
	
	
	
	
}

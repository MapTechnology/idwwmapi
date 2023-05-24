package idw.relatorio.causasrefugo;

import java.io.Serializable;
import java.math.BigDecimal;

public class RelatorioCausasDeRefugoDetalheDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String refugo;
	private String causa;
	private BigDecimal quantidadeRefugada;
	private BigDecimal indiceRefugo;
	
	public String getRefugo() {
		return refugo;
	}
	public void setRefugo(String refugo) {
		this.refugo = refugo;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public BigDecimal getQuantidadeRefugada() {
		return quantidadeRefugada;
	}
	public void setQuantidadeRefugada(BigDecimal quantidadeRefugada) {
		this.quantidadeRefugada = quantidadeRefugada;
	}
	public BigDecimal getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(BigDecimal indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}	
	
}

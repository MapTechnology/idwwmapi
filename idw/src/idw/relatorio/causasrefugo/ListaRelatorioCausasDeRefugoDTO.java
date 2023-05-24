package idw.relatorio.causasrefugo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ListaRelatorioCausasDeRefugoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<RelatorioCausasDeRefugoDTO> listaDeRefugos;
	
	private BigDecimal quantidadeProduzidaTotal;
	private BigDecimal quantidadeRefugadaTotal;
	private BigDecimal quantidadeLiquidaTotal;
	private BigDecimal indiceDeRefugoTotal;
	
	public List<RelatorioCausasDeRefugoDTO> getListaDeRefugos() {
		return listaDeRefugos;
	}
	public void setListaDeRefugos(List<RelatorioCausasDeRefugoDTO> listaDeRefugos) {
		this.listaDeRefugos = listaDeRefugos;
	}
	public BigDecimal getQuantidadeProduzidaTotal() {
		return quantidadeProduzidaTotal;
	}
	public void setQuantidadeProduzidaTotal(BigDecimal quantidadeProduzidaTotal) {
		this.quantidadeProduzidaTotal = quantidadeProduzidaTotal;
	}
	public BigDecimal getQuantidadeRefugadaTotal() {
		return quantidadeRefugadaTotal;
	}
	public void setQuantidadeRefugadaTotal(BigDecimal quantidadeRefugadaTotal) {
		this.quantidadeRefugadaTotal = quantidadeRefugadaTotal;
	}
	public BigDecimal getQuantidadeLiquidaTotal() {
		return quantidadeLiquidaTotal;
	}
	public void setQuantidadeLiquidaTotal(BigDecimal quantidadeLiquidaTotal) {
		this.quantidadeLiquidaTotal = quantidadeLiquidaTotal;
	}
	public BigDecimal getIndiceDeRefugoTotal() {
		return indiceDeRefugoTotal;
	}
	public void setIndiceDeRefugoTotal(BigDecimal indiceDeRefugoTotal) {
		this.indiceDeRefugoTotal = indiceDeRefugoTotal;
	}	

}

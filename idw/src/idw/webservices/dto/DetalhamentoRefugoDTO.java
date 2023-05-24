package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.List;

public class DetalhamentoRefugoDTO {
	
	private String refugo;
	private BigDecimal qtdRefugada;
	private List<DetalheRefugoDTO > listarefugos;
	
	public String getRefugo() {
		return refugo;
	}
	public void setRefugo(String refugo) {
		this.refugo = refugo;
	}
	public BigDecimal getQtdRefuga() {
		return qtdRefugada;
	}
	public void setQtdRefuga(BigDecimal qtdRefugada) {
		this.qtdRefugada = qtdRefugada;
	}
	public List<DetalheRefugoDTO> getListarefugos() {
		return listarefugos;
	}
	public void setListarefugos(List<DetalheRefugoDTO> listarefugos) {
		this.listarefugos = listarefugos;
	}
		
}

package idw.webservices.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DetalheAnaliseGargaloDTO {
	
	private ListaIndicadoresPtDTO listaIndicadoresPt; 
	private ListaIndicadoresPtDTO listaIndicadoresPtSaida;
	private ListaIndicadoresPtDTO listaIndicadoresPtGargaloTeorico;
	private ListaIndicadoresPtDTO listaIndicadoresPtGargaloDinamico;
		
	public DetalheAnaliseGargaloDTO(){
		this.listaIndicadoresPt = new ListaIndicadoresPtDTO();
		this.listaIndicadoresPtSaida = new ListaIndicadoresPtDTO();
		this.listaIndicadoresPtGargaloTeorico = new ListaIndicadoresPtDTO();
		this.listaIndicadoresPtGargaloDinamico = new ListaIndicadoresPtDTO();
	}
	public ListaIndicadoresPtDTO getListaIndicadoresPt() {
		return listaIndicadoresPt;
	}
	public void setListaIndicadoresPt(ListaIndicadoresPtDTO listaIndicadoresPt) {
		this.listaIndicadoresPt = listaIndicadoresPt;
	}
	public ListaIndicadoresPtDTO getListaIndicadoresPtSaida() {
		return listaIndicadoresPtSaida;
	}
	public void setListaIndicadoresPtSaida(
			ListaIndicadoresPtDTO listaIndicadoresPtSaida) {
		this.listaIndicadoresPtSaida = listaIndicadoresPtSaida;
	}
	public ListaIndicadoresPtDTO getListaIndicadoresPtGargaloTeorico() {
		return listaIndicadoresPtGargaloTeorico;
	}
	public void setListaIndicadoresPtGargaloTeorico(
			ListaIndicadoresPtDTO listaIndicadoresPtGargaloTeorico) {
		this.listaIndicadoresPtGargaloTeorico = listaIndicadoresPtGargaloTeorico;
	}
	public ListaIndicadoresPtDTO getListaIndicadoresPtGargaloDinamico() {
		return listaIndicadoresPtGargaloDinamico;
	}
	public void setListaIndicadoresPtGargaloDinamico(
			ListaIndicadoresPtDTO listaIndicadoresPtGargaloDinamico) {
		this.listaIndicadoresPtGargaloDinamico = listaIndicadoresPtGargaloDinamico;
	}
	
	public void prepararSerializacao(){
		this.listaIndicadoresPt.prepararSerializacao();
		this.listaIndicadoresPtSaida.prepararSerializacao();
		this.listaIndicadoresPtGargaloDinamico.prepararSerializacao();
		this.listaIndicadoresPtGargaloTeorico.prepararSerializacao();		
	}
	
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("listaIndicadoresPt", this.listaIndicadoresPt)
			.append("listaIndicadoresPtSaida", this.listaIndicadoresPtSaida)
			.append("listaIndicadoresPtGargaloDinamico", this.listaIndicadoresPtGargaloDinamico)
			.append("listaIndicadoresPtGargaloTeorico", this.listaIndicadoresPtGargaloTeorico)
			.toString();
	}
	
}

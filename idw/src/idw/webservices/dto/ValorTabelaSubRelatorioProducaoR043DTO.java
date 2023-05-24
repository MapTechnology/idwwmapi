package idw.webservices.dto;

import java.math.BigDecimal;

import ms.util.ConversaoTipos;

public class ValorTabelaSubRelatorioProducaoR043DTO {

	private String valorFormatado;
	private String indiceFormatado;
	
	private BigDecimal valor;
	private BigDecimal indice;
	
	public ValorTabelaSubRelatorioProducaoR043DTO(){
		this(2);
	}
	
	public ValorTabelaSubRelatorioProducaoR043DTO(int numeroCasasValor){
		setValorAtualizandoCamposFilho(BigDecimal.ZERO, numeroCasasValor);
		setIndiceAtualizandoCamposFilho(BigDecimal.ZERO);
	}
	
	public String getValorFormatado() {
		return valorFormatado;
	}
	public void setValorFormatado(String valorFormatado) {
		this.valorFormatado = valorFormatado;
	}
	public String getIndiceFormatado() {
		return indiceFormatado;
	}
	public void setIndiceFormatado(String indiceFormatado) {
		this.indiceFormatado = indiceFormatado;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getIndice() {
		return indice;
	}
	public void setIndice(BigDecimal indice) {
		this.indice = indice;
	}
	
	public void setValorAtualizandoCamposFilho(BigDecimal valor, int numeroCasas) {
		this.valor = valor;
		if(this.valor != null){
			this.valorFormatado = ConversaoTipos.converteParaStringUsandoVirgula(this.valor, numeroCasas);
		}
	}
	
	public void setIndiceAtualizandoCamposFilho(BigDecimal indice) {
		this.indice = indice;
		if(this.indice != null){
			this.indiceFormatado = ConversaoTipos.converteParaStringUsandoVirgula(this.indice, 2);
		}
	}

	@Override
	public String toString() {
		return "["+ valorFormatado +"("+ valor.intValue() +") , " + indiceFormatado + "]";
	}
	
	
}

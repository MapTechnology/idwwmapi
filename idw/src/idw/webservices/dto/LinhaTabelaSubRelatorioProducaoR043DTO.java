package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ms.util.ConversaoTipos;

public class LinhaTabelaSubRelatorioProducaoR043DTO {

	private String codigo;
	private String descricao;

	private String valorAcumuladoFormatado;
	private String indiceAcumuladoFormatado;

	private BigDecimal valorAcumulado;
	private BigDecimal indiceAcumulado;

	private List<ValorTabelaSubRelatorioProducaoR043DTO> valores;

	public LinhaTabelaSubRelatorioProducaoR043DTO() {
		valorAcumulado = BigDecimal.ZERO;
		indiceAcumulado = BigDecimal.ZERO;
		valores = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorAcumuladoFormatado() {
		return valorAcumuladoFormatado;
	}

	public void setValorAcumuladoFormatado(String valorAcumuladoFormatado) {
		this.valorAcumuladoFormatado = valorAcumuladoFormatado;
	}

	public String getIndiceAcumuladoFormatado() {
		return indiceAcumuladoFormatado;
	}

	public void setIndiceAcumuladoFormatado(String indiceAcumuladoFormatado) {
		this.indiceAcumuladoFormatado = indiceAcumuladoFormatado;
	}

	public BigDecimal getValorAcumulado() {
		return valorAcumulado;
	}

	public void setValorAcumulado(BigDecimal valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	public BigDecimal getIndiceAcumulado() {
		return indiceAcumulado;
	}

	public void setIndiceAcumulado(BigDecimal indiceAcumulado) {
		this.indiceAcumulado = indiceAcumulado;
	}

	public List<ValorTabelaSubRelatorioProducaoR043DTO> getValores() {
		return valores;
	}

	public void setValores(List<ValorTabelaSubRelatorioProducaoR043DTO> valores) {
		this.valores = valores;
	}

	public void setValorAcumuladoAtualizandoCamposFilho(
			BigDecimal valorAcumulado, int numeroCasas) {
		this.valorAcumulado = valorAcumulado;
		if (this.valorAcumulado != null) {
			this.valorAcumuladoFormatado = ConversaoTipos.converteParaStringUsandoVirgula(
					this.valorAcumulado, numeroCasas);
		}
	}

	public void setIndiceAcumuladoAtualizandoCamposFilho(
			BigDecimal indiceAcumulado) {
		this.indiceAcumulado = indiceAcumulado;
		if (this.indiceAcumulado != null) {
			this.indiceAcumuladoFormatado = ConversaoTipos.converteParaStringUsandoVirgula(
					this.indiceAcumulado, 2);
		}
	}

	@Override
	public String toString() {
		String retorno = "\n";
		retorno += "Parada: " + codigo + " - " + descricao + "\n";
		for (int i = 0; i < valores.size(); i++) {
			retorno += "     " + i + "-" + valores.get(i).toString() + "\n";
		}
		retorno += "Acumulado: [" + valorAcumuladoFormatado + " , "
				+ indiceAcumuladoFormatado + "]\n";
		return retorno;
	}

}

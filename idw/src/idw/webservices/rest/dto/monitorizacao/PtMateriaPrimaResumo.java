package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptIndicador")
public class PtMateriaPrimaResumo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String consumoProducaoBruta;
	private String consumoProducaoLiquida;
	private String consumoProducaoRefugada;
	private String custoTotalInsercao;
	private String custoTotalPerda;
	private String custoTotalInsercaoLiquida;
	private String quantidadeTotalInsercoes;
	
	public String getConsumoProducaoBruta() {
		return consumoProducaoBruta;
	}
	public void setConsumoProducaoBruta(String consumoProducaoBruta) {
		this.consumoProducaoBruta = consumoProducaoBruta;
	}
	public String getConsumoProducaoLiquida() {
		return consumoProducaoLiquida;
	}
	public void setConsumoProducaoLiquida(String consumoProducaoLiquida) {
		this.consumoProducaoLiquida = consumoProducaoLiquida;
	}
	public String getConsumoProducaoRefugada() {
		return consumoProducaoRefugada;
	}
	public void setConsumoProducaoRefugada(String consumoProducaoRefugada) {
		this.consumoProducaoRefugada = consumoProducaoRefugada;
	}
	public String getCustoTotalInsercao() {
		return custoTotalInsercao;
	}
	public void setCustoTotalInsercao(String custoTotalInsercao) {
		this.custoTotalInsercao = custoTotalInsercao;
	}
	public String getCustoTotalPerda() {
		return custoTotalPerda;
	}
	public void setCustoTotalPerda(String custoTotalPerda) {
		this.custoTotalPerda = custoTotalPerda;
	}
	public String getCustoTotalInsercaoLiquida() {
		return custoTotalInsercaoLiquida;
	}
	public void setCustoTotalInsercaoLiquida(String custoTotalInsercaoLiquida) {
		this.custoTotalInsercaoLiquida = custoTotalInsercaoLiquida;
	}
	public String getQuantidadeTotalInsercoes() {
		return quantidadeTotalInsercoes;
	}
	public void setQuantidadeTotalInsercoes(String quantidadeTotalInsercoes) {
		this.quantidadeTotalInsercoes = quantidadeTotalInsercoes;
	}
	
	
}

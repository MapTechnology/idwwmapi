package idw.model.rn.relatorios.opprocessada;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ListaRelatorioOPProcessadaDTO {

	private Map<DeterminaAgrupador, RelatorioOrdemProducaoProcessadaDTO> agrupamento = new HashMap<>();
	
	/* Total geral do relatorio
	 * 
	 */
	private BigDecimal totalGeralProducaoBruta = BigDecimal.ZERO;
	private BigDecimal totalGeralProducaoRefugada = BigDecimal.ZERO;
	private BigDecimal totalGeralProducaoLiquida = BigDecimal.ZERO;
	private Double totalGeralIndiceRefugo = 0d;
	
	private BigDecimal totalGeralProducaoBrutaMaisProducaoEmRegulagem = BigDecimal.ZERO;
	private BigDecimal totalGeralProducaoRefugadaMaisProducaoEmRegulagem = BigDecimal.ZERO;
	private Double totalGeralIndiceRefugoMaisProducaoEmRegulagem = 0d;
	
	private Double totalGeralTempoParadaCP = 0d;
	private Double totalGeralTempoParadaSP = 0d;
	private Double totalGeralTempoTrabalhado = 0d;
	private Double totalGeralTempoAtivo = 0d;
	
	private String totalGeralTempoParadaCPFormatado;
	private String totalGeralTempoParadaSPFormatado;
	private String totalGeralTempoTrabalhadoFormatado;
	private String totalGeralTempoAtivoFormatado;
	
	public ListaRelatorioOPProcessadaDTO() {
		super();
	}

	public Map<DeterminaAgrupador, RelatorioOrdemProducaoProcessadaDTO> getAgrupamento() {
		return agrupamento;
	}

	public void setAgrupamento(Map<DeterminaAgrupador, RelatorioOrdemProducaoProcessadaDTO> agrupamento) {
		this.agrupamento = agrupamento;
	}

	public BigDecimal getTotalGeralProducaoBruta() {
		return totalGeralProducaoBruta;
	}

	public void setTotalGeralProducaoBruta(BigDecimal totalGeralProducaoBruta) {
		this.totalGeralProducaoBruta = totalGeralProducaoBruta;
	}

	public BigDecimal getTotalGeralProducaoRefugada() {
		return totalGeralProducaoRefugada;
	}

	public void setTotalGeralProducaoRefugada(BigDecimal totalGeralProducaoRefugada) {
		this.totalGeralProducaoRefugada = totalGeralProducaoRefugada;
	}

	public BigDecimal getTotalGeralProducaoLiquida() {
		return totalGeralProducaoLiquida;
	}

	public void setTotalGeralProducaoLiquida(BigDecimal totalGeralProducaoLiquida) {
		this.totalGeralProducaoLiquida = totalGeralProducaoLiquida;
	}

	public Double getTotalGeralIndiceRefugo() {
		return totalGeralIndiceRefugo;
	}

	public void setTotalGeralIndiceRefugo(Double totalGeralIndiceRefugo) {
		this.totalGeralIndiceRefugo = totalGeralIndiceRefugo;
	}

	public BigDecimal getTotalGeralProducaoBrutaMaisProducaoEmRegulagem() {
		return totalGeralProducaoBrutaMaisProducaoEmRegulagem;
	}

	public void setTotalGeralProducaoBrutaMaisProducaoEmRegulagem(BigDecimal totalGeralProducaoBrutaMaisProducaoEmRegulagem) {
		this.totalGeralProducaoBrutaMaisProducaoEmRegulagem = totalGeralProducaoBrutaMaisProducaoEmRegulagem;
	}

	public BigDecimal getTotalGeralProducaoRefugadaMaisProducaoEmRegulagem() {
		return totalGeralProducaoRefugadaMaisProducaoEmRegulagem;
	}

	public void setTotalGeralProducaoRefugadaMaisProducaoEmRegulagem(
			BigDecimal totalGeralProducaoRefugadaMaisProducaoEmRegulagemGeral) {
		this.totalGeralProducaoRefugadaMaisProducaoEmRegulagem = totalGeralProducaoRefugadaMaisProducaoEmRegulagemGeral;
	}

	public Double getTotalGeralIndiceRefugoMaisProducaoEmRegulagem() {
		return totalGeralIndiceRefugoMaisProducaoEmRegulagem;
	}

	public void setTotalGeralIndiceRefugoMaisProducaoEmRegulagem(Double totalGeralIndiceRefugoMaisProducaoEmRegulagem) {
		this.totalGeralIndiceRefugoMaisProducaoEmRegulagem = totalGeralIndiceRefugoMaisProducaoEmRegulagem;
	}

	public Double getTotalGeralTempoParadaCP() {
		return totalGeralTempoParadaCP;
	}

	public void setTotalGeralTempoParadaCP(Double totalGeralTempoParadaCP) {
		this.totalGeralTempoParadaCP = totalGeralTempoParadaCP;
	}

	public Double getTotalGeralTempoParadaSP() {
		return totalGeralTempoParadaSP;
	}

	public void setTotalGeralTempoParadaSP(Double totalGeralTempoParadaSP) {
		this.totalGeralTempoParadaSP = totalGeralTempoParadaSP;
	}

	public Double getTotalGeralTempoTrabalhado() {
		return totalGeralTempoTrabalhado;
	}

	public void setTotalGeralTempoTrabalhado(Double totalGeralTempoTrabalhado) {
		this.totalGeralTempoTrabalhado = totalGeralTempoTrabalhado;
	}

	public Double getTotalGeralTempoAtivo() {
		return totalGeralTempoAtivo;
	}

	public void setTotalGeralTempoAtivo(Double totalGeralTempoAtivo) {
		this.totalGeralTempoAtivo = totalGeralTempoAtivo;
	}

	public String getTotalGeralTempoParadaCPFormatado() {
		return totalGeralTempoParadaCPFormatado;
	}

	public void setTotalGeralTempoParadaCPFormatado(String totalGeralTempoParadaCPFormatado) {
		this.totalGeralTempoParadaCPFormatado = totalGeralTempoParadaCPFormatado;
	}

	public String getTotalGeralTempoParadaSPFormatado() {
		return totalGeralTempoParadaSPFormatado;
	}

	public void setTotalGeralTempoParadaSPFormatado(String totalGeralTempoParadaSPFormatado) {
		this.totalGeralTempoParadaSPFormatado = totalGeralTempoParadaSPFormatado;
	}

	public String getTotalGeralTempoTrabalhadoFormatado() {
		return totalGeralTempoTrabalhadoFormatado;
	}

	public void setTotalGeralTempoTrabalhadoFormatado(String totalGeralTempoTrabalhadoFormatado) {
		this.totalGeralTempoTrabalhadoFormatado = totalGeralTempoTrabalhadoFormatado;
	}

	public String getTotalGeralTempoAtivoFormatado() {
		return totalGeralTempoAtivoFormatado;
	}

	public void setTotalGeralTempoAtivoFormatado(String totalGeralTempoAtivoFormatado) {
		this.totalGeralTempoAtivoFormatado = totalGeralTempoAtivoFormatado;
	}
}

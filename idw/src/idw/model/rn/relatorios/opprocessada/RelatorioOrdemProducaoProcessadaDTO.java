package idw.model.rn.relatorios.opprocessada;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class RelatorioOrdemProducaoProcessadaDTO {

	private Map<DeterminaDetalhe, RelatorioOrdemProducaoProcessadaDetalheDTO> detalhes = new HashMap<>();

	/*
	 * Totais do agrupamento
	 * 
	 */
	private BigDecimal totalProducaoBruta;
	private BigDecimal totalProducaoRefugada;
	private BigDecimal totalProducaoLiquida;
	private Double totalIndiceRefugo;

	private BigDecimal totalProducaoBrutaMaisProducaoEmRegulagem;
	private BigDecimal totalProducaoRefugadaMaisProducaoEmRegulagem;
	private Double totalIndiceRefugoMaisProducaoEmRegulagem;

	private Double totalTempoParadaCP;
	private Double totalTempoParadaSP;
	private Double totalTempoTrabalhado;
	private Double totalTempoAtivo;
	private String totalTempoParadaCPFormatado;
	private String totalTempoParadaSPFormatado;
	private String totalTempoTrabalhadoFormatado;
	private String totalTempoAtivoFormatado;
	
	
	public RelatorioOrdemProducaoProcessadaDTO() {
		super();
	}
	
	public Map<DeterminaDetalhe, RelatorioOrdemProducaoProcessadaDetalheDTO> getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(Map<DeterminaDetalhe, RelatorioOrdemProducaoProcessadaDetalheDTO> detalhes) {
		this.detalhes = detalhes;
	}

	public BigDecimal getTotalProducaoBruta() {
		return totalProducaoBruta;
	}

	public void setTotalProducaoBruta(BigDecimal totalProducaoBruta) {
		this.totalProducaoBruta = totalProducaoBruta;
	}

	public BigDecimal getTotalProducaoRefugada() {
		return totalProducaoRefugada;
	}

	public void setTotalProducaoRefugada(BigDecimal totalProducaoRefugada) {
		this.totalProducaoRefugada = totalProducaoRefugada;
	}

	public BigDecimal getTotalProducaoLiquida() {
		return totalProducaoLiquida;
	}

	public void setTotalProducaoLiquida(BigDecimal totalProducaoLiquida) {
		this.totalProducaoLiquida = totalProducaoLiquida;
	}

	public Double getTotalIndiceRefugo() {
		return totalIndiceRefugo;
	}

	public void setTotalIndiceRefugo(Double totalIndiceRefugo) {
		this.totalIndiceRefugo = totalIndiceRefugo;
	}

	public BigDecimal getTotalProducaoBrutaMaisProducaoEmRegulagem() {
		return totalProducaoBrutaMaisProducaoEmRegulagem;
	}

	public void setTotalProducaoBrutaMaisProducaoEmRegulagem(BigDecimal totalProducaoBrutaMaisProducaoEmRegulagem) {
		this.totalProducaoBrutaMaisProducaoEmRegulagem = totalProducaoBrutaMaisProducaoEmRegulagem;
	}

	public BigDecimal getTotalProducaoRefugadaMaisProducaoEmRegulagem() {
		return totalProducaoRefugadaMaisProducaoEmRegulagem;
	}

	public void setTotalProducaoRefugadaMaisProducaoEmRegulagem(BigDecimal totalProducaoRefugadaMaisProducaoEmRegulagemGeral) {
		this.totalProducaoRefugadaMaisProducaoEmRegulagem = totalProducaoRefugadaMaisProducaoEmRegulagemGeral;
	}

	public Double getTotalIndiceRefugoMaisProducaoEmRegulagem() {
		return totalIndiceRefugoMaisProducaoEmRegulagem;
	}

	public void setTotalIndiceRefugoMaisProducaoEmRegulagem(Double totalIndiceRefugoMaisProducaoEmRegulagem) {
		this.totalIndiceRefugoMaisProducaoEmRegulagem = totalIndiceRefugoMaisProducaoEmRegulagem;
	}

	public Double getTotalTempoParadaCP() {
		return totalTempoParadaCP;
	}

	public void setTotalTempoParadaCP(Double totalTempoParadaCP) {
		this.totalTempoParadaCP = totalTempoParadaCP;
	}

	public Double getTotalTempoParadaSP() {
		return totalTempoParadaSP;
	}

	public void setTotalTempoParadaSP(Double totalTempoParadaSP) {
		this.totalTempoParadaSP = totalTempoParadaSP;
	}

	public Double getTotalTempoTrabalhado() {
		return totalTempoTrabalhado;
	}

	public void setTotalTempoTrabalhado(Double totalTempoTrabalhado) {
		this.totalTempoTrabalhado = totalTempoTrabalhado;
	}

	public Double getTotalTempoAtivo() {
		return totalTempoAtivo;
	}

	public void setTotalTempoAtivo(Double totalTempoAtivo) {
		this.totalTempoAtivo = totalTempoAtivo;
	}

	public String getTotalTempoParadaCPFormatado() {
		return totalTempoParadaCPFormatado;
	}

	public void setTotalTempoParadaCPFormatado(String totalTempoParadaCPFormatado) {
		this.totalTempoParadaCPFormatado = totalTempoParadaCPFormatado;
	}

	public String getTotalTempoParadaSPFormatado() {
		return totalTempoParadaSPFormatado;
	}

	public void setTotalTempoParadaSPFormatado(String totalTempoParadaSPFormatado) {
		this.totalTempoParadaSPFormatado = totalTempoParadaSPFormatado;
	}

	public String getTotalTempoTrabalhadoFormatado() {
		return totalTempoTrabalhadoFormatado;
	}

	public void setTotalTempoTrabalhadoFormatado(String totalTempoTrabalhadoFormatado) {
		this.totalTempoTrabalhadoFormatado = totalTempoTrabalhadoFormatado;
	}

	public String getTotalTempoAtivoFormatado() {
		return totalTempoAtivoFormatado;
	}

	public void setTotalTempoAtivoFormatado(String totalTempoAtivoFormatado) {
		this.totalTempoAtivoFormatado = totalTempoAtivoFormatado;
	}

}
